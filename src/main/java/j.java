import javax.microedition.media.Controllable;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.media.Manager;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

// 
// Decompiled by Procyon v0.5.36
// 

public final class j implements Runnable, PlayerListener
{
    private static int aInt;
    private static int bInt;
    private static int cInt;
    private static int dInt;
    private static int eInt;
    private long aLong;
    private static Player[] aClassPlayerArr;
    public static boolean aBoolean;
    private static boolean bBoolean;
    private static boolean cBoolean;
    private ByteArrayInputStream aClassByteArrayInputStream;
    private InputStream aClassInputStream;
    private byte[] aByteArr;
    private Thread aClassThread;
    
    public j() {
        this.aLong = 0L;
    }
    
    public final void aVoid(final int n) {
        if (j.aClassPlayerArr == null) {
            j.aClassPlayerArr = new Player[21];
        }
        try {
            final byte[] array = new byte[i.aInt(this.aByteArr, (n << 3) + 4)];
            this.aClassInputStream.read(array);
            this.aClassByteArrayInputStream = new ByteArrayInputStream(array);
            (j.aClassPlayerArr[n] = Manager.createPlayer((InputStream)this.aClassByteArrayInputStream, "audio/midi")).addPlayerListener((PlayerListener)this);
            j.aClassPlayerArr[n].realize();
            ((VolumeControl)((Controllable)j.aClassPlayerArr[n]).getControl("VolumeControl")).setLevel(100);
            this.aClassByteArrayInputStream.close();
            this.aClassByteArrayInputStream = null;
            System.gc();
        }
        catch (Exception ex) {}
    }
    
    public final void aVoid() {
        j.bBoolean = false;
        (this.aClassThread = new Thread(this)).setPriority(1);
        this.aClassThread.start();
    }
    
    public final void bVoid() {
        if (j.aClassPlayerArr == null) {
            try {
                (this.aClassInputStream = this.getClass().getResourceAsStream("/snd.f")).skip(1L);
                this.aByteArr = new byte[168];
                this.aClassInputStream.read(this.aByteArr);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public final void cVoid() {
        try {
            j.aInt = -1;
            j.eInt = -1;
            j.cInt = 0;
            this.aClassInputStream.close();
            this.aClassInputStream = null;
            this.aByteArr = null;
            System.gc();
        }
        catch (Exception ex) {}
    }
    
    public final void dVoid() {
        if (j.aClassPlayerArr != null) {
            this.eVoid();
            for (int length = j.aClassPlayerArr.length, i = 0; i < length; ++i) {
                if (j.aClassPlayerArr[i] != null) {
                    j.aClassPlayerArr[i].close();
                    j.aClassPlayerArr[i] = null;
                }
            }
        }
        j.aClassPlayerArr = null;
        j.bBoolean = true;
    }
    
    private static int aInt(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20: {
                return 30;
            }
            case 3:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13: {
                return 20;
            }
            case 0:
            case 5:
            case 6:
            case 10:
            case 14: {
                return 10;
            }
            default: {
                return 0;
            }
        }
    }
    
    public final synchronized void run() {
        while (!bBoolean) {
            try {
                this.wait();
            }
            catch (Exception ex) {}
            if (cBoolean) {
                try {
                    boolean b = false;
                    switch (aInt) {
                        case 0:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14: {
                            b = false;
                            break;
                        }
                        default: {
                            b = true;
                            break;
                        }
                    }
                    if (b) {
                        aClassPlayerArr[aInt].deallocate();
                        eInt = -1;
                    }
                    aInt = -1;
                    cBoolean = false;
                }
                catch (Exception ex2) {}
                finally {
                    cInt = 0;
                }
            }
            if (bInt != -1) {
                try {
                    if (eInt != -1 && bInt != eInt) {
                        aClassPlayerArr[eInt].deallocate();
                        eInt = -1;
                    }
                    if (eInt == -1) {
                        aClassPlayerArr[bInt].prefetch();
                        eInt = bInt;
                    }
                    aClassPlayerArr[bInt].start();
                    aInt = bInt;
                    cInt = dInt;
                    aLong = System.currentTimeMillis();
                    continue;
                }
                catch (Exception ex3) {
                    continue;
                }
                finally {
                    bInt = -1;
                }
//                break;
            }
        }
    }
    
    public final synchronized void bVoid(final int bInt) {
        if (j.aBoolean) {
            if (j.aInt != -1) {
                if (j.cInt >= aInt(bInt) && (j.cInt != aInt(bInt) || Math.abs(System.currentTimeMillis() - this.aLong) <= 50L)) {
                    return;
                }
                j.cBoolean = true;
            }
            else {
                j.cInt = 0;
            }
            final int aInt;
            if ((aInt = aInt(bInt)) >= j.cInt) {
                j.bInt = bInt;
                j.dInt = aInt;
                this.notify();
            }
        }
    }
    
    public final synchronized void eVoid() {
        if (j.aInt != -1) {
            j.cBoolean = true;
        }
        this.notify();
    }
    
    public static synchronized boolean aBoolean() {
        return j.aInt != -1;
    }
    
    public final void playerUpdate(final Player player, final String s, final Object o) {
        if (j.aClassPlayerArr != null && j.aInt != -1 && s.equals("endOfMedia")) {
            this.eVoid();
        }
    }
    
    static {
        j.aInt = -1;
        j.bInt = -1;
        j.eInt = -1;
        j.cBoolean = false;
    }
}

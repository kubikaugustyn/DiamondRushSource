import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

// 
// Decompiled by Procyon v0.5.36
// 

public final class GloftDIRU extends MIDlet {
    public static byte[] aByteArr;
    private i aClassi;
    public Display aClassDisplay;
    public static String aClassString;

    public GloftDIRU() {
        GloftDIRU.aByteArr = this.getAppProperty("MIDlet-Version").getBytes();
        this.aClassi = new i(this);
    }

    public final void startApp() {
        if (this.aClassDisplay == null) {
            this.aClassDisplay = Display.getDisplay((MIDlet) this);
        }
        this.aClassDisplay.setCurrent((Displayable) this.aClassi);
        this.aClassi.dVoid();
    }

    public final void pauseApp() {
        this.aClassi.cVoid();
        this.notifyPaused();
    }

    public final void destroyApp(final boolean b) {
        if (GloftDIRU.aClassString != null) {
            try {
                this.platformRequest(GloftDIRU.aClassString);
            } catch (Exception ex) {
            }
        }
        this.notifyDestroyed();
    }

    public final void aVoid() {
        i.bVoid();
        this.aClassi.aClassj.dVoid();
//        try {
        this.destroyApp(true);
//        }
//        catch (MIDletStateChangeException ex) {}
    }

    static {
        GloftDIRU.aByteArr = null;
        GloftDIRU.aClassString = null;
    }
}

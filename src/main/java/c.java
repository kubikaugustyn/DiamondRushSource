import java.util.Enumeration;
import java.util.Vector;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.microedition.lcdui.Graphics;

// 
// Decompiled by Procyon v0.5.36
// 

public final class c {
    private static long aLong;
    private static String aClassString;
    private static String bClassString;
    public static f[] aClassfArr;
    public byte[][] aByteArrArr;
    private int aInt;
    private long bLong;
    public byte[] aByteArr;
    private int bInt;
    private boolean bBoolean;
    private int cInt;
    private int dInt;
    private int eInt;
    private int fInt;
    private int gInt;
    public boolean aBoolean;
    private static i aClassi;
    private short[] aShortArr;
    private int hInt;

    public c(final i aClassi) {
        this.aByteArrArr = null;
        this.aInt = 0;
        this.aByteArr = null;
        this.bBoolean = false;
        this.cInt = 0;
        this.dInt = 0;
        this.eInt = 0;
        this.fInt = 0;
        this.gInt = -1;
        this.aBoolean = false;
        this.aShortArr = new short[16];
        c.aClassi = aClassi;
    }

    private void aVoid(final Graphics graphics, final byte[] array, int n) {
        if (array == null) {
            return;
        }
        final byte b;
        switch (b = array[n]) {
            case 18: {
                if (array[n + 7] != 0) {
                    graphics.setColor((array[n + 3] & 0xFF) + ((array[n + 3 + 1] & 0xFF) << 8) + ((array[n + 3 + 2] & 0xFF) << 16));
                    graphics.fillRect(0, 0, 240, 320);
                    return;
                }
                break;
            }
            case 12: {
                int bInt = this.bInt;
                graphics.setColor(16777215);
                if (bInt > 5) {
                    bInt = 5;
                }
                final int n2 = c.aClassi.hInt * 24;
                n = c.aClassi.iInt * 24;
                graphics.fillRect(((n2 - c.aClassi.aInt) * (5 - bInt) + this.cInt * bInt) / 5, ((n - c.aClassi.bInt) * (5 - bInt) + this.dInt * bInt) / 5, bInt * 102 / 5, bInt * 38 / 5);
            }
            case 1: {
                int bInt2 = this.bInt;
                final short n3 = (short) i.aInt(array, n + 2);
                final short n4 = (short) i.aInt(array, n + 4);
                final short n5 = (short) i.aInt(array, n + 6);
                short n6 = (short) i.aInt(array, n + 8);
                short n7 = (short) i.aInt(array, n + 10);
                if (n6 == 10000) {
                    n6 = (short) c.aClassi.cInt;
                }
                if (n7 == 10000) {
                    n7 = (short) c.aClassi.dInt;
                }
                if (bInt2 > n5) {
                    bInt2 = n5;
                }
                final short n8 = (short) (n3 - 108);
                final short n9 = (short) (n4 - 108);
                c.aClassi.cInt = (short) ((n8 * bInt2 + n6 * (n5 - bInt2)) / n5);
                c.aClassi.dInt = (short) ((n9 * bInt2 + n7 * (n5 - bInt2)) / n5);
                final int n10 = c.aClassi.eInt * 24 - 240;
                final int bInt3 = c.aClassi.fInt * 24 - 320 + 80;
                Label_0491:
                {
                    i i;
                    int cInt;
                    if (c.aClassi.cInt > n10) {
                        i = c.aClassi;
                        cInt = n10;
                    } else {
                        if (c.aClassi.cInt >= 0) {
                            break Label_0491;
                        }
                        i = c.aClassi;
                        cInt = 0;
                    }
                    i.cInt = cInt;
                }
                Label_0524:
                {
                    i j;
                    int dInt;
                    if (c.aClassi.dInt > bInt3) {
                        j = c.aClassi;
                        dInt = bInt3;
                    } else {
                        if (c.aClassi.dInt >= 0) {
                            break Label_0524;
                        }
                        j = c.aClassi;
                        dInt = 0;
                    }
                    j.dInt = dInt;
                }
                c.aClassi.aInt = c.aClassi.cInt;
                c.aClassi.bInt = c.aClassi.dInt;
                if (c.aClassi.aInt > n10) {
                    final i aClassi = c.aClassi;
                    aClassi.aInt -= n10;
                }
                if (c.aClassi.bInt > bInt3) {
                    c.aClassi.bInt = bInt3;
                    return;
                }
                if (c.aClassi.bInt < 0) {
                    return;
                }
                break;
            }
            case 13: {
                int bInt4 = this.bInt;
                final short n11 = (short) i.aInt(array, n + 2);
                final short n12 = (short) i.aInt(array, n + 4);
                final short n13 = (short) i.aInt(array, n + 6);
                final short n14 = (short) i.aInt(array, n + 8);
                final short n15 = (short) i.aInt(array, n + 10);
                if (bInt4 > n13) {
                    bInt4 = n13;
                }
                final short cInt2 = (short) ((n11 * bInt4 + n14 * (n13 - bInt4)) / n13);
                final short dInt2 = (short) ((n12 * bInt4 + n15 * (n13 - bInt4)) / n13);
                if (b == 13) {
                    this.cInt = cInt2;
                    this.dInt = dInt2;
                    return;
                }
                break;
            }
            case 4: {
                int bInt5 = this.bInt;
                final short n16 = (short) i.aInt(array, n + 2);
                final short n17 = (short) i.aInt(array, n + 4);
                final short n18 = (short) i.aInt(array, n + 6);
                final short n19 = (short) i.aInt(array, n + 6);
                final short n20 = (short) i.aInt(array, n + 14);
                if (bInt5 > n20) {
                    bInt5 = n20;
                }
                c.aClassfArr[(short) i.aInt(array, n + 10)].aVoid(graphics, (int) (short) i.aInt(array, n + 12), (int) (short) ((n18 * bInt5 + n16 * (n20 - bInt5)) / n20), (int) (short) ((n19 * bInt5 + n17 * (n20 - bInt5)) / n20), 0);
            }
            case 27: {
                final int n21 = i.aClassh.aClassFont.stringWidth(i.aClassStringArr[30]) + 10;
                final int n22 = i.aClassh.aClassFont.getHeight() + 4;
                String s = null;
                try {
                    s = new String(array, n + 8, (short) i.aInt(array, n + 2), "ISO-8859-1");
                } catch (Exception ex) {
                }
                if (s != null) {
                    try {
                        s = i.bClassStringArr[Integer.parseInt(s.trim())];
                    } catch (Exception ex2) {
                    }
                }
                i.aVoid(graphics, 6, 197, 226, aClassStringArr(s, 220).length * i.aClassh.aClassFont.getHeight() + 6, 73, 1, n21, n22);
                aVoid(graphics, s, 8, 210, 220);
                i.aClassh.bVoid(graphics, i.aClassStringArr[30], 19, 200, 20);
                if (i.gInt / 2 % 4 < 2) {
                    graphics.drawImage(i.demoUITextures[0][9], 223, 197, 17);
                    return;
                }
                break;
            }
            case 2: {
                final short n23 = (short) i.aInt(array, n + 6);
                int n24;
                if ((n24 = (short) i.aInt(array, n + 4)) == 10000) {
                    n24 = -240;
                }
                String s2 = null;
                try {
                    s2 = new String(array, n + 11, (short) i.aInt(array, n + 2), "ISO-8859-1");
                } catch (Exception ex3) {
                }
                if (s2 != null) {
                    try {
                        s2 = i.bClassStringArr[Integer.parseInt(s2.trim())];
                    } catch (Exception ex4) {
                    }
                }
                final int n25 = aClassStringArr(s2, 222).length * i.aClassh.aClassFont.getHeight() + 2;
                i.aVoid(graphics, n24, n23 - 11, 226, n25, 73, 0);
                aVoid(graphics, s2, n24 + 2, n23 + 2, 222);
                if (i.gInt / 2 % 4 < 2) {
                    graphics.drawImage(i.demoUITextures[0][9], n24 + 226 - 10, n23 + n25 + 2, 17);
                }
                graphics.setClip(0, 0, 240, 320);
                break;
            }
        }
    }

    private void aVoid(final byte[] array, final int n) {
        switch (array[n]) {
            case 7: {
                array[n + 1] = 1;
            }
            case 27: {
                if (i.aBoolean) {
                    return;
                }
                String s = null;
                try {
                    s = new String(array, n + 8, (short) i.aInt(array, n + 2), "ISO-8859-1");
                } catch (Exception ex) {
                }
                this.aVoid(s, 196);
                final short n2 = (short) (array[n + 6] & 0xFF);
                final short n3 = (short) (array[n + 8] & 0xFF);
                if (n2 + n3 >= this.hInt) {
                    array[n + 7] = 1;
                    return;
                }
                array[n + 6] = (byte) (n2 + n3);
            }
            case 2: {
                String s2 = null;
                try {
                    s2 = new String(array, n + 11, (short) i.aInt(array, n + 2), "ISO-8859-1");
                } catch (Exception ex2) {
                }
                this.aVoid(s2, 222);
                final short n4 = (short) (array[n + 9] & 0xFF);
                final short n5 = (short) (array[n + 8] & 0xFF);
                byte[] array2;
                int n6;
                byte b;
                if (n4 + n5 >= this.hInt) {
                    array2 = array;
                    n6 = n + 10;
                    b = 1;
                } else {
                    array2 = array;
                    n6 = n + 9;
                    b = (byte) (n4 + n5);
                }
                array2[n6] = b;
                break;
            }
        }
    }

    public final void aVoid() {
        if (this.aByteArr == null) {
            return;
        }
        if (Math.abs(this.bLong - System.currentTimeMillis()) < c.aLong) {
            return;
        }
        if (this.aByteArr[0] == 0) {
            final byte b = this.aByteArr[1];
            int n = 2 + (b << 2);
            for (byte b2 = 0; b2 < b; ++b2) {
                final int b3 = i.bInt(this.aByteArr, 2 + (b2 << 2));
                this.aVoid(this.aByteArr, n);
                n += b3;
            }
        } else {
            this.aVoid(this.aByteArr, 0);
        }
    }

    public final void aVoid(final Graphics graphics) {
        if (this.aBoolean) {
            return;
        }
        switch ((this.aByteArr == null) ? -1 : this.aByteArr[0]) {
            case 25:
            case 26: {
                if (this.aByteArrArr == null || this.aInt >= this.aByteArrArr.length) {
                    return;
                }
                break;
            }
            default: {
                graphics.setColor(0);
                graphics.fillRect(0, 0, 240, 42);
                graphics.fillRect(0, 278, 240, 42);
                i.aClassh.bVoid(graphics, i.aClassStringArr[65], 2, 320 - (i.aClassh.aClassFont.getHeight() - 10), 36);
                break;
            }
        }
        if (this.aByteArr[0] == 0) {
            final byte b = this.aByteArr[1];
            int n = 2 + (b << 2);
            for (byte b2 = 0; b2 < b; ++b2) {
                final int b3 = i.bInt(this.aByteArr, 2 + (b2 << 2));
                this.aVoid(graphics, this.aByteArr, n);
                n += b3;
            }
        } else {
            this.aVoid(graphics, this.aByteArr, 0);
        }
        if (this.bBoolean) {
            graphics.setColor(0);
            graphics.fillRect(this.cInt - 3, this.dInt - 3, 109, 45);
            c.aClassfArr[this.fInt].aVoid(graphics, 0, this.bInt % c.aClassfArr[this.fInt].aInt(0), this.cInt, this.dInt, 0, 0, 0);
            c.aClassfArr[0].aVoid(graphics, this.eInt, this.cInt, this.dInt, 0);
            if (this.gInt >= 0) {
                if (i.bBoolean && this.gInt == 2) {
                    this.gInt = 7;
                }
                if (i.bBoolean && this.gInt == 6) {
                    this.gInt = 8;
                }
                c.aClassfArr[1].aVoid(graphics, this.gInt, this.cInt + 90, this.dInt - 6, 0);
            }
        }
    }

    public final byte[] aByteArr() {
        final byte[][] aByteArrArr = this.aByteArrArr;
        for (int i = 0; i < aByteArrArr.length; ++i) {
            this.bVoid(aByteArrArr[i], 0);
        }
        this.bBoolean = false;
        this.cInt = 0;
        this.dInt = 0;
        this.eInt = 0;
        this.fInt = 0;
        this.gInt = -1;
        this.aBoolean = false;
        this.aInt = 0;
        this.bLong = System.currentTimeMillis();
        return this.bByteArr();
    }

    private void bVoid(final byte[] array, final int n) {
        if (array[n] != 0) {
            array[n + 1] = 0;
            byte[] array2 = null;
            int n2 = 0;
            int n3 = 0;
            switch (array[n]) {
                case 27: {
                    array[n + 6] = 0;
                    aVoid(array, n + 4, (short) (-240));
                    array2 = array;
                    n2 = n;
                    n3 = 7;
                    break;
                }
                case 2: {
                    array[n + 9] = 0;
                    aVoid(array, n + 4, (short) (-240));
                    array2 = array;
                    n2 = n;
                    n3 = 10;
                    break;
                }
                default: {
                    return;
                }
            }
            array2[n2 + n3] = 0;
            return;
        }
        final byte b = array[n + 1];
        int n4 = n + 2 + (b << 2);
        for (byte b2 = 0; b2 < b; ++b2) {
            final int b3 = i.bInt(array, n + 2 + (b2 << 2));
            this.bVoid(array, n4);
            n4 += b3;
        }
    }

    public final byte[] bByteArr() {
        this.bInt = 0;
        c c;
        byte[] aByteArr;
        if (this.aByteArrArr == null || this.aInt >= this.aByteArrArr.length) {
            c = this;
            aByteArr = null;
        } else {
            c = this;
            aByteArr = this.aByteArrArr[this.aInt++];
        }
        c.aByteArr = aByteArr;
        return this.aByteArr;
    }

    public final void bVoid() {
        if (this.aByteArr[0] == 0) {
            final byte b = this.aByteArr[1];
            int n = 2 + (b << 2);
            for (byte b2 = 0; b2 < b; ++b2) {
                final int b3 = i.bInt(this.aByteArr, 2 + (b2 << 2));
                this.cVoid(this.aByteArr, n);
                n += b3;
            }
        } else {
            this.cVoid(this.aByteArr, 0);
        }
        ++this.bInt;
    }

    private void cVoid(final byte[] array, final int n) {
        final short n2 = array[n];
        if (this.aBoolean) {
            switch (n2) {
                case 5:
                case 9:
                case 10:
                case 25:
                case 26: {
                    break;
                }
                default: {
                    array[n + 1] = 1;
                    return;
                }
            }
        }
        switch (n2) {
            case 16:
            case 17:
            case 18: {
                if (this.bInt % 2 == 0) {
                    return;
                }
                final int n3 = n + ((n2 == 18) ? 2 : 4);
                byte b = array[n3];
                int gInt = -1;
                final int n4 = n + ((n2 == 18) ? 7 : 5);
                int n5 = (array[n4] != 0) ? 1 : 0;
                if (n2 != 18) {
                    gInt = (short) i.aInt(array, n + 2);
                }
                if (n5 != 0) {
                    n5 = 0;
                    this.gInt = -1;
                    if (--b == 0) {
                        array[n + 1] = 1;
                        if (n2 != 18) {
                            this.gInt = ((n2 == 16) ? gInt : -1);
                        }
                    }
                } else if (b > 0) {
                    n5 = 1;
                    if (n2 != 18) {
                        this.gInt = gInt;
                    }
                } else {
                    array[n + 1] = 1;
                }
                array[n4] = (byte) ((n5 != 0) ? 1 : 0);
                array[n3] = b;
            }
            case 14:
            case 15: {
                this.bBoolean = (n2 == 14);
                array[n + 1] = 1;
            }
            case 12: {
                final short cInt = (short) i.aInt(array, n + 2);
                final short dInt = (short) i.aInt(array, n + 4);
                this.cInt = cInt;
                this.dInt = dInt;
                if (this.bInt > 5) {
                    array[n + 1] = 1;
                    this.bBoolean = true;
                    return;
                }
                break;
            }
            case 11: {
                this.fInt = (short) i.aInt(array, n + 4);
                this.eInt = (short) i.aInt(array, n + 2);
                array[n + 1] = 1;
            }
            case 10: {
                final byte aByte = array[n + 2];
                if (this.bInt == 0) {
                    c.aClassi.kInt = ((c.aClassi.kInt & 0xFFFFFFF8) | aByte);
                    c.aClassi.aByte = aByte;
                } else if (c.aClassi.jInt <= 0) {
                    c.aClassi.aByte = 0;
                    array[n + 1] = 1;
                }
                c.aClassi.aVoid();
            }
            case 13: {
                if ((short) i.aInt(array, n + 8) == 10000) {
                    aVoid(array, n + 8, (short) this.cInt);
                }
                if ((short) i.aInt(array, n + 10) == 10000) {
                    aVoid(array, n + 10, (short) this.dInt);
                }
                if (this.bInt > (short) i.aInt(array, n + 6)) {
                    array[n + 1] = 1;
                    return;
                }
                break;
            }
            case 1: {
                if ((short) i.aInt(array, n + 8) == 10000) {
                    aVoid(array, n + 8, (short) c.aClassi.cInt);
                }
                if ((short) i.aInt(array, n + 10) == 10000) {
                    aVoid(array, n + 10, (short) c.aClassi.dInt);
                }
                if (this.bInt > (short) i.aInt(array, n + 6)) {
                    array[n + 1] = 1;
                    return;
                }
                break;
            }
            case 4: {
                if (this.bInt > (short) i.aInt(array, n + 14)) {
                    array[n + 1] = 1;
                    return;
                }
                break;
            }
            case 6: {
                if (this.bInt > i.bInt(array, n + 2)) {
                    array[n + 1] = 1;
                    return;
                }
                break;
            }
            case 25: {
                i.aIntArrArr[(short) i.aInt(array, n + 2)][(short) i.aInt(array, n + 4)] = (array[n + 7] << 8 | array[n + 6]);
                array[n + 1] = 1;
            }
            case 26: {
                i.bIntArrArr[(short) i.aInt(array, n + 2)][(short) i.aInt(array, n + 4)] = i.bInt(array, n + 6);
                array[n + 1] = 1;
            }
            case 5: {
                i.aVoid((short) i.aInt(array, n + 2), (short) i.aInt(array, n + 4), array[n + 6], 0);
                array[n + 1] = 1;
            }
            case 8: {
            }
            case 9: {
                i.aVoid((short) i.aInt(array, n + 2), (short) i.aInt(array, n + 4), (byte) 0, (int) (short) i.aInt(array, n + 6));
                array[n + 1] = 1;
            }
            case 27: {
                if (array[n + 7] != 0) {
                    array[n + 1] = 1;
                    return;
                }
                break;
            }
            case 2: {
                int n6;
                if ((n6 = (short) i.aInt(array, n + 4)) == 10000) {
                    n6 = -226;
                }
                short n7 = (short) (n6 + 30);
                if (array[n + 10] == 0) {
                    if (n7 > 7) {
                        n7 = 7;
                    }
                } else if (n7 > 240) {
                    array[n + 1] = 1;
                }
                aVoid(array, n + 4, n7);
                break;
            }
        }
    }

    public final boolean aBoolean() {
        boolean b = true;
        if (this.aByteArr[0] == 0) {
            final byte b2 = this.aByteArr[1];
            int n = 2 + (b2 << 2);
            for (byte b3 = 0; b3 < b2; ++b3) {
                final int b4 = i.bInt(this.aByteArr, 2 + (b3 << 2));
                if (!(b = (b && this.aByteArr[n + 1] == 1))) {
                    break;
                }
                n += b4;
            }
        } else {
            b = (this.aByteArr[1] == 1);
        }
        return b;
    }

    public final void aVoid(final int n) {
        try {
            final String bClassString = c.bClassString;
            c.aClassi.getClass();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(i.readChunk(bClassString, 0));
            byte[] array = new byte[4];
            byteArrayInputStream.read(array, 0, 2);
            boolean b = false;
            do {
                byteArrayInputStream.read(array, 0, 2);
                if ((short) i.aInt(array, 0) == n) {
                    byteArrayInputStream.read(array, 0, 2);
                    final short n2 = (short) i.aInt(array, 0);
                    byteArrayInputStream.read(array, 0, 4);
                    array = new byte[i.bInt(array, 0)];
                    byteArrayInputStream.read(array);
                    byteArrayInputStream.close();
                    byteArrayInputStream = null;
                    b = true;
                    int n3 = 0;
                    final short n4 = (short) i.aInt(array, 0);
                    n3 += 2;
                    if (n4 != 0) {
                        final short[] array2 = new short[n4];
                        for (short n5 = 0; n5 < n4; ++n5) {
                            array2[n5] = (short) i.aInt(array, n3);
                            n3 += 2;
                        }
                        for (short n6 = 1; n6 < n4; ++n6) {
                            final short n7 = array2[n6];
                            int n9;
                            int n8 = n9 = n6;
                            int n10;
                            while (true) {
                                n10 = n9;
                                if (n8 <= 0 || array2[n10 - 1] <= n7) {
                                    break;
                                }
                                array2[n10] = array2[n10 - 1];
                                n8 = (n9 = n10 - 1);
                            }
                            array2[n10] = n7;
                        }
                        final InputStream resourceAsStream = this.getClass().getResourceAsStream(c.aClassString);
                        byte[] array3 = new byte[4];
                        resourceAsStream.read(array3, 0, 2);
                        final short n11 = (short) i.aInt(array3, 0);
                        if (c.aClassfArr == null) {
                            c.aClassfArr = new f[n11];
                        }
                        for (short n12 = 0; n12 < n4; ++n12) {
                            final short n13 = array2[n12];
                            int iInteger = 0;
                            while (iInteger == 0) {
                                resourceAsStream.read(array3, 0, 2);
                                if (n13 == (short) i.aInt(array3, 0)) {
                                    iInteger = 1;
                                }
                                resourceAsStream.read(array3, 0, 4);
                                final int b2 = i.bInt(array3, 0);
                                if (iInteger == 0 && c.aClassfArr[n13] != null) {
                                    resourceAsStream.skip(b2);
                                } else {
                                    array3 = new byte[b2];
                                    resourceAsStream.read(array3);
                                    (c.aClassfArr[n13] = new f()).aVoid(array3, 0);
                                    c.aClassfArr[n13].aVoid(0, 0, -1, -1);
                                    c.aClassfArr[n13].dByteArr = null;
                                }
                            }
                        }
                        resourceAsStream.close();
                    }
                    final byte[][] aByteArrArr = new byte[n2][];
                    int n14 = 0;
                    byte[][] array4 = null;
                    int n15 = 0;
                    int n16 = 0;
                    for (short n17 = 0; n17 < n2 || n16 != 0; ++n17) {
                        byte[][] array5;
                        if (n16 == 0) {
                            array5 = aByteArrArr;
                        } else {
                            array5 = array4;
                            --n16;
                            --n17;
                        }
                        final int n18 = array[n3++] & 0xFF;
                        byte[] array6 = null;
                        Label_1801:
                        {
                            byte[] array7 = null;
                            switch (n18) {
                                case 18: {
                                    final short n19 = (short) (array[n3++] & 0xFF);
                                    final int n20 = (array[n3++] & 0xFF) + ((array[n3++] & 0xFF) << 8) + ((array[n3++] & 0xFF) << 16);
                                    aVoid(array6 = new byte[8], 2, n19);
                                    aVoid(array6, 3, n20);
                                    array6[7] = 0;
                                    break Label_1801;
                                }
                                case 16:
                                case 17: {
                                    final short n21 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n22 = (short) (array[n3++] & 0xFF);
                                    aVoid(array6 = new byte[6], 2, n21);
                                    aVoid(array6, 4, n22);
                                    array6[5] = 0;
                                    break Label_1801;
                                }
                                case 11: {
                                    final short n23 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n24 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[6], 2, n23);
                                    aVoid(array6, 4, n24);
                                    break Label_1801;
                                }
                                case 12: {
                                    final short n25 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n26 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[6], 2, n25);
                                    aVoid(array6, 4, n26);
                                    break Label_1801;
                                }
                                case 13: {
                                    final short n27 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n28 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n29 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[12], 2, n27);
                                    aVoid(array6, 4, n28);
                                    aVoid(array6, 6, n29);
                                    aVoid(array6, 8, (short) 10000);
                                    aVoid(array6, 10, (short) 10000);
                                    break Label_1801;
                                }
                                case 14:
                                case 15: {
                                    array7 = new byte[2];
                                    break;
                                }
                                case 4: {
                                    final short n30 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n31 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n32 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n33 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n34 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n35 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n36 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[16], 2, n30);
                                    aVoid(array6, 4, n31);
                                    aVoid(array6, 6, n32);
                                    aVoid(array6, 8, n33);
                                    aVoid(array6, 10, n34);
                                    aVoid(array6, 12, n35);
                                    aVoid(array6, 14, n36);
                                    break Label_1801;
                                }
                                case 7: {
                                    array7 = new byte[2];
                                    break;
                                }
                                case 1: {
                                    final short n37 = (short) (i.aInt(array, n3) * 24);
                                    n3 += 2;
                                    final short n38 = (short) (i.aInt(array, n3) * 24);
                                    n3 += 2;
                                    final short n39 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[12], 2, n37);
                                    aVoid(array6, 4, n38);
                                    aVoid(array6, 6, n39);
                                    aVoid(array6, 8, (short) 10000);
                                    aVoid(array6, 10, (short) 10000);
                                    break Label_1801;
                                }
                                case 6: {
                                    final int b3 = i.bInt(array, n3);
                                    n3 += 4;
                                    aVoid(array6 = new byte[6], 2, b3);
                                    break Label_1801;
                                }
                                case 26: {
                                    final short n40 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n41 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final int b4 = i.bInt(array, n3);
                                    n3 += 4;
                                    aVoid(array6 = new byte[10], 2, n40);
                                    aVoid(array6, 4, n41);
                                    aVoid(array6, 6, b4);
                                    break Label_1801;
                                }
                                case 25: {
                                    final short n42 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n43 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n44 = (short) (array[n3++] & 0xFF);
                                    final short n45 = (short) (array[n3++] & 0xFF);
                                    aVoid(array6 = new byte[8], 2, n42);
                                    aVoid(array6, 4, n43);
                                    array6[6] = (byte) n44;
                                    array6[7] = (byte) n45;
                                    break Label_1801;
                                }
                                case 5: {
                                    final short n46 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n47 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n48 = (short) (array[n3++] & 0xFF);
                                    aVoid(array6 = new byte[7], 2, n46);
                                    aVoid(array6, 4, n47);
                                    array6[6] = (byte) n48;
                                    break Label_1801;
                                }
                                case 27: {
                                    final short n49 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[n49 + 8], 2, n49);
                                    aVoid(array6, 4, (short) 10000);
                                    array6[7] = (array6[6] = 0);
                                    System.arraycopy(array, n3, array6, 8, n49);
                                    n3 += n49;
                                    break Label_1801;
                                }
                                case 2: {
                                    final short n50 = (short) (array[n3++] & 0xFF);
                                    final short n51 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n52 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[n52 + 11], 2, n52);
                                    aVoid(array6, 4, (short) 10000);
                                    aVoid(array6, 6, n51);
                                    array6[8] = (byte) n50;
                                    array6[10] = (array6[9] = 0);
                                    System.arraycopy(array, n3, array6, 11, n52);
                                    n3 += n52;
                                    break Label_1801;
                                }
                                case 9: {
                                    final short n53 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n54 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    final short n55 = (short) i.aInt(array, n3);
                                    n3 += 2;
                                    aVoid(array6 = new byte[8], 2, n53);
                                    aVoid(array6, 4, n54);
                                    aVoid(array6, 6, n55);
                                    break Label_1801;
                                }
                                case 10: {
                                    (array6 = new byte[3])[2] = (byte) (array[n3++] & 0xFF);
                                    break Label_1801;
                                }
                                case 0: {
                                    array4 = new byte[n16 = (short) (array[n3++] & 0xFF)][];
                                    array7 = null;
                                    break;
                                }
                            }
                            array6 = array7;
                        }
                        if (array6 != null) {
                            array6[0] = (byte) n18;
                            array6[1] = 0;
                            if (array5 == array4) {
                                array5[n15] = array6;
                                ++n15;
                            } else {
                                array5[n14] = array6;
                                ++n14;
                            }
                        }
                        if (array5 == array4 && n16 == 0) {
                            int n56 = 0;
                            for (int j = 0; j < array4.length; ++j) {
                                n56 += array4[j].length;
                            }
                            final byte[] array8;
                            (array8 = new byte[2 + (array4.length << 2) + n56])[0] = 0;
                            array8[1] = (byte) array4.length;
                            int n57 = 2 + (array4.length << 2);
                            for (int k = 0; k < array4.length; ++k) {
                                aVoid(array8, 2 + (k << 2), array4[k].length);
                                System.arraycopy(array4[k], 0, array8, n57, array4[k].length);
                                n57 += array4[k].length;
                            }
                            aByteArrArr[n14] = array8;
                            n15 = 0;
                            array4 = null;
                            ++n14;
                        }
                    }
                    this.aByteArrArr = aByteArrArr;
                } else {
                    byteArrayInputStream.skip(2L);
                    byteArrayInputStream.read(array, 0, 4);
                    byteArrayInputStream.skip(i.bInt(array, 0));
                }
            } while (!b);
        } catch (Exception ex) {
        }
    }

    public static int aInt(final Graphics graphics, final String s, final int n, int n2, int iInteger) {
        String[] aClassStringArr;
        for (aClassStringArr = aClassStringArr(s, iInteger), iInteger = 0; iInteger < aClassStringArr.length; ++iInteger) {
            i.aClassh.bVoid(graphics, aClassStringArr[iInteger], n, n2, 17);
            n2 += i.aClassh.aClassFont.getHeight();
        }
        return n2;
    }

    private static void aVoid(final Graphics graphics, final String s, final int n, int n2, final int n3) {
        n2 += 14;
        try {
            final String[] aClassStringArr = aClassStringArr(s, n3);
            for (int iInteger = 0; iInteger < aClassStringArr.length; ++iInteger) {
                if (aClassStringArr[iInteger] == null) {
                    return;
                }
                if (aClassStringArr[iInteger].trim().equals("") || aClassStringArr[iInteger].trim().equals(" ")) {
                    return;
                }
                h h;
                Graphics graphics2;
                String s2;
                int n4;
                int n5;
                int n6;
                if (i.bBoolean) {
                    h = i.aClassh;
                    graphics2 = graphics;
                    s2 = aClassStringArr[iInteger];
                    n4 = n + n3;
                    n5 = n2;
                    n6 = 8;
                } else {
                    h = i.aClassh;
                    graphics2 = graphics;
                    s2 = aClassStringArr[iInteger];
                    n4 = n;
                    n5 = n2;
                    n6 = 4;
                }
                h.bVoid(graphics2, s2, n4, n5, n6);
                n2 += i.aClassh.aClassFont.getHeight();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String[] aClassStringArr(final String s, final int n) {
        final Vector<String> vector = new Vector<String>();
        String obj = "";
        final String[] aClassStringArr = aClassStringArr(s, ' ');
        for (int iInteger = 0; iInteger < aClassStringArr.length; ++iInteger) {
            final String str = aClassStringArr[iInteger];
            if (i.aClassh.aClassFont.stringWidth(str) >= n) {
                final String[] bClassStringArr;
                final String trim;
                if ((bClassStringArr = bClassStringArr(obj + str, n)).length > 1 && (trim = bClassStringArr[bClassStringArr.length - 1].trim()).length() == 1 && (trim.equals(".") || trim.equals(",") || trim.equals(";") || trim.equals("?") || trim.equals("'") || trim.equals("\"") || trim.equals("!"))) {
                    final String s2 = bClassStringArr[bClassStringArr.length - 2];
                    final String string = s2.charAt(s2.length() - 1) + trim;
                    bClassStringArr[bClassStringArr.length - 2] = s2.substring(0, s2.length() - 1);
                    bClassStringArr[bClassStringArr.length - 1] = string;
                }
                final String[] array = bClassStringArr;
                for (int j = 0; j < array.length - 1; ++j) {
                    if (array[j] != null && !array[j].equals("") && !array[j].equals(" ")) {
                        vector.addElement(array[j]);
                    }
                }
                obj = "" + array[array.length - 1] + " ";
                if (iInteger != aClassStringArr.length - 1 || obj == null || obj.equals("") || obj.equals(" ")) {
                    continue;
                }
            } else {
                StringBuffer sb;
                if (i.aClassh.aClassFont.stringWidth(obj + str + " ") < n) {
                    final String trim2;
                    if (aClassStringArr.length > 2 && iInteger == aClassStringArr.length - 2 && (trim2 = aClassStringArr[aClassStringArr.length - 1].trim()).length() == 1 && i.aClassh.aClassFont.stringWidth(obj + " " + str + " " + trim2) >= n && (trim2.equals(".") || trim2.equals(",") || trim2.equals(";") || trim2.equals("?") || trim2.equals("'") || trim2.equals("\"") || trim2.equals("!"))) {
                        if (obj != null && !obj.equals("") && !obj.equals(" ")) {
                            vector.addElement(obj);
                        }
                        final String string2;
                        if ((string2 = "" + str + " " + trim2) != null && !string2.equals("") && !string2.equals(" ")) {
                            vector.addElement(string2);
                            break;
                        }
                        break;
                    } else {
                        sb = new StringBuffer();
                    }
                } else {
                    if (obj != null && !obj.equals("") && !obj.equals(" ")) {
                        vector.addElement(obj);
                    }
                    obj = "";
                    sb = new StringBuffer();
                }
                obj = sb.append(obj).append(str).append(" ").toString();
                if (iInteger != aClassStringArr.length - 1 || obj == null || obj.equals("") || obj.equals(" ")) {
                    continue;
                }
            }
            vector.addElement(obj);
        }
        return aClassStringArr(vector);
    }

    private static String[] bClassStringArr(final String s, final int n) {
        final Vector<String> vector = new Vector<String>();
        String string = "";
        for (int iInteger = 0; iInteger < s.length(); ++iInteger) {
            final char char1 = s.charAt(iInteger);
            StringBuffer sb;
            String str;
            if (i.aClassh.aClassFont.stringWidth(string + char1) < n) {
                sb = new StringBuffer();
                str = string;
            } else {
                vector.addElement(string);
                sb = new StringBuffer();
                str = "";
            }
            string = sb.append(str).append(char1).toString();
            if (iInteger == s.length() - 1 && string != null && !string.equals("") && !string.equals(" ")) {
                vector.addElement(string);
            }
        }
        return aClassStringArr(vector);
    }

    private static String[] aClassStringArr(final Vector vector) {
        final String[] array = new String[vector.size()];
        final Enumeration<String> elements = vector.elements();
        int n = 0;
        while (elements.hasMoreElements()) {
            final String trim;
            if (!(trim = elements.nextElement().trim()).equals("") && !trim.equals(" ")) {
                array[n] = trim;
            }
            ++n;
        }
        return array;
    }

    public static String[] aClassStringArr(final String s, final char c) {
        final Vector<String> vector = new Vector<String>();
        String string = "";
        for (int i = 0; i < s.length(); ++i) {
            final char char1;
            if ((char1 = s.charAt(i)) != c) {
                string += char1;
            }
            if (char1 == c || char1 == '\n' || i == s.length() - 1) {
                vector.addElement(string);
                string = "";
            }
        }
        return aClassStringArr(vector);
    }

    private void aVoid(final String s, final int n) {
        try {
            this.hInt = 0;
            final int length = s.length();
            int n2 = 0;
            int n3 = 0;
            for (int iInteger = 0; iInteger < length; ++iInteger) {
                if (s.charAt(length - 1) == '\n') {
                    return;
                }
                Label_0276:
                {
                    final char char1;
                    if ((char1 = s.charAt(iInteger)) > ' ') {
                        n2 += i.aClassh.aClassFont.charWidth((char) char1);
                    } else if (char1 == ' ' && iInteger + 1 < length && (s.charAt(iInteger + 1) == '?' || s.charAt(iInteger + 1) == '!' || s.charAt(iInteger + 1) == ':')) {
                        final int n4 = n2 + i.aClassh.aClassFont.charWidth((char) char1);
                        s.charAt(iInteger + 1);
                        n2 = n4 + i.aClassh.aClassFont.charWidth((char) char1);
                    } else {
                        if (char1 == ' ') {
                            n2 += i.aClassh.aClassFont.charWidth((char) char1);
                            break Label_0276;
                        }
                        if (char1 == '\n') {
                            n2 = 0;
                            this.aShortArr[this.hInt++] = (short) iInteger;
                        }
                        continue;
                    }
                    if (n2 > n) {
                        iInteger = n3 - 1;
                        this.aShortArr[this.hInt++] = (short) iInteger;
                        n2 = 0;
                    }
                    if (s.charAt(iInteger) != ' ') {
                        continue;
                    }
                }
                n3 = iInteger + 1;
            }
            this.aShortArr[this.hInt++] = (short) length;
        } catch (Exception ex) {
        }
    }

    private static void aVoid(final byte[] array, final int n, final short n2) {
        array[n] = (byte) n2;
        array[n + 1] = (byte) (n2 >> 8);
    }

    private static void aVoid(final byte[] array, final int n, final int n2) {
        array[n] = (byte) n2;
        array[n + 1] = (byte) (n2 >> 8);
        array[n + 2] = (byte) (n2 >> 16);
        array[n + 3] = (byte) (n2 >>> 24);
    }

    static {
        c.aLong = 1000L;
        c.aClassString = "/demoSpr.bin";
        c.bClassString = "/demo.f";
        c.aClassfArr = null;
        c.aClassi = null;
    }
}

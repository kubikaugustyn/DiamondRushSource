import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// 
// Decompiled by Procyon v0.5.36
// 

public final class f
{
    private static int[] aIntArr;
    private byte[] fByteArr;
    private byte[] gByteArr;
    private short[] bShortArr;
    public byte[] aByteArr;
    private byte[] hByteArr;
    public byte[] bByteArr;
    public short[] aShortArr;
    public byte[] cByteArr;
    private int[][] aIntArrArr;
    private int bInt;
    public int aInt;
    private boolean aBoolean;
    private short aShort;
    public byte[] dByteArr;
    private short[] cShortArr;
    public Image[][] aClassImageArrArr;
    public static byte[] eByteArr;
    
    public final void aVoid(final byte[] array, int n) {
        try {
            System.gc();
            ++n;
            ++n;
            ++n;
            ++n;
            ++n;
            ++n;
            final int n2 = 6;
            ++n;
            final int n3 = array[n2] & 0xFF;
            final int n4 = 7;
            ++n;
            final short n5;
            if ((n5 = (short)(n3 + ((array[n4] & 0xFF) << 8))) > 0) {
                System.arraycopy(array, 8, this.fByteArr = new byte[n5 << 1], 0, this.fByteArr.length);
                n = 8 + this.fByteArr.length;
            }
            final short n6;
            if ((n6 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8))) > 0) {
                System.arraycopy(array, n, this.hByteArr = new byte[n6 << 2], 0, this.hByteArr.length);
                n += this.hByteArr.length;
            }
            final short n7;
            if ((n7 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8))) > 0) {
                this.gByteArr = new byte[n7];
                this.bShortArr = new short[n7];
                for (short n8 = 0; n8 < n7; ++n8) {
                    this.gByteArr[n8] = array[n++];
                    ++n;
                    this.bShortArr[n8] = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8));
                }
                final int n9 = n7 << 2;
                this.aByteArr = new byte[n9];
                for (int i = 0; i < n9; ++i) {
                    this.aByteArr[i] = array[n++];
                }
            }
            final short n10;
            if ((n10 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8))) > 0) {
                System.arraycopy(array, n, this.cByteArr = new byte[n10 * 5], 0, this.cByteArr.length);
                n += this.cByteArr.length;
            }
            final short n11;
            if ((n11 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8))) > 0) {
                this.bByteArr = new byte[n11];
                this.aShortArr = new short[n11];
                for (short n12 = 0; n12 < n11; ++n12) {
                    this.bByteArr[n12] = array[n++];
                    ++n;
                    this.aShortArr[n12] = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8));
                }
            }
            if (n5 <= 0) {
                System.gc();
                return;
            }
            final short n13 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8));
            this.bInt = (array[n++] & 0xFF);
            final int n14 = array[n++] & 0xFF;
            this.aIntArrArr = new int[16][];
            for (int j = 0; j < this.bInt; ++j) {
                this.aIntArrArr[j] = new int[n14];
                switch (n13) {
                    case -30584: {
                        for (int k = 0; k < n14; ++k) {
                            final int n15;
                            if (((n15 = (array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8) + ((array[n++] & 0xFF) << 16) + ((array[n++] & 0xFF) << 24)) & 0xFF000000) != 0xFF000000) {
                                this.aBoolean = true;
                            }
                            this.aIntArrArr[j][k] = n15;
                        }
                        break;
                    }
                    case 17476: {
                        for (int l = 0; l < n14; ++l) {
                            final int n16;
                            if (((n16 = (array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8)) & 0xF000) != 0xF000) {
                                this.aBoolean = true;
                            }
                            this.aIntArrArr[j][l] = ((n16 & 0xF000) << 16 | (n16 & 0xF000) << 12 | (n16 & 0xF00) << 12 | (n16 & 0xF00) << 8 | (n16 & 0xF0) << 8 | (n16 & 0xF0) << 4 | (n16 & 0xF) << 4 | (n16 & 0xF));
                        }
                        break;
                    }
                    case 21781: {
                        for (int n17 = 0; n17 < n14; ++n17) {
                            final int n18 = (array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8);
                            int n19 = -16777216;
                            if ((n18 & 0x8000) != 0x8000) {
                                n19 = 0;
                                this.aBoolean = true;
                            }
                            this.aIntArrArr[j][n17] = (n19 | (n18 & 0x7C00) << 9 | (n18 & 0x3E0) << 6 | (n18 & 0x1F) << 3);
                        }
                        break;
                    }
                    case 25861: {
                        for (int n20 = 0; n20 < n14; ++n20) {
                            final int n21 = (array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8);
                            int n22 = -16777216;
                            if (n21 == 63519) {
                                n22 = 0;
                                this.aBoolean = true;
                            }
                            this.aIntArrArr[j][n20] = (n22 | (n21 & 0xF800) << 8 | (n21 & 0x7E0) << 5 | (n21 & 0x1F) << 3);
                        }
                        break;
                    }
                }
            }
            this.aShort = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8));
            if (n5 > 0) {
                this.cShortArr = new short[n5];
                int n23 = 0;
                int n24 = n;
                for (short n25 = 0; n25 < n5; ++n25) {
                    final short n26 = (short)((array[n24++] & 0xFF) + ((array[n24++] & 0xFF) << 8));
                    this.cShortArr[n25] = (short)n23;
                    n24 += n26;
                    n23 += n26;
                }
                this.dByteArr = new byte[n23];
                for (short n27 = 0; n27 < n5; ++n27) {
                    final short n28 = (short)((array[n++] & 0xFF) + ((array[n++] & 0xFF) << 8));
                    System.arraycopy(array, n, this.dByteArr, this.cShortArr[n27] & 0xFFFF, n28);
                    n += n28;
                }
            }
            System.gc();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public final void aVoid(final int aInt, int aInt2, int n, int i) {
        if (this.fByteArr == null) {
            return;
        }
        if (n == -1) {
            n = (this.fByteArr.length >> 1) - 1;
        }
        if (this.aClassImageArrArr == null) {
            this.aClassImageArrArr = new Image[this.bInt][];
        }
        if (this.aClassImageArrArr[aInt] == null) {
            this.aClassImageArrArr[aInt] = new Image[this.fByteArr.length >> 1];
        }
        aInt2 = this.aInt;
        this.aInt = aInt;
        System.gc();
        int n2;
        int n3;
        int n4;
        int[] aIntArr;
        boolean b;
        int n5;
        int j;
        for (i = 0; i <= n; ++i) {
            n2 = i << 1;
            n3 = (this.fByteArr[n2] & 0xFF);
            n4 = (this.fByteArr[n2 + 1] & 0xFF);
            if (n3 > 0 && n4 > 0 && (aIntArr = this.aIntArr(i)) != null) {
                b = false;
                for (n5 = n3 * n4, j = 0; j < n5; ++j) {
                    if ((aIntArr[j] & 0xFF000000) != 0xFF000000) {
                        b = true;
                        break;
                    }
                }
                this.aClassImageArrArr[aInt][i] = Image.createRGBImage(aIntArr, n3, n4, b);
            }
        }
        System.gc();
        this.aInt = aInt2;
        System.gc();
    }
    
    public final void aVoid(int i) {
        if (this.fByteArr == null) {
            return;
        }
        if (this.aClassImageArrArr == null) {
            return;
        }
        if (this.aClassImageArrArr[0] == null) {
            return;
        }
        for (i = 0; i < this.aClassImageArrArr[0].length; ++i) {
            this.aClassImageArrArr[0][i] = null;
        }
        this.aClassImageArrArr[0] = null;
        --this.bInt;
    }
    
    public final String toStringClassString() {
        new String();
        int i = 0;
        for (int j = 0; j < this.fByteArr.length / 2; ++j) {
            i += 2 * (this.fByteArr[j * 2] & 0xFF) * (this.fByteArr[j * 2 + 1] & 0xFF);
        }
        return "raw/full: " + this.dByteArr.length + "/" + i;
    }
    
    public final int aInt(final int n, final int n2) {
        return this.cByteArr[(this.aShortArr[n] + n2) * 5 + 1] & 0xFF;
    }
    
    public final int aInt(final int n) {
        return this.bByteArr[n] & 0xFF;
    }
    
    public final void aVoid(final Graphics graphics, int n, int n2, final int n3, final int n4, final int n5, int n6, int n7) {
        n = (this.aShortArr[n] + n2) * 5;
        n2 = (this.cByteArr[n] & 0xFF);
        if ((n5 & 0x20) != 0x0) {
            n6 = (((n5 & 0x1) != 0x0) ? (0 + this.cByteArr[n + 2]) : (0 - this.cByteArr[n + 2]));
            n7 = (((n5 & 0x2) != 0x0) ? (0 + this.cByteArr[n + 3]) : (0 - this.cByteArr[n + 3]));
        }
        this.aVoid(graphics, n2, n3 - n6, n4 - n7, n5 ^ (this.cByteArr[n + 4] & 0xF));
    }
    
    public final void aVoid(final Graphics graphics, final int n, final int n2, final int n3, final int n4) {
        final int n5 = this.gByteArr[n] & 0xFF;
        for (short n6 = 0; n6 < n5; ++n6) {
            final int n7 = this.bShortArr[n] + n6 << 2;
            final int n8 = this.hByteArr[n7 + 3] & 0xFF;
            final int n9 = this.hByteArr[n7] & 0xFF;
            int n10 = ((n4 & 0x1) != 0x0) ? (n2 - this.hByteArr[n7 + 1]) : (n2 + this.hByteArr[n7 + 1]);
            int n11 = ((n4 & 0x2) != 0x0) ? (n3 - this.hByteArr[n7 + 2]) : (n3 + this.hByteArr[n7 + 2]);
            if ((n4 & 0x1) != 0x0) {
                n10 -= (this.fByteArr[n9 << 1] & 0xFF);
            }
            if ((n4 & 0x2) != 0x0) {
                n11 -= (this.fByteArr[(n9 << 1) + 1] & 0xFF);
            }
            this.bVoid(graphics, n9, n10, n11, n4 ^ (n8 & 0xF));
        }
    }
    
    public final void bVoid(final Graphics graphics, final int n, final int n2, final int n3, final int n4) {
        final int n5 = n << 1;
        final int n6 = this.fByteArr[n5] & 0xFF;
        final int n7 = this.fByteArr[n5 + 1] & 0xFF;
        if (n6 <= 0 || n7 <= 0) {
            return;
        }
        Image rgbImage = null;
        if (this.aClassImageArrArr != null && this.aClassImageArrArr[this.aInt] != null) {
            rgbImage = this.aClassImageArrArr[this.aInt][n];
        }
        if (rgbImage == null) {
            final int[] aIntArr;
            if ((aIntArr = this.aIntArr(n)) == null) {
                return;
            }
            rgbImage = Image.createRGBImage(aIntArr, n6, n7, this.aBoolean);
        }
        final int width = rgbImage.getWidth();
        final int height = rgbImage.getHeight();
        Graphics graphics2;
        Image image;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        if ((n4 & 0x1) != 0x0) {
            if ((n4 & 0x2) != 0x0) {
                graphics2 = graphics;
                image = rgbImage;
                n8 = 0;
                n9 = 0;
                n10 = width;
                n11 = height;
                n12 = 3;
            }
            else {
                graphics2 = graphics;
                image = rgbImage;
                n8 = 0;
                n9 = 0;
                n10 = width;
                n11 = height;
                n12 = 2;
            }
        }
        else if ((n4 & 0x2) != 0x0) {
            graphics2 = graphics;
            image = rgbImage;
            n8 = 0;
            n9 = 0;
            n10 = width;
            n11 = height;
            n12 = 1;
        }
        else {
            graphics2 = graphics;
            image = rgbImage;
            n8 = 0;
            n9 = 0;
            n10 = width;
            n11 = height;
            n12 = 0;
        }
        graphics2.drawRegion(image, n8, n9, n10, n11, n12, n2, n3, 0);
    }
    
    private int[] aIntArr(int n) {
        if (this.dByteArr == null || this.cShortArr == null) {
            return null;
        }
        final int n2 = n << 1;
        final int n3 = this.fByteArr[n2] & 0xFF;
        final int n4 = this.fByteArr[n2 + 1] & 0xFF;
        final int[] aIntArr = f.aIntArr;
        final int[] array;
        if ((array = this.aIntArrArr[this.aInt]) == null) {
            return null;
        }
        final byte[] dByteArr = this.dByteArr;
        n = (this.cShortArr[n] & 0xFFFF);
        int i = 0;
        final int n5 = n3 * n4;
        if (this.aShort == 10225) {
            while (i < n5) {
                int n6;
                if ((n6 = (dByteArr[n++] & 0xFF)) > 127) {
                    final int n7 = array[dByteArr[n++] & 0xFF];
                    n6 -= 128;
                    while (n6-- > 0) {
                        aIntArr[i++] = n7;
                    }
                }
                else {
                    aIntArr[i++] = array[n6];
                }
            }
        }
        else if (this.aShort == 5632) {
            while (i < n5) {
                aIntArr[i++] = array[dByteArr[n] >> 4 & 0xF];
                aIntArr[i++] = array[dByteArr[n] & 0xF];
                ++n;
            }
        }
        else if (this.aShort == 1024) {
            while (i < n5) {
                aIntArr[i++] = array[dByteArr[n] >> 6 & 0x3];
                aIntArr[i++] = array[dByteArr[n] >> 4 & 0x3];
                aIntArr[i++] = array[dByteArr[n] >> 2 & 0x3];
                aIntArr[i++] = array[dByteArr[n] & 0x3];
                ++n;
            }
        }
        else if (this.aShort == 512) {
            while (i < n5) {
                aIntArr[i++] = array[dByteArr[n] >> 7 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 6 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 5 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 4 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 3 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 2 & 0x1];
                aIntArr[i++] = array[dByteArr[n] >> 1 & 0x1];
                aIntArr[i++] = array[dByteArr[n] & 0x1];
                ++n;
            }
        }
        else if (this.aShort == 22018) {
            while (i < n5) {
                aIntArr[i++] = array[dByteArr[n++] & 0xFF];
            }
        }
        else if (this.aShort == 22258) {
            while (i < n5) {
                int n8;
                if ((n8 = (dByteArr[n++] & 0xFF)) > 127) {
                    n8 -= 128;
                    while (n8-- > 0) {
                        aIntArr[i++] = array[dByteArr[n++] & 0xFF];
                    }
                }
                else {
                    final int n9 = array[dByteArr[n++] & 0xFF];
                    while (n8-- > 0) {
                        aIntArr[i++] = n9;
                    }
                }
            }
        }
        return aIntArr;
    }
    
    public final void aVoid(final boolean b) {
        this.fByteArr = null;
        this.gByteArr = null;
        this.bShortArr = null;
        this.aByteArr = null;
        this.hByteArr = null;
        this.bByteArr = null;
        this.aShortArr = null;
        this.cByteArr = null;
        if (this.aIntArrArr != null) {
            for (int i = 0; i < this.aIntArrArr.length; ++i) {
                this.aIntArrArr[i] = null;
            }
            this.aIntArrArr = null;
        }
        this.dByteArr = null;
        this.cShortArr = null;
        if (b && this.aClassImageArrArr != null) {
            for (int j = 0; j < this.aClassImageArrArr.length; ++j) {
                if (this.aClassImageArrArr[j] != null) {
                    for (int k = 0; k < this.aClassImageArrArr[j].length; ++k) {
                        this.aClassImageArrArr[j][k] = null;
                    }
                }
            }
            this.aClassImageArrArr = null;
        }
    }
    
    static {
        f.aIntArr = new int[4096];
    }
}

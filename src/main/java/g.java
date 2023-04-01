import javax.microedition.lcdui.Graphics;

// 
// Decompiled by Procyon v0.5.36
// 

public final class g
{
    public static byte[][] aByteArrArr;
    private static byte aByte;
    private static byte bByte;
    private static int bInt;
    private static byte cByte;
    private static byte dByte;
    private static boolean aBoolean;
    public static int aInt;
    
    public static void aVoid(int i) {
        if ((g.aByte += g.bByte) > 24) {
            g.aByte = 0;
            int j;
            for (i = 12; i >= 1; --i) {
                for (j = 0; j < 12; ++j) {
                    g.aByteArrArr[j][i] = g.aByteArrArr[j][i - 1];
                }
            }
            bVoid(3);
        }
    }
    
    public static void bVoid(final int n) {
        for (int i = 0; i < 12; ++i) {
            g.aByteArrArr[i][0] = 0;
        }
        for (int j = 0; j < n; ++j) {
            int a;
            do {
                a = e.aInt(0, 12);
            } while (g.aByteArrArr[a][0] != 0);
            g.aByteArrArr[a][0] = (byte)e.aInt(1, 3);
        }
    }
    
    public static void aVoid(final Graphics graphics) {
        for (int iInteger = 0; iInteger < 12; ++iInteger) {
            for (int j = 0; j < 13; ++j) {
                f f;
                Graphics graphics2;
                int bInt;
                if (g.aByteArrArr[iInteger][j] == 1) {
                    f = i.aClassfArr[i.aInt(2)];
                    graphics2 = graphics;
                    bInt = g.bInt;
                }
                else {
                    if (g.aByteArrArr[iInteger][j] != 2) {
                        continue;
                    }
                    f = i.aClassfArr[i.aInt(2)];
                    graphics2 = graphics;
                    bInt = 0;
                }
                f.aVoid(graphics2, bInt, iInteger * 24, (j - 1) * 24 + g.aByte, 0);
            }
        }
        g.bInt = (g.bInt + 1) % g.aInt;
    }
    
    static {
        g.aByte = 0;
        g.bByte = 4;
        g.bInt = 0;
        g.cByte = 0;
        g.dByte = 2;
        g.aBoolean = false;
        g.aInt = 0;
    }
}

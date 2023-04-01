import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import java.io.InputStream;
import javax.microedition.lcdui.Font;

// 
// Decompiled by Procyon v0.5.36
// 

public final class h
{
    public static int aInt;
    public static int bInt;
    private static int eInt;
    public static int cInt;
    public int dInt;
    public int[] aIntArr;
    public int[] bIntArr;
    private static byte[] aByteArr;
    public Font aClassFont;
    
    public h(final int eInt) {
        this.dInt = 0;
        this.aIntArr = new int[2];
        this.bIntArr = new int[3];
        h.eInt = eInt;
        h.cInt = 16777215;
        this.aClassFont = Font.getFont(0, 1, eInt);
        this.aIntArr[0] = 4;
        this.aIntArr[1] = 14;
        this.bIntArr[0] = 0;
        this.bIntArr[0] = 0;
        this.bIntArr[0] = 0;
        final InputStream resourceAsStream = this.getClass().getResourceAsStream("/mc");
        h.aByteArr = new byte[256];
        try {
            resourceAsStream.read(h.aByteArr);
            resourceAsStream.close();
        }
        catch (Exception ex) {}
    }
    
    public static int aInt() {
        return h.eInt;
    }
    
    public final void aVoid(final Graphics graphics, final String s, final int n, final int n2, final int n3) {
        final String[] aClassStringArr = aClassStringArr(s);
        final int height = this.aClassFont.getHeight();
        for (int i = 0; i < aClassStringArr.length; ++i) {
            this.bVoid(graphics, aClassStringArr[i], n, n2 + i * height, n3);
        }
    }
    
    private static String[] aClassStringArr(final Vector vector) {
        final String[] array = new String[vector.size()];
        final Enumeration<String> elements = vector.elements();
        int n = 0;
        while (elements.hasMoreElements()) {
            array[n] = elements.nextElement().trim();
            ++n;
        }
        return array;
    }
    
    private static String[] aClassStringArr(final String s) {
        final Vector<String> vector = new Vector<String>();
        String string = "";
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            string += char1;
            if (char1 == '\n' || i == s.length() - 1) {
                vector.addElement(string);
                string = "";
            }
        }
        return aClassStringArr(vector);
    }
    
    public final void aVoid(final String s) {
        h.aInt = 0;
        final String[] aClassStringArr = aClassStringArr(s);
        for (int i = 0; i < aClassStringArr.length; ++i) {
            final int stringWidth;
            if ((stringWidth = this.aClassFont.stringWidth(aClassStringArr[i])) > h.aInt) {
                h.aInt = stringWidth;
            }
        }
        h.bInt = aClassStringArr.length * this.aClassFont.getHeight();
    }
    
    public final void aVoid(final Graphics graphics, final String s, final int n, int n2, final int color, final int n3) {
        n2 -= 12;
        this.aVoid(s);
        graphics.setColor(color);
        graphics.setFont(this.aClassFont);
        graphics.drawString(s, n, n2, 0);
    }
    
    public final void bVoid(final Graphics graphics, final String s, int n, int n2, final int n3) {
        n2 -= 12;
        Label_0046: {
            if ((n3 & 0x2B) != 0x0) {
                this.aVoid(s);
                int n4;
                int aInt;
                if ((n3 & 0x8) != 0x0) {
                    n4 = n;
                    aInt = h.aInt;
                }
                else {
                    if ((n3 & 0x1) == 0x0) {
                        break Label_0046;
                    }
                    n4 = n;
                    aInt = h.aInt >> 1;
                }
                n = n4 - aInt;
            }
        }
        graphics.setColor(16777215);
        graphics.setFont(this.aClassFont);
        graphics.drawString(s, n, n2, 0);
    }
    
    public static void aVoid() {
        h.cInt = 16777215;
    }
    
    public static void aVoid(final int cInt) {
        h.cInt = cInt;
    }
    
    public final int aInt(final String s) {
        int n = 1;
        for (int length = s.length(), i = s.indexOf(10); i != -1; i = ((i < length - 1) ? s.indexOf(10, i + 1) : -1)) {
            ++n;
        }
        return this.aClassFont.getHeight() * n;
    }
    
    static {
        h.eInt = 0;
        h.cInt = 0;
    }
}

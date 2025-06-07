import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import java.io.InputStream;
import javax.microedition.lcdui.Font;

// 
// Decompiled by Procyon v0.5.36
// 

public final class h {
    public static int stringWidth;
    public static int stringHeight;
    private static int size;
    public static int RGB;
    public int dInt;
    public int[] aIntArr;
    public int[] bIntArr;
    private static byte[] mc;
    public Font font;

    public h(final int size) {
        this.dInt = 0;
        this.aIntArr = new int[2];
        this.bIntArr = new int[3];
        h.size = size;
        h.RGB = 16777215;
        this.font = Font.getFont(0, 1, size);
        this.aIntArr[0] = 4;
        this.aIntArr[1] = 14;
        this.bIntArr[0] = 0;
        //this.bIntArr[0] = 0;
        //this.bIntArr[0] = 0;
        final InputStream resourceAsStream = this.getClass().getResourceAsStream("/mc");
        h.mc = new byte[256];
        try {
            resourceAsStream.read(h.mc);
            resourceAsStream.close();
        } catch (Exception ex) {
        }
    }

    public static int getFontSize() {
        return h.size;
    }

    public final void drawText(final Graphics graphics, final String s, final int n, final int n2, final int n3) {
        final String[] aClassStringArr = stringToLines(s);
        final int height = this.font.getHeight();
        for (int i = 0; i < aClassStringArr.length; ++i) {
            this.drawTextWithFlags(graphics, aClassStringArr[i], n, n2 + i * height, n3);
        }
    }

    private static String[] stringVectorToArray(final Vector<String> vector) {
        final String[] array = new String[vector.size()];
        final Enumeration<String> elements = vector.elements();
        int n = 0;
        while (elements.hasMoreElements()) {
            array[n] = elements.nextElement().trim();
            ++n;
        }
        return array;
    }

    private static String[] stringToLines(final String s) {
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
        return stringVectorToArray(vector);
    }

    public final void calculateStringSize(final String s) {
        h.stringWidth = 0;
        final String[] lines = stringToLines(s);
        for (int i = 0; i < lines.length; ++i) {
            final int stringWidth;
            if ((stringWidth = this.font.stringWidth(lines[i])) > h.stringWidth) {
                h.stringWidth = stringWidth;
            }
        }
        h.stringHeight = lines.length * this.font.getHeight();
    }

    public final void drawText(final Graphics graphics, final String text, final int x, int y, final int color, final int n3) {
        y -= 12;
        this.calculateStringSize(text);
        graphics.setColor(color);
        graphics.setFont(this.font);
        graphics.drawString(text, x, y, 0);
    }

    public final void drawTextWithFlags(final Graphics graphics, final String text, int x, int y, final int flags) {
        y -= 12;
        Label_0046:
        {
            if ((flags & 0x2B) != 0x0) {
                this.calculateStringSize(text);
                int n4;
                int xOffset;
                if ((flags & 0x8) != 0x0) {
                    n4 = x;
                    xOffset = h.stringWidth;
                } else {
                    if ((flags & 0x1) == 0x0) {
                        break Label_0046;
                    }
                    n4 = x;
                    xOffset = h.stringWidth >> 1;
                }
                x = n4 - xOffset;
            }
        }
        // The text color is white
        graphics.setColor(16777215);
        graphics.setFont(this.font);
        graphics.drawString(text, x, y, 0);
    }

    public static void setColorToWhite() {
        h.RGB = 16777215;
    }

    public static void setColor(final int RGB) {
        h.RGB = RGB;
    }

    public final int calculateTextHeight(final String s) {
        int n = 1;
        int length = s.length();
        for (int i = s.indexOf(10); i != -1; i = ((i < length - 1) ? s.indexOf(10, i + 1) : -1)) {
            ++n;
        }
        return this.font.getHeight() * n;
    }

    static {
        h.size = 0;
        h.RGB = 0;
    }
}

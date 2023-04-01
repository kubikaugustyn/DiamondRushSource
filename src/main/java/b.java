import javax.microedition.lcdui.Graphics;

// 
// Decompiled by Procyon v0.5.36
// 

public final class b
{
    public int aInt;
    public int bInt;
    private int gInt;
    private int hInt;
    public int cInt;
    public f aClassf;
    public int dInt;
    public int eInt;
    public int fInt;
    private b aClassb;
    
    public b() {
    }
    
    public b(final f aClassf, final int n, final int n2, final b b) {
        this.aInt = 0;
        this.bInt = 0;
        this.aClassf = aClassf;
        this.aClassb = null;
    }
    
    public final void aVoid(final int dInt) {
        if (dInt != this.dInt) {
            this.dInt = dInt;
            this.eInt = 0;
            this.fInt = 0;
            this.gInt = 0;
            this.hInt = 0;
        }
    }
    
    public final void aVoid() {
        final int n = (this.aClassf.aShortArr[this.dInt] + this.eInt) * 5;
        this.gInt = this.aClassf.cByteArr[n + 2];
        if ((this.cInt & 0x1) != 0x0) {
            this.gInt = -this.gInt;
        }
        this.hInt = this.aClassf.cByteArr[n + 3];
        if ((this.cInt & 0x2) != 0x0) {
            this.hInt = -this.hInt;
        }
        this.aInt += this.gInt;
        this.bInt += this.hInt;
    }
    
    public final boolean aBoolean() {
        final int a;
        return this.eInt == this.aClassf.aInt(this.dInt) - 1 && ((a = this.aClassf.aInt(this.dInt, this.eInt)) == 0 || this.fInt == a - 1);
    }
    
    public final void aVoid(final Graphics graphics) {
        if (this.aClassf == null) {
            return;
        }
        int aInt = this.aInt;
        int bInt = this.bInt;
        b b = this;
        b aClassb;
        while ((aClassb = b.aClassb) != null) {
            aInt += aClassb.aInt;
            bInt += aClassb.bInt;
            b = aClassb;
        }
        final int n = aInt;
        final int n2 = bInt;
        if (this.fInt >= 0) {
            this.aClassf.aVoid(graphics, this.dInt, this.eInt, n, n2, this.cInt, 0, 0);
            return;
        }
        if (this.dInt >= 0) {
            this.aClassf.bVoid(graphics, this.dInt, n, n2, this.cInt);
            return;
        }
        if (this.eInt >= 0) {
            this.aClassf.aVoid(graphics, this.eInt, n, n2, this.cInt);
        }
    }
    
    public final void bVoid() {
        if (this.aClassf == null) {
            return;
        }
        if (this.fInt < 0) {
            return;
        }
        final int a;
        if ((a = this.aClassf.aInt(this.dInt, this.eInt)) == 0) {
            return;
        }
        ++this.fInt;
        if (a > this.fInt) {
            return;
        }
        this.fInt = 0;
        ++this.eInt;
        if (this.eInt >= this.aClassf.aInt(this.dInt)) {
            this.eInt = 0;
            this.gInt = 0;
            this.hInt = 0;
        }
    }
}

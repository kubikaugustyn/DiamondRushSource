import javax.microedition.lcdui.Graphics;

// 
// Decompiled by Procyon v0.5.36
// 

public final class b_SpriteAnimator {
    public int x;
    public int y;
    private int crtFrameOffsetX;
    private int crtFrameOffsetY;
    public int flags;
    public f_Sprite sprite;
    public int crtAnimationI;
    public int crtAnimationFrame;
    public int crtTime;
    private b_SpriteAnimator parent;

    public b_SpriteAnimator() {
    }

    public b_SpriteAnimator(final f_Sprite sprite, final int x, final int y, final b_SpriteAnimator parent) {
        // TODO Does it really not care about the arguments?
        this.x = 0;
        this.y = 0;
        this.sprite = sprite;
        this.parent = null;
    }

    public final void setAnimation(final int animationI) {
        if (animationI != this.crtAnimationI) {
            this.crtAnimationI = animationI;
            this.crtAnimationFrame = 0;
            this.crtTime = 0;
            this.crtFrameOffsetX = 0;
            this.crtFrameOffsetY = 0;
        }
    }

    public final void applyFrameOffset() {
        final int aFIndex = (this.sprite.animationFirstAnimationFrameIndices[this.crtAnimationI] + this.crtAnimationFrame) * 5;
        this.crtFrameOffsetX = this.sprite.animationFrames[aFIndex + 2];
        if ((this.flags & f_Sprite.FLAG_FLIP_X) != 0x0) {
            this.crtFrameOffsetX = -this.crtFrameOffsetX;
        }
        this.crtFrameOffsetY = this.sprite.animationFrames[aFIndex + 3];
        if ((this.flags & f_Sprite.FLAG_FLIP_Y) != 0x0) {
            this.crtFrameOffsetY = -this.crtFrameOffsetY;
        }
        this.x += this.crtFrameOffsetX;
        this.y += this.crtFrameOffsetY;
    }

    public final boolean animationEnded() {
        // Is NOT on the last frame?
        if (this.crtAnimationFrame != this.sprite.getAnimationFrameCount(this.crtAnimationI) - 1)
            return false;

        final int time = this.sprite.getAnimationFrameTime(this.crtAnimationI, this.crtAnimationFrame);
        return (time == 0 || this.crtTime == time - 1); // Is on the last tick? (AND on the last frame)
    }

    public final void draw(final Graphics graphics) {
        if (this.sprite == null) return;

        int x = this.x;
        int y = this.y;
        b_SpriteAnimator parent = this.parent;
        while (parent != null) {
            x += parent.x;
            y += parent.y;
            parent = parent.parent;
        }

        // Used for animated sprites - draws a specific frame of an animation sequence
        // Typically used for characters, monsters, or any object that needs smooth animation
        if (this.crtTime >= 0) {
            this.sprite.drawAnimationFrame(graphics, this.crtAnimationI, this.crtAnimationFrame, x, y, this.flags, 0, 0);
            return;
        }

        // Used for simple module animations - draws a single module from sprite
        // Typically used for UI elements, icons, or simple animated graphics
        if (this.crtAnimationI >= 0) {
            this.sprite.drawModule(graphics, this.crtAnimationI, x, y, this.flags);
            return;
        }

        // Used for composite frames - draws a single frame composed of multiple modules
        // Typically used for more complex static images or background elements
        if (this.crtAnimationFrame >= 0) {
            this.sprite.drawFrame(graphics, this.crtAnimationFrame, x, y, this.flags);
        }
    }

    public final void tick() {
        if (this.sprite == null) return;
        if (this.crtTime < 0) return;

        final int time = this.sprite.getAnimationFrameTime(this.crtAnimationI, this.crtAnimationFrame);
        if (time == 0) return;

        ++this.crtTime;
        if (time > this.crtTime) return;

        // Go to the next frame
        this.crtTime = 0;
        ++this.crtAnimationFrame;
        if (this.crtAnimationFrame >= this.sprite.getAnimationFrameCount(this.crtAnimationI)) {
            // Loop back to the beginning
            this.crtAnimationFrame = 0;
            this.crtFrameOffsetX = 0;
            this.crtFrameOffsetY = 0;
        }
    }
}

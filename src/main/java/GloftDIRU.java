import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

// 
// Decompiled by Procyon v0.5.36
// 

public final class GloftDIRU extends MIDlet {
    public static byte[] midletVersionBytes;
    private i game;
    public Display display;
    public static String url;

    public GloftDIRU() {
        GloftDIRU.midletVersionBytes = this.getAppProperty("MIDlet-Version").getBytes();
        this.game = new i(this);
    }

    public final void startApp() {
        if (this.display == null) {
            this.display = Display.getDisplay((MIDlet) this);
        }
        this.display.setCurrent((Displayable) this.game);
        this.game.dVoid();
    }

    public final void pauseApp() {
        this.game.cVoid();
        this.notifyPaused();
    }

    public final void destroyApp(final boolean b) {
        if (GloftDIRU.url != null) {
            try {
                this.platformRequest(GloftDIRU.url);
            } catch (Exception ex) {
            }
        }
        this.notifyDestroyed();
    }

    public final void aVoid() {
        i.bVoid();
        this.game.aClassj.dVoid();
//        try {
        this.destroyApp(true);
//        }
//        catch (MIDletStateChangeException ex) {}
    }

    static {
        GloftDIRU.midletVersionBytes = null;
        GloftDIRU.url = null;
    }
}

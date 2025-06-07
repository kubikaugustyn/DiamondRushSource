// 
// Decompiled by Procyon v0.5.36
// 

public final class k extends Thread
{
    private final String url;
    
    public k(final String url) {
        this.url = url;
    }
    
    public final void run() {
        boolean runningOnPlatformRequest;
        try {
            runningOnPlatformRequest = i.aClassGloftDIRU.getAppProperty("APP-RUNNING-ON-PLATFORMREQUEST").trim().equals("0");
        }
        catch (Exception ex) {
            runningOnPlatformRequest = false;
        }
        try {
            if (runningOnPlatformRequest) {
                GloftDIRU.url = this.url;
                i.bByte = 3;
                return;
            }
            i.aClassGloftDIRU.platformRequest(this.url);
        }
        catch (Exception ex2) {
            GloftDIRU.url = this.url;
        }
    }
}

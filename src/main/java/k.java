// 
// Decompiled by Procyon v0.5.36
// 

public final class k extends Thread
{
    private final String aClassString;
    
    public k(final String aClassString) {
        this.aClassString = aClassString;
    }
    
    public final void runVoid() {
        boolean equals;
        try {
            equals = i.aClassGloftDIRU.getAppProperty("APP-RUNNING-ON-PLATFORMREQUEST").trim().equals("0");
        }
        catch (Exception ex) {
            equals = false;
        }
        try {
            if (equals) {
                GloftDIRU.aClassString = this.aClassString;
                i.bByte = 3;
                return;
            }
            i.aClassGloftDIRU.platformRequest(this.aClassString);
        }
        catch (Exception ex2) {
            GloftDIRU.aClassString = this.aClassString;
        }
    }
}

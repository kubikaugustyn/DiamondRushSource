import java.util.Random;

// 
// Decompiled by Procyon v0.5.36
// 

public final class e
{
    private static Random aClassRandom;
    
    public static int aInt(final int n, final int n2) {
        return n + Math.abs(e.aClassRandom.nextInt()) % (n2 - n);
    }
    
    static {
        e.aClassRandom = new Random(System.currentTimeMillis());
    }
}

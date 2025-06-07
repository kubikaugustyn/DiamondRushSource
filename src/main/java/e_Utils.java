import java.util.Random;

// 
// Decompiled by Procyon v0.5.36
// 

public final class e_Utils
{
    private static Random random;

    /**
     * Generates a random integer within the specified range [min, max).
     *
     * @param min the inclusive lower bound of the random number range
     * @param max the exclusive upper bound of the random number range
     * @return a random integer between min (inclusive) and max (exclusive)
     */
    public static int getRandomInt(final int min, final int max) {
        return min + Math.abs(e_Utils.random.nextInt()) % (max - min);
    }
    
    static {
        e_Utils.random = new Random(System.currentTimeMillis());
    }
}

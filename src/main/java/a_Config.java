// 
// Decompiled by Procyon v0.5.36
// 

public interface a_Config {
    public static final int aInt = new h(0).font.getHeight();
    public static final int bInt = aInt;
    /**
     * The prices for the individual jackets in the shop in violet gems
     */
    public static final int[] itemPrices = {150, 400, 1000, 3000};
    /**
     * The prices to access the different worlds in red gems
     */
    public static final int[] worldPrices = {0, 10, 25};
    /**
     * 1D {x, y} for every seal position (array)
     */
    public static final int[] sealItemPosOffsets = {
            -24, -23,
            24, -23,
            0, 23,
            24, 23
    };
    /**
     * 1D {x, y} for every seal position (array)
     */
    public static final int[] sealArrowPosOffsets = {
            -33, -54,
            14, -54,
            -8, -8,
            22, 2
    };
    /**
     * A target position for every seal position (2D array - arr[movement direction][current position])
     */
    public static final byte[][] sealMoveDirections = {
            // @formatter:off
            // From: {ANGKOR=0, BAVARIA=1, SIBERIA=2, SHOP=3}
            // A, B, SI, SH}
            {-1, -1,  0, -1}, // Targets for UP movement
            { 1, -1,  3, -1}, // Targets for RIGHT movement
            { 2,  2, -1, -1}, // Targets for DOWN movement
            {-1,  0, -1,  2}  // Targets for LEFT movement
            // @formatter:on
    };
    public static final int cInt = 240 - a_Config.aInt - 10;
    public static final int dInt = a_Config.aInt + 1;
    public static final int eInt = 310 - a_Config.aInt + 6;
    public static final int fInt = a_Config.aInt + 6;
    public static final int gInt = 69 - a_Config.fInt;
    public static final int hInt = a_Config.aInt + 4;
    public static final int iInt = a_Config.gInt + a_Config.fInt / 2;
}

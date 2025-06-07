import javax.microedition.lcdui.Displayable;
import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import java.io.InputStream;
import javax.microedition.lcdui.Canvas;

// 
// Decompiled by Procyon v0.5.36
// 

public final class i extends Canvas implements Runnable {
    // ADDED START
    public static final int SKEY_UP = 1;
    public static final int SKEY_DOWN = 2;
    public static final int SKEY_LEFT = 4;
    public static final int SKEY_RIGHT = 8;
    public static final int SKEY_CENTER = 16;
    public static final int SKEY_LSH = 32;
    public static final int SKEY_RSH = 64;
    public static final int SKEY_CENTER_ALT = 128; //Center key for Motorola devices
    public static final int SKEY_STAR = 256;
    public static final int SKEY_POUND = 512;
    public static final int SKEY_NUM0 = 1024;
    public static final int SKEY_NUM1 = 2048;
    public static final int SKEY_NUM2 = 4096;
    public static final int SKEY_NUM3 = 8192;
    public static final int SKEY_NUM4 = 16384;
    public static final int SKEY_NUM5 = 32768;
    public static final int SKEY_NUM6 = 65536;
    public static final int SKEY_NUM7 = 131072;
    public static final int SKEY_NUM8 = 262144;
    public static final int SKEY_NUM9 = 524288;

    public static final int KEY_ANY_OK = 32944;//SKEY_NUM5 | SKEY_CENTER_ALT | SKEY_CENTER | SKEY_LSH;
    public static final int KEY_OK = 32784;//SKEY_NUM5 | SKEY_CENTER;
    public static final int KEY_CANCEL = 64;//SKEY_RSH;
    public static final int KEY_RESPAWN = 256;//SKEY_STAR;
    public static final int KEY_UP = 4097;//SKEY_NUM2 | SKEY_UP;
    public static final int KEY_DOWN = 262146;//SKEY_NUM8 | SKEY_DOWN;
    public static final int KEY_LEFT = 16388;//SKEY_NUM4 | SKEY_LEFT;
    public static final int KEY_RIGHT = 65544;//SKEY_NUM6 | SKEY_RIGHT;

    public static final int SEAL_POS_ANGKOR = 0;
    public static final int SEAL_POS_BAVARIA = 1;
    public static final int SEAL_POS_SIBERIA = 2;
    public static final int SEAL_POS_SHOP = 3;

    public static final int SEAL_MOVE_NOOP = -1;
    public static final int SEAL_MOVE_UP = 0;
    public static final int SEAL_MOVE_RIGHT = 1;
    public static final int SEAL_MOVE_DOWN = 2;
    public static final int SEAL_MOVE_LEFT = 3;
    public static final int SEAL_MOVE_OK = 4;

    public static final int STAGE_ANGKOR_FALLING_TORCHES = 5;
    public static final int STAGE_ANGKOR_GREAT_ANACONDA = 8;
    public static final int STAGE_ANGKOR_DEMO = 13;
    public static final int STAGE_BAVARIA_EVIL_TEUTONIC_KNIGHT = 9;
    public static final int STAGE_SIBERIA_YETTI = 10;
    // ADDED END

    private int lInt;
    private int mInt;
    private boolean cBoolean;
    private boolean dBoolean;
    private int nInt;
    private int oInt;
    private String aClassString;
    private boolean eBoolean;
    /**
     * The current position of the arrow on the seal.<br>
     * 0=Angkor, 1=Bavaria, 2=Siberia, 3=Shop<br>
     * Enum: SEAL_POS_*
     */
    private int crtSealPosition;
    private int qInt;
    private int rInt;
    private int sInt;
    private int tInt;
    private String bClassString;
    private String cClassString;
    /**
     * The current movement of the arrow on the seal.<br>
     * -1=NOOP, 0=UP, 1=RIGHT, 2=DOWN, 3=LEFT, 4=OK=Enter<br>
     * Enum: SEAL_MOVE_*
     */
    private int crtSealMoveDirection;
    private boolean fBoolean;
    private boolean gBoolean;
    private byte cByte;
    private int crtSealArrowOffsetX;
    private int crtSealArrowOffsetY;
    private int xInt;
    private int yInt;
    private int zInt;
    private int AInt;
    private int BInt;
    private static boolean[] aBooleanArr;
    private int CInt;
    private static boolean[] bBooleanArr;
    private boolean hBoolean;
    private int DInt;
    private int EInt;
    private int FInt;
    private int GInt;
    private int HInt;
    private int IInt;
    private int JInt;
    private int KInt;
    private boolean iBoolean;
    private int LInt;
    private int MInt;
    private int NInt;
    private int OInt;
    private int PInt;
    private int QInt;
    private int RInt;
    private int SInt;
    private boolean jBoolean;
    private boolean kBoolean;
    private int TInt;
    private int UInt;
    private int VInt;
    private int WInt;
    private int XInt;
    private int YInt;
    private int ZInt;
    private byte dByte;
    private byte eByte;
    private byte fByte;
    private byte gByte;
    private byte hByte;
    private byte iByte;
    private boolean lBoolean;
    private int aaInt;
    private int abInt;
    private int acInt;
    private static byte[] aByteArr;
    private static byte[] bByteArr;
    private static byte[] cByteArr;
    private int adInt;
    private int aeInt;
    private byte jByte;
    private static boolean mBoolean;
    private int afInt;
    private int agInt;
    private static int keysPressed;
    private boolean nBoolean;
    private boolean oBoolean;
    private int aiInt;
    private int ajInt;
    private static byte[] dByteArr;
    private byte kByte;
    private int akInt;
    private int alInt;
    private int amInt;
    private int anInt;
    private boolean pBoolean;
    private int aoInt;
    private int apInt;
    private int aqInt;
    private int arInt;
    private int asInt;
    private int atInt;
    private boolean qBoolean;
    private boolean rBoolean;
    private boolean sBoolean;
    private boolean tBoolean;
    private int auInt;
    private int avInt;
    private static byte[] eByteArr;
    private int awInt;
    private int axInt;
    private int ayInt;
    public byte aByte;
    private byte lByte;
    private int azInt;
    /**
     * The current world index the game cares about.<br>
     * 0=Angkor, 1=Bavaria, 2=Siberia<br>
     * Enum: TODO
     */
    private int crtWorldIndex;
    /**
     * The current stage index the game is loading/in/etc.<br>
     * Should be a positive number.<br>
     * Enum for special stages: STAGE_*
     */
    private int crtStageI;
    public int aInt;
    public int bInt;
    public int cInt;
    public int dInt;
    public int crtStageWidth;
    public int crtStageHeight;
    private int aCInt;
    private int aDInt;
    private int aEInt;
    private int aFInt;
    private int aGInt;
    private int aHInt;
    private int aIInt;
    private int aJInt;
    private int aKInt;
    private int aLInt;
    private int aMInt;
    private int aNInt;
    private int aOInt;
    private int aPInt;
    private int aQInt;
    public static byte bByte;
    private int aRInt;
    private static byte mByte;
    private boolean uBoolean;
    private static int aSInt;
    public static int gInt;
    private long aLong;
    private boolean vBoolean;
    public int crtPlayerX;
    public int crtPlayerY;
    public int jInt;
    public int kInt;
    private int aTInt;
    private boolean shouldSaveCheckpoint;
    private int aUInt;
    private int aVInt;
    private boolean xBoolean;
    private byte nByte;
    private int aWInt;
    private long bLong;
    private int aXInt;
    private int aYInt;
    private int aZInt;
    private int baInt;
    private int bbInt;
    private int bcInt;
    private int bdInt;
    private int beInt;
    private int bfInt;
    private byte oByte;
    private int bgInt;
    private int bhInt;
    private int biInt;
    private int bjInt;
    private int bkInt;
    private int blInt;
    private int bmInt;
    private boolean yBoolean;
    private int bnInt;
    private boolean zBoolean;
    private int boInt;
    private int bpInt;
    private int bqInt;
    private int brInt;
    private int bsInt;
    private int crtGenFileI;
    private int buInt;
    private int bvInt;
    private int bwInt;
    private int bxInt;
    private int byInt;
    private int bzInt;
    private int bAInt;
    private int bBInt;
    private int bCInt;
    private boolean ABoolean;
    private int bDInt;
    private int bEInt;
    private int bFInt;
    private int bGInt;
    private int bHInt;
    private int bIInt;
    private int bJInt;
    private int bKInt;
    private int bLInt;
    private int bMInt;
    private int bNInt;
    private int bOInt;
    private int bPInt;
    private int bQInt;
    private int bRInt;
    private int bSInt;
    private int bTInt;
    private int bUInt;
    private int bVInt;
    private int bWInt;
    private int bXInt;
    private int bYInt;
    private int bZInt;
    private int caInt;
    private int cbInt;
    private boolean BBoolean;
    private int ccInt;
    private int cdInt;
    private InputStream tmpInputStream;
    private byte pByte;
    private byte qByte;
    private boolean CBoolean;
    private int ceInt;
    private int cfInt;
    private int cgInt;
    private int chInt;
    private Graphics aClassGraphics;
    private static Image splashLogoImage;
    private static Image splashBgGradientImage;
    private static Image splashCopyrightImage;
    private static Image[][] textures;
    public static Image[][] demoUITextures;
    public static f_Sprite[] aClassfArr;
    private static h textSize0;
    public static h textSize8;
    private static f_Sprite aClassf;
    private static byte[] fByteArr;
    private static b_SpriteAnimator[] aClassbArr;
    private static f_Sprite bClassf;
    private static byte[] gByteArr;
    private static byte[] hByteArr;
    private long cLong;
    private long dLong;
    private boolean DBoolean;
    private static byte[] iByteArr;
    private static byte[] jByteArr;
    public static int[][] crtStageForegrondLayer;
    public static int[][] bIntArrArr;
    private static byte[][] crtStagePlayerLayer;
    private static byte[][] bByteArrArr;
    private static byte[][] cByteArrArr;
    private static byte[] kByteArr;
    private boolean EBoolean;
    private int ciInt;
    private int cjInt;
    private int ckInt;
    private int clInt;
    private static byte[] lByteArr;
    private static byte[] mByteArr;
    private static int cmInt;
    private static int cnInt;
    private static byte[] tmpBytes;
    private static int[][] cIntArrArr;
    private static int[][] dIntArrArr;
    private static byte[][] dByteArrArr;
    private static byte[][] eByteArrArr;
    private static byte[] oByteArr;
    public final j_SoundManager aClassj;
    private c aClassc;
    private static c[] aClasscArr;
    private static byte[] pByteArr;
    private Thread aClassThread;
    public static GloftDIRU aClassGloftDIRU;
    private int coInt;
    private int cpInt;
    private int cqInt;
    private int crInt;
    private int csInt;
    private static f_Sprite cClassf;
    private int ctInt;
    private byte rByte;
    public static boolean aBoolean;
    private static String moreGamesUrl;
    private long eLong;
    private long fLong;
    private boolean FBoolean;
    private boolean GBoolean;
    private boolean HBoolean;
    private boolean IBoolean;
    private boolean JBoolean;
    private boolean KBoolean;
    private boolean LBoolean;
    private boolean MBoolean;
    private boolean NBoolean;
    private int crtHeroPalette;
    private int cvInt;
    private int cwInt;
    private boolean OBoolean;
    private boolean PBoolean;
    private int cxInt;
    private int cyInt;
    private boolean QBoolean;
    private boolean RBoolean;
    private int czInt;
    private int cAInt;
    private boolean SBoolean;
    private boolean TBoolean;
    private int cBInt;
    private static Image dClassImage;
    private static Graphics bClassGraphics;
    private static int cCInt;
    private static int cDInt;
    private static int cEInt;
    private static int cFInt;
    private static int cGInt;
    private static int cHInt;
    private int cIInt;
    private int cJInt;
    private int cKInt;
    private int cLInt;
    private static Image eClassImage;
    private static int cMInt;
    private static int cNInt;
    private static int cOInt;
    private int cPInt;
    private int cQInt;
    private int cRInt;
    private int cSInt;
    private int cTInt;
    private int cUInt;
    private int cVInt;
    private boolean UBoolean;
    private int cWInt;
    private int cXInt;
    private int cYInt;
    private int cZInt;
    private int daInt;
    private int dbInt;
    private long gLong;
    private int dcInt;
    private static boolean VBoolean;
    private static boolean WBoolean;
    private long hLong;
    private boolean XBoolean;
    private boolean YBoolean;
    private boolean ZBoolean;
    private boolean aaBoolean;
    private boolean abBoolean;
    private int ddInt;
    private int[] aIntArr;
    private static byte crtCheatPageKeyCodeIndex;
    private static int[] cheatPageKeyCode;
    private static int deInt;
    private static int dfInt;
    private static int dgInt;
    private byte tByte;
    private byte uByte;
    private boolean acBoolean;
    private static byte[] crtStageDoorXs;
    private static byte[] crtStageDoorYs;
    private long iLong;
    private boolean adBoolean;
    private int dhInt;
    private boolean aeBoolean;
    private long jLong;
    private long kLong;
    private boolean afBoolean;
    private long lLong;
    private boolean crtShouldLoadWaterBreathingPotion;
    private boolean ahBoolean;
    private boolean crtShouldLoadFanPot;
    private boolean ajBoolean;
    private String eClassString;
    private int diInt;
    private int djInt;
    private int dkInt;
    private int dlInt;
    private static boolean akBoolean;
    private static int dmInt;
    private static int dnInt;
    private static int doInt;
    private static int dpInt;
    private boolean alBoolean;
    private int dqInt;
    private int drInt;
    private int dsInt;
    private byte vByte;
    private int dtInt;
    private int duInt;
    private int dvInt;
    private int dwInt;
    private int dxInt;
    private byte wByte;
    private int dyInt;
    private int dzInt;
    private byte xByte;
    private byte yByte;
    private int dAInt;
    private int dBInt;
    private int dCInt;
    private byte zByte;
    private int dDInt;
    private int dEInt;
    private int dFInt;
    private byte AByte;
    private int dGInt;
    private int dHInt;
    private static f_Sprite dClassf;
    private static int[][] eIntArrArr;
    private static long[] aLongArr;
    private static long[] bLongArr;
    private static int[][] fIntArrArr;
    private static long[] cLongArr;
    private static long[] dLongArr;
    private static boolean amBoolean;
    private int dIInt;
    private int dJInt;
    private static String fClassString;
    private static long[][] aLongArrArr;
    private static StringBuffer aClassStringBuffer;
    private static StringBuffer bClassStringBuffer;
    private static StringBuffer crtWorldMapFileName;
    private static Image fClassImage;
    private static Graphics cClassGraphics;
    private int dKInt;
    private int dLInt;
    private int dMInt;
    private int dNInt;
    private int dOInt;
    private int dPInt;
    private int dQInt;
    private int dRInt;
    private int dSInt;
    private int dTInt;
    private int dUInt;
    private boolean anBoolean;
    private boolean aoBoolean;
    private int dVInt;
    private int dWInt;
    private int dXInt;
    private int dYInt;
    private static int dZInt;
    private int eaInt;
    private int ebInt;
    private int ecInt;
    private int edInt;
    private int eeInt;
    private int efInt;
    private int egInt;
    private int ehInt;
    private boolean apBoolean;
    private boolean aqBoolean;
    private boolean arBoolean;
    private int[] cIntArr;
    private int eiInt;
    private int ejInt;
    private int ekInt;
    private int elInt;
    private int emInt;
    private boolean asBoolean;
    private boolean atBoolean;
    private boolean auBoolean;
    private long mLong;
    private int enInt;
    private String gClassString;
    private StringBuffer dClassStringBuffer;
    private boolean avBoolean;
    private boolean awBoolean;
    private int eoInt;
    private int epInt;
    private static short[][] aShortArrArr;
    private static int[] dIntArr;
    private static int[][] gIntArrArr;
    private static String[] stageTitles;
    public static String[] texts; // Loaded from lang.xx or other files
    public static String[] demoTextMapping;
    public static boolean bBoolean;
    private static byte[] sByteArr;
    private static String[] worldFiles;
    private static int eqInt;
    private long nLong;
    private String hClassString;
    private int erInt;
    private int esInt;
    private int etInt;
    private int euInt;

    public i(final GloftDIRU aClassGloftDIRU) {
        this.lInt = 40;
        this.cBoolean = false;
        this.nInt = 0;
        this.oInt = a_Config.itemPrices[this.nInt];
        this.aClassString = "";
        this.eBoolean = true;
        this.crtSealPosition = SEAL_POS_ANGKOR;
        this.qInt = 0;
        this.rInt = 0;
        this.sInt = this.qInt;
        this.tInt = this.rInt;
        this.bClassString = "";
        this.cClassString = "";
        this.crtSealMoveDirection = SEAL_MOVE_NOOP;
        this.fBoolean = false;
        this.gBoolean = true;
        this.cByte = 0;
        this.crtSealArrowOffsetX = 0;
        this.crtSealArrowOffsetY = 0;
        this.xInt = 0;
        this.yInt = 0;
        this.zInt = 0;
        this.AInt = 0;
        this.BInt = 0;
        this.CInt = 0;
        this.hBoolean = false;
        this.DInt = -1;
        this.EInt = 10;
        this.FInt = 10;
        this.GInt = 0;
        this.HInt = 0;
        this.IInt = 0;
        this.JInt = 0;
        this.KInt = 0;
        this.iBoolean = false;
        this.LInt = 0;
        this.MInt = -1;
        this.NInt = -1;
        this.OInt = 0;
        this.PInt = 0;
        this.QInt = 0;
        this.RInt = 0;
        this.SInt = 0;
        this.jBoolean = false;
        this.kBoolean = false;
        this.TInt = 0;
        this.UInt = 0;
        this.VInt = 0;
        this.WInt = 0;
        this.XInt = 0;
        this.YInt = 0;
        this.ZInt = 0;
        this.dByte = 1;
        this.eByte = 1;
        this.fByte = 3;
        this.gByte = 3;
        this.hByte = 2;
        this.iByte = 0;
        this.lBoolean = false;
        this.agInt = 0;
        this.nBoolean = true;
        this.kByte = 0;
        this.akInt = 0;
        this.qBoolean = false;
        this.rBoolean = false;
        this.sBoolean = false;
        this.tBoolean = false;
        this.aByte = 0;
        this.lByte = 0;
        this.uBoolean = false;
        this.aYInt = 0;
        this.baInt = 0;
        this.bmInt = -1;
        this.bDInt = 0;
        this.bWInt = 0;
        this.bXInt = 0;
        this.bYInt = 0;
        this.bZInt = 0;
        this.caInt = 0;
        this.cbInt = 0;
        this.CBoolean = false;
        this.DBoolean = false;
        this.aClassc = null;
        this.coInt = -1;
        this.cpInt = -1;
        this.rByte = 0;
        this.FBoolean = false;
        this.GBoolean = false;
        this.HBoolean = false;
        this.IBoolean = false;
        this.JBoolean = false;
        this.KBoolean = false;
        this.LBoolean = false;
        this.MBoolean = false;
        this.NBoolean = false;
        this.crtHeroPalette = -1;
        this.PBoolean = false;
        this.QBoolean = false;
        this.RBoolean = false;
        this.cPInt = -1;
        this.cQInt = -1;
        this.cRInt = -1;
        this.cSInt = -1;
        this.cTInt = -1;
        this.cUInt = -1;
        this.cVInt = -1;
        this.UBoolean = true;
        this.daInt = 3;
        this.dbInt = -1;
        this.gLong = 0L;
        this.dcInt = -1;
        this.hLong = 0L;
        this.abBoolean = false;
        this.ddInt = 0;
        this.aIntArr = new int[]{0, 0, 0, 0, 0};
        this.acBoolean = false;
        this.iLong = 0L;
        this.dhInt = 0;
        this.jLong = 0L;
        this.kLong = 0L;
        this.afBoolean = false;
        this.ajBoolean = false;
        this.diInt = 0;
        this.alBoolean = true;
        this.dqInt = -1;
        this.dzInt = -1;
        this.xByte = 3;
        this.dKInt = 100;
        this.anBoolean = true;
        this.apBoolean = true;
        this.aqBoolean = true;
        this.arBoolean = true;
        this.ekInt = 2;
        this.emInt = 2;
        this.atBoolean = true;
        this.auBoolean = true;
        this.mLong = 0L;
        this.enInt = -1;
        this.dClassStringBuffer = new StringBuffer();
        this.avBoolean = true;
        this.awBoolean = true;
        this.nLong = System.currentTimeMillis();
        this.aDInt = -1;
        this.aFInt = -1;
        this.aHInt = -1;
        i.aClassbArr = new b_SpriteAnimator[6];
        i.aClassfArr = new f_Sprite[61];
        if (f_Sprite._unused_mcContents == null) {
            final InputStream resourceAsStream = this.getClass().getResourceAsStream("/mc");
            f_Sprite._unused_mcContents = new byte[256];
            try {
                resourceAsStream.read(f_Sprite._unused_mcContents);
                resourceAsStream.close();
            } catch (Exception ex) {
            }
        }
        i.textures = new Image[33][];
        i.demoUITextures = new Image[2][];
        i.aClassGloftDIRU = aClassGloftDIRU;
        this.aClassj = new j_SoundManager();
        this.setFullScreenMode(true);
        this.oBoolean = true;
        i.mBoolean = true;
        i.moreGamesUrl = i.aClassGloftDIRU.getAppProperty(i.moreGamesUrl);
        (this.aClassThread = new Thread(this)).start();
        short[] array;
        int n;
        if (!getMoreGamesEnabled()) {
            (i.aShortArrArr[0] = new short[8])[0] = 0;
            i.aShortArrArr[0][1] = 16;
            i.aShortArrArr[0][2] = 1;
            i.aShortArrArr[0][3] = 40;
            i.aShortArrArr[0][4] = 3;
            i.aShortArrArr[0][5] = 18;
            i.aShortArrArr[0][6] = 5;
            array = i.aShortArrArr[0];
            n = 7;
        } else {
            (i.aShortArrArr[0] = new short[10])[0] = 0;
            i.aShortArrArr[0][1] = 16;
            i.aShortArrArr[0][2] = 1;
            i.aShortArrArr[0][3] = 40;
            i.aShortArrArr[0][4] = 6;
            i.aShortArrArr[0][5] = 44;
            i.aShortArrArr[0][6] = 3;
            i.aShortArrArr[0][7] = 18;
            i.aShortArrArr[0][8] = 5;
            array = i.aShortArrArr[0];
            n = 9;
        }
        array[n] = 22;
    }

    private void hurtHero(int n, int hInt, final int n2) {
        this.aFInt = -1;
        this.aIInt = -1;
        this.aHInt = -1;
        final int dInt = i.aClassbArr[((this.kInt & 0x4000) == 0x0) ? 0 : 3].crtAnimationI;
        if (dInt == 40) return;
        if (dInt == 48) return;
        if (dInt == 47) return;
        if ((this.bLong <= 0L && this.aWInt == 0 && this.biInt == 0 && this.lByte != 6 && (this.kInt & 0x70) == 0x0) || this.aTInt > 0) {
            ++this.bcInt;
            this.aVoid((byte) (this.nByte - n));
            if (this.blInt == 0 && this.nByte == 0) {
                this.jLong = 0L;
                this.coInt = this.bEInt;
                this.cpInt = this.bFInt;
                i.cClassf = null;
            }
            this.kInt = ((this.kInt & 0xFFFFFF8F) | hInt);
            this.playSound(j_SoundManager.SOUND_SFX_HERO_HURT);
            switch (hInt) {
                case 16: {
                    final int n3 = 0;
                    this.avInt = n3;
                    this.auInt = n3;
                    this.aTInt = 5;
                    i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY] = 9;
                    this.kInt &= 0xFFFFFF8F;
                    i.bIntArrArr[this.crtPlayerX][this.crtPlayerY] = 138412032;
                    i.cByteArrArr[this.crtPlayerX][this.crtPlayerY] = 24;
                }
                case 64: {
                    this.gVoid(1000);
                }
                default: {
                    this.gVoid(10);
                    if (n2 != 0) {
                        n = (byte) n2;
                        do {
                            hInt = this.crtPlayerX - i.gByteArr[n];
                            final int iInt = this.crtPlayerY - i.gByteArr[n + 8];
                            if (i.crtStagePlayerLayer[hInt][iInt] < 0 && (byte) i.crtStageForegrondLayer[hInt][iInt] < 0) {
                                this.crtPlayerX = hInt;
                                this.crtPlayerY = iInt;
                                this.jInt = 18;
                                this.aByte = 0;
                                this.kInt = ((this.kInt & 0xFFFFFFF8) | n | 0x800);
                                return;
                            }
                        } while ((n = ((n >= 4) ? 1 : ((byte) (n + 1)))) != n2);
                        break;
                    }
                    break;
                }
            }
        }
    }

    private void aVoid(final byte nByte) {
        this.nByte = nByte;
        Label_0040:
        {
            byte nByte2;
            if (this.nByte <= 0) {
                nByte2 = 0;
            } else {
                if (this.nByte <= iByteArr[8]) {
                    break Label_0040;
                }
                nByte2 = iByteArr[8];
            }
            this.nByte = nByte2;
        }
        this.oBoolean = true;
    }

    private void aVoid(int iInteger) {
        this.bpInt = this.boInt;
        this.zBoolean = false;
        this.bqInt = 0;
        this.boInt = iInteger;
        this.cWInt = 0;
        if (iInteger >= 0) {
            this.cXInt = i.aShortArrArr[this.boInt].length >> 1;
            this.cYInt = 0;
            int aInt;
            for (iInteger = 0; iInteger < this.cXInt; ++iInteger) {
                aInt = aInt(i.textSize0, i.texts[i.aShortArrArr[this.boInt][(iInteger << 1) + 1]], 0);
                if ((this.boInt != 0 || iInteger != 3) && aInt > this.cYInt) {
                    this.cYInt = aInt;
                }
            }
            this.cZInt = 0;
            this.cWInt = 0;
        }
    }

    private static boolean isKeyPressed(final int keys) {
        return (i.keysPressed & keys) != 0x0;
    }

    public final void keyPressed(int keyCode) {
        keyCode = getKeyFromKeyCode(keyCode);
        i.keysPressed |= keyCode;
        this.dBoolean = false;
    }

    public final void keyReleased(final int keyCode) {
        i.keysPressed &= ~getKeyFromKeyCode(keyCode);
        this.dBoolean = true;
    }

    private void eVoid() {
        this.aLong = System.currentTimeMillis();
        i.aSInt = 0;
        i.gInt = 0;
        this.akInt = 0;
    }

    private static void sleep(final long millis) {
        if (millis <= 0L) {
            return;
        }
        System.currentTimeMillis();
        try {
            Thread.sleep(millis);
        } catch (Exception ex) {
        }
    }

    public final void run() {
        this.aLong = System.currentTimeMillis();
        this.eVoid();
        RecordStore recordStore = null;
        try {
            try {
                recordStore = RecordStore.openRecordStore("Preferences", false);
            } catch (Exception obj) {
                System.out.println("Exception " + obj);
            }
            i.jByteArr = new byte[1];
            if (recordStore == null) {
                try {
                    recordStore = RecordStore.openRecordStore("Preferences", true);
                    i.jByteArr[0] = 0;
                    this.cvInt = i.jByteArr.length;
                    recordStore.closeRecordStore();
                    this.vVoid();
                } catch (Exception ex2) {
                }
            } else {
                try {
                    i.jByteArr = recordStore.getRecord(1);
                    this.cvInt = i.jByteArr.length;
                    recordStore.closeRecordStore();
                    recordStore = null;
                } catch (Exception ex3) {
                }
            }
        } finally {
            try {
                if (recordStore != null) {
                    recordStore.closeRecordStore();
                }
            } catch (Exception ex4) {
            }
        }
        while (!this.BBoolean) {
            if (!this.afBoolean) {
                this.eLong = System.currentTimeMillis();
                try {
                    this.handleKeyPresses();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    sleep(5000L);
                }
                if (this.BBoolean) break;
                if (bByte != 2) ++i.aSInt;
                System.currentTimeMillis();
                if (this.fLong > 65L) {
                    this.vBoolean = true;
                    this.fLong = 0L;
                } else {
                    this.repaint();
                    this.vBoolean = false;
                    if (bByte != 2) {
                        ++gInt;
                    }
                    this.fLong = Math.abs(System.currentTimeMillis() - this.eLong);
                    sleep(50L - (System.currentTimeMillis() - this.eLong));
                }
            }
        }
        this.pVoid();
        this.aClassj.dVoid();
        aClassGloftDIRU.aVoid();
    }

    private void handleKeyPresses() {
        if (i.eqInt > 0) {
            i.eqInt -= (int) (System.currentTimeMillis() - this.nLong);
            this.nLong = System.currentTimeMillis();
            if (i.eqInt <= 0) {
                this.dVoid(true);
            }
        }
        if (i.keysPressed == 0) {
            this.aByte = 0;
        } else if (i.eqInt > 0) {
            this.dVoid(true);
            i.keysPressed = 0;
        } else {
            Label_4240:
            {
                int ahInt = 0;
                Label_4237:
                {
                    Label_4236:
                    {
                        switch (i.bByte) {
                            case 33: {
                                if (isKeyPressed(64)) {
                                    if (this.boInt == 0) {
                                        i.bByte = 4;
                                        this.aVoid(0);
                                    }
                                    if (this.boInt == 1) {
                                        i.bByte = 2;
                                        i.VBoolean = true;
                                        this.oBoolean = true;
                                        this.aVoid(1);
                                    }
                                }
                                break Label_4240;
                            }
                            case 26: {
                                if (isKeyPressed(64)) {
                                    i.bByte = 4;
                                    this.aVoid(4);
                                }
                                ahInt = 0;
                                break Label_4237;
                            }
                            case 18: {
                                break Label_4240;
                            }
                            case 25: {
                                this.PVoid();
                                break Label_4240;
                            }
                            case 24: {
                                boolean b = false;
                                Label_0795:
                                {
                                    if (isKeyPressed(512)) {
                                        this.abBoolean = !this.abBoolean;
                                    } else if (isKeyPressed(65536)) {
                                        this.aZInt += 50;
                                    } else if (isKeyPressed(131072)) {
                                        this.bbInt += 5;
                                    } else if (isKeyPressed(262144)) {
                                        if (i.mByte != 1) {
                                            this.cAInt <<= 1;
                                            Label_0454:
                                            {
                                                i i;
                                                int caInt;
                                                if (this.cAInt == 0) {
                                                    i = this;
                                                    caInt = 1;
                                                } else {
                                                    if (this.cAInt <= 8) {
                                                        break Label_0454;
                                                    }
                                                    i = this;
                                                    caInt = 0;
                                                }
                                                i.cAInt = caInt;
                                            }
                                            if (this.cAInt > 2) {
                                                i.iByteArr[10] = 1;
                                            } else {
                                                i.iByteArr[10] = 0;
                                            }
                                        }
                                    } else if (isKeyPressed(524288)) {
                                        this.SBoolean = !this.SBoolean;
                                    } else if (isKeyPressed(1024)) {
                                        this.TBoolean = !this.TBoolean;
                                    } else {
                                        if (!isKeyPressed(64)) {
                                            if (!isKeyPressed(32944)) {
                                                break Label_0795;
                                            }
                                            i.iByteArr[8] = (byte) this.czInt;
                                            i.iByteArr[9] = (byte) this.cAInt;
                                            if (this.SBoolean || this.TBoolean) {
                                                for (int j = 0; j <= 2; ++j) {
                                                    int eInt = eInt(j);
                                                    if (j == 2) {
                                                        ++eInt;
                                                    }
                                                    for (int k = 0; k <= eInt; ++k) {
                                                        this.aVoid(j, k, (byte) 2);
                                                        this.aVoid(j, k, (byte) 64);
                                                    }
                                                    aVoid(j, eInt);
                                                }
                                                if (this.TBoolean) {
                                                    for (int l = 0; l <= 2; ++l) {
                                                        int dInt = dInt(l);
                                                        if (l == 0) {
                                                            --dInt;
                                                        }
                                                        for (int eInt2 = eInt(l); eInt2 < dInt; ++eInt2) {
                                                            this.aVoid(l, eInt2, (byte) 2);
                                                            this.aVoid(l, eInt2, (byte) 64);
                                                        }
                                                        aVoid(l, dInt - 1);
                                                    }
                                                }
                                            }
                                            this.bInt();
                                            eInt(6, this.bbInt);
                                            this.uVoid();
                                        }
                                        b = true;
                                        this.aClassGraphics.setColor(0);
                                        this.aClassGraphics.fillRect(0, 0, 240, 320);
                                    }
                                }
                                if (b) {
                                    this.SVoid();
                                }
                                ahInt = 0;
                                break Label_4237;
                            }
                            case 34: {
                                int n = 0;
                                if (isKeyPressed(33008)) {
                                    this.SVoid();
                                    aVoid(i.aClassf, true);
                                    i.aClassf = null;
                                }
                                if (isKeyPressed(4097)) {
                                    --this.ddInt;
                                    if (this.ddInt < 0) {
                                        this.ddInt = 0;
                                    }
                                }
                                if (isKeyPressed(262146)) {
                                    ++this.ddInt;
                                    if (this.ddInt >= 2) {
                                        this.ddInt = 1;
                                    }
                                }
                                int n2 = this.aIntArr[this.ddInt];
                                if (isKeyPressed(16388)) {
                                    --n2;
                                }
                                if (isKeyPressed(65544)) {
                                    ++n2;
                                }
                                if (n2 < 0) {
                                    n2 = 0;
                                }
                                while (true) {
                                    int n3 = 0;
                                    switch (this.ddInt) {
                                        case 1: {
                                            n3 = 8;
                                            break;
                                        }
                                        case 0: {
                                            n3 = 115;
                                            break;
                                        }
                                        default: {
                                            if (n2 >= n) {
                                                n2 = n - 1;
                                            }
                                            this.aIntArr[this.ddInt] = n2;
                                            break Label_4236;
                                        }
                                    }
                                    n = n3;
                                    continue;
                                }
                            }
                            case 12: {
                                if (isKeyPressed(32944)) {
                                    this.azInt = 5;
                                    i.iByteArr[3] = (byte) this.azInt;
                                    if (this.kByte == 2) {
                                        this.lVoid();
                                    } else {
                                        eInt(4, -500);
                                        this.uVoid();
                                        i.bByte = 15;
                                        this.JBoolean = true;
                                        this.HBoolean = true;
                                        this.avVoid();
                                    }
                                }
                                break Label_4240;
                            }
                            case 4: {
                                this.TVoid();
                                break Label_4240;
                            }
                            case 30: {
                                if (isKeyPressed(1048575)) {
                                    i.bByte = 4;
                                    if (this.boInt == -1) {
                                        this.aVoid(this.aRInt = 0);
                                    } else {
                                        this.aRInt = 2;
                                    }
                                    ahInt = 0;
                                    break Label_4237;
                                }
                                break Label_4240;
                            }
                            case 2:
                            case 7:
                            case 32: {
                                this.TVoid();
                                break Label_4240;
                            }
                            // In-game, in a stage
                            case 1: {
                                if (this.hBoolean || this.ajBoolean) {
                                    i.keysPressed = 0;
                                }
                                i.mByte = i.bByte;
                                this.checkCheatKeyCodeIsPressed();
                                if (this.abBoolean && (isKeyPressed(524288) || isKeyPressed(131072))) {
                                    if (this.crtWorldIndex == 0 && this.crtStageI == 13) {
                                        this.aClassc = null;
                                        this.crtPlayerX = 60;
                                        this.crtPlayerY = 3;
                                    } else {
                                        this.atBoolean = isKeyPressed(524288);
                                        this.CBoolean = !this.atBoolean;
                                        this.bdInt = 0;
                                        this.bcInt = 0;
                                        this.xBoolean = true;
                                        this.crtPlayerX = this.crtStageWidth + 5 + 1;
                                    }
                                }
                                if ((this.clInt != 0 && !isKeyPressed(32944)) || this.ayInt != 0 || this.xBoolean || this.nByte <= 0 || i.aClassbArr[0].crtAnimationI == 19 || this.EBoolean) {
                                    i.keysPressed = 0;
                                    break Label_4240;
                                }
                                if (this.aClassc != null) {
                                    if (isKeyPressed(32784)) {
                                        this.aClassc.aVoid();
                                    } else if (isKeyPressed(32944)) {
                                        this.aClassc.aBoolean = true;
                                    }
                                    i.keysPressed = 0;
                                    break Label_4240;
                                }
                                if (this.aTInt > 0) {
                                    boolean b2 = true;
                                    if (isKeyPressed(4097)) {
                                        this.avInt = -5;
                                    } else if (isKeyPressed(262146)) {
                                        this.avInt = 5;
                                    } else if (isKeyPressed(16388)) {
                                        this.auInt = -5;
                                    } else if (isKeyPressed(65544)) {
                                        this.auInt = 5;
                                    } else if (!isKeyPressed(32784)) {
                                        if (isKeyPressed(32944)) {
                                            this.aeVoid();
                                            i.keysPressed = 0;
                                        } else {
                                            b2 = false;
                                        }
                                    }
                                    if (b2) {
                                        --this.aTInt;
                                        if (this.aTInt == 0) {
                                            if ((byte) i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] < 0) {
                                                i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] = 32;
                                            }
                                            if (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY] == 9) {
                                                i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY] = -1;
                                            }
                                            this.bLong = 40L;
                                            this.jInt = 0;
                                            this.kInt &= 0xFFFFFF8F;
                                            this.gVoid(this.cInt());
                                        }
                                        i.keysPressed = 0;
                                    }
                                } else {
                                    if (isKeyPressed(KEY_UP)) { // 4097
                                        this.aByte = 1;
                                    } else if (isKeyPressed(KEY_DOWN)) { // 262146
                                        this.aByte = 3;
                                    } else if (isKeyPressed(KEY_LEFT)) { // 16388
                                        this.aByte = 4;
                                    } else if (isKeyPressed(KEY_RIGHT)) { // 65544
                                        this.aByte = 2;
                                    } else if (isKeyPressed(KEY_OK)) { // 32784
                                        i.keysPressed = 0;
                                        if (this.bSInt == this.crtPlayerX && this.bTInt == this.crtPlayerY && (i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) == 0x4) {
                                            this.playSound(j_SoundManager.SOUND_SFX_CHECKPOINT);
                                            this.restoreCheckpoint();
                                        } else {
                                            final int n4;
                                            if ((n4 = ((i.eIntArrArr == null) ? 0 : aInt(i.eIntArrArr[this.crtPlayerX][this.crtPlayerY], (byte) 0, (byte) 3, (byte) 4))) != 8 && n4 != 7) {
                                                final int n5 = this.kInt & 0x7;
                                                int n6 = -1;
                                                int n7 = -1;
                                                boolean b3 = false;
                                                if (i.iByteArr[9] >= 2) {
                                                    int n8 = 0;
                                                    for (int n9 = 0; n9 < 2; ++n9) {
                                                        final int n10;
                                                        if (((n10 = ((n9 == 0) ? 1 : -1)) > 0 && this.crtPlayerX < this.crtStageWidth - 3) || (n10 < 0 && this.crtPlayerX > 3)) {
                                                            for (int n11 = 1; n11 <= 3; ++n11) {
                                                                final int n12 = this.crtPlayerX + n10 * n11;
                                                                final byte b4 = i.crtStagePlayerLayer[n12][this.crtPlayerY];
                                                                int n15 = 0;
                                                                Label_2157:
                                                                {
                                                                    if ((i.crtStageForegrondLayer[n12][this.crtPlayerY] & 0xFF) != 0x7 || (i.crtStageForegrondLayer[n12][this.crtPlayerY] >> 8 & 0xF0) != 0x0) {
                                                                        if (b4 == 48 && (i.bIntArrArr[n12][this.crtPlayerY] & 0x8) != 0x0) {
                                                                            continue;
                                                                        }
                                                                        Label_2094:
                                                                        {
                                                                            switch (b4) {
                                                                                case 11:
                                                                                case 19:
                                                                                case 43: {
                                                                                    int n13;
                                                                                    int n14;
                                                                                    if (n10 > 0) {
                                                                                        n13 = n8;
                                                                                        n14 = 2;
                                                                                    } else {
                                                                                        if (n10 >= 0) {
                                                                                            break Label_2094;
                                                                                        }
                                                                                        n13 = n8;
                                                                                        n14 = 4;
                                                                                    }
                                                                                    n8 = (n13 | n14);
                                                                                }
                                                                                case 0:
                                                                                case 1:
                                                                                case 8:
                                                                                case 9:
                                                                                case 14:
                                                                                case 47:
                                                                                case 48: {
                                                                                    if (n11 == 1) {
                                                                                        n15 = 4;
                                                                                        break Label_2157;
                                                                                    }
                                                                                    if (n7 < 0) {
                                                                                        n7 = ((n10 > 0) ? 2 : 4);
                                                                                        break;
                                                                                    }
                                                                                    b3 = true;
                                                                                    n7 = ((n8 == 2) ? 2 : ((n8 == 4) ? 4 : -1));
                                                                                    break;
                                                                                }
                                                                                case -1: {
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    n15 = 4;
                                                                }
                                                                n11 = n15;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i.iByteArr[9] >= 1) {
                                                    this.aByte = 5;
                                                    int n16 = 0;
                                                    final int[] array = {0, 1, 0, -1, 1, 1, -1, -1, 0, 2, 0, -2};
                                                    final int[] array2 = {-1, 0, 1, 0, -1, 1, 1, -1, -2, 0, 2, 0};
                                                    final int[] array3 = {0, 0, 0, 0, 3, 6, 12, 9, 1, 2, 4, 8};
                                                    for (int n17 = 0; n17 < array.length; ++n17) {
                                                        final int n18 = this.crtPlayerX + array[n17];
                                                        final int n19 = this.crtPlayerY + array2[n17];
                                                        if (n18 >= 0 && n18 < this.crtStageWidth && n19 >= 0 && n19 < this.crtStageHeight) {
                                                            final int n20 = i.bIntArrArr[n18][n19] & 0x7;
                                                            boolean b5 = false;
                                                            int n21 = -1;
                                                            boolean b6 = false;
                                                            Label_2616:
                                                            {
                                                                switch (i.crtStagePlayerLayer[n18][n19]) {
                                                                    case 9:
                                                                    case 18:
                                                                    case 30: {
                                                                        if (array3[n17] == 0) {
                                                                            b6 = true;
                                                                        }
                                                                        break Label_2616;
                                                                    }
                                                                    case 46:
                                                                    case 49:
                                                                    case 50: {
                                                                        if (array3[n17] == 0) {
                                                                            ++n16;
                                                                            b6 = true;
                                                                        }
                                                                        break Label_2616;
                                                                    }
                                                                    case 19:
                                                                    case 43: {
                                                                        if ((i.bIntArrArr[n18][n19] & 0xF8) == 0x0) {
                                                                            break;
                                                                        }
                                                                        break Label_2616;
                                                                    }
                                                                    case 45: {
                                                                        if ((i.bIntArrArr[n18][n19] & 0xF) != 0xA) {
                                                                            break;
                                                                        }
                                                                        break Label_2616;
                                                                    }
                                                                }
                                                                b5 = true;
                                                            }
                                                            if (b5) {
                                                                Label_2753:
                                                                {
                                                                    int n22;
                                                                    if (array3[n17] == 0) {
                                                                        n22 = n17 + 1;
                                                                    } else {
                                                                        if (i.bByteArrArr[n18][n19] < 12) {
                                                                            break Label_2753;
                                                                        }
                                                                        if ((array3[n17] & 0x1) != 0x0 && n20 == 3) {
                                                                            if (array[n17] == 0) {
                                                                                n22 = 1;
                                                                            } else if (array[n17] < 0) {
                                                                                n22 = 4;
                                                                            } else {
                                                                                if (array[n17] <= 0) {
                                                                                    break Label_2753;
                                                                                }
                                                                                n22 = 2;
                                                                            }
                                                                        } else {
                                                                            if ((array3[n17] & 0x8) == 0x0 || n20 != 2) {
                                                                                break Label_2753;
                                                                            }
                                                                            if (array2[n17] == 0) {
                                                                                n22 = 4;
                                                                            } else if (array2[n17] < 0) {
                                                                                n22 = 1;
                                                                            } else {
                                                                                if (array2[n17] <= 0) {
                                                                                    break Label_2753;
                                                                                }
                                                                                n22 = 3;
                                                                            }
                                                                        }
                                                                    }
                                                                    n21 = n22;
                                                                }
                                                                if (n21 != -1) {
                                                                    b6 = true;
                                                                    ++n16;
                                                                }
                                                            }
                                                            if (b6) {
                                                                if (n16 == 0) {
                                                                    if (n5 == n17 + 1) {
                                                                        n6 = n5;
                                                                    } else if (n6 < 0) {
                                                                        n6 = n17 + 1;
                                                                    }
                                                                } else {
                                                                    if (n16 != 1) {
                                                                        n6 = n5;
                                                                        break;
                                                                    }
                                                                    n6 = n21;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                Label_2971:
                                                {
                                                    i m = null;
                                                    int n23 = 0;
                                                    int n24 = 0;
                                                    Label_2967:
                                                    {
                                                        if (n6 > 0 && n7 == n5) {
                                                            this.aByte = 6;
                                                            m = this;
                                                            n23 = (this.kInt & 0xFFFFFFF8);
                                                            n24 = n5;
                                                        } else if (n6 > 0 && n7 < 0 && !b3) {
                                                            m = this;
                                                            n23 = (this.kInt & 0xFFFFFFF8);
                                                            n24 = n6;
                                                        } else {
                                                            if (n6 >= 0 || n7 <= 0 || b3) {
                                                                if (b3 && (n5 == 2 || n5 == 4)) {
                                                                    this.aByte = 6;
                                                                    m = this;
                                                                    n23 = (this.kInt & 0xFFFFFFF8);
                                                                    n24 = n5;
                                                                    break Label_2967;
                                                                }
                                                                if (!b3 || n7 <= 0) {
                                                                    break Label_2971;
                                                                }
                                                            }
                                                            this.aByte = 6;
                                                            m = this;
                                                            n23 = (this.kInt & 0xFFFFFFF8);
                                                            n24 = n7;
                                                        }
                                                    }
                                                    m.kInt = (n23 | n24);
                                                }
                                                if (this.aByte == 6 && (i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) == 0x2 && i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] >> 8 == 1) {
                                                    this.aDInt = -1;
                                                    this.bVoid(this.crtPlayerX, this.crtPlayerY, (byte) 2);
                                                }
                                            }
                                        }
                                    } else if (isKeyPressed(KEY_RESPAWN)) { // 256
                                        this.aDInt = -1;
                                        final int animationI = i.aClassbArr[0].crtAnimationI;
                                        if (animationI == 36 + (this.kInt & 0x7) - 1) {
                                            if ((i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) == 0x4) {
                                                this.restoreCheckpoint();
                                            } else {
                                                this.playSound(j_SoundManager.SOUND_SFX_DEATH);
                                                this.gVoid(19);
                                            }
                                        }
                                        switch (animationI) {
                                            case 0:
                                            case 1:
                                            case 2:
                                            case 3:
                                            case 34:
                                            case 35: {
                                                if ((i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) == 0x4) {
                                                    this.restoreCheckpoint();
                                                    break;
                                                }
                                                this.playSound(j_SoundManager.SOUND_SFX_DEATH);
                                                this.gVoid(19);
                                                break;
                                            }
                                        }
                                    } else if (isKeyPressed(KEY_ANY_OK)) { // 32944
                                        this.aeVoid();
                                        i.keysPressed = 0;
                                    }
                                    if (this.aByte != 5 && this.lByte == 0 && this.mInt == 0 && this.aByte != (this.kInt & 0x7)) {
                                        this.kInt |= 0x1000;
                                    }
                                }
                                break Label_4240;
                            }
                            case 10: {
                                break Label_4240;
                            }
                            case 15: {
                                Label_4006:
                                {
                                    if (this.dVInt == this.dXInt && this.dWInt == this.dYInt) {
                                        int n25 = -1;
                                        if (isKeyPressed(4097)) {
                                            n25 = 2;
                                        } else if (isKeyPressed(262146)) {
                                            n25 = 3;
                                        } else if (isKeyPressed(16388)) {
                                            n25 = 4;
                                        } else if (isKeyPressed(65544)) {
                                            n25 = 1;
                                        } else if (isKeyPressed(32944)) {
                                            if (System.currentTimeMillis() >= 2000L) {
                                                final int aInt = aInt(i.aLongArrArr[this.dVInt][this.dWInt], (byte) 6, (byte) 5);
                                                this.pVoid();
                                                this.auVoid();
                                                System.gc();
                                                this.crtStageI = aInt;
                                                this.lVoid();
                                                i.keysPressed = 0;
                                            }
                                            break Label_4006;
                                        } else if (isKeyPressed(64)) {
                                            this.JBoolean = true;
                                            this.HBoolean = true;
                                            this.LBoolean = true;
                                            this.bsInt = 0;
                                            i.bByte = 28;
                                            i.keysPressed = 0;
                                            break Label_4240;
                                        }
                                        i.keysPressed = 0;
                                        if (n25 != -1) {
                                            final int dvInt = this.dVInt;
                                            final int dwInt = this.dWInt;
                                            final long n26;
                                            final int aInt2 = aInt(n26 = i.aLongArrArr[dvInt][dwInt], (byte) 11, (byte) 3);
                                            int n27 = 14;
                                            int n28 = -1;
                                            int n29 = -1;
                                            for (int n30 = 0; n30 < aInt2; ++n30, n27 += 4) {
                                                final int aInt3 = aInt(n26, (byte) n27, (byte) 4);
                                                n27 += 4;
                                                final int aInt4 = aInt(n26, (byte) n27, (byte) 4);
                                                if (aInt(i.aLongArrArr[aInt3][aInt4], (byte) 0, (byte) 3) != 1) {
                                                    int n31 = 0;
                                                    switch (n25) {
                                                        case 1: {
                                                            if (aInt3 <= dvInt) {
                                                                continue;
                                                            }
                                                            if (n28 >= 0) {
                                                                n29 = n30;
                                                                continue;
                                                            }
                                                            n31 = n30;
                                                            break;
                                                        }
                                                        case 4: {
                                                            if (aInt3 >= dvInt) {
                                                                continue;
                                                            }
                                                            if (n28 >= 0) {
                                                                n29 = n30;
                                                                continue;
                                                            }
                                                            n31 = n30;
                                                            break;
                                                        }
                                                        case 2: {
                                                            if (aInt4 >= dwInt) {
                                                                continue;
                                                            }
                                                            if (n28 >= 0) {
                                                                n29 = n30;
                                                                continue;
                                                            }
                                                            n31 = n30;
                                                            break;
                                                        }
                                                        case 3: {
                                                            if (aInt4 <= dwInt) {
                                                                continue;
                                                            }
                                                            if (n28 >= 0) {
                                                                n29 = n30;
                                                                continue;
                                                            }
                                                            n31 = n30;
                                                            break;
                                                        }
                                                    }
                                                    n28 = n31;
                                                }
                                            }
                                            if (n28 != -1) {
                                                int n32 = -1;
                                                Label_3930:
                                                {
                                                    if (n29 != -1) {
                                                        int n33 = 14 + (n28 << 1 << 2);
                                                        final int aInt5 = aInt(n26, (byte) n33, (byte) 4);
                                                        n33 += 4;
                                                        final int aInt6 = aInt(n26, (byte) n33, (byte) 4);
                                                        int n34 = 14 + (n29 << 1 << 2);
                                                        final int aInt7 = aInt(n26, (byte) n34, (byte) 4);
                                                        n34 += 4;
                                                        final int aInt8 = aInt(n26, (byte) n34, (byte) 4);
                                                        int n35 = 0;
                                                        Label_3921:
                                                        {
                                                            switch (n25) {
                                                                case 1:
                                                                case 4: {
                                                                    if (dwInt == aInt6) {
                                                                        n35 = n28;
                                                                        break Label_3921;
                                                                    }
                                                                    if (dwInt != aInt8) {
                                                                        n35 = ((Math.abs(dvInt - aInt5) > Math.abs(dvInt - aInt7)) ? n28 : n29);
                                                                        break Label_3921;
                                                                    }
                                                                    break;
                                                                }
                                                                case 2:
                                                                case 3: {
                                                                    if (dvInt == aInt5) {
                                                                        n35 = n28;
                                                                        break Label_3921;
                                                                    }
                                                                    if (dvInt != aInt7 && aInt5 > aInt7) {
                                                                        n35 = n28;
                                                                        break Label_3921;
                                                                    }
                                                                    break;
                                                                }
                                                                default: {
                                                                    break Label_3930;
                                                                }
                                                            }
                                                            n35 = n29;
                                                        }
                                                        n32 = n35;
                                                    } else {
                                                        n32 = n28;
                                                    }
                                                }
                                                if (n32 != -1) {
                                                    int n36 = 14 + (n32 << 1 << 2);
                                                    final int aInt9 = aInt(n26, (byte) n36, (byte) 4);
                                                    n36 += 4;
                                                    final int aInt10 = aInt(n26, (byte) n36, (byte) 4);
                                                    if (aInt(i.aLongArrArr[aInt9][aInt10], (byte) 0, (byte) 3) == 0) {
                                                        this.dXInt = aInt9;
                                                        this.dYInt = aInt10;
                                                        this.awBoolean = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break Label_4240;
                            }
                            case 17:
                            case 20: {
                                if (isKeyPressed(32944)) {
                                    if (this.aRInt == 5) {
                                        this.avVoid();
                                        this.cVoid(false);
                                        this.pVoid();
                                    }
                                    this.uBoolean = true;
                                    break;
                                }
                                break Label_4240;
                            }
                            case 27: {
                                i.mByte = i.bByte;
                                this.checkCheatKeyCodeIsPressed();
                                if (this.DInt != -1 || this.BInt != 0) {
                                    i.keysPressed = 0;
                                    break Label_4240;
                                }
                                Label_4185:
                                {
                                    i self;
                                    int sealMoveDirection;
                                    if (isKeyPressed(KEY_ANY_OK)) { // 32944
                                        self = this;
                                        sealMoveDirection = SEAL_MOVE_OK;
                                    } else {
                                        if (isKeyPressed(KEY_CANCEL)) { // 64
                                            this.pVoid();
                                            i.bByte = 9;
                                            this.brInt = 8;
                                            this.aVoid(-1);
                                            this.bsInt = 0;
                                            break Label_4185;
                                        }
                                        if (isKeyPressed(KEY_UP)) { // 4097
                                            self = this;
                                            sealMoveDirection = SEAL_MOVE_UP;
                                        } else if (isKeyPressed(KEY_DOWN)) { // 262146
                                            self = this;
                                            sealMoveDirection = SEAL_MOVE_DOWN;
                                        } else if (isKeyPressed(KEY_LEFT)) { // 16388
                                            self = this;
                                            sealMoveDirection = SEAL_MOVE_LEFT;
                                        } else {
                                            if (!isKeyPressed(KEY_RIGHT)) { // 65544
                                                break Label_4185;
                                            }
                                            self = this;
                                            sealMoveDirection = SEAL_MOVE_RIGHT;
                                        }
                                    }
                                    self.crtSealMoveDirection = sealMoveDirection;
                                }
                                i.keysPressed = 0;
                                break Label_4240;
                            }
                            case 31: {
                                if (isKeyPressed(64)) {
                                    this.bsInt = 0;
                                    this.brInt = 8;
                                    i.bByte = 9;
                                    this.aVoid(-1);
                                    break;
                                }
                                if (isKeyPressed(32944)) {
                                    this.QVoid();
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    ahInt = 0;
                }
                i.keysPressed = ahInt;
            }
            if (!this.dBoolean && (this.kInt & 0x7) != 0x0) {
                this.mInt = 10;
            }
        }
        switch (i.bByte) {
            case 22: {
                switch (this.aRInt) {
                    case 0: {
                        this.eoInt = 0;
                        this.epInt = 0;
                        this.aRInt = 1;
                    }
                    case 1: {
                        i.sByteArr = readChunk("/cr.f", 0);
                        int n37 = 0;
                        while (n37 < i.sByteArr.length) {
                            if (i.sByteArr[n37] == 92 && i.sByteArr[n37 + 1] == 110) {
                                i.sByteArr[n37++] = 10;
                                i.sByteArr[n37++] = 32;
                            } else {
                                ++n37;
                            }
                        }
                        int n38;
                        for (n38 = 0; i.sByteArr[n38] != 36; ++n38) {
                        }
                        for (int n39 = 0; n39 < GloftDIRU.midletVersionBytes.length; ++n39, ++n38) {
                            i.sByteArr[n38] = GloftDIRU.midletVersionBytes[n39];
                        }
                        this.aRInt = 2;
                    }
                    case 2: {
                        Label_4719:
                        {
                            i i3 = null;
                            int eoInt = 0;
                            Label_4716:
                            {
                                int n40 = 0;
                                int n41 = 0;
                                Label_4715:
                                {
                                    if (isKeyPressed(4097)) {
                                        if (this.eoInt >= 240) {
                                            this.eoInt -= 3;
                                            if (this.eoInt < 240) {
                                                i3 = this;
                                                eoInt = 240;
                                                break Label_4716;
                                            }
                                            break Label_4719;
                                        }
                                    } else {
                                        if (isKeyPressed(262146)) {
                                            i3 = this;
                                            n40 = this.eoInt;
                                            n41 = 3;
                                            break Label_4715;
                                        }
                                        if (isKeyPressed(64)) {
                                            if (this.iBoolean) {
                                                this.bsInt = 0;
                                                this.brInt = 8;
                                                i.bByte = 9;
                                                this.iBoolean = false;
                                                break Label_4719;
                                            }
                                            this.aRInt = 3;
                                            break Label_4719;
                                        }
                                    }
                                    i3 = this;
                                    n40 = this.eoInt;
                                    n41 = 1;
                                }
                                eoInt = n40 + n41;
                            }
                            i3.eoInt = eoInt;
                        }
                        int n42;
                        int epInt;
                        for (n42 = -this.eoInt, epInt = 0; epInt < i.sByteArr.length && n42 <= -340; ++epInt) {
                            if (i.sByteArr[epInt] == 10) {
                                n42 += 17;
                            }
                        }
                        this.epInt = epInt;
                        if (this.epInt >= i.sByteArr.length) {
                            this.epInt = 0;
                            this.eoInt = 0;
                            return;
                        }
                        break;
                    }
                    case 3: {
                        i.sByteArr = null;
                        System.gc();
                        i.bByte = 4;
                        this.aRInt = 2;
                        this.aVoid(0);
                        this.aClassj.playSound(j_SoundManager.SOUND_M_TITLE);
                        break;
                    }
                }
            }
            case 21: {
                final int n43 = this.bsInt++;
                Label_5670:
                {
                    try {
                        switch (n43) {
                            case 0: {
                                if (this.IBoolean) {
                                    this.sVoid();
                                    break;
                                }
                                break;
                            }
                            case 1: {
                                if (this.JBoolean) {
                                    this.pVoid();
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                if (this.GBoolean) {
                                    this.GBoolean = false;
                                    aVoid(i.aClassfArr[17], true);
                                    i.aClassfArr[17] = null;
                                    aVoid(i.aClassfArr[10], true);
                                    i.aClassfArr[10] = null;
                                    aVoid(i.aClassfArr[46], true);
                                    i.aClassfArr[46] = null;
                                    aVoid(i.aClassfArr[55], true);
                                    i.aClassfArr[55] = null;
                                    i.textures[8] = null;
                                    aVoid(i.aClassfArr[59], true);
                                    i.textures[3] = null;
                                    aVoid(i.aClassfArr[17], true);
                                    i.aClassfArr[17] = null;
                                    System.gc();
                                    break;
                                }
                                break;
                            }
                            case 3: {
                                if (this.HBoolean) {
                                    this.auVoid();
                                    break;
                                }
                                break;
                            }
                            case 4: {
                                // Load the map file
                                h.setColor(0xFFFFFF);
                                i.crtWorldMapFileName.delete(0, i.crtWorldMapFileName.length()); // Clear
                                switch (this.crtWorldIndex) {
                                    case 0: {
                                        i.crtWorldMapFileName.append("/map_angkor.out");
                                        break;
                                    }
                                    case 1: {
                                        i.crtWorldMapFileName.append("/map_scotland.out");
                                        break;
                                    }
                                    case 2: {
                                        i.crtWorldMapFileName.append("/map_tibet.out");
                                        break;
                                    }
                                }
                                i.aLongArrArr = new long[12][12];
                                this.cIntArr = new int[20];
                                this.aVoid(i.crtWorldMapFileName.toString());
                                break;
                            }
                            case 5: {
                                // Load the map sprites
                                i.aClassfArr[17] = loadSprite("/ms.f", 0);
                                i.aClassfArr[23] = loadSprite("/ms.f", 1);
                                break;
                            }
                            case 6: {
                                // Load the map header
                                while (true) {
                                    f_Sprite[] array4 = null;
                                    int n44 = 0;
                                    String fileName = null;
                                    int chunkI = 0;
                                    switch (this.crtWorldIndex) {
                                        case 0: {
                                            array4 = i.aClassfArr;
                                            n44 = 24;
                                            fileName = "/ms.f";
                                            chunkI = 2;
                                            break;
                                        }
                                        case 1: {
                                            array4 = i.aClassfArr;
                                            n44 = 25;
                                            fileName = "/ms.f";
                                            chunkI = 3;
                                            break;
                                        }
                                        case 2: {
                                            array4 = i.aClassfArr;
                                            n44 = 26;
                                            fileName = "/ms.f";
                                            chunkI = 4;
                                            break;
                                        }
                                        default: {
                                            break Label_5670;
                                        }
                                    }
                                    array4[n44] = loadSprite(fileName, chunkI);
                                    continue;
                                }
                            }
                            case 7: {
                                // Load the ice crystal
                                if (i.aClassfArr[54] == null) {
                                    i.aClassfArr[54] = loadSprite("/mmv.f", 1);
                                }
                                this.GInt = cInt(i.aClassfArr[54], 0) >> 1;
                                this.HInt = bInt(i.aClassfArr[54], 0) >> 1;
                                break;
                            }
                            case 8: {
                                // Load the fire crystal
                                if (i.aClassfArr[53] == null) {
                                    i.aClassfArr[53] = loadSprite("/mmv.f", 2);
                                    break;
                                }
                                break;
                            }
                            case 9: {
                                // Load the silver diamond
                                if (i.aClassfArr[52] == null) {
                                    i.aClassfArr[52] = loadSprite("/mmv.f", 3);
                                    break;
                                }
                                break;
                            }
                            case 10: {
                                if (this.acBoolean) {
                                    this.elInt = 0;
                                    this.eiInt = 0;
                                    this.ejInt = 0;
                                    this.arBoolean = false;
                                    this.aqBoolean = true;
                                    this.apBoolean = false;
                                    this.ekInt = 2;
                                    this.emInt = 2;
                                    this.asBoolean = false;
                                    break;
                                }
                                break;
                            }
                            case 14: {
                                if (this.CBoolean) {
                                    this.CBoolean = false;
                                }
                                this.dVInt = -1;
                                if (!this.acBoolean) {
                                    this.crtStageI = i.dZInt;
                                }
                                this.acBoolean = false;
                                for (int n46 = 0; n46 < 12; ++n46) {
                                    for (int n47 = 0; n47 < 12; ++n47) {
                                        final long n48;
                                        if ((n48 = i.aLongArrArr[n46][n47]) != 0L) {
                                            final int aInt11 = aInt(n48, (byte) 6, (byte) 5);
                                            int n49;
                                            int n50;
                                            int n51;
                                            if ((this.aByte(this.crtWorldIndex, aInt11) & 0x40) != 0x0 || aInt11 == 0) {
                                                n49 = n46;
                                                n50 = n47;
                                                n51 = 0;
                                            } else {
                                                n49 = n46;
                                                n50 = n47;
                                                n51 = 1;
                                            }
                                            aVoid(n49, n50, n51, (byte) 0, (byte) 3);
                                            if (aInt11 == this.crtStageI) {
                                                this.dVInt = n46;
                                                this.dWInt = n47;
                                            }
                                            if (aInt11 == i.dZInt) {
                                                this.dXInt = n46;
                                                this.dYInt = n47;
                                            }
                                            this.aoBoolean = false;
                                        }
                                    }
                                }
                                i.bByte = 15;
                                break;
                            }
                        }
                    } catch (Exception ex2) {
                    }
                }
                this.eVoid();
            }
            case 20: {
                if (i.aSInt > 30) {
                    this.CBoolean = true;
                    this.JBoolean = true;
                    this.HBoolean = true;
                    this.avVoid();
                    return;
                }
                break;
            }
            case 35: {
                Label_6577:
                {
                    switch (this.bsInt++) {
                        case 0: {
                            i.deInt = 0;
                            i.dfInt = 0;
                            i.dgInt = 0;
                            this.tByte = this.aByte(this.crtWorldIndex, this.crtStageI);
                            this.uByte = 0;
                            break;
                        }
                        case 1: {
                            i.deInt = (i.deInt = unpackUint16(i.iByteArr, 4)) + this.aZInt;
                            this.uBoolean = false;
                            break;
                        }
                        case 2: {
                            i.iByteArr[4] = (byte) i.deInt;
                            i.iByteArr[5] = (byte) (i.deInt >> 8);
                            break;
                        }
                        case 3: {
                            i.dfInt = (i.dfInt = unpackUint16(i.iByteArr, 6)) + this.bbInt;
                            break;
                        }
                        case 4: {
                            i.iByteArr[6] = (byte) i.dfInt;
                            i.iByteArr[7] = (byte) (i.dfInt >> 8);
                            break;
                        }
                        case 5: {
                            i.dgInt = i.iByteArr[2];
                            this.UInt = 0;
                            if ((i.dgInt & 0x8) == 0x0 && i.dfInt >= a_Config.worldPrices[1]) {
                                this.UInt = 1;
                                break;
                            }
                            if ((i.dgInt & 0x10) == 0x0 && i.dfInt >= a_Config.worldPrices[2]) {
                                this.UInt = 2;
                                break;
                            }
                            break;
                        }
                        case 6: {
                            try {
                                i.textures[28] = importTexturesWithPalette("/ui.f", 4, 0);
                            } catch (Exception ex3) {
                            }
                            break;
                        }
                        case 7: {
                            this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 2);
                            this.VInt = 0;
                            break;
                        }
                        case 8: {
                            int vInt;
                            int n52;
                            for (n52 = (vInt = (i.dgInt & 0xE0) >> 5); vInt < 4 && i.deInt >= a_Config.itemPrices[vInt]; ++vInt) {
                            }
                            if (n52 < vInt) {
                                final byte[] iByteArr = i.iByteArr;
                                final int n53 = 2;
                                iByteArr[n53] &= (byte) (-225);
                                final byte[] iByteArr2 = i.iByteArr;
                                final int n54 = 2;
                                iByteArr2[n54] |= (byte) (vInt << 5 & 0xE0);
                                this.uVoid();
                                this.VInt = vInt;
                            }
                        }
                        case 9: {
                            this.WVoid();
                            break;
                        }
                        case 10: {
                            this.eVoid();
                            System.gc();
                            break;
                        }
                        case 11: {
                            if (this.azInt < 99 && this.aZInt == this.aYInt && (this.tByte & 0x4) == 0x0) {
                                this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 4);
                                this.uByte |= 0x4;
                                ++this.azInt;
                            }
                            if (this.azInt < 99 && this.bbInt == this.baInt && (this.tByte & 0x8) == 0x0) {
                                this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 8);
                                this.uByte |= 0x8;
                                ++this.azInt;
                            }
                            if (this.azInt < 99 && this.bcInt == 0 && (this.tByte & 0x10) == 0x0) {
                                this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 16);
                                this.uByte |= 0x10;
                                ++this.azInt;
                            }
                            if (this.azInt < 99 && this.bdInt == 0 && (this.tByte & 0x20) == 0x0) {
                                this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 32);
                                this.uByte |= 0x20;
                                ++this.azInt;
                            }
                            final int abInt = this.crtStageI;
                            int n55 = 0;
                            Label_6463:
                            while (true) {
                                while (n55 < 12) {
                                    for (int n56 = 0; n56 < 12; ++n56) {
                                        final long n57;
                                        if ((n57 = i.aLongArrArr[n55][n56]) != 0L && aInt(n57, (byte) 6, (byte) 5) == abInt) {
                                            final long n58 = n57;
                                            break Label_6463;
                                        }
                                    }
                                    ++n55;
                                    continue;
                                    /*long n58 = 0L;
                                    final long n59 = n58;
                                    if ((this.aBInt == 0 || aInt(n59, (byte) 11, (byte) 3) > 1) && n59 >= 0L && (this.aByte(this.aAInt, this.aBInt + 1) & 0x40) == 0x0) {
                                        i.dZInt = this.aBInt + 1;
                                        this.aVoid(this.aAInt, i.dZInt, (byte) 64);
                                        this.acBoolean = true;
                                    } else {
                                        i.dZInt = this.aBInt;
                                    }
                                    this.cVoid(false);
                                    this.sVoid();
                                    this.IBoolean = false;
                                    this.HBoolean = true;
                                    break Label_6577;*/
                                }
                                final long n58 = -1L;
                                continue Label_6463;
                            }
                        }
                    }
                }
                this.eVoid();
                if (this.bsInt == 12) {
                    i.bByte = 17;
                    this.aRInt = 0;
                    this.playSound(15);
                    return;
                }
                break;
            }
            case 17: {
                switch (this.aRInt) {
                    case 0: {
                        if (i.aSInt > 40 || this.uBoolean) {
                            ++this.aRInt;
                            this.eVoid();
                            return;
                        }
                        break;
                    }
                    case 1: {
                        if ((i.aSInt > this.aZInt << 1 && i.aSInt > 40) || this.uBoolean) {
                            ++this.aRInt;
                            this.eVoid();
                            return;
                        }
                        break;
                    }
                    case 2: {
                        if (i.aSInt > 40 || this.uBoolean) {
                            ++this.aRInt;
                            this.eVoid();
                            return;
                        }
                        break;
                    }
                    case 3: {
                        if (i.aSInt > 10 || this.uBoolean) {
                            ++this.aRInt;
                            this.eVoid();
                            return;
                        }
                        break;
                    }
                    case 4: {
                        if (i.aSInt > 10 || this.uBoolean) {
                            ++this.aRInt;
                            this.eVoid();
                            this.uBoolean = false;
                            break;
                        }
                        break;
                    }
                }
            }
            case 31: {
            }
            case 16: {
                this.DBoolean = true;
                this.lVoid();
                i.keysPressed = 0;
            }
            case 0: {
                System.out.println("Set value to i.aClassbArr[0]. new b(<TEXTURES /ui.f 0>, 0, 0, null)");
                (i.aClassbArr[0] = new b_SpriteAnimator(loadSprite("/ui.f", 0), 0, 0, null)).setAnimation(0); // ui.f, chunk 0, palette 0, all animations
                System.out.println(i.aClassbArr[0]);
                i.bByte = 6;
                this.eVoid();
            }
            case 6: {
                if (i.aSInt < 60) {
                    i.aClassbArr[0].tick();
                    return;
                }
                i.texts = aClassStringArr(127);
                i.demoTextMapping = getDemoTextMapping();
                i.stageTitles = generateStageTitles();
                try {
                    i.bBoolean = d.getLocalizedText(127).trim().equals("1");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    i.bBoolean = false;
                }
                aAVoid();
                i.aClassfArr[18] = loadSprite("/ui.f", 3);
                this.pVoid();
                j_SoundManager.soundEnabled = true;
                i.bByte = 8;
                this.bsInt = 0;
                this.brInt = 32;
            }
            case 7: {
                if (this.zBoolean) {
                    i.bByte = 8;
                    this.bsInt = 0;
                    this.brInt = 32;
                    return;
                }
                break;
            }
            case 1: {
                this.UVoid();
            }
            case 3: {
                this.BBoolean = true;
            }
            case 9: {
                try {
                    this.tVoid();
                    int bsInt = 0;
                    int n60 = 0;
                    if (this.brInt == 8) {
                        bsInt = this.bsInt;
                    } else {
                        n60 = this.bsInt - 24;
                    }
                    int n61 = n60;
                    switch (bsInt) {
                        case 0: {
                            aAVoid();
                            System.gc();
                        }
                        case 1: {
                        }
                        case 2: {
                        }
                        case 3: {
                        }
                        case 4: {
                        }
                        case 6: {
                            if (i.splashLogoImage == null) {
                                i.splashLogoImage = readChunkAsImageFile("/spl.f", 0);
                            }
                            if (i.splashBgGradientImage == null) {
                                i.splashBgGradientImage = readChunkAsImageFile("/spl.f", 1);
                            }
                            if (i.splashCopyrightImage == null) {
                                i.splashCopyrightImage = readChunkAsImageFile("/spl.f", 2);
                                break;
                            }
                            break;
                        }
                        case 7: {
                            if (i.aClassfArr[18] == null) {
                                i.aClassfArr[18] = loadSprite("/ui.f", 3);
                                break;
                            }
                            break;
                        }
                    }
                    ++n61;
                    ++this.bsInt;
                    this.YBoolean = true;
                    if (n61 == 8) {
                        if (this.FBoolean) {
                            i.bByte = 4;
                            if (this.boInt == -1) {
                                this.aVoid(this.aRInt = 0);
                            } else {
                                this.aRInt = 2;
                            }
                        } else {
                            i.bByte = 30;
                            this.FBoolean = true;
                        }
                        this.aClassj.playSound(j_SoundManager.SOUND_M_TITLE);
                    }
                } catch (Exception ex4) {
                }
                this.eVoid();
            }
            case 11: {
                this.JBoolean = true;
                this.HBoolean = true;
                i.bByte = 5;
                this.RBoolean = true;
                this.eVoid();
            }
            case 5: {
                if (this.DBoolean && this.bsInt <= 5) {
                    this.eVoid(this.bsInt++);
                    for (int n62 = 0; n62 < 3; ++n62) {
                        i.bBooleanArr[n62] = false;
                    }
                    for (int n63 = 1; n63 < 3; ++n63) {
                        i.aBooleanArr[n63] = false;
                    }
                    this.eVoid();
                    if (this.bsInt == 5) {
                        this.NBoolean = true;
                        this.MBoolean = true;
                        this.LBoolean = true;
                        this.crtWorldIndex = 0;
                        this.crtStageI = STAGE_ANGKOR_DEMO;
                        i.keysPressed = 0;
                    }
                } else {
                    this.jVoid(); // Sets i.bByte to 1
                }
                this.eVoid();
            }
            case 8: {
                final int n64 = this.bsInt++;
                if (n64 < 21) {
                    if (n64 == 0) {
                        this.aClassj.loadMidiIndices();
                    }
                    this.aClassj.loadSound(n64);
                    if (n64 == 20) {
                        this.aClassj.cVoid();
                    }
                    System.gc();
                } else {
                    switch (n64) {
                        case 21: {
                            i.aClassfArr[9] = loadSprite("/cm.f", 7); // Effect animations
                            break;
                        }
                        case 22: {
                            i.aClassfArr[0] = loadSprite("/ui.f", 2); // Top and bottom UI
                            break;
                        }
                        case 23: {
                            // Demo UI - text box border parts + 5 button
                            i.demoUITextures[0] = importTexturesWithPalette("/demoui.f", 0, 0); // Gray/brown
                            i.demoUITextures[1] = importTexturesWithPalette("/demoui.f", 0, 1); // Blue
                            break;
                        }
                        case 24: {
                            this.aClassj.startThread();
                            i.bByte = 9;
                            this.aVoid(-1);
                            (i.aClassStringBuffer = new StringBuffer(i.stageTitles[0])).delete(i.aClassStringBuffer.length() - 1, i.aClassStringBuffer.length());
                            (i.bClassStringBuffer = new StringBuffer(i.stageTitles[11])).delete(i.bClassStringBuffer.length() - 1, i.bClassStringBuffer.length());
                            i.crtWorldMapFileName = new StringBuffer("1");
                            break;
                        }
                    }
                }
                this.eVoid();
            }
            case 2:
            case 12: {
            }
            case 15: {
                if (this.UInt > 0 || this.VInt > 0) {
                    final StringBuffer sb = new StringBuffer();
                    Label_7811:
                    {
                        if (this.UInt > 0) {
                            sb.append(i.texts[124]).append("\n"); // "World unlocked: " + "\n"
                            while (true) {
                                byte[] iByteArr3 = null;
                                int n65 = 0;
                                byte b7 = 0;
                                byte b8 = 0;
                                switch (this.UInt) {
                                    case 1: {
                                        sb.append(i.texts[4]); // "Bavaria"
                                        iByteArr3 = i.iByteArr;
                                        b7 = iByteArr3[n65 = 2];
                                        b8 = 8;
                                        break;
                                    }
                                    case 2: {
                                        sb.append(i.texts[64]); // "Siberia"
                                        final byte[] iByteArr4 = i.iByteArr;
                                        final int n66 = 2;
                                        iByteArr4[n66] |= 0x8;
                                        b7 = i.iByteArr[n65 = 2];
                                        b8 = 16;
                                        break;
                                    }
                                    default: {
                                        this.uVoid();
                                        this.UInt = 0;
                                        break Label_7811;
                                    }
                                }
                                if (iByteArr3 != null) iByteArr3[n65] = (byte) (b7 | b8);
//                                continue;
                            }
                        }
                    }
                    if (this.VInt > 0) {
                        if (sb.length() > 0) {
                            sb.append("\n\n");
                        }
                        sb.append(i.texts[33]).append("\n").append(i.texts[120 + this.VInt - 1]); // "Unlocked" + "\n" + <textx #121-124 - vests, suit, jacket...>
                        this.VInt = 0;
                    }
                    if (sb.length() > 0) {
                        this.aVoid(sb.toString(), -1, -1, 5000, 4273165, 0);
                    }
                }
            }
            case 27: {
                this.iVoid();
            }
            case 28: {
                try {
                    this.bVoid(this.bsInt);
                    ++this.bsInt;
                    if (this.bsInt == 11) {
                        i.bByte = 27;
                    }
                } catch (Exception ex5) {
                }
                this.eVoid();
            }
            case 29: {
                this.gVoid();
                break;
            }
        }
    }

    private void gVoid() {
        switch (this.WInt) {
            case 0: {
                if (System.currentTimeMillis() - this.aLong >= 3000L) {
                    ++this.WInt;
                    this.eVoid();
                    return;
                }
                break;
            }
            case 1: {
                boolean avBoolean;
                if (aSInt % 6 >= 3) {
                    this.XInt += 1677721;
                    avBoolean = false;
                } else {
                    avBoolean = true;
                }
                this.avBoolean = avBoolean;
                if (System.currentTimeMillis() - this.aLong >= 5000L) {
                    ++this.WInt;
                    this.avBoolean = true;
                    this.eVoid();
                    return;
                }
                break;
            }
            case 2: {
                Label_0195:
                {
                    i j;
                    byte dByte;
                    if (this.ZInt >= this.fByte) {
                        j = this;
                        dByte = -1;
                    } else {
                        if (this.ZInt > -this.fByte) {
                            break Label_0195;
                        }
                        j = this;
                        dByte = 1;
                    }
                    j.dByte = dByte;
                }
                this.ZInt += this.dByte * this.hByte;
                Label_0246:
                {
                    i k;
                    byte eByte;
                    if (this.YInt >= this.gByte) {
                        k = this;
                        eByte = -1;
                    } else {
                        if (this.ZInt > -this.gByte) {
                            break Label_0246;
                        }
                        k = this;
                        eByte = 1;
                    }
                    k.eByte = eByte;
                }
                final int yInt = this.YInt;
                final byte eByte2 = this.eByte;
                this.YInt = yInt + 0;
                if (System.currentTimeMillis() - this.aLong >= 10000L) {
                    this.YInt = 0;
                    this.ZInt = 0;
                    this.eVoid();
                    ++this.WInt;
                    return;
                }
                break;
            }
            case 3: {
                if (System.currentTimeMillis() - this.aLong >= 1000L) {
                    ++this.WInt;
                    return;
                }
                break;
            }
            case 4: {
                if (System.currentTimeMillis() - this.aLong >= 1000L) {
                    ++this.WInt;
                    return;
                }
                break;
            }
            case 5: {
                if (System.currentTimeMillis() - this.aLong >= 1000L) {
                    ++this.WInt;
                    return;
                }
                break;
            }
            case 6: {
                if (System.currentTimeMillis() - this.aLong >= 1000L) {
                    ++this.WInt;
                    this.eVoid();
                    return;
                }
                break;
            }
            case 7: {
                if (System.currentTimeMillis() - this.aLong >= 1000L) {
                    g.aByteArrArr = new byte[12][13];
                    ++this.WInt;
                    g.bVoid(3);
                    this.aClassj.playSound(j_SoundManager.SOUND_M_TITLE);
                    this.eVoid();
                    return;
                }
                break;
            }
            case 8: {
                g.aVoid(3);
                this.avBoolean = true;
                if (System.currentTimeMillis() - this.aLong >= 15000L) {
                    ++this.WInt;
                    this.eVoid();
                    return;
                }
                break;
            }
            case 9: {
                this.avBoolean = true;
                g.aVoid(3);
                if (System.currentTimeMillis() - this.aLong >= 12000L) {
                    ++this.WInt;
                    this.eVoid();
                    return;
                }
                break;
            }
            case 10: {
                this.pVoid();
                this.aVoid(0);
                i.bByte = 22;
                this.aRInt = 0;
                this.aClassj.freeCrtPlayerResource();
                break;
            }
        }
    }

    private void bVoid(int n) {
        switch (n) {
            case 0: {
                if (this.KBoolean) {
                    this.oVoid();
                    return;
                }
                break;
            }
            case 1: {
                if (this.HBoolean) {
                    this.auVoid();
                    return;
                }
                break;
            }
            case 2: {
                if (this.MBoolean) {
                    this.xVoid();
                    return;
                }
                break;
            }
            case 3: {
                if (this.LBoolean) {
                    System.gc();
                    this.LBoolean = false;
                    return;
                }
                break;
            }
            case 4: {
                this.pVoid();
                if (i.aClassfArr[10] == null) {
                    final f_Sprite[] aClassfArr = i.aClassfArr;
                    final int n2 = 10;
                    final String s = "/mmv.f";
                    final int n3 = 0;
                    n = 0;
                    aClassfArr[n2] = loadSprite(s, n3, 0, 0);
                }
                if (i.aClassfArr[46] == null) {
                    final f_Sprite[] aClassfArr2 = i.aClassfArr;
                    final int n4 = 46;
                    final String s2 = "/mmv.f";
                    final int n5 = 5;
                    n = 0;
                    aClassfArr2[n4] = loadSprite(s2, n5, 0, 0);
                }
                this.zInt = 240 - cInt(i.aClassfArr[10], 0) >> 1;
                this.AInt = 320 - bInt(i.aClassfArr[10], 0) - 48 >> 1;
            }
            case 5: {
                if (i.aClassfArr[55] == null) {
                    final f_Sprite[] aClassfArr3 = i.aClassfArr;
                    final int n6 = 55;
                    final String s3 = "/mmv.f";
                    final int n7 = 4;
                    n = 0;
                    aClassfArr3[n6] = loadSprite(s3, n7, 0, 0);
                    this.xInt = aInt(i.aClassfArr[55], 0);
                    i.bClassf = i.aClassfArr[55];
                }
                if (i.aClassfArr[18] == null) {
                    final f_Sprite[] aClassfArr4 = i.aClassfArr;
                    final int n8 = 18;
                    final String s4 = "/ui.f";
                    final int n9 = 3;
                    n = 0;
                    aClassfArr4[n8] = loadSprite(s4, n9, 0, 0);
                    return;
                }
                break;
            }
            case 6: {
                if (i.aClassfArr[54] == null) {
                    final f_Sprite[] aClassfArr5 = i.aClassfArr;
                    final int n10 = 54;
                    final String s5 = "/mmv.f";
                    final int n11 = 1;
                    n = 0;
                    aClassfArr5[n10] = loadSprite(s5, n11, 0, 0);
                }
                this.GInt = cInt(i.aClassfArr[54], 0) >> 1;
                this.HInt = bInt(i.aClassfArr[54], 0) >> 1;
            }
            case 7: {
                if (i.aClassfArr[53] == null) {
                    final f_Sprite[] aClassfArr6 = i.aClassfArr;
                    final int n12 = 53;
                    final String s6 = "/mmv.f";
                    final int n13 = 2;
                    n = 0;
                    aClassfArr6[n12] = loadSprite(s6, n13, 0, 0);
                    return;
                }
                break;
            }
            case 8: {
                if (i.aClassfArr[52] == null) {
                    final f_Sprite[] aClassfArr7 = i.aClassfArr;
                    final int n14 = 52;
                    final String s7 = "/mmv.f";
                    final int n15 = 3;
                    n = 0;
                    aClassfArr7[n14] = loadSprite(s7, n15, 0, 0);
                    return;
                }
                break;
            }
            case 9: {
                try {
                    final String string = "/" + 0 + ".f";
                    final int n16 = 3;
                    n = 0;
                    i.textures[8] = loadSprite(string, n16, 0, 0).images[0];
                    final String s8 = "/cm.f";
                    final int n17 = 2;
                    n = 0;
                    final f_Sprite aClassf;
                    (aClassf = loadSprite(s8, n17, 0, 0)).createImages(0, 0, -1, -1);
                    aClassf.createImages(1, 0, 0, -1);
                    i.aClassfArr[59] = aClassf;
                    g.aInt = aClassf.images[0].length;
                    aClassf.moduleData = null;
                    if (i.aClassfArr[17] == null) {
                        final f_Sprite[] aClassfArr8 = i.aClassfArr;
                        final int n18 = 17;
                        final String s9 = "/ms.f";
                        final int n19 = 0;
                        n = 0;
                        aClassfArr8[n18] = loadSprite(s9, n19, 0, 0);
                    }
                } catch (Exception ex) {
                }
            }
            case 10: {
                if (i.aClassfArr[9] == null) {
                    final f_Sprite[] aClassfArr9 = i.aClassfArr;
                    final int n20 = 9;
                    final String s10 = "/cm.f";
                    final int n21 = 7;
                    n = 0;
                    aClassfArr9[n20] = loadSprite(s10, n21, 0, 0);
                }
                this.JInt = aInt(i.aClassfArr[9], 5);
                n = i.iByteArr[2];
                for (int iInteger = 0; iInteger < 3; ++iInteger) {
                    if ((n & 1 << iInteger) != 0x0) {
                        i.bBooleanArr[iInteger] = true;
                    }
                }
                this.EInt = 10;
                this.FInt = 10;
                Label_0747:
                {
                    boolean[] array;
                    int n22;
                    boolean b;
                    if (((n = i.iByteArr[1]) & 0x1) != 0x0) {
                        array = i.aBooleanArr;
                        n22 = 1;
                        b = true;
                    } else {
                        if (unpackUint16(i.iByteArr, 6) >= a_Config.worldPrices[1]) {
                            final byte[] iByteArr = i.iByteArr;
                            final int n23 = 1;
                            iByteArr[n23] |= 0x1;
                            this.uVoid();
                            this.BInt = 1;
                            this.crtSealPosition = SEAL_POS_BAVARIA;
                            break Label_0747;
                        }
                        array = i.aBooleanArr;
                        n22 = 1;
                        b = false;
                    }
                    array[n22] = b;
                }
                Label_0810:
                {
                    boolean[] array2;
                    int n24;
                    boolean b2;
                    if ((n & 0x2) != 0x0) {
                        array2 = i.aBooleanArr;
                        n24 = 2;
                        b2 = true;
                    } else {
                        if (unpackUint16(i.iByteArr, 6) >= a_Config.worldPrices[2]) {
                            final byte[] iByteArr2 = i.iByteArr;
                            final int n25 = 1;
                            iByteArr2[n25] |= 0x2;
                            this.uVoid();
                            this.BInt = 2;
                            this.crtSealPosition = SEAL_POS_SIBERIA;
                            break Label_0810;
                        }
                        array2 = i.aBooleanArr;
                        n24 = 2;
                        b2 = false;
                    }
                    array2[n24] = b2;
                }
                this.qInt = a_Config.sealArrowPosOffsets[this.crtSealPosition << 1];
                this.rInt = a_Config.sealArrowPosOffsets[(this.crtSealPosition << 1) + 1];
                this.sInt = this.qInt;
                this.tInt = this.rInt;
                this.hVoid();
                this.gBoolean = true;
                this.avBoolean = true;
                break;
            }
        }
    }

    private void hVoid() {
        i i;
        StringBuffer sb;
        String action;
        if (this.crtSealPosition == SEAL_POS_SHOP) {
            i = this;
            sb = new StringBuffer();
            action = i.texts[45]; // "Press 5"
        } else if (isSealPositionUnlocked(this.crtSealPosition)) {
            i = this;
            sb = new StringBuffer();
            action = i.texts[45]; // "Press 5"
        } else {
            i = this;
            sb = new StringBuffer().append(a_Config.worldPrices[this.crtSealPosition]).append(" ");
            action = i.texts[48].toLowerCase(); // "Red diamonds"
        }
        i.bClassString = sb.append(action).append(" ").append(i.texts[77]).toString(); // "..." + action + " " + "to go to"
        i j = null;
        String[] array = null;
        int n = 0;
        switch (this.crtSealPosition) {
            case 0: {
                // "Angkor Wat"
                j = this;
                array = i.texts;
                n = 1;
                break;
            }
            case 1: {
                // "Bavaria"
                j = this;
                array = i.texts;
                n = 4;
                break;
            }
            case 2: {
                // "Siberia"
                j = this;
                array = i.texts;
                n = 64;
                break;
            }
            case 3: {
                // "Shop"
                j = this;
                array = i.texts;
                n = 63;
                break;
            }
            default: {
                return;
            }
        }
        j.cClassString = array[n];
    }

    private static boolean isSealPositionUnlocked(final int sealPosition) {
        return sealPosition == SEAL_POS_ANGKOR || // Angkor is unlocked
                sealPosition == SEAL_POS_SHOP || // Shop is unlocked
                unpackUint16(i.iByteArr, 6) >= a_Config.worldPrices[sealPosition]; // Do we have enough red diamonds?
    }

    private void iVoid() {
        if (!this.vBoolean) {
            this.sInt = this.qInt;
            this.tInt = this.rInt;
        }
        if (this.fBoolean) {
            i.keysPressed = 0;
            final int n = this.crtSealArrowOffsetX - this.qInt;
            final int n2 = this.crtSealArrowOffsetY - this.rInt;
            this.qInt += n / (8 - this.cByte);
            this.rInt += n2 / (8 - this.cByte);
            ++this.cByte;
            if (this.cByte == 8) {
                this.qInt = this.crtSealArrowOffsetX;
                this.rInt = this.crtSealArrowOffsetY;
                this.fBoolean = false;
                this.cByte = 0;
                this.gBoolean = true;
                this.hVoid();
            }
        } else {
            switch (this.crtSealMoveDirection) {
                case SEAL_MOVE_NOOP: break;
                case SEAL_MOVE_OK: {
                    switch (this.crtSealPosition) {
                        case SEAL_POS_ANGKOR: {
                            this.GBoolean = true;
                            this.HBoolean = true;
                            this.aClassj.freeCrtPlayerResource();
                            this.crtWorldIndex = 0;
                            this.lBoolean = false;
                            i.bByte = 15;
                            i.dZInt = bInt(this.crtWorldIndex);
                            this.avVoid();
                            break;
                        }
                        case SEAL_POS_BAVARIA: {
                            if (!isSealPositionUnlocked(this.crtSealPosition)) {
                                break;
                            }
                            this.GBoolean = true;
                            this.HBoolean = true;
                            this.aClassj.freeCrtPlayerResource();
                            this.crtWorldIndex = 1;
                            this.crtStageI = 0;
                            i.bByte = 15;
                            i.dZInt = bInt(this.crtWorldIndex);
                            this.avVoid();
                            this.pBoolean = true;
                            this.lBoolean = false;
                            if (i.iByteArr[9] < 1) {
                                i.iByteArr[9] = 1;
                                break;
                            }
                            break;
                        }
                        case SEAL_POS_SIBERIA: {
                            if (!isSealPositionUnlocked(this.crtSealPosition)) {
                                break;
                            }
                            this.GBoolean = true;
                            this.HBoolean = true;
                            this.aClassj.freeCrtPlayerResource();
                            this.crtWorldIndex = 2;
                            this.crtStageI = 0;
                            this.lBoolean = false;
                            i.bByte = 15;
                            i.dZInt = bInt(this.crtWorldIndex);
                            this.avVoid();
                            this.pBoolean = true;
                            if (i.iByteArr[9] < 2) {
                                i.iByteArr[9] = 2;
                                break;
                            }
                            break;
                        }
                        case SEAL_POS_SHOP: {
                            i.bByte = 18;
                            break;
                        }
                    }
                    break;
                }
                default: {
                    final byte newPosition = a_Config.sealMoveDirections[this.crtSealMoveDirection][this.crtSealPosition];
                    if (newPosition != -1) {
                        this.crtSealPosition = newPosition;
                        this.fBoolean = true;
                        this.crtSealArrowOffsetX = a_Config.sealArrowPosOffsets[this.crtSealPosition << 1];
                        this.crtSealArrowOffsetY = a_Config.sealArrowPosOffsets[(this.crtSealPosition << 1) + 1];
                        break;
                    }
                    break;
                }
            }
            this.crtSealMoveDirection = SEAL_MOVE_NOOP;
        }
    }

    private static String[] aClassStringArr(int n) {
        String[] n1 = new String[128];
        for (int i = 0; i <= 127; ++i) {
            try {
                n1[i] = d.getLocalizedText(i);
            } catch (Exception ex) {
                n1[i] = "E";
            }
        }
        return (String[]) (Object) n1;
    }

    private static String[] getDemoTextMapping() {
        final String[] demoTexts = new String[39];
        for (int i = 0; i < 39; ++i) {
            try {
                switch (i) {
                    case 0: {
                        demoTexts[i] = d.getLocalizedText(79);
                        break;
                    }
                    case 1: {
                        demoTexts[i] = d.getLocalizedText(80);
                        break;
                    }
                    case 2: {
                        demoTexts[i] = d.getLocalizedText(91);
                        break;
                    }
                    case 3: {
                        demoTexts[i] = d.getLocalizedText(102);
                        break;
                    }
                    case 4: {
                        demoTexts[i] = d.getLocalizedText(112);
                        break;
                    }
                    case 5: {
                        demoTexts[i] = d.getLocalizedText(113);
                        break;
                    }
                    case 6: {
                        demoTexts[i] = d.getLocalizedText(114);
                        break;
                    }
                    case 7: {
                        demoTexts[i] = d.getLocalizedText(115);
                        break;
                    }
                    case 8: {
                        demoTexts[i] = d.getLocalizedText(116);
                        break;
                    }
                    case 9: {
                        demoTexts[i] = d.getLocalizedText(117);
                        break;
                    }
                    case 10: {
                        demoTexts[i] = d.getLocalizedText(81);
                        break;
                    }
                    case 11: {
                        demoTexts[i] = d.getLocalizedText(82);
                        break;
                    }
                    case 12: {
                        demoTexts[i] = d.getLocalizedText(83);
                        break;
                    }
                    case 13: {
                        demoTexts[i] = d.getLocalizedText(84);
                        break;
                    }
                    case 14: {
                        demoTexts[i] = d.getLocalizedText(85);
                        break;
                    }
                    case 15: {
                        demoTexts[i] = d.getLocalizedText(86);
                        break;
                    }
                    case 16: {
                        demoTexts[i] = d.getLocalizedText(87);
                        break;
                    }
                    case 17: {
                        demoTexts[i] = d.getLocalizedText(88);
                        break;
                    }
                    case 18: {
                        demoTexts[i] = d.getLocalizedText(89);
                        break;
                    }
                    case 19: {
                        demoTexts[i] = d.getLocalizedText(90);
                        break;
                    }
                    case 20: {
                        demoTexts[i] = d.getLocalizedText(92);
                        break;
                    }
                    case 21: {
                        demoTexts[i] = d.getLocalizedText(93);
                        break;
                    }
                    case 22: {
                        demoTexts[i] = d.getLocalizedText(94);
                        break;
                    }
                    case 23: {
                        demoTexts[i] = d.getLocalizedText(95);
                        break;
                    }
                    case 24: {
                        demoTexts[i] = d.getLocalizedText(96);
                        break;
                    }
                    case 25: {
                        demoTexts[i] = d.getLocalizedText(97);
                        break;
                    }
                    case 26: {
                        demoTexts[i] = d.getLocalizedText(98);
                        break;
                    }
                    case 27: {
                        demoTexts[i] = d.getLocalizedText(99);
                        break;
                    }
                    case 28: {
                        demoTexts[i] = d.getLocalizedText(100);
                        break;
                    }
                    case 29: {
                        demoTexts[i] = d.getLocalizedText(101);
                        break;
                    }
                    case 30: {
                        demoTexts[i] = d.getLocalizedText(103);
                        break;
                    }
                    case 31: {
                        demoTexts[i] = d.getLocalizedText(104);
                        break;
                    }
                    case 32: {
                        demoTexts[i] = d.getLocalizedText(105);
                        break;
                    }
                    case 33: {
                        demoTexts[i] = d.getLocalizedText(106);
                        break;
                    }
                    case 34: {
                        demoTexts[i] = d.getLocalizedText(107);
                        break;
                    }
                    case 35: {
                        demoTexts[i] = d.getLocalizedText(108);
                        break;
                    }
                    case 36: {
                        demoTexts[i] = d.getLocalizedText(109);
                        break;
                    }
                    case 37: {
                        demoTexts[i] = d.getLocalizedText(110);
                        break;
                    }
                    case 38: {
                        demoTexts[i] = d.getLocalizedText(111);
                        break;
                    }
                }
            } catch (Exception ex) {
                demoTexts[i] = "E";
            }
        }
        return demoTexts;
    }

    private void jVoid() {
        try {
            int bsInt = this.bsInt;
            if (this.DBoolean) bsInt -= 5;
            ++this.bsInt;
            switch (bsInt) {
                case 0: {
                    if (this.NBoolean) {
                        this.uVoid();
                    }
                }
                case 1: {
                    if (this.MBoolean) {
                        this.xVoid();
                    }
                }
                case 2: {
                    if (this.LBoolean) {
                        System.gc();
                        this.LBoolean = false;
                    }
                }
                case 3: {
                    h.setColorToWhite();
                    h.setColorToWhite();
                }
                case 4: {
                    if (this.JBoolean) {
                        this.pVoid();
                    }
                }
                case 5: {
                    if (this.HBoolean) {
                        this.auVoid();
                    }
                }
                case 6: {
                    Label_0191:
                    {
                        final byte b;
                        int agInt;
                        if ((b = iByteArr[12]) < 1) {
                            agInt = b;
                        } else {
                            if ((this.agInt + 8) % 8 >= 1) {
                                break Label_0191;
                            }
                            agInt = 1;
                        }
                        this.agInt = agInt;
                    }
                    oVoid(this.agInt % 8);
                }
                case 7: {
                    this.baInt = this.cInt(this.crtWorldIndex, this.crtStageI);
                }
                case 8: {
                    i.cCInt = 264;
                    i.cDInt = 264;
                    i.dClassImage = Image.createImage(i.cCInt, i.cDInt);
                    i.bClassGraphics = i.dClassImage.getGraphics();
                    i.cEInt = -1;
                    i.aBoolean = false;
                    this.eBoolean = true;
                    this.aCInt = 0;
                    this.bjInt = 0;
                    this.cLong = 0L;
                    this.dLong = 0L;
                    this.abInt = 0;
                    this.acInt = 0;
                    this.kByte = 0;
                    this.PBoolean = ((this.aByte(this.crtWorldIndex, this.crtStageI) & 0x2) != 0x0);
                    this.clInt = 0;
                    // Special world config
                    switch (this.crtWorldIndex) {
                        case 0: {
                            if (this.crtStageI == STAGE_ANGKOR_FALLING_TORCHES) {
                                this.kByte = 1;
                                this.alInt = 816;
                                this.amInt = 0;
                                break;
                            }
                            if (this.crtStageI == STAGE_ANGKOR_DEMO) {
                                this.kByte = 2;
                                this.tBoolean = false;
                                break;
                            }
                            if (this.crtStageI == STAGE_ANGKOR_GREAT_ANACONDA) {
                                this.kByte = 4;
                                this.aoInt = 0;
                                this.aqInt = 3;
                                this.arInt = 0;
                                this.apInt = 0;
                                this.kBoolean = false;
                                this.cLong |= 0x8L;
                                this.cLong |= 0x400L;
                                this.OInt = 2;
                                this.PInt = 12;
                                this.QInt = 15;
                                this.RInt = 5;
                                break;
                            }
                            break;
                        }
                        case 1: {
                            if (this.crtStageI == STAGE_BAVARIA_EVIL_TEUTONIC_KNIGHT) {
                                this.yVoid();
                                break;
                            }
                            break;
                        }
                        case 2: {
                            if (this.crtStageI == STAGE_SIBERIA_YETTI) {
                                this.adVoid();
                                this.asInt = 360;
                                this.kByte = 3;
                                this.cLong |= 0x80L;
                                this.cLong |= 0x8L;
                                break;
                            }
                            break;
                        }
                    }
                    this.qBoolean = false;
                    this.rBoolean = false;
                    this.sBoolean = false;
                    this.aaInt = 0;
                    this.beInt = -1;
                    this.bfInt = -1;
                    this.oByte = 0;
                    this.bgInt = 0;
                    this.bhInt = 0;
                    this.biInt = 0;
                    this.axInt = 70;
                    this.nByte = i.iByteArr[8];
                    this.lByte = 0;
                    this.aZInt = 0;
                    this.bcInt = 0;
                    this.bdInt = 0;
                    this.bbInt = 0;
                    this.aWInt = 0;
                    this.kInt = 0;
                    this.aTInt = 0;
                    this.aUInt = 0;
                    this.aVInt = 0;
                    i.cmInt = -1;
                    i.mByteArr = null;
                    i.lByteArr = null;

                    // Load the stage
                    this.tmpInputStream = this.getClass().getResourceAsStream(i.worldFiles[this.crtWorldIndex]);
                    this.tmpInputStream.read();
                    // This while loop is why the game freezes when trying to load into a non-existent stage
                    int shouldExit = 0;
                    while (shouldExit == 0) {
                        final int worldStageCount = this.tmpInputStream.read();
                        int stageI = 0;
                        byte[] header = new byte[4];

                        while (stageI < worldStageCount && shouldExit == 0) {
                            this.tmpInputStream.read(header);
                            final int width = unpackUint16(header, 0);
                            final int height = unpackUint16(header, 2);

                            if (stageI == this.crtStageI) {
                                this.crtStageWidth = width;
                                this.crtStageHeight = height;

                                // Free memory
                                i.crtStagePlayerLayer = null;
                                i.cByteArrArr = null;
                                i.crtStageForegrondLayer = null;
                                System.gc();

                                // Allocate new memory
                                i.crtStagePlayerLayer = new byte[this.crtStageWidth][this.crtStageHeight];
                                i.cByteArrArr = new byte[this.crtStageWidth][this.crtStageHeight];
                                i.crtStageForegrondLayer = new int[this.crtStageWidth][this.crtStageHeight];

                                // Player layer
                                final byte[] layerBuffer = new byte[this.crtStageWidth * this.crtStageHeight];
                                this.tmpInputStream.read(layerBuffer);
                                for (int x = 0; x < this.crtStageWidth; ++x) {
                                    for (int y = 0; y < this.crtStageHeight; ++y) {
                                        i.crtStagePlayerLayer[x][y] = layerBuffer[x + y * this.crtStageWidth];
                                    }
                                }

                                // Background layer
                                i.bByteArrArr = new byte[this.crtStageWidth][this.crtStageHeight];
                                i.bIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
                                this.tmpInputStream.read(layerBuffer);
                                for (int x = 0; x < this.crtStageWidth; ++x) {
                                    for (int y = 0; y < this.crtStageHeight; ++y) {
                                        i.bIntArrArr[x][y] = layerBuffer[x + y * this.crtStageWidth];
                                    }
                                }

                                // Foreground layer
                                this.tmpInputStream.read(layerBuffer);
                                for (int x = 0; x < this.crtStageWidth; ++x) {
                                    for (int y = 0; y < this.crtStageHeight; ++y) {
                                        i.crtStageForegrondLayer[x][y] = layerBuffer[x + y * this.crtStageWidth];
                                    }
                                }

                                header = null;
                                shouldExit = 1;
                            } else {
                                // Skips the stage's bytes by skipping the three layers
                                this.tmpInputStream.skip(width * height * 3);
                            }
                            ++stageI;
                        }
                    }
                    this.tmpInputStream.close();
                    this.tmpInputStream = null;

                    final int n6 = 0;
                    this.cInt = n6;
                    this.aInt = n6;
                    final int n7 = 0;
                    this.dInt = n7;
                    this.bInt = n7;
                    this.aVoid();
                    System.gc();
                }
                case 9: {
                    final Hashtable<Object, Integer> hashtable = new Hashtable<Object, Integer>();
                    final Hashtable<Integer, Integer> hashtable2 = new Hashtable<Integer, Integer>();
                    final Hashtable<Integer, Integer> hashtable3 = new Hashtable<Integer, Integer>();
                    this.aiInt = 0;
                    this.ajInt = 0;
                    int n8 = 0;
                    this.aYInt = 0;
                    this.buInt = 0;
                    int n9 = 0;
                    int n10 = 0;
                    this.crtShouldLoadWaterBreathingPotion = false;
                    this.ahBoolean = false;
                    this.crtShouldLoadFanPot = false;
                    this.awInt = 0;
                    int n11 = 0;
                    for (int x = 0; x < this.crtStageWidth; ++x) {
                        for (int y = 0; y < this.crtStageHeight; ++y) {
                            i.bByteArrArr[x][y] = 0;
                            i.cByteArrArr[x][y] = 0;
                            final int foreground = i.crtStageForegrondLayer[x][y];
                            final int background = i.bIntArrArr[x][y];
                            final byte player = i.crtStagePlayerLayer[x][y];
                            Label_2656:
                            {
                                if (foreground != -1) {
                                    switch (foreground & 0xFF) {
                                        case 31: {
                                            this.cLong |= 0x40000000L;
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | 0x1F);
                                        }
                                        case 19: {
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | 0x13);
                                            break;
                                        }
                                        case 17: {
                                            final int n16;
                                            if ((n16 = (i.crtStageForegrondLayer[x][y - 1] & 0xFF)) == 14 || n16 == 33) {
                                                i.crtStageForegrondLayer[x][y - 1] = (0xFF00 | n16);
                                            }
                                            final byte b5;
                                            switch (b5 = i.crtStagePlayerLayer[x][y - 1]) {
                                                case 19:
                                                case 36:
                                                case 43:
                                                case 45:
                                                case 46:
                                                case 49: {
                                                    final Integer n17 = background;
                                                    final Integer n18;
                                                    hashtable2.put(n17, ((n18 = hashtable2.get(n17)) == null) ? 1 : n18 + 1);
                                                    i.crtStageForegrondLayer[x][y] = -1;
                                                    final Integer n19 = hashtable3.get(n17);
                                                    if (b5 == 36) {
                                                        if (n19 == null) {
                                                            hashtable3.put(n17, 58);
                                                            break;
                                                        }
                                                        break;
                                                    } else {
                                                        hashtable3.put(n17, 56);
                                                        if (this.kByte == 4) {
                                                            hashtable3.put(n17, 51);
                                                            break;
                                                        }
                                                        if (this.kByte == 5) {
                                                            hashtable3.put(n17, 52);
                                                            break;
                                                        }
                                                        if (this.kByte == 3) {
                                                            hashtable3.put(n17, 53);
                                                            break;
                                                        }
                                                        break;
                                                    }
//                                                    break;
                                                }
                                                default: {
                                                    i.crtStageForegrondLayer[x][y] = (background << 8 | 0x11);
                                                    break;
                                                }
                                            }
                                            if (background >= 0) {
                                                n10 |= 1 << background;
                                                break;
                                            }
                                            break;
                                        }
                                        case 14:
                                        case 33: {
                                            if (!this.fBoolean()) {
                                                i.crtStageForegrondLayer[x][y] = 33;
                                            }
                                            this.cLong |= 1L << (((i.crtStageForegrondLayer[x][y] & 0xFF) == 0xE) ? 22 : 33);
                                            if (!this.aBoolean(this.crtWorldIndex, this.crtStageI, x, y)) {
                                                break;
                                            }
                                            if (this.fBoolean()) {
                                                i.crtStagePlayerLayer[x][y] = 41;
                                                i.bIntArrArr[x][y] = 10;
                                                this.aYInt += 10;
                                                break;
                                            }
                                            i.crtStagePlayerLayer[x][y] = -1;
                                            final int[] array = i.crtStageForegrondLayer[x];
                                            final int n20 = y;
                                            array[n20] |= 0x100;
                                            break;
                                        }
                                        case 2: {
                                            this.cLong |= 0x100000L;
                                            switch (background) {
                                                case 0:
                                                case 1: {
                                                    this.cLong |= 0x80000L;
                                                    break;
                                                }
                                            }
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | 0x2);
                                            break;
                                        }
                                        case 8: {
                                            this.ahBoolean = true;
                                        }
                                        case 9: {
                                            if ((foreground & 0xFF) != 0x8) {
                                                this.crtShouldLoadWaterBreathingPotion = true;
                                            }
                                            this.cLong |= 0x10000000L;
                                            final Integer n21 = background;
                                            final Integer n22;
                                            hashtable.put(n21, ((n22 = hashtable.get(n21)) == null) ? 1 : n22 + 1);
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | foreground);
                                            break;
                                        }
                                        case 7: {
                                            if (background != -1) {
                                                i.crtStageDoorXs[background] = (byte) x;
                                                i.crtStageDoorYs[background] = (byte) y;
                                            }
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | foreground);
                                            break;
                                        }
                                        case 30: {
                                            this.cLong |= 0x40000000L;
                                            ++n11;
                                        }
                                        case 1:
                                        case 26: {
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | (foreground & 0xFF));
                                            break;
                                        }
                                        case 0: {
                                            ++n11;
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | (foreground & 0xFF));
                                            break;
                                        }
                                        case 4: {
                                            ++n9;
                                            this.cLong |= 0x10L;
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | (foreground & 0xFF));
                                            break;
                                        }
                                        case 5: {
                                            this.pByte = (byte) background;
                                            break;
                                        }
                                        case 28: {
                                            this.qByte = (byte) background;
                                            break;
                                        }
                                        case 3: {
                                            i.cByteArrArr[x][y] = 127;
                                            if (background > 0) {
                                                i.crtStageForegrondLayer[x][y] = (background + 1 << 8 | 0x3);
                                                break;
                                            }
                                            break;
                                        }
                                        case 6: {
                                            final Integer n23 = background;
                                            final Integer n24;
                                            hashtable.put(n23, ((n24 = hashtable.get(n23)) == null) ? 1 : n24 + 1);
                                            this.cLong |= 0x20000000L;
                                            i.crtStageForegrondLayer[x][y] = (background << 8 | 0x6);
                                            break;
                                        }
                                        default: {
                                            if (foreground >= 20 && foreground < 26) {
                                                i.crtStageForegrondLayer[x][y] = foreground;
                                                while (true) {
                                                    i m = null;
                                                    long n25 = 0L;
                                                    long n26 = 0L;
                                                    switch (this.crtWorldIndex) {
                                                        case 0: {
                                                            m = this;
                                                            n25 = this.cLong;
                                                            n26 = 16L;
                                                            break;
                                                        }
                                                        case 1: {
                                                            m = this;
                                                            n25 = this.cLong;
                                                            n26 = 2097152L;
                                                            break;
                                                        }
                                                        default: {
                                                            break Label_2656;
                                                        }
                                                    }
                                                    m.cLong = (n25 | n26);
                                                    continue;
                                                }
                                            }
                                            if (foreground < 80 && foreground > -1) {
                                                i.crtStageForegrondLayer[x][y] = -1;
                                                break;
                                            }
                                            break;
                                        }
                                        case 34: {
                                            this.cLong |= 0x400000000L;
                                            break;
                                        }
                                    }
                                }
                            }
                            byte[] array3 = null;
                            int n30 = 0;
                            int n31 = 0;
                            switch (player) {
                                case 48: {
                                    int[] array2;
                                    int n27;
                                    int n28;
                                    if ((background & 0x7) == 0x4) {
                                        array2 = i.bIntArrArr[x];
                                        n27 = y;
                                        n28 = 16;
                                    } else {
                                        array2 = i.bIntArrArr[x];
                                        n27 = y;
                                        n28 = 0;
                                    }
                                    array2[n27] = n28;
                                    ++this.awInt;
                                    this.cLong |= 0x10000000000L;
                                    this.cLong |= 0x100000000L;
                                    final int n29 = y - 1;
                                    i.crtStagePlayerLayer[x][n29] = 48;
                                    i.bIntArrArr[x][n29] = 8;
                                    kVoid(x, n29);
                                    continue;
                                }
                                case 47: {
                                    i.cByteArrArr[x][y] = 48;
                                    i.bIntArrArr[x][y] = 0;
                                    this.cLong |= 0x800000L;
                                    continue;
                                }
                                case 46: {
                                    i.bIntArrArr[x][y] = 0;
                                    i.cByteArrArr[x][y] = 24;
                                    i.bByteArrArr[x][y] = 0;
                                    this.cLong |= 0x2000000000L;
                                    continue;
                                }
                                case 45: {
                                    i.bIntArrArr[x][y] = 0;
                                    i.cByteArrArr[x][y] = 24;
                                    this.cLong |= 0x800000000L;
                                    continue;
                                }
                                case 44: {
                                    i.cByteArrArr[x][y] = 24;
                                    i.bIntArrArr[x][y] = 0;
                                    this.cLong |= 0x400000000L;
                                    continue;
                                }
                                case 42: {
                                    ++n11;
                                    ++n8;
                                    this.cLong |= 0x80000000L;
                                    this.cLong |= 0x40000000L;
                                    this.iVoid(x, y);
                                    continue;
                                }
                                case 41: {
                                    if (i.bIntArrArr[x][y] <= 0) {
                                        i.bIntArrArr[x][y] = 1;
                                    }
                                    this.aYInt += i.bIntArrArr[x][y];
                                    continue;
                                }
                                case 40: {
                                    this.cLong |= 0x40000000L;
                                    ++n11;
                                    this.lBoolean = true;
                                    this.cLong |= 0x8000000L;
                                    this.iVoid(x, y);
                                    ++n8;
                                    continue;
                                }
                                case 12: {
                                    i.crtStagePlayerLayer[x][y] = -1;
                                    this.abInt = x;
                                    this.acInt = y;
                                    this.aaInt = background;
                                    continue;
                                }
                                case 36: {
                                    if (i.bIntArrArr[x][y] != 1) {
                                        i.bIntArrArr[x][y] = 0;
                                    }
                                    this.cLong |= 0x100L;
                                    continue;
                                }
                                case 18: {
                                    this.ceInt = 0;
                                    this.cfInt = 0;
                                    this.cLong |= 0x8000000000L;
                                    this.cLong |= 0x80L;
                                    continue;
                                }
                                case 34: {
                                    i.crtStagePlayerLayer[x][y] = -1;
                                    i.crtStageForegrondLayer[x][y] = 15;
                                    this.cLong |= 0x1000000L;
                                    continue;
                                }
                                case 35: {
                                    i.crtStagePlayerLayer[x][y] = 35;
                                    i.crtStageForegrondLayer[x][y] = -1;
                                    this.cLong |= 0x1000000L;
                                    this.crtShouldLoadFanPot = true;
                                }
                                case 31:
                                case 33: {
                                    continue;
                                }
                                case 39: {
                                    this.lBoolean = true;
                                    this.cLong |= 0x4000000L;
                                    continue;
                                }
                                case 38: {
                                    this.lBoolean = true;
                                    this.cLong |= 0x4000000L;
                                    i.crtStageForegrondLayer[x][y] = 27;
                                    this.cLong |= 0x40L;
                                    continue;
                                }
                                case 14: {
                                    this.cLong |= 0x1000L;
                                    i.bIntArrArr[x][y] = ((i.bIntArrArr[x][y] == 4) ? 8 : 0);
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 24;
                                    break;
                                }
                                case 28: {
                                    this.cLong |= 0x800L;
                                    if (background > 10) {
                                        final int[] array4 = i.bIntArrArr[x];
                                        final int n32 = y;
                                        array4[n32] /= 11;
                                        final int[] array5 = i.bIntArrArr[x];
                                        final int n33 = y;
                                        array5[n33] |= 0x8;
                                    }
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 24;
                                    break;
                                }
                                case 79: {
                                    this.crtPlayerX = 0;
                                    this.crtPlayerY = y;
                                    this.ayInt = x;
                                    i.crtStagePlayerLayer[x][y] = -1;
                                    final int n34 = 0;
                                    this.cInt = n34;
                                    this.aInt = n34;
                                    final int n35 = this.crtPlayerY * 24 - 160;
                                    this.dInt = n35;
                                    this.bInt = n35;
                                    continue;
                                }
                                case 11: {
                                    i.bIntArrArr[x][y] = ((background == 1) ? 16 : 0);
                                    i.cByteArrArr[x][y] = 48;
                                    this.cLong |= 0x4000L;
                                    continue;
                                }
                                case 49: {
                                    this.cLong |= 0x20000000000L;
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 48;
                                    break;
                                }
                                case 43: {
                                    this.cLong |= 1L << ((this.crtWorldIndex == 1) ? 17 : 15);
                                    this.buInt |= 0x1;
                                    i.bIntArrArr[x][y] = ((background & 0xFFFE7FFF) | 0x10000);
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 48;
                                    break;
                                }
                                case 19: {
                                    this.cLong |= 1L << ((this.crtWorldIndex == 1) ? 17 : 15);
                                    this.buInt |= 0x2;
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 48;
                                    break;
                                }
                                case 22:
                                case 23: {
                                    this.cLong |= 0x200L;
                                    this.cLong |= 0x400L;
                                    array3 = i.cByteArrArr[x];
                                    n30 = y;
                                    n31 = 48;
                                    break;
                                }
                                case 30: {
                                    this.cLong |= 0x80L;
                                    i.bIntArrArr[x][y] = 0;
                                    continue;
                                }
                                case 37: {
                                    this.cLong |= 0x2000000L;
                                    i.bIntArrArr[x][y] = 0;
                                    continue;
                                }
                                case 10: {
                                    i.bIntArrArr[x][y] = 0;
                                    this.dLong |= 0x2L;
                                    continue;
                                }
                                case 16: {
                                    if (i.crtStagePlayerLayer[x][y + 1] != 16) {
                                        i.crtStagePlayerLayer[x][y - 1] = 16;
                                        i.bIntArrArr[x][y - 1] = background;
                                    }
                                    this.cLong |= 0x2000L;
                                    continue;
                                }
                                case 6: {
                                    ++n8;
                                    this.iVoid(x, y);
                                }
                                case 7: {
                                    this.cLong |= 0x10L;
                                    i.bIntArrArr[x][y] = 0;
                                    continue;
                                }
                                case 26: {
                                    this.cLong |= 0x10000000000L;
                                }
                                case 24:
                                case 27: {
                                    ++n11;
                                    ++n8;
                                    this.cLong |= 0x40000000L;
                                    this.cLong |= 0x80000L;
                                    this.iVoid(x, y);
                                    continue;
                                }
                                case 8: {
                                    this.cLong |= 0x20L;
                                    this.cLong |= 0x8L;
                                }
                                case 4: {
                                    if (player != 8) {
                                        this.iVoid(x, y);
                                    }
                                }
                                case 5: {
                                    this.cLong |= 0x4L;
                                }
                                case 2: {
                                    ++n8;
                                }
                                case 0: {
                                    i.cByteArrArr[x][y] = 48;
                                    i.bIntArrArr[x][y] = 0;
                                    this.dLong |= 0x1L;
                                    continue;
                                }
                                case 1: {
                                    ++this.aYInt;
                                    i.cByteArrArr[x][y] = 48;
                                    i.bIntArrArr[x][y] = 0;
                                }
                                case 53: {
                                }
                                case 51: {
                                }
                                case 52: {
                                    continue;
                                }
                                default: {
                                    if (player < 80 && player > -1) {
                                        array3 = i.crtStagePlayerLayer[x];
                                        n30 = y;
                                        n31 = -1;
                                        break;
                                    }
                                    continue;
                                }
                            }
                            array3[n30] = (byte) n31;
                        }
                    }
                    i.dByteArr = new byte[n8 << 1];
                    for (int n36 = 0; n36 < i.dByteArr.length; ++n36) {
                        i.dByteArr[n36] = 0;
                    }
                    i.aClasscArr = new c[n11];
                    i.pByteArr = new byte[n11];
                    int n37 = 0;
                    i.kByteArr = new byte[n9 + 1 << 1];
                    int n38;
                    for (n38 = 31; n38 >= 0 && (n10 & 1 << n38) == 0x0; --n38) {
                    }
                    if (++n38 > 0) {
                        i.mByteArr = new byte[n38];
                        i.lByteArr = new byte[n38];
                    }
                    if (this.awInt > 0) {
                        i.eByteArr = new byte[this.awInt * 3];
                    }
                    int n39 = 0;
                    for (int n40 = 0; n40 < this.crtStageHeight; ++n40) {
                        for (int n41 = 0; n41 < this.crtStageWidth; ++n41) {
                            final int n42 = i.crtStageForegrondLayer[n41][n40] & 0xFF;
                            final int n43 = i.crtStageForegrondLayer[n41][n40] >> 8;
                            Label_5021:
                            {
                                byte[] array6 = null;
                                int n44 = 0;
                                byte byteValue = 0;
                                switch (n42) {
                                    case 0:
                                    case 30: {
                                        array6 = i.pByteArr;
                                        n44 = n37++;
                                        byteValue = (byte) n43;
                                        break;
                                    }
                                    case 7: {
                                        final Integer n45 = hashtable.get(n43);
                                        int n46 = n43 << 8;
                                        if (n45 != null) {
                                            n46 = ((n46 & 0xFFFFFFF0) | n45);
                                        }
                                        final boolean b6 = (i.crtStageForegrondLayer[n41][n40 - 1] & 0xFF) == 0x11;
                                        final boolean b7 = (i.crtStageForegrondLayer[n41][n40 + 1] & 0xFF) == 0x11 && (i.crtStageForegrondLayer[n41 + 1][n40] & 0xFF) != 0x1A && (i.crtStageForegrondLayer[n41 - 1][n40] & 0xFF) != 0x1A;
                                        if (b6 || b7) {
                                            n46 = ((n46 & 0xFFFFFF0F) | 0x30);
                                            i.cByteArrArr[n41][n40] = 24;
                                            if (b6) {
                                                i.crtStageForegrondLayer[n41][n40 - 1] = -1;
                                            }
                                        }
                                        i.crtStageForegrondLayer[n41][n40] = (n46 << 8 | n42);
                                        break Label_5021;
                                    }
                                    case 4: {
                                        final int n47 = n43;
                                        i.kByteArr[n47 << 1] = (byte) n41;
                                        array6 = i.kByteArr;
                                        n44 = (n47 << 1) + 1;
                                        byteValue = (byte) n40;
                                        break;
                                    }
                                    case 5: {
                                        i.kByteArr[n9 << 1] = (byte) n41;
                                        array6 = i.kByteArr;
                                        n44 = (n9 << 1) + 1;
                                        byteValue = (byte) n40;
                                        break;
                                    }
                                    case 17: {
                                        if (n43 != -1) {
                                            final Integer n48 = n43;
                                            Integer n49;
                                            if ((n49 = hashtable2.get(n48)) == null) {
                                                n49 = 0;
                                            }
                                            i.mByteArr[n43] = n49.byteValue();
                                            Integer n50;
                                            if ((n50 = hashtable3.get(n48)) == null) {
                                                n50 = 57;
                                            }
                                            array6 = i.lByteArr;
                                            n44 = n43;
                                            byteValue = n50.byteValue();
                                            break;
                                        }
                                        break Label_5021;
                                    }
                                }
                                array6[n44] = byteValue;
                            }
                            byte[] array8 = null;
                            int n55 = 0;
                            int n56 = 0;
                            switch (i.crtStagePlayerLayer[n41][n40]) {
                                case 48: {
                                    if ((i.bIntArrArr[n41][n40] & 0x8) != 0x0) {
                                        final int n51 = n41 + (((i.bIntArrArr[n41][n40 + 1] & 0x10) == 0x0) ? 1 : -1);
                                        final int n52 = n39 * 3;
                                        byte[] array7;
                                        int n53;
                                        int n54;
                                        if (dInt(n51, n40) >= 0) {
                                            i.eByteArr[n52] = (byte) n51;
                                            i.eByteArr[n52 + 1] = (byte) n51;
                                            array7 = i.eByteArr;
                                            n53 = n52 + 2;
                                            n54 = (byte) n40;
                                        } else {
                                            array7 = i.eByteArr;
                                            n53 = n52 + 2;
                                            n54 = -1;
                                        }
                                        array7[n53] = (byte) n54;
                                        i.bIntArrArr[n41][n40] = ((i.bIntArrArr[n41][n40] & 0xFFFFFF) | n39 << 24);
                                        ++n39;
                                    }
                                    continue;
                                }
                                case 26: {
                                    array8 = i.pByteArr;
                                    n55 = n37++;
                                    n56 = 25;
                                    break;
                                }
                                case 42: {
                                    array8 = i.pByteArr;
                                    n55 = n37++;
                                    n56 = 11;
                                    break;
                                }
                                case 24: {
                                    array8 = i.pByteArr;
                                    n55 = n37++;
                                    n56 = 22;
                                    break;
                                }
                                case 27: {
                                    array8 = i.pByteArr;
                                    n55 = n37++;
                                    n56 = 23;
                                    break;
                                }
                                case 40: {
                                    array8 = i.pByteArr;
                                    n55 = n37++;
                                    n56 = 24;
                                    break;
                                }
                            }
                            array8[n55] = (byte) n56;
                        }
                    }
                    i.crtStageForegrondLayer[this.ayInt - 2][this.crtPlayerY] = (-193 << 8 | 0x7);
                    if ((this.cLong & 0x100000000L) != 0x0L || i.iByteArr[9] >= 8) {
                        this.cLong |= 0x10000000000L;
                        this.cLong |= 0x2L;
                        this.cLong |= 0x1L;
                        if ((this.cLong & 0x20000L) != 0x0L) {
                            this.cLong |= 0x40000L;
                        }
                        if ((this.cLong & 0x8000L) != 0x0L) {
                            this.cLong |= 0x10000L;
                        }
                        if ((this.cLong & 0x800000000L) != 0x0L) {
                            this.cLong |= 0x1000000000L;
                        }
                        if ((this.cLong & 0x2000000000L) != 0x0L) {
                            this.cLong |= 0x4000000000L;
                        }
                        if ((this.cLong & 0x20000000000L) != 0x0L) {
                            this.cLong |= 0x40000000000L;
                        }
                    }
                }
                case 10: {
                    this.tmpInputStream = this.getClass().getResourceAsStream("/" + this.crtWorldIndex + ".f");
                    this.ccInt = this.tmpInputStream.read();
                    i.tmpBytes = new byte[this.ccInt << 3];
                    this.tmpInputStream.read(i.tmpBytes);
                }
                default: {
                    int n57 = bsInt - 10 - 1;
                    // 0.f, 1.f or 2.f chunks 0-3 loading
                    if (n57 < 4) {
                        final int chunkI = n57;
                        final byte[] b8 = new byte[unpackUint32(i.tmpBytes, (chunkI << 3) + 4)];
                        this.tmpInputStream.read(b8);
                        final f_Sprite f;
                        (f = new f_Sprite()).parseSprite(b8, 0);
                        f.createImages(0, 0, -1, -1);
                        Label_5745:
                        {
                            switch (chunkI) {
                                case 0: {
                                    if ((this.dLong & 0x1L) != 0x0L) {
                                        i.aClassfArr[60] = f;
                                        break;
                                    }
                                    break Label_5745;
                                }
                                case 1: {
                                    if ((this.dLong & 0x2L) != 0x0L) {
                                        i.aClassfArr[16] = f;
                                        break;
                                    }
                                    break Label_5745;
                                }
                                case 2: {
                                    i.textures[0] = null;
                                    i.aClassfArr[42] = f;
                                    break;
                                }
                                case 3: {
                                    i.textures[8] = f.images[0];
                                    break;
                                }
                            }
                        }
                        f.moduleData = null;
                        this.crtGenFileI = 0;
                        return;
                    }
                    n57 -= 4;
                    // genx.f chunks 0-42 loading (x = chunkI // 10, chunk = chunkI % 10, e.g., 10 chunks per file)
                    if (n57 >= 0 && n57 < 43) {
                        final int chunkI = n57;
                        try {
                            if (chunkI % 10 == 0) {
                                this.tmpInputStream.close();
                                this.tmpInputStream = null;
                                this.tmpInputStream = this.getClass().getResourceAsStream("/gen" + this.crtGenFileI + ".f");
                                this.ccInt = this.tmpInputStream.read();
                                i.tmpBytes = new byte[this.ccInt << 3];
                                this.tmpInputStream.read(i.tmpBytes);
                                this.cdInt = 0;
                                ++this.crtGenFileI;
                            }
                            final int chunkLength = unpackUint32(i.tmpBytes, (chunkI - (this.crtGenFileI - 1) * 10 << 3) + 4);
                            if ((this.cLong & 1L << chunkI) != 0x0L) {
                                if (this.cdInt != 0) {
                                    this.tmpInputStream.skip(this.cdInt);
                                    this.cdInt = 0;
                                }
                                final byte[] data = new byte[chunkLength];
                                this.tmpInputStream.read(data);
                                final f_Sprite sprite = new f_Sprite();
                                sprite.parseSprite(data, 0);
                                if ((chunkI != 28 || this.crtShouldLoadWaterBreathingPotion) && (chunkI != 24 || this.crtShouldLoadFanPot)) {
                                    sprite.createImages(0, 0, -1, -1);
                                }
                                int n61 = -1;
                                int n62 = -1;
                                Label_6692:
                                {
                                    int n63 = 0;
                                    switch (chunkI) {
                                        case 41: {
                                            n61 = 38;
                                            break Label_6692;
                                        }
                                        case 42: {
                                            n61 = 39;
                                            break Label_6692;
                                        }
                                        case 0: {
                                            n61 = 33;
                                            break Label_6692;
                                        }
                                        case 36: {
                                            n61 = 35;
                                            break Label_6692;
                                        }
                                        case 1: {
                                            n61 = 34;
                                            break Label_6692;
                                        }
                                        case 38: {
                                            n61 = 36;
                                            break Label_6692;
                                        }
                                        case 16:
                                        case 18: {
                                            n61 = 37;
                                            break Label_6692;
                                        }
                                        case 40: {
                                            n61 = 2;
                                            break Label_6692;
                                        }
                                        case 32: {
                                            n61 = 32;
                                            break Label_6692;
                                        }
                                        case 23: {
                                            n61 = 30;
                                            break Label_6692;
                                        }
                                        case 37: {
                                            n61 = 29;
                                            break Label_6692;
                                        }
                                        case 35: {
                                            n61 = 28;
                                            break Label_6692;
                                        }
                                        case 34: {
                                            n61 = 27;
                                            break Label_6692;
                                        }
                                        case 33: {
                                            n61 = 22;
                                            break Label_6692;
                                        }
                                        case 31: {
                                            n63 = 29;
                                            break;
                                        }
                                        case 30: {
                                            n61 = 15;
                                            break Label_6692;
                                        }
                                        case 28: {
                                            if (this.ahBoolean) {
                                                sprite.createImages(1, 0, -1, -1);
                                            }
                                            n61 = 45;
                                            break Label_6692;
                                        }
                                        case 29: {
                                            n63 = 26;
                                            break;
                                        }
                                        case 2: {
                                            if (this.crtShouldLoadWaterBreathingPotion) {
                                                i.textures[24] = sprite.images[0];
                                            }
                                            if (this.ahBoolean) {
                                                sprite.createImages(1, 0, -1, -1);
                                                i.textures[25] = sprite.images[1];
                                            }
                                            break Label_6692;
                                        }
                                        case 6: {
                                            n63 = 21;
                                            break;
                                        }
                                        case 27: {
                                            n63 = 19;
                                            break;
                                        }
                                        case 26: {
                                            i.dClassf = sprite;
                                            break Label_6692;
                                        }
                                        case 25: {
                                            n63 = 17;
                                            break;
                                        }
                                        case 5: {
                                            n61 = 58;
                                            break Label_6692;
                                        }
                                        case 3: {
                                            n61 = 7;
                                            break Label_6692;
                                        }
                                        case 39: {
                                            n61 = 6;
                                            break Label_6692;
                                        }
                                        case 8: {
                                            n61 = 5;
                                            break Label_6692;
                                        }
                                        case 24: {
                                            i.textures[15] = null;
                                            sprite.createImages(1, 0, -1, -1);
                                            n61 = 57;
                                            i.textures[14] = null;
                                            break Label_6692;
                                        }
                                        case 22: {
                                            n61 = 8;
                                            break Label_6692;
                                        }
                                        case 20: {
                                            n63 = 13;
                                            break;
                                        }
                                        case 4:
                                        case 21: {
                                            if (this.crtWorldIndex != 2) {
                                                n61 = 3;
                                            }
                                            break Label_6692;
                                        }
                                        case 7: {
                                            if (this.crtWorldIndex == 2) {
                                                sprite.images = null;
                                                sprite.createImages(1, 0, -1, -1);
                                                sprite.paletteI = 1;
                                            }
                                            n61 = 20;
                                            break Label_6692;
                                        }
                                        case 14: {
                                            n63 = 6;
                                            break;
                                        }
                                        case 10: {
                                            (i.aClassbArr[4] = new b_SpriteAnimator(sprite, 0, 0, null)).setAnimation(0);
                                            break Label_6692;
                                        }
                                        case 9: {
                                            n61 = 12;
                                            break Label_6692;
                                        }
                                        case 15:
                                        case 17: {
                                            if ((this.buInt & 0x2) != 0x0) {
                                                if (this.crtWorldIndex == 2) {
                                                    sprite.images = null;
                                                    sprite.createImages(2, 0, -1, -1);
                                                    sprite.paletteI = 2;
                                                }
                                                n61 = 4;
                                            }
                                            if ((this.buInt & 0x1) != 0x0) {
                                                (i.aClassfArr[21] = new f_Sprite()).parseSprite(data, 0);
                                                i.aClassfArr[21].createImages(1, 0, -1, -1);
                                                i.aClassfArr[21].paletteI = 1;
                                                i.aClassfArr[21].moduleData = null;
                                            }
                                            break Label_6692;
                                        }
                                        case 13: {
                                            n61 = 1;
                                            break Label_6692;
                                        }
                                        case 11: {
                                            n61 = 11;
                                            break Label_6692;
                                        }
                                        case 19: {
                                            n63 = 7;
                                            break;
                                        }
                                        case 12: {
                                            n63 = 10;
                                            break;
                                        }
                                    }
                                    n62 = n63;
                                }
                                if (n61 != -1) {
                                    i.aClassfArr[n61] = sprite;
                                }
                                if (n62 != -1) {
                                    i.textures[n62] = sprite.images[0];
                                }
                                sprite.moduleData = null;
                                return;
                            }
                            this.cdInt += chunkLength;
                            return;
                        } catch (IOException ex) {
                            return;
                        }
                    }
                    n57 -= 43;
                    // cm.f chunks 0-8 loading
                    if (n57 >= 0 && n57 < 8) {
                        final int chunkI = n57;
                        try {
                            if (chunkI == 0) {
                                this.tmpInputStream.close();
                                this.tmpInputStream = null;
                                System.gc();
                                this.tmpInputStream = this.getClass().getResourceAsStream("/cm.f");
                                this.ccInt = this.tmpInputStream.read();
                                i.tmpBytes = new byte[this.ccInt << 3];
                                this.tmpInputStream.read(i.tmpBytes);
                            }
                            final byte[] b10 = new byte[unpackUint32(i.tmpBytes, (chunkI << 3) + 4)];
                            this.tmpInputStream.read(b10);
                            final f_Sprite f2;
                            (f2 = new f_Sprite()).parseSprite(b10, 0);
                            f2.createImages(0, 0, -1, -1);
                            Label_7075:
                            {
                                Label_7074:
                                {
                                    switch (chunkI) {
                                        case 6: {
                                            i.aClassfArr[43] = f2;
                                            i.textures[20] = null;
                                            break Label_7074;
                                        }
                                        case 5: {
                                            i.textures[18] = f2.images[0];
                                            break;
                                        }
                                        case 2: {
                                            f2.createImages(1, 0, 0, -1);
                                            i.aClassfArr[59] = f2;
                                            break Label_7074;
                                        }
                                        case 1: {
                                            switch (this.crtWorldIndex) {
                                                case 1:
                                                case 2: {
                                                    if (this.crtWorldIndex != 0) {
                                                        f2.createImages(this.crtWorldIndex, 0, -1, -1);
                                                        f2.freePalette0Images(0);
                                                        f2.paletteI = this.crtWorldIndex;
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            i.aClassfArr[56] = f2;
                                            break Label_7074;
                                        }
                                        case 3: {
                                            i.aClassfArr[13] = f2;
                                            this.rVoid();
                                            break Label_7075;
                                        }
                                        case 0: {
                                            i.textures[11] = f2.images[0];
                                            break;
                                        }
                                        case 4: {
                                            i.textures[5] = f2.images[0];
                                            break;
                                        }
                                    }
                                }
                            }
                            f2.moduleData = null;
                        } catch (Exception ex2) {
                        }
                        if (n57 == 7) {
                            this.tmpInputStream.close();
                            this.tmpInputStream = null;
                            System.gc();
                        }
                        return;
                    }
                    n57 -= 8;
                    // demo.f all demos loading
                    if (n57 >= 0 && n57 < 16) {
                        if (n57 < i.aClasscArr.length) {
                            (i.aClasscArr[n57] = new c(this)).aVoid((int) i.pByteArr[n57]);
                        }
                        if (n57 == 15 && i.aClasscArr.length >= 16) {
                            for (int n66 = 16; n66 < i.aClasscArr.length; ++n66) {
                                (i.aClasscArr[n66] = new c(this)).aVoid((int) i.pByteArr[n66]);
                            }
                        }
                        return;
                    }
                    n57 -= 16;
                    if (n57 < 0 || n57 >= 3) {
                        n57 -= 3;
                        switch (n57) {
                            case 0: {
                                i.tmpBytes = null;
                                this.loadHeroSprite(i.aClassfArr[12] != null || i.textures[6] != null || i.aClassfArr[58] != null || this.kByte == 1 || this.kByte == 4 || this.kByte == 5);
                            }
                            case 1: {
                                this.cLong = 0L;
                                this.dLong = 0L;
                                this.buInt = 0;
                                ++this.agInt;
                                i.iByteArr[12] = (byte) ((this.agInt < 3) ? this.agInt : 3);
                                this.uVoid();
                            }
                            // Clear checkpoint buffers
                            case 2: {
                                i.cIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
                                i.dByteArrArr = new byte[this.crtStageWidth][this.crtStageHeight];
                                i.eByteArrArr = new byte[this.crtStageWidth][this.crtStageHeight];
                                i.dIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
                                if (i.mByteArr != null) {
                                    i.oByteArr = new byte[i.mByteArr.length];
                                    return;
                                }
                                break;
                            }
                            case 3: {
                                if (this.lBoolean) {
                                    this.arVoid();
                                    i.eIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
                                    this.afVoid();
                                }
                            }
                            case 4: {
                                this.blInt = 0;
                                final int n67 = 0;
                                this.aeInt = n67;
                                this.adInt = n67;
                                this.saveCheckpoint();
                            }
                            case 5: {
                                this.bnInt = i.aSInt + 60;
                                this.qVoid();
                            }
                            case 6: {
                                aVoid(i.aClassf, true);
                                i.aClassf = null;
                                System.gc();
                            }
                            // Done, play sound etc.
                            case 7: {
                                this.DBoolean = false;
                                i.fByteArr = null;
                                System.gc();
                                this.aClassj.playSound(j_SoundManager.SOUND_M_ANGKOR_WAT + this.crtWorldIndex);
                                System.out.println("Move to crash.");
                                i.bByte = 1;
                                break;
                            }
                        }
                        return;
                    }
                    switch (this.kByte) {
                        case 1: {
                            this.dVoid(n57);
                            if (n57 == 2) {
                                this.tmpInputStream.close();
                                this.tmpInputStream = null;
                            }
                            return;
                        }
                        case 3: {
                            if (n57 > 0) {
                                return;
                            }
                            i.textures[31] = loadSprite("/mmv.f", 1, 0).images[0];
                            (i.aClassbArr[5] = new b_SpriteAnimator(loadSprite("/mm1.f", 0), 0, 0, null)).setAnimation(0);
                            return;
                        }
                        case 4: {
                            if (n57 >= 2) {
                                return;
                            }
                            this.cVoid(n57);
                            i.textures[32] = loadSprite("/mmv.f", 3, 0).images[0];
                            i.aClassfArr[20] = loadSprite("/gen0.f", 7, 0);
                            if (n57 == 1) {
                                this.tmpInputStream.close();
                                this.tmpInputStream = null;
                            }
                            return;
                        }
                        case 5: {
                            i.textures[30] = loadSprite("/mmv.f", 2, 0).images[0];
                            i.aClassfArr[20] = loadSprite("/gen0.f", 7, 0);
                            (i.aClassbArr[5] = new b_SpriteAnimator(loadSprite("/b1.f", 0), 0, 0, null)).setAnimation(10);
                            return;
                        }
                        default: {
                            return;
                        }
                    }
//                    break;
                }
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Loads the hero sprite and animator.
     * @param loadChunk2 Whether to load the chunk 2, containing the hero on fire animation.
     * @see <a href="https://kubikaugustyn.github.io/diamondRush/browser/all_files_new/?fileName=o.f">o.f file contents</a>
     */
    private void loadHeroSprite(final boolean loadChunk2) {
        try {
            InputStream stream = this.getClass().getResourceAsStream("/o.f");
            final byte[] chunksHeader = new byte[stream.read() << 3];
            stream.read(chunksHeader);
            final byte[] heroData = new byte[unpackUint32(chunksHeader, 4)];
            stream.read(heroData);
            if (!loadChunk2) {
                stream.close();
                stream = null;
                System.gc();
            }

            final f_Sprite hero = new f_Sprite();
            hero.parseSprite(heroData, 0);
            this.crtHeroPalette = i.iByteArr[8] - 4;
            hero.createImages(this.crtHeroPalette, 0, -1, -1);
            hero.paletteI = this.crtHeroPalette;
            hero.moduleData = null;
            System.out.println("Set value to i.aClassbArr[0]. new b(f==<TEXTURES /o.f 0>, 0, 0, null)");
            i.aClassbArr[0] = new b_SpriteAnimator(hero, 0, 0, null);
            System.gc();

            if (loadChunk2) {
                final byte[] fireData = new byte[unpackUint32(chunksHeader, 12)];
                stream.read(fireData);
                stream.close();
                System.gc();

                final f_Sprite fireAnimation = new f_Sprite();
                fireAnimation.parseSprite(fireData, 0);
                fireAnimation.createImages(0, 0, -1, -1);
                fireAnimation.moduleData = null;
                i.aClassbArr[3] = new b_SpriteAnimator(fireAnimation, 0, 0, null);
                System.gc();
            }
        } catch (Exception ex) {
        }
    }

    private int aInt() {
        return i.aShortArrArr[this.boInt][this.bqInt << 1];
    }

    private void kVoid() {
        if (i.moreGamesUrl != null) {
            final String moreGamesUrl = i.moreGamesUrl;
            try {
                Thread.sleep(10L);
                new k(moreGamesUrl).start();
            } catch (Exception ex) {
            }
        }
    }

    private void lVoid() {
        i i;
        int brInt;
        if (this.DBoolean) {
            i = this;
            brInt = 97;
        } else {
            i = this;
            brInt = 92;
        }
        i.brInt = brInt;
        this.bsInt = 0;
        if (!bBoolean()) {
            this.pBoolean = false;
        }
        this.JBoolean = true;
        this.xBoolean = false;
        i.bByte = 11;
        final byte kInt = 0;
        this.aByte = kInt;
        this.lByte = kInt;
        this.kInt = kInt;
        final int n = -1;
        this.aGInt = n;
        this.aFInt = n;
        this.bLong = 0L;
    }

    private static boolean getMoreGamesEnabled() {
        String more_games_status = null;
        try {
            more_games_status = i.aClassGloftDIRU.getAppProperty("more_games_status");
        } catch (Exception ex) {
        }
        return more_games_status != null && more_games_status.equals("on");
    }

    private void mVoid() {
        --this.bqInt;
        if (this.bqInt < 0) {
            this.bqInt = (i.aShortArrArr[this.boInt].length >> 1) - 1;
        }
    }

    private void nVoid() {
        this.bqInt = (this.bqInt + 1) % (i.aShortArrArr[this.boInt].length >> 1);
    }

    private void oVoid() {
        this.KBoolean = false;
        if (i.aClasscArr != null) {
            for (int length = i.aClasscArr.length, iInteger = 0; iInteger < length; ++iInteger) {
                aVoid(i.aClasscArr[iInteger]);
                i.aClasscArr[iInteger] = null;
            }
        }
        i.aClasscArr = null;
        aVoid(i.aClassfArr[42], true);
        aVoid(i.aClassfArr[43], true);
        System.gc();
    }

    private static void aVoid(final c c) {
        if (c == null) {
            return;
        }
        if (c.aClassfArr != null) {
            for (int i = 0; i < c.aClassfArr.length; ++i) {
                aVoid(c.aClassfArr[i], true);
                c.aClassfArr[i] = null;
            }
        }
        if (c.aByteArrArr != null) {
            for (int j = 0; j < c.aByteArrArr.length; ++j) {
                c.aByteArrArr[j] = null;
            }
            c.aByteArrArr = null;
        }
        c.aByteArr = null;
    }

    private static void aVoid(final f_Sprite f, final boolean b) {
        if (f == null) {
            return;
        }
        f.free(b);
    }

    private void pVoid() {
        this.JBoolean = false;
        this.oBoolean = true;
        this.EBoolean = false;
        this.diInt = 0;
        this.eClassString = null;
        i.mByteArr = null;
        i.lByteArr = null;
        this.aiInt = 0;
        this.ajInt = 0;
        i.dByteArr = null;
        i.eByteArr = null;
        this.tmpInputStream = null;
        i.tmpBytes = null;
        i.fClassImage = null;
        i.cClassGraphics = null;
        i.bClassGraphics = null;
        i.dClassImage = null;
        i.pByteArr = null;
        i.kByteArr = null;
        if (i.aClasscArr != null) {
            for (int length = i.aClasscArr.length, iInteger = 0; iInteger < length; ++iInteger) {
                aVoid(i.aClasscArr[iInteger]);
                i.aClasscArr[iInteger] = null;
            }
        }
        i.aClasscArr = null;
        if (this.aClassc != null) {
            aVoid(this.aClassc);
            this.aClassc = null;
        }
        if (i.textures != null) {
            for (int j = 0; j < 33; ++j) {
                if (i.textures[j] != null) {
                    for (int length2 = i.textures[j].length, k = 0; k < length2; ++k) {
                        i.textures[j][k] = null;
                    }
                    i.textures[j] = null;
                }
            }
        }
        aVoid(i.dClassf, true);
        System.gc();
        if (i.aClassfArr != null) {
            for (int l = 0; l < 61; ++l) {
                if (l != 41 && l != 0 && l != 9 && l != 18) {
                    aVoid(i.aClassfArr[l], true);
                    i.aClassfArr[l] = null;
                }
            }
        }
        if (i.aClassbArr != null) {
            for (int n = 0; n < 6; ++n) {
                if (i.aClassbArr[n] != null) {
                    aVoid(i.aClassbArr[n].sprite, true);
                    i.aClassbArr[n].sprite = null;
                    if (n == 0) System.out.println("Set value to i.aClassbArr[0]. null");
                    i.aClassbArr[n] = null;
                }
            }
            new Exception("Oh no").printStackTrace();
        }
        i.bIntArrArr = null;
        i.crtStageForegrondLayer = null;
        i.bByteArrArr = null;
        i.crtStagePlayerLayer = null;
        i.cByteArrArr = null;
        i.cIntArrArr = null;
        i.dIntArrArr = null;
        i.dByteArrArr = null;
        i.eByteArrArr = null;
        i.oByteArr = null;
        this.cLong = 0L;
        this.buInt = 0;
        this.aDInt = -1;
        this.aFInt = -1;
        this.aHInt = -1;
        this.aIInt = -1;
        i.bClassf = null;
        this.bKInt = -1;
        this.xByte = 3;
        i.eIntArrArr = null;
        i.fIntArrArr = null;
        i.aLongArr = null;
        i.cLongArr = null;
        i.bLongArr = null;
        i.dLongArr = null;
        this.alBoolean = false;
        this.dqInt = -1;
        this.drInt = 0;
        this.dsInt = 0;
        this.vByte = 0;
        this.dvInt = 0;
        this.dwInt = 0;
        this.dxInt = 0;
        this.wByte = 0;
        this.dyInt = 0;
        this.dzInt = -1;
        this.lBoolean = false;
        i.eByteArr = null;
        i.splashLogoImage = null;
        i.splashBgGradientImage = null;
        i.splashCopyrightImage = null;
        i.fClassImage = null;
        i.cClassGraphics = null;
        System.gc();
        System.gc();
    }

    private void qVoid() {
        this.oBoolean = true;
    }

    private void rVoid() {
        if ((this.dLong & 0x1L) == 0x0L) {
            for (int iInteger = 0; iInteger < 5; ++iInteger) {
                i.aClassfArr[13].images[0][iInteger] = null;
            }
        }
    }

    private void cVoid(final int chunkI) {
        try {
            if (chunkI == 0) {
                this.tmpInputStream = this.getClass().getResourceAsStream("/b0.f");
                this.ccInt = this.tmpInputStream.read();
                i.tmpBytes = new byte[this.ccInt << 3];
                this.tmpInputStream.read(i.tmpBytes);
            }
            final byte[] b = new byte[unpackUint32(i.tmpBytes, (chunkI << 3) + 4)];
            this.tmpInputStream.read(b);
            final f_Sprite f;
            (f = new f_Sprite()).parseSprite(b, 0);
            f.createImages(0, 0, -1, -1);
            f.moduleData = null;
            switch (chunkI) {
                case 0: {
                    i.aClassbArr[5] = new b_SpriteAnimator(f, 0, 0, null);
                }
                case 1: {
                    i.aClassfArr[40] = f;
                    break;
                }
            }
        } catch (Exception ex) {
        }
    }

    private void dVoid(final int chunkI) {
        try {
            if (chunkI == 0) {
                this.tmpInputStream = this.getClass().getResourceAsStream("/mm0.f");
                this.ccInt = this.tmpInputStream.read();
                i.tmpBytes = new byte[this.ccInt << 3];
                this.tmpInputStream.read(i.tmpBytes);
            }
            final byte[] b = new byte[unpackUint32(i.tmpBytes, (chunkI << 3) + 4)];
            this.tmpInputStream.read(b);
            final f_Sprite f;
            (f = new f_Sprite()).parseSprite(b, 0);
            f.createImages(0, 0, -1, -1);
            f.moduleData = null;
            switch (chunkI) {
                case 2: {
                    i.textures[27] = f.images[0]; // mm0.f, chunk 3, palette 0, all modules
                }
                case 1: {
                    (i.aClassbArr[2] = new b_SpriteAnimator(f, 0, 0, null)).setAnimation(0); // mm0.f, chunk 2, palette 0, all animations
                }
                case 0: {
                    (i.aClassbArr[1] = new b_SpriteAnimator(f, 0, 0, null)).setAnimation(2); // mm0.f, chunk 1, palette 0, all animations
                    break;
                }
            }
        } catch (Exception ex) {
        }
    }

    private static boolean bBoolean() {
        return i.iByteArr != null && i.iByteArr[13] != 0;
    }

    private void bVoid(final boolean b) {
        i.iByteArr[13] = 1;
        this.uVoid();
    }

    private void sVoid() {
        this.cVoid(true);
    }

    private void cVoid(final boolean b) {
        this.IBoolean = false;
        this.bVoid(true);
        this.wVoid();
        this.vVoid();
        aVoid(this.crtWorldIndex, i.dZInt);
        if (b) {
            i.iByteArr[aInt(this.crtWorldIndex, this.crtStageI)] = (byte) (this.bbInt + this.bInt(this.crtWorldIndex, this.crtStageI));
        }
        this.uVoid();
    }

    private void tVoid() {
        RecordStore openRecordStore = null;
        try {
            i.iByteArr = (openRecordStore = RecordStore.openRecordStore("DiamondRush", true)).getRecord(1);
            this.cwInt = i.iByteArr.length;
            openRecordStore.closeRecordStore();
        } catch (Exception ex) {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex2) {
            }
        } finally {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex3) {
            }
        }
    }

    private void uVoid() {
        this.NBoolean = false;
        RecordStore openRecordStore = null;
        try {
            if ((openRecordStore = RecordStore.openRecordStore("DiamondRush", true)).getNumRecords() == 0) {
                openRecordStore.addRecord(i.iByteArr, 0, this.cwInt);
            } else {
                openRecordStore.setRecord(1, i.iByteArr, 0, this.cwInt);
            }
            openRecordStore.closeRecordStore();
        } catch (Exception ex) {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex2) {
            }
        } finally {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex3) {
            }
        }
    }

    private void vVoid() {
        RecordStore recordStore = null;
        try {
            if ((recordStore = RecordStore.openRecordStore("Preferences", true)).getNumRecords() == 0) {
                recordStore.addRecord(i.jByteArr, 0, this.cvInt);
            } else {
                recordStore.setRecord(1, i.jByteArr, 0, this.cvInt);
            }
            recordStore.closeRecordStore();
            recordStore = RecordStore.openRecordStore("Preferences", true);
        } catch (Exception ex) {
            try {
                if (recordStore != null) {
                    recordStore.closeRecordStore();
                }
            } catch (Exception ex2) {
            }
        } finally {
            try {
                if (recordStore != null) {
                    recordStore.closeRecordStore();
                }
            } catch (Exception ex3) {
            }
        }
    }

    private void eVoid(int read) {
        RecordStore openRecordStore = null;
        try {
            String s = null;
            switch (read) {
                case 0:
                case 1: {
                    try {
                        openRecordStore = RecordStore.openRecordStore("DiamondRush", false);
                    } catch (Exception ex) {
                    }
                    i i;
                    boolean oBoolean;
                    if (openRecordStore == null) {
                        i = this;
                        oBoolean = true;
                    } else {
                        i = this;
                        oBoolean = false;
                    }
                    i.OBoolean = oBoolean;
                    openRecordStore.closeRecordStore();
                    if (read != 0) {
                        (i.iByteArr = new byte[1001])[3] = 5;
                        i.iByteArr[8] = 4;
                        i.iByteArr[9] = 0;
                        i.iByteArr[10] = 0;
                        this.cwInt = 14;
                        this.cwInt += 6;
                        break;
                    }
                    break;
                }
                case 2: {
                    s = "/map_angkor.out";
                }
                case 3: {
                    if (s == null) {
                        s = "/map_scotland.out";
                    }
                }
                case 4: {
                    if (s == null) {
                        s = "/map_tibet.out";
                    }
                    (this.tmpInputStream = this.getClass().getResourceAsStream(i.worldFiles[read - 2])).read();
                    read -= 2;
                    final int cwInt = this.cwInt;
                    i.iByteArr[14 + (read << 1)] = (byte) this.cwInt;
                    i.iByteArr[14 + (read << 1) + 1] = (byte) (this.cwInt >> 8);
                    read = this.tmpInputStream.read();
                    i.iByteArr[this.cwInt++] = (byte) read;
                    i.iByteArr[this.cwInt++] = 0;
                    this.awVoid();
                    this.aVoid(s);
                    i.iByteArr[this.cwInt++] = (byte) this.dKInt;
                    this.auVoid();
                    this.cwInt += read << 1;
                    for (int j = 0; j < read; ++j) {
                        final int cwInt2 = this.cwInt;
                        i.iByteArr[cwInt + 3 + (j << 1)] = (byte) cwInt2;
                        i.iByteArr[cwInt + 3 + (j << 1) + 1] = (byte) (cwInt2 >> 8);
                        byte b = 0;
                        byte b2 = 0;
                        final int aInt = aInt(this.tmpInputStream);
                        final int aInt2 = aInt(this.tmpInputStream);
                        final byte[] array = new byte[aInt * aInt2];
                        this.tmpInputStream.read(array);
                        for (int k = 0; k < aInt2; ++k) {
                            for (int l = 0; l < aInt; ++l) {
                                if (array[l + k * aInt] == 2) {
                                    ++b2;
                                }
                            }
                        }
                        final byte[] iByteArr = i.iByteArr;
                        final int n = 0;
                        iByteArr[n] += b2;
                        i.iByteArr[this.cwInt++] = 0;
                        i.iByteArr[this.cwInt++] = b2;
                        i.iByteArr[this.cwInt++] = 0;
                        this.tmpInputStream.skip(aInt * aInt2);
                        final int cwInt3 = this.cwInt;
                        this.cwInt += 2;
                        this.tmpInputStream.read(array);
                        for (int n2 = 0; n2 < aInt2; ++n2) {
                            for (int n3 = 0; n3 < aInt; ++n3) {
                                if (array[n3 + n2 * aInt] == 14 || array[n3 + n2 * aInt] == 33) {
                                    i.iByteArr[this.cwInt++] = (byte) n3;
                                    i.iByteArr[this.cwInt++] = (byte) n2;
                                    ++b;
                                }
                            }
                        }
                        i.iByteArr[cwInt3] = 0;
                        i.iByteArr[cwInt3 + 1] = b;
                    }
                    this.tmpInputStream.close();
                    this.tmpInputStream = null;
                    System.gc();
                    break;
                }
            }
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex2) {
            }
        } catch (Exception ex3) {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex4) {
            }
        } finally {
            try {
                if (openRecordStore != null) {
                    openRecordStore.closeRecordStore();
                }
            } catch (Exception ex5) {
            }
        }
    }

    private void wVoid() {
        i.iByteArr[3] = (byte) this.azInt;
        i.iByteArr[11] = this.rByte;
    }

    private void xVoid() {
        this.MBoolean = false;
        this.azInt = i.iByteArr[3];
        this.rByte = i.iByteArr[11];
        this.aZInt = unpackUint16(i.iByteArr, 4);
    }

    private byte aByte(final int worldIndex, final int stageIndex) {
        return i.iByteArr[aInt(worldIndex, stageIndex) + 2];
    }

    private void aVoid(final int n, final int n2, final byte b) {
        final int aInt = aInt(n, n2);
        final byte[] iByteArr = i.iByteArr;
        final int n3 = aInt + 2;
        iByteArr[n3] |= b;
    }

    private static void aVoid(int n, final int n2) {
        n = cInt(n) + 1;
        if (i.iByteArr[n] < n2) {
            i.iByteArr[n] = (byte) n2;
        }
    }

    private static int bInt(final int n) {
        final int n2;
        if ((n2 = cInt(n) + 1) >= 0 && n2 <= i.iByteArr.length) {
            return i.iByteArr[cInt(n) + 1];
        }
        return 0;
    }

    private static int cInt(int worldIndex) {
        int clampedIndex;
        if (worldIndex < 0) {
            clampedIndex = 0;
        } else {
            if (worldIndex < 3) {
                return unpackUint16(i.iByteArr, 14 + (worldIndex << 1));
            }
            clampedIndex = 2;
        }
         worldIndex = clampedIndex;
        return unpackUint16(i.iByteArr, 14 + (worldIndex << 1));
    }

    private static int dInt(final int n) {
        try {
            return i.iByteArr[cInt(n)];
        } catch (Exception ex) {
            return 0;
        }
    }

    private static int eInt(final int n) {
        return i.iByteArr[cInt(n) + 2];
    }

    private static int aInt(final int worldIndex, final int stageIndex) {
        return unpackUint16(i.iByteArr, cInt(worldIndex) + 3 + (stageIndex << 1));
    }

    private int bInt(final int n, final int n2) {
        return i.iByteArr[aInt(n, n2)];
    }

    private int cInt(final int n, final int n2) {
        return i.iByteArr[aInt(n, n2) + 1];
    }

    private void aVoid(int n, int iInteger, final int n2, final int n3) {
        final int aInt = aInt(n, iInteger);
        byte[] iByteArr;
        int n4;
        for (n = i.iByteArr[aInt + 4], iInteger = 0; iInteger < n; ++iInteger) {
            if (i.iByteArr[aInt + 5 + iInteger * 2] == n2 && i.iByteArr[aInt + 5 + iInteger * 2 + 1] == n3) {
                i.iByteArr[aInt + 5 + iInteger * 2] = 0;
                i.iByteArr[aInt + 5 + iInteger * 2 + 1] = 0;
                iByteArr = i.iByteArr;
                n4 = aInt + 3;
                ++iByteArr[n4];
                return;
            }
        }
    }

    private boolean aBoolean(int n, int iInteger, final int n2, final int n3) {
        final int aInt = aInt(n, iInteger);
        for (n = i.iByteArr[aInt + 4], iInteger = 0; iInteger < n; ++iInteger) {
            if (i.iByteArr[aInt + 5 + iInteger * 2] == n2 && i.iByteArr[aInt + 5 + iInteger * 2 + 1] == n3) {
                return false;
            }
        }
        return true;
    }

    private void yVoid() {
        this.aoInt = 13;
        this.aqInt = 4;
        this.atInt = 408;
        this.kByte = 5;
        this.cLong |= 0x80L;
        this.cLong |= 0x8L;
        this.aeBoolean = false;
        this.OInt = 16;
        this.PInt = 16;
        this.QInt = 19;
        this.RInt = 18;
    }

    private void zVoid() {
        final int dvInt = this.dVInt;
        final int dwInt = this.dWInt;
        final long n;
        final int aInt = aInt(n = i.aLongArrArr[dvInt][dwInt], (byte) 6, (byte) 5);
        final int aInt2 = aInt(n, (byte) 11, (byte) 3);
        int n2 = 14;
        if (this.crtStageI >= this.dKInt) {
            this.aVoid(this.crtWorldIndex, this.crtStageI, (byte) 2);
        }
        if (aInt2 > 1) {
            for (int iInteger = 0; iInteger < aInt2; ++iInteger, n2 += 4) {
                final int aInt3 = aInt(n, (byte) n2, (byte) 4);
                n2 += 4;
                final long n3;
                final int aInt4;
                if (aInt(n3 = i.aLongArrArr[aInt3][aInt(n, (byte) n2, (byte) 4)], (byte) 3, (byte) 3) == 1 && (aInt4 = aInt(n3, (byte) 6, (byte) 5)) > aInt) {
                    i.dZInt = aInt4;
                    this.cxInt = dvInt;
                    this.cyInt = dwInt;
                    this.aVoid(this.crtWorldIndex, i.dZInt, (byte) 64);
                    this.acBoolean = true;
                }
            }
        } else {
            i.dZInt = this.crtStageI;
        }
        this.cVoid(false);
    }

    public final void paint(final Graphics aClassGraphics) {
        try {
            if (((Displayable) this).getWidth() > ((Displayable) this).getHeight()) {
                try {
                    try {
                        aClassGraphics.setColor(0);
                        aClassGraphics.setClip(0, 0, ((Displayable) this).getWidth(), ((Displayable) this).getHeight());
                        aClassGraphics.fillRect(0, 0, ((Displayable) this).getWidth(), ((Displayable) this).getHeight());
                        aClassGraphics.setColor(16777215);
                        c.aInt(aClassGraphics, d.getLocalizedText(34), ((Displayable) this).getWidth() >> 1, (((Displayable) this).getHeight() >> 1) - 40, ((Displayable) this).getWidth() - 100);
                    } catch (Exception ex2) {
                    }
                    this.hideNotify();
                    this.showNotify();
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
            try {
                (this.aClassGraphics = aClassGraphics).setClip(0, 0, 240, 320);
                switch (i.bByte) {
                    // Paint cheat page
                    case 24: {
                        String s = null;
                        final h aClassh;
                        (aClassh = i.textSize8).dInt = 15;
                        this.aClassGraphics.setColor(0);
                        this.aClassGraphics.fillRect(0, 0, 240, 320);
                        int iInteger = 0;
                        Label_0590_Outer:
                        while (iInteger < 6) {
                            int n = -1;
                            while (true) {
                                String s2 = null;
                                switch (iInteger) {
                                    case 0: {
                                        n = 7;
                                        s2 = " 6 - Add " + String.valueOf(this.aZInt);
                                        break;
                                    }
                                    case 1: {
                                        n = 8;
                                        s2 = " 7 - Add " + String.valueOf(this.bbInt);
                                        break;
                                    }
                                    case 2: {
                                        n = 12;
                                        s2 = " 8 - x " + String.valueOf(this.cAInt) + ((this.cAInt >= 4) ? " blue potion" : "");
                                        break;
                                    }
                                    case 3: {
                                        n = 11;
                                        s2 = " 9 - " + i.texts[this.SBoolean ? 43 : 42];
                                        break;
                                    }
                                    case 4: {
                                        n = 10;
                                        s2 = " 0 - " + i.texts[this.TBoolean ? 43 : 42];
                                        break;
                                    }
                                    case 5: {
                                        n = -1;
                                        s2 = "";
                                        break;
                                    }
                                    default: {
                                        final int n2 = (iInteger + 1) * 35;
                                        if (n >= 0) {
                                            aClassh.drawTextWithFlags(this.aClassGraphics, i.texts[n], 110, n2, 17);
                                        }
                                        final int n3 = n2 + aClassh.dInt;
                                        h h;
                                        Graphics graphics;
                                        String s3;
                                        int n4;
                                        int n5;
                                        int n6;
                                        if (n == -1) {
                                            h = aClassh;
                                            graphics = this.aClassGraphics;
                                            s3 = s;
                                            n4 = 110;
                                            n5 = n3;
                                            n6 = 17;
                                        } else {
                                            aClassh.drawTextWithFlags(this.aClassGraphics, i.texts[9], 110, n3, 24);
                                            h = aClassh;
                                            graphics = this.aClassGraphics;
                                            s3 = s;
                                            n4 = 110;
                                            n5 = n3;
                                            n6 = 20;
                                        }
                                        h.drawTextWithFlags(graphics, s3, n4, n5, n6);
                                        ++iInteger;
                                        continue Label_0590_Outer;
                                    }
                                }
                                s = s2;
                                continue;
                            }
                        }
                        final String s4 = "Pound (#) - Pass levels ";
                        StringBuffer sb;
                        String str;
                        if (this.abBoolean) {
                            sb = new StringBuffer().append(s4);
                            str = "on";
                        } else {
                            sb = new StringBuffer().append(s4);
                            str = "off";
                        }
                        aClassh.drawTextWithFlags(this.aClassGraphics, sb.append(str).toString(), 110, 250, 17);
                        aClassh.drawTextWithFlags(this.aClassGraphics, "(Press 9 while gameplay to", 110, 265, 17);
                        aClassh.drawTextWithFlags(this.aClassGraphics, "skip the level)", 110, 280, 17);
                        this.IVoid();
                        this.JVoid();
                        break;
                    }
                    // Paint cheat page - tips
                    case 34: {
                        final h aClassh2;
                        (aClassh2 = i.textSize8).dInt = 2;
                        this.aClassGraphics.setColor(0);
                        this.aClassGraphics.fillRect(0, 0, 240, 320);
                        String s5 = null;
                        switch (this.ddInt) {
                            case 1: {
                                s5 = "Tips";
                                oVoid(this.aIntArr[1]);
                                this.atVoid();
                                break;
                            }
                            case 0: {
                                s5 = "Mix";
                                aClassh2.drawText(this.aClassGraphics, i.texts[this.aIntArr[0]], 10, 15, 20);
                                break;
                            }
                            default: {
                                s5 = "";
                                break;
                            }
                        }
                        aClassh2.dInt = 2;
                        aClassh2.drawTextWithFlags(this.aClassGraphics, s5, 40, 308, 20);
                        aClassh2.drawTextWithFlags(this.aClassGraphics, "" + this.aIntArr[this.ddInt], 120, 308, 20);
                        aClassh2.drawText(this.aClassGraphics, "Use up, down, left and right", 10, 270, 20);
                        aClassh2.drawText(this.aClassGraphics, "to navigate", 10, 285, 20);
                        this.IVoid();
                        this.JVoid();
                        break;
                    }
                    case 22: {
                        this.azVoid();
                        break;
                    }
                    // Paint help page
                    case 33: {
                        if (this.avBoolean) {
                            this.aClassGraphics.setColor(0);
                            this.aClassGraphics.setClip(0, 0, 240, 320);
                            this.aClassGraphics.fillRect(0, 0, 240, 320);
                            i.textSize8.drawText(this.aClassGraphics, i.texts[18] + "\n\n" + i.texts[29] + "\n" + i.texts[37] + "\n" + i.texts[38] + "\n\n" + i.texts[119] + "\n\n" + aClassString(i.texts[118]) + "\n" + aClassString(i.texts[67]), 120, 10, 17);
                            this.IVoid();
                            this.avBoolean = false;
                        }
                        break;
                    }
                    case 20: {
                        aVoid(this.aClassGraphics, i.textSize8, aClassString(i.texts[61]), 120, 180, 17, 20, true);
                        break;
                    }
                    case 17: {
                        final int arInt = this.aRInt;
                        final h aClassh3 = i.textSize8;
                        final Graphics aClassGraphics2;
                        (aClassGraphics2 = this.aClassGraphics).setColor(2496263);
                        aClassGraphics2.fillRect(0, 0, 240, 320);
                        switch (arInt) {
                            case 5: {
                                if (this.bdInt == 0) {
                                    if ((this.uByte & 0x20) != 0x0) {
                                        aClassGraphics2.drawImage(i.textures[5][0], 200, 237, 0);
                                        final f_Sprite f;
                                        if (arInt == 5 && i.aSInt < (f = i.aClassfArr[9]).getAnimationFrameCount(0) << 1) {
                                            f.drawAnimationFrame(aClassGraphics2, 0, i.aSInt << 1, 200, 237, 0, 0, 0);
                                        }
                                    }
                                    aClassGraphics2.drawImage(i.textures[28][0], 180, 254, 0);
                                }
                            }
                            case 4: {
                                int n7;
                                if (arInt != 4 || (n7 = -100 + i.aSInt * 10) > 0) {
                                    n7 = 0;
                                }
                                i.aClassbArr[0].sprite.drawAnimationFrame(aClassGraphics2, 12, 0, n7 + 7, 243, 0, 0, 0);
                                aClassh3.drawText(aClassGraphics2, i.texts[78], 120, 243, 17);
                                aClassh3.drawText(aClassGraphics2, String.valueOf(this.bdInt), 120, 259, 17);
                                if (this.bcInt == 0) {
                                    if ((this.uByte & 0x10) != 0x0) {
                                        aClassGraphics2.drawImage(i.textures[5][0], 200, 181, 0);
                                        final f_Sprite f2;
                                        if (arInt == 4 && i.aSInt < (f2 = i.aClassfArr[9]).getAnimationFrameCount(0) << 1) {
                                            f2.drawAnimationFrame(aClassGraphics2, 0, i.aSInt >> 1, 200, 181, 0, 0, 0);
                                        }
                                    }
                                    aClassGraphics2.drawImage(i.textures[28][0], 180, 198, 0);
                                }
                            }
                            case 3: {
                                int n8;
                                if (arInt != 3 || (n8 = -100 + i.aSInt * 10) > 0) {
                                    n8 = 0;
                                }
                                i.aClassbArr[0].sprite.drawAnimationFrame(aClassGraphics2, 10, 0, n8 + 7, 191, 0, 0, 0);
                                aClassh3.drawText(aClassGraphics2, i.texts[68], 120, 187, 17);
                                aClassh3.drawText(aClassGraphics2, String.valueOf(this.bcInt), 120, 203, 17);
                                if (this.bbInt == this.baInt) {
                                    if ((this.uByte & 0x8) != 0x0) {
                                        aClassGraphics2.drawImage(i.textures[5][0], 200, 125, 0);
                                        final f_Sprite f3;
                                        if (arInt == 3 && i.aSInt < (f3 = i.aClassfArr[9]).getAnimationFrameCount(0) << 1) {
                                            f3.drawAnimationFrame(aClassGraphics2, 0, i.aSInt >> 1, 200, 125, 0, 0, 0);
                                        }
                                    }
                                    aClassGraphics2.drawImage(i.textures[28][0], 180, 142, 0);
                                }
                            }
                            case 2: {
                                int n9;
                                if (arInt != 2 || (n9 = -100 + i.aSInt * 10) > 0) {
                                    n9 = 0;
                                }
                                i.aClassfArr[aInt(3)].drawFrame(aClassGraphics2, 0, n9 + 7, 131, 0);
                                aClassh3.drawText(aClassGraphics2, i.texts[48], 120, 131, 17);
                                aClassh3.drawText(aClassGraphics2, this.bbInt + "/" + this.baInt, 120, 147, 17);
                                if (this.aZInt == this.aYInt) {
                                    if ((this.uByte & 0x4) != 0x0) {
                                        aClassGraphics2.drawImage(i.textures[5][0], 200, 69, 0);
                                        final f_Sprite f4;
                                        if (arInt == 2 && i.aSInt < (f4 = i.aClassfArr[9]).getAnimationFrameCount(0) >> 1) {
                                            f4.drawAnimationFrame(aClassGraphics2, 0, i.aSInt << 1, 200, 69, 0, 0, 0);
                                        }
                                    }
                                    aClassGraphics2.drawImage(i.textures[28][0], 180, 86, 0);
                                }
                            }
                            case 1: {
                                int n10;
                                if (arInt != 1 || (n10 = -100 + i.aSInt * 10) > 0) {
                                    n10 = 0;
                                }
                                i.aClassfArr[aInt(2)].drawFrame(aClassGraphics2, 0, n10 + 7, 75, 0);
                                aClassh3.drawText(aClassGraphics2, i.texts[19], 120, 75, 17);
                                int azInt;
                                if (arInt != 1 || (azInt = i.aSInt >> 1) > this.aZInt) {
                                    azInt = this.aZInt;
                                }
                                aClassh3.drawText(aClassGraphics2, azInt + "/" + this.aYInt, 120, 91, 17);
                            }
                            case 0: {
                                int n12 = 0;
                                int n11 = 0;
                                Label_2231:
                                {
                                    if (arInt == 0) {
                                        n11 = (n12 = -100 + i.aSInt * 10) - 240;
                                        if (n12 > 0) {
                                            n12 = 0;
                                        }
                                        if (n11 <= 0) {
                                            break Label_2231;
                                        }
                                    } else {
                                        n12 = 0;
                                    }
                                    n11 = 0;
                                }
                                aClassh3.drawTextWithFlags(aClassGraphics2, i.stageTitles[i.gIntArrArr[this.crtWorldIndex][this.crtStageI] - 1], n12 + 120, 15, 17);
                                aClassh3.drawTextWithFlags(aClassGraphics2, i.texts[14], n11 + 120, 32, 17);
                                break;
                            }
                        }
                        i.textSize8.drawTextWithFlags(this.aClassGraphics, i.texts[(this.aRInt == 5) ? 17 : 65], 5, 320 - (aClassh3.font.getHeight() - 10), 36);
                        break;
                    }
                    case 4: {
                        this.HVoid();
                        break;
                    }
                    case 7: {
                        this.HVoid();
                        break;
                    }
                    case 30: {
                        bVoid(this.aClassGraphics, true);
                        this.fVoid(280);
                        if (i.aSInt % 15 >= 7) {
                            i.textSize0.drawTextWithFlags(this.aClassGraphics, i.texts[46], 120, 280, 17);
                            break;
                        }
                        break;
                    }
                    case 2: {
                        this.HVoid();
                        break;
                    }
                    case 5: {
                        if (!this.RBoolean) {
                            this.aClassGraphics.setClip(0, a_Config.eInt, 240, 320 - a_Config.eInt);
                            this.KVoid();
                            this.aClassGraphics.setClip(0, 0, 240, 320);
                        } else {
                            this.KVoid();
                        }
                        if (i.fClassString != null && this.RBoolean) {
                            this.atVoid();
                            break;
                        }
                        break;
                    }
                    case 28: {
                        this.brInt = 11;
                        this.KVoid();
                        break;
                    }
                    case 8:
                    case 9:
                    case 21:
                    case 35: {
                        this.KVoid();
                        break;
                    }
                    case 6: {
                        final b_SpriteAnimator b = i.aClassbArr[0];
                        this.aClassGraphics.setColor(0);
                        this.aClassGraphics.fillRect(0, 0, 240, 320);
                        b.y = 136;
                        int n13 = 0;
                        if (i.aSInt > 30) {
                            b.x = 139;
                            b.setAnimation(1);
                            int n14;
                            if ((n14 = i.aSInt - 30 << 2) > 29) {
                                n14 = 29;
                                f_Sprite f5;
                                Graphics graphics2;
                                int n16;
                                int n17;
                                int n18;
                                if (i.aSInt < 42) {
                                    final int n15 = 42 - i.aSInt;
                                    n13 = 0 + n15 * n15 % ((n15 >> 1) + 1);
                                    f5 = b.sprite;
                                    graphics2 = this.aClassGraphics;
                                    n16 = 10;
                                    n17 = 138;
                                    n18 = n13 + 136;
                                } else {
                                    f5 = b.sprite;
                                    graphics2 = this.aClassGraphics;
                                    n16 = 4;
                                    n17 = 138;
                                    n18 = 136;
                                }
                                f5.drawFrame(graphics2, n16, n17, n18, 0);
                                b.crtAnimationFrame = 0;
                            } else {
                                b.sprite.drawFrame(this.aClassGraphics, 10, 138, 136, 0);
                            }
                            b.y = n14 + 136;
                        } else {
                            b.x = (i.aSInt << 2) - 1 + 18;
                        }
                        final b_SpriteAnimator b2 = b;
                        b2.y += n13;
                        b.draw(this.aClassGraphics);
                        b.sprite.drawFrame(this.aClassGraphics, 5, 138, n13 + 160, 0);
                        break;
                    }
                    case 1: {
                        this.DVoid();
                        break;
                    }
                    case 12: {
                        this.aClassGraphics.setColor(0);
                        this.aClassGraphics.fillRect(0, 0, 240, 320);
                        final h aClassh4;
                        (aClassh4 = i.textSize8).drawTextWithFlags(this.aClassGraphics, i.texts[26], 120, 50, 17);
                        h h2;
                        Graphics graphics3;
                        String s6;
                        int n19;
                        int n20;
                        int n21;
                        if (this.kByte == 2) {
                            h2 = aClassh4;
                            graphics3 = this.aClassGraphics;
                            s6 = i.texts[49];
                            n19 = 0;
                            n20 = 320 - (aClassh4.font.getHeight() - 10);
                            n21 = 36;
                        } else {
                            aClassh4.drawTextWithFlags(this.aClassGraphics, i.texts[16], 0, 320 - (aClassh4.font.getHeight() - 10), 36);
                            final String string = i.texts[126] + " " + ((unpackUint16(i.iByteArr, 4) < 500) ? unpackUint16(i.iByteArr, 4) : 500) + " " + i.texts[19];
                            h2 = aClassh4;
                            graphics3 = this.aClassGraphics;
                            s6 = string;
                            n19 = 120;
                            n20 = 160;
                            n21 = 17;
                        }
                        h2.drawTextWithFlags(graphics3, s6, n19, n20, n21);
                    }
                    case 15: {
                        if (this.auBoolean) {
                            i.fClassImage = Image.createImage(200, 204);
                        }
                        Label_3607:
                        {
                            if (this.avBoolean) {
                                this.avBoolean = false;
                                this.awBoolean = true;
                                this.aClassGraphics.setClip(0, 0, 240, 320);
                                int n22 = 0;
                                int color = 0;
                                int color2 = 0;
                                int n23 = -1;
                                int n24 = 0;
                                while (true) {
                                    int n25 = 0;
                                    switch (this.crtWorldIndex) {
                                        case 0: {
                                            n22 = 939282;
                                            color = 3111750;
                                            color2 = 8635434;
                                            n24 = 24;
                                            n25 = 1;
                                            break;
                                        }
                                        case 1: {
                                            n22 = 869201;
                                            color = 4022666;
                                            color2 = 5873874;
                                            n24 = 25;
                                            n25 = 4;
                                            break;
                                        }
                                        case 2: {
                                            n22 = 5210510;
                                            color = 3711421;
                                            color2 = 7469567;
                                            n24 = 26;
                                            n25 = 64;
                                            break;
                                        }
                                        default: {
                                            this.aClassGraphics.setColor(n22);
                                            this.aClassGraphics.fillRect(0, 0, 240, 320);
                                            i.aClassfArr[n24].drawFrame(this.aClassGraphics, 0, 120, 0, 0);
                                            i.textSize0.drawTextWithFlags(this.aClassGraphics, i.texts[n23], 120, 12, 17);
                                            (i.cClassGraphics = i.fClassImage.getGraphics()).setColor(n22);
                                            i.cClassGraphics.fillRect(0, 0, 200, 204);
                                            i.aClassfArr[23].drawFrame(i.cClassGraphics, 0, 100, 102, 0);
                                            this.aClassGraphics.setColor(color);
                                            this.aClassGraphics.fillRoundRect(2, 275, 236, a_Config.hInt, 8, 8);
                                            this.aClassGraphics.setColor(color2);
                                            this.aClassGraphics.drawRoundRect(2, 275, 236, a_Config.hInt, 8, 8);
                                            this.IVoid();
                                            this.JVoid();
                                            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.texts[60], 218, 314, 40);
                                            if (i.aClassfArr[17] != null) {
                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, 12, 10, 278, 0);
                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, 10, 155, 280, 0);
                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, 11, 80, 280, 0);
                                            }
                                            i.crtWorldMapFileName.delete(0, i.crtWorldMapFileName.length());
                                            i.crtWorldMapFileName.append(this.azInt);
                                            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.crtWorldMapFileName.toString(), 41, 290, 20);
                                            i.crtWorldMapFileName.delete(0, i.crtWorldMapFileName.length());
                                            i.crtWorldMapFileName.append(unpackUint16(i.iByteArr, 4));
                                            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.crtWorldMapFileName.toString(), 99, 290, 20);
                                            i.crtWorldMapFileName.delete(0, i.crtWorldMapFileName.length());
                                            final int aInt = unpackUint16(i.iByteArr, 6);
                                            final byte j = i.iByteArr[0];
                                            if (aInt >= j) {
                                                i.crtWorldMapFileName.append(aInt).append("/").append(aInt);
                                            } else {
                                                i.crtWorldMapFileName.append(aInt).append("/").append(j);
                                            }
                                            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.crtWorldMapFileName.toString(), 174, 290, 20);
                                            this.auBoolean = false;
                                            this.axVoid();
                                            break Label_3607;
                                        }
                                    }
                                    n23 = n25;
                                    continue;
                                }
                            }
                        }
                        Label_5087:
                        {
                            if (this.awBoolean) {
                                this.aClassGraphics.drawImage(i.fClassImage, 20, 69, 0);
                                int color3 = 0;
                                int color4 = 0;
                                while (true) {
                                    int n26 = 0;
                                    switch (this.crtWorldIndex) {
                                        case 0: {
                                            color3 = 3111750;
                                            n26 = 8635434;
                                            break;
                                        }
                                        case 1: {
                                            color3 = 4022666;
                                            n26 = 5873874;
                                            break;
                                        }
                                        case 2: {
                                            color3 = 3711421;
                                            n26 = 7469567;
                                            break;
                                        }
                                        default: {
                                            this.aClassGraphics.setColor(color3);
                                            this.aClassGraphics.fillRoundRect(2, a_Config.gInt, 236, a_Config.fInt, 8, 8);
                                            this.aClassGraphics.setColor(color4);
                                            this.aClassGraphics.drawRoundRect(2, a_Config.gInt, 236, a_Config.fInt, 8, 8);
                                            final int n27 = 37 + this.dVInt * 13 + 6;
                                            final int n28 = 73 + this.dWInt * 13 + 6;
                                            if (this.dVInt != this.dXInt || this.dWInt != this.dYInt) {
                                                final int n29 = 37 + this.dXInt * 13 + 6;
                                                final int n30 = 73 + this.dYInt * 13 + 6;
                                                if (((this.aByte(this.crtWorldIndex, this.crtStageI + 1) & 0x2) != 0x0 && this.crtStageI + 1 == i.dZInt) || this.crtStageI == i.dZInt) {
                                                    this.apBoolean = true;
                                                }
                                                if (!this.apBoolean) {
                                                    this.apBoolean = this.hBoolean();
                                                    if (this.apBoolean) {
                                                        this.avBoolean = true;
                                                    }
                                                } else {
                                                    final int n31 = n27;
                                                    final int n32 = n28;
                                                    final int n33 = n29;
                                                    final int n34 = n30;
                                                    final int n35 = n33;
                                                    final int dnInt = n32;
                                                    final int dmInt = n31;
                                                    if (this.anBoolean) {
                                                        this.anBoolean = false;
                                                        this.dMInt = dmInt;
                                                        this.dNInt = dnInt;
                                                        this.dOInt = 0;
                                                        this.dPInt = n35 - dmInt;
                                                        this.dQInt = n34 - dnInt;
                                                        this.dRInt = 0;
                                                        this.dSInt = 0;
                                                        this.dTInt = 10;
                                                        this.dUInt = 10;
                                                    }
                                                    if (this.dPInt < 0) {
                                                        this.dTInt = -10;
                                                        this.dPInt = -this.dPInt;
                                                    }
                                                    if (this.dQInt < 0) {
                                                        this.dUInt = -10;
                                                        this.dQInt = -this.dQInt;
                                                    }
                                                    this.aoBoolean = (this.dTInt <= 0);
                                                    final int n36 = this.aoBoolean ? 7 : 6;
                                                    boolean b3 = false;
                                                    Label_4533:
                                                    {
                                                        Label_4532:
                                                        {
                                                            if (this.dQInt <= this.dPInt) {
                                                                this.dRInt = 2 * this.dPInt;
                                                                this.dSInt = 2 * this.dQInt;
                                                                if ((this.dTInt < 0 && this.dMInt <= n35) || (this.dTInt > 0 && this.dMInt >= n35)) {
                                                                    i.aClassfArr[17].drawFrame(this.aClassGraphics, n36, 37 + this.dXInt * 13 + 6, 73 + this.dYInt * 13 + 6, 0);
                                                                    this.anBoolean = true;
                                                                    b3 = true;
                                                                    break Label_4533;
                                                                }
                                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, n36, this.dMInt, this.dNInt, 0);
                                                                this.dMInt += this.dTInt;
                                                                this.dOInt += this.dSInt;
                                                                if (this.dOInt <= this.dPInt) {
                                                                    break Label_4532;
                                                                }
                                                                this.dNInt += this.dUInt;
                                                            } else {
                                                                this.dRInt = 2 * this.dQInt;
                                                                this.dSInt = 2 * this.dPInt;
                                                                if ((this.dUInt < 0 && this.dNInt <= n34) || (this.dUInt > 0 && this.dNInt >= n34)) {
                                                                    i.aClassfArr[17].drawFrame(this.aClassGraphics, n36, 37 + this.dXInt * 13 + 6, 73 + this.dYInt * 13 + 6, 0);
                                                                    this.anBoolean = true;
                                                                    b3 = true;
                                                                    break Label_4533;
                                                                }
                                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, n36, this.dMInt, this.dNInt, 0);
                                                                this.dNInt += this.dUInt;
                                                                this.dOInt += this.dSInt;
                                                                if (this.dOInt <= this.dQInt) {
                                                                    break Label_4532;
                                                                }
                                                                this.dMInt += this.dTInt;
                                                            }
                                                            this.dOInt -= this.dRInt;
                                                        }
                                                        b3 = false;
                                                    }
                                                    if (b3) {
                                                        this.dVInt = this.dXInt;
                                                        this.dWInt = this.dYInt;
                                                    }
                                                }
                                            } else if (this.awBoolean) {
                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, this.aoBoolean ? 7 : 6, n27, n28, 0);
                                            }
                                            h h3 = null;
                                            Graphics graphics4 = null;
                                            String s7 = null;
                                            int n37 = 0;
                                            int n38 = 0;
                                            int n39 = 0;
                                            Label_4743:
                                            {
                                                final int aInt2;
                                                String[] array;
                                                int n40;
                                                if ((aInt2 = aInt(i.aLongArrArr[this.dVInt][this.dWInt], (byte) 6, (byte) 5)) < this.dKInt) {
                                                    if (i.bBoolean) {
                                                        h3 = i.textSize0;
                                                        graphics4 = this.aClassGraphics;
                                                        s7 = i.stageTitles[aInt2];
                                                        n37 = 234;
                                                        n38 = a_Config.iInt;
                                                        n39 = 40;
                                                        break Label_4743;
                                                    }
                                                    h3 = i.textSize0;
                                                    graphics4 = this.aClassGraphics;
                                                    array = i.stageTitles;
                                                    n40 = aInt2;
                                                } else {
                                                    if (i.bBoolean) {
                                                        h3 = i.textSize0;
                                                        graphics4 = this.aClassGraphics;
                                                        s7 = i.stageTitles[aInt2 + 10 - this.dKInt + 1];
                                                        n37 = 234;
                                                        n38 = a_Config.iInt;
                                                        n39 = 40;
                                                        break Label_4743;
                                                    }
                                                    h3 = i.textSize0;
                                                    graphics4 = this.aClassGraphics;
                                                    array = i.stageTitles;
                                                    n40 = aInt2 + 10 - this.dKInt + 1;
                                                }
                                                s7 = array[n40];
                                                n37 = 8;
                                                n38 = a_Config.iInt;
                                                n39 = 36;
                                            }
                                            h3.drawTextWithFlags(graphics4, s7, n37, n38, n39);
                                            if (this.dVInt != this.dXInt || this.dWInt != this.dYInt) {
                                                break Label_5087;
                                            }
                                            final int aInt3 = aInt(i.aLongArrArr[this.dVInt][this.dWInt], (byte) 6, (byte) 5);
                                            int bInt = this.bInt(this.crtWorldIndex, aInt3);
                                            final int cInt = this.cInt(this.crtWorldIndex, aInt3);
                                            if (bInt > cInt) {
                                                bInt = cInt;
                                            }
                                            i.crtWorldMapFileName.delete(0, i.crtWorldMapFileName.length());
                                            i.crtWorldMapFileName.append(bInt);
                                            i.crtWorldMapFileName.append('/');
                                            i.crtWorldMapFileName.append(cInt);
                                            i.textSize8.calculateStringSize(i.crtWorldMapFileName.toString());
                                            final int n41 = h.stringWidth + 6 + 14;
                                            final int n42 = 37 + this.dVInt * 13 + 6;
                                            final int n43 = 73 + this.dWInt * 13 + 6;
                                            int n44 = n42 - (n41 >> 1);
                                            int n45;
                                            if ((n45 = n43 - 17 - 26) <= 63) {
                                                n45 = 63;
                                                if ((n44 = n42 + 20) + n41 >= 220) {
                                                    n44 = n42 - n41 - 20;
                                                }
                                            }
                                            if (n44 <= 25) {
                                                n44 = 25;
                                            }
                                            if (n44 + n41 >= 220) {
                                                n44 = 170;
                                            }
                                            aVoid(this.aClassGraphics, n44, n45 - 15, n41, 17, 37042, 0);
                                            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.crtWorldMapFileName.toString(), n44 + 2, n45 + 2 + 8, 20);
                                            if (i.aClassfArr[17] != null) {
                                                i.aClassfArr[17].drawFrame(this.aClassGraphics, 10, n44 + n41 - 2 - 14, n45 + 2 - 1, 0);
                                            }
                                            break Label_5087;
                                        }
                                    }
                                    color4 = n26;
                                    continue;
                                }
                            }
                        }
                        if (this.awBoolean && this.dVInt == this.dXInt && this.dWInt == this.dYInt) {
                            this.awBoolean = false;
                        }
                        break;
                    }
                    case 18: {
                        i.aClassfArr[17] = loadSprite("/ms.f", 0, 0, 0);
                        this.PVoid();
                        this.avBoolean = true;
                        i.bByte = 25;
                        this.enInt = this.nInt;
                        this.gClassString = i.texts[125] + " " + unpackUint16(i.iByteArr, 4) + " " + i.texts[19];
                    }
                    case 25: {
                        this.ayVoid();
                    }
                    case 27: {
                        this.BVoid();
                        break;
                    }
                    case 31: {
                        if (this.QBoolean) {
                            this.QBoolean = false;
                            this.aClassGraphics.setColor(0);
                            this.aClassGraphics.fillRect(0, 0, 240, 320);
                            i.textSize8.drawText(this.aClassGraphics, aClassString(i.texts[this.OBoolean ? 39 : 21]), 120, 160, 3);
                            this.JVoid();
                            this.IVoid();
                            break;
                        }
                        break;
                    }
                    case 16: {
                        this.KVoid();
                        break;
                    }
                    case 29: {
                        this.AVoid();
                        break;
                    }
                }
                final h aClassh5 = i.textSize8;
                if (i.eqInt > 0) {
                    aClassh5.calculateStringSize(this.hClassString);
                    final int bInt2 = h.stringHeight;
                    final int aInt4 = h.stringWidth;
                    if (this.erInt == -1) {
                        this.erInt = 240 - aInt4 >> 1;
                    }
                    if (this.esInt == -1) {
                        this.esInt = 320 - bInt2 >> 1;
                    }
                    this.aClassGraphics.setClip(this.erInt - 6, this.esInt - 3, aInt4 + 12, bInt2 + 26 + 6);
                    aVoid(this.aClassGraphics, this.erInt - 6, this.esInt - 3, aInt4 + 12, bInt2 + 6, this.etInt, this.euInt);
                    aClassh5.drawText(this.aClassGraphics, this.hClassString, this.erInt, this.esInt + 26, 0);
                }
            } catch (Throwable t) {
            }
        } catch (Exception ex3) {
        }
    }

    private static String aClassString(final String s) {
        final String[] a = c.aClassStringArr(s, 220);
        String string = "";
        for (int i = 0; i < a.length; ++i) {
            string = string + a[i] + "\n";
        }
        return string;
    }

    private void aVoid(final Graphics graphics, final boolean b, final int n, final int n2) {
        graphics.setClip(0, 0, 240, 320);
        int n3 = 0;
        int n4 = 0;
        if (n != 0 || n2 != 0) {
            n3 -= 24;
            n4 -= 24;
        }
        for (int iInteger = n4; iInteger < 320; iInteger += 24) {
            for (int j = n3; j < 240; j += 24) {
                graphics.drawImage(i.textures[8][0], j + n, iInteger + n2, 0);
            }
        }
        i.aClassfArr[10].drawFrame(graphics, 0, this.zInt + n, this.AInt + n2, 0);
        if (b) {
            for (int k = 0; k < 320; k += 24) {
                for (int l = 0; l < 240; l += 24) {
                    i.aClassfArr[17].drawFrame(graphics, 16, l, k, 0);
                }
            }
        }
    }

    private void aVoid(final Graphics graphics, final boolean b) {
        this.aVoid(graphics, b, 0, 0);
    }

    private void AVoid() {
        if (this.avBoolean) {
            this.aVoid(this.aClassGraphics, false, this.YInt, this.ZInt);
            i.aClassfArr[17].drawFrame(this.aClassGraphics, 11, 120 + a_Config.sealItemPosOffsets[6] + this.YInt, 136 + a_Config.sealItemPosOffsets[7] + this.ZInt, 0);
            for (int iInteger = 0; iInteger < 3; ++iInteger) {
                i.aClassfArr[iInteger + 52].drawFrame(this.aClassGraphics, 0, a_Config.sealItemPosOffsets[iInteger << 1] + 120 - this.GInt + this.YInt, a_Config.sealItemPosOffsets[(iInteger << 1) + 1] + 136 - this.HInt + this.ZInt, 0);
            }
        }
        switch (this.WInt) {
            case 1: {
                if (!this.avBoolean) {
                    this.aClassGraphics.setColor(this.XInt);
                    this.aClassGraphics.fillRect(0, 0, 240, 320);
                    for (int j = 0; j < 3; ++j) {
                        i.aClassfArr[j + 52].drawFrame(this.aClassGraphics, 0, a_Config.sealItemPosOffsets[j << 1] + 120 - this.GInt, a_Config.sealItemPosOffsets[(j << 1) + 1] + 136 - this.HInt, 0);
                    }
                    break;
                }
                break;
            }
            case 2: {
            }
            case 3: {
            }
            case 4: {
            }
            case 5: {
            }
            case 6: {
            }
            case 7: {
            }
            case 8: {
                g.aVoid(this.aClassGraphics);
            }
            case 9:
            case 10: {
                g.aVoid(this.aClassGraphics);
                final String aClassString = aClassString(i.texts[15] + "\n" + i.texts[20]);
                i.textSize8.calculateStringSize(aClassString);
                aVoid(this.aClassGraphics, (240 - h.stringWidth >> 1) - 3, (320 - h.stringHeight >> 1) - 3, h.stringWidth + 6, h.stringHeight + 6, 7096587, 0);
                i.textSize8.drawText(this.aClassGraphics, aClassString, 120, (320 - h.stringHeight >> 1) + 24, 17);
                break;
            }
        }
    }

    private void BVoid() {
        if (this.avBoolean || this.gBoolean) {
            this.aClassGraphics.setClip(0, 0, 240, 320);
            this.aVoid(this.aClassGraphics, false);
            i.aClassfArr[17].drawFrame(this.aClassGraphics, 11, 120 + a_Config.sealItemPosOffsets[6], 136 + a_Config.sealItemPosOffsets[7], 0);
            this.IVoid();
            this.JVoid();
            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.texts[36], 218, 314, 10);
            this.avBoolean = false;
        } else {
            this.aClassGraphics.setClip(this.sInt + 120, this.tInt + 136, 14, 22);
            i.aClassfArr[10].drawFrame(this.aClassGraphics, 0, this.zInt, this.AInt, 0);
        }
        if (this.BInt != 0) {
            this.gBoolean = false;
            this.avBoolean = true;
            for (int iInteger = 0; iInteger < this.BInt; ++iInteger) {
                if (isSealPositionUnlocked(iInteger)) {
                    i.aClassfArr[10].drawFrame(this.aClassGraphics, iInteger + 1, this.zInt, this.AInt, 0);
                }
            }
            this.aClassGraphics.setClip(0, 0, 240, 320);
            if (this.KInt < this.JInt) {
                i.aClassfArr[9].drawAnimationFrame(this.aClassGraphics, 5, this.KInt, a_Config.sealItemPosOffsets[this.BInt << 1] + 120 - 12, a_Config.sealItemPosOffsets[(this.BInt << 1) + 1] + 124, 0, 0, 0);
                ++this.KInt;
            } else {
                if (this.yInt % this.xInt >= this.xInt >> 1) {
                    i.aClassfArr[10].drawFrame(this.aClassGraphics, this.BInt + 1, this.zInt, this.AInt, 0);
                    ++this.CInt;
                }
                if (this.CInt >= 15) {
                    i.aBooleanArr[this.BInt] = true;
                    this.CInt = 0;
                    this.BInt = 0;
                    this.KInt = 0;
                    this.hVoid();
                    this.gBoolean = true;
                    this.avBoolean = false;
                }
            }
        } else {
            for (int j = 0; j < 3; ++j) {
                if (i.aBooleanArr[j]) {
                    i.aClassfArr[10].drawFrame(this.aClassGraphics, j + 1, this.zInt, this.AInt, 0);
                }
            }
        }
        for (int k = 0; k < 3; ++k) {
            if (i.bBooleanArr[k]) {
                final int n = k + 52;
                if (this.DInt != k) {
                    i.aClassfArr[n].drawFrame(this.aClassGraphics, 0, a_Config.sealItemPosOffsets[k << 1] + 120 - this.GInt, a_Config.sealItemPosOffsets[(k << 1) + 1] + 136 - this.HInt, 0);
                }
            }
        }
        if (this.DInt != -1) {
            this.avBoolean = true;
            final int dInt = this.DInt;
            final int n2 = dInt + 52;
            final int n3 = a_Config.sealItemPosOffsets[dInt << 1] + 120;
            final int n5;
            final int n4 = (n5 = a_Config.sealItemPosOffsets[(dInt << 1) + 1] + 136) - this.FInt;
            final int n6 = n3 - this.EInt;
            Label_0677:
            {
                if (n4 < 0) {
                    this.FInt -= 2;
                    if (this.FInt > n5) {
                        break Label_0677;
                    }
                } else {
                    if (n4 <= 0) {
                        break Label_0677;
                    }
                    this.FInt += 2;
                    if (this.FInt < n5) {
                        break Label_0677;
                    }
                }
                this.FInt = n5;
            }
            Label_0734:
            {
                if (n6 < 0) {
                    this.EInt -= 3;
                    if (this.EInt > n3) {
                        break Label_0734;
                    }
                } else {
                    if (n6 <= 0) {
                        break Label_0734;
                    }
                    this.EInt += 3;
                    if (this.EInt < n3) {
                        break Label_0734;
                    }
                }
                this.EInt = n3;
            }
            i.aClassfArr[n2].drawFrame(this.aClassGraphics, 0, this.EInt - this.GInt, this.FInt - this.HInt, 0);
            boolean b = false;
            Label_0946:
            {
                if (this.EInt == n3 && this.FInt == n5) {
                    this.EInt = n3;
                    this.FInt = n5;
                    if (this.IInt < 20) {
                        if (this.IInt % 2 == 1) {
                            this.aClassGraphics.setColor(0 + 838860 * this.IInt);
                            this.aClassGraphics.fillRect(0, 0, 240, 320);
                        }
                        ++this.IInt;
                    } else {
                        if (this.KInt >= this.JInt) {
                            this.KInt = 0;
                            this.IInt = 0;
                            b = true;
                            break Label_0946;
                        }
                        i.aClassfArr[9].drawAnimationFrame(this.aClassGraphics, 5, this.KInt, a_Config.sealItemPosOffsets[dInt << 1] + 120 - 12, a_Config.sealItemPosOffsets[(dInt << 1) + 1] + 124, 0, 0, 0);
                        ++this.KInt;
                    }
                }
                b = false;
            }
            if (b) {
                this.DInt = -1;
                if (i.bBooleanArr[0] && i.bBooleanArr[1] && i.bBooleanArr[2]) {
                    this.eVoid();
                    this.avBoolean = true;
                    this.iBoolean = true;
                    i.bByte = 29;
                }
            }
            return;
        }
        this.yInt %= this.xInt;
        this.aClassGraphics.setClip(this.qInt + 120, 136 + this.rInt, 14, 22);
        i.aClassfArr[55].drawAnimationFrame(this.aClassGraphics, 0, this.yInt, 120 + this.qInt, 136 + this.rInt, 0, 0, 0);
        ++this.yInt;
        if (this.gBoolean) {
            final String s = (c.aClassStringArr(this.bClassString, 220).length > 1) ? aClassString(this.bClassString + "\n" + this.cClassString) : (aClassString(this.bClassString) + this.cClassString);
            i.textSize8.calculateStringSize(s);
            final int n7 = (240 - h.stringWidth >> 1) - 3;
            final int n8 = 240 - (i.textSize8.font.getHeight() >> 1) - 3;
            final int n9 = h.stringWidth + 6;
            final int n10 = h.stringHeight + 3;
            this.aClassGraphics.setClip(n7, n8 - 15, n9, n10 + 20);
            aVoid(this.aClassGraphics, n7, n8 - 15, n9, n10, 7096587, 0);
            i.textSize8.drawText(this.aClassGraphics, s, 120, 240, 3);
            this.gBoolean = false;
        }
    }

    private static void bVoid(final Graphics graphics, final boolean b) {
        graphics.drawImage(i.splashBgGradientImage, 0, 0, 20);
        graphics.drawImage(i.splashLogoImage, 0, 0, 20);
        if (b) {
            graphics.drawImage(i.splashCopyrightImage, 120, 319, 33);
        }
    }

    private static void aVoid(final Graphics graphics, final int n, final int n2, final int n3, final int n4) {
        graphics.drawImage(i.dClassImage, n3 - n, n4 - n2, 0);
    }

    private void bVoid(final int n, final int n2) {
        final int n3 = this.aInt - this.aInt % 24;
        final int n4 = this.bInt - this.bInt % 24;
        final int n5 = this.aInt + i.cCInt - 24 - (this.aInt + i.cCInt - 24) % 24;
        final int n6 = this.bInt + i.cDInt - 24 - (this.bInt + i.cDInt - 24) % 24;
        final int n7 = n * 24;
        final int n8 = n2 * 24;
        if (n7 >= n3 && n7 <= n5 && n8 >= n4 && n8 <= n6) {
            final int n9 = i.crtStageForegrondLayer[n][n2] & 0xFF;
            if (i.crtStagePlayerLayer[n][n2] < 80) {
                if (n9 == 4 || n9 == 16 || n9 == 15) {
                    this.cVoid(n, n2);
                    return;
                }
                i.bClassGraphics.drawImage(i.textures[8][0], n7 % i.cCInt, n8 % i.cDInt, 0);
            }
        }
    }

    private void cVoid(int n, int n2) {
        final int n3 = this.aInt - this.aInt % 24;
        final int n4 = this.bInt - this.bInt % 24;
        final int n5 = this.aInt + i.cCInt - 24 - (this.aInt + i.cCInt - 24) % 24;
        final int n6 = this.bInt + i.cDInt - 24 - (this.bInt + i.cDInt - 24) % 24;
        n *= 24;
        n2 *= 24;
        if (n >= n3 && n <= n5 && n2 >= n4 && n2 <= n6) {
            this.aVoid(n, n2, n, n2, false);
        }
    }

    public static int aInt(final int n) {
        switch (n) {
            case 0: {
                return 42;
            }
            case 20: {
                return 43;
            }
            case 22: {
                i.aClassfArr[45].paletteI = 0;
                return 45;
            }
            case 23: {
                i.aClassfArr[45].paletteI = 1;
                return 45;
            }
            case 4: {
                return 56;
            }
            case 15: {
                i.aClassfArr[57].paletteI = 0;
                return 57;
            }
            case 14: {
                i.aClassfArr[57].paletteI = 1;
                return 57;
            }
            case 16: {
                return 58;
            }
            case 2: {
                i.aClassfArr[59].paletteI = 0;
                return 59;
            }
            case 3: {
                i.aClassfArr[59].paletteI = 1;
                return 59;
            }
            case 1: {
                return 60;
            }
            default: {
                return -1;
            }
        }
    }

    private void aVoid(final int n, int iInteger, final int n2, final int n3, final boolean b) {
        final Graphics bClassGraphics = i.bClassGraphics;
        final int ccInt = i.cCInt;
        final int cdInt = i.cDInt;
        final int n4 = n % ccInt;
        this.byInt = iInteger % cdInt - 24;
        this.bHInt = iInteger / 24 - 1;
        int j;
        int n5;
        int n6;
        i k = null;
        int akInt = 0;
        int n7;
        byte b2;
        i l = null;
        int amInt = 0;
        int n8;
        Graphics graphics;
        for (iInteger = iInteger; iInteger <= n3; iInteger += 24) {
            this.bxInt = n4 - 24;
            this.bGInt = n / 24 - 1;
            this.byInt += 24;
            ++this.bHInt;
            if (this.byInt >= cdInt) {
                this.byInt = 0;
            }
            for (j = n; j <= n2; j += 24) {
                this.bxInt += 24;
                ++this.bGInt;
                if (this.bxInt >= ccInt) {
                    this.bxInt = 0;
                }
                if (this.bGInt >= 0 && this.bGInt < this.crtStageWidth && this.bHInt >= 0 && this.bHInt < this.crtStageHeight) {
                    this.bIInt = i.crtStagePlayerLayer[this.bGInt][this.bHInt];
                    this.bJInt = (i.crtStageForegrondLayer[this.bGInt][this.bHInt] & 0xFF);
                    if (this.bIInt < 80) {
                        bClassGraphics.drawImage(i.textures[8][0], this.bxInt, this.byInt, 0);
                    }
                    Label_0439:
                    {
                        if (this.bJInt > -1 && this.bJInt < 38) {
                            switch (this.bJInt) {
                                case 4: {
                                    this.aJInt = 20;
                                    this.aKInt = 7;
                                    n5 = 0;
                                    this.bOInt = n5;
                                    this.bNInt = n5;
                                    break Label_0439;
                                }
                                case 27: {
                                    this.aJInt = 21;
                                    this.aKInt = 0;
                                    n6 = 0;
                                    this.bOInt = n6;
                                    this.bNInt = n6;
                                    break Label_0439;
                                }
                                case 15: {
                                    if (this.ceInt == 0) {
                                        this.aJInt = 14;
                                        k = this;
                                        akInt = 0 + this.ceInt * 5 / 10;
                                        break;
                                    }
                                    break Label_0439;
                                }
                                case 16: {
                                    if (this.ceInt != 9) {
                                        break Label_0439;
                                    }
                                    this.aJInt = 15;
                                    this.aKInt = 4 - this.ceInt * 5 / 10;
                                    if (this.aKInt < 0) {
                                        k = this;
                                        akInt = 0;
                                        break;
                                    }
                                    break Label_0439;
                                }
                            }
                            k.aKInt = akInt;
                        }
                    }
                    if (this.aJInt != -1) {
                        if (i.textures[this.aJInt] == null) {
                            i.aClassfArr[aInt(this.aJInt)].drawFrame(bClassGraphics, this.aKInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                        } else {
                            bClassGraphics.drawImage(i.textures[this.aJInt][this.aKInt], this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                        }
                        this.bPInt = 0;
                        this.aJInt = -1;
                        n7 = 0;
                        this.bOInt = n7;
                        this.bNInt = n7;
                    }
                    if (this.bIInt != -1) {
                        Label_0854:
                        {
                            if ((b2 = (byte) (this.bIInt - 80)) >= 0) {
                                this.aLInt = 0;
                                l = this;
                                amInt = b2;
                            } else {
                                switch (this.bIInt) {
                                    case 10: {
                                        i.aClassfArr[16].drawFrame(bClassGraphics, 0, this.bxInt, this.byInt, 0);
                                        break Label_0854;
                                    }
                                    case 1: {
                                        if (i.bByteArrArr[this.bGInt][this.bHInt] == 0 && (i.eIntArrArr == null || i.eIntArrArr[this.bGInt][this.bHInt] == 0)) {
                                            this.OVoid();
                                            this.aMInt -= this.bRInt;
                                            this.bOInt = 0;
                                        }
                                        break Label_0854;
                                    }
                                    case 0: {
                                        if (i.bByteArrArr[this.bGInt][this.bHInt] == 0 && (i.eIntArrArr == null || i.eIntArrArr[this.bGInt][this.bHInt] == 0)) {
                                            this.OVoid();
                                        }
                                        break Label_0854;
                                    }
                                    case 34: {
                                        if (this.ceInt == 9) {
                                            this.aLInt = 14;
                                            l = this;
                                            amInt = 0 + this.ceInt * 5 / 10;
                                            break;
                                        }
                                        break Label_0854;
                                    }
                                    case 35: {
                                        if (this.ceInt != 0) {
                                            break Label_0854;
                                        }
                                        this.aLInt = 15;
                                        this.aMInt = 4 - this.ceInt * 5 / 10;
                                        if (this.aMInt < 0) {
                                            l = this;
                                            amInt = 0;
                                            break;
                                        }
                                        break Label_0854;
                                    }
                                }
                            }
                            l.aMInt = amInt;
                        }
                        if (this.aLInt != -1) {
                            if (i.textures[this.aLInt] == null) {
                                i.aClassfArr[aInt(this.aLInt)].drawFrame(bClassGraphics, this.aMInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                            } else {
                                bClassGraphics.drawImage(i.textures[this.aLInt][this.aMInt], this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                            }
                            this.aLInt = -1;
                            this.bPInt = 0;
                            n8 = 0;
                            this.bOInt = n8;
                            this.bNInt = n8;
                        }
                    }
                    if (this.kByte == 2) {
                        graphics = bClassGraphics;
                        if (i.aClassfArr[10] == null) {
                            i.aClassfArr[10] = loadSprite("/mmv.f", 0, 0, 0);
                        }
                        if (this.bGInt >= 60 && this.bGInt < 65 && this.bHInt >= 2 && this.bHInt < 7) {
                            i.aClassfArr[10].drawFrame(graphics, 4 + (this.bHInt - 2) * 5 + this.bGInt - 60, this.bxInt, this.byInt, 0);
                        }
                    }
                }
            }
        }
    }

    private void CVoid() {
        this.aClassGraphics.setClip(0, 0, 240, 240);
    }

    private void DVoid() {
        final Graphics aClassGraphics = this.aClassGraphics;
        final int asInt = i.aSInt;
        this.bQInt = (((this.kInt & 0x1000) == 0x0) ? this.lByte : 0);
        aClassGraphics.translate(0, 40);
        this.bkInt = 0;
        this.CVoid();
        if (this.bjInt > 0) {
            this.bkInt = this.bjInt * asInt % ((this.bjInt >> 1) + 1) % 12;
        }
        if (this.bkInt > this.bInt) {
            this.bkInt = this.bInt;
        }
        this.bInt -= this.bkInt;
        this.cIInt = this.aInt / 24;
        this.cJInt = this.bInt / 24;
        this.cKInt = this.aInt % 24;
        this.cLInt = this.bInt % 24;
        this.bRInt = (asInt & 0x3F) >> 1;
        if (this.bRInt >= 4) {
            this.bRInt = 0;
        }
        final int n = this.aInt - this.cKInt;
        final int n2 = this.bInt - this.cLInt;
        final int n3 = this.aInt + i.cCInt - 24 - (this.aInt + i.cCInt - 24) % 24;
        final int n4 = this.bInt + i.cDInt - 24 - (this.bInt + i.cDInt - 24) % 24;
        if (i.cEInt == -1) {
            this.aVoid(n, n2, n3, n4, false);
            i.cEInt = n;
            i.cFInt = n3;
            i.cGInt = n2;
            i.cHInt = n4;
        }
        if (i.cEInt != n) {
            int n5;
            int n6;
            if (i.cEInt < n) {
                n5 = i.cFInt + 24;
                n6 = n3;
            } else {
                n5 = n;
                n6 = i.cEInt - 24;
            }
            this.aVoid(n5, n2, n6, n4, false);
            i.cEInt = n;
            i.cFInt = n3;
        }
        if (i.cGInt != n2) {
            int n7;
            int n8;
            if (i.cGInt < n2) {
                n7 = i.cHInt + 24;
                n8 = n4;
            } else {
                n7 = n2;
                n8 = i.cGInt - 24;
            }
            this.aVoid(n, n7, n3, n8, false);
            i.cGInt = n2;
            i.cHInt = n4;
        }
        final Graphics graphics = aClassGraphics;
        final int n9 = this.aInt % i.cCInt;
        final int n10 = this.bInt % i.cDInt;
        final int n11 = (this.aInt + 240) % i.cCInt;
        final int n12 = (this.bInt + 240) % i.cDInt;
        Graphics graphics2 = null;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        Label_0602:
        {
            if (n11 > n9) {
                if (n12 > n10) {
                    graphics2 = graphics;
                    n13 = n9;
                    n14 = n10;
                    n15 = 0;
                    n16 = 0;
                    break Label_0602;
                }
                aVoid(graphics, n9, n10, 0, 0);
                graphics2 = graphics;
                n13 = n9;
                n14 = 0;
                n15 = 0;
            } else {
                if (n12 > n10) {
                    aVoid(graphics, n9, n10, 0, 0);
                    graphics2 = graphics;
                    n13 = 0;
                    n14 = n10;
                    n15 = 240 - n11;
                    n16 = 0;
                    break Label_0602;
                }
                aVoid(graphics, n9, n10, 0, 0);
                aVoid(graphics, n9, 0, 0, 240 - n12);
                aVoid(graphics, 0, n10, 240 - n11, 0);
                graphics2 = graphics;
                n13 = 0;
                n14 = 0;
                n15 = 240 - n11;
            }
            n16 = 240 - n12;
        }
        aVoid(graphics2, n13, n14, n15, n16);
        this.CVoid();
        final Graphics graphics3 = aClassGraphics;
        for (int iInteger = -1; iInteger < 12; ++iInteger) {
            i k = null;
            int bjInt;
            int n17;
            int n18;
            int bgInt;
            int bhInt;
            i l;
            int boInt;
            int bgInt2;
            int bhInt2;
            int n19;
            i m;
            int akInt;
            int n20;
            i i2;
            int akInt2;
            int n21;
            i i3;
            int n22;
            int n23;
            int bgInt3;
            int bhInt3;
            int n24;
            byte b;
            int n25;
            int n26;
            i i4;
            int blInt;
            i i5;
            int bkInt;
            int n27;
            int n28;
            boolean b2;
            i i6;
            int blInt2;
            byte b3;
            int n29;
            i i7 = null;
            int blInt3 = 0;
            i i8 = null;
            int boInt2 = 0;
            i i9 = null;
            int bkInt2 = 0;
            int n30;
            i i10;
            byte boInt3;
            int aInt;
            int n31;
            int n32;
            int n33;
            int n34;
            int blInt4;
            int a;
            int n35;
            int n36;
            int aInt2;
            int n37;
            i i11 = null;
            int blInt5 = 0;
            int bxInt;
            int byInt;
            int n38;
            Image[] array;
            int n39;
            int n40;
            f_Sprite f;
            i i12;
            int blInt6;
            int n41;
            int n42;
            int n43;
            int n44;
            int n45;
            int n46;
            f_Sprite f2;
            Graphics graphics4;
            int n48;
            int n49;
            int n50;
            int n51;
            f_Sprite f3;
            byte b4;
            int n52;
            short blInt7;
            int asInt2;
            int n54;
            byte b5;
            int n55;
            int n56;
            int n57;
            byte b6;
            int bxInt2;
            int n58;
            i i13;
            int blInt8;
            int bgInt4;
            int bhInt4;
            int n59;
            i i14;
            int amInt;
            int n60;
            i i15 = null;
            int boInt4 = 0;
            i i16 = null;
            int boInt5 = 0;
            i i17 = null;
            int n61;
            Label_3025_Outer:
            Label_5350_Outer:
            for (int j = -1; j < 12; ++j) {
                this.bGInt = j + this.cIInt;
                this.bHInt = iInteger + this.cJInt;
                if (this.bGInt >= 0 && this.bGInt < this.crtStageWidth && this.bHInt >= 0 && this.bHInt < this.crtStageHeight) {
                    this.bIInt = i.crtStagePlayerLayer[this.bGInt][this.bHInt];
                    this.bJInt = (i.crtStageForegrondLayer[this.bGInt][this.bHInt] & 0xFF);
                    this.bxInt = j * 24 - this.cKInt;
                    this.byInt = iInteger * 24 - this.cLInt;
                    this.CVoid();
                    Label_2138:
                    {
                        if (this.bJInt > -1 && this.bJInt < 38) {
                            Label_1934:
                            {
                                switch (this.bJInt) {
                                    case 35: {
                                        k = this;
                                        break;
                                    }
                                    case 34: {
                                        i.aClassfArr[27].drawAnimationFrame(graphics3, 2, 0, this.bxInt, this.byInt, 0, 0, 0);
                                        break Label_1934;
                                    }
                                    case 14:
                                    case 33: {
                                        bjInt = this.bJInt;
                                        if ((n17 = i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8) == 255) {
                                            n17 = 0;
                                        }
                                        n18 = ((14 == bjInt) ? 8 : 22);
                                        if (i.aClassfArr[n18] != null) {
                                            i.aClassfArr[n18].drawAnimationFrame(this.aClassGraphics, 0, n17, this.bxInt, this.byInt, 0, 0, 0);
                                        }
                                        break Label_1934;
                                    }
                                    case 6: {
                                        bgInt = this.bGInt;
                                        bhInt = this.bHInt;
                                        this.aJInt = 26;
                                        this.aKInt = 0;
                                        Label_1272:
                                        {
                                            if (iBoolean(bgInt, bhInt) && i.bByteArrArr[bgInt][bhInt] <= 12) {
                                                l = this;
                                                boInt = -(i.bByteArrArr[bgInt][bhInt] - 12);
                                            } else if (this.isPlayerAtPosition(bgInt, bhInt)) {
                                                if ((this.kInt & 0x1000) == 0x0) {
                                                    if (this.jInt > 12) {
                                                        break Label_1272;
                                                    }
                                                    l = this;
                                                    boInt = -(this.jInt - 12);
                                                } else {
                                                    l = this;
                                                    boInt = 12;
                                                }
                                            } else {
                                                if (this.isPlayerAtPosition(bgInt - 1, bhInt)) {
                                                    if (this.bQInt != 4 || this.jInt <= 12) {
                                                        break Label_1272;
                                                    }
                                                } else if (!this.isPlayerAtPosition(bgInt + 1, bhInt) || this.bQInt != 2 || this.jInt <= 12) {
                                                    break Label_1272;
                                                }
                                                l = this;
                                                boInt = this.jInt - 12;
                                            }
                                            l.bOInt = boInt;
                                        }
                                        this.bOInt += 24;
                                        this.bPInt = 36;
                                        if (this.byInt + 24 < 240) {
                                            graphics3.clipRect(this.bxInt, this.byInt, 24, 24);
                                        }
                                        break Label_1934;
                                    }
                                    case 15: {
                                        if (this.ceInt != 0 && this.ceInt <= 5) {
                                            this.aJInt = 14;
                                            this.aKInt = 0 + this.ceInt * 5 / 10;
                                        }
                                        break Label_1934;
                                    }
                                    case 16: {
                                        if (this.ceInt == 9 || this.ceInt < 5) {
                                            break Label_1934;
                                        }
                                        this.aJInt = 15;
                                        this.aKInt = 4 - this.ceInt * 5 / 10;
                                        if (this.aKInt < 0) {
                                            this.aKInt = 0;
                                        }
                                        break Label_1934;
                                    }
                                    case 7: {
                                        bgInt2 = this.bGInt;
                                        bhInt2 = this.bHInt;
                                        if ((n19 = ((i.crtStageForegrondLayer[bgInt2][bhInt2] >> 8 & 0xF0) >> 4) - 1) < 0) {
                                            n19 = 0;
                                        }
                                        if ((i.crtStageForegrondLayer[bgInt2][bhInt2 - 1] & 0xFF) != 0x9 && (i.crtStageForegrondLayer[bgInt2][bhInt2 - 1] & 0xFF) != 0x8) {
                                            i.aClassfArr[56].drawFrame(this.aClassGraphics, n19, this.bxInt, this.byInt, 0);
                                        }
                                        this.aJInt = 4;
                                        this.aKInt = (byte) (n19 + 3);
                                        break Label_1934;
                                    }
                                    case 4: {
                                        if (i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8 >= this.aCInt) {
                                            this.aJInt = 20;
                                            if (i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8 >= this.aCInt) {
                                                m = this;
                                                akInt = 0 + (i.aSInt >> 1) % 7;
                                            } else {
                                                m = this;
                                                akInt = 7;
                                            }
                                            m.aKInt = akInt;
                                        }
                                        break Label_1934;
                                    }
                                    case 5:
                                    case 28: {
                                        this.aJInt = 11;
                                        if ((this.crtWorldIndex == 0 && (this.crtStageI == 4 || this.crtStageI == 7)) || (this.crtWorldIndex == 1 && this.crtStageI == 8) || (this.crtWorldIndex == 2 && (this.crtStageI == 1 || this.crtStageI == 2 || this.crtStageI == 6 || this.crtStageI == 7))) {
                                            this.aKInt = 1;
                                            break Label_1934;
                                        }
                                        this.aKInt = 0;
                                        break Label_1934;
                                    }
                                    case 8:
                                    case 9: {
                                        n20 = i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8;
                                        this.aJInt = ((this.bJInt == 9) ? 22 : 23);
                                        if ((n20 & 0x200) != 0x0) {
                                            i2 = this;
                                            akInt2 = (byte) (1 + (i.aSInt >> 2) % 6);
                                        } else if ((n20 & 0x100) != 0x0) {
                                            i2 = this;
                                            akInt2 = 1;
                                        } else {
                                            i2 = this;
                                            akInt2 = 0;
                                        }
                                        i2.aKInt = akInt2;
                                        break Label_1934;
                                    }
                                    case 3: {
                                        if ((n21 = (i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8) - 1) >= 0) {
                                            this.aJInt = 12;
                                            this.aKInt = (byte) n21;
                                        }
                                        break Label_1934;
                                    }
                                    case 37: {
                                        i.aClassfArr[27].drawAnimationFrame(graphics3, 2, 0, this.bxInt, this.byInt, 0, 0, 0);
                                        k = this;
                                        break;
                                    }
                                }
                                i3 = k;
                                i.bClassf = i.aClassfArr[30];
                                i3.bKInt = 1;
                                i3.bLInt = aInt(i.bClassf, 1, i.aSInt % aInt(i.bClassf, 1));
                            }
                            if (this.aJInt != -1) {
                                if (i.textures[this.aJInt] == null) {
                                    i.aClassfArr[aInt(this.aJInt)].drawFrame(graphics3, this.aKInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                                } else {
                                    graphics3.drawImage(i.textures[this.aJInt][this.aKInt], this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                                }
                                this.bPInt = 0;
                                this.aJInt = -1;
                                graphics3.setClip(0, -this.bkInt, 240, 240);
                            } else {
                                if (i.bClassf == null) {
                                    break Label_2138;
                                }
                                if (this.bKInt != -1) {
                                    i.bClassf.drawAnimationFrame(graphics3, this.bKInt, this.bLInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, 0, 0, 0);
                                    this.bKInt = -1;
                                }
                                i.bClassf = null;
                            }
                            n22 = 0;
                            this.bOInt = n22;
                            this.bNInt = n22;
                        }
                    }
                    if (this.bIInt != -1) {
                        Label_5612:
                        {
                            if ((byte) (this.bIInt - 80) < 0) {
                                n23 = i.bIntArrArr[this.bGInt][this.bHInt];
                                Label_5608:
                                {
                                    switch (this.bIInt) {
                                        case 49: {
                                            bgInt3 = this.bGInt;
                                            bhInt3 = this.bHInt;
                                            n24 = i.bIntArrArr[bgInt3][bhInt3];
                                            b = i.bByteArrArr[bgInt3][bhInt3];
                                            n25 = (n24 & 0x7);
                                            this.bNInt = b * i.gByteArr[n25];
                                            this.bOInt = b * i.gByteArr[n25 + 8];
                                            i.bClassf = i.aClassfArr[38];
                                            if ((((n26 = (n24 & 0x7000) >> 12) == 2 || n26 == 4 || n25 == 2 || n25 == 4) && i.crtStagePlayerLayer[bgInt3 - 1][bhInt3] >= 0 && i.crtStagePlayerLayer[bgInt3 + 1][bhInt3] >= 0) || ((n26 == 1 || n26 == 3 || n25 == 1 || n25 == 3) && i.crtStagePlayerLayer[bgInt3][bhInt3 - 1] >= 0 && i.crtStagePlayerLayer[bgInt3][bhInt3 + 1] >= 0)) {
                                                this.bKInt = 1;
                                                i4 = this;
                                                blInt = 0;
                                            } else {
                                                if (n25 == 1 || n25 == 3) {
                                                    i5 = this;
                                                    bkInt = n25 - 1;
                                                } else {
                                                    i5 = this;
                                                    bkInt = 0;
                                                }
                                                i5.bKInt = bkInt;
                                                i4 = this;
                                                blInt = (i.aSInt >> 1) % i.bClassf.getAnimationFrameCount(this.bKInt);
                                            }
                                            i4.bLInt = blInt;
                                            this.FVoid();
                                            break Label_5612;
                                        }
                                        case 48: {
                                            if (((n27 = i.bIntArrArr[this.bGInt][this.bHInt]) & 0x8) == 0x0) {
                                                i.bClassf = i.aClassfArr[32];
                                                n28 = (n27 & 0x7);
                                                if (((b2 = ((n27 & 0x10) == 0x0)) && n28 == 2) || (!b2 && n28 == 4)) {
                                                    i6 = this;
                                                    blInt2 = 2;
                                                } else {
                                                    i6 = this;
                                                    blInt2 = (b2 ? 1 : 0);
                                                }
                                                i6.bLInt = blInt2;
                                                b3 = i.bByteArrArr[this.bGInt][this.bHInt];
                                                this.bNInt = b3 * i.gByteArr[n28];
                                                this.bOInt = b3 * i.gByteArr[n28 + 8];
                                            }
                                            break Label_5612;
                                        }
                                        case 21: {
                                            n29 = (i.bIntArrArr[this.bGInt][this.bHInt] & 0x7);
                                            i.bClassf = i.aClassfArr[29];
                                            Label_3107:
                                            {
                                                if ((i.bIntArrArr[this.bGInt][this.bHInt] & 0x8) == 0x0) {
                                                    while (true) {
                                                        switch (n29) {
                                                            case 1: {
                                                                i7 = this;
                                                                blInt3 = 2;
                                                                break;
                                                            }
                                                            case 2: {
                                                                i7 = this;
                                                                blInt3 = 1;
                                                                break;
                                                            }
                                                            case 4: {
                                                                i7 = this;
                                                                blInt3 = 0;
                                                                break;
                                                            }
                                                            default: {
                                                                this.bNInt = i.bByteArrArr[this.bGInt][this.bHInt] * i.gByteArr[n29];
                                                                i8 = this;
                                                                boInt2 = i.bByteArrArr[this.bGInt][this.bHInt] * i.gByteArr[n29 + 8];
                                                                break Label_3107;
                                                            }
                                                        }
                                                        i7.bLInt = blInt3;
                                                        //continue Label_3025_Outer;
                                                        continue Label_5350_Outer;
                                                    }
                                                }
                                                while (true) {
                                                    switch (n29) {
                                                        case 1: {
                                                            i9 = this;
                                                            bkInt2 = 14;
                                                            break;
                                                        }
                                                        case 2: {
                                                            i9 = this;
                                                            bkInt2 = 13;
                                                            break;
                                                        }
                                                        case 4: {
                                                            i9 = this;
                                                            bkInt2 = 12;
                                                            break;
                                                        }
                                                        default: {
                                                            this.bLInt = aInt(i.bClassf, this.bKInt, i.bByteArrArr[this.bGInt][this.bHInt]);
                                                            n30 = (i.bClassf.animationFirstAnimationFrameIndices[this.bKInt] + this.bLInt) * 5;
                                                            this.bNInt = i.bClassf.animationFrames[n30 + 2];
                                                            i8 = this;
                                                            boInt2 = i.bClassf.animationFrames[n30 + 3];
                                                            break Label_3107;
                                                        }
                                                    }
                                                    i9.bKInt = bkInt2;
                                                    continue;
                                                }
                                            }
                                            i8.bOInt = boInt2;
                                            break Label_5612;
                                        }
                                        case 46: {
                                            i.bClassf = i.aClassfArr[29];
                                            this.bKInt = (i.bIntArrArr[this.bGInt][this.bHInt] & 0x1F);
                                            if (this.bKInt == 8 || this.bKInt == 9) {
                                                this.bLInt = 0;
                                                this.bNInt = i.bClassf.animationFrames[i.bClassf.animationFirstAnimationFrameIndices[this.bKInt] * 5 + 2];
                                                i10 = this;
                                                boInt3 = (byte) (-i.bByteArrArr[this.bGInt][this.bHInt]);
                                            } else {
                                                aInt = aInt(i.bClassf, this.bKInt, (i.bIntArrArr[this.bGInt][this.bHInt] & 0x1FE0) >> 5);
                                                this.bLInt = aInt;
                                                n31 = (i.bClassf.animationFirstAnimationFrameIndices[this.bKInt] + aInt) * 5;
                                                this.bNInt = i.bClassf.animationFrames[n31 + 2];
                                                i10 = this;
                                                boInt3 = i.bClassf.animationFrames[n31 + 3];
                                            }
                                            i10.bOInt = boInt3;
                                            break Label_5612;
                                        }
                                        case 45: {
                                            n32 = i.bIntArrArr[this.bGInt][this.bHInt];
                                            i.bClassf = i.aClassfArr[28];
                                            this.bKInt = (n32 & 0xF);
                                            n33 = (i.bIntArrArr[this.bGInt][this.bHInt] & 0x1FE000) >> 13;
                                            if (this.bKInt == 10) {
                                                n34 = n33;
                                                blInt4 = 0;
                                                a = i.bClassf.getAnimationFrameCount(this.bKInt);
                                                n35 = 0;
                                                while (true) {
                                                    n36 = n35;
                                                    if (n34 <= 0) {
                                                        break;
                                                    }
                                                    n34 -= i.bClassf.getAnimationFrameTime(this.bKInt, n36);
                                                    blInt4 = n36;
                                                    n35 = (n36 + 1) % a;
                                                }
                                                this.bLInt = blInt4;
                                            } else {
                                                aInt2 = aInt(i.bClassf, this.bKInt, n33);
                                                this.bLInt = aInt2;
                                                n37 = (i.bClassf.animationFirstAnimationFrameIndices[this.bKInt] + aInt2) * 5;
                                                this.bNInt = i.bClassf.animationFrames[n37 + 2];
                                                this.bOInt = i.bClassf.animationFrames[n37 + 3];
                                            }
                                            this.FVoid();
                                            break Label_5612;
                                        }
                                        case 44: {
                                            this.bKInt = (i.bIntArrArr[this.bGInt][this.bHInt] & 0x38) >> 3;
                                            i.bClassf = i.aClassfArr[27];
                                            Label_3699:
                                            {
                                                switch (this.bKInt) {
                                                    case 3: {
                                                        this.bLInt = 0;
                                                        this.bOInt = -i.bByteArrArr[this.bGInt][this.bHInt];
                                                        break Label_3699;
                                                    }
                                                    case 1: {
                                                        i11 = this;
                                                        blInt5 = (i.bByteArrArr[this.bGInt][this.bHInt] >> 1) % i.aClassfArr[27].getAnimationFrameCount(1);
                                                        break;
                                                    }
                                                    default: {
                                                        i11 = this;
                                                        blInt5 = i.bByteArrArr[this.bGInt][this.bHInt];
                                                        break;
                                                    }
                                                }
                                                i11.bLInt = blInt5;
                                            }
                                            this.bLInt = 0;
                                            break Label_5612;
                                        }
                                        case 12: {
                                            bxInt = this.bxInt;
                                            byInt = this.byInt;
                                            n38 = bxInt;
                                            array = i.textures[18];
                                            this.aClassGraphics.drawImage(array[1], n38 + 6, byInt, 0);
                                            this.aClassGraphics.drawImage(array[0], n38 + 3, byInt + 7, 0);
                                            n39 = 0;
                                            if (this.aaInt < 10) {
                                                n39 = i.aClassfArr[0].images[0][0].getWidth() >> 1;
                                                ++n39;
                                            }
                                            aVoid(this.aClassGraphics, n38 + 19 - n39, byInt + 13, this.aaInt, i.aClassfArr[0].images[0], 0);
                                            break Label_5612;
                                        }
                                        case 36: {
                                            n40 = ((i.bIntArrArr[this.bGInt][this.bHInt] == 1) ? 1 : 0);
                                            f = i.aClassfArr[5];
                                            f.drawAnimationFrame(this.aClassGraphics, n40, (i.aSInt >> 1) % f.getAnimationFrameCount(n40), this.bxInt, this.byInt, 0, 0, 0);
                                            break Label_5612;
                                        }
                                        case 18: {
                                            i.bClassf = i.aClassfArr[6];
                                            this.bKInt = 0;
                                            if (this.ceInt == 0) {
                                                i12 = this;
                                                blInt6 = 0;
                                            } else if (this.ceInt == 9) {
                                                i12 = this;
                                                blInt6 = 2;
                                            } else {
                                                i12 = this;
                                                blInt6 = ((this.cfInt < 0) ? 1 : 3);
                                            }
                                            i12.bLInt = blInt6;
                                            break Label_5612;
                                        }
                                        case 34: {
                                            if (this.ceInt != 9 && this.ceInt >= 5) {
                                                this.aLInt = 14;
                                                this.aMInt = 0 + this.ceInt * 5 / 10;
                                            }
                                            break Label_5612;
                                        }
                                        case 35: {
                                            if (this.ceInt == 0 || this.ceInt > 5) {
                                                break Label_5612;
                                            }
                                            this.aLInt = 15;
                                            this.aMInt = 4 - this.ceInt * 5 / 10;
                                            if (this.aMInt < 0) {
                                                this.aMInt = 0;
                                            }
                                            break Label_5612;
                                        }
                                        case 28: {
                                            n41 = -1;
                                            n42 = 3;
                                            if (((n43 = i.bIntArrArr[this.bGInt][this.bHInt]) & 0x7) == 0x3) {
                                                n41 = 1;
                                                n42 = 0;
                                            }
                                            if ((n43 & 0x8) == 0x0) {
                                                n44 = this.aOInt;
                                                n45 = this.aNInt;
                                            } else {
                                                n44 = this.aQInt;
                                                n45 = this.aPInt;
                                            }
                                            n46 = n45;
                                            for (int n47 = 0; n47 < n44; ++n47) {
                                                i.aClassfArr[11].drawFrame(this.aClassGraphics, n42 + n47 * n41, this.bxInt + 3, this.byInt + n41 * (n46 - n47 * 24), 0);
                                            }
                                            if (n41 == 1) {
                                                f2 = i.aClassfArr[42];
                                                graphics4 = this.aClassGraphics;
                                                n48 = i.crtStagePlayerLayer[this.bGInt][this.bHInt - 1] - 80;
                                                n49 = this.bxInt;
                                                n50 = this.byInt - 24;
                                            } else {
                                                f2 = i.aClassfArr[42];
                                                graphics4 = this.aClassGraphics;
                                                n48 = i.crtStagePlayerLayer[this.bGInt][this.bHInt + 1] - 80;
                                                n49 = this.bxInt;
                                                n50 = this.byInt + 24;
                                            }
                                            f2.drawFrame(graphics4, n48, n49, n50, 0);
                                            break Label_5612;
                                        }
                                        case 16: {
                                            if (i.crtStagePlayerLayer[this.bGInt][this.bHInt + 1] != 16) {
                                                n51 = i.bIntArrArr[this.bGInt][this.bHInt];
                                                f3 = (i.bClassf = i.aClassfArr[1]);
                                                b4 = i.bByteArrArr[this.bGInt][this.bHInt];
                                                n52 = 36 - b4;
                                                blInt7 = 0;
                                                this.bKInt = (((n51 & 0x7) == 0x4) ? 1 : 0);
                                                if (b4 != 0) {
                                                    for (short n53 = 0; n52 > 0; n52 -= f3.getAnimationFrameTime(this.bKInt, (int) n53), blInt7 = n53, ++n53) {
                                                    }
                                                }
                                                this.bLInt = blInt7;
                                                this.bNInt = f3.animationFrames[(f3.animationFirstAnimationFrameIndices[this.bKInt] + blInt7) * 5 + 2];
                                            }
                                            break Label_5612;
                                        }
                                        case 14: {
                                            asInt2 = i.aSInt;
                                            n54 = i.bIntArrArr[this.bGInt][this.bHInt];
                                            if ((b5 = i.bByteArrArr[this.bGInt][this.bHInt]) > 24) {
                                                b5 = 24;
                                            }
                                            n55 = (n54 & 0x7);
                                            this.bNInt = b5 * i.gByteArr[n55];
                                            this.bOInt = b5 * i.gByteArr[n55 + 8];
                                            if ((n54 & 0x8) == 0x0) {
                                                this.aLInt = 10;
                                                this.aMInt = (asInt2 >> 1) % 3;
                                                if (n55 != 3) {
                                                    n56 = (asInt2 >> 1) % 5;
                                                    this.aClassGraphics.drawImage(i.textures[10][n56 + 3], this.bxInt + this.bNInt - (n56 << 2), this.byInt + (this.bOInt + 24), 36);
                                                }
                                            } else {
                                                this.aLInt = 10;
                                                this.aMInt = 2 - (asInt2 >> 1) % 3;
                                                if (n55 != 3) {
                                                    n57 = (asInt2 >> 1) % 5;
                                                    this.aClassGraphics.drawImage(i.textures[10][n57 + 8], this.bxInt + 24 - 12 + this.bNInt + n57 * 3, this.byInt + (this.bOInt + 24), 36);
                                                    if ((asInt2 >> 1 & 0x1) == 0x0 && i.crtStagePlayerLayer[this.bGInt - 1][this.bHInt] >= 0) {
                                                        --this.bNInt;
                                                        ++this.bOInt;
                                                    }
                                                }
                                            }
                                            break Label_5612;
                                        }
                                        case 32: {
                                            this.aClassGraphics.setColor(13883367);
                                            b6 = i.bByteArrArr[this.bGInt][this.bHInt];
                                            if ((i.bIntArrArr[this.bGInt][this.bHInt] & 0x1) != 0x0) {
                                                bxInt2 = this.bxInt;
                                                n58 = this.bxInt + 24 - b6;
                                                i13 = this;
                                                blInt8 = 0;
                                            } else {
                                                bxInt2 = this.bxInt + 24;
                                                n58 = this.bxInt + b6;
                                                i13 = this;
                                                blInt8 = 1;
                                            }
                                            i13.bLInt = blInt8;
                                            this.aClassGraphics.drawLine(bxInt2, this.byInt + 12, n58, this.byInt + 12);
                                            if (b6 > 0) {
                                                i.aClassbArr[0].sprite.drawModule(this.aClassGraphics, this.bLInt, n58, this.byInt + 12 - 2, 0);
                                            }
                                            break Label_5612;
                                        }
                                        case 11: {
                                            bgInt4 = this.bGInt;
                                            bhInt4 = this.bHInt;
                                            this.aLInt = 6;
                                            if ((n59 = (i.bIntArrArr[bgInt4][bhInt4] & 0xF00) >> 8) >= 4) {
                                                this.aLInt = -1;
                                                break Label_5612;
                                            }
                                            if (n59 == 0) {
                                                i14 = this;
                                                amInt = 0 + (i.aSInt >> 1) % 3;
                                            } else {
                                                i14 = this;
                                                amInt = n59 + 3 - 1;
                                            }
                                            i14.aMInt = amInt;
                                            n60 = (i.bIntArrArr[bgInt4][bhInt4] & 0x7);
                                            this.bNInt = i.bByteArrArr[bgInt4][bhInt4] * i.gByteArr[n60] + 2;
                                            this.bOInt = i.bByteArrArr[bgInt4][bhInt4] * i.gByteArr[n60 + 8] + 2;
                                            if ((i.bIntArrArr[bgInt4][bhInt4] & 0x10) == 0x0) {
                                                while (true) {
                                                    switch (n60) {
                                                        case 1: {
                                                            this.bNInt += 4;
                                                            break Label_5612;
                                                        }
                                                        case 2: {
                                                            i15 = this;
                                                            boInt4 = this.bOInt + 4;
                                                            break;
                                                        }
                                                        case 3: {
                                                            this.bNInt -= 4;
                                                            break Label_5612;
                                                        }
                                                        case 4: {
                                                            i15 = this;
                                                            boInt4 = this.bOInt - 4;
                                                            break;
                                                        }
                                                        default: {
                                                            break Label_5612;
                                                        }
                                                    }
                                                    i15.bOInt = boInt4;
                                                    continue Label_5350_Outer;
                                                }
                                            }
                                            while (true) {
                                                switch (n60) {
                                                    case 1: {
                                                        this.bNInt -= 4;
                                                        break Label_5612;
                                                    }
                                                    case 2: {
                                                        i16 = this;
                                                        boInt5 = this.bOInt - 4;
                                                        break;
                                                    }
                                                    case 3: {
                                                        this.bNInt += 4;
                                                        break Label_5612;
                                                    }
                                                    case 4: {
                                                        i16 = this;
                                                        boInt5 = this.bOInt + 4;
                                                        break;
                                                    }
                                                    default: {
                                                        break Label_5612;
                                                    }
                                                }
                                                i16.bOInt = boInt5;
                                                continue;
                                            }
                                        }
                                        case 30: {
                                            i.bClassf = i.aClassfArr[20];
                                            this.bKInt = 0;
                                            this.bLInt = 0 + (n23 - 1) * 7 / 16;
                                            break Label_5612;
                                        }
                                        case 37: {
                                            this.aLInt = 17;
                                            this.aMInt = 0 + (n23 - 1) * 3 / 8;
                                            break Label_5612;
                                        }
                                        case 23: {
                                            i.bClassf = i.aClassfArr[12];
                                            this.bLInt = 0;
                                            this.bVoid((byte) 23);
                                            break Label_5612;
                                        }
                                        case 22: {
                                            i.bClassf = i.aClassfArr[12];
                                            this.bLInt = 1;
                                            this.bVoid((byte) 22);
                                            break Label_5612;
                                        }
                                        case 43: {
                                            this.cVoid((byte) this.bIInt);
                                            break Label_5612;
                                        }
                                        case 19: {
                                            this.cVoid((byte) this.bIInt);
                                        }
                                        case 10: {
                                            break Label_5612;
                                        }
                                        case 47: {
                                            i17 = this;
                                            break;
                                        }
                                        case 9: {
                                            this.OVoid();
                                            if ((i.bIntArrArr[this.bGInt][this.bHInt] & 0xFC00000) == 0x8400000) {
                                                this.bNInt += this.auInt;
                                                this.bOInt += this.avInt;
                                            }
                                            break Label_5612;
                                        }
                                        case 4: {
                                        }
                                        case 5: {
                                        }
                                        case 2: {
                                            break Label_5612;
                                        }
                                        case 1: {
                                            if ((i.bIntArrArr[this.bGInt][this.bHInt] & Integer.MIN_VALUE) != 0x0 || this.bRInt != 0) {
                                                i17 = this;
                                                break;
                                            }
                                            break Label_5612;
                                        }
                                        case 0: {
                                            if ((i.bIntArrArr[this.bGInt][this.bHInt] & Integer.MIN_VALUE) != 0x0) {
                                                break Label_5608;
                                            }
                                            break Label_5612;
                                        }
                                        case 6: {
                                        }
                                        case 7: {
                                            break Label_5612;
                                        }
                                        case 8: {
                                            i17 = this;
                                            break;
                                        }
                                    }
                                }
                                i17.OVoid();
                            }
                        }
                        if (this.aLInt != -1) {
                            if (i.textures[this.aLInt] == null) {
                                i.aClassfArr[aInt(this.aLInt)].drawFrame(graphics3, this.aMInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                            } else {
                                graphics3.drawImage(i.textures[this.aLInt][this.aMInt], this.bxInt + this.bNInt, this.byInt + this.bOInt, this.bPInt);
                            }
                            this.aLInt = -1;
                            this.bPInt = 0;
                        } else {
                            if (i.bClassf == null) {
                                continue;
                            }
                            if (this.bGInt == this.coInt && this.bHInt == this.cpInt) {
                                i.cClassf = i.bClassf;
                                this.ctInt = this.bKInt;
                                this.csInt = this.bLInt;
                                this.crInt = this.bxInt + this.bNInt;
                                this.cqInt = this.byInt + this.bOInt;
                            }
                            if (this.bKInt != -1) {
                                i.bClassf.drawAnimationFrame(graphics3, this.bKInt, this.bLInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, 0, 0, 0);
                                this.bKInt = -1;
                            } else {
                                i.bClassf.drawFrame(graphics3, this.bLInt, this.bxInt + this.bNInt, this.byInt + this.bOInt, 0);
                            }
                            i.bClassf = null;
                            this.bMInt = 0;
                        }
                        n61 = 0;
                        this.bOInt = n61;
                        this.bNInt = n61;
                    }
                }
            }
        }
        if (i.aBoolean) {
            aClassGraphics.setColor(0);
            aClassGraphics.fillRect(0, 0, 240, 320);
            this.NVoid();
            if (this.adInt != this.aeInt) {
                int adInt;
                int n62 = adInt = this.adInt;
                while (true) {
                    int n63 = adInt;
                    if (n62 == this.aeInt) {
                        break;
                    }
                    final int n64 = i.aByteArr[n63 << 1] * 24 - this.aInt;
                    final int n65 = i.aByteArr[(n63 << 1) + 1] * 24 - this.bInt;
                    f_Sprite f4;
                    Graphics graphics5;
                    int n66;
                    int aInt3;
                    if (i.cByteArr[n63] < 0) {
                        final f_Sprite f5;
                        f4 = (f5 = i.aClassfArr[2]);
                        graphics5 = aClassGraphics;
                        n66 = 0;
                        aInt3 = aInt(f5, 0, i.bByteArr[n63]);
                    } else {
                        f4 = i.aClassfArr[9];
                        graphics5 = aClassGraphics;
                        n66 = i.cByteArr[n63];
                        aInt3 = i.bByteArr[n63];
                    }
                    f4.drawAnimationFrame(graphics5, n66, aInt3, n64, n65, 0, 0, 0);
                    n62 = (adInt = (++n63 & 0x7));
                }
            }
            this.aClassGraphics.setClip(0, 0, 240, 320);
            aClassGraphics.translate(0, -40);
            this.GVoid();
            return;
        }
        this.NVoid();
        if (this.lBoolean) {
            final int ckInt = this.cKInt;
            final int clInt = this.cLInt;
            final int n67 = ckInt;
            final Graphics aClassGraphics2 = this.aClassGraphics;
            for (int n68 = 0; n68 < 12; ++n68) {
                for (int n69 = 0; n69 < 12; ++n69) {
                    final int n70 = n69 + this.aInt / 24;
                    final int n71 = n68 + this.bInt / 24;
                    if (n70 >= 0 && n70 < this.crtStageWidth && n71 >= 0 && n71 < this.crtStageHeight) {
                        final int n72 = i.eIntArrArr[n70][n71];
                        final int n73 = n69 * 24 - n67;
                        final int n74 = n68 * 24 - clInt;
                        if (n72 > 0) {
                            int n75;
                            byte b7 = (byte) (n75 = 0);
                            while (true) {
                                byte b8 = (byte) n75;
                                if (b7 > 2) {
                                    break;
                                }
                                Label_6562:
                                {
                                    if (aInt(n72, b8, (byte) 0, (byte) 3) != 0) {
                                        byte b9;
                                        if ((b9 = (byte) (aInt(n72, b8, (byte) 7, (byte) 2) << 3)) > 0) {
                                            b9 = ((aInt(aInt(n72, b8, (byte) 0, (byte) 3), (byte) 45, (byte) 2) <= 1) ? ((byte) (b9 - 24)) : ((byte) (24 - b9)));
                                            this.CVoid();
                                            aClassGraphics2.clipRect(n73, n74 + (b8 << 3), 24, 8);
                                        }
                                        final int aInt4;
                                        final int n77;
                                        final int n76 = (((n77 = (aInt4 = aInt(n70, n71, n72, b8)) >> 1) == 7) ? (i.aSInt >> 3) : i.aSInt) & 0x1;
                                        if (n77 == 15) {
                                            i.dClassf.drawFrame(aClassGraphics2, aInt4 + this.cBInt, n73 + b9 - 8, n74 + (b8 << 3) + 8, 36);
                                            ++this.cBInt;
                                            if (this.cBInt > 2) {
                                                this.cBInt = 0;
                                            }
                                        } else {
                                            f_Sprite f6;
                                            Graphics graphics6;
                                            int n78;
                                            int n79;
                                            int n80;
                                            if (n77 == 14 || n77 == 11) {
                                                f6 = i.dClassf;
                                                graphics6 = aClassGraphics2;
                                                n78 = aInt4 + n76;
                                                n79 = n73 + b9;
                                                n80 = n74;
                                            } else {
                                                if (n77 == 8 && b8 == 0 && i.eIntArrArr[n70][n71 - 1] > 0) {
                                                    i.dClassf.drawFrame(aClassGraphics2, 33, n73 + b9, n74, 20);
                                                    b8 = 3;
                                                    break Label_6562;
                                                }
                                                f6 = i.dClassf;
                                                graphics6 = aClassGraphics2;
                                                n78 = aInt4 + n76;
                                                n79 = n73 + b9;
                                                n80 = n74 + (b8 << 3);
                                            }
                                            f6.drawFrame(graphics6, n78, n79, n80, 20);
                                            this.CVoid();
                                        }
                                    }
                                }
                                b7 = (byte) (n75 = (byte) (b8 + 1));
                            }
                        }
                    }
                }
            }
        }
        if (this.awInt > 0) {
            this.EVoid();
        }
        if (this.kByte != 0) {
            this.LVoid();
        }
        for (int n81 = -1; n81 < 12; ++n81) {
            for (int n82 = -1; n82 < 12; ++n82) {
                final int n83 = n82 + this.cIInt;
                final int n84 = n81 + this.cJInt;
                if (n83 >= 0 && n83 < this.crtStageWidth && n84 >= 0 && n84 < this.crtStageHeight) {
                    final int n85 = i.crtStageForegrondLayer[n83][n84] & 0xFF;
                    final byte b10 = i.crtStagePlayerLayer[n83][n84];
                    if (n85 < 38 || n85 >= 80) {
                        final int n86 = n82 * 24 - this.cKInt;
                        final int n87 = n81 * 24 - this.cLInt;
                        Label_7042:
                        {
                            f_Sprite f7;
                            Graphics graphics7;
                            int n89;
                            int n90;
                            if (n85 >= 20 && n85 < 26) {
                                final int n88 = n85 - 20;
                                f7 = i.aClassfArr[3];
                                graphics7 = aClassGraphics;
                                n89 = n88;
                                n90 = (asInt >> 2) % (i.aClassfArr[3].animationAnimationFrameCounts[n88] & 0xFF);
                            } else {
                                switch (n85) {
                                    case 36: {
                                        i.aClassfArr[20].drawAnimationFrame(aClassGraphics, 0, (0 + ((i.crtStageForegrondLayer[n83][n84] >> 8) - 1) * 7) / 16, n86, n87, 0, 0, 0);
                                        break;
                                    }
                                    case 31: {
                                        final int n91 = i.crtStageForegrondLayer[n83][n84] >> 8;
                                        final f_Sprite f8 = i.aClassfArr[15];
                                        f8.drawAnimationFrame(this.aClassGraphics, n91, (i.aSInt >> 1) % (f8.animationAnimationFrameCounts[n91] & 0xFF), n86, n87, 0, 0, 0);
                                        break;
                                    }
                                    case 32: {
                                        i.aClassfArr[16].drawAnimationFrame(this.aClassGraphics, 0, i.crtStageForegrondLayer[n83][n84] >> 8 & 0xFF, n86, n87, 0, 0, 0);
                                        break;
                                    }
                                    default: {
                                        final byte b11;
                                        if ((b11 = (byte) (n85 - 80)) >= 0) {
                                            i.aClassfArr[42].drawFrame(aClassGraphics, (int) b11, n86, n87, 0);
                                            break;
                                        }
                                        break;
                                    }
                                }
                                final int n92;
                                if ((n92 = (i.crtStageForegrondLayer[n83][n84] & 0xF0000000) >> 28) <= 0) {
                                    break Label_7042;
                                }
                                f7 = i.aClassfArr[13];
                                graphics7 = aClassGraphics;
                                n89 = 0;
                                n90 = n92;
                            }
                            f7.drawAnimationFrame(graphics7, n89, n90, n86, n87, 0, 0, 0);
                        }
                        if (b10 == 54) {
                            i.aClassfArr[7].drawAnimationFrame(aClassGraphics, 0, aInt(i.aClassfArr[7], 0, i.bIntArrArr[n83][n84]), n86, n87, 0, 0, 0);
                        }
                    }
                }
            }
        }
        if (this.ABoolean) {
            aClassGraphics.drawImage(i.aClassfArr[13].images[0][0 + this.bDInt], (this.bBInt - this.cIInt) * 24 - this.cKInt + this.bzInt, (this.bCInt - this.cJInt + 1) * 24 - this.cLInt + this.bAInt, 0);
            this.ABoolean = false;
        }
        if (this.aDInt != -1) {
            aClassGraphics.drawImage(i.textures[13][0], this.bvInt - 12, this.bwInt - 24 + 2, 3);
            aClassGraphics.drawImage(i.textures[this.aDInt][this.aEInt], this.bvInt - 12, this.bwInt - 24, 3);
        }
        if (this.adInt != this.aeInt) {
            int adInt2;
            int n93 = adInt2 = this.adInt;
            while (true) {
                int n94 = adInt2;
                if (n93 == this.aeInt) {
                    break;
                }
                final int n95 = i.aByteArr[n94 << 1] * 24 - this.aInt;
                final int n96 = i.aByteArr[(n94 << 1) + 1] * 24 - this.bInt;
                f_Sprite f9;
                Graphics graphics8;
                int n97;
                int aInt5;
                if (i.cByteArr[n94] < 0) {
                    final f_Sprite f10;
                    f9 = (f10 = i.aClassfArr[2]);
                    graphics8 = aClassGraphics;
                    n97 = 0;
                    aInt5 = aInt(f10, 0, i.bByteArr[n94]);
                } else {
                    f9 = i.aClassfArr[9];
                    graphics8 = aClassGraphics;
                    n97 = i.cByteArr[n94];
                    aInt5 = i.bByteArr[n94];
                }
                f9.drawAnimationFrame(graphics8, n97, aInt5, n95, n96, 0, 0, 0);
                n93 = (adInt2 = (++n94 & 0x7));
            }
        }
        this.bInt += this.bkInt;
        if (this.xBoolean) {
            aVoid(aClassGraphics, i.textSize0, i.texts[15], 120, 160, 17, 19, false);
        }
        if (this.bnInt > i.aSInt && this.kByte != 2) {
            if (!this.ajBoolean && !this.hBoolean) {
                final int n99;
                final int n98 = ((n99 = this.bnInt - i.aSInt) < 20) ? ((n99 - 10) * 240 / 20) : ((n99 >= 50) ? ((60 - n99) * 240 / 15) : 120);
                final int n100 = 240 - n98;
                aVoid(aClassGraphics, i.textSize0, i.texts[i.dIntArr[this.crtWorldIndex]], n98, 15, 17, 20, false);
                aVoid(aClassGraphics, i.textSize0, i.stageTitles[i.gIntArrArr[this.crtWorldIndex][this.crtStageI] - 1], n100, 50, 17, 20, false);
            }
        } else if (this.akInt > i.aSInt) {
            aVoid(aClassGraphics, i.textSize0, i.texts[13], 120, a_Config.cInt, 17, 20, false);
        } else if (this.akInt == i.aSInt && this.rByte <= 2) {
            ++this.rByte;
            this.wVoid();
        }
        Label_7755:
        {
            i i18 = null;
            Graphics graphics9 = null;
            int n101 = 0;
            switch (this.kByte) {
                case 4: {
                    this.MVoid();
                    break Label_7755;
                }
                case 3: {
                    if (this.aoInt != -1 && this.aoInt != 15) {
                        i18 = this;
                        graphics9 = aClassGraphics;
                        n101 = 5;
                        break;
                    }
                    break Label_7755;
                }
                case 5: {
                    if (this.aoInt != -1 && this.aoInt != 15 && this.aoInt != 13 && this.aoInt != 12) {
                        i18 = this;
                        graphics9 = aClassGraphics;
                        n101 = 4;
                        break;
                    }
                    break Label_7755;
                }
            }
            i18.aVoid(graphics9, n101);
        }
        aClassGraphics.translate(0, -40);
        aClassGraphics.setClip(0, 0, 240, 320);
        if (this.aClassc == null) {
            this.GVoid();
        }
        if (this.eClassString != null) {
            // Renders the loading message? e.g. Do not hold up rocks too long or you will be crushed
            this.oBoolean = true;
            aVoid(aClassGraphics, i.textSize8, aClassString(this.eClassString), 120, 223, 17, 4, true);
        }
        if (this.aClassc != null && !i.aBoolean) {
            // Renders the loading icon from demo.f and demoSpr.bin?
            this.oBoolean = true;
            this.aClassc.aVoid(aClassGraphics);
        }
        if (this.blInt > 0) {
            // Renders the loading bar?
            this.oBoolean = true;
            aClassGraphics.setColor(0);
            aClassGraphics.fillRect(0, 0, 240, this.blInt);
            aClassGraphics.fillRect(0, 320 - this.blInt, 240, this.blInt);
            aClassGraphics.translate(0, 40);
            this.NVoid();
            if (i.cClassf != null) {
                if (this.ctInt != -1) {
                    i.cClassf.drawAnimationFrame(aClassGraphics, this.ctInt, this.csInt, (this.coInt - this.cIInt) * 24 - this.cKInt, (this.cpInt - this.cJInt) * 24 - this.cLInt, 0, 0, 0);
                } else {
                    i.cClassf.drawFrame(aClassGraphics, this.csInt, this.crInt, this.cqInt, 0);
                }
            }
            aClassGraphics.translate(0, -40);
        }
    }

    private void EVoid() {
        final int n = this.bInt - 24;
        final int n2 = this.bInt + 320;
        final int aInt = this.aInt;
        final int n3 = this.aInt + 240;
        final int n4 = (i.aSInt >> 1) % i.aClassfArr[2].getAnimationFrameCount(1);
        for (int iInteger = 0; iInteger < i.eByteArr.length; iInteger += 3) {
            int n5 = 0;
            final byte b;
            final int n6;
            if ((n6 = (b = i.eByteArr[iInteger + 2]) * 24) > n && n6 < n2) {
                final byte b2 = i.eByteArr[iInteger];
                final byte b3 = i.eByteArr[iInteger + 1];
                final int n7 = b2 * 24;
                final int n8 = b3 * 24 + 24;
                if ((n7 >= aInt && n7 <= n3) || (n8 >= aInt && n8 <= n3) || (n7 <= aInt && n8 >= n3)) {
                    int n9 = n7 - aInt;
                    final int n10 = b2 + ((b2 != 0) ? -1 : 0);
                    boolean b4 = true;
                    if (i.crtStagePlayerLayer[n10][b] == 48 && (i.bIntArrArr[n10][b] & 0x8) != 0x0) {
                        n9 -= 12;
                        b4 = false;
                        if ((i.bIntArrArr[n10][b + 1] & 0x7) == 0x3) {
                            n5 = -i.bByteArrArr[n10][b + 1];
                        } else {
                            n9 -= -i.bByteArrArr[n10][b + 1];
                        }
                    }
                    int n11 = n8 - aInt;
                    final int n12 = b3 + ((b3 < this.crtStageWidth - 1) ? 1 : 0);
                    boolean b6 = true;
                    if (i.crtStagePlayerLayer[n12][b] == 48 && (i.bIntArrArr[n12][b] & 0x8) != 0x0) {
                        n11 += 12;
                        b6 = false;
                        if ((i.bIntArrArr[n12][b + 1] & 0x7) == 0x3) {
                            n5 = -i.bByteArrArr[n12][b + 1];
                        } else {
                            n11 -= i.bByteArrArr[n12][b + 1];
                        }
                    }
                    int n13 = n6 - this.bInt + 10 + n5;
                    this.aClassGraphics.setColor(1820159);
                    this.aClassGraphics.drawLine(n9, n13, n11, n13);
                    n13 += 2;
                    this.aClassGraphics.drawLine(n9, n13, n11, n13);
                    --n13;
                    this.aClassGraphics.setColor(14153215);
                    this.aClassGraphics.drawLine(n9, n13, n11, n13);
                    f_Sprite f;
                    Graphics graphics;
                    int n14;
                    int n15;
                    byte b7;
                    int n16;
                    int n17;
                    if (b4) {
                        f = i.aClassfArr[2];
                        graphics = this.aClassGraphics;
                        n14 = 1;
                        n15 = n4;
                        b7 = (byte) n9;
                        n16 = n13;
                        n17 = 1;
                    } else {
                        if (!b6) {
                            continue;
                        }
                        f = i.aClassfArr[2];
                        graphics = this.aClassGraphics;
                        n14 = 1;
                        n15 = n4;
                        b7 = (byte) n11;
                        n16 = n13;
                        n17 = 0;
                    }
                    f.drawAnimationFrame(graphics, n14, n15, (int) b7, n16, n17, 0, 0);
                }
            }
        }
    }

    private void FVoid() {
        if ((i.bIntArrArr[this.bGInt][this.bHInt] & 0x7) == 0x1 && (i.crtStageForegrondLayer[this.bGInt][this.bHInt] & 0xFF) == 0x23) {
            this.bNInt = 0;
            this.bOInt = i.bByteArrArr[this.bGInt][this.bHInt];
        }
    }

    private void GVoid() {
        boolean b = false;
        final Graphics aClassGraphics = this.aClassGraphics;
        final f_Sprite f;
        if ((f = i.aClassfArr[0]) == null) {
            return;
        }
        aClassGraphics.translate(120, 320);
        f_Sprite f2;
        if (this.oBoolean || i.bByte == 2) {
            f.drawFrame(aClassGraphics, 0, 0, 0, 0);
            if (this.UBoolean) {
                f.drawFrame(aClassGraphics, 19, 0, 0, 0);
            }
            f2 = f;
        } else {
            b = true;
            aClassGraphics.setClip(-120, -320, 240, 320);
            f2 = f;
        }
        f2.drawFrame(aClassGraphics, 1, 0, 0, 0);
        if (this.pBoolean) {
            f.drawFrame(aClassGraphics, 2, 2, 0, 0);
            f.drawFrame(aClassGraphics, 3 + this.anInt, 2, 0, 0);
        }
        if (b) {
            aClassGraphics.setClip(-120, -320, 240, 320);
        }
        if (this.nByte != this.cPInt || this.oBoolean || this.nByte <= 1) {
            final Image[] array = i.aClassfArr[0].images[0];
            final int n = (this.nByte <= 1) ? 1 : 0;
            final int n2 = -33 - (i.iByteArr[8] - 4) * array[n + 11].getWidth() / 2;
            aClassGraphics.drawImage(array[n + 11], n2, -29, 0);
            int n3 = 0 + array[n + 11].getWidth();
            final int width = array[15].getWidth();
            for (byte b2 = 0; b2 < i.iByteArr[8]; ++b2) {
                Graphics graphics;
                Image[] array2;
                int n4;
                if ((this.nByte <= 1 && b2 == 0 && (i.aSInt >> 2 & 0x1) == 0x0) || (b2 < this.nByte && this.nByte > 1)) {
                    graphics = aClassGraphics;
                    array2 = array;
                    n4 = 15;
                } else {
                    graphics = aClassGraphics;
                    array2 = array;
                    n4 = 13;
                }
                graphics.drawImage(array2[n4 + n], n2 + n3, -29, 0);
                n3 += width;
            }
            aClassGraphics.drawImage(array[n + 17], n2 + n3, -29, 0);
            this.cPInt = this.nByte;
        }
        if (this.cQInt != this.aZInt || this.cTInt != this.aaInt || this.oBoolean) {
            aVoid(aClassGraphics, 70, -12, this.aZInt, i.aClassfArr[0].images[0], 0);
        }
        if (this.cRInt != this.bbInt || this.oBoolean) {
            this.cRInt = this.bbInt;
            aVoid(aClassGraphics, 107, -12, this.bbInt, i.aClassfArr[0].images[0], 0);
        }
        aClassGraphics.translate(-120, -320);
        aClassGraphics.translate(120, 0);
        int n5 = 0;
        if (this.oBoolean || i.bByte == 2) {
            f.drawFrame(aClassGraphics, 20, 0, 0, 0);
            n5 = 1;
        }
        if (this.cUInt != this.aUInt || this.cVInt != this.aVInt || this.oBoolean || i.bByte == 2 || n5 != 0) {
            if (n5 == 0) {
                f.drawFrame(aClassGraphics, 20, 0, 0, 0);
                n5 = 1;
            }
            aVoid(aClassGraphics, 47, 18, this.aUInt, i.aClassfArr[0].images[0], 0);
            aVoid(aClassGraphics, 87, 18, this.aVInt, i.aClassfArr[0].images[0], 0);
            this.cUInt = this.aUInt;
            this.cVInt = this.aVInt;
        }
        if (this.cSInt != this.azInt || this.oBoolean || n5 != 0) {
            if (n5 == 0) {
                f.drawFrame(aClassGraphics, 20, 0, 0, 0);
            }
            aVoid(aClassGraphics, -29, 18, this.azInt, i.aClassfArr[0].images[0], 0);
            this.cSInt = this.azInt;
        }
        aClassGraphics.translate(-120, 0);
        this.cQInt = this.aZInt;
        this.cTInt = this.aaInt;
        this.oBoolean = false;
    }

    private void bVoid(final byte b) {
        final b_SpriteAnimator b2 = i.aClassbArr[4];
        if (b == 23) {
            b2.x = this.bxInt;
            final b_SpriteAnimator b3 = b2;
            b3.flags |= 0x1;
        } else {
            b2.flags &= 0xFFFFFFFE;
            b2.x = this.bxInt + 24;
        }
        b2.y = this.byInt;
        b2.applyFrameOffset();
        b2.draw(this.aClassGraphics);
    }

    private void fVoid(final int n) {
        for (int iInteger = n - 8 - 1; iInteger < n + 15 - 2; ++iInteger) {
            i.aClassfArr[18].drawFrame(this.aClassGraphics, 4, iInteger % 2, iInteger, 0);
        }
        this.aClassGraphics.setColor(16777215);
        this.aClassGraphics.drawLine(0, n - 8 - 1 - 1, 240, n - 8 - 1 - 1);
        this.aClassGraphics.drawLine(0, n + 15 - 1, 240, n + 15 - 1);
        this.aClassGraphics.setColor(0);
        this.aClassGraphics.drawLine(0, n - 8 - 1 - 2, 240, n - 8 - 1 - 2);
        this.aClassGraphics.drawLine(0, n + 15 - 2, 240, n + 15 - 2);
    }

    private void HVoid() {
        if (this.YBoolean) {
            this.YBoolean = false;
            this.XBoolean = bBoolean();
        }
        int n = 320 - ((this.cXInt + 1) * a_Config.dInt + 1 + 2) + ((!this.XBoolean && this.boInt == 0) ? a_Config.dInt : 0);
        int n2 = 320 - a_Config.dInt + 1 + 1;
        this.aClassGraphics.setClip(0, 0, 240, 320);
        if (i.bByte == 2 && i.VBoolean && i.WBoolean) {
            this.UBoolean = false;
            this.DVoid();
            this.UBoolean = true;
            i.WBoolean = false;
        }
        if (i.bByte == 7 || i.bByte == 2) {
            final int n3 = n - (160 - (n2 - n) / 2);
            n -= n3;
            n2 -= n3;
        }
        if (this.boInt == 7) {
            this.fVoid(n - 22);
            i.textSize0.drawTextWithFlags(this.aClassGraphics, i.texts[(this.aRInt == 5) ? 23 : 2], 120, n - 20, 17);
        }
        if (i.bByte == 7) {
            Graphics graphics;
            int n5;
            int n6;
            int n7;
            int n8;
            if (this.dcInt != -1 && !i.VBoolean) {
                final int n4 = n + this.dcInt * a_Config.dInt;
                this.aClassGraphics.setColor(0);
                graphics = this.aClassGraphics;
                n5 = 0;
                n6 = n4;
                n7 = 240;
                n8 = a_Config.dInt + 1;
            } else {
                this.aClassGraphics.setColor(0);
                graphics = this.aClassGraphics;
                n5 = 0;
                n6 = 0;
                n7 = 240;
                n8 = 320;
            }
            graphics.fillRect(n5, n6, n7, n8);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.dbInt >= 0 && currentTimeMillis - this.gLong > 100L) {
            ++this.dbInt;
            this.gLong = currentTimeMillis;
        }
        if (this.dcInt != -1 && !i.VBoolean) {
            this.aClassGraphics.setClip(0, n + this.dcInt * a_Config.dInt - ((this.boInt == 0 && this.dcInt > 0 && !this.XBoolean) ? a_Config.dInt : 0), 240, a_Config.dInt + 1);
        }
        if (this.dcInt != this.bqInt || i.VBoolean) {
            final int n9 = n;
            final int n10 = n2;
            final int n11 = n9;
            if (i.bByte == 4) {
                bVoid(this.aClassGraphics, false);
                for (int iInteger = n11 - 1; iInteger < n10 - 2; ++iInteger) {
                    i.aClassfArr[18].drawFrame(this.aClassGraphics, 4, iInteger % 2, iInteger, 0);
                }
            }
            if (i.bByte == 2) {
                this.aClassGraphics.setColor(0);
                this.aClassGraphics.fillRect(0, n11 - 1, 240, n10 - 2 - (n11 - 1));
            }
            this.aClassGraphics.setColor(16777215);
            this.aClassGraphics.drawLine(0, n11 - 1 - 1, 240, n11 - 1 - 1);
            this.aClassGraphics.drawLine(0, n10 - 1, 240, n10 - 1);
            this.aClassGraphics.setColor(0);
            this.aClassGraphics.drawLine(0, n11 - 1 - 2, 240, n11 - 1 - 2);
            this.aClassGraphics.drawLine(0, n10 - 2, 240, n10 - 2);
        }
        if (!this.XBoolean && i.bByte == 4 && this.bqInt == 0 && this.aRInt != 5 && this.boInt != 8) {
            this.bqInt = 1;
        }
        for (int j = 0; j < this.cXInt; ++j) {
            if ((this.dcInt == -1 || j == this.dcInt || j == this.bqInt || i.VBoolean) && (this.boInt != 0 || j != 0 || this.XBoolean)) {
                int n12 = n + j * a_Config.dInt + a_Config.dInt / 2;
                if (this.boInt == 0 && j > 0 && !this.XBoolean) {
                    n12 -= a_Config.dInt;
                }
                int n13 = 16777215;
                if (j == 2 && this.boInt == 0 && getMoreGamesEnabled()) {
                    n13 = 16711680;
                }
                if (j == 0 && this.boInt == 8 && getMoreGamesEnabled()) {
                    n13 = 16711680;
                }
                Label_0925:
                {
                    Graphics graphics2 = null;
                    int n14 = 0;
                    int n15 = 0;
                    int n16 = 0;
                    int n17 = 0;
                    Label_0922:
                    {
                        Graphics graphics3;
                        int color;
                        if (this.kByte == 2 && j == 3 && this.boInt == 1) {
                            n13 = 16777215;
                            if (j != this.bqInt) {
                                this.aClassGraphics.setColor(13421772);
                                graphics2 = this.aClassGraphics;
                                n14 = 0;
                                n15 = n12 - a_Config.dInt / 2 + 1;
                                n16 = 240;
                                n17 = a_Config.dInt - 1;
                                break Label_0922;
                            }
                            graphics3 = this.aClassGraphics;
                            color = 6710886;
                        } else {
                            if (j != this.bqInt) {
                                break Label_0925;
                            }
                            graphics3 = this.aClassGraphics;
                            color = 13540096;
                        }
                        graphics3.setColor(color);
                        graphics2 = this.aClassGraphics;
                        n14 = 0;
                        n15 = n12 - a_Config.dInt / 2;
                        n16 = 240;
                        n17 = a_Config.dInt + 1;
                    }
                    graphics2.fillRect(n14, n15, n16, n17);
                }
                i.textSize0.calculateStringSize(i.texts[i.aShortArrArr[this.boInt][(j << 1) + 1]]);
                final int aInt = h.stringWidth;
                if ((j != 2 || this.boInt != 0 || !getMoreGamesEnabled()) && j == 0 && this.boInt == 8) {
                    getMoreGamesEnabled();
                }
                h.setColor(n13);
                i.textSize0.drawText(this.aClassGraphics, i.texts[i.aShortArrArr[this.boInt][(j << 1) + 1]], 120 - aInt / 2, n12 + 1, n13, 6);
                if (j == this.bqInt) {
                    this.aClassGraphics.setColor(16777215);
                    i.aClassfArr[18].drawFrame(this.aClassGraphics, 2, 120 - aInt / 2 - 8, n12, 0);
                    i.aClassfArr[18].drawFrame(this.aClassGraphics, 2, 120 + aInt / 2 + 8, n12, 0);
                }
            }
        }
        this.dcInt = this.bqInt;
        ++this.cWInt;
        i k;
        int daInt;
        if (this.daInt < 0) {
            k = this;
            daInt = 3;
        } else {
            k = this;
            daInt = this.daInt - 1;
        }
        k.daInt = daInt;
        if (this.daInt == 0 && this.cZInt + 1 < this.cXInt) {
            ++this.cZInt;
        }
        this.aClassGraphics.setClip(0, 0, 240, 320);
        if (this.boInt != 0 && this.boInt != 3 && this.boInt != 1 && this.boInt != 7 && this.boInt != 8) {
            this.IVoid();
        }
        this.JVoid();
        i.VBoolean = false;
        Label_2264:
        {
            if (this.dbInt == 2) {
                if (i.bByte == 2) {
                    i.VBoolean = true;
                    i.WBoolean = true;
                }
                this.dbInt = -1;
                this.oBoolean = true;
                this.dcInt = -1;
                h.setColor(16777215);
                this.zBoolean = true;
                switch (this.boInt) {
                    case 0: {
                        switch (this.aInt()) {
                            case 0: {
                                this.aClassj.freeCrtPlayerResource();
                                this.tVoid();
                                if (i.iByteArr != null && bBoolean()) {
                                    this.agInt = 0;
                                    this.MBoolean = true;
                                    this.pBoolean = true;
                                    this.bsInt = 0;
                                    i.bByte = 28;
                                    break Label_2264;
                                }
                            }
                            case 1: {
                                this.aClassj.freeCrtPlayerResource();
                                if (!bBoolean()) {
                                    this.QVoid();
                                    break Label_2264;
                                }
                                this.QBoolean = true;
                                this.DBoolean = false;
                                i.bByte = 31;
                                break Label_2264;
                            }
                            case 5: {
                                this.aVoid(7);
                                this.aRInt = 5;
                                break Label_2264;
                            }
                            case 6: {
                                this.kVoid();
                                break Label_2264;
                            }
                            case 2: {
                                this.aVoid(5);
                                this.aClassj.freeCrtPlayerResource();
                                break Label_2264;
                            }
                            case 4: {
                                i.bByte = 22;
                                this.aRInt = 0;
                                this.aClassj.freeCrtPlayerResource();
                                break Label_2264;
                            }
                            case 3: {
                                i.bByte = 33;
                                this.aClassj.freeCrtPlayerResource();
                                this.avBoolean = true;
                                break Label_2264;
                            }
                            default: {
                                this.zBoolean = false;
                                return;
                            }
                        }
//                        break;
                    }
                    case 3: {
                        this.aRInt = 0;
                        for (int l = 0; l < i.aShortArrArr[5].length; l += 2) {
                            if (0 == i.aShortArrArr[5][l]) {
                                i.aShortArrArr[5][l + 1] = 0;
                                break Label_2264;
                            }
                        }
                        return;
                    }
                    case 7: {
                        Label_1781:
                        {
                            switch (this.aInt()) {
                                case 0: {
                                    if (this.bpInt == 0) {
                                        i.bByte = 4;
                                    }
                                    this.aVoid(this.bpInt);
                                    break;
                                }
                                case 1: {
                                    switch (this.aRInt) {
                                        case 1: {
                                            this.lVoid();
                                            break Label_1781;
                                        }
                                        case 3: {
                                            i.bByte = 15;
                                            this.JBoolean = true;
                                            this.HBoolean = true;
                                            this.avVoid();
                                            break Label_1781;
                                        }
                                        case 4: {
                                            this.pVoid();
                                            i.bByte = 9;
                                            this.brInt = 8;
                                            this.aVoid(-1);
                                            this.bsInt = 0;
                                            break Label_1781;
                                        }
                                        case 5: {
                                            i.bByte = 3;
                                            break Label_1781;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        this.aRInt = -1;
                        return;
                    }
                    case 2: {
                        switch (this.aInt()) {
                            case 0: {
                                this.aClassj.freeCrtPlayerResource();
                                this.crtWorldIndex = 0;
                                this.lBoolean = false;
                                i.bByte = 15;
                                i.dZInt = bInt(this.crtWorldIndex);
                                this.HBoolean = true;
                                this.avVoid();
                                break Label_2264;
                            }
                            case 1: {
                                this.aClassj.freeCrtPlayerResource();
                                this.crtWorldIndex = 1;
                                this.crtStageI = 0;
                                i.bByte = 15;
                                i.dZInt = bInt(this.crtWorldIndex);
                                this.HBoolean = true;
                                this.avVoid();
                                this.pBoolean = true;
                                this.lBoolean = false;
                                if (i.iByteArr[9] < 1) {
                                    i.iByteArr[9] = 1;
                                    break Label_2264;
                                }
                                break;
                            }
                            case 2: {
                                this.aClassj.freeCrtPlayerResource();
                                this.crtWorldIndex = 2;
                                this.crtStageI = 0;
                                this.lBoolean = false;
                                i.bByte = 15;
                                i.dZInt = bInt(this.crtWorldIndex);
                                this.HBoolean = true;
                                this.avVoid();
                                this.pBoolean = true;
                                if (i.iByteArr[9] < 2) {
                                    i.iByteArr[9] = 2;
                                }
                                if (i.iByteArr[8] < 8) {
                                    i.iByteArr[8] = 8;
                                    break Label_2264;
                                }
                                break;
                            }
                            case 3: {
                                this.aVoid(4);
                                break Label_2264;
                            }
                            default: {
                                i.bByte = 3;
                                this.aClassj.dVoid();
                                i.aClassGloftDIRU.aVoid();
                                break;
                            }
                        }
                        return;
                    }
                    case 1: {
                        switch (this.aInt()) {
                            case 1: {
                                this.aVoid(7);
                                this.aRInt = 1;
                                break Label_2264;
                            }
                            case 0: {
                                i.bByte = 1;
                                i.fClassImage = null;
                                break Label_2264;
                            }
                            case 3: {
                                if (this.crtStageI != 13 || this.crtWorldIndex != 0) {
                                    this.aVoid(7);
                                    this.aRInt = 3;
                                    break Label_2264;
                                }
                                break;
                            }
                            case 4: {
                                this.aVoid(7);
                                this.aRInt = 4;
                                break Label_2264;
                            }
                            case 5: {
                                this.aVoid(7);
                                this.aRInt = 5;
                                break Label_2264;
                            }
                            case 2: {
                                this.aVoid(5);
                                break Label_2264;
                            }
                            case 6: {
                                i.bByte = 33;
                                this.avBoolean = true;
                                break Label_2264;
                            }
                            default: {
                                this.zBoolean = false;
                                break;
                            }
                        }
                        return;
                    }
                    case 5: {
                        return;
                    }
                    case 8: {
                        switch (this.aInt()) {
                            case 0: {
                                this.kVoid();
                                break;
                            }
                            case 1: {
                                i.bByte = 3;
                                break;
                            }
                        }
                        this.aRInt = -1;
                        break;
                    }
                }
            }
        }
    }

    private void IVoid() {
        i.aClassfArr[18].drawFrame(this.aClassGraphics, 0, 223, 308, 0);
    }

    private void JVoid() {
        i.aClassfArr[18].drawFrame(this.aClassGraphics, 3, 2, 308, 0);
    }

    private void KVoid() {
        final Graphics aClassGraphics;
        (aClassGraphics = this.aClassGraphics).setColor(0);
        aClassGraphics.fillRect(0, 0, 240, 320);
        int n;
        if ((n = (this.bsInt + 1) * 230 / this.brInt) > 230) {
            n = 230;
        }
        aClassGraphics.setColor(13540096);
        this.aClassGraphics.fillRect(5, 310, n, 6);
        aClassGraphics.setColor(16554500);
        this.aClassGraphics.drawRoundRect(4, 309, 231, 6, 2, 2);
        h.setColor(16777215);
        i.textSize0.drawTextWithFlags(this.aClassGraphics, i.texts[35], 120, a_Config.eInt, 1);
    }

    private void LVoid() {
        switch (this.kByte) {
            case 2: {
                if (this.tBoolean && this.aClassc == null && this.bmInt == -1) {
                    i.aClassfArr[15].drawAnimationFrame(this.aClassGraphics, 0, i.aSInt >> 1 & 0x3, this.bvInt, this.bwInt - 24, 0, 0, 0);
                }
                if (this.aInt + 240 > 1440 && this.bInt + 320 > 48) {
                    if (i.aClassfArr[10] == null) {
                        i.aClassfArr[10] = loadSprite("/mmv.f", 0, 0, 0);
                    }
                    final f_Sprite f = i.aClassfArr[10];
                    if (this.isPlayerAtPosition(60, 3) || this.isPlayerAtPosition(61, 3)) {
                        f.drawFrame(this.aClassGraphics, 1, 1440 - this.aInt, 48 - this.bInt, 0);
                    }
                }
                if (this.crtPlayerX > 55 && this.eBoolean) {
                    i.aClassbArr[0].draw(this.aClassGraphics);
                }
            }
            case 1: {
                final int asInt = i.aSInt;
                final b_SpriteAnimator b = i.aClassbArr[2];
                if (this.bInt + this.bkInt < 1008 && this.bInt + this.bkInt > 592) {
                    b.x = 240 - this.aInt;
                    b.y = 1008 - this.bInt;
                    b.applyFrameOffset();
                    b.draw(this.aClassGraphics);
                    b.x = 336 - this.aInt;
                    b.y = 1008 - this.bInt;
                    b.applyFrameOffset();
                    b.flags = 1;
                    b.draw(this.aClassGraphics);
                }
                if (this.bjInt > 10) {
                    for (int iInteger = 3; iInteger < 13; iInteger += 2) {
                        final int n;
                        this.aClassGraphics.drawImage(i.textures[27][iInteger & 0x1], ((n = 10 * (iInteger * 2 / 5 + 1)) + i.aSInt / n) * iInteger % 240, 320 / n * i.aSInt % 320, 0);
                    }
                }
                final int bInt = this.crtStageHeight * 24 - this.alInt - this.bInt;
                final int n2;
                int j = n2 = 168 - this.aInt;
                final int n3 = j + 240;
                while (j <= -24) {
                    j += 24;
                }
                final b_SpriteAnimator b2 = i.aClassbArr[1];
                if ((this.alInt >= 816 || b2.crtAnimationI == 2) && this.alInt > 816) {
                    for (int k = bInt + 20; k < 320; k += 24) {
                        for (int l = j; l < n3; l += 24) {
                            b2.sprite.drawAnimationFrame(this.aClassGraphics, 1, ((asInt >> 1) + l + k) % 2, l, k, 0, 0, 0);
                        }
                    }
                }
                if (b.crtAnimationI == 2) {
                    b2.flags = 0;
                    b2.x = n2 + 120;
                    b2.y = bInt;
                    b2.applyFrameOffset();
                    b2.draw(this.aClassGraphics);
                    b2.flags = 1;
                    b2.draw(this.aClassGraphics);
                    final Graphics aClassGraphics = this.aClassGraphics;
                    final int n4 = (i.aSInt << 3) % 160;
                    aClassGraphics.setColor(255, ((i.aSInt / 160 & 0x1) == 0x0) ? (160 - n4) : (n4 + 0), 0);
                    aClassGraphics.drawRect(0, 0, 239, 319);
                }
            }
            case 3: {
                if (this.kByte == 3 && i.aSInt >= this.kLong + 80L) {
                    for (int n5 = 14; n5 <= 21; ++n5) {
                        i.bIntArrArr[n5][15] = 0;
                        i.crtStageForegrondLayer[n5][15] = -1;
                        i.crtStagePlayerLayer[n5][15] = 44;
                        i.bByteArrArr[n5][15] = 0;
                        i.cByteArrArr[n5][15] = 24;
                    }
                    this.kLong = 0L;
                }
                if (this.aoInt != 15) {
                    if (this.aInt + 240 + 48 >= this.asInt && this.bInt + 320 + 48 >= 504) {
                        final b_SpriteAnimator b3;
                        (b3 = i.aClassbArr[5]).x = this.asInt - this.aInt;
                        b3.y = 504 - this.bInt;
                        b3.applyFrameOffset();
                        b3.draw(this.aClassGraphics);
                    }
                    if (this.aoInt == 12) {
                        final int n6 = this.asInt - this.aInt + i.aSInt * this.apInt % 48;
                        final int n7 = i.aClassbArr[5].y + 24;
                        i.aClassfArr[7].drawAnimationFrame(this.aClassGraphics, 0, i.aSInt % i.aClassfArr[7].getAnimationFrameCount(0), n6, n7, 0, 0, 0);
                        this.fVoid(n6, n7);
                    }
                }
            }
            case 4: {
                final Graphics aClassGraphics2 = this.aClassGraphics;
                final b_SpriteAnimator b4 = i.aClassbArr[5];
                final b_SpriteAnimator b5 = i.aClassbArr[4];
                int n8 = 0;
                Label_1183:
                {
                    int apInt = 0;
                    switch (this.aoInt) {
                        case 1: {
                            apInt = this.apInt;
                            break;
                        }
                        case 2:
                        case 7: {
                            apInt = 40;
                            break;
                        }
                        case 3: {
                            apInt = 40;
                            break;
                        }
                        case 4: {
                            apInt = 40 - (this.apInt << 1 << 1);
                            break;
                        }
                        case 5: {
                            n8 = 15 + this.apInt * 18;
                            this.ZBoolean = false;
                            break Label_1183;
                        }
                        case 9: {
                            apInt = 15 + this.apInt * 18;
                            break;
                        }
                        case 10: {
                            apInt = 15 + this.apInt * 18;
                            break;
                        }
                        case 11: {
                            apInt = 15 + this.apInt * 18;
                            break;
                        }
                        default: {
                            apInt = -1000;
                            break;
                        }
                    }
                    n8 = apInt;
                }
                b4.x = (10 + this.arInt * (2 + ((this.arInt > 0) ? 1 : 0))) * 24 - this.aInt;
                Label_1275:
                {
                    b_SpriteAnimator b6;
                    int bInt3;
                    if (this.aoInt == 5) {
                        final int bInt2 = b4.y;
                        b4.y = 256 - this.bInt - 15;
                        if (this.eInt() != 3) {
                            break Label_1275;
                        }
                        b6 = b4;
                        bInt3 = bInt2;
                    } else {
                        b6 = b4;
                        bInt3 = 256 - n8 - this.bInt;
                    }
                    b6.y = bInt3;
                }
                b4.draw(aClassGraphics2);
                if (this.kBoolean) {
                    b5.y = 96 - this.bInt;
                    b5.x = (this.dInt() + 1) * 24 - this.aInt;
                    b5.draw(aClassGraphics2);
                }
                for (int n9 = 0; n9 < 3; ++n9) {
                    final int n10;
                    if ((n10 = (n9 * (2 + ((n9 > 0) ? 1 : 0)) + 10) * 24 - this.aInt) < 240 && n10 > -48 && this.bInt > -80) {
                        i.aClassfArr[40].drawFrame(aClassGraphics2, 1, n10, 216 - this.bInt, 0);
                    }
                }
            }
            case 5: {
                if (this.aoInt == -1) {
                    break;
                }
                final b_SpriteAnimator b7;
                (b7 = i.aClassbArr[5]).x = this.atInt - this.aInt;
                b7.y = 504 - this.bInt;
                b7.applyFrameOffset();
                b7.draw(this.aClassGraphics);
                if (this.aoInt == 12) {
                    final int n11 = this.atInt - this.aInt + i.aSInt * this.apInt % 48;
                    final int n12 = i.aClassbArr[5].y + 24;
                    i.aClassfArr[7].drawAnimationFrame(this.aClassGraphics, 0, i.aSInt % i.aClassfArr[7].getAnimationFrameCount(1), n11, n12, 0, 0, 0);
                    this.fVoid(n11, n12);
                    break;
                }
                break;
            }
        }
    }

    private void MVoid() {
        final Graphics aClassGraphics = this.aClassGraphics;
        final b_SpriteAnimator b = i.aClassbArr[5];
        if (this.aoInt == 7) {
            final int n = b.x + i.aSInt * this.apInt % 48;
            int bInt = b.y;
            if (this.SInt == 10) {
                bInt -= 144;
            }
            i.aClassfArr[7].drawAnimationFrame(aClassGraphics, 1, i.aSInt % i.aClassfArr[7].getAnimationFrameCount(1), n, bInt, 0, 0, 0);
            this.fVoid(n, bInt);
            return;
        }
        if (this.aoInt != 8 && this.aoInt != 0) {
            this.aVoid(aClassGraphics, 3);
        }
    }

    private void aVoid(final Graphics graphics, int i) {
        i = i * 14 + 2;
        final int n = 240 - i >> 1;
        if (this.aqInt > 0) {
            graphics.setColor(0);
            graphics.fillRect(n, 5, i, 12);
            graphics.setColor(3913615);
            for (i = 0; i < this.aqInt; ++i) {
                graphics.fillRect(n + 2 + i * 14, 7, 12, 8);
            }
        }
    }

    private void NVoid() {
        if (this.EBoolean) {
            return;
        }
        final int hInt = this.crtPlayerX;
        final int iInt = this.crtPlayerY;
        final int asInt = i.aSInt;
        final int n = this.kInt & 0x7;
        final b_SpriteAnimator b = i.aClassbArr[((this.kInt & 0x4000) == 0x0) ? 0 : 3];
        final boolean cBoolean = this.isPlayerWithinStageBounds();
        final int n2 = ((this.kInt & 0x800) == 0x0) ? this.bQInt : (this.kInt & 0x7);
        if (!this.eBoolean) {
            return;
        }
        this.bvInt = hInt * 24 + i.gByteArr[n2] * this.jInt - this.aInt;
        this.bwInt = iInt * 24 + i.gByteArr[n2 + 8] * this.jInt - this.bInt;
        if ((this.bLong <= 0L || (asInt >> 1 & 0x1) == 0x0) && this.aTInt <= 0) {
            b.x = this.bvInt;
            b.y = this.bwInt;
            if (i.eIntArrArr != null && cBoolean && n != 1 && n != 3 && i.eIntArrArr[hInt][iInt + 1] != 0 && iBoolean(hInt, iInt + 1)) {
                final int n4;
                int n3 = (n4 = (asInt >> 1) + hInt) % 4;
                if ((n4 / 4 & 0x1) == 0x1) {
                    n3 = 4 - n3;
                }
                final b_SpriteAnimator b2 = b;
                b2.y += n3;
            }
            b.applyFrameOffset();
            b.draw(this.aClassGraphics);
            final int dInt;
            i.aBoolean = ((dInt = b.crtAnimationI) == 47 && b.crtAnimationFrame == 0);
            switch (dInt) {
                case 40:
                case 47:
                case 48: {
                    if (b.crtAnimationFrame <= ((dInt == 40) ? 13 : 6)) {
                        if (dInt != 47) {
                            break;
                        }
                    }
                    try {
                        int n5 = 0;
                        if (this.aFInt == 30 || this.aFInt == 31 || this.aFInt == 32) {
                            n5 = -2;
                        }
                        if (i.textures[this.aFInt] == null) {
                            i.aClassfArr[aInt(this.aFInt)].drawFrame(this.aClassGraphics, this.aGInt, b.x + n5, b.y - 24, 0);
                        } else {
                            this.aClassGraphics.drawImage(i.textures[this.aFInt][this.aGInt], b.x + n5, b.y - 24, 0);
                        }
                    } catch (Exception x) {
                        System.out.println(x);
                    }
                    if (this.aHInt > 0) {
                        aVoid(this.aClassGraphics, b.x + 24, b.y - 10, this.aHInt, i.aClassfArr[0].images[0], 0);
                        break;
                    }
                    break;
                }
                case 17:
                case 18: {
                    if (b.crtAnimationFrame == 0) {
                        this.aClassGraphics.drawImage(i.textures[this.aFInt][this.aGInt], b.x, b.y - 12, 0);
                        break;
                    }
                    break;
                }
            }
        }
        if (cBoolean && i.crtStagePlayerLayer[hInt][iInt] == 0) {
            final int n6 = i.bIntArrArr[hInt][iInt] & 0x7;
            final byte b3 = i.bByteArrArr[hInt][iInt];
            try {
                i.aClassfArr[aInt(1)].drawFrame(this.aClassGraphics, 0 + (i.bIntArrArr[hInt][iInt] & 0x38), hInt * 24 - this.aInt + i.gByteArr[n6] * b3, iInt * 24 - this.bInt + i.gByteArr[n6 + 8] * b3, 0);
            } catch (Exception ex) {
            }
        }
    }

    private void OVoid() {
        final int bgInt = this.bGInt;
        final int bhInt;
        final int n = (bhInt = this.bHInt) + 1;
        this.bzInt = 0;
        this.bAInt = 0;
        this.ABoolean = false;
        int n3;
        final int n2 = (n3 = i.bIntArrArr[bgInt][bhInt]) & 0x7;
        final byte b = i.bByteArrArr[bgInt][bhInt];
        if (n3 == -1) {
            n3 = -1;
        }
        this.bNInt += b * i.gByteArr[n2];
        this.bOInt += b * i.gByteArr[n2 + 8];
        final boolean b2 = i.eIntArrArr != null && i.eIntArrArr[bgInt][bhInt] != 0;
        switch (this.bIInt) {
            case 47: {
                i.bClassf = i.aClassfArr[30];
                this.bKInt = 0;
                this.bLInt = aInt(i.bClassf, 0, i.aSInt % aInt(i.bClassf, 0));
                break;
            }
            case 8: {
                this.aLInt = 16;
                this.aMInt = 0 + (i.aSInt >> 1 & 0x1);
                break;
            }
            case 5: {
                this.aLInt = 25;
                this.aMInt = 0 + this.bRInt;
                break;
            }
            case 6: {
                this.aLInt = 5;
                this.aMInt = 0;
                break;
            }
            case 7: {
                this.aLInt = 5;
                this.aMInt = 1;
                break;
            }
            case 9: {
                i.bClassf = i.aClassfArr[(n3 & 0xFC00000) >> 22];
                this.bLInt = 0;
                break;
            }
            case 4: {
                this.aLInt = 24;
                this.aMInt = 0 + this.bRInt;
                break;
            }
            case 0: {
                final int n4 = (n3 & 0x38) >> 3;
                int bnInt = (n3 & 0x7000) >> 12;
                final boolean b3 = (n3 & 0x10000) == 0x0;
                if (!b2 && n2 == 0 && iBoolean(bgInt, n)) {
                    final int n5 = (n3 & 0xFFFF8FFF) | bnInt << 12;
                    if (b3) {
                        n3 = (n5 & 0xFFFEFFFF);
                    } else {
                        n3 = (n5 | 0x10000);
                        bnInt = -bnInt;
                    }
                    this.bNInt = bnInt;
                } else {
                    n3 &= 0xFFFF8FFF;
                }
                i.bIntArrArr[bgInt][bhInt] = n3;
                this.aLInt = 1;
                this.aMInt = n4 + 0;
                break;
            }
            case 1: {
                this.aLInt = 2;
                this.aMInt = 0 + this.bRInt;
                break;
            }
            case 2: {
                final int n6 = i.crtStageForegrondLayer[this.bGInt][this.bHInt] & 0xFF;
                final int n7 = i.crtStageForegrondLayer[this.bGInt][this.bHInt] >> 8;
                if ((n6 != 14 && n6 != 33) || n7 > 11) {
                    this.aLInt = 3;
                    this.aMInt = 0 + this.bRInt;
                    i i;
                    f_Sprite[] array;
                    int n8;
                    if (n6 == 14) {
                        i = this;
                        array = i.aClassfArr;
                        n8 = 8;
                    } else {
                        if (n6 != 33) {
                            break;
                        }
                        i = this;
                        array = i.aClassfArr;
                        n8 = 22;
                    }
                    i.bOInt = -(array[n8].getAnimationFrameCount(0) - n7);
                    break;
                }
                break;
            }
        }
        if (b2 || (i.eIntArrArr != null && i.eIntArrArr[bgInt][n] != 0 && iBoolean(bgInt, n))) {
            final int n10;
            int n9 = (n10 = (i.aSInt >> 1) + bgInt) % 4;
            if ((n10 / 4 & 0x1) == 0x1) {
                n9 = 4 - n9;
            }
            this.bOInt += n9;
        }
        if (((n3 & 0x200) != 0x0 || (i.crtStagePlayerLayer[bgInt - i.gByteArr[n2]][n] < 0 && iBoolean(bgInt, n) && (i.bIntArrArr[bgInt][n] & 0x7) == 0x0 && bgInt != this.bgInt && bhInt != this.bhInt)) && (this.kInt & 0x8) == 0x0) {
            this.bOInt += b * b / 24;
            if (this.bIInt != 9) {
                this.bNInt += -1 + i.aSInt % 3;
            }
        }
        if ((n3 & 0x200) != 0x0) {
            this.bNInt = -this.bNInt;
        }
        if (this.bIInt == 0) {
            this.bDInt = ((n3 & 0x1C0) >> 6) - 1;
            if (this.bDInt >= 0 && this.bDInt < 5) {
                this.ABoolean = true;
                i j = null;
                int bzInt = 0;
                switch (n3 & 0x7) {
                    case 4: {
                        j = this;
                        bzInt = 24;
                        break;
                    }
                    case 2: {
                        j = this;
                        bzInt = -24;
                        break;
                    }
                    default: {
                        j = this;
                        bzInt = 0;
                        break;
                    }
                }
                j.bzInt = bzInt;
                this.bAInt = 13;
                this.bBInt = this.bGInt;
                this.bCInt = this.bHInt - 1;
            }
        }
        this.FVoid();
    }

    private void cVoid(final byte b) {
        final int n = i.bIntArrArr[this.bGInt][this.bHInt];
        final byte b2 = i.bByteArrArr[this.bGInt][this.bHInt];
        final int n2 = n & 0x7;
        this.bNInt = b2 * i.gByteArr[n2];
        this.bOInt = b2 * i.gByteArr[n2 + 8];
        i.bClassf = i.aClassfArr[(b == 19) ? 4 : 21];
        i j = null;
        int asInt = 0;
        f_Sprite f = null;
        int bkInt3 = 0;
        Label_0188:
        {
            if (this.crtWorldIndex == 1) {
                i i;
                int bkInt;
                if ((n & 0xF8) >> 3 > 0) {
                    i = this;
                    bkInt = 2;
                } else {
                    i = this;
                    bkInt = 0;
                }
                i.bKInt = bkInt;
                j = this;
                asInt = i.aSInt;
                f = i.bClassf;
            } else {
                Label_0164:
                {
                    i k;
                    int bkInt2;
                    if ((n & 0xF8) >> 3 > 0) {
                        k = this;
                        bkInt2 = 4;
                    } else {
                        this.bKInt = n2 - 1;
                        if (this.bKInt >= 0) {
                            break Label_0164;
                        }
                        k = this;
                        bkInt2 = ((n & 0x7000) >> 12) - 1;
                    }
                    k.bKInt = bkInt2;
                }
                j = this;
                asInt = i.aSInt >> 1;
                f = i.bClassf;
                if (this.bKInt < 0) {
                    bkInt3 = 0;
                    break Label_0188;
                }
            }
            bkInt3 = this.bKInt;
        }
        j.bLInt = asInt % f.getAnimationFrameCount(bkInt3);
        this.FVoid();
    }

    private static int aInt(final f_Sprite f, final int n, int i) {
        int n2 = 0;
        for (int n3 = 0; i > 0; i -= f.getAnimationFrameTime(n, n3), n2 = n3, ++n3) {
        }
        return n2;
    }

    private static int bInt(final f_Sprite f, final int n, int n2) {
        n2 = 0;
        for (int i = 0; i < 1; ++i) {
            n2 = 0 + f.getAnimationFrameTime(n, 0);
        }
        return n2;
    }

    private static void aVoid(final Graphics graphics, int n, final int n2, int iInteger, final Image[] array, int n3) {
        if (iInteger == 0) {
            graphics.drawImage(i.aClassfArr[0].images[0][0], n, n2, 24);
            return;
        }
        while (iInteger > 0) {
            n3 = iInteger % 10;
            iInteger /= 10;
            final Image image = array[n3];
            n -= image.getWidth();
            graphics.drawImage(image, n, n2, 0);
        }
    }

    private boolean isPlayerWithinStageBounds() {
        return this.crtPlayerX > 0 && this.crtPlayerX < this.crtStageWidth - 1 &&
                this.crtPlayerY > 0 && this.crtPlayerY < this.crtStageHeight - 1;
    }

    private void gVoid(int n) {
        final int dInt;
        if ((dInt = i.aClassbArr[0].crtAnimationI) != 19 && (this.kInt & 0x4000) == 0x0 && (this.kInt & 0x800) == 0x0) {
            Label_0516:
            {
                if (this.isPlayerWithinStageBounds()) {
                    final int n2;
                    if ((n2 = ((i.eIntArrArr == null) ? 0 : aInt(i.eIntArrArr[this.crtPlayerX][this.crtPlayerY], (byte) 0, (byte) 3, (byte) 4))) == 8 || n2 == 7) {
                        switch (n) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 11:
                            case 24:
                            case 25:
                            case 26:
                            case 27: {
                                n = 36 + (this.kInt & 0x7) - 1;
                                break;
                            }
                        }
                    } else if (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY + 1] < 0 || i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY + 1] == 14) {
                        int n3 = 0;
                        switch (n) {
                            case 14: {
                                n3 = 28;
                                break;
                            }
                            case 16: {
                                n3 = 29;
                                break;
                            }
                            case 42: {
                                n3 = 46;
                                break;
                            }
                            case 44: {
                                n3 = 45;
                                break;
                            }
                            case 1: {
                                n3 = 35;
                                break;
                            }
                            case 3: {
                                n3 = 34;
                                break;
                            }
                            case 0: {
                                n3 = 0;
                                break;
                            }
                            case 2: {
                                n3 = 2;
                                break;
                            }
                            case 22: {
                                n3 = 31;
                                break;
                            }
                            case 20: {
                                n3 = 30;
                                break;
                            }
                            case 23: {
                                n3 = 33;
                                break;
                            }
                            case 21: {
                                n3 = 32;
                                break;
                            }
                            default: {
                                break Label_0516;
                            }
                        }
                        n = n3;
                    }
                }
            }
            if (n == 1000) {
                i.aClassbArr[3].setAnimation(0);
                this.kInt |= 0x4000;
            } else {
                i.aClassbArr[0].setAnimation(n);
            }
            if (dInt != n) {
                this.axInt = 70;
            }
        }
    }

    private void PVoid() {
        if (isKeyPressed(KEY_ANY_OK)) { // 32944
            i.keysPressed = 0;
            this.avBoolean = true;
            final int nInt = this.nInt;
            this.enInt = -1;
            switch (fInt(nInt)) {
                case -1: {
                    this.aClassString = i.texts[41];
                }
                case 0: {
                    this.aClassString = i.texts[0];
                }
                case 1: {
                    this.aZInt = unpackUint16(i.iByteArr, 4) - a_Config.itemPrices[this.nInt];
                    this.gClassString = null;
                    System.gc();
                    this.gClassString = i.texts[125] + " " + this.aZInt + " " + i.texts[19];
                    i.iByteArr[4] = (byte) this.aZInt;
                    i.iByteArr[5] = (byte) (this.aZInt >> 8);
                    i.iByteArr[8] = (byte) (nInt + 4 + 1);
                    this.uVoid();
                    this.oInt = -1;
                    this.aClassString = i.texts[0];
                    this.aaBoolean = true;
                    this.aVoid(i.texts[32], -1, -1, 5000, 4273165, 0);
                    break;
                }
            }
            return;
        }
        if (isKeyPressed(KEY_CANCEL)) { // 64
            i.keysPressed = 0;
            i.bByte = 27;
            this.avBoolean = true;
            this.gBoolean = true;
            i.keysPressed = 0;
            return;
        }
        Label_0325:
        {
            i i;
            i j;
            i k;
            int n;
            if (isKeyPressed(KEY_UP)) { // 4097
                i = this;
                j = this;
                k = this;
                n = -1;
            } else {
                if (!isKeyPressed(KEY_DOWN)) { // 262146
                    break Label_0325;
                }
                i = this;
                j = this;
                k = this;
                n = 1;
            }
            final int n2 = n;
            final i l = k;
            i.nInt = j.nInt + n2;
            if (l.nInt < 0) {
                l.nInt = 3;
            }
            if (l.nInt == 4) {
                l.nInt = 0;
            }
        }
        i.keysPressed = 0;
        i m;
        String[] array;
        int n3;
        if (fInt(this.nInt) == 0) {
            this.oInt = -1;
            m = this;
            array = i.texts;
            n3 = 0;
        } else {
            this.oInt = a_Config.itemPrices[this.nInt];
            this.dClassStringBuffer.delete(0, this.dClassStringBuffer.length());
            this.dClassStringBuffer.append(this.oInt);
            m = this;
            array = i.texts;
            n3 = 6;
        }
        m.aClassString = array[n3];
        this.avBoolean = true;
    }

    private static int fInt(final int n) {
        if (i.iByteArr[8] >= n + 4 + 1) {
            return 0;
        }
        if (unpackUint16(i.iByteArr, 4) < a_Config.itemPrices[n]) {
            return -1;
        }
        return 1;
    }

    private void QVoid() {
        this.DBoolean = true;
        i.bByte = 16;
        this.bsInt = 0;
        this.brInt = 6;
        this.azInt = 0;
        this.bbInt = 0;
        this.aZInt = 0;
        this.pBoolean = false;
        this.agInt = 0;
        i.dZInt = 0;
    }

    private void checkCheatKeyCodeIsPressed() {
        if (i.crtCheatPageKeyCodeIndex < i.cheatPageKeyCode.length && isKeyPressed(i.cheatPageKeyCode[i.crtCheatPageKeyCodeIndex])) {
            i.keysPressed = 0;
            if (++i.crtCheatPageKeyCodeIndex == i.cheatPageKeyCode.length) {
                i.keysPressed = 0;
                i.bByte = 24;
                this.czInt = i.iByteArr[8];
                this.cAInt = i.iByteArr[9];
                this.SBoolean = false;
                this.TBoolean = false;
            }
        } else {
            byte sByte;
            if (isKeyPressed(i.cheatPageKeyCode[0])) {
                i.keysPressed = 0;
                sByte = 1;
            } else {
                sByte = 0;
            }
            i.crtCheatPageKeyCodeIndex = sByte;
        }
    }

    private void SVoid() {
        this.aClassGraphics.setClip(0, 0, 240, 320);
        this.aClassGraphics.setColor(0);
        this.aClassGraphics.fillRect(0, 0, 240, 320);
        i.bByte = i.mByte;
        if (i.mByte == 27) {
            this.avBoolean = true;
            this.gBoolean = true;
        } else if (i.mByte == 1) {
            this.oBoolean = true;
        }
        i.keysPressed = 0;
    }

    private void TVoid() {
        if (this.dbInt >= 0 && this.dbInt <= 2) {
            i.keysPressed = 0;
            return;
        }
        if (isKeyPressed(KEY_UP)) { // 4097
            if (System.currentTimeMillis() < 300L) {
                return;
            }
            this.mVoid();
            if (this.boInt == 0 && this.bqInt == 0 && !this.XBoolean) {
                this.mVoid();
            }
        } else if (isKeyPressed(KEY_DOWN)) { // 262146
            if (System.currentTimeMillis() < 300L) {
                return;
            }
            this.nVoid();
            if (this.boInt == 0 && this.bqInt == 0 && !this.XBoolean) {
                this.nVoid();
            }
        } else if (isKeyPressed(KEY_ANY_OK)) { // 32944
            if (this.dbInt < 0 || this.dbInt > 2) {
                this.dbInt = 0;
                this.gLong = System.currentTimeMillis();
            }
        } else if (isKeyPressed(KEY_CANCEL)) { // 64
            switch (this.boInt) {
                case 5: {
                    i.VBoolean = true;
                    i.WBoolean = false;
                    if (i.bByte == 2) {
                        this.aVoid(1);
                        this.oBoolean = true;
                        i.WBoolean = true;
                    }
                    if (i.bByte == 4) {
                        this.aVoid(0);
                        this.playSound(j_SoundManager.SOUND_M_TITLE);
                        break;
                    }
                    break;
                }
                case 2: {
                    i.bByte = 9;
                    this.aVoid(0);
                    this.brInt = 8;
                    this.bsInt = 0;
                    break;
                }
                case 4: {
                    this.aVoid(2);
                    break;
                }
            }
        }
        i.keysPressed = 0;
    }

    private boolean dBoolean() {
        if (this.xByte == 3) {
            final int n = i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF;
            if (this.cfInt == 0 && n != 15 && n != 16) {
                this.playSound(0);
                i i;
                int cfInt;
                if (this.ceInt <= 0) {
                    i = this;
                    cfInt = 1;
                } else {
                    i = this;
                    cfInt = -1;
                }
                i.cfInt = cfInt;
            }
            return true;
        }
        return false;
    }

    private void bVoid(final int n, final int n2, final int n3) {
        int n4 = i.bIntArrArr[n2][n3];
        if (n == 43 && (n4 & 0xF8) == 0x0) {
            if ((n4 & 0x18000) == 0x0) {
                i.crtStagePlayerLayer[n2][n3] = -1;
                this.jVoid(n2, n3);
                return;
            }
            final int n5;
            n4 = ((((n5 = ((((n4 - 32768 & 0xFF01FFFF) | n2 << 17) & 0x80FFFFFF) | n3 << 24)) & 0x7) == 0x1 || (n5 & 0x7) == 0x3) ? (n5 | Integer.MIN_VALUE) : (n5 & Integer.MAX_VALUE));
        }
        i.bIntArrArr[n2][n3] = ((n4 & 0xFFFFFF07) | 0x78);
    }

    private void dVoid(final int n, final int n2) {
        switch (i.crtStagePlayerLayer[n][n2]) {
            case 0: {
                this.playSound(11);
            }
            case 19:
            case 43:
            case 45:
            case 46: {
                i.crtStageForegrondLayer[n][n2] = -1;
                this.jVoid(n, n2);
            }
            case 48: {
                i.crtStageForegrondLayer[n][n2] = -1;
                this.jVoid(n, n2);
                int n3 = n2 + 1;
                if (i.crtStagePlayerLayer[n][n3] != 48) {
                    n3 = -1;
                }
                i.crtStagePlayerLayer[n][n3] = -1;
                this.jVoid(n, n3);
                i.eByteArr[(i.bIntArrArr[n][n2] >> 24) * 3 + 2] = -1;
            }
            default: {
                i.crtStageForegrondLayer[n][n2] = -1;
            }
        }
    }

    private void UVoid() {
        if (this.cBoolean) {
            --this.lInt;
        }
        if ((this.hBoolean || this.ajBoolean) && i.aSInt > 140) {
            if (this.ajBoolean) {
                this.bInt();
            }
            this.hBoolean = false;
            this.ajBoolean = false;
            this.KBoolean = true;
            this.bsInt = 0;
            this.eVoid();
            this.IBoolean = true;
            i.bByte = 28;
        }
        boolean b = this.isPlayerWithinStageBounds();
        if (this.alBoolean) {
            this.alBoolean = false;
            if (this.dtInt < this.duInt) {
                this.mVoid(aInt((byte) this.dtInt, (byte) 13, (byte) 7), aInt((byte) this.dtInt, (byte) 20, (byte) 7));
                ++this.dtInt;
            } else {
                this.dtInt = 0;
                this.duInt = 0;
            }
        }
        if (i.aClassbArr[4] != null) {
            i.aClassbArr[4].tick();
        }
        if (this.bjInt > 0) {
            --this.bjInt;
        }
        if (this.diInt > 0) {
            --this.diInt;
            if (this.diInt == 0) {
                this.eClassString = null;
            }
        }
        if (this.adInt != this.aeInt) {
            int adInt;
            int n = adInt = this.adInt;
            while (true) {
                final int n2 = adInt;
                if (n == this.aeInt) {
                    break;
                }
                final byte[] bByteArr = i.bByteArr;
                final int n3 = n2;
                ++bByteArr[n3];
                if (i.bByteArr[n2] >= ((i.cByteArr[n2] < 0) ? aInt(i.aClassfArr[2], 0) : i.aClassfArr[9].getAnimationFrameCount((int) i.cByteArr[n2]))) {
                    ++this.adInt;
                    this.adInt &= 0x7;
                }
                n = (adInt = (n2 + 1 & 0x7));
            }
        }
        if (this.kByte != 0) {
            Label_5436:
            {
                switch (this.kByte) {
                    case 2: {
                        if (i.crtStageForegrondLayer != null && this.isPlayerWithinStageBounds() && (i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) == 0x0) {
                            final int n4;
                            if ((n4 = i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] >> 8) == 13) {
                                this.qBoolean = true;
                            } else if (n4 == 16) {
                                this.rBoolean = true;
                            }
                        }
                        if (!this.sBoolean && this.jInt <= 0 && this.isPlayerAtPosition(46, 7)) {
                            this.tBoolean = true;
                            this.sBoolean = true;
                        }
                        if (this.isPlayerAtPosition(61, 3) && this.jInt == 6) {
                            this.cVoid(this.crtPlayerX, this.crtPlayerY, 5);
                            this.eBoolean = false;
                        }
                        if (this.aClassc == null && (this.isPlayerAtPosition(60, 3) || this.isPlayerAtPosition(61, 3))) {
                            this.bVoid(true);
                            this.NBoolean = true;
                            this.auVoid();
                            this.pVoid();
                            this.crtWorldIndex = 0;
                            this.crtStageI = 0;
                            this.lVoid();
                        }
                        if (this.aIInt == 2) {
                            i.crtStageForegrondLayer[11][50] = -1;
                        }
                        break;
                    }
                    case 1: {
                        if (i.crtStagePlayerLayer[18][63] == 0 && i.bByteArrArr[18][63] <= 0 && this.amInt == 0) {
                            this.bjInt = 120;
                            ++this.amInt;
                        }
                        Label_0773:
                        {
                            b_SpriteAnimator b2;
                            int n5;
                            if (this.amInt == 3) {
                                if (i.aClassbArr[2].crtAnimationI == 0) {
                                    b2 = i.aClassbArr[2];
                                    n5 = 1;
                                } else {
                                    if (i.aClassbArr[2].crtAnimationI != 1 || !i.aClassbArr[2].animationEnded()) {
                                        break Label_0773;
                                    }
                                    i.aClassbArr[2].setAnimation(2);
                                    if (this.crtPlayerY == this.crtStageHeight - 4) {
                                        this.alInt = 817;
                                    }
                                    break Label_0773;
                                }
                            } else {
                                if (i.aClassbArr[2].crtAnimationI == 0) {
                                    break Label_0773;
                                }
                                b2 = i.aClassbArr[2];
                                n5 = 0;
                            }
                            b2.setAnimation(n5);
                        }
                        i.aClassbArr[2].tick();
                        if (i.aClassbArr[2].crtAnimationI == 2) {
                            i.aClassbArr[1].tick();
                            if (this.bjInt == 10) {
                                this.bjInt = 60;
                            }
                            if (i.aClassbArr[1].crtAnimationI == 0) {
                                if ((this.aClassc == null || this.alInt < 46) && this.alInt < 1704) {
                                    ++this.alInt;
                                    final int alInt = this.crtStageHeight * 24 - (this.bInt + 320 - 80);
                                    if (this.alInt < alInt) {
                                        this.alInt = alInt;
                                    }
                                }
                                if (this.crtStageHeight * 24 - this.alInt <= this.crtPlayerY * 24 + 18 && this.crtPlayerX < 17) {
                                    this.hurtHero(i.iByteArr[8], 64, 1);
                                }
                            } else if (i.aClassbArr[1].animationEnded()) {
                                i.aClassbArr[1].setAnimation(0);
                            }
                        }
                        break;
                    }
                    case 3: {
                        final b_SpriteAnimator b3 = i.aClassbArr[5];
                        final int beInt = this.bEInt;
                        final int bfInt = this.bFInt;
                        final int n6 = this.crtPlayerX - 8;
                        final int n7 = this.crtPlayerX + 8;
                        final int n8 = this.crtPlayerY + 8;
                        final int n9 = this.crtPlayerY - 8;
                        for (int iInteger = 15; iInteger <= 22; ++iInteger) {
                            for (int j = 14; j <= 21; ++j) {
                                if ((j <= n6 || j >= n7 || iInteger <= n8 || iInteger >= n9) && i.crtStagePlayerLayer[j][iInteger] == 44) {
                                    this.bEInt = j;
                                    this.bFInt = iInteger;
                                    this.akVoid();
                                }
                            }
                        }
                        this.bEInt = beInt;
                        this.bFInt = bfInt;
                        if (this.nByte == 0) {
                            this.adVoid();
                        }
                        b_SpriteAnimator b4;
                        if (this.aoInt == 12) {
                            if (this.apInt++ > 100) {
                                this.aoInt = 15;
                                this.jVoid(11, 11);
                            } else {
                                this.aClassj.playSound(j_SoundManager.SOUND_SFX_MINE);
                            }
                            b4 = b3;
                        } else if (this.aoInt == -1) {
                            if (this.crtPlayerX * 24 >= 336) {
                                b3.setAnimation(this.aoInt = 0);
                                break;
                            }
                            break;
                        } else {
                            if (this.aoInt == 15 || this.aoInt == -1) {
                                break;
                            }
                            int n10 = -1;
                            final int n11 = this.crtPlayerX * 24 + 12;
                            final int n12 = this.crtPlayerY * 24;
                            int n13 = this.asInt + 24;
                            if (this.jLong == 0L && this.nByte != 0) {
                                this.jLong = i.aSInt + e_Utils.getRandomInt(340, 441);
                            }
                            int n14 = (this.aqInt > 0 && i.aSInt % this.aqInt == 0) ? 2 : 1;
                            if (this.aoInt == 10 || this.aoInt == 11) {
                                n14 = (((i.aSInt & 0xB) == 0x0) ? 2 : n14);
                            }
                            while (n14-- > 0) {
                                Label_2250:
                                {
                                    switch (this.aoInt) {
                                        case 2: {
                                            if (!b3.animationEnded()) {
                                                break;
                                            }
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 13);
                                                break;
                                            }
                                            n10 = (this.aoInt = 4);
                                            break;
                                        }
                                        case 3: {
                                            if (!b3.animationEnded()) {
                                                break;
                                            }
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 14);
                                                break;
                                            }
                                            n10 = (this.aoInt = 5);
                                            break;
                                        }
                                        case 0: {
                                            if (n13 > 360) {
                                                n10 = (this.aoInt = 4);
                                                break;
                                            }
                                            n10 = (this.aoInt = 5);
                                            break;
                                        }
                                        case 1: {
                                            if (n13 < 504) {
                                                n10 = (this.aoInt = 5);
                                                break;
                                            }
                                            n10 = (this.aoInt = 4);
                                            break;
                                        }
                                        case 10: {
                                            if (!b3.animationEnded()) {
                                                this.asInt -= 2;
                                                break;
                                            }
                                            this.bjInt = 10;
                                            n13 = this.asInt + 24;
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 13);
                                                break;
                                            }
                                            if (n12 < 504) {
                                                n10 = (this.aoInt = 4);
                                                break;
                                            }
                                            if (n11 >= n13 - 48) {
                                                n10 = (this.aoInt = 6);
                                                break;
                                            }
                                            break;
                                        }
                                        case 11: {
                                            if (!b3.animationEnded()) {
                                                this.asInt += 2;
                                                break;
                                            }
                                            this.bjInt = 10;
                                            n13 = this.asInt + 24;
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 14);
                                                break;
                                            }
                                            if (n12 < 504) {
                                                n10 = (this.aoInt = 5);
                                                break;
                                            }
                                            if (n11 <= n13 + 48) {
                                                n10 = (this.aoInt = 7);
                                                break;
                                            }
                                            break;
                                        }
                                        case 4: {
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 13);
                                                break;
                                            }
                                            if (n12 >= 504 && n11 < n13 && this.asInt - 48 >= 360) {
                                                n10 = (this.aoInt = 10);
                                            }
                                            if (n13 <= 360) {
                                                n10 = (this.aoInt = 5);
                                            }
                                            if (this.aoInt == 4) {
                                                --this.asInt;
                                                break;
                                            }
                                            break;
                                        }
                                        case 5: {
                                            if (i.aSInt > this.jLong) {
                                                n10 = (this.aoInt = 14);
                                                break;
                                            }
                                            if (n12 >= 504 && n11 > n13 && this.asInt + 48 <= 504) {
                                                n10 = (this.aoInt = 11);
                                            }
                                            if (n13 >= 504) {
                                                n10 = (this.aoInt = 4);
                                            }
                                            if (this.aoInt == 5) {
                                                ++this.asInt;
                                                break;
                                            }
                                            break;
                                        }
                                        case 6:
                                        case 7:
                                        case 13:
                                        case 14: {
                                            int aoInt = 0;
                                            int n15 = 0;
                                            int n16 = 0;
                                            while (true) {
                                                int n17 = 0;
                                                switch (this.aoInt) {
                                                    case 6:
                                                    case 13: {
                                                        aoInt = 4;
                                                        n15 = 2;
                                                        n17 = 1;
                                                        break;
                                                    }
                                                    case 7:
                                                    case 14: {
                                                        aoInt = 5;
                                                        n15 = 1;
                                                        n17 = 2;
                                                        break;
                                                    }
                                                    default: {
                                                        if (b3.crtAnimationFrame == 5 && b3.crtTime == 0) {
                                                            i k;
                                                            int bjInt;
                                                            if (this.aoInt == 13 || this.aoInt == 14) {
                                                                k = this;
                                                                bjInt = 80;
                                                            } else {
                                                                k = this;
                                                                bjInt = 10;
                                                            }
                                                            k.bjInt = bjInt;
                                                        }
                                                        if (b3.animationEnded()) {
                                                            if (this.aoInt == 13 || this.aoInt == 14) {
                                                                this.kLong = i.aSInt + 40;
                                                                this.jLong = i.aSInt + e_Utils.getRandomInt(340, 441);
                                                            }
                                                            n10 = (this.aoInt = aoInt);
                                                        }
                                                        if (b3.crtAnimationFrame >= 5 && n12 >= 504 && n11 >= n13 - n15 * 24 && n11 <= n13 + n16 * 24) {
                                                            this.hurtHero(1, 48, 4);
                                                            break Label_2250;
                                                        }
                                                        break Label_2250;
                                                    }
                                                }
                                                n16 = n17;
                                                continue;
                                            }
                                        }
                                    }
                                }
                                if (n12 >= 504 && n11 >= n13 - 24 && n11 <= n13 + 24) {
                                    this.hurtHero(1, 48, (int) i.hByteArr[this.kInt & 0x7]);
                                }
                                if (this.aqInt <= 0) {
                                    this.aoInt = 12;
                                    this.apInt = 0;
                                    break Label_5436;
                                }
                            }
                            Label_2517:
                            {
                                if (this.ceInt == 5) {
                                    int[] array;
                                    int n18;
                                    if (this.cfInt <= 0) {
                                        if (this.aqInt <= 2) {
                                            i.crtStagePlayerLayer[10][16] = 45;
                                            i.cByteArrArr[10][16] = 24;
                                            i.bByteArrArr[10][16] = 0;
                                            i.bIntArrArr[10][16] = 0;
                                        }
                                        i.crtStagePlayerLayer[26][19] = 45;
                                        i.cByteArrArr[26][19] = 24;
                                        i.bByteArrArr[26][19] = 0;
                                        array = i.bIntArrArr[26];
                                        n18 = 19;
                                    } else {
                                        i.crtStagePlayerLayer[10][19] = 45;
                                        i.cByteArrArr[10][19] = 24;
                                        i.bByteArrArr[10][19] = 0;
                                        i.bIntArrArr[10][19] = 0;
                                        if (this.aqInt > 2) {
                                            break Label_2517;
                                        }
                                        i.crtStagePlayerLayer[26][16] = 45;
                                        i.cByteArrArr[26][16] = 24;
                                        i.bByteArrArr[26][16] = 0;
                                        array = i.bIntArrArr[26];
                                        n18 = 16;
                                    }
                                    array[n18] = 0;
                                }
                            }
                            if (this.aoInt != 10 && this.aoInt != 11) {
                                for (int l = 21; l < 23; ++l) {
                                    for (int n19 = n13 / 24 - 1; n19 < n13 / 24 - 2 + 4; ++n19) {
                                        if (i.crtStagePlayerLayer[n19][l] == 9) {
                                            Label_2673:
                                            {
                                                if ((i.bIntArrArr[n19][l] & 0x7) == 0x3) {
                                                    --this.aqInt;
                                                    i m = null;
                                                    int n20 = 0;
                                                    int aoInt2 = 0;
                                                    switch (this.aoInt) {
                                                        case 0:
                                                        case 2:
                                                        case 4:
                                                        case 6: {
                                                            m = this;
                                                            aoInt2 = (n20 = 2);
                                                            break;
                                                        }
                                                        case 1:
                                                        case 3:
                                                        case 5:
                                                        case 7: {
                                                            m = this;
                                                            aoInt2 = (n20 = 3);
                                                            break;
                                                        }
                                                        default: {
                                                            break Label_2673;
                                                        }
                                                    }
                                                    n10 = n20;
                                                    m.aoInt = aoInt2;
                                                }
                                            }
                                            i.crtStagePlayerLayer[n19][l] = -1;
                                            this.bVoid(n19, l);
                                            i.crtStagePlayerLayer[n19][l] = 30;
                                            i.cByteArrArr[n19][l] = 24;
                                            i.bIntArrArr[n19][l] = 4;
                                            this.playSound(14);
                                        }
                                    }
                                }
                            }
                            if (n10 != -1) {
                                b3.setAnimation(n10);
                                break;
                            }
                            b4 = b3;
                        }
                        b4.tick();
                        break;
                    }
                    case 4: {
                        if (this.aoInt == 5) {
                            if (this.ZBoolean) {
                                break;
                            }
                            this.ZBoolean = true;
                        }
                        final b_SpriteAnimator b5 = i.aClassbArr[5];
                        ++this.apInt;
                        int n21 = -1;
                        final b_SpriteAnimator b6 = i.aClassbArr[4];
                        int n22 = -1;
                        final int dInt = this.dInt();
                        if (i.crtStagePlayerLayer[this.PInt][2] == -1) {
                            i.crtStagePlayerLayer[this.PInt][2] = 31;
                        }
                        if (i.crtStagePlayerLayer[this.QInt][2] == -1) {
                            i.crtStagePlayerLayer[this.QInt][2] = 31;
                        }
                        switch (this.aoInt) {
                            case 0: {
                                if (this.crtPlayerX >= 10) {
                                    this.aoInt = 6;
                                    this.apInt = 0;
                                    break;
                                }
                                break;
                            }
                            case 6: {
                                if (this.apInt > 10) {
                                    this.aoInt = 1;
                                    n21 = 2;
                                    this.apInt = 0;
                                    break;
                                }
                                break;
                            }
                            case 1: {
                                if (this.apInt > 40) {
                                    this.aoInt = 2;
                                    this.apInt = 0;
                                    break;
                                }
                                if (this.apInt > 20) {
                                    this.bBoolean(dInt, 8);
                                    hVoid(dInt, 8);
                                    this.MInt = dInt;
                                    this.NInt = 8;
                                    break;
                                }
                                break;
                            }
                            case 7: {
                                gVoid(this.MInt, this.NInt);
                                this.MInt = -1;
                                this.NInt = -1;
                                if (this.apInt > 80) {
                                    this.aoInt = 8;
                                    this.alVoid();
                                }
                                if ((this.apInt & 0x6F) == 0x1) {
                                    this.playSound(7);
                                    break;
                                }
                                break;
                            }
                            case 3: {
                                if (this.apInt <= 40) {
                                    break;
                                }
                                if (this.aqInt <= 0) {
                                    this.aoInt = 7;
                                    this.apInt = 0;
                                    break;
                                }
                                if (this.SInt == 10) {
                                    this.aoInt = 9;
                                    this.apInt = 0;
                                    break;
                                }
                                if (this.SInt == 2 || this.SInt == 1) {
                                    this.aoInt = 4;
                                    this.apInt = 0;
                                    n21 = 2;
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                if (this.bBoolean(dInt, 8)) {
                                    --this.aqInt;
                                    this.SInt = this.aoInt;
                                    gVoid(this.MInt, this.NInt);
                                    this.MInt = -1;
                                    this.NInt = -1;
                                    this.SInt = this.aoInt;
                                    this.aoInt = 3;
                                    n21 = 3;
                                    this.playSound(10);
                                }
                                if (this.apInt > 15 && b5.crtAnimationI != 6) {
                                    n21 = 6;
                                }
                                if (this.apInt > 30) {
                                    this.aoInt = 4;
                                    this.apInt = 0;
                                    n21 = 0;
                                    gVoid(this.MInt, this.NInt);
                                    this.MInt = -1;
                                    this.NInt = -1;
                                    break;
                                }
                                break;
                            }
                            case 4: {
                                final int n23 = (this.aqInt <= 1) ? 5 : 10;
                                Label_3392:
                                {
                                    int n24;
                                    if (this.apInt >= n23) {
                                        this.aoInt = 5;
                                        this.apInt = 0;
                                        n24 = 4;
                                    } else {
                                        if (this.apInt <= n23 >> 1 || b5.crtAnimationI == 1) {
                                            break Label_3392;
                                        }
                                        n24 = 1;
                                    }
                                    n21 = n24;
                                }
                                this.eBoolean();
                                this.abVoid();
                                break;
                            }
                            case 5: {
                                if (b5.y - 40 - b5.sprite.animationFrames[(b5.sprite.animationFirstAnimationFrameIndices[b5.crtAnimationI] + b5.crtAnimationFrame) * 5 + 3] <= 72 - this.bInt + 40) {
                                    this.TInt = 0;
                                    this.acVoid();
                                    this.aoInt = 10;
                                    this.MInt = dInt;
                                    this.NInt = 4;
                                    hVoid(this.MInt, this.NInt);
                                }
                                this.eBoolean();
                                this.abVoid();
                                break;
                            }
                            case 9: {
                                this.apInt -= 2;
                                this.abVoid();
                                if (b5.y - 40 - b5.sprite.animationFrames[(b5.sprite.animationFirstAnimationFrameIndices[b5.crtAnimationI] + b5.crtAnimationFrame) * 5 + 3] >= 240 - this.bInt + 40) {
                                    this.aoInt = 6;
                                    this.apInt = 0;
                                    final int n25;
                                    int arInt = (n25 = this.crtPlayerX - 10) / 3;
                                    if (n25 == arInt * 3 + 2) {
                                        arInt += i.aSInt % 50 / 25;
                                    }
                                    this.arInt = arInt;
                                    break;
                                }
                                break;
                            }
                            case 10: {
                                --this.apInt;
                                this.abVoid();
                                ++this.LInt;
                                if (this.LInt == 28) {
                                    n21 = 7;
                                }
                                if (this.LInt >= 50) {
                                    this.LInt = 0;
                                    this.aoInt = 11;
                                    gVoid(this.MInt, this.NInt);
                                    this.MInt = -1;
                                    this.NInt = -1;
                                    n21 = 8;
                                    n22 = 2;
                                    this.kBoolean = true;
                                    break;
                                }
                                break;
                            }
                            case 11: {
                                --this.apInt;
                                ++this.LInt;
                                if (this.LInt >= 12) {
                                    this.LInt = 0;
                                    this.aoInt = 9;
                                    n21 = 4;
                                    this.jBoolean = false;
                                    this.kBoolean = false;
                                    break;
                                }
                                if (this.jBoolean) {
                                    break;
                                }
                                final int dInt2 = this.dInt();
                                if (this.crtPlayerY == 4 && this.crtPlayerX >= dInt2 - 3 && this.crtPlayerX <= dInt2 + 4) {
                                    this.hurtHero(1, 64, (this.crtPlayerX == dInt2) ? 4 : 2);
                                    this.jBoolean = true;
                                    break;
                                }
                                break;
                            }
                        }
                        if (n21 == -1) {
                            b5.tick();
                        } else {
                            b5.setAnimation(n21);
                        }
                        if (this.kBoolean) {
                            if (n22 == -1) {
                                b6.tick();
                            } else {
                                b6.setAnimation(n22);
                            }
                        }
                        break;
                    }
                    case 5: {
                        final b_SpriteAnimator b7 = i.aClassbArr[5];
                        b_SpriteAnimator b8;
                        if (this.aoInt == 12) {
                            if (this.apInt++ > 100) {
                                this.aoInt = 15;
                                this.jVoid(11, 11);
                            } else {
                                this.aClassj.playSound(j_SoundManager.SOUND_SFX_MINE);
                            }
                            b8 = b7;
                        } else if (this.aoInt == -1) {
                            if (this.crtPlayerX * 24 >= 360) {
                                b7.setAnimation(this.aoInt = 10);
                                break;
                            }
                            break;
                        } else {
                            if (this.aoInt == 15 || this.aoInt == -1) {
                                break;
                            }
                            int n26 = -1;
                            final int n27 = this.crtPlayerX * 24 + 12;
                            final int n28 = this.crtPlayerY * 24;
                            final int n29 = this.atInt + 24;
                            if (this.aoInt == 13) {
                                n26 = 13;
                                if (n27 > n29) {
                                    this.aeBoolean = true;
                                }
                            }
                            int n30 = (this.aqInt > 0 && i.aSInt % this.aqInt == 0) ? 2 : 1;
                            if (this.aoInt == 6 || this.aoInt == 7) {
                                n30 = (((i.aSInt & 0xB) == 0x0) ? 2 : n30);
                            }
                            if (!this.adBoolean && (this.aoInt == 0 || this.aoInt == 1)) {
                                i i2;
                                int dhInt;
                                if (this.aoInt == 0) {
                                    this.dhInt = 36;
                                    this.dhInt ^= -1;
                                    i2 = this;
                                    dhInt = this.dhInt + 1;
                                } else {
                                    i2 = this;
                                    dhInt = 36;
                                }
                                i2.dhInt = dhInt;
                                if (n28 < 504 && (n27 == n29 + this.dhInt || i.aSInt % 76 == 0)) {
                                    this.adBoolean = true;
                                }
                            }
                            while (n30-- > 0) {
                                Label_5070:
                                {
                                    switch (this.aoInt) {
                                        case 13: {
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = 0);
                                                this.aeBoolean = false;
                                                break Label_5070;
                                            }
                                            if (this.aeBoolean) {
                                                b7.tick();
                                            }
                                            break Label_5070;
                                        }
                                        case 4:
                                        case 5: {
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = ((this.aoInt != 4) ? 1 : 0));
                                            }
                                            this.adBoolean = false;
                                            this.dhInt = 0;
                                            break Label_5070;
                                        }
                                        case 10:
                                        case 11: {
                                            Label_4472:
                                            {
                                                i i3;
                                                int n31;
                                                int aoInt3;
                                                if (n27 > n29 && n29 < 504) {
                                                    i3 = this;
                                                    aoInt3 = (n31 = 1);
                                                } else {
                                                    if (n27 >= n29 || n29 <= 360) {
                                                        break Label_4472;
                                                    }
                                                    i3 = this;
                                                    aoInt3 = (n31 = 0);
                                                }
                                                n26 = n31;
                                                i3.aoInt = aoInt3;
                                            }
                                            this.adBoolean = false;
                                            this.dhInt = 0;
                                            break Label_5070;
                                        }
                                        case 6: {
                                            if (n28 >= 504) {
                                                if (n27 >= n29 - 48) {
                                                    n26 = (this.aoInt = 8);
                                                    break Label_5070;
                                                }
                                                this.atInt -= 2;
                                                break Label_5070;
                                            } else {
                                                if (n29 >= 360) {
                                                    n26 = (this.aoInt = 0);
                                                }
                                                break Label_5070;
                                            }
//                                            break;
                                        }
                                        case 7: {
                                            if (n28 >= 504) {
                                                if (n27 <= n29 + 48) {
                                                    n26 = (this.aoInt = 9);
                                                    break Label_5070;
                                                }
                                                this.atInt += 2;
                                                break Label_5070;
                                            } else {
                                                if (n29 <= 504) {
                                                    n26 = (this.aoInt = 1);
                                                }
                                                break Label_5070;
                                            }
//                                            break;
                                        }
                                        case 0: {
                                            if (n28 >= 504 && n29 > 360) {
                                                if (n27 < n29) {
                                                    n26 = (this.aoInt = 6);
                                                    break Label_5070;
                                                }
                                                --this.atInt;
                                                break Label_5070;
                                            } else {
                                                if (this.adBoolean) {
                                                    n26 = (this.aoInt = 2);
                                                    break Label_5070;
                                                }
                                                if (n29 <= 360) {
                                                    n26 = (this.aoInt = 1);
                                                    break Label_5070;
                                                }
                                                --this.atInt;
                                                break Label_5070;
                                            }
//                                            break;
                                        }
                                        case 1: {
                                            if (n28 >= 504 && n29 < 504) {
                                                if (n27 < n29) {
                                                    ++this.atInt;
                                                    break Label_5070;
                                                }
                                                n26 = (this.aoInt = 7);
                                                break Label_5070;
                                            } else {
                                                if (this.adBoolean) {
                                                    n26 = (this.aoInt = 3);
                                                    break Label_5070;
                                                }
                                                if (n29 >= 504) {
                                                    n26 = (this.aoInt = 0);
                                                    break Label_5070;
                                                }
                                                ++this.atInt;
                                                break Label_5070;
                                            }
//                                            break;
                                        }
                                        case 8: {
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = 10);
                                            }
                                            if (b7.crtAnimationFrame >= 4 && n28 >= 504 && n27 >= n29 - 48 && n27 <= n29) {
                                                break;
                                            }
                                            break Label_5070;
                                        }
                                        case 9: {
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = 11);
                                            }
                                            if (b7.crtAnimationFrame >= 4 && n28 >= 504 && n27 >= n29 && n27 <= n29 + 48) {
                                                break;
                                            }
                                            break Label_5070;
                                        }
                                        case 3: {
                                            if (b7.crtAnimationFrame == 5 && b7.crtTime == 0) {
                                                this.bjInt = 30;
                                            }
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = 11);
                                                this.adBoolean = false;
                                                this.dhInt = 0;
                                            }
                                            if (b7.crtAnimationFrame >= 7 && n28 < 504 && n27 == n29 + this.dhInt) {
                                                break;
                                            }
                                            break Label_5070;
                                        }
                                        case 2: {
                                            if (b7.crtAnimationFrame == 5 && b7.crtTime == 0) {
                                                this.bjInt = 30;
                                            }
                                            if (b7.animationEnded()) {
                                                n26 = (this.aoInt = 10);
                                                this.adBoolean = false;
                                                this.dhInt = 0;
                                            }
                                            if (b7.crtAnimationFrame >= 7 && n28 < 504 && n27 == n29 + this.dhInt) {
                                                break;
                                            }
                                            break Label_5070;
                                        }
                                    }
                                    this.hurtHero(1, 48, 0);
                                }
                                if (n28 >= 504 && n27 >= n29 - 24 && n27 <= n29 - 24) {
                                    this.hurtHero(1, 48, (int) i.hByteArr[this.kInt & 0x7]);
                                }
                            }
                            if ((this.aoInt == 8 || this.aoInt == 9) && b7.crtAnimationFrame == 5) {
                                this.acVoid();
                            }
                            if (this.aoInt != 6 && this.aoInt != 7) {
                                for (int n32 = 21; n32 < 23; ++n32) {
                                    for (int n33 = n29 / 24 - 1; n33 < n29 / 24 - 2 + 4; ++n33) {
                                        if (i.crtStagePlayerLayer[n33][n32] == 0) {
                                            Label_5328:
                                            {
                                                if ((i.bIntArrArr[n33][n32] & 0x7) == 0x3 && this.aoInt != 13) {
                                                    --this.aqInt;
                                                    i i4 = null;
                                                    int n34 = 0;
                                                    int aoInt4 = 0;
                                                    switch (this.aoInt) {
                                                        case 0:
                                                        case 2:
                                                        case 4:
                                                        case 8:
                                                        case 10: {
                                                            i4 = this;
                                                            aoInt4 = (n34 = 4);
                                                            break;
                                                        }
                                                        case 1:
                                                        case 3:
                                                        case 5:
                                                        case 9:
                                                        case 11: {
                                                            i4 = this;
                                                            aoInt4 = (n34 = 5);
                                                            break;
                                                        }
                                                        default: {
                                                            break Label_5328;
                                                        }
                                                    }
                                                    n26 = n34;
                                                    i4.aoInt = aoInt4;
                                                }
                                            }
                                            i.crtStagePlayerLayer[n33][n32] = -1;
                                            this.bVoid(n33, n32);
                                            i.crtStagePlayerLayer[n33][n32] = 30;
                                            i.cByteArrArr[n33][n32] = 24;
                                            i.bIntArrArr[n33][n32] = 4;
                                            this.playSound(14);
                                        }
                                    }
                                }
                            }
                            if (this.aqInt <= 0) {
                                this.aoInt = 12;
                                this.apInt = 0;
                                n26 = 12;
                            }
                            if (n26 != -1) {
                                b7.setAnimation(n26);
                                break;
                            }
                            b8 = b7;
                        }
                        b8.tick();
                        break;
                    }
                }
            }
            if (i.bByte != 1) {
                return;
            }
        }
        if ((i.aSInt & 0xF) == 0x0) {
            this.aaVoid();
        }
        if (this.cfInt != 0 && (i.aSInt >> 1 & 0x1) == 0x0) {
            this.ceInt += this.cfInt;
            if (this.ceInt == 0 || this.ceInt == 9) {
                this.cfInt = 0;
                for (int n35 = 1; n35 < this.crtStageHeight - 1; ++n35) {
                    for (int n36 = 1; n36 < this.crtStageWidth - 1; ++n36) {
                        final int n37 = i.crtStageForegrondLayer[n36][n35] & 0xFF;
                        final byte b9 = i.crtStagePlayerLayer[n36][n35];
                        if (n37 == 15 || n37 == 16 || b9 == 34 || b9 == 35) {
                            this.cVoid(n36, n35);
                        }
                    }
                }
            } else if (this.ceInt == 5) {
                final int n38 = this.crtStageHeight - 1;
                final int n39 = this.crtStageWidth - 1;
                for (int n40 = 1; n40 < n38; ++n40) {
                    for (int n41 = 1; n41 < n39; ++n41) {
                        final int n42 = i.crtStageForegrondLayer[n41][n40] & 0xFF;
                        final byte b10 = i.crtStagePlayerLayer[n41][n40];
                        boolean b11 = false;
                        Label_5786:
                        {
                            if (n42 == 15) {
                                this.dVoid(n41, n40);
                                i.crtStagePlayerLayer[n41][n40] = 34;
                            } else if (n42 == 16) {
                                this.dVoid(n41, n40);
                                i.crtStagePlayerLayer[n41][n40] = 35;
                            } else {
                                int[] array2;
                                int n43;
                                int n44;
                                if (b10 == 34) {
                                    array2 = i.crtStageForegrondLayer[n41];
                                    n43 = n40;
                                    n44 = 15;
                                } else {
                                    if (b10 != 35) {
                                        break Label_5786;
                                    }
                                    array2 = i.crtStageForegrondLayer[n41];
                                    n43 = n40;
                                    n44 = 16;
                                }
                                array2[n43] = n44;
                                i.crtStagePlayerLayer[n41][n40] = -1;
                                this.lVoid(n41, n40);
                            }
                            b11 = true;
                        }
                        if (b11) {
                            kVoid(n41, n40);
                        }
                    }
                }
            }
        }
        --this.bLong;
        if (this.aWInt > 0 && --this.aWInt == 0) {
            this.XVoid();
        }
        if (this.jInt <= 0 && this.shouldSaveCheckpoint) {
            this.shouldSaveCheckpoint = false;
            this.playSound(9);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
            }
            this.saveCheckpoint();
        }
        if (i.aClassfArr[11] != null) {
            final int n45;
            i i5;
            int anInt;
            if ((n45 = i.aSInt % 89) < 15) {
                i5 = this;
                anInt = 0;
            } else if (n45 < 45) {
                i5 = this;
                anInt = 48 * (n45 - 15) / 30;
            } else if (n45 < 60) {
                i5 = this;
                anInt = 48;
            } else {
                i5 = this;
                anInt = 48 - 48 * (n45 - 60) / 30;
            }
            i5.aNInt = anInt;
            this.aOInt = ((this.aNInt > 0) ? ((this.aNInt - 1) / 24 + 2) : 1);
            final int n46;
            i i6;
            int apInt;
            if ((n46 = i.aSInt % 44) < 7) {
                i6 = this;
                apInt = 0;
            } else if (n46 < 22) {
                i6 = this;
                apInt = 48 * (n46 - 7) / 15;
            } else if (n46 < 30) {
                i6 = this;
                apInt = 48;
            } else {
                i6 = this;
                apInt = 48 - 48 * (n46 - 30) / 15;
            }
            i6.aPInt = apInt;
            this.aQInt = ((this.aPInt > 0) ? ((this.aPInt - 1) / 24 + 2) : 1);
        }
        if (this.biInt != 0 && this.bgInt != 0) {
            this.ZVoid();
        }
        this.ahVoid();
        if (this.awInt > 0) {
            this.VVoid();
        }
        this.asVoid();
        if (this.clInt != 0) {
            this.agVoid();
        }
        if (this.aClassc != null) {
            this.axInt = 70;
            if (this.aClassc.aBoolean() && this.aClassc.bByteArr() == null) {
                this.aClassc = null;
            }
            if (this.aClassc != null) {
                this.aClassc.bVoid();
            }
        } else if (this.bmInt != -1) {
            this.kVoid(this.bmInt);
            this.bmInt = -1;
            this.aByte = 0;
        }
        Label_7749:
        {
            i i8;
            int jInt;
            if (this.aTInt > 0) {
                if (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY] < 0) {
                    i i7;
                    int n47;
                    int n48;
                    if (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY + 1] == 9 && (i.bIntArrArr[this.crtPlayerX][this.crtPlayerY + 1] & 0x7) == 0x3) {
                        ++this.crtPlayerY;
                        i7 = this;
                        n47 = (this.kInt & 0xFFFFFFF8);
                        n48 = 3;
                    } else if (i.crtStagePlayerLayer[this.crtPlayerX - 1][this.crtPlayerY + 1] == 9 && (i.bIntArrArr[this.crtPlayerX - 1][this.crtPlayerY + 1] & 0x7) == 0x3) {
                        ++this.crtPlayerY;
                        --this.crtPlayerX;
                        i7 = this;
                        n47 = (this.kInt & 0xFFFFFFF8);
                        n48 = 3;
                    } else if (i.crtStagePlayerLayer[this.crtPlayerX + 1][this.crtPlayerY + 1] == 9 && (i.bIntArrArr[this.crtPlayerX + 1][this.crtPlayerY + 1] & 0x7) == 0x3) {
                        ++this.crtPlayerY;
                        ++this.crtPlayerX;
                        i7 = this;
                        n47 = (this.kInt & 0xFFFFFFF8);
                        n48 = 3;
                    } else {
                        i7 = this;
                        n47 = (this.kInt & 0xFFFFFFF8);
                        n48 = 0;
                    }
                    i7.kInt = (n47 | n48);
                }
                i8 = this;
                jInt = i.bByteArrArr[this.crtPlayerX][this.crtPlayerY];
            } else if ((this.lByte == 0 || (this.jInt <= 0 && this.lByte != 5)) && !this.xBoolean && (this.kInt & 0x70) == 0x0 && this.aFInt == -1) {
                this.lByte = this.aByte;
                boolean aBoolean = false;
                if (this.ayInt > 0) {
                    this.lByte = 2;
                    --this.ayInt;
                    if (this.ayInt == 0) {
                        this.doorHeadClose(this.crtPlayerX - 1, this.crtPlayerY);
                        this.aByte = 0;
                        i.keysPressed = 0;
                    }
                } else if (b) {
                    kVoid(this.crtPlayerX, this.crtPlayerY);
                }
                switch (this.lByte) {
                    case 3: {
                        this.kInt &= 0xFFFFFFF7;
                    }
                    case 1:
                    case 2:
                    case 4: {
                        if (i.aClassbArr[0].crtAnimationI == 40 || i.aClassbArr[0].crtAnimationI == 48) {
                            break;
                        }
                        if ((this.kInt & 0x1000) != 0x0) {
                            this.kInt = ((this.kInt & 0xFFFFFFF8) | this.lByte);
                            this.jInt = 18;
                            int n49;
                            if ((n49 = this.lByte - 1) < 0) {
                                n49 = 0;
                            }
                            this.gVoid(n49 + 0);
                            break;
                        }
                        aBoolean = this.aBoolean(-i.gByteArr[this.lByte], -i.gByteArr[this.lByte + 8], false);
                        b = this.isPlayerWithinStageBounds();
                        if (!aBoolean) {
                            break;
                        }
                        this.lInt = 40;
                        this.cBoolean = false;
                        int n50;
                        if ((n50 = this.lByte - 1) < 0) {
                            n50 = 0;
                        }
                        if ((this.kInt & 0x8) == 0x0) {
                            this.gVoid(n50 + 4);
                            break;
                        }
                        if (this.lByte == 2) {
                            this.gVoid(8);
                            break;
                        }
                        this.gVoid(9);
                        break;
                    }
                    case 6: {
                        final int n51 = ((this.kInt & 0x7) == 0x2) ? 1 : -1;
                        if (b && i.crtStagePlayerLayer[this.crtPlayerX + n51][this.crtPlayerY] < 0) {
                            this.gVoid((n51 == -1) ? 22 : 20);
                            i.crtStagePlayerLayer[this.crtPlayerX + n51][this.crtPlayerY] = 32;
                            i.bByteArrArr[this.crtPlayerX + n51][this.crtPlayerY] = 18;
                            i.bIntArrArr[this.crtPlayerX + n51][this.crtPlayerY] = (0x4 | ((n51 > 0) ? 1 : 0));
                            i.cByteArrArr[this.crtPlayerX + n51][this.crtPlayerY] = 30;
                            this.jInt = 72;
                            this.aByte = 0;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        this.jInt = 0;
                        final int n52 = this.kInt & 0x7;
                        if (this.isPlayerWithinStageBounds()) {
                            this.gVoid(n52 + 13 - 1);
                            break;
                        }
                        break;
                    }
                    case 0: {
                        this.kInt &= 0xFFFFFFF7;
                        boolean b12 = false;
                        System.out.println(i.aClassbArr[0]);
                        switch (i.aClassbArr[0].crtAnimationI) {
                            case 0:
                            case 2:
                            case 10:
                            case 11:
                            case 12:
                            case 34:
                            case 35:
                            case 40:
                            case 48: {
                                break;
                            }
                            default: {
                                if ((this.kInt & 0x4000) == 0x0) {
                                    b12 = true;
                                    break;
                                }
                                break;
                            }
                        }
                        if (b12) {
                            int n53;
                            if ((n53 = 0 + (this.kInt & 0x7) - 1) < 0) {
                                n53 = 0;
                            }
                            this.gVoid(n53);
                        }
                        i i9;
                        int axInt;
                        if (this.aClassc == null) {
                            i9 = this;
                            axInt = 6;
                        } else {
                            i9 = this;
                            axInt = 0;
                        }
                        i9.aXInt = axInt;
                        if (this.jInt > 0) {
                            this.jInt -= 6;
                            break;
                        }
                        break;
                    }
                }
                if (b) {
                    final byte b13 = i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY - 1];
                    if (!aBoolean && this.lByte != 5 && this.jInt <= 0 && (b13 == 0 || b13 == 9 || b13 == 8 || b13 == 48) && (i.crtStageForegrondLayer[this.crtPlayerX][this.crtPlayerY] & 0xFF) != 0x23) {
                        int aInt = 0;
                        if (i.eIntArrArr != null) {
                            aInt = aInt(i.eIntArrArr[this.crtPlayerX][this.crtPlayerY], (byte) 0, (byte) 3, (byte) 4);
                        }
                        if (!this.lBoolean || (aInt == 0 && aInt != 3)) {
                            if ((this.kInt & 0x8) == 0x0 && i.aClassbArr[0].crtAnimationI != 11 && i.aClassbArr[0].crtAnimationI != 10 && i.aClassbArr[0].crtAnimationI != 12) {
                                this.gVoid(11);
                            }
                            this.cBoolean = true;
                            if (this.lInt <= 0) {
                                this.lInt = 40;
                                this.bLong = 0L;
                                this.hurtHero(i.iByteArr[8], 32, 0);
                                return;
                            }
                        }
                    }
                }
                if (aBoolean) {
                    this.yBoolean = false;
                    break Label_7749;
                }
                if (!b || (i.aSInt & 0x1F) != 0x0) {
                    break Label_7749;
                }
                boolean b14 = i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY - 1] == 0;
                for (int n54 = 1; !b14 && n54 <= 4; b14 |= this.aBoolean(i.gByteArr[n54], i.gByteArr[n54 + 8], true), ++n54) {
                }
                if (b14) {
                    break Label_7749;
                }
                if (this.yBoolean) {
                    this.gVoid(19);
                    break Label_7749;
                }
                this.yBoolean = true;
                break Label_7749;
            } else {
                if (this.xBoolean && this.jInt <= 0) {
                    i i10;
                    byte lByte;
                    if (this.atBoolean) {
                        i10 = this;
                        lByte = this.pByte;
                    } else {
                        i10 = this;
                        lByte = this.qByte;
                    }
                    i10.lByte = lByte;
                    this.kInt = ((this.kInt & 0xFFFFFFF8) | this.lByte);
                    this.crtPlayerX -= i.gByteArr[this.lByte];
                    this.crtPlayerY -= i.gByteArr[this.lByte + 8];
                    b = this.isPlayerWithinStageBounds();
                    this.jInt = 18;
                    if (i.aClassbArr[0].crtAnimationI != 4) {
                        this.gVoid(4 + this.lByte - 1);
                    }
                }
                if ((this.kInt & 0x70) > 32 && (this.kInt & 0x800) == 0x0) {
                    break Label_7749;
                }
                this.jInt -= 6;
                if (this.jInt > 0) {
                    break Label_7749;
                }
                this.kInt &= 0xFFFFEF8F;
                i8 = this;
                jInt = 0;
            }
            i8.jInt = jInt;
        }
        if (this.clInt == 0) {
            if (this.EBoolean) {
                this.ckInt = 8;
                if (this.gBoolean()) {
                    this.cVoid(this.bSInt, this.bTInt, 5);
                    this.EBoolean = false;
                }
            } else if (this.aClassc == null) {
                if (i.akBoolean && this.lByte != 0) {
                    i.akBoolean = false;
                    this.axInt = 0;
                }
                if (!i.akBoolean) {
                    this.aVoid();
                }
            } else {
                this.aInt = this.cInt;
                this.bInt = this.dInt;
            }
        }
        if (this.lByte != 0 && b) {
            this.nBoolean = (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY + 1] >= 0);
        }
        this.YVoid();
        if (this.xBoolean && (this.crtPlayerX < -5 || this.crtPlayerX > this.crtStageWidth + 5 || this.crtPlayerY < -5 || this.crtPlayerY > this.crtStageHeight + 5)) {
            this.oVoid();
            i i11;
            boolean b15;
            if (this.atBoolean || this.crtStageI >= this.dKInt) {
                this.bsInt = 0;
                this.brInt = 12;
                i.bByte = 35;
                i11 = this;
                b15 = false;
            } else {
                i.bByte = 20;
                this.bsInt = 0;
                this.WVoid();
                this.zVoid();
                eInt(6, this.bbInt);
                i11 = this;
                b15 = true;
            }
            i11.cVoid(b15);
            this.uVoid();
            this.eVoid();
            this.aRInt = -1;
        }
    }

    private static byte aByte(int n, final int n2, final int n3, final int n4) {
        int n5 = n + n2;
        if (((n > 0 && n3 == 0) || (n < n3 && n3 > 0)) && (i.crtStagePlayerLayer[n5][n4] < 0 || i.crtStagePlayerLayer[n5][n4] == 31 || dInt(n5, n4) >= 0)) {
            do {
                n = n5;
                n5 += n2;
            } while (((n > 0 && n3 == 0) || (n < n3 && n3 > 0)) && (i.crtStagePlayerLayer[n5][n4] < 0 || dInt(n5, n4) >= 0 || i.crtStagePlayerLayer[n5][n4] == 31));
        }
        return (byte) n;
    }

    private void VVoid() {
        final int n = this.crtStageWidth - 1;
        for (int iInteger = 0; iInteger < i.eByteArr.length; iInteger += 3) {
            final byte b;
            if ((b = i.eByteArr[iInteger + 2]) > 0) {
                final byte b2 = i.eByteArr[iInteger + 1];
                final byte b3 = i.eByteArr[iInteger];
                final byte[] eByteArr = i.eByteArr;
                final int n2 = iInteger;
                final byte aByte = aByte(b3, -1, 0, b);
                eByteArr[n2] = aByte;
                final byte b4 = aByte;
                final byte[] eByteArr2 = i.eByteArr;
                final int n3 = iInteger + 1;
                final byte aByte2 = aByte(b2, 1, n, b);
                eByteArr2[n3] = aByte2;
                for (byte b5 = aByte2, b6 = b4; b6 <= b5; ++b6) {
                    this.aBoolean(b6, b);
                }
            }
        }
    }

    private boolean aBoolean(final int x, final int y) {
        final int dInt = dInt(x, y);
        int n3 = 0;
        if (dInt >= 0) {
            if (dInt == 37 && i.crtStagePlayerLayer[x][y] == 43) n3 = 268435456;
            kVoid(x, y);
            i.crtStagePlayerLayer[x][y] = 9;
            i.bIntArrArr[x][y] = ((i.bIntArrArr[x][y] & 0xF03FFFFF) | dInt << 22 | n3);
            this.cVoid(x, y, 1);
        }
        final b_SpriteAnimator b = i.aClassbArr[((this.kInt & 0x4000) == 0x0) ? 0 : 3];
        if (this.isPlayerAtPosition(x, y) && this.aTInt <= 0 && b.crtAnimationI != 40 && b.crtAnimationI != 48 && b.crtAnimationI != 47) {
            this.hurtHero(0, 16, 0);
        }
        return dInt >= 0;
    }

    private static int dInt(final int x, final int y) {
        if (i.crtStagePlayerLayer[x][y] < 0) return -1;
        switch (i.crtStagePlayerLayer[x][y]) {
            case 1: return 34; // Violet gem
            case 45: return 35; // Monkey
            case 19:
            case 43: return 37; // Any snake
            case 46: return 36; // Wasp
            case 49: return 39; // Turtle
            default: return -1;
        }
    }

    public static int unpackUint16(final byte[] array, final int ptr) {
        return (array[ptr] & 0xFF) | (array[ptr + 1] & 0xFF) << 8;
    }

    public static int unpackUint32(final byte[] array, final int ptr) {
        return (array[ptr] & 0xFF) | (array[ptr + 1] & 0xFF) << 8 | (array[ptr + 2] & 0xFF) << 16 | (array[ptr + 3] & 0xFF) << 24;
    }

    private static int eInt(final int ptr, int uint16) {
        uint16 += unpackUint16(i.iByteArr, ptr);
        if (uint16 < 0) uint16 = 0;
        i.iByteArr[ptr] = (byte) uint16;
        i.iByteArr[ptr + 1] = (byte) (uint16 >> 8);
        return uint16;
    }

    private void WVoid() {
        for (int iInteger = 0; iInteger < this.aiInt; ++iInteger) {
            this.aVoid(this.crtWorldIndex, this.crtStageI, i.dByteArr[iInteger << 1] & 0xFF, i.dByteArr[(iInteger << 1) + 1] & 0xFF);
        }
    }

    private int bInt() {
        return eInt(4, this.aZInt);
    }

    private void cVoid(final int n, final int n2, final int n3) {
        final int n4 = this.aeInt << 1;
        i.aByteArr[n4] = (byte) n;
        i.aByteArr[n4 + 1] = (byte) n2;
        i.cByteArr[this.aeInt] = (byte) n3;
        i.bByteArr[this.aeInt] = 0;
        this.aeInt = (this.aeInt + 1 & 0x7);
    }

    private void XVoid() {
        --this.azInt;
        ++this.bdInt;
        if (this.azInt >= 0) {
            this.restoreCheckpoint();
            this.nByte = i.iByteArr[8];
            this.oBoolean = true;
            this.kInt = 0;
            this.aTInt = 0;
            final byte b = 0;
            this.lByte = b;
            this.aByte = b;
            return;
        }
        i.bByte = 12;
    }

    private void hVoid(int doorI) {
        if (doorI < 0) return;
        final byte x = i.crtStageDoorXs[doorI];
        final byte y = i.crtStageDoorYs[doorI];
        final int n2 = i.crtStageForegrondLayer[x][y] & 0xFF;
        final int n3 = i.crtStageForegrondLayer[x][y] >> 8;
        if ((n3 & 0xF0) != 0x0) return;
        if (n2 != 7 || (n3 >> 8 & 0xFF) != doorI) System.out.println("!!!!!!!!!!!!!! door missing");
        doorI = (n3 & 0xF);
        int n4;
        if (--doorI == 0) {
            n4 = ((n3 & 0xFFFFFF0F) | 0x10);
            this.aVoid(x, y - 1, 1, 0, 1);
            this.aVoid(x, y - 1, -1, 0, 1);
            doorI = (i.crtStageForegrondLayer[x][y - 1] >> 8 | 0x200);
            i.crtStageForegrondLayer[x][y - 1] = (doorI << 8 | (i.crtStageForegrondLayer[x][y - 1] & 0xFF));
            i.cByteArrArr[x][y] = 24;
        } else {
            n4 = ((n3 & 0xFFFFFFF0) | doorI);
        }
        i.crtStageForegrondLayer[x][y] = (n4 << 8 | n2);
        this.playSound(8);
    }

    private void doorHeadClose(final int x, final int y) {
        try {
            final int n3 = i.crtStageForegrondLayer[x][y] >> 8;
            if ((i.crtStageForegrondLayer[x][y] & 0xFF) != 0x7) return; // Not door bottom
            if ((n3 & 0xF0) == 0x0) return;
            if (i.crtStagePlayerLayer[x][y] == 32) return;

            this.playSound(14);
            i.crtStageForegrondLayer[x][y] = ((n3 & 0xFFFFFF0F) << 8 | 0x7);
            this.aVoid(x, y - 1, 1, 0, 0);
            this.aVoid(x, y - 1, -1, 0, 0);

            if (this.isPlayerAtPosition(x, y)) {
                this.bLong = 0L;
                this.biInt = 0;
                this.hurtHero(i.iByteArr[8], 48, 0);
                this.playSound(2);
            } else {
                switch (i.crtStagePlayerLayer[x][y]) {
                    case 0: // Boulder
                    case 1: // Violet gem
                    case 19: // Green snake
                    case 43: // Red snake
                    case 45: // Monkey
                    {
                        i.crtStagePlayerLayer[x][y] = -1;
                        this.bVoid(x, y);
                        this.jVoid(x, y);
                        break;
                    }
                }
            }
            i.cByteArrArr[x][y] = 24;
        } catch (Exception ex) {
        }
    }

    private void doorHeadClose(final int doorI) {
        if (doorI < 0) return;
        try {
            this.doorHeadClose(i.crtStageDoorXs[doorI], i.crtStageDoorYs[doorI]);
        } catch (Exception ex) {
        }
    }

    /**
     * Maybe does something with the hero on fire animation and the hero sprite?
     */
    private void YVoid() {
        final int n = ((this.kInt & 0x4000) == 0x0) ? 0 : 3;
        final b_SpriteAnimator b = i.aClassbArr[n];
        int n2 = -1;
        boolean b2 = true;
        boolean b3 = false;
        final boolean a;
        if (a = b.animationEnded()) {
            this.kInt &= 0xFFFFDFFF;
        }
        Label_3151:
        {
            int n3 = 0;
            Label_3150:
            {
                if (n == 3) {
                    if (!a) {
                        break Label_3151;
                    }
                    this.kInt &= 0xFFFFB7FF;
                    n3 = this.cInt();
                } else {
                    int n4 = 0;
                    switch (b.crtAnimationI) {
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46: {
                            if (a) {
                                n2 = 0 + (this.kInt & 0x7) - 1;
                                final byte b4 = 0;
                                this.aByte = b4;
                                this.lByte = b4;
                                this.jInt = 0;
                                i.keysPressed = 0;
                            }
                            break Label_3151;
                        }
                        case 1:
                        case 3: {
                            if (a) {
                                n2 = 0 + (this.kInt & 0x7) - 1;
                            }
                            b3 = true;
                            break Label_3151;
                        }
                        case 36:
                        case 37:
                        case 38:
                        case 39: {
                            n4 = 4;
                            break;
                        }
                        case 47: {
                            this.jInt = 0;
                            final byte b5 = 0;
                            this.lByte = b5;
                            this.aByte = b5;
                            if ((i.aSInt & 0x1) == 0x0) {
                                int n5 = this.crtPlayerX - 2 + i.aSInt % 5;
                                final int n6 = this.crtPlayerY - 2 + i.aSInt % 3;
                                if (n5 == this.crtPlayerX && (n6 == this.crtPlayerY || n6 == this.crtPlayerY - 1)) {
                                    n5 += (((i.aSInt >> 1 & 0x1) == 0x0) ? 1 : -1);
                                }
                                this.cVoid(n5, n6, i.aSInt * 3 % 5);
                            }
                            if (a) {
                                n2 = 0 + (this.kInt & 0x7) - 1;
                                final int afInt = -1;
                                this.aHInt = afInt;
                                this.aGInt = afInt;
                                this.aFInt = afInt;
                            }
                            break Label_3151;
                        }
                        case 40:
                        case 48: {
                            this.jInt = 0;
                            final byte b6 = 0;
                            this.lByte = b6;
                            this.aByte = b6;
                            if (b.crtTime == 0) {
                                if (b.crtAnimationFrame == ((b.crtAnimationI == 40) ? 12 : 6)) {
                                    this.playSound(4);
                                }
                                if (b.crtAnimationFrame == ((b.crtAnimationI == 40) ? 13 : 6)) {
                                    boolean b7 = false;
                                    int n7 = -1;
                                    boolean b8 = false;
                                    switch (this.aIInt) {
                                        case 26: {
                                            b7 = true;
                                            this.bmInt = 25;
                                            b8 = true;
                                            break;
                                        }
                                        case 24: {
                                            b8 = true;
                                            b7 = true;
                                            this.bmInt = 22;
                                            break;
                                        }
                                        case 27: {
                                            b8 = true;
                                            b7 = true;
                                            this.bmInt = 23;
                                            break;
                                        }
                                        case 40: {
                                            b8 = true;
                                            b7 = true;
                                            this.bmInt = 24;
                                            break;
                                        }
                                        case 42: {
                                            b8 = true;
                                            b7 = true;
                                            this.pBoolean = true;
                                            this.bmInt = 11;
                                            break;
                                        }
                                        case 41: {
                                            if (this.fBoolean()) {
                                                this.ajBoolean = true;
                                                this.eVoid();
                                            }
                                            this.aZInt += this.aHInt;
                                            this.aaInt -= this.aHInt;
                                            if (this.aaInt <= 0 && !this.fBoolean()) {
                                                i.crtStagePlayerLayer[this.abInt][this.acInt] = -1;
                                                this.aaInt = 0;
                                            }
                                            n7 = 3;
                                            break;
                                        }
                                        case 4: {
                                            n7 = 2;
                                            ++this.aUInt;
                                            break;
                                        }
                                        case 5: {
                                            ++this.aVInt;
                                            n7 = 1;
                                            break;
                                        }
                                        case 2: {
                                            ++this.bbInt;
                                            b8 = true;
                                            n7 = 0;
                                            break;
                                        }
                                        case 6: {
                                            ++this.azInt;
                                            i.eByteArrArr[this.crtPlayerX][this.crtPlayerY] = -1;
                                            final int[] array = i.dIntArrArr[this.crtPlayerX];
                                            final int iInt = this.crtPlayerY;
                                            array[iInt] |= 0x100;
                                            n7 = 0;
                                            this.aVoid(this.crtWorldIndex, this.crtStageI, this.crtPlayerX, this.crtPlayerY);
                                            break;
                                        }
                                        case 7: {
                                            this.aVoid((byte) 127);
                                            n7 = 4;
                                            break;
                                        }
                                        case 51:
                                        case 52:
                                        case 53: {
                                            this.aVoid(this.crtWorldIndex, this.crtStageI, this.crtPlayerX, this.crtPlayerY);
                                            n7 = 0;
                                            b7 = true;
                                            this.eVoid();
                                            this.hBoolean = true;
                                            i i;
                                            int dInt;
                                            if (this.aIInt == 53) {
                                                i = this;
                                                dInt = 0;
                                            } else if (this.aIInt == 51) {
                                                i = this;
                                                dInt = 1;
                                            } else {
                                                i = this;
                                                dInt = 2;
                                            }
                                            i.DInt = dInt;
                                            final byte[] iByteArr = i.iByteArr;
                                            final int n8 = 2;
                                            iByteArr[n8] |= (byte) (1 << this.DInt);
                                            this.uVoid();
                                            break;
                                        }
                                    }
                                    if (b7) {
                                        this.gVoid(47);
                                    }
                                    if (n7 != -1) {
                                        this.cVoid(this.crtPlayerX, this.crtPlayerY - 1, n7);
                                    }
                                    if (b8) {
                                        i.dByteArr[this.aiInt << 1] = (byte) this.crtPlayerX;
                                        i.dByteArr[(this.aiInt << 1) + 1] = (byte) this.crtPlayerY;
                                        ++this.aiInt;
                                    }
                                    this.oBoolean = true;
                                    this.aIInt = -1;
                                }
                            }
                            if (b.animationEnded()) {
                                this.iLong = System.currentTimeMillis();
                                n2 = 0 + (this.kInt & 0x7) - 1;
                                final int afInt2 = -1;
                                this.aHInt = afInt2;
                                this.aGInt = afInt2;
                                this.aFInt = afInt2;
                            }
                            break Label_3151;
                        }
                        case 35: {
                            b3 = true;
                            n3 = 35;
                            break Label_3150;
                        }
                        case 34: {
                            b3 = true;
                            n3 = 34;
                            break Label_3150;
                        }
                        case 0: {
                            b3 = true;
                            n3 = 0;
                            break Label_3150;
                        }
                        case 2: {
                            b3 = true;
                            n3 = 2;
                            break Label_3150;
                        }
                        case 9: {
                            if (!this.nBoolean) {
                                n3 = 27;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 8: {
                            if (!this.nBoolean) {
                                n3 = 26;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 27: {
                            if (!this.nBoolean) {
                                n3 = 9;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 26: {
                            if (!this.nBoolean) {
                                n3 = 8;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 4:
                        case 6: {
                            if (this.nBoolean) {
                                n3 = b.crtAnimationI;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 5: {
                            if (!this.nBoolean) {
                                n3 = 24;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 7: {
                            if (!this.nBoolean) {
                                n3 = 25;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 24: {
                            if (this.nBoolean) {
                                n3 = 5;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 25: {
                            if (this.nBoolean) {
                                n3 = 7;
                                break Label_3150;
                            }
                            break Label_3151;
                        }
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 30:
                        case 31:
                        case 32:
                        case 33: {
                            if (a) {
                                b2 = false;
                                i.keysPressed = 0;
                            }
                            break Label_3151;
                        }
                        case 19: {
                            if (a) {
                                b2 = false;
                                this.XVoid();
                            }
                            break Label_3151;
                        }
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 28:
                        case 29: {
                            if (a) {
                                i.keysPressed = 0;
                                this.lByte = 0;
                                this.jInt = 0;
                                n4 = 0;
                                break;
                            }
                            if ((this.kInt & 0x2000) == 0x0 && b.crtAnimationFrame == 2 && b.crtTime == 0) {
                                final int n9 = this.crtPlayerX - i.gByteArr[this.kInt & 0x7];
                                final int n10 = this.crtPlayerY - i.gByteArr[(this.kInt & 0x7) + 8];
                                if (i.iByteArr[9] >= 8 && b.crtAnimationFrame == 2 && b.crtTime == 0) {
                                    this.cVoid(n9, n10, -1);
                                }
                                final int n11 = n9;
                                final byte b9 = (byte) n10;
                                final int n12 = n11;
                                final int[] array2 = {0, 1, -1, 0, 0};
                                final int[] array3 = {0, 0, 0, 1, -1};
                                int n13 = 0;
                                final boolean b10 = i.iByteArr[9] >= 8;
                                boolean b11 = false;
                                Label_2313:
                                {
                                    int dBoolean = 0;
                                    switch (i.crtStagePlayerLayer[n12][b9]) {
                                        case 9: {
                                            if ((this.kInt & 0x2000) == 0x0) {
                                                this.kInt |= 0x2000;
                                                n13 = 1;
                                                final int n14 = n12;
                                                final byte b12 = b9;
                                                final int n16;
                                                final int n15 = n16 = n14;
                                                final byte b13 = b12;
                                                final int n17 = n16;
                                                boolean b14 = false;
                                                Label_1887:
                                                {
                                                    if (i.eByteArr != null) {
                                                        for (int j = 0; j < i.eByteArr.length; j += 3) {
                                                            if (i.eByteArr[j + 2] == b13 && (i.eByteArr[j] - 1 == n17 || i.eByteArr[j + 1] + 1 == n17)) {
                                                                b14 = true;
                                                                break Label_1887;
                                                            }
                                                        }
                                                    }
                                                    b14 = false;
                                                }
                                                if (!b14) {
                                                    kVoid(n15, b12);
                                                    final int n18 = this.isPlayerAtPosition(n15, b12 - 1) ? 2 : 1;
                                                    switch ((i.bIntArrArr[n15][b12] & 0xFC00000) >> 22) {
                                                        case 39: {
                                                            i.crtStagePlayerLayer[n15][b12] = 49;
                                                            i.bIntArrArr[n15][b12] = n18;
                                                            break;
                                                        }
                                                        case 37: {
                                                            byte[] array4;
                                                            byte b15;
                                                            int n19;
                                                            if ((i.bIntArrArr[n15][b12] & 0x10000000) != 0x0) {
                                                                array4 = i.crtStagePlayerLayer[n15];
                                                                b15 = b12;
                                                                n19 = 43;
                                                            } else {
                                                                array4 = i.crtStagePlayerLayer[n15];
                                                                b15 = b12;
                                                                n19 = 19;
                                                            }
                                                            array4[b15] = (byte) n19;
                                                            i.bIntArrArr[n15][b12] = n18;
                                                            this.bVoid(19, n15, (int) b12);
                                                            break;
                                                        }
                                                        case 35: {
                                                            i.crtStagePlayerLayer[n15][b12] = 45;
                                                            i.bIntArrArr[n15][b12] = ((i.bIntArrArr[n15][b12] & 0xFFFFFFF0) | 0xA);
                                                            break;
                                                        }
                                                        case 34: {
                                                            i.crtStagePlayerLayer[n15][b12] = 1;
                                                            this.cVoid(n15, b12);
                                                            break;
                                                        }
                                                        case 36: {
                                                            i.crtStagePlayerLayer[n15][b12] = 46;
                                                            i.bIntArrArr[n15][b12] = 0;
                                                            i.bByteArrArr[n15][b12] = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break Label_2313;
                                        }
                                        case 18: {
                                            dBoolean = (this.dBoolean() ? 1 : 0);
                                            break;
                                        }
                                        case 0: {
                                            b11 = true;
                                            break Label_2313;
                                        }
                                        case 30: {
                                            n13 = 1;
                                            if (i.bIntArrArr[n12][b9] == 0) {
                                                this.playSound(11);
                                                i.bIntArrArr[n12][b9] = 1;
                                            }
                                            break Label_2313;
                                        }
                                        case 10: {
                                            if (this.xByte == 3 && i.bIntArrArr[n12][b9] <= 0) {
                                                n13 = 1;
                                                i.bIntArrArr[n12][b9] = 1;
                                                this.bVoid(n12, b9);
                                            }
                                            break Label_2313;
                                        }
                                        case 16: {
                                            n13 = 1;
                                            b11 = true;
                                            break Label_2313;
                                        }
                                        default: {
                                            if (i.crtStagePlayerLayer[n12][b9] - 80 >= 0 || ((i.crtStageForegrondLayer[n12][b9] & 0xFF) == 0x7 && (i.crtStageForegrondLayer[n12][b9] >> 8 & 0xF0) == 0x0)) {
                                                b11 = true;
                                                dBoolean = 1;
                                                break;
                                            }
                                            break Label_2313;
                                        }
                                    }
                                    n13 = dBoolean;
                                }
                                if (b11) {
                                    vibrate(200);
                                    this.playSound(6);
                                    this.gVoid(41 + (this.kInt & 0x7) - 1);
                                }
                                if (n13 == 0) {
                                    for (int k = 0; k < 5; ++k) {
                                        final int n20 = n12 + array2[k];
                                        final int n21 = b9 + array3[k];
                                        if (n20 >= 0 && n20 < this.crtStageWidth && n21 >= 0 && n21 < this.crtStageHeight) {
                                            final byte b16 = i.crtStagePlayerLayer[n20][n21];
                                            int n22 = 0;
                                            boolean b17 = false;
                                            switch (b16) {
                                                case 1: {
                                                    if (n20 == this.crtPlayerX - i.gByteArr[this.kInt & 0x7] && n21 == this.crtPlayerY - i.gByteArr[(this.kInt & 0x7) + 8]) {
                                                        b17 = true;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 19:
                                                case 43:
                                                case 45:
                                                case 46:
                                                case 49: {
                                                    final int n23;
                                                    final byte b18 = (byte) (((n23 = (i.bIntArrArr[n20][n21] & 0x7)) == 0) ? 0 : i.bByteArrArr[n20][n21]);
                                                    final boolean b19 = b16 != 49 && b16 != 46;
                                                    if (aBoolean(n12, b9, 0, 0, n20, n21, n23, b18)) {
                                                        b17 = true;
                                                        n22 = (b19 ? 1 : 0);
                                                    }
                                                    if (b17) {
                                                        this.playSound(10);
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            if (b10 && b17 && (n20 != this.crtPlayerX || n21 != this.crtPlayerY)) {
                                                if (this.aBoolean(n20, n21)) {
                                                    this.kInt |= 0x2000;
                                                }
                                            } else if (n22 != 0) {
                                                this.kInt |= 0x2000;
                                                if (b16 == 45) {
                                                    int n24;
                                                    if ((n24 = (i.bIntArrArr[n20][n21] & 0x1C00) >> 10) == 3) {
                                                        i.crtStagePlayerLayer[n20][n21] = -1;
                                                        this.jVoid(n20, n21);
                                                    } else {
                                                        ++n24;
                                                        i.bIntArrArr[n20][n21] = (0xA | n24 << 10);
                                                        i.bIntArrArr[n20][n21] = ((i.bIntArrArr[n20][n21] & 0xFFFFFF07) | 0x78);
                                                        i.bByteArrArr[n20][n21] = 0;
                                                    }
                                                } else {
                                                    this.bVoid(b16, n20, n21);
                                                }
                                            }
                                        }
                                    }
                                }
                                this.aByte = 0;
                                i.keysPressed = 0;
                            }
                            break Label_3151;
                        }
                        case 11: {
                            if (i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY - 1] == -1) {
                                n4 = 0;
                                break;
                            }
                            if (a && i.crtStagePlayerLayer[this.crtPlayerX][this.crtPlayerY - 1] != -1) {
                                this.bLong = 0L;
                                this.hurtHero(i.iByteArr[8], 32, 0);
                            }
                            break Label_3151;
                        }
                        case 17:
                        case 18: {
                            if (a) {
                                n2 = 0 + (this.kInt & 0x7) - 1;
                                this.jInt = 0;
                                break Label_3151;
                            }
                            if (b.crtAnimationFrame > 0 && this.aFInt != -1) {
                                final int n25 = ((this.kInt & 0x7) == 0x2) ? (this.crtPlayerX + 1) : (this.crtPlayerX - 1);
                                final int n26 = i.crtStageForegrondLayer[n25][this.crtPlayerY] >> 8;
                                final int n27 = i.crtStageForegrondLayer[n25][this.crtPlayerY] & 0xFF;
                                final int n28 = n26 | 0x100;
                                if (n27 == 9) {
                                    --this.aUInt;
                                } else {
                                    --this.aVInt;
                                }
                                i.crtStageForegrondLayer[n25][this.crtPlayerY] = (n28 << 8 | n27);
                                this.hVoid(n28 & 0xFF);
                                final int n29 = -1;
                                this.aHInt = n29;
                                this.aFInt = n29;
                            }
                            break Label_3151;
                        }
                        case 10: {
                            if (a) {
                                this.kInt &= 0xFFFFF7FF;
                                n3 = this.cInt();
                                break Label_3150;
                            }
                            this.bLong = 40L;
                            break Label_3151;
                        }
                        case 12: {
                            if (this.blInt < 160) {
                                this.blInt += 12;
                            }
                            break Label_3151;
                        }
                        default: {
                            n4 = 36;
                            break;
                        }
                    }
                    n3 = n4 + (this.kInt & 0x7) - 1;
                }
            }
            n2 = n3;
        }
        i l;
        int axInt;
        if (b3) {
            l = this;
            axInt = this.axInt - 1;
        } else {
            l = this;
            axInt = 70;
        }
        l.axInt = axInt;
        if (n2 != -1) {
            this.gVoid(n2);
        }
        if (b2) {
            b.tick();
        }
        this.mInt = ((this.mInt > 0) ? (--this.mInt) : 0);
    }

    private int cInt() {
        int n;
        if (this.nByte <= 0) {
            this.playSound(2);
            n = 12;
            this.aWInt = 80;
        } else {
            n = 0 + (this.kInt & 0x7) - 1;
            this.kInt &= 0xFFFFFF8F;
            this.bLong = 40L;
        }
        this.lByte = 0;
        return n;
    }

    /**
     * Vibrates the device, if enableed.
     * @param _unused Probably was used to determine the vibration duration.
     */
    private static void vibrate(final int _unused) {
        if (i.mBoolean) {
            i.aClassGloftDIRU.display.vibrate(200);
        }
    }

    private void ZVoid() {
        if (this.oByte <= 0) {
            final int n = (this.biInt > 0) ? 1 : -1;
            this.biInt -= n;
            if (this.biInt != 0) {
                if (i.crtStagePlayerLayer[this.bgInt][this.bhInt] == 48) {
                    final int n2 = this.bhInt + (((i.bIntArrArr[this.bgInt][this.bhInt] & 0x8) == 0x0) ? -1 : 1);
                    if (i.crtStagePlayerLayer[this.bgInt + n][n2] >= 0) {
                        int hInt = this.crtPlayerX;
                        while (true) {
                            final int n3 = hInt - n;
                            if (i.crtStagePlayerLayer[n3][this.crtPlayerY] != 32) {
                                break;
                            }
                            i.crtStagePlayerLayer[n3][this.crtPlayerY] = -1;
                            hInt = n3;
                        }
                        this.biInt = 0;
                        return;
                    }
                    i.crtStagePlayerLayer[this.bgInt + n][n2] = i.crtStagePlayerLayer[this.bgInt][n2];
                    i.crtStagePlayerLayer[this.bgInt][n2] = -1;
                    i.bIntArrArr[this.bgInt + n][n2] = i.bIntArrArr[this.bgInt][n2];
                    i.bByteArrArr[this.bgInt][n2] = this.oByte;
                }
                i.crtStagePlayerLayer[this.bgInt + n][this.bhInt] = i.crtStagePlayerLayer[this.bgInt][this.bhInt];
                i.crtStagePlayerLayer[this.bgInt][this.bhInt] = -1;
                this.bVoid(this.bgInt, this.bhInt);
                this.bgInt += n;
                i.bIntArrArr[this.bgInt][this.bhInt] = (this.beInt | Integer.MIN_VALUE);
                this.oByte = 18;
                i.bByteArrArr[this.bgInt][this.bhInt] = this.oByte;
            } else {
                if (i.crtStagePlayerLayer[this.bgInt][this.bhInt] == 48) {
                    i.bByteArrArr[this.bgInt][this.bhInt + (((i.bIntArrArr[this.bgInt][this.bhInt] & 0x8) == 0x0) ? -1 : 1)] = 0;
                } else {
                    i.bIntArrArr[this.bgInt][this.bhInt] = this.bfInt;
                }
                i.bByteArrArr[this.bgInt][this.bhInt] = 0;
                this.bfInt = -1;
                this.cVoid(this.bgInt, this.bhInt);
            }
            kVoid(this.bgInt - n, this.bhInt);
            return;
        }
        this.oByte -= 6;
        i.bByteArrArr[this.bgInt][this.bhInt] = this.oByte;
        if ((this.biInt == 1 || this.biInt == -1) && this.oByte <= 6 && (this.kInt & 0x70) == 0x0) {
            this.gVoid(((this.kInt & 0x7) == 0x4) ? 23 : 21);
        }
    }

    private void aaVoid() {
        int n = i.kByteArr[this.aCInt << 1] - this.crtPlayerX;
        int n2 = i.kByteArr[(this.aCInt << 1) + 1] - this.crtPlayerY;
        if (this.kByte == 2 && this.aCInt == 2) {
            n = 10;
            n2 = -8;
        }
        i i;
        int anInt;
        if (n2 == 0) {
            if (n < 0) {
                i = this;
                anInt = 12;
            } else {
                i = this;
                anInt = 4;
            }
        } else if (n == 0) {
            if (n2 < 0) {
                i = this;
                anInt = 0;
            } else {
                i = this;
                anInt = 8;
            }
        } else {
            final int n3;
            if ((n3 = (n << 7) / n2) > 0) {
                if (n3 < 128) {
                    if (n > 0) {
                        i = this;
                        anInt = 7;
                    } else {
                        i = this;
                        anInt = 15;
                    }
                } else if (n3 > 128) {
                    if (n > 0) {
                        i = this;
                        anInt = 5;
                    } else {
                        i = this;
                        anInt = 13;
                    }
                } else if (n > 0) {
                    i = this;
                    anInt = 6;
                } else {
                    i = this;
                    anInt = 14;
                }
            } else if (n3 > -128) {
                if (n < 0) {
                    i = this;
                    anInt = 9;
                } else {
                    i = this;
                    anInt = 1;
                }
            } else if (n3 < -128) {
                if (n < 0) {
                    i = this;
                    anInt = 11;
                } else {
                    i = this;
                    anInt = 3;
                }
            } else if (n < 0) {
                i = this;
                anInt = 10;
            } else {
                i = this;
                anInt = 2;
            }
        }
        i.anInt = anInt;
    }

    private void fVoid(final int n, final int n2) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (this.isPlayerAtPosition((this.aInt + n) / 24 + j, (this.bInt + n2) / 24 + i)) {
                    this.hurtHero(1, 48, 0);
                }
            }
        }
    }

    private void abVoid() {
        final int dInt = this.dInt();
        if (this.crtPlayerX == dInt || this.crtPlayerX == dInt + 1) {
            final b_SpriteAnimator b;
            final int n = (b = i.aClassbArr[5]).y - 40;
            final int n2 = b.y + 256;
            final byte b2 = b.sprite.animationFrames[(b.sprite.animationFirstAnimationFrameIndices[b.crtAnimationI] + b.crtAnimationFrame) * 5 + 3];
            final int n3 = n - b2;
            final int n4 = n2 - b2;
            final int bInt;
            if ((bInt = i.aClassbArr[0].y) > n3 && bInt < n4 && !this.jBoolean) {
                this.hurtHero(1, 48, (this.crtPlayerX == dInt) ? 4 : 2);
            }
        }
    }

    private static void gVoid(final int n, final int n2) {
        if (n < 0 || n2 < 0) {
            return;
        }
        i.crtStagePlayerLayer[n][n2] = -1;
        i.crtStagePlayerLayer[n + 1][n2] = -1;
    }

    private static void hVoid(final int n, final int n2) {
        if (n < 0 || n2 < 0) {
            return;
        }
        i.crtStagePlayerLayer[n][n2] = 50;
        i.crtStagePlayerLayer[n + 1][n2] = 50;
    }

    private boolean bBoolean(final int n, int n2) {
        n2 = 0;
        for (int iInteger = n; iInteger <= n + 1; ++iInteger) {
            for (int j = 8; j >= 7; --j) {
                if (i.crtStagePlayerLayer[iInteger][j] == 0) {
                    this.dVoid(iInteger, j);
                    kVoid(iInteger, j);
                    i.crtStagePlayerLayer[iInteger][j] = -1;
                    this.bVoid(iInteger, j);
                    n2 = 1;
                }
            }
        }
        return n2 != 0;
    }

    private int dInt() {
        return 10 + this.arInt * (((this.arInt > 0) ? 1 : 0) + 2);
    }

    private int eInt() {
        final b_SpriteAnimator b;
        return this.crtStageHeight * ((b = i.aClassbArr[5]).y - 40 - b.sprite.animationFrames[(b.sprite.animationFirstAnimationFrameIndices[b.crtAnimationI] + b.crtAnimationFrame) * 5 + 3] + this.bInt) / (this.crtStageHeight * 24);
    }

    private boolean eBoolean() {
        final int dInt = this.dInt();
        final int eInt = this.eInt();
        boolean b = false;
        for (int iInteger = dInt; iInteger <= dInt + 1; ++iInteger) {
            for (int j = eInt; j <= 10; ++j) {
                if (i.crtStagePlayerLayer[iInteger][j] == 0) {
                    this.dVoid(iInteger, j);
                    kVoid(iInteger, j);
                    i.crtStagePlayerLayer[iInteger][j] = -1;
                    this.bVoid(iInteger, j);
                    b = true;
                }
            }
        }
        return b;
    }

    private void acVoid() {
        this.bjInt = 30;
        if (i.crtStagePlayerLayer[this.PInt][this.RInt] == -1) {
            i.crtStagePlayerLayer[this.PInt][this.OInt] = 0;
            kVoid(this.PInt, this.OInt);
        }
        if (i.crtStagePlayerLayer[this.QInt][this.RInt] == -1) {
            i.crtStagePlayerLayer[this.QInt][this.OInt] = 0;
            kVoid(this.QInt, this.OInt);
        }
    }

    private void adVoid() {
        this.aoInt = -1;
        this.aqInt = 5;
    }

    public final void aVoid() {
        final byte b = (byte) (((this.kInt & 0x1000) == 0x0) ? this.lByte : 0);
        final int n = this.crtPlayerX * 24 + this.jInt * i.gByteArr[b];
        final int n2 = 24 * this.crtStageWidth - 240;
        final int dInt = 24 * this.crtStageHeight - 240;
        Label_0141:
        {
            i i;
            int cInt;
            if (n < this.cInt + 96) {
                this.cInt = this.cInt - 96 + n >> 1;
                if (this.cInt >= 0) {
                    break Label_0141;
                }
                i = this;
                cInt = 0;
            } else {
                if (n <= this.cInt + 120) {
                    break Label_0141;
                }
                this.cInt = this.cInt - 120 + n >> 1;
                if (this.cInt <= n2) {
                    break Label_0141;
                }
                i = this;
                cInt = n2;
            }
            i.cInt = cInt;
        }
        final int n3;
        if ((n3 = this.crtPlayerY * 24 + this.jInt * i.gByteArr[b + 8] + 40) < this.dInt + 96) {
            this.dInt = this.dInt - 96 + n3 >> 1;
            if (this.dInt < 0) {
                this.dInt = 0;
            }
        }
        if (n3 > this.dInt + 160) {
            this.dInt = this.dInt - 160 + n3 >> 1;
            if (this.dInt > dInt) {
                this.dInt = dInt;
            }
        }
        this.aInt = this.cInt;
        this.bInt = this.dInt;
        Label_0288:
        {
            i j;
            int aInt;
            if (this.aInt < 0) {
                j = this;
                aInt = 0;
            } else {
                if (this.aInt <= n2) {
                    break Label_0288;
                }
                j = this;
                aInt = n2;
            }
            j.aInt = aInt;
        }
        i k;
        i l;
        int dInt2;
        int bInt;
        if (this.bInt < 0) {
            k = this;
            l = this;
            bInt = (dInt2 = 0);
        } else {
            if (this.bInt <= dInt) {
                return;
            }
            k = this;
            l = this;
            bInt = (dInt2 = dInt);
        }
        l.dInt = dInt2;
        k.bInt = bInt;
    }

    private void bVoid(int n, int n2, final byte b) {
        while ((i.crtStageForegrondLayer[n][n2] & 0xFF) == b) {
            i.crtStageForegrondLayer[n][n2] = -1;
            this.bVoid(n - 1, n2, b);
            this.bVoid(n + 1, n2, b);
            this.bVoid(n, n2 - 1, b);
            final int n3 = n;
            ++n2;
            n = n3;
        }
    }

    private boolean aBoolean(int n, int n2, final boolean b) {
        int n3 = 0;
        final int kInt = this.kInt;
        int hInt = this.crtPlayerX;
        int iInt = this.crtPlayerY;
        byte lByte = this.lByte;
        boolean xBoolean = this.xBoolean;
        int axInt = this.aXInt;
        int jInt = this.jInt;
        final int awInt = this.aWInt;
        int n4;
        int n5;
        if (n > 0) {
            n4 = (kInt & 0xFFFFFFF8);
            n5 = 2;
        } else if (n < 0) {
            n4 = (kInt & 0xFFFFFFF8);
            n5 = 4;
        } else if (n2 < 0) {
            n4 = (kInt & 0xFFFFFFF8);
            n5 = 1;
        } else {
            n4 = (kInt & 0xFFFFFFF8);
            n5 = 3;
        }
        int kInt2 = n4 | n5;
        final int n6 = hInt + n;
        final int n7 = iInt + n2;
        boolean b2 = false;
        boolean b3 = false;
        if (n6 < 0 || n6 >= this.crtStageWidth || n7 < 0 || n7 >= this.crtStageHeight) {
            b2 = true;
        } else {
            if (i.eIntArrArr != null && i.eIntArrArr[n6][n7] != 0 && i.iByteArr[10] == 0) {
                b2 = false;
                n3 = 1;
            }
            Label_0738:
            {
                int n10 = 0;
                switch ((byte) i.crtStageForegrondLayer[n6][n7]) {
                    case 19: {
                        if (b) {
                            break Label_0738;
                        }
                        int n8;
                        int n9;
                        for (n8 = n6 + 3, n9 = n7; i.crtStagePlayerLayer[n8][n9] != 39; --n9) {
                        }
                        if (!this.lBoolean) {
                            this.arVoid();
                        }
                        this.lBoolean = true;
                        this.alBoolean = false;
                        if (i.eIntArrArr == null) {
                            i.eIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
                        }
                        this.aByte((byte) i.bIntArrArr[n8][n9], (byte) n8, (byte) n9, (byte) 0);
                        this.mVoid(n8, n9);
                        while (true) {
                            ++n9;
                            if ((i.crtStageForegrondLayer[n6][n9] & 0xFF) != 0x13) {
                                break Label_0738;
                            }
                            i.crtStageForegrondLayer[n6][n9] = -1;
                        }
//                        break;
                    }
                    case 1: {
                        if (!b) {
                            this.bjInt = 120;
                            ++this.amInt;
                            this.bVoid(n6, n7, (byte) 1);
                        }
                        break Label_0738;
                    }
                    case 7: {
                        if ((i.crtStageForegrondLayer[n6][n7] >> 8 & 0xF0) >> 4 < 2) {
                            n10 = 1;
                            break;
                        }
                        break Label_0738;
                    }
                    // Checkpoint
                    case 4: {
                        final int n11;
                        if (!b && (n11 = (i.crtStageForegrondLayer[n6][n7] & 0xFFFFFF00) >> 8) >= this.aCInt) {
                            this.shouldSaveCheckpoint = true;
                            this.aCInt = n11 + 1;
                            this.akInt = i.aSInt + 13;
                        }
                        break Label_0738;
                    }
                    case 28: {
                        if (!b) {
                            xBoolean = true;
                            this.atBoolean = false;
                        }
                        break Label_0738;
                    }
                    case 5: {
                        b2 = true;
                        if (!b) {
                            xBoolean = true;
                            this.atBoolean = true;
                        }
                        break Label_0738;
                    }
                    case 2: {
                        if (!b) {
                            b3 = true;
                            i i = null;
                            int aeInt = 0;
                            Label_0701:
                            {
                                i j = null;
                                int adInt = 0;
                                Label_0696:
                                {
                                    switch (i.crtStageForegrondLayer[n6][n7] >> 8) {
                                        case 0: {
                                            if (i.iByteArr[9] >= 1) {
                                                this.aDInt = 7;
                                                i = this;
                                                aeInt = 0;
                                                break Label_0701;
                                            }
                                            j = this;
                                            break;
                                        }
                                        case 1: {
                                            if (i.iByteArr[9] >= 2) {
                                                j = this;
                                                adInt = 7;
                                                break Label_0696;
                                            }
                                            j = this;
                                            break;
                                        }
                                        default: {
                                            break Label_0738;
                                        }
                                    }
                                    adInt = 13;
                                }
                                j.aDInt = adInt;
                                i = this;
                                aeInt = 1;
                            }
                            i.aEInt = aeInt;
                        }
                        break Label_0738;
                    }
                    case 6: {
                        break Label_0738;
                    }
                    case 3: {
                        if (i.crtStageForegrondLayer[n6][n7] >> 8 < 3) {
                            b2 = true;
                            break Label_0738;
                        }
                        b2 = false;
                        n10 = 1;
                        break;
                    }
                }
                n3 = n10;
            }
            if (n3 == 0) {
                final byte b4;
                switch (b4 = i.crtStagePlayerLayer[n6][n7]) {
                    case 34:
                    case 35: {
                        b2 = b;
                        break;
                    }
                    case 31:
                    case 49: {
                        b2 = false;
                        break;
                    }
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 11:
                    case 14:
                    case 19:
                    case 24:
                    case 26:
                    case 27:
                    case 33:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 45:
                    case 50:
                    case 51:
                    case 52:
                    case 53: {
                        b2 = true;
                        break;
                    }
                    case 10: {
                        if (this.xByte == 3) {
                            if (!b && i.bIntArrArr[n6][n7] <= 0) {
                                i.bIntArrArr[n6][n7] = 1;
                            }
                            b2 = true;
                            break;
                        }
                        break;
                    }
                    case 0:
                    case 8:
                    case 9:
                    case 47: {
                        final int n12 = hInt + (n << 1);
                        n2 = iInt + (n2 << 1);
                        if (this.kByte == 4) {
                            final int dInt = this.dInt();
                            if ((n12 == dInt || n12 == dInt + 1) && n2 >= this.eInt()) {
                                this.gVoid((((kInt2 | 0x8) & 0x7) == 0x2) ? 8 : 9);
                                return false;
                            }
                        }
                        --axInt;
                        final int n13 = i.crtStageForegrondLayer[n12][n2] & 0xFF;
                        final int n14 = i.crtStageForegrondLayer[n12][n2] >> 8;
                        final byte b5 = i.crtStagePlayerLayer[n6][iInt + 1];
                        if ((axInt < 0 || b) && n != 0 && eBoolean(n12, n2) && (n13 != 7 || (n14 & 0xF0) != 0x0) && ((b5 != 19 && b5 != 45 && b5 != 49 && b5 != 43) || (i.crtStageForegrondLayer[n6][iInt + 1] & 0xFF) == 0x23)) {
                            if (!b) {
                                final int n15 = n6;
                                final int n16 = n7;
                                final boolean b6 = n > 0;
                                final byte b7 = b4;
                                final boolean b8 = b6;
                                final int n17 = n16;
                                final int n18 = n15;
                                final int n19 = b8 ? (n18 + 1) : (n18 - 1);
                                final int n20 = i.bIntArrArr[n18][n17];
                                i.crtStagePlayerLayer[n19][n17] = b7;
                                i.crtStagePlayerLayer[n18][n17] = -1;
                                i.bByteArrArr[n19][n17] = 18;
                                int n21;
                                int n22;
                                if (b8) {
                                    n21 = (((n20 & 0xFFFFFFF8) | 0x2) & 0xFFFFF3FF);
                                    n22 = 1024;
                                } else {
                                    n21 = (((n20 & 0xFFFFFFF8) | 0x4) & 0xFFFFF3FF);
                                    n22 = 2048;
                                }
                                i.bIntArrArr[n19][n17] = (((n21 | n22) & 0xFFFFFDFF) | Integer.MIN_VALUE);
                                kVoid(n19, n17);
                                this.bVoid(n18, n17);
                            }
                            b2 = true;
                            kInt2 |= 0x8;
                            break;
                        }
                        if (n != 0) {
                            kInt2 |= 0x8;
                        }
                        lByte = 0;
                        i.bIntArrArr[n6][n7] &= 0xFFFFFFF8;
                        break;
                    }
                    case 48: {
                        final int n23 = hInt + (n << 1);
                        n2 = iInt + (n2 << 1);
                        --axInt;
                        int n24;
                        int n25;
                        if ((i.bIntArrArr[n6][n7] & 0x8) != 0x0) {
                            n24 = 0;
                            n25 = 1;
                        } else {
                            n24 = -1;
                            n25 = 0;
                        }
                        final int n26 = n25;
                        if ((axInt < 0 || b) && n != 0 && i.crtStagePlayerLayer[n23][n2 + n24] < 0 && i.crtStagePlayerLayer[n23][n2 + n26] < 0 && i.crtStagePlayerLayer[n6][n7 + n26 + 1] >= 0) {
                            if (!b) {
                                i.crtStagePlayerLayer[n23][n2 + n24] = b4;
                                i.crtStagePlayerLayer[n23][n2 + n26] = b4;
                                i.crtStagePlayerLayer[n6][n7 + n24] = -1;
                                i.crtStagePlayerLayer[n6][n7 + n26] = -1;
                                i.bIntArrArr[n23][n2 + n24] = i.bIntArrArr[n6][n7 + n24];
                                i.bIntArrArr[n23][n2 + n26] = ((i.bIntArrArr[n6][n7 + n26] & 0xFFFFFFF0) | ((n > 0) ? 2 : 4));
                                i.bByteArrArr[n23][n2 + n26] = 18;
                                i.cByteArrArr[n23][n2 + n24 - 1] = 48;
                                i.cByteArrArr[n23][n2 + n24 - 1] = 48;
                                i.cByteArrArr[n23][n2 + n24 - 1] = 48;
                                kVoid(n23, n2 + n26);
                            }
                            b2 = true;
                            kInt2 |= 0x8;
                            break;
                        }
                        if (n != 0) {
                            kInt2 |= 0x8;
                        }
                        lByte = 0;
                        break;
                    }
                    case -1: {
                        Label_1991:
                        {
                            boolean b9;
                            if (n6 == 0 || n7 == 0 || n6 == this.crtStageWidth - 1 || n7 == this.crtStageHeight - 1) {
                                b9 = true;
                            } else {
                                if (((n != 0 && i.crtStagePlayerLayer[n6][iInt + 1] == 0 && (i.bIntArrArr[n6][iInt + 1] & 0x7) == 0x3) || (this.aNInt >= 24 && ((i.crtStagePlayerLayer[n6][n7 - 1] == 28 && (i.bIntArrArr[n6][n7 - 1] & 0x8) == 0x0) || (i.crtStagePlayerLayer[n6][n7 + 1] == 28 && (i.bIntArrArr[n6][n7 + 1] & 0x8) == 0x0))) || (this.aPInt >= 24 && (i.crtStagePlayerLayer[n6][n7 - 1] == 28 || i.crtStagePlayerLayer[n6][n7 + 1] == 28))) && !b) {
                                    lByte = 0;
                                    break Label_1991;
                                }
                                b9 = true;
                            }
                            b2 = b9;
                        }
                        kInt2 &= 0xFFFFFFF7;
                        break;
                    }
                    case 28: {
                        lByte = 0;
                        kInt2 &= 0xFFFFFFF7;
                        break;
                    }
                    default: {
                        n = 0;
                        b2 = false;
                        if (this.lByte == 4 || this.lByte == 2) {
                            this.gVoid(0 + this.lByte - 1);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        if (!b && b2 && !b3) {
            this.aDInt = -1;
        }
        if (b2 && awInt == 0) {
            jInt = 18;
            hInt += n;
            iInt = n7;
            if ((kInt2 & 0x8) == 0x0 && !b) {
                this.gVoid(lByte + 4 - 1);
            }
        } else if (n != 0 && !b) {
            kInt2 |= 0x8;
        }
        if ((kInt2 & 0x8) != 0x0 && !b) {
            this.gVoid(((kInt2 & 0x7) == 0x2) ? 8 : 9);
        }
        if (!b) {
            this.kInt = kInt2;
            this.crtPlayerX = hInt;
            this.crtPlayerY = iInt;
            this.lByte = lByte;
            this.xBoolean = xBoolean;
            this.aXInt = axInt;
            this.jInt = jInt;
            this.aWInt = awInt;
        }
        return b2;
    }

    public static void bVoid() {
        i.bByte = 3;
    }

    private void aeVoid() {
        i.bByte = 2;
        i.VBoolean = true;
        this.aVoid(1);
        this.oBoolean = true;
        if (i.aClassfArr[18] == null) {
            i.aClassfArr[18] = loadSprite("/ui.f", 3, 0, 0);
        }
    }

    public final void cVoid() {
        this.lLong = System.currentTimeMillis() - this.aLong;
        this.afBoolean = true;
        System.out.println(j_SoundManager.isPlayingSound());
        this.aClassj.freeCrtPlayerResource();
    }

    public final void showNotify() {
        if (this.afBoolean) {
            this.dVoid();
        }
    }

    public final void hideNotify() {
        if (!this.afBoolean) {
            this.cVoid();
        }
    }

    public final void dVoid() {
        this.afBoolean = false;
        i.VBoolean = true;
        i.WBoolean = true;
        this.dBoolean = true;
        i.keysPressed = 0;
        this.dbInt = -1;
        if (this.boInt == 7) {
            this.bqInt = 0;
        }
        this.aLong = System.currentTimeMillis() - this.lLong;
        i i = null;
        switch (i.bByte) {
            case 0:
            case 6:
            case 12:
            case 22: {
                return;
            }
            case 7: {
                this.bqInt = 1;
                return;
            }
            case 15: {
                i = this;
                break;
            }
            case 1: {
                this.aClassGraphics.setClip(0, 0, 240, 320);
                this.aClassGraphics.setColor(0);
                this.aClassGraphics.fillRect(0, 0, 240, 320);
                this.oBoolean = true;
                if (i.aBoolean) {
                    this.oBoolean = true;
                    this.GVoid();
                    return;
                }
                if (this.aClassc != null) {
                    return;
                }
                if (this.ayInt != 0) {
                    return;
                }
                if (this.xBoolean) {
                    return;
                }
                if (this.nByte <= 0) {
                    return;
                }
                if (i.aClassbArr[0].crtAnimationI == 19) {
                    return;
                }
                if (this.EBoolean) {
                    return;
                }
                this.aeVoid();
                return;
            }
            case 5: {
                this.RBoolean = true;
                return;
            }
            case 8: {
                return;
            }
            case 9:
            case 28: {
                return;
            }
            case 11: {
                this.bsInt = 6;
                return;
            }
            case 31: {
                this.QBoolean = true;
                return;
            }
            case 16: {
                this.azInt = 0;
                this.bbInt = 0;
                this.pBoolean = false;
                this.agInt = 0;
                this.DBoolean = true;
                return;
            }
            case 17: {
                return;
            }
            case 18:
            case 25:
            case 26: {
                i = this;
                break;
            }
            case 19: {
                return;
            }
            case 20: {
                return;
            }
            case 21: {
                this.avVoid();
                return;
            }
            case 23: {
                return;
            }
            case 27: {
                this.avBoolean = true;
                this.gBoolean = true;
                return;
            }
            case 2: {
                i.fClassImage = null;
                if (i.aBoolean) {
                    this.oBoolean = true;
                    this.GVoid();
                }
                this.oBoolean = true;
                if (this.boInt == 1) {
                    this.bqInt = 0;
                }
                return;
            }
            case 33: {
                i = this;
                break;
            }
        }
        i.avBoolean = true;
    }

    private void afVoid() {
        if (!this.lBoolean) {
            return;
        }
        for (int iInteger = 0; iInteger < this.crtStageWidth; ++iInteger) {
            for (int j = 0; j < this.crtStageHeight; ++j) {
                if (i.crtStagePlayerLayer[iInteger][j] == 38) {
                    this.aByte((byte) i.bIntArrArr[iInteger][j], (byte) iInteger, (byte) j, (byte) 0);
                    ++this.duInt;
                }
            }
        }
    }

    private void iVoid(final int n, final int n2) {
        this.cLong |= 0x400000L;
        final int[] array = i.crtStageForegrondLayer[n];
        array[n2] &= 0xFFFFFF00;
        final int[] array2 = i.crtStageForegrondLayer[n];
        array2[n2] |= 0xE;
    }

    private boolean fBoolean() {
        return this.kByte == 4 || this.kByte == 5 || this.kByte == 3;
    }

    private void aVoid(int n, int n2, int n3, int n4, final int n5) {
        while (n + n3 > 0 && n + n3 < this.crtStageWidth && n2 + n4 > 0 && n2 + n4 < this.crtStageHeight) {
            final int n6;
            switch (n6 = (i.crtStageForegrondLayer[n + n3][n2 + n4] & 0xFF)) {
                case 8:
                case 9: {
                    final int n7 = i.crtStageForegrondLayer[n + n3][n2 + n4] >> 8;
                    i.crtStageForegrondLayer[n + n3][n2 + n4] = (((n5 == 1) ? (n7 | 0x200) : (n7 & 0xFFFFFDFF)) << 8 | n6);
                    this.aVoid(n + n3, n2 + n4, n3, n4, n5);
                    final int n8 = n + n3;
                    final int n9 = n2 + n4;
                    final int n10 = 0;
                    n4 = 1;
                    n3 = n10;
                    n2 = n9;
                    n = n8;
                    continue;
                }
                default: {
                }
            }
        }
    }

    private boolean isPlayerAtPosition(final int x, final int y) {
        return x == this.crtPlayerX && y == this.crtPlayerY;
    }

    private void kVoid(final int n) {
        final byte b = 0;
        this.lByte = b;
        this.aByte = b;
        for (int iInteger = 0; iInteger < i.pByteArr.length; ++iInteger) {
            if (i.pByteArr[iInteger] == n) {
                this.aClassc = i.aClasscArr[iInteger];
            }
        }
        this.aClassc.aVoid();
    }

    private boolean gBoolean() {
        Label_0081:
        {
            if (this.aInt < this.ciInt) {
                this.aInt += this.ckInt;
                if (this.aInt <= this.ciInt) {
                    break Label_0081;
                }
            } else {
                if (this.aInt <= this.ciInt) {
                    break Label_0081;
                }
                this.aInt -= this.ckInt;
                if (this.aInt >= this.ciInt) {
                    break Label_0081;
                }
            }
            this.aInt = this.ciInt;
        }
        Label_0162:
        {
            if (this.bInt < this.cjInt) {
                this.bInt += this.ckInt;
                if (this.bInt <= this.cjInt) {
                    break Label_0162;
                }
            } else {
                if (this.bInt <= this.cjInt) {
                    break Label_0162;
                }
                this.bInt -= this.ckInt;
                if (this.bInt >= this.cjInt) {
                    break Label_0162;
                }
            }
            this.bInt = this.cjInt;
        }
        boolean b = false;
        boolean b2 = false;
        Label_0230:
        {
            if (this.aInt < 0) {
                this.aInt = 0;
            } else if (this.aInt > this.crtStageWidth * 24 - 240) {
                this.aInt = this.crtStageWidth * 24 - 240;
            } else if (this.aInt != this.ciInt) {
                break Label_0230;
            }
            b = true;
        }
        Label_0300:
        {
            if (this.bInt < 0) {
                this.bInt = 0;
            } else if (this.bInt > this.crtStageHeight * 24 - 320 + 80) {
                this.bInt = this.crtStageHeight * 24 - 320 + 80;
            } else if (this.bInt != this.cjInt) {
                break Label_0300;
            }
            b2 = true;
        }
        if (b && b2) {
            this.cInt = this.aInt;
            this.dInt = this.bInt;
            this.axInt = 70;
            return true;
        }
        return false;
    }

    private void agVoid() {
        switch (this.clInt) {
            case 1: {
                this.ckInt = 8;
                if (this.gBoolean()) {
                    this.clInt = 2;
                    this.dlInt = 40;
                    return;
                }
                break;
            }
            case 2: {
                --this.dlInt;
                if (this.dlInt == 30) {
                    if ((i.crtStageForegrondLayer[this.djInt][this.dkInt] >> 8 & 0xF0) != 0x0) {
                        this.doorHeadClose(this.djInt, this.dkInt);
                        return;
                    }
                    break;
                } else {
                    if (this.dlInt == 0) {
                        this.clInt = 3;
                        this.ciInt = this.crtPlayerX * 24 - 108;
                        this.cjInt = this.crtPlayerY * 24 - 108;
                        this.ckInt = 5;
                        this.eClassString = i.texts[i.lByteArr[i.cmInt]];
                        i.textSize0.calculateStringSize(this.eClassString);
                        this.diInt = 80;
                        return;
                    }
                    break;
                }
//                break;
            }
            case 3: {
                if (this.gBoolean()) {
                    this.dlInt = 20;
                    this.clInt = 4;
                    this.axInt = 0;
                    return;
                }
                break;
            }
            case 4: {
                --this.dlInt;
                if (this.dlInt == 0) {
                    this.axInt = 0;
                    this.clInt = 0;
                    i.akBoolean = true;
                    break;
                }
                break;
            }
        }
    }

    private void ahVoid() {
        int n = this.crtPlayerX - 8;
        int n2 = this.crtPlayerX + 8;
        int n3 = this.crtPlayerY + 8;
        int n4 = this.crtPlayerY - 8;
        int n5 = 0;
        if (i.aClassbArr[4] != null) {
            final int eInt;
            n5 = (((eInt = i.aClassbArr[4].crtAnimationFrame) == 0) ? 0 : ((eInt <= 10) ? 1 : ((eInt <= 20) ? 2 : 3)));
        }
        if (n < 1) {
            n = 1;
        }
        if (n2 > this.crtStageWidth - 2) {
            n2 = this.crtStageWidth - 2;
        }
        if (n4 < 1) {
            n4 = 1;
        }
        if (n3 > this.crtStageHeight - 2) {
            n3 = this.crtStageHeight - 2;
        }
        i i = this;
        int bfInt = n3;
        while (true) {
            i.bFInt = bfInt;
            if (this.bFInt < n4) {
                break;
            }
            i j = this;
            int beInt = n;
            while (true) {
                j.bEInt = beInt;
                if (this.bEInt > n2) {
                    break;
                }
                final boolean b = this.biInt != 0 && this.bEInt == this.bgInt && this.bFInt == this.bhInt;
                Label_8485:
                {
                    if (i.cByteArrArr[this.bEInt][this.bFInt] > 0 && !b) {
                        final byte[] array = i.cByteArrArr[this.bEInt];
                        final int bfInt2 = this.bFInt;
                        array[bfInt2] -= 6;
                        Label_2587:
                        {
                            i m = null;
                            i i2 = null;
                            switch ((byte) i.crtStageForegrondLayer[this.bEInt][this.bFInt]) {
                                case 36: {
                                    int n6 = i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8;
                                    int[] array2;
                                    int n7;
                                    int n8;
                                    if (++n6 >= 16) {
                                        array2 = i.crtStageForegrondLayer[this.bEInt];
                                        n7 = this.bFInt;
                                        n8 = -1;
                                    } else {
                                        i.cByteArrArr[this.bEInt][this.bFInt] = 24;
                                        array2 = i.crtStageForegrondLayer[this.bEInt];
                                        n7 = this.bFInt;
                                        n8 = (n6 << 8 | 0x24);
                                    }
                                    array2[n7] = n8;
                                    break Label_2587;
                                }
                                case 35:
                                case 37: {
                                    if (this.bEInt != this.bgInt || this.bFInt != this.bhInt || this.biInt == 0) {
                                        final int beInt2 = this.bEInt;
                                        final int bfInt3 = this.bFInt;
                                        i.cByteArrArr[beInt2][bfInt3] = 24;
                                        Label_0929:
                                        {
                                            int n15;
                                            byte b4;
                                            byte[] array6 = null;
                                            if (i.bByteArrArr[beInt2][bfInt3] <= 0) {
                                                final int n9 = bfInt3 - 1;
                                                final int n10 = bfInt3 + 1;
                                                final byte b2;
                                                Label_0660:
                                                {
                                                    int[] array3;
                                                    int n11;
                                                    int n12;
                                                    if ((b2 = (byte) i.crtStageForegrondLayer[beInt2][n9]) == 34 || b2 == 37) {
                                                        array3 = i.crtStageForegrondLayer[beInt2];
                                                        n11 = n9;
                                                        n12 = 37;
                                                    } else {
                                                        if (b2 == 35 || !dBoolean(beInt2, n9)) {
                                                            break Label_0660;
                                                        }
                                                        i.bByteArrArr[beInt2][n9] = 18;
                                                        array3 = i.crtStageForegrondLayer[beInt2];
                                                        n11 = n9;
                                                        n12 = 35;
                                                    }
                                                    array3[n11] = n12;
                                                }
                                                final byte b3 = i.crtStagePlayerLayer[beInt2][bfInt3];
                                                if (i.crtStagePlayerLayer[beInt2][n9] < 0 && !this.isPlayerAtPosition(beInt2, n9) && b2 == 35 && b3 != 32 && b3 != 21 && i.crtStagePlayerLayer[beInt2][bfInt3] != -1) {
                                                    i.bByteArrArr[beInt2][n9] = 18;
                                                    i.crtStagePlayerLayer[beInt2][n9] = i.crtStagePlayerLayer[beInt2][bfInt3];
                                                    i.bIntArrArr[beInt2][n9] = ((i.bIntArrArr[beInt2][bfInt3] & 0xFFFFFFF8) | 0x1);
                                                    i.crtStagePlayerLayer[beInt2][bfInt3] = -1;
                                                    this.bVoid(beInt2, bfInt3);
                                                } else {
                                                    this.cVoid(beInt2, bfInt3);
                                                }
                                                if ((i.crtStageForegrondLayer[beInt2][n10] & 0xFF) != 0x23 && i.crtStagePlayerLayer[beInt2][n10] != 47) {
                                                    int[] array4;
                                                    int n13;
                                                    int n14;
                                                    if (i.crtStageForegrondLayer[beInt2][bfInt3] == 37) {
                                                        array4 = i.crtStageForegrondLayer[beInt2];
                                                        n13 = bfInt3;
                                                        n14 = 34;
                                                    } else {
                                                        array4 = i.crtStageForegrondLayer[beInt2];
                                                        n13 = bfInt3;
                                                        n14 = -1;
                                                    }
                                                    array4[n13] = n14;
                                                }
                                                i.cByteArrArr[beInt2][n9] = 24;
                                                if (i.crtStagePlayerLayer[beInt2][bfInt3] >= 0) {
                                                    break Label_0929;
                                                }
                                                final byte[] array5 = i.bByteArrArr[beInt2];
                                                n15 = bfInt3;
                                                b4 = 18;
                                            } else {
                                                array6 = i.bByteArrArr[beInt2];
                                                b4 = (byte) (array6[n15 = bfInt3] - 6);
                                            }
                                            array6[n15] = b4;
                                        }
                                    }
                                    break Label_2587;
                                }
                                case 32: {
                                    int n16 = i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8 & 0xFF;
                                    if ((i.aSInt & 0x1) == 0x0) {
                                        ++n16;
                                    } else if (n16 == 1) {
                                        this.bVoid(this.bEInt, this.bFInt);
                                    }
                                    int[] array7;
                                    int n17;
                                    int n18;
                                    if (n16 == i.aClassfArr[16].getAnimationFrameCount(0)) {
                                        array7 = i.crtStageForegrondLayer[this.bEInt];
                                        n17 = this.bFInt;
                                        n18 = -1;
                                    } else {
                                        array7 = i.crtStageForegrondLayer[this.bEInt];
                                        n17 = this.bFInt;
                                        n18 = (n16 << 8 | 0x20);
                                    }
                                    array7[n17] = n18;
                                    i.cByteArrArr[this.bEInt][this.bFInt] = 24;
                                    break Label_2587;
                                }
                                case 26: {
                                    if (this.jInt <= 6 && this.isPlayerAtPosition(this.bEInt, this.bFInt)) {
                                        i.keysPressed = 0;
                                        this.aByte = 0;
                                        i.cmInt = i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8;
                                        this.doorHeadClose(this.crtPlayerX + i.gByteArr[this.kInt & 0x7], this.crtPlayerY);
                                        if (i.cmInt < 0 || i.cmInt >= i.mByteArr.length) {
                                            i.cmInt = -1;
                                        } else {
                                            this.playSound(1);
                                            this.clInt = 1;
                                            final int cmInt = i.cmInt;
                                            this.playSound(1);
                                            final int n19 = this.crtStageWidth - 1;
                                            for (int n20 = this.crtStageHeight - 1, k = 1; k < n20; ++k) {
                                                for (int l = 1; l < n19; ++l) {
                                                    if ((i.crtStageForegrondLayer[l][k] & 0xFF) == 0x11 && i.crtStageForegrondLayer[l][k] >> 8 == cmInt) {
                                                        int djInt = -1;
                                                        int dkInt = 0;
                                                        Label_1363:
                                                        {
                                                            int n21 = 0;
                                                            if (i.crtStagePlayerLayer[l][k] == 18) {
                                                                djInt = l;
                                                                n21 = k;
                                                            } else {
                                                                Label_1353:
                                                                {
                                                                    switch (i.crtStageForegrondLayer[l][k - 1] & 0xFF) {
                                                                        case 7: {
                                                                            if ((i.crtStageForegrondLayer[l][k - 1] >> 8 & 0xF0) != 0x0) {
                                                                                break Label_1353;
                                                                            }
                                                                            break Label_1363;
                                                                        }
                                                                        case 14:
                                                                        case 33: {
                                                                            djInt = l;
                                                                            n21 = k - 1;
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            dkInt = n21;
                                                        }
                                                        if (djInt != -1) {
                                                            this.djInt = djInt;
                                                            this.dkInt = dkInt;
                                                            this.ciInt = djInt * 24 - 108;
                                                            this.cjInt = dkInt * 24 - 108;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i.crtStageForegrondLayer[this.bEInt][this.bFInt] = -1;
                                    }
                                    break Label_2587;
                                }
                                case 6: {
                                    final int beInt3 = this.bEInt;
                                    final int bfInt4 = this.bFInt;
                                    final int doorI = i.crtStageForegrondLayer[beInt3][bfInt4] >> 8;
                                    int n23 = (iBoolean(beInt3, bfInt4) || i.crtStagePlayerLayer[beInt3][bfInt4] == 47 || i.crtStagePlayerLayer[beInt3][bfInt4] == 48) ? 1 : 0;
                                    int n24 = i.bByteArrArr[beInt3][bfInt4];
                                    if (n23 == 0 && this.isPlayerAtPosition(beInt3, bfInt4)) {
                                        n23 = 1;
                                        n24 = (((this.kInt & 0x1000) != 0x0) ? 0 : this.jInt);
                                    }
                                    if (n23 != 0 && n24 < 12) {
                                        this.hVoid(doorI);
                                        break Label_2587;
                                    }
                                    this.doorHeadClose(doorI);
                                    break Label_2587;
                                }
                                case 33: {
                                    this.nVoid(33);
                                    break Label_2587;
                                }
                                case 14: {
                                    this.nVoid(14);
                                    break Label_2587;
                                }
                                case 2: {
                                    switch (i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8) {
                                        case 0: {
                                            if (i.crtStagePlayerLayer[this.bEInt - 1][this.bFInt] != 30 && i.crtStagePlayerLayer[this.bEInt + 1][this.bFInt] != 30 && i.crtStagePlayerLayer[this.bEInt][this.bFInt - 1] != 30 && i.crtStagePlayerLayer[this.bEInt][this.bFInt + 1] != 30) {
                                                this.aDInt = -1;
                                                this.bVoid(this.bEInt, this.bFInt, (byte) 2);
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    break Label_2587;
                                }
                                case 3: {
                                    final int beInt4 = this.bEInt;
                                    final int bfInt5 = this.bFInt;
                                    int n25;
                                    if ((n25 = i.crtStageForegrondLayer[beInt4][bfInt5] >> 8) < 6) {
                                        switch (n25) {
                                            case -1: {
                                                if (Math.abs(this.crtPlayerX - beInt4) < 4 && Math.abs(this.crtPlayerY - bfInt5) < 4) {
                                                    n25 = 3;
                                                    break;
                                                }
                                                break;
                                            }
                                            case 0:
                                            case 1: {
                                                break;
                                            }
                                            case 2: {
                                                Label_1948:
                                                {
                                                    switch (this.lByte) {
                                                        case 1: {
                                                            if (this.isPlayerAtPosition(beInt4, bfInt5 - 1)) {
                                                                break;
                                                            }
                                                            break Label_1948;
                                                        }
                                                        case 2: {
                                                            if (this.isPlayerAtPosition(beInt4 + 1, bfInt5)) {
                                                                break;
                                                            }
                                                            break Label_1948;
                                                        }
                                                        case 3: {
                                                            if (this.isPlayerAtPosition(beInt4, bfInt5 + 1)) {
                                                                break;
                                                            }
                                                            break Label_1948;
                                                        }
                                                        case 4: {
                                                            if (this.isPlayerAtPosition(beInt4 - 1, bfInt5)) {
                                                                break;
                                                            }
                                                            break Label_1948;
                                                        }
                                                    }
                                                    n25 = 3;
                                                }
                                                break;
                                            }
                                            default: {
                                                if ((i.aSInt & 0x1) == 0x0) {
                                                    ++n25;
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        i.cByteArrArr[beInt4][bfInt5] = 24;
                                        i.crtStageForegrondLayer[beInt4][bfInt5] = (n25 << 8 | 0x3);
                                        break Label_2587;
                                    }
                                    i.cByteArrArr[beInt4][bfInt5] = 0;
                                    break Label_2587;
                                }
                                case 30: {
                                    if (this.aClassc == null && this.bmInt == -1 && this.isPlayerAtPosition(this.bEInt, this.bFInt) && this.jInt <= 0) {
                                        this.bmInt = i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8;
                                        i.crtStageForegrondLayer[this.bEInt][this.bFInt] = -1;
                                    }
                                    break Label_2587;
                                }
                                case 0: {
                                    if (this.aClassc == null && this.bmInt == -1 && this.isPlayerAtPosition(this.bEInt, this.bFInt) && this.jInt <= 6) {
                                        this.bmInt = i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8;
                                        i.crtStageForegrondLayer[this.bEInt][this.bFInt] = -1;
                                    }
                                    break Label_2587;
                                }
                                case 7: {
                                    final int beInt5 = this.bEInt;
                                    final int bfInt6 = this.bFInt;
                                    int n27;
                                    final int n26;
                                    if ((n26 = ((n27 = i.crtStageForegrondLayer[beInt5][bfInt6] >> 8) & 0xF0) >> 4) != 0) {
                                        if (i.aSInt % 3 == 0 && n26 < 3) {
                                            n27 = ((n27 & 0xFFFFFF0F) | n26 + 1 << 4);
                                            if (n26 == 2) {
                                                final int n28;
                                                if ((n28 = (i.crtStageForegrondLayer[beInt5][bfInt6 - 1] & 0xFF)) == 9 || n28 == 8) {
                                                    i.crtStageForegrondLayer[beInt5][bfInt6 - 1] = ((i.crtStageForegrondLayer[beInt5][bfInt6 - 1] >> 8 & 0xFFFFFDFF) << 8 | n28);
                                                }
                                                this.aVoid(beInt5, bfInt6 - 1, 1, 0, 0);
                                                this.aVoid(beInt5, bfInt6 - 1, -1, 0, 0);
                                            }
                                            i.cByteArrArr[beInt5][bfInt6] = 24;
                                        }
                                        i.crtStageForegrondLayer[beInt5][bfInt6] = (n27 << 8 | 0x7);
                                    }
                                    break Label_2587;
                                }
                                case 8: {
                                    m = this;
                                    i2 = this;
                                    break;
                                }
                                case 9: {
                                    m = this;
                                    i2 = this;
                                    break;
                                }
                            }
                            final i i3 = i2;
                            final int beInt6 = m.bEInt;
                            final int bfInt7 = i3.bFInt;
                            final int n29 = i.crtStageForegrondLayer[beInt6][bfInt7] >> 8;
                            final int n30 = i.crtStageForegrondLayer[beInt6][bfInt7] & 0xFF;
                            final int dInt;
                            if ((n29 & 0x100) == 0x0 && ((n30 == 9 && i3.aUInt > 0) || (n30 == 8 && i3.aVInt > 0)) && i3.crtPlayerY == bfInt7 && (i3.crtPlayerX == beInt6 - 1 || i3.crtPlayerX == beInt6 + 1) && (dInt = i.aClassbArr[0].crtAnimationI) != 18 && dInt != 17 && i3.jInt <= 6) {
                                final i i4 = i3;
                                final i i5 = i3;
                                final byte b5 = 0;
                                i5.aByte = b5;
                                i4.lByte = b5;
                                i i6;
                                int n31;
                                if (i3.crtPlayerX == beInt6 - 1) {
                                    i3.kInt = ((i3.kInt & 0xFFFFFFF8) | 0x2);
                                    i6 = i3;
                                    n31 = 18;
                                } else {
                                    i3.kInt = ((i3.kInt & 0xFFFFFFF8) | 0x4);
                                    i6 = i3;
                                    n31 = 17;
                                }
                                i6.gVoid(n31);
                                i i7;
                                int afInt;
                                if (n30 == 9) {
                                    i7 = i3;
                                    afInt = 24;
                                } else {
                                    i7 = i3;
                                    afInt = 25;
                                }
                                i7.aFInt = afInt;
                                i3.aGInt = 0;
                            }
                        }
                        if ((i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xF0000000) >> 28 > 0) {
                            int n32;
                            if ((n32 = (i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xF0000000) >> 28) == 0) {
                                this.playSound(10);
                            }
                            if ((i.aSInt & 0x1) == 0x0) {
                                ++n32;
                            }
                            int[] array8;
                            int n33;
                            int n34;
                            if (n32 >= i.aClassfArr[13].getAnimationFrameCount(0)) {
                                array8 = i.crtStageForegrondLayer[this.bEInt];
                                n33 = this.bFInt;
                                n34 = (i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xFFFFFFF);
                            } else {
                                array8 = i.crtStageForegrondLayer[this.bEInt];
                                n33 = this.bFInt;
                                n34 = ((i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xFFFFFFF) | n32 << 28);
                            }
                            array8[n33] = n34;
                            kVoid(this.bEInt, this.bFInt);
                        }
                        i i10 = null;
                        i i11 = null;
                        int n98 = 0;
                        switch (i.crtStagePlayerLayer[this.bEInt][this.bFInt]) {
                            case 54: {
                                final int beInt7 = this.bEInt;
                                final int bfInt8 = this.bFInt;
                                int n35 = i.bIntArrArr[beInt7][bfInt8];
                                final f_Sprite f = i.aClassfArr[7];
                                ++n35;
                                final int aInt = aInt(f, 0);
                                if (n35 >= aInt) {
                                    i.crtStagePlayerLayer[beInt7][bfInt8] = -1;
                                    kVoid(beInt7, bfInt8);
                                    break Label_8485;
                                }
                                if (n35 == 1) {
                                    this.playSound(7);
                                    kVoid(beInt7, bfInt8);
                                } else if (n35 == aInt >> 1) {
                                    for (int n36 = -1; n36 < 2; ++n36) {
                                        for (int n37 = -1; n37 < 2; ++n37) {
                                            final int n38 = beInt7 + n37;
                                            final int n39 = bfInt8 + n36;
                                            Label_3288:
                                            {
                                                int[] array9 = null;
                                                int n40 = 0;
                                                boolean b6 = false;
                                                Label_3216:
                                                {
                                                    switch (i.crtStagePlayerLayer[n38][n39]) {
                                                        case 10: {
                                                            if (this.xByte == 3) {
                                                                break Label_3216;
                                                            }
                                                            break Label_3288;
                                                        }
                                                        case 30:
                                                        case 37: {
                                                            array9 = i.bIntArrArr[n38];
                                                            n40 = n39;
                                                            b6 = true;
                                                            break;
                                                        }
                                                        case 16:
                                                        case 19:
                                                        case 43:
                                                        case 49: {
                                                            i.crtStagePlayerLayer[n38][n39] = -1;
                                                            this.jVoid(n38, n39);
                                                            i.cByteArrArr[n38][n39] = 24;
                                                            break Label_3288;
                                                        }
                                                        case 8: {
                                                            i.crtStagePlayerLayer[n38][n39] = 54;
                                                            array9 = i.bIntArrArr[n38];
                                                            n40 = n39;
                                                            b6 = false;
                                                            break;
                                                        }
                                                    }
                                                }
                                                array9[n40] = (b6 ? 1 : 0);
                                                kVoid(n38, n39);
                                            }
                                            if (this.isPlayerAtPosition(n38, n39)) {
                                                this.hurtHero(1, 64, 0);
                                            }
                                        }
                                    }
                                }
                                i.bIntArrArr[beInt7][bfInt8] = n35;
                                i.cByteArrArr[beInt7][bfInt8] = 24;
                                break Label_8485;
                            }
                            case 50: {
                                if (this.jInt < 12 && this.isPlayerAtPosition(this.bEInt, this.bFInt) && !this.jBoolean) {
                                    this.hurtHero(1, 48, (int) i.hByteArr[this.kInt & 0x7]);
                                }
                                break Label_8485;
                            }
                            case 49: {
                                this.eVoid((byte) 49);
                                break Label_8485;
                            }
                            case 48: {
                                if ((i.bIntArrArr[this.bEInt][this.bFInt] & 0x8) == 0x0) {
                                    this.dVoid((byte) 48);
                                    break Label_8485;
                                }
                                this.aiVoid();
                                break Label_8485;
                            }
                            case 46: {
                                final int beInt8 = this.bEInt;
                                final int bfInt9 = this.bFInt;
                                int n41 = i.bIntArrArr[beInt8][bfInt9] & 0x1F;
                                int n42 = (i.bIntArrArr[beInt8][bfInt9] & 0x1FE0) >> 5;
                                final int aInt2 = aInt(i.aClassfArr[29], n41);
                                if ((i.crtStageForegrondLayer[beInt8][bfInt9] & 0xFF) == 0x23) {
                                    if (++n42 > aInt2) {
                                        n42 = 0;
                                    }
                                    i.bIntArrArr[beInt8][bfInt9] = (0x0 | n42 << 5);
                                    break Label_8485;
                                }
                                if (i.crtStagePlayerLayer[beInt8][bfInt9 + 1] < 0 && n41 != 8 && n41 != 9) {
                                    int n43 = 0;
                                    switch (n41) {
                                        case 0:
                                        case 2:
                                        case 4:
                                        case 6: {
                                            n43 = 8;
                                            break;
                                        }
                                        default: {
                                            n43 = 9;
                                            break;
                                        }
                                    }
                                    final int n44 = n43;
                                    i.bByteArrArr[beInt8][bfInt9 + 1] = 18;
                                    i.crtStagePlayerLayer[beInt8][bfInt9 + 1] = 46;
                                    i.crtStagePlayerLayer[beInt8][bfInt9] = -1;
                                    i.bIntArrArr[beInt8][bfInt9 + 1] = n44;
                                    kVoid(beInt8, bfInt9);
                                    break Label_8485;
                                }
                                if (n41 == 8 || n41 == 9) {
                                    final byte[] array10 = i.bByteArrArr[beInt8];
                                    final int n45 = bfInt9;
                                    array10[n45] -= 6;
                                    if (i.bByteArrArr[beInt8][bfInt9] < 0) {
                                        if (i.crtStagePlayerLayer[beInt8][bfInt9 + 1] < 0) {
                                            i.bByteArrArr[beInt8][bfInt9 + 1] = 18;
                                            i.crtStagePlayerLayer[beInt8][bfInt9 + 1] = 46;
                                            i.crtStagePlayerLayer[beInt8][bfInt9] = -1;
                                            i.bIntArrArr[beInt8][bfInt9 + 1] = n41;
                                            kVoid(beInt8, bfInt9);
                                        } else {
                                            i.bIntArrArr[beInt8][bfInt9] = ((n41 == 8) ? 10 : 11);
                                            i.bByteArrArr[beInt8][bfInt9] = 0;
                                        }
                                    } else if (aBoolean(beInt8, bfInt9, 3, i.bByteArrArr[beInt8][bfInt9], this.crtPlayerX, this.crtPlayerY, this.kInt & 0x7, this.jInt)) {
                                        this.hurtHero(1, 48, i.bIntArrArr[beInt8][bfInt9] & 0x7);
                                    }
                                } else if (hBoolean(beInt8, bfInt9)) {
                                    i.crtStagePlayerLayer[beInt8][bfInt9] = -1;
                                    this.jVoid(beInt8, bfInt9);
                                    kVoid(beInt8, bfInt9);
                                } else {
                                    Label_4803:
                                    {
                                        if (this.isPlayerAtPosition(beInt8 - 1, bfInt9) || this.isPlayerAtPosition(beInt8 + 1, bfInt9) || this.isPlayerAtPosition(beInt8, bfInt9 - 1)) {
                                            Label_4035:
                                            {
                                                int n46;
                                                if (this.crtPlayerY == bfInt9 - 1) {
                                                    n46 = 17;
                                                } else if (this.crtPlayerX == beInt8 - 1) {
                                                    n46 = 16;
                                                } else {
                                                    if (this.crtPlayerX != beInt8 + 1) {
                                                        break Label_4035;
                                                    }
                                                    n46 = 15;
                                                }
                                                n41 = n46;
                                            }
                                            n42 = 0;
                                        } else {
                                            final int n47 = this.kInt & 0x7;
                                            if (this.crtPlayerX == beInt8 && this.jInt == 6 && (n47 == 4 || n47 == 2) && this.crtPlayerY < bfInt9 && i.crtStagePlayerLayer[beInt8][bfInt9 - 1] < 0 && bfInt9 * 24 <= this.bInt + 320 - 80) {
                                                int n48 = 0;
                                                switch (n41) {
                                                    case 0:
                                                    case 2: {
                                                        n48 = 6;
                                                        break;
                                                    }
                                                    case 1:
                                                    case 3: {
                                                        n48 = 7;
                                                        break;
                                                    }
                                                    default: {
                                                        break Label_4803;
                                                    }
                                                }
                                                n41 = n48;
                                                n42 = 0;
                                            } else if (this.crtPlayerY == bfInt9 && this.jInt == 6 && (n47 == 1 || n47 == 3) && n41 >= 0 && n41 <= 3 && ((this.crtPlayerX < beInt8 && i.crtStagePlayerLayer[beInt8 - 1][bfInt9] < 0 && beInt8 * 24 < this.aInt + 240) || (this.crtPlayerX > beInt8 && i.crtStagePlayerLayer[beInt8 + 1][bfInt9] < 0 && (beInt8 + 1) * 24 > this.aInt))) {
                                                n41 = ((this.crtPlayerX < beInt8) ? 4 : 5);
                                                n42 = 0;
                                            } else {
                                                ++n42;
                                                Label_4576:
                                                {
                                                    byte[] array11 = null;
                                                    int n50 = 0;
                                                    switch (n41) {
                                                        case 4: {
                                                            final int n49 = beInt8 - 1;
                                                            if (i.crtStagePlayerLayer[n49][bfInt9] < 0 && n42 == bInt(i.aClassfArr[29], 4, 1)) {
                                                                i.crtStagePlayerLayer[n49][bfInt9] = 21;
                                                                i.bIntArrArr[n49][bfInt9] = 4;
                                                                i.bByteArrArr[n49][bfInt9] = 18;
                                                                array11 = i.cByteArrArr[n49];
                                                                n50 = bfInt9;
                                                                break;
                                                            }
                                                            break Label_4576;
                                                        }
                                                        case 5: {
                                                            final int n51 = beInt8 + 1;
                                                            if (i.crtStagePlayerLayer[n51][bfInt9] < 0 && n42 == bInt(i.aClassfArr[29], 5, 1)) {
                                                                i.crtStagePlayerLayer[n51][bfInt9] = 21;
                                                                i.bIntArrArr[n51][bfInt9] = 2;
                                                                i.bByteArrArr[n51][bfInt9] = 18;
                                                                array11 = i.cByteArrArr[n51];
                                                                n50 = bfInt9;
                                                                break;
                                                            }
                                                            break Label_4576;
                                                        }
                                                        case 6:
                                                        case 7: {
                                                            final int n52 = bfInt9 - 1;
                                                            if (i.crtStagePlayerLayer[beInt8][n52] < 0 && n42 == bInt(i.aClassfArr[29], n41, 1)) {
                                                                i.crtStagePlayerLayer[beInt8][n52] = 21;
                                                                i.bIntArrArr[beInt8][n52] = 1;
                                                                i.bByteArrArr[beInt8][n52] = 18;
                                                                array11 = i.cByteArrArr[beInt8];
                                                                n50 = n52;
                                                                break;
                                                            }
                                                            break Label_4576;
                                                        }
                                                    }
                                                    array11[n50] = 24;
                                                }
                                                if (n42 > aInt2) {
                                                    n42 = 0;
                                                    int n53 = 0;
                                                    switch (this.aInt(beInt8, bfInt9, this.crtPlayerX, this.crtPlayerY, false)) {
                                                        case 4: {
                                                            n53 = ((this.crtPlayerY == bfInt9 && n41 != 4 && beInt8 * 24 < this.aInt + 240) ? 4 : 0);
                                                            break;
                                                        }
                                                        case 2: {
                                                            n53 = ((this.crtPlayerY == bfInt9 && n41 != 5 && (beInt8 + 1) * 24 > this.aInt) ? 5 : 1);
                                                            break;
                                                        }
                                                        case 1: {
                                                            if (this.crtPlayerX == beInt8 && n41 != 6 && n41 != 7 && bfInt9 * 24 <= this.bInt + 320 - 80) {
                                                                n41 = ((n41 == 2) ? 6 : 7);
                                                                break Label_4803;
                                                            }
                                                            n41 = ((this.crtPlayerX < beInt8) ? 2 : 3);
                                                            break Label_4803;
                                                        }
                                                        default: {
                                                            n53 = ((this.crtPlayerX >= beInt8) ? 1 : 0);
                                                            break;
                                                        }
                                                    }
                                                    n41 = n53;
                                                }
                                            }
                                        }
                                    }
                                    i.cByteArrArr[beInt8][bfInt9] = 24;
                                    i.bIntArrArr[beInt8][bfInt9] = ((n41 & 0x1F) | n42 << 5);
                                }
                                break Label_8485;
                            }
                            case 45: {
                                final int beInt9 = this.bEInt;
                                final int bfInt10 = this.bFInt;
                                i.cByteArrArr[beInt9][bfInt10] = 24;
                                final int n54 = (i.bIntArrArr[beInt9][bfInt10] & 0x1C00) >> 10;
                                final int n55 = i.bIntArrArr[beInt9][bfInt10] & 0xF;
                                int n56 = 0;
                                final boolean b7 = (i.crtStageForegrondLayer[beInt9][bfInt10] & 0xFF) == 0x23;
                                if (n55 == 10) {
                                    n56 = 100;
                                } else {
                                    for (int a = i.aClassfArr[28].getAnimationFrameCount(n55), n57 = 0; n57 < a; ++n57) {
                                        n56 += i.aClassfArr[28].getAnimationFrameTime(n55, n57);
                                    }
                                }
                                int n58 = (i.bIntArrArr[beInt9][bfInt10] & 0x1FE000) >> 13;
                                ++n58;
                                i.bIntArrArr[beInt9][bfInt10] = ((i.bIntArrArr[beInt9][bfInt10] & 0xFFE01FFF) | n58 << 13);
                                byte[] array12;
                                int n59;
                                int n60;
                                if (n55 >= 4 && n55 <= 9) {
                                    array12 = i.bByteArrArr[beInt9];
                                    n59 = bfInt10;
                                    n60 = 12;
                                } else {
                                    array12 = i.bByteArrArr[beInt9];
                                    n59 = bfInt10;
                                    n60 = 0;
                                }
                                array12[n59] = (byte) n60;
                                if (n58 > n56 >> 1) {
                                    if (!b7) {
                                        if (this.isPlayerAtPosition(beInt9, bfInt10) && n55 != 10) {
                                            int n61 = 0;
                                            switch (n55) {
                                                case 4:
                                                case 5: {
                                                    n61 = 1;
                                                    break;
                                                }
                                                case 6: {
                                                    n61 = 2;
                                                    break;
                                                }
                                                case 7:
                                                case 8: {
                                                    n61 = 3;
                                                    break;
                                                }
                                                case 9: {
                                                    n61 = 4;
                                                    break;
                                                }
                                                default: {
                                                    n61 = i.hByteArr[this.kInt & 0x7];
                                                    break;
                                                }
                                            }
                                            this.hurtHero(1, 48, n61);
                                        }
                                        if (hBoolean(beInt9, bfInt10)) {
                                            i.crtStagePlayerLayer[beInt9][bfInt10] = -1;
                                            this.jVoid(beInt9, bfInt10);
                                            break Label_8485;
                                        }
                                    }
                                    if (n58 >= n56) {
                                        kVoid(beInt9, bfInt10);
                                        final int aInt3 = this.aInt(beInt9, bfInt10, this.crtPlayerX, this.crtPlayerY, true);
                                        int n62 = 0;
                                        switch (n55) {
                                            case 0:
                                            case 3:
                                            case 4:
                                            case 7:
                                            case 9: {
                                                n62 = 1;
                                                break;
                                            }
                                        }
                                        final boolean b8 = aInt3 == 4;
                                        int n63 = 0;
                                        int n64 = 0;
                                        int n65 = 0;
                                        Label_5529:
                                        {
                                            if (n62 != (b8 ? 1 : 0)) {
                                                n63 = (b8 ? 3 : 2);
                                                n64 = beInt9;
                                                n65 = bfInt10;
                                            } else {
                                                n64 = beInt9 - i.gByteArr[aInt3];
                                                n65 = bfInt10 - i.gByteArr[aInt3 + 8];
                                                int n66 = 0;
                                                if (b8) {
                                                    if (this.isPlayerAtPosition(n64, n65) && n55 != 0) {
                                                        n63 = 0;
                                                        n64 = beInt9;
                                                        n65 = bfInt10;
                                                        break Label_5529;
                                                    }
                                                    switch (aInt3) {
                                                        case 1: {
                                                            n66 = 4;
                                                            break;
                                                        }
                                                        case 4: {
                                                            n66 = 9;
                                                            break;
                                                        }
                                                        case 3: {
                                                            n66 = 7;
                                                            break;
                                                        }
                                                        default: {
                                                            n66 = 0;
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    if (this.isPlayerAtPosition(n64, n65) && n55 != 1) {
                                                        n63 = 1;
                                                        n64 = beInt9;
                                                        n65 = bfInt10;
                                                        break Label_5529;
                                                    }
                                                    switch (aInt3) {
                                                        case 1: {
                                                            n66 = 5;
                                                            break;
                                                        }
                                                        case 2: {
                                                            n66 = 6;
                                                            break;
                                                        }
                                                        case 3: {
                                                            n66 = 8;
                                                            break;
                                                        }
                                                        default: {
                                                            n66 = 1;
                                                            break;
                                                        }
                                                    }
                                                }
                                                n63 = n66;
                                            }
                                        }
                                        if (i.crtStagePlayerLayer[n64][n65] >= 0 || b7) {
                                            if (n64 != beInt9 || n65 != bfInt10) {
                                                n63 = 0;
                                            }
                                            n64 = beInt9;
                                            n65 = bfInt10;
                                        }
                                        i.crtStagePlayerLayer[beInt9][bfInt10] = -1;
                                        i.bByteArrArr[n64][n65] = 0;
                                        i.bIntArrArr[n64][n65] = (n54 << 10 | n63);
                                        i.bIntArrArr[n64][n65] &= 0xFFE01FFF;
                                        i.crtStagePlayerLayer[n64][n65] = 45;
                                    }
                                }
                                Label_5806:
                                {
                                    if (b7) {
                                        if (!this.isPlayerAtPosition(beInt9, bfInt10) || n55 == 10) {
                                            break Label_5806;
                                        }
                                    } else {
                                        int n67 = beInt9;
                                        int n68 = bfInt10;
                                        switch (n55) {
                                            case 7:
                                            case 8: {
                                                --n68;
                                                break;
                                            }
                                            case 10: {
                                                n67 = -1;
                                                n68 = -1;
                                                break;
                                            }
                                            case 9: {
                                                ++n67;
                                                break;
                                            }
                                            case 6: {
                                                --n67;
                                            }
                                            case 4:
                                            case 5: {
                                                ++n68;
                                                break;
                                            }
                                        }
                                        if (!this.isPlayerAtPosition(n67, n68)) {
                                            break Label_5806;
                                        }
                                    }
                                    this.hurtHero(1, 48, (int) i.hByteArr[this.kInt & 0x7]);
                                }
                                break Label_8485;
                            }
                            case 44: {
                                this.akVoid();
                                break Label_8485;
                            }
                            case 40: {
                                this.lVoid(40);
                                break Label_8485;
                            }
                            case 36: {
                                final int beInt10 = this.bEInt;
                                final int bfInt11 = this.bFInt;
                                if (i.bIntArrArr[beInt10][bfInt11] == 0) {
                                    if (i.crtStagePlayerLayer[beInt10][bfInt11 - 1] == 11) {
                                        i.bIntArrArr[beInt10][bfInt11] = 1;
                                        this.alVoid();
                                    }
                                } else if (this.isPlayerAtPosition(beInt10, bfInt11 - 1)) {
                                    this.hurtHero(1, 64, 0);
                                }
                                break Label_8485;
                            }
                            case 28: {
                                final int n69 = i.bIntArrArr[this.bEInt][this.bFInt];
                                final int n70 = this.bFInt + ((((n69 & 0x8) == 0x0) ? this.aOInt : this.aQInt) - 1) * (((n69 & 0x7) == 0x3) ? 1 : -1);
                                if (this.isPlayerAtPosition(this.bEInt, n70)) {
                                    this.hurtHero(2, 48, (int) i.hByteArr[this.kInt & 0x7]);
                                }
                                switch (i.crtStagePlayerLayer[this.bEInt][n70]) {
                                    case -1:
                                    case 28:
                                    case 32: {
                                        break;
                                    }
                                    default: {
                                        this.jVoid(this.bEInt, n70);
                                        i.crtStagePlayerLayer[this.bEInt][n70] = -1;
                                        kVoid(this.bEInt, n70);
                                        this.bVoid(this.bEInt, n70);
                                        break;
                                    }
                                }
                                i.cByteArrArr[this.bEInt][this.bFInt] = 24;
                                break Label_8485;
                            }
                            case 16: {
                                final int beInt11 = this.bEInt;
                                final int bfInt12 = this.bFInt;
                                int n71;
                                int n72;
                                if (i.crtStagePlayerLayer[beInt11][bfInt12 + 1] != 16) {
                                    n71 = 0;
                                    n72 = -1;
                                } else {
                                    n71 = 1;
                                    n72 = 0;
                                }
                                final int n73 = n72;
                                byte b9 = i.bByteArrArr[beInt11][bfInt12 + n71];
                                final int n75;
                                final int n74 = (((n75 = i.bIntArrArr[beInt11][bfInt12 + n71]) & 0x7) == 0x4) ? 4 : 2;
                                final boolean b10 = this.isPlayerAtPosition(beInt11 - i.gByteArr[n74], bfInt12 + n71) || this.isPlayerAtPosition(beInt11 - i.gByteArr[n74], bfInt12 + n73);
                                if (b9 <= 0 && b10 && this.jInt <= 12) {
                                    b9 = 36;
                                } else if (b9 > 0) {
                                    if (n71 == 0) {
                                        --b9;
                                    }
                                    if ((b9 == 11 || (n71 == 0 && b9 < 11)) && b10) {
                                        this.hurtHero(1, 48, n75 & 0x7);
                                    }
                                    i.cByteArrArr[beInt11][bfInt12] = 24;
                                }
                                if (hBoolean(beInt11, bfInt12)) {
                                    this.playSound(14);
                                    i.crtStagePlayerLayer[beInt11][bfInt12 + n73] = -1;
                                    this.jVoid(beInt11, bfInt12 + n73);
                                    i.crtStagePlayerLayer[beInt11][bfInt12 + n71] = -1;
                                    this.jVoid(beInt11, bfInt12 + n71);
                                    break Label_8485;
                                }
                                i.bIntArrArr[beInt11][bfInt12 + n73] = n75;
                                i.bIntArrArr[beInt11][bfInt12 + n71] = n75;
                                if (n71 == 0) {
                                    i.bByteArrArr[beInt11][bfInt12 + n73] = b9;
                                    i.bByteArrArr[beInt11][bfInt12 + n71] = b9;
                                }
                                break Label_8485;
                            }
                            case 14: {
                                final int beInt12 = this.bEInt;
                                final int bfInt13 = this.bFInt;
                                int n77;
                                final int n76 = (n77 = i.bIntArrArr[beInt12][bfInt13]) >> 8 & 0xFF;
                                int n78 = ((n77 & 0x8) != 0x0) ? 4 : 2;
                                Label_7035:
                                {
                                    if (n76 >= 20) {
                                        if (fBoolean(beInt12, bfInt13 + 1) || (n78 == 4 && (i.crtStagePlayerLayer[beInt12 - 1][bfInt13] < 0 || i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 16 || i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 19 || i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 43)) || (n78 == 2 && (i.crtStagePlayerLayer[beInt12 + 1][bfInt13] < 0 || i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 16 || i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 19 || i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 43))) {
                                            i.bIntArrArr[beInt12][bfInt13] = ((n77 & 0xFFFF00FF) | 0x1300);
                                        }
                                    } else {
                                        byte[] array13;
                                        int n79;
                                        int n80;
                                        if (n76 > 0) {
                                            i.bIntArrArr[beInt12][bfInt13] = ((n77 & 0xFFFF00FF) | n76 - 1 << 8);
                                            array13 = i.cByteArrArr[beInt12];
                                            n79 = bfInt13;
                                            n80 = 24;
                                        } else {
                                            final byte b11;
                                            if ((b11 = i.bByteArrArr[beInt12][bfInt13]) <= 0) {
                                                int n81 = beInt12;
                                                int n82 = bfInt13;
                                                Label_6947:
                                                {
                                                    if (fBoolean(beInt12, bfInt13 + 1)) {
                                                        n82 = bfInt13 + 1;
                                                        n78 = 3;
                                                    } else {
                                                        if (n78 == 4) {
                                                            if (fBoolean(beInt12 - 1, bfInt13)) {
                                                                n81 = beInt12 - 1;
                                                                break Label_6947;
                                                            }
                                                            n78 = 0;
                                                            if (i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 16 || i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 19 || i.crtStagePlayerLayer[beInt12 - 1][bfInt13] == 43) {
                                                                break Label_6947;
                                                            }
                                                        } else {
                                                            if (fBoolean(beInt12 + 1, bfInt13)) {
                                                                n81 = beInt12 + 1;
                                                                break Label_6947;
                                                            }
                                                            n78 = 0;
                                                            if (i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 16 || i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 19 || i.crtStagePlayerLayer[beInt12 + 1][bfInt13] == 43) {
                                                                break Label_6947;
                                                            }
                                                        }
                                                        n77 = ((n77 & 0xFFFF00FF) | 0x1400);
                                                    }
                                                }
                                                if (n81 != beInt12 || n82 != bfInt13) {
                                                    i.crtStagePlayerLayer[n81][n82] = 14;
                                                    kVoid(n81, n82);
                                                    i.crtStagePlayerLayer[beInt12][bfInt13] = -1;
                                                    i.bByteArrArr[n81][n82] = 18;
                                                }
                                                i.bIntArrArr[n81][n82] = ((n77 & 0xFFFFFFF8) | n78);
                                                break Label_7035;
                                            }
                                            array13 = i.bByteArrArr[beInt12];
                                            n79 = bfInt13;
                                            n80 = (byte) (b11 - 6);
                                        }
                                        array13[n79] = (byte) n80;
                                    }
                                }
                                if (this.isPlayerAtPosition(beInt12, bfInt13)) {
                                    this.hurtHero(1, 48, n78);
                                }
                                break Label_8485;
                            }
                            case 10: {
                                final int beInt13 = this.bEInt;
                                final int bfInt14 = this.bFInt;
                                if (i.bIntArrArr[beInt13][bfInt14] > 0) {
                                    i.crtStagePlayerLayer[beInt13][bfInt14] = -1;
                                    i.crtStageForegrondLayer[beInt13][bfInt14] = 32;
                                    kVoid(beInt13, bfInt14);
                                    this.lVoid(beInt13, bfInt14);
                                    i.cByteArrArr[beInt13][bfInt14] = 24;
                                }
                                break Label_8485;
                            }
                            case 21: {
                                final int beInt14 = this.bEInt;
                                final int bfInt15 = this.bFInt;
                                final int n83 = i.bIntArrArr[beInt14][bfInt15] & 0x7;
                                int n86;
                                byte b12;
                                byte[] array18 = null;
                                if ((i.bIntArrArr[beInt14][bfInt15] & 0x8) != 0x0) {
                                    int n84 = 0;
                                    switch (n83) {
                                        case 4: {
                                            n84 = 12;
                                            break;
                                        }
                                        case 2: {
                                            n84 = 13;
                                            break;
                                        }
                                        default: {
                                            n84 = 14;
                                            break;
                                        }
                                    }
                                    if (i.bByteArrArr[beInt14][bfInt15] >= aInt(i.aClassfArr[29], n84) || (i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xFF) == 0x23) {
                                        i.crtStagePlayerLayer[beInt14][bfInt15] = -1;
                                        kVoid(beInt14, bfInt15);
                                    } else {
                                        final byte[] array14 = i.bByteArrArr[beInt14];
                                        final int n85 = bfInt15;
                                        ++array14[n85];
                                    }
                                    final byte[] array15 = i.cByteArrArr[beInt14];
                                    n86 = bfInt15;
                                    b12 = 24;
                                } else {
                                    if (this.isPlayerAtPosition(beInt14, bfInt15) || (this.isPlayerAtPosition(beInt14 + i.gByteArr[n83], bfInt15 + i.gByteArr[n83 + 8]) && i.bByteArrArr[beInt14][bfInt15] <= this.jInt)) {
                                        this.hurtHero(1, 48, 0);
                                    }
                                    if (i.bByteArrArr[beInt14][bfInt15] <= 0) {
                                        final int n87 = beInt14 - i.gByteArr[n83];
                                        final int n88 = bfInt15 - i.gByteArr[n83 + 8];
                                        byte b13 = 24;
                                        if (n83 == 4) {
                                            b13 = 12;
                                        }
                                        byte[] array16;
                                        byte b14;
                                        int n89;
                                        if (i.crtStagePlayerLayer[n87][n88] < 0) {
                                            i.crtStagePlayerLayer[n87][n88] = 21;
                                            i.bIntArrArr[n87][n88] = i.bIntArrArr[beInt14][bfInt15];
                                            i.bByteArrArr[n87][n88] = b13;
                                            array16 = i.crtStagePlayerLayer[beInt14];
                                            b14 = (byte) bfInt15;
                                            n89 = -1;
                                        } else if (i.crtStagePlayerLayer[n87][n88] == 21) {
                                            final int n90 = i.bIntArrArr[n87][n88] & 0x7;
                                            final int n91 = n87 - i.gByteArr[n90];
                                            final int n92 = n88 - i.gByteArr[n90 + 8];
                                            i.crtStagePlayerLayer[beInt14][bfInt15] = -1;
                                            kVoid(beInt14, bfInt15);
                                            final int n93 = i.bIntArrArr[beInt14][bfInt15];
                                            if (i.crtStagePlayerLayer[n91][n92] < 0) {
                                                i.crtStagePlayerLayer[n91][n92] = 21;
                                                i.bIntArrArr[n91][n92] = i.bIntArrArr[n87][n88];
                                                i.bByteArrArr[n91][n92] = 18;
                                            }
                                            i.crtStagePlayerLayer[n87][n88] = 21;
                                            i.bIntArrArr[n87][n88] = n93;
                                            array16 = i.bByteArrArr[n87];
                                            b14 = (byte) n88;
                                            n89 = 18;
                                        } else {
                                            switch (i.crtStagePlayerLayer[n87][n88]) {
                                                case 19:
                                                case 43:
                                                case 45:
                                                case 46: {
                                                    i.crtStagePlayerLayer[n87][n88] = -1;
                                                    this.jVoid(n87, n88);
                                                    break;
                                                }
                                                case 10:
                                                case 30: {
                                                    if (i.bIntArrArr[n87][n88] < 1) {
                                                        i.bIntArrArr[n87][n88] = 1;
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            final int[] array17 = i.bIntArrArr[beInt14];
                                            final byte b15 = (byte) bfInt15;
                                            array17[b15] |= 0x8;
                                            array16 = i.bByteArrArr[beInt14];
                                            b14 = (byte) bfInt15;
                                            n89 = 0;
                                        }
                                        array16[b14] = (byte) n89;
                                        final byte[] array15 = i.cByteArrArr[n87];
                                        n86 = n88;
                                        b12 = 48;
                                    } else {
                                        array18 = i.bByteArrArr[beInt14];
                                        b12 = (byte) (array18[n86 = bfInt15] - 12);
                                    }
                                }
                                array18[n86] = b12;
                                break Label_8485;
                            }
                            case 32: {
                                this.anVoid();
                                break Label_8485;
                            }
                            case 11: {
                                this.amVoid();
                                break Label_8485;
                            }
                            case 37: {
                                final int beInt15 = this.bEInt;
                                final int bfInt16 = this.bFInt;
                                final int n94;
                                if ((n94 = i.bIntArrArr[beInt15][bfInt16]) > 0) {
                                    if (n94 >= 8) {
                                        this.lVoid(beInt15, bfInt16);
                                        i.crtStagePlayerLayer[beInt15][bfInt16] = -1;
                                        kVoid(beInt15, bfInt16);
                                    }
                                    i.bIntArrArr[beInt15][bfInt16] = n94 + 1;
                                    i.cByteArrArr[beInt15][bfInt16] = 24;
                                }
                                break Label_8485;
                            }
                            case 30: {
                                final int n95;
                                if ((n95 = i.bIntArrArr[this.bEInt][this.bFInt]) > 0) {
                                    final int beInt16 = this.bEInt;
                                    final int bfInt17 = this.bFInt;
                                    if (n95 == 4) {
                                        for (int n96 = 1; n96 < 5; ++n96) {
                                            final byte b16 = i.gByteArr[n96];
                                            final byte b17 = i.gByteArr[n96 + 8];
                                            if (i.crtStagePlayerLayer[beInt16 + b16][bfInt17 + b17] == 30) {
                                                final int[] array19 = i.bIntArrArr[beInt16 + b16];
                                                final int n97 = bfInt17 + b17;
                                                ++array19[n97];
                                                i.cByteArrArr[beInt16 + b16][bfInt17 + b17] = 24;
                                            }
                                        }
                                    } else if (n95 >= 16) {
                                        i.crtStagePlayerLayer[beInt16][bfInt17] = -1;
                                        kVoid(beInt16, bfInt17);
                                    }
                                    i.bIntArrArr[beInt16][bfInt17] = n95 + 1;
                                    i.cByteArrArr[beInt16][bfInt17] = 24;
                                }
                                break Label_8485;
                            }
                            case 24: {
                                this.mVoid(24);
                                break Label_8485;
                            }
                            case 27: {
                                this.mVoid(27);
                                break Label_8485;
                            }
                            case 26: {
                                this.mVoid(26);
                                break Label_8485;
                            }
                            case 43: {
                                this.eVoid((byte) 43);
                                break Label_8485;
                            }
                            case 19: {
                                this.eVoid((byte) 19);
                                break Label_8485;
                            }
                            case 42: {
                                this.lVoid(42);
                                break Label_8485;
                            }
                            case 2: {
                                this.lVoid(2);
                                break Label_8485;
                            }
                            case 53: {
                                this.lVoid(53);
                                break Label_8485;
                            }
                            case 51: {
                                this.lVoid(51);
                                break Label_8485;
                            }
                            case 52: {
                                this.lVoid(52);
                                break Label_8485;
                            }
                            case 5: {
                                this.lVoid(5);
                                break Label_8485;
                            }
                            case 4: {
                                this.lVoid(4);
                                break Label_8485;
                            }
                            case 6: {
                                this.lVoid(6);
                                break Label_8485;
                            }
                            case 7: {
                                this.lVoid(7);
                                break Label_8485;
                            }
                            case 41: {
                                this.lVoid(41);
                                break Label_8485;
                            }
                            case 47: {
                                this.aqVoid();
                                this.ajVoid();
                                break Label_8485;
                            }
                            case 1: {
                                this.aqVoid();
                                break Label_8485;
                            }
                            case 0: {
                                this.aqVoid();
                                break Label_8485;
                            }
                            case 9: {
                                Label_8366:
                                {
                                    if ((i.bIntArrArr[this.bEInt][this.bFInt] & 0xFC00000) == 0x8400000) {
                                        i.cByteArrArr[this.bEInt][this.bFInt] = 24;
                                        Label_8332:
                                        {
                                            i i8;
                                            int auInt;
                                            if (this.auInt > 0) {
                                                i8 = this;
                                                auInt = this.auInt - 1;
                                            } else {
                                                if (this.auInt >= 0) {
                                                    break Label_8332;
                                                }
                                                i8 = this;
                                                auInt = this.auInt + 1;
                                            }
                                            i8.auInt = auInt;
                                        }
                                        i i9;
                                        int avInt;
                                        if (this.avInt > 0) {
                                            i9 = this;
                                            avInt = this.avInt - 1;
                                        } else {
                                            if (this.avInt >= 0) {
                                                break Label_8366;
                                            }
                                            i9 = this;
                                            avInt = this.avInt + 1;
                                        }
                                        i9.avInt = avInt;
                                    }
                                }
                                this.aqVoid();
                                break Label_8485;
                            }
                            case 8: {
                                this.aqVoid();
                                break Label_8485;
                            }
                            case 23: {
                                i10 = this;
                                i11 = this;
                                n98 = 23;
                                break;
                            }
                            case 22: {
                                i10 = this;
                                i11 = this;
                                n98 = 22;
                                break;
                            }
                        }
                        final int n99 = n5;
                        final int n100 = n98;
                        final i i12 = i11;
                        final int beInt17 = i10.bEInt;
                        final int bfInt18 = i12.bFInt;
                        final int n101 = (n100 == 23) ? -1 : 1;
                        i.cByteArrArr[beInt17][bfInt18] = 24;
                        if (i12.crtPlayerY == bfInt18) {
                            for (int n102 = 0; n102 <= n99; ++n102) {
                                if (i12.crtPlayerX == beInt17 + n102 * n101) {
                                    i12.hurtHero(1, 64, 0);
                                }
                            }
                        }
                    }
                }
                j = this;
                beInt = this.bEInt + 1;
            }
            i = this;
            bfInt = this.bFInt - 1;
        }
    }

    private void aiVoid() {
        final int beInt = this.bEInt;
        final int bfInt;
        int n2 = 0;
        Label_0078:
        {
            final int n;
            int n3 = 0;
            switch ((n = i.bIntArrArr[beInt][(bfInt = this.bFInt) + 1]) & 0x7) {
                case 4: {
                    n2 = beInt + 1;
                    break Label_0078;
                }
                case 2: {
                    n3 = beInt;
                    break;
                }
                default: {
                    if ((n & 0x10) == 0x0) {
                        n2 = beInt + 1;
                        break Label_0078;
                    }
                    n3 = beInt;
                    break;
                }
            }
            n2 = n3 - 1;
        }
        final int n4 = n2;
        final int n5 = (i.bIntArrArr[beInt][bfInt] >> 24) * 3;
        byte[] array;
        int n6;
        int n7;
        if (i.crtStagePlayerLayer[n4][bfInt] < 0) {
            i.eByteArr[n5 + 2] = (byte) bfInt;
            i.eByteArr[n5 + 1] = (byte) n4;
            array = i.eByteArr;
            n6 = n5;
            n7 = (byte) n4;
        } else {
            array = i.eByteArr;
            n6 = n5 + 2;
            n7 = -1;
        }
        array[n6] = (byte) n7;
    }

    private void dVoid(final byte b) {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        if (i.bByteArrArr[beInt][bfInt] == 6 && (i.crtStageForegrondLayer[beInt][bfInt] & 0xFF) == 0x6) {
            this.hVoid(i.crtStageForegrondLayer[beInt][bfInt] >> 8);
        }
        if (i.bByteArrArr[beInt][bfInt] <= 0) {
            int n2 = 0;
            Label_0099:
            {
                final int n;
                int n3;
                if ((n = ((n2 = i.bIntArrArr[beInt][bfInt]) & 0x7)) == 2) {
                    n3 = (n2 | 0x10);
                } else {
                    if (n != 4) {
                        break Label_0099;
                    }
                    n3 = (n2 & 0xFFFFFFEF);
                }
                n2 = n3;
            }
            final int n4 = bfInt + 1;
            if (i.crtStagePlayerLayer[beInt][n4] < 0 && (!this.isPlayerAtPosition(beInt, n4) || this.aWInt != 0)) {
                i.crtStagePlayerLayer[beInt][bfInt - 1] = -1;
                i.crtStagePlayerLayer[beInt][n4] = 48;
                i.bIntArrArr[beInt][n4] = ((n2 & 0xFFFFFFF8) | 0x3);
                i.bIntArrArr[beInt][bfInt] = (i.bIntArrArr[beInt][bfInt - 1] | 0x8);
                i.bByteArrArr[beInt][n4] = 18;
                final int n5 = bfInt - 2;
                i.cByteArrArr[beInt - 1][n5] = 48;
                i.cByteArrArr[beInt][n5] = 48;
                i.cByteArrArr[beInt + 1][n5] = 48;
                kVoid(beInt, bfInt);
                this.aiVoid();
            } else {
                if ((n2 & 0x7) == 0x3 && this.isPlayerAtPosition(beInt, n4)) {
                    this.hurtHero(2, 48, 0);
                }
                i.bIntArrArr[beInt][bfInt] = (n2 & 0xFFFFFFF8);
            }
        } else {
            final byte[] array = i.bByteArrArr[beInt];
            final int n6 = bfInt;
            array[n6] -= 6;
        }
        i.cByteArrArr[beInt][bfInt] = 24;
        i.cByteArrArr[beInt][bfInt - 1] = 24;
    }

    private static boolean dBoolean(int n, final int n2) {
        final byte b = i.crtStagePlayerLayer[n][n2];
        n = (i.crtStageForegrondLayer[n][n2] & 0xFF);
        return b < 80 && b != 30 && b != 10 && b != 37 && b != 34 && b != 35 && n != 14 && n != 33 && n != 15 && n != 4 && n != 16;
    }

    private static boolean eBoolean(int n, final int n2) {
        final byte b = i.crtStagePlayerLayer[n][n2];
        n = (i.crtStageForegrondLayer[n][n2] & 0xFF);
        return b == -1 && n != 14 && n != 33 && n != 5 && n != 28;
    }

    private static boolean fBoolean(final int n, final int n2) {
        final byte b = i.crtStagePlayerLayer[n][n2];
        final int n3 = i.crtStageForegrondLayer[n][n2] & 0xFF;
        return b == -1 && n3 != 14 && n3 != 33 && n3 != 4 && n3 != 32 && (n3 != 7 || (i.crtStageForegrondLayer[n][n2] >> 8 & 0xF0) != 0x0);
    }

    private void ajVoid() {
        final int n = this.bFInt - 1;
        final boolean b = i.eIntArrArr != null && i.eIntArrArr[this.bEInt][this.bFInt] != 0 && i.eIntArrArr[this.bEInt][this.bFInt - 1] == 0;
        if ((i.crtStageForegrondLayer[this.bEInt][n] & 0xFF) != 0x23 && dBoolean(this.bEInt, n) && ((!this.isPlayerAtPosition(this.bEInt - 1, this.bFInt) && !this.isPlayerAtPosition(this.bEInt + 1, this.bFInt)) || (this.kInt & 0x8) == 0x0) && (i.crtStagePlayerLayer[this.bEInt][this.bFInt + 1] >= 0 || b)) {
            System.out.println("In ProcessWindPod condition throw");
            i.crtStageForegrondLayer[this.bEInt][n] = 35;
            i.bByteArrArr[this.bEInt][n] = 18;
            i.cByteArrArr[this.bEInt][n] = 24;
        }
    }

    private static int aInt(final f_Sprite f, final int n) {
        int n2 = 0;
        final int n3 = f.animationAnimationFrameCounts[n] & 0xFF;
        for (short n4 = 0; n4 < n3; ++n4) {
            n2 += (f.animationFrames[(f.animationFirstAnimationFrameIndices[n] + n4) * 5 + 1] & 0xFF);
        }
        return n2;
    }

    private void akVoid() {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        i.cByteArrArr[beInt][bfInt] = 24;
        byte[] array3 = null;
        int n4 = 0;
        int n5 = 0;
        switch ((i.bIntArrArr[beInt][bfInt] & 0x38) >> 3) {
            case 0: {
                if ((this.crtPlayerX != beInt || (bfInt + 1) * 24 <= this.bInt || this.kByte == 3) && (this.kByte != 3 || this.kLong == 0L || i.aSInt < this.kLong + (21 - beInt))) {
                    return;
                }
                int n = bfInt + 1;
                while (true) {
                    final byte b = i.crtStagePlayerLayer[beInt][n];
                    if (this.crtPlayerY == n || b >= 80 || b == 30 || b == 34 || b == 35 || b == 0) {
                        break;
                    }
                    ++n;
                }
                if (this.crtPlayerY == n || this.kByte == 3) {
                    i.bIntArrArr[beInt][bfInt] = ((i.bIntArrArr[beInt][bfInt] & 0xFFFFFFC7) | 0x8);
                    i.bByteArrArr[beInt][bfInt] = 10;
                }
                return;
            }
            case 1: {
                final byte[] array = i.bByteArrArr[beInt];
                final int n2 = bfInt;
                --array[n2];
                if (i.bByteArrArr[beInt][bfInt] <= 0) {
                    i.crtStageForegrondLayer[beInt][bfInt] = 34;
                    i.bIntArrArr[beInt][bfInt] = ((i.bIntArrArr[beInt][bfInt] & 0xFFFFFFC0) | 0x18 | 0x3);
                    i.bByteArrArr[beInt][bfInt] = 0;
                }
                return;
            }
            case 3: {
                if (i.bByteArrArr[beInt][bfInt] > 0) {
                    final byte[] array2 = i.bByteArrArr[beInt];
                    final int n3 = bfInt;
                    array2[n3] -= 5;
                    return;
                }
                final boolean cBoolean = this.isPlayerAtPosition(beInt, bfInt + 1);
                boolean b2 = false;
                if (cBoolean || i.crtStagePlayerLayer[beInt][bfInt + 1] >= 0 || (this.lBoolean && i.eIntArrArr[beInt][bfInt + 1] != 0)) {
                    if (cBoolean) {
                        this.hurtHero(1, 48, 0);
                        b2 = true;
                    } else {
                        b2 = true;
                        switch (i.crtStagePlayerLayer[beInt][bfInt + 1]) {
                            case 10: {
                                i.crtStageForegrondLayer[beInt][bfInt + 1] = 32;
                                this.bVoid(beInt, bfInt + 1);
                                b2 = false;
                                break;
                            }
                            case 19:
                            case 43:
                            case 45:
                            case 46:
                            case 49: {
                                this.jVoid(beInt, bfInt + 1);
                                i.crtStagePlayerLayer[beInt][bfInt + 1] = -1;
                                break;
                            }
                            case 30: {
                                this.playSound(11);
                                i.bIntArrArr[beInt][bfInt + 1] = 1;
                                break;
                            }
                            case 18: {
                                this.dBoolean();
                                break;
                            }
                            case 21: {
                                b2 = false;
                                break;
                            }
                            default: {
                                this.playSound(14);
                                break;
                            }
                        }
                    }
                }
                if (b2) {
                    i.bIntArrArr[beInt][bfInt] = ((i.bIntArrArr[beInt][bfInt] & 0xFFFFFFC0) | 0x20);
                    i.bByteArrArr[beInt][bfInt] = 0;
                    return;
                }
                i.crtStagePlayerLayer[beInt][bfInt] = -1;
                i.crtStagePlayerLayer[beInt][bfInt + 1] = 44;
                i.bIntArrArr[beInt][bfInt + 1] = i.bIntArrArr[beInt][bfInt];
                array3 = i.bByteArrArr[beInt];
                n4 = bfInt + 1;
                n5 = 19;
                break;
            }
            case 4: {
                if ((i.aSInt & 0x1) != 0x0) {
                    return;
                }
                final byte[] array4 = i.bByteArrArr[beInt];
                final int n6 = bfInt;
                ++array4[n6];
                if (i.bByteArrArr[beInt][bfInt] == i.aClassfArr[27].getAnimationFrameCount(4)) {
                    array3 = i.crtStagePlayerLayer[beInt];
                    n4 = bfInt;
                    n5 = -1;
                    break;
                }
                return;
            }
        }
        array3[n4] = (byte) n5;
        kVoid(beInt, bfInt);
    }

    private void lVoid(final int aiInt) {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        if (this.jInt > 0 || !this.isPlayerAtPosition(beInt, bfInt)) {
            return;
        }
        final int n;
        if (((n = (i.crtStageForegrondLayer[beInt][bfInt] & 0xFF)) == 14 || n == 33) && i.crtStageForegrondLayer[beInt][bfInt] >> 8 == 255) {
            return;
        }
        Label_0429:
        {
            i i = null;
            int agInt = 0;
            switch (this.aIInt = aiInt) {
                case 40: {
                    this.aFInt = 19;
                    this.aGInt = 0;
                    i.crtStagePlayerLayer[this.bEInt][this.bFInt] = -1;
                    this.aIInt = 40;
                    i.iByteArr[10] = 1;
                    break Label_0429;
                }
                case 42: {
                    this.aFInt = 29;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 41: {
                    this.aFInt = 2;
                    this.aGInt = 0;
                    this.aHInt = i.bIntArrArr[this.bEInt][this.bFInt];
                    break Label_0429;
                }
                case 4: {
                    this.aFInt = 24;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 5: {
                    this.aFInt = 25;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 2: {
                    this.aFInt = 3;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 53: {
                    this.aFInt = 32;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 51: {
                    this.aFInt = 30;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 52: {
                    this.aFInt = 31;
                    i = this;
                    agInt = 0;
                    break;
                }
                case 6: {
                    if (this.azInt < 99) {
                        this.aFInt = 5;
                        i = this;
                        agInt = 0;
                        break;
                    }
                    i.crtStagePlayerLayer[beInt][bfInt] = 7;
                    i.bIntArrArr[beInt][bfInt] = 0;
                    this.lVoid(7);
                    break Label_0429;
                }
                case 7: {
                    if (this.nByte == i.iByteArr[8]) {
                        i.crtStagePlayerLayer[beInt][bfInt] = 41;
                        i.bIntArrArr[beInt][bfInt] = 10;
                        final i j = this;
                        j.aYInt += 10;
                        this.lVoid(41);
                        break Label_0429;
                    }
                    this.aFInt = 5;
                    i = this;
                    agInt = 1;
                    break;
                }
            }
            i.aGInt = agInt;
        }
        i.crtStagePlayerLayer[beInt][bfInt] = -1;
        this.oBoolean = true;
    }

    private boolean gBoolean(final int n, final int n2) {
        return i.crtStagePlayerLayer[n][n2] == 28 || (this.aNInt >= 24 && ((i.crtStagePlayerLayer[n][n2 - 1] == 28 && (i.bIntArrArr[n][n2 - 1] & 0x8) == 0x0) || (i.crtStagePlayerLayer[n][n2 + 1] == 28 && (i.bIntArrArr[n][n2 + 1] & 0x8) == 0x0))) || (this.aPInt >= 24 && (i.crtStagePlayerLayer[n][n2 - 1] == 28 || i.crtStagePlayerLayer[n][n2 + 1] == 28));
    }

    private int aInt(final int n, final int n2, int n3, int n4, final boolean b) {
        n3 = n - n3;
        n4 = n2 - n4;
        final int n5 = (n3 > 0) ? n3 : (-n3);
        final int n6 = (n4 > 0) ? n4 : (-n4);
        int n7 = 0;
        if (n5 > n6) {
            Label_0062:
            {
                int n8;
                if (n3 > 0) {
                    n8 = 4;
                } else {
                    if (n3 >= 0) {
                        break Label_0062;
                    }
                    n8 = 2;
                }
                n7 = n8;
            }
            if (n7 != 0 && (!fBoolean(n - i.gByteArr[n7], n2) || this.gBoolean(n - i.gByteArr[n7], n2))) {
                n7 = 0;
            }
        }
        if (n7 == 0) {
            Label_0123:
            {
                int n9;
                if (n4 > 0) {
                    n9 = 1;
                } else {
                    if (n4 >= 0) {
                        break Label_0123;
                    }
                    n9 = 3;
                }
                n7 = n9;
            }
            n4 = n2 - i.gByteArr[n7 + 8];
            if (b && n7 != 0 && (!fBoolean(n, n4) || (this.lBoolean && i.eIntArrArr[n][n4] != 0) || this.gBoolean(n, n4))) {
                n7 = 0;
                Label_0201:
                {
                    int n10;
                    if (n3 > 0) {
                        n10 = 4;
                    } else {
                        if (n3 >= 0) {
                            break Label_0201;
                        }
                        n10 = 2;
                    }
                    n7 = n10;
                }
                if (n7 != 0 && i.crtStagePlayerLayer[n - i.gByteArr[n7]][n2] >= 0) {
                    n7 = 0;
                }
            }
        }
        return n7;
    }

    private void eVoid(final byte b) {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        int n = i.bIntArrArr[beInt][bfInt];
        byte b2 = i.bByteArrArr[beInt][bfInt];
        int n2 = 0;
        int n3 = 0;
        final boolean b3 = (i.crtStageForegrondLayer[beInt][bfInt] & 0xFF) == 0x23;
        final boolean b4 = b == 43 && (n & 0xF00) != 0x0;
        if (!b3 && hBoolean(beInt, bfInt)) {
            i.crtStagePlayerLayer[beInt][bfInt] = -1;
            this.jVoid(beInt, bfInt);
            return;
        }
        int n4 = n & 0x7;
        Label_0771:
        {
            byte[] array;
            int n12;
            byte b5;
            if (b2 <= 0) {
                Label_0600:
                {
                    if (b3 && b2 <= 6) {
                        if (b2 < 0) {
                            i.bByteArrArr[beInt][bfInt] = 0;
                        }
                    } else {
                        kVoid(beInt, bfInt);
                        if (b4) {
                            b2 = 18;
                            final int aInt = this.aInt(beInt, bfInt, this.crtPlayerX, this.crtPlayerY, true);
                            final int n5 = (n & 0xFFFFFFF8) | aInt;
                            n4 = aInt;
                            n2 = -i.gByteArr[aInt];
                            n3 = -i.gByteArr[aInt + 8];
                            if (aInt == 0) {
                                b2 = 0;
                                n3 = (n2 = 0);
                            }
                            n = n5 - 256;
                        } else {
                            Label_0594:
                            {
                                if ((n & 0xFE0000) != 0x0 && (n & 0xF8) == 0x0) {
                                    final int n6 = (n & 0xFE0000) >> 17;
                                    final int n7 = (n & 0x7F000000) >> 24;
                                    if (beInt == n6 && bfInt == n7) {
                                        final int n8;
                                        n4 = ((((n8 = (n & 0xFF01FFFF)) & Integer.MIN_VALUE) == 0x0) ? 2 : 1);
                                        n = ((n8 & 0xFFFFFFF8) | n4);
                                        break Label_0600;
                                    }
                                    b2 = 21;
                                    final int aInt2 = this.aInt(beInt, bfInt, n6, n7, true);
                                    n = ((n & 0xFFFFFFF8) | aInt2);
                                    n2 = -i.gByteArr[aInt2];
                                    n3 = -i.gByteArr[aInt2 + 8];
                                    if ((n4 = aInt2) != 0) {
                                        break Label_0600;
                                    }
                                    b2 = 0;
                                } else if (n4 == 0) {
                                    b2 = 21;
                                    final int n9 = (n & 0x7000) >> 12;
                                    n = ((n & 0xFFFFFFF8) | n9);
                                    n4 = n9;
                                    n2 = -i.gByteArr[n4];
                                    n3 = -i.gByteArr[n4 + 8];
                                    if (!fBoolean(beInt + n2, bfInt + n3)) {
                                        n3 = (n2 = 0);
                                        b2 = 0;
                                    }
                                    break Label_0600;
                                } else {
                                    b2 = 21;
                                    n2 = -i.gByteArr[n4];
                                    n3 = -i.gByteArr[n4 + 8];
                                    if (!fBoolean(beInt + n2, bfInt + n3)) {
                                        while (true) {
                                            int n10 = 0;
                                            int n11 = 0;
                                            switch (n4) {
                                                case 4: {
                                                    n10 = (n & 0xFFFF8FFF);
                                                    n11 = 8192;
                                                    break;
                                                }
                                                case 2: {
                                                    n10 = (n & 0xFFFF8FFF);
                                                    n11 = 16384;
                                                    break;
                                                }
                                                case 1: {
                                                    n10 = (n & 0xFFFF8FFF);
                                                    n11 = 12288;
                                                    break;
                                                }
                                                case 3: {
                                                    n10 = (n & 0xFFFF8FFF);
                                                    n11 = 4096;
                                                    break;
                                                }
                                                default: {
                                                    n &= 0xFFFFFFF8;
                                                    n4 = 0;
                                                    break Label_0594;
                                                }
                                            }
                                            n = (n10 | n11);
                                            continue;
                                        }
                                    }
                                    break Label_0600;
                                }
                            }
                            n3 = (n2 = 0);
                        }
                    }
                }
                if ((n & 0xF8) == 0x0) {
                    i.crtStagePlayerLayer[beInt][bfInt] = -1;
                    i.crtStagePlayerLayer[beInt + n2][bfInt + n3] = b;
                    i.cByteArrArr[beInt + n2][bfInt + n3] = 48;
                    i.bByteArrArr[beInt + n2][bfInt + n3] = b2;
                    i.bIntArrArr[beInt + n2][bfInt + n3] = n;
                    break Label_0771;
                }
                if ((i.aSInt & 0x3) == 0x0) {
                    n = ((n & 0xFFFFFF07) | (n & 0xF8) - 8);
                    if (b == 43 && (n & 0xF8) == 0x0) {
                        n = ((n & 0xFFFFF0FF) | 0xC00);
                    }
                }
                array = i.bByteArrArr[beInt];
                n12 = bfInt;
                b5 = 0;
            } else {
                if (b2 < 0) {
                    i.bByteArrArr[beInt][bfInt] = 0;
                }
                final byte b6 = (byte) (b2 - 3);
                array = i.bByteArrArr[beInt];
                n12 = bfInt;
                b5 = b6;
            }
            array[n12] = b5;
        }
        if ((n & 0xF8) == 0x0 && (i.aClassbArr[0].crtAnimationI < 13 || i.aClassbArr[0].crtAnimationI > 16) && aBoolean(beInt, bfInt, n4, i.bByteArrArr[beInt][bfInt], this.crtPlayerX, this.crtPlayerY, ((this.kInt & 0x1000) == 0x0) ? this.lByte : 0, this.jInt)) {
            this.hurtHero(1, 48, n4);
            if (b4) {
                n &= 0xFFFFF0FF;
            }
        }
        i.bIntArrArr[beInt][bfInt] = n;
    }

    private void alVoid() {
        if ((this.kByte == 3 || this.kByte == 4 || this.kByte == 5) && this.aqInt > 0) {
            return;
        }
        if (i.cmInt >= 0) {
            final byte[] mByteArr = i.mByteArr;
            final int cmInt = i.cmInt;
            --mByteArr[cmInt];
            if (i.mByteArr[i.cmInt] == 0) {
                final int cmInt2 = i.cmInt;
                this.playSound(8);
                final int n = this.crtStageWidth - 1;
                for (int n2 = this.crtStageHeight - 1, j = 1; j < n2; ++j) {
                    for (int k = 1; k < n; ++k) {
                        if ((crtStageForegrondLayer[k][j] & 0xFF) == 0x11 && crtStageForegrondLayer[k][j] >> 8 == cmInt2) {
                            final int n3;
                            switch (n3 = (crtStageForegrondLayer[k][j - 1] & 0xFF)) {
                                case 7: {
                                    final int n4 = k;
                                    final int n5 = j - 1;
                                    final int n6 = n4;
                                    final int n7;
                                    if (((n7 = i.crtStageForegrondLayer[n6][n5] >> 8) & 0xF0) == 0x0) {
                                        i.crtStageForegrondLayer[n6][n5] = ((n7 | 0x10) << 8 | 0x7);
                                        i.cByteArrArr[n6][n5] = 24;
                                    }
                                    break;
                                }
                                case 14:
                                case 33: {
                                    i.crtStageForegrondLayer[k][j - 1] = (0x0 | n3);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void mVoid(final int n) {
        if ((i.crtStageForegrondLayer[this.bEInt][this.bFInt] & 0xFF) == 0xE && i.crtStageForegrondLayer[this.bEInt][this.bFInt] >> 8 == 255) {
            return;
        }
        if (this.isPlayerAtPosition(this.bEInt, this.bFInt) && (i.aClassbArr[0].crtAnimationI == 40 || i.aClassbArr[0].crtAnimationI == 48)) {
            i.crtStagePlayerLayer[this.bEInt][this.bFInt] = -1;
            while (true) {
                i i = null;
                int aiInt = 0;
                switch (n) {
                    case 24: {
                        i.iByteArr[9] = 1;
                        this.aFInt = 7;
                        this.aGInt = 0;
                        i = this;
                        aiInt = 24;
                        break;
                    }
                    case 27: {
                        i.iByteArr[9] = 2;
                        this.aFInt = 7;
                        this.aGInt = 1;
                        i = this;
                        aiInt = 27;
                        break;
                    }
                    case 26: {
                        i.iByteArr[9] = 8;
                        this.aFInt = 7;
                        this.aGInt = 2;
                        i = this;
                        aiInt = 26;
                        break;
                    }
                    default: {
                        this.aVoid(this.crtWorldIndex, this.crtStageI, this.bEInt, this.bFInt);
                        return;
                    }
                }
                i.aIInt = aiInt;
                continue;
            }
        }
    }

    private void amVoid() {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        final int n;
        if ((n = (i.bIntArrArr[beInt][bfInt] & 0xF00) >> 8) != 0) {
            if (n >= 4) {
                i.crtStagePlayerLayer[beInt][bfInt] = -1;
            } else if ((i.aSInt >> 1 & 0x1) == 0x0) {
                i.bIntArrArr[beInt][bfInt] += 256;
            }
        } else if (i.eIntArrArr != null && i.eIntArrArr[beInt][bfInt] != 0) {
            i.bIntArrArr[beInt][bfInt] = ((i.bIntArrArr[beInt][bfInt] & 0xFFFFF0FF) | 0x100);
        } else if (i.bByteArrArr[beInt][bfInt] <= 4) {
            final int n2 = i.bIntArrArr[beInt][bfInt];
            i.cByteArrArr[beInt][bfInt] = 24;
            final boolean b = (n2 & 0x10) != 0x0;
            Label_0803:
            {
                final int n3;
                int[] array;
                int n11;
                int n12;
                int n13;
                if ((n3 = (n2 & 0x7)) != 0) {
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 0;
                    int n7 = 0;
                    int n8 = 0;
                    int n9 = 0;
                    Label_0383:
                    {
                        int n10 = 0;
                        switch (n3) {
                            case 3: {
                                n4 = (b ? 1 : -1);
                                n8 = (b ? 2 : 4);
                                n9 = (b ? 4 : 2);
                                n7 = 1;
                                break Label_0383;
                            }
                            case 2: {
                                n5 = (b ? -1 : 1);
                                n8 = (b ? 1 : 3);
                                n9 = (b ? 3 : 1);
                                n10 = 1;
                                break;
                            }
                            case 1: {
                                n4 = (b ? -1 : 1);
                                n8 = (b ? 4 : 2);
                                n9 = (b ? 2 : 4);
                                n7 = -1;
                                break Label_0383;
                            }
                            case 4: {
                                n5 = (b ? 1 : -1);
                                n8 = (b ? 3 : 1);
                                n9 = (b ? 1 : 3);
                                n10 = -1;
                                break;
                            }
                        }
                        n6 = n10;
                    }
                    if (fBoolean(beInt + n6, bfInt + n7) && fBoolean(beInt + n4, bfInt + n5) && fBoolean(beInt + n4 - n6, bfInt + n5 - n7)) {
                        if (i.bByteArrArr[beInt][bfInt] <= 0) {
                            i.bIntArrArr[beInt + n6][bfInt + n7] = n2;
                            i.crtStagePlayerLayer[beInt + n6][bfInt + n7] = 11;
                            i.crtStagePlayerLayer[beInt][bfInt] = -1;
                            i.bByteArrArr[beInt + n6][bfInt + n7] = 18;
                        }
                        break Label_0803;
                    } else {
                        if (fBoolean(beInt + n4, bfInt + n5)) {
                            i.bIntArrArr[beInt + n4][bfInt + n5] = ((n2 & 0xFFFFFFF8) | n8);
                            i.crtStagePlayerLayer[beInt + n4][bfInt + n5] = 11;
                            i.crtStagePlayerLayer[beInt][bfInt] = -1;
                            i.bByteArrArr[beInt + n4][bfInt + n5] = 18;
                            break Label_0803;
                        }
                        if (fBoolean(beInt + n6, bfInt + n7)) {
                            if (i.bByteArrArr[beInt][bfInt] <= 0) {
                                i.bIntArrArr[beInt + n6][bfInt + n7] = n2;
                                i.crtStagePlayerLayer[beInt + n6][bfInt + n7] = 11;
                                i.crtStagePlayerLayer[beInt][bfInt] = -1;
                                i.bByteArrArr[beInt + n6][bfInt + n7] = 18;
                            }
                            break Label_0803;
                        } else {
                            array = i.bIntArrArr[beInt];
                            n11 = bfInt;
                            n12 = (n2 & 0xFFFFFFF8);
                            n13 = n9;
                        }
                    }
                } else {
                    Label_0735:
                    {
                        int[] array2;
                        int n14;
                        int n15;
                        if (i.crtStagePlayerLayer[beInt - 1][bfInt] >= 0) {
                            array2 = i.bIntArrArr[beInt];
                            n14 = bfInt;
                            n15 = ((n2 & 0xFFFFFFF8) | (b ? 1 : 3));
                        } else {
                            if (i.crtStagePlayerLayer[beInt][bfInt + 1] < 0) {
                                break Label_0735;
                            }
                            array2 = i.bIntArrArr[beInt];
                            n14 = bfInt;
                            n15 = ((n2 & 0xFFFFFFF8) | (b ? 2 : 4));
                        }
                        array2[n14] = n15;
                    }
                    if (i.crtStagePlayerLayer[beInt + 1][bfInt] >= 0) {
                        i.bIntArrArr[beInt][bfInt] = ((n2 & 0xFFFFFFF8) | (b ? 3 : 1));
                    }
                    if (i.crtStagePlayerLayer[beInt][bfInt + 1] < 0) {
                        break Label_0803;
                    }
                    array = i.bIntArrArr[beInt];
                    n11 = bfInt;
                    n12 = (n2 & 0xFFFFFFF8);
                    n13 = (b ? 4 : 2);
                }
                array[n11] = (n12 | n13);
            }
            kVoid(beInt, bfInt);
        }
        if (this.isPlayerAtPosition(beInt, bfInt)) {
            this.hurtHero(1, 64, 0);
        }
        if (i.bByteArrArr[beInt][bfInt] > 0) {
            final byte[] array3 = i.bByteArrArr[beInt];
            final int n16 = bfInt;
            array3[n16] -= 5;
        }
    }

    private void anVoid() {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        i.cByteArrArr[beInt][bfInt] = 24;
        int n6;
        byte b3;
        byte[] array2 = null;
        if (i.bByteArrArr[beInt][bfInt] == 0) {
            final int n2;
            final int n = (((n2 = i.bIntArrArr[beInt][bfInt]) & 0x1) == 0x0) ? -1 : 1;
            byte b = i.crtStagePlayerLayer[beInt + n][bfInt];
            final int n3 = i.crtStageForegrondLayer[beInt + n][bfInt] & 0xFF;
            boolean b2 = false;
            Label_0565:
            {
                final int n4;
                if ((n4 = n2 >> 1) > 0) {
                    if (b < 0 && n3 != 14 && n3 != 33) {
                        i.bIntArrArr[beInt + n][bfInt] = (n4 - 1 << 1 | (n2 & 0x1));
                        i.cByteArrArr[beInt + n][bfInt] = 30;
                        i.bByteArrArr[beInt + n][bfInt] = 18;
                        b = 32;
                        break Label_0565;
                    }
                    if (b == 32) {
                        break Label_0565;
                    }
                    int bfInt2 = i.bIntArrArr[beInt + n][bfInt];
                    int n5 = 0;
                    if (b == 48 && (bfInt2 & 0x8) != 0x0) {
                        break Label_0565;
                    }
                    switch (b) {
                        case 1:
                        case 2:
                        case 4:
                        case 5:
                        case 6:
                        case 7: {
                            n5 = -n;
                        }
                        case 0:
                        case 8:
                        case 9:
                        case 11:
                        case 14:
                        case 19:
                        case 43:
                        case 47:
                        case 48:
                        case 49: {
                            this.playSound(12);
                            this.oByte = 0;
                            this.biInt = this.crtPlayerX - (beInt + n) + n5;
                            this.bgInt = beInt + n;
                            this.bhInt = bfInt;
                            if (this.bfInt == -1) {
                                switch (b) {
                                    case 0:
                                    case 8:
                                    case 9:
                                    case 47: {
                                        bfInt2 = (bfInt2 & 0xFFFF8FFF & 0xFFFFFDFF);
                                        break;
                                    }
                                }
                                this.bfInt = bfInt2;
                            }
                            if (this.biInt < 0) {
                                this.beInt = ((bfInt2 & 0xFFFFFFF8) | 0x4);
                                break Label_0565;
                            }
                            this.beInt = ((bfInt2 & 0xFFFFFFF8) | 0x2);
                            break Label_0565;
                        }
                        default: {
                            if (b != -1) {
                                break;
                            }
                            break Label_0565;
                        }
                    }
                }
                b2 = true;
            }
            if (b2) {
                for (int iInteger = 1; iInteger <= 3; ++iInteger) {
                    if (i.crtStagePlayerLayer[this.crtPlayerX + n * iInteger][this.crtPlayerY] == 32) {
                        i.crtStagePlayerLayer[this.crtPlayerX + n * iInteger][this.crtPlayerY] = -1;
                    }
                }
            }
            final byte[] array = i.crtStagePlayerLayer[beInt + n];
            n6 = bfInt;
            b3 = b;
        } else {
            array2 = i.bByteArrArr[beInt];
            b3 = (byte) (array2[n6 = bfInt] - 6);
        }
        array2[n6] = b3;
        kVoid(beInt, bfInt);
    }

    private void jVoid(final int n, final int n2) {
        i.crtStageForegrondLayer[n][n2] = ((i.crtStageForegrondLayer[n][n2] & 0xFFFFFFF) | 0x10000000);
        this.alVoid();
    }

    private void nVoid(final int n) {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        final int n2 = i.crtStageForegrondLayer[beInt][bfInt] >> 8;
        i.crtStageForegrondLayer[beInt][bfInt] = (n2 << 8 | n);
        if (i.bByteArrArr[beInt][bfInt] <= 0) {
            if (n2 == 0) {
                if (this.isPlayerAtPosition(beInt, bfInt) && this.jInt <= 0) {
                    this.kInt &= 0xFFFFF7FF;
                    i.crtStageForegrondLayer[beInt][bfInt] = (0x100 | n);
                    i i;
                    int n3;
                    if (Math.abs(this.iLong - System.currentTimeMillis()) >= 5000L) {
                        i = this;
                        n3 = 40;
                    } else {
                        i = this;
                        n3 = 48;
                    }
                    i.gVoid(n3);
                    this.playSound(3);
                }
            } else if ((i.aSInt >> 1 & 0x1) == 0x0 && i.aClassfArr[(n == 14) ? 8 : 22] != null && n2 < i.aClassfArr[(n == 14) ? 8 : 22].getAnimationFrameCount(0) - 1) {
                i.crtStageForegrondLayer[beInt][bfInt] = (n2 + 1 << 8 | n);
                i.cByteArrArr[beInt][bfInt] = 24;
            }
        }
    }

    private static boolean hBoolean(final int n, final int n2) {
        final int n3 = n2 - 1;
        final int n4 = n - 1;
        final int n5 = n + 1;
        return (i.bByteArrArr[n][n3] <= 6 && ((iBoolean(n, n3) && ((i.bIntArrArr[n][n3] & 0x7) == 0x3 || (i.crtStagePlayerLayer[n][n2] != 16 && i.crtStagePlayerLayer[n][n3] != 1))) || i.crtStagePlayerLayer[n][n3] == 46 || i.crtStagePlayerLayer[n][n3] == 14 || i.crtStagePlayerLayer[n][n3] == 48)) || (i.bByteArrArr[n5][n2] <= 0 && i.crtStagePlayerLayer[n5][n2] == 14 && (i.bIntArrArr[n5][n2] & 0x8) != 0x0 && (i.bIntArrArr[n5][n2] & 0x7) != 0x3) || (i.bByteArrArr[n4][n2] <= 0 && i.crtStagePlayerLayer[n4][n2] == 14 && (i.bIntArrArr[n4][n2] & 0x8) == 0x0 && (i.bIntArrArr[n4][n2] & 0x7) != 0x3);
    }

    private static boolean iBoolean(final int n, final int n2) {
        if (i.crtStagePlayerLayer[n][n2] >= 0) {
            switch (i.crtStagePlayerLayer[n][n2]) {
                case 0:
                case 1:
                case 8:
                case 9: {
                    return true;
                }
            }
        }
        return false;
    }

    private static void kVoid(final int n, final int n2) {
        final int n3 = n - 1;
        final int n4 = n + 1;
        final int n5 = n2 - 1;
        final int n6 = n2 + 1;
        i.cByteArrArr[n3][n5] = 48;
        i.cByteArrArr[n][n5] = 48;
        i.cByteArrArr[n4][n5] = 48;
        i.cByteArrArr[n3][n2] = 48;
        i.cByteArrArr[n][n2] = 48;
        i.cByteArrArr[n4][n2] = 48;
        i.cByteArrArr[n3][n6] = 48;
        i.cByteArrArr[n][n6] = 48;
        i.cByteArrArr[n4][n6] = 48;
    }

    private void saveCheckpoint() {
        this.jByte = i.iByteArr[10];
        this.chInt = this.cfInt;
        this.cgInt = this.ceInt;
        this.afInt = this.aaInt;
        this.bZInt = this.aCInt;
        this.bXInt = this.aZInt;
        this.bYInt = this.bbInt;
        this.bSInt = this.crtPlayerX;
        this.bTInt = this.crtPlayerY;
        this.bUInt = this.aUInt;
        this.bVInt = this.aVInt;
        this.bWInt = this.ayInt;
        this.ajInt = this.aiInt;
        this.caInt = this.amInt;
        this.cbInt = this.alInt;
        i.cnInt = i.cmInt;
        if (i.mByteArr != null) {
            System.arraycopy(i.mByteArr, 0, i.oByteArr, 0, i.mByteArr.length);
        }
        for (int iInteger = 0; iInteger < this.crtStageWidth; ++iInteger) {
            System.arraycopy(i.bIntArrArr[iInteger], 0, i.cIntArrArr[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.bByteArrArr[iInteger], 0, i.dByteArrArr[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.crtStagePlayerLayer[iInteger], 0, i.eByteArrArr[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.crtStageForegrondLayer[iInteger], 0, i.dIntArrArr[iInteger], 0, this.crtStageHeight);
        }
        if (this.lBoolean) {
            if (i.fIntArrArr == null) {
                i.fIntArrArr = new int[this.crtStageWidth][this.crtStageHeight];
            }
            for (int j = 0; j < this.crtStageWidth; ++j) {
                System.arraycopy(i.eIntArrArr[j], 0, i.fIntArrArr[j], 0, this.crtStageHeight);
            }
            if (i.cLongArr == null) {
                i.cLongArr = new long[15];
            }
            System.arraycopy(i.aLongArr, 0, i.cLongArr, 0, i.aLongArr.length);
            if (i.dLongArr == null) {
                i.dLongArr = new long[15];
            }
            System.arraycopy(i.bLongArr, 0, i.dLongArr, 0, i.bLongArr.length);
            this.yByte = this.xByte;
            this.dAInt = this.dqInt;
            this.dBInt = this.drInt;
            this.dCInt = this.dsInt;
            this.zByte = this.vByte;
            this.dDInt = this.dvInt;
            this.dEInt = this.dwInt;
            this.dFInt = this.dxInt;
            this.AByte = this.wByte;
            this.dGInt = this.dyInt;
            this.dHInt = this.dzInt;
            i.amBoolean = this.alBoolean;
            this.dIInt = this.dtInt;
            this.dJInt = this.duInt;
        }
    }

    private void restoreCheckpoint() {
        i.cEInt = -1;
        final int afInt = -1;
        this.aHInt = afInt;
        this.aGInt = afInt;
        this.aFInt = afInt;
        this.bgInt = 0;
        this.bhInt = 0;
        this.EBoolean = true;
        this.ciInt = this.bSInt * 24 - 120;
        this.cjInt = this.bTInt * 24 - 160 + 40;
        this.blInt = 0;
        Label_0147:
        {
            int[] array;
            int n;
            if (this.qBoolean) {
                this.bmInt = 15;
                this.qBoolean = false;
                i.dIntArrArr[37][7] = -1;
                array = i.dIntArrArr[39];
                n = 5;
            } else {
                if (!this.rBoolean) {
                    break Label_0147;
                }
                this.bmInt = 17;
                this.rBoolean = false;
                i.dIntArrArr[46][7] = -1;
                array = i.dIntArrArr[50];
                n = 7;
            }
            array[n] = -1;
        }
        this.tBoolean = false;
        this.axInt = 70;
        i.iByteArr[10] = this.jByte;
        this.aaInt = this.afInt;
        this.cfInt = this.chInt;
        this.ceInt = this.cgInt;
        this.aCInt = this.bZInt;
        this.bbInt = this.bYInt;
        this.aZInt = this.bXInt;
        i.aClassbArr[0].setAnimation(2);
        this.kInt = 2;
        this.bjInt = 0;
        this.crtPlayerX = this.bSInt;
        this.crtPlayerY = this.bTInt;
        this.aUInt = this.bUInt;
        this.aVInt = this.bVInt;
        this.aiInt = this.ajInt;
        switch (this.kByte) {
            case 5: {
                this.yVoid();
                break;
            }
            case 3: {
                this.aqInt = 5;
                break;
            }
            case 4: {
                this.aoInt = 0;
                this.arInt = 0;
                this.aqInt = 3;
                this.kBoolean = false;
                break;
            }
            case 1: {
                this.alInt = this.cbInt;
                this.amInt = this.caInt;
                break;
            }
        }
        i.cmInt = i.cnInt;
        if (i.mByteArr != null) {
            System.arraycopy(i.oByteArr, 0, i.mByteArr, 0, i.mByteArr.length);
        }
        for (int iInteger = 0; iInteger < this.crtStageWidth; ++iInteger) {
            System.arraycopy(i.cIntArrArr[iInteger], 0, i.bIntArrArr[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.dByteArrArr[iInteger], 0, i.bByteArrArr[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.eByteArrArr[iInteger], 0, i.crtStagePlayerLayer[iInteger], 0, this.crtStageHeight);
            System.arraycopy(i.dIntArrArr[iInteger], 0, i.crtStageForegrondLayer[iInteger], 0, this.crtStageHeight);
        }
        for (int n2 = this.crtStageHeight - 1, j = 1; j < n2; ++j) {
            for (int n3 = this.crtStageWidth - 1, k = 1; k < n3; ++k) {
                final byte b = i.crtStagePlayerLayer[k][j];
                final int n4 = i.crtStageForegrondLayer[k][j] & 0xFF;
                if ((b > -1 && b < 80) || (n4 > -1 && n4 < 80)) {
                    kVoid(k, j);
                }
            }
        }
        if (i.aClassbArr[2] != null) {
            i.aClassbArr[2].setAnimation(0);
            i.crtStagePlayerLayer[18][63] = -1;
        }
        this.ayInt = this.bWInt;
        this.oBoolean = true;
        if (this.lBoolean) {
            this.alBoolean = i.amBoolean;
            this.dtInt = this.dIInt;
            this.duInt = this.dJInt;
            for (int l = 0; l < this.crtStageWidth; ++l) {
                System.arraycopy(i.fIntArrArr[l], 0, i.eIntArrArr[l], 0, this.crtStageHeight);
            }
            System.arraycopy(i.cLongArr, 0, i.aLongArr, 0, i.aLongArr.length);
            System.arraycopy(i.dLongArr, 0, i.bLongArr, 0, i.bLongArr.length);
            this.xByte = this.yByte;
            this.dqInt = this.dAInt;
            this.drInt = this.dBInt;
            this.dsInt = this.dCInt;
            this.vByte = this.zByte;
            this.dvInt = this.dDInt;
            this.dwInt = this.dEInt;
            this.dxInt = this.dFInt;
            this.wByte = this.AByte;
            this.dyInt = this.dGInt;
            this.dzInt = this.dHInt;
        }
        if (i.eByteArr != null) {
            for (int bfInt = 0; bfInt < this.crtStageHeight; ++bfInt) {
                for (int beInt = 0; beInt < this.crtStageWidth; ++beInt) {
                    if (i.crtStagePlayerLayer[beInt][bfInt] == 48) {
                        this.bEInt = beInt;
                        this.bFInt = bfInt;
                        if ((i.bIntArrArr[beInt][bfInt] & 0x8) == 0x0) {
                            this.dVoid((byte) 48);
                        } else {
                            this.aiVoid();
                        }
                    }
                }
            }
        }
    }

    public static void aVoid(final short n, final short n2, final byte b, final int n3) {
        i.crtStagePlayerLayer[n][n2] = b;
        i.bIntArrArr[n][n2] = n3;
    }

    private static boolean bBoolean(final int n, final int n2, final int n3, final int n4) {
        return Math.abs(n - n3) < 24 && Math.abs(n2 - n4) < 24;
    }

    private static boolean aBoolean(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        i.dmInt = (i.dnInt = 0);
        i.doInt = (i.dpInt = 100);
        if (Math.abs(n - n5) > 1 || Math.abs(n2 - n6) > 1) {
            return false;
        }
        i.dmInt = n * 24 + i.gByteArr[n3] * n4;
        i.dnInt = n2 * 24 + i.gByteArr[n3 + 8] * n4;
        i.doInt = n5 * 24 + i.gByteArr[n7] * n8;
        i.dpInt = n6 * 24 + i.gByteArr[n7 + 8] * n8;
        return bBoolean(i.dmInt, i.dnInt, i.doInt, i.dpInt);
    }

    private void aqVoid() {
        final int beInt = this.bEInt;
        final int bfInt = this.bFInt;
        byte b = i.bByteArrArr[beInt][bfInt];
        int n = i.bIntArrArr[beInt][bfInt];
        final byte b2 = i.crtStagePlayerLayer[beInt][bfInt];
        final boolean b3 = i.eIntArrArr != null && i.eIntArrArr[beInt][bfInt] != 0;
        final int n2 = n & 0x7;
        int n3;
        int n4;
        int n5;
        if (b3 && i.eIntArrArr[beInt][bfInt] != 3) {
            n3 = -1;
            n4 = 1;
            n5 = bfInt - 1;
        } else {
            n3 = 1;
            n4 = 3;
            n5 = bfInt + 1;
        }
        final int iInt = n5;
        final boolean aBoolean = aBoolean(beInt, bfInt, n2, b, this.crtPlayerX, this.crtPlayerY, ((this.kInt & 0x1000) == 0x0) ? this.lByte : 0, this.jInt);
        if (b2 == 1 && aBoolean) {
            final int n6 = beInt;
            final int n7 = bfInt;
            final int n8 = n6;
            this.cVoid(n8, n7, 3);
            final i j = this;
            ++j.aZInt;
            i.crtStagePlayerLayer[n8][n7] = -1;
            final i k = this;
            --k.aaInt;
            this.biInt = 0;
            if (this.aaInt == 0) {
                i.crtStagePlayerLayer[this.abInt][this.acInt] = -1;
            }
            if (i.crtStagePlayerLayer[n8][n7 - 1] == -1) {
                this.bVoid(n8, n7 - 1);
            }
            this.bVoid(n8, n7);
            this.oBoolean = true;
            return;
        }
        final boolean b4 = (i.crtStageForegrondLayer[beInt][bfInt] & 0xFF) == 0x23;
        if (i.crtStagePlayerLayer[beInt][iInt] == 9 && b <= 0) {
            final byte b5 = (byte) i.crtStageForegrondLayer[beInt][iInt];
            final int n9;
            if ((n9 = (i.bIntArrArr[beInt][iInt] & 0xFC00000) >> 22) != 34) {
                if (n9 == 33) {
                    if (b5 == -1) {
                        i.crtStageForegrondLayer[beInt][iInt] = 32;
                    }
                    this.crtPlayerX = beInt;
                    this.crtPlayerY = iInt;
                    i.crtStagePlayerLayer[beInt][iInt] = -1;
                    this.jInt = 0;
                    this.hurtHero(2, 48, this.aTInt = 0);
                } else if (i.crtStagePlayerLayer[beInt][iInt] == 19 || i.crtStagePlayerLayer[beInt][iInt] == 43 || i.crtStagePlayerLayer[beInt][iInt] == 45 || i.crtStagePlayerLayer[beInt][iInt] == 46 || i.crtStagePlayerLayer[beInt][iInt] == 49 || i.crtStagePlayerLayer[beInt][iInt] == 11) {
                    i.crtStagePlayerLayer[beInt][iInt] = -1;
                    this.jVoid(beInt, iInt);
                }
            }
        }
        if (b <= 0 && !b4) {
            if (n2 == n4 && this.isPlayerAtPosition(beInt, iInt) && eBoolean(beInt, iInt)) {
                if ((b2 == 0 || b2 == 9) && n3 > 0) {
                    this.hurtHero(2, 48, 0);
                } else if (b2 == 1) {
                    i.bIntArrArr[beInt][iInt] = ((n & 0xFFFFFFF8) | 0x3);
                    i.bByteArrArr[beInt][iInt] = 18;
                    i.crtStagePlayerLayer[beInt][iInt] = 1;
                    i.crtStagePlayerLayer[beInt][bfInt] = -1;
                    this.bVoid(beInt, bfInt);
                } else if (b2 == 8) {
                    n &= 0xFFC1FFFF;
                }
                i.bIntArrArr[beInt][bfInt] = (n & 0xFFFFFFF8);
            } else if ((eBoolean(beInt, iInt) || i.crtStagePlayerLayer[beInt][iInt] == 21) && (!this.isPlayerAtPosition(beInt, bfInt) || this.aTInt > 0) && ((!this.isPlayerAtPosition(beInt, iInt) && !bBoolean(i.dmInt, i.dnInt, i.doInt, i.dpInt - 1)) || this.aTInt > 0 || this.aWInt != 0 || (b2 != 0 && n2 == n4))) {
                if (n3 > 0 || (i.eIntArrArr != null && i.eIntArrArr[beInt][iInt] != 0)) {
                    n = ((n + 131072 & 0xFFFFFFF8) | n4);
                    i.bIntArrArr[beInt][iInt] = (n | Integer.MIN_VALUE);
                    i.bByteArrArr[beInt][iInt] = 18;
                    i.crtStagePlayerLayer[beInt][iInt] = b2;
                    i.crtStagePlayerLayer[beInt][bfInt] = -1;
                    kVoid(beInt, bfInt);
                    i.cByteArrArr[beInt][bfInt + n3 * 2] = 24;
                    this.bVoid(beInt, bfInt);
                } else {
                    n &= 0xFFC1FFF8;
                    i.bIntArrArr[beInt][bfInt] = n;
                    i.bByteArrArr[beInt][iInt] = 0;
                }
            } else if (iBoolean(beInt, iInt)) {
                if (n3 < 0 && (i.eIntArrArr == null || i.eIntArrArr[beInt][iInt] == 0) && i.crtStagePlayerLayer[beInt][bfInt + 1] < 0) {
                    i.bIntArrArr[beInt][bfInt + 1] = ((n & 0xFFFFFFF8) | 0x3);
                    i.bIntArrArr[beInt][bfInt + 1] |= Integer.MIN_VALUE;
                    i.crtStagePlayerLayer[beInt][bfInt + 1] = b2;
                    i.bByteArrArr[beInt][bfInt + 1] = 18;
                    i.crtStagePlayerLayer[beInt][bfInt] = -1;
                } else if (i.bByteArrArr[beInt][iInt] <= 0) {
                    if ((n & 0x3E0000) >> 17 >= 2) {
                        if (b2 == 8) {
                            i.crtStagePlayerLayer[beInt][bfInt] = 54;
                            i.bIntArrArr[beInt][bfInt] = 0;
                            kVoid(beInt, bfInt);
                            return;
                        }
                        if (i.crtStagePlayerLayer[beInt][iInt] == 8) {
                            i.crtStagePlayerLayer[beInt][iInt] = 54;
                            i.bIntArrArr[beInt][iInt] = 0;
                            kVoid(beInt, iInt);
                            return;
                        }
                    }
                    n &= 0xFFC1FFFF;
                    Label_1240:
                    {
                        int n10;
                        int n11;
                        if (eBoolean(beInt - 1, bfInt) && eBoolean(beInt - 1, iInt) && !this.isPlayerAtPosition(beInt - 1, bfInt)) {
                            i.bByteArrArr[beInt][bfInt] = (byte) (((n & 0x7000) >> 12) + 1);
                            i.cByteArrArr[beInt][bfInt] = 24;
                            n10 = (((n & 0xFFFFFFF8) | 0x4) & 0xFFFFF3FF);
                            n11 = 2048;
                        } else {
                            if (!eBoolean(beInt + 1, bfInt) || !eBoolean(beInt + 1, iInt) || this.isPlayerAtPosition(beInt + 1, bfInt)) {
                                break Label_1240;
                            }
                            i.bByteArrArr[beInt][bfInt] = (byte) (((n & 0x7000) >> 12) + 1);
                            i.cByteArrArr[beInt][bfInt] = 24;
                            n10 = (((n & 0xFFFFFFF8) | 0x2) & 0xFFFFF3FF);
                            n11 = 1024;
                        }
                        n = (n10 | n11 | 0x200);
                    }
                    i.bIntArrArr[beInt][bfInt] = n;
                }
            } else if (b2 == 8) {
                if ((n & 0x3E0000) >> 17 >= 2) {
                    i.crtStagePlayerLayer[beInt][bfInt] = 54;
                    i.bIntArrArr[beInt][bfInt] = 0;
                    kVoid(beInt, bfInt);
                    return;
                }
                n &= 0xFFC1FFFF;
            } else {
                n = (n & 0xFFFFF3FF & 0xFFC1FFFF & 0xFFFFFFF8);
                i.bIntArrArr[beInt][bfInt] = n;
            }
        } else if (!b4) {
            if ((n & 0x200) == 0x0) {
                byte b6;
                if (n2 != 3 || (i.crtStageForegrondLayer[beInt][bfInt] & 0xFF) != 0x6 || b > 12) {
                    b6 = (byte) (b - 6);
                } else {
                    b6 = (byte) (b - (i.aSInt & 0x1));
                    i.cByteArrArr[beInt][bfInt] = 24;
                }
                Label_1634:
                {
                    if (b6 == 0 || b6 == 12) {
                        while (true) {
                            int n12 = 0;
                            int n13 = 0;
                            switch (n & 0xC00) {
                                case 2048: {
                                    n12 = (n & 0xFFFFFFC7);
                                    n13 = n - 8;
                                    break;
                                }
                                case 1024: {
                                    n12 = (n & 0xFFFFFFC7);
                                    n13 = n + 8;
                                    break;
                                }
                                default: {
                                    if (b6 != 0) {
                                        break Label_1634;
                                    }
                                    if ((i.crtStageForegrondLayer[beInt][bfInt] & 0xFF) == 0x6) {
                                        n &= 0xFFFFFE3F;
                                    }
                                    if (n2 != n4) {
                                        break Label_1634;
                                    }
                                    if ((b2 == 0 || b2 == 9) && n3 > 0 && !eBoolean(beInt, bfInt + 1)) {
                                        vibrate(200);
                                        this.playSound(14);
                                        this.bjInt = 10;
                                        if (b2 == 9 && this.aTInt > 0 && this.isPlayerAtPosition(beInt, bfInt)) {
                                            this.hurtHero(1, 0, 0);
                                            this.oBoolean = true;
                                        }
                                        if (!iBoolean(beInt, bfInt + 1)) {
                                            n = ((n & 0xFFFFFE3F) | 0x40);
                                        }
                                    }
                                    i.cByteArrArr[beInt][bfInt] = 30;
                                    if (!this.isPlayerAtPosition(beInt, iInt)) {
                                        n &= 0xFFFFFFF8;
                                    }
                                    break Label_1634;
                                }
                            }
                            n = (n12 | (n13 & 0x38));
                            continue;
                        }
                    }
                }
                i.bByteArrArr[beInt][bfInt] = b6;
                i.bIntArrArr[beInt][bfInt] = n;
            } else {
                int n14 = 0;
                int n15 = 0;
                Label_1679:
                {
                    int n16;
                    if (n2 == 4) {
                        n16 = -1;
                    } else {
                        if (n2 != 2) {
                            break Label_1679;
                        }
                        n16 = 1;
                    }
                    n14 = n16;
                }
                if (eBoolean(beInt, iInt) && !this.isPlayerAtPosition(beInt, iInt)) {
                    byte b7;
                    if ((b7 = (byte) (b - 6)) <= 0) {
                        b7 = 0;
                        n = (n & 0xFFFFFDFF & 0xFFFFFFF8);
                    }
                    i.bByteArrArr[beInt][bfInt] = b7;
                    i.bIntArrArr[beInt][bfInt] = n;
                    i.cByteArrArr[beInt][bfInt] = 24;
                } else if (eBoolean(beInt + n14, bfInt) && !this.isPlayerAtPosition(beInt + n14, bfInt) && eBoolean(beInt + n14, iInt) && !this.isPlayerAtPosition(beInt + n14, iInt) && (i.bIntArrArr[beInt][iInt] & 0x200) == 0x0) {
                    if (b >= 6 || (i.aSInt & 0x3) == 0x0) {
                        ++b;
                    }
                    if (b >= 12) {
                        n &= 0xFFFFFDFF;
                        byte b8;
                        if (n14 != 0) {
                            b8 = 6;
                            i.crtStagePlayerLayer[beInt][bfInt] = -1;
                            if (eBoolean(beInt + n14, iInt)) {
                                b8 = 12;
                                n = ((n & 0xFFFFFFF8) | n4);
                                n15 = n3;
                            }
                        } else {
                            n &= 0xFFFFFFF8;
                            b8 = 0;
                        }
                        i.bIntArrArr[beInt + n14][bfInt + n15] = (n | Integer.MIN_VALUE);
                        i.bByteArrArr[beInt + n14][bfInt + n15] = b8;
                        i.crtStagePlayerLayer[beInt + n14][bfInt + n15] = b2;
                        kVoid(beInt, bfInt);
                        i.cByteArrArr[beInt][bfInt + n3 * 2] = 24;
                    } else {
                        i.bByteArrArr[beInt][bfInt] = b;
                        i.bIntArrArr[beInt][bfInt] = n;
                        i.cByteArrArr[beInt][bfInt] = 24;
                    }
                } else {
                    byte b9;
                    if ((b9 = (byte) (b - 6)) <= 0) {
                        b9 = 0;
                        n = (n & 0xFFFFFDFF & 0xFFFFFFF8);
                    }
                    i.bByteArrArr[beInt][bfInt] = b9;
                    i.bIntArrArr[beInt][bfInt] = n;
                    i.cByteArrArr[beInt][bfInt] = 24;
                    this.cVoid(beInt, bfInt);
                }
            }
        }
        final int n17 = n & 0x20000000;
        final byte b10 = i.bByteArrArr[beInt][bfInt];
        final int n18 = n & 0x40000000;
        if ((n17 == 0 && b10 != 0) || (n18 == 0 && b3)) {
            this.bVoid(beInt, bfInt);
        }
        if ((n17 != 0 && b10 == 0) || (n18 != 0 && !b3)) {
            this.cVoid(beInt, bfInt);
        }
        i.bIntArrArr[beInt][bfInt] = ((((((n & 0xDFFFFFFF) | ((b10 != 0) ? 536870912 : 0)) & 0xBFFFFFFF) | (b3 ? 1073741824 : 0)) & Integer.MAX_VALUE) | (((((n & 0x200) != 0x0) ? 1 : ((b10 != 0 || n17 != 0) ? 2 : (b3 ? 3 : ((i.crtStageForegrondLayer[beInt][bfInt] > -1 && i.crtStageForegrondLayer[beInt][bfInt] < 38) ? 4 : (((eBoolean(beInt - 1, bfInt) || eBoolean(beInt + 1, bfInt)) && iBoolean(beInt, bfInt + 1) && (i.bIntArrArr[beInt][bfInt + 1] & 0x7) == 0x0 && beInt != this.bgInt && bfInt != this.bhInt) ? 6 : 0))))) != 0) ? Integer.MIN_VALUE : 0));
        final int n19;
        if ((n19 = ((i.bIntArrArr[beInt][bfInt] & 0x1C0) >> 6) - 1) >= 0 && n19 < 5) {
            i.bIntArrArr[beInt][bfInt] = ((i.bIntArrArr[beInt][bfInt] & 0xFFFFFE3F) | (i.bIntArrArr[beInt][bfInt] + 64 & 0x1C0));
        }
    }

    private static f_Sprite loadSprite(final String fileName, final int chunkI, final int offsetPalettes, final int countPalettes) {
        f_Sprite textures = null;
        try {
            textures = new f_Sprite();
            byte[] chunk = readChunk(fileName, chunkI);
            System.out.print("Get" + ((chunk[0] == (byte) 223 && chunk[1] == (byte) 3) ? "" : " broken") + " textures: ");
            System.out.print(fileName);
            System.out.print(", chunk #");
            System.out.println(chunkI);
            // DesktopLauncher.printByteArr(chunk, "Chunk data");
            // textures.aVoid(aByteArr(fileName, chunkI), 0);
            textures.parseSprite(chunk, 0);
            for (int i = offsetPalettes; i <= countPalettes; ++i) {
                textures.createImages(i, 0, -1, -1);
            }
            textures.paletteI = offsetPalettes;
            textures.moduleData = null;
            System.gc();
        } catch (Exception ex) {
        }
        return textures;
    }

    private static f_Sprite loadSprite(String fileName, int chunkI) {
        final String s2 = fileName;
        chunkI = chunkI;
        fileName = s2;
        return loadSprite(s2, chunkI, 0, 0);
    }

    private static f_Sprite loadSprite(final String fileName, final int chunkI, final int _unused) {
        return loadSprite(fileName, chunkI, 0, 0);
    }

    private static Image[] importTexturesWithPalette(final String fileName, final int chunkI, final int paletteI) {
        f_Sprite textures = null;
        try {
            System.out.print("Other get textures with palette: ");
            System.out.print(fileName);
            System.out.print(", chunk #");
            System.out.println(chunkI);
            System.out.print(", palette #");
            System.out.println(paletteI);
            textures = new f_Sprite();
            textures.parseSprite(readChunk(fileName, chunkI), 0);
            textures.createImages(paletteI, 0, -1, -1);
            aVoid(textures, false);
            System.gc();
        } catch (Exception ex) {
        }
        return textures.images[paletteI];
    }

    private static Image readChunkAsImageFile(final String fileName, final int chunkI) {
        Image image = null;
        try {
            final byte[] aByteArr = readChunk(fileName, chunkI);
            image = Image.createImage(aByteArr, 0, aByteArr.length);
            System.gc();
        } catch (Exception ex) {
        }
        return image;
    }

    public static byte[] readChunk(final String fileName, int chunkI) {
        System.out.println("Read chunk of file: " + fileName + ", chunk #" + chunkI);
        byte[] array = null;
        final InputStream file = i.class.getResourceAsStream(fileName);
        try {
            array = new byte[file.read() << 3];
            file.read(array);
            // DesktopLauncher.printByteArr(array, "Header: ");
            final int address = unpackUint32(array, chunkI << 3);
            chunkI = unpackUint32(array, (chunkI << 3) + 4); // Chunk index is overwritten to store length of the chunk
            // System.out.println("Skip to " + address + " with length: " + chunkI);
            //file.skipNBytes(address); // Replaced original file.skip(address) - undone below!
            file.skip(address);
            // As shown here: https://bugs.openjdk.org/browse/JDK-6204246#:~:text=However%2C%20BufferedInputStream.skip(long)%20can%20decide%20to%20skip%20less%20than%0Athe%20number%0Aof%20bytes%20that%20were%20reported%20as%20being%20available%20to%20skip.
            // It was skipping 8151 instead of 16073 bytes
            array = new byte[chunkI];
            file.read(array);
            file.close();
        } catch (Exception ex) {
            // System.out.println("nullllllll for file: " + name + ", chunk #" + chunkI);
            ex.printStackTrace();
        }
        return array;
    }

    private static int aInt(final h h, String s, int n) {
        if (n != -1 && (n = s.indexOf(10)) != -1) {
            s = s.substring(0, n);
        }
        if ((n = s.indexOf(125)) != -1) {
            s = s.substring(0, n);
        }
        h.calculateStringSize(s);
        return h.stringWidth;
    }

    private static int aInt(final InputStream inputStream) { // Seems like read low endian int
        try {
            return (inputStream.read() & 0xFF) | (inputStream.read() & 0xFF) << 8;
        } catch (Exception ex) {
            System.out.println("Sadly an exception, added this try-catch to remove an error in source code");
            ex.printStackTrace();
        }
        System.exit(666);
        return 0;
    }

    private static int getKeyFromKeyCode(int keyCode) {
        if (keyCode < 0) {
            keyCode = Math.abs(keyCode);
        }
        switch (keyCode) {
            case 1: return SKEY_UP;
            case 2: return SKEY_DOWN;
            case 3: return SKEY_LEFT;
            case 4: return SKEY_RIGHT;
            case 5: return SKEY_CENTER;
            case 6: return SKEY_LSH;
            case 7: return SKEY_RSH;
            case 23: return SKEY_CENTER_ALT;
            case 42: return SKEY_STAR;
            case 35: return SKEY_POUND;
            case 48: return SKEY_NUM0;
            case 49: return SKEY_NUM1;
            case 50: return SKEY_NUM2;
            case 51: return SKEY_NUM3;
            case 52: return SKEY_NUM4;
            case 53: return SKEY_NUM5;
            case 54: return SKEY_NUM6;
            case 55: return SKEY_NUM7;
            case 56: return SKEY_NUM8;
            case 57: return SKEY_NUM9;
            default: return 0;
        }
    }

    private void arVoid() {
        if (this.lBoolean) {
            i.aLongArr = new long[15];
            i.cLongArr = new long[15];
            i.bLongArr = new long[15];
            i.dLongArr = new long[15];
            this.xByte = 3;
            this.alBoolean = true;
            this.dqInt = -1;
            this.drInt = 0;
            this.dsInt = 0;
            this.vByte = 0;
            this.dvInt = 0;
            this.dwInt = 0;
            this.dxInt = 0;
            this.wByte = 0;
            this.dyInt = 0;
            this.dzInt = -1;
            this.dtInt = 0;
            this.duInt = 0;
        }
    }

    private byte aByte(final byte b, final byte b2, final byte b3, final byte b4) {
        int n;
        byte b5 = (byte) (n = 0);
        byte b6;
        while (true) {
            b6 = (byte) n;
            if (b5 >= 15 || aInt(b6, (byte) 0, (byte) 4) == 0) {
                break;
            }
            b5 = (byte) (n = (byte) (b6 + 1));
        }
        if (b6 < 15) {
            aVoid(b6, (byte) 1, (byte) 0, (byte) 4);
            aVoid(b6, b4, (byte) 4, (byte) 2);
            aVoid(b6, b, (byte) 6, (byte) 7);
            aVoid(b6, b, (byte) 27, (byte) 7);
            aVoid(b6, b2, (byte) 13, (byte) 7);
            aVoid(b6, b3, (byte) 20, (byte) 7);
            return b6;
        }
        return -1;
    }

    private static int aInt(final int n, final byte b, final byte b2, final byte b3) {
        return n >>> b * 9 + b2 & ~(-1 << b3);
    }

    private static void aVoid(final int n, final int n2, final byte b, final byte b2, final byte b3, final byte b4) {
        final int n3;
        final int aInt = aInt(n3 = i.eIntArrArr[n][n2], b, b3, b4);
        final byte b5 = (byte) (b * 9 + b3);
        i.eIntArrArr[n][n2] = ((n3 ^ aInt << b5) | b2 << b5);
        i.cByteArrArr[n][n2] = 24;
        i.cByteArrArr[n][n2 + 1] = 24;
    }

    private static int aInt(final int n, final byte b, final byte b2) {
        return (int) (i.aLongArr[n - 1] >>> b & ~(-1L << b2));
    }

    private static void aVoid(int n, final byte b, final byte b2, final byte b3) {
        final long n2 = aInt(n, b2, b3);
        --n;
        i.aLongArr[n] = ((i.aLongArr[n] ^ n2 << b2) | (long) b << b2);
    }

    private static int aInt(final byte b, final byte b2, final byte b3) {
        return (int) (i.bLongArr[b] >>> b2 & ~(-1L << b3));
    }

    private static void aVoid(final byte b, final byte b2, final byte b3, final byte b4) {
        i.bLongArr[b] = ((i.bLongArr[b] ^ (long) aInt(b, b3, b4) << b3) | (long) (b2 << b3));
    }

    private static byte bByte(final int n, final int n2) {
        int n3;
        byte b = (byte) (n3 = 0);
        while (true) {
            final byte b2 = (byte) n3;
            if (b >= 15) {
                return -1;
            }
            if (n == aInt(b2, (byte) 13, (byte) 7) && n2 == aInt(b2, (byte) 20, (byte) 7)) {
                return b2;
            }
            b = (byte) (n3 = (byte) (b2 + 1));
        }
    }

    private void asVoid() {
        if (!this.lBoolean) {
            return;
        }
        Label_1070:
        {
            if (this.dqInt >= 0 && this.dzInt >= 0) {
                ++this.dqInt;
                int aInt = aInt((int) this.wByte, (byte) 14, (byte) 6);
                int aInt2 = aInt((int) this.wByte, (byte) 20, (byte) 6);
                byte b7 = 0;
                byte b8 = 0;
                byte b9 = 0;
                byte b10 = 0;
                switch (aInt((int) this.wByte, (byte) 47, (byte) 2)) {
                    case 1: {
                        if (aInt2 == this.dyInt) {
                            this.dqInt = -1;
                            this.dzInt = -1;
                            fVoid(this.wByte);
                            this.xByte = 4;
                            break Label_1070;
                        }
                        final byte b = (byte) aInt((int) this.wByte, (byte) 49, (byte) 5);
                        if (this.dqInt == 0 || this.dqInt % b != 0) {
                            break Label_1070;
                        }
                        this.dqInt = 0;
                        final byte b2;
                        if ((b2 = (byte) aInt((int) this.wByte, (byte) 26, (byte) 2)) < 0) {
                            break Label_1070;
                        }
                        byte b4;
                        byte b3 = b4 = 0;
                        while (true) {
                            final byte b5 = b4;
                            if (b3 >= b) {
                                break;
                            }
                            cVoid(aInt - b5, aInt2, b2);
                            int n = aInt2;
                            byte b6;
                            if ((b6 = (byte) (b2 + 1)) > 2) {
                                b6 = 0;
                                ++n;
                            }
                            final int aInt3 = aInt(i.eIntArrArr[aInt - b5][n], b6, (byte) 3, (byte) 4);
                            Label_0302:
                            {
                                if (n != this.dyInt || b2 != 2) {
                                    if (aInt3 == 12 || aInt3 == 9) {
                                        break Label_0302;
                                    }
                                } else if (aInt3 == 0 || aInt3 == 3) {
                                    break Label_0302;
                                }
                                aVoid(aInt - b5, n, b6, (byte) 7, (byte) 3, (byte) 4);
                            }
                            b3 = (b4 = (byte) (b5 + 1));
                        }
                        if (b2 == 2) {
                            aVoid((int) this.wByte, (byte) 0, (byte) 47, (byte) 2);
                            aVoid((int) this.wByte, (byte) 0, (byte) 26, (byte) 2);
                            ++aInt2;
                            b7 = this.wByte;
                            b8 = (byte) aInt2;
                            b9 = 20;
                            b10 = 6;
                            break;
                        }
                        b7 = this.wByte;
                        b8 = (byte) (b2 + 1);
                        b9 = 26;
                        b10 = 2;
                        break;
                    }
                    case 0: {
                        aVoid((int) this.wByte, (byte) 1, (byte) 47, (byte) 2);
                        final byte b11 = (byte) aInt((int) this.wByte, (byte) 49, (byte) 5);
                        final byte b12 = (byte) aInt((int) this.wByte, (byte) 45, (byte) 2);
                        byte b13 = 0;
                        if (b12 != 0) {
                            if (b12 == 2) {
                                while (aInt >= this.dvInt && (byte) (i.crtStagePlayerLayer[aInt + 1][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 10 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 37 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 34 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 35) {
                                    ++aInt;
                                }
                            } else {
                                while (aInt <= this.dvInt && (byte) (i.crtStagePlayerLayer[aInt + 1][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 10 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 37 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 34 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 35) {
                                    ++aInt;
                                }
                            }
                        } else if ((byte) (i.crtStagePlayerLayer[aInt + 1][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 10 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 37 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 34 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 35) {
                            while ((byte) (i.crtStagePlayerLayer[aInt + 1][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 10 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 37 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 34 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 35) {
                                ++aInt;
                            }
                        } else {
                            while (b13 < b11) {
                                ++b13;
                                if ((byte) (i.crtStagePlayerLayer[aInt][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt][aInt2] != 10 && i.crtStagePlayerLayer[aInt][aInt2] != 37 && i.crtStagePlayerLayer[aInt][aInt2] != 34 && i.crtStagePlayerLayer[aInt][aInt2] != 35) {
                                    b13 = b11;
                                } else {
                                    --aInt;
                                }
                            }
                        }
                        if (this.dxInt != 2 && aInt <= this.dvInt) {
                            while ((byte) (i.crtStagePlayerLayer[aInt + 1][aInt2] - 80) < 0 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 10 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 37 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 34 && i.crtStagePlayerLayer[aInt + 1][aInt2] != 35) {
                                ++aInt;
                            }
                        }
                        aVoid((int) this.wByte, (byte) aInt, (byte) 14, (byte) 6);
                        byte b14 = 1;
                        byte b15;
                        while (true) {
                            b15 = b14;
                            if ((byte) (i.crtStagePlayerLayer[aInt - b15][aInt2] - 80) >= 0 || i.crtStagePlayerLayer[aInt - b15][aInt2] == 10 || i.crtStagePlayerLayer[aInt - b15][aInt2] == 37 || i.crtStagePlayerLayer[aInt - b15][aInt2] == 34 || i.crtStagePlayerLayer[aInt - b15][aInt2] == 35) {
                                break;
                            }
                            b14 = (byte) (b15 + 1);
                        }
                        b7 = this.wByte;
                        b8 = b15;
                        b9 = 49;
                        b10 = 5;
                        break;
                    }
                }
                aVoid((int) b7, b8, b9, b10);
            }
        }
        Label_4517:
        {
            switch (this.xByte) {
                case 2: {
                    byte b17;
                    byte b16 = b17 = 1;
                    while (true) {
                        final byte b18 = b17;
                        if (b16 > 15) {
                            break Label_4517;
                        }
                        Label_3627:
                        {
                            switch (aInt((int) b18, (byte) 28, (byte) 3)) {
                                case 3: {
                                    fVoid(b18);
                                    break;
                                }
                                case 2: {
                                    if (this.dzInt >= 0) {
                                        ++this.dzInt;
                                        final byte b19 = b18;
                                        int aInt4 = aInt((int) b19, (byte) 14, (byte) 6);
                                        int aInt5 = aInt((int) b19, (byte) 20, (byte) 6);
                                        final int aInt6 = aInt((int) b19, (byte) 0, (byte) 7);
                                        final int aInt7 = aInt((int) b19, (byte) 7, (byte) 7);
                                        final int aInt8 = aInt((int) b19, (byte) 47, (byte) 2);
                                        final byte b21;
                                        final byte b20 = (byte) aInt(b21 = (byte) aInt((int) b19, (byte) 54, (byte) 3), (byte) 6, (byte) 7);
                                        switch (aInt8) {
                                            case 1: {
                                                final byte b22 = (byte) aInt((int) b19, (byte) 49, (byte) 5);
                                                if (this.dzInt == 0 || this.dzInt % b22 != 0) {
                                                    break;
                                                }
                                                this.dzInt = 0;
                                                final byte b23 = (byte) aInt((int) b19, (byte) 26, (byte) 2);
                                                final byte b24 = (byte) aInt((int) b19, (byte) 57, (byte) 1);
                                                if (b23 < 0) {
                                                    break;
                                                }
                                                if (b24 != 1) {
                                                    byte b26;
                                                    byte b25 = b26 = 0;
                                                    while (true) {
                                                        final byte b27 = b26;
                                                        if (b25 >= b22) {
                                                            break;
                                                        }
                                                        aVoid(aInt4 - b27, aInt5, b23, (byte) 7, (byte) 3, (byte) 4);
                                                        aVoid((int) b19, b23, (byte) 43, (byte) 2);
                                                        aVoid(aInt4 - b27, aInt5, b23, b19, (byte) 0, (byte) 3);
                                                        b25 = (b26 = (byte) (b27 + 1));
                                                    }
                                                    if (this.drInt > 0) {
                                                        int n2 = aInt5;
                                                        byte b28;
                                                        if ((b28 = (byte) (b23 + 1)) > 2) {
                                                            b28 = 0;
                                                            ++n2;
                                                        }
                                                        byte b30;
                                                        byte b29 = b30 = 0;
                                                        while (true) {
                                                            final byte b31 = b30;
                                                            if (b29 >= b22) {
                                                                break;
                                                            }
                                                            if ((byte) (i.crtStagePlayerLayer[aInt4 - b31][n2] - 80) < 0 && i.crtStagePlayerLayer[aInt4 - b31][n2] != 10 && i.crtStagePlayerLayer[aInt4 - b31][n2] != 37 && i.crtStagePlayerLayer[aInt4 - b31][n2] != 34 && i.crtStagePlayerLayer[aInt4 - b31][n2] != 35) {
                                                                aVoid(aInt4 - b31, n2, b28, (byte) 8, (byte) 3, (byte) 4);
                                                            }
                                                            b29 = (b30 = (byte) (b31 + 1));
                                                        }
                                                    }
                                                    ++this.drInt;
                                                }
                                                if (b24 == 1 || ((aInt7 >= aInt6 || b20 == 0) && b23 == this.vByte)) {
                                                    if (b24 == 1) {
                                                        aVoid((int) b19, (byte) 0, (byte) 57, (byte) 1);
                                                    }
                                                    aVoid((int) b19, (byte) 3, (byte) 28, (byte) 3);
                                                    if (b20 == 0) {
                                                        aVoid(b21, (byte) 3, (byte) 0, (byte) 4);
                                                        aVoid((int) b19, (byte) 5, (byte) 28, (byte) 3);
                                                        if (this.dqInt == -1) {
                                                            this.dzInt = -1;
                                                            this.xByte = 4;
                                                        }
                                                        break;
                                                    }
                                                }
                                                if (b23 == 0) {
                                                    aVoid((int) b19, (byte) 0, (byte) 47, (byte) 2);
                                                    aVoid((int) b19, (byte) 2, (byte) 26, (byte) 2);
                                                    break;
                                                }
                                                aVoid((int) b19, (byte) (b23 - 1), (byte) 26, (byte) 2);
                                                break;
                                            }
                                            case 0: {
                                                aVoid((int) b19, (byte) 1, (byte) 47, (byte) 2);
                                                --aInt5;
                                                aVoid((int) b19, (byte) aInt5, (byte) 20, (byte) 6);
                                                if ((byte) (i.crtStagePlayerLayer[aInt4][aInt5] - 80) >= 0 || i.crtStagePlayerLayer[aInt4][aInt5] == 10 || i.crtStagePlayerLayer[aInt4][aInt5] == 37 || i.crtStagePlayerLayer[aInt4][aInt5] == 34 || i.crtStagePlayerLayer[aInt4][aInt5] == 35) {
                                                    while ((byte) (i.crtStagePlayerLayer[aInt4][aInt5] - 80) >= 0 || i.crtStagePlayerLayer[aInt4][aInt5] == 10 || i.crtStagePlayerLayer[aInt4][aInt5] == 37 || i.crtStagePlayerLayer[aInt4][aInt5] == 34 || i.crtStagePlayerLayer[aInt4][aInt5] == 35) {
                                                        --aInt4;
                                                    }
                                                } else {
                                                    while ((byte) (i.crtStagePlayerLayer[aInt4 + 1][aInt5] - 80) < 0 && i.crtStagePlayerLayer[aInt4 + 1][aInt5] != 10 && i.crtStagePlayerLayer[aInt4 + 1][aInt5] != 37 && i.crtStagePlayerLayer[aInt4 + 1][aInt5] != 34 && i.crtStagePlayerLayer[aInt4 + 1][aInt5] != 35) {
                                                        ++aInt4;
                                                    }
                                                }
                                                aVoid((int) b19, (byte) aInt4, (byte) 14, (byte) 6);
                                                byte b32 = 1;
                                                byte b33;
                                                while (true) {
                                                    b33 = b32;
                                                    if ((byte) (i.crtStagePlayerLayer[aInt4 - b33][aInt5] - 80) >= 0 || i.crtStagePlayerLayer[aInt4 - b33][aInt5] == 10 || i.crtStagePlayerLayer[aInt4 - b33][aInt5] == 37 || i.crtStagePlayerLayer[aInt4 - b33][aInt5] == 34 || i.crtStagePlayerLayer[aInt4 - b33][aInt5] == 35) {
                                                        break;
                                                    }
                                                    b32 = (byte) (b33 + 1);
                                                }
                                                aVoid((int) b19, b33, (byte) 49, (byte) 5);
                                                byte a = (byte) (b20 - b33);
                                                byte b34 = 0;
                                                this.vByte = 0;
                                                if (a < 0) {
                                                    final int n3 = -a * 3;
                                                    byte b35 = 0;
                                                    final int n4;
                                                    if ((n4 = b33 + a) * 3 - b33 != 0 && n4 * 3 <= b33 * 3 / 2) {
                                                        b35 = 1;
                                                    }
                                                    this.vByte = (byte) (n3 / b33);
                                                    this.vByte += b35;
                                                    if (this.vByte > 2) {
                                                        aVoid((int) b19, (byte) 1, (byte) 57, (byte) 1);
                                                    }
                                                    b34 = (byte) Math.abs(a);
                                                    a = 0;
                                                }
                                                int n5;
                                                if ((n5 = aInt7 + (b33 - b34)) > aInt6) {
                                                    final int n6 = aInt6 - n5;
                                                    n5 += n6;
                                                    a -= (byte) n6;
                                                }
                                                aVoid((int) b19, (byte) n5, (byte) 7, (byte) 7);
                                                aVoid(b21, a, (byte) 6, (byte) 7);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                case 1:
                                case 6:
                                case 7: {
                                    final byte b36 = b18;
                                    int aInt9 = aInt((int) b36, (byte) 31, (byte) 6);
                                    final int aInt10 = aInt((int) b36, (byte) 37, (byte) 6);
                                    final byte b37 = (byte) aInt((int) b36, (byte) 43, (byte) 2);
                                    final byte b38 = (byte) aInt(i.eIntArrArr[aInt9][aInt10], b37, (byte) 7, (byte) 2);
                                    byte b39 = (byte) aInt((int) b36, (byte) 45, (byte) 2);
                                    final boolean b40 = (byte) aInt((int) b36, (byte) 28, (byte) 3) == 7;
                                    byte b41 = 0;
                                    if (b39 > 1) {
                                        b39 = -1;
                                    }
                                    if (b38 == 0) {
                                        byte b42 = (byte) (b37 + 1);
                                        int n7 = aInt10;
                                        if (b37 == 2) {
                                            b42 = 0;
                                            n7 = aInt10 + 1;
                                        }
                                        if (aInt(i.eIntArrArr[aInt9][n7], b42, (byte) 3, (byte) 4) == 7) {
                                            this.drInt = 1;
                                            if (b40) {
                                                fVoid(b36);
                                                this.xByte = 3;
                                                this.alBoolean = true;
                                                break;
                                            }
                                            int n8;
                                            if ((n8 = b42 - 1) < 0) {
                                                n8 = 2;
                                            }
                                            this.dzInt = 0;
                                            final byte b43 = (byte) aInt(i.eIntArrArr[aInt9][n7], b42, (byte) 0, (byte) 3);
                                            aVoid((int) b43, (byte) aInt((int) b36, (byte) 54, (byte) 3), (byte) 54, (byte) 3);
                                            aVoid((int) b43, (byte) 2, (byte) 28, (byte) 3);
                                            aVoid((int) b43, (byte) 0, (byte) 47, (byte) 2);
                                            aVoid((int) b43, (byte) n8, (byte) 26, (byte) 2);
                                            aVoid((int) b43, (byte) aInt9, (byte) 14, (byte) 6);
                                            aVoid((int) b43, (byte) n7, (byte) 20, (byte) 6);
                                            aVoid((int) b43, (byte) 0, (byte) 57, (byte) 1);
                                            fVoid(b36);
                                            break;
                                        }
                                    }
                                    if (b37 == 2 && b38 == 0) {
                                        if ((byte) (i.crtStagePlayerLayer[aInt9][aInt10 + 1] - 80) >= 0 || i.crtStagePlayerLayer[aInt9][aInt10 + 1] == 10 || i.crtStagePlayerLayer[aInt9][aInt10 + 1] == 37 || i.crtStagePlayerLayer[aInt9][aInt10 + 1] == 34 || i.crtStagePlayerLayer[aInt9][aInt10 + 1] == 35) {
                                            Label_2855:
                                            {
                                                byte b44;
                                                int n9;
                                                int n10;
                                                byte b45;
                                                byte b46;
                                                byte b47;
                                                if (b39 == 0) {
                                                    if (b40) {
                                                        cVoid(aInt9, aInt10, b37);
                                                    } else {
                                                        aVoid(aInt9, aInt10, b37, (byte) 15, (byte) 3, (byte) 4);
                                                    }
                                                    if ((b41 = this.aByte(b36, aInt9, aInt10, b39, b37, (byte) 1, b40)) < 0) {
                                                        b44 = b36;
                                                        n9 = aInt9;
                                                        n10 = aInt10;
                                                        b45 = b39;
                                                        b46 = b37;
                                                        b47 = -1;
                                                    } else {
                                                        if ((byte) (i.crtStagePlayerLayer[aInt9 - 1][aInt10] - 80) < 0 && i.crtStagePlayerLayer[aInt9 - 1][aInt10] != 10 && i.crtStagePlayerLayer[aInt9 - 1][aInt10] != 37 && i.crtStagePlayerLayer[aInt9 - 1][aInt10] != 34 && i.crtStagePlayerLayer[aInt9 - 1][aInt10] != 35) {
                                                            this.aByte(aInt9 - 1, aInt10, (byte) (b40 ? 7 : 5), (byte) (-1), (byte) 2, (byte) aInt((int) b36, (byte) 54, (byte) 3));
                                                        }
                                                        break Label_2855;
                                                    }
                                                } else {
                                                    b44 = b36;
                                                    n9 = aInt9;
                                                    n10 = aInt10;
                                                    b45 = b39;
                                                    b46 = b37;
                                                    b47 = b39;
                                                }
                                                b41 = this.aByte(b44, n9, n10, b45, b46, b47, b40);
                                            }
                                            if (b41 == -2) {
                                                byte b53 = 0;
                                                byte b54 = 0;
                                                byte b55 = 0;
                                                byte b56 = 0;
                                                Label_3362:
                                                {
                                                    final int n12;
                                                    final int n11;
                                                    if ((n11 = (n12 = i.bIntArrArr[aInt9][aInt10 + 1])) != -1 && aByte(n11, (byte) 6, (byte) 1) == 1) {
                                                        final int n13 = aInt9;
                                                        final int n14 = aInt10;
                                                        final byte b48 = b39;
                                                        final int n15 = n14;
                                                        int n16 = n13;
                                                        boolean b49 = true;
                                                        boolean b50 = true;
                                                        boolean b52 = false;
                                                        Label_3289:
                                                        while (true) {
                                                            boolean b51 = b50;
                                                            while (b51) {
                                                                b51 = true;
                                                                n16 -= b48;
                                                                if (b48 == 0) {
                                                                    if ((byte) (i.crtStagePlayerLayer[n16 - 1][n15] - 80) >= 0 || i.crtStagePlayerLayer[n16 - 1][n15] == 10 || i.crtStagePlayerLayer[n16 - 1][n15] == 37 || i.crtStagePlayerLayer[n16 - 1][n15] == 34 || (i.crtStagePlayerLayer[n16 - 1][n15] == 35 && (byte) (i.crtStagePlayerLayer[n16 + 1][n15] - 80) >= 0) || i.crtStagePlayerLayer[n16 + 1][n15] == 10 || i.crtStagePlayerLayer[n16 + 1][n15] == 37 || i.crtStagePlayerLayer[n16 + 1][n15] == 34 || i.crtStagePlayerLayer[n16 + 1][n15] == 35) {
                                                                        b49 = true;
                                                                        b50 = false;
                                                                        continue Label_3289;
                                                                    }
                                                                    continue;
                                                                } else {
                                                                    if ((byte) (i.crtStagePlayerLayer[n16][n15 + 1] - 80) < 0 && i.crtStagePlayerLayer[n16][n15 + 1] != 10 && i.crtStagePlayerLayer[n16][n15 + 1] != 37 && i.crtStagePlayerLayer[n16][n15 + 1] != 34 && i.crtStagePlayerLayer[n16][n15 + 1] != 35) {
                                                                        b51 = false;
                                                                    }
                                                                    if ((byte) (i.crtStagePlayerLayer[n16][n15] - 80) >= 0 || i.crtStagePlayerLayer[n16][n15] == 10 || i.crtStagePlayerLayer[n16][n15] == 37 || i.crtStagePlayerLayer[n16][n15] == 34 || i.crtStagePlayerLayer[n16][n15] == 35) {
                                                                        b49 = b51;
                                                                        b50 = false;
                                                                        continue Label_3289;
                                                                    }
                                                                    if (!b51) {
                                                                        b52 = b51;
                                                                        break Label_3289;
                                                                    }
                                                                    continue;
                                                                }
                                                            }
                                                            b52 = b49;
                                                            break;
                                                        }
                                                        if (b52) {
                                                            this.drInt = 0;
                                                            this.dzInt = 0;
                                                            aVoid((int) b36, (byte) 2, (byte) 28, (byte) 3);
                                                            aVoid((int) b36, aByte(n12, (byte) 0, (byte) 6), (byte) 0, (byte) 7);
                                                            aVoid((int) b36, (byte) 2, (byte) 26, (byte) 2);
                                                            aVoid((int) b36, (byte) aInt9, (byte) 14, (byte) 6);
                                                            b53 = b36;
                                                            b54 = (byte) (aInt10 + 1);
                                                            b55 = 20;
                                                            b56 = 6;
                                                            break Label_3362;
                                                        }
                                                    }
                                                    b53 = b36;
                                                    b54 = 3;
                                                    b55 = 28;
                                                    b56 = 3;
                                                }
                                                aVoid((int) b53, b54, b55, b56);
                                                aInt9 += b39;
                                            } else {
                                                b39 = b41;
                                                aInt9 += b39;
                                            }
                                        } else if (b39 != 0) {
                                            b39 = 0;
                                            aVoid((int) b36, (byte) 0, (byte) 45, (byte) 2);
                                        }
                                    }
                                    if (b41 == -2) {
                                        break;
                                    }
                                    switch (b39) {
                                        case 0: {
                                            final byte b57 = b36;
                                            final byte b58 = (byte) aInt9;
                                            final int n17 = aInt10;
                                            final byte b59 = b37;
                                            final boolean b60 = b40;
                                            final byte b61 = b59;
                                            int n18 = n17;
                                            final byte b62 = b58;
                                            final byte b63 = b57;
                                            if (!b60 && aInt(i.eIntArrArr[b62][n18], b61, (byte) 3, (byte) 4) == 0) {
                                                aVoid(b62, n18, b61, (byte) 3, (byte) 3, (byte) 4);
                                            }
                                            byte b64;
                                            if ((b64 = (byte) (b61 + 1)) > 2) {
                                                b64 = 0;
                                                ++n18;
                                                aVoid((int) b63, (byte) n18, (byte) 37, (byte) 6);
                                            }
                                            aVoid((int) b63, b64, (byte) 43, (byte) 2);
                                            byte b65;
                                            int n19;
                                            byte b66;
                                            byte b67;
                                            if (b60) {
                                                b65 = b62;
                                                n19 = n18;
                                                b66 = b64;
                                                b67 = 6;
                                            } else {
                                                aVoid(b62, n18, b64, b63, (byte) 0, (byte) 3);
                                                b65 = b62;
                                                n19 = n18;
                                                b66 = b64;
                                                b67 = 0;
                                            }
                                            aVoid(b65, n19, b66, b67, (byte) 3, (byte) 4);
                                            break Label_3627;
                                        }
                                        case -1:
                                        case 1: {
                                            final byte b68 = (byte) aInt9;
                                            final int n20 = aInt10;
                                            final byte b69 = b37;
                                            final byte b70 = b38;
                                            final byte b71 = b69;
                                            final int n21 = n20;
                                            final byte b72 = b68;
                                            byte b73;
                                            if ((b73 = (byte) (b70 + 1)) > 2) {
                                                b73 = 0;
                                            }
                                            aVoid(b72, n21, b71, b73, (byte) 7, (byte) 2);
                                            break Label_3627;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        b16 = (b17 = (byte) (b18 + 1));
                    }
//                    break;
                }
                case 1: {
                    this.xByte = 2;
                    return;
                }
                case 4: {
                    byte b75;
                    byte b74 = b75 = 0;
                    while (true) {
                        final byte b76 = b75;
                        if (b74 >= 15) {
                            break;
                        }
                        Label_3776:
                        {
                            if (aInt(b76, (byte) 0, (byte) 4) == 3) {
                                int aInt11 = aInt(b76, (byte) 13, (byte) 7);
                                int aInt12 = aInt(b76, (byte) 20, (byte) 7);
                                final int aInt13 = aInt(b76, (byte) 4, (byte) 2);
                                i.bLongArr[b76] = 0L;
                                byte b77 = 0;
                                byte b78 = 0;
                                while (true) {
                                    byte b79 = 0;
                                    Label_3752:
                                    {
                                        byte b80 = 0;
                                        switch (aInt13) {
                                            case 0: {
                                                ++aInt12;
                                                b77 = 0;
                                                b79 = 0;
                                                break Label_3752;
                                            }
                                            case 1: {
                                                ++aInt11;
                                                b80 = 1;
                                                break;
                                            }
                                            case 2: {
                                                --aInt11;
                                                b80 = -1;
                                                break;
                                            }
                                            default: {
                                                this.aByte(aInt11, aInt12, (byte) 7, b77, b78, bByte(aInt11, aInt12));
                                                break Label_3776;
                                            }
                                        }
                                        b77 = b80;
                                        b79 = 2;
                                    }
                                    b78 = b79;
                                    continue;
                                }
                            }
                        }
                        b74 = (b75 = (byte) (b76 + 1));
                    }
                    this.xByte = 2;
                    return;
                }
                case 5: {
                    final int dvInt = this.dvInt;
                    final int dwInt = this.dwInt;
                    final int dvInt2 = dvInt;
                    this.dqInt = 0;
                    int[] array;
                    int n22;
                    if (this.dxInt > 1) {
                        array = i.eIntArrArr[dvInt2];
                        n22 = dwInt - 1;
                    } else {
                        array = i.eIntArrArr[dvInt2 + this.dxInt];
                        n22 = dwInt;
                    }
                    aVoid((int) (this.wByte = (byte) aInt(array[n22], (byte) 2, (byte) 0, (byte) 3)), (byte) 0, (byte) 47, (byte) 2);
                    final int aInt14 = aInt((int) this.wByte, (byte) 7, (byte) 7);
                    int n23 = 0;
                    int n24 = 0;
                    int dyInt = 0;
                    int n25 = 0;
                    int n26 = 0;
                    switch (this.dxInt) {
                        case 2: {
                            n23 = 0;
                            n24 = dvInt2;
                            dyInt = dwInt;
                            n25 = aInt14;
                            n26 = dwInt - 1;
                            final int n27 = -1;
                            this.dwInt = n27;
                            this.dvInt = n27;
                            break;
                        }
                        default: {
                            final int dxInt = this.dxInt;
                            n24 = dvInt2 + dxInt;
                            n23 = ((dxInt < 0) ? 1 : 2);
                            dyInt = dwInt + 1;
                            final int n28 = aInt14;
                            final int n29 = n24;
                            int n30 = dyInt;
                            int n31 = n29;
                            byte aByte = 0;
                            int n32 = 1;
                            final int dxInt2 = this.dxInt;
                            int n33 = 0;
                            Label_4322:
                            while (true) {
                                int n34 = 0;
                                while ((i.eIntArrArr[n31 + dxInt2][n30 - 1] != 0 && (byte) (i.crtStagePlayerLayer[n31][n30] - 80) >= 0) || i.crtStagePlayerLayer[n31][n30] == 10 || i.crtStagePlayerLayer[n31][n30] == 37 || i.crtStagePlayerLayer[n31][n30] == 34 || i.crtStagePlayerLayer[n31][n30] == 35) {
                                    n31 += dxInt2;
                                }
                                int n35 = 0;
                                int a2;
                                while (true) {
                                    a2 = n35;
                                    if ((byte) (i.crtStagePlayerLayer[n31 + a2][n30] - 80) >= 0 || i.crtStagePlayerLayer[n31 + a2][n30] == 10 || i.crtStagePlayerLayer[n31 + a2][n30] == 37 || i.crtStagePlayerLayer[n31 + a2][n30] == 34 || i.crtStagePlayerLayer[n31 + a2][n30] == 35) {
                                        break;
                                    }
                                    if (n32 != 0) {
                                        n32 = 0;
                                        aVoid((int) (aByte = this.aByte(n31, n30, (byte) 8, (byte) (-2), (byte) 2, (byte) 0)), (byte) 5, (byte) 28, (byte) 3);
                                        aVoid((int) aByte, (byte) n31, (byte) 14, (byte) 6);
                                        aVoid((int) aByte, (byte) n30, (byte) 20, (byte) 6);
                                    }
                                    aVoid(n31 + a2, n30, (byte) 2, aByte, (byte) 0, (byte) 3);
                                    n35 = a2 + dxInt2;
                                }
                                final int abs = Math.abs(a2);
                                n33 += abs;
                                ++n30;
                                while (i.eIntArrArr[n31][n30] == 0) {
                                    n31 += dxInt2;
                                    if (n34 >= abs || n31 < 0 || n31 == this.crtStageWidth) {
                                        break Label_4322;
                                    }
                                    ++n34;
                                }
                            }
                            if (n33 > 0) {
                                aVoid((int) aByte, (byte) n33, (byte) 7, (byte) 7);
                            }
                            n25 = n28 - n33;
                            n26 = dwInt;
                            this.dvInt = dvInt2;
                            this.dwInt = dwInt;
                            break;
                        }
                    }
                    aVoid((int) this.wByte, (byte) n23, (byte) 45, (byte) 2);
                    this.dyInt = dyInt;
                    this.aByte((byte) n25, (byte) n24, (byte) n26, (byte) n23);
                    byte b81;
                    aVoid(b81 = bByte(n24, n26), (byte) 2, (byte) 0, (byte) 4);
                    this.xByte = 1;
                    while (true) {
                        i j = null;
                        int n36 = 0;
                        int n37 = 0;
                        byte b82 = 0;
                        byte b83 = 0;
                        byte b84 = 0;
                        Label_4495:
                        {
                            switch (this.dxInt) {
                                case 2: {
                                    j = this;
                                    n36 = n24;
                                    n37 = dwInt;
                                    b82 = 3;
                                    b83 = 0;
                                    b84 = 0;
                                    break Label_4495;
                                }
                                case 1: {
                                    j = this;
                                    n36 = n24 - 1;
                                    n37 = dwInt;
                                    b82 = 14;
                                    b83 = -1;
                                    break;
                                }
                                case -1: {
                                    j = this;
                                    n36 = n24 + 1;
                                    n37 = dwInt;
                                    b82 = 11;
                                    b83 = 1;
                                    break;
                                }
                                default: {
                                    aVoid((int) b81, (byte) 6, (byte) 28, (byte) 3);
                                    this.dxInt = 0;
                                    break Label_4517;
                                }
                            }
                            b84 = 2;
                        }
                        b81 = j.aByte(n36, n37, b82, b83, b84, b81);
                        continue;
                    }
                }
            }
        }
    }

    private static void fVoid(final byte b) {
        i.aLongArr[b - 1] = 0L;
    }

    private byte aByte(final byte b, int n, final int n2, final byte b2, final byte b3, final byte b4, final boolean b5) {
        byte b6;
        if ((byte) (i.crtStagePlayerLayer[n + b4][n2] - 80) >= 0 || i.crtStagePlayerLayer[n + b4][n2] == 10 || i.crtStagePlayerLayer[n + b4][n2] == 37 || i.crtStagePlayerLayer[n + b4][n2] == 34 || i.crtStagePlayerLayer[n + b4][n2] == 35) {
            b6 = -2;
        } else {
            if (b2 != (b6 = b4)) {
                aVoid((int) b, (byte) ((b4 < 0) ? 2 : b4), (byte) 45, (byte) 2);
            }
            n += b4;
            aVoid((int) b, (byte) n, (byte) 31, (byte) 6);
            aVoid(n, n2, b3, b, (byte) 0, (byte) 3);
            if (b5) {
                cVoid(n, n2, b3);
            } else {
                final int aInt = aInt((int) b, (byte) 28, (byte) 3);
                int n3;
                byte b7;
                if (b4 > 0) {
                    n3 = ((aInt == 6 && this.dvInt == n && this.dwInt == n2) ? 11 : 4);
                    b7 = 9;
                } else {
                    n3 = ((aInt == 6 && this.dvInt == n && this.dwInt == n2) ? 14 : 5);
                    b7 = 12;
                }
                final byte b8 = b7;
                int n4;
                int n5;
                byte b9;
                int n6;
                if ((byte) (i.crtStagePlayerLayer[n][n2 + 1] - 80) >= 0 || i.crtStagePlayerLayer[n + b4][n2] == 10 || i.crtStagePlayerLayer[n + b4][n2] == 37 || i.crtStagePlayerLayer[n + b4][n2] == 34 || i.crtStagePlayerLayer[n + b4][n2] == 35) {
                    n4 = n;
                    n5 = n2;
                    b9 = b3;
                    n6 = n3;
                } else {
                    n4 = n;
                    n5 = n2;
                    b9 = b3;
                    n6 = b8;
                }
                aVoid(n4, n5, b9, (byte) n6, (byte) 3, (byte) 4);
            }
        }
        return b6;
    }

    private static byte aByte(final int n, final byte b, final byte b2) {
        return (byte) (n >>> b & ~(16777215 << b2));
    }

    private static void cVoid(final int n, final int n2, final byte b) {
        final int n3 = i.eIntArrArr[n][n2];
        final byte b2 = (byte) (b * 9);
        i.eIntArrArr[n][n2] = (n3 ^ (n3 >>> b2 & 0x1FF) << b2);
        i.cByteArrArr[n][n2] = 24;
    }

    private byte aByte(final int n, final int n2, final byte b, byte b2, final byte b3, final byte b4) {
        int n3;
        byte b5 = (byte) (n3 = 1);
        byte b6;
        while (true) {
            b6 = (byte) n3;
            if (b5 > 15 || aInt((int) b6, (byte) 28, (byte) 3) == 0) {
                break;
            }
            b5 = (byte) (n3 = (byte) (b6 + 1));
        }
        i.aLongArr[b6 - 1] = 0L;
        if (b == 7) {
            cVoid(n, n2, b3);
            aVoid((int) b6, (byte) 7, (byte) 28, (byte) 3);
        } else {
            aVoid((int) b6, (byte) 1, (byte) 28, (byte) 3);
            aVoid((int) b6, b4, (byte) 54, (byte) 3);
            aVoid(n, n2, b3, b6, (byte) 0, (byte) 3);
            aVoid(n, n2, b3, b, (byte) 3, (byte) 4);
        }
        aVoid((int) b6, (byte) n, (byte) 31, (byte) 6);
        aVoid((int) b6, (byte) n2, (byte) 37, (byte) 6);
        aVoid((int) b6, b3, (byte) 43, (byte) 2);
        if (b2 < 0) {
            b2 = 2;
        }
        aVoid((int) b6, b2, (byte) 45, (byte) 2);
        return b6;
    }

    private static int aInt(final int n, final int n2, int aInt, final byte b) {
        final byte b2;
        final int aInt2 = aInt((int) (b2 = (byte) aInt(aInt, b, (byte) 0, (byte) 3)), (byte) 31, (byte) 6);
        final int aInt3 = aInt((int) b2, (byte) 37, (byte) 6);
        final int aInt4 = aInt((int) b2, (byte) 43, (byte) 2);
        aInt = aInt(aInt, b, (byte) 3, (byte) 4);
        if (aInt2 == n && aInt3 == n2 && aInt4 == b) {
            int n3 = 0;
            switch (aInt) {
                case 4: {
                    n3 = 1;
                    break;
                }
                case 5: {
                    n3 = 2;
                    break;
                }
                default: {
                    return aInt << 1;
                }
            }
            aInt = n3;
            return aInt << 1;
        }
        switch (aInt) {
            case 6: {
                cVoid(n, n2, b);
                break;
            }
        }
        return aInt << 1;
    }

    private void lVoid(final int dvInt, final int dwInt) {
        if (this.lBoolean) {
            this.dxInt = ((i.eIntArrArr[dvInt - 1][dwInt] != 0) ? -1 : ((i.eIntArrArr[dvInt + 1][dwInt] != 0) ? 1 : 0));
            if (this.dxInt == 0) {
                this.dxInt = ((i.eIntArrArr[dvInt][dwInt - 1] != 0) ? 2 : 0);
            }
            if (this.dxInt != 0) {
                this.xByte = 5;
                this.playSound(13);
                this.dvInt = dvInt;
                this.dwInt = dwInt;
            }
        }
    }

    private void mVoid(final int n, final int n2) {
        final byte bByte;
        int n3;
        if ((bByte = bByte(n, n2)) >= 0) {
            aVoid(bByte, (byte) 2, (byte) 0, (byte) 4);
            n3 = 39;
        } else {
            n3 = -1;
        }
        if (n3 > 0) {
            i.crtStagePlayerLayer[n][n2] = -1;
            this.xByte = 1;
            this.aByte(n, n2 + 1, (byte) 0, (byte) 0, (byte) 0, bByte(n, n2));
        }
    }

    private static int bInt(final f_Sprite f, int n) {
        n = (n << 2) + 3;
        return f.frameBBoxes[n] & 0xFF;
    }

    private static int cInt(final f_Sprite f, int n) {
        n = (n << 2) + 2;
        return f.frameBBoxes[n] & 0xFF;
    }

    private static void oVoid(int n) {
        try {
            n %= 8;
            i.fClassString = d.getLocalizedText(n + 69);
            if (n <= 4) {
                i.aClassf = loadSprite("/tips.f", n);
                return;
            }
            i.aClassf = null;
        } catch (Exception ex) {
        }
    }

    private void atVoid() {
        this.RBoolean = false;
        oVoid(this.agInt);
        final Graphics aClassGraphics;
        (aClassGraphics = this.aClassGraphics).setColor(798521);
        aClassGraphics.fillRoundRect(20, 40, 200, 220, 8, 8);
        aClassGraphics.setColor(13540096);
        aClassGraphics.drawRoundRect(20, 40, 200, 220, 8, 8);
        final Graphics graphics = aClassGraphics;
        final String fClassString = i.fClassString;
        int a = 65;
        final String s = fClassString;
        final Graphics graphics2 = graphics;
        final String[] a2 = c.aClassStringArr(s, '\n');
        final int n = this.agInt % 8;
        for (int j = 0; j < a2.length; ++j) {
            i.textSize8.font.getHeight();
            int n3;
            final int n2 = ((n == 0 && (j == 1 || j == 4)) || (n > 0 && n < 4 && j == 1)) ? ((n == 0 && j == 1) ? (n3 = 7) : ((n == 0 && j == 4) ? (n3 = 6) : (n3 = 0))) : (n3 = -1);
            final int n4 = n3;
            if (n2 >= 0) {
                if (i.aClassf == null) {
                    i.aClassf = loadSprite("/tips.f", this.agInt);
                }
                if (i.aClassf != null) {
                    try {
                        i.aClassf.drawFrame(graphics2, n4, 120 - cInt(i.aClassf, n4) / 2, a - 5, 0);
                        a += (i.aClassf.frameBBoxes[(n4 << 2) + 3] & 0xFF) + 10;
                    } catch (Exception ex) {
                    }
                }
            } else {
                a = c.aInt(graphics2, a2[j], 120, a, 170);
            }
        }
    }

    private static void aVoid(final Graphics graphics, final h h, String s, final int n, final int n2, int aInt, int a, final boolean b) {
        h.dInt = a;
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        s = aClassString(s, 230);
        aInt = aInt(h, s, b ? -1 : 0);
        a = h.calculateTextHeight(s);
        final int n3 = n - (aInt >> 1);
        graphics.setColor(798521);
        graphics.fillRoundRect(n3 - 5, n2 - 5, aInt + 10, a + 10, 10, 10);
        graphics.setColor(13540096);
        graphics.drawRoundRect(n3 - 5, n2 - 5, aInt + 10, a + 10, 10, 10);
        h.drawText(graphics, s, n, n2 + 10, 17);
    }

    private void auVoid() {
        this.HBoolean = false;
        aVoid(i.aClassfArr[23], true);
        i.aClassfArr[23] = null;
        aVoid(i.aClassfArr[24], true);
        i.aClassfArr[24] = null;
        aVoid(i.aClassfArr[25], true);
        i.aClassfArr[25] = null;
        aVoid(i.aClassfArr[26], true);
        i.aClassfArr[26] = null;
        aVoid(i.aClassfArr[17], true);
        i.aClassfArr[17] = null;
        this.cIntArr = null;
        i.fClassImage = null;
        i.cClassGraphics = null;
        System.gc();
    }

    private void avVoid() {
        this.eVoid();
        this.auBoolean = true;
        this.avBoolean = true;
        this.anBoolean = true;
        i.bByte = 21;
        this.bsInt = 0;
        this.brInt = 14;
        this.dKInt = 100;
        if (this.crtStageI > bInt(this.crtWorldIndex)) {
            this.crtStageI = bInt(this.crtWorldIndex);
        }
        this.awVoid();
    }

    private void awVoid() {
        i.aLongArrArr = new long[12][12];
        this.cIntArr = new int[20];
    }

    private static int aInt(final long n, final byte b, final byte b2) {
        return (int) (n >>> b & ~(-1L << b2));
    }

    private static void aVoid(final int n, final int n2, final int n3, final byte b, final byte b2) {
        final long n4 = i.aLongArrArr[n][n2];
        i.aLongArrArr[n][n2] = ((n4 ^ (long) aInt(n4, b, b2) << b) | (long) n3 << b);
    }

    private boolean hBoolean() {
        boolean b = false;
        final int n = this.eiInt >> 1;
        i i;
        int ekInt;
        if (this.ekInt < 0) {
            i = this;
            ekInt = 2;
        } else {
            i = this;
            ekInt = this.ekInt - 1;
        }
        i.ekInt = ekInt;
        if (this.dXInt == 0 && this.dYInt == 0) {
            this.dXInt = this.dVInt;
            this.dYInt = this.dWInt;
        }
        if (this.ekInt == 0) {
            boolean b2;
            if (this.ejInt == n) {
                b2 = true;
            } else {
                ++this.ejInt;
                b2 = false;
            }
            b = b2;
        }
        final int aInt = aInt(i.aLongArrArr[this.dVInt][this.dWInt], (byte) 3, (byte) 3);
        final int aInt2 = aInt(i.aLongArrArr[this.dXInt][this.dYInt], (byte) 3, (byte) 3);
        int n2 = 0;
        while (true) {
            int n3 = 0;
            switch ((aInt == 1 || aInt2 == 1) ? 1 : aInt) {
                case 0: {
                    n3 = 2;
                    break;
                }
                case 1: {
                    n3 = 8;
                    break;
                }
                default: {
                    int j = 0;
                    for (int n4 = this.asBoolean ? (n - 1) : 0, n5 = this.asBoolean ? -1 : 1; j < this.ejInt; ++j, n4 += n5) {
                        final int n6 = n4 << 1;
                        i.aClassfArr[17].drawFrame(this.aClassGraphics, n2, this.cIntArr[n6], this.cIntArr[n6 + 1], 0);
                    }
                    int n7 = 0;
                    int n8 = 0;
                    while (true) {
                        int n9 = 0;
                        switch (aInt) {
                            case 0: {
                                n8 = 0;
                                n9 = 0;
                                break;
                            }
                            case 1: {
                                n8 = 2;
                                n9 = 9;
                                break;
                            }
                            default: {
                                final int n10 = this.dVInt * 13 + n8 + 37;
                                final int n11 = this.dWInt * 13 + n8 + 73;
                                i.aClassfArr[17].drawFrame(this.aClassGraphics, n7, n10, n11, 0);
                                i.aClassfArr[17].drawFrame(this.aClassGraphics, this.aoBoolean ? 7 : 6, n10 + 6, n11 + 6, 0);
                                boolean b3 = true;
                                if (j == n) {
                                    i k;
                                    int emInt;
                                    if (this.emInt < 0) {
                                        k = this;
                                        emInt = 2;
                                    } else {
                                        k = this;
                                        emInt = this.emInt - 1;
                                    }
                                    k.emInt = emInt;
                                    if (this.emInt == 0) {
                                        this.emInt = 1;
                                        b3 = false;
                                    }
                                }
                                Label_0553:
                                {
                                    if (!b3) {
                                        int n12 = 0;
                                        switch (aInt2) {
                                            case 0: {
                                                n8 = 0;
                                                n12 = 0;
                                                break;
                                            }
                                            case 1: {
                                                n8 = 2;
                                                n12 = 9;
                                                break;
                                            }
                                            default: {
                                                break Label_0553;
                                            }
                                        }
                                        n7 = n12;
                                    } else {
                                        int n13 = 0;
                                        switch (aInt2) {
                                            case 0: {
                                                n8 = 0;
                                                n13 = 1;
                                                break;
                                            }
                                            case 1: {
                                                n8 = 2;
                                                n13 = 5;
                                                break;
                                            }
                                            default: {
                                                break Label_0553;
                                            }
                                        }
                                        n7 = n13;
                                    }
                                }
                                final int n14 = this.dXInt * 13 + n8 + 37;
                                final int n15 = this.dYInt * 13 + n8 + 73;
                                i.aClassfArr[17].drawFrame(this.aClassGraphics, n7, n14, n15, 0);
                                if (!b3) {
                                    boolean b4;
                                    if (this.elInt == i.aClassfArr[9].getAnimationFrameCount(0)) {
                                        --this.elInt;
                                        this.arBoolean = true;
                                        b4 = true;
                                    } else {
                                        b4 = false;
                                    }
                                    b = b4;
                                    if (!this.PBoolean) {
                                        i.aClassfArr[9].drawFrame(this.aClassGraphics, this.elInt, n14, n15, 0);
                                    }
                                    ++this.elInt;
                                }
                                return b;
                            }
                        }
                        n7 = n9;
                        continue;
                    }
                }
            }
            n2 = n3;
            continue;
        }
    }

    private void nVoid(final int n, final int n2) {
        if (!this.atBoolean) {
            final int aInt = aInt(i.aLongArrArr[this.cxInt][this.cyInt], (byte) 6, (byte) 5);
            if ((n2 != i.dZInt || n != aInt) && (n != i.dZInt || n2 != aInt)) {
                return;
            }
            if (n == i.dZInt && n2 == aInt) {
                this.asBoolean = true;
            }
        } else {
            if ((n2 != i.dZInt || n != i.dZInt - 1) && (n != i.dZInt || n2 != i.dZInt - 1)) {
                return;
            }
            if (n == i.dZInt && n2 == i.dZInt - 1) {
                this.asBoolean = true;
            }
        }
        this.cIntArr[this.eiInt++] = this.eaInt;
        this.cIntArr[this.eiInt++] = this.ebInt;
    }

    private void axVoid() {
        this.dLInt = 0;
        if (((this.aByte(this.crtWorldIndex, this.crtStageI + 1) & 0x2) != 0x0 && this.crtStageI + 1 == i.dZInt) || this.crtStageI == i.dZInt) {
            this.aqBoolean = false;
            this.arBoolean = true;
        }
        for (int iInteger = 0; iInteger < 12; ++iInteger) {
            for (int j = 0; j < 12; ++j) {
                final long n = i.aLongArrArr[iInteger][j];
                boolean b = false;
                if (n != 0L) {
                    final int aInt = aInt(n, (byte) 3, (byte) 3);
                    final int aInt2 = aInt(n, (byte) 6, (byte) 5);
                    final int n2 = (!this.arBoolean && aInt2 == i.dZInt && aInt2 != 0) ? 1 : aInt(n, (byte) 0, (byte) 3);
                    int n3 = -1;
                    int n4 = -1;
                    int n5 = -1;
                    Label_0278:
                    {
                        if (n2 == 0) {
                            b = (this.bInt(this.crtWorldIndex, aInt2) == this.cInt(this.crtWorldIndex, aInt2));
                            int n6 = 0;
                            switch (aInt) {
                                case 0: {
                                    n4 = 17;
                                    n5 = 0;
                                    n6 = ((aInt(n, (byte) 11, (byte) 3) > 2) ? 13 : 0);
                                    break;
                                }
                                case 1: {
                                    n4 = 18;
                                    n5 = 2;
                                    n6 = 9;
                                    break;
                                }
                                default: {
                                    break Label_0278;
                                }
                            }
                            n3 = n6;
                        } else {
                            switch (aInt) {
                                case 0: {
                                    n5 = 0;
                                    n3 = 1;
                                    break;
                                }
                            }
                        }
                    }
                    final int n7 = iInteger;
                    final int n8 = j;
                    final long n9 = n;
                    final int n10 = aInt;
                    final int n11 = n2;
                    final int n12 = n10;
                    final long n13 = n9;
                    final int n14 = n8;
                    final int n15 = n7;
                    final int aInt3 = aInt(n13, (byte) 6, (byte) 5);
                    this.dLInt |= 1 << aInt3;
                    for (int aInt4 = aInt(n13, (byte) 11, (byte) 3), n16 = 14, k = 0; k < aInt4; ++k, n16 += 4) {
                        int eaInt = 37 + n15 * 13;
                        int ebInt = 73 + n14 * 13;
                        final int aInt5 = aInt(n13, (byte) n16, (byte) 4);
                        n16 += 4;
                        final int aInt6 = aInt(n13, (byte) n16, (byte) 4);
                        final int n17 = aInt5;
                        final int n18 = aInt6;
                        final long n19;
                        final int aInt7 = aInt(n19 = i.aLongArrArr[n17][n18], (byte) 6, (byte) 5);
                        if ((this.dLInt & 1 << aInt7) <= 0) {
                            int n20 = 37 + n17 * 13;
                            int n21 = 73 + n18 * 13;
                            eaInt += 6;
                            ebInt += 6;
                            n20 += 6;
                            n21 += 6;
                            this.eaInt = eaInt;
                            this.ebInt = ebInt;
                            this.ecInt = 0;
                            this.edInt = n20 - eaInt;
                            this.eeInt = n21 - ebInt;
                            this.efInt = 0;
                            this.egInt = 0;
                            this.ehInt = 1;
                            int n22 = 1;
                            int n23 = 1;
                            if (this.edInt < 0) {
                                n22 = -1;
                                this.edInt = -this.edInt;
                            }
                            if (this.eeInt < 0) {
                                n23 = -1;
                                this.eeInt = -this.eeInt;
                            }
                            int n24 = 0;
                            int aInt8 = aInt(n19, (byte) 0, (byte) 3);
                            int aInt9 = aInt(n19, (byte) 3, (byte) 3);
                            if (n12 == 1) {
                                aInt9 = n12;
                            }
                            if (n11 == 1) {
                                if (aInt9 == 1) {
                                    continue;
                                }
                                aInt8 = n11;
                            }
                            if (!this.arBoolean && aInt7 == i.dZInt) {
                                aInt8 = 1;
                            }
                            Label_0699:
                            {
                                if (aInt8 == 0) {
                                    int n25 = 0;
                                    switch (aInt9) {
                                        case 0: {
                                            n25 = 2;
                                            break;
                                        }
                                        case 1: {
                                            n25 = 8;
                                            break;
                                        }
                                        default: {
                                            break Label_0699;
                                        }
                                    }
                                    n24 = n25;
                                } else {
                                    int n26 = 0;
                                    switch (aInt9) {
                                        case 0: {
                                            n26 = 3;
                                            break;
                                        }
                                        case 1: {
                                            n26 = 4;
                                            break;
                                        }
                                        default: {
                                            break Label_0699;
                                        }
                                    }
                                    n24 = n26;
                                }
                            }
                            if (this.eeInt <= this.edInt) {
                                this.efInt = this.edInt << 1;
                                this.egInt = this.eeInt << 1;
                                while (true) {
                                    if (this.ehInt % 8 == 0) {
                                        i.aClassfArr[17].drawFrame(i.cClassGraphics, n24, this.eaInt - 20, this.ebInt - 69, 0);
                                        if (this.aqBoolean) {
                                            this.nVoid(aInt3, aInt7);
                                        }
                                    }
                                    if (this.eaInt == n20) {
                                        break;
                                    }
                                    this.eaInt += n22;
                                    this.ecInt += this.egInt;
                                    if (this.ecInt > this.edInt) {
                                        this.ebInt += n23;
                                        this.ecInt -= this.efInt;
                                    }
                                    ++this.ehInt;
                                }
                            } else {
                                this.efInt = 2 * this.eeInt;
                                this.egInt = 2 * this.edInt;
                                while (true) {
                                    if (this.ehInt % 8 == 0) {
                                        i.aClassfArr[17].drawFrame(i.cClassGraphics, n24, this.eaInt - 20, this.ebInt - 69, 0);
                                        if (this.aqBoolean) {
                                            this.nVoid(aInt3, aInt7);
                                        }
                                    }
                                    if (this.ebInt == n21) {
                                        break;
                                    }
                                    this.ebInt += n23;
                                    this.ecInt += this.egInt;
                                    if (this.ecInt > this.eeInt) {
                                        this.eaInt += n22;
                                        this.ecInt -= this.efInt;
                                    }
                                    ++this.ehInt;
                                }
                            }
                        }
                    }
                    if (n5 != -1 && n3 != -1) {
                        if (b && n4 != -1) {
                            i.aClassfArr[17].drawFrame(i.cClassGraphics, n4, iInteger * 13 + n5 + 37 - 20, j * 13 + n5 + 73 - 69, 0);
                        }
                        i.aClassfArr[17].drawFrame(i.cClassGraphics, n3, iInteger * 13 + n5 + 37 - 20, j * 13 + n5 + 73 - 69, 0);
                        int n27 = -1;
                        Label_1202:
                        {
                            int n28 = 0;
                            switch (this.crtWorldIndex) {
                                case 0: {
                                    if (aInt2 == 8) {
                                        n28 = 52;
                                        break;
                                    }
                                    break Label_1202;
                                }
                                case 1: {
                                    if (aInt2 == 9) {
                                        n28 = 53;
                                        break;
                                    }
                                    break Label_1202;
                                }
                                case 2: {
                                    if (aInt2 == 10) {
                                        n28 = 54;
                                        break;
                                    }
                                    break Label_1202;
                                }
                            }
                            n27 = n28;
                        }
                        if (n27 != -1) {
                            i.aClassfArr[n27].drawFrame(i.cClassGraphics, 0, iInteger * 13 - 8 + 37 - 20, j * 13 - 8 + 73 - 69, 0);
                        }
                    }
                }
            }
        }
        this.aqBoolean = false;
    }

    private void aVoid(final String name) throws IOException {
        final InputStream resourceAsStream;
        final int n = ((byte) (resourceAsStream = this.getClass().getResourceAsStream(name)).read() & 0xFF) + (((byte) resourceAsStream.read() & 0xFF) << 8);
        final int read = resourceAsStream.read();
        resourceAsStream.read(i.fByteArr = new byte[n]);
        resourceAsStream.close();
        int n2 = 0;
        for (int iInteger = 0; iInteger < read; ++iInteger) {
            final byte b = i.fByteArr[n2++];
            final byte b2 = i.fByteArr[n2++];
            final byte b3 = i.fByteArr[n2++];
            final byte dkInt = i.fByteArr[n2++];
            if (b3 == 1 && dkInt < this.dKInt) {
                this.dKInt = dkInt;
            }
            final byte b4 = i.fByteArr[n2++];
            aVoid(b, b2, 1, (byte) 0, (byte) 3);
            aVoid(b, b2, b3, (byte) 3, (byte) 3);
            aVoid(b, b2, dkInt, (byte) 6, (byte) 5);
            aVoid(b, b2, b4, (byte) 11, (byte) 3);
            byte b5 = 14;
            for (byte b6 = 0; b6 < b4; ++b6) {
                aVoid(b, b2, i.fByteArr[n2++], b5, (byte) 4);
                final byte b7 = (byte) (b5 + 4);
                aVoid(b, b2, i.fByteArr[n2++], b7, (byte) 4);
                b5 = (byte) (b7 + 4);
            }
        }
        i.fByteArr = null;
        System.gc();
    }

    public static final void aVoid(final Graphics graphics, final int n, int n2, final int n3, int n4, int iInteger, final int n5) {
        n2 += 15;
        n4 += 2;
        final int clipX = graphics.getClipX();
        final int clipY = graphics.getClipY();
        final int clipWidth = graphics.getClipWidth();
        final int clipHeight = graphics.getClipHeight();
        graphics.setClip(n, n2, n3, n4);
        graphics.setColor(iInteger);
        graphics.fillRect(n, n2, n3, n4);
        graphics.setClip(n - 3, n2, n3 + 6, n4);
        for (iInteger = n2; iInteger <= n2 + n4; iInteger += 8) {
            graphics.drawImage(i.demoUITextures[n5][7], n, iInteger, 24);
            graphics.drawImage(i.demoUITextures[n5][5], n + n3, iInteger, 20);
        }
        graphics.setClip(n, n2 - 3, n3, n4 + 6);
        for (iInteger = n; iInteger <= n + n3; iInteger += 8) {
            graphics.drawImage(i.demoUITextures[n5][4], iInteger, n2, 36);
            graphics.drawImage(i.demoUITextures[n5][6], iInteger, n2 + n4, 20);
        }
        graphics.setClip(n - 3, n2 - 3, n3 + 6, n4 + 6);
        graphics.drawImage(i.demoUITextures[n5][0], n, n2, 40);
        graphics.drawImage(i.demoUITextures[n5][1], n + n3, n2, 36);
        graphics.drawImage(i.demoUITextures[n5][2], n, n2 + n4, 24);
        graphics.drawImage(i.demoUITextures[n5][3], n + n3, n2 + n4, 20);
        graphics.setClip(clipX, clipY, clipWidth, clipHeight);
    }

    public static final void aVoid(final Graphics graphics, int clipX, int clipY, int clipWidth, final int n, int clipHeight, final int n2, final int n3, final int n4) {
        clipX = graphics.getClipX();
        clipY = graphics.getClipY();
        clipWidth = graphics.getClipWidth();
        clipHeight = graphics.getClipHeight();
        aVoid(graphics, 6, 197, 226, n, 73, 1);
        aVoid(graphics, 16, 192 - n4, n3, n4, 73, 1);
        graphics.setClip(13, 195, n3 + 6, 3);
        graphics.setColor(73);
        graphics.fillRect(13, 195, n3 + 6, 3);
        graphics.drawImage(i.demoUITextures[1][3], 16, 195, 24);
        graphics.drawImage(i.demoUITextures[1][2], n3 + 16, 195, 20);
        graphics.setClip(clipX, clipY, clipWidth, clipHeight);
    }

    private void ayVoid() {
        if (this.nInt == this.enInt && !this.avBoolean) {
            return;
        }
        if (this.nInt != this.enInt) {
            this.avBoolean = true;
        }
        this.aClassGraphics.setClip(0, 0, 240, 320);
        if (this.avBoolean) {
            this.aVoid(this.aClassGraphics, true);
            this.aClassGraphics.setColor(0);
            this.aClassGraphics.fillRect(0, 0, 240, a_Config.bInt);
            this.aClassGraphics.setColor(16777215);
            this.aClassGraphics.drawLine(0, a_Config.bInt, 240, a_Config.bInt);
            i.textSize0.drawTextWithFlags(this.aClassGraphics, i.texts[63], 120, 9, 17);
            aVoid(this.aClassGraphics, 10, 35, 220, 90, 4273165, 0);
            if (this.oInt != -1) {
                i.textSize8.drawText(this.aClassGraphics, aClassString(this.aClassString, 200), 120, 280, 17);
            }
            if (this.aaBoolean) {
                this.aaBoolean = false;
                i.textSize8.drawTextWithFlags(this.aClassGraphics, this.aClassString, 120, 191, 1);
            }
            i.textSize8.drawText(this.aClassGraphics, this.gClassString, 120, 260, 17);
            this.IVoid();
            this.JVoid();
            this.avBoolean = false;
        }
        if (this.nInt != this.enInt) {
            this.aClassGraphics.setColor(4273165);
            this.aClassGraphics.fillRect(20, 58 + ((this.enInt >= 0) ? this.enInt : this.nInt) * 20 + 2, 7, 9);
        }
        i.aClassfArr[17].drawFrame(this.aClassGraphics, 14, 20, 58 + this.nInt * 20 + 2, 0);
        aVoid(this.aClassGraphics, 10, 155, 220, 70, 4273165, 0);
        h h;
        Graphics graphics;
        String aClassString;
        if (this.oInt != -1) {
            final String string = i.texts[47] + " " + this.dClassStringBuffer.toString() + "\n" + i.texts[27];
            h = i.textSize8;
            graphics = this.aClassGraphics;
            aClassString = string;
        } else {
            h = i.textSize8;
            graphics = this.aClassGraphics;
            aClassString = this.aClassString;
        }
        h.drawText(graphics, aClassString, 120, 210, 1);
        for (int iInteger = 0; iInteger < 4; ++iInteger) {
            final int n = 58 + iInteger * 20;
            i.aClassfArr[46].drawFrame(this.aClassGraphics, iInteger + 0, 27, n, 0);
            i.textSize8.drawTextWithFlags(this.aClassGraphics, i.texts[iInteger + 120], 53, n + 8, 0);
        }
        final Image[] array;
        int width = (array = i.aClassfArr[0].images[0])[11].getWidth();
        final int width2 = array[15].getWidth();
        this.aClassGraphics.drawImage(array[11], 100, 175, 0);
        for (int j = 0; j < 8; ++j) {
            this.aClassGraphics.drawImage(array[(j >= 4) ? 13 : 15], width + 100, 175, 0);
            width += width2;
        }
        final int nInt = this.nInt;
        final int n2 = width;
        int n3 = width - (width2 << 2);
        for (int k = 0; k <= nInt; ++k) {
            this.aClassGraphics.drawImage(array[15], n3 + 100, 175, 0);
            n3 += width2;
        }
        this.aClassGraphics.drawImage(array[17], n2 + 100, 175, 0);
        if (this.nInt != this.enInt) {
            this.enInt = this.nInt;
        }
    }

    private void playSound(final int soundID) {
        this.aClassj.playSound(soundID);
    }

    private void azVoid() {
        if (this.aRInt != 2) {
            return;
        }
        final Graphics aClassGraphics;
        (aClassGraphics = this.aClassGraphics).setColor(0, 0, 0);
        aClassGraphics.fillRect(0, 0, 240, 320);
        int n = -17;
        int epInt = this.epInt;
        int epInt2 = this.epInt;
        final int n2 = (this.eoInt >= 340) ? (-(this.eoInt % 17)) : (340 - this.eoInt - 17);
        while (epInt < i.sByteArr.length && n < 340) {
            if (i.sByteArr[epInt] == 10) {
                h.setColor(16777215);
                final Graphics graphics = aClassGraphics;
                final byte[] sByteArr = i.sByteArr;
                final h aClassh = i.textSize8;
                final int n3 = epInt2;
                final int n4 = epInt - epInt2;
                final int n5 = n + n2;
                final int n6 = n4;
                final int n7 = n3;
                final h h = aClassh;
                final byte[] array = sByteArr;
                final Graphics graphics2 = graphics;
                int n8 = h.font.getHeight();
                int n9 = 0;
                int n10 = n5;
                final boolean b = n5 != -1;
                final int cInt = h.RGB;
                int n11 = n7;
                boolean b2 = true;
                int n12 = n7;
                int n13 = 0;
                for (int i = n7; i <= n7 + n6; ++i) {
                    int n14 = 10;
                    if (i < n7 + n6) {
                        n14 = (array[i] & 0xFF);
                    }
                    if (b2 && n9 > 234) {
                        n9 = n13;
                        array[n12] = 10;
                        i = n12 - 1;
                    } else if (n14 == 10) {
                        if (b2 && b) {
                            n9 = 120 - (n9 >> 1);
                            i = n11 - 1;
                        } else {
                            n9 = 0;
                            n11 = i + 1;
                            n10 += n8;
                            n8 = h.font.getHeight();
                        }
                        if (b) {
                            b2 = !b2;
                        }
                    } else {
                        int n17 = 0;
                        int charWidth = 0;
                        Label_0563:
                        {
                            int n16;
                            int n15;
                            if (n14 > 32) {
                                n15 = (n16 = array[i]);
                            } else {
                                if (n14 == 32) {
                                    n12 = i;
                                    n13 = n9;
                                    n17 = n9;
                                    charWidth = (h.aIntArr[0] & 0xFF) + h.bIntArr[1];
                                    break Label_0563;
                                }
                                if (n14 == 1) {
                                    ++i;
                                    h.RGB = array[i];
                                    continue;
                                }
                                if (n14 != 2) {
                                    continue;
                                }
                                ++i;
                                n15 = (n16 = (array[i] & 0xFF));
                            }
                            final int n18 = n16;
                            if (n15 >= 89) {
                                if (!b2 && b) {
                                    h.drawTextWithFlags(graphics2, "" + (char) n18, n9, n10 + 10, 0);
                                }
                                n17 = n9;
                            } else {
                                if (!b2 && b) {
                                    h.drawTextWithFlags(graphics2, "" + (char) n18, n9, n10 + 10, 0);
                                }
                                n17 = n9;
                            }
                            charWidth = h.font.charWidth((char) n18);
                        }
                        n9 = n17 + charWidth;
                    }
                }
                h.RGB = cInt;
                n += 17;
                epInt2 = epInt + 1;
            }
            ++epInt;
        }
        int n19 = 0;
        for (int j = 6; j > 0; --j) {
            aClassGraphics.setColor(0);
            aClassGraphics.fillRect(0, n19, 240, j);
            aClassGraphics.fillRect(0, 320 - n19 - j, 240, j);
            n19 += j + 1;
        }
        this.IVoid();
    }

    private static String[] generateStageTitles() {
        final String[] titles = new String[16];
        int secretStageI = 1;
        for (int titleI = 0; titleI < 15; ++titleI) {
            if (titleI < 11) {
                try {
                    final String stageTitle = i.texts[66]; // "Stage %U"
                    if (stageTitle.indexOf("%U") == -1 || stageTitle.length() == 1) {
                        titles[titleI] = stageTitle;
                    } else {
                        titles[titleI] = d.replaceAll(stageTitle, "%U", "" + (titleI + 1));
                    }
                } catch (Exception ex) {
                    titles[titleI] = "E";
                }
            } else {
                try {
                    final String secretStageTitle = i.texts[62]; // "Secret stage %U"
                    if (secretStageTitle.indexOf("%U") == -1 || secretStageTitle.length() == 1) {
                        titles[titleI] = secretStageTitle;
                    } else {
                        titles[titleI] = d.replaceAll(secretStageTitle, "%U", "" + secretStageI);
                    }
                    ++secretStageI;
                } catch (Exception ex2) {
                    titles[titleI] = "E";
                }
            }
        }
        try {
            titles[15] = i.texts[31]; // "Intro stage"
        } catch (Exception ex3) {
            titles[15] = " ";
        }
        return titles;
    }

    private void aVoid(final String s, final int n, final int n2, final int n3, final int etInt, final int n4) {
        this.nLong = System.currentTimeMillis();
        i.eqInt = 5000;
        this.erInt = -1;
        this.esInt = -1;
        this.hClassString = aClassString(s, 220);
        this.etInt = etInt;
        this.euInt = 0;
    }

    private void dVoid(final boolean b) {
        i.eqInt = 0;
        this.avBoolean = true;
    }

    private static String aClassString(final String str, final int n) {
        int n2 = 0;
        int index = 0;
        int n3 = 0;
        int n4 = 0;
        final StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i <= sb.length(); ++i) {
            int n5 = 10;
            if (i < sb.length()) {
                n5 = (sb.charAt(i) & '\u00ff');
            }
            if (n2 > n && index != n4) {
                n2 = n3;
                sb.setCharAt(index, '\n');
                i = index - 1;
                n4 = index;
            } else {
                int n6;
                if (n5 == 10) {
                    n6 = 0;
                } else if (n5 > 32) {
                    if (n5 == 64) {
                        n2 += 14;
                    }
                    continue;
                } else {
                    if (n5 != 32) {
                        continue;
                    }
                    index = i;
                    n3 = n2;
                    n6 = n2 + (h.getFontSize() + (h.getFontSize() << 1));
                }
                n2 = n6;
            }
        }
        return sb.toString();
    }

    private static void aAVoid() {
        i.textSize0 = new h(0);
        i.textSize8 = new h(8);
    }

    static {
        i.aBooleanArr = new boolean[]{true, false, false};
        i.bBooleanArr = new boolean[]{false, false, false};
        i.aByteArr = new byte[16];
        i.bByteArr = new byte[8];
        i.cByteArr = new byte[8];
        i.mByte = (i.bByte = 0);
        i.gByteArr = new byte[]{0, 0, -1, 0, 1, 0, 0, 0, 0, 1, 0, -1, 0, 0, 0, 0};
        i.hByteArr = new byte[]{0, 3, 4, 1, 2, 5, 6};
        i.iByteArr = null;
        i.jByteArr = null;
        i.aClasscArr = null;
        i.pByteArr = null;
        i.aBoolean = false;
        i.moreGamesUrl = "more_games_url";
        i.dClassImage = null;
        i.bClassGraphics = null;
        i.cCInt = 0;
        i.cDInt = 0;
        i.cEInt = -1;
        i.cFInt = -1;
        i.cGInt = -1;
        i.cHInt = -1;
        i.eClassImage = null;
        i.cMInt = 0;
        i.cNInt = 0;
        i.cOInt = 0;
        i.VBoolean = false;
        i.WBoolean = true;
        i.crtCheatPageKeyCodeIndex = 0;
        i.cheatPageKeyCode = new int[]{SKEY_POUND, SKEY_NUM4, SKEY_NUM7, SKEY_NUM7, SKEY_NUM2};
        i.deInt = 0;
        i.dfInt = 0;
        i.dgInt = 0;
        i.crtStageDoorXs = new byte[16];
        i.crtStageDoorYs = new byte[16];
        i.akBoolean = false;
        i.aLongArr = new long[15];
        i.bLongArr = new long[15];
        i.aShortArrArr = new short[][]{{0, 16, 1, 40, 6, 44, 3, 18, 5, 22}, {0, 50, 1, 49, 6, 18, 3, 28, 4, 36, 5, 22}, {0, 1, 1, 4, 2, 64, 3, 63}, new short[0], new short[0], new short[0], {0, 50, 4, 36}, {0, 24, 1, 25}, {0, 44, 1, 22}};
        i.dIntArr = new int[]{1, 4, 64};
        i.gIntArrArr = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
        i.bBoolean = false;
        i.sByteArr = null;
        i.worldFiles = new String[]{"/w0.bin", "/w1.bin", "/w2.bin"};
        i.eqInt = 0;
    }
}

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// 
// Decompiled by Procyon v0.5.36
// 

public final class f_Sprite {
    // ADDED START constants
    public static final short PIXEL_FORMAT_8888 = (short) 0x8888;
    public static final short PIXEL_FORMAT_4444 = (short) 0x4444;
    public static final short PIXEL_FORMAT_1555 = (short) 0x5515;
    public static final short PIXEL_FORMAT_0565 = (short) 0x6505;

    public static final short ENCODE_FORMAT_I256 = 0x5602;
    public static final short ENCODE_FORMAT_I16 = 0x1600;
    public static final short ENCODE_FORMAT_I4 = 0x0400;
    public static final short ENCODE_FORMAT_I2 = 0x0200;
    public static final short ENCODE_FORMAT_I256RLE = 0x56F2;
    public static final short ENCODE_FORMAT_I127RLE = 0x27F1;

    public static final short FLAG_FLIP_X = 0x1;
    public static final short FLAG_FLIP_Y = 0x2;
    public static final short FLAG_OFFSET_AF = 0x20;
    // ADDED END

    private static final int[] tmp = new int[4096]; // Added 'final'
    // 1D {width, height} array
    private byte[] modules;
    // 1D {moduleIndex, offsetX, offsetY, flags} array
    private byte[] frameModules;
    // firstFrameModuleIndex for each frame (array)
    private short[] frameFirstModuleIndices;
    // frameModuleCount for each frame (array)
    private byte[] frameFrameModuleCounts;
    // 1D {x, y, w, h} for each frame (array)
    public byte[] frameBBoxes;
    // 1D {frameIndex, time, offsetX, offsetY, flags} for each animation frame (array)
    public byte[] animationFrames;
    // firstAnimationFrameIndex for each animation (array)
    public short[] animationFirstAnimationFrameIndices;
    // animationFrameCount for each animation (array)
    public byte[] animationAnimationFrameCounts;
    // The count of the palettes present
    private int paletteCount;
    // 2D {R, G, B, A} for each color for each palette (array)
    private int[][] palettes;
    // Whether the sprite has any transparent color in any of its palettes
    private boolean hasTransparency;
    // ENCODE_FORMAT of the encoded data
    private short dataFormat;
    // Tmp
    private short[] moduleDataPointers;
    // The encoded pixels for contained modules
    public byte[] moduleData;
    public int paletteI;
    public Image[][] images;
    public static byte[] _unused_mcContents;

    public final void parseSprite(final byte[] array, int ptr) {
        try {
            System.gc();
            ++ptr;
            ++ptr;
            ++ptr;
            ++ptr;
            ++ptr;
            ++ptr;
            final int n2 = 6;
            ++ptr;
            final int n3 = array[n2] & 0xFF;
            final int n4 = 7;
            ++ptr;

            // Modules
            final short moduleCount = (short) (n3 + ((array[n4] & 0xFF) << 8));
            if (moduleCount > 0) {
                System.arraycopy(array, 8, this.modules = new byte[moduleCount << 1], 0, this.modules.length);
                ptr = 8 + this.modules.length;
            }

            // Frames
            final short frameModuleCount = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            if (frameModuleCount > 0) {
                System.arraycopy(array, ptr, this.frameModules = new byte[frameModuleCount << 2], 0, this.frameModules.length);
                ptr += this.frameModules.length;
            }

            final short frameCount = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            if (frameCount > 0) {
                this.frameFrameModuleCounts = new byte[frameCount];
                this.frameFirstModuleIndices = new short[frameCount];
                for (short frameI = 0; frameI < frameCount; ++frameI) {
                    // TODO Hmmm... my web implementation uses an uint16 here, but here only an uint8 is read and an uint8 is skipped
                    this.frameFrameModuleCounts[frameI] = array[ptr++];
                    ++ptr;
                    this.frameFirstModuleIndices[frameI] = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
                }
                final int n9 = frameCount << 2;
                this.frameBBoxes = new byte[n9];
                for (int i = 0; i < n9; ++i) {
                    this.frameBBoxes[i] = array[ptr++];
                }
            }

            // Animations
            final short animationFramesCount = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            if (animationFramesCount > 0) {
                System.arraycopy(array, ptr, this.animationFrames = new byte[animationFramesCount * 5], 0, this.animationFrames.length);
                ptr += this.animationFrames.length;
            }

            final short animationCount = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            if (animationCount > 0) {
                this.animationAnimationFrameCounts = new byte[animationCount];
                this.animationFirstAnimationFrameIndices = new short[animationCount];
                for (short n12 = 0; n12 < animationCount; ++n12) {
                    // TODO Hmmm... again, as above, only an uint8 is read
                    this.animationAnimationFrameCounts[n12] = array[ptr++];
                    ++ptr;
                    this.animationFirstAnimationFrameIndices[n12] = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
                }
            }

            // Modules image data
            if (moduleCount <= 0) {
                System.gc();
                return;
            }

            // Parse palettes
            final short pixelFormat = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            this.paletteCount = (array[ptr++] & 0xFF);
            final int colorsPerPalette = array[ptr++] & 0xFF;
            this.palettes = new int[16][];
            for (int paletteI = 0; paletteI < this.paletteCount; ++paletteI) {
                this.palettes[paletteI] = new int[colorsPerPalette];
                switch (pixelFormat) {
                    case PIXEL_FORMAT_8888: {
                        for (int k = 0; k < colorsPerPalette; ++k) {
                            final int n15 = (array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8) + ((array[ptr++] & 0xFF) << 16) + ((array[ptr++] & 0xFF) << 24);
                            if ((n15 & 0xFF000000) != 0xFF000000) {
                                this.hasTransparency = true;
                            }
                            this.palettes[paletteI][k] = n15;
                        }
                        break;
                    }
                    case PIXEL_FORMAT_4444: {
                        for (int l = 0; l < colorsPerPalette; ++l) {
                            final int n16 = (array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8);
                            if ((n16 & 0xF000) != 0xF000) {
                                this.hasTransparency = true;
                            }
                            this.palettes[paletteI][l] = ((n16 & 0xF000) << 16 | (n16 & 0xF000) << 12 | (n16 & 0xF00) << 12 | (n16 & 0xF00) << 8 | (n16 & 0xF0) << 8 | (n16 & 0xF0) << 4 | (n16 & 0xF) << 4 | (n16 & 0xF));
                        }
                        break;
                    }
                    case PIXEL_FORMAT_1555: {
                        for (int n17 = 0; n17 < colorsPerPalette; ++n17) {
                            final int n18 = (array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8);
                            int alphaBits = 0xFF000000; // -16777216
                            if ((n18 & 0x8000) != 0x8000) {
                                alphaBits = 0;
                                this.hasTransparency = true;
                            }
                            this.palettes[paletteI][n17] = (alphaBits | (n18 & 0x7C00) << 9 | (n18 & 0x3E0) << 6 | (n18 & 0x1F) << 3);
                        }
                        break;
                    }
                    case PIXEL_FORMAT_0565: {
                        for (int n20 = 0; n20 < colorsPerPalette; ++n20) {
                            final int n21 = (array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8);
                            int alphaBits = 0xFF000000; // -16777216
                            if (n21 == 0xF81F) { // 63519
                                alphaBits = 0;
                                this.hasTransparency = true;
                            }
                            this.palettes[paletteI][n20] = (alphaBits | (n21 & 0xF800) << 8 | (n21 & 0x7E0) << 5 | (n21 & 0x1F) << 3);
                        }
                        break;
                    }
                }
            }

            // Parse module data
            this.dataFormat = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
            if (moduleCount > 0) {
                this.moduleDataPointers = new short[moduleCount];
                int moduleDataSize = 0;
                int tmpPtr = ptr; // idk

                // First pass - calculate the sizes and offsets
                for (short moduleI = 0; moduleI < moduleCount; ++moduleI) {
                    final short size = (short) ((array[tmpPtr++] & 0xFF) + ((array[tmpPtr++] & 0xFF) << 8));
                    this.moduleDataPointers[moduleI] = (short) moduleDataSize;
                    tmpPtr += size;
                    moduleDataSize += size;
                }

                // Second pass - data copying
                this.moduleData = new byte[moduleDataSize];
                for (short moduleI = 0; moduleI < moduleCount; ++moduleI) {
                    final short size = (short) ((array[ptr++] & 0xFF) + ((array[ptr++] & 0xFF) << 8));
                    System.arraycopy(array, ptr, this.moduleData, this.moduleDataPointers[moduleI] & 0xFFFF, size);
                    ptr += size;
                }
            }
            System.gc();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final void createImages(final int paletteI, int _unused_1, int lastModuleI, int _unused_2) {
        if (this.modules == null) return;

        if (lastModuleI == -1)
            lastModuleI = (this.modules.length >> 1) - 1;

        if (this.images == null)
            this.images = new Image[this.paletteCount][];
        if (this.images[paletteI] == null)
            this.images[paletteI] = new Image[this.modules.length >> 1];

        int oldPaletteI = this.paletteI;
        this.paletteI = paletteI;
        System.gc();
        for (int moduleI = 0; moduleI <= lastModuleI; ++moduleI) {
            int packedModuleI = moduleI << 1;
            int width = (this.modules[packedModuleI] & 0xFF);
            int height = (this.modules[packedModuleI + 1] & 0xFF);
            if (width > 0 && height > 0) {
                int[] rgb = this.parseImageData(moduleI);
                if (rgb != null) {
                    boolean processAlpha = false;
                    int pixelCount = width * height;
                    for (int pixel = 0; pixel < pixelCount; ++pixel) {
                        if ((rgb[pixel] & 0xFF000000) != 0xFF000000) {
                            processAlpha = true;
                            break;
                        }
                    }
                    this.images[paletteI][moduleI] = Image.createRGBImage(rgb, width, height, processAlpha);
                }
            }
        }
        System.gc();
        this.paletteI = oldPaletteI;
        System.gc();
    }

    public final void freePalette0Images(int _unused) {
        if (this.modules == null) return;
        if (this.images == null) return;
        if (this.images[0] == null) return;
        for (int i = 0; i < this.images[0].length; ++i) {
            this.images[0][i] = null;
        }
        this.images[0] = null;
        --this.paletteCount;
    }

    public final String toString() {
        // new String(); // Huh?
        int fullSize = 0;
        for (int moduleI = 0; moduleI < this.modules.length / 2; ++moduleI) {
            fullSize += 2 * (this.modules[moduleI * 2] & 0xFF) * (this.modules[moduleI * 2 + 1] & 0xFF);
        }
        return "raw/full: " + this.moduleData.length + "/" + fullSize;
    }

    public final int getAnimationFrameTime(final int animationI, final int animationFrame) {
        return this.animationFrames[(this.animationFirstAnimationFrameIndices[animationI] + animationFrame) * 5 + 1] & 0xFF;
    }

    public final int getAnimationFrameCount(final int animationI) {
        return this.animationAnimationFrameCounts[animationI] & 0xFF;
    }

    public final void drawAnimationFrame(final Graphics graphics, int animationI, int animationFrame, final int baseX, final int baseY, final int flags, int offsetX, int offsetY) {
        int packedAnimationFrameI = (this.animationFirstAnimationFrameIndices[animationI] + animationFrame) * 5; // Introduced a variable
        int frameIndex = (this.animationFrames[packedAnimationFrameI] & 0xFF); // Introduced a variable
        if ((flags & FLAG_OFFSET_AF) != 0x0) {
            offsetX = (((flags & FLAG_FLIP_X) != 0x0) ? (this.animationFrames[packedAnimationFrameI + 2]) : (-this.animationFrames[packedAnimationFrameI + 2]));
            offsetY = (((flags & FLAG_FLIP_Y) != 0x0) ? (this.animationFrames[packedAnimationFrameI + 3]) : (-this.animationFrames[packedAnimationFrameI + 3]));
        }
        this.drawFrame(graphics, frameIndex, baseX - offsetX, baseY - offsetY, flags ^ (this.animationFrames[packedAnimationFrameI + 4] & 0xF));
    }

    public final void drawFrame(final Graphics graphics, final int frameIndex, final int baseX, final int baseY, final int flags) {
        final int frameModuleCount = this.frameFrameModuleCounts[frameIndex] & 0xFF;
        for (short frameModuleI = 0; frameModuleI < frameModuleCount; ++frameModuleI) {
            final int packedFMI = this.frameFirstModuleIndices[frameIndex] + frameModuleI << 2; // Packed frame module index
            final int fmFlags = this.frameModules[packedFMI + 3] & 0xFF;
            final int moduleI = this.frameModules[packedFMI] & 0xFF;
            int x = ((flags & FLAG_FLIP_X) != 0x0) ? (baseX - this.frameModules[packedFMI + 1]) : (baseX + this.frameModules[packedFMI + 1]);
            int y = ((flags & FLAG_FLIP_Y) != 0x0) ? (baseY - this.frameModules[packedFMI + 2]) : (baseY + this.frameModules[packedFMI + 2]);
            if ((flags & FLAG_FLIP_X) != 0x0) {
                // x -= module.width
                x -= (this.modules[moduleI << 1] & 0xFF);
            }
            if ((flags & FLAG_FLIP_Y) != 0x0) {
                // y -= module.height
                y -= (this.modules[(moduleI << 1) + 1] & 0xFF);
            }
            this.drawModule(graphics, moduleI, x, y, flags ^ (fmFlags & 0xF));
        }
    }

    public final void drawModule(final Graphics graphics, final int moduleI, final int x, final int y, final int flags) {
        final int packedModuleI = moduleI << 1;
        final int moduleWidth = this.modules[packedModuleI] & 0xFF;
        final int moduleHeight = this.modules[packedModuleI + 1] & 0xFF;
        if (moduleWidth <= 0 || moduleHeight <= 0) {
            return;
        }

        Image rgbImage = null;
        if (this.images != null && this.images[this.paletteI] != null) {
            rgbImage = this.images[this.paletteI][moduleI];
        }
        if (rgbImage == null) {
            final int[] rgb = this.parseImageData(moduleI);
            if (rgb == null) return;
            rgbImage = Image.createRGBImage(rgb, moduleWidth, moduleHeight, this.hasTransparency);
        }

        final int width = rgbImage.getWidth();
        final int height = rgbImage.getHeight();
        int transform;
        if ((flags & FLAG_FLIP_X) != 0x0) {
            if ((flags & FLAG_FLIP_Y) != 0x0)
                transform = 3;
            else
                transform = 2;
        } else if ((flags & FLAG_FLIP_Y) != 0x0) {
            transform = 1;
        } else {
            transform = 0;
        }
        // https://www.j2megame.org/j2meapi/JSR_118_Mobile_Information_Device_Profile_2_0/javax/microedition/lcdui/Graphics.html#drawRegion(javax.microedition.lcdui.Image,%20int,%20int,%20int,%20int,%20int,%20int,%20int,%20int)
        graphics.drawRegion(rgbImage, 0, 0, width, height, transform, x, y, 0);
    }

    private int[] parseImageData(int moduleI) {
        if (this.moduleData == null || this.moduleDataPointers == null) {
            return null;
        }

        final int packedModuleI = moduleI << 1;
        final int width = this.modules[packedModuleI] & 0xFF;
        final int height = this.modules[packedModuleI + 1] & 0xFF;
        final int[] rgb = f_Sprite.tmp;

        final int[] palette = this.palettes[this.paletteI];
        if (palette == null) return null;

        final byte[] moduleData = this.moduleData;
        int ptr = (this.moduleDataPointers[moduleI] & 0xFFFF); // Introduced a variable from moduleI
        int i = 0;
        final int n5 = width * height;
        if (this.dataFormat == ENCODE_FORMAT_I127RLE) {
            while (i < n5) {
                int n6;
                if ((n6 = (moduleData[ptr++] & 0xFF)) > 127) {
                    final int n7 = palette[moduleData[ptr++] & 0xFF];
                    n6 -= 128;
                    while (n6-- > 0) {
                        rgb[i++] = n7;
                    }
                } else {
                    rgb[i++] = palette[n6];
                }
            }
        } else if (this.dataFormat == ENCODE_FORMAT_I16) {
            while (i < n5) {
                rgb[i++] = palette[moduleData[ptr] >> 4 & 0xF];
                rgb[i++] = palette[moduleData[ptr] & 0xF];
                ++ptr;
            }
        } else if (this.dataFormat == ENCODE_FORMAT_I4) {
            while (i < n5) {
                rgb[i++] = palette[moduleData[ptr] >> 6 & 0x3];
                rgb[i++] = palette[moduleData[ptr] >> 4 & 0x3];
                rgb[i++] = palette[moduleData[ptr] >> 2 & 0x3];
                rgb[i++] = palette[moduleData[ptr] & 0x3];
                ++ptr;
            }
        } else if (this.dataFormat == ENCODE_FORMAT_I2) {
            while (i < n5) {
                rgb[i++] = palette[moduleData[ptr] >> 7 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 6 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 5 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 4 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 3 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 2 & 0x1];
                rgb[i++] = palette[moduleData[ptr] >> 1 & 0x1];
                rgb[i++] = palette[moduleData[ptr] & 0x1];
                ++ptr;
            }
        } else if (this.dataFormat == ENCODE_FORMAT_I256) {
            while (i < n5) {
                rgb[i++] = palette[moduleData[ptr++] & 0xFF];
            }
        } else if (this.dataFormat == ENCODE_FORMAT_I256RLE) {
            while (i < n5) {
                int n8;
                if ((n8 = (moduleData[ptr++] & 0xFF)) > 127) {
                    n8 -= 128;
                    while (n8-- > 0) {
                        rgb[i++] = palette[moduleData[ptr++] & 0xFF];
                    }
                } else {
                    final int n9 = palette[moduleData[ptr++] & 0xFF];
                    while (n8-- > 0) {
                        rgb[i++] = n9;
                    }
                }
            }
        }
        return rgb;
    }

    public final void free(final boolean freeImages) {
        this.modules = null;
        this.frameFrameModuleCounts = null;
        this.frameFirstModuleIndices = null;
        this.frameBBoxes = null;
        this.frameModules = null;
        this.animationAnimationFrameCounts = null;
        this.animationFirstAnimationFrameIndices = null;
        this.animationFrames = null;
        if (this.palettes != null) {
            for (int i = 0; i < this.palettes.length; ++i) {
                this.palettes[i] = null;
            }
            this.palettes = null;
        }
        this.moduleData = null;
        this.moduleDataPointers = null;
        if (freeImages && this.images != null) {
            for (int j = 0; j < this.images.length; ++j) {
                if (this.images[j] != null) {
                    for (int k = 0; k < this.images[j].length; ++k) {
                        this.images[j][k] = null;
                    }
                }
            }
            this.images = null;
        }
    }
}

import javax.microedition.media.Controllable;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.media.Manager;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

// 
// Decompiled by Procyon v0.5.36
// 

public final class j_SoundManager implements Runnable, PlayerListener {
    // ADDED START Sound IDs
    public final static int SOUND_SFX_SWITCH = 0;
    public final static int SOUND_SFX_RIDDLE = 1;
    public final static int SOUND_SFX_DEATH = 2;
    public final static int SOUND_SFX_CHEST_1 = 3;
    public final static int SOUND_SFX_CHEST_2 = 4;
    public final static int SOUND_SFX_HERO_HURT = 5;
    public final static int SOUND_SFX_HAMMER_HIT_UNBREAKABLE = 6;
    public final static int SOUND_SFX_MINE = 7;
    public final static int SOUND_SFX_WORKING = 8;
    public final static int SOUND_SFX_CHECKPOINT = 9;
    public final static int SOUND_SFX_ENEMY_HURT = 10;
    public final static int SOUND_SFX_BREAK = 11;
    public final static int SOUND_SFX_HOOKING = 12;
    public final static int SOUND_SFX_WATER = 13;
    public final static int SOUND_SFX_BOULDER = 14;
    public final static int SOUND_M_LEVEL_CLEAR = 15;
    public final static int SOUND_M_ANGKOR_WAT = 16;
    public final static int SOUND_M_BAVARIA = 17;
    public final static int SOUND_M_SIBERIA = 18;
    public final static int SOUND_M_TITLE = 19;
    public final static int SOUND_M_GAME_OVER = 20;

    // Number of sounds
    final static int TOTAL_SOUNDS = 21;

    // The volume of sounds
    final static int SOUND_VOLUME = 100;
    // ADDED END

    private static int crtSoundID = -1;
    private static int newSoundID = -1;
    private static int crtSoundPriority;
    private static int newSoundPriority;
    private static int previousSoundID = -1;
    private long soundLoopStartTime;
    private static Player[] midiPlayers;
    public static boolean soundEnabled;
    private static boolean stopSoundThreadLoop;
    private static boolean needFreeCrtPlayerResource = false;
    private ByteArrayInputStream midiByteStream;
    private InputStream sndFileStream;
    private byte[] soundFileHeader;
    private Thread soundThread;

    public j_SoundManager() {
        this.soundLoopStartTime = 0L;
    }

    /**
     * Load the specified audio data into the midiPlayers
     *
     * @param soundID The ID of the audio data to be loaded
     */
    public final void loadSound(final int soundID) {
        if (j_SoundManager.midiPlayers == null) {
            j_SoundManager.midiPlayers = new Player[TOTAL_SOUNDS];
        }
        try {
            final byte[] audioFile = new byte[i.unpackUint16(this.soundFileHeader, (soundID << 3) + 4)];
            this.sndFileStream.read(audioFile);
            this.midiByteStream = new ByteArrayInputStream(audioFile);

            j_SoundManager.midiPlayers[soundID] = Manager.createPlayer((InputStream) this.midiByteStream, "audio/midi");
            j_SoundManager.midiPlayers[soundID].addPlayerListener((PlayerListener) this);
            j_SoundManager.midiPlayers[soundID].realize();
            ((VolumeControl) ((Controllable) j_SoundManager.midiPlayers[soundID]).getControl("VolumeControl")).setLevel(SOUND_VOLUME);

            this.midiByteStream.close();
            this.midiByteStream = null;
            System.gc();
        } catch (Exception ex) {
        }
    }

    /**
     * Start the audio playback thread
     */
    public final void startThread() {
        j_SoundManager.stopSoundThreadLoop = false;
        this.soundThread = new Thread(this);
        this.soundThread.setPriority(1);
        this.soundThread.start();
    }

    /**
     * Loads the indices for the MIDI files if they haven't already been loaded.
     */
    public final void loadMidiIndices() {
        if (j_SoundManager.midiPlayers == null) {
            try {
                this.sndFileStream = this.getClass().getResourceAsStream("/snd.f");
                this.sndFileStream.skip(1L); // Ignore file count
                this.soundFileHeader = new byte[TOTAL_SOUNDS << 3]; // Header size (file count << 3 = 168 bytes)
                this.sndFileStream.read(this.soundFileHeader); // Read the header
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public final void cVoid() {
        try {
            j_SoundManager.crtSoundID = -1;
            j_SoundManager.previousSoundID = -1;
            j_SoundManager.crtSoundPriority = 0;
            this.sndFileStream.close();
            this.sndFileStream = null;
            this.soundFileHeader = null;
            System.gc();
        } catch (Exception ex) {
        }
    }

    /**
     * Release player resources and stop the audio playback thread loop
     */
    public final void dVoid() {
        if (j_SoundManager.midiPlayers != null) {
            this.freeCrtPlayerResource();
            int length = j_SoundManager.midiPlayers.length;
            for (int i = 0; i < length; ++i) {
                if (j_SoundManager.midiPlayers[i] != null) {
                    j_SoundManager.midiPlayers[i].close();
                    j_SoundManager.midiPlayers[i] = null;
                }
            }
        }
        j_SoundManager.midiPlayers = null;
        j_SoundManager.stopSoundThreadLoop = true;
    }

    /**
     * Get the playback priority of a specific sound
     *
     * @param soundID The ID of the sound
     */
    private static int getSoundPriority(final int soundID) {
        switch (soundID) {
            case SOUND_SFX_RIDDLE:
            case SOUND_SFX_DEATH:
            case SOUND_SFX_CHEST_2:
            case SOUND_M_LEVEL_CLEAR:
            case SOUND_M_ANGKOR_WAT:
            case SOUND_M_BAVARIA:
            case SOUND_M_SIBERIA:
            case SOUND_M_TITLE:
            case SOUND_M_GAME_OVER:
                return 30;

            case SOUND_SFX_CHEST_1:
            case SOUND_SFX_MINE:
            case SOUND_SFX_WORKING:
            case SOUND_SFX_CHECKPOINT:
            case SOUND_SFX_BREAK:
            case SOUND_SFX_HOOKING:
            case SOUND_SFX_WATER:
                return 20;

            case SOUND_SFX_SWITCH:
            case SOUND_SFX_HERO_HURT:
            case SOUND_SFX_HAMMER_HIT_UNBREAKABLE:
            case SOUND_SFX_ENEMY_HURT:
            case SOUND_SFX_BOULDER:
                return 10;

            default:
                return 0;
        }
    }

    public final synchronized void run() {
        while (!stopSoundThreadLoop) {
            // Waiting for this.notify() call
            try {
                this.wait();
            } catch (Exception ignored) {
            }

            if (needFreeCrtPlayerResource) {
                try {
                    boolean isLongDurationSfx;
                    switch (crtSoundID) {
                        case SOUND_SFX_SWITCH:
                        case SOUND_SFX_HERO_HURT:
                        case SOUND_SFX_HAMMER_HIT_UNBREAKABLE:
                        case SOUND_SFX_MINE:
                        case SOUND_SFX_WORKING:
                        case SOUND_SFX_ENEMY_HURT:
                        case SOUND_SFX_BREAK:
                        case SOUND_SFX_HOOKING:
                        case SOUND_SFX_WATER:
                        case SOUND_SFX_BOULDER: {
                            isLongDurationSfx = false;
                            break;
                        }
                        default: {
                            isLongDurationSfx = true;
                            break;
                        }
                    }

                    if (isLongDurationSfx) {
                        midiPlayers[crtSoundID].deallocate();
                        previousSoundID = -1;
                    }

                    crtSoundID = -1;
                    needFreeCrtPlayerResource = false;
                } catch (Exception ignored) {
                } finally {
                    crtSoundPriority = 0;
                }
            }

            if (newSoundID != -1) {
                try {
                    // If the previous sound is different from the current sound,
                    // release the player resources of the previous sound
                    if (previousSoundID != -1 && newSoundID != previousSoundID) {
                        midiPlayers[previousSoundID].deallocate();
                        previousSoundID = -1;
                    }

                    if (previousSoundID == -1) {
                        midiPlayers[newSoundID].prefetch();
                        previousSoundID = newSoundID;
                    }

                    midiPlayers[newSoundID].start();
                    crtSoundID = newSoundID;
                    crtSoundPriority = newSoundPriority;
                    soundLoopStartTime = System.currentTimeMillis();
                    continue;
                } catch (Exception ex3) {
                    continue;
                } finally {
                    newSoundID = -1;
                }
//                break;
            }
        }
    }

    /**
     * Play specified sound
     *
     * @param soundID The ID of the sound
     * @apiNote It has the same function as freeCrtPlayerResource
     * The specified sound may not be played due to the sound priority,
     * or the interval between the last sound playback is too short
     */
    public final synchronized void playSound(final int soundID) {
        if (j_SoundManager.soundEnabled) {
            if (j_SoundManager.crtSoundID != -1) {
                if (j_SoundManager.crtSoundPriority >= getSoundPriority(soundID) && (j_SoundManager.crtSoundPriority != getSoundPriority(soundID) || Math.abs(System.currentTimeMillis() - this.soundLoopStartTime) <= 50L)) {
                    return;
                }

                j_SoundManager.needFreeCrtPlayerResource = true;
            } else {
                j_SoundManager.crtSoundPriority = 0;
            }

            final int priority = getSoundPriority(soundID);
            if (priority >= j_SoundManager.crtSoundPriority) {
                j_SoundManager.newSoundID = soundID;
                j_SoundManager.newSoundPriority = priority;
                this.notify();
            }
        }
    }

    /**
     * Release the current player resource, reset crtSoundId and crtSoundPriority
     */
    public final synchronized void freeCrtPlayerResource() {
        if (j_SoundManager.crtSoundID != -1) {
            j_SoundManager.needFreeCrtPlayerResource = true;
        }
        this.notify();
    }

    public static synchronized boolean isPlayingSound() {
        return j_SoundManager.crtSoundID != -1;
    }

    /**
     * This method is called to deliver an event to a registered listener when a Player event is observed.
     * @param player The player which generated the event.
     * @param event The event generated as defined by the enumerated types.
     * @param eventData The associated event data.
     */
    public final void playerUpdate(final Player player, final String event, final Object eventData) {
        if (j_SoundManager.midiPlayers != null && j_SoundManager.crtSoundID != -1 && event.equals(END_OF_MEDIA)) { // "endOfMedia"
            this.freeCrtPlayerResource();
        }
    }
}

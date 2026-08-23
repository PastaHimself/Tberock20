/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.SimpleSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.SoundManager
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.AbstractSoundInstanceAccessor
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.audio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.AbstractSoundInstanceAccessor;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSMusic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/handlers/audio/MenuMusicHandler;", "", "<init>", "()V", "currentMusic", "Lnet/minecraft/client/resources/sounds/SimpleSoundInstance;", "cooldown", "", "playingVanilla", "", "newMusic", "replaceMusic", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
public final class MenuMusicHandler {
    @NotNull
    public static final MenuMusicHandler INSTANCE = new MenuMusicHandler();
    @Nullable
    private static SimpleSoundInstance currentMusic;
    private static int cooldown;
    private static boolean playingVanilla;

    private MenuMusicHandler() {
    }

    private final SimpleSoundInstance newMusic() {
        SimpleSoundInstance simpleSoundInstance;
        SimpleSoundInstance it = simpleSoundInstance = TBSMusic.getMENU_MUSIC();
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.client.features.sounds.AbstractSoundInstanceAccessor");
        ((AbstractSoundInstanceAccessor)it).setLooping(true);
        return simpleSoundInstance;
    }

    public final void replaceMusic(@NotNull Minecraft mc) {
        block12: {
            block11: {
                Intrinsics.checkNotNullParameter((Object)mc, (String)"mc");
                if (!TBSConfigs.INSTANCE.getClient().getEnableMenuMusic()) {
                    playingVanilla = true;
                    if (currentMusic != null) {
                        SoundManager soundManager = mc.getSoundManager();
                        SimpleSoundInstance simpleSoundInstance = currentMusic;
                        Intrinsics.checkNotNull((Object)simpleSoundInstance);
                        soundManager.stop((SoundInstance)simpleSoundInstance);
                        currentMusic = null;
                        cooldown = 40;
                    }
                    return;
                }
                if (currentMusic == null) break block11;
                SoundManager soundManager = mc.getSoundManager();
                SimpleSoundInstance simpleSoundInstance = currentMusic;
                Intrinsics.checkNotNull((Object)simpleSoundInstance);
                if (soundManager.isActive((SoundInstance)simpleSoundInstance)) break block12;
            }
            if (mc.level == null) {
                currentMusic = this.newMusic();
                if (playingVanilla) {
                    mc.getSoundManager().stop();
                    playingVanilla = false;
                }
                if (cooldown <= 0) {
                    SoundManager soundManager = mc.getSoundManager();
                    SimpleSoundInstance simpleSoundInstance = currentMusic;
                    Intrinsics.checkNotNull((Object)simpleSoundInstance);
                    soundManager.play((SoundInstance)simpleSoundInstance);
                }
            }
        }
        if (mc.level != null) {
            if (currentMusic != null) {
                SoundManager soundManager = mc.getSoundManager();
                SimpleSoundInstance simpleSoundInstance = currentMusic;
                Intrinsics.checkNotNull((Object)simpleSoundInstance);
                soundManager.stop((SoundInstance)simpleSoundInstance);
                currentMusic = null;
                cooldown = 40;
            }
            return;
        }
        if (cooldown > 0 && TBSConfigs.INSTANCE.getClient().getEnableMenuMusic()) {
            int n = cooldown;
            cooldown = n + -1;
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.replaceMusic(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, MenuMusicHandler::_init_$lambda$0);
        cooldown = 20;
    }
}


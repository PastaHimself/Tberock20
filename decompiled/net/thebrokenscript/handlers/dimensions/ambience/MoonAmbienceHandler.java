/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.dimensions.ambience;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.boss.jimmy.AudioFader;
import net.thebrokenscript.boss.jimmy.Jimbo;
import net.thebrokenscript.boss.jimmy.MoonRiseAmbience;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSSoundCategories;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ambience/MoonAmbienceHandler;", "", "<init>", "()V", "instance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getInstance", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setInstance", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "fader", "Lnet/thebrokenscript/boss/jimmy/AudioFader;", "getFader", "()Lnet/thebrokenscript/boss/jimmy/AudioFader;", "setFader", "(Lnet/thebrokenscript/boss/jimmy/AudioFader;)V", "ambience", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
public final class MoonAmbienceHandler {
    @NotNull
    public static final MoonAmbienceHandler INSTANCE = new MoonAmbienceHandler();
    @Nullable
    private static FancySoundInstance instance;
    @Nullable
    private static AudioFader fader;

    private MoonAmbienceHandler() {
    }

    @Nullable
    public final FancySoundInstance getInstance() {
        return instance;
    }

    public final void setInstance(@Nullable FancySoundInstance fancySoundInstance) {
        instance = fancySoundInstance;
    }

    @Nullable
    public final AudioFader getFader() {
        return fader;
    }

    public final void setFader(@Nullable AudioFader audioFader) {
        fader = audioFader;
    }

    private final void ambience(Minecraft mc) {
        block11: {
            block10: {
                LocalPlayer localPlayer = mc.player;
                if (localPlayer == null) {
                    return;
                }
                LocalPlayer player = localPlayer;
                if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.CORRUPTED_MOON)) {
                    FancySoundInstance fancySoundInstance = instance;
                    if (fancySoundInstance != null) {
                        FancySoundInstance it = fancySoundInstance;
                        boolean bl = false;
                        it.stop();
                        instance = null;
                        fader = null;
                    }
                    return;
                }
                MoonRiseAmbience rise = Jimbo.INSTANCE.getMOONRISE();
                if (rise != null && rise.getStage() > 0) {
                    FancySoundInstance fancySoundInstance = instance;
                    if (fancySoundInstance != null) {
                        fancySoundInstance.stop();
                    }
                    instance = null;
                    fader = null;
                    return;
                }
                if (instance == null) break block10;
                FancySoundInstance fancySoundInstance = instance;
                Intrinsics.checkNotNull((Object)fancySoundInstance);
                if (!fancySoundInstance.isStopped()) break block11;
            }
            FancySoundInstance fancySoundInstance = instance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.PURGATORY_AMBIENCE.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)44, null);
            Intrinsics.checkNotNull((Object)fancySoundInstance);
            fader = new AudioFader(fancySoundInstance);
        }
        SoundManager soundManager = mc.getSoundManager();
        FancySoundInstance fancySoundInstance = instance;
        Intrinsics.checkNotNull((Object)fancySoundInstance);
        if (!soundManager.isActive((SoundInstance)fancySoundInstance)) {
            instance = null;
            fader = null;
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.ambience(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, MoonAmbienceHandler::_init_$lambda$0);
    }
}


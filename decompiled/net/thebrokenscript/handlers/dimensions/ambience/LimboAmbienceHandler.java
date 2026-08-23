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
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ambience/LimboAmbienceHandler;", "", "<init>", "()V", "instance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getInstance", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setInstance", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "ambience", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
public final class LimboAmbienceHandler {
    @NotNull
    public static final LimboAmbienceHandler INSTANCE = new LimboAmbienceHandler();
    @Nullable
    private static FancySoundInstance instance;

    private LimboAmbienceHandler() {
    }

    @Nullable
    public final FancySoundInstance getInstance() {
        return instance;
    }

    public final void setInstance(@Nullable FancySoundInstance fancySoundInstance) {
        instance = fancySoundInstance;
    }

    private final void ambience(Minecraft mc) {
        block9: {
            block8: {
                LocalPlayer localPlayer = mc.player;
                if (localPlayer == null) {
                    return;
                }
                LocalPlayer player = localPlayer;
                if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.LIMBO)) {
                    FancySoundInstance fancySoundInstance = instance;
                    if (!(fancySoundInstance != null ? fancySoundInstance.isStopped() : false)) {
                        FancySoundInstance fancySoundInstance2 = instance;
                        if (fancySoundInstance2 != null) {
                            fancySoundInstance2.stop();
                        }
                    }
                    return;
                }
                if (instance == null) break block8;
                FancySoundInstance fancySoundInstance = instance;
                Intrinsics.checkNotNull((Object)fancySoundInstance);
                if (!fancySoundInstance.isStopped()) break block9;
            }
            instance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.LIMBO.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.5f, (float)0.0f, (boolean)true, null, (int)40, null);
        }
        SoundManager soundManager = mc.getSoundManager();
        FancySoundInstance fancySoundInstance = instance;
        Intrinsics.checkNotNull((Object)fancySoundInstance);
        if (!soundManager.isActive((SoundInstance)fancySoundInstance)) {
            instance = null;
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.ambience(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, LimboAmbienceHandler::_init_$lambda$0);
    }
}


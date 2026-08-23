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
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ambience/StairsAmbienceHandler;", "", "<init>", "()V", "stairsInstance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getStairsInstance", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setStairsInstance", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "tunnelInstance", "getTunnelInstance", "setTunnelInstance", "ambience", "", "mc", "Lnet/minecraft/client/Minecraft;", "ambienceChanger", "thebrokenscript-common"})
public final class StairsAmbienceHandler {
    @NotNull
    public static final StairsAmbienceHandler INSTANCE = new StairsAmbienceHandler();
    @Nullable
    private static FancySoundInstance stairsInstance;
    @Nullable
    private static FancySoundInstance tunnelInstance;

    private StairsAmbienceHandler() {
    }

    @Nullable
    public final FancySoundInstance getStairsInstance() {
        return stairsInstance;
    }

    public final void setStairsInstance(@Nullable FancySoundInstance fancySoundInstance) {
        stairsInstance = fancySoundInstance;
    }

    @Nullable
    public final FancySoundInstance getTunnelInstance() {
        return tunnelInstance;
    }

    public final void setTunnelInstance(@Nullable FancySoundInstance fancySoundInstance) {
        tunnelInstance = fancySoundInstance;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void ambience(Minecraft mc) {
        block5: {
            block7: {
                block6: {
                    LocalPlayer localPlayer = mc.player;
                    if (localPlayer == null) {
                        return;
                    }
                    LocalPlayer player = localPlayer;
                    if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.PROTECTED_VOID)) {
                        return;
                    }
                    if (!(player.getY() < 102.0) || !(player.getY() > 50.0)) break block5;
                    if (stairsInstance == null) break block6;
                    SoundManager soundManager = mc.getSoundManager();
                    FancySoundInstance fancySoundInstance = stairsInstance;
                    Intrinsics.checkNotNull((Object)fancySoundInstance);
                    if (soundManager.isActive((SoundInstance)fancySoundInstance)) break block7;
                }
                stairsInstance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.INF_STAIRS.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)44, null);
                return;
            }
            FancySoundInstance fancySoundInstance = stairsInstance;
            if (!Intrinsics.areEqual((Float)(fancySoundInstance != null ? Float.valueOf(fancySoundInstance.getSoundVolume()) : null), (float)0.0f)) return;
            FancySoundInstance fancySoundInstance2 = stairsInstance;
            Intrinsics.checkNotNull((Object)fancySoundInstance2);
            fancySoundInstance2.setVolume(1.0f);
            return;
        }
        FancySoundInstance fancySoundInstance = stairsInstance;
        if (!Intrinsics.areEqual((Float)(fancySoundInstance != null ? Float.valueOf(fancySoundInstance.getSoundVolume()) : null), (float)1.0f)) return;
        FancySoundInstance fancySoundInstance3 = stairsInstance;
        Intrinsics.checkNotNull((Object)fancySoundInstance3);
        fancySoundInstance3.setVolume(0.0f);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void ambienceChanger(Minecraft mc) {
        block5: {
            block7: {
                block6: {
                    LocalPlayer localPlayer = mc.player;
                    if (localPlayer == null) {
                        return;
                    }
                    LocalPlayer player = localPlayer;
                    if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.PROTECTED_VOID)) {
                        return;
                    }
                    if (!(player.getY() >= 102.0)) break block5;
                    if (tunnelInstance == null) break block6;
                    SoundManager soundManager = mc.getSoundManager();
                    FancySoundInstance fancySoundInstance = tunnelInstance;
                    Intrinsics.checkNotNull((Object)fancySoundInstance);
                    if (soundManager.isActive((SoundInstance)fancySoundInstance)) break block7;
                }
                tunnelInstance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.FLESH_TUNNEL_AMBIENCE.invoke()), (SoundSource)SoundSource.AMBIENT, (float)0.0f, (float)0.0f, (boolean)true, null, (int)44, null);
                return;
            }
            FancySoundInstance fancySoundInstance = tunnelInstance;
            if (!Intrinsics.areEqual((Float)(fancySoundInstance != null ? Float.valueOf(fancySoundInstance.getSoundVolume()) : null), (float)0.0f)) return;
            FancySoundInstance fancySoundInstance2 = tunnelInstance;
            Intrinsics.checkNotNull((Object)fancySoundInstance2);
            fancySoundInstance2.setVolume(1.0f);
            return;
        }
        FancySoundInstance fancySoundInstance = tunnelInstance;
        if (!Intrinsics.areEqual((Float)(fancySoundInstance != null ? Float.valueOf(fancySoundInstance.getSoundVolume()) : null), (float)1.0f)) return;
        FancySoundInstance fancySoundInstance3 = tunnelInstance;
        Intrinsics.checkNotNull((Object)fancySoundInstance3);
        fancySoundInstance3.setVolume(0.0f);
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.ambience(ClientDSLKt.getMC());
        INSTANCE.ambienceChanger(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, StairsAmbienceHandler::_init_$lambda$0);
    }
}


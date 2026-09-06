/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.thebrokenscript.brokencore.api.network.ActionPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network.music;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.boss.integrity.IntegrityBossTracks;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.registry.TBSSoundCategories;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/network/music/Phase3MusicPacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
public final class Phase3MusicPacket
extends ActionPacket<Phase3MusicPacket> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("integrity_phase3_music");

    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(Phase3MusicPacket::handle$lambda$0);
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    private static final void handle$lambda$0() {
        FancyAudio.INSTANCE.stop((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_INTRO().get());
        FancyAudio.INSTANCE.stop((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_PART_1().get());
        FancyAudio.INSTANCE.stop((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_PART_1_BRIDGE().get());
        FancyAudio.INSTANCE.stop((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_PART_2().get());
        FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_PART_2_BRIDGE().get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)false, null, (int)60, null).getOnEnded().add(Phase3MusicPacket::handle$lambda$0$0);
    }

    private static final Unit handle$lambda$0$0(FancySoundInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)IntegrityBossTracks.INSTANCE.getTRACK_PART_3().get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)44, null);
        return Unit.INSTANCE;
    }
}


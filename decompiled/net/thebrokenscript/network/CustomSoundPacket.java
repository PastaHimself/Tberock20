/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.boss.kerfur.CustomMusicPayload;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/CustomSoundPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/boss/kerfur/CustomMusicPayload;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class CustomSoundPacket
extends EndecPacket<CustomSoundPacket, CustomMusicPayload> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("custom_sound");

    public CustomSoundPacket() {
        super(CustomMusicPayload.Companion.getENDEC());
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull CustomMusicPayload data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            cx.getEnqueueWork().invoke(() -> CustomSoundPacket.handle$lambda$0(data));
        }
    }

    private static final void handle$lambda$0(CustomMusicPayload $data) {
        FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)$data.getSound(), null, (float)$data.getVolume(), (float)$data.getPitch(), (boolean)$data.getLoops(), null, (int)34, null).setGain($data.getGain());
    }
}


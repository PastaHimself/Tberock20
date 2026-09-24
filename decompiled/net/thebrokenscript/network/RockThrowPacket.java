/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.ext.JomlVecExtKt
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 */
package net.thebrokenscript.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.attacks.MoonRockTossAttack;
import net.thebrokenscript.network.FracturedEndecData;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/RockThrowPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/network/FracturedEndecData;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class RockThrowPacket
extends EndecPacket<RockThrowPacket, FracturedEndecData> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("rock_throw");

    public RockThrowPacket() {
        super(FracturedEndecData.Companion.getENDEC());
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull FracturedEndecData data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> RockThrowPacket.handle$lambda$0(cx, data));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx, FracturedEndecData $data) {
        Player player = $cx.getPlayer();
        if (player == null || (player = player.level()) == null) {
            return;
        }
        Player level = player;
        Entity entity = level.getEntity($data.getFractured());
        FracturedEntity fracturedEntity = entity instanceof FracturedEntity ? (FracturedEntity)entity : null;
        if (fracturedEntity == null) {
            return;
        }
        FracturedEntity ent = fracturedEntity;
        MoonRockTossAttack.Companion.throwRock(ent, JomlVecExtKt.toVec3((Vector3d)$data.getStartPos()));
    }
}


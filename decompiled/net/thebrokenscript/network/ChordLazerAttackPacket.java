/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.entity.boss.ChordEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/ChordLazerAttackPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class ChordLazerAttackPacket
extends EndecPacket<ChordLazerAttackPacket, Integer> {
    @NotNull
    private final ResourceLocation id;

    public ChordLazerAttackPacket() {
        Endec endec2 = Endec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"INT");
        super(endec2);
        this.id = TBSConstants.id("chord_lazer_attack");
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(int data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isServerbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> ChordLazerAttackPacket.handle$lambda$0(cx, data));
    }

    private static final void handle$lambda$0(PacketHandlerContext $cx, int $data) {
        Player player = $cx.getPlayer();
        if (player == null || (player = player.level()) == null) {
            return;
        }
        Player level = player;
        Entity entity = level.getEntity($data);
        ChordEntity chordEntity = entity instanceof ChordEntity ? (ChordEntity)entity : null;
        if (chordEntity == null) {
            return;
        }
        ChordEntity entity2 = chordEntity;
        if (entity2.getTarget() == null) {
            return;
        }
        LivingEntity livingEntity = entity2.getTarget();
        Intrinsics.checkNotNull((Object)livingEntity);
        entity2.performRangedAttack(livingEntity, 1.0f);
    }
}


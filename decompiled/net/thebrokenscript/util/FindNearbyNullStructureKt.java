/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.thebrokenscript.block.entity.NullStructureBlockEntity;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u0001\u00a8\u0006\f"}, d2={"findNearbyNullStructure", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "radius", "", "structureId", "", "onlyOncePerPlayer", "onlyOncePerWorld", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nfindNearbyNullStructure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findNearbyNullStructure.kt\nnet/thebrokenscript/util/FindNearbyNullStructureKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,39:1\n295#2,2:40\n*S KotlinDebug\n*F\n+ 1 findNearbyNullStructure.kt\nnet/thebrokenscript/util/FindNearbyNullStructureKt\n*L\n20#1:40,2\n*E\n"})
public final class FindNearbyNullStructureKt {
    public static final boolean findNearbyNullStructure(@NotNull ServerLevel level, @NotNull ServerPlayer player, int radius, @NotNull String structureId, boolean onlyOncePerPlayer, boolean onlyOncePerWorld) {
        BlockPos foundPos;
        Object v1;
        block9: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
            BlockPos senderPos = player.blockPosition();
            Iterable iterable = BlockPos.betweenClosed((BlockPos)senderPos.offset(-radius, -radius, -radius), (BlockPos)senderPos.offset(radius, radius, radius));
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"betweenClosed(...)");
            Iterable $this$firstOrNull$iv = iterable;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                BlockPos it = (BlockPos)element$iv;
                boolean bl = false;
                if (!(senderPos.distSqr((Vec3i)it) <= (double)(radius * radius) && level.getBlockState(it).is((Holder)TBSBlocks.NULL_STRUCTURE))) continue;
                v1 = element$iv;
                break block9;
            }
            v1 = null;
        }
        BlockPos blockPos = v1;
        Object object = foundPos = blockPos != null ? blockPos.immutable() : null;
        if (foundPos != null) {
            BlockEntity blockEntity = level.getBlockEntity(foundPos);
            NullStructureBlockEntity nullStructureBlockEntity = blockEntity instanceof NullStructureBlockEntity ? (NullStructureBlockEntity)blockEntity : null;
            if (nullStructureBlockEntity == null) {
                return false;
            }
            NullStructureBlockEntity blockEntity2 = nullStructureBlockEntity;
            if (((CharSequence)structureId).length() > 0 && !Intrinsics.areEqual((Object)blockEntity2.getStructureId(), (Object)structureId)) {
                return false;
            }
            if (onlyOncePerWorld) {
                if (blockEntity2.getTriggered()) {
                    return false;
                }
                blockEntity2.setTriggered(true);
                blockEntity2.setChanged();
            } else if (onlyOncePerPlayer) {
                if (blockEntity2.getPlayers().contains(player.getUUID())) {
                    return false;
                }
                UUID uUID = player.getUUID();
                Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
                blockEntity2.addPlayer(uUID);
                blockEntity2.setChanged();
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean findNearbyNullStructure$default(ServerLevel serverLevel, ServerPlayer serverPlayer, int n, String string, boolean bl, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 15;
        }
        if ((n2 & 8) != 0) {
            string = "";
        }
        if ((n2 & 0x10) != 0) {
            bl = false;
        }
        if ((n2 & 0x20) != 0) {
            bl2 = false;
        }
        return FindNearbyNullStructureKt.findNearbyNullStructure(serverLevel, serverPlayer, n, string, bl, bl2);
    }
}


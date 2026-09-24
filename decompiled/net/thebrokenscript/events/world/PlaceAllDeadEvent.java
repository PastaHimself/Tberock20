/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.block.AllDeadBlock;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.util.InteractionTracker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/world/PlaceAllDeadEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlaceAllDeadEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaceAllDeadEvent.kt\nnet/thebrokenscript/events/world/PlaceAllDeadEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1563#2:32\n1634#2,3:33\n295#2,2:36\n*S KotlinDebug\n*F\n+ 1 PlaceAllDeadEvent.kt\nnet/thebrokenscript/events/world/PlaceAllDeadEvent\n*L\n24#1:32\n24#1:33,3\n24#1:36,2\n*E\n"})
public final class PlaceAllDeadEvent
extends TBSEvent {
    public PlaceAllDeadEvent() {
        super(1);
    }

    /*
     * WARNING - void declaration
     */
    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        BlockPos blockPos;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vec3 vec3 = PlayerExt.INSTANCE.getInteractionTracker((Player)player).calculateAverageCenter(InteractionTracker.CenterType.BOTH, level);
        Object object = blockPos = vec3 != null ? PositionUtil.getBlockPos((Position)((Position)vec3)) : null;
        if (blockPos != null) {
            if (level.getBlockEntity(blockPos) == null) {
                v2 = level.setBlock(blockPos, ((AllDeadBlock)((Object)TBSBlocks.ALL_DEAD.get())).defaultBlockState(), 3);
            } else {
                Object v3;
                block6: {
                    void $this$mapTo$iv$iv;
                    Iterable $this$map$iv = (Iterable)EntriesMappings.entries$0;
                    boolean $i$f$map = false;
                    Iterable iterable = $this$map$iv;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        Direction direction = (Direction)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        boolean bl = false;
                        collection.add(blockPos.relative((Direction)it));
                    }
                    Iterable $this$firstOrNull$iv = (List)destination$iv$iv;
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        BlockPos it = (BlockPos)element$iv;
                        boolean bl = false;
                        if (!(level.getBlockEntity(it) == null)) continue;
                        v3 = element$iv;
                        break block6;
                    }
                    v3 = null;
                }
                BlockPos blockPos2 = v3;
                if (blockPos2 == null) {
                    return;
                }
                BlockPos blockPosNoEntity = blockPos2;
                v2 = level.setBlock(blockPosNoEntity, ((AllDeadBlock)((Object)TBSBlocks.ALL_DEAD.get())).defaultBlockState(), 3);
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }
}


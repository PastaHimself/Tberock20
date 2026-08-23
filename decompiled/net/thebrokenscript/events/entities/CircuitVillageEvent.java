/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.GoalSelector
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.npc.Villager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.entities;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.data.CircuitInhabited;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.util.CustomGoals;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/entities/CircuitVillageEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class CircuitVillageEvent
extends NullEvent {
    public CircuitVillageEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (level.isVillage(BlockPos.containing((Position)((Position)pos)))) {
            RandomSource random = level.random;
            int x = 0;
            int z = 0;
            boolean negativeX = random.nextBoolean();
            boolean negativeZ = random.nextBoolean();
            x = negativeX ? random.nextInt(15, 31) * -1 : random.nextInt(15, 31);
            z = negativeZ ? random.nextInt(15, 31) * -1 : random.nextInt(15, 31);
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos blockPos = player.blockPosition().offset(x, 0, z);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            BlockPos newPos = PositionUtil.withY((BlockPos)blockPos, (Number)y);
            if (level.getBlockState(newPos).isAir() && level.getBlockState(newPos.above()).isAir()) {
                if ((double)random.nextFloat() >= 0.3) {
                    EntityType entityType = EntityType.VILLAGER;
                    Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"VILLAGER");
                    Villager villager = (Villager)EntityTypeExt.trySummonTyped((EntityType)entityType, (LevelAccessor)((LevelAccessor)level), (BlockPos)newPos);
                    if (villager != null && (villager = (Villager)EntityUtil.applyRandomRotation((Entity)((Entity)villager))) != null) {
                        Villager villager2;
                        Villager it = villager2 = villager;
                        boolean bl = false;
                        it.setCustomName((Component)TBSLang.INSTANCE.getVILLAGER_NICK());
                        GoalSelector goalSelector = it.goalSelector;
                        GoalSelector targetSelector = it.targetSelector;
                        goalSelector.getAvailableGoals().clear();
                        targetSelector.getAvailableGoals().clear();
                        goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)it));
                        goalSelector.addGoal(1, (Goal)new CustomGoals.CircuitSpawnGoal((Mob)it));
                        goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)it, 0.6));
                        goalSelector.addGoal(4, (Goal)new LookAtPlayerGoal((Mob)it, Player.class, 32.0f, 100.0f));
                        EntityUtil.updateData((Entity)((Entity)villager2), TBSDataAttachments.CIRCUIT_INHABITED, CircuitVillageEvent::execute$lambda$1);
                    }
                } else {
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT_STALK.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)newPos));
                }
            }
        }
    }

    private static final Unit execute$lambda$1(CircuitInhabited it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.setInhabited(true);
        return Unit.INSTANCE;
    }
}


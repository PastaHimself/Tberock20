/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt;
import net.thebrokenscript.entity.tbe.TheBrokenEndCuriousEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.util.StructureUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/events/entities/TbeCuriousEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
public final class TbeCuriousEvent
extends NullEvent {
    public TbeCuriousEvent() {
        super(1);
    }

    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return super.canExecute(level, player, pos) && LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonStage() != 2 && EntityLookupExtImplKt.get((LevelEntityGetterAdapter)EntityFinder.getEntities((ServerLevel)level), TheBrokenEndCuriousEntity.class).isEmpty() && level.random.nextBoolean();
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        int playerSurfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, player.getBlockX(), player.getBlockZ());
        if (BaseMonsterExtKt.isInCave((LivingEntity)((LivingEntity)player)) || player.getY() < (double)(playerSurfaceY - 1)) {
            return;
        }
        BlockPos spawnPos = StructureUtil.getRandomPlacementPosition$default(StructureUtil.INSTANCE, (Level)level, pos.x, pos.z, 75.0, 110.0, false, 32, null);
        int surfaceY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPos.getX(), spawnPos.getZ());
        spawnPos = PositionUtil.withY((BlockPos)spawnPos, (Number)surfaceY);
        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.THE_BROKEN_END_CURIOUS.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)spawnPos));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.EntityCollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.client.TBSClient;
import net.thebrokenscript.config.TBSConfigs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/block/JimTriggerBlock;", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "propagatesSkylightDown", "", "thebrokenscript-common"})
public final class JimTriggerBlock
extends Block {
    public JimTriggerBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return TBSConfigs.INSTANCE.getServer().getDanger().getShowTriggerBlocks() ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Entity ent;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (TBSClient.INSTANCE.getLoaded() && TBSConfigs.INSTANCE.getServer().getDanger().getShowTriggerBlocks()) {
            VoxelShape voxelShape = Shapes.empty();
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"empty(...)");
            return voxelShape;
        }
        if (context instanceof EntityCollisionContext && (ent = ((EntityCollisionContext)context).getEntity()) instanceof Player && PlayerUtil.getGameMode((Player)((Player)ent)) == GameType.CREATIVE) {
            VoxelShape voxelShape = Shapes.block();
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"block(...)");
            return voxelShape;
        }
        VoxelShape voxelShape = Shapes.empty();
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"empty(...)");
        return voxelShape;
    }

    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return true;
    }
}


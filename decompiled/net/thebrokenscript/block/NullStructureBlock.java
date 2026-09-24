/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.network.chat.Component
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
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

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.block.entity.NullStructureBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0014J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J.\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0016\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/block/NullStructureBlock;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/EntityBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "newBlockEntity", "Lnet/thebrokenscript/block/entity/NullStructureBlockEntity;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "Lnet/minecraft/world/level/BlockGetter;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "animateTick", "", "Lnet/minecraft/world/level/Level;", "random", "Lnet/minecraft/util/RandomSource;", "appendHoverText", "stack", "Lnet/minecraft/world/item/ItemStack;", "Lnet/minecraft/world/item/Item$TooltipContext;", "tooltipComponents", "", "Lnet/minecraft/network/chat/Component;", "tooltipFlag", "Lnet/minecraft/world/item/TooltipFlag;", "thebrokenscript-common"})
public final class NullStructureBlock
extends Block
implements EntityBlock {
    public NullStructureBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    public NullStructureBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (NullStructureBlockEntity)TBSBlockEntities.NULL_STRUCTURE.create(pos, state);
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.INVISIBLE;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Entity ent;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (context instanceof EntityCollisionContext && (ent = ((EntityCollisionContext)context).getEntity()) instanceof Player && PlayerUtil.getGameMode((Player)((Player)ent)) == GameType.CREATIVE && ((Player)ent).isHolding(NullStructureBlock::getShape$lambda$0)) {
            VoxelShape voxelShape = Shapes.block();
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"block(...)");
            return voxelShape;
        }
        VoxelShape voxelShape = Shapes.empty();
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"empty(...)");
        return voxelShape;
    }

    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer localPlayer = mc.player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer player = localPlayer;
        if (PlayerUtil.getGameMode((Player)((Player)player)) == GameType.CREATIVE && player.isHolding(NullStructureBlock::animateTick$lambda$0)) {
            level.addParticle((ParticleOptions)TBSParticleTypes.NULL_STRUCTURE_PARTICLE.get(), (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }
    }

    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(tooltipComponents, (String)"tooltipComponents");
        Intrinsics.checkNotNullParameter((Object)tooltipFlag, (String)"tooltipFlag");
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add((Component)TBSLang.INSTANCE.getTBS_STRUCTURE_TOOLTIP());
    }

    private static final boolean getShape$lambda$0(ItemStack it) {
        return it.is(((NullStructureBlock)((Object)TBSBlocks.NULL_STRUCTURE.get())).asItem());
    }

    private static final boolean animateTick$lambda$0(ItemStack it) {
        return it.is(((NullStructureBlock)((Object)TBSBlocks.NULL_STRUCTURE.get())).asItem());
    }
}


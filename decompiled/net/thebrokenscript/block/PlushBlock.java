/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block;

import com.mojang.serialization.MapCodec;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.block.entity.PlushBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.registry.TBSPlushies;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J(\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0014J(\u0010$\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0014J\u001c\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00140(H\u0014J\u0012\u0010*\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020+H\u0016J8\u0010,\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u000200H\u0014J0\u00101\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0014J\u0018\u00103\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0014R\u0016\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00000\u0000 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Lnet/thebrokenscript/block/PlushBlock;", "Lnet/minecraft/world/level/block/HorizontalDirectionalBlock;", "Lnet/minecraft/world/level/block/EntityBlock;", "entity", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lnet/thebrokenscript/block/entity/PlushBlockEntity;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "sound", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/sounds/SoundEvent;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "kotlin.jvm.PlatformType", "newBlockEntity", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "useWithoutItem", "Lnet/minecraft/world/InteractionResult;", "level", "Lnet/minecraft/world/level/Level;", "player", "Lnet/minecraft/world/entity/player/Player;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/world/level/BlockGetter;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "getCollisionShape", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/Block;", "getStateForPlacement", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "neighborChanged", "neighborBlock", "neighborPos", "movedByPiston", "", "onPlace", "oldState", "updateMergeState", "thebrokenscript-common"})
public final class PlushBlock
extends HorizontalDirectionalBlock
implements EntityBlock {
    @NotNull
    private final BlockEntityEntry<? extends PlushBlockEntity> entity;
    @Nullable
    private final RegistryEntry<SoundEvent, SoundEvent> sound;
    private final MapCodec<PlushBlock> codec;

    public PlushBlock(@NotNull BlockEntityEntry<? extends PlushBlockEntity> entity, @NotNull BlockBehaviour.Properties properties, @Nullable RegistryEntry<SoundEvent, SoundEvent> sound) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.entity = entity;
        this.sound = sound;
        this.codec = HorizontalDirectionalBlock.simpleCodec(arg_0 -> PlushBlock.codec$lambda$0(this, arg_0));
    }

    @NotNull
    public PlushBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (PlushBlockEntity)this.entity.create(pos, state);
    }

    @NotNull
    protected InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
        if (level instanceof ServerLevel) {
            BlockEntity blockEntity = ((ServerLevel)level).getBlockEntity(pos);
            Intrinsics.checkNotNull((Object)blockEntity, (String)"null cannot be cast to non-null type net.thebrokenscript.block.entity.PlushBlockEntity");
            PlushBlockEntity ent = (PlushBlockEntity)blockEntity;
            ent.stopTriggeredAnim("squish", "squish");
            ent.triggerAnim("squish", "squish");
            player.swing(InteractionHand.MAIN_HAND, true);
            if (Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.SHADOW.getBlock().get())) {
                Vec3 vec3 = pos.getCenter();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
                Set set = BuiltInRegistries.SOUND_EVENT.entrySet();
                Intrinsics.checkNotNullExpressionValue((Object)set, (String)"entrySet(...)");
                Object v = ((Map.Entry)CollectionsKt.random((Collection)set, (Random)((Random)Random.Default))).getValue();
                Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
                SoundUtil.tryPlaySound$default((Level)level, (Vec3)vec3, (SoundEvent)((SoundEvent)v), (float)1.0f, (float)Math.max((float)Math.random() * 1.5f, 0.005f), null, (int)16, null);
            } else if (Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.TEKKIT.getBlock().get())) {
                Vec3 vec3 = pos.getCenter();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
                SoundUtil.tryPlaySound$default((Level)level, (Vec3)vec3, (SoundEvent)((SoundEvent)TBSSounds.TEKKIT_GUN_SFX.invoke()), (float)0.0f, (float)0.0f, null, (int)28, null);
            } else {
                RegistryEntry<SoundEvent, SoundEvent> registryEntry = this.sound;
                if (registryEntry != null) {
                    RegistryEntry<SoundEvent, SoundEvent> it = registryEntry;
                    boolean bl = false;
                    Vec3 vec3 = pos.getCenter();
                    Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
                    SoundUtil.tryPlaySound$default((Level)level, (Vec3)vec3, (SoundEvent)((SoundEvent)it.get()), (float)0.0f, (float)0.0f, null, (int)28, null);
                }
            }
        }
        InteractionResult interactionResult = super.useWithoutItem(state, level, pos, player, hitResult);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResult, (String)"useWithoutItem(...)");
        return interactionResult;
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        VoxelShape voxelShape = Shapes.box((double)0.25, (double)0.0, (double)0.25, (double)0.75, (double)0.625, (double)0.75);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        return voxelShape;
    }

    @NotNull
    protected VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        VoxelShape voxelShape = Shapes.empty();
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"empty(...)");
        return voxelShape;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        Property[] propertyArray = new Property[]{HorizontalDirectionalBlock.FACING};
        builder.add(propertyArray);
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return (BlockState)this.defaultBlockState().setValue((Property)HorizontalDirectionalBlock.FACING, (Comparable)context.getHorizontalDirection().getOpposite());
    }

    protected void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborBlock, (String)"neighborBlock");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        if (level instanceof ServerLevel) {
            if (!Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.TEKKIT.getBlock().get()) && !Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.HERMIT.getBlock().get())) {
                return;
            }
            this.updateMergeState(pos, level);
        }
    }

    protected void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)oldState, (String)"oldState");
        if (level instanceof ServerLevel) {
            if (!Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.TEKKIT.getBlock().get()) && !Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSPlushies.HERMIT.getBlock().get())) {
                return;
            }
            this.updateMergeState(pos, level);
        }
    }

    private final void updateMergeState(BlockPos pos, Level level) {
        String string;
        PlushBlock plushBlock;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        Intrinsics.checkNotNull((Object)blockEntity, (String)"null cannot be cast to non-null type net.thebrokenscript.block.entity.PlushBlockEntity");
        PlushBlockEntity ent = (PlushBlockEntity)blockEntity;
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        if (Intrinsics.areEqual((Object)block, (Object)TBSPlushies.TEKKIT.getBlock().get())) {
            plushBlock = (PlushBlock)((Object)TBSPlushies.HERMIT.getBlock().get());
        } else if (Intrinsics.areEqual((Object)block, (Object)TBSPlushies.HERMIT.getBlock().get())) {
            plushBlock = (PlushBlock)((Object)TBSPlushies.TEKKIT.getBlock().get());
        } else {
            return;
        }
        PlushBlock partner = plushBlock;
        Direction facing = (Direction)state.getValue((Property)BlockStateProperties.HORIZONTAL_FACING);
        BlockPos leftPos = pos.relative(facing.getCounterClockWise());
        BlockPos rightPos = pos.relative(facing.getClockWise());
        BlockState blockState = level.getBlockState(leftPos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        if (PlushBlock.updateMergeState$isValidPartner(partner, facing, blockState)) {
            string = "left";
        } else {
            BlockState blockState2 = level.getBlockState(rightPos);
            Intrinsics.checkNotNullExpressionValue((Object)blockState2, (String)"getBlockState(...)");
            string = PlushBlock.updateMergeState$isValidPartner(partner, facing, blockState2) ? "right" : null;
        }
        String desiredSide = string;
        String currentSide = ent.getMergedSide();
        if (Intrinsics.areEqual((Object)currentSide, (Object)desiredSide)) {
            return;
        }
        if (currentSide != null) {
            ent.stopTriggeredAnim(currentSide + "start", currentSide + "start");
            ent.triggerAnim(currentSide + "finish", currentSide + "finish");
            ent.setMergedSide(null);
            ent.setChanged();
        }
        if (desiredSide != null) {
            ent.stopTriggeredAnim(desiredSide + "finish", desiredSide + "finish");
            ent.triggerAnim(desiredSide + "start", desiredSide + "start");
            ent.setMergedSide(desiredSide);
            ent.setChanged();
        }
    }

    @NotNull
    protected MapCodec<PlushBlock> codec() {
        MapCodec<PlushBlock> mapCodec = this.codec;
        Intrinsics.checkNotNullExpressionValue(mapCodec, (String)"codec");
        return mapCodec;
    }

    private static final PlushBlock codec$lambda$0(PlushBlock this$0, BlockBehaviour.Properties it) {
        BlockEntityEntry<? extends PlushBlockEntity> blockEntityEntry = this$0.entity;
        Intrinsics.checkNotNull((Object)it);
        return new PlushBlock(blockEntityEntry, it, this$0.sound);
    }

    private static final boolean updateMergeState$isValidPartner(PlushBlock partner, Direction facing, BlockState neighborState) {
        if (!neighborState.hasProperty((Property)BlockStateProperties.HORIZONTAL_FACING)) {
            return false;
        }
        return Intrinsics.areEqual((Object)neighborState.getBlock(), (Object)((Object)partner)) && neighborState.getValue((Property)BlockStateProperties.HORIZONTAL_FACING) == facing;
    }
}


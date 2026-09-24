/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.EntityCollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block.portal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.block.portal.PortalControllerBlockEntity;
import net.thebrokenscript.block.portal.PortalExtenderBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J8\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J0\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001aH\u0014J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fH\u0014J(\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020#2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0014\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/block/portal/PortalExtenderBlock;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/EntityBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "newBlockEntity", "Lnet/thebrokenscript/block/portal/PortalExtenderBlockEntity;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "useWithoutItem", "Lnet/minecraft/world/InteractionResult;", "level", "Lnet/minecraft/world/level/Level;", "player", "Lnet/minecraft/world/entity/player/Player;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "neighborChanged", "", "neighborBlock", "neighborPos", "movedByPiston", "", "onPlace", "oldState", "moving", "updateParent", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/world/level/BlockGetter;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPortalExtenderBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PortalExtenderBlock.kt\nnet/thebrokenscript/block/portal/PortalExtenderBlock\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n15#2:107\n1#3:108\n*S KotlinDebug\n*F\n+ 1 PortalExtenderBlock.kt\nnet/thebrokenscript/block/portal/PortalExtenderBlock\n*L\n37#1:107\n*E\n"})
public final class PortalExtenderBlock
extends Block
implements EntityBlock {
    public PortalExtenderBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    public PortalExtenderBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (PortalExtenderBlockEntity)TBSBlockEntities.PORTAL_EXTENDER.create(pos, state);
    }

    @NotNull
    protected InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
        if (level.isClientSide || PlatformUtil.Companion.isProduction()) {
            return InteractionResult.PASS;
        }
        BlockEntity blockEntity = level.getBlockEntity(pos);
        PortalExtenderBlockEntity portalExtenderBlockEntity = blockEntity instanceof PortalExtenderBlockEntity ? (PortalExtenderBlockEntity)blockEntity : null;
        if (portalExtenderBlockEntity == null) {
            return InteractionResult.PASS;
        }
        PortalExtenderBlockEntity ent = portalExtenderBlockEntity;
        Object object = ent.getParent();
        if (object == null || (object = object.offset((Vec3i)pos)) == null || (object = object.toShortString()) == null) {
            object = "Unknown";
        }
        Object parent = object;
        String $this$c$iv = "Parent pos: " + (String)parent;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        player.sendSystemMessage(component);
        return InteractionResult.PASS;
    }

    protected void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborBlock, (String)"neighborBlock");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        this.updateParent(level, pos);
    }

    protected void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean moving) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)oldState, (String)"oldState");
        super.onPlace(state, level, pos, oldState, moving);
        this.updateParent(level, pos);
    }

    private final void updateParent(Level level, BlockPos pos) {
        block9: {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            PortalExtenderBlockEntity portalExtenderBlockEntity = blockEntity instanceof PortalExtenderBlockEntity ? (PortalExtenderBlockEntity)blockEntity : null;
            if (portalExtenderBlockEntity == null) {
                return;
            }
            PortalExtenderBlockEntity ent = portalExtenderBlockEntity;
            if (ent.getParent() != null) {
                BlockPos blockPos = ent.getParent();
                Intrinsics.checkNotNull((Object)blockPos);
                if (level.getBlockEntity(blockPos.offset((Vec3i)ent.getBlockPos())) instanceof PortalControllerBlockEntity) {
                    return;
                }
                ent.setParent(null);
                BlockUtil.setDirty((BlockEntity)ent);
            }
            for (Direction dir : EntriesMappings.entries$0) {
                BlockEntity neighbor;
                BlockPos npos = pos.offset(dir.getNormal());
                if (level.getBlockEntity(npos) == null) continue;
                if (neighbor instanceof PortalExtenderBlockEntity) {
                    BlockPos p = ((PortalExtenderBlockEntity)neighbor).getParent();
                    if (p != null && level.getBlockEntity(p.offset((Vec3i)((PortalExtenderBlockEntity)neighbor).getBlockPos())) instanceof PortalControllerBlockEntity) {
                        ent.setParent(p.offset((Vec3i)((PortalExtenderBlockEntity)neighbor).getBlockPos()).subtract((Vec3i)pos));
                        BlockUtil.setDirty((BlockEntity)ent);
                    }
                } else if (neighbor instanceof PortalControllerBlockEntity) {
                    ent.setParent(((PortalControllerBlockEntity)neighbor).getBlockPos().subtract((Vec3i)pos));
                    BlockUtil.setDirty((BlockEntity)ent);
                }
                if (ent.getParent() == null) continue;
            }
            BlockPos blockPos = ent.getParent();
            if (blockPos == null) break block9;
            BlockPos it = blockPos;
            boolean bl = false;
            BlockEntity blockEntity2 = level.getBlockEntity(it.offset((Vec3i)pos));
            PortalControllerBlockEntity portalControllerBlockEntity = blockEntity2 instanceof PortalControllerBlockEntity ? (PortalControllerBlockEntity)blockEntity2 : null;
            if (portalControllerBlockEntity != null) {
                portalControllerBlockEntity.update(pos);
            }
        }
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.INVISIBLE;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape voxelShape;
        Entity ent;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (context instanceof EntityCollisionContext && (ent = ((EntityCollisionContext)context).getEntity()) instanceof Player && (((Player)ent).getMainHandItem().is((Holder)TBSItems.LINKER) || ((Player)ent).getOffhandItem().is((Holder)TBSItems.LINKER) || PlayerUtil.getGameMode((Player)((Player)ent)) == GameType.CREATIVE)) {
            VoxelShape voxelShape2 = Shapes.block();
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"block(...)");
            return voxelShape2;
        }
        if (context.isHoldingItem((Item)TBSItems.LINKER.get())) {
            VoxelShape voxelShape3 = Shapes.block();
            voxelShape = voxelShape3;
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape3, (String)"block(...)");
        } else {
            VoxelShape voxelShape4 = Shapes.empty();
            voxelShape = voxelShape4;
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape4, (String)"empty(...)");
        }
        return voxelShape;
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }
}


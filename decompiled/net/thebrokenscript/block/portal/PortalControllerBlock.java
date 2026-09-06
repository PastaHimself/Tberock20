/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.RelativeMovement
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.EntityCollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.blocks.TickedBlock
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExtKt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block.portal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.block.portal.PortalControllerBlockEntity;
import net.thebrokenscript.brokencore.api.blocks.TickedBlock;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExtKt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.handlers.subs.PlayerTeleportationSubscriber;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J>\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fH\u0002J0\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020$2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\fH\u0014J(\u0010+\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020-2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020/H\u0014\u00a8\u00060"}, d2={"Lnet/thebrokenscript/block/portal/PortalControllerBlock;", "Lnet/thebrokenscript/brokencore/api/blocks/TickedBlock;", "Lnet/minecraft/world/level/block/EntityBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "newBlockEntity", "Lnet/thebrokenscript/block/portal/PortalControllerBlockEntity;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "tick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "random", "Lnet/minecraft/util/RandomSource;", "processPlayers", "entities", "", "Lnet/minecraft/world/entity/Entity;", "ent", "linked", "bba", "Lnet/minecraft/world/phys/AABB;", "bbb", "getEntryFace", "Lnet/minecraft/core/Direction;", "entityPos", "Lnet/minecraft/world/phys/Vec3;", "aabb", "velocity", "useWithoutItem", "Lnet/minecraft/world/InteractionResult;", "Lnet/minecraft/world/level/Level;", "player", "Lnet/minecraft/world/entity/player/Player;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/world/level/BlockGetter;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPortalControllerBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PortalControllerBlock.kt\nnet/thebrokenscript/block/portal/PortalControllerBlock\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n15#2:170\n15#2:180\n1563#3:171\n1634#3,3:172\n1563#3:175\n1634#3,3:176\n1#4:179\n*S KotlinDebug\n*F\n+ 1 PortalControllerBlock.kt\nnet/thebrokenscript/block/portal/PortalControllerBlock\n*L\n51#1:170\n151#1:180\n62#1:171\n62#1:172,3\n63#1:175\n63#1:176,3\n*E\n"})
public final class PortalControllerBlock
extends TickedBlock
implements EntityBlock {
    public PortalControllerBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties, 1);
    }

    @NotNull
    public PortalControllerBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (PortalControllerBlockEntity)TBSBlockEntities.PORTAL_CONTROLLER.create(pos, state);
    }

    protected void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        Entity p0;
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        super.tick(state, level, pos, random);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        PortalControllerBlockEntity portalControllerBlockEntity = blockEntity instanceof PortalControllerBlockEntity ? (PortalControllerBlockEntity)blockEntity : null;
        if (portalControllerBlockEntity == null) {
            return;
        }
        PortalControllerBlockEntity ent = portalControllerBlockEntity;
        BlockPos blockPos = ent.getLinked();
        if (blockPos == null) {
            return;
        }
        BlockPos linkedPos = blockPos;
        BlockEntity blockEntity2 = level.getBlockEntity(linkedPos.offset((Vec3i)pos));
        PortalControllerBlockEntity portalControllerBlockEntity2 = blockEntity2 instanceof PortalControllerBlockEntity ? (PortalControllerBlockEntity)blockEntity2 : null;
        if (portalControllerBlockEntity2 == null) {
            return;
        }
        PortalControllerBlockEntity linked = portalControllerBlockEntity2;
        AABB bba = ent.getBb().getAabb().move(ent.getBlockPos());
        AABB bbb = linked.getBb().getAabb().move(linked.getBlockPos());
        Intrinsics.checkNotNull((Object)bba);
        Vec3 vec3 = BoundingBoxExtKt.getSizeBox((AABB)bba);
        Intrinsics.checkNotNull((Object)bbb);
        if (!Intrinsics.areEqual((Object)vec3, (Object)BoundingBoxExtKt.getSizeBox((AABB)bbb))) {
            if (!PlatformUtil.Companion.isProduction()) {
                LevelAccessor levelAccessor = (LevelAccessor)level;
                String $this$c$iv = "Incompatible linked AABB sizes! A: " + ent.getBlockPos().toShortString() + "; B: " + linkedPos.toShortString();
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)component, (boolean)false, (int)2, null);
            }
            return;
        }
        List entities = level.getEntitiesOfClass(Entity.class, bba);
        List entities2 = level.getEntitiesOfClass(Entity.class, bbb);
        Intrinsics.checkNotNull((Object)entities);
        this.processPlayers(entities, level, ent, linked, bba, bbb);
        Intrinsics.checkNotNull((Object)entities2);
        this.processPlayers(entities2, level, linked, ent, bbb, bba);
        List list = level.getEntitiesOfClass(Entity.class, bba);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesOfClass(...)");
        Iterable iterable = list;
        PortalControllerBlockEntity portalControllerBlockEntity3 = ent;
        boolean $i$f$map = false;
        void var14_17 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Entity entity = (Entity)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(p0.getUUID());
        }
        portalControllerBlockEntity3.setIncoming(CollectionsKt.toMutableList((Collection)((List)destination$iv$iv)));
        List list2 = level.getEntitiesOfClass(Entity.class, bbb);
        Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getEntitiesOfClass(...)");
        $this$map$iv = list2;
        portalControllerBlockEntity3 = linked;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            p0 = (Entity)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(p0.getUUID());
        }
        portalControllerBlockEntity3.setIncoming(CollectionsKt.toMutableList((Collection)((List)destination$iv$iv)));
    }

    private final void processPlayers(List<? extends Entity> entities, ServerLevel level, PortalControllerBlockEntity ent, PortalControllerBlockEntity linked, AABB bba, AABB bbb) {
        for (Entity entity : entities) {
            if (ent.getIncoming().contains(entity.getUUID())) continue;
            List<UUID> list = linked.getIncoming();
            UUID uUID = entity.getUUID();
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
            list.add(uUID);
            Vec3 entityPos = entity.position();
            double yOffset = entity.isPassenger() ? 0.0 : entityPos.y - bba.minY;
            Vec3 offset = new Vec3(entityPos.x - bba.minX, yOffset, entityPos.z - bba.minZ);
            Vec3 target = bbb.getMinPosition().add(offset);
            Ref.BooleanRef canceled = new Ref.BooleanRef();
            CancelProxy cancelProxy = new CancelProxy(arg_0 -> PortalControllerBlock.processPlayers$lambda$0(canceled, arg_0), () -> PortalControllerBlock.processPlayers$lambda$1(canceled));
            Vec3 vec3 = entity.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            Vec3 vec32 = entity.getDeltaMovement();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"getDeltaMovement(...)");
            Direction entryFace = this.getEntryFace(vec3, bba, vec32);
            if (entity instanceof Player) {
                PlayerTeleportationSubscriber.INSTANCE.call((Player)entity, entryFace, cancelProxy);
            }
            if (cancelProxy.isCanceled() || !(entity instanceof LivingEntity) || !entity.teleportTo(level, target.x, target.y, target.z, (Set)EnumSet.of((Enum)RelativeMovement.X_ROT, (Enum)RelativeMovement.Y_ROT, (Enum)RelativeMovement.X, (Enum)RelativeMovement.Y, (Enum)RelativeMovement.Z), ((LivingEntity)entity).getYRot(), ((LivingEntity)entity).getXRot())) continue;
            ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().multiply(1.0, 1.0, 1.0));
        }
    }

    private final Direction getEntryFace(Vec3 entityPos, AABB aabb, Vec3 velocity) {
        Object object;
        double epsilon = 0.1;
        if (entityPos.x <= aabb.minX + epsilon && velocity.x > 0.0) {
            object = Direction.WEST;
        } else if (entityPos.x >= aabb.maxX - epsilon && velocity.x < 0.0) {
            object = Direction.EAST;
        } else if (entityPos.y <= aabb.minY + epsilon && velocity.y > 0.0) {
            object = Direction.DOWN;
        } else if (entityPos.y >= aabb.maxY - epsilon && velocity.y < 0.0) {
            object = Direction.UP;
        } else if (entityPos.z <= aabb.minZ + epsilon && velocity.z > 0.0) {
            object = Direction.NORTH;
        } else if (entityPos.z >= aabb.maxZ - epsilon && velocity.z < 0.0) {
            object = Direction.SOUTH;
        } else {
            Object v1;
            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Direction.WEST, (Object)(entityPos.x - aabb.minX)), TuplesKt.to((Object)Direction.EAST, (Object)(aabb.maxX - entityPos.x)), TuplesKt.to((Object)Direction.DOWN, (Object)(entityPos.y - aabb.minY)), TuplesKt.to((Object)Direction.UP, (Object)(aabb.maxY - entityPos.y)), TuplesKt.to((Object)Direction.NORTH, (Object)(entityPos.z - aabb.minZ)), TuplesKt.to((Object)Direction.SOUTH, (Object)(aabb.maxZ - entityPos.z))};
            Map distances = MapsKt.mapOf((Pair[])pairArray);
            Iterable iterable = distances.entrySet();
            Iterator iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                v1 = null;
            } else {
                Object t = iterator.next();
                if (!iterator.hasNext()) {
                    v1 = t;
                } else {
                    Map.Entry it = (Map.Entry)t;
                    boolean bl = false;
                    double d = ((Number)it.getValue()).doubleValue();
                    do {
                        Object t2 = iterator.next();
                        Map.Entry it2 = (Map.Entry)t2;
                        $i$a$-minByOrNull-PortalControllerBlock$getEntryFace$1 = false;
                        double d2 = ((Number)it2.getValue()).doubleValue();
                        if (Double.compare(d, d2) <= 0) continue;
                        t = t2;
                        d = d2;
                    } while (iterator.hasNext());
                    v1 = t;
                }
            }
            if ((object = (Map.Entry)v1) == null || (object = (Direction)object.getKey()) == null) {
                object = Direction.NORTH;
            }
        }
        return object;
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
        PortalControllerBlockEntity portalControllerBlockEntity = blockEntity instanceof PortalControllerBlockEntity ? (PortalControllerBlockEntity)blockEntity : null;
        if (portalControllerBlockEntity == null) {
            return InteractionResult.PASS;
        }
        PortalControllerBlockEntity ent = portalControllerBlockEntity;
        Object object = ent.getLinked();
        if (object == null || (object = object.offset((Vec3i)pos)) == null || (object = object.toShortString()) == null) {
            object = "Unknown";
        }
        Object linked = object;
        Vec3 size = BoundingBoxExtKt.getSizeBox((AABB)ent.getBb().getAabb());
        String $this$c$iv = "Linked pos: " + (String)linked + "; Size: " + size;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        player.sendSystemMessage(component);
        return InteractionResult.PASS;
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

    private static final Unit processPlayers$lambda$0(Ref.BooleanRef $canceled, boolean it) {
        $canceled.element = it;
        return Unit.INSTANCE;
    }

    private static final boolean processPlayers$lambda$1(Ref.BooleanRef $canceled) {
        return $canceled.element;
    }
}


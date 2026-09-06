/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BedBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.ComparatorBlock
 *  net.minecraft.world.level.block.DispenserBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.LeverBlock
 *  net.minecraft.world.level.block.RedStoneWireBlock
 *  net.minecraft.world.level.block.RepeaterBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.data.NbtSerializable
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.RayExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.RayExt;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u000489:;B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u0006J\u0018\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020$J \u0010%\u001a\u00020&2\u0006\u0010\n\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001aH\u0002J(\u0010)\u001a\u00020*2\u0006\u0010\n\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u00107\u001a\u000203H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006<"}, d2={"Lnet/thebrokenscript/util/InteractionTracker;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "<init>", "()V", "interactions", "Ljava/util/HashMap;", "Lnet/thebrokenscript/util/InteractionTracker$InteractionType;", "Ljava/util/ArrayList;", "Lnet/thebrokenscript/util/InteractionTracker$TrackedInteraction;", "getTrackType", "level", "Lnet/minecraft/world/level/Level;", "pos", "Lnet/minecraft/core/BlockPos;", "value", "bedAnchor", "getBedAnchor", "()Lnet/thebrokenscript/util/InteractionTracker$TrackedInteraction;", "setBedAnchor", "(Lnet/thebrokenscript/util/InteractionTracker$TrackedInteraction;)V", "track", "", "interactionTime", "", "interactionPos", "playerPos", "Lnet/minecraft/world/phys/Vec3;", "type", "lastBedInteraction", "getLastBedInteraction", "()Lnet/minecraft/core/BlockPos;", "untrack", "getMostUsedPos", "calculateAverageCenter", "centerType", "Lnet/thebrokenscript/util/InteractionTracker$CenterType;", "Lnet/minecraft/server/level/ServerLevel;", "isVisible", "", "from", "to", "findGroundBelow", "", "x", "", "startY", "z", "save", "entity", "Lnet/minecraft/world/entity/player/Player;", "serializeNbt", "Lnet/minecraft/nbt/Tag;", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNbt", "tag", "InteractionType", "TrackedInteraction", "CenterType", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nInteractionTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InteractionTracker.kt\nnet/thebrokenscript/util/InteractionTracker\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,261:1\n382#2,7:262\n1#3:269\n1#3:280\n1617#4,9:270\n1869#4:279\n1870#4:281\n1626#4:282\n774#4:283\n865#4,2:284\n37#5,2:286\n*S KotlinDebug\n*F\n+ 1 InteractionTracker.kt\nnet/thebrokenscript/util/InteractionTracker\n*L\n105#1:262,7\n147#1:280\n147#1:270,9\n147#1:279\n147#1:281\n147#1:282\n150#1:283\n150#1:284,2\n240#1:286,2\n*E\n"})
public final class InteractionTracker
implements NbtSerializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final HashMap<InteractionType, ArrayList<TrackedInteraction>> interactions = new HashMap();
    @NotNull
    private static final HashMap<UUID, InteractionTracker> trackerObjects = new HashMap();
    private static final double ANCHOR_RADIUS = 50.0;
    private static final double BED_REPLACE_THRESHOLD = 20.0;

    @Nullable
    public final InteractionType getTrackType(@NotNull Level level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Block block = level.getBlockState(pos).getBlock();
        if (!Intrinsics.areEqual((Object)level.dimension(), (Object)Level.OVERWORLD)) {
            return null;
        }
        Block block2 = block;
        return Intrinsics.areEqual((Object)block2, (Object)Blocks.CHEST) || Intrinsics.areEqual((Object)block2, (Object)Blocks.BARREL) || Intrinsics.areEqual((Object)block2, (Object)Blocks.TRAPPED_CHEST) ? InteractionType.CHEST_LIKE : (block2 instanceof DoorBlock || block2 instanceof TrapDoorBlock ? InteractionType.DOOR_LIKE : (block2 instanceof BedBlock ? InteractionType.BED : (Intrinsics.areEqual((Object)block2, (Object)Blocks.FURNACE) || Intrinsics.areEqual((Object)block2, (Object)Blocks.SMOKER) || Intrinsics.areEqual((Object)block2, (Object)Blocks.BLAST_FURNACE) ? InteractionType.FURNACE_LIKE : (Intrinsics.areEqual((Object)block2, (Object)Blocks.CRAFTING_TABLE) || Intrinsics.areEqual((Object)block2, (Object)Blocks.STONECUTTER) || Intrinsics.areEqual((Object)block2, (Object)Blocks.ENCHANTING_TABLE) || Intrinsics.areEqual((Object)block2, (Object)Blocks.SMITHING_TABLE) || Intrinsics.areEqual((Object)block2, (Object)Blocks.GRINDSTONE) || Intrinsics.areEqual((Object)block2, (Object)Blocks.LOOM) ? InteractionType.CRAFTING_TABLE_LIKE : (block2 instanceof ButtonBlock || block2 instanceof LeverBlock || block2 instanceof RepeaterBlock || block2 instanceof ComparatorBlock || block2 instanceof DispenserBlock || block2 instanceof RedStoneWireBlock ? InteractionType.REDSTONE_COMPONENT : null)))));
    }

    private final TrackedInteraction getBedAnchor() {
        ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)InteractionType.BED);
        return arrayList != null ? (TrackedInteraction)CollectionsKt.lastOrNull((List)arrayList) : null;
    }

    private final void setBedAnchor(TrackedInteraction value) {
        if (value == null) {
            ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)InteractionType.BED);
            if (arrayList != null) {
                arrayList.clear();
            }
        } else {
            Map map = this.interactions;
            InteractionType interactionType = InteractionType.BED;
            Object object = new TrackedInteraction[]{value};
            object = CollectionsKt.arrayListOf((Object[])object);
            map.put(interactionType, object);
        }
    }

    public final void track(long interactionTime, @NotNull BlockPos interactionPos, @NotNull Vec3 playerPos, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)interactionPos, (String)"interactionPos");
        Intrinsics.checkNotNullParameter((Object)playerPos, (String)"playerPos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        InteractionType interactionType = this.getTrackType(level, interactionPos);
        if (interactionType == null) {
            return;
        }
        InteractionType trackType = interactionType;
        this.track(interactionTime, interactionPos, playerPos, trackType);
    }

    /*
     * WARNING - void declaration
     */
    public final void track(long interactionTime, @NotNull BlockPos interactionPos, @NotNull Vec3 playerPos, @NotNull InteractionType type) {
        TrackedInteraction anchor;
        Intrinsics.checkNotNullParameter((Object)interactionPos, (String)"interactionPos");
        Intrinsics.checkNotNullParameter((Object)playerPos, (String)"playerPos");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        this.interactions.putIfAbsent(type, new ArrayList());
        TrackedInteraction interaction = new TrackedInteraction(interactionTime, interactionPos, playerPos);
        if (type == InteractionType.BED && ((anchor = this.getBedAnchor()) == null || interactionPos.distSqr((Vec3i)anchor.getInteractionPos()) > 400.0)) {
            this.interactions.clear();
            Map map = this.interactions;
            InteractionType interactionType = InteractionType.BED;
            Object object = new TrackedInteraction[]{interaction};
            object = CollectionsKt.arrayListOf((Object[])object);
            map.put(interactionType, object);
            return;
        }
        TrackedInteraction trackedInteraction = this.getBedAnchor();
        if (trackedInteraction == null) {
            return;
        }
        anchor = trackedInteraction;
        if (playerPos.distanceTo(anchor.getPlayerPos()) <= 50.0) {
            ArrayList typedInteractions;
            Object object;
            void $this$getOrPut$iv;
            Map map = this.interactions;
            InteractionType key$iv = type;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get((Object)key$iv);
            if (value$iv == null) {
                boolean bl = false;
                ArrayList answer$iv = new ArrayList();
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            if ((typedInteractions = (ArrayList)object).isEmpty() || interactionTime - ((TrackedInteraction)CollectionsKt.last((List)typedInteractions)).getInteractionTime() > 30L) {
                typedInteractions.add(interaction);
            }
        }
    }

    @Nullable
    public final BlockPos getLastBedInteraction() {
        ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)InteractionType.BED);
        return arrayList != null && (arrayList = (TrackedInteraction)CollectionsKt.lastOrNull((List)arrayList)) != null && (arrayList = ((TrackedInteraction)((Object)arrayList)).getPlayerPos()) != null ? PositionUtil.getBlockPos((Position)((Position)arrayList)) : null;
    }

    public final void untrack(@NotNull BlockPos interactionPos, @NotNull InteractionType type) {
        Intrinsics.checkNotNullParameter((Object)interactionPos, (String)"interactionPos");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)type);
        if (arrayList == null) {
            return;
        }
        ArrayList<TrackedInteraction> typedInteractions = arrayList;
        for (int i = 0; i < this.interactions.size(); ++i) {
            TrackedInteraction interaction;
            Intrinsics.checkNotNullExpressionValue((Object)typedInteractions.get(i), (String)"get(...)");
            if (!Intrinsics.areEqual((Object)interaction.getInteractionPos(), (Object)interactionPos)) continue;
            typedInteractions.remove(interaction);
        }
    }

    @Nullable
    public final BlockPos getMostUsedPos(@NotNull InteractionType type) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)type);
        Intrinsics.checkNotNull(arrayList);
        ArrayList<TrackedInteraction> typedInteractions = arrayList;
        HashMap map = new HashMap();
        Iterator<TrackedInteraction> iterator = typedInteractions.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator<TrackedInteraction> iterator2 = iterator;
        while (iterator2.hasNext()) {
            TrackedInteraction i;
            Intrinsics.checkNotNullExpressionValue((Object)iterator2.next(), (String)"next(...)");
            ((Map)map).put(i.getInteractionPos(), map.getOrDefault(i.getInteractionPos(), 1));
        }
        int last = 0;
        BlockPos result = null;
        for (BlockPos pos : map.keySet()) {
            Object v = map.get(pos);
            Intrinsics.checkNotNull(v);
            int count = ((Number)v).intValue();
            if (last >= count) continue;
            result = pos;
            last = count;
        }
        return result;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Vec3 calculateAverageCenter(@NotNull CenterType centerType, @NotNull ServerLevel level) {
        double d;
        Vec3 center;
        Iterable $this$filterTo$iv$iv;
        void $this$filter$iv;
        InteractionType type;
        Object element$iv$iv;
        void $this$mapNotNullTo$iv$iv;
        Iterable it;
        Intrinsics.checkNotNullParameter((Object)((Object)centerType), (String)"centerType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Collection<ArrayList<TrackedInteraction>> collection = this.interactions.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Iterable iterable = collection;
        int n = 0;
        for (Object t : iterable) {
            ArrayList arrayList = (ArrayList)t;
            int n2 = n;
            boolean bl = false;
            int n3 = ((ArrayList)it).size();
            n = n2 + n3;
        }
        if (n <= 5) {
            return null;
        }
        BlockPos blockPos = this.getLastBedInteraction();
        if (blockPos == null) {
            return null;
        }
        BlockPos anchor = blockPos;
        Iterable $this$mapNotNull$iv = (Iterable)InteractionType.getEntries();
        boolean $i$f$mapNotNull = false;
        it = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv$iv$iv.iterator();
        while (iterator.hasNext()) {
            Vec3 it$iv$iv;
            Object element$iv$iv$iv;
            element$iv$iv = element$iv$iv$iv = iterator.next();
            boolean bl = false;
            type = (InteractionType)((Object)element$iv$iv);
            boolean bl2 = false;
            Collection collection2 = this.interactions.get((Object)type);
            if ((collection2 == null || collection2.isEmpty() ? null : this.calculateAverageCenter(centerType, type)) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        $this$mapNotNull$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$mapNotNullTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo22 = false;
        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
            center = (Vec3)element$iv$iv2;
            boolean bl = false;
            Vec3 vec3 = anchor.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            if (!this.isVisible(level, vec3, center)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        List centers = (List)destination$iv$iv;
        if (centers.isEmpty()) {
            return null;
        }
        $this$filterTo$iv$iv = centers;
        double d2 = 0.0;
        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
            void it2;
            center = (Vec3)element$iv$iv2;
            double d3 = d2;
            boolean bl = false;
            d = it2.x;
            d2 = d3 + d;
        }
        double avgX = d2 / (double)centers.size();
        Iterable $i$f$filterTo22 = centers;
        double d4 = 0.0;
        for (Object t : $i$f$filterTo22) {
            void it3;
            element$iv$iv = (Vec3)t;
            double d5 = d4;
            boolean bl = false;
            d = it3.y;
            d4 = d5 + d;
        }
        double avgY = d4 / (double)centers.size();
        Iterable element$iv$iv2 = centers;
        double d6 = 0.0;
        for (Object t : element$iv$iv2) {
            void it4;
            type = (Vec3)t;
            double d7 = d6;
            boolean bl = false;
            d = it4.z;
            d6 = d7 + d;
        }
        double avgZ = d6 / (double)centers.size();
        double groundY = this.findGroundBelow(level, (int)avgX, (int)avgY, (int)avgZ);
        return new Vec3(avgX, groundY, avgZ);
    }

    private final boolean isVisible(ServerLevel level, Vec3 from, Vec3 to) {
        Vec3 direction = to.subtract(from).normalize();
        Vec3 adjustedTo = to.subtract(direction.scale(0.5));
        Level level2 = (Level)level;
        Intrinsics.checkNotNull((Object)adjustedTo);
        return RayExt.rayCast((Level)level2, (Vec3)from, (Vec3)adjustedTo).getType() == HitResult.Type.MISS;
    }

    private final double findGroundBelow(ServerLevel level, int x, int startY, int z) {
        int y = startY;
        int n = level.getMinBuildHeight();
        if (n <= y) {
            while (true) {
                BlockPos pos;
                BlockState state;
                if ((state = level.getBlockState(pos = new BlockPos(x, y, z))).isCollisionShapeFullBlock((BlockGetter)level, pos) && state.getFluidState().isEmpty() && level.getBlockState(pos.above()).isAir()) {
                    return (double)y + 1.0;
                }
                if (y == n) break;
                --y;
            }
        }
        return startY;
    }

    @Nullable
    public final Vec3 calculateAverageCenter(@NotNull CenterType centerType, @NotNull InteractionType type) {
        Intrinsics.checkNotNullParameter((Object)((Object)centerType), (String)"centerType");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        ArrayList<TrackedInteraction> arrayList = this.interactions.get((Object)type);
        if (arrayList == null) {
            return null;
        }
        ArrayList<TrackedInteraction> typedInteractions = arrayList;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        int s = Math.max(typedInteractions.size(), 1);
        Iterator<TrackedInteraction> iterator = typedInteractions.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator<TrackedInteraction> iterator2 = iterator;
        block5: while (iterator2.hasNext()) {
            Intrinsics.checkNotNullExpressionValue((Object)iterator2.next(), (String)"next(...)");
            switch (WhenMappings.$EnumSwitchMapping$0[centerType.ordinal()]) {
                case 1: {
                    TrackedInteraction interaction;
                    x += ((double)interaction.getInteractionPos().getX() + interaction.getPlayerPos().x) / 2.0;
                    y += ((double)interaction.getInteractionPos().getY() + interaction.getPlayerPos().y) / 2.0;
                    z += ((double)interaction.getInteractionPos().getZ() + interaction.getPlayerPos().z) / 2.0;
                    continue block5;
                }
                case 2: {
                    TrackedInteraction interaction;
                    x += (double)interaction.getInteractionPos().getX();
                    y += (double)interaction.getInteractionPos().getY();
                    z += (double)interaction.getInteractionPos().getZ();
                    continue block5;
                }
                case 3: {
                    TrackedInteraction interaction;
                    x += interaction.getPlayerPos().x;
                    y += interaction.getPlayerPos().y;
                    z += interaction.getPlayerPos().z;
                    continue block5;
                }
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Vec3(x / (double)s, y / (double)s, z / (double)s);
    }

    public final void save(@NotNull Player entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        TBSDataAttachments.INTERACTION_TRACKER.set((Entity)entity, (Object)this);
    }

    @NotNull
    public Tag serializeNbt(@NotNull HolderLookup.Provider provider2) {
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        CompoundTag nbt = new CompoundTag();
        Iterator<InteractionType> iterator = this.interactions.keySet().iterator();
        while (iterator.hasNext()) {
            Iterator<TrackedInteraction> iterator2;
            ArrayList<TrackedInteraction> typeEntries;
            InteractionType type;
            Intrinsics.checkNotNullExpressionValue((Object)((Object)iterator.next()), (String)"next(...)");
            Intrinsics.checkNotNull(this.interactions.get((Object)type));
            ListTag typeNbt = new ListTag();
            Intrinsics.checkNotNullExpressionValue(typeEntries.iterator(), (String)"iterator(...)");
            while (iterator2.hasNext()) {
                TrackedInteraction interaction;
                Intrinsics.checkNotNullExpressionValue((Object)iterator2.next(), (String)"next(...)");
                typeNbt.add((Object)interaction.toNbt());
            }
            nbt.put(String.valueOf(type.getI()), (Tag)typeNbt);
        }
        return (Tag)nbt;
    }

    public void deserializeNbt(@NotNull HolderLookup.Provider provider2, @NotNull Tag tag) {
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        CompoundTag cfr_ignored_0 = (CompoundTag)tag;
        this.interactions.clear();
        new BoundingBox(0, 0, 0, 0, 0, 0).intersects(new BoundingBox(0, 0, 0, 0, 0, 0));
        Collection $this$toTypedArray$iv = (Collection)InteractionType.getEntries();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        int n = thisCollection$iv.toArray(new InteractionType[0]).length;
        for (int i = 0; i < n; ++i) {
            Iterator iterator;
            String str = String.valueOf(i);
            ListTag typeList = ((CompoundTag)tag).getList(str, 10);
            Intrinsics.checkNotNullExpressionValue((Object)typeList.iterator(), (String)"iterator(...)");
            while (iterator.hasNext()) {
                Tag nbtCompound = (Tag)iterator.next();
                if (!(nbtCompound instanceof CompoundTag)) continue;
                Object t = NbtUtils.readBlockPos((CompoundTag)((CompoundTag)nbtCompound), (String)"blockPos").get();
                Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
                BlockPos interactionPos = (BlockPos)t;
                Vec3 playerPos = new Vec3(((CompoundTag)nbtCompound).getDouble("x"), ((CompoundTag)nbtCompound).getDouble("y"), ((CompoundTag)nbtCompound).getDouble("z"));
                long interactionTime = ((CompoundTag)nbtCompound).getLong("interactionTime");
                InteractionType interactionType = InteractionType.Companion.fromInt(i);
                Intrinsics.checkNotNull((Object)((Object)interactionType));
                this.track(interactionTime, interactionPos, playerPos, interactionType);
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/util/InteractionTracker$CenterType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYER_POS", "BLOCK_POS", "BOTH", "thebrokenscript-common"})
    public static final class CenterType
    extends Enum<CenterType> {
        public static final /* enum */ CenterType PLAYER_POS = new CenterType();
        public static final /* enum */ CenterType BLOCK_POS = new CenterType();
        public static final /* enum */ CenterType BOTH = new CenterType();
        private static final /* synthetic */ CenterType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static CenterType[] values() {
            return (CenterType[])$VALUES.clone();
        }

        public static CenterType valueOf(String value) {
            return Enum.valueOf(CenterType.class, value);
        }

        @NotNull
        public static EnumEntries<CenterType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = centerTypeArray = new CenterType[]{CenterType.PLAYER_POS, CenterType.BLOCK_POS, CenterType.BOTH};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/util/InteractionTracker$Companion;", "", "<init>", "()V", "trackerObjects", "Ljava/util/HashMap;", "Ljava/util/UUID;", "Lnet/thebrokenscript/util/InteractionTracker;", "Lkotlin/collections/HashMap;", "getTrackerObjects", "()Ljava/util/HashMap;", "ANCHOR_RADIUS", "", "BED_REPLACE_THRESHOLD", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<UUID, InteractionTracker> getTrackerObjects() {
            return trackerObjects;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/util/InteractionTracker$InteractionType;", "", "i", "", "<init>", "(Ljava/lang/String;II)V", "getI", "()I", "CHEST_LIKE", "BED", "CRAFTING_TABLE_LIKE", "FURNACE_LIKE", "DOOR_LIKE", "REDSTONE_COMPONENT", "Companion", "thebrokenscript-common"})
    public static final class InteractionType
    extends Enum<InteractionType> {
        @NotNull
        public static final Companion Companion;
        private final int i;
        public static final /* enum */ InteractionType CHEST_LIKE;
        public static final /* enum */ InteractionType BED;
        public static final /* enum */ InteractionType CRAFTING_TABLE_LIKE;
        public static final /* enum */ InteractionType FURNACE_LIKE;
        public static final /* enum */ InteractionType DOOR_LIKE;
        public static final /* enum */ InteractionType REDSTONE_COMPONENT;
        private static final /* synthetic */ InteractionType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private InteractionType(int i) {
            this.i = i;
        }

        public final int getI() {
            return this.i;
        }

        public static InteractionType[] values() {
            return (InteractionType[])$VALUES.clone();
        }

        public static InteractionType valueOf(String value) {
            return Enum.valueOf(InteractionType.class, value);
        }

        @NotNull
        public static EnumEntries<InteractionType> getEntries() {
            return $ENTRIES;
        }

        static {
            CHEST_LIKE = new InteractionType(0);
            BED = new InteractionType(1);
            CRAFTING_TABLE_LIKE = new InteractionType(2);
            FURNACE_LIKE = new InteractionType(3);
            DOOR_LIKE = new InteractionType(4);
            REDSTONE_COMPONENT = new InteractionType(5);
            $VALUES = interactionTypeArray = new InteractionType[]{InteractionType.CHEST_LIKE, InteractionType.BED, InteractionType.CRAFTING_TABLE_LIKE, InteractionType.FURNACE_LIKE, InteractionType.DOOR_LIKE, InteractionType.REDSTONE_COMPONENT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/util/InteractionTracker$InteractionType$Companion;", "", "<init>", "()V", "fromInt", "Lnet/thebrokenscript/util/InteractionTracker$InteractionType;", "i", "", "thebrokenscript-common"})
        public static final class Companion {
            private Companion() {
            }

            @Nullable
            public final InteractionType fromInt(int i) {
                Pair[] pairArray = new Pair[]{new Pair((Object)0, (Object)CHEST_LIKE), new Pair((Object)1, (Object)BED), new Pair((Object)2, (Object)CRAFTING_TABLE_LIKE), new Pair((Object)3, (Object)FURNACE_LIKE), new Pair((Object)4, (Object)DOOR_LIKE), new Pair((Object)5, (Object)REDSTONE_COMPONENT)};
                return (InteractionType)((Object)MapsKt.mapOf((Pair[])pairArray).get(i));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/util/InteractionTracker$TrackedInteraction;", "", "interactionTime", "", "interactionPos", "Lnet/minecraft/core/BlockPos;", "playerPos", "Lnet/minecraft/world/phys/Vec3;", "<init>", "(JLnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/Vec3;)V", "getInteractionTime", "()J", "getInteractionPos", "()Lnet/minecraft/core/BlockPos;", "getPlayerPos", "()Lnet/minecraft/world/phys/Vec3;", "toNbt", "Lnet/minecraft/nbt/CompoundTag;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "thebrokenscript-common"})
    public static final class TrackedInteraction {
        private final long interactionTime;
        @NotNull
        private final BlockPos interactionPos;
        @NotNull
        private final Vec3 playerPos;

        public TrackedInteraction(long interactionTime, @NotNull BlockPos interactionPos, @NotNull Vec3 playerPos) {
            Intrinsics.checkNotNullParameter((Object)interactionPos, (String)"interactionPos");
            Intrinsics.checkNotNullParameter((Object)playerPos, (String)"playerPos");
            this.interactionTime = interactionTime;
            this.interactionPos = interactionPos;
            this.playerPos = playerPos;
        }

        public final long getInteractionTime() {
            return this.interactionTime;
        }

        @NotNull
        public final BlockPos getInteractionPos() {
            return this.interactionPos;
        }

        @NotNull
        public final Vec3 getPlayerPos() {
            return this.playerPos;
        }

        @NotNull
        public final CompoundTag toNbt() {
            CompoundTag nbt = new CompoundTag();
            Tag interactionPosNbt = NbtUtils.writeBlockPos((BlockPos)this.interactionPos);
            nbt.putDouble("x", this.playerPos.x);
            nbt.putDouble("y", this.playerPos.y);
            nbt.putDouble("z", this.playerPos.z);
            nbt.put("blockPos", interactionPosNbt);
            nbt.putLong("interactionTime", this.interactionTime);
            return nbt;
        }

        public final long component1() {
            return this.interactionTime;
        }

        @NotNull
        public final BlockPos component2() {
            return this.interactionPos;
        }

        @NotNull
        public final Vec3 component3() {
            return this.playerPos;
        }

        @NotNull
        public final TrackedInteraction copy(long interactionTime, @NotNull BlockPos interactionPos, @NotNull Vec3 playerPos) {
            Intrinsics.checkNotNullParameter((Object)interactionPos, (String)"interactionPos");
            Intrinsics.checkNotNullParameter((Object)playerPos, (String)"playerPos");
            return new TrackedInteraction(interactionTime, interactionPos, playerPos);
        }

        public static /* synthetic */ TrackedInteraction copy$default(TrackedInteraction trackedInteraction, long l, BlockPos blockPos, Vec3 vec3, int n, Object object) {
            if ((n & 1) != 0) {
                l = trackedInteraction.interactionTime;
            }
            if ((n & 2) != 0) {
                blockPos = trackedInteraction.interactionPos;
            }
            if ((n & 4) != 0) {
                vec3 = trackedInteraction.playerPos;
            }
            return trackedInteraction.copy(l, blockPos, vec3);
        }

        @NotNull
        public String toString() {
            return "TrackedInteraction(interactionTime=" + this.interactionTime + ", interactionPos=" + this.interactionPos + ", playerPos=" + this.playerPos + ")";
        }

        public int hashCode() {
            int result = Long.hashCode(this.interactionTime);
            result = result * 31 + this.interactionPos.hashCode();
            result = result * 31 + this.playerPos.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackedInteraction)) {
                return false;
            }
            TrackedInteraction trackedInteraction = (TrackedInteraction)other;
            if (this.interactionTime != trackedInteraction.interactionTime) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.interactionPos, (Object)trackedInteraction.interactionPos)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.playerPos, (Object)trackedInteraction.playerPos);
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[CenterType.values().length];
            try {
                nArray[CenterType.BOTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CenterType.BLOCK_POS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CenterType.PLAYER_POS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


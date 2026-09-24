/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.util;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.dsl.AabbUtil;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.UtilityBlockPoiScanner;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.Bedroom;
import net.thebrokenscript.brokencore.api.learner.rooms.CraftingRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.EmptyRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.GenericRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.Kitchen;
import net.thebrokenscript.brokencore.api.learner.rooms.LivingRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.StorageRoom;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.brokencore.api.util.CuboidBlockIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u00101\u001a\u00020\fJ\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\u001c\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020'0\u0003R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010$\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&`(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000&X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/RoomMeaningScanner;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "roomShapes", "", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "Lnet/minecraft/world/level/Level;", "maxUpdatesPerTick", "", "callback", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "", "<init>", "(Ljava/util/List;Lnet/minecraft/world/level/Level;ILkotlin/jvm/functions/Function1;)V", "category", "", "getCategory", "()Ljava/lang/String;", "tickDebug", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "updates", "currentRoomIndex", "boxes", "Ljava/util/Stack;", "Lnet/minecraft/world/phys/AABB;", "finished", "", "getFinished", "()Z", "iter", "Lnet/thebrokenscript/brokencore/api/util/CuboidBlockIterator;", "roomShapeMap", "Ljava/util/HashMap;", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "skipPositions", "Ljava/util/HashSet;", "Lnet/minecraft/core/BlockPos;", "Lkotlin/collections/HashSet;", "pos", "step", "rooms", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "tick", "assignMeaning", "finish", "getRoomType", "shape", "pois", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nRoomMeaningScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomMeaningScanner.kt\nnet/thebrokenscript/brokencore/api/learner/util/RoomMeaningScanner\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,162:1\n216#2,2:163\n1869#3:165\n1870#3:173\n1563#3:174\n1634#3,3:175\n382#4,7:166\n382#4,7:178\n*S KotlinDebug\n*F\n+ 1 RoomMeaningScanner.kt\nnet/thebrokenscript/brokencore/api/learner/util/RoomMeaningScanner\n*L\n73#1:163,2\n111#1:165\n111#1:173\n150#1:174\n150#1:175,3\n113#1:166,7\n142#1:178,7\n*E\n"})
public final class RoomMeaningScanner
implements Debuggable {
    @NotNull
    private final List<VoxelShape> roomShapes;
    @NotNull
    private final Level level;
    private final int maxUpdatesPerTick;
    @NotNull
    private final Function1<PlayerBase, Unit> callback;
    @NotNull
    private final String category;
    private int updates;
    private int currentRoomIndex;
    @NotNull
    private final Stack<AABB> boxes;
    @NotNull
    private CuboidBlockIterator iter;
    @NotNull
    private final HashMap<VoxelShape, List<RoomPoi>> roomShapeMap;
    @NotNull
    private final HashSet<BlockPos> skipPositions;
    @NotNull
    private BlockPos pos;
    private int step;
    @NotNull
    private List<AbstractRoom> rooms;

    /*
     * WARNING - void declaration
     */
    public RoomMeaningScanner(@NotNull List<? extends VoxelShape> roomShapes, @NotNull Level level, int maxUpdatesPerTick, @NotNull Function1<? super PlayerBase, Unit> callback) {
        BoundingBox boundingBox;
        void $this$pos_u24lambda_u240;
        BoundingBox boundingBox2;
        RoomMeaningScanner $this$boxes_u24lambda_u240;
        Intrinsics.checkNotNullParameter(roomShapes, (String)"roomShapes");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        this.roomShapes = roomShapes;
        this.level = level;
        this.maxUpdatesPerTick = maxUpdatesPerTick;
        this.callback = callback;
        this.category = "player_base";
        this.updates = this.maxUpdatesPerTick;
        RoomMeaningScanner roomMeaningScanner = this;
        RoomMeaningScanner roomMeaningScanner2 = this;
        boolean bl = false;
        Stack stack = new Stack();
        stack.addAll(((VoxelShape)CollectionsKt.first($this$boxes_u24lambda_u240.roomShapes)).toAabbs());
        roomMeaningScanner2.boxes = stack;
        if (this.boxes.empty()) {
            boundingBox2 = new BoundingBox(0, 0, 0, 0, 0, 0);
        } else {
            AABB aABB = this.boxes.peek();
            Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"peek(...)");
            boundingBox2 = AabbUtil.getRoundBox(aABB);
        }
        this.iter = new CuboidBlockIterator(boundingBox2);
        this.roomShapeMap = new HashMap();
        this.skipPositions = new HashSet();
        $this$boxes_u24lambda_u240 = this;
        roomMeaningScanner2 = this;
        boolean bl2 = false;
        if ($this$pos_u24lambda_u240.boxes.empty()) {
            boundingBox = new BoundingBox(0, 0, 0, 0, 0, 0);
        } else {
            AABB aABB = $this$pos_u24lambda_u240.boxes.peek();
            Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"peek(...)");
            boundingBox = AabbUtil.getRoundBox(aABB);
        }
        BoundingBox box = boundingBox;
        roomMeaningScanner2.pos = new BlockPos(box.minX(), box.minY(), box.minZ());
        this.rooms = new ArrayList();
    }

    @Override
    @NotNull
    public String getCategory() {
        return this.category;
    }

    @Override
    public void tickDebug() {
        this.tick();
    }

    @Override
    public void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            VoxelShape voxelShape = Shapes.create((AABB)new AABB(this.pos));
            Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"create(...)");
            VoxelShapeExtKt.renderLines(voxelShape, buffer, poseStack, 1.0f, 0.0f, 0.0f);
            VoxelShape voxelShape2 = (VoxelShape)CollectionsKt.getOrNull(this.roomShapes, (int)this.currentRoomIndex);
            if (voxelShape2 == null) break block0;
            VoxelShapeExtKt.renderLines(voxelShape2, buffer, poseStack, 1.0f, 1.0f, 1.0f);
        }
    }

    public final boolean getFinished() {
        return this.step == 3;
    }

    public final void tick() {
        switch (this.step) {
            case 0: {
                this.iter();
                break;
            }
            case 1: {
                this.assignMeaning();
                break;
            }
            case 2: {
                this.finish();
            }
        }
    }

    private final void assignMeaning() {
        Map $this$forEach$iv = this.roomShapeMap;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            VoxelShape shape = (VoxelShape)entry.getKey();
            List pois = (List)entry.getValue();
            this.rooms.add(this.getRoomType(shape, pois));
        }
        ++this.step;
    }

    private final void finish() {
        this.callback.invoke((Object)new PlayerBase(CollectionsKt.toList((Iterable)this.rooms)));
        this.skipPositions.clear();
        this.roomShapeMap.clear();
        this.boxes.clear();
        this.rooms.clear();
        ++this.step;
    }

    /*
     * WARNING - void declaration
     */
    private final void iter() {
        while (this.updates < this.maxUpdatesPerTick && this.currentRoomIndex < this.roomShapes.size()) {
            if (!this.skipPositions.contains(this.pos)) {
                Iterable $this$forEach$iv = RoomPoiScanner.Companion.getScanners$brokencore_common();
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Object object;
                    void $this$getOrPut$iv;
                    RoomPoiScanner it = (RoomPoiScanner)element$iv;
                    boolean bl = false;
                    BlockState state = this.level.getBlockState(this.pos);
                    Map map = this.roomShapeMap;
                    VoxelShape key$iv = this.roomShapes.get(this.currentRoomIndex);
                    boolean $i$f$getOrPut = false;
                    Object value$iv = $this$getOrPut$iv.get(key$iv);
                    if (value$iv == null) {
                        boolean bl2 = false;
                        List answer$iv = new ArrayList();
                        $this$getOrPut$iv.put(key$iv, answer$iv);
                        object = answer$iv;
                    } else {
                        object = value$iv;
                    }
                    List list = (List)object;
                    Intrinsics.checkNotNull((Object)state);
                    if (!it.trigger(this.pos, state, this.level)) continue;
                    list.add(it.scan(this.pos, state, this.level, this.skipPositions));
                }
            }
            if (this.iter.getFinished()) {
                if (this.boxes.isEmpty()) {
                    RoomMeaningScanner.iter$updateRoom(this);
                } else if (!((Collection)this.boxes).isEmpty()) {
                    this.boxes.pop();
                    if (!((Collection)this.boxes).isEmpty()) {
                        AABB aABB = this.boxes.peek();
                        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"peek(...)");
                        RoomMeaningScanner.iter$updateIterator(this, aABB);
                    }
                }
            } else {
                this.pos = this.iter.next();
            }
            int n = this.updates;
            this.updates = n + 1;
        }
        this.updates = 0;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final AbstractRoom getRoomType(@NotNull VoxelShape shape, @NotNull List<RoomPoi> pois) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
        Intrinsics.checkNotNullParameter(pois, (String)"pois");
        Iterable $this$map$iv = pois;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            RoomPoi roomPoi = (RoomPoi)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getSubtype());
        }
        List subtypes = (List)destination$iv$iv;
        HashMap<String, List<RoomPoi>> map = RoomMeaningScanner.getRoomType$getMap(pois);
        if (map.isEmpty()) {
            return new EmptyRoom(shape);
        }
        if (subtypes.contains("bed")) {
            return new Bedroom(shape, map);
        }
        if (subtypes.contains("stove")) {
            return new Kitchen(shape, map);
        }
        if (subtypes.contains("chair") || subtypes.contains("couch") && subtypes.contains("table")) {
            return new LivingRoom(shape, map);
        }
        if (MiscExt.containsAny(subtypes, UtilityBlockPoiScanner.INSTANCE.getUtilityBlockNames$brokencore_common())) {
            return new CraftingRoom(shape, map);
        }
        Object[] objectArray = new String[]{"barrel", "chest", "double_chest"};
        if (MiscExt.containsAny(subtypes, CollectionsKt.listOf((Object[])objectArray))) {
            return new StorageRoom(shape, map);
        }
        return new GenericRoom(shape, map);
    }

    private static final void iter$updateIterator(RoomMeaningScanner this$0, AABB aabb) {
        BoundingBox box = AabbUtil.getRoundBox(aabb);
        this$0.skipPositions.clear();
        this$0.iter = new CuboidBlockIterator(box.minX(), box.minY(), box.minZ(), box.maxX(), box.maxY(), box.maxZ());
        this$0.pos = this$0.iter.getStartPos();
    }

    private static final void iter$updateBoxes(RoomMeaningScanner this$0) {
        if (!((Collection)this$0.boxes).isEmpty()) {
            this$0.boxes.addAll(this$0.roomShapes.get(this$0.currentRoomIndex).toAabbs());
            AABB aABB = this$0.boxes.peek();
            Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"peek(...)");
            RoomMeaningScanner.iter$updateIterator(this$0, aABB);
        }
    }

    private static final void iter$updateRoom(RoomMeaningScanner this$0) {
        ++this$0.currentRoomIndex;
        if (this$0.currentRoomIndex == this$0.roomShapes.size()) {
            ++this$0.step;
            return;
        }
        RoomMeaningScanner.iter$updateBoxes(this$0);
    }

    /*
     * WARNING - void declaration
     */
    private static final HashMap<String, List<RoomPoi>> getRoomType$getMap(List<RoomPoi> $pois) {
        HashMap<String, List<RoomPoi>> map = new HashMap<String, List<RoomPoi>>();
        for (RoomPoi poi : $pois) {
            Object object;
            void $this$getOrPut$iv;
            boolean needsAdding = false;
            needsAdding = true;
            Map map2 = map;
            String key$iv = poi.getSubtype();
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                boolean bl = false;
                needsAdding = false;
                Object[] objectArray = new RoomPoi[]{poi};
                List answer$iv = CollectionsKt.mutableListOf((Object[])objectArray);
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlin.collections.MutableList<net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi>");
            List list = TypeIntrinsics.asMutableList(object);
            if (!needsAdding) continue;
            list.add(poi);
        }
        return map;
    }
}


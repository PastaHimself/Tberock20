/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.RandomKt
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.AbstractFurnaceBlock
 *  net.minecraft.world.level.block.BarrelBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.CartographyTableBlock
 *  net.minecraft.world.level.block.CraftingTableBlock
 *  net.minecraft.world.level.block.CrossCollisionBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.TransparentBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.SlabType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.RandomKt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CartographyTableBlock;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.debug.renderer.DebugBoxOutline;
import net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0002DEB\u00ee\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012'\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u008d\u0001\b\u0002\u0010\u0012\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001b0\u0013\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\f\u0010;\u001a\u00020\u001b*\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\u0006\u0010B\u001a\u00020\u0011J\b\u0010C\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR2\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0093\u0001\u0010\u0012\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0*X\u0082\u000e\u00a2\u0006\u0002\n\u0000RN\u0010+\u001aB\u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0,0,j \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0,`.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010/\u001a\f\u0012\b\u0012\u000601R\u00020\u000000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u00102\u001a\u001a\u0012\b\u0012\u000601R\u00020\u00000-j\f\u0012\b\u0012\u000601R\u00020\u0000`3X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u00104\u001a\f\u0012\b\u0012\u000601R\u00020\u00000*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00050-j\b\u0012\u0004\u0012\u00020\u0005`3X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001fR\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006F"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "level", "Lnet/minecraft/world/level/Level;", "startPos", "Lnet/minecraft/core/BlockPos;", "maxRecursionDepth", "", "maxFlooderUpdatesPerTick", "minFlooderUpdatesForRecursionIncrement", "callback", "Lkotlin/Function1;", "", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lkotlin/ParameterName;", "name", "shape", "", "statePredicate", "Lkotlin/Function6;", "Lnet/minecraft/world/level/block/state/BlockState;", "neighborState", "state", "Lnet/minecraft/core/Direction;", "dir", "pos", "neighborPos", "", "<init>", "(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;IIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function6;)V", "getMaxRecursionDepth", "()I", "getMaxFlooderUpdatesPerTick", "getMinFlooderUpdatesForRecursionIncrement", "getCallback", "()Lkotlin/jvm/functions/Function1;", "category", "", "getCategory", "()Ljava/lang/String;", "debug", "shapes", "", "floorCeilingPairGroups", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashMap;", "floodersNeedingUpdates", "Ljava/util/Stack;", "Lnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector$Flooder;", "nextFloodersNeedingUpdates", "Lkotlin/collections/HashSet;", "flooders", "positions", "recursionDepth", "value", "step", "getStep", "recursionThresholdCounter", "isDoorLike", "tickDebug", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "tick", "updateFlooders", "Flooder", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nFloodFillRoomDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloodFillRoomDetector.kt\nnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,281:1\n1869#2,2:282\n1878#2,3:288\n216#3:284\n216#3,2:285\n217#3:287\n216#3:291\n216#3,2:292\n217#3:294\n*S KotlinDebug\n*F\n+ 1 FloodFillRoomDetector.kt\nnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector\n*L\n74#1:282,2\n98#1:288,3\n78#1:284\n80#1:285,2\n78#1:287\n111#1:291\n113#1:292,2\n111#1:294\n*E\n"})
public final class FloodFillRoomDetector
implements Debuggable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Level level;
    private final int maxRecursionDepth;
    private final int maxFlooderUpdatesPerTick;
    private final int minFlooderUpdatesForRecursionIncrement;
    @NotNull
    private final Function1<List<? extends VoxelShape>, Unit> callback;
    @NotNull
    private final Function6<BlockState, BlockState, Direction, BlockPos, BlockPos, Level, Boolean> statePredicate;
    @NotNull
    private final String category;
    private boolean debug;
    @NotNull
    private List<VoxelShape> shapes;
    @NotNull
    private final HashMap<BlockPos, HashMap<BlockPos, HashSet<Integer>>> floorCeilingPairGroups;
    @NotNull
    private Stack<Flooder> floodersNeedingUpdates;
    @NotNull
    private HashSet<Flooder> nextFloodersNeedingUpdates;
    @NotNull
    private List<Flooder> flooders;
    @NotNull
    private HashSet<BlockPos> positions;
    private int recursionDepth;
    private int step;
    private int recursionThresholdCounter;

    public FloodFillRoomDetector(@NotNull Level level, @NotNull BlockPos startPos, int maxRecursionDepth, int maxFlooderUpdatesPerTick, int minFlooderUpdatesForRecursionIncrement, @NotNull Function1<? super List<? extends VoxelShape>, Unit> callback, @NotNull Function6<? super BlockState, ? super BlockState, ? super Direction, ? super BlockPos, ? super BlockPos, ? super Level, Boolean> statePredicate) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        Intrinsics.checkNotNullParameter(statePredicate, (String)"statePredicate");
        this.level = level;
        this.maxRecursionDepth = maxRecursionDepth;
        this.maxFlooderUpdatesPerTick = maxFlooderUpdatesPerTick;
        this.minFlooderUpdatesForRecursionIncrement = minFlooderUpdatesForRecursionIncrement;
        this.callback = callback;
        this.statePredicate = statePredicate;
        this.category = "floodfill";
        this.shapes = new ArrayList();
        this.floorCeilingPairGroups = new HashMap();
        this.floodersNeedingUpdates = new Stack();
        this.nextFloodersNeedingUpdates = new HashSet();
        this.flooders = new ArrayList();
        this.positions = new HashSet();
        for (Direction dir : EntriesMappings.entries$0) {
            BlockPos blockPos = startPos.offset(dir.getNormal());
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            Direction direction = dir.getOpposite();
            Intrinsics.checkNotNullExpressionValue((Object)direction, (String)"getOpposite(...)");
            Flooder flooder = new Flooder(blockPos, direction, 0, startPos);
            this.floodersNeedingUpdates.add(flooder);
            this.flooders.add(flooder);
        }
    }

    public /* synthetic */ FloodFillRoomDetector(Level level, BlockPos blockPos, int n, int n2, int n3, Function1 function1, Function6 function6, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            n = 64;
        }
        if ((n4 & 8) != 0) {
            n2 = 64;
        }
        if ((n4 & 0x10) != 0) {
            n3 = 16;
        }
        if ((n4 & 0x40) != 0) {
            function6 = (Function6)new Function6<BlockState, BlockState, Direction, BlockPos, BlockPos, Level, Boolean>((Object)Companion){

                public final Boolean invoke(BlockState p0, BlockState p1, Direction p2, BlockPos p3, BlockPos p4, Level p5) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                    Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                    Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                    Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                    Intrinsics.checkNotNullParameter((Object)p5, (String)"p5");
                    return ((Companion)this.receiver).defaultPredicate(p0, p1, p2, p3, p4, p5);
                }
            };
        }
        this(level, blockPos, n, n2, n3, (Function1<? super List<? extends VoxelShape>, Unit>)function1, (Function6<? super BlockState, ? super BlockState, ? super Direction, ? super BlockPos, ? super BlockPos, ? super Level, Boolean>)function6);
    }

    public final int getMaxRecursionDepth() {
        return this.maxRecursionDepth;
    }

    public final int getMaxFlooderUpdatesPerTick() {
        return this.maxFlooderUpdatesPerTick;
    }

    public final int getMinFlooderUpdatesForRecursionIncrement() {
        return this.minFlooderUpdatesForRecursionIncrement;
    }

    @NotNull
    public final Function1<List<? extends VoxelShape>, Unit> getCallback() {
        return this.callback;
    }

    @Override
    @NotNull
    public String getCategory() {
        return this.category;
    }

    public final int getStep() {
        return this.step;
    }

    private final boolean isDoorLike(BlockState $this$isDoorLike) {
        return $this$isDoorLike.getBlock() instanceof DoorBlock;
    }

    @Override
    public void tickDebug() {
        this.debug = true;
        this.tick();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        block6: {
            block5: {
                Object element$iv2;
                Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
                Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
                if (this.step >= 2) break block5;
                ArrayList copy = new ArrayList(this.flooders);
                Iterable $this$forEach$iv = copy;
                boolean $i$f$forEach = false;
                for (Object element$iv2 : $this$forEach$iv) {
                    Flooder it = (Flooder)element$iv2;
                    boolean bl = false;
                    new DebugBoxOutline(new AABB(it.getPos()), 1.0, 1.0f, 0.0f, 0.0f).render(poseStack, buffer);
                }
                HashMap copy2 = new HashMap(this.floorCeilingPairGroups);
                Map $this$forEach$iv2 = copy2;
                boolean $i$f$forEach2 = false;
                element$iv2 = $this$forEach$iv2.entrySet().iterator();
                while (element$iv2.hasNext()) {
                    Map.Entry element$iv3;
                    Map.Entry bl = element$iv3 = (Map.Entry)element$iv2.next();
                    boolean bl2 = false;
                    HashMap map = (HashMap)bl.getValue();
                    HashMap copy3 = new HashMap(map);
                    Map $this$forEach$iv3 = copy3;
                    boolean $i$f$forEach3 = false;
                    Iterator iterator = $this$forEach$iv3.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry element$iv4;
                        Map.Entry it = element$iv4 = iterator.next();
                        boolean bl3 = false;
                        int n = ((BlockPos)it.getKey()).getX();
                        Object v = it.getValue();
                        Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
                        int n2 = ((Number)CollectionsKt.first((Iterable)((Iterable)v))).intValue();
                        Object v2 = it.getValue();
                        Intrinsics.checkNotNullExpressionValue(v2, (String)"<get-value>(...)");
                        int n3 = ((Number)CollectionsKt.last((Iterable)((Iterable)v2))).intValue();
                        new DebugBoxOutline(new AABB(new BlockPos(n, Math.min(n2, n3), ((BlockPos)it.getKey()).getZ())), 1.0, 0.0f, 1.0f, 0.0f).render(poseStack, buffer);
                        int n4 = ((BlockPos)it.getKey()).getX();
                        Object v3 = it.getValue();
                        Intrinsics.checkNotNullExpressionValue(v3, (String)"<get-value>(...)");
                        n2 = ((Number)CollectionsKt.first((Iterable)((Iterable)v3))).intValue();
                        Object v4 = it.getValue();
                        Intrinsics.checkNotNullExpressionValue(v4, (String)"<get-value>(...)");
                        n3 = ((Number)CollectionsKt.last((Iterable)((Iterable)v4))).intValue();
                        new DebugBoxOutline(new AABB(new BlockPos(n4, Math.max(n2, n3), ((BlockPos)it.getKey()).getZ())), 1.0, 0.0f, 0.0f, 1.0f).render(poseStack, buffer);
                    }
                }
                break block6;
            }
            if (this.step != 3) break block6;
            Iterable $this$forEachIndexed$iv = this.shapes;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                void shape;
                int n;
                if ((n = index$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                VoxelShape bl = (VoxelShape)item$iv;
                int index = n;
                boolean bl4 = false;
                float r = RandomKt.Random((int)(index + 1)).nextFloat();
                float g = RandomKt.Random((int)(index + 2)).nextFloat();
                float b = RandomKt.Random((int)(index + 3)).nextFloat();
                VoxelShapeExtKt.renderLines((VoxelShape)shape, buffer, poseStack, r, g, b);
            }
        }
    }

    public final void tick() {
        switch (this.step) {
            case 0: {
                this.updateFlooders();
                break;
            }
            case 1: {
                Map $this$forEach$iv = this.floorCeilingPairGroups;
                boolean $i$f$forEach = false;
                Iterator iterator = $this$forEach$iv.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry element$iv;
                    Map.Entry entry = element$iv = iterator.next();
                    boolean bl = false;
                    HashMap map = (HashMap)entry.getValue();
                    VoxelShape shape = null;
                    shape = Shapes.empty();
                    Map $this$forEach$iv2 = map;
                    boolean $i$f$forEach2 = false;
                    Iterator iterator2 = $this$forEach$iv2.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        Map.Entry element$iv2;
                        Map.Entry entry2 = element$iv2 = iterator2.next();
                        boolean bl2 = false;
                        BlockPos pair = (BlockPos)entry2.getKey();
                        HashSet ints = (HashSet)entry2.getValue();
                        if (ints.size() <= 1) continue;
                        double minY = Math.min(((Number)CollectionsKt.first((Iterable)ints)).intValue(), ((Number)CollectionsKt.last((Iterable)ints)).intValue());
                        double maxY = Math.max(((Number)CollectionsKt.first((Iterable)ints)).intValue(), ((Number)CollectionsKt.last((Iterable)ints)).intValue());
                        double x = pair.getX();
                        double z = pair.getZ();
                        VoxelShape box = Shapes.box((double)x, (double)minY, (double)z, (double)(x + 1.0), (double)(maxY + 1.0), (double)(z + 1.0));
                        shape = shape == null ? box : Shapes.join((VoxelShape)box, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
                    }
                    VoxelShape voxelShape = shape;
                    Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"element");
                    this.shapes.add(voxelShape);
                }
                if (!this.debug) {
                    this.floorCeilingPairGroups.clear();
                }
                ++this.step;
                break;
            }
            case 2: {
                this.step = 3;
                this.callback.invoke(this.shapes);
            }
        }
    }

    private final void updateFlooders() {
        int i;
        if (!((Collection)this.floodersNeedingUpdates).isEmpty()) {
            for (i = 0; i < this.maxFlooderUpdatesPerTick && !((Collection)this.floodersNeedingUpdates).isEmpty(); ++i) {
                Flooder flooder = this.floodersNeedingUpdates.pop();
                Intrinsics.checkNotNull((Object)flooder);
                Flooder.propagate$default(flooder, 0, 1, null);
            }
        }
        if (this.floodersNeedingUpdates.isEmpty()) {
            ++this.recursionDepth;
            this.floodersNeedingUpdates.addAll((Collection<Flooder>)this.nextFloodersNeedingUpdates);
            this.nextFloodersNeedingUpdates.clear();
        }
        this.recursionThresholdCounter += i;
        if (this.recursionThresholdCounter < this.minFlooderUpdatesForRecursionIncrement && !((Collection)this.floodersNeedingUpdates).isEmpty()) {
            return;
        }
        this.recursionThresholdCounter = 0;
        if (this.recursionDepth > this.maxRecursionDepth || this.flooders.isEmpty() && this.recursionDepth > 1) {
            ++this.step;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector$Companion;", "", "<init>", "()V", "defaultPredicate", "", "neighborState", "Lnet/minecraft/world/level/block/state/BlockState;", "state", "dir", "Lnet/minecraft/core/Direction;", "pos", "Lnet/minecraft/core/BlockPos;", "neighborPos", "level", "Lnet/minecraft/world/level/Level;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final boolean defaultPredicate(BlockState neighborState, BlockState state, Direction dir, BlockPos pos, BlockPos neighborPos, Level level) {
            Block block2 = neighborState.getBlock();
            if (block2 instanceof DoorBlock || block2 instanceof TransparentBlock || block2 instanceof CrossCollisionBlock || block2 instanceof AbstractFurnaceBlock || block2 instanceof CraftingTableBlock || block2 instanceof CartographyTableBlock || block2 instanceof BarrelBlock) {
                return false;
            }
            if (block2 instanceof SlabBlock) {
                return switch (WhenMappings.$EnumSwitchMapping$0[dir.ordinal()]) {
                    case 1 -> {
                        if (neighborState.getValue((Property)BlockStateProperties.SLAB_TYPE) == SlabType.BOTTOM) {
                            yield true;
                        }
                        yield false;
                    }
                    case 2 -> {
                        if (neighborState.getValue((Property)BlockStateProperties.SLAB_TYPE) == SlabType.TOP) {
                            yield true;
                        }
                        yield false;
                    }
                    default -> false;
                };
            }
            return neighborState.isFaceSturdy((BlockGetter)level, neighborPos, dir.getOpposite());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[Direction.values().length];
                try {
                    nArray[Direction.UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Direction.DOWN.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0086\u0010J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector$Flooder;", "", "pos", "Lnet/minecraft/core/BlockPos;", "prevDir", "Lnet/minecraft/core/Direction;", "rotations", "", "roomPos", "<init>", "(Lnet/thebrokenscript/brokencore/api/learner/util/FloodFillRoomDetector;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;ILnet/minecraft/core/BlockPos;)V", "getPos", "()Lnet/minecraft/core/BlockPos;", "getPrevDir", "()Lnet/minecraft/core/Direction;", "getRotations", "()I", "getRoomPos", "hashCode", "propagate", "", "i", "equals", "", "other", "brokencore-common"})
    public final class Flooder {
        @NotNull
        private final BlockPos pos;
        @NotNull
        private final Direction prevDir;
        private final int rotations;
        @NotNull
        private final BlockPos roomPos;

        public Flooder(@NotNull BlockPos pos, Direction prevDir, @NotNull int rotations, BlockPos roomPos) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)prevDir, (String)"prevDir");
            Intrinsics.checkNotNullParameter((Object)roomPos, (String)"roomPos");
            this.pos = pos;
            this.prevDir = prevDir;
            this.rotations = rotations;
            this.roomPos = roomPos;
            FloodFillRoomDetector.this.positions.add(this.pos);
        }

        @NotNull
        public final BlockPos getPos() {
            return this.pos;
        }

        @NotNull
        public final Direction getPrevDir() {
            return this.prevDir;
        }

        public final int getRotations() {
            return this.rotations;
        }

        @NotNull
        public final BlockPos getRoomPos() {
            return this.roomPos;
        }

        public int hashCode() {
            return this.pos.hashCode();
        }

        public final void propagate(int i) {
            Flooder flooder = this;
            while (true) {
                block10: {
                    Object object;
                    boolean isDoor;
                    BlockState state;
                    BlockPos pos;
                    Direction dir;
                    block12: {
                        BlockPos keyPos;
                        Object object2;
                        block13: {
                            HashSet pairList;
                            HashMap group;
                            block14: {
                                int n;
                                block11: {
                                    if (i > 5) {
                                        FloodFillRoomDetector.this.flooders.remove(flooder);
                                        return;
                                    }
                                    dir = (Direction)EntriesMappings.entries$0.get(i);
                                    if (dir == flooder.prevDir) break block10;
                                    pos = flooder.pos.offset(dir.getNormal());
                                    if (FloodFillRoomDetector.this.positions.contains(pos)) {
                                        Flooder flooder2 = flooder;
                                        int n2 = i + 1;
                                        flooder = flooder2;
                                        i = n2;
                                        continue;
                                    }
                                    state = FloodFillRoomDetector.this.level.getBlockState(pos);
                                    Intrinsics.checkNotNull((Object)state);
                                    isDoor = FloodFillRoomDetector.this.isDoorLike(state);
                                    Function6 function6 = FloodFillRoomDetector.this.statePredicate;
                                    BlockState blockState = FloodFillRoomDetector.this.level.getBlockState(flooder.pos);
                                    Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
                                    BlockPos blockPos = flooder.pos;
                                    Intrinsics.checkNotNull((Object)pos);
                                    if (((Boolean)function6.invoke((Object)state, (Object)blockState, (Object)dir, (Object)blockPos, (Object)pos, (Object)FloodFillRoomDetector.this.level)).booleanValue() || isDoor) break block11;
                                    Direction direction = dir.getOpposite();
                                    Intrinsics.checkNotNullExpressionValue((Object)direction, (String)"getOpposite(...)");
                                    Flooder flooder3 = new Flooder(pos, direction, 0, flooder.roomPos);
                                    FloodFillRoomDetector.this.nextFloodersNeedingUpdates.add(flooder3);
                                    FloodFillRoomDetector.this.flooders.add(flooder3);
                                    FloodFillRoomDetector.this.flooders.remove(flooder);
                                    break block10;
                                }
                                if (dir.getAxis() != Direction.Axis.Y || isDoor) break block12;
                                Flooder flooder4 = flooder;
                                object = FloodFillRoomDetector.this;
                                object2 = flooder4;
                                int n3 = flooder.pos.getX();
                                boolean bl = false;
                                if (dir == Direction.UP) {
                                    n = $this$propagate_u24lambda_u240.pos.getY();
                                } else {
                                    int y = 0;
                                    while ($this$propagate_u24lambda_u240.pos.getY() + y > ((FloodFillRoomDetector)object).level.getMinBuildHeight() && $this$propagate_u24lambda_u240.pos.getY() + y < ((FloodFillRoomDetector)object).level.getMaxBuildHeight()) {
                                        BlockPos pos2 = $this$propagate_u24lambda_u240.pos.offset(0, y, 0);
                                        BlockState state2 = ((FloodFillRoomDetector)object).level.getBlockState(pos2);
                                        Function6 function6 = ((FloodFillRoomDetector)object).statePredicate;
                                        Intrinsics.checkNotNull((Object)state2);
                                        Intrinsics.checkNotNull((Object)pos2);
                                        if (((Boolean)function6.invoke((Object)state2, (Object)state2, (Object)dir, (Object)pos2, (Object)pos2, (Object)((FloodFillRoomDetector)object).level)).booleanValue()) break;
                                        ++y;
                                    }
                                    n = pos.getY() + y;
                                }
                                int n4 = n;
                                int n5 = flooder.pos.getZ();
                                int n6 = n4;
                                int n7 = n3;
                                keyPos = new BlockPos(n7, n6, n5);
                                group = (HashMap)FloodFillRoomDetector.this.floorCeilingPairGroups.get(flooder.roomPos);
                                if (group == null) break block13;
                                pairList = (HashSet)group.get(keyPos);
                                if (pairList == null || pairList.size() >= 2) break block14;
                                pairList.add(flooder.pos.getY());
                                break block10;
                            }
                            if (pairList != null) break block10;
                            object2 = group;
                            Object bl = new Integer[]{flooder.pos.getY()};
                            bl = SetsKt.hashSetOf((Object[])bl);
                            object2.put(keyPos, bl);
                            break block10;
                        }
                        object = FloodFillRoomDetector.this.floorCeilingPairGroups;
                        object2 = flooder.roomPos;
                        Object bl = new Pair[1];
                        Object[] y = new Integer[]{flooder.pos.getY()};
                        bl[0] = TuplesKt.to((Object)keyPos, (Object)SetsKt.hashSetOf((Object[])y));
                        bl = MapsKt.hashMapOf((Pair[])bl);
                        object.put(object2, bl);
                        break block10;
                    }
                    if (isDoor && state.getValue((Property)BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER) {
                        BlockPos.MutableBlockPos ofsPos = pos.mutable();
                        int n = FloodFillRoomDetector.this.getMaxRecursionDepth();
                        object = FloodFillRoomDetector.this;
                        for (int j = 0; j < n; ++j) {
                            int it = j;
                            boolean bl = false;
                            BlockState curState = ((FloodFillRoomDetector)object).level.getBlockState((BlockPos)ofsPos);
                            BlockPos lastPos = ofsPos.immutable().offset(dir.getNormal());
                            Intrinsics.checkNotNull((Object)curState);
                            if (!((FloodFillRoomDetector)object).isDoorLike(curState) && !((Map)((FloodFillRoomDetector)object).floorCeilingPairGroups).containsKey(ofsPos.immutable())) {
                                Function6 function6 = ((FloodFillRoomDetector)object).statePredicate;
                                BlockPos blockPos = ofsPos.immutable();
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"immutable(...)");
                                BlockPos blockPos2 = ofsPos.immutable();
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"immutable(...)");
                                if (!((Boolean)function6.invoke((Object)curState, (Object)curState, (Object)dir, (Object)blockPos, (Object)blockPos2, (Object)((FloodFillRoomDetector)object).level)).booleanValue()) {
                                    BlockPos blockPos3 = ofsPos.immutable();
                                    Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"immutable(...)");
                                    Direction direction = dir.getOpposite();
                                    Intrinsics.checkNotNullExpressionValue((Object)direction, (String)"getOpposite(...)");
                                    Intrinsics.checkNotNull((Object)lastPos);
                                    Flooder flooder5 = (FloodFillRoomDetector)object.new Flooder(blockPos3, direction, 0, lastPos);
                                    ((FloodFillRoomDetector)object).nextFloodersNeedingUpdates.add(flooder5);
                                    ((FloodFillRoomDetector)object).flooders.add(flooder5);
                                    ((FloodFillRoomDetector)object).flooders.remove(flooder);
                                    ((Map)((FloodFillRoomDetector)object).floorCeilingPairGroups).put(lastPos, new HashMap());
                                    continue;
                                }
                            }
                            ofsPos.setX(ofsPos.getX() + dir.getNormal().getX());
                            ofsPos.setY(ofsPos.getY() + dir.getNormal().getY());
                            ofsPos.setZ(ofsPos.getZ() + dir.getNormal().getZ());
                        }
                    }
                }
                Flooder flooder6 = flooder;
                int n = i + 1;
                flooder = flooder6;
                i = n;
            }
        }

        public static /* synthetic */ void propagate$default(Flooder flooder, int n, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = 0;
            }
            flooder.propagate(n);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            Object object = other;
            if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
                return false;
            }
            Object object2 = other;
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.learner.util.FloodFillRoomDetector.Flooder");
            Flooder cfr_ignored_0 = (Flooder)object2;
            if (this.rotations != ((Flooder)other).rotations) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.pos, (Object)((Flooder)other).pos)) {
                return false;
            }
            return this.prevDir == ((Flooder)other).prevDir;
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class EntriesMappings {
            public static final /* synthetic */ EnumEntries<Direction> entries$0;

            static {
                entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
            }
        }
    }
}


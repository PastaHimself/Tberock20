/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.AnvilBlock
 *  net.minecraft.world.level.block.BlastFurnaceBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BrewingStandBlock
 *  net.minecraft.world.level.block.CartographyTableBlock
 *  net.minecraft.world.level.block.CauldronBlock
 *  net.minecraft.world.level.block.CraftingTableBlock
 *  net.minecraft.world.level.block.EnchantingTableBlock
 *  net.minecraft.world.level.block.FurnaceBlock
 *  net.minecraft.world.level.block.GrindstoneBlock
 *  net.minecraft.world.level.block.LoomBlock
 *  net.minecraft.world.level.block.SmithingTableBlock
 *  net.minecraft.world.level.block.SmokerBlock
 *  net.minecraft.world.level.block.StonecutterBlock
 *  net.minecraft.world.level.block.TorchBlock
 *  net.minecraft.world.level.block.WallTorchBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrewingStandBlock;
import net.minecraft.world.level.block.CartographyTableBlock;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.GrindstoneBlock;
import net.minecraft.world.level.block.LoomBlock;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J8\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001aj\b\u0012\u0004\u0012\u00020\u0012`\u001bH\u0016R(\u0010\u0004\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/UtilityBlockPoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "utilityBlocks", "", "Ljava/lang/Class;", "Lnet/minecraft/world/level/block/Block;", "", "getUtilityBlocks$brokencore_common", "()Ljava/util/Map;", "utilityBlockNames", "", "getUtilityBlockNames$brokencore_common", "()Ljava/util/Collection;", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nUtilityBlockPoiScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtilityBlockPoiScanner.kt\nnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/UtilityBlockPoiScanner\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,73:1\n216#2,2:74\n*S KotlinDebug\n*F\n+ 1 UtilityBlockPoiScanner.kt\nnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/UtilityBlockPoiScanner\n*L\n57#1:74,2\n*E\n"})
public final class UtilityBlockPoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final UtilityBlockPoiScanner INSTANCE = new UtilityBlockPoiScanner();
    @NotNull
    private static final Map<Class<? extends Block>, String> utilityBlocks;
    @NotNull
    private static final Collection<String> utilityBlockNames;

    private UtilityBlockPoiScanner() {
    }

    @NotNull
    public final Map<Class<? extends Block>, String> getUtilityBlocks$brokencore_common() {
        return utilityBlocks;
    }

    @NotNull
    public final Collection<String> getUtilityBlockNames$brokencore_common() {
        return utilityBlockNames;
    }

    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        boolean passed = false;
        Map<Class<? extends Block>, String> $this$forEach$iv = utilityBlocks;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<Class<? extends Block>, String>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Class<? extends Block>, String> element$iv;
            Map.Entry<Class<? extends Block>, String> entry = element$iv = iterator.next();
            boolean bl = false;
            Class<? extends Block> klass = entry.getKey();
            if (!klass.isInstance(state.getBlock())) continue;
            passed = true;
        }
        return passed;
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        VoxelShape voxelShape = Shapes.create((AABB)new AABB(blockPos));
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"create(...)");
        String string = utilityBlocks.get(state.getBlock().getClass());
        Intrinsics.checkNotNull((Object)string);
        return new RoomPoi(voxelShape, blockPos, string);
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(FurnaceBlock.class, (Object)"furnace"), TuplesKt.to(SmokerBlock.class, (Object)"smoker"), TuplesKt.to(BlastFurnaceBlock.class, (Object)"blast_furnace"), TuplesKt.to(CartographyTableBlock.class, (Object)"cartography_table"), TuplesKt.to(SmithingTableBlock.class, (Object)"smithing_table"), TuplesKt.to(EnchantingTableBlock.class, (Object)"enchanting_table"), TuplesKt.to(LoomBlock.class, (Object)"loom"), TuplesKt.to(GrindstoneBlock.class, (Object)"grindstone"), TuplesKt.to(CauldronBlock.class, (Object)"cauldron"), TuplesKt.to(StonecutterBlock.class, (Object)"stonecutter"), TuplesKt.to(BrewingStandBlock.class, (Object)"brewing_stand"), TuplesKt.to(AnvilBlock.class, (Object)"anvil"), TuplesKt.to(TorchBlock.class, (Object)"torch"), TuplesKt.to(WallTorchBlock.class, (Object)"torch"), TuplesKt.to(CraftingTableBlock.class, (Object)"crafting_table")};
        utilityBlocks = MapsKt.mapOf((Pair[])pairArray);
        utilityBlockNames = utilityBlocks.values();
    }
}


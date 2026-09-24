/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.ArrayDeque
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.blocks.TickedBlock
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.brokencore.api.blocks.TickedBlock;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010 \u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u0015H\u0002J&\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0$2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0015H\u0002R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/block/PhysicalStacktraceBlock;", "Lnet/thebrokenscript/brokencore/api/blocks/TickedBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "getLightBlock", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "worldIn", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "chunkSize", "digPerTick", "infectChance", "", "chunkStates", "", "Lnet/minecraft/world/level/ChunkPos;", "Lnet/thebrokenscript/block/PhysicalStacktraceBlock$ChunkState;", "tick", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "random", "Lnet/minecraft/util/RandomSource;", "findFirstSolidY", "worldX", "worldZ", "startY", "infectColumn", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "generateDigQueue", "Lkotlin/collections/ArrayDeque;", "ChunkState", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPhysicalStacktraceBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhysicalStacktraceBlock.kt\nnet/thebrokenscript/block/PhysicalStacktraceBlock\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n382#2,7:173\n774#3:180\n865#3,2:181\n1011#3,2:183\n*S KotlinDebug\n*F\n+ 1 PhysicalStacktraceBlock.kt\nnet/thebrokenscript/block/PhysicalStacktraceBlock\n*L\n45#1:173,7\n73#1:180\n73#1:181,2\n169#1:183,2\n*E\n"})
public final class PhysicalStacktraceBlock
extends TickedBlock {
    private final int chunkSize;
    private final int digPerTick;
    private final float infectChance;
    @NotNull
    private final Map<ChunkPos, ChunkState> chunkStates;

    public PhysicalStacktraceBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties, 40);
        this.chunkSize = 16;
        this.digPerTick = 1;
        this.infectChance = 0.8f;
        this.chunkStates = new LinkedHashMap();
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 15;
    }

    /*
     * WARNING - void declaration
     */
    protected void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        block14: {
            Object object;
            void $this$getOrPut$iv;
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            super.tick(state, level, pos, random);
            if (TBSConfigs.INSTANCE.getServer().getWorld().getDisableWorldEater()) {
                return;
            }
            ChunkAccess chunk = level.getChunk(pos);
            ChunkPos chunkPos = chunk.getPos();
            Map<ChunkPos, ChunkState> map = this.chunkStates;
            ChunkPos key$iv = chunkPos;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                boolean bl = false;
                ChunkState answer$iv = new ChunkState(null, new ArrayDeque(), false, 0.0f, null, 0L, 61, null);
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            ChunkState chunkState = (ChunkState)object;
            int chunkStartX = chunkPos.x * this.chunkSize;
            int chunkStartZ = chunkPos.z * this.chunkSize;
            int chunkEndX = chunkStartX + this.chunkSize;
            int chunkEndZ = chunkStartZ + this.chunkSize;
            if (!chunkState.getInitialized()) {
                chunkState.setInitialized(true);
                int initialY = this.findFirstSolidY(pos.getX(), pos.getZ(), pos.getY(), level);
                if (initialY >= level.getMinBuildHeight()) {
                    BlockPos blockPos = new BlockPos(pos.getX(), initialY, pos.getZ());
                    Intrinsics.checkNotNull((Object)chunk);
                    this.infectColumn(blockPos, level, chunk, chunkState);
                }
            }
            long currentWorldTick = level.getGameTime();
            if (chunkState.getDiggingQueue().isEmpty() && random.nextFloat() < this.infectChance) {
                void $this$filterTo$iv$iv;
                void $this$filter$iv;
                Object object2 = new BlockPos[]{pos.offset(1, 0, 0), pos.offset(-1, 0, 0), pos.offset(0, 0, 1), pos.offset(0, 0, -1)};
                object2 = CollectionsKt.listOf((Object[])object2);
                boolean $i$f$filter = false;
                void var17_22 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    BlockPos it = (BlockPos)element$iv$iv;
                    boolean bl = false;
                    Intrinsics.checkNotNull((Object)it);
                    if (!PhysicalStacktraceBlock.tick$inSameChunk(chunkStartX, chunkEndX, chunkStartZ, chunkEndZ, it)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                List neighborPositions = (List)destination$iv$iv;
                if (!((Collection)neighborPositions).isEmpty()) {
                    BlockPos targetPos = (BlockPos)neighborPositions.get(random.nextInt(neighborPositions.size()));
                    int surfaceY = this.findFirstSolidY(targetPos.getX(), targetPos.getZ(), targetPos.getY(), level);
                    BlockPos candidatePos = new BlockPos(targetPos.getX(), surfaceY, targetPos.getZ());
                    BlockState state2 = level.getBlockState(candidatePos);
                    if (!state2.isAir() && !state2.canBeReplaced()) {
                        Intrinsics.checkNotNull((Object)chunk);
                        this.infectColumn(candidatePos, level, chunk, chunkState);
                    }
                }
            }
            if (chunkState.getConvertedColumns().size() >= this.chunkSize * this.chunkSize && chunkState.getDiggingQueue().isEmpty()) {
                ArrayDeque<BlockPos> arrayDeque = chunkState.getDiggingQueue();
                Intrinsics.checkNotNull((Object)chunk);
                arrayDeque.addAll((Collection)this.generateDigQueue(chunk, level, chunkState));
                chunkState.setDigStartTick(currentWorldTick + 100L);
            }
            Long l = chunkState.getDigStartTick();
            if (l == null) break block14;
            long digStartTick = ((Number)l).longValue();
            boolean bl = false;
            if (currentWorldTick >= digStartTick) {
                if (chunkState.getLastDigTick() != currentWorldTick) {
                    if (random.nextFloat() <= 0.15f && chunkState.getDigChance() < 0.6f) {
                        chunkState.setDigChance(chunkState.getDigChance() + 0.15f);
                    }
                    chunkState.setLastDigTick(currentWorldTick);
                }
                int n = this.digPerTick;
                for (int i = 0; i < n; ++i) {
                    BlockPos nextDigPos;
                    BlockState stateAtPos;
                    int it = i;
                    boolean bl2 = false;
                    if (!(random.nextFloat() <= chunkState.getDigChance()) || (BlockPos)chunkState.getDiggingQueue().removeFirstOrNull() == null || (stateAtPos = level.getBlockState(nextDigPos)).isAir()) continue;
                    level.setBlock(nextDigPos, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }
    }

    private final int findFirstSolidY(int worldX, int worldZ, int startY, ServerLevel level) {
        for (int y = RangesKt.coerceAtMost((int)startY, (int)(level.getMaxBuildHeight() - 1)); y >= level.getMinBuildHeight(); --y) {
            if (level.getBlockState(new BlockPos(worldX, y, worldZ)).isAir()) continue;
            return y;
        }
        return level.getMinBuildHeight() - 1;
    }

    private final void infectColumn(BlockPos pos, ServerLevel level, ChunkAccess chunk, ChunkState state) {
        Pair local;
        block6: {
            block5: {
                int startX = chunk.getPos().x * this.chunkSize;
                int startZ = chunk.getPos().z * this.chunkSize;
                local = new Pair((Object)(pos.getX() - startX), (Object)(pos.getZ() - startZ));
                int n = this.chunkSize;
                int n2 = ((Number)local.getFirst()).intValue();
                boolean bl = 0 <= n2 ? n2 < n : false;
                if (!bl) break block5;
                n = this.chunkSize;
                n2 = ((Number)local.getSecond()).intValue();
                if (0 <= n2 ? n2 < n : false) break block6;
            }
            return;
        }
        if (state.getConvertedColumns().contains(local)) {
            return;
        }
        int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ()) - 1;
        for (int y = RangesKt.coerceAtMost((int)surfaceY, (int)(level.getMaxBuildHeight() - 1)); y >= level.getMinBuildHeight(); --y) {
            BlockPos bp = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState st = level.getBlockState(bp);
            if (st.isAir() && !st.is((Block)TBSBlocks.PHYSICAL_STACKTRACE.get())) continue;
            level.setBlock(bp, ((PhysicalStacktraceBlock)((Object)TBSBlocks.PHYSICAL_STACKTRACE.get())).defaultBlockState(), 3);
        }
        state.getConvertedColumns().add((Pair<Integer, Integer>)local);
    }

    private final ArrayDeque<BlockPos> generateDigQueue(ChunkAccess chunk, ServerLevel level, ChunkState state) {
        int startX = chunk.getPos().x * this.chunkSize;
        int startZ = chunk.getPos().z * this.chunkSize;
        int centerX = startX + this.chunkSize / 2;
        int centerZ = startZ + this.chunkSize / 2;
        List positions = new ArrayList();
        block0: for (Pair<Integer, Integer> pair : state.getConvertedColumns()) {
            int y;
            int localX = ((Number)pair.component1()).intValue();
            int localZ = ((Number)pair.component2()).intValue();
            int worldX = startX + localX;
            int worldZ = startZ + localZ;
            for (y = level.getMaxBuildHeight() - 1; y >= level.getMinBuildHeight() && !level.getBlockState(new BlockPos(worldX, y, worldZ)).is((Block)TBSBlocks.PHYSICAL_STACKTRACE.get()); --y) {
            }
            if (y < level.getMinBuildHeight()) continue;
            int yy = y;
            int n = level.getMinBuildHeight();
            if (n > yy) continue;
            while (true) {
                positions.add(new BlockPos(worldX, yy, worldZ));
                if (yy == n) continue block0;
                --yy;
            }
        }
        List $this$sortBy$iv = positions;
        boolean $i$f$sortBy = false;
        if ($this$sortBy$iv.size() > 1) {
            CollectionsKt.sortWith((List)$this$sortBy$iv, (Comparator)new Comparator(centerX, centerZ){
                final /* synthetic */ int $centerX$inlined;
                final /* synthetic */ int $centerZ$inlined;
                {
                    this.$centerX$inlined = n;
                    this.$centerZ$inlined = n2;
                }

                public final int compare(T a, T b) {
                    BlockPos it = (BlockPos)a;
                    boolean bl = false;
                    Comparable comparable = Integer.valueOf(Math.abs(it.getX() - this.$centerX$inlined) + Math.abs(it.getZ() - this.$centerZ$inlined));
                    it = (BlockPos)b;
                    Comparable comparable2 = comparable;
                    bl = false;
                    return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(Math.abs(it.getX() - this.$centerX$inlined) + Math.abs(it.getZ() - this.$centerZ$inlined)));
                }
            });
        }
        return new ArrayDeque((Collection)positions);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean tick$inSameChunk(int chunkStartX, int chunkEndX, int chunkStartZ, int chunkEndZ, BlockPos pos) {
        int n = pos.getX();
        if (chunkStartX > n) return false;
        if (n >= chunkEndX) return false;
        boolean bl = true;
        if (!bl) return false;
        n = pos.getZ();
        if (chunkStartZ > n) return false;
        if (n >= chunkEndZ) return false;
        return true;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\fH\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\t\u0010,\u001a\u00020\u000eH\u00c6\u0003Jd\u0010-\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00064"}, d2={"Lnet/thebrokenscript/block/PhysicalStacktraceBlock$ChunkState;", "", "convertedColumns", "", "Lkotlin/Pair;", "", "diggingQueue", "Lkotlin/collections/ArrayDeque;", "Lnet/minecraft/core/BlockPos;", "initialized", "", "digChance", "", "digStartTick", "", "lastDigTick", "<init>", "(Ljava/util/Set;Lkotlin/collections/ArrayDeque;ZFLjava/lang/Long;J)V", "getConvertedColumns", "()Ljava/util/Set;", "getDiggingQueue", "()Lkotlin/collections/ArrayDeque;", "getInitialized", "()Z", "setInitialized", "(Z)V", "getDigChance", "()F", "setDigChance", "(F)V", "getDigStartTick", "()Ljava/lang/Long;", "setDigStartTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastDigTick", "()J", "setLastDigTick", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/Set;Lkotlin/collections/ArrayDeque;ZFLjava/lang/Long;J)Lnet/thebrokenscript/block/PhysicalStacktraceBlock$ChunkState;", "equals", "other", "hashCode", "toString", "", "thebrokenscript-common"})
    public static final class ChunkState {
        @NotNull
        private final Set<Pair<Integer, Integer>> convertedColumns;
        @NotNull
        private final ArrayDeque<BlockPos> diggingQueue;
        private boolean initialized;
        private float digChance;
        @Nullable
        private Long digStartTick;
        private long lastDigTick;

        public ChunkState(@NotNull Set<Pair<Integer, Integer>> convertedColumns, @NotNull ArrayDeque<BlockPos> diggingQueue, boolean initialized, float digChance, @Nullable Long digStartTick, long lastDigTick) {
            Intrinsics.checkNotNullParameter(convertedColumns, (String)"convertedColumns");
            Intrinsics.checkNotNullParameter(diggingQueue, (String)"diggingQueue");
            this.convertedColumns = convertedColumns;
            this.diggingQueue = diggingQueue;
            this.initialized = initialized;
            this.digChance = digChance;
            this.digStartTick = digStartTick;
            this.lastDigTick = lastDigTick;
        }

        public /* synthetic */ ChunkState(Set set, ArrayDeque arrayDeque, boolean bl, float f, Long l, long l2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                set = new LinkedHashSet();
            }
            if ((n & 2) != 0) {
                arrayDeque = new ArrayDeque();
            }
            if ((n & 4) != 0) {
                bl = false;
            }
            if ((n & 8) != 0) {
                f = 0.15f;
            }
            if ((n & 0x10) != 0) {
                l = null;
            }
            if ((n & 0x20) != 0) {
                l2 = -1L;
            }
            this(set, (ArrayDeque<BlockPos>)arrayDeque, bl, f, l, l2);
        }

        @NotNull
        public final Set<Pair<Integer, Integer>> getConvertedColumns() {
            return this.convertedColumns;
        }

        @NotNull
        public final ArrayDeque<BlockPos> getDiggingQueue() {
            return this.diggingQueue;
        }

        public final boolean getInitialized() {
            return this.initialized;
        }

        public final void setInitialized(boolean bl) {
            this.initialized = bl;
        }

        public final float getDigChance() {
            return this.digChance;
        }

        public final void setDigChance(float f) {
            this.digChance = f;
        }

        @Nullable
        public final Long getDigStartTick() {
            return this.digStartTick;
        }

        public final void setDigStartTick(@Nullable Long l) {
            this.digStartTick = l;
        }

        public final long getLastDigTick() {
            return this.lastDigTick;
        }

        public final void setLastDigTick(long l) {
            this.lastDigTick = l;
        }

        @NotNull
        public final Set<Pair<Integer, Integer>> component1() {
            return this.convertedColumns;
        }

        @NotNull
        public final ArrayDeque<BlockPos> component2() {
            return this.diggingQueue;
        }

        public final boolean component3() {
            return this.initialized;
        }

        public final float component4() {
            return this.digChance;
        }

        @Nullable
        public final Long component5() {
            return this.digStartTick;
        }

        public final long component6() {
            return this.lastDigTick;
        }

        @NotNull
        public final ChunkState copy(@NotNull Set<Pair<Integer, Integer>> convertedColumns, @NotNull ArrayDeque<BlockPos> diggingQueue, boolean initialized, float digChance, @Nullable Long digStartTick, long lastDigTick) {
            Intrinsics.checkNotNullParameter(convertedColumns, (String)"convertedColumns");
            Intrinsics.checkNotNullParameter(diggingQueue, (String)"diggingQueue");
            return new ChunkState(convertedColumns, diggingQueue, initialized, digChance, digStartTick, lastDigTick);
        }

        public static /* synthetic */ ChunkState copy$default(ChunkState chunkState, Set set, ArrayDeque arrayDeque, boolean bl, float f, Long l, long l2, int n, Object object) {
            if ((n & 1) != 0) {
                set = chunkState.convertedColumns;
            }
            if ((n & 2) != 0) {
                arrayDeque = chunkState.diggingQueue;
            }
            if ((n & 4) != 0) {
                bl = chunkState.initialized;
            }
            if ((n & 8) != 0) {
                f = chunkState.digChance;
            }
            if ((n & 0x10) != 0) {
                l = chunkState.digStartTick;
            }
            if ((n & 0x20) != 0) {
                l2 = chunkState.lastDigTick;
            }
            return chunkState.copy(set, arrayDeque, bl, f, l, l2);
        }

        @NotNull
        public String toString() {
            return "ChunkState(convertedColumns=" + this.convertedColumns + ", diggingQueue=" + this.diggingQueue + ", initialized=" + this.initialized + ", digChance=" + this.digChance + ", digStartTick=" + this.digStartTick + ", lastDigTick=" + this.lastDigTick + ")";
        }

        public int hashCode() {
            int result = ((Object)this.convertedColumns).hashCode();
            result = result * 31 + this.diggingQueue.hashCode();
            result = result * 31 + Boolean.hashCode(this.initialized);
            result = result * 31 + Float.hashCode(this.digChance);
            result = result * 31 + (this.digStartTick == null ? 0 : ((Object)this.digStartTick).hashCode());
            result = result * 31 + Long.hashCode(this.lastDigTick);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChunkState)) {
                return false;
            }
            ChunkState chunkState = (ChunkState)other;
            if (!Intrinsics.areEqual(this.convertedColumns, chunkState.convertedColumns)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.diggingQueue, chunkState.diggingQueue)) {
                return false;
            }
            if (this.initialized != chunkState.initialized) {
                return false;
            }
            if (Float.compare(this.digChance, chunkState.digChance) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.digStartTick, (Object)chunkState.digStartTick)) {
                return false;
            }
            return this.lastDigTick == chunkState.lastDigTick;
        }

        public ChunkState() {
            this(null, null, false, 0.0f, null, 0L, 63, null);
        }
    }
}


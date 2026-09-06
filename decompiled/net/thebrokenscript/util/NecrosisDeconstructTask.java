/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.block.Blocks
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000eJ\u0006\u0010\u0010\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/util/NecrosisDeconstructTask;", "", "<init>", "()V", "activeJobs", "", "Lnet/thebrokenscript/util/NecrosisDeconstructTask$Job;", "TICKS_PER_BLOCK", "", "start", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "paths", "", "Lnet/minecraft/core/BlockPos;", "tick", "Job", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNecrosisDeconstructTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NecrosisDeconstructTask.kt\nnet/thebrokenscript/util/NecrosisDeconstructTask\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1563#2:96\n1634#2,3:97\n*S KotlinDebug\n*F\n+ 1 NecrosisDeconstructTask.kt\nnet/thebrokenscript/util/NecrosisDeconstructTask\n*L\n47#1:96\n47#1:97,3\n*E\n"})
public final class NecrosisDeconstructTask {
    @NotNull
    public static final NecrosisDeconstructTask INSTANCE = new NecrosisDeconstructTask();
    @NotNull
    private static final List<Job> activeJobs = new ArrayList();
    private static final int TICKS_PER_BLOCK = 2;

    private NecrosisDeconstructTask() {
    }

    /*
     * WARNING - void declaration
     */
    public final void start(@NotNull ServerLevel level, @NotNull List<? extends List<? extends BlockPos>> paths) {
        int n;
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(paths, (String)"paths");
        if (paths.isEmpty()) {
            return;
        }
        Iterable $this$map$iv = paths;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            List list = (List)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(CollectionsKt.reversed((Iterable)((Iterable)it)));
        }
        List reversedPaths = (List)destination$iv$iv;
        int n2 = 0;
        int n3 = reversedPaths.size();
        int[] nArray = new int[n3];
        List list = reversedPaths;
        ServerLevel serverLevel = level;
        while (n2 < n3) {
            n = n2++;
            nArray[n] = -1;
        }
        int[] nArray2 = nArray;
        n2 = 0;
        n3 = reversedPaths.size();
        nArray = new int[n3];
        int[] nArray3 = nArray2;
        while (n2 < n3) {
            n = n2++;
            nArray[n] = 0;
        }
        int[] nArray4 = nArray;
        int[] nArray5 = nArray3;
        List list2 = list;
        ServerLevel serverLevel2 = serverLevel;
        Job job = new Job(serverLevel2, list2, nArray5, nArray4);
        activeJobs.add(job);
    }

    public final void tick() {
        Iterator<Job> jobIterator = activeJobs.iterator();
        while (jobIterator.hasNext()) {
            Job job = jobIterator.next();
            int n = ((Collection)job.getPaths()).size();
            for (int pathIdx = 0; pathIdx < n; ++pathIdx) {
                int n2;
                int n3;
                int[] nArray;
                List<BlockPos> path = job.getPaths().get(pathIdx);
                if (job.getCursors()[pathIdx] >= path.size()) continue;
                if (job.getCooldowns()[pathIdx] > 0) {
                    nArray = job.getCooldowns();
                    n3 = pathIdx;
                    n2 = nArray[n3];
                    nArray[n3] = n2 + -1;
                    continue;
                }
                nArray = job.getCursors();
                n3 = pathIdx;
                n2 = nArray[n3];
                nArray[n3] = n2 + 1;
                int idx = job.getCursors()[pathIdx];
                if (idx >= path.size()) {
                    int n4 = job.getFinishedCount();
                    job.setFinishedCount(n4 + 1);
                    continue;
                }
                BlockPos pos = path.get(idx);
                if (job.getLevel().getBlockState(pos).is((Holder)TBSBlocks.NECROSIS)) {
                    for (int i = 0; i < 5; ++i) {
                        job.getLevel().setBlock(pos.below(i), Blocks.AIR.defaultBlockState(), 3);
                    }
                }
                job.getCooldowns()[pathIdx] = 2;
            }
            if (job.getFinishedCount() < job.getPaths().size()) continue;
            jobIterator.remove();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/util/NecrosisDeconstructTask$Job;", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "paths", "", "Lnet/minecraft/core/BlockPos;", "cursors", "", "cooldowns", "<init>", "(Lnet/minecraft/server/level/ServerLevel;Ljava/util/List;[I[I)V", "getLevel", "()Lnet/minecraft/server/level/ServerLevel;", "getPaths", "()Ljava/util/List;", "getCursors", "()[I", "getCooldowns", "finishedCount", "", "getFinishedCount", "()I", "setFinishedCount", "(I)V", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "", "thebrokenscript-common"})
    private static final class Job {
        @NotNull
        private final ServerLevel level;
        @NotNull
        private final List<List<BlockPos>> paths;
        @NotNull
        private final int[] cursors;
        @NotNull
        private final int[] cooldowns;
        private int finishedCount;

        public Job(@NotNull ServerLevel level, @NotNull List<? extends List<? extends BlockPos>> paths, @NotNull int[] cursors, @NotNull int[] cooldowns) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter(paths, (String)"paths");
            Intrinsics.checkNotNullParameter((Object)cursors, (String)"cursors");
            Intrinsics.checkNotNullParameter((Object)cooldowns, (String)"cooldowns");
            this.level = level;
            this.paths = paths;
            this.cursors = cursors;
            this.cooldowns = cooldowns;
        }

        @NotNull
        public final ServerLevel getLevel() {
            return this.level;
        }

        @NotNull
        public final List<List<BlockPos>> getPaths() {
            return this.paths;
        }

        @NotNull
        public final int[] getCursors() {
            return this.cursors;
        }

        @NotNull
        public final int[] getCooldowns() {
            return this.cooldowns;
        }

        public final int getFinishedCount() {
            return this.finishedCount;
        }

        public final void setFinishedCount(int n) {
            this.finishedCount = n;
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
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type net.thebrokenscript.util.NecrosisDeconstructTask.Job");
            Job cfr_ignored_0 = (Job)object2;
            if (this.finishedCount != ((Job)other).finishedCount) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.level, (Object)((Job)other).level)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.paths, ((Job)other).paths)) {
                return false;
            }
            if (!Arrays.equals(this.cursors, ((Job)other).cursors)) {
                return false;
            }
            return Arrays.equals(this.cooldowns, ((Job)other).cooldowns);
        }

        public int hashCode() {
            int result = this.finishedCount;
            result = 31 * result + this.level.hashCode();
            result = 31 * result + ((Object)this.paths).hashCode();
            result = 31 * result + Arrays.hashCode(this.cursors);
            result = 31 * result + Arrays.hashCode(this.cooldowns);
            return result;
        }

        @NotNull
        public final ServerLevel component1() {
            return this.level;
        }

        @NotNull
        public final List<List<BlockPos>> component2() {
            return this.paths;
        }

        @NotNull
        public final int[] component3() {
            return this.cursors;
        }

        @NotNull
        public final int[] component4() {
            return this.cooldowns;
        }

        @NotNull
        public final Job copy(@NotNull ServerLevel level, @NotNull List<? extends List<? extends BlockPos>> paths, @NotNull int[] cursors, @NotNull int[] cooldowns) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter(paths, (String)"paths");
            Intrinsics.checkNotNullParameter((Object)cursors, (String)"cursors");
            Intrinsics.checkNotNullParameter((Object)cooldowns, (String)"cooldowns");
            return new Job(level, paths, cursors, cooldowns);
        }

        public static /* synthetic */ Job copy$default(Job job, ServerLevel serverLevel, List list, int[] nArray, int[] nArray2, int n, Object object) {
            if ((n & 1) != 0) {
                serverLevel = job.level;
            }
            if ((n & 2) != 0) {
                list = job.paths;
            }
            if ((n & 4) != 0) {
                nArray = job.cursors;
            }
            if ((n & 8) != 0) {
                nArray2 = job.cooldowns;
            }
            return job.copy(serverLevel, list, nArray, nArray2);
        }

        @NotNull
        public String toString() {
            return "Job(level=" + this.level + ", paths=" + this.paths + ", cursors=" + Arrays.toString(this.cursors) + ", cooldowns=" + Arrays.toString(this.cooldowns) + ")";
        }
    }
}


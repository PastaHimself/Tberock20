/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.util;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.learner.util.FloodFillRoomDetector;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.brokencore.api.learner.util.RoomMeaningScanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BT\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/UnfinalizedPlayerBase;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/Level;", "floodFillRecursionDepth", "", "maxFlooderUpdatesPerTick", "minFlooderUpdatesForRecursionIncrement", "callback", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "Lkotlin/ParameterName;", "name", "finalized", "", "<init>", "(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/Level;IIILkotlin/jvm/functions/Function1;)V", "ticking", "step", "done", "", "getDone", "()Z", "category", "", "getCategory", "()Ljava/lang/String;", "tickDebug", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "tick", "brokencore-common"})
public final class UnfinalizedPlayerBase
implements Debuggable {
    @Nullable
    private Debuggable ticking;
    private volatile int step;
    @NotNull
    private final String category;

    public UnfinalizedPlayerBase(@NotNull BlockPos pos, @NotNull Level level, int floodFillRecursionDepth, int maxFlooderUpdatesPerTick, int minFlooderUpdatesForRecursionIncrement, @NotNull Function1<? super PlayerBase, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        this.ticking = new FloodFillRoomDetector(level, pos, floodFillRecursionDepth, maxFlooderUpdatesPerTick, minFlooderUpdatesForRecursionIncrement, arg_0 -> UnfinalizedPlayerBase.ticking$lambda$0(this, level, maxFlooderUpdatesPerTick, callback, arg_0), null, 64, null);
        this.category = "player_base";
    }

    public final boolean getDone() {
        return this.step == 2;
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
        block1: {
            Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            if (this.step >= 2) break block1;
            Debuggable debuggable = this.ticking;
            if (debuggable != null) {
                debuggable.renderDebug(poseStack, buffer);
            }
        }
    }

    public final void tick() {
    }

    private static final Unit ticking$lambda$0(UnfinalizedPlayerBase this$0, Level $level, int $maxFlooderUpdatesPerTick, Function1 $callback, List it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        int n = this$0.step;
        this$0.step = n + 1;
        this$0.ticking = new RoomMeaningScanner(it, $level, $maxFlooderUpdatesPerTick, (Function1<? super PlayerBase, Unit>)((Function1)arg_0 -> UnfinalizedPlayerBase.ticking$lambda$0$0(this$0, $callback, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit ticking$lambda$0$0(UnfinalizedPlayerBase this$0, Function1 $callback, PlayerBase base) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        int n = this$0.step;
        this$0.step = n + 1;
        $callback.invoke((Object)base);
        return Unit.INSTANCE;
    }
}


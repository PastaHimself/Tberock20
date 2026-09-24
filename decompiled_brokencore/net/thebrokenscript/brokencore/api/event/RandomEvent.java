/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0004\u0010\u0007J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H$J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "", "weight", "", "<init>", "(F)V", "", "(Ljava/lang/Number;)V", "getWeight", "()F", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "canExecute", "", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "run", "queue", "afterTicks", "", "action", "Lkotlin/Function0;", "brokencore-common"})
public abstract class RandomEvent {
    private final float weight;
    private ServerLevel level;
    private ServerPlayer player;

    public RandomEvent(float weight) {
        this.weight = weight;
    }

    public final float getWeight() {
        return this.weight;
    }

    public RandomEvent(@NotNull Number weight) {
        Intrinsics.checkNotNullParameter((Object)weight, (String)"weight");
        this(weight.floatValue());
    }

    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return true;
    }

    public static /* synthetic */ boolean canExecute$default(RandomEvent randomEvent, ServerLevel serverLevel, ServerPlayer serverPlayer, Vec3 vec3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canExecute");
        }
        if ((n & 4) != 0) {
            Vec3 vec32 = serverPlayer.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        return randomEvent.canExecute(serverLevel, serverPlayer, vec3);
    }

    protected abstract void execute(@NotNull ServerLevel var1, @NotNull ServerPlayer var2, @NotNull Vec3 var3);

    public static /* synthetic */ void execute$default(RandomEvent randomEvent, ServerLevel serverLevel, ServerPlayer serverPlayer, Vec3 vec3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((n & 4) != 0) {
            Vec3 vec32 = serverPlayer.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        randomEvent.execute(serverLevel, serverPlayer, vec3);
    }

    public final void run(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.level = level;
        this.player = player;
        this.execute(level, player, pos);
    }

    public static /* synthetic */ void run$default(RandomEvent randomEvent, ServerLevel serverLevel, ServerPlayer serverPlayer, Vec3 vec3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        if ((n & 4) != 0) {
            Vec3 vec32 = serverPlayer.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        randomEvent.run(serverLevel, serverPlayer, vec3);
    }

    protected final void queue(long afterTicks, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, (String)"action");
        ServerLevel serverLevel = this.level;
        if (serverLevel == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"level");
            serverLevel = null;
        }
        MinecraftServer minecraftServer = serverLevel.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        MinecraftServerExtKt.getQueue(minecraftServer).add(afterTicks, (Function0<Unit>)((Function0)() -> RandomEvent.queue$lambda$0(action)));
    }

    private static final Unit queue$lambda$0(Function0 $action) {
        $action.invoke();
        return Unit.INSTANCE;
    }
}


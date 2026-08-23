/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event.game;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/LevelTickEvents;", "", "<init>", "()V", "PRE", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/LevelTickEvents$Data;", "POST", "Data", "brokencore-common"})
public final class LevelTickEvents {
    @NotNull
    public static final LevelTickEvents INSTANCE = new LevelTickEvents();
    @JvmField
    @NotNull
    public static final GameEvent<Data> PRE = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Data> POST = new GameEvent();

    private LevelTickEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/LevelTickEvents$Data;", "", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/level/Level;)V", "getLevel", "()Lnet/minecraft/world/level/Level;", "brokencore-common"})
    public static class Data {
        @NotNull
        private final Level level;

        public Data(@NotNull Level level) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            this.level = level;
        }

        @NotNull
        public final Level getLevel() {
            return this.level;
        }
    }
}


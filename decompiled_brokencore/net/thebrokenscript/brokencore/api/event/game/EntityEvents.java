/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.event.game;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.event.Cancelable;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/EntityEvents;", "", "<init>", "()V", "MOUNT", "Lnet/thebrokenscript/brokencore/api/event/GameEvent;", "Lnet/thebrokenscript/brokencore/api/event/game/EntityEvents$Mount;", "SPAWN", "Lnet/thebrokenscript/brokencore/api/event/game/EntityEvents$Spawn;", "Spawn", "Mount", "brokencore-common"})
public final class EntityEvents {
    @NotNull
    public static final EntityEvents INSTANCE = new EntityEvents();
    @JvmField
    @NotNull
    public static final GameEvent<Mount> MOUNT = new GameEvent();
    @JvmField
    @NotNull
    public static final GameEvent<Spawn> SPAWN = new GameEvent();

    private EntityEvents() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u001a\u0010\n\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/EntityEvents$Mount;", "Lnet/thebrokenscript/brokencore/api/event/Cancelable;", "mounting", "Lnet/minecraft/world/entity/Entity;", "vehicle", "level", "Lnet/minecraft/world/level/Level;", "isMounting", "", "isDismounting", "canceled", "<init>", "(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/Level;ZZZ)V", "getMounting", "()Lnet/minecraft/world/entity/Entity;", "getVehicle", "getLevel", "()Lnet/minecraft/world/level/Level;", "()Z", "getCanceled", "setCanceled", "(Z)V", "brokencore-common"})
    public static class Mount
    implements Cancelable {
        @NotNull
        private final Entity mounting;
        @NotNull
        private final Entity vehicle;
        @NotNull
        private final Level level;
        private final boolean isMounting;
        private final boolean isDismounting;
        private boolean canceled;

        public Mount(@NotNull Entity mounting, @NotNull Entity vehicle, @NotNull Level level, boolean isMounting, boolean isDismounting, boolean canceled) {
            Intrinsics.checkNotNullParameter((Object)mounting, (String)"mounting");
            Intrinsics.checkNotNullParameter((Object)vehicle, (String)"vehicle");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            this.mounting = mounting;
            this.vehicle = vehicle;
            this.level = level;
            this.isMounting = isMounting;
            this.isDismounting = isDismounting;
            this.canceled = canceled;
        }

        public /* synthetic */ Mount(Entity entity, Entity entity2, Level level, boolean bl, boolean bl2, boolean bl3, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x10) != 0) {
                boolean bl4 = bl2 = !bl;
            }
            if ((n & 0x20) != 0) {
                bl3 = false;
            }
            this(entity, entity2, level, bl, bl2, bl3);
        }

        @NotNull
        public final Entity getMounting() {
            return this.mounting;
        }

        @NotNull
        public final Entity getVehicle() {
            return this.vehicle;
        }

        @NotNull
        public final Level getLevel() {
            return this.level;
        }

        public final boolean isMounting() {
            return this.isMounting;
        }

        public final boolean isDismounting() {
            return this.isDismounting;
        }

        @Override
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override
        public void setCanceled(boolean bl) {
            this.canceled = bl;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/event/game/EntityEvents$Spawn;", "", "entity", "Lnet/minecraft/world/entity/Entity;", "<init>", "(Lnet/minecraft/world/entity/Entity;)V", "getEntity", "()Lnet/minecraft/world/entity/Entity;", "brokencore-common"})
    public static class Spawn {
        @NotNull
        private final Entity entity;

        public Spawn(@NotNull Entity entity) {
            Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
            this.entity = entity;
        }

        @NotNull
        public final Entity getEntity() {
            return this.entity;
        }
    }
}


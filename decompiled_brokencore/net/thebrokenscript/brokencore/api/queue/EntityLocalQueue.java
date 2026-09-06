/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.queue;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005:\u0001\u0014B%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00028\u0001X\u0084\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/queue/EntityLocalQueue;", "E", "Lnet/minecraft/world/entity/Entity;", "L", "Lnet/minecraft/world/level/Level;", "", "entityClass", "Ljava/lang/Class;", "uuid", "Ljava/util/UUID;", "level", "<init>", "(Ljava/lang/Class;Ljava/util/UUID;Lnet/minecraft/world/level/Level;)V", "getEntityClass", "()Ljava/lang/Class;", "getUuid", "()Ljava/util/UUID;", "getLevel", "()Lnet/minecraft/world/level/Level;", "Lnet/minecraft/world/level/Level;", "Task", "brokencore-common"})
public class EntityLocalQueue<E extends Entity, L extends Level> {
    @NotNull
    private final Class<E> entityClass;
    @NotNull
    private final UUID uuid;
    @NotNull
    private final L level;

    public EntityLocalQueue(@NotNull Class<E> entityClass, @NotNull UUID uuid, @NotNull L level) {
        Intrinsics.checkNotNullParameter(entityClass, (String)"entityClass");
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter(level, (String)"level");
        this.entityClass = entityClass;
        this.uuid = uuid;
        this.level = level;
    }

    @NotNull
    protected final Class<E> getEntityClass() {
        return this.entityClass;
    }

    @NotNull
    protected final UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    protected final L getLevel() {
        return this.level;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/queue/EntityLocalQueue$Task;", "E", "Lnet/minecraft/world/entity/Entity;", "", "<init>", "()V", "brokencore-common"})
    public static final class Task<E extends Entity> {
    }
}


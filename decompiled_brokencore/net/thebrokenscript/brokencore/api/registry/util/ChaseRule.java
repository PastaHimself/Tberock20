/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.util;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.registry.util.ChaseSightTracker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\rJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\u001b\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fH\u00c6\u0003JU\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/util/ChaseRule;", "T", "Lnet/minecraft/world/entity/Entity;", "", "entityClass", "Ljava/lang/Class;", "sound", "Ljava/util/function/Supplier;", "Lnet/minecraft/sounds/SoundEvent;", "requiresSight", "", "isChasing", "Lkotlin/Function2;", "Lnet/minecraft/world/entity/player/Player;", "<init>", "(Ljava/lang/Class;Ljava/util/function/Supplier;ZLkotlin/jvm/functions/Function2;)V", "getEntityClass", "()Ljava/lang/Class;", "getSound", "()Ljava/util/function/Supplier;", "getRequiresSight", "()Z", "()Lkotlin/jvm/functions/Function2;", "invokeIsChasing", "e", "player", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class ChaseRule<T extends Entity> {
    @NotNull
    private final Class<T> entityClass;
    @NotNull
    private final Supplier<SoundEvent> sound;
    private final boolean requiresSight;
    @NotNull
    private final Function2<T, Player, Boolean> isChasing;

    public ChaseRule(@NotNull Class<T> entityClass, @NotNull Supplier<SoundEvent> sound, boolean requiresSight, @NotNull Function2<? super T, ? super Player, Boolean> isChasing) {
        Intrinsics.checkNotNullParameter(entityClass, (String)"entityClass");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter(isChasing, (String)"isChasing");
        this.entityClass = entityClass;
        this.sound = sound;
        this.requiresSight = requiresSight;
        this.isChasing = isChasing;
    }

    public /* synthetic */ ChaseRule(Class clazz, Supplier supplier, boolean bl, Function2 function2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = false;
        }
        this(clazz, supplier, bl, function2);
    }

    @NotNull
    public final Class<T> getEntityClass() {
        return this.entityClass;
    }

    @NotNull
    public final Supplier<SoundEvent> getSound() {
        return this.sound;
    }

    public final boolean getRequiresSight() {
        return this.requiresSight;
    }

    @NotNull
    public final Function2<T, Player, Boolean> isChasing() {
        return this.isChasing;
    }

    public final boolean invokeIsChasing(@NotNull Entity e, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (!this.entityClass.isInstance(e)) {
            return false;
        }
        Entity typedEntity = (Entity)this.entityClass.cast(e);
        Intrinsics.checkNotNull((Object)typedEntity);
        return (Boolean)this.isChasing.invoke((Object)typedEntity, (Object)player) != false && (!this.requiresSight || ChaseSightTracker.INSTANCE.hasSeen(e));
    }

    @NotNull
    public final Class<T> component1() {
        return this.entityClass;
    }

    @NotNull
    public final Supplier<SoundEvent> component2() {
        return this.sound;
    }

    public final boolean component3() {
        return this.requiresSight;
    }

    @NotNull
    public final Function2<T, Player, Boolean> component4() {
        return this.isChasing;
    }

    @NotNull
    public final ChaseRule<T> copy(@NotNull Class<T> entityClass, @NotNull Supplier<SoundEvent> sound, boolean requiresSight, @NotNull Function2<? super T, ? super Player, Boolean> isChasing) {
        Intrinsics.checkNotNullParameter(entityClass, (String)"entityClass");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter(isChasing, (String)"isChasing");
        return new ChaseRule<T>(entityClass, sound, requiresSight, isChasing);
    }

    public static /* synthetic */ ChaseRule copy$default(ChaseRule chaseRule, Class clazz, Supplier supplier, boolean bl, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            clazz = chaseRule.entityClass;
        }
        if ((n & 2) != 0) {
            supplier = chaseRule.sound;
        }
        if ((n & 4) != 0) {
            bl = chaseRule.requiresSight;
        }
        if ((n & 8) != 0) {
            function2 = chaseRule.isChasing;
        }
        return chaseRule.copy(clazz, supplier, bl, function2);
    }

    @NotNull
    public String toString() {
        return "ChaseRule(entityClass=" + this.entityClass + ", sound=" + this.sound + ", requiresSight=" + this.requiresSight + ", isChasing=" + this.isChasing + ")";
    }

    public int hashCode() {
        int result = this.entityClass.hashCode();
        result = result * 31 + this.sound.hashCode();
        result = result * 31 + Boolean.hashCode(this.requiresSight);
        result = result * 31 + this.isChasing.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChaseRule)) {
            return false;
        }
        ChaseRule chaseRule = (ChaseRule)other;
        if (!Intrinsics.areEqual(this.entityClass, chaseRule.entityClass)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.sound, chaseRule.sound)) {
            return false;
        }
        if (this.requiresSight != chaseRule.requiresSight) {
            return false;
        }
        return Intrinsics.areEqual(this.isChasing, chaseRule.isChasing);
    }
}


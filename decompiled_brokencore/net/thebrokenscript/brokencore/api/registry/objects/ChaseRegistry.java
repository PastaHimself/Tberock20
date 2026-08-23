/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.registry.util.ChaseRule;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\f*\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\tJ=\u0010\u000e\u001a9\u00125\u00123\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\u0011\u0012\u0017\u0012\u0015\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t0\b\u00a2\u0006\u0002\b\u00110\u0010\u00a2\u0006\u0002\b\u00110\u000fR0\u0010\u0004\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t0\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/ChaseRegistry;", "", "<init>", "()V", "rules", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lnet/minecraft/world/entity/Entity;", "", "Lnet/thebrokenscript/brokencore/api/registry/util/ChaseRule;", "register", "", "T", "rule", "allGroups", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "brokencore-common"})
public final class ChaseRegistry {
    @NotNull
    public static final ChaseRegistry INSTANCE = new ChaseRegistry();
    @NotNull
    private static final ConcurrentHashMap<Class<? extends Entity>, List<ChaseRule<? extends Entity>>> rules = new ConcurrentHashMap();

    private ChaseRegistry() {
    }

    public final <T extends Entity> void register(@NotNull ChaseRule<T> rule) {
        Intrinsics.checkNotNullParameter(rule, (String)"rule");
        rules.computeIfAbsent(rule.getEntityClass(), arg_0 -> ChaseRegistry.register$lambda$1(ChaseRegistry::register$lambda$0, arg_0)).add(rule);
    }

    @NotNull
    public final Set<Map.Entry<Class<? extends Entity>, List<ChaseRule<? extends Entity>>>> allGroups() {
        Set<Map.Entry<Class<? extends Entity>, List<ChaseRule<? extends Entity>>>> set = rules.entrySet();
        Intrinsics.checkNotNullExpressionValue(set, (String)"<get-entries>(...)");
        return set;
    }

    private static final List register$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Collections.synchronizedList(new ArrayList());
    }

    private static final List register$lambda$1(Function1 $tmp0, Object p0) {
        return (List)$tmp0.invoke(p0);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R*\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler;", "", "<init>", "()V", "attrs", "", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "getAttrs$brokencore_common", "()Ljava/util/Map;", "spawns", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "getSpawns$brokencore_common", "pushAll", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler$Consumer;", "pushAttrs", "pushSpawns", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEntityHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,58:1\n216#2,2:59\n216#2,2:61\n*S KotlinDebug\n*F\n+ 1 EntityHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler\n*L\n34#1:59,2\n41#1:61,2\n*E\n"})
public final class EntityHandler {
    @NotNull
    public static final EntityHandler INSTANCE = new EntityHandler();
    @NotNull
    private static final Map<EntityEntry<?>, Function0<AttributeSupplier.Builder>> attrs = new LinkedHashMap();
    @NotNull
    private static final Map<EntityEntry<?>, Function0<SpawnConditions>> spawns = new LinkedHashMap();

    private EntityHandler() {
    }

    @NotNull
    public final Map<EntityEntry<?>, Function0<AttributeSupplier.Builder>> getAttrs$brokencore_common() {
        return attrs;
    }

    @NotNull
    public final Map<EntityEntry<?>, Function0<SpawnConditions>> getSpawns$brokencore_common() {
        return spawns;
    }

    public final void pushAll(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        this.pushAttrs(cons);
        this.pushSpawns(cons);
    }

    public final void pushAttrs(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<EntityEntry<?>, Function0<AttributeSupplier.Builder>> $this$forEach$iv = attrs;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<EntityEntry<?>, Function0<AttributeSupplier.Builder>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<EntityEntry<?>, Function0<AttributeSupplier.Builder>> element$iv;
            Map.Entry<EntityEntry<?>, Function0<AttributeSupplier.Builder>> entry = element$iv = iterator.next();
            boolean bl = false;
            EntityEntry<?> entry2 = entry.getKey();
            Function0<AttributeSupplier.Builder> attrs = entry.getValue();
            cons.attrs(entry2, attrs);
        }
    }

    public final void pushSpawns(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<EntityEntry<?>, Function0<SpawnConditions>> $this$forEach$iv = spawns;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<EntityEntry<?>, Function0<SpawnConditions>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<EntityEntry<?>, Function0<SpawnConditions>> element$iv;
            Map.Entry<EntityEntry<?>, Function0<SpawnConditions>> entry = element$iv = iterator.next();
            boolean bl = false;
            EntityEntry<?> entry2 = entry.getKey();
            Function0<SpawnConditions> spawns = entry.getValue();
            cons.spawns(entry2, spawns);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\"\u0010\b\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H&\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler$Consumer;", "", "attrs", "", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "spawns", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "brokencore-common"})
    public static interface Consumer {
        public void attrs(@NotNull EntityEntry<?> var1, @NotNull Function0<? extends AttributeSupplier.Builder> var2);

        public void spawns(@NotNull EntityEntry<?> var1, @NotNull Function0<? extends SpawnConditions> var2);
    }
}


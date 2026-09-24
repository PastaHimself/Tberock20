/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
 *  net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent
 *  net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent$Operation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.registry.handlers.EntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.brokencore.neoforge.BCNeoForge;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\"\u0010\u0011\u001a\u00020\b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\"\u0010\u0016\u001a\u00020\b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/EntityHandlerImpl;", "Lnet/thebrokenscript/brokencore/api/registry/handlers/EntityHandler$Consumer;", "<init>", "()V", "attrQueue", "", "Lkotlin/Function1;", "Lnet/neoforged/neoforge/event/entity/EntityAttributeCreationEvent;", "", "registeredAttrs", "", "spawnsQueue", "Lnet/neoforged/neoforge/event/entity/RegisterSpawnPlacementsEvent;", "registeredSpawns", "registerAttrs", "event", "registerSpawns", "attrs", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lkotlin/Function0;", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "spawns", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nEntityHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/EntityHandlerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1869#2,2:81\n1869#2,2:83\n*S KotlinDebug\n*F\n+ 1 EntityHandlerImpl.kt\nnet/thebrokenscript/brokencore/neoforge/EntityHandlerImpl\n*L\n32#1:81,2\n45#1:83,2\n*E\n"})
public final class EntityHandlerImpl
implements EntityHandler.Consumer {
    @NotNull
    public static final EntityHandlerImpl INSTANCE = new EntityHandlerImpl();
    @NotNull
    private static final List<Function1<EntityAttributeCreationEvent, Unit>> attrQueue = new ArrayList();
    private static boolean registeredAttrs;
    @NotNull
    private static final List<Function1<RegisterSpawnPlacementsEvent, Unit>> spawnsQueue;
    private static boolean registeredSpawns;

    private EntityHandlerImpl() {
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerAttrs(@NotNull EntityAttributeCreationEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredAttrs) {
            return;
        }
        EntityHandler.INSTANCE.pushAttrs(INSTANCE);
        BCNeoForge.LOGGER.info("Registering entity attributes!");
        Iterable $this$forEach$iv = attrQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredAttrs = true;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void registerSpawns(@NotNull RegisterSpawnPlacementsEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (registeredSpawns) {
            return;
        }
        EntityHandler.INSTANCE.pushSpawns(INSTANCE);
        BCNeoForge.LOGGER.info("Registering entity spawn conditions!");
        Iterable $this$forEach$iv = spawnsQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)event);
        }
        registeredSpawns = true;
    }

    @Override
    public void attrs(@NotNull EntityEntry<?> entry, @NotNull Function0<? extends AttributeSupplier.Builder> attrs) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        Intrinsics.checkNotNullParameter(attrs, (String)"attrs");
        if (registeredAttrs) {
            throw new IllegalStateException("Entity attributes have already been registered, cannot re-register!");
        }
        attrQueue.add((Function1<EntityAttributeCreationEvent, Unit>)((Function1)arg_0 -> EntityHandlerImpl.attrs$lambda$0(entry, attrs, arg_0)));
    }

    @Override
    public void spawns(@NotNull EntityEntry<?> entry, @NotNull Function0<? extends SpawnConditions> spawns) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        Intrinsics.checkNotNullParameter(spawns, (String)"spawns");
        if (registeredSpawns) {
            throw new IllegalStateException("Entity spawn conditions have already been registered, cannot re-register!");
        }
        spawnsQueue.add((Function1<RegisterSpawnPlacementsEvent, Unit>)((Function1)arg_0 -> EntityHandlerImpl.spawns$lambda$0(spawns, entry, arg_0)));
    }

    private static final Unit attrs$lambda$0(EntityEntry $entry, Function0 $attrs, EntityAttributeCreationEvent it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Object t = $entry.get();
        Intrinsics.checkNotNull(t, (String)"null cannot be cast to non-null type net.minecraft.world.entity.EntityType<net.minecraft.world.entity.LivingEntity>");
        it.put((EntityType)t, ((AttributeSupplier.Builder)$attrs.invoke()).build());
        return Unit.INSTANCE;
    }

    private static final Unit spawns$lambda$0(Function0 $spawns, EntityEntry $entry, RegisterSpawnPlacementsEvent it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        SpawnConditions cond = (SpawnConditions)$spawns.invoke();
        Object t = $entry.get();
        Intrinsics.checkNotNull(t, (String)"null cannot be cast to non-null type net.minecraft.world.entity.EntityType<net.minecraft.world.entity.Entity>");
        it.register((EntityType)t, cond.getPlacementType(), cond.getHeightmap(), cond.predicate(), RegisterSpawnPlacementsEvent.Operation.REPLACE);
        return Unit.INSTANCE;
    }

    static {
        spawnsQueue = new ArrayList();
    }
}


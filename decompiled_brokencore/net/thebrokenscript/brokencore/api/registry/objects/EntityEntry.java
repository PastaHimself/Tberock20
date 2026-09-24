/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "T", "Lnet/minecraft/world/entity/Entity;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/entity/EntityType;", "key", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/resources/ResourceKey;)V", "brokencore-common"})
public class EntityEntry<T extends Entity>
extends RegistryEntry<EntityType<?>, EntityType<T>> {
    public EntityEntry(@NotNull ResourceKey<EntityType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super(key);
    }
}


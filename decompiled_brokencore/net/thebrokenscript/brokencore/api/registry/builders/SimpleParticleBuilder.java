/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.entries.CustomSimpleParticleType;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002.\u0012\u0004\u0012\u00020\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J*\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0011H\u0016R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleParticleBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/minecraft/core/particles/ParticleType;", "Lnet/minecraft/core/particles/SimpleParticleType;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;)V", "overrideLimiter", "", "createObject", "Lnet/thebrokenscript/brokencore/api/registry/entries/CustomSimpleParticleType;", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "brokencore-common"})
public final class SimpleParticleBuilder
extends AbstractBuilder<SimpleParticleBuilder, ParticleType<?>, SimpleParticleType, RegistryEntry<ParticleType<?>, SimpleParticleType>> {
    @JvmField
    public boolean overrideLimiter;

    public SimpleParticleBuilder(@NotNull BrokenReg parent, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceKey resourceKey = Registries.PARTICLE_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"PARTICLE_TYPE");
        super(parent, resourceKey, name);
    }

    @Override
    @NotNull
    protected CustomSimpleParticleType createObject() {
        return new CustomSimpleParticleType(this.overrideLimiter);
    }

    @Override
    @NotNull
    public RegistryEntry<ParticleType<?>, SimpleParticleType> createEntry(@NotNull ResourceKey<ParticleType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new RegistryEntry(key);
    }
}


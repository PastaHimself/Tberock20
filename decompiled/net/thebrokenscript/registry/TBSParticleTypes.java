/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  net.thebrokenscript.brokencore.api.registry.builders.SimpleParticleBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleParticleBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/registry/TBSParticleTypes;", "", "<init>", "()V", "NULL_PARTICLE", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/core/particles/ParticleType;", "Lnet/minecraft/core/particles/SimpleParticleType;", "FARDAWAY_PARTICLE", "EYES", "WRETCHED_PARTICLE", "PARTICLE_OF_CURVED", "NULL_STRUCTURE_PARTICLE", "PAPER_PARTICLE", "thebrokenscript-common"})
public final class TBSParticleTypes {
    @NotNull
    public static final TBSParticleTypes INSTANCE = new TBSParticleTypes();
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> NULL_PARTICLE = TBSReg.INSTANCE.simpleParticle("null_particle", TBSParticleTypes::NULL_PARTICLE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> FARDAWAY_PARTICLE = TBSReg.INSTANCE.simpleParticle("fardaway", TBSParticleTypes::FARDAWAY_PARTICLE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> EYES = TBSReg.INSTANCE.simpleParticle("eyes", TBSParticleTypes::EYES$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> WRETCHED_PARTICLE = BrokenReg.simpleParticle$default((BrokenReg)TBSReg.INSTANCE, (String)"wretched_particle", null, (int)2, null);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> PARTICLE_OF_CURVED = TBSReg.INSTANCE.simpleParticle("particle_of_curved", TBSParticleTypes::PARTICLE_OF_CURVED$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> NULL_STRUCTURE_PARTICLE = TBSReg.INSTANCE.simpleParticle("null_structure_particle", TBSParticleTypes::NULL_STRUCTURE_PARTICLE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> PAPER_PARTICLE = TBSReg.INSTANCE.simpleParticle("paper_particle", TBSParticleTypes::PAPER_PARTICLE$lambda$0);

    private TBSParticleTypes() {
    }

    private static final void NULL_PARTICLE$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }

    private static final void FARDAWAY_PARTICLE$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }

    private static final void EYES$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }

    private static final void PARTICLE_OF_CURVED$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }

    private static final void NULL_STRUCTURE_PARTICLE$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }

    private static final void PAPER_PARTICLE$lambda$0(SimpleParticleBuilder $this$simpleParticle) {
        Intrinsics.checkNotNullParameter((Object)$this$simpleParticle, (String)"$this$simpleParticle");
        $this$simpleParticle.overrideLimiter = true;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.particle.ParticleEngine$SpriteParticleRegistration
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleType
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.particle.EyesParticle;
import net.thebrokenscript.client.particle.FardawayParticle;
import net.thebrokenscript.client.particle.NullParticle;
import net.thebrokenscript.client.particle.NullStructureParticle;
import net.thebrokenscript.client.particle.PaperParticle;
import net.thebrokenscript.client.particle.ParticleOfCurvedParticle;
import net.thebrokenscript.client.particle.WretchedParticle;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/registry/TBSParticles;", "", "<init>", "()V", "register", "", "registrar", "Lnet/thebrokenscript/registry/TBSParticles$Consumer;", "Consumer", "thebrokenscript-common"})
public final class TBSParticles {
    @NotNull
    public static final TBSParticles INSTANCE = new TBSParticles();

    private TBSParticles() {
    }

    public final void register(@NotNull Consumer registrar) {
        Intrinsics.checkNotNullParameter((Object)registrar, (String)"registrar");
        registrar.register((ParticleType)TBSParticleTypes.NULL_PARTICLE.get(), NullParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.FARDAWAY_PARTICLE.get(), FardawayParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.EYES.get(), EyesParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.WRETCHED_PARTICLE.get(), WretchedParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.PARTICLE_OF_CURVED.get(), ParticleOfCurvedParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.NULL_STRUCTURE_PARTICLE.get(), NullStructureParticle.Companion::provider);
        registrar.register((ParticleType)TBSParticleTypes.PAPER_PARTICLE.get(), PaperParticle.Companion::provider);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH&\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/registry/TBSParticles$Consumer;", "", "register", "", "T", "Lnet/minecraft/core/particles/ParticleOptions;", "type", "Lnet/minecraft/core/particles/ParticleType;", "spriteSet", "Lnet/minecraft/client/particle/ParticleEngine$SpriteParticleRegistration;", "thebrokenscript-common"})
    public static interface Consumer {
        public <T extends ParticleOptions> void register(@NotNull ParticleType<T> var1, @NotNull ParticleEngine.SpriteParticleRegistration<T> var2);
    }
}


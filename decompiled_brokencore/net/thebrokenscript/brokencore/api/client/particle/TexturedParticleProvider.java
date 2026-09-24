/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.TextureSheetParticle
 *  net.minecraft.core.particles.SimpleParticleType
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.particle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003BM\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012<\u0010\u0007\u001a8\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\u000b\u0010\fJH\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000RD\u0010\u0007\u001a8\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/client/particle/TexturedParticleProvider;", "T", "Lnet/minecraft/client/particle/TextureSheetParticle;", "Lnet/minecraft/client/particle/ParticleProvider;", "Lnet/minecraft/core/particles/SimpleParticleType;", "spriteSet", "Lnet/minecraft/client/particle/SpriteSet;", "ctor", "Lkotlin/Function8;", "Lnet/minecraft/client/multiplayer/ClientLevel;", "", "<init>", "(Lnet/minecraft/client/particle/SpriteSet;Lkotlin/jvm/functions/Function8;)V", "createParticle", "Lnet/minecraft/client/particle/Particle;", "typeIn", "level", "x", "y", "z", "xSpeed", "ySpeed", "zSpeed", "brokencore-common"})
public final class TexturedParticleProvider<T extends TextureSheetParticle>
implements ParticleProvider<SimpleParticleType> {
    @NotNull
    private final SpriteSet spriteSet;
    @NotNull
    private final Function8<ClientLevel, Double, Double, Double, Double, Double, Double, SpriteSet, T> ctor;

    public TexturedParticleProvider(@NotNull SpriteSet spriteSet, @NotNull Function8<? super ClientLevel, ? super Double, ? super Double, ? super Double, ? super Double, ? super Double, ? super Double, ? super SpriteSet, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)spriteSet, (String)"spriteSet");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        this.spriteSet = spriteSet;
        this.ctor = ctor;
    }

    @NotNull
    public Particle createParticle(@NotNull SimpleParticleType typeIn, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        Intrinsics.checkNotNullParameter((Object)typeIn, (String)"typeIn");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (Particle)this.ctor.invoke((Object)level, (Object)x, (Object)y, (Object)z, (Object)xSpeed, (Object)ySpeed, (Object)zSpeed, (Object)this.spriteSet);
    }
}


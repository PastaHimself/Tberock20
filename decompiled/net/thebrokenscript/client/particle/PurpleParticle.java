/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.TextureSheetParticle
 *  net.thebrokenscript.brokencore.api.client.particle.TexturedParticleProvider
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.particle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.thebrokenscript.brokencore.api.client.particle.TexturedParticleProvider;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.particle.PurpleParticle;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011BI\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/client/particle/PurpleParticle;", "Lnet/minecraft/client/particle/TextureSheetParticle;", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "x", "", "y", "z", "vx", "vy", "vz", "spriteSet", "Lnet/minecraft/client/particle/SpriteSet;", "<init>", "(Lnet/minecraft/client/multiplayer/ClientLevel;DDDDDDLnet/minecraft/client/particle/SpriteSet;)V", "getRenderType", "Lnet/minecraft/client/particle/ParticleRenderType;", "Companion", "thebrokenscript-common"})
public final class PurpleParticle
extends TextureSheetParticle {
    @NotNull
    public static final Companion Companion = new Companion(null);

    private PurpleParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.setSize(1.0f, 1.0f);
        this.quadSize = 0.7f;
        this.lifetime = 20;
        this.gravity = 0.0f;
        this.hasPhysics = false;
        this.xd = vx * 0.0;
        this.yd = vy * 0.0;
        this.zd = vz * 0.0;
        this.pickSprite(spriteSet);
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        ParticleRenderType particleRenderType = ParticleRenderType.PARTICLE_SHEET_LIT;
        Intrinsics.checkNotNullExpressionValue((Object)particleRenderType, (String)"PARTICLE_SHEET_LIT");
        return particleRenderType;
    }

    public /* synthetic */ PurpleParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, DefaultConstructorMarker $constructor_marker) {
        this(level, x, y, z, vx, vy, vz, spriteSet);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/client/particle/PurpleParticle$Companion;", "", "<init>", "()V", "provider", "Lnet/thebrokenscript/brokencore/api/client/particle/TexturedParticleProvider;", "Lnet/thebrokenscript/client/particle/PurpleParticle;", "spriteSet", "Lnet/minecraft/client/particle/SpriteSet;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TexturedParticleProvider<PurpleParticle> provider(@NotNull SpriteSet spriteSet) {
            Intrinsics.checkNotNullParameter((Object)spriteSet, (String)"spriteSet");
            return new TexturedParticleProvider(spriteSet, (Function8)provider.1.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


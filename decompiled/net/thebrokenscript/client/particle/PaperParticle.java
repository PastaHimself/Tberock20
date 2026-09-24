/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.TextureSheetParticle
 *  net.thebrokenscript.brokencore.api.client.particle.TexturedParticleProvider
 *  net.thebrokenscript.brokencore.api.ext.JomlVecExtKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Vector2d
 *  org.joml.Vector2f
 */
package net.thebrokenscript.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.thebrokenscript.brokencore.api.client.particle.TexturedParticleProvider;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.particle.PaperParticle;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector2d;
import org.joml.Vector2f;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBI\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J8\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/client/particle/PaperParticle;", "Lnet/minecraft/client/particle/TextureSheetParticle;", "level", "Lnet/minecraft/client/multiplayer/ClientLevel;", "x", "", "y", "z", "vx", "vy", "vz", "spriteSet", "Lnet/minecraft/client/particle/SpriteSet;", "<init>", "(Lnet/minecraft/client/multiplayer/ClientLevel;DDDDDDLnet/minecraft/client/particle/SpriteSet;)V", "getRenderType", "Lnet/minecraft/client/particle/ParticleRenderType;", "randomOfs", "", "render", "", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "renderInfo", "Lnet/minecraft/client/Camera;", "partialTicks", "renderRotatedQuad", "quaternion", "Lorg/joml/Quaternionf;", "tick", "Companion", "thebrokenscript-common"})
public final class PaperParticle
extends TextureSheetParticle {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final float randomOfs;

    private PaperParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.setSize(0.25f, 0.25f);
        this.quadSize = 0.25f;
        this.lifetime = 100 + (int)(Math.random() * (double)100);
        this.gravity = 0.0f;
        this.roll = (float)(Math.random() * Math.PI * 2.0);
        this.hasPhysics = true;
        this.xd = vx + (this.random.nextDouble() - 0.5) * 0.02;
        this.yd = vy;
        this.zd = vz + (this.random.nextDouble() - 0.5) * 0.02;
        this.friction = 0.96f;
        this.randomOfs = (float)(Math.random() * 0.001);
        this.pickSprite(spriteSet);
        this.setSpriteFromAge(spriteSet);
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        ParticleRenderType particleRenderType = ParticleRenderType.PARTICLE_SHEET_LIT;
        Intrinsics.checkNotNullExpressionValue((Object)particleRenderType, (String)"PARTICLE_SHEET_LIT");
        return particleRenderType;
    }

    public void render(@NotNull VertexConsumer buffer, @NotNull Camera renderInfo, float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)renderInfo, (String)"renderInfo");
        float wave = (float)(Math.sin((double)this.age * 0.125) * 0.08) * 3.5f;
        float mul = this.onGround ? 0.0f : 1.0f;
        Quaternionf quaternionA = Axis.XP.rotationDegrees(90.0f);
        Quaternionf quaternionB = Axis.XN.rotationDegrees(90.0f);
        quaternionB.rotateZ(this.roll);
        quaternionA.rotateZ(-this.roll + (float)Math.PI);
        quaternionA.rotateX(-wave * mul);
        quaternionB.rotateX(wave * mul);
        this.renderRotatedQuad(buffer, renderInfo, quaternionB, partialTicks);
        this.renderRotatedQuad(buffer, renderInfo, quaternionA, partialTicks);
    }

    protected void renderRotatedQuad(@NotNull VertexConsumer buffer, @NotNull Quaternionf quaternion, float x, float y, float z, float partialTicks) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)quaternion, (String)"quaternion");
        super.renderRotatedQuad(buffer, quaternion, x, y + 0.01f + this.randomOfs, z, partialTicks);
    }

    public void tick() {
        super.tick();
        double age = (double)this.age * 0.125;
        Vector2d normal = JomlVecExtKt.toDouble((Vector2f)new Vector2f((float)Math.cos(this.roll), (float)Math.sin(this.roll)));
        double wave = Math.sin(age) * 0.08;
        this.xd = wave * normal.y;
        this.yd = (Math.sin(age * 2.0) * 0.5 + 0.75) * -0.035;
        this.zd = wave * normal.x;
    }

    public /* synthetic */ PaperParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, DefaultConstructorMarker $constructor_marker) {
        this(level, x, y, z, vx, vy, vz, spriteSet);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/client/particle/PaperParticle$Companion;", "", "<init>", "()V", "provider", "Lnet/thebrokenscript/brokencore/api/client/particle/TexturedParticleProvider;", "Lnet/thebrokenscript/client/particle/PaperParticle;", "spriteSet", "Lnet/minecraft/client/particle/SpriteSet;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TexturedParticleProvider<PaperParticle> provider(@NotNull SpriteSet spriteSet) {
            Intrinsics.checkNotNullParameter((Object)spriteSet, (String)"spriteSet");
            return new TexturedParticleProvider(spriteSet, (Function8)provider.1.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


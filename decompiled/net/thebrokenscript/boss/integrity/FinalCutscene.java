/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt
 *  net.thebrokenscript.brokencore.api.util.math.Rotation
 *  net.thebrokenscript.brokencore.api.util.math.Transform
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import net.thebrokenscript.brokencore.api.util.math.Rotation;
import net.thebrokenscript.brokencore.api.util.math.Transform;
import net.thebrokenscript.client.gui.CreditsGui;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\bR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/boss/integrity/FinalCutscene;", "", "<init>", "()V", "interpPos", "Lnet/minecraft/world/phys/Vec3;", "kotlin.jvm.PlatformType", "t", "", "interpRot", "Lnet/minecraft/world/phys/Vec2;", "zoom", "getZoom", "()F", "setZoom", "(F)V", "blackout", "", "getBlackout", "()Z", "setBlackout", "(Z)V", "zoomValue", "getZoomValue", "ticks", "active", "start", "", "end", "update", "deltaTime", "Companion", "thebrokenscript-common"})
public final class FinalCutscene {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private float zoom = 1.0f;
    private boolean blackout;
    private float ticks;
    private boolean active;
    public static final long PRE_LENGTH = 108L;
    public static final long LENGTH = 190L;
    public static final long ZOOM_LENGTH = 100L;
    public static final long OFFSET = 10L;
    public static final long BLACKOUT_TICKS = 40L;
    public static final long TOTAL_LENGTH = 428L;
    @NotNull
    private static final Vec3 POS1 = new Vec3(194.0, -45.0, 169.0);
    @NotNull
    private static final Vec3 POS2 = new Vec3(194.0, 10.0, 199.0);
    @NotNull
    private static final Vec2 ROT1 = new Vec2(0.0f, 10.0f);
    @NotNull
    private static final Vec2 ROT2 = new Vec2(0.0f, -90.0f);

    private final Vec3 interpPos(float t) {
        return POS1.lerp(POS2, (double)t);
    }

    private final Vec2 interpRot(float t) {
        return PositionUtil.lerp((Vec2)ROT1, (Vec2)ROT2, (float)t);
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getBlackout() {
        return this.blackout;
    }

    public final void setBlackout(boolean bl) {
        this.blackout = bl;
    }

    public final float getZoomValue() {
        return 1.0f / this.zoom;
    }

    public final void start() {
        this.active = true;
        this.ticks = 0.0f;
        this.zoom = 1.0f;
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides((Camera)camera).setActive(true);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides((Camera)camera2);
    }

    public final void end() {
        this.active = false;
        this.zoom = 1.0f;
        ClientDSLKt.getMC().setScreen((Screen)new CreditsGui());
    }

    public final void update(float deltaTime) {
        if (!this.active) {
            return;
        }
        if (this.ticks > 428.0f) {
            this.end();
            return;
        }
        this.ticks += deltaTime;
        float delta = Mth.clamp((float)((this.ticks - (float)108L) / (float)190L), (float)0.0f, (float)1.0f);
        Vec3 pos = this.interpPos(delta);
        Vec2 rot = this.interpRot(delta);
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        Transform transform = CameraExtImplKt.getOverrides((Camera)camera).getTransform();
        Vector3f vector3f = pos.toVector3f();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
        transform.setPosition(vector3f);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides((Camera)camera2).getTransform().setRotation(new Rotation(rot.y, rot.x));
        Camera camera3 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera3, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides((Camera)camera3);
        float zoomDelta = Mth.clamp((float)((this.ticks - (float)108L - (float)190L + (float)10L) / (float)100L), (float)0.0f, (float)1.0f);
        this.zoom = Mth.lerp((float)zoomDelta, (float)1.0f, (float)5.0f);
        this.blackout = this.ticks >= 388.0f && this.ticks < 428.0f;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/boss/integrity/FinalCutscene$Companion;", "", "<init>", "()V", "PRE_LENGTH", "", "LENGTH", "ZOOM_LENGTH", "OFFSET", "BLACKOUT_TICKS", "TOTAL_LENGTH", "POS1", "Lnet/minecraft/world/phys/Vec3;", "getPOS1", "()Lnet/minecraft/world/phys/Vec3;", "POS2", "getPOS2", "ROT1", "Lnet/minecraft/world/phys/Vec2;", "getROT1", "()Lnet/minecraft/world/phys/Vec2;", "ROT2", "getROT2", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Vec3 getPOS1() {
            return POS1;
        }

        @NotNull
        public final Vec3 getPOS2() {
            return POS2;
        }

        @NotNull
        public final Vec2 getROT1() {
            return ROT1;
        }

        @NotNull
        public final Vec2 getROT2() {
            return ROT2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fractured;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.entity.fractured.FracturedSubEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/entity/fractured/Leg;", "", "leg", "Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "offset", "Lnet/minecraft/world/phys/Vec3;", "target", "<init>", "(Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V", "getLeg", "()Lnet/thebrokenscript/entity/fractured/FracturedSubEntity;", "getOffset", "()Lnet/minecraft/world/phys/Vec3;", "getTarget", "setTarget", "(Lnet/minecraft/world/phys/Vec3;)V", "tick", "", "jim", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "thebrokenscript-common"})
public final class Leg {
    @NotNull
    private final FracturedSubEntity leg;
    @NotNull
    private final Vec3 offset;
    @NotNull
    private Vec3 target;

    public Leg(@NotNull FracturedSubEntity leg, @NotNull Vec3 offset, @NotNull Vec3 target) {
        Intrinsics.checkNotNullParameter((Object)((Object)leg), (String)"leg");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        this.leg = leg;
        this.offset = offset;
        this.target = target;
    }

    public /* synthetic */ Leg(FracturedSubEntity fracturedSubEntity, Vec3 vec3, Vec3 vec32, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            vec32 = new Vec3(vec3.x, vec3.y, vec3.z);
        }
        this(fracturedSubEntity, vec3, vec32);
    }

    @NotNull
    public final FracturedSubEntity getLeg() {
        return this.leg;
    }

    @NotNull
    public final Vec3 getOffset() {
        return this.offset;
    }

    @NotNull
    public final Vec3 getTarget() {
        return this.target;
    }

    public final void setTarget(@NotNull Vec3 vec3) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"<set-?>");
        this.target = vec3;
    }

    public final void tick(@NotNull BaseFracturedEntity jim) {
        Intrinsics.checkNotNullParameter((Object)((Object)jim), (String)"jim");
        this.leg.xo = this.leg.getX();
        this.leg.yo = this.leg.getY();
        this.leg.zo = this.leg.getZ();
        this.leg.yRotO = this.leg.getYRot();
        this.leg.xRotO = this.leg.getXRot();
        float yawRad = -((float)Math.toRadians(jim.yBodyRot));
        Vec3 rotated = this.target.yRot(yawRad);
        Intrinsics.checkNotNull((Object)rotated);
        Vec2 vec2 = PositionUtil.getXz((Vec3)rotated).add(PositionUtil.getXz((Vec3)jim.getPos()));
        Intrinsics.checkNotNullExpressionValue((Object)vec2, (String)"add(...)");
        this.leg.setPos(PositionUtil.withY((Vec2)vec2, (Number)jim.getY()));
        this.leg.setYRot(jim.yBodyRot);
    }
}


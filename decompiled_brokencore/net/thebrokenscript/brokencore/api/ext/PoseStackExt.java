/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\n\u0010\t\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/PoseStackExt;", "", "<init>", "()V", "scale", "", "Lcom/mojang/blaze3d/vertex/PoseStack;", "scalar", "", "billboard", "brokencore-common"})
public final class PoseStackExt {
    @NotNull
    public static final PoseStackExt INSTANCE = new PoseStackExt();

    private PoseStackExt() {
    }

    public final void scale(@NotNull PoseStack $this$scale, @NotNull Number scalar) {
        Intrinsics.checkNotNullParameter((Object)$this$scale, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)scalar, (String)"scalar");
        $this$scale.scale(scalar.floatValue(), scalar.floatValue(), scalar.floatValue());
    }

    public final void billboard(@NotNull PoseStack $this$billboard) {
        Intrinsics.checkNotNullParameter((Object)$this$billboard, (String)"<this>");
        Billboarder.INSTANCE.withCameraRotation($this$billboard);
    }
}


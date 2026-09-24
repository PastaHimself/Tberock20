/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.ext;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\u00a2\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"pushPop", "T", "Lcom/mojang/blaze3d/vertex/PoseStack;", "block", "Lkotlin/Function0;", "(Lcom/mojang/blaze3d/vertex/PoseStack;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "translate", "", "vec", "Lnet/minecraft/world/phys/Vec3;", "Lorg/joml/Vector3f;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nRenderExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderExt.kt\nnet/thebrokenscript/brokencore/api/ext/RenderExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,10:1\n1#2:11\n*E\n"})
public final class RenderExtKt {
    public static final <T> T pushPop(@NotNull PoseStack $this$pushPop, @NotNull Function0<? extends T> block2) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$pushPop, (String)"<this>");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        $this$pushPop.pushPose();
        Unit $this$pushPop_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        Object it = object = block2.invoke();
        boolean bl2 = false;
        $this$pushPop.popPose();
        return (T)object;
    }

    public static final void translate(@NotNull PoseStack $this$translate, @NotNull Vec3 vec) {
        Intrinsics.checkNotNullParameter((Object)$this$translate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        $this$translate.translate(vec.x, vec.y, vec.z);
    }

    public static final void translate(@NotNull PoseStack $this$translate, @NotNull Vector3f vec) {
        Intrinsics.checkNotNullParameter((Object)$this$translate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        $this$translate.translate(vec.x, vec.y, vec.z);
    }
}


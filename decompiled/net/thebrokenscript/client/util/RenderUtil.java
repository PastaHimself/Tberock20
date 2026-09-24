/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.ext.MiscExt
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package net.thebrokenscript.client.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/client/util/RenderUtil;", "", "<init>", "()V", "getInverseTransformMatrix", "Lorg/joml/Matrix4f;", "outMat", "thebrokenscript-common"})
public final class RenderUtil {
    @NotNull
    public static final RenderUtil INSTANCE = new RenderUtil();

    private RenderUtil() {
    }

    @NotNull
    public final Matrix4f getInverseTransformMatrix(@NotNull Matrix4f outMat) {
        Intrinsics.checkNotNullParameter((Object)outMat, (String)"outMat");
        Matrix4f projection = MiscExt.getProjectionMatrix((Minecraft)ClientDSLKt.getMC());
        Matrix4f modelView = ClientMixinBridge.INSTANCE.getWorldModelMatrix(ClientDSLKt.getMC());
        outMat.identity();
        outMat.mul((Matrix4fc)projection);
        outMat.mul((Matrix4fc)modelView);
        outMat.invert();
        return outMat;
    }
}


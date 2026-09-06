/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 */
package net.thebrokenscript.mixinterfaces;

import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JH\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/mixinterfaces/BakedGlyphExt;", "", "tbs$resetBox", "", "chance", "", "tbs$renderBox", "x", "y", "matrix", "Lorg/joml/Matrix4f;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "red", "green", "blue", "alpha", "thebrokenscript-common"})
public interface BakedGlyphExt {
    public void tbs$resetBox(float var1);

    public void tbs$renderBox(float var1, float var2, @NotNull Matrix4f var3, @NotNull VertexConsumer var4, float var5, float var6, float var7, float var8);
}


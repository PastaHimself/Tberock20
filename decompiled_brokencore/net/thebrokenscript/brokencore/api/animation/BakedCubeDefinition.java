/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.geom.ModelPart$Cube
 *  net.minecraft.client.model.geom.builders.CubeDefinition
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.thebrokenscript.brokencore.api.animation.PerFaceCuboid;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BakedCubeDefinition;", "Lnet/minecraft/client/model/geom/builders/CubeDefinition;", "cube", "Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;)V", "bake", "Lnet/minecraft/client/model/geom/ModelPart$Cube;", "texWidth", "", "texHeight", "brokencore-common"})
@ExperimentalAnimationApi
public final class BakedCubeDefinition
extends CubeDefinition {
    @NotNull
    private final PerFaceCuboid cube;

    public BakedCubeDefinition(@NotNull PerFaceCuboid cube) {
        Intrinsics.checkNotNullParameter((Object)((Object)cube), (String)"cube");
        super("", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, new CubeDeformation(0.0f), false, 0.0f, 0.0f, SetsKt.emptySet());
        this.cube = cube;
    }

    @NotNull
    public ModelPart.Cube bake(int texWidth, int texHeight) {
        return this.cube;
    }
}


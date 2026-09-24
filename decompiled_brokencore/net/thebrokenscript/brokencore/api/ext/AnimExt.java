/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.animation.AnimationDefinition
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.animation.AnimationDefinition;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"timeLength", "", "Lnet/minecraft/client/animation/AnimationDefinition;", "getTimeLength", "(Lnet/minecraft/client/animation/AnimationDefinition;)D", "brokencore-common"})
@JvmName(name="AnimExt")
public final class AnimExt {
    public static final double getTimeLength(@NotNull AnimationDefinition $this$timeLength) {
        Intrinsics.checkNotNullParameter((Object)$this$timeLength, (String)"<this>");
        return (double)((long)$this$timeLength.lengthInSeconds() * 1000L) * 1.2;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.RequiresOptIn
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 */
package net.thebrokenscript.brokencore.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Retention(value=AnnotationRetention.BINARY)
@Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION})
@java.lang.annotation.Retention(value=RetentionPolicy.CLASS)
@java.lang.annotation.Target(value={ElementType.TYPE, ElementType.METHOD})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Lnet/thebrokenscript/brokencore/api/annotation/ExperimentalAnimationApi;", "", "brokencore-common"})
@RequiresOptIn(message="This API is incomplete and experimental. It may not produce the expected results and may break. Use with caution.")
public @interface ExperimentalAnimationApi {
}


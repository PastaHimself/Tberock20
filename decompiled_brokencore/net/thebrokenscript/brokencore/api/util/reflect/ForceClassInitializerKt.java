/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package net.thebrokenscript.brokencore.api.util.reflect;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.util.reflect.AnnotationScannerKt;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b\u00a8\u0006\u0006"}, d2={"forceInitializeClasses", "", "T", "", "classLoader", "Ljava/lang/ClassLoader;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nForceClassInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForceClassInitializer.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ForceClassInitializerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,17:1\n1869#2,2:18\n*S KotlinDebug\n*F\n+ 1 ForceClassInitializer.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ForceClassInitializerKt\n*L\n14#1:18,2\n*E\n"})
public final class ForceClassInitializerKt {
    public static final /* synthetic */ <T extends Annotation> void forceInitializeClasses(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter((Object)classLoader, (String)"classLoader");
        boolean $i$f$forceInitializeClasses = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        Iterable $this$forEach$iv = AnnotationScannerKt.scanClasses(Annotation.class, true, classLoader);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl = false;
            Class.forName(it, true, classLoader);
        }
    }

    public static /* synthetic */ void forceInitializeClasses$default(ClassLoader classLoader, int n, Object object) {
        if ((n & 1) != 0) {
            ClassLoader classLoader2 = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getClassLoader();
            Intrinsics.checkNotNullExpressionValue((Object)classLoader2, (String)"getClassLoader(...)");
            classLoader = classLoader2;
        }
        Intrinsics.checkNotNullParameter((Object)classLoader, (String)"classLoader");
        boolean $i$f$forceInitializeClasses = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        Iterable $this$forEach$iv = AnnotationScannerKt.scanClasses(Annotation.class, true, classLoader);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl = false;
            Class.forName(it, true, classLoader);
        }
    }
}


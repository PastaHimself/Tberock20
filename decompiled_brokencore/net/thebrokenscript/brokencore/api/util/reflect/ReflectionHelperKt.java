/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.full.KClassifiers
 *  kotlin.reflect.full.KTypes
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.tree.AnnotationNode
 *  org.objectweb.asm.tree.ClassNode
 */
package net.thebrokenscript.brokencore.api.util.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.full.KTypes;
import net.thebrokenscript.brokencore.api.util.ListUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\u0006H\u0086\b\u001a/\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u0006\u0012\u0002\b\u00030\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000f\"\u00020\b\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"hasAnnotation", "", "Lorg/objectweb/asm/tree/ClassNode;", "annotationType", "Lorg/objectweb/asm/Type;", "isType", "Lkotlin/reflect/KParameter;", "clazz", "Lkotlin/reflect/KClassifier;", "T", "findConstructor", "Lkotlin/reflect/KFunction;", "", "Lkotlin/reflect/KClass;", "args", "", "(Lkotlin/reflect/KClass;[Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KFunction;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nReflectionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectionHelper.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ReflectionHelperKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,23:1\n1761#2,3:24\n295#2,2:27\n*S KotlinDebug\n*F\n+ 1 ReflectionHelper.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ReflectionHelperKt\n*L\n13#1:24,3\n18#1:27,2\n*E\n"})
public final class ReflectionHelperKt {
    public static final boolean hasAnnotation(@NotNull ClassNode $this$hasAnnotation, @NotNull Type annotationType) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$hasAnnotation, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)annotationType, (String)"annotationType");
        List list = $this$hasAnnotation.visibleAnnotations;
        if (list != null) {
            boolean bl2;
            block5: {
                Iterable $this$any$iv = list;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        AnnotationNode it = (AnnotationNode)element$iv;
                        boolean bl3 = false;
                        if (!Intrinsics.areEqual((Object)it.desc, (Object)annotationType.getDescriptor())) continue;
                        bl2 = true;
                        break block5;
                    }
                    bl2 = false;
                }
            }
            bl = bl2;
        } else {
            bl = false;
        }
        return bl;
    }

    public static final boolean isType(@NotNull KParameter $this$isType, @NotNull KClassifier clazz) {
        Intrinsics.checkNotNullParameter((Object)$this$isType, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        return Intrinsics.areEqual((Object)$this$isType.getType().getClassifier(), (Object)clazz) || KTypes.isSubtypeOf((KType)$this$isType.getType(), (KType)KClassifiers.createType$default((KClassifier)clazz, null, (boolean)false, null, (int)7, null));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ <T> boolean isType(KParameter $this$isType) {
        Intrinsics.checkNotNullParameter((Object)$this$isType, (String)"<this>");
        boolean $i$f$isType = false;
        KClassifier kClassifier = $this$isType.getType().getClassifier();
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        if (Intrinsics.areEqual((Object)kClassifier, (Object)Reflection.getOrCreateKotlinClass(Object.class))) return true;
        KType kType = $this$isType.getType();
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        if (!KTypes.isSubtypeOf((KType)kType, (KType)KClassifiers.createType$default((KClassifier)((KClassifier)Reflection.getOrCreateKotlinClass(Object.class)), null, (boolean)false, null, (int)7, null))) return false;
        return true;
    }

    @Nullable
    public static final KFunction<Object> findConstructor(@NotNull KClass<?> $this$findConstructor, KClassifier ... args) {
        Object v1;
        block1: {
            Intrinsics.checkNotNullParameter($this$findConstructor, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)args, (String)"args");
            Iterable $this$firstOrNull$iv = $this$findConstructor.getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KFunction it = (KFunction)element$iv;
                boolean bl = false;
                boolean bl2 = it.getParameters().size() == args.length && ListUtilKt.allIndexed(args, (arg_0, arg_1) -> ReflectionHelperKt.findConstructor$lambda$0$0(it, arg_0, arg_1));
                if (!bl2) continue;
                v1 = element$iv;
                break block1;
            }
            v1 = null;
        }
        return v1;
    }

    private static final boolean findConstructor$lambda$0$0(KFunction $it, int i, KClassifier arg) {
        Intrinsics.checkNotNullParameter((Object)arg, (String)"arg");
        return ReflectionHelperKt.isType((KParameter)$it.getParameters().get(i), arg);
    }
}


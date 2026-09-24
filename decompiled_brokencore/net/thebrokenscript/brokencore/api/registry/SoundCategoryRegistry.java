/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.util.reflect.AnnotationScannerKt;
import net.thebrokenscript.brokencore.impl.SoundCategory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry;", "", "<init>", "()V", "initFields", "", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSoundCategoryRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundCategoryRegistry.kt\nnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,29:1\n13805#2,2:30\n*S KotlinDebug\n*F\n+ 1 SoundCategoryRegistry.kt\nnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry\n*L\n12#1:30,2\n*E\n"})
public abstract class SoundCategoryRegistry {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final List<SoundCategoryRegistry> instances = new ArrayList();

    public SoundCategoryRegistry() {
        instances.add(this);
    }

    public final void initFields() {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue((Object)fieldArray, (String)"getDeclaredFields(...)");
        Object[] $this$forEach$iv = fieldArray;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Field field = (Field)element$iv;
            boolean bl = false;
            field.get(this);
        }
    }

    @JvmStatic
    public static final void initAll(@NotNull ClassLoader classLoader) {
        Companion.initAll(classLoader);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry$Companion;", "", "<init>", "()V", "instances", "", "Lnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry;", "initAll", "", "classLoader", "Ljava/lang/ClassLoader;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nSoundCategoryRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundCategoryRegistry.kt\nnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,29:1\n1869#2,2:30\n1869#2,2:32\n*S KotlinDebug\n*F\n+ 1 SoundCategoryRegistry.kt\nnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry$Companion\n*L\n25#1:30,2\n26#1:32,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final void initAll(@NotNull ClassLoader classLoader) {
            Object it;
            Intrinsics.checkNotNullParameter((Object)classLoader, (String)"classLoader");
            Iterable $this$forEach$iv = AnnotationScannerKt.scanClasses(SoundCategory.class, false, classLoader);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (String)element$iv;
                boolean bl = false;
                Class.forName((String)it, true, classLoader);
            }
            $this$forEach$iv = instances;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (SoundCategoryRegistry)element$iv;
                boolean bl = false;
                ((SoundCategoryRegistry)it).initFields();
            }
        }

        public static /* synthetic */ void initAll$default(Companion companion, ClassLoader classLoader, int n, Object object) {
            if ((n & 1) != 0) {
                ClassLoader classLoader2 = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getClassLoader();
                Intrinsics.checkNotNullExpressionValue((Object)classLoader2, (String)"getClassLoader(...)");
                classLoader = classLoader2;
            }
            companion.initAll(classLoader);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


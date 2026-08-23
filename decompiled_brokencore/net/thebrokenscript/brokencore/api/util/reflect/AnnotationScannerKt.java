/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.tree.ClassNode
 */
package net.thebrokenscript.brokencore.api.util.reflect;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.reflect.AsmHelper;
import net.thebrokenscript.brokencore.api.util.reflect.ReflectionHelperKt;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"scanClasses", "", "", "annotation", "Ljava/lang/Class;", "", "respectSide", "", "classLoader", "Ljava/lang/ClassLoader;", "brokencore-common"})
public final class AnnotationScannerKt {
    @NotNull
    public static final List<String> scanClasses(@NotNull Class<? extends Annotation> annotation, boolean respectSide, @NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(annotation, (String)"annotation");
        Intrinsics.checkNotNullParameter((Object)classLoader, (String)"classLoader");
        Side currentSide = PlatformUtil.Companion.getSide();
        Type annotationType = AsmHelper.typeOf(annotation);
        Stream<Path> stream = classLoader.resources("").map(arg_0 -> AnnotationScannerKt.scanClasses$lambda$1(AnnotationScannerKt::scanClasses$lambda$0, arg_0));
        if (stream == null) {
            throw new IllegalStateException("Root path for class loader " + classLoader.getName() + " not found");
        }
        Stream<Path> roots = stream;
        List result = new ArrayList();
        roots.flatMap(arg_0 -> AnnotationScannerKt.scanClasses$lambda$3(AnnotationScannerKt::scanClasses$lambda$2, arg_0)).filter(arg_0 -> AnnotationScannerKt.scanClasses$lambda$5(AnnotationScannerKt::scanClasses$lambda$4, arg_0)).forEach(arg_0 -> AnnotationScannerKt.scanClasses$lambda$7(arg_0 -> AnnotationScannerKt.scanClasses$lambda$6(annotationType, classLoader, respectSide, currentSide, result, arg_0), arg_0));
        return CollectionsKt.toList((Iterable)result);
    }

    public static /* synthetic */ List scanClasses$default(Class clazz, boolean bl, ClassLoader classLoader, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        if ((n & 4) != 0) {
            ClassLoader classLoader2 = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getClassLoader();
            Intrinsics.checkNotNullExpressionValue((Object)classLoader2, (String)"getClassLoader(...)");
            classLoader = classLoader2;
        }
        return AnnotationScannerKt.scanClasses(clazz, bl, classLoader);
    }

    private static final Path scanClasses$lambda$0(URL it) {
        URI uRI = it.toURI();
        Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"toURI(...)");
        Path path = Paths.get(uRI);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
        return path;
    }

    private static final Path scanClasses$lambda$1(Function1 $tmp0, Object p0) {
        return (Path)$tmp0.invoke(p0);
    }

    private static final Stream scanClasses$lambda$2(Path it) {
        return Files.walk(it, new FileVisitOption[0]);
    }

    private static final Stream scanClasses$lambda$3(Function1 $tmp0, Object p0) {
        return (Stream)$tmp0.invoke(p0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean scanClasses$lambda$4(Path it) {
        Intrinsics.checkNotNull((Object)it);
        if (!Intrinsics.areEqual((Object)PathsKt.getExtension((Path)it), (Object)"class")) return false;
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.isRegularFile(it, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) return false;
        return true;
    }

    private static final boolean scanClasses$lambda$5(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit scanClasses$lambda$6(Type $annotationType, ClassLoader $classLoader, boolean $respectSide, Side $currentSide, List $result, Path it) {
        Intrinsics.checkNotNull((Object)it);
        byte[] byArray = Files.readAllBytes(it);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readAllBytes(...)");
        ClassNode cn = AsmHelper.ClassNode$default(byArray, 0, 2, null);
        if (ReflectionHelperKt.hasAnnotation(cn, $annotationType)) {
            try {
                String string = cn.name;
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"name");
                String className = StringsKt.replace$default((String)string, (char)'/', (char)'.', (boolean)false, (int)4, null);
                Class<?> clazz = Class.forName(className, false, $classLoader);
                if ($respectSide && clazz.isAnnotationPresent(SideOnly.class) && !clazz.getAnnotation(SideOnly.class).side().isCompatible($currentSide)) {
                    return Unit.INSTANCE;
                }
                ((Collection)$result).add(className);
            }
            catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to scan for class " + cn.name + " with annotation " + $annotationType.getClassName(), e);
            }
        }
        return Unit.INSTANCE;
    }

    private static final void scanClasses$lambda$7(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.tree.ClassNode
 */
package net.thebrokenscript.brokencore.api.util.reflect;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0011\u0010\u000b\u001a\u00020\f\"\u0006\b\u0000\u0010\r\u0018\u0001H\u0087\bJ\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0007J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0007\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/util/reflect/AsmHelper;", "", "<init>", "()V", "ClassNode", "Lorg/objectweb/asm/tree/ClassNode;", "bytes", "", "flags", "", "toByteArray", "typeOf", "Lorg/objectweb/asm/Type;", "T", "clazz", "Lkotlin/reflect/KClass;", "Ljava/lang/Class;", "brokencore-common"})
public final class AsmHelper {
    @NotNull
    public static final AsmHelper INSTANCE = new AsmHelper();

    private AsmHelper() {
    }

    @JvmStatic
    @NotNull
    public static final ClassNode ClassNode(@NotNull byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        ClassNode cn = new ClassNode();
        new ClassReader(bytes).accept((ClassVisitor)cn, flags);
        return cn;
    }

    public static /* synthetic */ ClassNode ClassNode$default(byte[] byArray, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return AsmHelper.ClassNode(byArray, n);
    }

    @JvmStatic
    @NotNull
    public static final byte[] toByteArray(@NotNull ClassNode $this$toByteArray, int flags) {
        Intrinsics.checkNotNullParameter((Object)$this$toByteArray, (String)"<this>");
        ClassWriter w = new ClassWriter(flags);
        $this$toByteArray.accept((ClassVisitor)w);
        byte[] byArray = w.toByteArray();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"toByteArray(...)");
        return byArray;
    }

    public static /* synthetic */ byte[] toByteArray$default(ClassNode classNode, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return AsmHelper.toByteArray(classNode, n);
    }

    @JvmStatic
    public static final /* synthetic */ <T> Type typeOf() {
        boolean $i$f$typeOf = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        Type type = Type.getType(Object.class);
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        return type;
    }

    @JvmStatic
    @NotNull
    public static final Type typeOf(@NotNull KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Type type = Type.getType((Class)JvmClassMappingKt.getJavaClass(clazz));
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        return type;
    }

    @JvmStatic
    @NotNull
    public static final Type typeOf(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Type type = Type.getType(clazz);
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        return type;
    }
}


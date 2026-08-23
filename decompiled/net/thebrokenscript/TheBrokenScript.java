/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.thebrokenscript.brokencore.api.engine.EngineControl
 *  net.thebrokenscript.brokencore.api.engine.EngineController
 *  net.thebrokenscript.brokencore.api.queue.WorkQueue
 *  net.thebrokenscript.brokencore.api.util.reflect.AnnotationScannerKt
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.TBSEngineControl;
import net.thebrokenscript.brokencore.api.engine.EngineControl;
import net.thebrokenscript.brokencore.api.engine.EngineController;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.brokencore.api.util.reflect.AnnotationScannerKt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/TheBrokenScript;", "", "<init>", "()V", "MOST_IMPORTANT_THING_EVER", "", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "serverWorkQueue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "init", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTheBrokenScript.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheBrokenScript.kt\nnet/thebrokenscript/TheBrokenScript\n+ 2 ForceClassInitializer.kt\nnet/thebrokenscript/brokencore/api/util/reflect/ForceClassInitializerKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,28:1\n12#2,3:29\n15#2,2:33\n1869#3:32\n1870#3:35\n*S KotlinDebug\n*F\n+ 1 TheBrokenScript.kt\nnet/thebrokenscript/TheBrokenScript\n*L\n24#1:29,3\n24#1:33,2\n24#1:32\n24#1:35\n*E\n"})
public final class TheBrokenScript {
    @NotNull
    public static final TheBrokenScript INSTANCE = new TheBrokenScript();
    @NotNull
    public static final String MOST_IMPORTANT_THING_EVER = "//:3c//";
    @JvmField
    @NotNull
    public static final Logger LOGGER;
    @JvmField
    @NotNull
    public static final WorkQueue serverWorkQueue;

    private TheBrokenScript() {
    }

    public final void init() {
        ClassLoader classLoader = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getClassLoader();
        Intrinsics.checkNotNullExpressionValue((Object)classLoader, (String)"getClassLoader(...)");
        ClassLoader classLoader$iv = classLoader;
        boolean $i$f$forceInitializeClasses = false;
        Iterable $this$forEach$iv$iv = AnnotationScannerKt.scanClasses(ForceRuntimeInit.class, (boolean)true, (ClassLoader)classLoader$iv);
        boolean $i$f$forEach = false;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            String it$iv = (String)element$iv$iv;
            boolean bl = false;
            Class.forName(it$iv, true, classLoader$iv);
        }
        EngineControl.INSTANCE.register((EngineController)new TBSEngineControl());
        TBSConfigs.INSTANCE.init();
    }

    static {
        Logger logger = LogManager.getLogger(TheBrokenScript.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
        serverWorkQueue = new WorkQueue(null, 1, null);
    }
}


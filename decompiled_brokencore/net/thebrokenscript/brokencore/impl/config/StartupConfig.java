/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KProperty
 *  net.neoforged.fml.config.ModConfig$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import net.neoforged.fml.config.ModConfig;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.impl.config.DebugConfig;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/StartupConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "<init>", "()V", "debug", "Lnet/thebrokenscript/brokencore/impl/config/DebugConfig;", "getDebug", "()Lnet/thebrokenscript/brokencore/impl/config/DebugConfig;", "debug$delegate", "Lkotlin/properties/ReadOnlyProperty;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nStartupConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartupConfig.kt\nnet/thebrokenscript/brokencore/impl/config/StartupConfig\n+ 2 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,8:1\n176#2:9\n177#2,2:12\n295#3,2:10\n*S KotlinDebug\n*F\n+ 1 StartupConfig.kt\nnet/thebrokenscript/brokencore/impl/config/StartupConfig\n*L\n7#1:9\n7#1:12,2\n7#1:10,2\n*E\n"})
public final class StartupConfig
extends Config.Base {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty debug$delegate;

    /*
     * WARNING - void declaration
     */
    public StartupConfig() {
        void comment$iv;
        void this_$iv;
        Object v0;
        block2: {
            super(ModConfig.Type.STARTUP);
            Config config = this;
            String[] stringArray = new String[]{"Debugging configuration."};
            StartupConfig startupConfig = this;
            boolean $i$f$nested = false;
            Iterable $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(DebugConfig.class).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                KFunction it$iv = (KFunction)element$iv$iv;
                boolean bl = false;
                if (!it$iv.getParameters().isEmpty()) continue;
                v0 = element$iv$iv;
                break block2;
            }
            v0 = null;
        }
        KFunction kFunction = v0;
        if (kFunction == null) {
            throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(DebugConfig.class) + " must have a single empty constructor");
        }
        KFunction constructor$iv = kFunction;
        startupConfig.debug$delegate = (ReadOnlyProperty)Config.access$nested((Config)this_$iv, (Function0)new Function0<DebugConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final DebugConfig invoke() {
                return (Config.SubGroup)this.$constructor.call(new Object[0]);
            }
        }, (String[])Arrays.copyOf(comment$iv, ((void)comment$iv).length)).provideDelegate((Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public final DebugConfig getDebug() {
        return (DebugConfig)this.debug$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(StartupConfig.class, "debug", "getDebug()Lnet/thebrokenscript/brokencore/impl/config/DebugConfig;", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


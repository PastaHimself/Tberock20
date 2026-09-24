/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.PropertyDelegateProvider
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KProperty
 *  kotlin.text.CharsKt
 *  kotlin.text.Regex
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.neoforge.common.ModConfigSpec
 *  net.neoforged.neoforge.common.ModConfigSpec$BooleanValue
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  net.neoforged.neoforge.common.ModConfigSpec$ConfigValue
 *  net.neoforged.neoforge.common.ModConfigSpec$DoubleValue
 *  net.neoforged.neoforge.common.ModConfigSpec$EnumValue
 *  net.neoforged.neoforge.common.ModConfigSpec$IntValue
 *  net.neoforged.neoforge.common.ModConfigSpec$LongValue
 *  org.jetbrains.annotations.ApiStatus$Experimental
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.util.OnceSet;
import net.thebrokenscript.brokencore.api.util.PropertiesKt;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001:\u000eMNOPQRSTUVWXYZB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0004J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cJ5\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u0010$JI\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020&0\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u0010+JK\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0-0\u001e\"\u000e\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0/2\u0006\u0010 \u001a\u0002H.2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u00100JI\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002020\u001e2\u0006\u0010'\u001a\u0002032\b\b\u0002\u0010)\u001a\u0002032\b\b\u0002\u0010*\u001a\u0002032\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u00104JI\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002060\u001e2\u0006\u0010'\u001a\u0002072\b\b\u0002\u0010)\u001a\u0002072\b\b\u0002\u0010*\u001a\u0002072\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u00108Jq\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H;0:0\u001e\"\b\b\u0000\u0010;*\u00020\u00012\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u00052\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u0002H;0\u001c2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020!0@H\u0004\u00a2\u0006\u0002\u0010AJQ\u0010B\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H;0C0\u001e\"\b\b\u0000\u0010;*\u00020\u000e2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0004\u00a2\u0006\u0002\u0010EJF\u0010B\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H;0C0\u001e\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u000e2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0084\b\u00a2\u0006\u0002\u0010FJm\u0010G\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u0002H;0H0\u001e\"\b\b\u0000\u0010I*\u00020\u0001\"\u000e\b\u0001\u0010;*\b\u0012\u0004\u0012\u0002HI0J2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H;0K2\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050#\"\u00020\u0005H\u0005\u00a2\u0006\u0002\u0010LR\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006["}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "allValues", "", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigPath;", "getAllValues", "()Ljava/util/List;", "children", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "getChildren", "registerAll", "", "builder", "Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;", "genLang", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "addConfigLang", "onLoad", "onReload", "onUnload", "values", "", "b", "Lkotlin/properties/PropertyDelegateProvider;", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "default", "", "comment", "", "(Z[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "d", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigDouble;", "current", "", "min", "max", "(DDD[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "e", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigEnum;", "E", "", "(Ljava/lang/Enum;[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "i", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigInt;", "", "(III[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "l", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigLong;", "", "(JJJ[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "list", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigList;", "T", "adder", "Lkotlin/Function0;", "initial", "validator", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;[Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lkotlin/properties/PropertyDelegateProvider;", "nested", "Lkotlin/properties/ReadOnlyProperty;", "ctor", "(Lkotlin/jvm/functions/Function0;[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "([Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "custom", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "V", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;[Ljava/lang/String;)Lkotlin/properties/PropertyDelegateProvider;", "IValueProvider", "ConfigPath", "CValue", "Factory", "GroupFactory", "ConfigBool", "ConfigDouble", "ConfigEnum", "ConfigInt", "ConfigLong", "ConfigList", "ConfigGroup", "Base", "SubGroup", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,328:1\n1869#2,2:329\n1869#2,2:331\n1869#2,2:333\n1869#2,2:335\n1869#2,2:337\n295#2,2:339\n*S KotlinDebug\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n*L\n51#1:329,2\n55#1:331,2\n68#1:333,2\n69#1:335,2\n70#1:337,2\n176#1:339,2\n*E\n"})
public abstract class Config {
    @NotNull
    private final List<ConfigPath> allValues = new ArrayList();
    @NotNull
    private final List<SubGroup> children = new ArrayList();

    @NotNull
    public abstract String getName();

    @NotNull
    protected final List<ConfigPath> getAllValues() {
        return this.allValues;
    }

    @NotNull
    protected final List<SubGroup> getChildren() {
        return this.children;
    }

    public final void registerAll(@NotNull ModConfigSpec.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Iterable $this$forEach$iv = this.allValues;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ConfigPath it = (ConfigPath)element$iv;
            boolean bl = false;
            it.register(builder);
        }
    }

    public void genLang(@NotNull BrokenReg reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SubGroup it = (SubGroup)element$iv;
            boolean bl = false;
            it.genLang(reg);
        }
    }

    protected final void addConfigLang(@NotNull BrokenReg $this$addConfigLang, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)$this$addConfigLang, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        String path = $this$addConfigLang.getModId() + ".configuration." + name;
        CharSequence charSequence = name;
        Regex regex = new Regex("(?=[A-Z])|\\.");
        int n = 0;
        $this$addConfigLang.getData().getLang().set(path, CollectionsKt.joinToString$default((Iterable)regex.split(charSequence, n), (CharSequence)" ", null, null, (int)0, null, Config::addConfigLang$lambda$0, (int)30, null));
    }

    public void onLoad() {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Config p0 = (Config)element$iv;
            boolean bl = false;
            p0.onLoad();
        }
    }

    public void onReload() {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Config p0 = (Config)element$iv;
            boolean bl = false;
            p0.onReload();
        }
    }

    public void onUnload() {
        Iterable $this$forEach$iv = this.children;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Config p0 = (Config)element$iv;
            boolean bl = false;
            p0.onUnload();
        }
    }

    @NotNull
    public final List<ConfigPath> values() {
        return CollectionsKt.toList((Iterable)this.allValues);
    }

    @NotNull
    protected final PropertyDelegateProvider<Config, ConfigBool> b(boolean bl, String ... comment) {
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.b$lambda$0(bl, comment, arg_0));
    }

    @NotNull
    protected final PropertyDelegateProvider<Config, ConfigDouble> d(double current, double min, double max, String ... comment) {
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.d$lambda$0(current, min, max, comment, arg_0));
    }

    public static /* synthetic */ PropertyDelegateProvider d$default(Config config, double d, double d2, double d3, String[] stringArray, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }
        if ((n & 2) != 0) {
            d2 = Double.NEGATIVE_INFINITY;
        }
        if ((n & 4) != 0) {
            d3 = Double.POSITIVE_INFINITY;
        }
        return config.d(d, d2, d3, stringArray);
    }

    @NotNull
    protected final <E extends Enum<E>> PropertyDelegateProvider<Config, ConfigEnum<E>> e(@NotNull E e, String ... comment) {
        Intrinsics.checkNotNullParameter(e, (String)"default");
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.e$lambda$0(e, comment, arg_0));
    }

    @NotNull
    protected final PropertyDelegateProvider<Config, ConfigInt> i(int current, int min, int max, String ... comment) {
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.i$lambda$0(current, min, max, comment, arg_0));
    }

    public static /* synthetic */ PropertyDelegateProvider i$default(Config config, int n, int n2, int n3, String[] stringArray, int n4, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }
        if ((n4 & 2) != 0) {
            n2 = Integer.MIN_VALUE;
        }
        if ((n4 & 4) != 0) {
            n3 = Integer.MAX_VALUE;
        }
        return config.i(n, n2, n3, stringArray);
    }

    @NotNull
    protected final PropertyDelegateProvider<Config, ConfigLong> l(long current, long min, long max, String ... comment) {
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.l$lambda$0(current, min, max, comment, arg_0));
    }

    public static /* synthetic */ PropertyDelegateProvider l$default(Config config, long l, long l2, long l3, String[] stringArray, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: l");
        }
        if ((n & 2) != 0) {
            l2 = Long.MIN_VALUE;
        }
        if ((n & 4) != 0) {
            l3 = Long.MAX_VALUE;
        }
        return config.l(l, l2, l3, stringArray);
    }

    @NotNull
    protected final <T> PropertyDelegateProvider<Config, ConfigList<T>> list(@NotNull Function0<? extends T> adder, @NotNull String[] comment, @NotNull List<? extends T> initial, @NotNull Function1<Object, Boolean> validator) {
        Intrinsics.checkNotNullParameter(adder, (String)"adder");
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        Intrinsics.checkNotNullParameter(initial, (String)"initial");
        Intrinsics.checkNotNullParameter(validator, (String)"validator");
        return new Factory(arg_0 -> Config.list$lambda$1(initial, adder, validator, comment, arg_0));
    }

    public static /* synthetic */ PropertyDelegateProvider list$default(Config config, Function0 function0, String[] stringArray, List list, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: list");
        }
        if ((n & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n & 8) != 0) {
            function1 = Config::list$lambda$0;
        }
        return config.list(function0, stringArray, list, (Function1<Object, Boolean>)function1);
    }

    @NotNull
    protected final <T extends SubGroup> PropertyDelegateProvider<Config, ReadOnlyProperty<Config, T>> nested(@NotNull Function0<? extends T> ctor, String ... comment) {
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new GroupFactory<T>(ctor, comment);
    }

    protected final /* synthetic */ <T extends SubGroup> PropertyDelegateProvider<Config, ReadOnlyProperty<Config, T>> nested(String ... comment) {
        Object v0;
        block2: {
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            boolean $i$f$nested = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            Iterable $this$firstOrNull$iv = Reflection.getOrCreateKotlinClass(SubGroup.class).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KFunction it = (KFunction)element$iv;
                boolean bl = false;
                if (!it.getParameters().isEmpty()) continue;
                v0 = element$iv;
                break block2;
            }
            v0 = null;
        }
        KFunction kFunction = v0;
        if (kFunction == null) {
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(SubGroup.class) + " must have a single empty constructor");
        }
        KFunction constructor = kFunction;
        Intrinsics.needClassReification();
        return this.nested(new Function0<T>(constructor){
            final /* synthetic */ KFunction<T> $constructor;
            {
                this.$constructor = $constructor;
            }

            public final T invoke() {
                return (T)((SubGroup)this.$constructor.call(new Object[0]));
            }
        }, Arrays.copyOf(comment, comment.length));
    }

    @ApiStatus.Experimental
    @NotNull
    protected final <V, T extends ModConfigSpec.ConfigValue<V>> PropertyDelegateProvider<Config, CValue<V, T>> custom(@NotNull Function2<? super ModConfigSpec.Builder, ? super String, ? extends T> ctor, String ... comment) {
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
        return new Factory(arg_0 -> Config.custom$lambda$0(comment, ctor, arg_0));
    }

    /*
     * WARNING - void declaration
     */
    private static final CharSequence addConfigLang$lambda$0(String it) {
        String string;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string2 = it;
        if (((CharSequence)string2).length() > 0) {
            void f;
            char c = string2.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            StringBuilder stringBuilder2 = stringBuilder.append((Object)(Character.isLowerCase((char)f) ? CharsKt.titlecase((char)f) : String.valueOf((char)f)));
            String string3 = string2;
            int n = 1;
            String string4 = string3.substring(n);
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
            string = stringBuilder2.append(string4).toString();
        } else {
            string = string2;
        }
        return string;
    }

    private static final ConfigBool b$lambda$0(boolean $default, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigBool(name, $default, Arrays.copyOf($comment, $comment.length));
    }

    private static final ConfigDouble d$lambda$0(double $current, double $min, double $max, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigDouble(name, $current, $min, $max, Arrays.copyOf($comment, $comment.length));
    }

    private static final ConfigEnum e$lambda$0(Enum $default, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigEnum<Enum>(name, $default, Arrays.copyOf($comment, $comment.length));
    }

    private static final ConfigInt i$lambda$0(int $current, int $min, int $max, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigInt(name, $current, $min, $max, Arrays.copyOf($comment, $comment.length));
    }

    private static final ConfigLong l$lambda$0(long $current, long $min, long $max, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigLong(name, $current, $min, $max, Arrays.copyOf($comment, $comment.length));
    }

    private static final boolean list$lambda$0(Object it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return true;
    }

    private static final ConfigList list$lambda$1(List $initial, Function0 $adder, Function1 $validator, String[] $comment, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new ConfigList(name, $initial, $adder, (Function1<Object, Boolean>)$validator, Arrays.copyOf($comment, $comment.length));
    }

    private static final CValue custom$lambda$0(String[] $comment, Function2 $ctor, String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new CValue(name, arg_0 -> Config.custom$lambda$0$0($ctor, name, arg_0), Arrays.copyOf($comment, $comment.length));
    }

    private static final ModConfigSpec.ConfigValue custom$lambda$0$0(Function2 $ctor, String $name, ModConfigSpec.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        return (ModConfigSpec.ConfigValue)$ctor.invoke((Object)builder, (Object)$name);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@@X\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "Lnet/thebrokenscript/brokencore/api/config/Config;", "type", "Lnet/neoforged/fml/config/ModConfig$Type;", "<init>", "(Lnet/neoforged/fml/config/ModConfig$Type;)V", "getType", "()Lnet/neoforged/fml/config/ModConfig$Type;", "name", "", "getName", "()Ljava/lang/String;", "<set-?>", "Lnet/neoforged/neoforge/common/ModConfigSpec;", "specification", "getSpecification", "()Lnet/neoforged/neoforge/common/ModConfigSpec;", "setSpecification$brokencore_common", "(Lnet/neoforged/neoforge/common/ModConfigSpec;)V", "specification$delegate", "Lnet/thebrokenscript/brokencore/api/util/OnceSet;", "genLang", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config$Base\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,328:1\n1869#2,2:329\n*S KotlinDebug\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config$Base\n*L\n304#1:329,2\n*E\n"})
    public static class Base
    extends Config {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final ModConfig.Type type;
        @NotNull
        private final String name;
        @NotNull
        private final OnceSet specification$delegate;

        public Base(@NotNull ModConfig.Type type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            this.type = type;
            String string = this.type.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
            this.name = string;
            this.specification$delegate = PropertiesKt.onceSet();
        }

        @NotNull
        public final ModConfig.Type getType() {
            return this.type;
        }

        @Override
        @NotNull
        public String getName() {
            return this.name;
        }

        @NotNull
        public final ModConfigSpec getSpecification() {
            return (ModConfigSpec)this.specification$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final void setSpecification$brokencore_common(@NotNull ModConfigSpec modConfigSpec) {
            Intrinsics.checkNotNullParameter((Object)modConfigSpec, (String)"<set-?>");
            this.specification$delegate.setValue(this, $$delegatedProperties[0], modConfigSpec);
        }

        @Override
        public void genLang(@NotNull BrokenReg reg) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Iterable $this$forEach$iv = this.getSpecification().getValues().valueMap().keySet();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String k = (String)element$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)k);
                this.addConfigLang(reg, k);
            }
            super.genLang(reg);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Base.class, "specification", "getSpecification()Lnet/neoforged/neoforge/common/ModConfigSpec;", 0)))};
            $$delegatedProperties = kPropertyArray;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0007B7\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\r\"\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000b\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00028\u0000\u00a2\u0006\u0002\u0010!J\"\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u00062\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'H\u0096\u0002\u00a2\u0006\u0002\u0010(J*\u0010\u0015\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00062\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010)R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R+\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00018@@BX\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\"\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u001e\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "V", "", "T", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "Lkotlin/properties/ReadWriteProperty;", "Lnet/thebrokenscript/brokencore/api/config/Config;", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigPath;", "name", "", "provider", "Lnet/thebrokenscript/brokencore/api/config/Config$IValueProvider;", "comment", "", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/config/Config$IValueProvider;[Ljava/lang/String;)V", "[Ljava/lang/String;", "<set-?>", "value", "getValue$brokencore_common", "()Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "setValue", "(Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;)V", "value$delegate", "Lnet/thebrokenscript/brokencore/api/util/OnceSet;", "register", "", "builder", "Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;", "get", "()Ljava/lang/Object;", "set", "v", "(Ljava/lang/Object;)V", "default", "getDefault", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lnet/thebrokenscript/brokencore/api/config/Config;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "(Lnet/thebrokenscript/brokencore/api/config/Config;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "brokencore-common"})
    public static class CValue<V, T extends ModConfigSpec.ConfigValue<V>>
    extends ConfigPath
    implements ReadWriteProperty<Config, V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final IValueProvider<V, T> provider;
        @NotNull
        private final String[] comment;
        @NotNull
        private final OnceSet value$delegate;

        public CValue(@NotNull String name, @NotNull IValueProvider<V, T> provider, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter(provider, (String)"provider");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name);
            this.provider = provider;
            this.comment = comment;
            this.value$delegate = PropertiesKt.onceSet();
        }

        @NotNull
        public final T getValue$brokencore_common() {
            return (T)((ModConfigSpec.ConfigValue)this.value$delegate.getValue(this, $$delegatedProperties[0]));
        }

        private final void setValue(T t) {
            this.value$delegate.setValue(this, $$delegatedProperties[0], t);
        }

        @Override
        public void register(@NotNull ModConfigSpec.Builder builder) {
            Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
            String[] stringArray = this.comment;
            ModConfigSpec.Builder builder2 = builder.comment(Arrays.copyOf(stringArray, stringArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"comment(...)");
            this.setValue(this.provider.apply(builder2));
        }

        @NotNull
        public final V get() {
            Object object = this.getValue$brokencore_common().get();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
            return (V)object;
        }

        public final void set(@NotNull V v) {
            Intrinsics.checkNotNullParameter(v, (String)"v");
            this.getValue$brokencore_common().set(v);
            System.out.println((Object)("Set config value '" + this.getName() + "' to '" + v + "'"));
        }

        @NotNull
        public final V getDefault() {
            Object object = this.getValue$brokencore_common().getDefault();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getDefault(...)");
            return (V)object;
        }

        @NotNull
        public V getValue(@NotNull Config thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
            Intrinsics.checkNotNullParameter(property, (String)"property");
            return this.get();
        }

        public void setValue(@NotNull Config thisRef, @NotNull KProperty<?> property, @NotNull V value) {
            Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
            Intrinsics.checkNotNullParameter(property, (String)"property");
            Intrinsics.checkNotNullParameter(value, (String)"value");
            this.set(value);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CValue.class, "value", "getValue$brokencore_common()Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", 0)))};
            $$delegatedProperties = kPropertyArray;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "", "Lnet/neoforged/neoforge/common/ModConfigSpec$BooleanValue;", "name", "", "def", "comment", "", "<init>", "(Ljava/lang/String;Z[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigBool
    extends CValue<Boolean, ModConfigSpec.BooleanValue> {
        public ConfigBool(@NotNull String name, boolean def, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigBool._init_$lambda$0(name, def, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.BooleanValue _init_$lambda$0(String $name, boolean $def, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.BooleanValue booleanValue = it.define($name, $def);
            Intrinsics.checkNotNullExpressionValue((Object)booleanValue, (String)"define(...)");
            return booleanValue;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigDouble;", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "", "Lnet/neoforged/neoforge/common/ModConfigSpec$DoubleValue;", "name", "", "current", "min", "max", "comment", "", "<init>", "(Ljava/lang/String;DDD[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigDouble
    extends CValue<Double, ModConfigSpec.DoubleValue> {
        public ConfigDouble(@NotNull String name, double current, double min, double max, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigDouble._init_$lambda$0(name, current, min, max, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.DoubleValue _init_$lambda$0(String $name, double $current, double $min, double $max, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.DoubleValue doubleValue = it.defineInRange($name, $current, $min, $max);
            Intrinsics.checkNotNullExpressionValue((Object)doubleValue, (String)"defineInRange(...)");
            return doubleValue;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\t\"\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigEnum;", "E", "", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "Lnet/neoforged/neoforge/common/ModConfigSpec$EnumValue;", "name", "", "defaultValue", "comment", "", "<init>", "(Ljava/lang/String;Ljava/lang/Enum;[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigEnum<E extends Enum<E>>
    extends CValue<E, ModConfigSpec.EnumValue<E>> {
        public ConfigEnum(@NotNull String name, @NotNull E defaultValue, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter(defaultValue, (String)"defaultValue");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigEnum._init_$lambda$0(name, defaultValue, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.EnumValue _init_$lambda$0(String $name, Enum $defaultValue, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.EnumValue enumValue = it.defineEnum($name, $defaultValue);
            Intrinsics.checkNotNullExpressionValue((Object)enumValue, (String)"defineEnum(...)");
            return enumValue;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigGroup;", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigPath;", "config", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "comment", "", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;[Ljava/lang/String;)V", "getConfig", "()Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "getComment", "()[Ljava/lang/String;", "[Ljava/lang/String;", "register", "", "builder", "Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;", "brokencore-common"})
    public static final class ConfigGroup
    extends ConfigPath {
        @NotNull
        private final SubGroup config;
        @NotNull
        private final String[] comment;

        public ConfigGroup(@NotNull SubGroup config, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)config, (String)"config");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(config.getName());
            this.config = config;
            this.comment = comment;
        }

        @NotNull
        public final SubGroup getConfig() {
            return this.config;
        }

        @NotNull
        public final String[] getComment() {
            return this.comment;
        }

        @Override
        public void register(@NotNull ModConfigSpec.Builder builder) {
            Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
            String[] stringArray = this.comment;
            builder.comment(Arrays.copyOf(stringArray, stringArray.length)).push(this.getName());
            this.config.registerAll(builder);
            builder.pop();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigInt;", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "", "Lnet/neoforged/neoforge/common/ModConfigSpec$IntValue;", "name", "", "current", "min", "max", "comment", "", "<init>", "(Ljava/lang/String;III[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigInt
    extends CValue<Integer, ModConfigSpec.IntValue> {
        public ConfigInt(@NotNull String name, int current, int min, int max, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigInt._init_$lambda$0(name, current, min, max, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.IntValue _init_$lambda$0(String $name, int $current, int $min, int $max, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.IntValue intValue = it.defineInRange($name, $current, $min, $max);
            Intrinsics.checkNotNullExpressionValue((Object)intValue, (String)"defineInRange(...)");
            return intValue;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022 \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00050\u0003BS\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000f\"\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigList;", "T", "", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "name", "", "initial", "adder", "Lkotlin/Function0;", "validator", "Lkotlin/Function1;", "", "comment", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigList<T>
    extends CValue<List<? extends T>, ModConfigSpec.ConfigValue<List<? extends T>>> {
        public ConfigList(@NotNull String name, @NotNull List<? extends T> initial, @NotNull Function0<? extends T> adder, @NotNull Function1<Object, Boolean> validator, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter(initial, (String)"initial");
            Intrinsics.checkNotNullParameter(adder, (String)"adder");
            Intrinsics.checkNotNullParameter(validator, (String)"validator");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigList._init_$lambda$0(name, initial, adder, validator, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.ConfigValue _init_$lambda$0(String $name, List $initial, Function0 $adder, Function1 $validator, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.ConfigValue configValue = it.defineList($name, $initial, () -> ConfigList._init_$lambda$0$0($adder), arg_0 -> ConfigList._init_$lambda$0$1($validator, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)configValue, (String)"defineList(...)");
            return configValue;
        }

        private static final Object _init_$lambda$0$0(Function0 $tmp0) {
            return $tmp0.invoke();
        }

        private static final boolean _init_$lambda$0$1(Function1 $tmp0, Object p0) {
            return (Boolean)$tmp0.invoke(p0);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigLong;", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "", "Lnet/neoforged/neoforge/common/ModConfigSpec$LongValue;", "name", "", "current", "min", "max", "comment", "", "<init>", "(Ljava/lang/String;JJJ[Ljava/lang/String;)V", "brokencore-common"})
    public static final class ConfigLong
    extends CValue<Long, ModConfigSpec.LongValue> {
        public ConfigLong(@NotNull String name, long current, long min, long max, String ... comment) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            super(name, arg_0 -> ConfigLong._init_$lambda$0(name, current, min, max, arg_0), Arrays.copyOf(comment, comment.length));
        }

        private static final ModConfigSpec.LongValue _init_$lambda$0(String $name, long $current, long $min, long $max, ModConfigSpec.Builder it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ModConfigSpec.LongValue longValue = it.defineInRange($name, $current, $min, $max);
            Intrinsics.checkNotNullExpressionValue((Object)longValue, (String)"defineInRange(...)");
            return longValue;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$ConfigPath;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "register", "", "builder", "Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;", "brokencore-common"})
    public static abstract class ConfigPath {
        @NotNull
        private final String name;

        public ConfigPath(@NotNull String name) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public abstract void register(@NotNull ModConfigSpec.Builder var1);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00062\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00050\u0007B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00028\u00022\u0006\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0096\u0002\u00a2\u0006\u0002\u0010\u0012R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$Factory;", "V", "", "T", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "C", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "Lkotlin/properties/PropertyDelegateProvider;", "Lnet/thebrokenscript/brokencore/api/config/Config;", "ctor", "Lkotlin/Function1;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/config/Config;Lkotlin/jvm/functions/Function1;)V", "provideDelegate", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lnet/thebrokenscript/brokencore/api/config/Config;Lkotlin/reflect/KProperty;)Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "brokencore-common"})
    private final class Factory<V, T extends ModConfigSpec.ConfigValue<V>, C extends CValue<V, T>>
    implements PropertyDelegateProvider<Config, C> {
        @NotNull
        private final Function1<String, C> ctor;

        public Factory(Function1<? super String, ? extends C> ctor) {
            Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
            this.ctor = ctor;
        }

        @NotNull
        public C provideDelegate(@NotNull Config thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
            Intrinsics.checkNotNullParameter(property, (String)"property");
            CValue v = (CValue)this.ctor.invoke((Object)property.getName());
            Config.this.getAllValues().add(v);
            return (C)v;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u00050\u0003B%\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u000f\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0096\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$GroupFactory;", "T", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "Lkotlin/properties/PropertyDelegateProvider;", "Lnet/thebrokenscript/brokencore/api/config/Config;", "Lkotlin/properties/ReadOnlyProperty;", "ctor", "Lkotlin/Function0;", "comment", "", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/config/Config;Lkotlin/jvm/functions/Function0;[Ljava/lang/String;)V", "[Ljava/lang/String;", "provideDelegate", "thisRef", "property", "Lkotlin/reflect/KProperty;", "brokencore-common"})
    private final class GroupFactory<T extends SubGroup>
    implements PropertyDelegateProvider<Config, ReadOnlyProperty<? super Config, ? extends T>> {
        @NotNull
        private final Function0<T> ctor;
        @NotNull
        private final String[] comment;

        public GroupFactory(@NotNull Function0<? extends T> ctor, String[] comment) {
            Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
            Intrinsics.checkNotNullParameter((Object)comment, (String)"comment");
            this.ctor = ctor;
            this.comment = comment;
        }

        @NotNull
        public ReadOnlyProperty<Config, T> provideDelegate(@NotNull Config thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
            Intrinsics.checkNotNullParameter(property, (String)"property");
            SubGroup config = (SubGroup)this.ctor.invoke();
            config.setName$brokencore_common(property.getName());
            String[] stringArray = this.comment;
            ConfigGroup group = new ConfigGroup(config, Arrays.copyOf(stringArray, stringArray.length));
            Config.this.getAllValues().add(group);
            Config.this.getChildren().add(config);
            return PropertiesKt.valOf(config);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0002J\u0015\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$IValueProvider;", "V", "", "T", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "apply", "builder", "Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;", "(Lnet/neoforged/neoforge/common/ModConfigSpec$Builder;)Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "brokencore-common"})
    public static interface IValueProvider<V, T extends ModConfigSpec.ConfigValue<V>> {
        @NotNull
        public T apply(@NotNull ModConfigSpec.Builder var1);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@PX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "Lnet/thebrokenscript/brokencore/api/config/Config;", "<init>", "()V", "<set-?>", "", "name", "getName", "()Ljava/lang/String;", "setName$brokencore_common", "(Ljava/lang/String;)V", "name$delegate", "Lnet/thebrokenscript/brokencore/api/util/OnceSet;", "genLang", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config$SubGroup\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,328:1\n1869#2,2:329\n*S KotlinDebug\n*F\n+ 1 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config$SubGroup\n*L\n321#1:329,2\n*E\n"})
    public static class SubGroup
    extends Config {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final OnceSet name$delegate = PropertiesKt.onceSet();

        @Override
        @NotNull
        public String getName() {
            return (String)this.name$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public void setName$brokencore_common(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
            this.name$delegate.setValue(this, $$delegatedProperties[0], string);
        }

        @Override
        public void genLang(@NotNull BrokenReg reg) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Iterable $this$forEach$iv = this.getAllValues();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ConfigPath v = (ConfigPath)element$iv;
                boolean bl = false;
                this.addConfigLang(reg, v.getName());
            }
            super.genLang(reg);
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SubGroup.class, "name", "getName()Ljava/lang/String;", 0)))};
            $$delegatedProperties = kPropertyArray;
        }
    }
}


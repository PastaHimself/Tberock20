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
 *  net.minecraft.data.DataProvider$Factory
 *  net.minecraft.data.PackOutput
 */
package net.thebrokenscript.brokencore.api.datagen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.thebrokenscript.brokencore.api.datagen.BaseDataGenerator;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.util.reflect.ReflectionHelperKt;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\b\u001a/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u00a8\u0006\u0007"}, d2={"factory", "Lnet/minecraft/data/DataProvider$Factory;", "T", "Lnet/thebrokenscript/brokencore/api/datagen/BaseDataGenerator;", "Lkotlin/reflect/KClass;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nDatagenUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DatagenUtil.kt\nnet/thebrokenscript/brokencore/api/datagen/DatagenUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
public final class DatagenUtilKt {
    public static final /* synthetic */ <T extends BaseDataGenerator> DataProvider.Factory<T> factory(KClass<T> $this$factory) {
        DataProvider.Factory factory2;
        Intrinsics.checkNotNullParameter($this$factory, (String)"<this>");
        boolean $i$f$factory = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        KClassifier[] kClassifierArray = new KClassifier[]{Reflection.getOrCreateKotlinClass(PackOutput.class)};
        KFunction<Object> kFunction = ReflectionHelperKt.findConstructor(Reflection.getOrCreateKotlinClass(BaseDataGenerator.class), kClassifierArray);
        if (kFunction != null) {
            KFunction<Object> ctor = kFunction;
            boolean bl = false;
            Intrinsics.needClassReification();
            factory2 = new DataProvider.Factory(ctor){
                final /* synthetic */ KFunction<Object> $ctor;
                {
                    this.$ctor = $ctor;
                }

                public final T create(PackOutput it) {
                    Object[] objectArray = new Object[]{it};
                    Object object = this.$ctor.call(objectArray);
                    Intrinsics.reifiedOperationMarker((int)1, (String)"T");
                    return (T)((BaseDataGenerator)object);
                }
            };
        } else {
            factory2 = null;
        }
        return factory2;
    }

    public static final /* synthetic */ <T extends BaseDataGenerator> DataProvider.Factory<T> factory(KClass<T> $this$factory, BrokenReg reg) {
        DataProvider.Factory factory2;
        Intrinsics.checkNotNullParameter($this$factory, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        boolean $i$f$factory = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        KClassifier[] kClassifierArray = new KClassifier[]{Reflection.getOrCreateKotlinClass(PackOutput.class), Reflection.getOrCreateKotlinClass(BrokenReg.class)};
        KFunction<Object> kFunction = ReflectionHelperKt.findConstructor(Reflection.getOrCreateKotlinClass(BaseDataGenerator.class), kClassifierArray);
        if (kFunction != null) {
            KFunction<Object> ctor = kFunction;
            boolean bl = false;
            Intrinsics.needClassReification();
            factory2 = new DataProvider.Factory(ctor, reg){
                final /* synthetic */ KFunction<Object> $ctor;
                final /* synthetic */ BrokenReg $reg;
                {
                    this.$ctor = $ctor;
                    this.$reg = $reg;
                }

                public final T create(PackOutput it) {
                    Object[] objectArray = new Object[]{it, this.$reg};
                    Object object = this.$ctor.call(objectArray);
                    Intrinsics.reifiedOperationMarker((int)1, (String)"T");
                    return (T)((BaseDataGenerator)object);
                }
            };
        } else {
            factory2 = null;
        }
        return factory2;
    }
}


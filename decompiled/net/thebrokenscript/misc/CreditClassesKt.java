/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.modules.PolymorphicModuleBuilder
 *  kotlinx.serialization.modules.SerializersModule
 *  kotlinx.serialization.modules.SerializersModuleBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import net.thebrokenscript.misc.CreditDivider;
import net.thebrokenscript.misc.CreditHeader;
import net.thebrokenscript.misc.CreditInfo;
import net.thebrokenscript.misc.CreditLines;
import net.thebrokenscript.misc.CreditSection;
import net.thebrokenscript.misc.CreditSubtitle;
import net.thebrokenscript.misc.CreditText;
import net.thebrokenscript.misc.CreditTitle;
import net.thebrokenscript.misc.Credits;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"creditsModule", "Lkotlinx/serialization/modules/SerializersModule;", "getCreditsModule", "()Lkotlinx/serialization/modules/SerializersModule;", "creditsJson", "Lkotlinx/serialization/json/Json;", "getCreditsJson", "()Lkotlinx/serialization/json/Json;", "loadCredits", "Lnet/thebrokenscript/misc/Credits;", "data", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCreditClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditClassesKt\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n+ 3 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n+ 4 PolymorphicModuleBuilder.kt\nkotlinx/serialization/modules/PolymorphicModuleBuilderKt\n*L\n1#1,101:1\n222#2:102\n31#3,2:103\n247#3,7:105\n254#3,2:119\n33#3:121\n118#4:112\n118#4:113\n118#4:114\n118#4:115\n118#4:116\n118#4:117\n118#4:118\n*S KotlinDebug\n*F\n+ 1 CreditClasses.kt\nnet/thebrokenscript/misc/CreditClassesKt\n*L\n100#1:102\n82#1:103,2\n83#1:105,7\n83#1:119,2\n82#1:121\n84#1:112\n85#1:113\n86#1:114\n87#1:115\n88#1:116\n89#1:117\n90#1:118\n*E\n"})
public final class CreditClassesKt {
    @NotNull
    private static final SerializersModule creditsModule;
    @NotNull
    private static final Json creditsJson;

    @NotNull
    public static final SerializersModule getCreditsModule() {
        return creditsModule;
    }

    @NotNull
    public static final Json getCreditsJson() {
        return creditsJson;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Credits loadCredits(@NotNull String data) {
        void this_$iv;
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Json json = creditsJson;
        String string$iv = data;
        boolean $i$f$decodeFromString = false;
        this_$iv.getSerializersModule();
        return (Credits)this_$iv.decodeFromString((DeserializationStrategy)Credits.Companion.serializer(), string$iv);
    }

    private static final Unit creditsJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setSerializersModule(creditsModule);
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setClassDiscriminator("@type");
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$polymorphic_u24default$iv;
        PolymorphicModuleBuilder $this$subclass$iv;
        PolymorphicModuleBuilder builder$iv;
        SerializersModuleBuilder builder$iv2;
        boolean $i$f$SerializersModule = false;
        SerializersModuleBuilder $this$creditsModule_u24lambda_u240 = builder$iv2 = new SerializersModuleBuilder();
        boolean bl = false;
        SerializersModuleBuilder serializersModuleBuilder = $this$creditsModule_u24lambda_u240;
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(CreditInfo.class);
        KSerializer baseSerializer$iv = null;
        boolean $i$f$polymorphic = false;
        PolymorphicModuleBuilder $this$creditsModule_u24lambda_u240_u240 = builder$iv = new PolymorphicModuleBuilder(baseClass$iv, baseSerializer$iv);
        boolean bl2 = false;
        PolymorphicModuleBuilder polymorphicModuleBuilder = $this$creditsModule_u24lambda_u240_u240;
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(CreditTitle.class);
        boolean $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditTitle.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditSubtitle.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditSubtitle.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditHeader.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditHeader.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditSection.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditSection.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditText.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditText.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditLines.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditLines.Companion.serializer());
        $this$subclass$iv = $this$creditsModule_u24lambda_u240_u240;
        clazz$iv = Reflection.getOrCreateKotlinClass(CreditDivider.class);
        $i$f$subclass = false;
        $this$subclass$iv.subclass(clazz$iv, CreditDivider.Companion.serializer());
        builder$iv.buildTo((SerializersModuleBuilder)$this$polymorphic_u24default$iv);
        creditsModule = builder$iv2.build();
        creditsJson = JsonKt.Json$default(null, CreditClassesKt::creditsJson$lambda$0, (int)1, null);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Deserializer
 *  io.wispforest.endec.Deserializer$Struct
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.SerializationContext
 *  io.wispforest.endec.Serializer
 *  io.wispforest.endec.Serializer$Struct
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructField
 *  io.wispforest.endec.impl.StructField$StructFieldException
 *  io.wispforest.owo.serialization.endec.MinecraftEndecs
 *  io.wispforest.owo.serialization.format.nbt.NbtEndec
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.full.KClasses
 *  kotlin.text.Regex
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.util.serde;

import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.Serializer;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructField;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import io.wispforest.owo.serialization.format.nbt.NbtEndec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.text.Regex;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList;
import net.thebrokenscript.brokencore.api.util.serde.WrappedUUIDSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 5*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000256B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010$J)\u0010%\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010!\u001a\u00020(H\u0016\u00a2\u0006\u0002\u0010)J)\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\n\b\u0001\u0010+\u0018\u0001*\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H+0-H\u0086\bJ2\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\b\b\u0001\u0010+*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H+0\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H+0-J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u00103\u001a\u000204H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR1\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012RD\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00160\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000\"\b\b\u0001\u0010\u0016*\u00020\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00160\f8BX\u0082\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010.\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0/X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "S", "", "Lio/wispforest/endec/StructEndec;", "clazz", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "constructor", "Lkotlin/reflect/KFunction;", "properties", "", "Lkotlin/reflect/KProperty1;", "getProperties$annotations", "()V", "fields", "Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec$FieldInfo;", "getFields", "()Ljava/util/List;", "fields$delegate", "Lkotlin/Lazy;", "fieldInfo", "F", "getFieldInfo$annotations", "(Lkotlin/reflect/KProperty1;)V", "getFieldInfo", "(Lkotlin/reflect/KProperty1;)Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec$FieldInfo;", "encodeStruct", "", "ctx", "Lio/wispforest/endec/SerializationContext;", "serializer", "Lio/wispforest/endec/Serializer;", "struct", "Lio/wispforest/endec/Serializer$Struct;", "value", "(Lio/wispforest/endec/SerializationContext;Lio/wispforest/endec/Serializer;Lio/wispforest/endec/Serializer$Struct;Ljava/lang/Object;)V", "decodeStruct", "deserializer", "Lio/wispforest/endec/Deserializer;", "Lio/wispforest/endec/Deserializer$Struct;", "(Lio/wispforest/endec/SerializationContext;Lio/wispforest/endec/Deserializer;Lio/wispforest/endec/Deserializer$Struct;)Ljava/lang/Object;", "withEndec", "T", "endec", "Lio/wispforest/endec/Endec;", "class2endec", "", "equals", "", "other", "hashCode", "", "Companion", "FieldInfo", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nKClassEndec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndec$Companion\n*L\n1#1,152:1\n1563#2:153\n1634#2,2:154\n669#2,11:156\n1636#2:167\n295#2,2:168\n295#2,2:170\n1563#2:172\n1634#2,3:173\n132#3:176\n132#3:177\n132#3:178\n132#3:179\n132#3:180\n132#3:181\n132#3:182\n132#3:183\n132#3:184\n132#3:185\n132#3:186\n132#3:187\n132#3:188\n132#3:189\n132#3:190\n132#3:191\n132#3:192\n132#3:193\n132#3:194\n132#3:195\n132#3:196\n132#3:197\n132#3:198\n132#3:199\n132#3:200\n*S KotlinDebug\n*F\n+ 1 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndec\n*L\n26#1:153\n26#1:154,2\n27#1:156,11\n26#1:167\n70#1:168,2\n75#1:170,2\n34#1:172\n34#1:173,3\n103#1:176\n104#1:177\n105#1:178\n106#1:179\n107#1:180\n108#1:181\n109#1:182\n110#1:183\n111#1:184\n112#1:185\n113#1:186\n114#1:187\n115#1:188\n116#1:189\n117#1:190\n118#1:191\n119#1:192\n120#1:193\n121#1:194\n122#1:195\n123#1:196\n124#1:197\n125#1:198\n126#1:199\n127#1:200\n*E\n"})
public final class KClassEndec<S>
implements StructEndec<S> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KClass<S> clazz;
    @NotNull
    private final KFunction<S> constructor;
    @NotNull
    private final List<KProperty1<S, Object>> properties;
    @NotNull
    private final Lazy fields$delegate;
    @NotNull
    private final Map<KClass<?>, Endec<?>> class2endec;
    @NotNull
    private static final Lazy<Map<KClass<?>, Endec<? extends Object>>> DEFAULT_ENDECS$delegate = LazyKt.lazy(KClassEndec::DEFAULT_ENDECS_delegate$lambda$0);

    /*
     * WARNING - void declaration
     */
    public KClassEndec(@NotNull KClass<S> clazz) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        this.clazz = clazz;
        KFunction kFunction = KClasses.getPrimaryConstructor(this.clazz);
        if (kFunction == null) {
            throw new IllegalStateException(("No primary constructor for " + this.clazz).toString());
        }
        this.constructor = kFunction;
        Iterable iterable = this.constructor.getParameters();
        KClassEndec kClassEndec = this;
        boolean $i$f$map = false;
        void var4_5 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Object v1;
            void p;
            Collection collection;
            block5: {
                KParameter kParameter = (KParameter)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                Iterable $this$singleOrNull$iv = KClasses.getMemberProperties(this.clazz);
                boolean $i$f$singleOrNull = false;
                Object single$iv = null;
                boolean found$iv = false;
                for (Object element$iv : $this$singleOrNull$iv) {
                    KProperty1 it = (KProperty1)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.getName(), (Object)p.getName())) continue;
                    if (found$iv) {
                        v1 = null;
                        break block5;
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
                v1 = !found$iv ? null : single$iv;
            }
            Object var19_20 = v1;
            KProperty1 kProperty1 = var19_20 instanceof KProperty1 ? (KProperty1)var19_20 : null;
            if (kProperty1 == null) {
                throw new IllegalStateException(("No property found for constructor parameter '" + p.getName() + "' in " + this.clazz).toString());
            }
            collection.add(kProperty1);
        }
        kClassEndec.properties = (List)destination$iv$iv;
        this.fields$delegate = LazyKt.lazy(() -> KClassEndec.fields_delegate$lambda$0(this));
        this.class2endec = MapsKt.toMutableMap(Companion.getDEFAULT_ENDECS());
    }

    private static /* synthetic */ void getProperties$annotations() {
    }

    private final List<FieldInfo<Object>> getFields() {
        Lazy lazy = this.fields$delegate;
        return (List)lazy.getValue();
    }

    private final <F> FieldInfo<F> getFieldInfo(KProperty1<S, ? extends F> $this$fieldInfo) {
        KClassifier kClassifier = $this$fieldInfo.getReturnType().getClassifier();
        KClass kClass = kClassifier instanceof KClass ? (KClass)kClassifier : null;
        if (kClass == null) {
            throw new IllegalStateException(("Property '" + $this$fieldInfo.getName() + "' has no classifier in " + this.clazz).toString());
        }
        KClass clazz = kClass;
        Object object = this.class2endec.get(clazz);
        Object object2 = object instanceof Endec ? object : null;
        if (object2 == null) {
            throw new IllegalStateException(("No Endec found for class " + clazz).toString());
        }
        Endec<?> endec2 = object2;
        object = $this$fieldInfo.getName();
        Regex regex = new Regex("([a-z])([A-Z])");
        String string = "$1_$2";
        String string2 = regex.replace(object, string).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        String name = string2;
        StructField field = endec2.fieldOf(name, arg_0 -> KClassEndec._get_fieldInfo_$lambda$0($this$fieldInfo, arg_0));
        String string3 = $this$fieldInfo.getName();
        Intrinsics.checkNotNull((Object)field);
        return new FieldInfo(string3, name, endec2, field);
    }

    private static /* synthetic */ void getFieldInfo$annotations(KProperty1 kProperty1) {
    }

    public void encodeStruct(@NotNull SerializationContext ctx, @NotNull Serializer<?> serializer, @NotNull Serializer.Struct struct, @NotNull S value) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        for (FieldInfo<Object> field : this.getFields()) {
            field.getField().encodeField(ctx, serializer, struct, value);
        }
    }

    @NotNull
    public S decodeStruct(@NotNull SerializationContext ctx, @NotNull Deserializer<?> deserializer, @NotNull Deserializer.Struct struct) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Map args = new LinkedHashMap();
        for (FieldInfo<Object> fieldInfo : this.getFields()) {
            KParameter param;
            Object v2;
            Ref.ObjectRef value;
            String name;
            block8: {
                Ref.BooleanRef found;
                String fName;
                block7: {
                    fName = fieldInfo.component1();
                    name = fieldInfo.component2();
                    StructField field = fieldInfo.component4();
                    value = new Ref.ObjectRef();
                    found = new Ref.BooleanRef();
                    try {
                        Unit cfr_ignored_0 = (Unit)deserializer.tryRead(new Function((Ref.ObjectRef<Object>)value, field, ctx, struct, found){
                            final /* synthetic */ Ref.ObjectRef<Object> $value;
                            final /* synthetic */ StructField<S, Object> $field;
                            final /* synthetic */ SerializationContext $ctx;
                            final /* synthetic */ Deserializer.Struct $struct;
                            final /* synthetic */ Ref.BooleanRef $found;
                            {
                                this.$value = $value;
                                this.$field = $field;
                                this.$ctx = $ctx;
                                this.$struct = $struct;
                                this.$found = $found;
                            }

                            public final void apply(Deserializer<?> it) {
                                this.$value.element = this.$field.decodeField(this.$ctx, it, this.$struct);
                                this.$found.element = true;
                            }
                        });
                    }
                    catch (StructField.StructFieldException e) {
                        KParameter param2;
                        Object v0;
                        block6: {
                            Iterable $this$firstOrNull$iv = this.constructor.getParameters();
                            boolean $i$f$firstOrNull = false;
                            for (Object element$iv : $this$firstOrNull$iv) {
                                KParameter it = (KParameter)element$iv;
                                boolean bl = false;
                                if (!Intrinsics.areEqual((Object)it.getName(), (Object)fName)) continue;
                                v0 = element$iv;
                                break block6;
                            }
                            v0 = null;
                        }
                        KParameter kParameter = param2 = (KParameter)v0;
                        if (kParameter != null ? kParameter.isOptional() : false) break block7;
                        throw e;
                    }
                }
                if (!found.element) continue;
                Iterable $this$firstOrNull$iv = this.constructor.getParameters();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    KParameter it = (KParameter)element$iv;
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)it.getName(), (Object)fName)) continue;
                    v2 = element$iv;
                    break block8;
                }
                v2 = null;
            }
            if ((KParameter)v2 == null) {
                throw new IllegalStateException(("No constructor parameter found for field '" + name + "' in " + this.clazz).toString());
            }
            args.put(param, value.element);
        }
        return (S)this.constructor.callBy(args);
    }

    public final /* synthetic */ <T> KClassEndec<S> withEndec(Endec<T> endec2) {
        Intrinsics.checkNotNullParameter(endec2, (String)"endec");
        boolean $i$f$withEndec = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return this.withEndec(Reflection.getOrCreateKotlinClass(Object.class), endec2);
    }

    @NotNull
    public final <T> KClassEndec<S> withEndec(@NotNull KClass<T> clazz, @NotNull Endec<T> endec2) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter(endec2, (String)"endec");
        this.class2endec.put(clazz, endec2);
        return this;
    }

    public boolean equals(@Nullable Object other) {
        return this == other || other instanceof KClassEndec && Intrinsics.areEqual(this.clazz, ((KClassEndec)other).clazz);
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    /*
     * WARNING - void declaration
     */
    private static final List fields_delegate$lambda$0(KClassEndec this$0) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this$0.properties;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KProperty1 kProperty1 = (KProperty1)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(this$0.getFieldInfo((KProperty1)it));
        }
        return (List)destination$iv$iv;
    }

    private static final Object _get_fieldInfo_$lambda$0(KProperty1 $this_fieldInfo, Object it) {
        Intrinsics.checkNotNull((Object)it);
        return $this_fieldInfo.get(it);
    }

    private static final Map DEFAULT_ENDECS_delegate$lambda$0() {
        Pair[] pairArray = new Pair[25];
        Companion companion = Companion;
        Endec<WrappedBlockPosList> endec2 = Endec.VOID;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"VOID");
        Object endec$iv = endec2;
        boolean $i$f$e = false;
        pairArray[0] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Void.class), (Object)endec$iv);
        Companion this_$iv = Companion;
        Endec endec3 = Endec.BOOLEAN;
        Intrinsics.checkNotNullExpressionValue((Object)endec3, (String)"BOOLEAN");
        endec$iv = endec3;
        $i$f$e = false;
        pairArray[1] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Boolean.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec4 = Endec.BYTE;
        Intrinsics.checkNotNullExpressionValue((Object)endec4, (String)"BYTE");
        endec$iv = endec4;
        $i$f$e = false;
        pairArray[2] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Byte.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec5 = Endec.SHORT;
        Intrinsics.checkNotNullExpressionValue((Object)endec5, (String)"SHORT");
        endec$iv = endec5;
        $i$f$e = false;
        pairArray[3] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Short.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec6 = Endec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)endec6, (String)"INT");
        endec$iv = endec6;
        $i$f$e = false;
        pairArray[4] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Integer.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec7 = Endec.LONG;
        Intrinsics.checkNotNullExpressionValue((Object)endec7, (String)"LONG");
        endec$iv = endec7;
        $i$f$e = false;
        pairArray[5] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Long.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec8 = Endec.FLOAT;
        Intrinsics.checkNotNullExpressionValue((Object)endec8, (String)"FLOAT");
        endec$iv = endec8;
        $i$f$e = false;
        pairArray[6] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Float.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec9 = Endec.DOUBLE;
        Intrinsics.checkNotNullExpressionValue((Object)endec9, (String)"DOUBLE");
        endec$iv = endec9;
        $i$f$e = false;
        pairArray[7] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Double.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec10 = Endec.STRING;
        Intrinsics.checkNotNullExpressionValue((Object)endec10, (String)"STRING");
        endec$iv = endec10;
        $i$f$e = false;
        pairArray[8] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(String.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec11 = Endec.BYTES;
        Intrinsics.checkNotNullExpressionValue((Object)endec11, (String)"BYTES");
        endec$iv = endec11;
        $i$f$e = false;
        pairArray[9] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(byte[].class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec12 = MinecraftEndecs.VECTOR3F;
        Intrinsics.checkNotNullExpressionValue((Object)endec12, (String)"VECTOR3F");
        endec$iv = endec12;
        $i$f$e = false;
        pairArray[10] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Vector3f.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec13 = MinecraftEndecs.BLOCK_POS;
        Intrinsics.checkNotNullExpressionValue((Object)endec13, (String)"BLOCK_POS");
        endec$iv = endec13;
        $i$f$e = false;
        pairArray[11] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(BlockPos.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec14 = MinecraftEndecs.VEC3D;
        Intrinsics.checkNotNullExpressionValue((Object)endec14, (String)"VEC3D");
        endec$iv = endec14;
        $i$f$e = false;
        pairArray[12] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Vec3.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec15 = MinecraftEndecs.VEC3I;
        Intrinsics.checkNotNullExpressionValue((Object)endec15, (String)"VEC3I");
        endec$iv = endec15;
        $i$f$e = false;
        pairArray[13] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Vec3i.class), (Object)endec$iv);
        this_$iv = Companion;
        endec$iv = ExtraEndecs.VECTOR4F;
        $i$f$e = false;
        pairArray[14] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Vector4f.class), endec$iv);
        this_$iv = Companion;
        Endec<WrappedBlockPosList> endec16 = MinecraftEndecs.BLOCK_HIT_RESULT;
        Intrinsics.checkNotNullExpressionValue((Object)endec16, (String)"BLOCK_HIT_RESULT");
        endec$iv = endec16;
        $i$f$e = false;
        pairArray[15] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(BlockHitResult.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec17 = MinecraftEndecs.CHUNK_POS;
        Intrinsics.checkNotNullExpressionValue((Object)endec17, (String)"CHUNK_POS");
        endec$iv = endec17;
        $i$f$e = false;
        pairArray[16] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(ChunkPos.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec18 = MinecraftEndecs.TEXT;
        Intrinsics.checkNotNullExpressionValue((Object)endec18, (String)"TEXT");
        endec$iv = endec18;
        $i$f$e = false;
        pairArray[17] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Component.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec19 = MinecraftEndecs.PACKET_BYTE_BUF;
        Intrinsics.checkNotNullExpressionValue((Object)endec19, (String)"PACKET_BYTE_BUF");
        endec$iv = endec19;
        $i$f$e = false;
        pairArray[18] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(FriendlyByteBuf.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec20 = MinecraftEndecs.ITEM_STACK;
        Intrinsics.checkNotNullExpressionValue((Object)endec20, (String)"ITEM_STACK");
        endec$iv = endec20;
        $i$f$e = false;
        pairArray[19] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(ItemStack.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec21 = MinecraftEndecs.IDENTIFIER;
        Intrinsics.checkNotNullExpressionValue((Object)endec21, (String)"IDENTIFIER");
        endec$iv = endec21;
        $i$f$e = false;
        pairArray[20] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(ResourceLocation.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec22 = NbtEndec.ELEMENT;
        Intrinsics.checkNotNullExpressionValue((Object)endec22, (String)"ELEMENT");
        endec$iv = endec22;
        $i$f$e = false;
        pairArray[21] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Tag.class), (Object)endec$iv);
        this_$iv = Companion;
        Endec endec23 = NbtEndec.COMPOUND;
        Intrinsics.checkNotNullExpressionValue((Object)endec23, (String)"COMPOUND");
        endec$iv = endec23;
        $i$f$e = false;
        pairArray[22] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(CompoundTag.class), (Object)endec$iv);
        this_$iv = Companion;
        endec$iv = ExtraEndecs.BLOCK_POS_LIST;
        $i$f$e = false;
        pairArray[23] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(WrappedBlockPosList.class), endec$iv);
        this_$iv = Companion;
        endec$iv = ExtraEndecs.UUID_SET;
        $i$f$e = false;
        pairArray[24] = TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(WrappedUUIDSet.class), endec$iv);
        return MapsKt.mapOf((Pair[])pairArray);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00070\r\"\n\b\u0001\u0010\u000e\u0018\u0001*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0082\bR/\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec$Companion;", "", "<init>", "()V", "DEFAULT_ENDECS", "", "Lkotlin/reflect/KClass;", "Lio/wispforest/endec/Endec;", "getDEFAULT_ENDECS", "()Ljava/util/Map;", "DEFAULT_ENDECS$delegate", "Lkotlin/Lazy;", "e", "Lkotlin/Pair;", "T", "endec", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Map<KClass<?>, Endec<?>> getDEFAULT_ENDECS() {
            Lazy lazy = DEFAULT_ENDECS$delegate;
            return (Map)lazy.getValue();
        }

        private final /* synthetic */ <T> Pair<KClass<T>, Endec<T>> e(Endec<T> endec2) {
            boolean $i$f$e = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            return TuplesKt.to((Object)Reflection.getOrCreateKotlinClass(Object.class), endec2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0014\u001a\u00020\u0004H\u0086\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\u0002J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec$FieldInfo;", "F", "", "fieldName", "", "serializedName", "endec", "Lio/wispforest/endec/Endec;", "field", "Lio/wispforest/endec/impl/StructField;", "<init>", "(Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;Ljava/lang/String;Ljava/lang/String;Lio/wispforest/endec/Endec;Lio/wispforest/endec/impl/StructField;)V", "getFieldName", "()Ljava/lang/String;", "getSerializedName", "getEndec", "()Lio/wispforest/endec/Endec;", "getField", "()Lio/wispforest/endec/impl/StructField;", "component1", "component2", "component3", "component4", "brokencore-common"})
    private final class FieldInfo<F> {
        @NotNull
        private final String fieldName;
        @NotNull
        private final String serializedName;
        @NotNull
        private final Endec<F> endec;
        @NotNull
        private final StructField<S, F> field;

        public FieldInfo(@NotNull String fieldName, @NotNull String serializedName, @NotNull Endec<F> endec2, StructField<S, F> field) {
            Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
            Intrinsics.checkNotNullParameter((Object)serializedName, (String)"serializedName");
            Intrinsics.checkNotNullParameter(endec2, (String)"endec");
            Intrinsics.checkNotNullParameter(field, (String)"field");
            this.fieldName = fieldName;
            this.serializedName = serializedName;
            this.endec = endec2;
            this.field = field;
        }

        @NotNull
        public final String getFieldName() {
            return this.fieldName;
        }

        @NotNull
        public final String getSerializedName() {
            return this.serializedName;
        }

        @NotNull
        public final Endec<F> getEndec() {
            return this.endec;
        }

        @NotNull
        public final StructField<S, F> getField() {
            return this.field;
        }

        @NotNull
        public final String component1() {
            return this.fieldName;
        }

        @NotNull
        public final String component2() {
            return this.serializedName;
        }

        @NotNull
        public final Endec<F> component3() {
            return this.endec;
        }

        @NotNull
        public final StructField<S, F> component4() {
            return this.field;
        }
    }
}


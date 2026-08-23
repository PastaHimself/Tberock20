/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ObjectArrays
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.resources.model.BlockModelRotation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import compat.net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.resources.model.BlockModelRotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0019"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "", "model", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "rotationX", "", "rotationY", "uvLock", "", "weight", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;IIZI)V", "getModel", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "getRotationX", "()I", "getRotationY", "getUvLock", "()Z", "getWeight", "toJSON", "Lcom/google/gson/JsonObject;", "includeWeight", "Builder", "Companion", "brokencore-common"})
public final class ConfiguredModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ModelFile model;
    private final int rotationX;
    private final int rotationY;
    private final boolean uvLock;
    private final int weight;
    public static final int DEFAULT_WEIGHT = 1;

    @JvmOverloads
    public ConfiguredModel(@NotNull ModelFile model, int rotationX, int rotationY, boolean uvLock, int weight) {
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this.model = model;
        Companion.checkRotation(rotationX, rotationY);
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.uvLock = uvLock;
        Companion.checkWeight(weight);
        this.weight = weight;
    }

    public /* synthetic */ ConfiguredModel(ModelFile modelFile, int n, int n2, boolean bl, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 2) != 0) {
            n = 0;
        }
        if ((n4 & 4) != 0) {
            n2 = 0;
        }
        if ((n4 & 8) != 0) {
            bl = false;
        }
        if ((n4 & 0x10) != 0) {
            n3 = 1;
        }
        this(modelFile, n, n2, bl, n3);
    }

    @NotNull
    public final ModelFile getModel() {
        return this.model;
    }

    public final int getRotationX() {
        return this.rotationX;
    }

    public final int getRotationY() {
        return this.rotationY;
    }

    public final boolean getUvLock() {
        return this.uvLock;
    }

    public final int getWeight() {
        return this.weight;
    }

    @NotNull
    public final JsonObject toJSON(boolean includeWeight) {
        JsonObject modelJson = new JsonObject();
        modelJson.addProperty("model", this.model.getLocation().toString());
        if (this.rotationX != 0) {
            modelJson.addProperty("x", (Number)this.rotationX);
        }
        if (this.rotationY != 0) {
            modelJson.addProperty("y", (Number)this.rotationY);
        }
        if (this.uvLock) {
            modelJson.addProperty("uvlock", Boolean.valueOf(this.uvLock));
        }
        if (includeWeight && this.weight != 1) {
            modelJson.addProperty("weight", (Number)this.weight);
        }
        return modelJson;
    }

    @JvmOverloads
    public ConfiguredModel(@NotNull ModelFile model, int rotationX, int rotationY, boolean uvLock) {
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this(model, rotationX, rotationY, uvLock, 0, 16, null);
    }

    @JvmOverloads
    public ConfiguredModel(@NotNull ModelFile model, int rotationX, int rotationY) {
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this(model, rotationX, rotationY, false, 0, 24, null);
    }

    @JvmOverloads
    public ConfiguredModel(@NotNull ModelFile model, int rotationX) {
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this(model, rotationX, 0, false, 0, 28, null);
    }

    @JvmOverloads
    public ConfiguredModel(@NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this(model, 0, 0, false, 0, 30, null);
    }

    @JvmStatic
    @NotNull
    public static final Builder<VariantBlockStateBuilder> builder(@NotNull VariantBlockStateBuilder outer, @NotNull VariantBlockStateBuilder.PartialBlockstate state) {
        return Companion.builder(outer, state);
    }

    @JvmStatic
    @NotNull
    public static final Builder<MultiPartBlockStateBuilder.PartBuilder> builder(@NotNull MultiPartBlockStateBuilder outer) {
        return Companion.builder(outer);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B7\b\u0001\u0012\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0011\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000R\"\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder;", "T", "", "callback", "Ljava/util/function/Function;", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "otherModels", "", "<init>", "(Ljava/util/function/Function;Ljava/util/List;)V", "model", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "rotationX", "", "rotationY", "uvLock", "", "weight", "modelFile", "value", "buildLast", "build", "()[Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "addModel", "()Ljava/lang/Object;", "nextModel", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nConfiguredModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfiguredModel.kt\ncompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,303:1\n37#2,2:304\n*S KotlinDebug\n*F\n+ 1 ConfiguredModel.kt\ncompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder\n*L\n184#1:304,2\n*E\n"})
    public static final class Builder<T> {
        @Nullable
        private final Function<ConfiguredModel[], T> callback;
        @NotNull
        private final List<ConfiguredModel> otherModels;
        @Nullable
        private ModelFile model;
        private int rotationX;
        private int rotationY;
        private boolean uvLock;
        private int weight;

        @JvmOverloads
        public Builder(@Nullable Function<ConfiguredModel[], T> callback, @NotNull List<ConfiguredModel> otherModels) {
            Intrinsics.checkNotNullParameter(otherModels, (String)"otherModels");
            this.callback = callback;
            this.otherModels = otherModels;
            this.weight = 1;
        }

        public /* synthetic */ Builder(Function function, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                function = null;
            }
            if ((n & 2) != 0) {
                ImmutableList immutableList = ImmutableList.of();
                Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"of(...)");
                list = (List)immutableList;
            }
            this(function, list);
        }

        @NotNull
        public final Builder<T> modelFile(@NotNull ModelFile model) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            Preconditions.checkNotNull((Object)model, (String)"Model must not be null", (Object[])new Object[0]);
            this.model = model;
            return this;
        }

        @NotNull
        public final Builder<T> rotationX(int value) {
            Companion.checkRotation(value, this.rotationY);
            this.rotationX = value;
            return this;
        }

        @NotNull
        public final Builder<T> rotationY(int value) {
            Companion.checkRotation(this.rotationX, value);
            this.rotationY = value;
            return this;
        }

        @NotNull
        public final Builder<T> uvLock(boolean value) {
            this.uvLock = value;
            return this;
        }

        @NotNull
        public final Builder<T> weight(int value) {
            Companion.checkWeight(value);
            this.weight = value;
            return this;
        }

        @NotNull
        public final ConfiguredModel buildLast() {
            ModelFile modelFile = this.model;
            Intrinsics.checkNotNull((Object)modelFile);
            return new ConfiguredModel(modelFile, this.rotationX, this.rotationY, this.uvLock, this.weight);
        }

        @NotNull
        public final ConfiguredModel[] build() {
            Collection $this$toTypedArray$iv = this.otherModels;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Object[] objectArray = ObjectArrays.concat((Object[])thisCollection$iv.toArray(new ConfiguredModel[0]), (Object)this.buildLast());
            Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"concat(...)");
            return (ConfiguredModel[])objectArray;
        }

        public final T addModel() {
            Preconditions.checkNotNull(this.callback, (String)"Cannot use addModel() without an owning builder present", (Object[])new Object[0]);
            Function<ConfiguredModel[], ConfiguredModel[]> function = this.callback;
            Intrinsics.checkNotNull(function);
            return function.apply(this.build());
        }

        @NotNull
        public final Builder<T> nextModel() {
            ConfiguredModel[] configuredModelArray = this.build();
            return new Builder<T>(this.callback, CollectionsKt.mutableListOf((Object[])Arrays.copyOf(configuredModelArray, configuredModelArray.length)));
        }

        @JvmOverloads
        public Builder(@Nullable Function<ConfiguredModel[], T> callback) {
            this(callback, null, 2, null);
        }

        @JvmOverloads
        public Builder() {
            this(null, null, 3, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J5\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0005J\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aJ\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001fR\u00020 0\u001a2\u0006\u0010\u001c\u001a\u00020 H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Companion;", "", "<init>", "()V", "DEFAULT_WEIGHT", "", "validRotations", "Ljava/util/stream/IntStream;", "allYRotations", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "model", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "x", "uvLock", "", "weight", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;IZI)[Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "allRotations", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;ZI)[Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "checkRotation", "", "rotationX", "rotationY", "checkWeight", "builder", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder;", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "outer", "state", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nConfiguredModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfiguredModel.kt\ncompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,303:1\n37#2,2:304\n37#2,2:312\n1374#3:306\n1460#3,5:307\n*S KotlinDebug\n*F\n+ 1 ConfiguredModel.kt\ncompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Companion\n*L\n239#1:304,2\n248#1:312,2\n248#1:306\n248#1:307,5\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        private final IntStream validRotations() {
            IntStream intStream = IntStream.range(0, 4).map(Companion::validRotations$lambda$0);
            Intrinsics.checkNotNullExpressionValue((Object)intStream, (String)"map(...)");
            return intStream;
        }

        @JvmOverloads
        @NotNull
        public final ConfiguredModel[] allYRotations(@NotNull ModelFile model, int x, boolean uvLock, int weight) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            List<ConfiguredModel> list = this.validRotations().mapToObj(arg_0 -> Companion.allYRotations$lambda$0(model, x, uvLock, weight, arg_0)).toList();
            Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
            Collection $this$toTypedArray$iv = list;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            return thisCollection$iv.toArray(new ConfiguredModel[0]);
        }

        public static /* synthetic */ ConfiguredModel[] allYRotations$default(Companion companion, ModelFile modelFile, int n, boolean bl, int n2, int n3, Object object) {
            if ((n3 & 8) != 0) {
                n2 = 1;
            }
            return companion.allYRotations(modelFile, n, bl, n2);
        }

        /*
         * WARNING - void declaration
         */
        @JvmOverloads
        @NotNull
        public final ConfiguredModel[] allRotations(@NotNull ModelFile model, boolean uvLock, int weight) {
            void $this$toTypedArray$iv;
            void $this$flatMapTo$iv$iv;
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            List<ConfiguredModel[]> list = this.validRotations().mapToObj(arg_0 -> Companion.allRotations$lambda$0(model, uvLock, weight, arg_0)).toList();
            Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
            Iterable $this$flatMap$iv = list;
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                Object[] p0 = (ConfiguredModel[])element$iv$iv;
                boolean bl = false;
                Iterable list$iv$iv = ArraysKt.toList((Object[])p0);
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            $this$flatMap$iv = (List)destination$iv$iv;
            boolean $i$f$toTypedArray = false;
            void thisCollection$iv = $this$toTypedArray$iv;
            return thisCollection$iv.toArray(new ConfiguredModel[0]);
        }

        public static /* synthetic */ ConfiguredModel[] allRotations$default(Companion companion, ModelFile modelFile, boolean bl, int n, int n2, Object object) {
            if ((n2 & 4) != 0) {
                n = 1;
            }
            return companion.allRotations(modelFile, bl, n);
        }

        public final void checkRotation(int rotationX, int rotationY) {
            Preconditions.checkArgument((BlockModelRotation.by((int)rotationX, (int)rotationY) != null ? 1 : 0) != 0, (String)"Invalid model rotation x=%d, y=%d", (int)rotationX, (int)rotationY);
        }

        public final void checkWeight(int weight) {
            Preconditions.checkArgument((weight >= 1 ? 1 : 0) != 0, (String)"Model weight must be greater than or equal to 1. Found: %d", (int)weight);
        }

        @NotNull
        public final Builder<?> builder() {
            return new Builder(null, null, 3, null);
        }

        @JvmStatic
        @NotNull
        public final Builder<VariantBlockStateBuilder> builder(@NotNull VariantBlockStateBuilder outer, @NotNull VariantBlockStateBuilder.PartialBlockstate state) {
            Intrinsics.checkNotNullParameter((Object)outer, (String)"outer");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Function<ConfiguredModel[], VariantBlockStateBuilder> function = arg_0 -> Companion.builder$lambda$0(outer, state, arg_0);
            ImmutableList immutableList = ImmutableList.of();
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"of(...)");
            return new Builder<VariantBlockStateBuilder>(function, (List)immutableList);
        }

        @JvmStatic
        @NotNull
        public final Builder<MultiPartBlockStateBuilder.PartBuilder> builder(@NotNull MultiPartBlockStateBuilder outer) {
            Intrinsics.checkNotNullParameter((Object)outer, (String)"outer");
            Function<ConfiguredModel[], MultiPartBlockStateBuilder.PartBuilder> function = arg_0 -> Companion.builder$lambda$1(outer, arg_0);
            ImmutableList immutableList = ImmutableList.of();
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"of(...)");
            return new Builder<MultiPartBlockStateBuilder.PartBuilder>(function, (List)immutableList);
        }

        @JvmOverloads
        @NotNull
        public final ConfiguredModel[] allYRotations(@NotNull ModelFile model, int x, boolean uvLock) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            return compat.net.neoforged.neoforge.client.model.generators.ConfiguredModel$Companion.allYRotations$default(this, model, x, uvLock, 0, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final ConfiguredModel[] allRotations(@NotNull ModelFile model, boolean uvLock) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            return compat.net.neoforged.neoforge.client.model.generators.ConfiguredModel$Companion.allRotations$default(this, model, uvLock, 0, 4, null);
        }

        private static final int validRotations$lambda$0(int it) {
            return it * 90;
        }

        private static final ConfiguredModel allYRotations$lambda$0(ModelFile $model, int $x, boolean $uvLock, int $weight, int y) {
            return new ConfiguredModel($model, $x, y, $uvLock, $weight);
        }

        private static final ConfiguredModel[] allRotations$lambda$0(ModelFile $model, boolean $uvLock, int $weight, int x) {
            return Companion.allYRotations($model, x, $uvLock, $weight);
        }

        private static final VariantBlockStateBuilder builder$lambda$0(VariantBlockStateBuilder $outer, VariantBlockStateBuilder.PartialBlockstate $state, ConfiguredModel[] models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            return $outer.setModels($state, Arrays.copyOf(models, models.length));
        }

        private static final MultiPartBlockStateBuilder.PartBuilder builder$lambda$1(MultiPartBlockStateBuilder $outer, ConfiguredModel[] models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            MultiPartBlockStateBuilder.PartBuilder ret = new MultiPartBlockStateBuilder.PartBuilder($outer, new BlockStateProvider.ConfiguredModelList(Arrays.copyOf(models, models.length)));
            $outer.addPart(ret);
            return ret;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


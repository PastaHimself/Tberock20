/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  com.google.common.collect.UnmodifiableIterator
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import compat.net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import compat.net.neoforged.neoforge.client.model.generators.IGeneratedBlockState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001%B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J'\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\n2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010\u001d\u001a\u00020\nJ \u0010\u001e\u001a\u00020\u00002\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150 JA\u0010!\u001a\u00020\u00002\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150 2\u001a\u0010\"\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030#0\u0015\"\u0006\u0012\u0002\b\u00030#\u00a2\u0006\u0002\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/IGeneratedBlockState;", "owner", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Lnet/minecraft/world/level/block/Block;)V", "getOwner", "()Lnet/minecraft/world/level/block/Block;", "models", "", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;", "getModels", "()Ljava/util/Map;", "coveredStates", "", "Lnet/minecraft/world/level/block/state/BlockState;", "toJson", "Lcom/google/gson/JsonObject;", "addModels", "state", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "(Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;[Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "setModels", "model", "disjointToAll", "", "newState", "partialState", "forAllStates", "mapper", "Ljava/util/function/Function;", "forAllStatesExcept", "ignored", "Lnet/minecraft/world/level/block/state/properties/Property;", "(Ljava/util/function/Function;[Lnet/minecraft/world/level/block/state/properties/Property;)Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "PartialBlockstate", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nVariantBlockStateBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariantBlockStateBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,324:1\n1869#2,2:325\n*S KotlinDebug\n*F\n+ 1 VariantBlockStateBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder\n*L\n60#1:325,2\n*E\n"})
public final class VariantBlockStateBuilder
implements IGeneratedBlockState {
    @NotNull
    private final Block owner;
    @NotNull
    private final Map<PartialBlockstate, BlockStateProvider.ConfiguredModelList> models;
    @NotNull
    private final Set<BlockState> coveredStates;

    public VariantBlockStateBuilder(@NotNull Block owner) {
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        this.owner = owner;
        this.models = new LinkedHashMap();
        this.coveredStates = new HashSet();
    }

    @NotNull
    public final Block getOwner() {
        return this.owner;
    }

    @NotNull
    public final Map<PartialBlockstate, BlockStateProvider.ConfiguredModelList> getModels() {
        return this.models;
    }

    @Override
    @NotNull
    public JsonObject toJson() {
        ArrayList arrayList = Lists.newArrayList((Iterable)((Iterable)this.owner.getStateDefinition().getPossibleStates()));
        Intrinsics.checkNotNullExpressionValue((Object)arrayList, (String)"newArrayList(...)");
        List missingStates = arrayList;
        missingStates.removeAll((Collection)this.coveredStates);
        Preconditions.checkState((boolean)missingStates.isEmpty(), (String)"Blockstate for block %s does not cover all states. Missing: %s", (Object)this.owner, (Object)missingStates);
        JsonObject variants = new JsonObject();
        Iterable iterable = this.models.entrySet();
        Comparator comparator = Map.Entry.comparingByKey(PartialBlockstate.Companion.comparingByProperties());
        Intrinsics.checkNotNullExpressionValue(comparator, (String)"comparingByKey(...)");
        Iterable $this$forEach$iv = CollectionsKt.sortedWith((Iterable)iterable, comparator);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry entry = (Map.Entry)element$iv;
            boolean bl = false;
            variants.add(((PartialBlockstate)entry.getKey()).toString(), ((BlockStateProvider.ConfiguredModelList)entry.getValue()).toJSON());
        }
        JsonObject main = new JsonObject();
        main.add("variants", (JsonElement)variants);
        return main;
    }

    @NotNull
    public final VariantBlockStateBuilder addModels(@NotNull PartialBlockstate state, ConfiguredModel ... models) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)models, (String)"models");
        Preconditions.checkArgument((!(models.length == 0) ? 1 : 0) != 0, (String)"Cannot set models to empty array", (Object[])new Object[0]);
        Preconditions.checkArgument((state.getOwner() == this.owner ? 1 : 0) != 0, (String)"Cannot set models for a different block. Found: %s, Current: %s", (Object)state.getOwner(), (Object)this.owner);
        if (!this.models.containsKey(state)) {
            Preconditions.checkArgument((boolean)this.disjointToAll(state), (String)"Cannot set models for a state for which a partial match has already been configured", (Object[])new Object[0]);
            this.models.put(state, new BlockStateProvider.ConfiguredModelList(Arrays.copyOf(models, models.length)));
            UnmodifiableIterator unmodifiableIterator = this.owner.getStateDefinition().getPossibleStates().iterator();
            Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"iterator(...)");
            UnmodifiableIterator unmodifiableIterator2 = unmodifiableIterator;
            while (unmodifiableIterator2.hasNext()) {
                BlockState fullState = (BlockState)unmodifiableIterator2.next();
                Intrinsics.checkNotNull((Object)fullState);
                if (!state.test(fullState)) continue;
                this.coveredStates.add(fullState);
            }
        } else {
            this.models.compute(state, (arg_0, arg_1) -> VariantBlockStateBuilder.addModels$lambda$1((arg_0, arg_1) -> VariantBlockStateBuilder.addModels$lambda$0(models, arg_0, arg_1), arg_0, arg_1));
        }
        return this;
    }

    @NotNull
    public final VariantBlockStateBuilder setModels(@NotNull PartialBlockstate state, ConfiguredModel ... model) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        Preconditions.checkArgument((!this.models.containsKey(state) ? 1 : 0) != 0, (String)"Cannot set models for a state that has already been configured: %s", (Object)state);
        this.addModels(state, Arrays.copyOf(model, model.length));
        return this;
    }

    private final boolean disjointToAll(PartialBlockstate newState) {
        return this.coveredStates.stream().noneMatch(newState);
    }

    @NotNull
    public final PartialBlockstate partialState() {
        return new PartialBlockstate(this.owner, this);
    }

    @NotNull
    public final VariantBlockStateBuilder forAllStates(@NotNull Function<BlockState, ConfiguredModel[]> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return this.forAllStatesExcept(mapper, new Property[0]);
    }

    @NotNull
    public final VariantBlockStateBuilder forAllStatesExcept(@NotNull Function<BlockState, ConfiguredModel[]> mapper, Property<?> ... ignored) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        Intrinsics.checkNotNullParameter(ignored, (String)"ignored");
        Set seen = new HashSet();
        UnmodifiableIterator unmodifiableIterator = this.owner.getStateDefinition().getPossibleStates().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)unmodifiableIterator, (String)"iterator(...)");
        UnmodifiableIterator unmodifiableIterator2 = unmodifiableIterator;
        while (unmodifiableIterator2.hasNext()) {
            BlockState fullState = (BlockState)unmodifiableIterator2.next();
            LinkedHashMap linkedHashMap = Maps.newLinkedHashMap((Map)fullState.getValues());
            Intrinsics.checkNotNullExpressionValue((Object)linkedHashMap, (String)"newLinkedHashMap(...)");
            Map propertyValues = linkedHashMap;
            for (Property<?> p : ignored) {
                propertyValues.remove(p);
            }
            PartialBlockstate partialState = new PartialBlockstate(this.owner, propertyValues, this);
            if (!seen.add(partialState)) continue;
            ConfiguredModel[] configuredModelArray = mapper.apply(fullState);
            this.setModels(partialState, Arrays.copyOf(configuredModelArray, configuredModelArray.length));
        }
        return this;
    }

    private static final BlockStateProvider.ConfiguredModelList addModels$lambda$0(ConfiguredModel[] $models, PartialBlockstate partialBlockstate, BlockStateProvider.ConfiguredModelList cml) {
        Intrinsics.checkNotNullParameter((Object)partialBlockstate, (String)"<unused var>");
        BlockStateProvider.ConfiguredModelList configuredModelList = cml;
        return configuredModelList != null ? configuredModelList.append(Arrays.copyOf($models, $models.length)) : null;
    }

    private static final BlockStateProvider.ConfiguredModelList addModels$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        return (BlockStateProvider.ConfiguredModelList)$tmp0.invoke(p0, p1);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B5\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\rJ1\u0010\u0013\u001a\u00020\u0000\"\u000e\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00072\u0006\u0010\u0016\u001a\u0002H\u0014\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001f\u00a2\u0006\u0002\u0010 J\u001f\u0010!\u001a\u00020\n2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001f\u00a2\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0000J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020-H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006/"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "Ljava/util/function/Predicate;", "Lnet/minecraft/world/level/block/state/BlockState;", "owner", "Lnet/minecraft/world/level/block/Block;", "setStates", "", "Lnet/minecraft/world/level/block/state/properties/Property;", "", "outerBuilder", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "<init>", "(Lnet/minecraft/world/level/block/Block;Ljava/util/Map;Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;)V", "(Lnet/minecraft/world/level/block/Block;Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;)V", "getOwner", "()Lnet/minecraft/world/level/block/Block;", "Ljava/util/SortedMap;", "getSetStates", "()Ljava/util/SortedMap;", "with", "T", "prop", "value", "(Lnet/minecraft/world/level/block/state/properties/Property;Ljava/lang/Comparable;)Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "checkValidOwner", "", "modelForState", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder;", "addModels", "models", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "([Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "setModels", "([Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "partialState", "equals", "", "other", "", "hashCode", "", "test", "t", "toString", "", "Companion", "brokencore-common"})
    public static final class PartialBlockstate
    implements Predicate<BlockState> {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final Block owner;
        @NotNull
        private final VariantBlockStateBuilder outerBuilder;
        @NotNull
        private final SortedMap<Property<?>, Comparable<?>> setStates;

        public PartialBlockstate(@NotNull Block owner, @NotNull Map<Property<?>, Comparable<?>> setStates, @NotNull VariantBlockStateBuilder outerBuilder) {
            Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
            Intrinsics.checkNotNullParameter(setStates, (String)"setStates");
            Intrinsics.checkNotNullParameter((Object)outerBuilder, (String)"outerBuilder");
            this.owner = owner;
            this.outerBuilder = outerBuilder;
            for (Map.Entry<Property<?>, Comparable<?>> entry : setStates.entrySet()) {
                Property<?> prop = entry.getKey();
                Comparable<?> value = entry.getValue();
                Preconditions.checkArgument((boolean)this.owner.getStateDefinition().getProperties().contains(prop), (String)"Property %s not found on block %s", entry, (Object)this.owner);
                Collection collection = prop.getPossibleValues();
                Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getPossibleValues(...)");
                Preconditions.checkArgument((boolean)CollectionsKt.contains((Iterable)collection, value), (String)"%s is not a valid value for %s", value, prop);
            }
            TreeMap treeMap = Maps.newTreeMap(Comparator.comparing(PartialBlockstate::_init_$lambda$0));
            Intrinsics.checkNotNullExpressionValue((Object)treeMap, (String)"newTreeMap(...)");
            this.setStates = treeMap;
            ((TreeMap)this.setStates).putAll(setStates);
        }

        @NotNull
        public final Block getOwner() {
            return this.owner;
        }

        @NotNull
        public final SortedMap<Property<?>, Comparable<?>> getSetStates() {
            return this.setStates;
        }

        public PartialBlockstate(@NotNull Block owner, @NotNull VariantBlockStateBuilder outerBuilder) {
            Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
            Intrinsics.checkNotNullParameter((Object)outerBuilder, (String)"outerBuilder");
            ImmutableMap immutableMap = ImmutableMap.of();
            Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"of(...)");
            this(owner, (Map)immutableMap, outerBuilder);
        }

        @NotNull
        public final <T extends Comparable<? super T>> PartialBlockstate with(@NotNull Property<T> prop, @NotNull T value) {
            Intrinsics.checkNotNullParameter(prop, (String)"prop");
            Intrinsics.checkNotNullParameter(value, (String)"value");
            Preconditions.checkArgument((!this.setStates.containsKey(prop) ? 1 : 0) != 0, (String)"Property %s has already been set", prop);
            Map newState = new HashMap(this.setStates);
            newState.put(prop, value);
            return new PartialBlockstate(this.owner, newState, this.outerBuilder);
        }

        private final void checkValidOwner() {
            Preconditions.checkNotNull((Object)this.outerBuilder, (String)"Partial blockstate must have a valid owner to perform this action", (Object[])new Object[0]);
        }

        @NotNull
        public final ConfiguredModel.Builder<VariantBlockStateBuilder> modelForState() {
            this.checkValidOwner();
            return ConfiguredModel.Companion.builder(this.outerBuilder, this);
        }

        @NotNull
        public final PartialBlockstate addModels(ConfiguredModel ... models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            this.checkValidOwner();
            this.outerBuilder.addModels(this, Arrays.copyOf(models, models.length));
            return this;
        }

        @NotNull
        public final VariantBlockStateBuilder setModels(ConfiguredModel ... models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            this.checkValidOwner();
            return this.outerBuilder.setModels(this, Arrays.copyOf(models, models.length));
        }

        @NotNull
        public final PartialBlockstate partialState() {
            this.checkValidOwner();
            return this.outerBuilder.partialState();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !Intrinsics.areEqual(this.getClass(), other.getClass())) {
                return false;
            }
            PartialBlockstate that = (PartialBlockstate)other;
            return Intrinsics.areEqual((Object)this.owner, (Object)that.owner) && Intrinsics.areEqual(this.setStates, that.setStates);
        }

        public int hashCode() {
            Object[] objectArray = new Object[]{this.owner, this.setStates};
            return Objects.hash(objectArray);
        }

        @Override
        public boolean test(@NotNull BlockState t) {
            Intrinsics.checkNotNullParameter((Object)t, (String)"t");
            if (t.getBlock() != this.owner) {
                return false;
            }
            Iterator<Map.Entry<Property<?>, Comparable<?>>> iterator = this.setStates.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Property<?>, Comparable<?>> entry;
                Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
                if (t.getValue(entry.getKey()) == entry.getValue()) continue;
                return false;
            }
            return true;
        }

        @NotNull
        public String toString() {
            StringBuilder ret = new StringBuilder();
            Iterator<Map.Entry<Property<?>, Comparable<?>>> iterator = this.setStates.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Property<?>, Comparable<?>> entry;
                Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
                if (((CharSequence)ret).length() > 0) {
                    ret.append(',');
                }
                Property<?> property = entry.getKey();
                Intrinsics.checkNotNull(property);
                StringBuilder stringBuilder = ret.append(property.getName()).append('=');
                Property<?> property2 = entry.getKey();
                Intrinsics.checkNotNull(property2, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.state.properties.Property<kotlin.Any>");
                stringBuilder.append(property2.getName(entry.getValue()));
            }
            String string = ret.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            return string;
        }

        private static final String _init_$lambda$0(Property obj) {
            Property property = obj;
            Intrinsics.checkNotNull((Object)property);
            return property.getName();
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate$Companion;", "", "<init>", "()V", "comparingByProperties", "Ljava/util/Comparator;", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder$PartialBlockstate;", "brokencore-common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Comparator<PartialBlockstate> comparingByProperties() {
                return Companion::comparingByProperties$lambda$0;
            }

            private static final int comparingByProperties$lambda$0(PartialBlockstate s1, PartialBlockstate s2) {
                SortedSet propUniverse = new TreeSet(s1.getSetStates().comparator().reversed());
                Set<Property<?>> set = s1.getSetStates().keySet();
                Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
                propUniverse.addAll((Collection)set);
                PartialBlockstate partialBlockstate = s2;
                Intrinsics.checkNotNull((Object)partialBlockstate);
                Set<Property<?>> set2 = partialBlockstate.getSetStates().keySet();
                Intrinsics.checkNotNullExpressionValue(set2, (String)"<get-keys>(...)");
                propUniverse.addAll((Collection)set2);
                for (Property prop : propUniverse) {
                    int cmp;
                    Comparable val2;
                    Object v = s1.getSetStates().get(prop);
                    Comparable val1 = v instanceof Comparable ? (Comparable)v : null;
                    Object v2 = s2.getSetStates().get(prop);
                    Comparable comparable = val2 = v2 instanceof Comparable ? (Comparable)v2 : null;
                    if (val1 == null && val2 != null) {
                        return -1;
                    }
                    if (val2 == null && val1 != null) {
                        return 1;
                    }
                    if (val1 == null || val2 == null || (cmp = val1.compareTo(val2)) == 0) continue;
                    return cmp;
                }
                return 0;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.ListMultimap
 *  com.google.common.collect.Multimap
 *  com.google.common.collect.MultimapBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import compat.net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import compat.net.neoforged.neoforge.client.model.generators.IGeneratedBlockState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\nJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/IGeneratedBlockState;", "owner", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Lnet/minecraft/world/level/block/Block;)V", "parts", "", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "part", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel$Builder;", "addPart", "toJson", "Lcom/google/gson/JsonObject;", "PartBuilder", "Companion", "brokencore-common"})
public final class MultiPartBlockStateBuilder
implements IGeneratedBlockState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Block owner;
    @NotNull
    private final List<PartBuilder> parts;

    public MultiPartBlockStateBuilder(@NotNull Block owner) {
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        this.owner = owner;
        this.parts = new ArrayList();
    }

    @NotNull
    public final ConfiguredModel.Builder<PartBuilder> part() {
        return ConfiguredModel.Companion.builder(this);
    }

    @NotNull
    public final MultiPartBlockStateBuilder addPart(@Nullable PartBuilder part) {
        PartBuilder partBuilder = part;
        Intrinsics.checkNotNull((Object)partBuilder);
        this.parts.add(partBuilder);
        return this;
    }

    @Override
    @NotNull
    public JsonObject toJson() {
        JsonArray variants = new JsonArray();
        for (PartBuilder part : this.parts) {
            variants.add((JsonElement)part.toJson());
        }
        JsonObject main = new JsonObject();
        main.add("multipart", (JsonElement)variants);
        return main;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n0\bR\u00060\tR\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J,\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\r2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006\u0010"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$Companion;", "", "<init>", "()V", "toJson", "Lcom/google/gson/JsonObject;", "conditions", "", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder$ConditionGroup;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "useOr", "", "Lcom/google/common/collect/Multimap;", "Lnet/minecraft/world/level/block/state/properties/Property;", "", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final JsonObject toJson(List<PartBuilder.ConditionGroup> conditions, boolean useOr) {
            JsonObject groupJson = new JsonObject();
            JsonArray innerGroupJson = new JsonArray();
            groupJson.add(useOr ? "OR" : "AND", (JsonElement)innerGroupJson);
            for (PartBuilder.ConditionGroup group : conditions) {
                innerGroupJson.add((JsonElement)group.toJson());
            }
            return groupJson;
        }

        private final JsonObject toJson(Multimap<Property<?>, Comparable<?>> conditions, boolean useOr) {
            JsonObject groupJson = new JsonObject();
            for (Map.Entry e : conditions.asMap().entrySet()) {
                StringBuilder activeString = new StringBuilder();
                for (Comparable el : (Collection)e.getValue()) {
                    if (((CharSequence)activeString).length() > 0) {
                        activeString.append("|");
                    }
                    Object k = e.getKey();
                    Intrinsics.checkNotNull(k, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.state.properties.Property<kotlin.Any>");
                    Property property = (Property)k;
                    Intrinsics.checkNotNull((Object)el, (String)"null cannot be cast to non-null type kotlin.Any");
                    activeString.append(property.getName((Comparable)((Object)el)));
                }
                groupJson.addProperty(((Property)e.getKey()).getName(), activeString.toString());
            }
            if (useOr) {
                JsonArray innerWhen = new JsonArray();
                for (Map.Entry entry : groupJson.entrySet()) {
                    JsonObject obj = new JsonObject();
                    obj.add((String)entry.getKey(), (JsonElement)entry.getValue());
                    innerWhen.add((JsonElement)obj);
                }
                groupJson = new JsonObject();
                groupJson.add("OR", (JsonElement)innerWhen);
            }
            return groupJson;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001)B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u00060\u0000R\u00020\u0019JC\u0010\u001c\u001a\u00060\u0000R\u00020\u0019\"\u000e\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00122\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0 \"\u0002H\u001dH\u0007\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\n0\u0018R\u00060\u0000R\u00020\u0019J\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR%\u0010\u0010\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n0\u0018R\u00060\u0000R\u00020\u00190\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006*"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "", "models", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;)V", "getModels", "()Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;", "setModels", "(Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;)V", "useOr", "", "getUseOr", "()Z", "setUseOr", "(Z)V", "conditions", "Lcom/google/common/collect/Multimap;", "Lnet/minecraft/world/level/block/state/properties/Property;", "", "getConditions", "()Lcom/google/common/collect/Multimap;", "nestedConditionGroups", "", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder$ConditionGroup;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "getNestedConditionGroups", "()Ljava/util/List;", "condition", "T", "prop", "values", "", "(Lnet/minecraft/world/level/block/state/properties/Property;[Ljava/lang/Comparable;)Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "nestedGroup", "end", "toJson", "Lcom/google/gson/JsonObject;", "canApplyTo", "b", "Lnet/minecraft/world/level/block/Block;", "ConditionGroup", "brokencore-common"})
    public final class PartBuilder {
        @NotNull
        private BlockStateProvider.ConfiguredModelList models;
        private boolean useOr;
        @NotNull
        private final Multimap<Property<?>, Comparable<?>> conditions;
        @NotNull
        private final List<ConditionGroup> nestedConditionGroups;

        public PartBuilder(BlockStateProvider.ConfiguredModelList models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            this.models = models;
            ListMultimap listMultimap = MultimapBuilder.linkedHashKeys().arrayListValues().build();
            Intrinsics.checkNotNullExpressionValue((Object)listMultimap, (String)"build(...)");
            this.conditions = (Multimap)listMultimap;
            this.nestedConditionGroups = new ArrayList();
        }

        @NotNull
        public final BlockStateProvider.ConfiguredModelList getModels() {
            return this.models;
        }

        public final void setModels(@NotNull BlockStateProvider.ConfiguredModelList configuredModelList) {
            Intrinsics.checkNotNullParameter((Object)configuredModelList, (String)"<set-?>");
            this.models = configuredModelList;
        }

        public final boolean getUseOr() {
            return this.useOr;
        }

        public final void setUseOr(boolean bl) {
            this.useOr = bl;
        }

        @NotNull
        public final Multimap<Property<?>, Comparable<?>> getConditions() {
            return this.conditions;
        }

        @NotNull
        public final List<ConditionGroup> getNestedConditionGroups() {
            return this.nestedConditionGroups;
        }

        @NotNull
        public final PartBuilder useOr() {
            this.useOr = true;
            return this;
        }

        @SafeVarargs
        @NotNull
        public final <T extends Comparable<? super T>> PartBuilder condition(@NotNull Property<T> prop, T ... values) {
            Intrinsics.checkNotNullParameter(prop, (String)"prop");
            Intrinsics.checkNotNullParameter(values, (String)"values");
            Preconditions.checkArgument((!(values.length == 0) ? 1 : 0) != 0, (String)"Value list must not be empty", (Object[])new Object[0]);
            Preconditions.checkArgument((!this.conditions.containsKey(prop) ? 1 : 0) != 0, (String)"Cannot set condition for property \"%s\" more than once", (Object)prop.getName());
            Preconditions.checkArgument((boolean)this.canApplyTo(MultiPartBlockStateBuilder.this.owner), (String)"IProperty %s is not valid for the block %s", prop, (Object)MultiPartBlockStateBuilder.this.owner);
            Preconditions.checkState((boolean)this.nestedConditionGroups.isEmpty(), (String)"Can't have normal conditions if there are already nested condition groups", (Object[])new Object[0]);
            this.conditions.putAll(prop, (Iterable)CollectionsKt.listOf((Object[])Arrays.copyOf(values, values.length)));
            return this;
        }

        @NotNull
        public final ConditionGroup nestedGroup() {
            Preconditions.checkState((boolean)this.conditions.isEmpty(), (String)"Can't have nested condition groups if there are already normal conditions", (Object[])new Object[0]);
            ConditionGroup group = new ConditionGroup();
            this.nestedConditionGroups.add(group);
            return group;
        }

        @NotNull
        public final MultiPartBlockStateBuilder end() {
            return MultiPartBlockStateBuilder.this;
        }

        @NotNull
        public final JsonObject toJson() {
            JsonObject out = new JsonObject();
            if (!this.conditions.isEmpty()) {
                out.add("when", (JsonElement)Companion.toJson(this.conditions, this.useOr));
            } else if (!this.nestedConditionGroups.isEmpty()) {
                out.add("when", (JsonElement)Companion.toJson(this.nestedConditionGroups, this.useOr));
            }
            out.add("apply", this.models.toJSON());
            return out;
        }

        public final boolean canApplyTo(@NotNull Block b) {
            Intrinsics.checkNotNullParameter((Object)b, (String)"b");
            Collection collection = b.getStateDefinition().getProperties();
            Set set = this.conditions.keySet();
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"keySet(...)");
            return collection.containsAll(set);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0017\u001a\n0\u0000R\u00060\fR\u00020\r\"\u000e\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00062\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00180\u001b\"\u0002H\u0018H\u0007\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\n0\u0000R\u00060\fR\u00020\rJ\u000e\u0010\u001e\u001a\n0\u0000R\u00060\fR\u00020\rJ\n\u0010\u001f\u001a\u00060\fR\u00020\rJ\u000e\u0010\u0011\u001a\n0\u0000R\u00060\fR\u00020\rJ\u0006\u0010 \u001a\u00020!R%\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n0\u0000R\u00060\fR\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\f\u0018\u00010\u0000R\u00060\fR\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder$ConditionGroup;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;)V", "conditions", "Lcom/google/common/collect/Multimap;", "Lnet/minecraft/world/level/block/state/properties/Property;", "", "getConditions", "()Lcom/google/common/collect/Multimap;", "nestedConditionGroups", "", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "getNestedConditionGroups", "()Ljava/util/List;", "parent", "useOr", "", "getUseOr", "()Z", "setUseOr", "(Z)V", "condition", "T", "prop", "values", "", "(Lnet/minecraft/world/level/block/state/properties/Property;[Ljava/lang/Comparable;)Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder$ConditionGroup;", "nestedGroup", "endNestedGroup", "end", "toJson", "Lcom/google/gson/JsonObject;", "brokencore-common"})
        @SourceDebugExtension(value={"SMAP\nMultiPartBlockStateBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiPartBlockStateBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder$PartBuilder$ConditionGroup\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1#2:256\n*E\n"})
        public final class ConditionGroup {
            @NotNull
            private final Multimap<Property<?>, Comparable<?>> conditions;
            @NotNull
            private final List<ConditionGroup> nestedConditionGroups;
            @Nullable
            private ConditionGroup parent;
            private boolean useOr;

            public ConditionGroup() {
                ListMultimap listMultimap = MultimapBuilder.linkedHashKeys().arrayListValues().build();
                Intrinsics.checkNotNullExpressionValue((Object)listMultimap, (String)"build(...)");
                this.conditions = (Multimap)listMultimap;
                this.nestedConditionGroups = new ArrayList();
            }

            @NotNull
            public final Multimap<Property<?>, Comparable<?>> getConditions() {
                return this.conditions;
            }

            @NotNull
            public final List<ConditionGroup> getNestedConditionGroups() {
                return this.nestedConditionGroups;
            }

            public final boolean getUseOr() {
                return this.useOr;
            }

            public final void setUseOr(boolean bl) {
                this.useOr = bl;
            }

            @SafeVarargs
            @NotNull
            public final <T extends Comparable<? super T>> ConditionGroup condition(@NotNull Property<T> prop, T ... values) {
                Intrinsics.checkNotNullParameter(prop, (String)"prop");
                Intrinsics.checkNotNullParameter(values, (String)"values");
                Preconditions.checkArgument((!(values.length == 0) ? 1 : 0) != 0, (String)"Value list must not be empty", (Object[])new Object[0]);
                Preconditions.checkArgument((!this.conditions.containsKey(prop) ? 1 : 0) != 0, (String)"Cannot set condition for property \"%s\" more than once", (Object)prop.getName());
                Preconditions.checkArgument((boolean)PartBuilder.this.canApplyTo(MultiPartBlockStateBuilder.this.owner), (String)"IProperty %s is not valid for the block %s", prop, (Object)MultiPartBlockStateBuilder.this.owner);
                Preconditions.checkState((boolean)this.nestedConditionGroups.isEmpty(), (String)"Can't have normal conditions if there are already nested condition groups", (Object[])new Object[0]);
                this.conditions.putAll(prop, (Iterable)CollectionsKt.listOf((Object[])Arrays.copyOf(values, values.length)));
                return this;
            }

            @NotNull
            public final ConditionGroup nestedGroup() {
                Preconditions.checkState((boolean)this.conditions.isEmpty(), (String)"Can't have nested condition groups if there are already normal conditions", (Object[])new Object[0]);
                ConditionGroup group = new ConditionGroup();
                group.parent = this;
                this.nestedConditionGroups.add(group);
                return group;
            }

            @NotNull
            public final ConditionGroup endNestedGroup() {
                if (this.parent == null) {
                    boolean bl = false;
                    String string = "This condition group is not nested, use end() instead";
                    throw new IllegalStateException(string.toString());
                }
                ConditionGroup conditionGroup = this.parent;
                Intrinsics.checkNotNull((Object)conditionGroup);
                return conditionGroup;
            }

            @NotNull
            public final PartBuilder end() {
                if (!(this.parent == null)) {
                    boolean bl = false;
                    String string = "This is a nested condition group, use endNestedGroup() instead";
                    throw new IllegalStateException(string.toString());
                }
                return PartBuilder.this;
            }

            @NotNull
            public final ConditionGroup useOr() {
                this.useOr = true;
                return this;
            }

            @NotNull
            public final JsonObject toJson() {
                if (!this.conditions.isEmpty()) {
                    return Companion.toJson(this.conditions, this.useOr);
                }
                if (!this.nestedConditionGroups.isEmpty()) {
                    return Companion.toJson(this.nestedConditionGroups, this.useOr);
                }
                return new JsonObject();
            }
        }
    }
}


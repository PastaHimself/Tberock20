/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.armortrim.TrimMaterial
 *  net.minecraft.world.item.armortrim.TrimMaterials
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.ModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000f\u001a\u00060\nR\u00020\u0000J\u0012\u0010\u000f\u001a\u00060\nR\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R$\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "outputLocation", "Lnet/minecraft/resources/ResourceLocation;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "overrides", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder$OverrideBuilder;", "getOverrides", "()Ljava/util/List;", "setOverrides", "(Ljava/util/List;)V", "override", "index", "", "toJson", "Lcom/google/gson/JsonObject;", "OverrideBuilder", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nItemModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1#2:118\n1563#3:119\n1634#3,3:120\n1869#3,2:123\n*S KotlinDebug\n*F\n+ 1 ItemModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder\n*L\n68#1:119\n68#1:120,3\n68#1:123,2\n*E\n"})
public class ItemModelBuilder
extends ModelBuilder<ItemModelBuilder> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private List<OverrideBuilder> overrides;
    @NotNull
    private static final List<ResourceKey<TrimMaterial>> VANILLA_TRIM_MATERIALS;

    public ItemModelBuilder(@NotNull ResourceLocation outputLocation, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)outputLocation, (String)"outputLocation");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        super(outputLocation, existingFileHelper);
        this.overrides = new ArrayList();
        for (ResourceKey<TrimMaterial> trim : VANILLA_TRIM_MATERIALS) {
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)("trims/items/boots_trim_" + trim.location().getPath()));
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
            this.existingFileHelper.trackGenerated(resourceLocation, ModelProvider.TEXTURE);
            ResourceLocation resourceLocation2 = ResourceLocation.withDefaultNamespace((String)("trims/items/chestplate_trim_" + trim.location().getPath()));
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"withDefaultNamespace(...)");
            this.existingFileHelper.trackGenerated(resourceLocation2, ModelProvider.TEXTURE);
            ResourceLocation resourceLocation3 = ResourceLocation.withDefaultNamespace((String)("trims/items/helmet_trim_" + trim.location().getPath()));
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation3, (String)"withDefaultNamespace(...)");
            this.existingFileHelper.trackGenerated(resourceLocation3, ModelProvider.TEXTURE);
            ResourceLocation resourceLocation4 = ResourceLocation.withDefaultNamespace((String)("trims/items/leggings_trim_" + trim.location().getPath()));
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation4, (String)"withDefaultNamespace(...)");
            this.existingFileHelper.trackGenerated(resourceLocation4, ModelProvider.TEXTURE);
        }
    }

    @NotNull
    protected final List<OverrideBuilder> getOverrides() {
        return this.overrides;
    }

    protected final void setOverrides(@NotNull List<OverrideBuilder> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.overrides = list;
    }

    @NotNull
    public final OverrideBuilder override() {
        OverrideBuilder overrideBuilder = new OverrideBuilder();
        List<OverrideBuilder> list = this.overrides;
        OverrideBuilder p0 = overrideBuilder;
        boolean bl = false;
        list.add(p0);
        return overrideBuilder;
    }

    @NotNull
    public final OverrideBuilder override(int index) {
        Preconditions.checkElementIndex((int)index, (int)this.overrides.size(), (String)"override");
        return this.overrides.get(index);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public JsonObject toJson() {
        JsonObject root = super.toJson();
        if (!this.overrides.isEmpty()) {
            void $this$mapTo$iv$iv;
            JsonArray overridesJson = new JsonArray();
            Iterable $this$map$iv = this.overrides;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                OverrideBuilder overrideBuilder = (OverrideBuilder)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.toJson());
            }
            Iterable $this$forEach$iv = (List)destination$iv$iv;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                JsonObject it = (JsonObject)element$iv;
                boolean bl = false;
                overridesJson.add((JsonElement)it);
            }
            root.add("overrides", (JsonElement)overridesJson);
        }
        return root;
    }

    static {
        Object[] objectArray = new ResourceKey[]{TrimMaterials.QUARTZ, TrimMaterials.IRON, TrimMaterials.NETHERITE, TrimMaterials.REDSTONE, TrimMaterials.COPPER, TrimMaterials.GOLD, TrimMaterials.EMERALD, TrimMaterials.DIAMOND, TrimMaterials.LAPIS, TrimMaterials.AMETHYST};
        VANILLA_TRIM_MATERIALS = CollectionsKt.listOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder$Companion;", "", "<init>", "()V", "VANILLA_TRIM_MATERIALS", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/item/armortrim/TrimMaterial;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00060\u0000R\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u000b\u001a\u00060\u0000R\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder$OverrideBuilder;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder;)V", "model", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "predicates", "", "Lnet/minecraft/resources/ResourceLocation;", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder;", "predicate", "key", "value", "end", "toJson", "Lcom/google/gson/JsonObject;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nItemModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder$OverrideBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,117:1\n1#2:118\n216#3,2:119\n*S KotlinDebug\n*F\n+ 1 ItemModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ItemModelBuilder$OverrideBuilder\n*L\n93#1:119,2\n*E\n"})
    public final class OverrideBuilder {
        @Nullable
        private ModelFile model;
        @NotNull
        private final Map<ResourceLocation, Float> predicates = new LinkedHashMap();

        @NotNull
        public final OverrideBuilder model(@NotNull ModelFile model) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            this.model = model;
            model.assertExistence();
            return this;
        }

        @NotNull
        public final OverrideBuilder predicate(@NotNull ResourceLocation key, float value) {
            OverrideBuilder overrideBuilder;
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            OverrideBuilder $this$predicate_u24lambda_u240 = overrideBuilder = this;
            boolean bl = false;
            $this$predicate_u24lambda_u240.predicates.put(key, Float.valueOf(value));
            return overrideBuilder;
        }

        @NotNull
        public final ItemModelBuilder end() {
            return ItemModelBuilder.this;
        }

        @NotNull
        public final JsonObject toJson() {
            JsonObject ret = new JsonObject();
            JsonObject predicatesJson = new JsonObject();
            Map<ResourceLocation, Float> $this$forEach$iv = this.predicates;
            boolean $i$f$forEach = false;
            Iterator<Map.Entry<ResourceLocation, Float>> iterator = $this$forEach$iv.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<ResourceLocation, Float> element$iv;
                Map.Entry<ResourceLocation, Float> entry = element$iv = iterator.next();
                boolean bl = false;
                ResourceLocation k = entry.getKey();
                float v = ((Number)entry.getValue()).floatValue();
                predicatesJson.addProperty(k.toString(), (Number)Float.valueOf(v));
            }
            ret.add("predicate", (JsonElement)predicatesJson);
            ModelFile modelFile = this.model;
            Intrinsics.checkNotNull((Object)modelFile);
            ret.addProperty("model", modelFile.getLocation().toString());
            return ret;
        }
    }
}


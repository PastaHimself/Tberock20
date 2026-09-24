/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.math.Transformation
 *  compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.client.renderer.block.model.BlockElement
 *  net.minecraft.client.renderer.block.model.BlockElementFace
 *  net.minecraft.client.renderer.block.model.BlockElementRotation
 *  net.minecraft.client.renderer.block.model.BlockFaceUV
 *  net.minecraft.client.renderer.block.model.BlockModel$GuiLight
 *  net.minecraft.client.renderer.block.model.ItemTransform
 *  net.minecraft.client.renderer.texture.MissingTextureAtlasSprite
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.item.ItemDisplayContext
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.jetbrains.annotations.VisibleForTesting
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.math.Transformation;
import compat.net.neoforged.neoforge.client.model.generators.CustomLoaderBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import compat.net.neoforged.neoforge.common.util.TransformationHelper;
import compat.net.neoforged.neoforge.mixin.BlockElementAccessor;
import compat.net.neoforged.neoforge.mixin.GuiLightAccessor;
import compat.net.neoforged.neoforge.mixin.ItemTransformDeserializerAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockElementRotation;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemTransform;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0016\u0018\u0000 ]*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0005YZ[\\]B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u00105\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u00106J\b\u00107\u001a\u00020\u001dH\u0014J\u0013\u0010\t\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0002\u00108J\u001b\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0010\u00a2\u0006\u0002\u0010;J\u001b\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0004\u00a2\u0006\u0002\u0010<J\u0013\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0002\u0010=J\u0013\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0002\u0010>J\u0010\u0010\u0013\u001a\f0\u0014R\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0013\u0010?\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u001d\u00a2\u0006\u0002\u0010@J\u0013\u0010\"\u001a\u00028\u00002\u0006\u0010A\u001a\u00020#\u00a2\u0006\u0002\u0010BJ\u0010\u0010C\u001a\f0*R\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0018\u0010C\u001a\f0*R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010D\u001a\u00020EJ5\u0010-\u001a\u0002HI\"\u000e\b\u0001\u0010I*\b\u0012\u0004\u0012\u00028\u00000.2\u0018\u0010J\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002HI0K\u00a2\u0006\u0002\u0010LJ\u0010\u00103\u001a\f04R\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010M\u001a\u00020NH\u0017J\u0010\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u0010H\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0004X\u0085\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\f0\u0014R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0012\u0012\u000e\u0012\f0*R\b\u0012\u0004\u0012\u00028\u00000\u00000)X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010.X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00103\u001a\f04R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u00020E8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010H\u00a8\u0006^"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "T", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "outputLocation", "Lnet/minecraft/resources/ResourceLocation;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "parent", "getParent", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "setParent", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;)V", "textures", "", "", "getTextures", "()Ljava/util/Map;", "transforms", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder;", "getTransforms", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder;", "renderType", "getRenderType", "()Ljava/lang/String;", "setRenderType", "(Ljava/lang/String;)V", "ambientOcclusion", "", "getAmbientOcclusion", "()Z", "setAmbientOcclusion", "(Z)V", "guiLight", "Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;", "getGuiLight", "()Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;", "setGuiLight", "(Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;)V", "elements", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;", "getElements", "()Ljava/util/List;", "customLoader", "Lcompat/net/neoforged/neoforge/client/model/generators/CustomLoaderBuilder;", "getCustomLoader", "()Lcompat/net/neoforged/neoforge/client/model/generators/CustomLoaderBuilder;", "setCustomLoader", "(Lcompat/net/neoforged/neoforge/client/model/generators/CustomLoaderBuilder;)V", "rootTransforms", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$RootTransformsBuilder;", "self", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "exists", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "texture", "key", "(Ljava/lang/String;Ljava/lang/String;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "ao", "(Z)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "light", "(Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "element", "index", "", "elementCount", "getElementCount", "()I", "L", "customLoaderFactory", "Ljava/util/function/BiFunction;", "(Ljava/util/function/BiFunction;)Lcompat/net/neoforged/neoforge/client/model/generators/CustomLoaderBuilder;", "toJson", "Lcom/google/gson/JsonObject;", "serializeLocOrKey", "tex", "serializeVector3f", "Lcom/google/gson/JsonArray;", "vec", "Lorg/joml/Vector3f;", "serializeFloat", "", "f", "", "ElementBuilder", "FaceRotation", "TransformsBuilder", "RootTransformsBuilder", "Companion", "brokencore-common"})
public class ModelBuilder<T extends ModelBuilder<T>>
extends ModelFile {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    protected final ExistingFileHelper existingFileHelper;
    @Nullable
    private ModelFile parent;
    @NotNull
    private final Map<String, String> textures;
    @NotNull
    private final TransformsBuilder transforms;
    @Nullable
    private String renderType;
    private boolean ambientOcclusion;
    @Nullable
    private BlockModel.GuiLight guiLight;
    @NotNull
    private final List<ElementBuilder> elements;
    @Nullable
    private CustomLoaderBuilder<T> customLoader;
    @NotNull
    private final RootTransformsBuilder rootTransforms;
    @NotNull
    private static final Vector3f ONE = new Vector3f(1.0f, 1.0f, 1.0f);

    protected ModelBuilder(@NotNull ResourceLocation outputLocation, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)outputLocation, (String)"outputLocation");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        super(outputLocation);
        this.existingFileHelper = existingFileHelper;
        this.textures = new LinkedHashMap();
        this.transforms = new TransformsBuilder();
        this.ambientOcclusion = true;
        this.elements = new ArrayList();
        this.rootTransforms = new RootTransformsBuilder();
    }

    @Nullable
    protected final ModelFile getParent() {
        return this.parent;
    }

    protected final void setParent(@Nullable ModelFile modelFile) {
        this.parent = modelFile;
    }

    @NotNull
    protected final Map<String, String> getTextures() {
        return this.textures;
    }

    @NotNull
    protected final TransformsBuilder getTransforms() {
        return this.transforms;
    }

    @Nullable
    protected final String getRenderType() {
        return this.renderType;
    }

    protected final void setRenderType(@Nullable String string) {
        this.renderType = string;
    }

    protected final boolean getAmbientOcclusion() {
        return this.ambientOcclusion;
    }

    protected final void setAmbientOcclusion(boolean bl) {
        this.ambientOcclusion = bl;
    }

    @Nullable
    protected final BlockModel.GuiLight getGuiLight() {
        return this.guiLight;
    }

    protected final void setGuiLight(@Nullable BlockModel.GuiLight guiLight) {
        this.guiLight = guiLight;
    }

    @NotNull
    protected final List<ElementBuilder> getElements() {
        return this.elements;
    }

    @Nullable
    protected final CustomLoaderBuilder<T> getCustomLoader() {
        return this.customLoader;
    }

    protected final void setCustomLoader(@Nullable CustomLoaderBuilder<T> customLoaderBuilder) {
        this.customLoader = customLoaderBuilder;
    }

    private final T self() {
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type T of compat.net.neoforged.neoforge.client.model.generators.ModelBuilder");
        return (T)this;
    }

    @Override
    protected boolean exists() {
        return true;
    }

    @NotNull
    public final T parent(@NotNull ModelFile parent) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        parent.assertExistence();
        this.parent = parent;
        return this.self();
    }

    @NotNull
    public final T texture(@NotNull String key, @NotNull String texture) {
        ResourceLocation resourceLocation;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        if (texture.charAt(0) == '#') {
            this.textures.put(key, texture);
            return this.self();
        }
        if (StringsKt.contains$default((CharSequence)texture, (CharSequence)":", (boolean)false, (int)2, null)) {
            var4_3 = ResourceLocation.parse((String)texture);
            Intrinsics.checkNotNull((Object)var4_3);
            resourceLocation = var4_3;
        } else {
            var4_3 = ResourceLocation.fromNamespaceAndPath((String)this.getLocation().getNamespace(), (String)texture);
            Intrinsics.checkNotNull((Object)var4_3);
            resourceLocation = var4_3;
        }
        ResourceLocation asLoc = resourceLocation;
        return this.texture(key, asLoc);
    }

    @NotNull
    public final T texture(@NotNull String key, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Preconditions.checkArgument((boolean)this.existingFileHelper.exists(texture, ModelProvider.TEXTURE), (String)"Texture %s does not exist in any known resource pack", (Object)texture);
        this.textures.put(key, texture.toString());
        return this.self();
    }

    @NotNull
    public final T renderType(@NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        ResourceLocation resourceLocation = ResourceLocation.parse((String)renderType);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return this.renderType(resourceLocation);
    }

    @NotNull
    public final T renderType(@NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.renderType = renderType.toString();
        return this.self();
    }

    @NotNull
    public final TransformsBuilder transforms() {
        return this.transforms;
    }

    @NotNull
    public final T ao(boolean ao) {
        this.ambientOcclusion = ao;
        return this.self();
    }

    @NotNull
    public final T guiLight(@NotNull BlockModel.GuiLight light) {
        Intrinsics.checkNotNullParameter((Object)light, (String)"light");
        this.guiLight = light;
        return this.self();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final ElementBuilder element() {
        if (this.customLoader == null) ** GOTO lbl-1000
        v0 = this.customLoader;
        v1 = v0 != null ? v0.getAllowInlineElements() : false;
        if (v1) lbl-1000:
        // 2 sources

        {
            v2 = true;
        } else {
            v2 = false;
        }
        if (this.customLoader != null) {
            v3 = this.customLoader;
            v4 /* !! */  = v3 != null ? v3.getLoaderId() : null;
        } else {
            v4 /* !! */  = null;
        }
        Preconditions.checkState((boolean)v2, (String)"Custom model loader %s does not support inline elements", v4 /* !! */ );
        ret = new ElementBuilder();
        this.elements.add(ret);
        return ret;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final ElementBuilder element(int index) {
        if (this.customLoader == null) ** GOTO lbl-1000
        v0 = this.customLoader;
        v1 = v0 != null ? v0.getAllowInlineElements() : false;
        if (v1) lbl-1000:
        // 2 sources

        {
            v2 = true;
        } else {
            v2 = false;
        }
        if (this.customLoader != null) {
            v3 = this.customLoader;
            v4 /* !! */  = v3 != null ? v3.getLoaderId() : null;
        } else {
            v4 /* !! */  = null;
        }
        Preconditions.checkState((boolean)v2, (String)"Custom model loader %s does not support inline elements", v4 /* !! */ );
        Preconditions.checkElementIndex((int)index, (int)this.elements.size(), (String)"Element index");
        return this.elements.get(index);
    }

    public final int getElementCount() {
        return this.elements.size();
    }

    @NotNull
    public final <L extends CustomLoaderBuilder<T>> L customLoader(@NotNull BiFunction<T, ExistingFileHelper, L> customLoaderFactory) {
        Intrinsics.checkNotNullParameter(customLoaderFactory, (String)"customLoaderFactory");
        L l = customLoaderFactory.apply(this.self(), this.existingFileHelper);
        Intrinsics.checkNotNullExpressionValue(l, (String)"apply(...)");
        CustomLoaderBuilder customLoader = (CustomLoaderBuilder)l;
        Preconditions.checkState((customLoader.getAllowInlineElements() || this.elements.isEmpty() ? 1 : 0) != 0, (String)"Custom model loader %s does not support inline elements", (Object)customLoader.getLoaderId());
        this.customLoader = customLoader;
        return (L)customLoader;
    }

    @NotNull
    public final RootTransformsBuilder rootTransforms() {
        return this.rootTransforms;
    }

    @VisibleForTesting
    @NotNull
    public JsonObject toJson() {
        JsonObject transform2;
        Map<ItemDisplayContext, ItemTransform> transforms;
        JsonObject root = new JsonObject();
        if (this.parent != null) {
            ModelFile modelFile = this.parent;
            Intrinsics.checkNotNull((Object)modelFile);
            root.addProperty("parent", modelFile.getLocation().toString());
        }
        if (!this.ambientOcclusion) {
            root.addProperty("ambientocclusion", Boolean.valueOf(false));
        }
        if (this.guiLight != null) {
            BlockModel.GuiLight guiLight = this.guiLight;
            Intrinsics.checkNotNull((Object)guiLight, (String)"null cannot be cast to non-null type compat.net.neoforged.neoforge.mixin.GuiLightAccessor");
            root.addProperty("gui_light", ((GuiLightAccessor)guiLight).brokencore$getSerializedName());
        }
        if (this.renderType != null) {
            root.addProperty("render_type", this.renderType);
        }
        if (!(transforms = this.transforms.build()).isEmpty()) {
            JsonObject display = new JsonObject();
            for (Map.Entry<ItemDisplayContext, ItemTransform> entry : transforms.entrySet()) {
                JsonObject transform3 = new JsonObject();
                ItemTransform vec = entry.getValue();
                if (Intrinsics.areEqual((Object)vec, (Object)ItemTransform.NO_TRANSFORM)) continue;
                if (!Intrinsics.areEqual((Object)vec.translation, (Object)ItemTransformDeserializerAccessor.brokencore$getDefaultTranslation())) {
                    Vector3f vector3f = entry.getValue().translation;
                    Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"translation");
                    transform3.add("translation", (JsonElement)this.serializeVector3f(vector3f));
                }
                if (!Intrinsics.areEqual((Object)vec.rotation, (Object)ItemTransformDeserializerAccessor.brokencore$getDefaultRotation())) {
                    Vector3f vector3f = vec.rotation;
                    Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"rotation");
                    transform3.add("rotation", (JsonElement)this.serializeVector3f(vector3f));
                }
                if (!Intrinsics.areEqual((Object)vec.scale, (Object)ItemTransformDeserializerAccessor.brokencore$getDefaultScale())) {
                    Vector3f vector3f = entry.getValue().scale;
                    Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"scale");
                    transform3.add("scale", (JsonElement)this.serializeVector3f(vector3f));
                }
                display.add(entry.getKey().getSerializedName(), (JsonElement)transform3);
            }
            root.add("display", (JsonElement)display);
        }
        if (!this.textures.isEmpty()) {
            JsonObject textures = new JsonObject();
            for (Map.Entry<Object, Object> entry : this.textures.entrySet()) {
                textures.addProperty((String)entry.getKey(), this.serializeLocOrKey((String)entry.getValue()));
            }
            root.add("textures", (JsonElement)textures);
        }
        if (!this.elements.isEmpty()) {
            JsonArray elements = new JsonArray();
            this.elements.stream().map(arg_0 -> ModelBuilder.toJson$lambda$0(toJson.1.INSTANCE, arg_0)).forEach(arg_0 -> ModelBuilder.toJson$lambda$2(arg_0 -> ModelBuilder.toJson$lambda$1(this, elements, arg_0), arg_0));
            root.add("elements", (JsonElement)elements);
        }
        if ((transform2 = this.rootTransforms.toJson()).size() > 0) {
            root.add("transform", (JsonElement)transform2);
        }
        if (this.customLoader != null) {
            CustomLoaderBuilder<T> customLoaderBuilder = this.customLoader;
            Intrinsics.checkNotNull(customLoaderBuilder);
            return customLoaderBuilder.toJson(root);
        }
        return root;
    }

    private final String serializeLocOrKey(String tex) {
        String string;
        if (tex.charAt(0) == '#') {
            string = tex;
        } else {
            String string2 = ResourceLocation.parse((String)tex).toString();
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        }
        return string;
    }

    private final JsonArray serializeVector3f(Vector3f vec) {
        JsonArray ret = new JsonArray();
        ret.add(this.serializeFloat(vec.x()));
        ret.add(this.serializeFloat(vec.y()));
        ret.add(this.serializeFloat(vec.z()));
        return ret;
    }

    private final Number serializeFloat(float f) {
        return (float)((int)f) == f ? (Number)((int)f) : (Number)Float.valueOf(f);
    }

    private static final BlockElement toJson$lambda$0(Function1 $tmp0, Object p0) {
        return (BlockElement)$tmp0.invoke(p0);
    }

    private static final Unit toJson$lambda$1(ModelBuilder this$0, JsonArray $elements, BlockElement part) {
        JsonObject partObj = new JsonObject();
        BlockElement blockElement = part;
        Intrinsics.checkNotNull((Object)blockElement);
        Vector3f vector3f = blockElement.from;
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"from");
        partObj.add("from", (JsonElement)this$0.serializeVector3f(vector3f));
        Vector3f vector3f2 = part.to;
        Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"to");
        partObj.add("to", (JsonElement)this$0.serializeVector3f(vector3f2));
        if (part.rotation != null) {
            JsonObject rotation = new JsonObject();
            Vector3f vector3f3 = part.rotation.origin();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"origin(...)");
            rotation.add("origin", (JsonElement)this$0.serializeVector3f(vector3f3));
            rotation.addProperty("axis", part.rotation.axis().getSerializedName());
            rotation.addProperty("angle", (Number)Float.valueOf(part.rotation.angle()));
            if (part.rotation.rescale()) {
                rotation.addProperty("rescale", Boolean.valueOf(part.rotation.rescale()));
            }
            partObj.add("rotation", (JsonElement)rotation);
        }
        if (!part.shade) {
            partObj.addProperty("shade", Boolean.valueOf(false));
        }
        JsonObject faces = new JsonObject();
        for (Direction dir : EntriesMappings.entries$0) {
            BlockElementFace face2;
            if ((BlockElementFace)part.faces.get(dir) == null) continue;
            JsonObject faceObj = new JsonObject();
            String string = face2.texture();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"texture(...)");
            faceObj.addProperty("texture", this$0.serializeLocOrKey(string));
            float[] fArray = face2.uv().uvs;
            if (!Arrays.equals(fArray, ((BlockElementAccessor)part).brokencore$uvsByFace(dir))) {
                faceObj.add("uv", new Gson().toJsonTree((Object)face2.uv().uvs));
            }
            if (face2.cullForDirection() != null) {
                Direction direction = face2.cullForDirection();
                Intrinsics.checkNotNull((Object)direction);
                faceObj.addProperty("cullface", direction.getSerializedName());
            }
            if (face2.uv().rotation != 0) {
                faceObj.addProperty("rotation", (Number)face2.uv().rotation);
            }
            if (face2.tintIndex() != -1) {
                faceObj.addProperty("tintindex", (Number)face2.tintIndex());
            }
            faces.add(dir.getSerializedName(), (JsonElement)faceObj);
        }
        if (!part.faces.isEmpty()) {
            partObj.add("faces", (JsonElement)faces);
        }
        $elements.add((JsonElement)partObj);
        return Unit.INSTANCE;
    }

    private static final void toJson$lambda$2(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$Companion;", "", "<init>", "()V", "ONE", "Lorg/joml/Vector3f;", "writeVec3", "Lcom/google/gson/JsonArray;", "vector", "writeQuaternion", "quaternion", "Lorg/joml/Quaternionf;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final JsonArray writeVec3(Vector3f vector) {
            JsonArray array = new JsonArray();
            array.add((Number)Float.valueOf(vector.x()));
            array.add((Number)Float.valueOf(vector.y()));
            array.add((Number)Float.valueOf(vector.z()));
            return array;
        }

        private final JsonArray writeQuaternion(Quaternionf quaternion) {
            JsonArray array = new JsonArray();
            array.add((Number)Float.valueOf(quaternion.x()));
            array.add((Number)Float.valueOf(quaternion.y()));
            array.add((Number)Float.valueOf(quaternion.z()));
            array.add((Number)Float.valueOf(quaternion.w()));
            return array;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0002,-B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J(\u0010\u0004\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u0006\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u001c\u001a\u00020\tJ\u0014\u0010\f\u001a\u00100\rR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0018\u0010\u000e\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ2\u0010\u001d\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2 \u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b0\u001fJ@\u0010 \u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2 \u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"J2\u0010\u0007\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2 \u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b0\u001fJ\u0018\u0010#\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010$\u001a\u00020%J\u0018\u0010$\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010$\u001a\u00020%J*\u0010'\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b0\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010(\u001a\u00020)J\u000b\u0010*\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u00100\nR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0018\u00010\rR\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;)V", "from", "Lorg/joml/Vector3f;", "to", "faces", "", "Lnet/minecraft/core/Direction;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$FaceBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "rotation", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$RotationBuilder;", "shade", "", "validateCoordinate", "", "coord", "", "name", "", "validatePosition", "pos", "x", "y", "z", "face", "dir", "allFaces", "action", "Ljava/util/function/BiConsumer;", "allFacesExcept", "exc", "", "textureAll", "texture", "", "cube", "addTexture", "build", "Lnet/minecraft/client/renderer/block/model/BlockElement;", "end", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "FaceBuilder", "RotationBuilder", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,868:1\n1#2:869\n37#3,2:870\n37#3,2:872\n*S KotlinDebug\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder\n*L\n438#1:870,2\n451#1:872,2\n*E\n"})
    public final class ElementBuilder {
        @NotNull
        private Vector3f from = new Vector3f();
        @NotNull
        private Vector3f to = new Vector3f(16.0f, 16.0f, 16.0f);
        @NotNull
        private final Map<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder> faces = new LinkedHashMap();
        @Nullable
        private compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder rotation;
        private boolean shade = true;

        private final void validateCoordinate(float coord, char name) {
            Preconditions.checkArgument((!(coord < -16.0f) && !(coord > 32.0f) ? 1 : 0) != 0, (String)("Position " + name + " out of range, must be within [-16, 32]. Found: %d"), (Object)Float.valueOf(coord));
        }

        private final void validatePosition(Vector3f pos) {
            this.validateCoordinate(pos.x(), 'x');
            this.validateCoordinate(pos.y(), 'y');
            this.validateCoordinate(pos.z(), 'z');
        }

        @NotNull
        public final ElementBuilder from(float x, float y, float z) {
            this.from = new Vector3f(x, y, z);
            this.validatePosition(this.from);
            return this;
        }

        @NotNull
        public final ElementBuilder to(float x, float y, float z) {
            this.to = new Vector3f(x, y, z);
            this.validatePosition(this.to);
            return this;
        }

        @NotNull
        public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder face(@NotNull Direction dir) {
            Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
            FaceBuilder faceBuilder = this.faces.computeIfAbsent(dir, arg_0 -> ElementBuilder.face$lambda$0((Function1)new Function1<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder>((Object)this){

                public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder invoke(Direction p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    return (ElementBuilder)this.receiver.new FaceBuilder(p0);
                }
            }, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)faceBuilder, (String)"computeIfAbsent(...)");
            return faceBuilder;
        }

        @NotNull
        public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder rotation() {
            if (this.rotation == null) {
                this.rotation = new RotationBuilder();
            }
            compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder rotationBuilder = this.rotation;
            Intrinsics.checkNotNull((Object)rotationBuilder);
            return rotationBuilder;
        }

        @NotNull
        public final ElementBuilder shade(boolean shade) {
            ElementBuilder elementBuilder;
            ElementBuilder $this$shade_u24lambda_u240 = elementBuilder = this;
            boolean bl = false;
            $this$shade_u24lambda_u240.shade = shade;
            return elementBuilder;
        }

        @NotNull
        public final ElementBuilder allFaces(@NotNull BiConsumer<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder> action) {
            ElementBuilder elementBuilder;
            Intrinsics.checkNotNullParameter(action, (String)"action");
            ElementBuilder $this$allFaces_u24lambda_u240 = elementBuilder = this;
            boolean bl = false;
            Collection $this$toTypedArray$iv = (Collection)EntriesMappings.entries$0;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Arrays.stream(thisCollection$iv.toArray(new Direction[0])).forEach(arg_0 -> ElementBuilder.allFaces$lambda$0$1(arg_0 -> ElementBuilder.allFaces$lambda$0$0(action, $this$allFaces_u24lambda_u240, arg_0), arg_0));
            return elementBuilder;
        }

        @NotNull
        public final ElementBuilder allFacesExcept(@NotNull BiConsumer<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder> action, @NotNull Set<Direction> exc) {
            ElementBuilder elementBuilder;
            Intrinsics.checkNotNullParameter(action, (String)"action");
            Intrinsics.checkNotNullParameter(exc, (String)"exc");
            ElementBuilder $this$allFacesExcept_u24lambda_u240 = elementBuilder = this;
            boolean bl = false;
            Collection $this$toTypedArray$iv = (Collection)EntriesMappings.entries$0;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Arrays.stream(thisCollection$iv.toArray(new Direction[0])).filter(arg_0 -> ElementBuilder.allFacesExcept$lambda$0$1(arg_0 -> ElementBuilder.allFacesExcept$lambda$0$0(exc, arg_0), arg_0)).forEach(arg_0 -> ElementBuilder.allFacesExcept$lambda$0$3(arg_0 -> ElementBuilder.allFacesExcept$lambda$0$2(action, $this$allFacesExcept_u24lambda_u240, arg_0), arg_0));
            return elementBuilder;
        }

        @NotNull
        public final ElementBuilder faces(@NotNull BiConsumer<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder> action) {
            ElementBuilder elementBuilder;
            Intrinsics.checkNotNullParameter(action, (String)"action");
            ElementBuilder $this$faces_u24lambda_u240 = elementBuilder = this;
            boolean bl = false;
            $this$faces_u24lambda_u240.faces.entrySet().stream().forEach(arg_0 -> ElementBuilder.faces$lambda$0$1(arg_0 -> ElementBuilder.faces$lambda$0$0(action, arg_0), arg_0));
            return elementBuilder;
        }

        @NotNull
        public final ElementBuilder textureAll(@NotNull String texture) {
            Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
            return this.allFaces(this.addTexture(texture));
        }

        @NotNull
        public final ElementBuilder texture(@NotNull String texture) {
            Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
            return this.faces(this.addTexture(texture));
        }

        @NotNull
        public final ElementBuilder cube(@NotNull String texture) {
            Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
            BiConsumer<Object, Object> biConsumer = this.addTexture(texture).andThen((arg_0, arg_1) -> ElementBuilder.cube$lambda$1(ElementBuilder::cube$lambda$0, arg_0, arg_1));
            Intrinsics.checkNotNullExpressionValue(biConsumer, (String)"andThen(...)");
            return this.allFaces(biConsumer);
        }

        private final BiConsumer<Direction, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder> addTexture(String texture) {
            return (arg_0, arg_1) -> ElementBuilder.addTexture$lambda$0(texture, arg_0, arg_1);
        }

        @NotNull
        public final BlockElement build() {
            LinkedHashMap linkedHashMap = this.faces.entrySet().stream().collect(Collectors.toMap(arg_0 -> ElementBuilder.build$lambda$1(ElementBuilder::build$lambda$0, arg_0), arg_0 -> ElementBuilder.build$lambda$3(ElementBuilder::build$lambda$2, arg_0), ElementBuilder::build$lambda$4, ElementBuilder::build$lambda$5));
            Intrinsics.checkNotNullExpressionValue((Object)linkedHashMap, (String)"collect(...)");
            Map faces = linkedHashMap;
            compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder rotationBuilder = this.rotation;
            return new BlockElement(this.from, this.to, faces, (BlockElementRotation)(rotationBuilder != null ? rotationBuilder.build() : null), this.shade);
        }

        @NotNull
        public final T end() {
            return ModelBuilder.this.self();
        }

        private static final FaceBuilder face$lambda$0(Function1 $tmp0, Object p0) {
            return (FaceBuilder)$tmp0.invoke(p0);
        }

        private static final Unit allFaces$lambda$0$0(BiConsumer $action, ElementBuilder $this_apply, Direction it) {
            Intrinsics.checkNotNull((Object)it);
            $action.accept(it, $this_apply.face(it));
            return Unit.INSTANCE;
        }

        private static final void allFaces$lambda$0$1(Function1 $tmp0, Object p0) {
            $tmp0.invoke(p0);
        }

        private static final boolean allFacesExcept$lambda$0$0(Set $exc, Direction it) {
            return !$exc.contains(it);
        }

        private static final boolean allFacesExcept$lambda$0$1(Function1 $tmp0, Object p0) {
            return (Boolean)$tmp0.invoke(p0);
        }

        private static final Unit allFacesExcept$lambda$0$2(BiConsumer $action, ElementBuilder $this_apply, Direction it) {
            Intrinsics.checkNotNull((Object)it);
            $action.accept(it, $this_apply.face(it));
            return Unit.INSTANCE;
        }

        private static final void allFacesExcept$lambda$0$3(Function1 $tmp0, Object p0) {
            $tmp0.invoke(p0);
        }

        private static final Unit faces$lambda$0$0(BiConsumer $action, Map.Entry it) {
            $action.accept(it.getKey(), it.getValue());
            return Unit.INSTANCE;
        }

        private static final void faces$lambda$0$1(Function1 $tmp0, Object p0) {
            $tmp0.invoke(p0);
        }

        private static final Unit cube$lambda$0(Direction dir, FaceBuilder f) {
            Intrinsics.checkNotNull((Object)dir);
            f.cullFace(dir);
            return Unit.INSTANCE;
        }

        private static final void cube$lambda$1(Function2 $tmp0, Object p0, Object p1) {
            $tmp0.invoke(p0, p1);
        }

        private static final void addTexture$lambda$0(String $texture, Direction direction, FaceBuilder f) {
            Intrinsics.checkNotNullParameter((Object)direction, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)f, (String)"f");
            f.texture($texture);
        }

        private static final Direction build$lambda$0(Map.Entry it) {
            return (Direction)it.getKey();
        }

        private static final Direction build$lambda$1(Function1 $tmp0, Object p0) {
            return (Direction)$tmp0.invoke(p0);
        }

        private static final BlockElementFace build$lambda$2(Map.Entry it) {
            return ((FaceBuilder)it.getValue()).build();
        }

        private static final BlockElementFace build$lambda$3(Function1 $tmp0, Object p0) {
            return (BlockElementFace)$tmp0.invoke(p0);
        }

        private static final BlockElementFace build$lambda$4(BlockElementFace blockElementFace, BlockElementFace blockElementFace2) {
            throw new IllegalArgumentException();
        }

        private static final LinkedHashMap build$lambda$5() {
            return new LinkedHashMap();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class EntriesMappings {
            public static final /* synthetic */ EnumEntries<Direction> entries$0;

            static {
                entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000f\u001a\u00100\u0000R\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0002\u001a\u00020\u0003J\u001c\u0010\u0012\u001a\u00100\u0000R\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0013\u001a\u00020\bJ\u001c\u0010\t\u001a\u00100\u0000R\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\t\u001a\u00020\nJ4\u0010\u000b\u001a\u00100\u0000R\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u001c\u0010\r\u001a\u00100\u0000R\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0011R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$FaceBuilder;", "", "dir", "Lnet/minecraft/core/Direction;", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;Lnet/minecraft/core/Direction;)V", "cullface", "tintindex", "", "texture", "", "uvs", "", "rotation", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$FaceRotation;", "cullFace", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "tintIndex", "index", "u1", "", "v1", "u2", "v2", "rot", "build", "Lnet/minecraft/client/renderer/block/model/BlockElementFace;", "end", "brokencore-common"})
        @SourceDebugExtension(value={"SMAP\nModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$FaceBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,868:1\n1#2:869\n*E\n"})
        public final class FaceBuilder {
            @Nullable
            private Direction cullface;
            private int tintindex;
            @NotNull
            private String texture;
            @Nullable
            private float[] uvs;
            @NotNull
            private FaceRotation rotation;

            public FaceBuilder(Direction dir) {
                Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
                this.tintindex = -1;
                String string = MissingTextureAtlasSprite.getLocation().toString();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
                this.texture = string;
                this.rotation = FaceRotation.ZERO;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder cullFace(@NotNull Direction dir) {
                FaceBuilder faceBuilder;
                Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
                FaceBuilder $this$cullFace_u24lambda_u240 = faceBuilder = this;
                boolean bl = false;
                $this$cullFace_u24lambda_u240.cullface = dir;
                return faceBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder tintIndex(int index) {
                FaceBuilder faceBuilder;
                FaceBuilder $this$tintIndex_u24lambda_u240 = faceBuilder = this;
                boolean bl = false;
                $this$tintIndex_u24lambda_u240.tintindex = index;
                return faceBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder texture(@NotNull String texture) {
                Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
                Preconditions.checkNotNull((Object)texture, (String)"Texture must not be null", (Object[])new Object[0]);
                this.texture = texture;
                return this;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder uvs(float u1, float v1, float u2, float v2) {
                float[] fArray = new float[]{u1, v1, u2, v2};
                this.uvs = fArray;
                return this;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.FaceBuilder rotation(@NotNull FaceRotation rot) {
                FaceBuilder faceBuilder;
                Intrinsics.checkNotNullParameter((Object)((Object)rot), (String)"rot");
                FaceBuilder $this$rotation_u24lambda_u240 = faceBuilder = this;
                boolean bl = false;
                $this$rotation_u24lambda_u240.rotation = rot;
                return faceBuilder;
            }

            @NotNull
            public final BlockElementFace build() {
                if (this.texture == null) {
                    boolean bl = false;
                    String string = "A model face must have a texture";
                    throw new IllegalStateException(string.toString());
                }
                return new BlockElementFace(this.cullface, this.tintindex, this.texture, new BlockFaceUV(this.uvs, this.rotation.getRotation()));
            }

            @NotNull
            public final ElementBuilder end() {
                return ElementBuilder.this;
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00100\u0000R\f0\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ\u001c\u0010\u0006\u001a\u00100\u0000R\f0\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\b\u001a\u00100\u0000R\f0\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u00100\u0000R\f0\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\f0\fR\b\u0012\u0004\u0012\u00028\u00000\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$RotationBuilder;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;)V", "origin", "Lorg/joml/Vector3f;", "axis", "Lnet/minecraft/core/Direction$Axis;", "angle", "", "rescale", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "x", "y", "z", "build", "Lnet/minecraft/client/renderer/block/model/BlockElementRotation;", "end", "brokencore-common"})
        @SourceDebugExtension(value={"SMAP\nModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$ElementBuilder$RotationBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,868:1\n1#2:869\n*E\n"})
        public final class RotationBuilder {
            @Nullable
            private Vector3f origin;
            @Nullable
            private Direction.Axis axis;
            private float angle;
            private boolean rescale;

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder origin(float x, float y, float z) {
                RotationBuilder rotationBuilder;
                RotationBuilder $this$origin_u24lambda_u240 = rotationBuilder = this;
                boolean bl = false;
                $this$origin_u24lambda_u240.origin = new Vector3f(x, y, z);
                return rotationBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder axis(@NotNull Direction.Axis axis) {
                RotationBuilder rotationBuilder;
                Intrinsics.checkNotNullParameter((Object)axis, (String)"axis");
                RotationBuilder $this$axis_u24lambda_u240 = rotationBuilder = this;
                boolean bl = false;
                $this$axis_u24lambda_u240.axis = axis;
                return rotationBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder angle(float angle) {
                Preconditions.checkArgument((angle == 0.0f || Mth.abs((float)angle) == 22.5f || Mth.abs((float)angle) == 45.0f ? 1 : 0) != 0, (String)"Invalid rotation %f found, only -45/-22.5/0/22.5/45 allowed", (Object)Float.valueOf(angle));
                this.angle = angle;
                return this;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$ElementBuilder.RotationBuilder rescale(boolean rescale) {
                RotationBuilder rotationBuilder;
                RotationBuilder $this$rescale_u24lambda_u240 = rotationBuilder = this;
                boolean bl = false;
                $this$rescale_u24lambda_u240.rescale = rescale;
                return rotationBuilder;
            }

            @NotNull
            public final BlockElementRotation build() {
                Vector3f vector3f = this.origin;
                Intrinsics.checkNotNull((Object)vector3f);
                Direction.Axis axis = this.axis;
                Intrinsics.checkNotNull((Object)axis);
                return new BlockElementRotation(vector3f, axis, this.angle, this.rescale);
            }

            @NotNull
            public final ElementBuilder end() {
                return ElementBuilder.this;
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$FaceRotation;", "", "rotation", "", "<init>", "(Ljava/lang/String;II)V", "getRotation", "()I", "ZERO", "CLOCKWISE_90", "UPSIDE_DOWN", "COUNTERCLOCKWISE_90", "brokencore-common"})
    public static final class FaceRotation
    extends Enum<FaceRotation> {
        private final int rotation;
        public static final /* enum */ FaceRotation ZERO = new FaceRotation(0);
        public static final /* enum */ FaceRotation CLOCKWISE_90 = new FaceRotation(90);
        public static final /* enum */ FaceRotation UPSIDE_DOWN = new FaceRotation(180);
        public static final /* enum */ FaceRotation COUNTERCLOCKWISE_90 = new FaceRotation(270);
        private static final /* synthetic */ FaceRotation[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private FaceRotation(int rotation) {
            this.rotation = rotation;
        }

        public final int getRotation() {
            return this.rotation;
        }

        public static FaceRotation[] values() {
            return (FaceRotation[])$VALUES.clone();
        }

        public static FaceRotation valueOf(String value) {
            return Enum.valueOf(FaceRotation.class, value);
        }

        @NotNull
        public static EnumEntries<FaceRotation> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = faceRotationArray = new FaceRotation[]{FaceRotation.ZERO, FaceRotation.CLOCKWISE_90, FaceRotation.UPSIDE_DOWN, FaceRotation.COUNTERCLOCKWISE_90};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0004\u001a\u00020\u0005J(\u0010\u0004\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0012\u001a\u00020\u0007J0\u0010\u0012\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0006\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0006\u001a\u00020\u0007J0\u0010\u0006\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\b\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\b\u001a\u00020\u0007J0\u0010\b\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0015\u001a\u00020\u0007J0\u0010\u0015\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\t\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\t\u001a\u00020\u000fJ(\u0010\t\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u0018\u0010\t\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\n\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\n\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$RootTransformsBuilder;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;)V", "translation", "Lorg/joml/Vector3f;", "leftRotation", "Lorg/joml/Quaternionf;", "rightRotation", "scale", "origin", "Lcompat/net/neoforged/neoforge/common/util/TransformationHelper$TransformOrigin;", "originVec", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "x", "", "y", "z", "rotation", "isDegrees", "", "postRotation", "xScale", "yScale", "zScale", "transform", "transformation", "Lcom/mojang/math/Transformation;", "end", "toJson", "Lcom/google/gson/JsonObject;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$RootTransformsBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,868:1\n1#2:869\n*E\n"})
    public final class RootTransformsBuilder {
        @NotNull
        private Vector3f translation = new Vector3f();
        @NotNull
        private Quaternionf leftRotation = new Quaternionf();
        @NotNull
        private Quaternionf rightRotation = new Quaternionf();
        @NotNull
        private Vector3f scale = ModelBuilder.access$getONE$cp();
        @Nullable
        private TransformationHelper.TransformOrigin origin;
        @Nullable
        private Vector3f originVec;

        @NotNull
        public final RootTransformsBuilder translation(@NotNull Vector3f translation) {
            RootTransformsBuilder rootTransformsBuilder;
            Intrinsics.checkNotNullParameter((Object)translation, (String)"translation");
            RootTransformsBuilder $this$translation_u24lambda_u240 = rootTransformsBuilder = this;
            boolean bl = false;
            $this$translation_u24lambda_u240.translation = translation;
            return rootTransformsBuilder;
        }

        @NotNull
        public final RootTransformsBuilder translation(float x, float y, float z) {
            return this.translation(new Vector3f(x, y, z));
        }

        @NotNull
        public final RootTransformsBuilder rotation(@NotNull Quaternionf rotation) {
            RootTransformsBuilder rootTransformsBuilder;
            Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
            RootTransformsBuilder $this$rotation_u24lambda_u240 = rootTransformsBuilder = this;
            boolean bl = false;
            $this$rotation_u24lambda_u240.leftRotation = rotation;
            return rootTransformsBuilder;
        }

        @NotNull
        public final RootTransformsBuilder rotation(float x, float y, float z, boolean isDegrees) {
            return this.rotation(TransformationHelper.INSTANCE.quatFromXYZ(x, y, z, isDegrees));
        }

        @NotNull
        public final RootTransformsBuilder leftRotation(@NotNull Quaternionf leftRotation) {
            Intrinsics.checkNotNullParameter((Object)leftRotation, (String)"leftRotation");
            return this.rotation(leftRotation);
        }

        @NotNull
        public final RootTransformsBuilder leftRotation(float x, float y, float z, boolean isDegrees) {
            return this.leftRotation(TransformationHelper.INSTANCE.quatFromXYZ(x, y, z, isDegrees));
        }

        @NotNull
        public final RootTransformsBuilder rightRotation(@NotNull Quaternionf rightRotation) {
            RootTransformsBuilder rootTransformsBuilder;
            Intrinsics.checkNotNullParameter((Object)rightRotation, (String)"rightRotation");
            RootTransformsBuilder $this$rightRotation_u24lambda_u240 = rootTransformsBuilder = this;
            boolean bl = false;
            $this$rightRotation_u24lambda_u240.rightRotation = rightRotation;
            return rootTransformsBuilder;
        }

        @NotNull
        public final RootTransformsBuilder rightRotation(float x, float y, float z, boolean isDegrees) {
            RootTransformsBuilder rootTransformsBuilder;
            RootTransformsBuilder $this$rightRotation_u24lambda_u241 = rootTransformsBuilder = this;
            boolean bl = false;
            $this$rightRotation_u24lambda_u241.rightRotation(TransformationHelper.INSTANCE.quatFromXYZ(x, y, z, isDegrees));
            return rootTransformsBuilder;
        }

        @NotNull
        public final RootTransformsBuilder postRotation(@NotNull Quaternionf postRotation) {
            Intrinsics.checkNotNullParameter((Object)postRotation, (String)"postRotation");
            return this.rightRotation(postRotation);
        }

        @NotNull
        public final RootTransformsBuilder postRotation(float x, float y, float z, boolean isDegrees) {
            return this.postRotation(TransformationHelper.INSTANCE.quatFromXYZ(x, y, z, isDegrees));
        }

        @NotNull
        public final RootTransformsBuilder scale(float scale) {
            return this.scale(new Vector3f(scale, scale, scale));
        }

        @NotNull
        public final RootTransformsBuilder scale(float xScale, float yScale, float zScale) {
            return this.scale(new Vector3f(xScale, yScale, zScale));
        }

        @NotNull
        public final RootTransformsBuilder scale(@NotNull Vector3f scale) {
            RootTransformsBuilder rootTransformsBuilder;
            Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
            RootTransformsBuilder $this$scale_u24lambda_u240 = rootTransformsBuilder = this;
            boolean bl = false;
            $this$scale_u24lambda_u240.scale = scale;
            return rootTransformsBuilder;
        }

        @NotNull
        public final RootTransformsBuilder transform(@NotNull Transformation transformation) {
            Intrinsics.checkNotNullParameter((Object)transformation, (String)"transformation");
            Vector3f vector3f = transformation.getTranslation();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"getTranslation(...)");
            this.translation = vector3f;
            Quaternionf quaternionf = transformation.getLeftRotation();
            Intrinsics.checkNotNullExpressionValue((Object)quaternionf, (String)"getLeftRotation(...)");
            this.leftRotation = quaternionf;
            Quaternionf quaternionf2 = transformation.getRightRotation();
            Intrinsics.checkNotNullExpressionValue((Object)quaternionf2, (String)"getRightRotation(...)");
            this.rightRotation = quaternionf2;
            Vector3f vector3f2 = transformation.getScale();
            Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"getScale(...)");
            this.scale = vector3f2;
            return this;
        }

        @NotNull
        public final RootTransformsBuilder origin(@NotNull Vector3f origin) {
            Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
            this.originVec = origin;
            this.origin = null;
            return this;
        }

        @NotNull
        public final RootTransformsBuilder origin(@NotNull TransformationHelper.TransformOrigin origin) {
            Intrinsics.checkNotNullParameter((Object)((Object)origin), (String)"origin");
            this.origin = origin;
            this.originVec = null;
            return this;
        }

        @NotNull
        public final ModelBuilder<T> end() {
            return ModelBuilder.this;
        }

        @NotNull
        public final JsonObject toJson() {
            JsonObject transform2 = new JsonObject();
            if (!this.translation.equals(0.0f, 0.0f, 0.0f)) {
                transform2.add("translation", (JsonElement)Companion.writeVec3(this.translation));
            }
            if (!Intrinsics.areEqual((Object)this.scale, (Object)ONE)) {
                transform2.add("scale", (JsonElement)Companion.writeVec3(this.scale));
            }
            if (!this.leftRotation.equals(0.0f, 0.0f, 0.0f, 1.0f)) {
                transform2.add("rotation", (JsonElement)Companion.writeQuaternion(this.leftRotation));
            }
            if (!this.rightRotation.equals(0.0f, 0.0f, 0.0f, 1.0f)) {
                transform2.add("post_rotation", (JsonElement)Companion.writeQuaternion(this.rightRotation));
            }
            if (this.origin != null) {
                TransformationHelper.TransformOrigin transformOrigin = this.origin;
                Intrinsics.checkNotNull((Object)((Object)transformOrigin));
                transform2.addProperty("origin", transformOrigin.getSerializedName());
            } else if (this.originVec != null) {
                Vector3f vector3f = this.originVec;
                Intrinsics.checkNotNull((Object)vector3f);
                if (!vector3f.equals(0.0f, 0.0f, 0.0f)) {
                    Vector3f vector3f2 = this.originVec;
                    Intrinsics.checkNotNull((Object)vector3f2);
                    transform2.add("origin", (JsonElement)Companion.writeVec3(vector3f2));
                }
            }
            return transform2;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00100\u0007R\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005J\u000b\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000eR(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u00100\u0007R\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder;", "", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;)V", "transforms", "", "Lnet/minecraft/world/item/ItemDisplayContext;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder$TransformVecBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "transform", "type", "build", "Lnet/minecraft/client/renderer/block/model/ItemTransform;", "end", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "TransformVecBuilder", "brokencore-common"})
    public final class TransformsBuilder {
        @NotNull
        private final Map<ItemDisplayContext, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder> transforms = new LinkedHashMap();

        @NotNull
        public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder transform(@NotNull ItemDisplayContext type) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            TransformVecBuilder transformVecBuilder = this.transforms.computeIfAbsent(type, arg_0 -> TransformsBuilder.transform$lambda$0((Function1)new Function1<ItemDisplayContext, compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder>((Object)this){

                public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder invoke(ItemDisplayContext p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    return (TransformsBuilder)this.receiver.new TransformVecBuilder(p0);
                }
            }, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)transformVecBuilder, (String)"computeIfAbsent(...)");
            return transformVecBuilder;
        }

        @NotNull
        public final Map<ItemDisplayContext, ItemTransform> build() {
            LinkedHashMap linkedHashMap = this.transforms.entrySet().stream().collect(Collectors.toMap(arg_0 -> TransformsBuilder.build$lambda$1(TransformsBuilder::build$lambda$0, arg_0), arg_0 -> TransformsBuilder.build$lambda$3(TransformsBuilder::build$lambda$2, arg_0), TransformsBuilder::build$lambda$4, TransformsBuilder::build$lambda$5));
            Intrinsics.checkNotNullExpressionValue((Object)linkedHashMap, (String)"collect(...)");
            return linkedHashMap;
        }

        @NotNull
        public final T end() {
            return ModelBuilder.this.self();
        }

        private static final TransformVecBuilder transform$lambda$0(Function1 $tmp0, Object p0) {
            return (TransformVecBuilder)$tmp0.invoke(p0);
        }

        private static final ItemDisplayContext build$lambda$0(Map.Entry it) {
            return (ItemDisplayContext)it.getKey();
        }

        private static final ItemDisplayContext build$lambda$1(Function1 $tmp0, Object p0) {
            return (ItemDisplayContext)$tmp0.invoke(p0);
        }

        private static final ItemTransform build$lambda$2(Map.Entry it) {
            return ((TransformVecBuilder)it.getValue()).build();
        }

        private static final ItemTransform build$lambda$3(Function1 $tmp0, Object p0) {
            return (ItemTransform)$tmp0.invoke(p0);
        }

        private static final ItemTransform build$lambda$4(ItemTransform k1, ItemTransform k2) {
            throw new IllegalArgumentException();
        }

        private static final LinkedHashMap build$lambda$5() {
            return new LinkedHashMap();
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00100\u0000R\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ,\u0010\u0010\u001a\u00100\u0000R\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ,\u0010\b\u001a\u00100\u0000R\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u001c\u0010\t\u001a\u00100\u0000R\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\rJ,\u0010\t\u001a\u00100\u0000R\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder$TransformVecBuilder;", "", "type", "Lnet/minecraft/world/item/ItemDisplayContext;", "<init>", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder;Lnet/minecraft/world/item/ItemDisplayContext;)V", "rotation", "Lorg/joml/Vector3f;", "translation", "scale", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "x", "", "y", "z", "leftRotation", "sc", "build", "Lnet/minecraft/client/renderer/block/model/ItemTransform;", "end", "brokencore-common"})
        @SourceDebugExtension(value={"SMAP\nModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelBuilder.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelBuilder$TransformsBuilder$TransformVecBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,868:1\n1#2:869\n*E\n"})
        public final class TransformVecBuilder {
            @NotNull
            private Vector3f rotation;
            @NotNull
            private Vector3f translation;
            @NotNull
            private Vector3f scale;

            public TransformVecBuilder(ItemDisplayContext type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                this.rotation = new Vector3f((Vector3fc)ItemTransformDeserializerAccessor.brokencore$getDefaultRotation());
                this.translation = new Vector3f((Vector3fc)ItemTransformDeserializerAccessor.brokencore$getDefaultTranslation());
                this.scale = new Vector3f((Vector3fc)ItemTransformDeserializerAccessor.brokencore$getDefaultScale());
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder rotation(float x, float y, float z) {
                TransformVecBuilder transformVecBuilder;
                TransformVecBuilder $this$rotation_u24lambda_u240 = transformVecBuilder = this;
                boolean bl = false;
                $this$rotation_u24lambda_u240.rotation = new Vector3f(x, y, z);
                return transformVecBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder leftRotation(float x, float y, float z) {
                return this.rotation(x, y, z);
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder translation(float x, float y, float z) {
                TransformVecBuilder transformVecBuilder;
                TransformVecBuilder $this$translation_u24lambda_u240 = transformVecBuilder = this;
                boolean bl = false;
                $this$translation_u24lambda_u240.translation = new Vector3f(x, y, z);
                return transformVecBuilder;
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder scale(float sc) {
                return this.scale(sc, sc, sc);
            }

            @NotNull
            public final compat.net.neoforged.neoforge.client.model.generators.ModelBuilder$TransformsBuilder.TransformVecBuilder scale(float x, float y, float z) {
                TransformVecBuilder transformVecBuilder;
                TransformVecBuilder $this$scale_u24lambda_u240 = transformVecBuilder = this;
                boolean bl = false;
                $this$scale_u24lambda_u240.scale = new Vector3f(x, y, z);
                return transformVecBuilder;
            }

            @NotNull
            public final ItemTransform build() {
                return new ItemTransform(this.rotation, this.translation, this.scale);
            }

            @NotNull
            public final TransformsBuilder end() {
                return TransformsBuilder.this;
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.Model
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2i
 *  org.joml.Vector2ic
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.animation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.animation.BedrockBone;
import net.thebrokenscript.brokencore.api.animation.BedrockTransform;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f BQ\b\u0002\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u001eR*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockModel;", "Lnet/minecraft/client/model/Model;", "bones", "Ljava/util/LinkedHashMap;", "", "Lnet/thebrokenscript/brokencore/api/animation/BedrockModel$BedrockBonePart;", "Lkotlin/collections/LinkedHashMap;", "root", "Lnet/minecraft/client/model/geom/ModelPart;", "identifier", "layerFactory", "Ljava/util/function/Function;", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/minecraft/client/renderer/RenderType;", "<init>", "(Ljava/util/LinkedHashMap;Lnet/minecraft/client/model/geom/ModelPart;Ljava/lang/String;Ljava/util/function/Function;)V", "getIdentifier", "()Ljava/lang/String;", "renderToBuffer", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "packedLight", "", "packedOverlay", "color", "forEachBone", "func", "Ljava/util/function/BiConsumer;", "BedrockBonePart", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
public final class BedrockModel
extends Model {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final LinkedHashMap<String, BedrockBonePart> bones;
    @NotNull
    private final ModelPart root;
    @NotNull
    private final String identifier;

    private BedrockModel(LinkedHashMap<String, BedrockBonePart> bones, ModelPart root, String identifier, Function<ResourceLocation, RenderType> layerFactory) {
        super(layerFactory);
        this.bones = bones;
        this.root = root;
        this.identifier = identifier;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    public final void forEachBone(@NotNull BiConsumer<String, BedrockBonePart> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        this.bones.forEach(func);
    }

    public /* synthetic */ BedrockModel(LinkedHashMap bones, ModelPart root, String identifier, Function layerFactory, DefaultConstructorMarker $constructor_marker) {
        this(bones, root, identifier, layerFactory);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockModel$BedrockBonePart;", "", "bone", "Lnet/thebrokenscript/brokencore/api/animation/BedrockBone;", "part", "Lnet/minecraft/client/model/geom/ModelPart;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/BedrockBone;Lnet/minecraft/client/model/geom/ModelPart;)V", "getBone", "()Lnet/thebrokenscript/brokencore/api/animation/BedrockBone;", "getPart", "()Lnet/minecraft/client/model/geom/ModelPart;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
    public static final class BedrockBonePart {
        @NotNull
        private final BedrockBone bone;
        @NotNull
        private final ModelPart part;

        public BedrockBonePart(@NotNull BedrockBone bone, @NotNull ModelPart part) {
            Intrinsics.checkNotNullParameter((Object)bone, (String)"bone");
            Intrinsics.checkNotNullParameter((Object)part, (String)"part");
            this.bone = bone;
            this.part = part;
        }

        @NotNull
        public final BedrockBone getBone() {
            return this.bone;
        }

        @NotNull
        public final ModelPart getPart() {
            return this.part;
        }

        @NotNull
        public final BedrockBone component1() {
            return this.bone;
        }

        @NotNull
        public final ModelPart component2() {
            return this.part;
        }

        @NotNull
        public final BedrockBonePart copy(@NotNull BedrockBone bone, @NotNull ModelPart part) {
            Intrinsics.checkNotNullParameter((Object)bone, (String)"bone");
            Intrinsics.checkNotNullParameter((Object)part, (String)"part");
            return new BedrockBonePart(bone, part);
        }

        public static /* synthetic */ BedrockBonePart copy$default(BedrockBonePart bedrockBonePart, BedrockBone bedrockBone, ModelPart modelPart, int n, Object object) {
            if ((n & 1) != 0) {
                bedrockBone = bedrockBonePart.bone;
            }
            if ((n & 2) != 0) {
                modelPart = bedrockBonePart.part;
            }
            return bedrockBonePart.copy(bedrockBone, modelPart);
        }

        @NotNull
        public String toString() {
            return "BedrockBonePart(bone=" + this.bone + ", part=" + this.part + ")";
        }

        public int hashCode() {
            int result = this.bone.hashCode();
            result = result * 31 + this.part.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BedrockBonePart)) {
                return false;
            }
            BedrockBonePart bedrockBonePart = (BedrockBonePart)other;
            if (!Intrinsics.areEqual((Object)this.bone, (Object)bedrockBonePart.bone)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.part, (Object)bedrockBonePart.part);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ4\u0010\f\u001a\u00020\r2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockModel$Companion;", "", "<init>", "()V", "parse", "Lnet/thebrokenscript/brokencore/api/animation/BedrockModel;", "obj", "Lcom/google/gson/JsonObject;", "layerFactory", "Ljava/util/function/Function;", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/minecraft/client/renderer/RenderType;", "collectParts", "", "bones", "Ljava/util/LinkedHashMap;", "", "Lnet/thebrokenscript/brokencore/api/animation/BedrockModel$BedrockBonePart;", "Lkotlin/collections/LinkedHashMap;", "parent", "Lnet/minecraft/client/model/geom/ModelPart;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BedrockModel parse(@NotNull JsonObject obj, @NotNull Function<ResourceLocation, RenderType> layerFactory) {
            JsonObject boneObj;
            JsonElement element;
            Intrinsics.checkNotNullParameter((Object)obj, (String)"obj");
            Intrinsics.checkNotNullParameter(layerFactory, (String)"layerFactory");
            JsonObject geometry = obj.get("minecraft:geometry").getAsJsonArray().get(0).getAsJsonObject();
            JsonObject desc = geometry.get("description").getAsJsonObject();
            String identifier = desc.get("identifier").getAsString();
            int textureWidth = desc.get("texture_width").getAsInt();
            int textureHeight = desc.get("texture_height").getAsInt();
            Vector2i textureSize = new Vector2i(textureWidth, textureHeight);
            JsonArray boneArr = geometry.get("bones").getAsJsonArray();
            LinkedHashMap<String, BedrockBonePart> bones = new LinkedHashMap<String, BedrockBonePart>();
            MeshDefinition modelData = new MeshDefinition();
            LinkedHashMap<String, ArrayList<JsonObject>> parentMap = new LinkedHashMap<String, ArrayList<JsonObject>>();
            Iterator iterator = boneArr.iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                element = (JsonElement)iterator2.next();
                boneObj = element.getAsJsonObject();
                if (!boneObj.has("parent")) continue;
                String parent = boneObj.get("parent").getAsString();
                parentMap.putIfAbsent(parent, new ArrayList());
                Object v = parentMap.get(parent);
                Intrinsics.checkNotNull(v);
                ((ArrayList)v).add(boneObj);
            }
            Iterator iterator3 = boneArr.iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator3, (String)"iterator(...)");
            iterator2 = iterator3;
            while (iterator2.hasNext()) {
                JsonElement cubes;
                element = (JsonElement)iterator2.next();
                boneObj = element.getAsJsonObject();
                if (boneObj.has("parent")) continue;
                String name = boneObj.get("name").getAsString();
                JsonArray pivotArr = boneObj.has("pivot") ? boneObj.get("pivot").getAsJsonArray() : new JsonArray();
                JsonArray rotArr = boneObj.has("rotation") ? boneObj.get("rotation").getAsJsonArray() : new JsonArray();
                Vector3f pivot = new Vector3f(0.0f, 0.0f, 0.0f);
                Vector3f rot = new Vector3f(0.0f, 0.0f, 0.0f);
                if (pivotArr != null && !pivotArr.isEmpty()) {
                    pivot.set(pivotArr.get(0).getAsFloat(), pivotArr.get(1).getAsFloat(), pivotArr.get(2).getAsFloat());
                }
                if (rotArr != null && !rotArr.isEmpty()) {
                    rot.set(rotArr.get(0).getAsFloat(), rotArr.get(1).getAsFloat(), rotArr.get(2).getAsFloat());
                }
                BedrockTransform transform2 = new BedrockTransform(new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(1.0f, 1.0f, 1.0f), rot, pivot);
                JsonElement jsonElement = cubes = boneObj.get("cubes");
                JsonArray jsonArray = jsonElement != null ? jsonElement.getAsJsonArray() : new JsonArray();
                Intrinsics.checkNotNull((Object)jsonArray);
                String string = name;
                Intrinsics.checkNotNull((Object)string);
                Vector2ic vector2ic = (Vector2ic)textureSize;
                PartDefinition partDefinition = modelData.getRoot();
                Intrinsics.checkNotNullExpressionValue((Object)partDefinition, (String)"getRoot(...)");
                BedrockBone.Companion.parse(jsonArray, string, vector2ic, transform2, partDefinition, parentMap, bones);
            }
            ModelPart part = modelData.getRoot().bake(textureWidth, textureHeight);
            Intrinsics.checkNotNull((Object)part);
            this.collectParts(bones, part);
            Intrinsics.checkNotNull((Object)identifier);
            return new BedrockModel(bones, part, identifier, layerFactory, null);
        }

        private final void collectParts(LinkedHashMap<String, BedrockBonePart> bones, ModelPart parent) {
            Iterator<String> iterator = bones.keySet().iterator();
            while (iterator.hasNext()) {
                String boneName;
                Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
                if (!parent.hasChild(boneName)) continue;
                ModelPart child = parent.getChild(boneName);
                Map map = bones;
                BedrockBonePart bedrockBonePart = bones.get(boneName);
                Intrinsics.checkNotNull((Object)bedrockBonePart);
                BedrockBone bedrockBone = bedrockBonePart.getBone();
                Intrinsics.checkNotNull((Object)child);
                map.put(boneName, new BedrockBonePart(bedrockBone, child));
                this.collectParts(bones, child);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


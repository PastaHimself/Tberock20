/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2ic
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.animation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.thebrokenscript.brokencore.api.animation.BedrockCuboid;
import net.thebrokenscript.brokencore.api.animation.BedrockModel;
import net.thebrokenscript.brokencore.api.animation.BedrockTransform;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockBone;", "", "name", "", "transform", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;)V", "getName", "()Ljava/lang/String;", "getTransform", "()Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
public final class BedrockBone {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @NotNull
    private final BedrockTransform transform;

    public BedrockBone(@NotNull String name, @NotNull BedrockTransform transform2) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        this.name = name;
        this.transform = transform2;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final BedrockTransform getTransform() {
        return this.transform;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final BedrockTransform component2() {
        return this.transform;
    }

    @NotNull
    public final BedrockBone copy(@NotNull String name, @NotNull BedrockTransform transform2) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        return new BedrockBone(name, transform2);
    }

    public static /* synthetic */ BedrockBone copy$default(BedrockBone bedrockBone, String string, BedrockTransform bedrockTransform, int n, Object object) {
        if ((n & 1) != 0) {
            string = bedrockBone.name;
        }
        if ((n & 2) != 0) {
            bedrockTransform = bedrockBone.transform;
        }
        return bedrockBone.copy(string, bedrockTransform);
    }

    @NotNull
    public String toString() {
        return "BedrockBone(name=" + this.name + ", transform=" + this.transform + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.transform.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BedrockBone)) {
            return false;
        }
        BedrockBone bedrockBone = (BedrockBone)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)bedrockBone.name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.transform, (Object)bedrockBone.transform);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0096\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2B\u0010\u0010\u001a>\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00140\u0011j\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014`\u00152\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005`\u0015\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockBone$Companion;", "", "<init>", "()V", "parse", "Lnet/thebrokenscript/brokencore/api/animation/BedrockModel$BedrockBonePart;", "cubes", "Lcom/google/gson/JsonArray;", "boneName", "", "textureSize", "Lorg/joml/Vector2ic;", "transform", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "parentPart", "Lnet/minecraft/client/model/geom/builders/PartDefinition;", "parentMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lcom/google/gson/JsonObject;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "partMap", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BedrockModel.BedrockBonePart parse(@NotNull JsonArray cubes, @NotNull String boneName, @NotNull Vector2ic textureSize, @NotNull BedrockTransform transform2, @NotNull PartDefinition parentPart, @NotNull LinkedHashMap<String, ArrayList<JsonObject>> parentMap, @NotNull LinkedHashMap<String, BedrockModel.BedrockBonePart> partMap) {
            Intrinsics.checkNotNullParameter((Object)cubes, (String)"cubes");
            Intrinsics.checkNotNullParameter((Object)boneName, (String)"boneName");
            Intrinsics.checkNotNullParameter((Object)textureSize, (String)"textureSize");
            Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
            Intrinsics.checkNotNullParameter((Object)parentPart, (String)"parentPart");
            Intrinsics.checkNotNullParameter(parentMap, (String)"parentMap");
            Intrinsics.checkNotNullParameter(partMap, (String)"partMap");
            PartDefinition newData = null;
            Iterator<String> iterator = cubes.iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
            Iterator<String> iterator2 = iterator;
            while (iterator2.hasNext()) {
                JsonElement element = (JsonElement)iterator2.next();
                JsonObject jsonObject = element.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue((Object)jsonObject, (String)"getAsJsonObject(...)");
                BedrockCuboid cuboid = BedrockCuboid.Companion.parse(jsonObject);
                BedrockTransform tf = new BedrockTransform(new Vector3f(0.0f), new Vector3f(1.0f), new Vector3f(0.0f), new Vector3f(0.0f));
                newData = parentPart.addOrReplaceChild(boneName, cuboid.toBuilder(), tf.toModelTransform());
            }
            if (newData == null) {
                newData = parentPart.addOrReplaceChild(boneName, new CubeListBuilder(), PartPose.ZERO);
            }
            iterator2 = parentMap.keySet().iterator();
            while (iterator2.hasNext()) {
                Iterator<JsonObject> iterator3;
                ArrayList<JsonObject> children;
                String name;
                Intrinsics.checkNotNullExpressionValue((Object)iterator2.next(), (String)"next(...)");
                Intrinsics.checkNotNull(parentMap.get(name));
                Intrinsics.checkNotNullExpressionValue(children.iterator(), (String)"iterator(...)");
                while (iterator3.hasNext()) {
                    JsonObject child;
                    Intrinsics.checkNotNullExpressionValue((Object)iterator3.next(), (String)"next(...)");
                    if (!Intrinsics.areEqual((Object)boneName, (Object)name)) continue;
                    String subName = child.get("name").getAsString();
                    JsonArray subCubes = child.has("cubes") ? child.get("cubes").getAsJsonArray() : new JsonArray();
                    JsonArray pivotArr = child.has("pivot") ? child.get("pivot").getAsJsonArray() : new JsonArray();
                    JsonArray rotArr = child.has("rotation") ? child.get("rotation").getAsJsonArray() : new JsonArray();
                    Vector3f pivot = new Vector3f(0.0f, 0.0f, 0.0f);
                    Vector3f rot = new Vector3f(0.0f, 0.0f, 0.0f);
                    if (pivotArr != null && !pivotArr.isEmpty()) {
                        pivot.set(pivotArr.get(0).getAsFloat(), pivotArr.get(1).getAsFloat(), pivotArr.get(2).getAsFloat());
                    }
                    if (rotArr != null && !rotArr.isEmpty()) {
                        rot.set(rotArr.get(0).getAsFloat(), rotArr.get(1).getAsFloat(), rotArr.get(2).getAsFloat());
                    }
                    BedrockTransform subTransform = new BedrockTransform(new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(1.0f, 1.0f, 1.0f), rot, new Vector3f((Vector3fc)pivot));
                    Map map = partMap;
                    Intrinsics.checkNotNull((Object)subCubes);
                    Intrinsics.checkNotNull((Object)subName);
                    Object object = newData;
                    Intrinsics.checkNotNull((Object)object);
                    object = this.parse(subCubes, subName, textureSize, subTransform, (PartDefinition)object, parentMap, partMap);
                    map.put(boneName, object);
                }
            }
            ModelPart part = newData.bake(textureSize.x(), textureSize.y());
            BedrockBone bone = new BedrockBone(boneName, transform2);
            Intrinsics.checkNotNull((Object)part);
            BedrockModel.BedrockBonePart bonePart = new BedrockModel.BedrockBonePart(bone, part);
            ((Map)partMap).put(boneName, new BedrockModel.BedrockBonePart(bone, part));
            return bonePart;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


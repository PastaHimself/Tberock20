/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementBuildersKt
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonPrimitive
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2d
 *  org.joml.Vector2dc
 *  org.joml.Vector2f
 *  org.joml.Vector2fc
 *  org.joml.Vector2i
 *  org.joml.Vector2ic
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector3i
 *  org.joml.Vector3ic
 *  org.joml.Vector4d
 *  org.joml.Vector4dc
 *  org.joml.Vector4f
 *  org.joml.Vector4fc
 *  org.joml.Vector4i
 *  org.joml.Vector4ic
 */
package net.thebrokenscript.brokencore.api.ext;

import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4d;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\r\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u000e\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u000f\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0010\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0011\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0012\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0013\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0014\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u0017\u001a\u00020\t*\u00020\n\u001a\n\u0010\u0016\u001a\u00020\b*\u00020\u0007\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u0016\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0018\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0017\u001a\u00020\t*\u00020\u000b\u001a\n\u0010\u0018\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\b\u001a\n\u0010\u0018\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0018\u001a\u00020\n*\u00020\t\u001a\n\u0010\u0016\u001a\u00020\u000b*\u00020\t\u001a\n\u0010\u0018\u001a\u00020\u0007*\u00020\u0006\u001a\n\u0010\u0016\u001a\u00020\b*\u00020\u0006\u001a\n\u0010\u0018\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\b\"\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001f\u00a8\u0006\""}, d2={"loadJson", "Lorg/joml/Vector4i;", "json", "Lkotlinx/serialization/json/JsonArray;", "Lorg/joml/Vector4f;", "Lorg/joml/Vector4d;", "Lorg/joml/Vector3i;", "Lorg/joml/Vector3f;", "Lorg/joml/Vector3d;", "Lorg/joml/Vector2i;", "Lorg/joml/Vector2f;", "Lorg/joml/Vector2d;", "toJson", "Lorg/joml/Vector4ic;", "Lorg/joml/Vector4fc;", "Lorg/joml/Vector4dc;", "Lorg/joml/Vector3ic;", "Lorg/joml/Vector3fc;", "Lorg/joml/Vector3dc;", "Lorg/joml/Vector2ic;", "Lorg/joml/Vector2fc;", "Lorg/joml/Vector2dc;", "toDouble", "toInt", "toFloat", "toVec3", "Lnet/minecraft/world/phys/Vec3;", "axesByLargest", "", "Lnet/minecraft/core/Direction$Axis;", "getAxesByLargest", "(Lorg/joml/Vector3f;)Ljava/util/List;", "axesBySmallest", "getAxesBySmallest", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nJomlVecExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JomlVecExt.kt\nnet/thebrokenscript/brokencore/api/ext/JomlVecExtKt\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n52#2,3:148\n52#2,3:151\n52#2,3:154\n52#2,3:157\n52#2,3:160\n52#2,3:163\n52#2,3:166\n52#2,3:169\n52#2,3:172\n1056#3:175\n1056#3:176\n*S KotlinDebug\n*F\n+ 1 JomlVecExt.kt\nnet/thebrokenscript/brokencore/api/ext/JomlVecExtKt\n*L\n71#1:148,3\n77#1:151,3\n83#1:154,3\n89#1:157,3\n94#1:160,3\n99#1:163,3\n104#1:166,3\n108#1:169,3\n112#1:172,3\n141#1:175\n144#1:176\n*E\n"})
public final class JomlVecExtKt {
    @NotNull
    public static final Vector4i loadJson(@NotNull Vector4i $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        $this$loadJson.w = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(3)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector4f loadJson(@NotNull Vector4f $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        $this$loadJson.w = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(3)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector4d loadJson(@NotNull Vector4d $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        $this$loadJson.w = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(3)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector3i loadJson(@NotNull Vector3i $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector3f loadJson(@NotNull Vector3f $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector3d loadJson(@NotNull Vector3d $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        $this$loadJson.z = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(2)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector2i loadJson(@NotNull Vector2i $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector2f loadJson(@NotNull Vector2f $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getFloat((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        return $this$loadJson;
    }

    @NotNull
    public static final Vector2d loadJson(@NotNull Vector2d $this$loadJson, @NotNull JsonArray json) {
        Intrinsics.checkNotNullParameter((Object)$this$loadJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        $this$loadJson.x = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(0)));
        $this$loadJson.y = JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)json.get(1)));
        return $this$loadJson;
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector4ic $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u240 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)$this$toJson.y());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)$this$toJson.z());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)$this$toJson.w());
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector4fc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u241 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u241, (Number)Float.valueOf($this$toJson.x()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u241, (Number)Float.valueOf($this$toJson.y()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u241, (Number)Float.valueOf($this$toJson.z()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u241, (Number)Float.valueOf($this$toJson.w()));
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector4dc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u242 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u242, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u242, (Number)$this$toJson.y());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u242, (Number)$this$toJson.z());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u242, (Number)$this$toJson.w());
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector3ic $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u243 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u243, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u243, (Number)$this$toJson.y());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u243, (Number)$this$toJson.z());
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector3fc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u244 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u244, (Number)Float.valueOf($this$toJson.x()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u244, (Number)Float.valueOf($this$toJson.y()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u244, (Number)Float.valueOf($this$toJson.z()));
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector3dc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u245 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u245, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u245, (Number)$this$toJson.y());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u245, (Number)$this$toJson.z());
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector2ic $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u246 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u246, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u246, (Number)$this$toJson.y());
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector2fc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u247 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u247, (Number)Float.valueOf($this$toJson.x()));
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u247, (Number)Float.valueOf($this$toJson.y()));
        return builder$iv.build();
    }

    @NotNull
    public static final JsonArray toJson(@NotNull Vector2dc $this$toJson) {
        JsonArrayBuilder builder$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u248 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u248, (Number)$this$toJson.x());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u248, (Number)$this$toJson.y());
        return builder$iv.build();
    }

    @NotNull
    public static final Vector2d toDouble(@NotNull Vector2f $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector2d((double)$this$toDouble.x, (double)$this$toDouble.y);
    }

    @NotNull
    public static final Vector2i toInt(@NotNull Vector2f $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector2i((int)$this$toInt.x, (int)$this$toInt.y);
    }

    @NotNull
    public static final Vector3d toDouble(@NotNull Vector3f $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector3d((double)$this$toDouble.x, (double)$this$toDouble.y, (double)$this$toDouble.z);
    }

    @NotNull
    public static final Vector3i toInt(@NotNull Vector3f $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector3i((int)$this$toInt.x, (int)$this$toInt.y, (int)$this$toInt.z);
    }

    @NotNull
    public static final Vector4d toDouble(@NotNull Vector4f $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector4d((double)$this$toDouble.x, (double)$this$toDouble.y, (double)$this$toDouble.z, (double)$this$toDouble.w);
    }

    @NotNull
    public static final Vector4i toInt(@NotNull Vector4f $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector4i((int)$this$toInt.x, (int)$this$toInt.y, (int)$this$toInt.z, (int)$this$toInt.w);
    }

    @NotNull
    public static final Vector2f toFloat(@NotNull Vector2d $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector2f((float)$this$toFloat.x, (float)$this$toFloat.y);
    }

    @NotNull
    public static final Vector2i toInt(@NotNull Vector2d $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector2i((int)$this$toInt.x, (int)$this$toInt.y);
    }

    @NotNull
    public static final Vector3f toFloat(@NotNull Vector3d $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector3f((float)$this$toFloat.x, (float)$this$toFloat.y, (float)$this$toFloat.z);
    }

    @NotNull
    public static final Vector3i toInt(@NotNull Vector3d $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector3i((int)$this$toInt.x, (int)$this$toInt.y, (int)$this$toInt.z);
    }

    @NotNull
    public static final Vector4f toFloat(@NotNull Vector4d $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector4f((float)$this$toFloat.x, (float)$this$toFloat.y, (float)$this$toFloat.z, (float)$this$toFloat.w);
    }

    @NotNull
    public static final Vector4i toInt(@NotNull Vector4d $this$toInt) {
        Intrinsics.checkNotNullParameter((Object)$this$toInt, (String)"<this>");
        return new Vector4i((int)$this$toInt.x, (int)$this$toInt.y, (int)$this$toInt.z, (int)$this$toInt.w);
    }

    @NotNull
    public static final Vector2f toFloat(@NotNull Vector2i $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector2f((float)$this$toFloat.x, (float)$this$toFloat.y);
    }

    @NotNull
    public static final Vector2d toDouble(@NotNull Vector2i $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector2d((double)$this$toDouble.x, (double)$this$toDouble.y);
    }

    @NotNull
    public static final Vector3f toFloat(@NotNull Vector3i $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector3f((float)$this$toFloat.x, (float)$this$toFloat.y, (float)$this$toFloat.z);
    }

    @NotNull
    public static final Vector3d toDouble(@NotNull Vector3i $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector3d((double)$this$toDouble.x, (double)$this$toDouble.y, (double)$this$toDouble.z);
    }

    @NotNull
    public static final Vector4f toFloat(@NotNull Vector4i $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Vector4f((float)$this$toFloat.x, (float)$this$toFloat.y, (float)$this$toFloat.z, (float)$this$toFloat.w);
    }

    @NotNull
    public static final Vector4d toDouble(@NotNull Vector4i $this$toDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$toDouble, (String)"<this>");
        return new Vector4d((double)$this$toDouble.x, (double)$this$toDouble.y, (double)$this$toDouble.z, (double)$this$toDouble.w);
    }

    @NotNull
    public static final Vec3 toVec3(@NotNull Vector3d $this$toVec3) {
        Intrinsics.checkNotNullParameter((Object)$this$toVec3, (String)"<this>");
        return new Vec3($this$toVec3.x, $this$toVec3.y, $this$toVec3.z);
    }

    @NotNull
    public static final List<Direction.Axis> getAxesByLargest(@NotNull Vector3f $this$axesByLargest) {
        Intrinsics.checkNotNullParameter((Object)$this$axesByLargest, (String)"<this>");
        Iterable $this$sortedBy$iv = (Iterable)EntriesMappings.entries$0;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator($this$axesByLargest){
            final /* synthetic */ Vector3f $this_axesByLargest$inlined;
            {
                this.$this_axesByLargest$inlined = vector3f;
            }

            public final int compare(T a, T b) {
                Direction.Axis it = (Direction.Axis)a;
                boolean bl = false;
                Comparable comparable = Float.valueOf(this.$this_axesByLargest$inlined.get(it.ordinal()));
                it = (Direction.Axis)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Float.valueOf(this.$this_axesByLargest$inlined.get(it.ordinal())));
            }
        });
    }

    @NotNull
    public static final List<Direction.Axis> getAxesBySmallest(@NotNull Vector3f $this$axesBySmallest) {
        Intrinsics.checkNotNullParameter((Object)$this$axesBySmallest, (String)"<this>");
        Iterable $this$sortedBy$iv = (Iterable)EntriesMappings.entries$0;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator($this$axesBySmallest){
            final /* synthetic */ Vector3f $this_axesBySmallest$inlined;
            {
                this.$this_axesBySmallest$inlined = vector3f;
            }

            public final int compare(T a, T b) {
                Direction.Axis it = (Direction.Axis)a;
                boolean bl = false;
                Comparable comparable = Float.valueOf(-this.$this_axesBySmallest$inlined.get(it.ordinal()));
                it = (Direction.Axis)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Float.valueOf(-this.$this_axesBySmallest$inlined.get(it.ordinal())));
            }
        });
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction.Axis> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.Axis.values()));
        }
    }
}


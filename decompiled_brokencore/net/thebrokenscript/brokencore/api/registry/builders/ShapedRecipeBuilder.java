/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0004J\b\u0010'\u001a\u00020\u0000H\u0016J!\u0010(\u001a\u00020\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020+0*\u00a2\u0006\u0002\b,H\u0016J\u0014\u0010(\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00000-R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u001aX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/ShapedRecipeBuilder;", "", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "result", "Lnet/minecraft/resources/ResourceLocation;", "count", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;I)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "getName", "()Ljava/lang/String;", "id", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "id$delegate", "Lkotlin/Lazy;", "pattern", "", "getPattern", "()Ljava/util/List;", "keys", "", "", "getKeys", "()Ljava/util/Map;", "category", "group", "row", "rowPattern", "key", "char", "item", "createJson", "Lcom/google/gson/JsonObject;", "register", "configure", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nShapedRecipeBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShapedRecipeBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/ShapedRecipeBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,126:1\n1#2:127\n1869#3,2:128\n216#4,2:130\n*S KotlinDebug\n*F\n+ 1 ShapedRecipeBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/ShapedRecipeBuilder\n*L\n95#1:128,2\n98#1:130,2\n*E\n"})
public class ShapedRecipeBuilder {
    @NotNull
    private final BrokenReg parent;
    @NotNull
    private final String name;
    @JvmField
    @NotNull
    public ResourceLocation result;
    @JvmField
    public int count;
    @NotNull
    private final Lazy id$delegate;
    @NotNull
    private final List<String> pattern;
    @NotNull
    private final Map<Character, ResourceLocation> keys;
    @JvmField
    @NotNull
    public String category;
    @JvmField
    @Nullable
    public String group;

    public ShapedRecipeBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull ResourceLocation result, int count) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        this.parent = parent;
        this.name = name;
        this.result = result;
        this.count = count;
        this.id$delegate = LazyKt.lazy(() -> ShapedRecipeBuilder.id_delegate$lambda$0(this));
        this.pattern = new ArrayList();
        this.keys = new LinkedHashMap();
        this.category = "misc";
    }

    public /* synthetic */ ShapedRecipeBuilder(BrokenReg brokenReg, String string, ResourceLocation resourceLocation, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            n = 1;
        }
        this(brokenReg, string, resourceLocation, n);
    }

    @NotNull
    public final BrokenReg getParent() {
        return this.parent;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ResourceLocation getId() {
        Lazy lazy = this.id$delegate;
        return (ResourceLocation)lazy.getValue();
    }

    @NotNull
    protected final List<String> getPattern() {
        return this.pattern;
    }

    @NotNull
    protected final Map<Character, ResourceLocation> getKeys() {
        return this.keys;
    }

    @NotNull
    public final ShapedRecipeBuilder row(@NotNull String rowPattern) {
        ShapedRecipeBuilder shapedRecipeBuilder;
        Intrinsics.checkNotNullParameter((Object)rowPattern, (String)"rowPattern");
        ShapedRecipeBuilder $this$row_u24lambda_u240 = shapedRecipeBuilder = this;
        boolean bl = false;
        $this$row_u24lambda_u240.pattern.add(rowPattern);
        return shapedRecipeBuilder;
    }

    @NotNull
    public final ShapedRecipeBuilder key(char c, @NotNull ResourceLocation item2) {
        ShapedRecipeBuilder shapedRecipeBuilder;
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        ShapedRecipeBuilder $this$key_u24lambda_u240 = shapedRecipeBuilder = this;
        boolean bl = false;
        $this$key_u24lambda_u240.keys.put(Character.valueOf(c), item2);
        return shapedRecipeBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final JsonObject createJson() {
        void $this$createJson_u24lambda_u240_u243;
        JsonArray $this$createJson_u24lambda_u240_u242;
        JsonArray $this$createJson_u24lambda_u240_u241;
        Object element$iv;
        JsonArray jsonArray;
        JsonObject jsonObject;
        JsonObject $this$createJson_u24lambda_u240 = jsonObject = new JsonObject();
        boolean bl = false;
        $this$createJson_u24lambda_u240.addProperty("type", "minecraft:crafting_shaped");
        String string = this.group;
        if (string != null) {
            String it = string;
            boolean bl2 = false;
            $this$createJson_u24lambda_u240.addProperty("group", it);
        }
        $this$createJson_u24lambda_u240.addProperty("category", this.category);
        JsonArray jsonArray2 = jsonArray = new JsonArray();
        String string2 = "pattern";
        JsonObject jsonObject2 = $this$createJson_u24lambda_u240;
        boolean bl3 = false;
        Object $this$forEach$iv = this.pattern;
        boolean $i$f$forEach = false;
        Iterator<Object> iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            element$iv = iterator.next();
            String it = (String)element$iv;
            boolean bl4 = false;
            $this$createJson_u24lambda_u240_u241.add(it);
        }
        Unit unit = Unit.INSTANCE;
        jsonObject2.add(string2, (JsonElement)jsonArray);
        $this$createJson_u24lambda_u240_u241 = jsonArray = new JsonObject();
        string2 = "key";
        jsonObject2 = $this$createJson_u24lambda_u240;
        boolean bl5 = false;
        $this$forEach$iv = this.keys;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            void $this$createJson_u24lambda_u240_u242_u240_u240;
            JsonObject jsonObject3;
            Object object = element$iv = (Map.Entry)iterator.next();
            boolean bl6 = false;
            char c = ((Character)object.getKey()).charValue();
            ResourceLocation item2 = (ResourceLocation)object.getValue();
            JsonObject jsonObject4 = jsonObject3 = new JsonObject();
            String string3 = String.valueOf(c);
            JsonArray jsonArray3 = $this$createJson_u24lambda_u240_u242;
            boolean bl7 = false;
            $this$createJson_u24lambda_u240_u242_u240_u240.addProperty("item", item2.toString());
            Unit unit2 = Unit.INSTANCE;
            jsonArray3.add(string3, (JsonElement)jsonObject3);
        }
        unit = Unit.INSTANCE;
        jsonObject2.add(string2, (JsonElement)jsonArray);
        $this$createJson_u24lambda_u240_u242 = jsonArray = new JsonObject();
        string2 = "result";
        jsonObject2 = $this$createJson_u24lambda_u240;
        boolean bl8 = false;
        $this$createJson_u24lambda_u240_u243.addProperty("id", this.result.toString());
        if (this.count > 1) {
            $this$createJson_u24lambda_u240_u243.addProperty("count", (Number)this.count);
        }
        unit = Unit.INSTANCE;
        jsonObject2.add(string2, (JsonElement)jsonArray);
        return jsonObject;
    }

    @NotNull
    public ShapedRecipeBuilder register() {
        ShapedRecipeBuilder shapedRecipeBuilder;
        ShapedRecipeBuilder it = shapedRecipeBuilder = this;
        boolean bl = false;
        this.parent.getData().getRecipes().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> ShapedRecipeBuilder.register$lambda$0$0(this, arg_0)));
        return shapedRecipeBuilder;
    }

    @NotNull
    public ShapedRecipeBuilder configure(@NotNull Function1<? super ShapedRecipeBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        block2.invoke((Object)this);
        Unit $this$configure_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return this.register();
    }

    @NotNull
    public final ShapedRecipeBuilder configure(@NotNull InstanceConsumer<ShapedRecipeBuilder> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.configure((Function1<? super ShapedRecipeBuilder, Unit>)((Function1)arg_0 -> ShapedRecipeBuilder.configure$lambda$1(block2, arg_0)));
    }

    private static final ResourceLocation id_delegate$lambda$0(ShapedRecipeBuilder this$0) {
        return this$0.parent.id(this$0.name);
    }

    private static final Unit register$lambda$0$0(ShapedRecipeBuilder this$0, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)("data/" + this$0.getId().getNamespace() + "/recipe/" + this$0.getId().getPath() + ".json"), (Object)this$0.createJson())};
        this$0.parent.getData().getRecipes().accept(pairArray);
        return Unit.INSTANCE;
    }

    private static final Unit configure$lambda$1(InstanceConsumer $block, ShapedRecipeBuilder $this$configure) {
        Intrinsics.checkNotNullParameter((Object)$this$configure, (String)"$this$configure");
        MiscExt.gluedApply($this$configure, $block);
        return Unit.INSTANCE;
    }
}


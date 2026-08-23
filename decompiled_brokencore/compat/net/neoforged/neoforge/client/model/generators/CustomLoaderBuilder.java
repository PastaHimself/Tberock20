/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.ModelBuilder;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B)\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\nJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u000b\u0010\u001e\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00028\u0000X\u0084\u0004\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/CustomLoaderBuilder;", "T", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "", "loaderId", "Lnet/minecraft/resources/ResourceLocation;", "parent", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "allowInlineElements", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;Z)V", "getLoaderId", "()Lnet/minecraft/resources/ResourceLocation;", "getParent", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "getExistingFileHelper", "()Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "getAllowInlineElements", "()Z", "visibility", "", "", "getVisibility", "()Ljava/util/Map;", "optional", "partName", "show", "end", "toJson", "Lcom/google/gson/JsonObject;", "json", "brokencore-common"})
public abstract class CustomLoaderBuilder<T extends ModelBuilder<T>> {
    @NotNull
    private final ResourceLocation loaderId;
    @NotNull
    private final T parent;
    @NotNull
    private final ExistingFileHelper existingFileHelper;
    private final boolean allowInlineElements;
    @NotNull
    private final Map<String, Boolean> visibility;
    private boolean optional;

    protected CustomLoaderBuilder(@NotNull ResourceLocation loaderId, @NotNull T parent, @NotNull ExistingFileHelper existingFileHelper, boolean allowInlineElements) {
        Intrinsics.checkNotNullParameter((Object)loaderId, (String)"loaderId");
        Intrinsics.checkNotNullParameter(parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        this.loaderId = loaderId;
        this.parent = parent;
        this.existingFileHelper = existingFileHelper;
        this.allowInlineElements = allowInlineElements;
        this.visibility = new LinkedHashMap();
    }

    @NotNull
    public final ResourceLocation getLoaderId() {
        return this.loaderId;
    }

    @NotNull
    protected final T getParent() {
        return this.parent;
    }

    @NotNull
    protected final ExistingFileHelper getExistingFileHelper() {
        return this.existingFileHelper;
    }

    public final boolean getAllowInlineElements() {
        return this.allowInlineElements;
    }

    @NotNull
    protected final Map<String, Boolean> getVisibility() {
        return this.visibility;
    }

    @NotNull
    public final CustomLoaderBuilder<T> visibility(@NotNull String partName, boolean show) {
        Intrinsics.checkNotNullParameter((Object)partName, (String)"partName");
        this.visibility.put(partName, show);
        return this;
    }

    @NotNull
    public final CustomLoaderBuilder<T> optional() {
        Preconditions.checkState((boolean)this.allowInlineElements, (String)"Only loaders with support for inline elements can be marked as optional", (Object[])new Object[0]);
        this.optional = true;
        return this;
    }

    @NotNull
    public final T end() {
        return this.parent;
    }

    @NotNull
    public final JsonObject toJson(@NotNull JsonObject json) {
        Intrinsics.checkNotNullParameter((Object)json, (String)"json");
        if (this.optional) {
            JsonObject loaderObj = new JsonObject();
            loaderObj.addProperty("id", this.loaderId.toString());
            loaderObj.addProperty("optional", Boolean.valueOf(true));
            json.add("loader", (JsonElement)loaderObj);
        } else {
            json.addProperty("loader", this.loaderId.toString());
        }
        if (!this.visibility.isEmpty()) {
            JsonObject visibilityObj = new JsonObject();
            for (Map.Entry<String, Boolean> entry : this.visibility.entrySet()) {
                visibilityObj.addProperty(entry.getKey(), entry.getValue());
            }
            json.add("visibility", (JsonElement)visibilityObj);
        }
        return json;
    }
}


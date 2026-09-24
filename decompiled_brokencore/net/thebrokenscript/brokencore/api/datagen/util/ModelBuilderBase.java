/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.util;

import com.google.gson.JsonElement;
import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000eJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012H&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/util/ModelBuilderBase;", "", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "getFiles", "()Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "block", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelBuilder;", "existingModel", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile$ExistingModelFile;", "loc", "", "Lnet/minecraft/resources/ResourceLocation;", "uncheckedModel", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile$UncheckedModelFile;", "build", "", "Lcom/google/gson/JsonElement;", "brokencore-common"})
public abstract class ModelBuilderBase {
    @NotNull
    private final ExistingFileHelper files;

    public ModelBuilderBase(@NotNull ExistingFileHelper files) {
        Intrinsics.checkNotNullParameter((Object)files, (String)"files");
        this.files = files;
    }

    @NotNull
    protected final ExistingFileHelper getFiles() {
        return this.files;
    }

    @NotNull
    public final BlockModelBuilder block() {
        ResourceLocation resourceLocation = ResourceLocation.parse((String)"empty");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return new BlockModelBuilder(resourceLocation, this.files);
    }

    @NotNull
    public final ModelFile.ExistingModelFile existingModel(@NotNull String loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        ResourceLocation resourceLocation = ResourceLocation.parse((String)loc);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return this.existingModel(resourceLocation);
    }

    @NotNull
    public final ModelFile.ExistingModelFile existingModel(@NotNull ResourceLocation loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        return new ModelFile.ExistingModelFile(loc, this.files);
    }

    @NotNull
    public final ModelFile.UncheckedModelFile uncheckedModel(@NotNull String loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        ResourceLocation resourceLocation = ResourceLocation.parse((String)loc);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return this.uncheckedModel(resourceLocation);
    }

    @NotNull
    public final ModelFile.UncheckedModelFile uncheckedModel(@NotNull ResourceLocation loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        return new ModelFile.UncheckedModelFile(loc);
    }

    @NotNull
    public abstract Map<String, JsonElement> build();
}


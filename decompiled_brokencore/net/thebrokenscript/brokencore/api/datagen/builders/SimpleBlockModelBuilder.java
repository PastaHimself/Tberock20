/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.data.models.model.ModelLocationUtils
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.builders;

import com.google.gson.JsonElement;
import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.datagen.builders.BlockModelBuilderBase;
import net.thebrokenscript.brokencore.api.util.system.PathUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/builders/SimpleBlockModelBuilder;", "Lnet/thebrokenscript/brokencore/api/datagen/builders/BlockModelBuilderBase;", "block", "Lnet/minecraft/world/level/block/Block;", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "type", "", "textures", "", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/world/level/block/Block;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;Ljava/lang/String;Ljava/util/Map;)V", "build", "Lcom/google/gson/JsonElement;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSimpleBlockModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleBlockModelBuilder.kt\nnet/thebrokenscript/brokencore/api/datagen/builders/SimpleBlockModelBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,20:1\n1#2:21\n216#3,2:22\n*S KotlinDebug\n*F\n+ 1 SimpleBlockModelBuilder.kt\nnet/thebrokenscript/brokencore/api/datagen/builders/SimpleBlockModelBuilder\n*L\n18#1:22,2\n*E\n"})
public final class SimpleBlockModelBuilder
extends BlockModelBuilderBase {
    @NotNull
    private final String type;
    @NotNull
    private final Map<String, ResourceLocation> textures;

    public SimpleBlockModelBuilder(@NotNull Block block2, @NotNull ExistingFileHelper files, @NotNull String type, @NotNull Map<String, ResourceLocation> textures) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)files, (String)"files");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(textures, (String)"textures");
        super(block2, files);
        this.type = type;
        this.textures = textures;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Map<String, JsonElement> build() {
        ResourceLocation resourceLocation = ModelLocationUtils.getModelLocation((Block)this.getBlock());
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getModelLocation(...)");
        Object t = this.block().parent(this.existingModel(this.type));
        BlockModelBuilder blockModelBuilder = (BlockModelBuilder)t;
        String string = PathUtilKt.modelPath(resourceLocation);
        boolean bl = false;
        Map<String, ResourceLocation> $this$forEach$iv = this.textures;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<String, ResourceLocation>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            void $this$build_u24lambda_u240;
            Map.Entry<String, ResourceLocation> element$iv;
            Map.Entry<String, ResourceLocation> it = element$iv = iterator.next();
            boolean bl2 = false;
            $this$build_u24lambda_u240.texture(it.getKey(), it.getValue());
        }
        return MapsKt.mapOf((Pair)TuplesKt.to((Object)string, (Object)((BlockModelBuilder)t).toJson()));
    }
}


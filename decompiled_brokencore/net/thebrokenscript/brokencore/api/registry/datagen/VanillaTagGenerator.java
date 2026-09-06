/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlinx.coroutines.future.FutureKt
 *  net.minecraft.core.Holder
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$PathProvider
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlinx.coroutines.future.FutureKt;
import net.minecraft.core.Holder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.datagen.data.TagManager;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder;
import net.thebrokenscript.brokencore.api.registry.datagen.TagGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.VanillaTagGenerator;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.TagObject;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/VanillaTagGenerator;", "Lnet/thebrokenscript/brokencore/api/registry/datagen/TagGenerator;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "paths", "Lnet/minecraft/data/PackOutput$PathProvider;", "kotlin.jvm.PlatformType", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTagGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagGenerator.kt\nnet/thebrokenscript/brokencore/api/registry/datagen/VanillaTagGenerator\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n216#2,2:157\n1#3:159\n*S KotlinDebug\n*F\n+ 1 TagGenerator.kt\nnet/thebrokenscript/brokencore/api/registry/datagen/VanillaTagGenerator\n*L\n69#1:157,2\n*E\n"})
public final class VanillaTagGenerator
extends TagGenerator {
    private final PackOutput.PathProvider paths;

    public VanillaTagGenerator(@NotNull PackOutput output, @NotNull BrokenReg parent) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        super(output, parent);
        this.paths = output.createPathProvider(PackOutput.Target.DATA_PACK, "tags");
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput var1_1, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof generate.1)) ** GOTO lbl-1000
        var14_3 = $completion;
        if ((var14_3.label & -2147483648) != 0) {
            var14_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ VanillaTagGenerator this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.generate(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var15_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$forEach$iv = this.getParent().getVanillaBlockTags$brokencore_common();
                $i$f$forEach = false;
                for (Map.Entry<K, V> element$iv : $this$forEach$iv.entrySet()) {
                    var7_11 = element$iv;
                    $i$a$-forEach-VanillaTagGenerator$generate$2 = false;
                    entry = (BlockEntry)var7_11.getKey();
                    consumer = (InstanceConsumer)var7_11.getValue();
                    MiscExt.gluedApply(new BlockTagsBuilder<T>(this.getParent(), (Block)entry.value()), consumer);
                }
                entries = (TagManager)this.getParent().getData().get(this.getClass(), generate.entries.1.INSTANCE);
                if (entries.isEmpty()) {
                    return Unit.INSTANCE;
                }
                var4_8 = entries.iterator();
lbl27:
                // 3 sources

                while (var4_8.hasNext()) {
                    tag = (TagObject)var4_8.next();
                    values = new JsonArray();
                    for (Holder entry : tag.getEntries()) {
                        var10_18 = entry.unwrapKey();
                        Intrinsics.checkNotNullExpressionValue((Object)var10_18, (String)"unwrapKey(...)");
                        v0 /* !! */  = (ResourceKey)OptionalsKt.getOrNull((Optional)var10_18);
                        if (v0 /* !! */  == null || (v0 /* !! */  = v0 /* !! */ .location()) == null || (v0 /* !! */  = v0 /* !! */ .toString()) == null) continue;
                        it /* !! */  = v0 /* !! */ ;
                        $i$a$-let-VanillaTagGenerator$generate$3 = false;
                        values.add((String)it /* !! */ );
                    }
                    for (TagKey<T> entry : tag.getTagEntries()) {
                        values.add("#" + entry.location());
                    }
                    for (ResourceKey key : tag.getKeyEntries()) {
                        values.add(key.location().toString());
                    }
                    for (ResourceLocation loc : tag.getOptionalEntries()) {
                        optObj = new JsonObject();
                        optObj.addProperty("id", loc.toString());
                        optObj.addProperty("required", Boxing.boxBoolean((boolean)false));
                        values.add((JsonElement)optObj);
                    }
                    obj = new JsonObject();
                    obj.addProperty("replace", Boxing.boxBoolean((boolean)false));
                    obj.add("values", (JsonElement)values);
                    v1 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)obj), (Path)this.paths.json(ResourceLocation.withDefaultNamespace((String)tag.getKey().location().getPath()).withPrefix(tag.getKey().registry().location().getPath() + "/")));
                    Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"saveStable(...)");
                    $continuation.L$0 = cache;
                    $continuation.L$1 = var4_8;
                    $continuation.label = 1;
                    v2 = FutureKt.await((CompletionStage)v1, (Continuation)$continuation);
                    if (v2 != var15_5) continue;
                    return var15_5;
                }
                break;
            }
            case 1: {
                var4_8 = (Iterator<TagObject<?>>)$continuation.L$1;
                cache = (CachedOutput)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
                ** GOTO lbl27
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}


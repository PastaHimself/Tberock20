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
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$PathProvider
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.Iterator;
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
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.thebrokenscript.brokencore.api.datagen.BaseDataGenerator;
import net.thebrokenscript.brokencore.api.datagen.DataConsumer;
import net.thebrokenscript.brokencore.api.datagen.data.TagManager;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.datagen.TagGenerator;
import net.thebrokenscript.brokencore.api.registry.objects.TagObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/TagGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/BaseDataGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/DataConsumer;", "Lnet/thebrokenscript/brokencore/api/datagen/data/TagManager;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "paths", "Lnet/minecraft/data/PackOutput$PathProvider;", "kotlin.jvm.PlatformType", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTagGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagGenerator.kt\nnet/thebrokenscript/brokencore/api/registry/datagen/TagGenerator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public class TagGenerator
extends BaseDataGenerator
implements DataConsumer<TagManager> {
    @NotNull
    private final BrokenReg parent;
    private final PackOutput.PathProvider paths;

    public TagGenerator(@NotNull PackOutput output, @NotNull BrokenReg parent) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        super(output);
        this.parent = parent;
        this.paths = output.createPathProvider(PackOutput.Target.DATA_PACK, "tags");
    }

    @NotNull
    protected final BrokenReg getParent() {
        return this.parent;
    }

    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput cache, @NotNull Continuation<? super Unit> $completion) {
        return TagGenerator.generate$suspendImpl(this, cache, $completion);
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    static /* synthetic */ Object generate$suspendImpl(TagGenerator var0, CachedOutput var1_1, Continuation<? super Unit> $completion) {
        if (!($completion instanceof generate.1)) ** GOTO lbl-1000
        var14_3 = $completion;
        if ((var14_3.label & -2147483648) != 0) {
            var14_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var0, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ TagGenerator this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return TagGenerator.generate$suspendImpl(this.this$0, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var15_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                entries = (TagManager)$this.parent.getData().get($this.getClass(), generate.entries.1.INSTANCE);
                if (entries.isEmpty()) {
                    return Unit.INSTANCE;
                }
                var4_7 = entries.iterator();
lbl16:
                // 3 sources

                while (var4_7.hasNext()) {
                    tag = var4_7.next();
                    values = new JsonArray();
                    for (TagKey entry : tag.getEntries()) {
                        var10_13 = entry.unwrapKey();
                        Intrinsics.checkNotNullExpressionValue((Object)var10_13, (String)"unwrapKey(...)");
                        v0 /* !! */  = (ResourceKey)OptionalsKt.getOrNull((Optional)var10_13);
                        if (v0 /* !! */  == null || (v0 /* !! */  = v0 /* !! */ .location()) == null || (v0 /* !! */  = v0 /* !! */ .toString()) == null) continue;
                        it /* !! */  = v0 /* !! */ ;
                        $i$a$-let-TagGenerator$generate$2 = false;
                        values.add((String)it /* !! */ );
                    }
                    for (TagKey entry : tag.getTagEntries()) {
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
                    v1 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)obj), (Path)$this.paths.json(tag.getKey().location().withPrefix(tag.getKey().registry().location().getPath() + "/")));
                    Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"saveStable(...)");
                    $continuation.L$0 = $this;
                    $continuation.L$1 = cache;
                    $continuation.L$2 = var4_7;
                    $continuation.label = 1;
                    v2 = FutureKt.await((CompletionStage)v1, (Continuation)$continuation);
                    if (v2 != var15_5) continue;
                    return var15_5;
                }
                break;
            }
            case 1: {
                var4_7 = (Iterator<TagObject<?>>)$continuation.L$2;
                cache = (CachedOutput)$continuation.L$1;
                $this = (TagGenerator)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
                ** GOTO lbl16
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}


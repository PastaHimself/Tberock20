/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.future.FutureKt
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.common.data.SoundDefinition;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.future.FutureKt;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.datagen.DataConsumer;
import net.thebrokenscript.brokencore.api.datagen.data.SoundManager;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.datagen.RegGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.SoundGenerator;
import net.thebrokenscript.brokencore.api.util.data.DefaultedMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/SoundGenerator;", "Lnet/thebrokenscript/brokencore/api/registry/datagen/RegGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/DataConsumer;", "Lnet/thebrokenscript/brokencore/api/datagen/data/SoundManager;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
public class SoundGenerator
extends RegGenerator
implements DataConsumer<SoundManager> {
    public SoundGenerator(@NotNull PackOutput output, @NotNull BrokenReg parent) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        super(output, parent);
    }

    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput cache, @NotNull Continuation<? super Unit> $completion) {
        return SoundGenerator.generate$suspendImpl(this, cache, $completion);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ Object generate$suspendImpl(SoundGenerator var0, CachedOutput var1_1, Continuation<? super Unit> $completion) {
        if (!($completion instanceof generate.1)) ** GOTO lbl-1000
        var10_3 = $completion;
        if ((var10_3.label & -2147483648) != 0) {
            var10_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var0, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ SoundGenerator this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SoundGenerator.generate$suspendImpl(this.this$0, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                data = (SoundManager)$this.getParent().getData().get($this.getClass(), generate.data.1.INSTANCE);
                objs = new DefaultedMap<T, E>((Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, generate$lambda$0(java.lang.String ), (Ljava/lang/String;)Lcom/google/gson/JsonObject;)());
                for (Map.Entry<ResourceLocation, SoundDefinition> var6_9 : data) {
                    key = var6_9.getKey();
                    def = var6_9.getValue();
                    ((JsonObject)objs.get(key.getNamespace())).add(key.getPath(), (JsonElement)def.serialize());
                }
                var5_8 /* !! */  = ((Map)objs).entrySet().iterator();
lbl20:
                // 3 sources

                while (var5_8 /* !! */ .hasNext()) {
                    var6_9 = var5_8 /* !! */ .next();
                    id = (String)var6_9.getKey();
                    obj = (JsonObject)var6_9.getValue();
                    v0 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)obj), (Path)$this.getOutput().getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(id).resolve("sounds.json"));
                    Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"saveStable(...)");
                    $continuation.L$0 = $this;
                    $continuation.L$1 = cache;
                    $continuation.L$2 = var5_8 /* !! */ ;
                    $continuation.label = 1;
                    v1 = FutureKt.await((CompletionStage)v0, (Continuation)$continuation);
                    if (v1 != var11_5) continue;
                    return var11_5;
                }
                break;
            }
            case 1: {
                var5_8 /* !! */  = (Iterator<Map.Entry<ResourceLocation, SoundDefinition>>)$continuation.L$2;
                cache = (CachedOutput)$continuation.L$1;
                $this = (SoundGenerator)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
                ** GOTO lbl20
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final JsonObject generate$lambda$0(String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new JsonObject();
    }
}


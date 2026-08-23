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
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.future.FutureKt
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$PathProvider
 *  net.minecraft.data.PackOutput$Target
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.future.FutureKt;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.thebrokenscript.brokencore.api.datagen.BaseDataGenerator;
import net.thebrokenscript.brokencore.api.datagen.DataConsumer;
import net.thebrokenscript.brokencore.api.datagen.data.LangManager;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.datagen.LangGenerator;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import net.thebrokenscript.brokencore.api.util.Rdh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/LangGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/BaseDataGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/DataConsumer;", "Lnet/thebrokenscript/brokencore/api/datagen/data/LangManager;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "paths", "Lnet/minecraft/data/PackOutput$PathProvider;", "kotlin.jvm.PlatformType", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
public class LangGenerator
extends BaseDataGenerator
implements DataConsumer<LangManager> {
    @NotNull
    private final BrokenReg parent;
    private final PackOutput.PathProvider paths;

    public LangGenerator(@NotNull PackOutput output, @NotNull BrokenReg parent) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        super(output);
        this.parent = parent;
        this.paths = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "lang");
    }

    @NotNull
    protected final BrokenReg getParent() {
        return this.parent;
    }

    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput cache, @NotNull Continuation<? super Unit> $completion) {
        return LangGenerator.generate$suspendImpl(this, cache, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ Object generate$suspendImpl(LangGenerator var0, CachedOutput var1_1, Continuation<? super Unit> $completion) {
        if (!($completion instanceof generate.1)) ** GOTO lbl-1000
        var12_3 = $completion;
        if ((var12_3.label & -2147483648) != 0) {
            var12_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var0, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                final /* synthetic */ LangGenerator this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return LangGenerator.generate$suspendImpl(this.this$0, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var13_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                entries = (LangManager)$this.parent.getData().get($this.getClass(), generate.entries.1.INSTANCE);
                if (entries.isEmpty()) {
                    return Unit.INSTANCE;
                }
                english = new JsonObject();
                upsideDown = new JsonObject();
                rdh = new JsonObject();
                for (Map.Entry var8_11 : entries) {
                    k = (String)var8_11.getKey();
                    v = (String)var8_11.getValue();
                    english.addProperty(k, v);
                    upsideDown.addProperty(k, LangUtil.INSTANCE.toUpsideDown(v));
                    rdh.addProperty(k, Rdh.INSTANCE.rdhify(v));
                }
                var7_10 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)english), (Path)$this.paths.json($this.parent.id("en_us")));
                Intrinsics.checkNotNullExpressionValue((Object)var7_10, (String)"saveStable(...)");
                $continuation.L$0 = $this;
                $continuation.L$1 = cache;
                $continuation.L$2 = upsideDown;
                $continuation.L$3 = rdh;
                $continuation.label = 1;
                v0 = FutureKt.await((CompletionStage)((CompletionStage)var7_10), (Continuation)$continuation);
                if (v0 == var13_5) {
                    return var13_5;
                }
                ** GOTO lbl43
            }
            case 1: {
                rdh = (JsonObject)$continuation.L$3;
                upsideDown = (JsonObject)$continuation.L$2;
                cache = (CachedOutput)$continuation.L$1;
                $this = (LangGenerator)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl43:
                // 2 sources

                var7_10 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)upsideDown), (Path)$this.paths.json($this.parent.id("en_ud")));
                Intrinsics.checkNotNullExpressionValue((Object)var7_10, (String)"saveStable(...)");
                $continuation.L$0 = $this;
                $continuation.L$1 = cache;
                $continuation.L$2 = rdh;
                $continuation.L$3 = null;
                $continuation.label = 2;
                v1 = FutureKt.await((CompletionStage)((CompletionStage)var7_10), (Continuation)$continuation);
                if (v1 == var13_5) {
                    return var13_5;
                }
                ** GOTO lbl60
            }
            case 2: {
                rdh = (JsonObject)$continuation.L$2;
                cache = (CachedOutput)$continuation.L$1;
                $this = (LangGenerator)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl60:
                // 2 sources

                var7_10 = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)rdh), (Path)$this.paths.json($this.parent.id("en_rdh")));
                Intrinsics.checkNotNullExpressionValue((Object)var7_10, (String)"saveStable(...)");
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.L$2 = null;
                $continuation.label = 3;
                v2 = FutureKt.await((CompletionStage)((CompletionStage)var7_10), (Continuation)$continuation);
                if (v2 == var13_5) {
                    return var13_5;
                }
                ** GOTO lbl73
            }
            case 3: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl73:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}


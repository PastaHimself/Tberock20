/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineName
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.future.FutureKt
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net.thebrokenscript.brokencore.api.datagen;

import com.google.gson.JsonElement;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.future.FutureKt;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.thebrokenscript.brokencore.api.datagen.BaseDataGenerator;
import net.thebrokenscript.brokencore.api.platform.PlatformDatagen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u00a6@\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u00020\u0019*\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020 0\u001fH\u0084@\u00a2\u0006\u0002\u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/BaseDataGenerator;", "Lnet/minecraft/data/DataProvider;", "output", "Lnet/minecraft/data/PackOutput;", "<init>", "(Lnet/minecraft/data/PackOutput;)V", "getOutput", "()Lnet/minecraft/data/PackOutput;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "files", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "getFiles", "()Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "logger", "Lorg/slf4j/Logger;", "getLogger", "()Lorg/slf4j/Logger;", "run", "Ljava/util/concurrent/CompletableFuture;", "cache", "Lnet/minecraft/data/CachedOutput;", "generate", "", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getName", "", "saveJsons", "map", "", "Lcom/google/gson/JsonElement;", "(Lnet/minecraft/data/CachedOutput;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
public abstract class BaseDataGenerator
implements DataProvider {
    @NotNull
    private final PackOutput output;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final ExistingFileHelper files;
    @NotNull
    private final Logger logger;

    public BaseDataGenerator(@NotNull PackOutput output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        this.output = output;
        this.scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null).plus((CoroutineContext)Dispatchers.getDefault()).plus((CoroutineContext)new CoroutineName("DataGenerator")));
        this.files = PlatformDatagen.Companion.createFileHelper();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        this.logger = logger;
    }

    @NotNull
    protected final PackOutput getOutput() {
        return this.output;
    }

    @NotNull
    protected final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    protected final ExistingFileHelper getFiles() {
        return this.files;
    }

    @NotNull
    protected final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final CompletableFuture<?> run(@NotNull CachedOutput cache) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        return FutureKt.asCompletableFuture((Deferred)BuildersKt.async$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, cache, null){
            int label;
            final /* synthetic */ BaseDataGenerator this$0;
            final /* synthetic */ CachedOutput $cache;
            {
                this.this$0 = $receiver;
                this.$cache = $cache;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.label = 1;
                        Object object3 = this.this$0.generate(this.$cache, (Continuation<? super Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)3, null));
    }

    @Nullable
    public abstract Object generate(@NotNull CachedOutput var1, @NotNull Continuation<? super Unit> var2);

    @NotNull
    public String getName() {
        String string = Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName();
        Intrinsics.checkNotNull((Object)string);
        return string;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    protected final Object saveJsons(@NotNull CachedOutput var1_1, @NotNull Map<String, ? extends JsonElement> var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof saveJsons.1)) ** GOTO lbl-1000
        var10_4 = $completion;
        if ((var10_4.label & -2147483648) != 0) {
            var10_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ BaseDataGenerator this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.saveJsons(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = map.entrySet().iterator();
lbl13:
                // 3 sources

                while (var4_7.hasNext()) {
                    var5_8 = var4_7.next();
                    path = (String)var5_8.getKey();
                    json = (JsonElement)var5_8.getValue();
                    var8_11 = DataProvider.saveStable((CachedOutput)$this$saveJsons, (JsonElement)json, (Path)this.output.getOutputFolder().resolve(path));
                    Intrinsics.checkNotNullExpressionValue((Object)var8_11, (String)"saveStable(...)");
                    $continuation.L$0 = $this$saveJsons;
                    $continuation.L$1 = var4_7;
                    $continuation.label = 1;
                    v0 = FutureKt.await((CompletionStage)var8_11, (Continuation)$continuation);
                    if (v0 != var11_6) continue;
                    return var11_6;
                }
                break;
            }
            case 1: {
                var4_7 = (Iterator<Map.Entry<K, V>>)$continuation.L$1;
                $this$saveJsons = (CachedOutput)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
                ** GOTO lbl13
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}


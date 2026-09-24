/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.future.FutureKt
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$PathProvider
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.locale.Language
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.datagen;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.future.FutureKt;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.datagen.BaseDataGenerator;
import net.thebrokenscript.brokencore.api.util.Rdh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/impl/datagen/BCLangGen;", "Lnet/thebrokenscript/brokencore/api/datagen/BaseDataGenerator;", "output", "Lnet/minecraft/data/PackOutput;", "<init>", "(Lnet/minecraft/data/PackOutput;)V", "paths", "Lnet/minecraft/data/PackOutput$PathProvider;", "kotlin.jvm.PlatformType", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadEnglishLang", "Lcom/google/common/collect/ImmutableMap;", "", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCLangGen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCLangGen.kt\nnet/thebrokenscript/brokencore/impl/datagen/BCLangGen\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
public final class BCLangGen
extends BaseDataGenerator {
    private final PackOutput.PathProvider paths;

    public BCLangGen(@NotNull PackOutput output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        super(output);
        this.paths = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "lang");
    }

    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput cache, @NotNull Continuation<? super Unit> $completion) {
        JsonObject rdh = new JsonObject();
        ImmutableMap<String, String> lang2 = this.loadEnglishLang();
        for (Map.Entry entry : ((Map)lang2).entrySet()) {
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            Intrinsics.checkNotNull((Object)v);
            rdh.addProperty(k, Rdh.INSTANCE.rdhify(v));
        }
        CompletableFuture completableFuture = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)rdh), (Path)this.paths.json(ResourceLocation.withDefaultNamespace((String)"en_rdh")));
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"saveStable(...)");
        Object object = FutureKt.await((CompletionStage)completableFuture, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final ImmutableMap<String, String> loadEnglishLang() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Closeable closeable = Language.class.getResourceAsStream("/assets/minecraft/lang/en_us.json");
        Throwable throwable = null;
        try {
            InputStream it = (InputStream)closeable;
            boolean bl = false;
            InputStream inputStream = it;
            Intrinsics.checkNotNull((Object)inputStream);
            Intrinsics.checkNotNull((Object)builder);
            Language.loadFromJson((InputStream)inputStream, (p0, p1) -> builder.put(p0, p1));
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        ImmutableMap immutableMap = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"build(...)");
        return immutableMap;
    }
}


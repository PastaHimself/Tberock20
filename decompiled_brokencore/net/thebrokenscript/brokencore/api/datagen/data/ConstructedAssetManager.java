/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.data.PackOutput
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.datagen.data;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J9\u0010\u0016\u001a\u00020\u00002*\u0010\u0017\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00190\u0018\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0019H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J(\u0010\u001d\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00190\u0018H\u0086\u0002\u00a2\u0006\u0002\u0010\u001eJ\u001d\u0010\u001d\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0012H\u0086\u0002R&\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager;", "", "<init>", "()V", "constructors", "", "Lkotlin/Function1;", "Lnet/minecraft/data/PackOutput;", "", "getConstructors", "()Ljava/util/List;", "built", "", "", "Lcom/google/gson/JsonElement;", "getBuilt", "()Ljava/util/Map;", "files", "", "getFiles", "constructAll", "output", "accept", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager;", "register", "ctor", "plusAssign", "([Lkotlin/Pair;)V", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nConstructedAssetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstructedAssetManager.kt\nnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,24:1\n1869#2,2:25\n1#3:27\n*S KotlinDebug\n*F\n+ 1 ConstructedAssetManager.kt\nnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager\n*L\n12#1:25,2\n*E\n"})
public class ConstructedAssetManager {
    @NotNull
    private final List<Function1<PackOutput, Unit>> constructors = new ArrayList();
    @NotNull
    private final Map<String, JsonElement> built = new LinkedHashMap();

    @NotNull
    protected final List<Function1<PackOutput, Unit>> getConstructors() {
        return this.constructors;
    }

    @NotNull
    protected final Map<String, JsonElement> getBuilt() {
        return this.built;
    }

    @NotNull
    public Map<String, JsonElement> getFiles() {
        return MapsKt.toMap(this.built);
    }

    public void constructAll(@NotNull PackOutput output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Iterable $this$forEach$iv = this.constructors;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)output);
        }
    }

    @NotNull
    public ConstructedAssetManager accept(Pair<String, ? extends JsonElement> ... pairs) {
        ConstructedAssetManager constructedAssetManager;
        Intrinsics.checkNotNullParameter(pairs, (String)"pairs");
        ConstructedAssetManager $this$accept_u24lambda_u240 = constructedAssetManager = this;
        boolean bl = false;
        MapsKt.putAll($this$accept_u24lambda_u240.built, pairs);
        return constructedAssetManager;
    }

    @NotNull
    public ConstructedAssetManager register(@NotNull Function1<? super PackOutput, Unit> ctor) {
        ConstructedAssetManager constructedAssetManager;
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ConstructedAssetManager $this$register_u24lambda_u240 = constructedAssetManager = this;
        boolean bl = false;
        ((Collection)$this$register_u24lambda_u240.constructors).add(ctor);
        return constructedAssetManager;
    }

    public final void plusAssign(@NotNull Pair<String, JsonElement>[] pairs) {
        Intrinsics.checkNotNullParameter(pairs, (String)"pairs");
        MapsKt.putAll(this.built, pairs);
    }

    public final void plusAssign(@NotNull Map<String, ? extends JsonElement> pairs) {
        Intrinsics.checkNotNullParameter(pairs, (String)"pairs");
        this.built.putAll(pairs);
    }
}


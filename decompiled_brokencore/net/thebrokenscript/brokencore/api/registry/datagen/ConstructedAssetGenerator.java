/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.PackOutput
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.thebrokenscript.brokencore.api.datagen.DataConsumer;
import net.thebrokenscript.brokencore.api.datagen.data.ConstructedAssetManager;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.datagen.ConstructedAssetGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.RegGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/ConstructedAssetGenerator;", "Lnet/thebrokenscript/brokencore/api/registry/datagen/RegGenerator;", "Lnet/thebrokenscript/brokencore/api/datagen/DataConsumer;", "Lnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager;", "output", "Lnet/minecraft/data/PackOutput;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "generate", "", "cache", "Lnet/minecraft/data/CachedOutput;", "(Lnet/minecraft/data/CachedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brokencore-common"})
public abstract class ConstructedAssetGenerator
extends RegGenerator
implements DataConsumer<ConstructedAssetManager> {
    public ConstructedAssetGenerator(@NotNull PackOutput output, @NotNull BrokenReg parent) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        super(output, parent);
    }

    @Override
    @Nullable
    public Object generate(@NotNull CachedOutput cache, @NotNull Continuation<? super Unit> $completion) {
        return ConstructedAssetGenerator.generate$suspendImpl(this, cache, $completion);
    }

    static /* synthetic */ Object generate$suspendImpl(ConstructedAssetGenerator $this, CachedOutput cache, Continuation<? super Unit> $completion) {
        ConstructedAssetManager data2 = (ConstructedAssetManager)$this.getParent().getData().get($this.getClass(), generate.data.1.INSTANCE);
        data2.constructAll($this.getOutput());
        Object object = $this.saveJsons(cache, data2.getFiles(), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}


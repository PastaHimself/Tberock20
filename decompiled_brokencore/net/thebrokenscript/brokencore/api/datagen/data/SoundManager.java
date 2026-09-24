/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.datagen.data;

import compat.net.neoforged.neoforge.common.data.SoundDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0003H\u0086\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\u0002J(\u0010\u0010\u001a\u00020\u000e2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00130\u0012H\u0086\u0002\u00a2\u0006\u0002\u0010\u0014J\u001d\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0015H\u0086\u0002J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0017H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/datagen/data/SoundManager;", "", "", "Lnet/minecraft/resources/ResourceLocation;", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition;", "<init>", "()V", "sounds", "", "getSounds", "()Ljava/util/Map;", "get", "key", "set", "", "value", "plusAssign", "pair", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "iterator", "", "isEmpty", "", "isNotEmpty", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSoundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundManager.kt\nnet/thebrokenscript/brokencore/api/datagen/data/SoundManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
public final class SoundManager
implements Iterable<Map.Entry<ResourceLocation, SoundDefinition>>,
KMappedMarker {
    @NotNull
    private final Map<ResourceLocation, SoundDefinition> sounds = new LinkedHashMap();

    @NotNull
    public final Map<ResourceLocation, SoundDefinition> getSounds() {
        return this.sounds;
    }

    @Nullable
    public final SoundDefinition get(@NotNull ResourceLocation key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return this.sounds.get(key);
    }

    public final void set(@NotNull ResourceLocation key, @NotNull SoundDefinition value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        SoundManager $this$set_u24lambda_u240 = this;
        boolean bl = false;
        $this$set_u24lambda_u240.sounds.put(key, value);
    }

    public final void plusAssign(@NotNull Pair<ResourceLocation, SoundDefinition>[] pair) {
        Intrinsics.checkNotNullParameter(pair, (String)"pair");
        SoundManager $this$plusAssign_u24lambda_u240 = this;
        boolean bl = false;
        MapsKt.putAll($this$plusAssign_u24lambda_u240.sounds, pair);
    }

    public final void plusAssign(@NotNull Map<ResourceLocation, SoundDefinition> pair) {
        Intrinsics.checkNotNullParameter(pair, (String)"pair");
        SoundManager $this$plusAssign_u24lambda_u241 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u241.sounds.putAll(pair);
    }

    @Override
    @NotNull
    public Iterator<Map.Entry<ResourceLocation, SoundDefinition>> iterator() {
        return this.sounds.entrySet().iterator();
    }

    public final boolean isEmpty() {
        return this.sounds.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.sounds.isEmpty();
    }
}


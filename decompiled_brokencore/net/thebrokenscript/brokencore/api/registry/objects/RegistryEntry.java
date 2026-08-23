/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Kind
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.HolderOwner
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import com.mojang.datafixers.util.Either;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0004J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0004J\r\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\rH\u0016J\u0016\u0010 \u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u001c\u0010 \u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070$H\u0016J\u0016\u0010 \u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0016\u0010 \u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0014\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&0)H\u0016J\u001a\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00000+H\u0016J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0016\u00100\u001a\u00020\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0016J\r\u00103\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001dJ\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\u0013\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010:H\u0096\u0002J\u000e\u0010;\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u001dR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006<"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "R", "T", "Lnet/minecraft/core/Holder;", "Ljava/util/function/Supplier;", "Lkotlin/Function0;", "key", "Lnet/minecraft/resources/ResourceKey;", "<init>", "(Lnet/minecraft/resources/ResourceKey;)V", "getKey", "()Lnet/minecraft/resources/ResourceKey;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "inner", "getInner", "()Lnet/minecraft/core/Holder;", "setInner", "(Lnet/minecraft/core/Holder;)V", "registry", "Lnet/minecraft/core/Registry;", "getRegistry", "()Lnet/minecraft/core/Registry;", "bind", "asHolder", "bindOrThrow", "value", "()Ljava/lang/Object;", "isBound", "", "is", "location", "resourceKey", "predicate", "Ljava/util/function/Predicate;", "tagKey", "Lnet/minecraft/tags/TagKey;", "holder", "tags", "Ljava/util/stream/Stream;", "unwrap", "Lcom/mojang/datafixers/util/Either;", "unwrapKey", "Ljava/util/Optional;", "kind", "Lnet/minecraft/core/Holder$Kind;", "canSerializeIn", "owner", "Lnet/minecraft/core/HolderOwner;", "get", "toString", "", "hashCode", "", "equals", "other", "", "invoke", "brokencore-common"})
public class RegistryEntry<R, T extends R>
implements Holder<R>,
Supplier<T>,
Function0<T> {
    @NotNull
    private final ResourceKey<R> key;
    @NotNull
    private final ResourceLocation id;
    @Nullable
    private Holder<R> inner;

    public RegistryEntry(@NotNull ResourceKey<R> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        this.key = key;
        ResourceLocation resourceLocation = this.key.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        this.id = resourceLocation;
    }

    @NotNull
    public final ResourceKey<R> getKey() {
        return this.key;
    }

    @NotNull
    public final ResourceLocation getId() {
        return this.id;
    }

    @Nullable
    protected final Holder<R> getInner() {
        return this.inner;
    }

    protected final void setInner(@Nullable Holder<R> holder) {
        this.inner = holder;
    }

    @Nullable
    protected final Registry<R> getRegistry() {
        return (Registry)BuiltInRegistries.REGISTRY.get(this.key.registry());
    }

    @Nullable
    protected final Holder<R> bind() {
        if (this.inner != null) {
            return this.inner;
        }
        Object object = this.getRegistry();
        this.inner = (Holder)(object != null && (object = object.getHolder(this.key)) != null ? (Holder.Reference)((Optional)object).orElse(null) : null);
        return this.inner;
    }

    @NotNull
    public final Holder<R> asHolder() {
        return this.bindOrThrow();
    }

    @NotNull
    protected final Holder<R> bindOrThrow() throws IllegalStateException {
        if (this.inner != null) {
            Holder<R> holder = this.inner;
            Intrinsics.checkNotNull(holder);
            return holder;
        }
        Registry<R> registry = this.getRegistry();
        if (registry == null) {
            throw new IllegalStateException("Registry not present for " + this + ": " + this.key.registry());
        }
        Registry<R> reg = registry;
        Holder.Reference reference = reg.getHolder(this.key).orElse(null);
        if (reference == null) {
            throw new IllegalStateException(" Value not present in registry " + this.key.registry() + " for " + this + ": " + this.key.location());
        }
        Holder.Reference value = reference;
        this.inner = (Holder)value;
        return (Holder)value;
    }

    public R value() {
        return (R)this.bindOrThrow().value();
    }

    public boolean isBound() {
        Holder<R> holder = this.bind();
        return holder != null ? holder.isBound() : false;
    }

    public boolean is(@NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        return Intrinsics.areEqual((Object)location, (Object)this.key.location());
    }

    public boolean is(@NotNull ResourceKey<R> resourceKey) {
        Intrinsics.checkNotNullParameter(resourceKey, (String)"resourceKey");
        return Intrinsics.areEqual(resourceKey, this.key);
    }

    public boolean is(@NotNull Predicate<ResourceKey<R>> predicate) {
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        return predicate.test(this.key);
    }

    public boolean is(@NotNull TagKey<R> tagKey) {
        Intrinsics.checkNotNullParameter(tagKey, (String)"tagKey");
        Holder<R> holder = this.bind();
        return holder != null ? holder.is(tagKey) : false;
    }

    public boolean is(@NotNull Holder<R> holder) {
        Intrinsics.checkNotNullParameter(holder, (String)"holder");
        Holder<R> holder2 = this.bind();
        return holder2 != null ? holder2.is(holder) : false;
    }

    @NotNull
    public Stream<TagKey<R>> tags() {
        Object object = this.bind();
        if (object == null || (object = object.tags()) == null) {
            Stream stream = Stream.empty();
            object = stream;
            Intrinsics.checkNotNullExpressionValue(stream, (String)"empty(...)");
        }
        return object;
    }

    @NotNull
    public Either<ResourceKey<R>, R> unwrap() {
        Either either = Either.left(this.key);
        Intrinsics.checkNotNullExpressionValue((Object)either, (String)"left(...)");
        return either;
    }

    @NotNull
    public Optional<ResourceKey<R>> unwrapKey() {
        Optional<ResourceKey<R>> optional = Optional.of(this.key);
        Intrinsics.checkNotNullExpressionValue(optional, (String)"of(...)");
        return optional;
    }

    @NotNull
    public Holder.Kind kind() {
        return Holder.Kind.REFERENCE;
    }

    public boolean canSerializeIn(@NotNull HolderOwner<R> owner) {
        Intrinsics.checkNotNullParameter(owner, (String)"owner");
        Holder<R> holder = this.bind();
        return holder != null ? holder.canSerializeIn(owner) : false;
    }

    @Override
    public T get() {
        return (T)this.bindOrThrow().value();
    }

    @NotNull
    public String toString() {
        return "RegistryEntry{" + this.key + "}";
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Holder)) return false;
        Holder holder = (Holder)other;
        if (holder == null) return false;
        Holder it = holder;
        boolean bl = false;
        if (it.kind() != Holder.Kind.REFERENCE) return false;
        Optional optional = it.unwrapKey();
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"unwrapKey(...)");
        if (!Intrinsics.areEqual((Object)OptionalsKt.getOrNull((Optional)optional), this.key)) return false;
        return true;
    }

    public T invoke() {
        return this.get();
    }
}


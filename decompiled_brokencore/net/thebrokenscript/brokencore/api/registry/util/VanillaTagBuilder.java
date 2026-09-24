/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.HolderOwner
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.objects.TagObject;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007H\u0002J1\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u001e\"\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0002\u0010\u001fJ1\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\u0010 \u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u001e\"\b\u0012\u0004\u0012\u00028\u00000\u001a\u00a2\u0006\u0002\u0010!J1\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\u0010\"\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001e\"\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010#J,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\b\u00028\u00000\u001e\"\u0004\b\u00028\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J%\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001e\"\u00020\u0018\u00a2\u0006\u0002\u0010'J\u001b\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\b\u00028\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u0017\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\u0002J\u0017\u0010(\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0017\u0010(\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086\u0002J!\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u001eH\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J\"\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u001eH\u0086\u0002\u00a2\u0006\u0002\u0010/J\"\u0010(\u001a\u00020)2\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u001eH\u0086\u0002\u00a2\u0006\u0002\u00100J\"\u0010(\u001a\u00020)2\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001eH\u0086\u0002\u00a2\u0006\u0002\u00101J\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ+\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020)05\u00a2\u0006\u0002\b6J \u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9\u00a8\u00068"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "T", "", "owner", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registryKey", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;)V", "getOwner", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "getRegistryKey", "()Lnet/minecraft/resources/ResourceKey;", "getName", "()Ljava/lang/String;", "replace", "", "entries", "", "Lnet/minecraft/core/Holder;", "optionalEntries", "Lnet/minecraft/resources/ResourceLocation;", "tagEntries", "Lnet/minecraft/tags/TagKey;", "keyEntries", "resolveRegistry", "add", "", "([Lnet/minecraft/core/Holder;)Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "tags", "([Lnet/minecraft/tags/TagKey;)Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "keys", "([Lnet/minecraft/resources/ResourceKey;)Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "([Ljava/lang/Object;)Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "addOptional", "locations", "([Lnet/minecraft/resources/ResourceLocation;)Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "plusAssign", "", "entry", "(Ljava/lang/Object;)V", "tagKey", "key", "([Ljava/lang/Object;)V", "([Lnet/minecraft/core/Holder;)V", "([Lnet/minecraft/tags/TagKey;)V", "([Lnet/minecraft/resources/ResourceKey;)V", "register", "configure", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTagBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,283:1\n1#2:284\n1#2:295\n11879#3,9:285\n13805#3:294\n13806#3:296\n11888#3:297\n382#4,7:298\n*S KotlinDebug\n*F\n+ 1 TagBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder\n*L\n143#1:295\n143#1:285,9\n143#1:294\n143#1:296\n143#1:297\n166#1:298,7\n*E\n"})
public final class VanillaTagBuilder<T> {
    @NotNull
    private final BrokenReg owner;
    @NotNull
    private final ResourceKey<? extends Registry<T>> registryKey;
    @NotNull
    private final String name;
    @JvmField
    public boolean replace;
    @NotNull
    private final List<Holder<T>> entries;
    @NotNull
    private final List<ResourceLocation> optionalEntries;
    @NotNull
    private final List<TagKey<T>> tagEntries;
    @NotNull
    private final List<ResourceKey<T>> keyEntries;

    public VanillaTagBuilder(@NotNull BrokenReg owner, @NotNull ResourceKey<? extends Registry<T>> registryKey, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter(registryKey, (String)"registryKey");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.owner = owner;
        this.registryKey = registryKey;
        this.name = name;
        this.entries = new ArrayList();
        this.optionalEntries = new ArrayList();
        this.tagEntries = new ArrayList();
        this.keyEntries = new ArrayList();
    }

    @NotNull
    public final BrokenReg getOwner() {
        return this.owner;
    }

    @NotNull
    public final ResourceKey<? extends Registry<T>> getRegistryKey() {
        return this.registryKey;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    private final Registry<T> resolveRegistry() {
        Object object = BuiltInRegistries.REGISTRY.get(this.registryKey.location());
        return object instanceof Registry ? (Registry)object : null;
    }

    @NotNull
    public final VanillaTagBuilder<T> add(Holder<T> ... entries2) {
        VanillaTagBuilder vanillaTagBuilder;
        Intrinsics.checkNotNullParameter(entries2, (String)"entries");
        VanillaTagBuilder $this$add_u24lambda_u240 = vanillaTagBuilder = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$add_u24lambda_u240.entries, (Object[])entries2);
        return vanillaTagBuilder;
    }

    @NotNull
    public final VanillaTagBuilder<T> add(TagKey<T> ... tags2) {
        VanillaTagBuilder vanillaTagBuilder;
        Intrinsics.checkNotNullParameter(tags2, (String)"tags");
        VanillaTagBuilder $this$add_u24lambda_u241 = vanillaTagBuilder = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$add_u24lambda_u241.tagEntries, (Object[])tags2);
        return vanillaTagBuilder;
    }

    @NotNull
    public final VanillaTagBuilder<T> add(ResourceKey<T> ... keys) {
        VanillaTagBuilder vanillaTagBuilder;
        Intrinsics.checkNotNullParameter(keys, (String)"keys");
        VanillaTagBuilder $this$add_u24lambda_u242 = vanillaTagBuilder = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$add_u24lambda_u242.keyEntries, (Object[])keys);
        return vanillaTagBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final VanillaTagBuilder<T> add(T ... entries2) {
        VanillaTagBuilder vanillaTagBuilder;
        Intrinsics.checkNotNullParameter(entries2, (String)"entries");
        VanillaTagBuilder $this$add_u24lambda_u243 = vanillaTagBuilder = this;
        boolean bl = false;
        Registry<T> registry = $this$add_u24lambda_u243.resolveRegistry();
        if (registry != null) {
            void $this$mapNotNullTo$iv$iv;
            void $this$mapNotNull$iv;
            Registry<T> registry2 = registry;
            T[] TArray = entries2;
            List<Holder<T>> list = $this$add_u24lambda_u243.entries;
            boolean $i$f$mapNotNull = false;
            void var9_9 = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            int n = ((void)$this$forEach$iv$iv$iv).length;
            for (int i = 0; i < n; ++i) {
                Holder.Reference it$iv$iv;
                void element$iv$iv$iv;
                void element$iv$iv = element$iv$iv$iv = $this$forEach$iv$iv$iv[i];
                boolean bl2 = false;
                void it = element$iv$iv;
                boolean bl3 = false;
                Optional<Holder.Reference> optional = registry2.getResourceKey((Object)it).map(arg_0 -> VanillaTagBuilder.add$lambda$3$0$1(arg_0 -> VanillaTagBuilder.add$lambda$3$0$0(registry2, arg_0), arg_0));
                Intrinsics.checkNotNullExpressionValue(optional, (String)"map(...)");
                if ((Holder.Reference)OptionalsKt.getOrNull(optional) == null) continue;
                boolean bl4 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            list.addAll((List)destination$iv$iv);
        }
        return vanillaTagBuilder;
    }

    @NotNull
    public final VanillaTagBuilder<T> addOptional(ResourceLocation ... locations) {
        VanillaTagBuilder vanillaTagBuilder;
        Intrinsics.checkNotNullParameter((Object)locations, (String)"locations");
        VanillaTagBuilder $this$addOptional_u24lambda_u240 = vanillaTagBuilder = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$addOptional_u24lambda_u240.optionalEntries, (Object[])locations);
        return vanillaTagBuilder;
    }

    public final void plusAssign(@NotNull T entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        VanillaTagBuilder $this$plusAssign_u24lambda_u240 = this;
        boolean bl = false;
        Object[] objectArray = new Object[]{entry};
        $this$plusAssign_u24lambda_u240.add(objectArray);
    }

    public final void plusAssign(@NotNull Holder<T> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        VanillaTagBuilder $this$plusAssign_u24lambda_u241 = this;
        boolean bl = false;
        Holder[] holderArray = new Holder[]{entry};
        $this$plusAssign_u24lambda_u241.add(holderArray);
    }

    public final void plusAssign(@NotNull TagKey<T> tagKey) {
        Intrinsics.checkNotNullParameter(tagKey, (String)"tagKey");
        VanillaTagBuilder $this$plusAssign_u24lambda_u242 = this;
        boolean bl = false;
        TagKey[] tagKeyArray = new TagKey[]{tagKey};
        $this$plusAssign_u24lambda_u242.add(tagKeyArray);
    }

    public final void plusAssign(@NotNull ResourceKey<T> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        VanillaTagBuilder $this$plusAssign_u24lambda_u243 = this;
        boolean bl = false;
        ResourceKey[] resourceKeyArray = new ResourceKey[]{key};
        $this$plusAssign_u24lambda_u243.add(resourceKeyArray);
    }

    public final void plusAssign(@NotNull T[] entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        VanillaTagBuilder $this$plusAssign_u24lambda_u244 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u244.add(Arrays.copyOf(entry, entry.length));
    }

    public final void plusAssign(@NotNull Holder<T>[] entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        VanillaTagBuilder $this$plusAssign_u24lambda_u245 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u245.add(Arrays.copyOf(entry, entry.length));
    }

    public final void plusAssign(@NotNull TagKey<T>[] tagKey) {
        Intrinsics.checkNotNullParameter(tagKey, (String)"tagKey");
        VanillaTagBuilder $this$plusAssign_u24lambda_u246 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u246.add(Arrays.copyOf(tagKey, tagKey.length));
    }

    public final void plusAssign(@NotNull ResourceKey<T>[] keys) {
        Intrinsics.checkNotNullParameter(keys, (String)"keys");
        VanillaTagBuilder $this$plusAssign_u24lambda_u247 = this;
        boolean bl = false;
        $this$plusAssign_u24lambda_u247.add(Arrays.copyOf(keys, keys.length));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final TagKey<T> register() {
        Object object;
        void $this$getOrPut$iv;
        String identifier = this.registryKey.location() + ":" + this.owner.getModId() + ":" + this.name;
        Map map = this.owner.getVanillaTagKeys$brokencore_common();
        String key$iv = identifier;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(key$iv);
        if (value$iv == null) {
            boolean bl = false;
            TagKey key = TagKey.create(this.registryKey, (ResourceLocation)ResourceLocation.withDefaultNamespace((String)this.name));
            Intrinsics.checkNotNull((Object)key);
            TagObject obj = new TagObject(key, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
            this.owner.getData().getVanillaTags().plusAssign(obj);
            Pair answer$iv = TuplesKt.to((Object)key, obj);
            $this$getOrPut$iv.put(key$iv, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        Pair key = (Pair)object;
        Object object2 = key.getSecond();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.registry.objects.TagObject<T of net.thebrokenscript.brokencore.api.registry.util.VanillaTagBuilder>");
        TagObject obj = (TagObject)object2;
        obj.getEntries().addAll((Collection)this.entries);
        obj.getTagEntries().addAll((Collection)this.tagEntries);
        obj.getOptionalEntries().addAll((Collection<ResourceLocation>)this.optionalEntries);
        obj.getKeyEntries().addAll((Collection)this.keyEntries);
        Object object3 = key.getFirst();
        Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type net.minecraft.tags.TagKey<T of net.thebrokenscript.brokencore.api.registry.util.VanillaTagBuilder>");
        return (TagKey)object3;
    }

    @NotNull
    public final TagKey<T> configure(@NotNull Function1<? super VanillaTagBuilder<T>, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        block2.invoke((Object)this);
        Unit $this$configure_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return this.register();
    }

    @NotNull
    public final TagKey<T> configure(@NotNull InstanceConsumer<VanillaTagBuilder<T>> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.configure(arg_0 -> VanillaTagBuilder.configure$lambda$1(block2, arg_0));
    }

    private static final Holder.Reference add$lambda$3$0$0(Registry $registry, ResourceKey key) {
        return Holder.Reference.createStandAlone((HolderOwner)$registry.holderOwner(), (ResourceKey)key);
    }

    private static final Holder.Reference add$lambda$3$0$1(Function1 $tmp0, Object p0) {
        return (Holder.Reference)$tmp0.invoke(p0);
    }

    private static final Unit configure$lambda$1(InstanceConsumer $block, VanillaTagBuilder $this$configure) {
        Intrinsics.checkNotNullParameter((Object)$this$configure, (String)"$this$configure");
        MiscExt.gluedApply($this$configure, $block);
        return Unit.INSTANCE;
    }
}


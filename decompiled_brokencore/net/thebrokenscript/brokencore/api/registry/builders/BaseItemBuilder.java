/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.color.item.ItemColor
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import compat.net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.thebrokenscript.brokencore.api.ext.KFuncExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.RecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.handlers.ItemHandler;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u001a\b\u0002\u0010\u0005*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00002 \u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00070\u0006B+\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000e2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0007J8\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00162\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0007J&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!J\u001b\u0010\"\u001a\u00028\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010!H&\u00a2\u0006\u0002\u0010$J&\u0010%\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000J\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000JC\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002)\u0010 \u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020)\u0012\u0004\u0012\u00020*0\r\u00a2\u0006\u0002\b+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J\u0016\u0010.\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0014J\r\u00100\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u00101J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "T", "Lnet/minecraft/world/item/Item;", "M", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelProvider;", "S", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/world/item/Item$Properties;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getCtor", "()Lkotlin/jvm/functions/Function1;", "setCtor", "(Lkotlin/jvm/functions/Function1;)V", "props", "Lkotlin/Function0;", "creativeTabs", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/item/CreativeModeTab;", "disableCreativeTab", "", "colorHandler", "Lnet/minecraft/client/color/item/ItemColor;", "lang", "block", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "model", "builder", "(Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;)Lnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder;", "tab", "noLang", "noTab", "recipe", "Lnet/thebrokenscript/brokencore/api/registry/builders/item/RecipeBuilder;", "", "Lkotlin/ExtensionFunctionType;", "createEntry", "key", "onRegistered", "entry", "createObject", "()Lnet/minecraft/world/item/Item;", "register", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBaseItemBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseItemBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BaseItemBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
public abstract class BaseItemBuilder<T extends Item, M extends ItemModelProvider, S extends BaseItemBuilder<T, M, S>>
extends AbstractBuilder<S, Item, T, ItemEntry<T>> {
    @NotNull
    private Function1<? super Item.Properties, ? extends T> ctor;
    @NotNull
    private Function0<? extends Item.Properties> props;
    @NotNull
    private List<ResourceKey<CreativeModeTab>> creativeTabs;
    private boolean disableCreativeTab;
    @JvmField
    @Nullable
    public Function0<? extends ItemColor> colorHandler;
    @JvmField
    @Nullable
    public String lang;

    public BaseItemBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function1<? super Item.Properties, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = Registries.ITEM;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"ITEM");
        super(parent, resourceKey, name);
        this.ctor = ctor;
        this.props = BaseItemBuilder::props$lambda$0;
        this.creativeTabs = new ArrayList();
        this.lang = LangUtil.INSTANCE.getAutomaticName(this.getId());
    }

    @NotNull
    public final Function1<Item.Properties, T> getCtor() {
        return this.ctor;
    }

    public final void setCtor(@NotNull Function1<? super Item.Properties, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
        this.ctor = function1;
    }

    @JvmOverloads
    @NotNull
    public final BaseItemBuilder<T, M, S> props(@NotNull Item.Properties props, @NotNull InstanceConsumer<Item.Properties> block2) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.props((Function0<Item.Properties>)((Function0)() -> BaseItemBuilder.props$lambda$2(props)), block2);
    }

    public static /* synthetic */ BaseItemBuilder props$default(BaseItemBuilder baseItemBuilder, Item.Properties properties, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: props");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BaseItemBuilder::props$lambda$1;
        }
        return baseItemBuilder.props(properties, instanceConsumer);
    }

    @JvmOverloads
    @NotNull
    public final BaseItemBuilder<T, M, S> props(@NotNull Function0<? extends Item.Properties> props, @NotNull InstanceConsumer<Item.Properties> block2) {
        BaseItemBuilder baseItemBuilder;
        Intrinsics.checkNotNullParameter(props, (String)"props");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BaseItemBuilder $this$props_u24lambda_u244 = baseItemBuilder = this;
        boolean bl = false;
        $this$props_u24lambda_u244.props = KFuncExt.INSTANCE.chainApplyConsumer(props, block2);
        return baseItemBuilder;
    }

    public static /* synthetic */ BaseItemBuilder props$default(BaseItemBuilder baseItemBuilder, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: props");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BaseItemBuilder::props$lambda$3;
        }
        return baseItemBuilder.props((Function0<Item.Properties>)function0, instanceConsumer);
    }

    @NotNull
    public final BaseItemBuilder<T, M, S> props(@NotNull InstanceConsumer<Item.Properties> block2) {
        BaseItemBuilder baseItemBuilder;
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BaseItemBuilder $this$props_u24lambda_u245 = baseItemBuilder = this;
        boolean bl = false;
        $this$props_u24lambda_u245.props = KFuncExt.INSTANCE.chainApplyConsumer($this$props_u24lambda_u245.props, block2);
        return baseItemBuilder;
    }

    @NotNull
    public abstract S model(@NotNull InstanceConsumer<M> var1);

    @NotNull
    public final BaseItemBuilder<T, M, S> tab(@NotNull ResourceKey<CreativeModeTab> tab) {
        BaseItemBuilder baseItemBuilder;
        Intrinsics.checkNotNullParameter(tab, (String)"tab");
        BaseItemBuilder $this$tab_u24lambda_u240 = baseItemBuilder = this;
        boolean bl = false;
        ((Collection)$this$tab_u24lambda_u240.creativeTabs).add(tab);
        return baseItemBuilder;
    }

    @NotNull
    public final BaseItemBuilder<T, M, S> noLang() {
        BaseItemBuilder baseItemBuilder;
        BaseItemBuilder $this$noLang_u24lambda_u240 = baseItemBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.lang = null;
        return baseItemBuilder;
    }

    @NotNull
    public final BaseItemBuilder<T, M, S> noTab() {
        BaseItemBuilder baseItemBuilder;
        BaseItemBuilder $this$noTab_u24lambda_u240 = baseItemBuilder = this;
        boolean bl = false;
        $this$noTab_u24lambda_u240.creativeTabs.clear();
        $this$noTab_u24lambda_u240.disableCreativeTab = true;
        return baseItemBuilder;
    }

    @NotNull
    public final BaseItemBuilder<T, M, S> recipe(@NotNull Function1<? super RecipeBuilder<T, M, S>, Unit> block2) {
        BaseItemBuilder baseItemBuilder;
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        BaseItemBuilder $this$recipe_u24lambda_u240 = baseItemBuilder = this;
        boolean bl = false;
        Intrinsics.checkNotNull((Object)$this$recipe_u24lambda_u240, (String)"null cannot be cast to non-null type S of net.thebrokenscript.brokencore.api.registry.builders.BaseItemBuilder");
        RecipeBuilder recipeBuilder = new RecipeBuilder($this$recipe_u24lambda_u240);
        block2.invoke(recipeBuilder);
        recipeBuilder.register();
        return baseItemBuilder;
    }

    @Override
    @NotNull
    public ItemEntry<T> createEntry(@NotNull ResourceKey<Item> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new ItemEntry(key);
    }

    @Override
    protected void onRegistered(@NotNull ItemEntry<T> entry) {
        Function0<? extends ItemColor> it;
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        Function0<? extends ItemColor> function0 = this.colorHandler;
        if (function0 != null) {
            it = function0;
            boolean bl = false;
            ItemHandler.INSTANCE.getColorHandlers$brokencore_common().put(entry, it);
        }
        if (this.creativeTabs.isEmpty() && !this.disableCreativeTab) {
            ResourceKey<CreativeModeTab> resourceKey = this.getParent().getCreativeTab();
            if (resourceKey != null) {
                it = resourceKey;
                boolean bl = false;
                ((Collection)this.creativeTabs).add(it);
            }
        }
        for (ResourceKey<CreativeModeTab> tab : this.creativeTabs) {
            this.getParent().getCreativeTabs().computeIfAbsent(tab, arg_0 -> BaseItemBuilder.onRegistered$lambda$3(BaseItemBuilder::onRegistered$lambda$2, arg_0)).add(this.getKey());
        }
    }

    @Override
    @NotNull
    protected T createObject() {
        return (T)((Item)this.ctor.invoke(this.props.invoke()));
    }

    @Override
    @NotNull
    public ItemEntry<T> register() {
        Object e;
        block0: {
            e = super.register();
            ItemEntry it = (ItemEntry)e;
            boolean bl = false;
            String string = this.lang;
            if (string == null) break block0;
            String it2 = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set("item." + this.getParent().getModId() + "." + this.getName(), it2);
        }
        return (ItemEntry)e;
    }

    @JvmOverloads
    @NotNull
    public final BaseItemBuilder<T, M, S> props(@NotNull Item.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return BaseItemBuilder.props$default(this, props, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final BaseItemBuilder<T, M, S> props(@NotNull Function0<? extends Item.Properties> props) {
        Intrinsics.checkNotNullParameter(props, (String)"props");
        return BaseItemBuilder.props$default(this, props, null, 2, null);
    }

    private static final Item.Properties props$lambda$0() {
        return new Item.Properties();
    }

    private static final void props$lambda$1(Item.Properties $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final Item.Properties props$lambda$2(Item.Properties $props) {
        return $props;
    }

    private static final void props$lambda$3(Item.Properties $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final List onRegistered$lambda$2(ResourceKey it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new ArrayList();
    }

    private static final List onRegistered$lambda$3(Function1 $tmp0, Object p0) {
        return (List)$tmp0.invoke(p0);
    }
}


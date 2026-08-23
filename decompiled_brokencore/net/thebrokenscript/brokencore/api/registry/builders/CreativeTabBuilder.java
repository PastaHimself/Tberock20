/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.CreativeModeTab$Builder
 *  net.minecraft.world.item.CreativeModeTab$Row
 *  net.minecraft.world.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0002H\u0014J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/CreativeTabBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "Lnet/minecraft/world/item/CreativeModeTab;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;)V", "titleKey", "icon", "Lkotlin/Function0;", "Lnet/minecraft/world/item/ItemStack;", "title", "createObject", "register", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCreativeTabBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreativeTabBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/CreativeTabBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n1#2:44\n*E\n"})
public final class CreativeTabBuilder
extends SimpleBuilder<CreativeTabBuilder, CreativeModeTab> {
    @NotNull
    private final String titleKey;
    @JvmField
    @Nullable
    public Function0<ItemStack> icon;
    @JvmField
    @Nullable
    public String title;

    public CreativeTabBuilder(@NotNull BrokenReg parent, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceKey resourceKey = Registries.CREATIVE_MODE_TAB;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"CREATIVE_MODE_TAB");
        super(parent, resourceKey, name);
        this.titleKey = "itemGroup." + this.getId().getNamespace() + "." + this.getId().getPath();
    }

    @Override
    @NotNull
    protected CreativeModeTab createObject() {
        Object it;
        CreativeModeTab.Builder builder;
        CreativeModeTab.Builder $this$createObject_u24lambda_u240 = builder = CreativeModeTab.builder((CreativeModeTab.Row)CreativeModeTab.Row.TOP, (int)0);
        boolean bl = false;
        Function0<ItemStack> function0 = this.icon;
        if (function0 != null) {
            it = function0;
            boolean bl2 = false;
            $this$createObject_u24lambda_u240.icon(() -> CreativeTabBuilder.createObject$lambda$0$0$0(it));
        }
        String string = this.title;
        if (string != null) {
            it = string;
            boolean bl3 = false;
            $this$createObject_u24lambda_u240.title((Component)Component.translatable((String)this.titleKey));
        }
        CreativeModeTab creativeModeTab = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)creativeModeTab, (String)"build(...)");
        return creativeModeTab;
    }

    @Override
    @NotNull
    public RegistryEntry<CreativeModeTab, CreativeModeTab> register() {
        Object e;
        block0: {
            Object it = e = super.register();
            boolean bl = false;
            String string = this.title;
            if (string == null) break block0;
            String it2 = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set(this.titleKey, it2);
        }
        return e;
    }

    private static final ItemStack createObject$lambda$0$0$0(Function0 $tmp0) {
        return (ItemStack)$tmp0.invoke();
    }
}


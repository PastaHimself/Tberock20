/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.ItemStack
 *  net.thebrokenscript.brokencore.api.registry.builders.CreativeTabBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.ItemEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.registry.builders.CreativeTabBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEasterEggItems;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/registry/TBSCreativeTabs;", "", "<init>", "()V", "MAIN", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/item/CreativeModeTab;", "EASTER_EGGS", "thebrokenscript-common"})
public final class TBSCreativeTabs {
    @NotNull
    public static final TBSCreativeTabs INSTANCE = new TBSCreativeTabs();
    @JvmField
    @NotNull
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MAIN = TBSReg.INSTANCE.creativeTab("tbs", TBSCreativeTabs::MAIN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EASTER_EGGS = TBSReg.INSTANCE.creativeTab("easter_eggs", TBSCreativeTabs::EASTER_EGGS$lambda$0);

    private TBSCreativeTabs() {
    }

    private static final void MAIN$lambda$0(CreativeTabBuilder $this$creativeTab) {
        Intrinsics.checkNotNullParameter((Object)$this$creativeTab, (String)"$this$creativeTab");
        $this$creativeTab.icon = (Function0)new PropertyReference0Impl(TBSItems.POLAROID){

            public Object get() {
                return ((ItemEntry)this.receiver).getStack();
            }
        };
        $this$creativeTab.title = "The Broken Script";
    }

    private static final void EASTER_EGGS$lambda$0(CreativeTabBuilder $this$creativeTab) {
        Intrinsics.checkNotNullParameter((Object)$this$creativeTab, (String)"$this$creativeTab");
        $this$creativeTab.icon = TBSCreativeTabs::EASTER_EGGS$lambda$0$0;
        $this$creativeTab.title = "TBS - Funny Items";
    }

    private static final ItemStack EASTER_EGGS$lambda$0$0() {
        return TBSEasterEggItems.NULL_BREAD.getStack();
    }
}


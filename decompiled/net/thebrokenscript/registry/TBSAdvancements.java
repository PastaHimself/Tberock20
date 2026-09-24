/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  net.minecraft.advancements.Advancement
 *  net.minecraft.advancements.critereon.RecipeCraftedTrigger$TriggerInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.registry.builders.AdvancementBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
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
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.RecipeCraftedTrigger;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.builders.AdvancementBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/registry/TBSAdvancements;", "", "<init>", "()V", "CAN_SOMEONE_HEAR_ME", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/advancements/Advancement;", "CAN_YOU_SEE_ME", "NULLNULLNULL", "YOUVE_BROUGHT_IT_UPON_YOURSELF", "POLAROID_CRAFT", "thebrokenscript-common"})
public final class TBSAdvancements {
    @NotNull
    public static final TBSAdvancements INSTANCE = new TBSAdvancements();
    @JvmField
    @NotNull
    public static final RegistryEntry<Advancement, Advancement> CAN_SOMEONE_HEAR_ME = TBSReg.INSTANCE.advancement("can_someone_hear_me", TBSAdvancements::CAN_SOMEONE_HEAR_ME$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<Advancement, Advancement> CAN_YOU_SEE_ME = TBSReg.INSTANCE.advancement("can_you_see_me", TBSAdvancements::CAN_YOU_SEE_ME$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<Advancement, Advancement> NULLNULLNULL = TBSReg.INSTANCE.advancement("nullnullnull", TBSAdvancements::NULLNULLNULL$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<Advancement, Advancement> YOUVE_BROUGHT_IT_UPON_YOURSELF = TBSReg.INSTANCE.advancement("you_ve_brought_it_upon_yourself", TBSAdvancements::YOUVE_BROUGHT_IT_UPON_YOURSELF$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<Advancement, Advancement> POLAROID_CRAFT = TBSReg.INSTANCE.advancement("polaroid_craft", TBSAdvancements::POLAROID_CRAFT$lambda$0);

    private TBSAdvancements() {
    }

    private static final void CAN_SOMEONE_HEAR_ME$lambda$0(AdvancementBuilder $this$advancement) {
        Intrinsics.checkNotNullParameter((Object)$this$advancement, (String)"$this$advancement");
        $this$advancement.title = "Go away";
        $this$advancement.desc = "This place is not for you.";
        $this$advancement.icon = (Function0)new PropertyReference0Impl(TBSBlocks.OBSIDIAN){

            public Object get() {
                return ((BlockEntry)this.receiver).getItemStackOrThrow();
            }
        };
        $this$advancement.background = ResourceLocation.withDefaultNamespace((String)"textures/block/stone.png");
    }

    private static final void CAN_YOU_SEE_ME$lambda$0(AdvancementBuilder $this$advancement) {
        Intrinsics.checkNotNullParameter((Object)$this$advancement, (String)"$this$advancement");
        $this$advancement.title = "Here I am.";
        $this$advancement.desc = "Can you see me?";
        $this$advancement.icon = (Function0)new PropertyReference0Impl(TBSBlocks.ALL_DEAD){

            public Object get() {
                return ((BlockEntry)this.receiver).getItemStackOrThrow();
            }
        };
        $this$advancement.background = ResourceLocation.withDefaultNamespace((String)"textures/block/stone.png");
    }

    private static final void NULLNULLNULL$lambda$0(AdvancementBuilder $this$advancement) {
        Intrinsics.checkNotNullParameter((Object)$this$advancement, (String)"$this$advancement");
        $this$advancement.title = "nullnullnull";
        $this$advancement.desc = "nullnullnull";
        $this$advancement.icon = (Function0)new PropertyReference0Impl(TBSItems.SERIAL_DESIGNATION_N){

            public Object get() {
                return ((ItemEntry)this.receiver).getStack();
            }
        };
        $this$advancement.background = ResourceLocation.withDefaultNamespace((String)"textures/block/stone.png");
    }

    private static final void YOUVE_BROUGHT_IT_UPON_YOURSELF$lambda$0(AdvancementBuilder $this$advancement) {
        Intrinsics.checkNotNullParameter((Object)$this$advancement, (String)"$this$advancement");
        $this$advancement.title = "You've brought it upon yourself.";
        $this$advancement.desc = "It was your fault.";
        $this$advancement.icon = (Function0)new PropertyReference0Impl(TBSItems.GORE){

            public Object get() {
                return ((ItemEntry)this.receiver).getStack();
            }
        };
        $this$advancement.background = ResourceLocation.withDefaultNamespace((String)"textures/block/stone.png");
    }

    private static final void POLAROID_CRAFT$lambda$0(AdvancementBuilder $this$advancement) {
        Intrinsics.checkNotNullParameter((Object)$this$advancement, (String)"$this$advancement");
        $this$advancement.title = "Look at the bigger picture";
        $this$advancement.desc = "A memory.";
        $this$advancement.icon = (Function0)new PropertyReference0Impl(TBSItems.POLAROID){

            public Object get() {
                return ((ItemEntry)this.receiver).getStack();
            }
        };
        $this$advancement.background = ResourceLocation.withDefaultNamespace((String)"textures/block/stone.png");
        $this$advancement.criteria.put("craft_polaroid", RecipeCraftedTrigger.TriggerInstance.craftedItem((ResourceLocation)TBSItems.POLAROID.getId()));
    }
}


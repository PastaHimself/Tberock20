/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.registry.TBSDataComponents;
import net.thebrokenscript.registry.TBSMenus;
import net.thebrokenscript.world.inventory.LibraryBookMenu;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/item/LibraryBookItem;", "Lnet/minecraft/world/item/Item;", "properties", "Lnet/minecraft/world/item/Item$Properties;", "<init>", "(Lnet/minecraft/world/item/Item$Properties;)V", "use", "Lnet/minecraft/world/InteractionResultHolder;", "Lnet/minecraft/world/item/ItemStack;", "level", "Lnet/minecraft/world/level/Level;", "player", "Lnet/minecraft/world/entity/player/Player;", "usedHand", "Lnet/minecraft/world/InteractionHand;", "inventoryTick", "", "stack", "entity", "Lnet/minecraft/world/entity/Entity;", "slot", "", "selected", "", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nLibraryBookItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibraryBookItem.kt\nnet/thebrokenscript/item/LibraryBookItem\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,60:1\n15#2:61\n*S KotlinDebug\n*F\n+ 1 LibraryBookItem.kt\nnet/thebrokenscript/item/LibraryBookItem\n*L\n33#1:61\n*E\n"})
public final class LibraryBookItem
extends Item {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MAX_ID = 251;

    public LibraryBookItem(@NotNull Item.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)usedHand, (String)"usedHand");
        ItemStack stack = player.getItemInHand(usedHand);
        if (!level.isClientSide && player instanceof ServerPlayer) {
            int n;
            Integer n2 = (Integer)stack.get((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke());
            if (n2 != null) {
                n = n2;
            } else {
                LibraryBookItem $this$use_u24lambda_u240 = this;
                boolean bl = false;
                int newId = level.random.nextInt(1, 251);
                stack.set((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke(), (Object)newId);
                n = newId;
            }
            int id = n;
            ServerPlayer serverPlayer = (ServerPlayer)player;
            String $this$c$iv = "";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            TBSMenus.LIBRARY_BOOK_GUI.open(serverPlayer, component, (arg_0, arg_1, arg_2) -> LibraryBookItem.use$lambda$1(id, arg_0, arg_1, arg_2));
        }
        if (level.isClientSide) {
            player.swing(usedHand);
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                RandomSource randomSource = RandomSource.create();
                Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"create(...)");
                localPlayer.playSound(SoundEvents.BOOK_PAGE_TURN, 1.0f, RandomUtil.nextFloat((RandomSource)randomSource, (float)0.85f, (float)1.6f));
            }
        }
        InteractionResultHolder interactionResultHolder = InteractionResultHolder.sidedSuccess((Object)stack, (boolean)level.isClientSide);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResultHolder, (String)"sidedSuccess(...)");
        return interactionResultHolder;
    }

    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slot, boolean selected) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (level.isClientSide) {
            return;
        }
        if (!stack.has((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke())) {
            stack.set((DataComponentType)TBSDataComponents.INSTANCE.getLIBRARY_BOOK_NUM().invoke(), (Object)level.random.nextInt(1, 251));
        }
    }

    private static final AbstractContainerMenu use$lambda$1(int $id, int containerId, Inventory inv, Player player) {
        MenuType menuType = (MenuType)TBSMenus.LIBRARY_BOOK_GUI.get();
        Intrinsics.checkNotNull((Object)inv);
        return new LibraryBookMenu((MenuType<LibraryBookMenu>)menuType, containerId, inv, $id);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/item/LibraryBookItem$Companion;", "", "<init>", "()V", "MAX_ID", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


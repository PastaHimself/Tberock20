/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.inventory.InventoryScreen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.item.ItemStack
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.handlers.subs.ScreenSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/CorruptedCommandBlockScreenHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class CorruptedCommandBlockScreenHandler {
    @NotNull
    public static final CorruptedCommandBlockScreenHandler INSTANCE = new CorruptedCommandBlockScreenHandler();

    private CorruptedCommandBlockScreenHandler() {
    }

    private static final Unit _init_$lambda$0(Screen screen) {
        Intrinsics.checkNotNullParameter((Object)screen, (String)"screen");
        if (screen instanceof InventoryScreen) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return Unit.INSTANCE;
            }
            LocalPlayer player = localPlayer;
            Inventory inventory = player.getInventory();
            ItemStack itemStack = TBSBlocks.CORRUPTED_COMMAND_BLOCK.getItemStack();
            Intrinsics.checkNotNull((Object)itemStack);
            if (inventory.contains(itemStack)) {
                PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.SYNC_PLAYER_BLOCKPOS, new CustomPacketPayload[0]);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        ScreenSubscriber.INSTANCE.add((Function1<? super Screen, Unit>)((Function1)CorruptedCommandBlockScreenHandler::_init_$lambda$0));
    }
}


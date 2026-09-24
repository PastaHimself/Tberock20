/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.handlers.subs.ItemCraftedSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/handlers/player/PolaroidCraftHandler;", "", "<init>", "()V", "crafting", "", "Lnet/minecraft/world/item/ItemStack;", "player", "Lnet/minecraft/world/entity/player/Player;", "craftMatrix", "Lnet/minecraft/world/Container;", "thebrokenscript-common"})
public final class PolaroidCraftHandler {
    @NotNull
    public static final PolaroidCraftHandler INSTANCE = new PolaroidCraftHandler();

    private PolaroidCraftHandler() {
    }

    public final void crafting(@NotNull ItemStack crafting, @NotNull Player player, @NotNull Container craftMatrix) {
        Intrinsics.checkNotNullParameter((Object)crafting, (String)"crafting");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)craftMatrix, (String)"craftMatrix");
        if (Intrinsics.areEqual((Object)crafting.getItem(), (Object)TBSItems.POLAROID.get())) {
            Level level = player.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).getCraftedPolaroid()) {
                RepUtilKt.applyRep(player, RepTier.GAIN_HUGE);
            }
            if (player.level().isClientSide) {
                PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.CRAFTED_POLAROID_PACKET.of(true), new CustomPacketPayload[0]);
            }
        }
    }

    static {
        ItemCraftedSubscriber.INSTANCE.add((Function3<? super ItemStack, ? super Player, ? super Container, Unit>)((Function3)new Function3<ItemStack, Player, Container, Unit>((Object)INSTANCE){

            public final void invoke(ItemStack p0, Player p1, Container p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((PolaroidCraftHandler)this.receiver).crafting(p0, p1, p2);
            }
        }));
    }
}


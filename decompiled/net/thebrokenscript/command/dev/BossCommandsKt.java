/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.BoolArgumentType
 *  com.mojang.brigadier.arguments.FloatArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.EntityArgument
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.client.overlay.IntegBossBarUpdate;
import net.thebrokenscript.client.overlay.JimmyBossBarUpdate;
import net.thebrokenscript.entity.integrity.phase1.IntegrityPhase1Entity;
import net.thebrokenscript.network.UpdateIntegBossBarPacket;
import net.thebrokenscript.network.UpdateJimmyBossBarPacket;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addBossCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
public final class BossCommandsKt {
    public static final void addBossCommands(@NotNull CommandDSL<CommandSourceStack> $this$addBossCommands) {
        Intrinsics.checkNotNullParameter($this$addBossCommands, (String)"<this>");
        $this$addBossCommands.group("boss", BossCommandsKt::addBossCommands$lambda$0);
    }

    private static final void addBossCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.entity(), (String)"entity(...)");
        $this$group.add("animate [entity]", argumentTypeArray, BossCommandsKt::addBossCommands$lambda$0$0);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        $this$group.add("kit [players]", argumentTypeArray, BossCommandsKt::addBossCommands$lambda$0$1);
        argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)BoolArgumentType.bool(), (String)"bool(...)");
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg((float)0.0f, (float)1.0f), (String)"floatArg(...)");
        $this$group.add("bar [players] [show] [value]", argumentTypeArray, BossCommandsKt::addBossCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)EntityArgument.players(), (String)"players(...)");
        Intrinsics.checkNotNullExpressionValue((Object)BoolArgumentType.bool(), (String)"bool(...)");
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg((float)0.0f, (float)1.0f), (String)"floatArg(...)");
        $this$group.add("jim_bar [players] [show] [value]", argumentTypeArray, BossCommandsKt::addBossCommands$lambda$0$3);
    }

    private static final int addBossCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Entity entity = EntityArgument.getEntity((CommandContext)it, (String)"entity");
        if (!(entity instanceof IntegrityPhase1Entity)) {
            CommandCxUtil.fail$default((String)"Must be integrity, you dumbass!", (CommandContext)it, (boolean)false, (int)2, null);
            return 1;
        }
        ((IntegrityPhase1Entity)entity).setCrawlOut(true);
        CommandCxUtil.success$default((String)"great job", (CommandContext)it, (boolean)false, (int)2, null);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addBossCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        Registry ench = ((CommandSourceStack)it.getSource()).registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        Holder.Reference prot = ench.getHolderOrThrow(Enchantments.PROTECTION);
        Holder.Reference sharp = ench.getHolderOrThrow(Enchantments.SHARPNESS);
        Holder.Reference power = ench.getHolderOrThrow(Enchantments.POWER);
        Holder.Reference punch = ench.getHolderOrThrow(Enchantments.PUNCH);
        Holder.Reference flame = ench.getHolderOrThrow(Enchantments.FLAME);
        Holder.Reference infinity = ench.getHolderOrThrow(Enchantments.INFINITY);
        Holder.Reference mending = ench.getHolderOrThrow(Enchantments.MENDING);
        Holder.Reference unbreaking = ench.getHolderOrThrow(Enchantments.UNBREAKING);
        for (ServerPlayer player : players) {
            void $this$addBossCommands_u24lambda_u240_u241_u246;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u245;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u244;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u243;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u242;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u241;
            ItemStack $this$addBossCommands_u24lambda_u240_u241_u240;
            ItemStack itemStack;
            ItemStack itemStack2 = itemStack = Items.NETHERITE_HELMET.getDefaultInstance();
            EquipmentSlot equipmentSlot = EquipmentSlot.HEAD;
            ServerPlayer serverPlayer = player;
            boolean bl = false;
            $this$addBossCommands_u24lambda_u240_u241_u240.enchant((Holder)prot, 4);
            Unit unit = Unit.INSTANCE;
            serverPlayer.setItemSlot(equipmentSlot, itemStack);
            $this$addBossCommands_u24lambda_u240_u241_u240 = itemStack = Items.NETHERITE_CHESTPLATE.getDefaultInstance();
            equipmentSlot = EquipmentSlot.CHEST;
            serverPlayer = player;
            boolean bl2 = false;
            $this$addBossCommands_u24lambda_u240_u241_u241.enchant((Holder)prot, 4);
            unit = Unit.INSTANCE;
            serverPlayer.setItemSlot(equipmentSlot, itemStack);
            $this$addBossCommands_u24lambda_u240_u241_u241 = itemStack = Items.NETHERITE_LEGGINGS.getDefaultInstance();
            equipmentSlot = EquipmentSlot.LEGS;
            serverPlayer = player;
            boolean bl3 = false;
            $this$addBossCommands_u24lambda_u240_u241_u242.enchant((Holder)prot, 4);
            unit = Unit.INSTANCE;
            serverPlayer.setItemSlot(equipmentSlot, itemStack);
            $this$addBossCommands_u24lambda_u240_u241_u242 = itemStack = Items.NETHERITE_BOOTS.getDefaultInstance();
            equipmentSlot = EquipmentSlot.FEET;
            serverPlayer = player;
            boolean bl4 = false;
            $this$addBossCommands_u24lambda_u240_u241_u243.enchant((Holder)prot, 4);
            unit = Unit.INSTANCE;
            serverPlayer.setItemSlot(equipmentSlot, itemStack);
            player.setItemSlot(EquipmentSlot.OFFHAND, Items.SHIELD.getDefaultInstance());
            $this$addBossCommands_u24lambda_u240_u241_u243 = itemStack = Items.NETHERITE_SWORD.getDefaultInstance();
            serverPlayer = player.getSlot(0);
            boolean bl5 = false;
            $this$addBossCommands_u24lambda_u240_u241_u244.enchant((Holder)sharp, 5);
            serverPlayer.set(itemStack);
            player.getSlot(1).set(Items.NETHERITE_PICKAXE.getDefaultInstance());
            player.getSlot(2).set(Items.NETHERITE_AXE.getDefaultInstance());
            player.getSlot(3).set(Items.NETHERITE_SHOVEL.getDefaultInstance());
            $this$addBossCommands_u24lambda_u240_u241_u244 = itemStack = Items.BOW.getDefaultInstance();
            serverPlayer = player.getSlot(4);
            boolean bl6 = false;
            $this$addBossCommands_u24lambda_u240_u241_u245.enchant((Holder)power, 5);
            $this$addBossCommands_u24lambda_u240_u241_u245.enchant((Holder)punch, 2);
            $this$addBossCommands_u24lambda_u240_u241_u245.enchant((Holder)infinity, 1);
            $this$addBossCommands_u24lambda_u240_u241_u245.enchant((Holder)flame, 1);
            serverPlayer.set(itemStack);
            player.getSlot(5).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(6).set(Items.WATER_BUCKET.getDefaultInstance());
            player.getSlot(7).set(Items.GOLDEN_APPLE.getDefaultInstance().copyWithCount(64));
            player.getSlot(8).set(Items.TORCH.getDefaultInstance().copyWithCount(64));
            player.getSlot(9).set(Items.ARROW.getDefaultInstance().copyWithCount(64));
            player.getSlot(10).set(Items.ARROW.getDefaultInstance().copyWithCount(64));
            player.getSlot(11).set(Items.SPECTRAL_ARROW.getDefaultInstance().copyWithCount(64));
            player.getSlot(12).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(13).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(14).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(15).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(16).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            player.getSlot(17).set(Items.COBBLESTONE.getDefaultInstance().copyWithCount(64));
            $this$addBossCommands_u24lambda_u240_u241_u245 = itemStack = Items.ELYTRA.getDefaultInstance();
            serverPlayer = player.getSlot(18);
            boolean bl7 = false;
            $this$addBossCommands_u24lambda_u240_u241_u246.enchant((Holder)unbreaking, 3);
            $this$addBossCommands_u24lambda_u240_u241_u246.enchant((Holder)mending, 1);
            serverPlayer.set(itemStack);
            player.getSlot(25).set(Items.COOKED_BEEF.getDefaultInstance().copyWithCount(64));
            player.getSlot(32).set(Items.FIREWORK_ROCKET.getDefaultInstance().copyWithCount(64));
            player.getSlot(34).set(Items.COOKED_BEEF.getDefaultInstance().copyWithCount(64));
            player.getSlot(26).set(Items.TORCH.getDefaultInstance().copyWithCount(64));
            player.getSlot(35).set(Items.TORCH.getDefaultInstance().copyWithCount(64));
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Given boss kit to " + players.size() + " players!"), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addBossCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        boolean show = BoolArgumentType.getBool((CommandContext)it, (String)"show");
        float value = FloatArgumentType.getFloat((CommandContext)it, (String)"value");
        UpdateIntegBossBarPacket packet = (UpdateIntegBossBarPacket)TBSPackets.UPDATE_INTEG_BOSS_BAR.of(new IntegBossBarUpdate(value, show));
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)packet));
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Updated boss bar for " + players.size() + " players!"), (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addBossCommands$lambda$0$3(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Collection players = EntityArgument.getPlayers((CommandContext)it, (String)"players");
        boolean show = BoolArgumentType.getBool((CommandContext)it, (String)"show");
        float value = FloatArgumentType.getFloat((CommandContext)it, (String)"value");
        UpdateJimmyBossBarPacket packet = (UpdateJimmyBossBarPacket)TBSPackets.UPDATE_JIMMY_BOSS_BAR.of(new JimmyBossBarUpdate(value, show));
        for (ServerPlayer player : players) {
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)packet));
        }
        CommandCxUtil.success$default((CommandContext)it, (String)("Updated boss bar for " + players.size() + " players!"), (boolean)false, (int)2, null);
        return 0;
    }
}


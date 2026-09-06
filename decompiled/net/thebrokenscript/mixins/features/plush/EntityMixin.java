/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.plush;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.item.PlushItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Entity.class})
public class EntityMixin {
    @Inject(method={"setShiftKeyDown"}, at={@At(value="HEAD")})
    public void tbs$plushSqueak(boolean keyDown, CallbackInfo ci) {
        Entity ent = (Entity)this;
        if (ent instanceof ServerPlayer) {
            ItemStack stack;
            Item item;
            ServerPlayer sp = (ServerPlayer)ent;
            if (keyDown && !ent.isSpectator() && !ent.isShiftKeyDown() && (item = (stack = sp.getItemBySlot(EquipmentSlot.HEAD)).getItem()) instanceof PlushItem) {
                PlushItem item2 = (PlushItem)item;
                item2.onUse(sp.serverLevel(), (Player)sp, stack);
            }
        }
    }
}


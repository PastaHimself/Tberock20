/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.llamalad7.mixinextras.sugar.Share
 *  com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef
 *  kotlin.Pair
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.Gui$HeartType
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  org.spongepowered.asm.mixin.Debug
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.events;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import java.util.HashMap;
import kotlin.Pair;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export=true)
@Mixin(value={Gui.class})
public class GuiMixin {
    @Unique
    private static final HashMap<TextureAtlasSprite, Pair<Boolean, MobEffectInstance>> bc$carry = new HashMap();

    @WrapOperation(method={"renderHearts"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderHeart(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/gui/Gui$HeartType;IIZZZ)V")})
    public void bc$onRenderHeartContainer(Gui instance, GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k1"}) int k1, @Local(name={"l1"}) int l1, @Local(argsOnly=true) Player player, @Local(argsOnly=true, index=5) int height, @Local(argsOnly=true, index=6) int offsetHeartIndex, @Local(argsOnly=true, index=7) float maxHealth, @Local(argsOnly=true, index=8) int currentHealth, @Local(argsOnly=true, index=9) int displayHealth, @Local(argsOnly=true, index=10) int absorptionAmount, @Local(argsOnly=true, index=11) boolean renderHighlight) {
        RenderEvents.Hud.Heart.HeartData data2 = new RenderEvents.Hud.Heart.HeartData(guiGraphics, l, player, k1, l1, height, offsetHeartIndex, maxHealth, currentHealth, displayHealth, absorptionAmount, renderHighlight);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Heart.CONTAINER, data2)) {
            original.call(new Object[]{instance, guiGraphics, heartType, x, y, hardcore, halfHeart, blinking});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderHearts"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderHeart(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/gui/Gui$HeartType;IIZZZ)V")})
    public void bc$onRenderHeartAbsorption(Gui instance, GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k1"}) int k1, @Local(name={"l1"}) int l1, @Local(argsOnly=true) Player player, @Local(argsOnly=true, index=5) int height, @Local(argsOnly=true, index=6) int offsetHeartIndex, @Local(argsOnly=true, index=7) float maxHealth, @Local(argsOnly=true, index=8) int currentHealth, @Local(argsOnly=true, index=9) int displayHealth, @Local(argsOnly=true, index=10) int absorptionAmount, @Local(argsOnly=true, index=11) boolean renderHighlight) {
        RenderEvents.Hud.Heart.HeartData data2 = new RenderEvents.Hud.Heart.HeartData(guiGraphics, l, player, k1, l1, height, offsetHeartIndex, maxHealth, currentHealth, displayHealth, absorptionAmount, renderHighlight);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Heart.ABSORPTION, data2)) {
            original.call(new Object[]{instance, guiGraphics, heartType, x, y, hardcore, halfHeart, blinking});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderHearts"}, at={@At(ordinal=2, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderHeart(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/gui/Gui$HeartType;IIZZZ)V")})
    public void bc$onRenderHeartHalf(Gui instance, GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k1"}) int k1, @Local(name={"l1"}) int l1, @Local(argsOnly=true) Player player, @Local(argsOnly=true, index=5) int height, @Local(argsOnly=true, index=6) int offsetHeartIndex, @Local(argsOnly=true, index=7) float maxHealth, @Local(argsOnly=true, index=8) int currentHealth, @Local(argsOnly=true, index=9) int displayHealth, @Local(argsOnly=true, index=10) int absorptionAmount, @Local(argsOnly=true, index=11) boolean renderHighlight) {
        RenderEvents.Hud.Heart.HeartData data2 = new RenderEvents.Hud.Heart.HeartData(guiGraphics, l, player, k1, l1, height, offsetHeartIndex, maxHealth, currentHealth, displayHealth, absorptionAmount, renderHighlight);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Heart.HEARTS, data2)) {
            original.call(new Object[]{instance, guiGraphics, heartType, x, y, hardcore, halfHeart, blinking});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderHearts"}, at={@At(ordinal=3, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderHeart(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/gui/Gui$HeartType;IIZZZ)V")})
    public void bc$onRenderHeart(Gui instance, GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k1"}) int k1, @Local(name={"l1"}) int l1, @Local(argsOnly=true) Player player, @Local(argsOnly=true, index=5) int height, @Local(argsOnly=true, index=6) int offsetHeartIndex, @Local(argsOnly=true, index=7) float maxHealth, @Local(argsOnly=true, index=8) int currentHealth, @Local(argsOnly=true, index=9) int displayHealth, @Local(argsOnly=true, index=10) int absorptionAmount, @Local(argsOnly=true, index=11) boolean renderHighlight) {
        RenderEvents.Hud.Heart.HeartData data2 = new RenderEvents.Hud.Heart.HeartData(guiGraphics, l, player, k1, l1, height, offsetHeartIndex, maxHealth, currentHealth, displayHealth, absorptionAmount, renderHighlight);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Heart.HEARTS, data2)) {
            original.call(new Object[]{instance, guiGraphics, heartType, x, y, hardcore, halfHeart, blinking});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderArmor"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    private static void bc$onRenderArmor(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k"}) int k, @Local(name={"j"}) int j, @Local(argsOnly=true) Player player, @Local(argsOnly=true, index=3) int heartRows) {
        RenderEvents.Hud.ArmorData data2 = new RenderEvents.Hud.ArmorData(instance, player, l, j, heartRows, height, k);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.ARMOR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderFood"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderHungerContainer(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k"}) int k, @Local(name={"j"}) int j, @Local(argsOnly=true) Player player) {
        RenderEvents.Hud.Hunger.HungerData data2 = new RenderEvents.Hud.Hunger.HungerData(instance, l, k, RenderEvents.Hud.Hunger.ShankType.CONTAINER, player.hasEffect(MobEffects.HUNGER), j);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Hunger.CONTAINER, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderFood"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderHungerFull(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k"}) int k, @Local(name={"j"}) int j, @Local(argsOnly=true) Player player) {
        RenderEvents.Hud.Hunger.HungerData data2 = new RenderEvents.Hud.Hunger.HungerData(instance, l, k, RenderEvents.Hud.Hunger.ShankType.FULL, player.hasEffect(MobEffects.HUNGER), j);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Hunger.SHANK, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderFood"}, at={@At(ordinal=2, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderHungerHalf(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"l"}) int l, @Local(name={"k"}) int k, @Local(name={"j"}) int j, @Local(argsOnly=true) Player player) {
        RenderEvents.Hud.Hunger.HungerData data2 = new RenderEvents.Hud.Hunger.HungerData(instance, l, k, RenderEvents.Hud.Hunger.ShankType.HALF, player.hasEffect(MobEffects.HUNGER), j);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Hunger.SHANK, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderSlot(Lnet/minecraft/client/gui/GuiGraphics;IILnet/minecraft/client/DeltaTracker;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;I)V")})
    public void bc$onRenderItem(Gui instance, GuiGraphics guiGraphics, int x, int y, DeltaTracker deltaTracker, Player player, ItemStack stack, int seed, Operation<Void> original, @Local(name={"i1"}) int i1, @Local(name={"j1"}) int j1, @Local(name={"k1"}) int k1) {
        RenderEvents.Hud.HotbarItems.HotbarItemData data2 = new RenderEvents.Hud.HotbarItems.HotbarItemData(guiGraphics, player, deltaTracker, j1, k1, i1, (ItemStack)player.getInventory().items.get(i1));
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.HotbarItems.MAIN_HAND_ITEM, data2)) {
            original.call(new Object[]{instance, guiGraphics, x, y, deltaTracker, player, stack, seed});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderSlot(Lnet/minecraft/client/gui/GuiGraphics;IILnet/minecraft/client/DeltaTracker;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;I)V")})
    public void bc$onRenderItemOffhandLeft(Gui instance, GuiGraphics guiGraphics, int x, int y, DeltaTracker deltaTracker, Player player, ItemStack stack, int seed, Operation<Void> original, @Local(name={"i"}) int i, @Local(name={"i2"}) int i2) {
        RenderEvents.Hud.HotbarItems.HotbarItemData data2 = new RenderEvents.Hud.HotbarItems.HotbarItemData(guiGraphics, player, deltaTracker, i - 91 - 26, i2, -1, stack);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.HotbarItems.OFFHAND_ITEM, data2)) {
            original.call(new Object[]{instance, guiGraphics, x, y, deltaTracker, player, stack, seed});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/Gui;renderSlot(Lnet/minecraft/client/gui/GuiGraphics;IILnet/minecraft/client/DeltaTracker;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;I)V")})
    public void bc$onRenderItemOffhandRight(Gui instance, GuiGraphics guiGraphics, int x, int y, DeltaTracker deltaTracker, Player player, ItemStack stack, int seed, Operation<Void> original, @Local(name={"i"}) int i, @Local(name={"i2"}) int i2) {
        RenderEvents.Hud.HotbarItems.HotbarItemData data2 = new RenderEvents.Hud.HotbarItems.HotbarItemData(guiGraphics, player, deltaTracker, i + 91 + 10, i2, -1, stack);
        guiGraphics.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.HotbarItems.OFFHAND_ITEM, data2)) {
            original.call(new Object[]{instance, guiGraphics, x, y, deltaTracker, player, stack, seed});
        }
        guiGraphics.pop();
    }

    @WrapOperation(method={"renderCrosshair"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderIndicatorFull(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(argsOnly=true) DeltaTracker deltaTracker) {
        RenderEvents.Hud.AttackIndicatorData data2 = new RenderEvents.Hud.AttackIndicatorData(instance, deltaTracker, false, 0.0f);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.ATTACK_INDICATOR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderCrosshair"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderIndicatorProgress(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"f"}) float f, @Local(argsOnly=true) DeltaTracker deltaTracker) {
        RenderEvents.Hud.AttackIndicatorData data2 = new RenderEvents.Hud.AttackIndicatorData(instance, deltaTracker, false, Math.max(1.0f - f, 0.0f));
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.ATTACK_INDICATOR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=4, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onHotbarIndicator(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"f"}) float f, @Local(argsOnly=true) DeltaTracker deltaTracker) {
        RenderEvents.Hud.AttackIndicatorData data2 = new RenderEvents.Hud.AttackIndicatorData(instance, deltaTracker, true, Math.max(1.0f - f, 0.0f));
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.ATTACK_INDICATOR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderExperienceBar"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderExperienceBarBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original) {
        LocalPlayer player = Minecraft.getInstance().player;
        assert (player != null);
        RenderEvents.Hud.Experience.ExperienceData data2 = new RenderEvents.Hud.Experience.ExperienceData(instance, player.experienceLevel, player.experienceProgress);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Experience.BAR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderExperienceBar"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIIIIIII)V")})
    public void bc$onRenderExperienceBar(GuiGraphics instance, ResourceLocation sprite, int textureWidth, int textureHeight, int uPosition, int vPosition, int x, int y, int uWidth, int vHeight, Operation<Void> original) {
        LocalPlayer player = Minecraft.getInstance().player;
        assert (player != null);
        RenderEvents.Hud.Experience.ExperienceData data2 = new RenderEvents.Hud.Experience.ExperienceData(instance, player.experienceLevel, player.experienceProgress);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Experience.BAR, data2)) {
            original.call(new Object[]{instance, sprite, textureWidth, textureHeight, uPosition, vPosition, x, y, uWidth, vHeight});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderExperienceLevel"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;IIIZ)I")})
    public int bc$onRenderExperienceLevel(GuiGraphics instance, Font font, String text, int x, int y, int color, boolean dropShadow, Operation<Integer> original) {
        LocalPlayer player = Minecraft.getInstance().player;
        assert (player != null);
        RenderEvents.Hud.Experience.ExperienceData data2 = new RenderEvents.Hud.Experience.ExperienceData(instance, player.experienceLevel, player.experienceProgress);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Experience.BAR, data2)) {
            return (Integer)original.call(new Object[]{instance, font, text, x, y, color, dropShadow});
        }
        instance.pop();
        return 0;
    }

    @WrapOperation(method={"renderCrosshair"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderCrosshair(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(argsOnly=true) DeltaTracker deltaTracker) {
        RenderEvents.Hud.CrosshairData data2 = new RenderEvents.Hud.CrosshairData(instance, deltaTracker, (instance.guiWidth() - 15) / 2, (instance.guiHeight() - 15) / 2);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.CROSSHAIR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderHotbarBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"player"}) Player player, @Local(name={"humanoidarm"}) HumanoidArm humanoidarm) {
        RenderEvents.Hud.Background.BackgroundData data2 = new RenderEvents.Hud.Background.BackgroundData(instance, player.getInventory().selected, humanoidarm == HumanoidArm.LEFT);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Background.HOTBAR, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=2, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderOffhandLeftBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"player"}) Player player) {
        RenderEvents.Hud.Background.BackgroundData data2 = new RenderEvents.Hud.Background.BackgroundData(instance, player.getInventory().selected, true);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Background.OFFHAND, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=3, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderOffhandRightBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"player"}) Player player) {
        RenderEvents.Hud.Background.BackgroundData data2 = new RenderEvents.Hud.Background.BackgroundData(instance, player.getInventory().selected, true);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Background.OFFHAND, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderItemHotbar"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderHighlight(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"player"}) Player player, @Local(name={"humanoidarm"}) HumanoidArm humanoidarm) {
        RenderEvents.Hud.Background.BackgroundData data2 = new RenderEvents.Hud.Background.BackgroundData(instance, player.getInventory().selected, humanoidarm == HumanoidArm.LEFT);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Background.HIGHLIGHT, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderEffects"}, at={@At(ordinal=1, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderEffectBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"mobeffectinstance"}) MobEffectInstance mobeffectinstance, @Share(value="ambient") LocalBooleanRef bc$ambient) {
        RenderEvents.Hud.Potion.PotionData data2 = new RenderEvents.Hud.Potion.PotionData(instance, mobeffectinstance, false);
        bc$ambient.set(false);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Potion.BACKGROUND, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @WrapOperation(method={"renderEffects"}, at={@At(ordinal=0, value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V")})
    public void bc$onRenderEffectAmbientBG(GuiGraphics instance, ResourceLocation sprite, int x, int y, int width, int height, Operation<Void> original, @Local(name={"mobeffectinstance"}) MobEffectInstance mobeffectinstance, @Share(value="ambient") LocalBooleanRef bc$ambient) {
        RenderEvents.Hud.Potion.PotionData data2 = new RenderEvents.Hud.Potion.PotionData(instance, mobeffectinstance, true);
        bc$ambient.set(true);
        instance.push();
        if (!GameEvent.callCancelable(RenderEvents.Hud.Potion.BACKGROUND, data2)) {
            original.call(new Object[]{instance, sprite, x, y, width, height});
        }
        instance.pop();
    }

    @Inject(method={"renderEffects"}, at={@At(ordinal=0, value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z")})
    public void bc$populateCarry(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci, @Local(name={"mobeffectinstance"}) MobEffectInstance mobeffectinstance, @Local(name={"textureatlassprite"}) TextureAtlasSprite textureatlassprite, @Share(value="ambient") LocalBooleanRef bc$ambient) {
        bc$carry.put(textureatlassprite, (Pair<Boolean, MobEffectInstance>)new Pair((Object)bc$ambient.get(), (Object)mobeffectinstance));
    }

    @Inject(method={"renderEffects"}, at={@At(value="HEAD")})
    public void bc$clearCarry(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        bc$carry.clear();
    }
}


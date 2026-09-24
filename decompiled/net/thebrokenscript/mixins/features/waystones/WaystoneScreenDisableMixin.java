/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.blay09.mods.waystones.client.gui.screen.WaystoneSelectionScreenBase
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.waystones;

import java.util.Objects;
import net.blay09.mods.waystones.client.gui.screen.WaystoneSelectionScreenBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.registry.TBSTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WaystoneSelectionScreenBase.class})
public class WaystoneScreenDisableMixin {
    @Inject(method={"init"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$disableScreen(CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        assert (player != null);
        ClientLevel level = player.clientLevel;
        Iterable entityList = level.entitiesForRendering();
        for (Entity entity : entityList) {
            String namespace = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace();
            if (!namespace.equals("thebrokenscript") || !entity.getType().is(TBSTags.TBS_CHASERS) || !Objects.requireNonNull(EntityUtil.clientTargetUUID((Entity)entity)).equals(player.getUUID())) continue;
            Minecraft.getInstance().setScreen(null);
            player.displayClientMessage(ComponentUtil.getC((String)"Error: Unknown Screen"), true);
            ci.cancel();
        }
    }
}


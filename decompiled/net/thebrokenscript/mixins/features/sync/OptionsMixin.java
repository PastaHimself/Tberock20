/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.CameraType
 *  net.minecraft.client.Options
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.sync;

import java.lang.runtime.SwitchBootstraps;
import net.minecraft.client.CameraType;
import net.minecraft.client.Options;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.data.CameraMode;
import net.thebrokenscript.registry.TBSPackets;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Options.class})
public class OptionsMixin {
    @Inject(method={"setCameraType"}, at={@At(value="TAIL")})
    public void tbs$syncCameraType(CameraType pointOfView, CallbackInfo ci) {
        CameraType cameraType = pointOfView;
        int n = 0;
        PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.SET_CAMERA_MODE.of((Object)(switch (SwitchBootstraps.enumSwitch("enumSwitch", new Object[]{"FIRST_PERSON", "THIRD_PERSON_BACK", "THIRD_PERSON_FRONT"}, (CameraType)cameraType, n)) {
            case 0 -> CameraMode.FIRST_PERSON;
            case 1 -> CameraMode.THIRD_PERSON_BACK;
            case 2 -> CameraMode.THIRD_PERSON_FRONT;
            default -> CameraMode.FIRST_PERSON;
        })), new CustomPacketPayload[0]);
    }
}


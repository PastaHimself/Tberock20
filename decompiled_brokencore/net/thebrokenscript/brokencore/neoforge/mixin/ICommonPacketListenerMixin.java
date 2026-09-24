/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Connection
 *  net.minecraft.network.ConnectionProtocol
 *  net.minecraft.network.PacketListener
 *  net.minecraft.resources.ResourceLocation
 *  net.neoforged.neoforge.common.extensions.ICommonPacketListener
 *  net.neoforged.neoforge.network.registration.NetworkRegistry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 *  org.spongepowered.asm.mixin.Shadow
 */
package net.thebrokenscript.brokencore.neoforge.mixin;

import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.PacketListener;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import net.thebrokenscript.brokencore.api.fake.FakePlayerPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={ICommonPacketListener.class})
public interface ICommonPacketListenerMixin
extends PacketListener {
    @Shadow
    public Connection getConnection();

    @Overwrite
    default public boolean hasChannel(ResourceLocation payloadId) {
        if (this instanceof FakePlayerPacketListener) {
            return false;
        }
        return NetworkRegistry.hasChannel((Connection)this.getConnection(), (ConnectionProtocol)this.protocol(), (ResourceLocation)payloadId);
    }
}


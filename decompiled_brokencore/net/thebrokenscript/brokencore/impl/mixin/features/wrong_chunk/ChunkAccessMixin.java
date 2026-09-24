/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.network.PlayerChunkSender
 *  org.spongepowered.asm.mixin.Mixin
 */
package net.thebrokenscript.brokencore.impl.mixin.features.wrong_chunk;

import net.minecraft.server.network.PlayerChunkSender;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={PlayerChunkSender.class})
public abstract class ChunkAccessMixin {
}


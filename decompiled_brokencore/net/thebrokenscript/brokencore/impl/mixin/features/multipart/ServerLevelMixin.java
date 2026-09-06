/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  net.minecraft.server.level.ServerLevel
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.server.level.ServerLevel;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.impl.mixinterfaces.MultipartServerLevelState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={ServerLevel.class})
public class ServerLevelMixin
implements MultipartServerLevelState {
    @Unique
    private final Int2ObjectMap<MultipartEntityPart<?>> bc$multipartEntities = new Int2ObjectOpenHashMap();

    @Override
    public Int2ObjectMap<MultipartEntityPart<?>> bc$getMultipartEntities() {
        return this.bc$multipartEntities;
    }
}


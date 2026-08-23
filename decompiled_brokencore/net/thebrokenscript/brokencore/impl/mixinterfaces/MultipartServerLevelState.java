/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 */
package net.thebrokenscript.brokencore.impl.mixinterfaces;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;

public interface MultipartServerLevelState {
    public Int2ObjectMap<MultipartEntityPart<?>> bc$getMultipartEntities();
}


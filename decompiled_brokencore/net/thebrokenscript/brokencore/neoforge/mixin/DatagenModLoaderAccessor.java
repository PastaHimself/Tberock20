/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  net.neoforged.neoforge.data.loading.DatagenModLoader
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.brokencore.neoforge.mixin;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.loading.DatagenModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={DatagenModLoader.class})
public interface DatagenModLoaderAccessor {
    @Accessor(value="existingFileHelper")
    public static ExistingFileHelper brokencore$getExistingFileHelper() {
        throw new AssertionError();
    }
}


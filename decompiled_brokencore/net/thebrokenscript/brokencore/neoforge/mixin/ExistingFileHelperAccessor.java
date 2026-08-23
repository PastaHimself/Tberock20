/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.PackType
 *  net.minecraft.server.packs.resources.MultiPackResourceManager
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.brokencore.neoforge.mixin;

import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ExistingFileHelper.class})
public interface ExistingFileHelperAccessor {
    @Accessor(value="clientResources")
    public MultiPackResourceManager brokencore$getClientResources();

    @Accessor(value="serverData")
    public MultiPackResourceManager brokencore$getServerData();

    @Accessor(value="generated")
    public Multimap<PackType, ResourceLocation> brokencore$getGenerated();

    @Accessor(value="enable")
    public boolean brokencore$getEnable();
}


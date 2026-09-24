/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.entity.EntityAccess
 *  net.minecraft.world.level.entity.EntityLookup
 *  net.minecraft.world.level.entity.EntitySectionStorage
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.brokencore.impl.mixin.features.entitylookup;

import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityLookup;
import net.minecraft.world.level.entity.EntitySectionStorage;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={LevelEntityGetterAdapter.class})
public interface LevelEntityGetterAdapterAccessor<T extends EntityAccess> {
    @Accessor(value="visibleEntities")
    public EntityLookup<T> bc$getVisibleEntities();

    @Accessor(value="sectionStorage")
    public EntitySectionStorage<T> bc$getSectionStorage();
}


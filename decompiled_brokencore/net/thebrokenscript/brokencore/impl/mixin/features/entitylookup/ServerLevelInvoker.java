/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  net.minecraft.world.level.entity.PersistentEntitySectionManager
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package net.thebrokenscript.brokencore.impl.mixin.features.entitylookup;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import net.thebrokenscript.brokencore.api.mixinterfaces.ServerLevelExt;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={ServerLevel.class})
public class ServerLevelInvoker
implements ServerLevelExt {
    @Shadow
    @Final
    private PersistentEntitySectionManager<Entity> entityManager;

    @Override
    @NotNull
    public LevelEntityGetterAdapter<Entity> brokencore_getEntities() {
        return (LevelEntityGetterAdapter)this.entityManager.getEntityGetter();
    }
}


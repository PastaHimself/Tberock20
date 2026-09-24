/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.NaturalSpawner$SpawnState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.spawning;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.thebrokenscript.registry.TBSMobCategories;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={NaturalSpawner.SpawnState.class})
public class SpawnStateMixin {
    @Inject(method={"canSpawn"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$forceSpawns(EntityType<?> entityType, BlockPos pos, ChunkAccess chunk, CallbackInfoReturnable<Boolean> cir) {
        if (BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getNamespace().equals("thebrokenscript")) {
            cir.setReturnValue((Object)true);
        }
    }

    @Inject(method={"canSpawnForCategory"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$forceCategorySpawns(MobCategory category, ChunkPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (category == TBSMobCategories.MOBS) {
            cir.setReturnValue((Object)true);
        }
    }
}


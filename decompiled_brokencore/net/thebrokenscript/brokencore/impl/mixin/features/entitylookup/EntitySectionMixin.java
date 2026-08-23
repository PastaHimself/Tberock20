/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.ClassInstanceMultiMap
 *  net.minecraft.world.level.entity.EntityAccess
 *  net.minecraft.world.level.entity.EntitySection
 *  net.minecraft.world.level.entity.Visibility
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.features.entitylookup;

import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.util.ClassInstanceMultiMap;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntitySection;
import net.minecraft.world.level.entity.Visibility;
import net.thebrokenscript.brokencore.api.mixinterfaces.EntityLookupExt;
import net.thebrokenscript.brokencore.api.util.data.ConcurrentClassInstanceMultiMap;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntitySection.class})
public class EntitySectionMixin<T extends EntityAccess>
implements EntityLookupExt<T> {
    @Mutable
    @Shadow
    @Final
    private ClassInstanceMultiMap<T> storage;
    @Unique
    private final ConcurrentClassInstanceMultiMap<EntityAccess> bc$byClass = new ConcurrentClassInstanceMultiMap<EntityAccess>(EntityAccess.class);

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void bc$replaceWithConcurrent(Class<T> entityClazz, Visibility chunkStatus, CallbackInfo ci) {
        this.storage = new ConcurrentClassInstanceMultiMap<T>(entityClazz);
    }

    @Inject(method={"add"}, at={@At(value="RETURN")})
    private void bc$addToClassMap(T entity, CallbackInfo ci) {
        this.bc$byClass.add((EntityAccess)entity);
    }

    @Inject(method={"remove"}, at={@At(value="RETURN")})
    private void bc$removeFromClassMap(T entity, CallbackInfoReturnable<Boolean> cir) {
        this.bc$byClass.remove(entity);
    }

    @Override
    @NotNull
    public <U extends T> @NotNull Collection<@NotNull U> bc$getByClass(@NotNull @NotNull Class<@NotNull U> clazz) {
        return new ArrayList<U>(this.bc$byClass.find(clazz));
    }
}


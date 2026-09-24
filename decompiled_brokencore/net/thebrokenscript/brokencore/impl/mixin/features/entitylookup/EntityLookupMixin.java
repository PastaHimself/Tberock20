/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.entity.EntityAccess
 *  net.minecraft.world.level.entity.EntityLookup
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.entitylookup;

import java.util.Collection;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityLookup;
import net.thebrokenscript.brokencore.api.mixinterfaces.EntityLookupExt;
import net.thebrokenscript.brokencore.api.util.data.ConcurrentClassInstanceMultiMap;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityLookup.class})
public class EntityLookupMixin<T extends EntityAccess>
implements EntityLookupExt<T> {
    @Unique
    private final ConcurrentClassInstanceMultiMap<EntityAccess> bc$byClass = new ConcurrentClassInstanceMultiMap<EntityAccess>(EntityAccess.class);

    @Inject(method={"add"}, at={@At(value="RETURN")})
    private void bc$addToClassMap(T entity, CallbackInfo ci) {
        this.bc$byClass.add((EntityAccess)entity);
    }

    @Inject(method={"remove"}, at={@At(value="RETURN")})
    private void bc$removeFromClassMap(T entity, CallbackInfo ci) {
        this.bc$byClass.remove(entity);
    }

    @Override
    @NotNull
    public <U extends T> @NotNull Collection<@NotNull U> bc$getByClass(@NotNull @NotNull Class<@NotNull U> clazz) {
        return this.bc$byClass.find(clazz);
    }
}


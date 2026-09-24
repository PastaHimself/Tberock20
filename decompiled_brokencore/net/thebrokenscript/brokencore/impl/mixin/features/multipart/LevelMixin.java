/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.entity.EntityTypeTest
 *  net.minecraft.world.phys.AABB
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.impl.mixinterfaces.MultipartServerLevelState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Level.class})
public class LevelMixin {
    @Inject(method={"getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"}, at={@At(value="RETURN")})
    private void bc$addMultipartsPred(Entity entity, AABB boundingBox, Predicate<? super Entity> predicate, CallbackInfoReturnable<List<Entity>> cir, @Local List<Entity> list) {
        Level me = (Level)this;
        if (!(me instanceof ServerLevel)) {
            return;
        }
        ServerLevel server = (ServerLevel)me;
        Int2ObjectMap<MultipartEntityPart<?>> ents = ((MultipartServerLevelState)server).bc$getMultipartEntities();
        for (MultipartEntityPart part : ents.values()) {
            if (part == entity || !part.getBoundingBox().intersects(boundingBox) || !predicate.test(part)) continue;
            list.add(part);
        }
    }

    @Inject(method={"getEntities(Lnet/minecraft/world/level/entity/EntityTypeTest;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;Ljava/util/List;I)V"}, at={@At(value="RETURN")})
    private <T extends Entity> void bc$addMultipartsTest(EntityTypeTest<Entity, T> entityTypeTest, AABB bounds, Predicate<? super T> predicate, List<? super T> output, int maxResults, CallbackInfo ci) {
        Level me = (Level)this;
        if (!(me instanceof ServerLevel)) {
            return;
        }
        ServerLevel server = (ServerLevel)me;
        Int2ObjectMap<MultipartEntityPart<?>> ents = ((MultipartServerLevelState)server).bc$getMultipartEntities();
        for (MultipartEntityPart part : ents.values()) {
            Entity t = (Entity)entityTypeTest.tryCast((Object)part);
            if (t == null || !t.getBoundingBox().intersects(bounds) || !predicate.test(t)) continue;
            output.add(t);
            if (output.size() < maxResults) continue;
            break;
        }
    }
}


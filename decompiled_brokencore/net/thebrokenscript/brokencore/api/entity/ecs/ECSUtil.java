/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.MobCategory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity.ecs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/ECSUtil;", "", "<init>", "()V", "createEmptyEntityType", "Lnet/minecraft/world/entity/EntityType;", "T", "Lnet/minecraft/world/entity/Entity;", "brokencore-common"})
public final class ECSUtil {
    @NotNull
    public static final ECSUtil INSTANCE = new ECSUtil();

    private ECSUtil() {
    }

    @NotNull
    public final <T extends Entity> EntityType<T> createEmptyEntityType() {
        EntityType entityType = EntityType.Builder.createNothing((MobCategory)MobCategory.MISC).noSave().build(null);
        Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"build(...)");
        return entityType;
    }
}


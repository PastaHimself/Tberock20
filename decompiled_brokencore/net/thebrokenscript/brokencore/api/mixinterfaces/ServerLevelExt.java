/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import kotlin.Metadata;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/brokencore/api/mixinterfaces/ServerLevelExt;", "", "brokencore_getEntities", "Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;", "Lnet/minecraft/world/entity/Entity;", "brokencore-common"})
public interface ServerLevelExt {
    @NotNull
    public LevelEntityGetterAdapter<Entity> brokencore_getEntities();
}


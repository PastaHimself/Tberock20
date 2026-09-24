/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"tryDropItems", "", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/world/phys/Vec3;", "stack", "Lnet/minecraft/world/item/ItemStack;", "pickUpDelay", "", "brokencore-common"})
@JvmName(name="ItemUtil")
public final class ItemUtil {
    public static final void tryDropItems(@NotNull LevelAccessor $this$tryDropItems, @NotNull Vec3 pos, @NotNull ItemStack stack, int pickUpDelay) {
        Intrinsics.checkNotNullParameter((Object)$this$tryDropItems, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        if (!($this$tryDropItems instanceof ServerLevel)) {
            return;
        }
        ItemEntity ent = new ItemEntity((Level)$this$tryDropItems, pos.x, pos.y, pos.z, stack);
        ent.setPickUpDelay(pickUpDelay);
        ((ServerLevel)$this$tryDropItems).addFreshEntity((Entity)ent);
    }

    public static /* synthetic */ void tryDropItems$default(LevelAccessor levelAccessor, Vec3 vec3, ItemStack itemStack, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 10;
        }
        ItemUtil.tryDropItems(levelAccessor, vec3, itemStack, n);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fever;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/fever/FeverNavigation;", "Lnet/minecraft/world/entity/ai/navigation/FlyingPathNavigation;", "entity", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/thebrokenscript/api/entity/BaseFeverEntity;Lnet/minecraft/world/level/Level;)V", "canUpdatePath", "", "canMoveDirectly", "pos1", "Lnet/minecraft/world/phys/Vec3;", "pos2", "thebrokenscript-common"})
public final class FeverNavigation
extends FlyingPathNavigation {
    @NotNull
    private final BaseFeverEntity entity;

    public FeverNavigation(@NotNull BaseFeverEntity entity, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super((Mob)entity, level);
        this.entity = entity;
    }

    protected boolean canUpdatePath() {
        return super.canUpdatePath() && this.entity.canMove();
    }

    protected boolean canMoveDirectly(@NotNull Vec3 pos1, @NotNull Vec3 pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        return super.canMoveDirectly(pos1, pos2) && this.entity.canMove();
    }
}


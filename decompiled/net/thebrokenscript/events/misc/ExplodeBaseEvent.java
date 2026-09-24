/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt
 *  net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/events/misc/ExplodeBaseEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
public final class ExplodeBaseEvent
extends TBSEvent {
    public ExplodeBaseEvent() {
        super(1);
    }

    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return super.canExecute(level, player, pos) && PlayerExt.INSTANCE.getReputation(player) == ReputationEnum.BAD;
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        VoxelShape voxelShape = ((AbstractRoom)CollectionsKt.random((Collection)PlayerExt.INSTANCE.getBase((Player)player).getRooms(), (Random)((Random)Random.Default))).getShape();
        if (voxelShape == null || (voxelShape = VoxelShapeExtKt.randomBlockPos((VoxelShape)voxelShape)) == null) {
            return;
        }
        VoxelShape blockPos = voxelShape;
        double offsetX = level.random.nextInt(5, 16);
        double offsetZ = level.random.nextInt(5, 16);
        Vec3 offset = new Vec3(offsetX, 0.0, offsetZ).scale((double)level.random.nextFloat() < 0.7 ? 1.0 : -1.0);
        Vec3 explosionPos = blockPos.getCenter().add(offset);
        level.explode(null, explosionPos.x, explosionPos.y, explosionPos.z, 4.0f, Level.ExplosionInteraction.TNT);
    }
}


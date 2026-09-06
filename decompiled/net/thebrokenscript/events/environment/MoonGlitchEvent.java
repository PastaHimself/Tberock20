/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.environment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/events/environment/MoonGlitchEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
public final class MoonGlitchEvent
extends NullEvent {
    public MoonGlitchEvent() {
        super(1);
    }

    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return super.canExecute(level, player, pos) && PlayerExt.INSTANCE.getMoonGlitchDuration(player) < 1.0;
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)((Holder)TBSSounds.MOON_GLITCH), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
        PlayerExt.INSTANCE.setMoonGlitchDuration(player, 1600.0);
        LevelUtil.getQueue((Level)((Level)level)).add(55L, () -> MoonGlitchEvent.execute$lambda$0(level, player));
    }

    private static final Unit execute$lambda$0(ServerLevel $level, ServerPlayer $player) {
        if ($level.random.nextBoolean() && $level.canSeeSky($player.blockPosition())) {
            RandomSource random = $level.random;
            double distance = 35.0;
            double angle = Math.toRadians(((double)random.nextFloat() - 0.5) * 30.0);
            Vec3 look = $player.getLookAngle();
            double cos = Math.cos(angle);
            double sin = Math.sin(angle);
            Vec3 rotatedLook = new Vec3(look.x * cos - look.z * sin, look.y, look.x * sin + look.z * cos).normalize();
            Vec3 spawnPos = $player.position().add(rotatedLook.x * distance, 0.0, rotatedLook.z * distance);
            Intrinsics.checkNotNull((Object)spawnPos);
            BlockPos fixedPos = $level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, PositionUtil.getBlockPos((Position)((Position)spawnPos)));
            EntityType entityType = (EntityType)TBSEntities.INTEGRITY_CURIOUS.invoke();
            LevelAccessor levelAccessor = (LevelAccessor)$level;
            Intrinsics.checkNotNull((Object)fixedPos);
            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (BlockPos)fixedPos);
        }
        return Unit.INSTANCE;
    }
}


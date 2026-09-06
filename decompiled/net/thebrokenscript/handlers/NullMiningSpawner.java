/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/NullMiningSpawner;", "", "<init>", "()V", "onPlayerTick", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class NullMiningSpawner {
    @NotNull
    public static final NullMiningSpawner INSTANCE = new NullMiningSpawner();

    private NullMiningSpawner() {
    }

    private final void onPlayerTick(Player player) {
        Level level = player.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (!(player instanceof ServerPlayer)) {
            return;
        }
        if (!Intrinsics.areEqual((Object)((ServerLevel)level).dimension(), (Object)Level.OVERWORLD) && !Intrinsics.areEqual((Object)((ServerLevel)level).dimension(), (Object)Level.NETHER)) {
            return;
        }
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere()) {
            return;
        }
        BlockPos pos = player.blockPosition();
        if (PlayerExt.INSTANCE.getReputation((ServerPlayer)player) != ReputationEnum.GOOD && pos.getY() < 40 && (double)((ServerLevel)level).random.nextFloat() < 3.0E-5 && ((ServerPlayer)player).gameMode.isSurvival() && !((ServerLevel)level).isFlat()) {
            RandomSource random = ((ServerLevel)level).random;
            Integer x = null;
            Integer z = null;
            boolean negativeX = random.nextBoolean();
            boolean negativeZ = random.nextBoolean();
            x = negativeX ? Integer.valueOf(random.nextInt(5, 16) * -1) : Integer.valueOf(random.nextInt(5, 16));
            z = negativeZ ? Integer.valueOf(random.nextInt(5, 16) * -1) : Integer.valueOf(random.nextInt(5, 16));
            BlockPos blockPos = pos.offset(x.intValue(), 0, z.intValue());
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            BlockPos spawnPos = blockPos;
            ((ServerLevel)level).removeBlock(spawnPos, false);
            ((ServerLevel)level).removeBlock(spawnPos.above(), false);
            EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_MINING.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)spawnPos));
        }
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((NullMiningSpawner)this.receiver).onPlayerTick(p0);
            }
        }));
    }
}


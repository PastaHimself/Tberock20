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
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.api.ext.AccessorExt;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/events/sounds/ParanoiaEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "getStepSoundUnderPlayer", "Lnet/minecraft/sounds/SoundEvent;", "repeatWithDelay", "sound", "times", "", "thebrokenscript-common"})
public final class ParanoiaEvent
extends TBSEvent {
    public ParanoiaEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (!BaseMonsterExtKt.isInCave((LivingEntity)((LivingEntity)player))) {
            return;
        }
        boolean randomBoolean = level.random.nextBoolean();
        if (randomBoolean) {
            SoundEvent sound = this.getStepSoundUnderPlayer(player);
            if (sound != null) {
                this.repeatWithDelay(level, player, sound, 5);
            }
        } else {
            SoundEvent blockSound = null;
            BlockState blockState = null;
            for (int yi = 0; yi < 10; ++yi) {
                for (int xi = -9; xi < 10; ++xi) {
                    for (int zi = -9; zi < 10; ++zi) {
                        Vec3 offset = new Vec3((double)xi, (double)yi, (double)zi);
                        BlockPos newPos = BlockPos.containing((Position)((Position)pos.add(offset)));
                        blockState = level.getBlockState(newPos);
                        if (!level.random.nextBoolean() || blockState.isAir()) continue;
                        blockSound = level.random.nextBoolean() ? blockState.getSoundType().getBreakSound() : blockState.getSoundType().getPlaceSound();
                        break;
                    }
                    if (blockSound != null) break;
                }
                if (blockSound != null) break;
            }
            if (blockSound != null) {
                this.repeatWithDelay(level, player, blockSound, 1);
            }
        }
    }

    private final SoundEvent getStepSoundUnderPlayer(ServerPlayer player) {
        Level level = player.level();
        BlockPos pos = player.blockPosition().below();
        BlockState blockState = level.getBlockState(pos);
        Block block = blockState.getBlock();
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"getBlock(...)");
        BlockBehaviour blockBehaviour = (BlockBehaviour)block;
        Intrinsics.checkNotNull((Object)blockState);
        SoundType soundType = AccessorExt.INSTANCE.getSoundType(blockBehaviour, blockState);
        return soundType.getStepSound();
    }

    private final void repeatWithDelay(ServerLevel level, ServerPlayer player, SoundEvent sound, int times) {
        if (times <= 0) {
            return;
        }
        double offsetX = -2.0 + level.random.nextDouble() * 4.0;
        double offsetZ = -2.0 + level.random.nextDouble() * 4.0;
        Holder holder2 = Holder.direct((Object)sound);
        player.connection.send((Packet)new ClientboundSoundPacket(holder2, SoundSource.AMBIENT, player.getX() + offsetX, player.getY(), player.getZ() + offsetZ, 55.0f, 1.0f, level.random.nextLong()));
        this.queue(level.random.nextInt(5, 16), () -> ParanoiaEvent.repeatWithDelay$lambda$0(this, level, player, sound, times));
    }

    private static final Unit repeatWithDelay$lambda$0(ParanoiaEvent this$0, ServerLevel $level, ServerPlayer $player, SoundEvent $sound, int $times) {
        this$0.repeatWithDelay($level, $player, $sound, $times - 1);
        return Unit.INSTANCE;
    }
}


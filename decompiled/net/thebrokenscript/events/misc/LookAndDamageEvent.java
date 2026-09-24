/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/LookAndDamageEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class LookAndDamageEvent
extends TBSEvent {
    public LookAndDamageEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.queue(1L, () -> LookAndDamageEvent.execute$lambda$0(player, level, pos));
        this.queue(5L, () -> LookAndDamageEvent.execute$lambda$1(player, level, pos));
        this.queue(5L, () -> LookAndDamageEvent.execute$lambda$2(player, level, pos));
        this.queue(5L, () -> LookAndDamageEvent.execute$lambda$3(player, level, pos));
    }

    private static final Unit execute$lambda$0(ServerPlayer $player, ServerLevel $level, Vec3 $pos) {
        $player.hurt($level.damageSources().generic(), 1.0f);
        $player.lookAt(EntityAnchorArgument.Anchor.EYES, $pos);
        $player.getFoodData().setFoodLevel($player.getRandom().nextInt(1, 10));
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1(ServerPlayer $player, ServerLevel $level, Vec3 $pos) {
        $player.hurt($level.damageSources().generic(), 1.0f);
        $player.lookAt(EntityAnchorArgument.Anchor.EYES, $pos.add(0.0, 20.0, 0.0));
        $player.getFoodData().setFoodLevel($player.getRandom().nextInt(1, 10));
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$2(ServerPlayer $player, ServerLevel $level, Vec3 $pos) {
        $player.hurt($level.damageSources().generic(), 1.0f);
        $player.lookAt(EntityAnchorArgument.Anchor.EYES, $pos.add(20.0, 0.0, 0.0));
        $player.getFoodData().setFoodLevel($player.getRandom().nextInt(1, 10));
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$3(ServerPlayer $player, ServerLevel $level, Vec3 $pos) {
        $player.hurt($level.damageSources().generic(), 1.0f);
        $player.lookAt(EntityAnchorArgument.Anchor.EYES, $pos.add(0.0, 0.0, 20.0));
        $player.getFoodData().setFoodLevel($player.getRandom().nextInt(1, 10));
        return Unit.INSTANCE;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.StructureUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.structures;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.StructureUtil;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/events/structures/GiiftEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
public final class GiiftEvent
extends NullEvent {
    public GiiftEvent() {
        super(1);
    }

    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return super.canExecute(level, player, pos) && PlayerExt.INSTANCE.getReputation(player) == ReputationEnum.GOOD;
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (TBSConfigs.INSTANCE.getServer().getWorld().getDisableRandomStructures()) {
            return;
        }
        BlockPos blockPos = PlayerExt.INSTANCE.getBase((Player)player).randomBottomPos((Level)level);
        if (blockPos != null) {
            if (level.getBlockState(blockPos.below()).isAir()) {
                ResourceLocation resourceLocation = TBSConstants.id("giift");
                BlockPos blockPos2 = blockPos.below();
                Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"below(...)");
                v2 = StructureUtil.placeStructure((ServerLevel)level, (ResourceLocation)resourceLocation, (BlockPos)blockPos2);
            } else {
                v2 = StructureUtil.placeStructure((ServerLevel)level, (ResourceLocation)TBSConstants.id("giift"), (BlockPos)blockPos);
            }
        }
    }
}


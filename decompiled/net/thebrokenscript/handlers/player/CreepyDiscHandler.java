/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ParticleUtil
 *  net.thebrokenscript.brokencore.api.util.math.Vectors
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ParticleUtil;
import net.thebrokenscript.brokencore.api.util.math.Vectors;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerRightClickInteractSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/player/CreepyDiscHandler;", "", "<init>", "()V", "onRightClickBlock", "", "ent", "Lnet/minecraft/world/entity/player/Player;", "level", "Lnet/minecraft/world/level/Level;", "pos", "Lnet/minecraft/core/BlockPos;", "hand", "Lnet/minecraft/world/InteractionHand;", "hitVec", "Lnet/minecraft/world/phys/BlockHitResult;", "thebrokenscript-common"})
public final class CreepyDiscHandler {
    @NotNull
    public static final CreepyDiscHandler INSTANCE = new CreepyDiscHandler();

    private CreepyDiscHandler() {
    }

    public final void onRightClickBlock(@NotNull Player ent, @NotNull Level level, @NotNull BlockPos pos, @NotNull InteractionHand hand, @NotNull BlockHitResult hitVec) {
        Intrinsics.checkNotNullParameter((Object)ent, (String)"ent");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)hitVec, (String)"hitVec");
        if (hand != ent.getUsedItemHand()) {
            return;
        }
        if (!(ent instanceof ServerPlayer)) {
            return;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars(ent);
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (!((ServerPlayer)ent).getMainHandItem().is(TBSTags.CREEPY_DISCS)) {
            return;
        }
        if (((ServerLevel)level).getBlockState(hitVec.getBlockPos()).is(Blocks.JUKEBOX)) {
            vars.setHasPlayedCreepyDisc(true);
            vars.syncTo(ent);
            ServerLevel serverLevel = (ServerLevel)level;
            Supplier supplier = (Supplier)TBSParticleTypes.NULL_PARTICLE;
            Vec3 vec3 = pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            ParticleUtil.sendParticles((ServerLevel)serverLevel, (Supplier)supplier, (Vec3)vec3, (Number)40, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
        }
    }

    static {
        PlayerRightClickInteractSubscriber.INSTANCE.add((Function5<? super Player, ? super Level, ? super BlockPos, ? super InteractionHand, ? super BlockHitResult, Unit>)((Function5)new Function5<Player, Level, BlockPos, InteractionHand, BlockHitResult, Unit>((Object)INSTANCE){

            public final void invoke(Player p0, Level p1, BlockPos p2, InteractionHand p3, BlockHitResult p4) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
                Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
                ((CreepyDiscHandler)this.receiver).onRightClickBlock(p0, p1, p2, p3, p4);
            }
        }));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.entity.nullent.NullMiningEntity;
import net.thebrokenscript.handlers.subs.AttackEntitySubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/handlers/NullMiningDespawner;", "", "<init>", "()V", "onEntityAttacked", "", "target", "Lnet/minecraft/world/entity/Entity;", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class NullMiningDespawner {
    @NotNull
    public static final NullMiningDespawner INSTANCE = new NullMiningDespawner();

    private NullMiningDespawner() {
    }

    public final void onEntityAttacked(@NotNull Entity target, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Level level = player.level();
        if ((double)target.getRandom().nextFloat() > 0.05) {
            return;
        }
        if (!(target instanceof NullMiningEntity) || ((NullMiningEntity)target).getDespawning()) {
            return;
        }
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ServerLevel serverLevel = (ServerLevel)level;
        Vec3 vec3 = target.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)serverLevel, (Vec3)vec3, (Number)500);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player2 = serverPlayer;
        ((NullMiningEntity)target).setDespawning(true);
        ((NullMiningEntity)target).lookAt(EntityAnchorArgument.Anchor.EYES, player2.position());
        player2.lookAt(EntityAnchorArgument.Anchor.EYES, target.position().add(0.0, (double)((NullMiningEntity)target).getEyeHeight(), 0.0));
        PlayerUtil.sendSound$default((ServerPlayer)player2, (Holder)((Holder)TBSSounds.ONE_OF_US), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
        ((NullMiningEntity)target).queueDiscard(5L);
    }

    static {
        AttackEntitySubscriber.INSTANCE.add((Function2<? super Entity, ? super Player, Unit>)((Function2)new Function2<Entity, Player, Unit>((Object)INSTANCE){

            public final void invoke(Entity p0, Player p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                ((NullMiningDespawner)this.receiver).onEntityAttacked(p0, p1);
            }
        }));
    }
}


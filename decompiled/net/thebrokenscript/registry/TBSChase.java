/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.registry.objects.ChaseRegistry
 *  net.thebrokenscript.brokencore.api.registry.util.ChaseRule
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.registry.objects.ChaseRegistry;
import net.thebrokenscript.brokencore.api.registry.util.ChaseRule;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.nullent.NullChaseEntity;
import net.thebrokenscript.entity.nullent.NullMazeEntity;
import net.thebrokenscript.entity.siluet.HeChaseEntity;
import net.thebrokenscript.entity.siluet.SiluetChaseEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSChase;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSChase {
    @NotNull
    public static final TBSChase INSTANCE = new TBSChase();

    private TBSChase() {
    }

    private static final boolean _init_$lambda$0(TheBrokenEndEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return !entity.isNoAi() && (Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID()) || EntityUtil.isWithin((Entity)((Entity)player), (Vec3)entity.getPos(), (Number)48));
    }

    private static final boolean _init_$lambda$1(CircuitEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return !entity.isNoAi() && (Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID()) || EntityUtil.isWithin((Entity)((Entity)player), (Vec3)entity.getPos(), (Number)48));
    }

    private static final boolean _init_$lambda$2(NullMazeEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID());
    }

    private static final boolean _init_$lambda$3(SiluetChaseEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID()) || EntityUtil.isWithin((Entity)((Entity)player), (Vec3)entity.getPos(), (Number)48);
    }

    private static final boolean _init_$lambda$4(HeChaseEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID()) || EntityUtil.isWithin((Entity)((Entity)player), (Vec3)entity.getPos(), (Number)48);
    }

    private static final boolean _init_$lambda$5(NullChaseEntity entity, Player player) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)((Entity)entity)), (Object)player.getUUID()) || EntityUtil.isWithin((Entity)((Entity)player), (Vec3)entity.getPos(), (Number)48);
    }

    static {
        ChaseRegistry.INSTANCE.register(new ChaseRule(TheBrokenEndEntity.class, (Supplier)TBSSounds.THE_BROKEN_END_CHASE, false, TBSChase::_init_$lambda$0, 4, null));
        ChaseRegistry.INSTANCE.register(new ChaseRule(CircuitEntity.class, (Supplier)TBSSounds.CIRCUIT_CHASE, false, TBSChase::_init_$lambda$1, 4, null));
        ChaseRegistry.INSTANCE.register(new ChaseRule(NullMazeEntity.class, (Supplier)TBSSounds.MAZE_CHASE, true, TBSChase::_init_$lambda$2));
        ChaseRegistry.INSTANCE.register(new ChaseRule(SiluetChaseEntity.class, (Supplier)TBSSounds.SILUET_CHASE, false, TBSChase::_init_$lambda$3, 4, null));
        ChaseRegistry.INSTANCE.register(new ChaseRule(HeChaseEntity.class, (Supplier)TBSSounds.SILUET_CHASE, false, TBSChase::_init_$lambda$4, 4, null));
        ChaseRegistry.INSTANCE.register(new ChaseRule(NullChaseEntity.class, (Supplier)TBSSounds.NULL_CHASE, false, TBSChase::_init_$lambda$5, 4, null));
    }
}


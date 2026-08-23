/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/entity/misc/BanEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "baseTick", "", "tick", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBanEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BanEntity.kt\nnet/thebrokenscript/entity/misc/BanEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class BanEntity
extends BaseMonster {
    public BanEntity(@NotNull EntityType<BanEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public void baseTick() {
        this.onServerTick(arg_0 -> BanEntity.baseTick$lambda$0(this, arg_0));
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> BanEntity.tick$lambda$0(this));
    }

    private static final Unit baseTick$lambda$0(BanEntity this$0, ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (!TBSConfigs.INSTANCE.getServer().getDisableBanning()) {
            Player player = level.getNearestPlayer((Entity)this$0, 128.0);
            if (player == null) {
                return Unit.INSTANCE;
            }
            Player player2 = player;
            PlayerExt.INSTANCE.updateVars(player2, (Function1<? super PlayerVariables, Unit>)((Function1)BanEntity::baseTick$lambda$0$0));
            Unit it = Unit.INSTANCE;
            boolean bl = false;
            this$0.discard();
        } else {
            this$0.discard();
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setBan(true);
        return Unit.INSTANCE;
    }

    private static final Object tick$lambda$0(BanEntity this$0) {
        if (!ClientVariables.INSTANCE.has(128L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(128L);
            }
        }
        return Unit.INSTANCE;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.fake_player;

import java.util.Collection;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/api/entity/ai/fake_player/FakePlayerGoals;", "", "<init>", "()V", "FakePlayerMimic", "FakePlayerTargeting", "thebrokenscript-common"})
public final class FakePlayerGoals {
    @NotNull
    public static final FakePlayerGoals INSTANCE = new FakePlayerGoals();

    private FakePlayerGoals() {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/api/entity/ai/fake_player/FakePlayerGoals$FakePlayerMimic;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "fakePlayer", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "<init>", "(Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;)V", "getFakePlayer", "()Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "start", "", "stop", "canUse", "", "canContinueToUse", "requiresUpdateEveryTick", "ticksWhileMimicing", "", "getTicksWhileMimicing", "()I", "setTicksWhileMimicing", "(I)V", "offset", "getOffset", "zOffset", "getZOffset", "()Z", "tick", "thebrokenscript-common"})
    public static final class FakePlayerMimic
    extends Goal {
        @NotNull
        private final FakePlayerEntity fakePlayer;
        private int ticksWhileMimicing;
        private final int offset;
        private final boolean zOffset;

        public FakePlayerMimic(@NotNull FakePlayerEntity fakePlayer) {
            Intrinsics.checkNotNullParameter((Object)((Object)fakePlayer), (String)"fakePlayer");
            this.fakePlayer = fakePlayer;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
            Object[] objectArray = new Integer[]{-5, -4, -3, 3, 4, 5};
            this.offset = ((Number)CollectionsKt.random((Collection)CollectionsKt.listOf((Object[])objectArray), (Random)((Random)Random.Default))).intValue();
            this.zOffset = this.fakePlayer.getRandom().nextBoolean();
        }

        @NotNull
        public final FakePlayerEntity getFakePlayer() {
            return this.fakePlayer;
        }

        public void start() {
            super.start();
            this.fakePlayer.setNoGravity(true);
        }

        public void stop() {
            super.stop();
            this.fakePlayer.setNoGravity(false);
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.fakePlayer.getTarget();
            Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
            if (player == null) {
                return false;
            }
            Player target = player;
            if (!target.isAlive()) {
                return false;
            }
            if (target.isSpectator()) {
                return false;
            }
            return !(this.fakePlayer.distanceToSqr((Entity)target) > 32.0);
        }

        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.fakePlayer.getTarget();
            Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
            if (player == null) {
                return false;
            }
            Player target = player;
            if (!target.isAlive()) {
                return false;
            }
            if (target.isSpectator()) {
                return false;
            }
            return !(this.fakePlayer.distanceToSqr((Entity)target) > 32.0);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public final int getTicksWhileMimicing() {
            return this.ticksWhileMimicing;
        }

        public final void setTicksWhileMimicing(int n) {
            this.ticksWhileMimicing = n;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final boolean getZOffset() {
            return this.zOffset;
        }

        public void tick() {
            LivingEntity livingEntity = this.fakePlayer.getTarget();
            Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
            if (player == null) {
                return;
            }
            Player player2 = player;
            if (this.ticksWhileMimicing < this.fakePlayer.getEvilDuration()) {
                if (this.zOffset) {
                    this.fakePlayer.setPos(player2.getX() + (double)this.offset, player2.getY(), player2.getZ());
                } else {
                    this.fakePlayer.setPos(player2.getX(), player2.getY(), player2.getZ() + (double)this.offset);
                }
                this.fakePlayer.setYRot((player2.getYRot() + 180.0f) % 360.0f);
                this.fakePlayer.setXRot(-player2.getXRot());
                this.fakePlayer.yHeadRot = (player2.yHeadRot + 180.0f) % 360.0f;
                int n = this.ticksWhileMimicing;
                this.ticksWhileMimicing = n + 1;
            } else {
                EntityType entityType = (EntityType)TBSEntities.CIRCUIT.get();
                Level level = this.fakePlayer.level();
                Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
                EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)((LevelAccessor)level), (Vec3)this.fakePlayer.getPos());
                this.fakePlayer.kill();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/ai/fake_player/FakePlayerGoals$FakePlayerTargeting;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "predicate", "Lkotlin/Function1;", "Lnet/minecraft/world/entity/LivingEntity;", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Lkotlin/jvm/functions/Function1;)V", "canUse", "canContinueToUse", "thebrokenscript-common"})
    public static final class FakePlayerTargeting
    extends Goal {
        @NotNull
        private final Mob mob;
        @NotNull
        private final Function1<LivingEntity, Boolean> predicate;

        public FakePlayerTargeting(@NotNull Mob mob, @NotNull Function1<? super LivingEntity, Boolean> predicate) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
            this.mob = mob;
            this.predicate = predicate;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.TARGET));
        }

        public /* synthetic */ FakePlayerTargeting(Mob mob, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                function1 = FakePlayerTargeting::_init_$lambda$0;
            }
            this(mob, (Function1<? super LivingEntity, Boolean>)function1);
        }

        public boolean canUse() {
            Player player = this.mob.level().getNearestPlayer((Entity)this.mob, 256.0);
            if (player == null) {
                return false;
            }
            Player targetPlayer = player;
            if (targetPlayer.isSpectator()) {
                return false;
            }
            if (!((Boolean)this.predicate.invoke((Object)targetPlayer)).booleanValue()) {
                return false;
            }
            this.mob.setTarget((LivingEntity)targetPlayer);
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            if (this.mob.getTarget() == null) return false;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) return false;
            if (!livingEntity.isAlive()) return false;
            boolean bl = true;
            if (!bl) return false;
            if ((Boolean)this.predicate.invoke((Object)this.mob.getTarget()) == false) return false;
            LivingEntity livingEntity2 = this.mob.getTarget();
            if (livingEntity2 == null) return false;
            if (livingEntity2.isSpectator()) return false;
            return true;
        }

        private static final boolean _init_$lambda$0(LivingEntity it) {
            return true;
        }
    }
}


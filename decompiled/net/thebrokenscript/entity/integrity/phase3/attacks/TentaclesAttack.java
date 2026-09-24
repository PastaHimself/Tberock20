/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.ext.DamageSourcesExt
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.ext.DamageSourcesExt;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.integrity.phase3.attacks.Attack;
import net.thebrokenscript.entity.integrity.phase3.attacks.AttackType;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\"H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/TentaclesAttack;", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/Attack;", "<init>", "()V", "type", "Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "getType", "()Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "attackCooldown", "", "getAttackCooldown", "()J", "chance", "", "getChance", "()F", "canMove", "", "entity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "canUse", "length", "distanceRange", "Lkotlin/Pair;", "", "getDistanceRange", "()Lkotlin/Pair;", "setup", "", "finish", "tick", "animate", "Lsoftware/bernie/geckolib/animation/PlayState;", "state", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTentaclesAttack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TentaclesAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/TentaclesAttack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n774#2:113\n865#2,2:114\n774#2:116\n865#2,2:117\n1869#2,2:119\n1869#2,2:121\n*S KotlinDebug\n*F\n+ 1 TentaclesAttack.kt\nnet/thebrokenscript/entity/integrity/phase3/attacks/TentaclesAttack\n*L\n27#1:113\n27#1:114,2\n53#1:116\n53#1:117,2\n55#1:119,2\n78#1:121,2\n*E\n"})
public final class TentaclesAttack
extends Attack {
    @NotNull
    private final AttackType type = AttackType.TENTACLES;
    private final long attackCooldown;
    private final float chance;
    @NotNull
    private final Pair<Integer, Integer> distanceRange = TuplesKt.to((Object)10, (Object)20);

    public TentaclesAttack() {
        this.attackCooldown = 55L;
        this.chance = 0.9f;
    }

    @Override
    @NotNull
    public AttackType getType() {
        return this.type;
    }

    @Override
    public long getAttackCooldown() {
        return this.attackCooldown;
    }

    @Override
    public float getChance() {
        return this.chance;
    }

    @Override
    public boolean canMove(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean canUse(@NotNull IntegrityPhase3Entity entity) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        if (entity.getTarget() == null) {
            return false;
        }
        Iterable $this$filter$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)entity.getLevel()), (Vec3)entity.getPos(), (Number)35);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Player it = (Player)element$iv$iv;
            boolean bl = false;
            double d = it.getY() - entity.getY();
            boolean bl2 = 0.0 <= d ? d <= 1.5 : false;
            if (!bl2) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List players = (List)destination$iv$iv;
        return !((Collection)players).isEmpty();
    }

    @Override
    public long length(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 144L;
    }

    @Override
    @NotNull
    public Pair<Integer, Integer> getDistanceRange() {
        return this.distanceRange;
    }

    @Override
    public void setup(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setAoeAttackTimer(0);
        entity.getNavigation().stop();
        entity.getMoveControl().setWantedPosition(entity.getX(), entity.getY(), entity.getZ(), 0.0);
        entity.setDeltaMovement(Vec3.ZERO);
        entity.setStuck(true);
    }

    @Override
    public void finish(@NotNull IntegrityPhase3Entity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        entity.setStuck(false);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void tick(@NotNull IntegrityPhase3Entity entity) {
        double upwardStrength;
        double knockbackStrength;
        double horizontalDist;
        boolean $i$f$forEach;
        Iterable $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        int n = entity.getAoeAttackTimer();
        entity.setAoeAttackTimer(n + 1);
        int timer = n;
        if (timer == 65) {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)entity.getLevel()), (Vec3)entity.getPos(), (Number)25);
            boolean $i$f$filter = false;
            Iterator iterator = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Player it = (Player)element$iv$iv;
                boolean bl = false;
                double d = it.getY() - entity.getY();
                boolean bl2 = 0.0 <= d ? d <= 1.5 : false;
                if (!(bl2 && it.distanceTo((Entity)entity) > 8.0f)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List players = (List)destination$iv$iv;
            $this$forEach$iv = players;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Player player = (Player)element$iv;
                boolean bl = false;
                DamageSources damageSources = entity.damageSources();
                Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
                player.hurt(DamageSourcesExt.INSTANCE.source(damageSources, TBSDamageTypes.INTEGRITY_SHIELD_BYPASS.getKey(), (Entity)entity), 7.5f);
                if (!(player.distanceTo((Entity)entity) < 10.0f)) continue;
                double dx = player.getX() - entity.getX();
                double dz = player.getZ() - entity.getZ();
                horizontalDist = RangesKt.coerceAtLeast((double)Math.sqrt(dx * dx + dz * dz), (double)0.001);
                knockbackStrength = 2.3;
                upwardStrength = 1.15;
                player.setDeltaMovement(player.getDeltaMovement().add(dx / horizontalDist * knockbackStrength, upwardStrength, dz / horizontalDist * knockbackStrength));
                player.hurtMarked = true;
            }
        }
        if (timer == 80) {
            List players = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)entity.getLevel()), (Vec3)entity.getPos(), (Number)35);
            $this$forEach$iv = players;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Player player = (Player)element$iv;
                boolean bl = false;
                DamageSources damageSources = entity.damageSources();
                Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
                player.hurt(DamageSourcesExt.INSTANCE.source(damageSources, TBSDamageTypes.INTEGRITY_SHIELD_BYPASS.getKey(), (Entity)entity), 5.0f);
                if (!(player.distanceTo((Entity)entity) < 10.0f) || !player.onGround()) continue;
                double dx = player.getX() - entity.getX();
                double dz = player.getZ() - entity.getZ();
                horizontalDist = RangesKt.coerceAtLeast((double)Math.sqrt(dx * dx + dz * dz), (double)0.001);
                knockbackStrength = 1.25;
                upwardStrength = 0.95;
                player.setDeltaMovement(player.getDeltaMovement().add(dx / horizontalDist * knockbackStrength, upwardStrength, dz / horizontalDist * knockbackStrength));
                player.hurtMarked = true;
            }
        }
    }

    @Override
    @NotNull
    public PlayState animate(@NotNull AnimationState<IntegrityPhase3Entity> state) {
        Intrinsics.checkNotNullParameter(state, (String)"state");
        IntegrityPhase3Entity ent = (IntegrityPhase3Entity)state.getAnimatable();
        AnimationController ctrl = state.getController();
        if (ent.getAttackTicks() < 1) {
            state.resetCurrentAnimation();
        }
        Intrinsics.checkNotNull((Object)ctrl);
        Intrinsics.checkNotNull((Object)((Object)ent));
        GeckoUtil.once((AnimationController)ctrl, (Entity)((Entity)ent), (String)"aoeTentacles");
        return PlayState.CONTINUE;
    }
}


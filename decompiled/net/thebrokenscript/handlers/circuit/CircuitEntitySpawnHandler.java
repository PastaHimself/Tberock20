/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.animal.WaterAnimal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.Villager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.circuit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.CircuitInhabited;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.handlers.subs.EntitySpawnSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSTags;
import net.thebrokenscript.util.CustomGoals;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/circuit/CircuitEntitySpawnHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class CircuitEntitySpawnHandler {
    @NotNull
    public static final CircuitEntitySpawnHandler INSTANCE = new CircuitEntitySpawnHandler();

    private CircuitEntitySpawnHandler() {
    }

    private static final Unit _init_$lambda$0(Entity it, CancelProxy cancelProxy) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"<unused var>");
        if (it instanceof Player) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual((Object)it.level().dimension(), (Object)Level.END)) {
            return Unit.INSTANCE;
        }
        CircuitInhabited hasInhabited = (CircuitInhabited)TBSDataAttachments.CIRCUIT_INHABITED.get(it);
        if (hasInhabited.getInhabited() && it instanceof PathfinderMob) {
            ((PathfinderMob)it).goalSelector.getAvailableGoals().clear();
            ((PathfinderMob)it).targetSelector.getAvailableGoals().clear();
            ((PathfinderMob)it).goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)it));
            if (((PathfinderMob)it).getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                ((PathfinderMob)it).goalSelector.addGoal(1, (Goal)new MeleeAttackGoal((PathfinderMob)it, 1.05, false));
            }
            ((PathfinderMob)it).goalSelector.addGoal(2, (Goal)new CustomGoals.CircuitSpawnGoal((Mob)it));
            if (it instanceof Villager) {
                ((Villager)it).goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)it, 0.6));
            } else {
                ((PathfinderMob)it).goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)it, 1.05));
            }
            ((PathfinderMob)it).goalSelector.addGoal(4, (Goal)new LookAtPlayerGoal((Mob)it, Player.class, 32.0f, 100.0f));
            if (it instanceof Monster) {
                ((Monster)it).targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)it, Player.class, true));
                ((Monster)it).targetSelector.addGoal(2, (Goal)new HurtByTargetGoal((PathfinderMob)it, new Class[0]));
            }
            return Unit.INSTANCE;
        }
        Level level = it.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCircuitInhabitedDelay() > 0) {
            return Unit.INSTANCE;
        }
        RandomSource randomSource = it.getRandom();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"getRandom(...)");
        if (RandomUtil.nextDouble((RandomSource)randomSource, (double)0.0, (double)100.0) <= TBSConfigs.INSTANCE.getServer().getEntities().getDisguisedCircuitEntityChance() && !it.getType().is(TBSTags.NOT_INHABITABLE) && it instanceof PathfinderMob && !(it instanceof Villager) && !(it instanceof WaterAnimal)) {
            Level level2 = it.level();
            Intrinsics.checkNotNullExpressionValue((Object)level2, (String)"level(...)");
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level2).isNullHere()) {
                TBSDataAttachments.CIRCUIT_INHABITED.set(it, (Object)new CircuitInhabited(true));
                ((PathfinderMob)it).goalSelector.getAvailableGoals().clear();
                ((PathfinderMob)it).targetSelector.getAvailableGoals().clear();
                ((PathfinderMob)it).goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)it));
                if (((PathfinderMob)it).getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                    ((PathfinderMob)it).goalSelector.addGoal(1, (Goal)new MeleeAttackGoal((PathfinderMob)it, 1.05, false));
                }
                ((PathfinderMob)it).goalSelector.addGoal(2, (Goal)new CustomGoals.CircuitSpawnGoal((Mob)it));
                ((PathfinderMob)it).goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)it, 1.05));
                ((PathfinderMob)it).goalSelector.addGoal(4, (Goal)new LookAtPlayerGoal((Mob)it, Player.class, 32.0f, 100.0f));
                if (it instanceof Monster) {
                    ((Monster)it).targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)it, Player.class, true));
                    ((Monster)it).targetSelector.addGoal(2, (Goal)new HurtByTargetGoal((PathfinderMob)it, new Class[0]));
                }
                Level level3 = it.level();
                Intrinsics.checkNotNullExpressionValue((Object)level3, (String)"level(...)");
                LevelExt.INSTANCE.updateVars((LevelAccessor)level3, (Function1<? super MapVariables, Unit>)((Function1)CircuitEntitySpawnHandler::lambda$0$0));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCircuitInhabitedDelay(5200);
        return Unit.INSTANCE;
    }

    static {
        EntitySpawnSubscriber.INSTANCE.add((Function2<? super Entity, ? super CancelProxy, Unit>)((Function2)CircuitEntitySpawnHandler::_init_$lambda$0));
    }
}


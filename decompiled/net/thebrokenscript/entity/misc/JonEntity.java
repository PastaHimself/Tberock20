/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.CustomGoals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002XYB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020*H\u0016J \u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*H\u0016J\u0018\u00101\u001a\u00020$2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020\nH\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010<\u001a\u00020$H\u0014J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020?H\u0014J\u0018\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020*H\u0016J\u0010\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0016J4\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\u0005\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010K2\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020$H\u0016J\b\u0010U\u001a\u00020$H\u0016J\u0010\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u00020BH\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006Z"}, d2={"Lnet/thebrokenscript/entity/misc/JonEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "saidHello", "getSaidHello", "()Z", "setSaidHello", "(Z)V", "saidHello$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "timesChatted", "getTimesChatted", "()I", "setTimesChatted", "(I)V", "timesChatted$delegate", "dying", "getDying", "setDying", "dying$delegate", "lastChat", "", "getLastChat", "()J", "setLastChat", "(J)V", "move", "", "Lnet/minecraft/world/entity/MoverType;", "pos", "Lnet/minecraft/world/phys/Vec3;", "setYBodyRot", "offset", "", "setYHeadRot", "rotation", "setYRot", "yRot", "setXRot", "xRot", "lookAt", "entity", "Lnet/minecraft/world/entity/Entity;", "maxYRotIncrease", "maxXRotIncrease", "anchor", "Lnet/minecraft/commands/arguments/EntityAnchorArgument$Anchor;", "target", "isAlive", "createNavigation", "Lnet/thebrokenscript/entity/misc/JonEntity$JonNav;", "registerGoals", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "removeWhenFarAway", "distanceToClosestPlayer", "", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tick", "kill", "die", "damageSource", "Companion", "JonNav", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nJonEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JonEntity.kt\nnet/thebrokenscript/entity/misc/JonEntity\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,217:1\n15#2:218\n51#2:219\n29#2:220\n24#2:221\n51#2:222\n29#2:223\n24#2:224\n*S KotlinDebug\n*F\n+ 1 JonEntity.kt\nnet/thebrokenscript/entity/misc/JonEntity\n*L\n39#1:218\n145#1:219\n145#1:220\n145#1:221\n190#1:222\n190#1:223\n190#1:224\n*E\n"})
public final class JonEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate saidHello$delegate;
    @NotNull
    private final EntityDataDelegate timesChatted$delegate;
    @NotNull
    private final EntityDataDelegate dying$delegate;
    private long lastChat;
    private static final EntityDataAccessor<Boolean> SAID_HELLO;
    private static final EntityDataAccessor<Integer> TIMES_CHATTED;
    private static final EntityDataAccessor<Boolean> DYING;
    public static final int CHAT_DELAY = 40;

    public JonEntity(@NotNull EntityType<JonEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        EntityDataAccessor<Boolean> entityDataAccessor = SAID_HELLO;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"SAID_HELLO");
        this.saidHello$delegate = this.entityData(entityDataAccessor);
        EntityDataAccessor<Integer> entityDataAccessor2 = TIMES_CHATTED;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor2, (String)"TIMES_CHATTED");
        this.timesChatted$delegate = this.entityData(entityDataAccessor2);
        EntityDataAccessor<Boolean> entityDataAccessor3 = DYING;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor3, (String)"DYING");
        this.dying$delegate = this.entityData(entityDataAccessor3);
        String $this$c$iv = "jon";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        this.setCustomName(component);
        this.setCustomNameVisible(true);
    }

    public final boolean getSaidHello() {
        Object object = this.saidHello$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setSaidHello(boolean bl) {
        this.saidHello$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getTimesChatted() {
        Object object = this.timesChatted$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return ((Number)object).intValue();
    }

    public final void setTimesChatted(int n) {
        this.timesChatted$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getDying() {
        Object object = this.dying$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setDying(boolean bl) {
        this.dying$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final long getLastChat() {
        return this.lastChat;
    }

    public final void setLastChat(long l) {
        this.lastChat = l;
    }

    public void move(@NotNull MoverType type, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (this.getDying()) {
            return;
        }
        super.move(type, pos);
    }

    public void setYBodyRot(float offset) {
        if (this.getDying()) {
            return;
        }
        super.setYBodyRot(offset);
    }

    public void setYHeadRot(float rotation) {
        if (this.getDying()) {
            return;
        }
        super.setYHeadRot(rotation);
    }

    public void setYRot(float yRot) {
        if (((Boolean)this.entityData.get(DYING)).booleanValue()) {
            return;
        }
        super.setYRot(yRot);
    }

    public void setXRot(float xRot) {
        if (this.getDying()) {
            return;
        }
        super.setXRot(xRot);
    }

    public void lookAt(@NotNull Entity entity, float maxYRotIncrease, float maxXRotIncrease) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (this.getDying()) {
            return;
        }
        super.lookAt(entity, maxYRotIncrease, maxXRotIncrease);
    }

    public void lookAt(@NotNull EntityAnchorArgument.Anchor anchor, @NotNull Vec3 target) {
        Intrinsics.checkNotNullParameter((Object)anchor, (String)"anchor");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        if (this.getDying()) {
            return;
        }
        super.lookAt(anchor, target);
    }

    public boolean isAlive() {
        if (this.getDying()) {
            return false;
        }
        return super.isAlive();
    }

    @NotNull
    protected JonNav createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return new JonNav(this, level);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(1, (Goal)new RandomStrollGoal((PathfinderMob)this, 0.2));
        this.goalSelector.addGoal(1, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 20.0f));
        this.goalSelector.addGoal(1, (Goal)new MoveTowardsTargetGoal((PathfinderMob)this, 0.2, 20.0f));
        this.targetSelector.addGoal(1, (Goal)new CustomGoals.AlwaysTargetPlayerGoal((Mob)this, Float.valueOf(400.0f)));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(SAID_HELLO, (Object)false);
        builder.define(TIMES_CHATTED, (Object)0);
        builder.define(DYING, (Object)false);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getDying()) {
            return false;
        }
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        if (this.getHealth() - amount <= 0.0f) {
            this.die(source);
            return true;
        }
        return super.hurt(source, amount);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "jon", 0, arg_0 -> JonEntity.registerControllers$lambda$0(this, arg_0)));
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Object[] objectArray = new Object[]{"jon"};
        MutableComponent mutableComponent = Component.translatable((String)"multiplayer.player.joined", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        Component $this$yellow$iv = (Component)mutableComponent;
        boolean $i$f$getYellow = false;
        Component component = $this$yellow$iv;
        ChatFormatting other$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent2 = (MutableComponent)$this$mut$iv$iv$iv;
        if (mutableComponent2 == null) {
            MutableComponent mutableComponent3 = $this$mut$iv$iv$iv.copy();
            mutableComponent2 = mutableComponent3;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"copy(...)");
        }
        MutableComponent mutableComponent4 = mutableComponent2.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"withStyle(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent4), (boolean)false, (int)2, null);
        return null;
    }

    public void tick() {
        super.tick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (this.getDying()) {
            this.setSpeed(0.0f);
            return;
        }
        if (this.lastChat + (long)40 <= ((ServerLevel)level).getGameTime() && ((ServerLevel)level).random.nextInt(0, 5) == 3) {
            if (this.getSaidHello()) {
                LevelAccessor levelAccessor = (LevelAccessor)level;
                Object[] objectArray = new Object[]{"jon", "let's play minecraft!"};
                MutableComponent mutableComponent = Component.translatable((String)"chat.type.text", (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Holder)((Holder)TBSSounds.JON_PLAY), (float)0.0f, (float)0.0f, null, (int)28, null);
            } else {
                LevelAccessor levelAccessor = (LevelAccessor)level;
                Object[] objectArray = new Object[]{"jon", "hello!"};
                MutableComponent mutableComponent = Component.translatable((String)"chat.type.text", (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
                SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Holder)((Holder)TBSSounds.JON_HELLO), (float)0.0f, (float)0.0f, null, (int)28, null);
                if (this.getTimesChatted() > 4 && ((ServerLevel)level).random.nextBoolean()) {
                    this.setSaidHello(true);
                }
            }
            int n = this.getTimesChatted();
            this.setTimesChatted(n + 1);
            this.lastChat = ((ServerLevel)level).getGameTime();
        }
    }

    public void kill() {
        DamageSource damageSource = this.getLevel().damageSources().genericKill();
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"genericKill(...)");
        this.die(damageSource);
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        this.setDying(true);
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        LevelUtil.getQueue((Level)this.getLevel()).add(72L, () -> JonEntity.die$lambda$0(this));
    }

    private static final PlayState registerControllers$lambda$0(JonEntity this$0, AnimationState it) {
        if (this$0.getDying()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"death");
        } else if (it.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle");
        }
        return PlayState.CONTINUE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit die$lambda$0(JonEntity this$0) {
        void $this$with$iv$iv;
        LevelAccessor levelAccessor = (LevelAccessor)this$0.getLevel();
        Object[] objectArray = new Object[]{"jon"};
        MutableComponent mutableComponent = Component.translatable((String)"multiplayer.player.left", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        Component $this$yellow$iv = (Component)mutableComponent;
        boolean $i$f$getYellow = false;
        Component component = $this$yellow$iv;
        ChatFormatting other$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent2 = (MutableComponent)$this$mut$iv$iv$iv;
        if (mutableComponent2 == null) {
            MutableComponent mutableComponent3 = $this$mut$iv$iv$iv.copy();
            mutableComponent2 = mutableComponent3;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"copy(...)");
        }
        MutableComponent mutableComponent4 = mutableComponent2.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"withStyle(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent4), (boolean)false, (int)2, null);
        this$0.discard();
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(JonEntity.class, "saidHello", "getSaidHello()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(JonEntity.class, "timesChatted", "getTimesChatted()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(JonEntity.class, "dying", "getDying()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        SAID_HELLO = SynchedEntityData.defineId(JonEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        TIMES_CHATTED = SynchedEntityData.defineId(JonEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        DYING = SynchedEntityData.defineId(JonEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\t0\t \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\t0\t\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/entity/misc/JonEntity$Companion;", "", "<init>", "()V", "SAID_HELLO", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "TIMES_CHATTED", "", "DYING", "CHAT_DELAY", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/entity/misc/JonEntity$JonNav;", "Lnet/minecraft/world/entity/ai/navigation/GroundPathNavigation;", "jon", "Lnet/thebrokenscript/entity/misc/JonEntity;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/thebrokenscript/entity/misc/JonEntity;Lnet/minecraft/world/level/Level;)V", "canMoveDirectly", "", "posVec31", "Lnet/minecraft/world/phys/Vec3;", "posVec32", "moveTo", "pathentity", "Lnet/minecraft/world/level/pathfinder/Path;", "speed", "", "thebrokenscript-common"})
    public static final class JonNav
    extends GroundPathNavigation {
        @NotNull
        private final JonEntity jon;

        public JonNav(@NotNull JonEntity jon, @NotNull Level level) {
            Intrinsics.checkNotNullParameter((Object)((Object)jon), (String)"jon");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            super((Mob)jon, level);
            this.jon = jon;
        }

        protected boolean canMoveDirectly(@NotNull Vec3 posVec31, @NotNull Vec3 posVec32) {
            Intrinsics.checkNotNullParameter((Object)posVec31, (String)"posVec31");
            Intrinsics.checkNotNullParameter((Object)posVec32, (String)"posVec32");
            if (this.jon.getDying()) {
                return false;
            }
            return super.canMoveDirectly(posVec31, posVec32);
        }

        public boolean moveTo(@Nullable Path pathentity, double speed) {
            if (this.jon.getDying()) {
                return false;
            }
            return super.moveTo(pathentity, speed);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.TicketType
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fever;

import java.util.Collection;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.api.entity.ai.anomaly.sa2.RandomFlyingGoal;
import net.thebrokenscript.api.entity.ai.fever.FeverGoals;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.entity.fever.FeverEntity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/entity/fever/FeverEntity;", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "computeCanMove", "", "wingCooldown", "", "getWingCooldown", "()I", "setWingCooldown", "(I)V", "stareTicks", "brokenFreeTicks", "graceTicks", "tick", "shouldBeSaved", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFeverEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeverEntity.kt\nnet/thebrokenscript/entity/fever/FeverEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n1761#2,3:114\n*S KotlinDebug\n*F\n+ 1 FeverEntity.kt\nnet/thebrokenscript/entity/fever/FeverEntity\n*L\n32#1:114,3\n*E\n"})
public final class FeverEntity
extends BaseFeverEntity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int wingCooldown;
    private int stareTicks;
    private int brokenFreeTicks;
    private int graceTicks;
    public static final float WEEPING_ANGEL_RANGE = 125.0f;
    public static final int STARE_BREAK_FREE_TICKS = 100;
    public static final int BREAK_FREE_DURATION_TICKS = 60;
    public static final int LOOK_AWAY_GRACE_TICKS = 30;
    @NotNull
    private static final TicketType<ChunkPos> FEVER;

    public FeverEntity(@NotNull EntityType<BaseFeverEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, (Goal)new FeverGoals.FeverTargeting((Mob)this, null, 2, null));
        this.goalSelector.addGoal(1, (Goal)new FeverGoals.FlyToPlayerGoal(this, 0.8));
        this.goalSelector.addGoal(2, (Goal)new RandomFlyingGoal((Mob)this, 1.0));
        this.goalSelector.addGoal(3, (Goal)new RandomLookAroundGoal((Mob)this));
    }

    private final boolean computeCanMove() {
        boolean bl;
        block3: {
            Level level = this.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            Iterable $this$any$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Number)Float.valueOf(125.0f));
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Player it = (Player)element$iv;
                    boolean bl2 = false;
                    if (!PlayerExt.INSTANCE.isEntityInFovCone(it, (Entity)this, 75.0)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return !bl;
    }

    public final int getWingCooldown() {
        return this.wingCooldown;
    }

    public final void setWingCooldown(int n) {
        this.wingCooldown = n;
    }

    @Override
    public void tick() {
        block1: {
            super.tick();
            SideUtil.serverSide((Entity)((Entity)this), () -> FeverEntity.tick$lambda$0(this));
            SideUtil.clientSide((Entity)((Entity)this), () -> FeverEntity.tick$lambda$1(this));
            if (this.tickCount % 20 != 0 || !(this.random.nextFloat() <= 0.005f) || this.getCanMoveCached()) break block1;
            LivingEntity livingEntity = this.getTarget();
            if (livingEntity != null) {
                livingEntity.sendSystemMessage((Component)TBSLang.INSTANCE.getFEVER_RANDOM_MESSAGES().get(this.random.nextInt(TBSLang.INSTANCE.getFEVER_RANDOM_MESSAGES().size())));
            }
        }
    }

    public boolean shouldBeSaved() {
        return false;
    }

    private static final Unit tick$lambda$0(FeverEntity this$0) {
        Level level = this$0.level();
        Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
        ServerLevel serverLevel = (ServerLevel)level;
        ChunkPos chunkPos = new ChunkPos(this$0.blockPosition());
        if (this$0.tickCount % 5 == 0) {
            boolean watchedNow;
            boolean bl = watchedNow = !this$0.computeCanMove();
            if (watchedNow) {
                this$0.graceTicks = 30;
                if (this$0.brokenFreeTicks <= 0) {
                    this$0.stareTicks += 5;
                    if (this$0.stareTicks >= 100) {
                        this$0.brokenFreeTicks = 60;
                        this$0.stareTicks = 0;
                    }
                }
            } else {
                this$0.stareTicks = 0;
                if (this$0.graceTicks > 0) {
                    this$0.graceTicks -= 5;
                }
            }
            if (this$0.brokenFreeTicks > 0) {
                this$0.brokenFreeTicks -= 5;
            }
            this$0.setCanMoveCached(this$0.brokenFreeTicks > 0 || !watchedNow && this$0.graceTicks <= 0);
        }
        this$0.setRooted(!this$0.getCanMoveCached() && this$0.onGround());
        if (!this$0.getCanMoveCached()) {
            this$0.navigation.stop();
            this$0.setDeltaMovement(Vec3.ZERO);
        }
        serverLevel.getChunkSource().addRegionTicket(FEVER, chunkPos, 2, (Object)chunkPos);
        return Unit.INSTANCE;
    }

    private static final Unit tick$lambda$1(FeverEntity this$0) {
        if (this$0.wingCooldown <= 0) {
            FancyEntitySoundInstance fancyEntitySoundInstance;
            this$0.wingCooldown = 15;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.FEVER_WING.get();
            Entity entity = (Entity)this$0;
            RandomSource randomSource = this$0.level().random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancyEntitySoundInstance $this$tick_u24lambda_u241_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 1.5f, 1.0f, entity, false, randomSource);
            boolean bl = false;
            $this$tick_u24lambda_u241_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_HELL, null, (int)1, null));
            $this$tick_u24lambda_u241_u240.setAttenuation(3.0f, 32.0f, 1.5f);
            FancyEntitySoundInstance wingInstance = fancyEntitySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)wingInstance);
        } else {
            --this$0.wingCooldown;
        }
        return Unit.INSTANCE;
    }

    private static final long FEVER$lambda$0(Function1 $tmp0, Object p0) {
        return ((Number)$tmp0.invoke(p0)).longValue();
    }

    static {
        TicketType ticketType = TicketType.create((String)TBSEntities.FEVER.getRegisteredName(), Comparator.comparingLong(arg_0 -> FeverEntity.FEVER$lambda$0(Companion.FEVER.1.INSTANCE, arg_0)), (int)20);
        Intrinsics.checkNotNullExpressionValue((Object)ticketType, (String)"create(...)");
        FEVER = ticketType;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/entity/fever/FeverEntity$Companion;", "", "<init>", "()V", "WEEPING_ANGEL_RANGE", "", "STARE_BREAK_FREE_TICKS", "", "BREAK_FREE_DURATION_TICKS", "LOOK_AWAY_GRACE_TICKS", "FEVER", "Lnet/minecraft/server/level/TicketType;", "Lnet/minecraft/world/level/ChunkPos;", "getFEVER", "()Lnet/minecraft/server/level/TicketType;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TicketType<ChunkPos> getFEVER() {
            return FEVER;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


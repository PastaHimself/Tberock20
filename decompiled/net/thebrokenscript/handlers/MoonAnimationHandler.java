/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.handlers.subs.LevelTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/handlers/MoonAnimationHandler;", "", "<init>", "()V", "TICKS_PER_FRAME", "", "CRACKS_TICKS_PER_FRAME", "FRAME_COUNT", "CRACK_FRAME_COUNT", "shouldTick", "", "animationTick", "crackAnimationTick", "onLevelTick", "", "level", "Lnet/minecraft/world/level/Level;", "thebrokenscript-common"})
public final class MoonAnimationHandler {
    @NotNull
    public static final MoonAnimationHandler INSTANCE = new MoonAnimationHandler();
    private static final int TICKS_PER_FRAME = 20;
    private static final int CRACKS_TICKS_PER_FRAME = 40;
    private static final int FRAME_COUNT = 8;
    private static final int CRACK_FRAME_COUNT = 9;
    private static boolean shouldTick;
    private static int animationTick;
    private static int crackAnimationTick;

    private MoonAnimationHandler() {
    }

    private final void onLevelTick(Level level) {
        int currentFrame;
        if (!(level instanceof ServerLevel)) {
            return;
        }
        MapVariables vars = LevelExt.INSTANCE.getVars((LevelAccessor)level);
        if (!shouldTick && vars.getMoonStage() == 1 && ((ServerLevel)level).getMoonPhase() + 1 == 4 && ((ServerLevel)level).getGameTime() % (long)100 == 0L && (double)level.random.nextFloat() < 0.05) {
            shouldTick = true;
            animationTick = 0;
        }
        if (!vars.getMoonShouldCrack() && vars.getMoonStage() == 1 && ((ServerLevel)level).getMoonPhase() + 1 == 1) {
            long dayTime = ((ServerLevel)level).getDayTime() % (long)24000;
            if (dayTime >= 18000L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$0));
                crackAnimationTick = 0;
            }
            if (dayTime >= 17920L && !LevelExt.INSTANCE.getVars((LevelAccessor)level).getSoundPlayed()) {
                for (ServerPlayer player : ((ServerLevel)level).players()) {
                    Intrinsics.checkNotNull((Object)player);
                    PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)player, (SoundEvent)TBSSounds.MOON_CRACK.get(), false, 0.0f, 0.0f, 0.0f, 30, null);
                }
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$1));
            }
        }
        if (vars.getMoonStage() == 1 && ((ServerLevel)level).getMoonPhase() + 1 == 4 && shouldTick) {
            int totalAnimationTicks = 280;
            if (animationTick < totalAnimationTicks) {
                currentFrame = animationTick / 20;
                int index = currentFrame < 8 ? currentFrame : 7 - (currentFrame - 7);
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> MoonAnimationHandler.onLevelTick$lambda$2(index, arg_0)));
                int n = animationTick;
                animationTick = n + 1;
            } else {
                shouldTick = false;
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$3));
            }
        } else if (!shouldTick) {
            animationTick = 0;
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$4));
        }
        if (vars.getMoonStage() == 1 && ((ServerLevel)level).getMoonPhase() + 1 == 1 && vars.getMoonShouldCrack()) {
            int totalCrackTicks = 320;
            if (crackAnimationTick < totalCrackTicks) {
                currentFrame = crackAnimationTick / 40;
                int index = RangesKt.coerceIn((int)currentFrame, (int)0, (int)8);
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> MoonAnimationHandler.onLevelTick$lambda$5(index, arg_0)));
                int n = crackAnimationTick;
                crackAnimationTick = n + 1;
            } else {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$6));
            }
        } else if (!vars.getMoonShouldCrack() && vars.getMoonCrackIndex() == -1) {
            crackAnimationTick = 0;
        }
        if (vars.getMoonStage() == 0 && vars.getMoonShouldCrack()) {
            crackAnimationTick = 0;
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)MoonAnimationHandler::onLevelTick$lambda$7));
        }
    }

    private static final Unit onLevelTick$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonShouldCrack(true);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$1(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setSoundPlayed(true);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$2(int $index, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonTextureIndex(RangesKt.coerceIn((int)$index, (int)0, (int)7));
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$3(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonTextureIndex(-1);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$4(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonTextureIndex(-1);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$5(int $index, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonCrackIndex($index);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$6(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonCrackIndex(8);
        return Unit.INSTANCE;
    }

    private static final Unit onLevelTick$lambda$7(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonCrackIndex(-1);
        $this$updateVars.setMoonShouldCrack(false);
        $this$updateVars.setSoundPlayed(false);
        return Unit.INSTANCE;
    }

    static {
        LevelTickSubscriber.INSTANCE.add((Function1<? super Level, Unit>)((Function1)new Function1<Level, Unit>((Object)INSTANCE){

            public final void invoke(Level p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((MoonAnimationHandler)this.receiver).onLevelTick(p0);
            }
        }));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.entity.nullent.NullEndgameEntity;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/TrueEndGame;", "", "<init>", "()V", "onPlayerTick", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class TrueEndGame {
    @NotNull
    public static final TrueEndGame INSTANCE = new TrueEndGame();

    private TrueEndGame() {
    }

    private final void onPlayerTick(Player player) {
        if (!(player instanceof ServerPlayer)) {
            return;
        }
        Level level = player.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = player.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, NullEndgameEntity.class, (Vec3)vec3, (Number)400)) {
            double counter = TagExt.INSTANCE.incDouble(EntityUtil.getPersistentData((Entity)((Entity)player)), "shutdown");
            if (!EntityUtil.getPersistentData((Entity)((Entity)player)).contains("spawnedShutdownWindow")) {
                EntityUtil.getPersistentData((Entity)((Entity)player)).putBoolean("spawnedShutdownWindow", false);
            }
            if (counter > 10.0 && !EntityUtil.getPersistentData((Entity)((Entity)player)).getBoolean("spawnedShutdownWindow")) {
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
                Intrinsics.checkNotNull((Object)string);
                String string2 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_END_GAME()));
                Intrinsics.checkNotNull((Object)string2);
                PlayerUtil.tryShowAlert((Player)player, (String)string, (String)string2);
                EntityUtil.getPersistentData((Entity)((Entity)player)).putBoolean("spawnedShutdownWindow", true);
            }
            if (counter == 16.0) {
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
                Intrinsics.checkNotNull((Object)string);
                String string3 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_END_GAME()));
                Intrinsics.checkNotNull((Object)string3);
                PlayerUtil.tryShowAlert((Player)player, (String)string, (String)string3);
                if (((ServerPlayer)player).isSpectator() || ((ServerPlayer)player).isCreative()) {
                    ((ServerPlayer)player).setGameMode(GameType.SURVIVAL);
                }
                if (!BCConfigs.INSTANCE.getClient().getDisableCrashes()) {
                    PlayerUtil.tryCrash((Player)player);
                }
            }
        }
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((TrueEndGame)this.receiver).onPlayerTick(p0);
            }
        }));
    }
}


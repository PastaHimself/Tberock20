/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  net.thebrokenscript.brokencore.api.fake.FakePlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.funny;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.FunnyEvent;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.brokencore.api.fake.FakePlayer;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/funny/CollinLockEvent;", "Lnet/thebrokenscript/api/event/FunnyEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCollinLockEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollinLockEvent.kt\nnet/thebrokenscript/events/funny/CollinLockEvent\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,33:1\n51#2:34\n29#2:35\n24#2:36\n51#2:37\n29#2:38\n24#2:39\n*S KotlinDebug\n*F\n+ 1 CollinLockEvent.kt\nnet/thebrokenscript/events/funny/CollinLockEvent\n*L\n20#1:34\n20#1:35\n20#1:36\n27#1:37\n27#1:38\n27#1:39\n*E\n"})
public final class CollinLockEvent
extends FunnyEvent {
    public CollinLockEvent() {
        super(1);
    }

    /*
     * WARNING - void declaration
     */
    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_COLLINLOCK()};
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
        FakePlayer player2 = CustomPlayerManager.add((ServerLevel)level, (GameProfile)GameProfiles.COLLINLOCK16_GAME_PROFILE);
        LevelUtil.getQueue((Level)((Level)level)).add(40L, () -> CollinLockEvent.execute$lambda$0(player2, level));
    }

    private static final Unit execute$lambda$0(FakePlayer $player, ServerLevel $level) {
        ChatUtil.say((ServerPlayer)((ServerPlayer)$player), (Component)((Component)TBSLang.INSTANCE.getCOLLINLOCK_MSG()));
        LevelUtil.getQueue((Level)((Level)$level)).add(40L, () -> CollinLockEvent.execute$lambda$0$0($level));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit execute$lambda$0$0(ServerLevel $level) {
        void $this$with$iv$iv;
        LevelAccessor levelAccessor = (LevelAccessor)$level;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_COLLINLOCK()};
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
        UUID uUID = GameProfiles.COLLINLOCK16_GAME_PROFILE.getId();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getId(...)");
        CustomPlayerManager.remove((UUID)uUID);
        return Unit.INSTANCE;
    }
}


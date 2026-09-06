/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.util.FindNearbyNullStructureKt;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/responses/nullent/CalResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "delay", "", "getDelay", "()J", "caseSensitive", "", "getCaseSensitive", "()Z", "isFullMessage", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "shouldExecute", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "respond", "", "thebrokenscript-common"})
public final class CalResponse
extends ChatResponse {
    private final long delay;
    private final boolean caseSensitive;
    private final boolean isFullMessage;
    @NotNull
    private final List<String> triggers;

    public CalResponse() {
        this.delay = 100L;
        this.isFullMessage = true;
        Object[] objectArray = new String[]{"Not_It_Cal", "not it cal", "not_it_cal"};
        this.triggers = CollectionsKt.listOf((Object[])objectArray);
    }

    public long getDelay() {
        return this.delay;
    }

    public boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public boolean isFullMessage() {
        return this.isFullMessage;
    }

    @NotNull
    public List<String> getTriggers() {
        return this.triggers;
    }

    protected boolean shouldExecute(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        return super.shouldExecute(level, sender) && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere() && !FindNearbyNullStructureKt.findNearbyNullStructure$default(level, sender, 100, "aftermath", false, false, 48, null);
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        if (FindNearbyNullStructureKt.findNearbyNullStructure$default(level, sender, 0, "fate", false, true, 20, null)) {
            double angle = level.random.nextDouble() * (double)2 * Math.PI;
            double distance = 50.0 + level.random.nextDouble() * 50.0;
            EntityType entityType = (EntityType)TBSEntities.THE_BROKEN_END_AMBUSH.get();
            LevelAccessor levelAccessor = (LevelAccessor)level;
            Vec3 vec3 = sender.position().add(Math.cos(angle) * distance, 0.0, Math.sin(angle) * distance);
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
        } else {
            LevelAccessor levelAccessor = (LevelAccessor)level;
            Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL(), TBSLang.INSTANCE.getMSG_CAL()};
            MutableComponent mutableComponent = Component.translatable((String)"chat.type.text", (Object[])objectArray);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
            ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
            if (PlayerExt.INSTANCE.getReputation(sender) == ReputationEnum.BAD && (level.getGameTime() - this.getLastResponseTime() < 160L || this.getLastResponseTime() == 0L)) {
                RepUtilKt.applyRep((Player)sender, RepTier.GAIN_SMALL);
            }
        }
        super.respond(level, sender);
    }
}


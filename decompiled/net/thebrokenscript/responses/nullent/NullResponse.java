/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/responses/nullent/NullResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "delay", "", "getDelay", "()J", "caseSensitive", "", "getCaseSensitive", "()Z", "isFullMessage", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "shouldExecute", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "respond", "", "thebrokenscript-common"})
public final class NullResponse
extends ChatResponse {
    private final long delay;
    private final boolean caseSensitive;
    private final boolean isFullMessage;
    @NotNull
    private final List<String> triggers = CollectionsKt.listOf((Object)"null");

    public NullResponse() {
        this.delay = 100L;
        this.caseSensitive = true;
        this.isFullMessage = true;
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
        return super.shouldExecute(level, sender) && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere();
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
        PlayerUtil.sendSound$default((ServerPlayer)sender, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)56, null);
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL(), TBSLang.INSTANCE.getMSG_NULL_1()};
        MutableComponent mutableComponent = Component.translatable((String)"chat.type.text", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
        this.afterTicks(20L, () -> NullResponse.respond$lambda$0(sender, level, this));
    }

    private static final Unit respond$lambda$0(ServerPlayer $sender, ServerLevel $level, NullResponse this$0) {
        Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
        PlayerUtil.sendSound$default((ServerPlayer)$sender, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)56, null);
        LevelAccessor levelAccessor = (LevelAccessor)$level;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL(), TBSLang.INSTANCE.getMSG_NULL_2()};
        MutableComponent mutableComponent = Component.translatable((String)"chat.type.text", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
        this$0.afterTicks(10L, () -> NullResponse.respond$lambda$0$0($level, $sender));
        return Unit.INSTANCE;
    }

    private static final Unit respond$lambda$0$0(ServerLevel $level, ServerPlayer $sender) {
        EntityType entityType = (EntityType)TBSEntities.NULL_CHASE.get();
        LevelAccessor levelAccessor = (LevelAccessor)$level;
        Vec3 vec3 = $sender.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3));
        RepUtilKt.applyRep((Player)$sender, RepTier.LOSS_MEDIUM);
        return Unit.INSTANCE;
    }
}


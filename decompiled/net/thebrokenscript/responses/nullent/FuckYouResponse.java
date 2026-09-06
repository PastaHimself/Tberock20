/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/responses/nullent/FuckYouResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "delay", "", "getDelay", "()J", "caseSensitive", "", "getCaseSensitive", "()Z", "isFullMessage", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "shouldExecute", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "respond", "", "thebrokenscript-common"})
public final class FuckYouResponse
extends ChatResponse {
    private final long delay;
    private final boolean caseSensitive;
    private final boolean isFullMessage;
    @NotNull
    private final List<String> triggers;

    public FuckYouResponse() {
        this.delay = 100L;
        this.isFullMessage = true;
        Object[] objectArray = new String[]{"Fuck you", "Asshole", "Ass hole", "Fucker", "Piece of shit", "Asshat", "Fuck ass", "Bitch", "Bitch ass", "Ass hat"};
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
        return super.shouldExecute(level, sender) && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere() && !sender.level().dimension().equals(TBSDimensions.LIMBO);
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
            BlockPos originPos = sender.blockPosition();
            double angle = level.random.nextDouble() * (double)((float)Math.PI * 2);
            double radius = level.random.nextDouble() * 26.0;
            int x = originPos.getX() + MathKt.roundToInt((double)(Math.cos(angle) * radius));
            int z = originPos.getZ() + MathKt.roundToInt((double)(Math.sin(angle) * radius));
            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos spawnPos = new BlockPos(x, y, z);
            RepUtilKt.applyRep((Player)sender, RepTier.LOSS_MEDIUM);
            Entity entity = EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NOTHING_IS_WATCHING_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)spawnPos);
            if (entity == null) break block0;
            EntityUtil.applyRandomRotation((Entity)entity);
        }
    }
}


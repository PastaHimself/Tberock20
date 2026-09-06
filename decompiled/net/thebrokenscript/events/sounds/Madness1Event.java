/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.ReputationEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/events/sounds/Madness1Event;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "allowedReputations", "", "Lnet/thebrokenscript/util/ReputationEnum;", "getAllowedReputations", "()Ljava/util/Set;", "canExecute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "execute", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMadness1Event.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Madness1Event.kt\nnet/thebrokenscript/events/sounds/Madness1Event\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1761#2,3:43\n*S KotlinDebug\n*F\n+ 1 Madness1Event.kt\nnet/thebrokenscript/events/sounds/Madness1Event\n*L\n23#1:43,3\n*E\n"})
public final class Madness1Event
extends TBSEvent {
    @NotNull
    private final Set<ReputationEnum> allowedReputations;

    public Madness1Event() {
        super(1);
        ReputationEnum[] reputationEnumArray = new ReputationEnum[]{ReputationEnum.BAD, ReputationEnum.NORMAL};
        this.allowedReputations = SetsKt.mutableSetOf((Object[])reputationEnumArray);
    }

    @NotNull
    public final Set<ReputationEnum> getAllowedReputations() {
        return this.allowedReputations;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean canExecute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (!super.canExecute(level, player, pos)) return false;
        Iterable $this$any$iv = this.allowedReputations;
        boolean $i$f$any = false;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            return false;
        }
        Iterator iterator = $this$any$iv.iterator();
        do {
            if (!iterator.hasNext()) return false;
            Object element$iv = iterator.next();
            ReputationEnum reputation = (ReputationEnum)((Object)element$iv);
            boolean bl2 = false;
            if (reputation == PlayerExt.INSTANCE.getReputation(player)) {
                return true;
            }
            bl = false;
        } while (!bl);
        return true;
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        player.displayClientMessage((Component)TBSLang.INSTANCE.getMADNESS_MESSAGE(), true);
        PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)((Holder)TBSSounds.TEXT_MADNESS_1), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)56, null);
        BlockPos blockPos = player.level().clip(new ClipContext(player.getEyePosition(1.0f), player.getEyePosition(1.0f).add(player.getViewVector(1.0f).scale(-5.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, (Entity)player)).getBlockPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getBlockPos(...)");
        player.lookAt(EntityAnchorArgument.Anchor.EYES, PositionUtil.withY((BlockPos)blockPos, (Number)pos.y).getCenter());
    }
}


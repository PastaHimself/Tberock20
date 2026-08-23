/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.advancements.AdvancementHolder
 *  net.minecraft.advancements.AdvancementProgress
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientPacketListener
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.ClientboundDisconnectPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.RelativeMovement
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.portal.DimensionTransition
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.EnumSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ItemUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import net.thebrokenscript.brokencore.impl.registry.BCTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000`\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0012\u0010\u001e\u001a\u00020\u0014*\u00020\f2\u0006\u0010\u001f\u001a\u00020 \u001a\u0012\u0010!\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\"\u001a\u00020#\u001a\u0012\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010%\u001a\u00020&\",\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2={"effect", "", "Lnet/minecraft/world/entity/player/Player;", "fx", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/effect/MobEffect;", "duration", "", "amplifier", "ambient", "visible", "smoothTeleport", "Lnet/minecraft/server/level/ServerPlayer;", "targetPos", "Lnet/minecraft/world/phys/Vec3;", "sendTo", "dest", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "awardAdvancement", "", "location", "Lnet/minecraft/resources/ResourceLocation;", "value", "Lnet/minecraft/world/level/GameType;", "gameMode", "getGameMode", "(Lnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/level/GameType;", "setGameMode", "(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/GameType;)V", "kick", "text", "Lnet/minecraft/network/chat/Component;", "giveItem", "stack", "Lnet/minecraft/world/item/ItemStack;", "hasLineOfSightThroughTransparent", "target", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PlayerUtil")
@SourceDebugExtension(value={"SMAP\nPlayerDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerDSLKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1869#2,2:139\n*S KotlinDebug\n*F\n+ 1 PlayerDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/PlayerUtil__PlayerDSLKt\n*L\n74#1:139,2\n*E\n"})
final class PlayerUtil__PlayerDSLKt {
    public static final boolean effect(@NotNull Player $this$effect, @NotNull Holder<MobEffect> fx, int duration2, int amplifier, boolean ambient, boolean visible) {
        Intrinsics.checkNotNullParameter((Object)$this$effect, (String)"<this>");
        Intrinsics.checkNotNullParameter(fx, (String)"fx");
        return $this$effect.addEffect(new MobEffectInstance(fx, duration2, amplifier, ambient, visible));
    }

    public static /* synthetic */ boolean effect$default(Player player, Holder holder, int n, int n2, boolean bl, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 1;
        }
        if ((n3 & 4) != 0) {
            n2 = 1;
        }
        if ((n3 & 8) != 0) {
            bl = false;
        }
        if ((n3 & 0x10) != 0) {
            bl2 = false;
        }
        return PlayerUtil.effect(player, (Holder<MobEffect>)holder, n, n2, bl, bl2);
    }

    public static final boolean smoothTeleport(@NotNull ServerPlayer $this$smoothTeleport, @NotNull Vec3 targetPos) {
        Intrinsics.checkNotNullParameter((Object)$this$smoothTeleport, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)targetPos, (String)"targetPos");
        return $this$smoothTeleport.teleportTo($this$smoothTeleport.serverLevel(), targetPos.x, targetPos.y, targetPos.z, (Set)EnumSet.of((Enum)RelativeMovement.X_ROT, (Enum)RelativeMovement.Y_ROT, (Enum)RelativeMovement.X, (Enum)RelativeMovement.Y, (Enum)RelativeMovement.Z), $this$smoothTeleport.getYRot(), $this$smoothTeleport.getXRot());
    }

    public static final boolean sendTo(@NotNull Player $this$sendTo, @NotNull ResourceKey<Level> dest) {
        Intrinsics.checkNotNullParameter((Object)$this$sendTo, (String)"<this>");
        Intrinsics.checkNotNullParameter(dest, (String)"dest");
        if (!($this$sendTo instanceof ServerPlayer)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)$this$sendTo.level().dimension(), dest)) {
            return false;
        }
        if (((ServerPlayer)$this$sendTo).isChangingDimension()) {
            return false;
        }
        ServerLevel nextLevel = ((ServerPlayer)$this$sendTo).server.getLevel(dest);
        if (nextLevel != null) {
            MinecraftServer minecraftServer = ((ServerPlayer)$this$sendTo).server;
            Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"server");
            MinecraftServerExtKt.getQueue(minecraftServer).add(1L, (Function0<Unit>)((Function0)() -> PlayerUtil__PlayerDSLKt.sendTo$lambda$0$PlayerUtil__PlayerDSLKt($this$sendTo, nextLevel)));
            return true;
        }
        return false;
    }

    public static final void awardAdvancement(@NotNull Player $this$awardAdvancement, @NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter((Object)$this$awardAdvancement, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        if (!($this$awardAdvancement instanceof ServerPlayer)) {
            return;
        }
        AdvancementHolder advancementHolder = ((ServerPlayer)$this$awardAdvancement).server.getAdvancements().get(location);
        if (advancementHolder == null) {
            return;
        }
        AdvancementHolder advancement = advancementHolder;
        AdvancementProgress progress = ((ServerPlayer)$this$awardAdvancement).getAdvancements().getOrStartProgress(advancement);
        if (!progress.isDone()) {
            Iterable iterable = progress.getRemainingCriteria();
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"getRemainingCriteria(...)");
            Iterable $this$forEach$iv = iterable;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String)element$iv;
                boolean bl = false;
                ((ServerPlayer)$this$awardAdvancement).getAdvancements().award(advancement, it);
            }
        }
    }

    @Nullable
    public static final GameType getGameMode(@NotNull Player $this$gameMode) {
        Intrinsics.checkNotNullParameter((Object)$this$gameMode, (String)"<this>");
        if ($this$gameMode instanceof ServerPlayer) {
            return ((ServerPlayer)$this$gameMode).gameMode.getGameModeForPlayer();
        }
        ClientPacketListener clientPacketListener = Minecraft.getInstance().getConnection();
        Intrinsics.checkNotNull((Object)clientPacketListener);
        PlayerInfo playerInfo = clientPacketListener.getPlayerInfo($this$gameMode.getGameProfile().getId());
        return playerInfo != null ? playerInfo.getGameMode() : null;
    }

    public static final void setGameMode(@NotNull Player $this$gameMode, @Nullable GameType value) {
        Intrinsics.checkNotNullParameter((Object)$this$gameMode, (String)"<this>");
        if ($this$gameMode instanceof ServerPlayer && value != null) {
            ((ServerPlayer)$this$gameMode).setGameMode(value);
        }
    }

    public static final void kick(@NotNull ServerPlayer $this$kick, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)$this$kick, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        if ($this$kick.server.isSingleplayer()) {
            $this$kick.server.saveEverything(true, true, true);
        }
        $this$kick.connection.send((Packet)new ClientboundDisconnectPacket(text));
    }

    public static final void giveItem(@NotNull Player $this$giveItem, @NotNull ItemStack stack) {
        Intrinsics.checkNotNullParameter((Object)$this$giveItem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        if ($this$giveItem.canTakeItem(stack)) {
            $this$giveItem.addItem(stack);
        } else {
            Level level = $this$giveItem.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            LevelAccessor levelAccessor = (LevelAccessor)level;
            Vec3 vec3 = $this$giveItem.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            ItemUtil.tryDropItems$default(levelAccessor, vec3, stack, 0, 4, null);
        }
    }

    public static final boolean hasLineOfSightThroughTransparent(@NotNull Player $this$hasLineOfSightThroughTransparent, @NotNull BaseMonster target) {
        Intrinsics.checkNotNullParameter((Object)$this$hasLineOfSightThroughTransparent, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)target), (String)"target");
        Level level = $this$hasLineOfSightThroughTransparent.level();
        if (level == null) {
            return false;
        }
        Level level2 = level;
        Vec3 start = $this$hasLineOfSightThroughTransparent.getEyePosition();
        Vec3 end = target.position().add(0.0, (double)(target.getEyeHeight() / (float)2), 0.0);
        Vec3 dir = end.subtract(start);
        double distance = dir.length();
        int steps = (int)(distance * (double)10);
        if (steps == 0) {
            return true;
        }
        Vec3 stepVec = dir.scale(1.0 / (double)steps);
        Vec3 current = null;
        current = start;
        for (int i = 0; i < steps; ++i) {
            int it = i;
            boolean bl = false;
            BlockPos pos = BlockPos.containing((double)current.x, (double)current.y, (double)current.z);
            BlockState state = level2.getBlockState(pos);
            if (!state.isAir()) {
                boolean hasCollision = !state.getCollisionShape((BlockGetter)level2, pos).isEmpty();
                boolean isTransparent = state.is(BCTags.TRANSPARENT);
                if (hasCollision && !isTransparent) {
                    return false;
                }
            }
            current = current.add(stepVec);
        }
        return true;
    }

    private static final Unit sendTo$lambda$0$PlayerUtil__PlayerDSLKt(Player $this_sendTo, ServerLevel $nextLevel) {
        ((ServerPlayer)$this_sendTo).changeDimension(new DimensionTransition($nextLevel, $this_sendTo.position(), ((ServerPlayer)$this_sendTo).getDeltaMovement(), ((ServerPlayer)$this_sendTo).getYRot(), ((ServerPlayer)$this_sendTo).getXRot(), DimensionTransition.PLACE_PORTAL_TICKET));
        return Unit.INSTANCE;
    }
}


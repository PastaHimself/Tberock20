/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDay
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.block.CorruptedCommandBlockConfirmPayload;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDay;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/CorruptedCommandBlockConfirmPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/block/CorruptedCommandBlockConfirmPayload;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCorruptedCommandBlockConfirmPacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CorruptedCommandBlockConfirmPacket.kt\nnet/thebrokenscript/network/CorruptedCommandBlockConfirmPacket\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,81:1\n44#2:82\n29#2:83\n24#2:84\n*S KotlinDebug\n*F\n+ 1 CorruptedCommandBlockConfirmPacket.kt\nnet/thebrokenscript/network/CorruptedCommandBlockConfirmPacket\n*L\n39#1:82\n39#1:83\n39#1:84\n*E\n"})
public final class CorruptedCommandBlockConfirmPacket
extends EndecPacket<CorruptedCommandBlockConfirmPacket, CorruptedCommandBlockConfirmPayload> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("corrupted_command_block_confirm");

    public CorruptedCommandBlockConfirmPacket() {
        super((Endec)CorruptedCommandBlockConfirmPayload.Companion.getENDEC());
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull CorruptedCommandBlockConfirmPayload data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        cx.getEnqueueWork().invoke(() -> CorruptedCommandBlockConfirmPacket.handle$lambda$0(cx, data));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final void handle$lambda$0(PacketHandlerContext $cx, CorruptedCommandBlockConfirmPayload $data) {
        boolean bl;
        boolean bl2;
        void $this$with$iv$iv;
        Player player = $cx.getPlayer();
        if (!(player instanceof ServerPlayer)) {
            return;
        }
        ServerLevel level = ((ServerPlayer)player).serverLevel();
        if (Arena.instance != null) {
            Arena arena = Arena.instance;
            Intrinsics.checkNotNull((Object)arena);
            if (!arena.checkLivingPlayers()) {
                Arena arena2 = Arena.instance;
                if (arena2 == null) return;
                arena2.restartPhase();
                return;
            }
        }
        Intrinsics.checkNotNull((Object)level);
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Object[] objectArray = new Object[]{"Integrity"};
        MutableComponent mutableComponent = Component.translatable((String)"commands.deop.success", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        Component $this$gray$iv = (Component)mutableComponent;
        boolean $i$f$getGray = false;
        Component component = $this$gray$iv;
        ChatFormatting other$iv$iv = ChatFormatting.GRAY;
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
        int xOffset = 0;
        int zOffset = 0;
        do {
            if (-10 <= (xOffset = level.random.nextInt(-20, 20))) {
                if (xOffset < 11) {
                    bl2 = true;
                    continue;
                }
                bl2 = false;
                continue;
            }
            bl2 = false;
        } while (bl2);
        do {
            if (-10 <= (zOffset = level.random.nextInt(-20, 20))) {
                if (zOffset < 11) {
                    bl = true;
                    continue;
                }
                bl = false;
                continue;
            }
            bl = false;
        } while (bl);
        MinecraftServer srv = ((ServerPlayer)player).server;
        int x = $data.getPosition().getX() + xOffset;
        int z = $data.getPosition().getZ() + zOffset;
        int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
        BlockPos center = new BlockPos(x, y, z);
        Vec3 vec3 = center.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        List players = CollectionsKt.toMutableList((Collection)EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)vec3, (Number)150));
        Arena arena = Arena.instance;
        if (arena != null) {
            arena.reset();
        }
        Arena.instance = new Arena(center, level, players);
        Intrinsics.checkNotNull((Object)srv);
        MinecraftServerExtKt.getQueue((MinecraftServer)srv).add(40L, () -> CorruptedCommandBlockConfirmPacket.handle$lambda$0$0(players, srv));
    }

    private static final Unit handle$lambda$0$0(List $players, MinecraftServer $srv) {
        FakeTimeOfDay.INSTANCE.set(TimeOfDay.MIDNIGHT);
        for (ServerPlayer player : $players) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)CorruptedCommandBlockConfirmPacket::handle$lambda$0$0$0));
        }
        Intrinsics.checkNotNull((Object)$srv);
        MinecraftServerExtKt.getQueue((MinecraftServer)$srv).add(60L, CorruptedCommandBlockConfirmPacket::handle$lambda$0$0$1);
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$0$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEnableCustomSky(true);
        $this$updateVars.setCustomSkyColor(new Vec3(70.0, 0.0, 0.0));
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$0$0$1() {
        block0: {
            Arena arena = Arena.instance;
            if (arena == null) break block0;
            arena.start();
        }
        return Unit.INSTANCE;
    }
}


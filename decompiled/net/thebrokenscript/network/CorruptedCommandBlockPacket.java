/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.block.CorruptedCommandBlockPayload;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSMenus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/CorruptedCommandBlockPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/block/CorruptedCommandBlockPayload;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCorruptedCommandBlockPacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CorruptedCommandBlockPacket.kt\nnet/thebrokenscript/network/CorruptedCommandBlockPacket\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,48:1\n72#2:49\n15#2:50\n49#2:51\n29#2:52\n24#2:53\n72#2:54\n15#2:55\n49#2:56\n29#2:57\n24#2:58\n15#2:59\n*S KotlinDebug\n*F\n+ 1 CorruptedCommandBlockPacket.kt\nnet/thebrokenscript/network/CorruptedCommandBlockPacket\n*L\n33#1:49\n33#1:50\n33#1:51\n33#1:52\n33#1:53\n35#1:54\n35#1:55\n35#1:56\n35#1:57\n35#1:58\n40#1:59\n*E\n"})
public final class CorruptedCommandBlockPacket
extends EndecPacket<CorruptedCommandBlockPacket, CorruptedCommandBlockPayload> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("corrupted_command_block");

    public CorruptedCommandBlockPacket() {
        super((Endec)CorruptedCommandBlockPayload.Companion.getENDEC());
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull CorruptedCommandBlockPayload data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        cx.getEnqueueWork().invoke(() -> CorruptedCommandBlockPacket.handle$lambda$0(cx, data));
    }

    /*
     * WARNING - void declaration
     */
    private static final void handle$lambda$0(PacketHandlerContext $cx, CorruptedCommandBlockPayload $data) {
        Player player = $cx.getPlayer();
        if (!(player instanceof ServerPlayer)) {
            return;
        }
        ServerLevel level = ((ServerPlayer)player).serverLevel();
        String string = $data.getCommand();
        Intrinsics.checkNotNull((Object)level);
        if (Intrinsics.areEqual((Object)string, (Object)LevelExt.INSTANCE.getVars((LevelAccessor)level).getCode())) {
            if (!Intrinsics.areEqual((Object)level.dimension(), (Object)Level.OVERWORLD)) {
                void $this$with$iv$iv$iv;
                void $this$red$iv$iv;
                LevelAccessor levelAccessor = (LevelAccessor)level;
                String $this$red$iv = "[error] invalid dimension: expected ResourceKey#<minecraft:overworld>";
                boolean $i$f$getRed = false;
                String $this$c$iv$iv = $this$red$iv;
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv$iv = component;
                boolean $i$f$getRed2 = false;
                void var8_14 = $this$red$iv$iv;
                ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
                    mutableComponent = mutableComponent2;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
                }
                MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
                v6 = ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent3), (boolean)false, (int)2, null);
            } else if (!level.getBlockState($data.getPosition().below()).is((Holder)TBSBlocks.INITIATOR)) {
                void $this$red$iv$iv;
                LevelAccessor levelAccessor = (LevelAccessor)level;
                String $this$red$iv = "[error] invalid position: initiator must be present below command block";
                boolean $i$f$getRed = false;
                String $this$c$iv$iv = $this$red$iv;
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv$iv = component;
                boolean $i$f$getRed3 = false;
                void $this$with$iv$iv$iv = $this$red$iv$iv;
                ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent4 = $this$mut$iv$iv$iv$iv.copy();
                    mutableComponent = mutableComponent4;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"copy(...)");
                }
                MutableComponent mutableComponent5 = mutableComponent.withStyle(other$iv$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"withStyle(...)");
                v6 = ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent5), (boolean)false, (int)2, null);
            } else {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)CorruptedCommandBlockPacket::handle$lambda$0$0));
                ((ServerPlayer)player).closeContainer();
                ServerPlayer serverPlayer = (ServerPlayer)player;
                String $this$c$iv = "";
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                TBSMenus.COMMAND_CONFIRM_GUI.open(serverPlayer, component);
                v6 = Unit.INSTANCE;
            }
        }
    }

    private static final Unit handle$lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCodeApplied(true);
        return Unit.INSTANCE;
    }
}


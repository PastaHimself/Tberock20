/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.Position
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006JH\u0010\b\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2+\b\u0004\u0010\u000b\u001a%\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\u0002\b\u0010H\u0082\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/command/dev/SetCommands;", "", "<init>", "()V", "addSetCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "playerVar", "name", "", "mutation", "Lkotlin/Function3;", "Lnet/thebrokenscript/data/PlayerVariables;", "Lcom/mojang/brigadier/context/CommandContext;", "Lnet/minecraft/server/level/ServerPlayer;", "Lkotlin/ExtensionFunctionType;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSetCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetCommands.kt\nnet/thebrokenscript/command/dev/SetCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,97:1\n78#1:98\n95#1:99\n51#2:100\n29#2:101\n24#2:102\n51#2:103\n29#2:104\n24#2:105\n*S KotlinDebug\n*F\n+ 1 SetCommands.kt\nnet/thebrokenscript/command/dev/SetCommands\n*L\n23#1:98\n23#1:99\n50#1:100\n50#1:101\n50#1:102\n66#1:103\n66#1:104\n66#1:105\n*E\n"})
public final class SetCommands {
    @NotNull
    public static final SetCommands INSTANCE = new SetCommands();

    private SetCommands() {
    }

    public final void addSetCommands(@NotNull CommandDSL<CommandSourceStack> $this$addSetCommands) {
        Intrinsics.checkNotNullParameter($this$addSetCommands, (String)"<this>");
        $this$addSetCommands.group("set", SetCommands::addSetCommands$lambda$0);
    }

    private final void playerVar(CommandDSL<CommandSourceStack> $this$playerVar, String name, Function3<? super PlayerVariables, ? super CommandContext<CommandSourceStack>, ? super ServerPlayer, Unit> mutation) {
        boolean $i$f$playerVar = false;
        $this$playerVar.add(name, (Function1)new Function1<CommandContext<CommandSourceStack>, Integer>(mutation){
            final /* synthetic */ Function3<PlayerVariables, CommandContext<CommandSourceStack>, ServerPlayer, Unit> $mutation;
            {
                this.$mutation = $mutation;
            }

            public final Integer invoke(CommandContext<CommandSourceStack> it) {
                Intrinsics.checkNotNullParameter(it, (String)"it");
                ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
                if (player == null) {
                    CommandCxUtil.fail$default(it, (Component)((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER()), (boolean)false, (int)2, null);
                    return -1;
                }
                PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
                this.$mutation.invoke((Object)vars, it, (Object)player);
                vars.syncTo((Player)player);
                CommandCxUtil.success$default(it, (Component)((Component)TBSLang.INSTANCE.getCMD_SET_SUCCESS()), (boolean)false, (int)2, null);
                return 0;
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    private static final void addSetCommands$lambda$0(CommandDSL $this$group) {
        void $this$playerVar$iv;
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = INSTANCE;
        CommandDSL commandDSL = $this$group;
        String name$iv = "spawn";
        boolean $i$f$playerVar = false;
        $this$playerVar$iv.add(name$iv, (Function1)new Function1<CommandContext<CommandSourceStack>, Integer>(){

            /*
             * WARNING - void declaration
             */
            public final Integer invoke(CommandContext<CommandSourceStack> it) {
                void cx;
                Intrinsics.checkNotNullParameter(it, (String)"it");
                ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
                if (player == null) {
                    CommandCxUtil.fail$default(it, (Component)((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER()), (boolean)false, (int)2, null);
                    return -1;
                }
                PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
                CommandContext<CommandSourceStack> commandContext = it;
                PlayerVariables $this$addSetCommands_u24lambda_u240_u240 = vars;
                boolean bl = false;
                BlockPos blockPos = BlockPos.containing((Position)((Position)((CommandSourceStack)cx.getSource()).getPosition()));
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
                $this$addSetCommands_u24lambda_u240_u240.setSpawnPos(blockPos);
                vars.syncTo((Player)player);
                CommandCxUtil.success$default(it, (Component)((Component)TBSLang.INSTANCE.getCMD_SET_SUCCESS()), (boolean)false, (int)2, null);
                return 0;
            }
        });
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer((int)0, (int)2), (String)"integer(...)");
        $this$group.add("moon_phase [value]", argumentTypeArray, SetCommands::addSetCommands$lambda$0$1);
        $this$group.group("null", SetCommands::addSetCommands$lambda$0$2);
    }

    private static final int addSetCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> SetCommands.addSetCommands$lambda$0$1$0(it, arg_0)));
        CommandCxUtil.success$default((CommandContext)it, (Component)((Component)TBSLang.INSTANCE.getCMD_SET_SUCCESS()), (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addSetCommands$lambda$0$1$0(CommandContext $it, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonStage(IntegerArgumentType.getInteger((CommandContext)$it, (String)"value"));
        return Unit.INSTANCE;
    }

    private static final void addSetCommands$lambda$0$2(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("joined", SetCommands::addSetCommands$lambda$0$2$0);
        $this$group.add("gone", SetCommands::addSetCommands$lambda$0$2$1);
    }

    /*
     * WARNING - void declaration
     */
    private static final int addSetCommands$lambda$0$2$0(CommandContext it) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)SetCommands::addSetCommands$lambda$0$2$0$0));
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        CustomPlayerManager.add((ServerLevel)serverLevel2, (GameProfile)GameProfiles.NULL_GAME_PROFILE);
        ServerLevel serverLevel3 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel3, (String)"getLevel(...)");
        PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)serverLevel3), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
        ServerLevel serverLevel4 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel4, (String)"getLevel(...)");
        LevelAccessor levelAccessor = (LevelAccessor)serverLevel4;
        Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
        SoundUtil.tryBroadcastSound$default((LevelAccessor)levelAccessor, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, (int)8, null);
        ServerLevel serverLevel5 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel5, (String)"getLevel(...)");
        LevelAccessor levelAccessor2 = (LevelAccessor)serverLevel5;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL()};
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
        ChatUtil.chat$default((LevelAccessor)levelAccessor2, (Component)((Component)mutableComponent4), (boolean)false, (int)2, null);
        CommandCxUtil.success$default((CommandContext)it, (Component)((Component)TBSLang.INSTANCE.getCMD_SET_SUCCESS()), (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addSetCommands$lambda$0$2$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFirstJoinTimer(0L);
        $this$updateVars.setFirstJoin(false);
        $this$updateVars.setNullHere(true);
        $this$updateVars.setScheduled(true);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final int addSetCommands$lambda$0$2$1(CommandContext it) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)SetCommands::addSetCommands$lambda$0$2$1$0));
        UUID uUID = GameProfiles.NULL_GAME_PROFILE.getId();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getId(...)");
        CustomPlayerManager.remove((UUID)uUID);
        ServerLevel serverLevel2 = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
        LevelAccessor levelAccessor = (LevelAccessor)serverLevel2;
        Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL()};
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
        CommandCxUtil.success$default((CommandContext)it, (Component)((Component)TBSLang.INSTANCE.getCMD_SET_SUCCESS()), (boolean)false, (int)2, null);
        return 0;
    }

    private static final Unit addSetCommands$lambda$0$2$1$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFirstJoinTimer(0L);
        $this$updateVars.setHasNullSpawned(false);
        $this$updateVars.setNullHere(false);
        $this$updateVars.setScheduled(false);
        return Unit.INSTANCE;
    }
}


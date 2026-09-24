/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.LongArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.arguments.coordinates.BlockPosArgument
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.CommandCxUtil
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.boss.integrity.TerrainCorrupterKt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.CommandCxUtil;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.util.SeedSwapper;
import net.thebrokenscript.world.chunk.ChunkCarver;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\u0004"}, d2={"addWorldCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nWorldCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorldCommands.kt\nnet/thebrokenscript/command/dev/WorldCommandsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,74:1\n295#2,2:75\n*S KotlinDebug\n*F\n+ 1 WorldCommands.kt\nnet/thebrokenscript/command/dev/WorldCommandsKt\n*L\n50#1:75,2\n*E\n"})
public final class WorldCommandsKt {
    public static final void addWorldCommands(@NotNull CommandDSL<CommandSourceStack> $this$addWorldCommands) {
        Intrinsics.checkNotNullParameter($this$addWorldCommands, (String)"<this>");
        $this$addWorldCommands.group("world", WorldCommandsKt::addWorldCommands$lambda$0);
    }

    private static final void addWorldCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("resetSeed", WorldCommandsKt::addWorldCommands$lambda$0$0);
        $this$group.add("carve", WorldCommandsKt::addWorldCommands$lambda$0$1);
        ArgumentType[] argumentTypeArray = new ArgumentType[2];
        Intrinsics.checkNotNullExpressionValue((Object)BlockPosArgument.blockPos(), (String)"blockPos(...)");
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("corrupt [pos] [radius]", argumentTypeArray, WorldCommandsKt::addWorldCommands$lambda$0$2);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)StringArgumentType.word(), (String)"word(...)");
        $this$group.add("var [name]", argumentTypeArray, WorldCommandsKt::addWorldCommands$lambda$0$3);
        if (!PlatformUtil.Companion.isProduction()) {
            argumentTypeArray = new ArgumentType[1];
            Intrinsics.checkNotNullExpressionValue((Object)LongArgumentType.longArg(), (String)"longArg(...)");
            $this$group.add("gametime [tick]", argumentTypeArray, WorldCommandsKt::addWorldCommands$lambda$0$4);
        }
    }

    private static final int addWorldCommands$lambda$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        SeedSwapper.swapSeed(serverLevel, ((CommandSourceStack)it.getSource()).getLevel().random.nextLong());
        return 0;
    }

    private static final int addWorldCommands$lambda$0$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ChunkPos pos = new ChunkPos(BlockPos.containing((Position)((Position)((CommandSourceStack)it.getSource()).getPosition())));
        CommandCxUtil.success$default((CommandContext)it, (String)("Carving hole at [" + pos.x + ", " + pos.z + "]..."), (boolean)false, (int)2, null);
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        Vec3 vec3 = ((CommandSourceStack)it.getSource()).getPosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getPosition(...)");
        ChunkCarver.start$default(ChunkCarver.INSTANCE, serverLevel, (Position)vec3, null, 4, null);
        return 0;
    }

    private static final int addWorldCommands$lambda$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        BlockPos pos = BlockPosArgument.getBlockPos((CommandContext)it, (String)"pos");
        int radius = IntegerArgumentType.getInteger((CommandContext)it, (String)"radius");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        Level level = (Level)serverLevel;
        Intrinsics.checkNotNull((Object)pos);
        TerrainCorrupterKt.corruptTerrain$default(level, pos, radius, 0.0f, 4, null);
        CommandCxUtil.success$default((String)"Successfully corrupted terrain!", (CommandContext)it, (boolean)false, (int)2, null);
        return 0;
    }

    private static final int addWorldCommands$lambda$0$3(CommandContext it) {
        Object value;
        Object object;
        Object v0;
        MapVariables vars;
        String worldVarName;
        block5: {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            ServerLevel level = ((CommandSourceStack)it.getSource()).getLevel();
            worldVarName = StringArgumentType.getString((CommandContext)it, (String)"name");
            Intrinsics.checkNotNull((Object)level);
            vars = LevelExt.INSTANCE.getVars((LevelAccessor)level);
            boolean bl = false;
            Iterable $this$firstOrNull$iv = Reflection.getOrCreateKotlinClass(((Object)((Object)vars)).getClass()).getMembers();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KCallable it2 = (KCallable)element$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual((Object)it2.getName(), (Object)worldVarName)) continue;
                v0 = element$iv;
                break block5;
            }
            v0 = null;
        }
        KCallable kCallable = v0;
        if (kCallable != null) {
            Object[] objectArray = new Object[]{vars};
            object = kCallable.call(objectArray);
        } else {
            object = null;
        }
        if ((value = object) != null) {
            CommandCxUtil.success$default((String)("The value of " + worldVarName + " is " + value), (CommandContext)it, (boolean)false, (int)2, null);
        } else {
            CommandCxUtil.fail$default((String)("worldVar '" + worldVarName + "' does not exist. Maybe check the code for the correct var name?"), (CommandContext)it, (boolean)false, (int)2, null);
        }
        return 0;
    }

    private static final int addWorldCommands$lambda$0$4(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        long tick = LongArgumentType.getLong((CommandContext)it, (String)"tick");
        ((CommandSourceStack)it.getSource()).getLevel().serverLevelData.setGameTime(tick);
        return 0;
    }
}


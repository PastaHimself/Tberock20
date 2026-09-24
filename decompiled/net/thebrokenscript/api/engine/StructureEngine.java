/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ArrayUtil
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ArrayUtil;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.structure.StructurePlaceHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/api/engine/StructureEngine;", "", "<init>", "()V", "random", "Lnet/minecraft/util/RandomSource;", "EXEC_TIME", "", "MIN_PLAYER_DISTANCE", "", "rule", "", "level", "Lnet/minecraft/world/level/Level;", "structures", "", "", "placed", "tick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStructureEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructureEngine.kt\nnet/thebrokenscript/api/engine/StructureEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,153:1\n1869#2:154\n1761#2,3:155\n1870#2:159\n15#3:158\n*S KotlinDebug\n*F\n+ 1 StructureEngine.kt\nnet/thebrokenscript/api/engine/StructureEngine\n*L\n135#1:154\n139#1:155,3\n135#1:159\n146#1:158\n*E\n"})
public final class StructureEngine {
    @NotNull
    public static final StructureEngine INSTANCE = new StructureEngine();
    @NotNull
    private static final RandomSource random;
    private static final long EXEC_TIME = 6000L;
    private static final double MIN_PLAYER_DISTANCE = 80.0;
    @NotNull
    private static final List<String> structures;
    private static boolean placed;

    private StructureEngine() {
    }

    private final boolean rule(Level level) {
        if (!Intrinsics.areEqual((Object)level.dimension(), (Object)Level.OVERWORLD)) {
            return false;
        }
        if (level.getGameTime() % 6000L != 0L) {
            return false;
        }
        if (placed) {
            return false;
        }
        return level.getDayTime() / (long)24000 % (long)2 == 0L;
    }

    public final void tick(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        if (TBSConfigs.INSTANCE.getServer().getWorld().getDisableRandomStructures()) {
            return;
        }
        if (server.getPlayerList().getPlayerCount() <= 0) {
            return;
        }
        List players = server.getPlayerList().getPlayers();
        ServerLevel serverLevel = server.getLevel(Level.OVERWORLD);
        if (serverLevel == null) {
            return;
        }
        ServerLevel overworld = serverLevel;
        if (overworld.getGameTime() % 6000L != 0L) {
            placed = false;
            return;
        }
        if (this.rule((Level)overworld)) {
            placed = true;
            double minDistanceSq = 6400.0;
            List handled = new ArrayList();
            Intrinsics.checkNotNull((Object)players);
            Iterable $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                boolean nearHandled;
                boolean bl;
                ServerPlayer player;
                block10: {
                    player = (ServerPlayer)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)player.serverLevel().dimension(), (Object)Level.OVERWORLD) || player.serverLevel().getDayTime() / (long)24000 <= 0L) continue;
                    Iterable $this$any$iv = handled;
                    boolean $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl = false;
                    } else {
                        for (Object element$iv2 : $this$any$iv) {
                            ServerPlayer it = (ServerPlayer)element$iv2;
                            boolean bl3 = false;
                            if (!(Intrinsics.areEqual((Object)it.serverLevel(), (Object)player.serverLevel()) && it.position().distanceToSqr(player.position()) < minDistanceSq)) continue;
                            bl = true;
                            break block10;
                        }
                        bl = false;
                    }
                }
                if (nearHandled = bl) continue;
                ServerLevel level = player.serverLevel();
                Collection collection = structures;
                RandomSource randomSource = level.random;
                Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                String structureId = (String)ArrayUtil.random((Collection)collection, (RandomSource)randomSource);
                if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
                    String $this$c$iv = "Attempting to place structure near you: " + structureId;
                    boolean $i$f$getC = false;
                    Component component = Component.nullToEmpty((String)$this$c$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                    player.sendSystemMessage(component);
                }
                Intrinsics.checkNotNull((Object)level);
                Intrinsics.checkNotNull((Object)player);
                Vec3 vec3 = player.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                StructurePlaceHandler.INSTANCE.place(level, player, vec3, structureId);
                handled.add(player);
            }
        }
    }

    static {
        RandomSource randomSource = RandomSource.create();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"create(...)");
        random = randomSource;
        Object[] objectArray = new String[]{"thedoor", "gorestructure", "bench", "structure1", "sign5", "sign4", "sign3", "sign2", "sign1", "sandpillar", "house3", "house2", "house1", "flower", "mall", "generationbug1", "dirtpillar", "cross", "cobledpillar", "notexturehouse", "2bedrocks", random.nextBoolean() ? "gift" : "glasspillar", random.nextBoolean() ? "stoneaslym" : "smallfractal", random.nextBoolean() ? "redstoneconstruct" : "sandcube", random.nextBoolean() ? "magmacross" : "treewithnoleaves", "treetop", "fractal3", "fractal4", "trap1", "trap2", "lavapool", "giift", "totem", "crossfly", "magmacross", "portal1", "listen", "carcas", "lamppost", random.nextBoolean() ? "clanbuildoverhaul" : "cavebase_overhaul", "crosses", "signabomination", "heavenportal", "doortrap", "trap", "float", "randombrickstructure", "randomwoodstructure", "signnicehouses", "glassfractal", "burn_fractal", "warning", "skylight", "skycorpse", "skyerror", "markermarker", "shrapnel", "errorglob", "you", "afriendlost", "steal", "zoombies", "spawner", "sealight", "unfinished", "hanginglight", "waterchute", "pileofrocks", "assortment", "dirt_home", "slightlywrongtree", "randomwoodstructuree", "missing_pillar", "base_foundation", "11", "setup", "tall_tree", "weird_structure", "overworld_web", "overworld_enter", "overworld_open", random.nextBoolean() ? "torch" : "redstone_torch"};
        structures = CollectionsKt.listOf((Object[])objectArray);
    }
}


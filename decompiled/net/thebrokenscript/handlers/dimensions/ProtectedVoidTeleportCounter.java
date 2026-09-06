/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.block.Blocks
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions;

import java.lang.invoke.LambdaMetafactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerTeleportationSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ProtectedVoidTeleportCounter;", "", "<init>", "()V", "yPosMap", "", "", "getYPosMap", "()Ljava/util/Map;", "counter", "", "player", "Lnet/minecraft/world/entity/player/Player;", "face", "Lnet/minecraft/core/Direction;", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nProtectedVoidTeleportCounter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtectedVoidTeleportCounter.kt\nnet/thebrokenscript/handlers/dimensions/ProtectedVoidTeleportCounter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1869#2,2:80\n*S KotlinDebug\n*F\n+ 1 ProtectedVoidTeleportCounter.kt\nnet/thebrokenscript/handlers/dimensions/ProtectedVoidTeleportCounter\n*L\n58#1:80,2\n*E\n"})
public final class ProtectedVoidTeleportCounter {
    @NotNull
    public static final ProtectedVoidTeleportCounter INSTANCE = new ProtectedVoidTeleportCounter();
    @NotNull
    private static final Map<Integer, Integer> yPosMap;

    private ProtectedVoidTeleportCounter() {
    }

    @NotNull
    public final Map<Integer, Integer> getYPosMap() {
        return yPosMap;
    }

    /*
     * Unable to fully structure code
     */
    public final void counter(@NotNull Player player, @NotNull Direction face, @NotNull CancelProxy cancelProxy) {
        block11: {
            block12: {
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)face, (String)"face");
                Intrinsics.checkNotNullParameter((Object)cancelProxy, (String)"cancelProxy");
                if (!(player instanceof ServerPlayer)) break block11;
                if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.PROTECTED_VOID)) {
                    return;
                }
                chunk = player.chunkPosition().getWorldPosition();
                playerPos = player.blockPosition();
                minX = chunk.getX() + 10;
                maxX = chunk.getX() + 12;
                minY = 79;
                maxY = 107;
                minZ = chunk.getZ() + 1;
                maxZ = chunk.getZ() + 3;
                var13_12 = playerPos.getX();
                v0 = minX <= var13_12 ? var13_12 <= maxX : false;
                if (!v0) break block12;
                var13_12 = playerPos.getY();
                v1 = minY <= var13_12 ? var13_12 <= maxY : false;
                if (!v1) break block12;
                var13_12 = playerPos.getZ();
                if (minZ <= var13_12 ? var13_12 <= maxZ : false) ** GOTO lbl-1000
            }
            if (playerPos.getY() > 102) lbl-1000:
            // 2 sources

            {
                v2 = true;
            } else {
                v2 = isInRestrictedArea = false;
            }
            if (!isInRestrictedArea) {
                PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, counter$lambda$0(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
                tpCount = PlayerExt.INSTANCE.getVars(player).getTeleportCounter();
                if (tpCount == 3) {
                    PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, counter$lambda$1(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
                    $this$forEach$iv = (Iterable)new IntRange(0, 5);
                    $i$f$forEach = false;
                    var16_16 = $this$forEach$iv.iterator();
                    while (var16_16.hasNext()) {
                        i = element$iv = ((IntIterator)var16_16).nextInt();
                        $i$a$-forEach-ProtectedVoidTeleportCounter$counter$3 = false;
                        v3 = ProtectedVoidTeleportCounter.yPosMap.get(i);
                        if (v3 != null) {
                            yPos = ((Number)v3).intValue();
                            $i$a$-let-ProtectedVoidTeleportCounter$counter$3$1 = false;
                            switch (yPos) {
                                case 79: 
                                case 80: {
                                    ((ServerPlayer)player).serverLevel().setBlock(chunk.offset(11, yPos, 2), TBSBlocks.PROTECTED_VOID.getDefaultState(), 3);
                                    ((ServerPlayer)player).serverLevel().setBlock(chunk.offset(11, yPos, 3), TBSBlocks.PROTECTED_VOID.getDefaultState(), 3);
                                    v4 = ((ServerPlayer)player).serverLevel().setBlock(chunk.offset(11, yPos + 26, 2), Blocks.AIR.defaultBlockState(), 3);
                                    break;
                                }
                                default: {
                                    v4 = ((ServerPlayer)player).serverLevel().setBlock(chunk.offset(11, yPos, 2), TBSBlocks.EXIT.getDefaultState(), 3);
                                }
                            }
                        }
                    }
                }
            } else {
                PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, counter$lambda$3(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
            }
        }
    }

    private static final Unit counter$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTeleportCounter($this$updateVars.getTeleportCounter() + 1);
        return Unit.INSTANCE;
    }

    private static final Unit counter$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTeleportCounter(0);
        return Unit.INSTANCE;
    }

    private static final Unit counter$lambda$3(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTeleportCounter(0);
        return Unit.INSTANCE;
    }

    static {
        PlayerTeleportationSubscriber.INSTANCE.add((Function3<? super Player, ? super Direction, ? super CancelProxy, Unit>)((Function3)new Function3<Player, Direction, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(Player p0, Direction p1, CancelProxy p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((ProtectedVoidTeleportCounter)this.receiver).counter(p0, p1, p2);
            }
        }));
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)0, (Object)71), TuplesKt.to((Object)1, (Object)72), TuplesKt.to((Object)2, (Object)79), TuplesKt.to((Object)3, (Object)80), TuplesKt.to((Object)4, (Object)95), TuplesKt.to((Object)5, (Object)96)};
        yPosMap = MapsKt.mapOf((Pair[])pairArray);
    }
}


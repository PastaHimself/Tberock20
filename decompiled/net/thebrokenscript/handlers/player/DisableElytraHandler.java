/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.fever.FeverEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/handlers/player/DisableElytraHandler;", "", "<init>", "()V", "isBeingChased", "", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nDisableElytraHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisableElytraHandler.kt\nnet/thebrokenscript/handlers/player/DisableElytraHandler\n+ 2 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n64#2:36\n1761#3,2:37\n1761#3,3:39\n1763#3:42\n*S KotlinDebug\n*F\n+ 1 DisableElytraHandler.kt\nnet/thebrokenscript/handlers/player/DisableElytraHandler\n*L\n31#1:36\n31#1:37,2\n32#1:39,3\n31#1:42\n*E\n"})
public final class DisableElytraHandler {
    @NotNull
    public static final DisableElytraHandler INSTANCE = new DisableElytraHandler();

    private DisableElytraHandler() {
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isBeingChased(@NotNull ServerPlayer $this$isBeingChased) {
        boolean bl;
        block7: {
            void base$iv;
            void $this$findEntitiesInRange$iv;
            Intrinsics.checkNotNullParameter((Object)$this$isBeingChased, (String)"<this>");
            KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(TheBrokenEndEntity.class), Reflection.getOrCreateKotlinClass(CircuitEntity.class), Reflection.getOrCreateKotlinClass(FeverEntity.class)};
            List chaseEntities = CollectionsKt.listOf((Object[])kClassArray);
            Level level = $this$isBeingChased.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            kClassArray = (KClass[])level;
            Vec3 vec3 = $this$isBeingChased.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            Vec3 vec32 = vec3;
            Number radius$iv = 192.0;
            boolean $i$f$findEntitiesInRange = false;
            Iterable $this$any$iv = EntityFinder.findEntitiesInRange((LevelAccessor)$this$findEntitiesInRange$iv, BaseMonster.class, (Vec3)base$iv, (Number)radius$iv);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    boolean bl2;
                    BaseMonster monster;
                    block6: {
                        monster = (BaseMonster)element$iv;
                        boolean bl3 = false;
                        Iterable $this$any$iv2 = chaseEntities;
                        boolean $i$f$any2 = false;
                        if ($this$any$iv2 instanceof Collection && ((Collection)$this$any$iv2).isEmpty()) {
                            bl2 = false;
                        } else {
                            for (Object element$iv2 : $this$any$iv2) {
                                KClass it = (KClass)element$iv2;
                                boolean bl4 = false;
                                if (!it.isInstance((Object)monster)) continue;
                                bl2 = true;
                                break block6;
                            }
                            bl2 = false;
                        }
                    }
                    if (!(bl2 && Intrinsics.areEqual((Object)monster.getTarget(), (Object)$this$isBeingChased))) continue;
                    bl = true;
                    break block7;
                }
                bl = false;
            }
        }
        return bl;
    }

    private static final Unit _init_$lambda$0(Player it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof ServerPlayer && ((ServerPlayer)it).isFallFlying() && INSTANCE.isBeingChased((ServerPlayer)it)) {
            it.stopFallFlying();
        }
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)DisableElytraHandler::_init_$lambda$0));
    }
}


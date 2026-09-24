/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.chat;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.siluet.SiluetChaseEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndStalkEntity;
import net.thebrokenscript.handlers.subs.ServerChatSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u00020\r*\u00020\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/handlers/chat/ChatEngineHandler;", "", "<init>", "()V", "onChat", "", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "message", "", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "hasEntities", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nChatEngineHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatEngineHandler.kt\nnet/thebrokenscript/handlers/chat/ChatEngineHandler\n+ 2 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n64#2:44\n1761#3,2:45\n1761#3,3:47\n1763#3:50\n*S KotlinDebug\n*F\n+ 1 ChatEngineHandler.kt\nnet/thebrokenscript/handlers/chat/ChatEngineHandler\n*L\n39#1:44\n39#1:45,2\n40#1:47,3\n39#1:50\n*E\n"})
public final class ChatEngineHandler {
    @NotNull
    public static final ChatEngineHandler INSTANCE = new ChatEngineHandler();

    private ChatEngineHandler() {
    }

    private final void onChat(ServerPlayer sender, String message, CancelProxy cancelProxy) {
        if (this.hasEntities(sender)) {
            cancelProxy.setCanceled(true);
            PlayerUtil.setActionBar((Player)((Player)sender), (Component)((Component)TBSLang.INSTANCE.getCHAT_ENGINE_1()));
            EntityUtil.getQueue((Entity)((Entity)sender)).add(20L, () -> ChatEngineHandler.onChat$lambda$0(sender));
        }
    }

    /*
     * WARNING - void declaration
     */
    public final boolean hasEntities(@NotNull ServerPlayer $this$hasEntities) {
        boolean bl;
        block7: {
            void base$iv;
            void $this$findEntitiesInRange$iv;
            Intrinsics.checkNotNullParameter((Object)$this$hasEntities, (String)"<this>");
            KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(TheBrokenEndStalkEntity.class), Reflection.getOrCreateKotlinClass(TheBrokenEndEntity.class), Reflection.getOrCreateKotlinClass(SiluetChaseEntity.class)};
            List chaseEntities = CollectionsKt.listOf((Object[])kClassArray);
            Level level = $this$hasEntities.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            kClassArray = (KClass[])level;
            Vec3 vec3 = $this$hasEntities.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            Vec3 vec32 = vec3;
            Number radius$iv = 128.0;
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
                    if (!(bl2 && Intrinsics.areEqual((Object)monster.getTarget(), (Object)$this$hasEntities))) continue;
                    bl = true;
                    break block7;
                }
                bl = false;
            }
        }
        return bl;
    }

    private static final Unit onChat$lambda$0(ServerPlayer $sender) {
        PlayerUtil.setActionBar((Player)((Player)$sender), (Component)((Component)TBSLang.INSTANCE.getCHAT_ENGINE_2()));
        return Unit.INSTANCE;
    }

    static {
        ServerChatSubscriber.INSTANCE.add((Function3<? super ServerPlayer, ? super String, ? super CancelProxy, Unit>)((Function3)new Function3<ServerPlayer, String, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(ServerPlayer p0, String p1, CancelProxy p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((ChatEngineHandler)this.receiver).onChat(p0, p1, p2);
            }
        }));
    }
}


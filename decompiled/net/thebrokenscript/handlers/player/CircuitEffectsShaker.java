/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$ArmorData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Background
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Background$BackgroundData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$CrosshairData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Experience
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Experience$ExperienceData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Heart
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Heart$HeartData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$HotbarItems
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$HotbarItems$HotbarItemData
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Hunger
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$Hud$Hunger$HungerData
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.player;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/handlers/player/CircuitEffectsShaker;", "", "<init>", "()V", "player", "Lnet/minecraft/client/player/LocalPlayer;", "getPlayer", "()Lnet/minecraft/client/player/LocalPlayer;", "setPlayer", "(Lnet/minecraft/client/player/LocalPlayer;)V", "isChasingThisPlayer", "", "()Z", "setChasingThisPlayer", "(Z)V", "onChase", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitEffectsShaker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitEffectsShaker.kt\nnet/thebrokenscript/handlers/player/CircuitEffectsShaker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1761#2,3:139\n*S KotlinDebug\n*F\n+ 1 CircuitEffectsShaker.kt\nnet/thebrokenscript/handlers/player/CircuitEffectsShaker\n*L\n134#1:139,3\n*E\n"})
public final class CircuitEffectsShaker {
    @NotNull
    public static final CircuitEffectsShaker INSTANCE = new CircuitEffectsShaker();
    @Nullable
    private static LocalPlayer player;
    private static boolean isChasingThisPlayer;

    private CircuitEffectsShaker() {
    }

    @Nullable
    public final LocalPlayer getPlayer() {
        return player;
    }

    public final void setPlayer(@Nullable LocalPlayer localPlayer) {
        player = localPlayer;
    }

    public final boolean isChasingThisPlayer() {
        return isChasingThisPlayer;
    }

    public final void setChasingThisPlayer(boolean bl) {
        isChasingThisPlayer = bl;
    }

    /*
     * Unable to fully structure code
     */
    private final void onChase(Minecraft mc) {
        block3: {
            block4: {
                block5: {
                    CircuitEffectsShaker.player = mc.player;
                    v0 = mc.level;
                    if (v0 == null || (v0 = v0.entitiesForRendering()) == null) break block4;
                    $this$any$iv = v0;
                    $i$f$any = false;
                    if (!($this$any$iv instanceof Collection) || !((Collection)$this$any$iv).isEmpty()) break block5;
                    v1 = false;
                    break block3;
                }
                var4_4 = $this$any$iv.iterator();
                while (var4_4.hasNext()) {
                    element$iv = var4_4.next();
                    it = (Entity)element$iv;
                    $i$a$-any-CircuitEffectsShaker$onChase$1 = false;
                    if (!(it instanceof CircuitEntity)) ** GOTO lbl-1000
                    v2 = CircuitEffectsShaker.player;
                    if (Intrinsics.areEqual((Object)EntityUtil.clientTargetUUID((Entity)it), (Object)(v2 != null ? v2.getUUID() : null)) && !((CircuitEntity)it).isNoAi()) {
                        v3 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v3 = false;
                    }
                    if (!v3) continue;
                    v1 = true;
                    break block3;
                }
                v1 = false;
                break block3;
            }
            v1 = false;
        }
        CircuitEffectsShaker.isChasingThisPlayer = v1;
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.onChase(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(RenderEvents.Hud.Hunger.HungerData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(0.0f, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(RenderEvents.Hud.Hunger.HungerData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(0.0f, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(RenderEvents.Hud.Background.BackgroundData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(RenderEvents.Hud.Background.BackgroundData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(RenderEvents.Hud.Background.BackgroundData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(RenderEvents.Hud.CrosshairData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(RenderEvents.Hud.HotbarItems.HotbarItemData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(RenderEvents.Hud.HotbarItems.HotbarItemData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(RenderEvents.Hud.ArmorData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(RenderEvents.Hud.Experience.ExperienceData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$11(RenderEvents.Hud.Experience.ExperienceData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (player != null) {
            if (isChasingThisPlayer) {
                LocalPlayer localPlayer = player;
                Intrinsics.checkNotNull((Object)localPlayer);
                float y = localPlayer.getRandom().nextFloat() * 3.0f - 1.0f;
                LocalPlayer localPlayer2 = player;
                Intrinsics.checkNotNull((Object)localPlayer2);
                float x = localPlayer2.getRandom().nextFloat() * 3.0f - 1.0f;
                $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$12(RenderEvents.Hud.Heart.HeartData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$13(RenderEvents.Hud.Heart.HeartData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(RenderEvents.Hud.Heart.HeartData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (isChasingThisPlayer) {
            float y = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            float x = $this$on.getPlayer().getRandom().nextFloat() * 3.0f - 1.0f;
            $this$on.getGuiGraphics().pose().translate(x, y, 0.0f);
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, CircuitEffectsShaker::_init_$lambda$0);
        GameEvent.Companion.on(RenderEvents.Hud.Hunger.CONTAINER, CircuitEffectsShaker::_init_$lambda$1);
        GameEvent.Companion.on(RenderEvents.Hud.Hunger.SHANK, CircuitEffectsShaker::_init_$lambda$2);
        GameEvent.Companion.on(RenderEvents.Hud.Background.HOTBAR, CircuitEffectsShaker::_init_$lambda$3);
        GameEvent.Companion.on(RenderEvents.Hud.Background.OFFHAND, CircuitEffectsShaker::_init_$lambda$4);
        GameEvent.Companion.on(RenderEvents.Hud.Background.HIGHLIGHT, CircuitEffectsShaker::_init_$lambda$5);
        GameEvent.Companion.on(RenderEvents.Hud.CROSSHAIR, CircuitEffectsShaker::_init_$lambda$6);
        GameEvent.Companion.on(RenderEvents.Hud.HotbarItems.MAIN_HAND_ITEM, CircuitEffectsShaker::_init_$lambda$7);
        GameEvent.Companion.on(RenderEvents.Hud.HotbarItems.OFFHAND_ITEM, CircuitEffectsShaker::_init_$lambda$8);
        GameEvent.Companion.on(RenderEvents.Hud.ARMOR, CircuitEffectsShaker::_init_$lambda$9);
        GameEvent.Companion.on(RenderEvents.Hud.Experience.LEVEL, CircuitEffectsShaker::_init_$lambda$10);
        GameEvent.Companion.on(RenderEvents.Hud.Experience.BAR, CircuitEffectsShaker::_init_$lambda$11);
        GameEvent.Companion.on(RenderEvents.Hud.Heart.CONTAINER, CircuitEffectsShaker::_init_$lambda$12);
        GameEvent.Companion.on(RenderEvents.Hud.Heart.HEARTS, CircuitEffectsShaker::_init_$lambda$13);
        GameEvent.Companion.on(RenderEvents.Hud.Heart.ABSORPTION, CircuitEffectsShaker::_init_$lambda$14);
    }
}


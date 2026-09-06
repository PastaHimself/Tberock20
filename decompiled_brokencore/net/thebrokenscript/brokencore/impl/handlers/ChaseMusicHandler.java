/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.handlers;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.LevelTickEvents;
import net.thebrokenscript.brokencore.api.registry.objects.ChaseRegistry;
import net.thebrokenscript.brokencore.api.registry.util.ChaseRule;
import net.thebrokenscript.brokencore.api.registry.util.ChaseSightTracker;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCSoundCategories;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/impl/handlers/ChaseMusicHandler;", "", "<init>", "()V", "music", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getMusic", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setMusic", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "currentSound", "Lnet/minecraft/sounds/SoundEvent;", "getCurrentSound", "()Lnet/minecraft/sounds/SoundEvent;", "setCurrentSound", "(Lnet/minecraft/sounds/SoundEvent;)V", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nChaseMusicHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChaseMusicHandler.kt\nnet/thebrokenscript/brokencore/impl/handlers/ChaseMusicHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1761#2,3:69\n1869#2,2:72\n1761#2,3:74\n1#3:77\n*S KotlinDebug\n*F\n+ 1 ChaseMusicHandler.kt\nnet/thebrokenscript/brokencore/impl/handlers/ChaseMusicHandler\n*L\n39#1:69,3\n40#1:72,2\n44#1:74,3\n*E\n"})
public final class ChaseMusicHandler {
    @NotNull
    public static final ChaseMusicHandler INSTANCE = new ChaseMusicHandler();
    @Nullable
    private static FancySoundInstance music;
    @Nullable
    private static SoundEvent currentSound;

    private ChaseMusicHandler() {
    }

    @Nullable
    public final FancySoundInstance getMusic() {
        return music;
    }

    public final void setMusic(@Nullable FancySoundInstance fancySoundInstance) {
        music = fancySoundInstance;
    }

    @Nullable
    public final SoundEvent getCurrentSound() {
        return currentSound;
    }

    public final void setCurrentSound(@Nullable SoundEvent soundEvent) {
        currentSound = soundEvent;
    }

    private static final Unit _init_$lambda$0(LevelTickEvents.Data $this$on) {
        block17: {
            block18: {
                SoundEvent soundToPlay;
                block19: {
                    Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
                    if (!$this$on.getLevel().isClientSide) break block17;
                    LocalPlayer localPlayer = ClientDSLKt.getMC().player;
                    if (localPlayer == null) {
                        return Unit.INSTANCE;
                    }
                    LocalPlayer player = localPlayer;
                    if ($this$on.getLevel().getGameTime() % (long)10 != 0L) {
                        return Unit.INSTANCE;
                    }
                    AABB aabb = new AABB(player.blockPosition()).inflate(192.0);
                    boolean shouldPlay = false;
                    soundToPlay = null;
                    Iterator<Map.Entry<Class<? extends Entity>, List<ChaseRule<? extends Entity>>>> iterator = ChaseRegistry.INSTANCE.allGroups().iterator();
                    block0: while (iterator.hasNext()) {
                        ChaseRule it;
                        boolean bl;
                        List<ChaseRule<? extends Entity>> rules;
                        List entities;
                        block15: {
                            Class<? extends Entity> entityClass;
                            Map.Entry<Class<? extends Entity>, List<ChaseRule<? extends Entity>>> entry;
                            Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
                            Intrinsics.checkNotNullExpressionValue(entry.getKey(), (String)"component1(...)");
                            Intrinsics.checkNotNullExpressionValue(entry.getValue(), (String)"component2(...)");
                            entities = $this$on.getLevel().getEntitiesOfClass(entityClass, aabb);
                            Iterable $this$any$iv = rules;
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                bl = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    it = (ChaseRule)element$iv;
                                    boolean bl2 = false;
                                    if (!it.getRequiresSight()) continue;
                                    bl = true;
                                    break block15;
                                }
                                bl = false;
                            }
                        }
                        if (bl) {
                            Intrinsics.checkNotNull((Object)entities);
                            Iterable $this$forEach$iv = entities;
                            boolean $i$f$forEach = false;
                            for (Object element$iv : $this$forEach$iv) {
                                it = (Entity)element$iv;
                                boolean bl3 = false;
                                Intrinsics.checkNotNull((Object)it);
                                ChaseSightTracker.INSTANCE.update((Entity)it, player);
                            }
                        }
                        for (ChaseRule<? extends Entity> rule : rules) {
                            boolean bl4;
                            block16: {
                                Intrinsics.checkNotNull((Object)entities);
                                Iterable $this$any$iv = entities;
                                boolean $i$f$any = false;
                                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                    bl4 = false;
                                } else {
                                    for (Object element$iv : $this$any$iv) {
                                        Entity it2 = (Entity)element$iv;
                                        boolean bl5 = false;
                                        Intrinsics.checkNotNull((Object)it2);
                                        if (!rule.invokeIsChasing(it2, (Player)player)) continue;
                                        bl4 = true;
                                        break block16;
                                    }
                                    bl4 = false;
                                }
                            }
                            if (!bl4) continue;
                            shouldPlay = true;
                            soundToPlay = rule.getSound().get();
                            break block0;
                        }
                    }
                    if (!shouldPlay) break block18;
                    if (music == null) break block19;
                    FancySoundInstance fancySoundInstance = music;
                    Intrinsics.checkNotNull((Object)fancySoundInstance);
                    if (fancySoundInstance.isStopped()) break block19;
                    if (Intrinsics.areEqual((Object)currentSound, soundToPlay)) break block17;
                }
                FancySoundInstance fancySoundInstance = music;
                if (fancySoundInstance != null) {
                    FancySoundInstance it = fancySoundInstance;
                    boolean bl = false;
                    FancyAudio.INSTANCE.stop(it);
                }
                SoundEvent soundEvent = soundToPlay;
                Intrinsics.checkNotNull(soundEvent);
                music = FancyAudio.play$default(FancyAudio.INSTANCE, soundEvent, BCSoundCategories.BC_CHASE, 0.75f, 0.0f, true, null, 40, null);
                currentSound = soundToPlay;
                break block17;
            }
            if (music != null) {
                FancySoundInstance fancySoundInstance = music;
                Intrinsics.checkNotNull((Object)fancySoundInstance);
                FancyAudio.INSTANCE.stop(fancySoundInstance);
                music = null;
                currentSound = null;
            }
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(LevelTickEvents.POST, ChaseMusicHandler::_init_$lambda$0);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.dimensions.ambience;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSSoundCategories;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/handlers/dimensions/ambience/ClanVoidAmbienceHandler;", "", "<init>", "()V", "pitch", "", "", "", "getPitch", "()Ljava/util/Map;", "instance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getInstance", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setInstance", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "ambience", "", "mc", "Lnet/minecraft/client/Minecraft;", "thebrokenscript-common"})
public final class ClanVoidAmbienceHandler {
    @NotNull
    public static final ClanVoidAmbienceHandler INSTANCE = new ClanVoidAmbienceHandler();
    @NotNull
    private static final Map<Integer, Float> pitch;
    @Nullable
    private static FancySoundInstance instance;

    private ClanVoidAmbienceHandler() {
    }

    @NotNull
    public final Map<Integer, Float> getPitch() {
        return pitch;
    }

    @Nullable
    public final FancySoundInstance getInstance() {
        return instance;
    }

    public final void setInstance(@Nullable FancySoundInstance fancySoundInstance) {
        instance = fancySoundInstance;
    }

    private final void ambience(Minecraft mc) {
        block12: {
            double offsetZ;
            double offsetX;
            RandomSource random;
            LocalPlayer player;
            block18: {
                block17: {
                    double d;
                    block16: {
                        block15: {
                            block13: {
                                block14: {
                                    LocalPlayer localPlayer = mc.player;
                                    if (localPlayer == null) {
                                        return;
                                    }
                                    player = localPlayer;
                                    if (!Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.CLAN_VOID)) {
                                        return;
                                    }
                                    random = player.getRandom();
                                    Level level = player.level();
                                    if (level.getGameTime() % (long)random.nextInt(450, 801) != 0L) break block12;
                                    double angle = level.random.nextDouble() * 2.0 * Math.PI;
                                    double distance = 2.0 + level.random.nextDouble() * 12.0;
                                    offsetX = player.getX() + Math.cos(angle) * distance;
                                    offsetZ = player.getZ() + Math.sin(angle) * distance;
                                    d = player.getY();
                                    boolean bl = 230.1 <= d ? d <= 250.9 : false;
                                    if (!bl) break block13;
                                    if (instance != null) {
                                        SoundManager soundManager = mc.getSoundManager();
                                        FancySoundInstance fancySoundInstance = instance;
                                        Intrinsics.checkNotNull((Object)fancySoundInstance);
                                        if (!soundManager.isActive((SoundInstance)fancySoundInstance)) {
                                            instance = null;
                                        }
                                    }
                                    if (instance == null) break block14;
                                    FancySoundInstance fancySoundInstance = instance;
                                    boolean bl2 = fancySoundInstance != null ? fancySoundInstance.isStopped() : false;
                                    if (!bl2) break block12;
                                }
                                instance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.STONE_FLOOR_AMBIENCE.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)false, null, (int)60, null);
                                break block12;
                            }
                            boolean bl = 216.0 <= d ? d <= 230.0 : false;
                            if (!bl) break block15;
                            ClientLevel clientLevel = ClientDSLKt.getMC().level;
                            if (clientLevel == null) break block12;
                            clientLevel.playLocalSound(offsetX, player.getY(), offsetZ, (SoundEvent)TBSSounds.WOOD_SFX.invoke(), SoundSource.AMBIENT, 4.0f, ((Number)MapsKt.getValue(pitch, (Object)random.nextInt(1, 5))).floatValue(), false);
                            break block12;
                        }
                        boolean bl = 206.0 <= d ? d <= 215.9 : false;
                        if (!bl) break block16;
                        ClientLevel clientLevel = ClientDSLKt.getMC().level;
                        if (clientLevel == null) break block12;
                        clientLevel.playLocalSound(offsetX, player.getY(), offsetZ, (SoundEvent)TBSSounds.MAZE_SFX.invoke(), SoundSource.AMBIENT, 4.0f, ((Number)MapsKt.getValue(pitch, (Object)random.nextInt(1, 5))).floatValue(), false);
                        break block12;
                    }
                    boolean bl = 251.0 <= d ? d <= 500.0 : false;
                    if (!bl) break block12;
                    if (instance != null) {
                        SoundManager soundManager = mc.getSoundManager();
                        FancySoundInstance fancySoundInstance = instance;
                        Intrinsics.checkNotNull((Object)fancySoundInstance);
                        if (!soundManager.isActive((SoundInstance)fancySoundInstance)) {
                            instance = null;
                        }
                    }
                    if (instance == null) break block17;
                    FancySoundInstance fancySoundInstance = instance;
                    boolean bl3 = fancySoundInstance != null ? fancySoundInstance.isStopped() : false;
                    if (!bl3) break block18;
                }
                instance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.DAY_A_AMBIENCE.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)false, null, (int)60, null);
            }
            if (random.nextInt(0, 8) != 3 || player.getBlockStateOn().isAir()) break block12;
            ClientLevel clientLevel = ClientDSLKt.getMC().level;
            if (clientLevel != null) {
                clientLevel.playLocalSound(offsetX, player.getY(), offsetZ, SoundEvents.GRASS_STEP, SoundSource.AMBIENT, 4.0f, 1.0f, false);
            }
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.ambience(ClientDSLKt.getMC());
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, ClanVoidAmbienceHandler::_init_$lambda$0);
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)1, (Object)Float.valueOf(0.25f)), TuplesKt.to((Object)2, (Object)Float.valueOf(0.75f)), TuplesKt.to((Object)3, (Object)Float.valueOf(1.0f)), TuplesKt.to((Object)4, (Object)Float.valueOf(1.25f))};
        pitch = MapsKt.mapOf((Pair[])pairArray);
    }
}


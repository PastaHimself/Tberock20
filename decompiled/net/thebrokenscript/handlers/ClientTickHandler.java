/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.Holder
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.jimmy.Jimbo;
import net.thebrokenscript.boss.jimmy.MoonRiseAmbience;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.dimensions.ambience.ClanVoidAmbienceHandler;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSSoundCategories;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/handlers/ClientTickHandler;", "", "<init>", "()V", "lastSentFov", "", "updateMoonRise", "", "mc", "Lnet/minecraft/client/Minecraft;", "onFovChange", "dataTick", "thebrokenscript-common"})
public final class ClientTickHandler {
    @NotNull
    public static final ClientTickHandler INSTANCE = new ClientTickHandler();
    private static double lastSentFov = -1.0;

    private ClientTickHandler() {
    }

    private final void updateMoonRise(Minecraft mc) {
        block8: {
            BlockState headBlock;
            BlockState block;
            block10: {
                block9: {
                    block7: {
                        LocalPlayer localPlayer = mc.player;
                        if (localPlayer == null) {
                            return;
                        }
                        LocalPlayer player = localPlayer;
                        block = player.level().getBlockState(player.blockPosition());
                        headBlock = player.level().getBlockState(player.blockPosition().above());
                        if (Jimbo.INSTANCE.getMOONRISE() == null && Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.CORRUPTED_MOON)) {
                            Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
                        }
                        if (!block.is((Holder)TBSBlocks.JIM_TRIGGER_1) && !headBlock.is((Holder)TBSBlocks.JIM_TRIGGER_1)) break block7;
                        if (Jimbo.INSTANCE.getMOONRISE() == null) {
                            Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
                        }
                        MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
                        if (moonRiseAmbience == null) break block8;
                        moonRiseAmbience.applyStage(1);
                        break block8;
                    }
                    if (!block.is((Holder)TBSBlocks.JIM_TRIGGER_2) && !headBlock.is((Holder)TBSBlocks.JIM_TRIGGER_2)) break block9;
                    if (Jimbo.INSTANCE.getMOONRISE() == null) {
                        Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
                    }
                    MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
                    if (moonRiseAmbience == null) break block8;
                    moonRiseAmbience.applyStage(2);
                    break block8;
                }
                if (!block.is((Holder)TBSBlocks.JIM_TRIGGER_3) && !headBlock.is((Holder)TBSBlocks.JIM_TRIGGER_3)) break block10;
                if (Jimbo.INSTANCE.getMOONRISE() == null) {
                    Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
                }
                MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
                if (moonRiseAmbience == null) break block8;
                moonRiseAmbience.applyStage(3);
                break block8;
            }
            if (!block.is((Holder)TBSBlocks.JIM_TRIGGER_4) && !headBlock.is((Holder)TBSBlocks.JIM_TRIGGER_4)) break block8;
            if (Jimbo.INSTANCE.getMOONRISE() == null) {
                Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
            }
            MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
            if (moonRiseAmbience != null) {
                moonRiseAmbience.applyStage(4);
            }
        }
    }

    private final void onFovChange(Minecraft mc) {
        Object object;
        double currentFov = ((Number)mc.options.fov().get()).intValue();
        if (mc.getConnection() == null) {
            return;
        }
        if (Math.abs(currentFov - lastSentFov) > 0.01 || Intrinsics.areEqual((object = mc.player) != null && (object = PlayerExt.INSTANCE.getVars((Player)object)) != null ? Double.valueOf(((PlayerVariables)object).getFov()) : null, (double)0.0)) {
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.UPDATE_FOV.of(currentFov), new CustomPacketPayload[0]);
            lastSentFov = currentFov;
        }
    }

    private final void dataTick(Minecraft mc) {
        block5: {
            block7: {
                block6: {
                    PlayerVariables vars;
                    LocalPlayer localPlayer = mc.player;
                    PlayerVariables playerVariables = vars = localPlayer != null ? PlayerExt.INSTANCE.getVars((Player)localPlayer) : null;
                    if (vars == null || vars.getMusicTimer() <= 0) break block5;
                    PlayerVariables playerVariables2 = vars;
                    int n = playerVariables2.getMusicTimer();
                    playerVariables2.setMusicTimer(n + -1);
                    if (vars.getMusicTimer() > 0) break block5;
                    if (ClanVoidAmbienceHandler.INSTANCE.getInstance() == null) break block6;
                    FancySoundInstance fancySoundInstance = ClanVoidAmbienceHandler.INSTANCE.getInstance();
                    Intrinsics.checkNotNull((Object)fancySoundInstance);
                    if (FancyAudio.INSTANCE.isPlaying(fancySoundInstance)) break block7;
                }
                if (mc.player != null) {
                    LocalPlayer localPlayer = mc.player;
                    Intrinsics.checkNotNull((Object)localPlayer);
                    if (Intrinsics.areEqual((Object)localPlayer.level().dimension(), TBSDimensions.CLAN_VOID)) {
                        ClanVoidAmbienceHandler.INSTANCE.setInstance(FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.DAY_A_AMBIENCE.invoke()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)false, null, (int)60, null));
                    }
                }
            }
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.FORCE_SYNC_MUSIC_TIMER, new CustomPacketPayload[0]);
        }
    }

    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
        if (moonRiseAmbience != null) {
            moonRiseAmbience.tick();
        }
        INSTANCE.updateMoonRise(ClientDSLKt.getMC());
        INSTANCE.onFovChange(ClientDSLKt.getMC());
        INSTANCE.dataTick(ClientDSLKt.getMC());
        if (!ClientVariables.INSTANCE.has(512L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return Unit.INSTANCE;
            }
            LocalPlayer player = localPlayer;
            ClientLevel clientLevel = ClientDSLKt.getMC().level;
            if (clientLevel == null) {
                return Unit.INSTANCE;
            }
            ClientLevel level = clientLevel;
            int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, player.getBlockX(), player.getBlockZ());
            if (player.getY() > (double)surfaceY && LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonStage() > 0) {
                ClientVariables.INSTANCE.set(512L);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.TICK_END, ClientTickHandler::_init_$lambda$0);
    }
}


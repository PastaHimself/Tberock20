/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.thebrokenscript.brokencore.api.network.BasePacket
 *  net.thebrokenscript.brokencore.api.network.PacketInitializer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.boss.kerfur.KerfBossMusicPacket;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.network.PacketInitializer;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.network.ChangeGammaPacket;
import net.thebrokenscript.network.ChaseSoundPacket;
import net.thebrokenscript.network.ChordLazerAttackPacket;
import net.thebrokenscript.network.ChordLazerChargePacket;
import net.thebrokenscript.network.ChordProjectileAttackPacket;
import net.thebrokenscript.network.ClearSkyBluePacket;
import net.thebrokenscript.network.CorruptedCommandBlockConfirmPacket;
import net.thebrokenscript.network.CorruptedCommandBlockPacket;
import net.thebrokenscript.network.CraftedPolaroidPacket;
import net.thebrokenscript.network.CurvedDeathSoundPacket;
import net.thebrokenscript.network.CurvedNoticePacket;
import net.thebrokenscript.network.CustomHostileSoundPacket;
import net.thebrokenscript.network.CustomMusicPacket;
import net.thebrokenscript.network.CustomSoundPacket;
import net.thebrokenscript.network.FireballShootPacket;
import net.thebrokenscript.network.InventoryCorruptionProgressPacket;
import net.thebrokenscript.network.JimmyBigStompPacket;
import net.thebrokenscript.network.JimmySlamHitPacket;
import net.thebrokenscript.network.MapVarsSyncPacket;
import net.thebrokenscript.network.NullisHereStopSoundPacket;
import net.thebrokenscript.network.OpenCreditsPacket;
import net.thebrokenscript.network.Phase2HitPacket;
import net.thebrokenscript.network.Phase3CutscenePacket;
import net.thebrokenscript.network.PlayerVarsSyncPacket;
import net.thebrokenscript.network.RockDropPacket;
import net.thebrokenscript.network.RockThrowPacket;
import net.thebrokenscript.network.SetCameraModePacket;
import net.thebrokenscript.network.SetWindowedPacket;
import net.thebrokenscript.network.StopLoopMusicPacket;
import net.thebrokenscript.network.SyncHomeDirToServerPlayerVarPacket;
import net.thebrokenscript.network.SyncMusicTimerPacket;
import net.thebrokenscript.network.SyncPlayerBlockPosToServerPacket;
import net.thebrokenscript.network.TBESpawnSoundPacket;
import net.thebrokenscript.network.TeleportPlayerFromBossToHomePacket;
import net.thebrokenscript.network.TentacleHitPacket;
import net.thebrokenscript.network.UpdateCapesPacket;
import net.thebrokenscript.network.UpdateFovPacket;
import net.thebrokenscript.network.UpdateIntegBossBarPacket;
import net.thebrokenscript.network.UpdateJimmyBossBarPacket;
import net.thebrokenscript.network.UpdateShockwavePositionPacket;
import net.thebrokenscript.network.WindowTitlePacket;
import net.thebrokenscript.network.WriteTxtPacket;
import net.thebrokenscript.network.debug.MazePathfindDebugPacket;
import net.thebrokenscript.network.music.BossEndMusicPacket;
import net.thebrokenscript.network.music.Phase1MusicPacket;
import net.thebrokenscript.network.music.Phase2MusicPacket;
import net.thebrokenscript.network.music.Phase3MusicPacket;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0002018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0002038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0002058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0002098\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020?8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020A8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020C8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020E8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020G8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020I8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020K8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020M8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020O8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020Q8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u00020S8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020U8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020W8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u00020Y8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020[8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020]8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020_8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020a8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020c8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2={"Lnet/thebrokenscript/registry/TBSPackets;", "Lnet/thebrokenscript/brokencore/api/network/PacketInitializer;", "<init>", "()V", "DEBUG_PATHFINDER_PACKET", "Lnet/thebrokenscript/network/debug/MazePathfindDebugPacket;", "PLAYER_TP_FROM_BOSS", "Lnet/thebrokenscript/network/TeleportPlayerFromBossToHomePacket;", "MAP_VARS_SYNC", "Lnet/thebrokenscript/network/MapVarsSyncPacket;", "PLAYER_VARS_SYNC", "Lnet/thebrokenscript/network/PlayerVarsSyncPacket;", "CORRUPTED_COMMAND_PACKET", "Lnet/thebrokenscript/network/CorruptedCommandBlockPacket;", "CORRUPTED_COMMAND_CONFIRM_PACKET", "Lnet/thebrokenscript/network/CorruptedCommandBlockConfirmPacket;", "INVENTORY_CORRUPTION_PROGRESS", "Lnet/thebrokenscript/network/InventoryCorruptionProgressPacket;", "NULL_STOP_SOUND_PACKET", "Lnet/thebrokenscript/network/NullisHereStopSoundPacket;", "CURVED_NOTICE_PACKET", "Lnet/thebrokenscript/network/CurvedNoticePacket;", "CURVED_DEATH_PACKET", "Lnet/thebrokenscript/network/CurvedDeathSoundPacket;", "CHORD_LAZER_ATTACK", "Lnet/thebrokenscript/network/ChordLazerAttackPacket;", "CHORD_LAZER_CHARGE", "Lnet/thebrokenscript/network/ChordLazerChargePacket;", "CHORD_PROJECTILE_ATTACK", "Lnet/thebrokenscript/network/ChordProjectileAttackPacket;", "TBE_SPAWN_PACKET", "Lnet/thebrokenscript/network/TBESpawnSoundPacket;", "UPDATE_FOV", "Lnet/thebrokenscript/network/UpdateFovPacket;", "FORCE_SYNC_MUSIC_TIMER", "Lnet/thebrokenscript/network/SyncMusicTimerPacket;", "WINDOW_TITLE_PACKET", "Lnet/thebrokenscript/network/WindowTitlePacket;", "SYNC_PLAYER_BLOCKPOS", "Lnet/thebrokenscript/network/SyncPlayerBlockPosToServerPacket;", "SET_WINDOWED", "Lnet/thebrokenscript/network/SetWindowedPacket;", "TENTACLE_HIT", "Lnet/thebrokenscript/network/TentacleHitPacket;", "PHASE2_HIT", "Lnet/thebrokenscript/network/Phase2HitPacket;", "WRITE_TXT_PACKET", "Lnet/thebrokenscript/network/WriteTxtPacket;", "SYNC_HOME_DIR", "Lnet/thebrokenscript/network/SyncHomeDirToServerPlayerVarPacket;", "CUSTOM_SOUND", "Lnet/thebrokenscript/network/CustomSoundPacket;", "CHASE_SOUND", "Lnet/thebrokenscript/network/ChaseSoundPacket;", "CUSTOM_HOSTILE", "Lnet/thebrokenscript/network/CustomHostileSoundPacket;", "CUSTOM_MUSIC", "Lnet/thebrokenscript/network/CustomMusicPacket;", "STOP_LOOPING_MUSIC", "Lnet/thebrokenscript/network/StopLoopMusicPacket;", "CHANGE_GAMMA", "Lnet/thebrokenscript/network/ChangeGammaPacket;", "SET_CAMERA_MODE", "Lnet/thebrokenscript/network/SetCameraModePacket;", "CRAFTED_POLAROID_PACKET", "Lnet/thebrokenscript/network/CraftedPolaroidPacket;", "OPEN_CREDITS", "Lnet/thebrokenscript/network/OpenCreditsPacket;", "KERF_BOSS_MUSIC", "Lnet/thebrokenscript/boss/kerfur/KerfBossMusicPacket;", "CLEAR_SKY_BLUE", "Lnet/thebrokenscript/network/ClearSkyBluePacket;", "SHOCKWAVE_UPDATE", "Lnet/thebrokenscript/network/UpdateShockwavePositionPacket;", "FIREBALL_PACKET", "Lnet/thebrokenscript/network/FireballShootPacket;", "ROCK_THROW_PACKET", "Lnet/thebrokenscript/network/RockThrowPacket;", "ROCK_DROP_PACKET", "Lnet/thebrokenscript/network/RockDropPacket;", "PHASE3_CUTSCENE", "Lnet/thebrokenscript/network/Phase3CutscenePacket;", "UPDATE_INTEG_BOSS_BAR", "Lnet/thebrokenscript/network/UpdateIntegBossBarPacket;", "UPDATE_JIMMY_BOSS_BAR", "Lnet/thebrokenscript/network/UpdateJimmyBossBarPacket;", "UPDATE_CAPES", "Lnet/thebrokenscript/network/UpdateCapesPacket;", "INTEGRITY_P1_MUSIC", "Lnet/thebrokenscript/network/music/Phase1MusicPacket;", "INTEGRITY_P2_MUSIC", "Lnet/thebrokenscript/network/music/Phase2MusicPacket;", "INTEGRITY_P3_MUSIC", "Lnet/thebrokenscript/network/music/Phase3MusicPacket;", "INTEGRITY_END_MUSIC", "Lnet/thebrokenscript/network/music/BossEndMusicPacket;", "JIMMY_SLAM_HIT", "Lnet/thebrokenscript/network/JimmySlamHitPacket;", "JIMMY_BIG_STOMP", "Lnet/thebrokenscript/network/JimmyBigStompPacket;", "thebrokenscript-common"})
public final class TBSPackets
extends PacketInitializer {
    @NotNull
    public static final TBSPackets INSTANCE = new TBSPackets();
    @JvmField
    @NotNull
    public static final MazePathfindDebugPacket DEBUG_PATHFINDER_PACKET = (MazePathfindDebugPacket)INSTANCE.register((BasePacket)new MazePathfindDebugPacket());
    @JvmField
    @NotNull
    public static final TeleportPlayerFromBossToHomePacket PLAYER_TP_FROM_BOSS = (TeleportPlayerFromBossToHomePacket)INSTANCE.register((BasePacket)new TeleportPlayerFromBossToHomePacket());
    @JvmField
    @NotNull
    public static final MapVarsSyncPacket MAP_VARS_SYNC = (MapVarsSyncPacket)INSTANCE.register((BasePacket)new MapVarsSyncPacket());
    @JvmField
    @NotNull
    public static final PlayerVarsSyncPacket PLAYER_VARS_SYNC = (PlayerVarsSyncPacket)INSTANCE.register((BasePacket)new PlayerVarsSyncPacket());
    @JvmField
    @NotNull
    public static final CorruptedCommandBlockPacket CORRUPTED_COMMAND_PACKET = (CorruptedCommandBlockPacket)INSTANCE.register((BasePacket)new CorruptedCommandBlockPacket());
    @JvmField
    @NotNull
    public static final CorruptedCommandBlockConfirmPacket CORRUPTED_COMMAND_CONFIRM_PACKET = (CorruptedCommandBlockConfirmPacket)INSTANCE.register((BasePacket)new CorruptedCommandBlockConfirmPacket());
    @JvmField
    @NotNull
    public static final InventoryCorruptionProgressPacket INVENTORY_CORRUPTION_PROGRESS = (InventoryCorruptionProgressPacket)INSTANCE.register((BasePacket)new InventoryCorruptionProgressPacket());
    @JvmField
    @NotNull
    public static final NullisHereStopSoundPacket NULL_STOP_SOUND_PACKET = (NullisHereStopSoundPacket)INSTANCE.register((BasePacket)new NullisHereStopSoundPacket());
    @JvmField
    @NotNull
    public static final CurvedNoticePacket CURVED_NOTICE_PACKET = (CurvedNoticePacket)INSTANCE.register((BasePacket)new CurvedNoticePacket());
    @JvmField
    @NotNull
    public static final CurvedDeathSoundPacket CURVED_DEATH_PACKET = (CurvedDeathSoundPacket)INSTANCE.register((BasePacket)new CurvedDeathSoundPacket());
    @JvmField
    @NotNull
    public static final ChordLazerAttackPacket CHORD_LAZER_ATTACK = (ChordLazerAttackPacket)INSTANCE.register((BasePacket)new ChordLazerAttackPacket());
    @JvmField
    @NotNull
    public static final ChordLazerChargePacket CHORD_LAZER_CHARGE = (ChordLazerChargePacket)INSTANCE.register((BasePacket)new ChordLazerChargePacket());
    @JvmField
    @NotNull
    public static final ChordProjectileAttackPacket CHORD_PROJECTILE_ATTACK = (ChordProjectileAttackPacket)INSTANCE.register((BasePacket)new ChordProjectileAttackPacket());
    @JvmField
    @NotNull
    public static final TBESpawnSoundPacket TBE_SPAWN_PACKET = (TBESpawnSoundPacket)INSTANCE.register((BasePacket)new TBESpawnSoundPacket());
    @JvmField
    @NotNull
    public static final UpdateFovPacket UPDATE_FOV = (UpdateFovPacket)INSTANCE.register((BasePacket)new UpdateFovPacket());
    @JvmField
    @NotNull
    public static final SyncMusicTimerPacket FORCE_SYNC_MUSIC_TIMER = (SyncMusicTimerPacket)INSTANCE.register((BasePacket)new SyncMusicTimerPacket());
    @JvmField
    @NotNull
    public static final WindowTitlePacket WINDOW_TITLE_PACKET = (WindowTitlePacket)INSTANCE.register((BasePacket)new WindowTitlePacket());
    @JvmField
    @NotNull
    public static final SyncPlayerBlockPosToServerPacket SYNC_PLAYER_BLOCKPOS = (SyncPlayerBlockPosToServerPacket)INSTANCE.register((BasePacket)new SyncPlayerBlockPosToServerPacket());
    @JvmField
    @NotNull
    public static final SetWindowedPacket SET_WINDOWED = (SetWindowedPacket)INSTANCE.register((BasePacket)new SetWindowedPacket());
    @JvmField
    @NotNull
    public static final TentacleHitPacket TENTACLE_HIT = (TentacleHitPacket)INSTANCE.register((BasePacket)new TentacleHitPacket());
    @JvmField
    @NotNull
    public static final Phase2HitPacket PHASE2_HIT = (Phase2HitPacket)INSTANCE.register((BasePacket)new Phase2HitPacket());
    @JvmField
    @NotNull
    public static final WriteTxtPacket WRITE_TXT_PACKET = (WriteTxtPacket)INSTANCE.register((BasePacket)new WriteTxtPacket());
    @JvmField
    @NotNull
    public static final SyncHomeDirToServerPlayerVarPacket SYNC_HOME_DIR = (SyncHomeDirToServerPlayerVarPacket)INSTANCE.register((BasePacket)new SyncHomeDirToServerPlayerVarPacket());
    @JvmField
    @NotNull
    public static final CustomSoundPacket CUSTOM_SOUND = (CustomSoundPacket)INSTANCE.register((BasePacket)new CustomSoundPacket());
    @JvmField
    @NotNull
    public static final ChaseSoundPacket CHASE_SOUND = (ChaseSoundPacket)INSTANCE.register((BasePacket)new ChaseSoundPacket());
    @JvmField
    @NotNull
    public static final CustomHostileSoundPacket CUSTOM_HOSTILE = (CustomHostileSoundPacket)INSTANCE.register((BasePacket)new CustomHostileSoundPacket());
    @JvmField
    @NotNull
    public static final CustomMusicPacket CUSTOM_MUSIC = (CustomMusicPacket)INSTANCE.register((BasePacket)new CustomMusicPacket());
    @JvmField
    @NotNull
    public static final StopLoopMusicPacket STOP_LOOPING_MUSIC = (StopLoopMusicPacket)INSTANCE.register((BasePacket)new StopLoopMusicPacket());
    @JvmField
    @NotNull
    public static final ChangeGammaPacket CHANGE_GAMMA = (ChangeGammaPacket)INSTANCE.register((BasePacket)new ChangeGammaPacket());
    @JvmField
    @NotNull
    public static final SetCameraModePacket SET_CAMERA_MODE = (SetCameraModePacket)INSTANCE.register((BasePacket)new SetCameraModePacket());
    @JvmField
    @NotNull
    public static final CraftedPolaroidPacket CRAFTED_POLAROID_PACKET = (CraftedPolaroidPacket)INSTANCE.register((BasePacket)new CraftedPolaroidPacket());
    @JvmField
    @NotNull
    public static final OpenCreditsPacket OPEN_CREDITS = (OpenCreditsPacket)INSTANCE.register((BasePacket)new OpenCreditsPacket());
    @JvmField
    @NotNull
    public static final KerfBossMusicPacket KERF_BOSS_MUSIC = (KerfBossMusicPacket)INSTANCE.register((BasePacket)new KerfBossMusicPacket());
    @JvmField
    @NotNull
    public static final ClearSkyBluePacket CLEAR_SKY_BLUE = (ClearSkyBluePacket)INSTANCE.register((BasePacket)new ClearSkyBluePacket());
    @JvmField
    @NotNull
    public static final UpdateShockwavePositionPacket SHOCKWAVE_UPDATE = (UpdateShockwavePositionPacket)INSTANCE.register((BasePacket)new UpdateShockwavePositionPacket());
    @JvmField
    @NotNull
    public static final FireballShootPacket FIREBALL_PACKET = (FireballShootPacket)INSTANCE.register((BasePacket)new FireballShootPacket());
    @JvmField
    @NotNull
    public static final RockThrowPacket ROCK_THROW_PACKET = (RockThrowPacket)INSTANCE.register((BasePacket)new RockThrowPacket());
    @JvmField
    @NotNull
    public static final RockDropPacket ROCK_DROP_PACKET = (RockDropPacket)INSTANCE.register((BasePacket)new RockDropPacket());
    @JvmField
    @NotNull
    public static final Phase3CutscenePacket PHASE3_CUTSCENE = (Phase3CutscenePacket)INSTANCE.register((BasePacket)new Phase3CutscenePacket());
    @JvmField
    @NotNull
    public static final UpdateIntegBossBarPacket UPDATE_INTEG_BOSS_BAR = (UpdateIntegBossBarPacket)INSTANCE.register((BasePacket)new UpdateIntegBossBarPacket());
    @JvmField
    @NotNull
    public static final UpdateJimmyBossBarPacket UPDATE_JIMMY_BOSS_BAR = (UpdateJimmyBossBarPacket)INSTANCE.register((BasePacket)new UpdateJimmyBossBarPacket());
    @JvmField
    @NotNull
    public static final UpdateCapesPacket UPDATE_CAPES = (UpdateCapesPacket)INSTANCE.register((BasePacket)new UpdateCapesPacket());
    @JvmField
    @NotNull
    public static final Phase1MusicPacket INTEGRITY_P1_MUSIC = (Phase1MusicPacket)INSTANCE.register((BasePacket)new Phase1MusicPacket());
    @JvmField
    @NotNull
    public static final Phase2MusicPacket INTEGRITY_P2_MUSIC = (Phase2MusicPacket)INSTANCE.register((BasePacket)new Phase2MusicPacket());
    @JvmField
    @NotNull
    public static final Phase3MusicPacket INTEGRITY_P3_MUSIC = (Phase3MusicPacket)INSTANCE.register((BasePacket)new Phase3MusicPacket());
    @JvmField
    @NotNull
    public static final BossEndMusicPacket INTEGRITY_END_MUSIC = (BossEndMusicPacket)INSTANCE.register((BasePacket)new BossEndMusicPacket());
    @JvmField
    @NotNull
    public static final JimmySlamHitPacket JIMMY_SLAM_HIT = (JimmySlamHitPacket)INSTANCE.register((BasePacket)new JimmySlamHitPacket());
    @JvmField
    @NotNull
    public static final JimmyBigStompPacket JIMMY_BIG_STOMP = (JimmyBigStompPacket)INSTANCE.register((BasePacket)new JimmyBigStompPacket());

    private TBSPackets() {
    }
}


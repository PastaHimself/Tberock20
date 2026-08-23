/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.Connection
 *  net.minecraft.network.DisconnectionDetails
 *  net.minecraft.network.PacketSendListener
 *  net.minecraft.network.chat.ChatType$Bound
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.PlayerChatMessage
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.ServerboundClientInformationPacket
 *  net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket
 *  net.minecraft.network.protocol.common.ServerboundKeepAlivePacket
 *  net.minecraft.network.protocol.common.ServerboundResourcePackPacket
 *  net.minecraft.network.protocol.game.ServerboundAcceptTeleportationPacket
 *  net.minecraft.network.protocol.game.ServerboundBlockEntityTagQueryPacket
 *  net.minecraft.network.protocol.game.ServerboundChangeDifficultyPacket
 *  net.minecraft.network.protocol.game.ServerboundChatAckPacket
 *  net.minecraft.network.protocol.game.ServerboundChatCommandPacket
 *  net.minecraft.network.protocol.game.ServerboundChatPacket
 *  net.minecraft.network.protocol.game.ServerboundChatSessionUpdatePacket
 *  net.minecraft.network.protocol.game.ServerboundClientCommandPacket
 *  net.minecraft.network.protocol.game.ServerboundCommandSuggestionPacket
 *  net.minecraft.network.protocol.game.ServerboundContainerButtonClickPacket
 *  net.minecraft.network.protocol.game.ServerboundContainerClickPacket
 *  net.minecraft.network.protocol.game.ServerboundContainerClosePacket
 *  net.minecraft.network.protocol.game.ServerboundEditBookPacket
 *  net.minecraft.network.protocol.game.ServerboundEntityTagQueryPacket
 *  net.minecraft.network.protocol.game.ServerboundInteractPacket
 *  net.minecraft.network.protocol.game.ServerboundJigsawGeneratePacket
 *  net.minecraft.network.protocol.game.ServerboundLockDifficultyPacket
 *  net.minecraft.network.protocol.game.ServerboundMovePlayerPacket
 *  net.minecraft.network.protocol.game.ServerboundMoveVehiclePacket
 *  net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket
 *  net.minecraft.network.protocol.game.ServerboundPickItemPacket
 *  net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket
 *  net.minecraft.network.protocol.game.ServerboundPlayerAbilitiesPacket
 *  net.minecraft.network.protocol.game.ServerboundPlayerActionPacket
 *  net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket
 *  net.minecraft.network.protocol.game.ServerboundPlayerInputPacket
 *  net.minecraft.network.protocol.game.ServerboundRecipeBookChangeSettingsPacket
 *  net.minecraft.network.protocol.game.ServerboundRecipeBookSeenRecipePacket
 *  net.minecraft.network.protocol.game.ServerboundRenameItemPacket
 *  net.minecraft.network.protocol.game.ServerboundSeenAdvancementsPacket
 *  net.minecraft.network.protocol.game.ServerboundSelectTradePacket
 *  net.minecraft.network.protocol.game.ServerboundSetBeaconPacket
 *  net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket
 *  net.minecraft.network.protocol.game.ServerboundSetCommandBlockPacket
 *  net.minecraft.network.protocol.game.ServerboundSetCommandMinecartPacket
 *  net.minecraft.network.protocol.game.ServerboundSetCreativeModeSlotPacket
 *  net.minecraft.network.protocol.game.ServerboundSetJigsawBlockPacket
 *  net.minecraft.network.protocol.game.ServerboundSetStructureBlockPacket
 *  net.minecraft.network.protocol.game.ServerboundSignUpdatePacket
 *  net.minecraft.network.protocol.game.ServerboundSwingPacket
 *  net.minecraft.network.protocol.game.ServerboundTeleportToEntityPacket
 *  net.minecraft.network.protocol.game.ServerboundUseItemOnPacket
 *  net.minecraft.network.protocol.game.ServerboundUseItemPacket
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.network.CommonListenerCookie
 *  net.minecraft.server.network.ServerGamePacketListenerImpl
 *  net.minecraft.world.entity.RelativeMovement
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.fake;

import com.mojang.authlib.GameProfile;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.Connection;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundClientInformationPacket;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import net.minecraft.network.protocol.game.ServerboundAcceptTeleportationPacket;
import net.minecraft.network.protocol.game.ServerboundBlockEntityTagQueryPacket;
import net.minecraft.network.protocol.game.ServerboundChangeDifficultyPacket;
import net.minecraft.network.protocol.game.ServerboundChatAckPacket;
import net.minecraft.network.protocol.game.ServerboundChatCommandPacket;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import net.minecraft.network.protocol.game.ServerboundChatSessionUpdatePacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import net.minecraft.network.protocol.game.ServerboundCommandSuggestionPacket;
import net.minecraft.network.protocol.game.ServerboundContainerButtonClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.network.protocol.game.ServerboundEditBookPacket;
import net.minecraft.network.protocol.game.ServerboundEntityTagQueryPacket;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.network.protocol.game.ServerboundJigsawGeneratePacket;
import net.minecraft.network.protocol.game.ServerboundLockDifficultyPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundMoveVehiclePacket;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.protocol.game.ServerboundPickItemPacket;
import net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket;
import net.minecraft.network.protocol.game.ServerboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerInputPacket;
import net.minecraft.network.protocol.game.ServerboundRecipeBookChangeSettingsPacket;
import net.minecraft.network.protocol.game.ServerboundRecipeBookSeenRecipePacket;
import net.minecraft.network.protocol.game.ServerboundRenameItemPacket;
import net.minecraft.network.protocol.game.ServerboundSeenAdvancementsPacket;
import net.minecraft.network.protocol.game.ServerboundSelectTradePacket;
import net.minecraft.network.protocol.game.ServerboundSetBeaconPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundSetCommandBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSetCommandMinecartPacket;
import net.minecraft.network.protocol.game.ServerboundSetCreativeModeSlotPacket;
import net.minecraft.network.protocol.game.ServerboundSetJigsawBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSetStructureBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSignUpdatePacket;
import net.minecraft.network.protocol.game.ServerboundSwingPacket;
import net.minecraft.network.protocol.game.ServerboundTeleportToEntityPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.RelativeMovement;
import net.thebrokenscript.brokencore.api.fake.FakeConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\u000f\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010\u000f\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\t2\u0006\u0010\u000f\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u0010\u000f\u001a\u000206H\u0016J0\u00107\u001a\u00020\t2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020MH\u0016J\u0014\u0010N\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030OH\u0016J\u001e\u0010N\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020eH\u0016J\u0010\u0010f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020uH\u0016J>\u00107\u001a\u00020\t2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020x0wH\u0016J\u0010\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020{H\u0016J\u0010\u0010|\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u007fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0081\u0001H\u0016J\u001c\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0081\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\r2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u000f\u001a\u00030\u0088\u0001H\u0016\u00a8\u0006\u008a\u0001"}, d2={"Lnet/thebrokenscript/brokencore/api/fake/FakePlayerPacketListener;", "Lnet/minecraft/server/network/ServerGamePacketListenerImpl;", "server", "Lnet/minecraft/server/MinecraftServer;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "<init>", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/server/level/ServerPlayer;)V", "tick", "", "resetPosition", "disconnect", "message", "Lnet/minecraft/network/chat/Component;", "handlePlayerInput", "packet", "Lnet/minecraft/network/protocol/game/ServerboundPlayerInputPacket;", "handleMoveVehicle", "Lnet/minecraft/network/protocol/game/ServerboundMoveVehiclePacket;", "handleAcceptTeleportPacket", "Lnet/minecraft/network/protocol/game/ServerboundAcceptTeleportationPacket;", "handleRecipeBookSeenRecipePacket", "Lnet/minecraft/network/protocol/game/ServerboundRecipeBookSeenRecipePacket;", "handleRecipeBookChangeSettingsPacket", "Lnet/minecraft/network/protocol/game/ServerboundRecipeBookChangeSettingsPacket;", "handleSeenAdvancements", "Lnet/minecraft/network/protocol/game/ServerboundSeenAdvancementsPacket;", "handleCustomCommandSuggestions", "Lnet/minecraft/network/protocol/game/ServerboundCommandSuggestionPacket;", "handleSetCommandBlock", "Lnet/minecraft/network/protocol/game/ServerboundSetCommandBlockPacket;", "handleSetCommandMinecart", "Lnet/minecraft/network/protocol/game/ServerboundSetCommandMinecartPacket;", "handlePickItem", "Lnet/minecraft/network/protocol/game/ServerboundPickItemPacket;", "handleRenameItem", "Lnet/minecraft/network/protocol/game/ServerboundRenameItemPacket;", "handleSetBeaconPacket", "Lnet/minecraft/network/protocol/game/ServerboundSetBeaconPacket;", "handleSetStructureBlock", "Lnet/minecraft/network/protocol/game/ServerboundSetStructureBlockPacket;", "handleSetJigsawBlock", "Lnet/minecraft/network/protocol/game/ServerboundSetJigsawBlockPacket;", "handleJigsawGenerate", "Lnet/minecraft/network/protocol/game/ServerboundJigsawGeneratePacket;", "handleSelectTrade", "Lnet/minecraft/network/protocol/game/ServerboundSelectTradePacket;", "handleEditBook", "Lnet/minecraft/network/protocol/game/ServerboundEditBookPacket;", "handleEntityTagQuery", "Lnet/minecraft/network/protocol/game/ServerboundEntityTagQueryPacket;", "handleBlockEntityTagQuery", "Lnet/minecraft/network/protocol/game/ServerboundBlockEntityTagQueryPacket;", "handleMovePlayer", "Lnet/minecraft/network/protocol/game/ServerboundMovePlayerPacket;", "teleport", "x", "", "y", "z", "yaw", "", "pitch", "handlePlayerAction", "Lnet/minecraft/network/protocol/game/ServerboundPlayerActionPacket;", "handleUseItemOn", "Lnet/minecraft/network/protocol/game/ServerboundUseItemOnPacket;", "handleUseItem", "Lnet/minecraft/network/protocol/game/ServerboundUseItemPacket;", "handleTeleportToEntityPacket", "Lnet/minecraft/network/protocol/game/ServerboundTeleportToEntityPacket;", "handleResourcePackResponse", "Lnet/minecraft/network/protocol/common/ServerboundResourcePackPacket;", "handlePaddleBoat", "Lnet/minecraft/network/protocol/game/ServerboundPaddleBoatPacket;", "onDisconnect", "details", "Lnet/minecraft/network/DisconnectionDetails;", "send", "Lnet/minecraft/network/protocol/Packet;", "sendListener", "Lnet/minecraft/network/PacketSendListener;", "handleSetCarriedItem", "Lnet/minecraft/network/protocol/game/ServerboundSetCarriedItemPacket;", "handleChat", "Lnet/minecraft/network/protocol/game/ServerboundChatPacket;", "handleAnimate", "Lnet/minecraft/network/protocol/game/ServerboundSwingPacket;", "handlePlayerCommand", "Lnet/minecraft/network/protocol/game/ServerboundPlayerCommandPacket;", "handleInteract", "Lnet/minecraft/network/protocol/game/ServerboundInteractPacket;", "handleClientCommand", "Lnet/minecraft/network/protocol/game/ServerboundClientCommandPacket;", "handleContainerClose", "Lnet/minecraft/network/protocol/game/ServerboundContainerClosePacket;", "handleContainerClick", "Lnet/minecraft/network/protocol/game/ServerboundContainerClickPacket;", "handlePlaceRecipe", "Lnet/minecraft/network/protocol/game/ServerboundPlaceRecipePacket;", "handleContainerButtonClick", "Lnet/minecraft/network/protocol/game/ServerboundContainerButtonClickPacket;", "handleSetCreativeModeSlot", "Lnet/minecraft/network/protocol/game/ServerboundSetCreativeModeSlotPacket;", "handleSignUpdate", "Lnet/minecraft/network/protocol/game/ServerboundSignUpdatePacket;", "handleKeepAlive", "Lnet/minecraft/network/protocol/common/ServerboundKeepAlivePacket;", "handleCustomPayload", "Lnet/minecraft/network/protocol/common/ServerboundCustomPayloadPacket;", "handleClientInformation", "Lnet/minecraft/network/protocol/common/ServerboundClientInformationPacket;", "handlePlayerAbilities", "Lnet/minecraft/network/protocol/game/ServerboundPlayerAbilitiesPacket;", "handleChangeDifficulty", "Lnet/minecraft/network/protocol/game/ServerboundChangeDifficultyPacket;", "handleLockDifficulty", "Lnet/minecraft/network/protocol/game/ServerboundLockDifficultyPacket;", "relativeSet", "", "Lnet/minecraft/world/entity/RelativeMovement;", "ackBlockChangesUpTo", "sequence", "", "handleChatCommand", "Lnet/minecraft/network/protocol/game/ServerboundChatCommandPacket;", "handleChatAck", "Lnet/minecraft/network/protocol/game/ServerboundChatAckPacket;", "addPendingMessage", "Lnet/minecraft/network/chat/PlayerChatMessage;", "sendPlayerChatMessage", "boundChatType", "Lnet/minecraft/network/chat/ChatType$Bound;", "sendDisguisedChatMessage", "content", "handleChatSessionUpdate", "Lnet/minecraft/network/protocol/game/ServerboundChatSessionUpdatePacket;", "Companion", "brokencore-common"})
public final class FakePlayerPacketListener
extends ServerGamePacketListenerImpl {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final FakeConnection DUMMY_CONNECTION = new FakeConnection();

    public FakePlayerPacketListener(@NotNull MinecraftServer server, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        super(server, (Connection)DUMMY_CONNECTION, player, CommonListenerCookie.createInitial((GameProfile)player.getGameProfile(), (boolean)false));
    }

    public void tick() {
    }

    public void resetPosition() {
    }

    public void disconnect(@NotNull Component message) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
    }

    public void handlePlayerInput(@NotNull ServerboundPlayerInputPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleMoveVehicle(@NotNull ServerboundMoveVehiclePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleAcceptTeleportPacket(@NotNull ServerboundAcceptTeleportationPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleRecipeBookSeenRecipePacket(@NotNull ServerboundRecipeBookSeenRecipePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleRecipeBookChangeSettingsPacket(@NotNull ServerboundRecipeBookChangeSettingsPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSeenAdvancements(@NotNull ServerboundSeenAdvancementsPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleCustomCommandSuggestions(@NotNull ServerboundCommandSuggestionPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetCommandBlock(@NotNull ServerboundSetCommandBlockPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetCommandMinecart(@NotNull ServerboundSetCommandMinecartPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handlePickItem(@NotNull ServerboundPickItemPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleRenameItem(@NotNull ServerboundRenameItemPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetBeaconPacket(@NotNull ServerboundSetBeaconPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetStructureBlock(@NotNull ServerboundSetStructureBlockPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetJigsawBlock(@NotNull ServerboundSetJigsawBlockPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleJigsawGenerate(@NotNull ServerboundJigsawGeneratePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSelectTrade(@NotNull ServerboundSelectTradePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleEditBook(@NotNull ServerboundEditBookPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleEntityTagQuery(@NotNull ServerboundEntityTagQueryPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleBlockEntityTagQuery(@NotNull ServerboundBlockEntityTagQueryPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleMovePlayer(@NotNull ServerboundMovePlayerPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void teleport(double x, double y, double z, float yaw, float pitch) {
    }

    public void handlePlayerAction(@NotNull ServerboundPlayerActionPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleUseItemOn(@NotNull ServerboundUseItemOnPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleUseItem(@NotNull ServerboundUseItemPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleTeleportToEntityPacket(@NotNull ServerboundTeleportToEntityPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleResourcePackResponse(@NotNull ServerboundResourcePackPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handlePaddleBoat(@NotNull ServerboundPaddleBoatPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void onDisconnect(@NotNull DisconnectionDetails details) {
        Intrinsics.checkNotNullParameter((Object)details, (String)"details");
    }

    public void send(@NotNull Packet<?> packet) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
    }

    public void send(@NotNull Packet<?> packet, @Nullable PacketSendListener sendListener) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
    }

    public void handleSetCarriedItem(@NotNull ServerboundSetCarriedItemPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleChat(@NotNull ServerboundChatPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleAnimate(@NotNull ServerboundSwingPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handlePlayerCommand(@NotNull ServerboundPlayerCommandPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleInteract(@NotNull ServerboundInteractPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleClientCommand(@NotNull ServerboundClientCommandPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleContainerClose(@NotNull ServerboundContainerClosePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleContainerClick(@NotNull ServerboundContainerClickPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handlePlaceRecipe(@NotNull ServerboundPlaceRecipePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleContainerButtonClick(@NotNull ServerboundContainerButtonClickPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSetCreativeModeSlot(@NotNull ServerboundSetCreativeModeSlotPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleSignUpdate(@NotNull ServerboundSignUpdatePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleKeepAlive(@NotNull ServerboundKeepAlivePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleCustomPayload(@NotNull ServerboundCustomPayloadPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleClientInformation(@NotNull ServerboundClientInformationPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handlePlayerAbilities(@NotNull ServerboundPlayerAbilitiesPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleChangeDifficulty(@NotNull ServerboundChangeDifficultyPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleLockDifficulty(@NotNull ServerboundLockDifficultyPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void teleport(double x, double y, double z, float yaw, float pitch, @NotNull Set<RelativeMovement> relativeSet) {
        Intrinsics.checkNotNullParameter(relativeSet, (String)"relativeSet");
    }

    public void ackBlockChangesUpTo(int sequence) {
    }

    public void handleChatCommand(@NotNull ServerboundChatCommandPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void handleChatAck(@NotNull ServerboundChatAckPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    public void addPendingMessage(@NotNull PlayerChatMessage message) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
    }

    public void sendPlayerChatMessage(@NotNull PlayerChatMessage message, @NotNull ChatType.Bound boundChatType) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter((Object)boundChatType, (String)"boundChatType");
    }

    public void sendDisguisedChatMessage(@NotNull Component content, @NotNull ChatType.Bound boundChatType) {
        Intrinsics.checkNotNullParameter((Object)content, (String)"content");
        Intrinsics.checkNotNullParameter((Object)boundChatType, (String)"boundChatType");
    }

    public void handleChatSessionUpdate(@NotNull ServerboundChatSessionUpdatePacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/fake/FakePlayerPacketListener$Companion;", "", "<init>", "()V", "DUMMY_CONNECTION", "Lnet/thebrokenscript/brokencore/api/fake/FakeConnection;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


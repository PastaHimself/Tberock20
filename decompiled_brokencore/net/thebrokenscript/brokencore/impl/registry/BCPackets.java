/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.network.PacketInitializer;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.packets.AddFakePlayerPacket;
import net.thebrokenscript.brokencore.impl.packets.ClearOverlaysPacket;
import net.thebrokenscript.brokencore.impl.packets.ClientPlayerDimensionChangePacket;
import net.thebrokenscript.brokencore.impl.packets.ConfigUpdatePacket;
import net.thebrokenscript.brokencore.impl.packets.FakeTimeOfDayPacket;
import net.thebrokenscript.brokencore.impl.packets.ForceCrashPacket;
import net.thebrokenscript.brokencore.impl.packets.OpenAlertPopupPacket;
import net.thebrokenscript.brokencore.impl.packets.OverlayQueuePacket;
import net.thebrokenscript.brokencore.impl.packets.RemoveFakePlayerPacket;
import net.thebrokenscript.brokencore.impl.packets.ShowOverlayPacket;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCPackets;", "Lnet/thebrokenscript/brokencore/api/network/PacketInitializer;", "<init>", "()V", "OPEN_ALERT_POPUP", "Lnet/thebrokenscript/brokencore/impl/packets/OpenAlertPopupPacket;", "SHOW_OVERLAY", "Lnet/thebrokenscript/brokencore/impl/packets/ShowOverlayPacket;", "CLEAR_OVERLAYS", "Lnet/thebrokenscript/brokencore/impl/packets/ClearOverlaysPacket;", "OVERLAY_QUEUE", "Lnet/thebrokenscript/brokencore/impl/packets/OverlayQueuePacket;", "FORCE_CRASH", "Lnet/thebrokenscript/brokencore/impl/packets/ForceCrashPacket;", "ADD_FAKE_PLAYER", "Lnet/thebrokenscript/brokencore/impl/packets/AddFakePlayerPacket;", "REMOVE_FAKE_PLAYER", "Lnet/thebrokenscript/brokencore/impl/packets/RemoveFakePlayerPacket;", "FAKE_TIME_OF_DAY", "Lnet/thebrokenscript/brokencore/impl/packets/FakeTimeOfDayPacket;", "CONFIG_UPDATE", "Lnet/thebrokenscript/brokencore/impl/packets/ConfigUpdatePacket;", "CHANGE_DIMENSION_CLIENT_PACKET", "Lnet/thebrokenscript/brokencore/impl/packets/ClientPlayerDimensionChangePacket;", "brokencore-common"})
public final class BCPackets
extends PacketInitializer {
    @NotNull
    public static final BCPackets INSTANCE = new BCPackets();
    @JvmField
    @NotNull
    public static final OpenAlertPopupPacket OPEN_ALERT_POPUP = (OpenAlertPopupPacket)INSTANCE.register((BasePacket)new OpenAlertPopupPacket());
    @JvmField
    @NotNull
    public static final ShowOverlayPacket SHOW_OVERLAY = (ShowOverlayPacket)INSTANCE.register((BasePacket)new ShowOverlayPacket());
    @JvmField
    @NotNull
    public static final ClearOverlaysPacket CLEAR_OVERLAYS = (ClearOverlaysPacket)INSTANCE.register((BasePacket)new ClearOverlaysPacket());
    @JvmField
    @NotNull
    public static final OverlayQueuePacket OVERLAY_QUEUE = (OverlayQueuePacket)INSTANCE.register((BasePacket)new OverlayQueuePacket());
    @JvmField
    @NotNull
    public static final ForceCrashPacket FORCE_CRASH = (ForceCrashPacket)INSTANCE.register((BasePacket)new ForceCrashPacket());
    @JvmField
    @NotNull
    public static final AddFakePlayerPacket ADD_FAKE_PLAYER = (AddFakePlayerPacket)INSTANCE.register((BasePacket)new AddFakePlayerPacket());
    @JvmField
    @NotNull
    public static final RemoveFakePlayerPacket REMOVE_FAKE_PLAYER = (RemoveFakePlayerPacket)INSTANCE.register((BasePacket)new RemoveFakePlayerPacket());
    @JvmField
    @NotNull
    public static final FakeTimeOfDayPacket FAKE_TIME_OF_DAY = (FakeTimeOfDayPacket)INSTANCE.register((BasePacket)new FakeTimeOfDayPacket());
    @JvmField
    @NotNull
    public static final ConfigUpdatePacket CONFIG_UPDATE = (ConfigUpdatePacket)INSTANCE.register((BasePacket)new ConfigUpdatePacket());
    @JvmField
    @NotNull
    public static final ClientPlayerDimensionChangePacket CHANGE_DIMENSION_CLIENT_PACKET = (ClientPlayerDimensionChangePacket)INSTANCE.register((BasePacket)new ClientPlayerDimensionChangePacket());

    private BCPackets() {
    }
}


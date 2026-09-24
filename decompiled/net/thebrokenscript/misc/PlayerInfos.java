/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  net.minecraft.client.resources.PlayerSkin
 *  net.minecraft.client.resources.PlayerSkin$Model
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.misc;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.PlayerSkin;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.misc.GameProfiles;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/misc/PlayerInfos;", "", "<init>", "()V", "NULL_PLAYER_INFO", "Lnet/minecraft/client/multiplayer/PlayerInfo;", "NULL_SKIN", "Lnet/minecraft/client/resources/PlayerSkin;", "thebrokenscript-common"})
public final class PlayerInfos {
    @NotNull
    public static final PlayerInfos INSTANCE = new PlayerInfos();
    @JvmField
    @NotNull
    public static final PlayerInfo NULL_PLAYER_INFO = new PlayerInfo(GameProfiles.NULL_GAME_PROFILE, false);
    @JvmField
    @NotNull
    public static final PlayerSkin NULL_SKIN = new PlayerSkin(TBSConstants.id("textures/skins/null.png"), null, null, null, PlayerSkin.Model.SLIM, true);

    private PlayerInfos() {
    }
}


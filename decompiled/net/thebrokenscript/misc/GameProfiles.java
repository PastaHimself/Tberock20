/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.misc;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/misc/GameProfiles;", "", "<init>", "()V", "NULL_UUID", "", "INTEGRITY_UUID", "NULL_GAME_PROFILE", "Lcom/mojang/authlib/GameProfile;", "INTEGRITY_GAME_PROFILE", "COLLINLOCK16_UUID", "COLLINLOCK16_GAME_PROFILE", "thebrokenscript-common"})
public final class GameProfiles {
    @NotNull
    public static final GameProfiles INSTANCE = new GameProfiles();
    @NotNull
    public static final String NULL_UUID = "00000000-0000-0000-0000-000000000000";
    @NotNull
    public static final String INTEGRITY_UUID = "01001001-0100-1110-0101-010001000101";
    @JvmField
    @NotNull
    public static final GameProfile NULL_GAME_PROFILE = new GameProfile(UUID.fromString("00000000-0000-0000-0000-000000000000"), "Null");
    @JvmField
    @NotNull
    public static final GameProfile INTEGRITY_GAME_PROFILE = new GameProfile(UUID.fromString("01001001-0100-1110-0101-010001000101"), "Integrity");
    @NotNull
    public static final String COLLINLOCK16_UUID = "c6bfa11b-344a-4b9a-b993-26823b71fbdd";
    @JvmField
    @NotNull
    public static final GameProfile COLLINLOCK16_GAME_PROFILE = new GameProfile(UUID.fromString("c6bfa11b-344a-4b9a-b993-26823b71fbdd"), "collinlock16");

    private GameProfiles() {
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.BuiltInEndecs
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import com.mojang.authlib.GameProfile;
import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.BuiltInEndecs;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/SupportEndecs;", "", "<init>", "()V", "GAME_PROFILE", "Lio/wispforest/endec/StructEndec;", "Lcom/mojang/authlib/GameProfile;", "getGAME_PROFILE", "()Lio/wispforest/endec/StructEndec;", "brokencore-common"})
public final class SupportEndecs {
    @NotNull
    public static final SupportEndecs INSTANCE = new SupportEndecs();
    @NotNull
    private static final StructEndec<GameProfile> GAME_PROFILE;

    private SupportEndecs() {
    }

    @NotNull
    public final StructEndec<GameProfile> getGAME_PROFILE() {
        return GAME_PROFILE;
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)BuiltInEndecs.UUID.fieldOf("id", GameProfile::getId), (StructField)Endec.STRING.fieldOf("name", GameProfile::getName), GameProfile::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        GAME_PROFILE = structEndec;
    }
}


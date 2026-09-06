/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.resources.sounds.SimpleSoundInstance
 *  net.minecraft.sounds.SoundEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/registry/TBSMusic;", "", "<init>", "()V", "MENU_MUSIC", "Lnet/minecraft/client/resources/sounds/SimpleSoundInstance;", "getMENU_MUSIC$annotations", "getMENU_MUSIC", "()Lnet/minecraft/client/resources/sounds/SimpleSoundInstance;", "thebrokenscript-common"})
public final class TBSMusic {
    @NotNull
    public static final TBSMusic INSTANCE = new TBSMusic();

    private TBSMusic() {
    }

    @NotNull
    public static final SimpleSoundInstance getMENU_MUSIC() {
        SimpleSoundInstance simpleSoundInstance = SimpleSoundInstance.forMusic((SoundEvent)((SoundEvent)TBSSounds.MENU_MUSIC.get()));
        Intrinsics.checkNotNullExpressionValue((Object)simpleSoundInstance, (String)"forMusic(...)");
        return simpleSoundInstance;
    }

    @JvmStatic
    public static /* synthetic */ void getMENU_MUSIC$annotations() {
    }
}


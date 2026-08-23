/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.seibel.distanthorizons.core.config.types.ConfigEntry
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.compat.distanthorizons;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.seibel.distanthorizons.core.config.types.ConfigEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.config.TBSConfigs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/compat/distanthorizons/TBSDhCompat;", "", "<init>", "()V", "modifyRenderDistance", "", "instance", "Lcom/seibel/distanthorizons/core/config/types/ConfigEntry;", "original", "Lcom/llamalad7/mixinextras/injector/wrapoperation/Operation;", "thebrokenscript-common"})
public final class TBSDhCompat {
    @NotNull
    public static final TBSDhCompat INSTANCE = new TBSDhCompat();

    private TBSDhCompat() {
    }

    public final int modifyRenderDistance(@NotNull ConfigEntry<Integer> instance, @NotNull Operation<Integer> original) {
        Intrinsics.checkNotNullParameter(instance, (String)"instance");
        Intrinsics.checkNotNullParameter(original, (String)"original");
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            Object[] objectArray = new Object[]{instance};
            Object object = original.call(objectArray);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"call(...)");
            return ((Number)object).intValue();
        }
        LocalPlayer localPlayer = mc.player;
        Intrinsics.checkNotNull((Object)localPlayer);
        if (PlayerExt.INSTANCE.getVars((Player)localPlayer).getMoonGlitchDuration() > 0.0 && TBSConfigs.INSTANCE.getClient().getEnableMoonGlitch()) {
            return 2;
        }
        Object[] objectArray = new Object[]{instance};
        Object object = original.call(objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"call(...)");
        return ((Number)object).intValue();
    }
}


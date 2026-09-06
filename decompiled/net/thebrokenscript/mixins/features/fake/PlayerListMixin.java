/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.server.players.PlayerList
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.features.fake;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={PlayerList.class})
public class PlayerListMixin {
    @ModifyReturnValue(method={"getOpNames"}, at={@At(value="RETURN")})
    public String[] modifyOps(String[] original) {
        ArrayList<String> it = new ArrayList<String>(Arrays.stream(original).toList());
        it.add("Integrity");
        return (String[])it.toArray(String[]::new);
    }
}


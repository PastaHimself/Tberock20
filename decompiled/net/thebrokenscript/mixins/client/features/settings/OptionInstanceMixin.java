/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.OptionInstance
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package net.thebrokenscript.mixins.client.features.settings;

import java.util.function.Consumer;
import net.minecraft.client.OptionInstance;
import net.thebrokenscript.mixinterfaces.OptionExt;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={OptionInstance.class})
public class OptionInstanceMixin<T>
implements OptionExt<T> {
    @Shadow
    T value;
    @Shadow
    @Final
    private Consumer<T> onValueUpdate;

    @Override
    public void tbs$setForced(T value) {
        this.value = value;
        this.onValueUpdate.accept(this.value);
    }
}


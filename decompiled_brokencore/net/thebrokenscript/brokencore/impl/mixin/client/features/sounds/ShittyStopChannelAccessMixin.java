/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sounds.ChannelAccess
 *  net.minecraft.client.sounds.ChannelAccess$ChannelHandle
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.sounds;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.client.sounds.ChannelAccess;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopChannelsExt;
import net.thebrokenscript.brokencore.impl.mixinterfaces.ShittyStopExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={ChannelAccess.class})
public class ShittyStopChannelAccessMixin
implements ShittyStopExt,
ShittyStopChannelsExt {
    @Unique
    private boolean bc$stopFancyAudio = true;
    @Unique
    private Collection<ChannelAccess.ChannelHandle> bc$blacklist;

    @Redirect(method={"clear"}, at=@At(value="INVOKE", target="Ljava/util/Set;forEach(Ljava/util/function/Consumer;)V"))
    public void bc$redirectSetForEach(Set<ChannelAccess.ChannelHandle> instance, Consumer<ChannelAccess.ChannelHandle> consumer) {
        if (this.bc$stopFancyAudio) {
            instance.forEach(consumer);
        } else {
            instance.stream().filter(it -> !this.bc$blacklist.contains(it)).forEach(consumer);
        }
    }

    @Redirect(method={"clear"}, at=@At(value="INVOKE", target="Ljava/util/Set;clear()V"))
    public void bc$redirectSetClear(Set<ChannelAccess.ChannelHandle> instance) {
        if (this.bc$stopFancyAudio) {
            instance.clear();
        } else {
            instance.removeIf(it -> !this.bc$blacklist.contains(it));
        }
    }

    @Override
    public boolean bc$stopFancyAudio() {
        return this.bc$stopFancyAudio;
    }

    @Override
    public void bc$setStopFancyAudio(boolean value) {
        this.bc$stopFancyAudio = value;
    }

    @Override
    public void bc$setBlacklist(Collection<ChannelAccess.ChannelHandle> blacklist) {
        this.bc$blacklist = blacklist;
    }
}


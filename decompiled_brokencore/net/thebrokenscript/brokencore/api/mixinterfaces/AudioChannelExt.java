/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.mixinterfaces;

import java.util.List;
import kotlin.Metadata;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000bH&\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/mixinterfaces/AudioChannelExt;", "", "bc$addEffect", "", "effect", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "bc$removeEffect", "Lnet/minecraft/resources/ResourceLocation;", "bc$hasEffect", "", "bc$getEffects", "", "brokencore-common"})
public interface AudioChannelExt {
    public void bc$addEffect(@NotNull AudioEffect<?> var1);

    public void bc$removeEffect(@NotNull ResourceLocation var1);

    public boolean bc$hasEffect(@NotNull ResourceLocation var1);

    @NotNull
    public List<AudioEffect<?>> bc$getEffects();
}


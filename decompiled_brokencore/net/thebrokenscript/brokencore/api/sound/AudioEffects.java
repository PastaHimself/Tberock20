/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.sound.AudioEffectHolder;
import net.thebrokenscript.brokencore.api.sound.AudioEffects;
import net.thebrokenscript.brokencore.api.sound.fx.EAXReverbEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbEffect;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/AudioEffects;", "", "<init>", "()V", "REVERB", "Lnet/thebrokenscript/brokencore/api/sound/AudioEffectHolder;", "Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbEffect;", "EAX_REVERB", "Lnet/thebrokenscript/brokencore/api/sound/fx/EAXReverbEffect;", "brokencore-common"})
public final class AudioEffects {
    @NotNull
    public static final AudioEffects INSTANCE = new AudioEffects();
    @JvmField
    @NotNull
    public static final AudioEffectHolder<ReverbEffect> REVERB = new AudioEffectHolder(ReverbEffect.Companion.getEFFECT_ID(), REVERB.1.INSTANCE);
    @JvmField
    @NotNull
    public static final AudioEffectHolder<EAXReverbEffect> EAX_REVERB = new AudioEffectHolder(EAXReverbEffect.Companion.getEFFECT_ID(), EAX_REVERB.1.INSTANCE);

    private AudioEffects() {
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.audio.Channel
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.openal.EXTEfx
 */
package net.thebrokenscript.brokencore.api.sound.fx;

import com.mojang.blaze3d.audio.Channel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.sound.ALUtilKt;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.openal.EXTEfx;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001HB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR+\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR+\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR+\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR+\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0010\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR+\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR+\u0010-\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR+\u00101\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR+\u00105\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR+\u00109\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b<\u0010\u0010\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR+\u0010>\u001a\u00020=2\u0006\u0010\b\u001a\u00020=8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bC\u0010\u0010\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006I"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbEffect;", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "<set-?>", "", "density", "getDensity", "()F", "setDensity", "(F)V", "density$delegate", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate;", "diffusion", "getDiffusion", "setDiffusion", "diffusion$delegate", "gain", "getGain", "setGain", "gain$delegate", "gainHf", "getGainHf", "setGainHf", "gainHf$delegate", "decayTime", "getDecayTime", "setDecayTime", "decayTime$delegate", "decayHfRatio", "getDecayHfRatio", "setDecayHfRatio", "decayHfRatio$delegate", "reflectionsGain", "getReflectionsGain", "setReflectionsGain", "reflectionsGain$delegate", "reflectionsDelay", "getReflectionsDelay", "setReflectionsDelay", "reflectionsDelay$delegate", "lateGain", "getLateGain", "setLateGain", "lateGain$delegate", "lateDelay", "getLateDelay", "setLateDelay", "lateDelay$delegate", "airAbsorptionGainHf", "getAirAbsorptionGainHf", "setAirAbsorptionGainHf", "airAbsorptionGainHf$delegate", "roomRolloffFactor", "getRoomRolloffFactor", "setRoomRolloffFactor", "roomRolloffFactor$delegate", "", "decayHfLimit", "getDecayHfLimit", "()I", "setDecayHfLimit", "(I)V", "decayHfLimit$delegate", "setup", "", "chan", "Lcom/mojang/blaze3d/audio/Channel;", "Companion", "brokencore-common"})
public final class ReverbEffect
extends AudioEffect<ReverbEffect> {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ResourceLocation id = EFFECT_ID;
    @NotNull
    private final AudioEffect.PropDelegate density$delegate = this.fxPropFloat(1);
    @NotNull
    private final AudioEffect.PropDelegate diffusion$delegate = this.fxPropFloat(2);
    @NotNull
    private final AudioEffect.PropDelegate gain$delegate = this.fxPropFloat(3);
    @NotNull
    private final AudioEffect.PropDelegate gainHf$delegate = this.fxPropFloat(4);
    @NotNull
    private final AudioEffect.PropDelegate decayTime$delegate = this.fxPropFloat(5);
    @NotNull
    private final AudioEffect.PropDelegate decayHfRatio$delegate = this.fxPropFloat(6);
    @NotNull
    private final AudioEffect.PropDelegate reflectionsGain$delegate = this.fxPropFloat(7);
    @NotNull
    private final AudioEffect.PropDelegate reflectionsDelay$delegate = this.fxPropFloat(8);
    @NotNull
    private final AudioEffect.PropDelegate lateGain$delegate = this.fxPropFloat(9);
    @NotNull
    private final AudioEffect.PropDelegate lateDelay$delegate = this.fxPropFloat(10);
    @NotNull
    private final AudioEffect.PropDelegate airAbsorptionGainHf$delegate = this.fxPropFloat(11);
    @NotNull
    private final AudioEffect.PropDelegate roomRolloffFactor$delegate = this.fxPropFloat(12);
    @NotNull
    private final AudioEffect.PropDelegate decayHfLimit$delegate = this.fxPropInt(13);
    @NotNull
    private static final ResourceLocation EFFECT_ID;

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public final float getDensity() {
        return ((Number)this.density$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setDensity(float f) {
        this.density$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    public final float getDiffusion() {
        return ((Number)this.diffusion$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final void setDiffusion(float f) {
        this.diffusion$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(f));
    }

    public final float getGain() {
        return ((Number)this.gain$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    public final void setGain(float f) {
        this.gain$delegate.setValue(this, $$delegatedProperties[2], Float.valueOf(f));
    }

    public final float getGainHf() {
        return ((Number)this.gainHf$delegate.getValue(this, $$delegatedProperties[3])).floatValue();
    }

    public final void setGainHf(float f) {
        this.gainHf$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    public final float getDecayTime() {
        return ((Number)this.decayTime$delegate.getValue(this, $$delegatedProperties[4])).floatValue();
    }

    public final void setDecayTime(float f) {
        this.decayTime$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    public final float getDecayHfRatio() {
        return ((Number)this.decayHfRatio$delegate.getValue(this, $$delegatedProperties[5])).floatValue();
    }

    public final void setDecayHfRatio(float f) {
        this.decayHfRatio$delegate.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    public final float getReflectionsGain() {
        return ((Number)this.reflectionsGain$delegate.getValue(this, $$delegatedProperties[6])).floatValue();
    }

    public final void setReflectionsGain(float f) {
        this.reflectionsGain$delegate.setValue(this, $$delegatedProperties[6], Float.valueOf(f));
    }

    public final float getReflectionsDelay() {
        return ((Number)this.reflectionsDelay$delegate.getValue(this, $$delegatedProperties[7])).floatValue();
    }

    public final void setReflectionsDelay(float f) {
        this.reflectionsDelay$delegate.setValue(this, $$delegatedProperties[7], Float.valueOf(f));
    }

    public final float getLateGain() {
        return ((Number)this.lateGain$delegate.getValue(this, $$delegatedProperties[8])).floatValue();
    }

    public final void setLateGain(float f) {
        this.lateGain$delegate.setValue(this, $$delegatedProperties[8], Float.valueOf(f));
    }

    public final float getLateDelay() {
        return ((Number)this.lateDelay$delegate.getValue(this, $$delegatedProperties[9])).floatValue();
    }

    public final void setLateDelay(float f) {
        this.lateDelay$delegate.setValue(this, $$delegatedProperties[9], Float.valueOf(f));
    }

    public final float getAirAbsorptionGainHf() {
        return ((Number)this.airAbsorptionGainHf$delegate.getValue(this, $$delegatedProperties[10])).floatValue();
    }

    public final void setAirAbsorptionGainHf(float f) {
        this.airAbsorptionGainHf$delegate.setValue(this, $$delegatedProperties[10], Float.valueOf(f));
    }

    public final float getRoomRolloffFactor() {
        return ((Number)this.roomRolloffFactor$delegate.getValue(this, $$delegatedProperties[11])).floatValue();
    }

    public final void setRoomRolloffFactor(float f) {
        this.roomRolloffFactor$delegate.setValue(this, $$delegatedProperties[11], Float.valueOf(f));
    }

    public final int getDecayHfLimit() {
        return ((Number)this.decayHfLimit$delegate.getValue(this, $$delegatedProperties[12])).intValue();
    }

    public final void setDecayHfLimit(int n) {
        this.decayHfLimit$delegate.setValue(this, $$delegatedProperties[12], n);
    }

    @Override
    protected void setup(@NotNull Channel chan) {
        Intrinsics.checkNotNullParameter((Object)chan, (String)"chan");
        if (!FancyAudio.INSTANCE.getHAS_EFX() || !this.isSetup()) {
            return;
        }
        EXTEfx.alEffecti((int)this.getEffectId(), (int)32769, (int)1);
        ALUtilKt.checkALError();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "density", "getDensity()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "diffusion", "getDiffusion()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "gain", "getGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "gainHf", "getGainHf()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "decayTime", "getDecayTime()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "decayHfRatio", "getDecayHfRatio()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "reflectionsGain", "getReflectionsGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "reflectionsDelay", "getReflectionsDelay()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "lateGain", "getLateGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "lateDelay", "getLateDelay()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "airAbsorptionGainHf", "getAirAbsorptionGainHf()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "roomRolloffFactor", "getRoomRolloffFactor()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ReverbEffect.class, "decayHfLimit", "getDecayHfLimit()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EFFECT_ID = BrokenCore.id("reverb");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbEffect$Companion;", "", "<init>", "()V", "EFFECT_ID", "Lnet/minecraft/resources/ResourceLocation;", "getEFFECT_ID", "()Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getEFFECT_ID() {
            return EFFECT_ID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


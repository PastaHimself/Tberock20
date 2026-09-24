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
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0010\u0014\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR+\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR+\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR+\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR+\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0010\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR+\u0010)\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR+\u0010-\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR+\u00101\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR+\u00106\u001a\u0002052\u0006\u0010\b\u001a\u0002058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b;\u0010\u0010\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010<\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b?\u0010\u0010\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR+\u0010@\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bC\u0010\u0010\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000eR+\u0010D\u001a\u0002052\u0006\u0010\b\u001a\u0002058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bG\u0010\u0010\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R+\u0010H\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bK\u0010\u0010\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR+\u0010L\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bO\u0010\u0010\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR+\u0010P\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bS\u0010\u0010\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR+\u0010T\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bW\u0010\u0010\u001a\u0004\bU\u0010\f\"\u0004\bV\u0010\u000eR+\u0010X\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b[\u0010\u0010\u001a\u0004\bY\u0010\f\"\u0004\bZ\u0010\u000eR+\u0010\\\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b_\u0010\u0010\u001a\u0004\b]\u0010\f\"\u0004\b^\u0010\u000eR+\u0010`\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bc\u0010\u0010\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR+\u0010d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bg\u0010\u0010\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR+\u0010i\u001a\u00020h2\u0006\u0010\b\u001a\u00020h8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bn\u0010\u0010\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m\u00a8\u0006t"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/EAXReverbEffect;", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "<set-?>", "", "density", "getDensity", "()F", "setDensity", "(F)V", "density$delegate", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate;", "diffusion", "getDiffusion", "setDiffusion", "diffusion$delegate", "gain", "getGain", "setGain", "gain$delegate", "gainHf", "getGainHf", "setGainHf", "gainHf$delegate", "gainLf", "getGainLf", "setGainLf", "gainLf$delegate", "decayTime", "getDecayTime", "setDecayTime", "decayTime$delegate", "decayHfRatio", "getDecayHfRatio", "setDecayHfRatio", "decayHfRatio$delegate", "decayLfRatio", "getDecayLfRatio", "setDecayLfRatio", "decayLfRatio$delegate", "reflectionsGain", "getReflectionsGain", "setReflectionsGain", "reflectionsGain$delegate", "reflectionsDelay", "getReflectionsDelay", "setReflectionsDelay", "reflectionsDelay$delegate", "", "reflectionsPan", "getReflectionsPan", "()[F", "setReflectionsPan", "([F)V", "reflectionsPan$delegate", "lateGain", "getLateGain", "setLateGain", "lateGain$delegate", "lateDelay", "getLateDelay", "setLateDelay", "lateDelay$delegate", "latePan", "getLatePan", "setLatePan", "latePan$delegate", "echoTime", "getEchoTime", "setEchoTime", "echoTime$delegate", "echoDepth", "getEchoDepth", "setEchoDepth", "echoDepth$delegate", "modulationTime", "getModulationTime", "setModulationTime", "modulationTime$delegate", "modulationDepth", "getModulationDepth", "setModulationDepth", "modulationDepth$delegate", "airAbsorptionGainHf", "getAirAbsorptionGainHf", "setAirAbsorptionGainHf", "airAbsorptionGainHf$delegate", "hfReference", "getHfReference", "setHfReference", "hfReference$delegate", "lfReference", "getLfReference", "setLfReference", "lfReference$delegate", "roomRolloffFactor", "getRoomRolloffFactor", "setRoomRolloffFactor", "roomRolloffFactor$delegate", "", "decayHfLimit", "getDecayHfLimit", "()I", "setDecayHfLimit", "(I)V", "decayHfLimit$delegate", "setup", "", "chan", "Lcom/mojang/blaze3d/audio/Channel;", "Companion", "brokencore-common"})
public final class EAXReverbEffect
extends AudioEffect<EAXReverbEffect> {
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
    private final AudioEffect.PropDelegate gainLf$delegate = this.fxPropFloat(5);
    @NotNull
    private final AudioEffect.PropDelegate decayTime$delegate = this.fxPropFloat(6);
    @NotNull
    private final AudioEffect.PropDelegate decayHfRatio$delegate = this.fxPropFloat(7);
    @NotNull
    private final AudioEffect.PropDelegate decayLfRatio$delegate = this.fxPropFloat(8);
    @NotNull
    private final AudioEffect.PropDelegate reflectionsGain$delegate = this.fxPropFloat(9);
    @NotNull
    private final AudioEffect.PropDelegate reflectionsDelay$delegate = this.fxPropFloat(10);
    @NotNull
    private final AudioEffect.PropDelegate reflectionsPan$delegate = this.fxPropFloat3(11);
    @NotNull
    private final AudioEffect.PropDelegate lateGain$delegate = this.fxPropFloat(12);
    @NotNull
    private final AudioEffect.PropDelegate lateDelay$delegate = this.fxPropFloat(13);
    @NotNull
    private final AudioEffect.PropDelegate latePan$delegate = this.fxPropFloat3(14);
    @NotNull
    private final AudioEffect.PropDelegate echoTime$delegate = this.fxPropFloat(15);
    @NotNull
    private final AudioEffect.PropDelegate echoDepth$delegate = this.fxPropFloat(16);
    @NotNull
    private final AudioEffect.PropDelegate modulationTime$delegate = this.fxPropFloat(17);
    @NotNull
    private final AudioEffect.PropDelegate modulationDepth$delegate = this.fxPropFloat(18);
    @NotNull
    private final AudioEffect.PropDelegate airAbsorptionGainHf$delegate = this.fxPropFloat(19);
    @NotNull
    private final AudioEffect.PropDelegate hfReference$delegate = this.fxPropFloat(20);
    @NotNull
    private final AudioEffect.PropDelegate lfReference$delegate = this.fxPropFloat(21);
    @NotNull
    private final AudioEffect.PropDelegate roomRolloffFactor$delegate = this.fxPropFloat(22);
    @NotNull
    private final AudioEffect.PropDelegate decayHfLimit$delegate = this.fxPropInt(23);
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

    public final float getGainLf() {
        return ((Number)this.gainLf$delegate.getValue(this, $$delegatedProperties[4])).floatValue();
    }

    public final void setGainLf(float f) {
        this.gainLf$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    public final float getDecayTime() {
        return ((Number)this.decayTime$delegate.getValue(this, $$delegatedProperties[5])).floatValue();
    }

    public final void setDecayTime(float f) {
        this.decayTime$delegate.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    public final float getDecayHfRatio() {
        return ((Number)this.decayHfRatio$delegate.getValue(this, $$delegatedProperties[6])).floatValue();
    }

    public final void setDecayHfRatio(float f) {
        this.decayHfRatio$delegate.setValue(this, $$delegatedProperties[6], Float.valueOf(f));
    }

    public final float getDecayLfRatio() {
        return ((Number)this.decayLfRatio$delegate.getValue(this, $$delegatedProperties[7])).floatValue();
    }

    public final void setDecayLfRatio(float f) {
        this.decayLfRatio$delegate.setValue(this, $$delegatedProperties[7], Float.valueOf(f));
    }

    public final float getReflectionsGain() {
        return ((Number)this.reflectionsGain$delegate.getValue(this, $$delegatedProperties[8])).floatValue();
    }

    public final void setReflectionsGain(float f) {
        this.reflectionsGain$delegate.setValue(this, $$delegatedProperties[8], Float.valueOf(f));
    }

    public final float getReflectionsDelay() {
        return ((Number)this.reflectionsDelay$delegate.getValue(this, $$delegatedProperties[9])).floatValue();
    }

    public final void setReflectionsDelay(float f) {
        this.reflectionsDelay$delegate.setValue(this, $$delegatedProperties[9], Float.valueOf(f));
    }

    @NotNull
    public final float[] getReflectionsPan() {
        return (float[])this.reflectionsPan$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final void setReflectionsPan(@NotNull float[] fArray) {
        Intrinsics.checkNotNullParameter((Object)fArray, (String)"<set-?>");
        this.reflectionsPan$delegate.setValue(this, $$delegatedProperties[10], fArray);
    }

    public final float getLateGain() {
        return ((Number)this.lateGain$delegate.getValue(this, $$delegatedProperties[11])).floatValue();
    }

    public final void setLateGain(float f) {
        this.lateGain$delegate.setValue(this, $$delegatedProperties[11], Float.valueOf(f));
    }

    public final float getLateDelay() {
        return ((Number)this.lateDelay$delegate.getValue(this, $$delegatedProperties[12])).floatValue();
    }

    public final void setLateDelay(float f) {
        this.lateDelay$delegate.setValue(this, $$delegatedProperties[12], Float.valueOf(f));
    }

    @NotNull
    public final float[] getLatePan() {
        return (float[])this.latePan$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final void setLatePan(@NotNull float[] fArray) {
        Intrinsics.checkNotNullParameter((Object)fArray, (String)"<set-?>");
        this.latePan$delegate.setValue(this, $$delegatedProperties[13], fArray);
    }

    public final float getEchoTime() {
        return ((Number)this.echoTime$delegate.getValue(this, $$delegatedProperties[14])).floatValue();
    }

    public final void setEchoTime(float f) {
        this.echoTime$delegate.setValue(this, $$delegatedProperties[14], Float.valueOf(f));
    }

    public final float getEchoDepth() {
        return ((Number)this.echoDepth$delegate.getValue(this, $$delegatedProperties[15])).floatValue();
    }

    public final void setEchoDepth(float f) {
        this.echoDepth$delegate.setValue(this, $$delegatedProperties[15], Float.valueOf(f));
    }

    public final float getModulationTime() {
        return ((Number)this.modulationTime$delegate.getValue(this, $$delegatedProperties[16])).floatValue();
    }

    public final void setModulationTime(float f) {
        this.modulationTime$delegate.setValue(this, $$delegatedProperties[16], Float.valueOf(f));
    }

    public final float getModulationDepth() {
        return ((Number)this.modulationDepth$delegate.getValue(this, $$delegatedProperties[17])).floatValue();
    }

    public final void setModulationDepth(float f) {
        this.modulationDepth$delegate.setValue(this, $$delegatedProperties[17], Float.valueOf(f));
    }

    public final float getAirAbsorptionGainHf() {
        return ((Number)this.airAbsorptionGainHf$delegate.getValue(this, $$delegatedProperties[18])).floatValue();
    }

    public final void setAirAbsorptionGainHf(float f) {
        this.airAbsorptionGainHf$delegate.setValue(this, $$delegatedProperties[18], Float.valueOf(f));
    }

    public final float getHfReference() {
        return ((Number)this.hfReference$delegate.getValue(this, $$delegatedProperties[19])).floatValue();
    }

    public final void setHfReference(float f) {
        this.hfReference$delegate.setValue(this, $$delegatedProperties[19], Float.valueOf(f));
    }

    public final float getLfReference() {
        return ((Number)this.lfReference$delegate.getValue(this, $$delegatedProperties[20])).floatValue();
    }

    public final void setLfReference(float f) {
        this.lfReference$delegate.setValue(this, $$delegatedProperties[20], Float.valueOf(f));
    }

    public final float getRoomRolloffFactor() {
        return ((Number)this.roomRolloffFactor$delegate.getValue(this, $$delegatedProperties[21])).floatValue();
    }

    public final void setRoomRolloffFactor(float f) {
        this.roomRolloffFactor$delegate.setValue(this, $$delegatedProperties[21], Float.valueOf(f));
    }

    public final int getDecayHfLimit() {
        return ((Number)this.decayHfLimit$delegate.getValue(this, $$delegatedProperties[22])).intValue();
    }

    public final void setDecayHfLimit(int n) {
        this.decayHfLimit$delegate.setValue(this, $$delegatedProperties[22], n);
    }

    @Override
    protected void setup(@NotNull Channel chan) {
        Intrinsics.checkNotNullParameter((Object)chan, (String)"chan");
        if (!FancyAudio.INSTANCE.getHAS_EFX() || !this.isSetup()) {
            return;
        }
        EXTEfx.alEffecti((int)this.getEffectId(), (int)32769, (int)32768);
        ALUtilKt.checkALError();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "density", "getDensity()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "diffusion", "getDiffusion()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "gain", "getGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "gainHf", "getGainHf()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "gainLf", "getGainLf()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "decayTime", "getDecayTime()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "decayHfRatio", "getDecayHfRatio()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "decayLfRatio", "getDecayLfRatio()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "reflectionsGain", "getReflectionsGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "reflectionsDelay", "getReflectionsDelay()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "reflectionsPan", "getReflectionsPan()[F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "lateGain", "getLateGain()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "lateDelay", "getLateDelay()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "latePan", "getLatePan()[F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "echoTime", "getEchoTime()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "echoDepth", "getEchoDepth()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "modulationTime", "getModulationTime()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "modulationDepth", "getModulationDepth()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "airAbsorptionGainHf", "getAirAbsorptionGainHf()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "hfReference", "getHfReference()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "lfReference", "getLfReference()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "roomRolloffFactor", "getRoomRolloffFactor()F", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EAXReverbEffect.class, "decayHfLimit", "getDecayHfLimit()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EFFECT_ID = BrokenCore.id("eax_reverb");
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/EAXReverbEffect$Companion;", "", "<init>", "()V", "EFFECT_ID", "Lnet/minecraft/resources/ResourceLocation;", "getEFFECT_ID", "()Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
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


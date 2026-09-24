/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound.fx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.sound.AudioEffects;
import net.thebrokenscript.brokencore.api.sound.fx.EAXReverbEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbEffect;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u00bf\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020<J!\u0010=\u001a\u00020<2\u0019\b\u0002\u0010>\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002090?\u00a2\u0006\u0002\b@J!\u0010A\u001a\u00020;2\u0019\b\u0002\u0010>\u001a\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u0002090?\u00a2\u0006\u0002\b@R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107\u00a8\u0006B"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbPreset;", "", "density", "", "diffusion", "gain", "gainHf", "gainLf", "decayTime", "decayHfRatio", "decayLfRatio", "reflectionsGain", "reflectionsDelay", "reflectionsPan", "", "lateGain", "lateDelay", "latePan", "echoTime", "echoDepth", "modulationTime", "modulationDepth", "airAbsorptionGainHf", "hfReference", "lfReference", "roomRolloffFactor", "decayHfLimit", "", "<init>", "(FFFFFFFFFF[FFF[FFFFFFFFFI)V", "getDensity", "()F", "getDiffusion", "getGain", "getGainHf", "getGainLf", "getDecayTime", "getDecayHfRatio", "getDecayLfRatio", "getReflectionsGain", "getReflectionsDelay", "getReflectionsPan", "()[F", "getLateGain", "getLateDelay", "getLatePan", "getEchoTime", "getEchoDepth", "getModulationTime", "getModulationDepth", "getAirAbsorptionGainHf", "getHfReference", "getLfReference", "getRoomRolloffFactor", "getDecayHfLimit", "()I", "apply", "", "fx", "Lnet/thebrokenscript/brokencore/api/sound/fx/EAXReverbEffect;", "Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbEffect;", "create", "filterCb", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "createEAX", "brokencore-common"})
public final class ReverbPreset {
    private final float density;
    private final float diffusion;
    private final float gain;
    private final float gainHf;
    private final float gainLf;
    private final float decayTime;
    private final float decayHfRatio;
    private final float decayLfRatio;
    private final float reflectionsGain;
    private final float reflectionsDelay;
    @NotNull
    private final float[] reflectionsPan;
    private final float lateGain;
    private final float lateDelay;
    @NotNull
    private final float[] latePan;
    private final float echoTime;
    private final float echoDepth;
    private final float modulationTime;
    private final float modulationDepth;
    private final float airAbsorptionGainHf;
    private final float hfReference;
    private final float lfReference;
    private final float roomRolloffFactor;
    private final int decayHfLimit;

    public ReverbPreset(float density, float diffusion, float gain, float gainHf, float gainLf, float decayTime, float decayHfRatio, float decayLfRatio, float reflectionsGain, float reflectionsDelay, @NotNull float[] reflectionsPan, float lateGain, float lateDelay, @NotNull float[] latePan, float echoTime, float echoDepth, float modulationTime, float modulationDepth, float airAbsorptionGainHf, float hfReference, float lfReference, float roomRolloffFactor, int decayHfLimit) {
        Intrinsics.checkNotNullParameter((Object)reflectionsPan, (String)"reflectionsPan");
        Intrinsics.checkNotNullParameter((Object)latePan, (String)"latePan");
        this.density = density;
        this.diffusion = diffusion;
        this.gain = gain;
        this.gainHf = gainHf;
        this.gainLf = gainLf;
        this.decayTime = decayTime;
        this.decayHfRatio = decayHfRatio;
        this.decayLfRatio = decayLfRatio;
        this.reflectionsGain = reflectionsGain;
        this.reflectionsDelay = reflectionsDelay;
        this.reflectionsPan = reflectionsPan;
        this.lateGain = lateGain;
        this.lateDelay = lateDelay;
        this.latePan = latePan;
        this.echoTime = echoTime;
        this.echoDepth = echoDepth;
        this.modulationTime = modulationTime;
        this.modulationDepth = modulationDepth;
        this.airAbsorptionGainHf = airAbsorptionGainHf;
        this.hfReference = hfReference;
        this.lfReference = lfReference;
        this.roomRolloffFactor = roomRolloffFactor;
        this.decayHfLimit = decayHfLimit;
    }

    public final float getDensity() {
        return this.density;
    }

    public final float getDiffusion() {
        return this.diffusion;
    }

    public final float getGain() {
        return this.gain;
    }

    public final float getGainHf() {
        return this.gainHf;
    }

    public final float getGainLf() {
        return this.gainLf;
    }

    public final float getDecayTime() {
        return this.decayTime;
    }

    public final float getDecayHfRatio() {
        return this.decayHfRatio;
    }

    public final float getDecayLfRatio() {
        return this.decayLfRatio;
    }

    public final float getReflectionsGain() {
        return this.reflectionsGain;
    }

    public final float getReflectionsDelay() {
        return this.reflectionsDelay;
    }

    @NotNull
    public final float[] getReflectionsPan() {
        return this.reflectionsPan;
    }

    public final float getLateGain() {
        return this.lateGain;
    }

    public final float getLateDelay() {
        return this.lateDelay;
    }

    @NotNull
    public final float[] getLatePan() {
        return this.latePan;
    }

    public final float getEchoTime() {
        return this.echoTime;
    }

    public final float getEchoDepth() {
        return this.echoDepth;
    }

    public final float getModulationTime() {
        return this.modulationTime;
    }

    public final float getModulationDepth() {
        return this.modulationDepth;
    }

    public final float getAirAbsorptionGainHf() {
        return this.airAbsorptionGainHf;
    }

    public final float getHfReference() {
        return this.hfReference;
    }

    public final float getLfReference() {
        return this.lfReference;
    }

    public final float getRoomRolloffFactor() {
        return this.roomRolloffFactor;
    }

    public final int getDecayHfLimit() {
        return this.decayHfLimit;
    }

    public final void apply(@NotNull EAXReverbEffect fx) {
        Intrinsics.checkNotNullParameter((Object)fx, (String)"fx");
        fx.setDensity(this.density);
        fx.setDiffusion(this.diffusion);
        fx.setGain(this.gain);
        fx.setGainHf(this.gainHf);
        fx.setGainLf(this.gainLf);
        fx.setDecayTime(this.decayTime);
        fx.setDecayHfRatio(this.decayHfRatio);
        fx.setDecayLfRatio(this.decayLfRatio);
        fx.setReflectionsGain(this.reflectionsGain);
        fx.setReflectionsDelay(this.reflectionsDelay);
        fx.setReflectionsPan(this.reflectionsPan);
        fx.setLateGain(this.lateGain);
        fx.setLateDelay(this.lateDelay);
        fx.setLatePan(this.latePan);
        fx.setEchoTime(this.echoTime);
        fx.setEchoDepth(this.echoDepth);
        fx.setModulationTime(this.modulationTime);
        fx.setModulationDepth(this.modulationDepth);
        fx.setAirAbsorptionGainHf(this.airAbsorptionGainHf);
        fx.setHfReference(this.hfReference);
        fx.setLfReference(this.lfReference);
        fx.setRoomRolloffFactor(this.roomRolloffFactor);
        fx.setDecayHfLimit(this.decayHfLimit);
    }

    public final void apply(@NotNull ReverbEffect fx) {
        Intrinsics.checkNotNullParameter((Object)fx, (String)"fx");
        fx.setDensity(this.density);
        fx.setDiffusion(this.diffusion);
        fx.setGain(this.gain);
        fx.setGainHf(this.gainHf);
        fx.setDecayTime(this.decayTime);
        fx.setDecayHfRatio(this.decayHfRatio);
        fx.setReflectionsGain(this.reflectionsGain);
        fx.setReflectionsDelay(this.reflectionsDelay);
        fx.setLateGain(this.lateGain);
        fx.setLateDelay(this.lateDelay);
        fx.setAirAbsorptionGainHf(this.airAbsorptionGainHf);
        fx.setRoomRolloffFactor(this.roomRolloffFactor);
        fx.setDecayHfLimit(this.decayHfLimit);
    }

    @NotNull
    public final ReverbEffect create(@NotNull Function1<? super ReverbEffect, Unit> filterCb) {
        Intrinsics.checkNotNullParameter(filterCb, (String)"filterCb");
        return AudioEffects.REVERB.create((Function1<ReverbEffect, Unit>)((Function1)new Function1<ReverbEffect, Unit>((Object)this){

            public final void invoke(ReverbEffect p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((ReverbPreset)this.receiver).apply(p0);
            }
        }), filterCb);
    }

    public static /* synthetic */ ReverbEffect create$default(ReverbPreset reverbPreset, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = ReverbPreset::create$lambda$0;
        }
        return reverbPreset.create((Function1<? super ReverbEffect, Unit>)function1);
    }

    @NotNull
    public final EAXReverbEffect createEAX(@NotNull Function1<? super EAXReverbEffect, Unit> filterCb) {
        Intrinsics.checkNotNullParameter(filterCb, (String)"filterCb");
        return AudioEffects.EAX_REVERB.create((Function1<EAXReverbEffect, Unit>)((Function1)new Function1<EAXReverbEffect, Unit>((Object)this){

            public final void invoke(EAXReverbEffect p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((ReverbPreset)this.receiver).apply(p0);
            }
        }), filterCb);
    }

    public static /* synthetic */ EAXReverbEffect createEAX$default(ReverbPreset reverbPreset, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = ReverbPreset::createEAX$lambda$0;
        }
        return reverbPreset.createEAX((Function1<? super EAXReverbEffect, Unit>)function1);
    }

    private static final Unit create$lambda$0(ReverbEffect reverbEffect) {
        Intrinsics.checkNotNullParameter((Object)reverbEffect, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit createEAX$lambda$0(EAXReverbEffect eAXReverbEffect) {
        Intrinsics.checkNotNullParameter((Object)eAXReverbEffect, (String)"<this>");
        return Unit.INSTANCE;
    }
}


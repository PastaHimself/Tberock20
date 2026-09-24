/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.audio.Channel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.openal.AL11
 *  org.lwjgl.openal.EXTEfx
 */
package net.thebrokenscript.brokencore.api.sound.fx;

import com.mojang.blaze3d.audio.Channel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.sound.ALUtilKt;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.SoundAccessorsKt;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.EXTEfx;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H$J\u0010\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00104\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00105\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00106\u001a\u00020\"H\u0016J\b\u00107\u001a\u00020\"H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u0018092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0018092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0006092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0018092\u0006\u0010:\u001a\u00020\u0006H\u0004J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0006092\u0006\u0010:\u001a\u00020\u0006H\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR1\u0010 \u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0!\u00a2\u0006\u0002\b#0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R1\u0010&\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0!\u00a2\u0006\u0002\b#0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u0012\u0010)\u001a\u00020*X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u0002028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00103\u00a8\u0006C"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "T", "", "<init>", "()V", "auxSlot", "", "getAuxSlot", "()I", "setAuxSlot", "(I)V", "effectId", "getEffectId", "setEffectId", "filterId", "getFilterId", "setFilterId", "connected", "", "getConnected", "()Ljava/util/List;", "setConnected", "(Ljava/util/List;)V", "<set-?>", "", "wetLevel", "getWetLevel", "()F", "setWetLevel", "(F)V", "wetLevel$delegate", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate;", "callbacks", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getCallbacks", "setCallbacks", "filterCallbacks", "getFilterCallbacks", "setFilterCallbacks", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "setup", "chan", "Lcom/mojang/blaze3d/audio/Channel;", "setupFilter", "isSetup", "", "()Z", "create", "connect", "destroy", "tick", "fxSlotPropFloat", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate;", "prop", "fxSlotPropInt", "fxPropFloat", "fxPropFloat3", "", "fxPropInt", "filterPropFloat", "filterPropInt", "PropDelegate", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAudioEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioEffect.kt\nnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n1869#2,2:225\n1869#2,2:227\n*S KotlinDebug\n*F\n+ 1 AudioEffect.kt\nnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect\n*L\n95#1:225,2\n101#1:227,2\n*E\n"})
public abstract class AudioEffect<T> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private int auxSlot = -1;
    private int effectId = -1;
    private int filterId = -1;
    @NotNull
    private List<Integer> connected = new ArrayList();
    @NotNull
    private final PropDelegate wetLevel$delegate = this.fxSlotPropFloat(2);
    @NotNull
    private List<Function1<T, Unit>> callbacks = new ArrayList();
    @NotNull
    private List<Function1<T, Unit>> filterCallbacks = new ArrayList();

    protected final int getAuxSlot() {
        return this.auxSlot;
    }

    protected final void setAuxSlot(int n) {
        this.auxSlot = n;
    }

    protected final int getEffectId() {
        return this.effectId;
    }

    protected final void setEffectId(int n) {
        this.effectId = n;
    }

    protected final int getFilterId() {
        return this.filterId;
    }

    protected final void setFilterId(int n) {
        this.filterId = n;
    }

    @NotNull
    protected final List<Integer> getConnected() {
        return this.connected;
    }

    protected final void setConnected(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.connected = list;
    }

    public final float getWetLevel() {
        return ((Number)this.wetLevel$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setWetLevel(float f) {
        this.wetLevel$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    @NotNull
    public final List<Function1<T, Unit>> getCallbacks() {
        return this.callbacks;
    }

    public final void setCallbacks(@NotNull List<Function1<T, Unit>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.callbacks = list;
    }

    @NotNull
    public final List<Function1<T, Unit>> getFilterCallbacks() {
        return this.filterCallbacks;
    }

    public final void setFilterCallbacks(@NotNull List<Function1<T, Unit>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.filterCallbacks = list;
    }

    @NotNull
    public abstract ResourceLocation getId();

    protected abstract void setup(@NotNull Channel var1);

    protected void setupFilter(@NotNull Channel chan) {
        Intrinsics.checkNotNullParameter((Object)chan, (String)"chan");
    }

    protected final boolean isSetup() {
        return this.auxSlot != -1 && this.effectId != -1 && this.filterId != -1;
    }

    public void create(@NotNull Channel chan) {
        Function1 it;
        Intrinsics.checkNotNullParameter((Object)chan, (String)"chan");
        if (!FancyAudio.INSTANCE.getHAS_EFX() || this.isSetup()) {
            return;
        }
        int[] slot = new int[1];
        int[] effect = new int[1];
        int[] filter = new int[1];
        EXTEfx.alGenAuxiliaryEffectSlots((int[])slot);
        ALUtilKt.checkALError();
        EXTEfx.alGenEffects((int[])effect);
        ALUtilKt.checkALError();
        EXTEfx.alGenFilters((int[])filter);
        ALUtilKt.checkALError();
        this.auxSlot = slot[0];
        this.effectId = effect[0];
        this.filterId = filter[0];
        this.setup(chan);
        Iterable $this$forEach$iv = this.callbacks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)this);
        }
        EXTEfx.alFilteri((int)this.filterId, (int)32769, (int)0);
        ALUtilKt.checkALError();
        this.setupFilter(chan);
        $this$forEach$iv = this.filterCallbacks;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)this);
        }
        EXTEfx.alAuxiliaryEffectSloti((int)this.auxSlot, (int)1, (int)this.effectId);
        ALUtilKt.checkALError();
    }

    public void connect(@NotNull Channel chan) {
        Intrinsics.checkNotNullParameter((Object)chan, (String)"chan");
        if (!FancyAudio.INSTANCE.getHAS_EFX() || !this.isSetup() || this.connected.contains(SoundAccessorsKt.getSource(chan))) {
            return;
        }
        AL11.alSource3i((int)SoundAccessorsKt.getSource(chan), (int)131078, (int)this.auxSlot, (int)0, (int)0);
        ((Collection)this.connected).add(SoundAccessorsKt.getSource(chan));
    }

    public void destroy() {
        if (!FancyAudio.INSTANCE.getHAS_EFX()) {
            return;
        }
        if (this.auxSlot != -1) {
            EXTEfx.alAuxiliaryEffectSloti((int)this.auxSlot, (int)1, (int)0);
            EXTEfx.alDeleteAuxiliaryEffectSlots((int)this.auxSlot);
        }
        if (this.effectId != -1) {
            EXTEfx.alDeleteEffects((int)this.effectId);
        }
        if (this.filterId != -1) {
            EXTEfx.alDeleteFilters((int)this.filterId);
        }
    }

    public void tick() {
    }

    @NotNull
    protected final PropDelegate<Float> fxSlotPropFloat(int prop) {
        return new PropDelegate<Float>(fxSlotPropFloat.1.INSTANCE, fxSlotPropFloat.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getAuxSlot();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setAuxSlot(((Number)value).intValue());
            }
        }), prop, Float.valueOf(-1.0f));
    }

    @NotNull
    protected final PropDelegate<Integer> fxSlotPropInt(int prop) {
        return new PropDelegate<Integer>(fxSlotPropInt.1.INSTANCE, fxSlotPropInt.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getAuxSlot();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setAuxSlot(((Number)value).intValue());
            }
        }), prop, -1);
    }

    @NotNull
    protected final PropDelegate<Float> fxPropFloat(int prop) {
        return new PropDelegate<Float>(fxPropFloat.1.INSTANCE, fxPropFloat.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getEffectId();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setEffectId(((Number)value).intValue());
            }
        }), prop, Float.valueOf(-1.0f));
    }

    @NotNull
    protected final PropDelegate<float[]> fxPropFloat3(int prop) {
        return new PropDelegate<float[]>(AudioEffect::fxPropFloat3$lambda$0, fxPropFloat3.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getEffectId();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setEffectId(((Number)value).intValue());
            }
        }), prop, new float[0]);
    }

    @NotNull
    protected final PropDelegate<Integer> fxPropInt(int prop) {
        return new PropDelegate<Integer>(fxPropInt.1.INSTANCE, fxPropInt.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getEffectId();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setEffectId(((Number)value).intValue());
            }
        }), prop, -1);
    }

    @NotNull
    protected final PropDelegate<Float> filterPropFloat(int prop) {
        return new PropDelegate<Float>(filterPropFloat.1.INSTANCE, filterPropFloat.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getFilterId();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setFilterId(((Number)value).intValue());
            }
        }), prop, Float.valueOf(-1.0f));
    }

    @NotNull
    protected final PropDelegate<Integer> filterPropInt(int prop) {
        return new PropDelegate<Integer>(filterPropInt.1.INSTANCE, filterPropInt.2.INSTANCE, (Function0<Integer>)((Function0)new MutablePropertyReference0Impl(this){

            public Object get() {
                return ((AudioEffect)this.receiver).getFilterId();
            }

            public void set(Object value) {
                ((AudioEffect)this.receiver).setFilterId(((Number)value).intValue());
            }
        }), prop, -1);
    }

    private static final float[] fxPropFloat3$lambda$0(int id, int prop) {
        float[] arr = new float[3];
        EXTEfx.alGetEffectfv((int)id, (int)prop, (float[])arr);
        return arr;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(AudioEffect.class, "wetLevel", "getWetLevel()F", 0)))};
        $$delegatedProperties = kPropertyArray;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u00aa\u0001\u00126\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00010\u0004\u0012K\u0010\n\u001aG\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0015\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0086\u0002\u00a2\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\f\u001a\u00028\u0001H\u0086\u0002\u00a2\u0006\u0002\u0010\u001bR>\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000RS\u0010\n\u001aG\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00028\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate;", "T", "", "getter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "effect", "param", "setter", "Lkotlin/Function3;", "value", "", "idGetter", "Lkotlin/Function0;", "prop", "fallback", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)V", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nAudioEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioEffect.kt\nnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect$PropDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n1#2:225\n*E\n"})
    public static final class PropDelegate<T> {
        @NotNull
        private final Function2<Integer, Integer, T> getter;
        @NotNull
        private final Function3<Integer, Integer, T, Unit> setter;
        @NotNull
        private final Function0<Integer> idGetter;
        private final int prop;
        private final T fallback;

        public PropDelegate(@NotNull Function2<? super Integer, ? super Integer, ? extends T> getter, @NotNull Function3<? super Integer, ? super Integer, ? super T, Unit> setter, @NotNull Function0<Integer> idGetter, int prop, T fallback) {
            Intrinsics.checkNotNullParameter(getter, (String)"getter");
            Intrinsics.checkNotNullParameter(setter, (String)"setter");
            Intrinsics.checkNotNullParameter(idGetter, (String)"idGetter");
            this.getter = getter;
            this.setter = setter;
            this.idGetter = idGetter;
            this.prop = prop;
            this.fallback = fallback;
        }

        public final T getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, (String)"property");
            return (T)(((Number)this.idGetter.invoke()).intValue() != -1 ? this.getter.invoke(this.idGetter.invoke(), (Object)this.prop) : this.fallback);
        }

        public final void setValue(@Nullable Object thisRef, @NotNull KProperty<?> property, T value) {
            block0: {
                Unit unit;
                Intrinsics.checkNotNullParameter(property, (String)"property");
                if (((Number)this.idGetter.invoke()).intValue() == -1) break block0;
                this.setter.invoke(this.idGetter.invoke(), (Object)this.prop, value);
                Unit it = unit = Unit.INSTANCE;
                boolean bl = false;
                ALUtilKt.checkALError();
            }
        }
    }
}


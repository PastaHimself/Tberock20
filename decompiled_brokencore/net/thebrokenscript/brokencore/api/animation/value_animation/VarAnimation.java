/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.animation.value_animation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\u0007\b\u0017\u0018\u0000 }*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002|}B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\tJ7\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\f\b\u0001\u0010)*\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010*\u001a\u0002H)2\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010+J\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J;\u00101\u001a\u0004\u0018\u00018\u00002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b\u00a2\u0006\u0002\u00108J/\u00101\u001a\u0004\u0018\u00018\u00002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00103\u001a\u00020\u001b2\b\b\u0002\u00104\u001a\u000205H\u0007\u00a2\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020\u0004H\u0007J\u0006\u0010<\u001a\u00020.J\u001c\u0010=\u001a\u00020.2\b\b\u0002\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u0004H\u0007J\u0010\u0010@\u001a\u00020.2\u0006\u0010>\u001a\u00020\u0004H\u0002J\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010B\u001a\u00020.2\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000DJ\b\u0010E\u001a\u00020FH\u0016J-\u0010G\u001a\u00020.2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010HJ5\u0010I\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ5\u0010K\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ5\u0010L\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ5\u0010M\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ5\u0010N\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ5\u0010O\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00042\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010JJ\u001c\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0006\u0010Q\u001a\u00020\bJ\u001c\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\bJ\u0015\u0010S\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0002\u0010TJ#\u0010S\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00028\u0000\u00a2\u0006\u0002\u0010WJ\u0019\u0010^\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010_\u001a\u00020\u001bH\u0007\u00a2\u0006\u0002\u0010`J\u001d\u0010S\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u001b\u00a2\u0006\u0002\u0010aJ\r\u0010b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010cJ\"\u0010d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0006\u0010Q\u001a\u00020\bJ\u000e\u0010e\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\bJ\u0006\u0010f\u001a\u00020\u0004J\u000e\u0010g\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010h\u001a\u00020\u0004J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010k\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\u001bJ\u000e\u0010n\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010o\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bJ\u000e\u0010p\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010q\u001a\u00020\bJ\u0006\u0010r\u001a\u00020\bJ\u0006\u0010s\u001a\u00020\bJ\u0006\u0010t\u001a\u00020\bJ\u0006\u0010u\u001a\u00020\bR\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR,\u0010\u000e\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0004\u0012\u00028\u00000\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010 \u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010!\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010\"\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0082.\u00a2\u0006\u0004\n\u0002\u0010&R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000Y8F\u00a2\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0011\u0010i\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bi\u0010jR\u0011\u0010l\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\bk\u0010mR\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020\b0w8F\u00a2\u0006\u0006\u001a\u0004\bx\u0010yR\u0017\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000w8F\u00a2\u0006\u0006\u001a\u0004\b{\u0010y\u00a8\u0006~"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "T", "", "loops", "", "<init>", "(Z)V", "length", "", "(ZI)V", "value", "keyframeCount", "getKeyframeCount", "()I", "keyframes", "Ljava/util/LinkedHashMap;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation$Pair;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "keyframe", "keyframeLength", "keyframeTime", "getLength", "time", "getTime", "currentKeyframeStartTime", "nextKeyframeStartTime", "animationProgress", "", "playing", "currentInterpolator", "currentValue", "Ljava/lang/Object;", "nextValue", "secondNextValue", "lastValue", "baked", "bakedFrames", "", "[Ljava/lang/Object;", "genericInterpolator", "key", "I", "interpolator", "(ILnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;Ljava/lang/Object;)Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "bake", "tick", "", "bakedTick", "unbakedTick", "blend", "max", "weight", "blendEasing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "minTime", "maxTime", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;FLnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;II)Ljava/lang/Object;", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;FLnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;)Ljava/lang/Object;", "stop", "notify", "pause", "play", "fromStart", "notifyStopped", "onPlaybackFunction", "copy", "forEachValue", "consumer", "Ljava/util/function/Consumer;", "toString", "", "onKeyframeAdded", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;Ljava/lang/Object;I)V", "onStopped", "(ZLnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;Ljava/lang/Object;I)V", "onPaused", "onPlayed", "onAnimationEnd", "onTickStart", "onTickEnd", "getKeyPair", "index", "getClosestKeyPair", "getValueAtTime", "(I)Ljava/lang/Object;", "tickDelta", "fallback", "(IFLjava/lang/Object;)Ljava/lang/Object;", "type", "Ljava/lang/Class;", "getType$annotations", "()V", "getType", "()Ljava/lang/Class;", "get", "frameDelta", "(F)Ljava/lang/Object;", "(IF)Ljava/lang/Object;", "currentKeyValue", "()Ljava/lang/Object;", "getIndexedKeyValue", "nextKeyframeExists", "hasNext", "hasKeyAtTime", "isPlaying", "isEmpty", "()Z", "getCurrentKeyframeProgress", "currentKeyframeProgress", "()F", "getDeltaForTime", "getIndexedKeyTime", "getIndexForTime", "getCurrentKeyframeStartTime", "getKeyframe", "getKeyframeLength", "getKeyframeTime", "getNextKeyframeStartTime", "keyTimes", "", "getKeyTimes", "()Ljava/util/List;", "values", "getValues", "Pair", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
@SourceDebugExtension(value={"SMAP\nVarAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VarAnimation.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,539:1\n1869#2,2:540\n1563#2:556\n1634#2,3:557\n216#3,2:542\n37#4,2:544\n37#4,2:546\n37#4,2:548\n37#4,2:550\n37#4,2:552\n37#4,2:554\n*S KotlinDebug\n*F\n+ 1 VarAnimation.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation\n*L\n262#1:540,2\n525#1:556\n525#1:557,3\n269#1:542,2\n335#1:544,2\n339#1:546,2\n341#1:548,2\n348#1:550,2\n434#1:552,2\n485#1:554,2\n*E\n"})
public class VarAnimation<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int keyframeCount;
    @NotNull
    private LinkedHashMap<Integer, Pair<Interpolator<T>, T>> keyframes = new LinkedHashMap();
    private final boolean loops;
    private int keyframe;
    private int keyframeLength;
    private int keyframeTime;
    private int length;
    private int time;
    private int currentKeyframeStartTime;
    private int nextKeyframeStartTime;
    private float animationProgress;
    private boolean playing;
    @Nullable
    private Interpolator<T> currentInterpolator;
    @Nullable
    private T currentValue;
    @Nullable
    private T nextValue;
    @Nullable
    private T secondNextValue;
    @Nullable
    private T lastValue;
    private boolean baked;
    private T[] bakedFrames;
    @Nullable
    private Interpolator<T> genericInterpolator;

    public final int getKeyframeCount() {
        return this.keyframeCount;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getTime() {
        return this.time;
    }

    public VarAnimation(boolean loops) {
        this.loops = loops;
    }

    protected VarAnimation(boolean loops, int length) {
        this.loops = loops;
        this.length = length;
    }

    @NotNull
    public final <I extends Interpolator<?>> VarAnimation<T> key(int time2, @NotNull I interpolator, T value) {
        Intrinsics.checkNotNullParameter(interpolator, (String)"interpolator");
        if (this.baked) {
            throw new RuntimeException("Attempted to add a keyframe to baked animation");
        }
        if (this.genericInterpolator == null) {
            this.genericInterpolator = interpolator;
        }
        ++this.keyframeCount;
        ((Map)this.keyframes).put(time2, new Pair<I, T>(interpolator, value));
        this.length = Math.max(time2, this.length);
        this.onKeyframeAdded(interpolator, value, time2);
        return this;
    }

    @NotNull
    public final VarAnimation<T> bake() {
        if (this.baked) {
            return this;
        }
        this.bakedFrames = new Object[this.length + 1];
        int n = this.length + 1;
        for (int i = 0; i < n; ++i) {
            T[] TArray = this.bakedFrames;
            if (this.bakedFrames == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"bakedFrames");
                TArray = null;
            }
            T t = this.getValueAtTime(i);
            Intrinsics.checkNotNull(t);
            TArray[i] = t;
        }
        this.baked = true;
        this.stop(false);
        this.keyframes.clear();
        return this;
    }

    public final void tick() {
        if (this.playing) {
            this.onTickStart(false, this.currentInterpolator, this.currentValue, this.time);
            if (this.baked) {
                this.bakedTick();
            } else {
                this.unbakedTick();
            }
            this.onTickEnd(false, this.currentInterpolator, this.currentValue, this.time);
        }
    }

    private final void bakedTick() {
        T t;
        this.onTickStart(true, null, this.currentValue, this.time);
        if (this.currentValue != null) {
            t = this.currentValue;
        } else {
            T[] TArray = this.bakedFrames;
            if (this.bakedFrames == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"bakedFrames");
                TArray = null;
            }
            t = TArray[0];
        }
        this.lastValue = t;
        T[] TArray = this.bakedFrames;
        if (this.bakedFrames == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"bakedFrames");
            TArray = null;
        }
        this.currentValue = TArray[this.time];
        if (this.loops) {
            this.time = (this.time + 1) % (this.length + 1);
        } else if (this.time < this.length) {
            ++this.time;
        }
        if (this.time == this.length) {
            this.onAnimationEnd(true, null, this.currentValue, this.length);
            if (!this.loops) {
                VarAnimation.stop$default(this, false, 1, null);
            }
        }
        this.onTickEnd(true, null, this.currentValue, this.time);
    }

    private final void unbakedTick() {
        Integer first;
        if (this.keyframeCount < 2) {
            return;
        }
        this.animationProgress = (float)this.time / (float)this.length;
        Integer second = first = (Integer)this.keyframes.keySet().stream().toList().get(this.keyframe);
        if (this.hasNext()) {
            second = (Integer)this.keyframes.keySet().stream().toList().get(this.keyframe + 1);
        }
        int n = second;
        Intrinsics.checkNotNull((Object)first);
        this.keyframeLength = n - first;
        if (this.time >= this.nextKeyframeStartTime) {
            ++this.keyframe;
            this.currentKeyframeStartTime = this.nextKeyframeStartTime;
            if (this.hasNext()) {
                Object e = this.keyframes.keySet().stream().toList().get(this.keyframe + 1);
                Intrinsics.checkNotNullExpressionValue(e, (String)"get(...)");
                this.nextKeyframeStartTime = ((Number)e).intValue();
            }
            this.keyframeTime = 0;
        }
        if (this.time >= this.length) {
            if (this.loops) {
                List list = this.keyframes.keySet().stream().toList();
                Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
                Object object = CollectionsKt.first(list);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"first(...)");
                this.currentKeyframeStartTime = ((Number)object).intValue();
                if (this.hasNext()) {
                    Object e = this.keyframes.keySet().stream().toList().get(1);
                    Intrinsics.checkNotNullExpressionValue(e, (String)"get(...)");
                    this.nextKeyframeStartTime = ((Number)e).intValue();
                    this.nextValue = this.keyframes.values().stream().toList().get(1).right();
                }
                List<Pair<Interpolator<T>, T>> list2 = this.keyframes.values().stream().toList();
                Intrinsics.checkNotNullExpressionValue(list2, (String)"toList(...)");
                this.currentValue = ((Pair)CollectionsKt.first(list2)).right();
                this.keyframe = 0;
                this.keyframeTime = 0;
                this.time = 0;
            }
            this.onAnimationEnd(false, null, this.currentValue, this.length);
        } else {
            this.time = this.loops ? (this.time + 1) % this.length : this.time + 1;
            ++this.keyframeTime;
        }
        this.nextValue = this.keyframes.values().stream().toList().get(Math.min(this.keyframe + 1, this.keyframes.size() - 1)).right();
        this.lastValue = this.keyframes.values().stream().toList().get(Math.max(this.keyframe - 1, 0)).right();
        this.secondNextValue = this.keyframes.values().stream().toList().get(Math.min(this.keyframe + 2, this.keyframes.size() - 1)).right();
        Pair<Interpolator<T>, T> pair = this.keyframes.get(this.currentKeyframeStartTime);
        Intrinsics.checkNotNull(pair);
        this.currentInterpolator = pair.left();
        this.currentKeyframeStartTime = first;
        this.currentValue = this.keyframes.values().stream().toList().get(this.keyframe).right();
    }

    @Nullable
    public final T blend(@NotNull VarAnimation<T> max, float weight, @NotNull Easing blendEasing, int minTime, int maxTime) {
        Intrinsics.checkNotNullParameter(max, (String)"max");
        Intrinsics.checkNotNullParameter((Object)blendEasing, (String)"blendEasing");
        if (this.keyframeCount < 2 || max.keyframeCount < 2) {
            return null;
        }
        Interpolator<T> interpolator = this.genericInterpolator;
        Intrinsics.checkNotNull(interpolator);
        T t = this.getValueAtTime(minTime);
        Intrinsics.checkNotNull(t);
        T t2 = max.getValueAtTime(maxTime);
        Intrinsics.checkNotNull(t2);
        return interpolator.withEasing(blendEasing, weight, t, t2);
    }

    @JvmOverloads
    @Nullable
    public final T blend(@NotNull VarAnimation<T> max, float weight, @NotNull Easing blendEasing) {
        Intrinsics.checkNotNullParameter(max, (String)"max");
        Intrinsics.checkNotNullParameter((Object)blendEasing, (String)"blendEasing");
        if (this.keyframeCount < 2 || max.keyframeCount < 2) {
            return null;
        }
        Interpolator<Object> interpolator = this.genericInterpolator;
        Intrinsics.checkNotNull(interpolator);
        Object object = VarAnimation.get$default(this, 0.0f, 1, null);
        Intrinsics.checkNotNull((Object)object);
        Object object2 = VarAnimation.get$default(max, 0.0f, 1, null);
        Intrinsics.checkNotNull((Object)object2);
        return (T)interpolator.withEasing(blendEasing, weight, object, object2);
    }

    public static /* synthetic */ Object blend$default(VarAnimation varAnimation, VarAnimation varAnimation2, float f, Easing easing, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blend");
        }
        if ((n & 4) != 0) {
            easing = Easing.Companion.getLINEAR();
        }
        return varAnimation.blend(varAnimation2, f, easing);
    }

    @JvmOverloads
    public final void stop(boolean notify) {
        if (this.keyframeCount < 2) {
            return;
        }
        if (notify) {
            this.onStopped(this.baked, this.currentInterpolator, this.currentValue, this.time);
        }
        this.onPlaybackFunction(true);
        this.time = 0;
        this.playing = false;
        if (!this.baked) {
            this.currentInterpolator = this.genericInterpolator;
            this.keyframeTime = 0;
            this.keyframe = 0;
            this.keyframeLength = this.getIndexedKeyTime(1);
            Pair<Interpolator<T>, T> pair = this.getIndexedKeyValue(0);
            Intrinsics.checkNotNull(pair);
            this.currentValue = pair.right();
            this.currentKeyframeStartTime = this.getIndexedKeyTime(0);
            this.nextKeyframeStartTime = this.getIndexedKeyTime(1);
        }
    }

    public static /* synthetic */ void stop$default(VarAnimation varAnimation, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
        }
        if ((n & 1) != 0) {
            bl = true;
        }
        varAnimation.stop(bl);
    }

    public final void pause() {
        this.playing = false;
        if (this.keyframeCount > 1) {
            this.onPaused(this.baked, this.currentInterpolator, this.currentValue, this.time);
        }
    }

    @JvmOverloads
    public final void play(boolean fromStart, boolean notifyStopped) {
        if (this.keyframeCount < 2) {
            return;
        }
        if (fromStart) {
            this.stop(notifyStopped);
        } else {
            this.onPlaybackFunction(false);
        }
        this.playing = true;
        this.onPlayed(this.baked, this.currentInterpolator, this.currentValue, this.time);
    }

    public static /* synthetic */ void play$default(VarAnimation varAnimation, boolean bl, boolean bl2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = true;
        }
        varAnimation.play(bl, bl2);
    }

    private final void onPlaybackFunction(boolean fromStart) {
        if (this.keyframeCount < 2) {
            return;
        }
        if (fromStart) {
            Object object;
            List<Pair<Interpolator<T>, T>> list = this.keyframes.values().stream().toList();
            Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
            this.currentValue = ((Pair)CollectionsKt.first(list)).right();
            this.nextValue = this.keyframes.values().stream().toList().get(1).right();
            List list2 = this.keyframes.keySet().stream().toList();
            Intrinsics.checkNotNullExpressionValue(list2, (String)"toList(...)");
            Object object2 = CollectionsKt.first(list2);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"first(...)");
            int first = ((Number)object2).intValue();
            Integer second = (Integer)this.keyframes.keySet().stream().toList().get(1);
            this.keyframeLength = second - first;
            Intrinsics.checkNotNull((Object)second);
            this.nextKeyframeStartTime = second;
            this.currentKeyframeStartTime = first;
            this.keyframeTime = 0;
            this.time = 0;
            this.keyframe = 0;
            this.lastValue = null;
            if (1 < this.keyframes.size()) {
                object = this.keyframes.values().stream().toList().get(1).right();
            } else {
                List<Pair<Interpolator<T>, T>> list3 = this.keyframes.values().stream().toList();
                Intrinsics.checkNotNullExpressionValue(list3, (String)"toList(...)");
                object = ((Pair)CollectionsKt.last(list3)).right();
            }
            this.secondNextValue = object;
        } else {
            int first;
            List list = this.keyframes.keySet().stream().toList();
            Intrinsics.checkNotNullExpressionValue(list, (String)"toList(...)");
            Object object = CollectionsKt.first(list);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"first(...)");
            int second = first = ((Number)object).intValue();
            this.currentValue = this.keyframes.values().stream().toList().get(this.keyframe).right();
            if (this.hasNext()) {
                Object e = this.keyframes.keySet().stream().toList().get(this.keyframe + 1);
                Intrinsics.checkNotNullExpressionValue(e, (String)"get(...)");
                second = ((Number)e).intValue();
                this.nextValue = this.keyframes.values().stream().toList().get(this.keyframe + 1).right();
            }
            if (this.keyframe - 1 > -1) {
                this.lastValue = this.keyframes.values().stream().toList().get(this.keyframe - 1).right();
            }
            this.nextKeyframeStartTime = second;
            this.keyframeLength = second - first;
        }
    }

    @NotNull
    public final VarAnimation<T> copy() {
        VarAnimation copied = new VarAnimation(this.loops, this.length);
        for (Map.Entry entry : ((Map)this.keyframes).entrySet()) {
            copied.key(((Number)entry.getKey()).intValue(), (Interpolator)((Pair)entry.getValue()).left(), ((Pair)entry.getValue()).right());
        }
        return copied;
    }

    public final void forEachValue(@NotNull Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Collection<Pair<Interpolator<T>, T>> collection = this.keyframes.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair)element$iv;
            boolean bl = false;
            consumer.accept(pair.right());
        }
    }

    @NotNull
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Map $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            int k = ((Number)entry.getKey()).intValue();
            Pair v = (Pair)entry.getValue();
            builder.append("time: " + k + ", easing: " + Reflection.getOrCreateKotlinClass(((Interpolator)v.left()).easing.getClass()).getSimpleName() + ", value: " + v.right() + "\n");
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    public final void onKeyframeAdded(@Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onStopped(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onPaused(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onPlayed(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onAnimationEnd(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onTickStart(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    public final void onTickEnd(boolean baked, @Nullable Interpolator<T> interpolator, @Nullable T value, int time2) {
    }

    @Nullable
    public final Pair<Integer, Integer> getKeyPair(int index) {
        Pair<Integer, Integer> pair;
        if (this.baked) {
            return null;
        }
        if (this.keyframeCount < 2) {
            return null;
        }
        if (this.nextKeyframeExists(index)) {
            Set<Integer> set = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Integer n = thisCollection$iv.toArray(new Integer[0])[index];
            Set<Integer> set2 = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set2, (String)"<get-keys>(...)");
            $this$toTypedArray$iv = set2;
            $i$f$toTypedArray = false;
            thisCollection$iv = $this$toTypedArray$iv;
            Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(n, thisCollection$iv.toArray(new Integer[0])[index + 1]);
            pair = pair2;
        } else if (index >= this.keyframeCount - 1) {
            Set<Integer> set = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Integer n = thisCollection$iv.toArray(new Integer[0])[this.keyframeCount - 2];
            Set<Integer> set3 = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set3, (String)"<get-keys>(...)");
            $this$toTypedArray$iv = set3;
            $i$f$toTypedArray = false;
            thisCollection$iv = $this$toTypedArray$iv;
            Pair<Integer, Integer> pair3 = new Pair<Integer, Integer>(n, thisCollection$iv.toArray(new Integer[0])[this.keyframeCount - 1]);
            pair = pair3;
        } else {
            Set<Integer> set = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Integer n = thisCollection$iv.toArray(new Integer[0])[0];
            Set<Integer> set4 = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set4, (String)"<get-keys>(...)");
            $this$toTypedArray$iv = set4;
            $i$f$toTypedArray = false;
            thisCollection$iv = $this$toTypedArray$iv;
            Pair<Integer, Integer> pair4 = new Pair<Integer, Integer>(n, thisCollection$iv.toArray(new Integer[0])[1]);
            pair = pair4;
        }
        return pair;
    }

    @Nullable
    public final Pair<Integer, Integer> getClosestKeyPair(int time2) {
        if (!this.baked) {
            Set<Integer> set = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Object[] keyTimes = thisCollection$iv.toArray(new Integer[0]);
            Arrays.sort(keyTimes);
            int n = this.keyframeCount - 1;
            for (int i = 0; i < n; ++i) {
                Object object = keyTimes[i];
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
                int minKeyTime = ((Number)object).intValue();
                Object object2 = keyTimes[i + 1];
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
                int maxKeyTime = ((Number)object2).intValue();
                if (minKeyTime - time2 >= 0) {
                    return new Pair<Object, Object>(keyTimes[i], keyTimes[i + 1]);
                }
                if (maxKeyTime - time2 < 0) continue;
                return new Pair<Object, Object>(keyTimes[i], keyTimes[i + 1]);
            }
        }
        return null;
    }

    @Nullable
    public final T getValueAtTime(int time2) {
        return this.getValueAtTime(time2, 0.0f);
    }

    public final T getValueAtTime(int time2, float tickDelta, T fallback) {
        T t = this.getValueAtTime(time2, 0.0f);
        if (t == null) {
            t = fallback;
        }
        return t;
    }

    @NotNull
    public final Class<T> getType() {
        if (!this.keyframes.isEmpty()) {
            Object value;
            Object b = value = ((Pair)CollectionsKt.first((List)new ArrayList<Pair<Interpolator<T>, T>>(this.keyframes.values()))).right();
            Intrinsics.checkNotNull(b);
            Class<?> clazz = b.getClass();
            Intrinsics.checkNotNull(clazz, (String)"null cannot be cast to non-null type java.lang.Class<T of net.thebrokenscript.brokencore.api.animation.value_animation.VarAnimation>");
            return clazz;
        }
        throw new RuntimeException("Cant get type with no keyframes");
    }

    public static /* synthetic */ void getType$annotations() {
    }

    @JvmOverloads
    @Nullable
    public final T get(float frameDelta) {
        T t;
        if (this.keyframeCount < 2) {
            return null;
        }
        if (this.currentValue == null || this.nextValue == null || this.currentInterpolator == null) {
            T t2;
            if (this.baked) {
                T[] TArray = this.bakedFrames;
                if (this.bakedFrames == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"bakedFrames");
                    TArray = null;
                }
                t2 = TArray[0];
            } else {
                Pair<Interpolator<T>, T> pair = this.getIndexedKeyValue(0);
                Intrinsics.checkNotNull(pair);
                t2 = pair.right();
            }
            return t2;
        }
        Interpolator<T> interpolator = this.currentInterpolator;
        Intrinsics.checkNotNull(interpolator);
        float f = this.getCurrentKeyframeProgress(frameDelta);
        T t3 = this.currentValue;
        Intrinsics.checkNotNull(t3);
        T t4 = this.nextValue;
        Intrinsics.checkNotNull(t4);
        if (this.lastValue != null) {
            T t5 = this.lastValue;
            t = t5;
            Intrinsics.checkNotNull(t5);
        } else {
            T t6 = this.currentValue;
            t = t6;
            Intrinsics.checkNotNull(t6);
        }
        T t7 = this.secondNextValue;
        Intrinsics.checkNotNull(t7);
        return interpolator.interpolate(f, t3, t4, t, t7);
    }

    public static /* synthetic */ Object get$default(VarAnimation varAnimation, float f, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((n & 1) != 0) {
            f = 0.0f;
        }
        return varAnimation.get(f);
    }

    @Nullable
    public final T getValueAtTime(int time2, float tickDelta) {
        if (this.baked) {
            T[] TArray = this.bakedFrames;
            if (this.bakedFrames == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"bakedFrames");
                TArray = null;
            }
            return TArray[time2];
        }
        Pair<Integer, Integer> pair = this.getClosestKeyPair(time2);
        if (pair != null) {
            int min = ((Number)pair.left()).intValue();
            int max = ((Number)pair.right()).intValue();
            Pair<Interpolator<T>, T> pair2 = this.keyframes.get(min);
            Intrinsics.checkNotNull(pair2);
            Pair<Interpolator<T>, T> left = pair2;
            Pair<Interpolator<T>, T> pair3 = this.keyframes.get(max);
            Intrinsics.checkNotNull(pair3);
            Pair<Interpolator<T>, T> right = pair3;
            T minVal = left.right();
            T maxVal = right.right();
            Interpolator<T> interpolator = left.left();
            float delta = ((float)time2 + tickDelta - (float)min) / (float)(max - min);
            return interpolator.interpolate(delta, minVal, maxVal);
        }
        return null;
    }

    @Nullable
    public final T currentKeyValue() {
        Pair<Interpolator<T>, T> pair = this.keyframes.values().stream().toList().get(this.keyframe);
        return (T)(pair != null ? pair.right() : null);
    }

    @Nullable
    public final Pair<Interpolator<T>, T> getIndexedKeyValue(int index) {
        Pair pair;
        if (this.baked) {
            pair = null;
        } else {
            Collection<Pair<Interpolator<Pair>, Pair>> collection = this.keyframes.values();
            Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
            Collection<Pair<Interpolator<Pair>, Pair>> $this$toTypedArray$iv = collection;
            boolean $i$f$toTypedArray = false;
            Collection<Pair<Interpolator<Pair>, Pair>> thisCollection$iv = $this$toTypedArray$iv;
            pair = thisCollection$iv.toArray(new Pair[0])[index];
        }
        return pair;
    }

    public final boolean nextKeyframeExists(int index) {
        return index >= 0 && index < this.keyframeCount - 1;
    }

    public final boolean hasNext() {
        return this.keyframe + 1 < this.keyframes.size();
    }

    public final boolean hasKeyAtTime(int time2) {
        return this.getIndexForTime(time2) != -1;
    }

    public final boolean isPlaying() {
        return this.playing && this.keyframeCount > 1;
    }

    public final boolean loops() {
        return this.loops;
    }

    public final boolean isEmpty() {
        return this.keyframeCount == 0;
    }

    public final float getCurrentKeyframeProgress(float frameDelta) {
        return this.baked ? 0.0f : VarAnimation.Companion.lerp(frameDelta, this.keyframeTime, this.keyframeTime + 1) / (float)(this.keyframeLength > 0 ? this.keyframeLength : 1);
    }

    public final float getCurrentKeyframeProgress() {
        return this.getCurrentKeyframeProgress(0.0f);
    }

    public final float getDeltaForTime(int time2) {
        Pair<Integer, Integer> pair;
        if (!this.baked && (pair = this.getClosestKeyPair(time2)) != null) {
            int min = ((Number)pair.left()).intValue();
            int max = ((Number)pair.right()).intValue();
            return (float)(time2 - min) / (float)max;
        }
        return 0.0f;
    }

    public final int getIndexedKeyTime(int index) {
        int n;
        if (this.baked) {
            n = 0;
        } else {
            Set<Integer> set = this.keyframes.keySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
            Collection $this$toTypedArray$iv = set;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Integer n2 = thisCollection$iv.toArray(new Integer[0])[index];
            Intrinsics.checkNotNullExpressionValue((Object)n2, (String)"get(...)");
            n = ((Number)n2).intValue();
        }
        return n;
    }

    public final int getIndexForTime(int time2) {
        int i = 0;
        for (Integer n : this.keyframes.keySet()) {
            Intrinsics.checkNotNullExpressionValue((Object)n, (String)"next(...)");
            int t = ((Number)n).intValue();
            if (t == time2) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public final int getCurrentKeyframeStartTime() {
        return this.baked ? 0 : this.currentKeyframeStartTime;
    }

    public final int getKeyframe() {
        return this.baked ? 0 : this.keyframe;
    }

    public final int getKeyframeLength() {
        return this.baked ? 0 : this.keyframeLength;
    }

    public final int getKeyframeTime() {
        return this.baked ? 0 : this.keyframeTime;
    }

    public final int getNextKeyframeStartTime() {
        return this.baked ? 0 : this.nextKeyframeStartTime;
    }

    @NotNull
    public final List<Integer> getKeyTimes() {
        Set<Integer> set = this.keyframes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
        return CollectionsKt.toList((Iterable)set);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<T> getValues() {
        void $this$mapTo$iv$iv;
        Collection<Pair<Interpolator<T>, T>> collection = this.keyframes.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        List lst = CollectionsKt.toList((Iterable)collection);
        Iterable $this$map$iv = lst;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Pair pair = (Pair)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl = false;
            collection2.add(it.right());
        }
        return (List)destination$iv$iv;
    }

    @JvmOverloads
    @Nullable
    public final T blend(@NotNull VarAnimation<T> max, float weight) {
        Intrinsics.checkNotNullParameter(max, (String)"max");
        return (T)VarAnimation.blend$default(this, max, weight, null, 4, null);
    }

    @JvmOverloads
    public final void stop() {
        VarAnimation.stop$default(this, false, 1, null);
    }

    @JvmOverloads
    public final void play(boolean fromStart) {
        VarAnimation.play$default(this, fromStart, false, 2, null);
    }

    @JvmOverloads
    public final void play() {
        VarAnimation.play$default(this, false, false, 3, null);
    }

    @JvmOverloads
    @Nullable
    public final T get() {
        return (T)VarAnimation.get$default(this, 0.0f, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation$Companion;", "", "<init>", "()V", "lerp", "", "delta", "start", "end", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final float lerp(float delta, float start, float end) {
            return start + delta * (end - start);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00028\u0002H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00012\b\b\u0002\u0010\u0005\u001a\u00028\u0002H\u00c6\u0001\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0004\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation$Pair;", "A", "B", "Ljava/lang/Record;", "left", "right", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation$Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "brokencore-common"})
    public static final class Pair<A, B>
    extends Record {
        private final A left;
        private final B right;

        public Pair(A left, B right) {
            this.left = left;
            this.right = right;
        }

        public final A left() {
            return this.left;
        }

        public final B right() {
            return this.right;
        }

        public final A component1() {
            return this.left;
        }

        public final B component2() {
            return this.right;
        }

        @NotNull
        public final Pair<A, B> copy(A left, B right) {
            return new Pair<A, B>(left, right);
        }

        public static /* synthetic */ Pair copy$default(Pair pair, Object object, Object object2, int n, Object object3) {
            if ((n & 1) != 0) {
                object = pair.left;
            }
            if ((n & 2) != 0) {
                object2 = pair.right;
            }
            return pair.copy(object, object2);
        }

        @Override
        @NotNull
        public String toString() {
            return "Pair(left=" + this.left + ", right=" + this.right + ")";
        }

        @Override
        public int hashCode() {
            int result = this.left == null ? 0 : this.left.hashCode();
            result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
            return result;
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair)other;
            if (!Intrinsics.areEqual(this.left, pair.left)) {
                return false;
            }
            return Intrinsics.areEqual(this.right, pair.right);
        }
    }
}


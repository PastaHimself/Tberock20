/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.animation.value_animation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.animation.value_animation.VarAnimation;
import net.thebrokenscript.brokencore.api.animation.value_animation.interpolator.Interpolator;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00019BE\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0000J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0012\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u0007J\u001c\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u0007J6\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005j\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u0003`\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J.\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005j\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u0003`\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000JB\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005j\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u0003`\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020!H\u0007J\u001c\u0010+\u001a\n\u0012\u0004\u0012\u0002H,\u0018\u00010\u0007\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020\u0006J#\u0010+\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0006\u00a2\u0006\u0002\u00105J\u001e\u0010+\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0002\b\u00030\u00052\b\b\u0002\u0010\"\u001a\u00020\u001eH\u0007J\u001e\u00106\u001a\u00020\u00142\u0016\u00107\u001a\u0012\u0012\f\b\u0000\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0018\u000108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R5\u0010$\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0005j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001e`\b8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R5\u0010'\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n`\b8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010&R)\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005j\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u0003`\b8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010&R-\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010&R9\u00100\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n010\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01`\b8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010&R-\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b8F\u00a2\u0006\u0006\u001a\u0004\b4\u0010&\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation;", "", "loops", "", "animations", "Ljava/util/HashMap;", "", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "Lkotlin/collections/HashMap;", "length", "", "<init>", "(ZLjava/util/HashMap;I)V", "value", "time", "getTime", "()I", "isPlaying", "()Z", "tick", "", "copy", "toString", "pause", "stop", "notify", "play", "fromStart", "blend", "blendWeight", "", "animation", "easing", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "frameDelta", "blendeasing", "progress", "getProgress", "()Ljava/util/HashMap;", "currentLengths", "getCurrentLengths", "keyValues", "getKeyValues", "get", "T", "key", "currentKeyframes", "getCurrentKeyframes", "keyTimes", "", "getKeyTimes", "currentTimes", "getCurrentTimes", "(FLjava/lang/String;)Ljava/lang/Object;", "forEachAnimation", "consumer", "Ljava/util/function/Consumer;", "Builder", "brokencore-common"})
@ExperimentalAnimationApi
@SourceDebugExtension(value={"SMAP\nMultiVarAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiVarAnimation.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,227:1\n216#2,2:228\n*S KotlinDebug\n*F\n+ 1 MultiVarAnimation.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation\n*L\n46#1:228,2\n*E\n"})
public final class MultiVarAnimation {
    private final boolean loops;
    @NotNull
    private final HashMap<String, VarAnimation<?>> animations;
    private final int length;
    private int time;
    private boolean isPlaying;

    private MultiVarAnimation(boolean loops, HashMap<String, VarAnimation<?>> animations, int length) {
        this.loops = loops;
        this.animations = animations;
        this.length = length;
    }

    public final int getTime() {
        return this.time;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void tick() {
        VarAnimation<?> animation;
        Iterator<VarAnimation<?>> iterator = this.animations.values().iterator();
        while (iterator.hasNext()) {
            Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
            if (!animation.isPlaying()) continue;
            animation.tick();
        }
        if (this.loops && this.time >= this.length) {
            this.time = 0;
            iterator = this.animations.values().iterator();
            while (iterator.hasNext()) {
                Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
                VarAnimation.play$default(animation, true, false, 2, null);
            }
        }
        if (this.loops) {
            this.time = (this.time + 1) % (this.length + 1);
        } else if (this.time < this.length) {
            ++this.time;
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final MultiVarAnimation copy() {
        void var3_4;
        void $this$copy_u24lambda_u240;
        MultiVarAnimation multiVarAnimation = this;
        boolean bl = this.loops;
        boolean bl2 = false;
        HashMap map = new HashMap();
        for (Map.Entry entry : ((Map)$this$copy_u24lambda_u240.animations).entrySet()) {
            ((Map)map).put(entry.getKey(), ((VarAnimation)entry.getValue()).copy());
        }
        void var7_7 = var3_4;
        int n = this.length;
        void var9_9 = var7_7;
        boolean bl3 = bl;
        return new MultiVarAnimation(bl3, (HashMap<String, VarAnimation<?>>)var9_9, n);
    }

    @NotNull
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Map $this$forEach$iv = this.animations;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            String string = (String)entry.getKey();
            VarAnimation animation = (VarAnimation)entry.getValue();
            builder.append("name:" + string + ", keyframes:\n" + animation);
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    public final void pause() {
        this.isPlaying = false;
    }

    @JvmOverloads
    public final void stop(boolean notify) {
        Iterator<VarAnimation<?>> iterator = this.animations.values().iterator();
        while (iterator.hasNext()) {
            VarAnimation<?> animation;
            Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
            animation.stop(true);
        }
        this.isPlaying = false;
        this.time = 0;
    }

    public static /* synthetic */ void stop$default(MultiVarAnimation multiVarAnimation, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        multiVarAnimation.stop(bl);
    }

    @JvmOverloads
    public final void play(boolean fromStart, boolean notify) {
        if (fromStart) {
            this.time = 0;
        }
        Iterator<VarAnimation<?>> iterator = this.animations.values().iterator();
        while (iterator.hasNext()) {
            VarAnimation<?> animation;
            Intrinsics.checkNotNullExpressionValue(iterator.next(), (String)"next(...)");
            animation.play(fromStart, notify);
        }
        this.isPlaying = true;
    }

    public static /* synthetic */ void play$default(MultiVarAnimation multiVarAnimation, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        multiVarAnimation.play(bl, bl2);
    }

    @NotNull
    public final HashMap<String, ?> blend(float blendWeight, @NotNull MultiVarAnimation animation, @NotNull Easing easing) {
        Intrinsics.checkNotNullParameter((Object)animation, (String)"animation");
        Intrinsics.checkNotNullParameter((Object)easing, (String)"easing");
        return this.blend(blendWeight, 0.0f, animation, easing);
    }

    @NotNull
    public final HashMap<String, ?> blend(float blendWeight, @NotNull MultiVarAnimation animation) {
        Intrinsics.checkNotNullParameter((Object)animation, (String)"animation");
        return this.blend(blendWeight, 0.0f, animation, Easing.Companion.getLINEAR());
    }

    @JvmOverloads
    @NotNull
    public final HashMap<String, ?> blend(float blendWeight, float frameDelta, @NotNull MultiVarAnimation animation, @NotNull Easing blendeasing) {
        Intrinsics.checkNotNullParameter((Object)animation, (String)"animation");
        Intrinsics.checkNotNullParameter((Object)blendeasing, (String)"blendeasing");
        HashMap map = new HashMap();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            VarAnimation<?> anim = animation.animations.get(key);
            if (anim != null) {
                Map map2 = map;
                VarAnimation<?> varAnimation = this.animations.get(key);
                Intrinsics.checkNotNull(varAnimation, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.animation.value_animation.VarAnimation<kotlin.Any>");
                Object object = VarAnimation.blend$default(varAnimation, anim, blendWeight, null, 4, null);
                map2.put(key, object);
                continue;
            }
            Map map3 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map3.put(key, varAnimation.get(frameDelta));
        }
        return map;
    }

    public static /* synthetic */ HashMap blend$default(MultiVarAnimation multiVarAnimation, float f, float f2, MultiVarAnimation multiVarAnimation2, Easing easing, int n, Object object) {
        if ((n & 8) != 0) {
            easing = Easing.Companion.getLINEAR();
        }
        return multiVarAnimation.blend(f, f2, multiVarAnimation2, easing);
    }

    @NotNull
    public final HashMap<String, Float> getProgress() {
        HashMap<String, Float> map = new HashMap<String, Float>();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, Float.valueOf(varAnimation.getCurrentKeyframeProgress()));
        }
        return map;
    }

    @NotNull
    public final HashMap<String, Integer> getCurrentLengths() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.getKeyframeLength());
        }
        return map;
    }

    @NotNull
    public final HashMap<String, ?> getKeyValues() {
        HashMap map = new HashMap();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.getValues());
        }
        return map;
    }

    @Nullable
    public final <T> VarAnimation<T> get(@NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return this.animations.get(key);
    }

    @NotNull
    public final HashMap<String, Integer> getCurrentKeyframes() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.getKeyframe());
        }
        return map;
    }

    @NotNull
    public final HashMap<String, List<Integer>> getKeyTimes() {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.getKeyTimes());
        }
        return map;
    }

    @NotNull
    public final HashMap<String, Integer> getCurrentTimes() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.getTime());
        }
        return map;
    }

    @Nullable
    public final <T> T get(float frameDelta, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        VarAnimation<?> varAnimation = this.animations.get(key);
        return (T)(varAnimation != null ? varAnimation.get(frameDelta) : null);
    }

    @JvmOverloads
    @NotNull
    public final HashMap<String, ?> get(float frameDelta) {
        HashMap map = new HashMap();
        Iterator<String> iterator = this.animations.keySet().iterator();
        while (iterator.hasNext()) {
            String key;
            Intrinsics.checkNotNullExpressionValue((Object)iterator.next(), (String)"next(...)");
            Map map2 = map;
            VarAnimation<?> varAnimation = this.animations.get(key);
            Intrinsics.checkNotNull(varAnimation);
            map2.put(key, varAnimation.get(frameDelta));
        }
        return map;
    }

    public static /* synthetic */ HashMap get$default(MultiVarAnimation multiVarAnimation, float f, int n, Object object) {
        if ((n & 1) != 0) {
            f = 0.0f;
        }
        return multiVarAnimation.get(f);
    }

    public final void forEachAnimation(@Nullable Consumer<? super VarAnimation<?>> consumer) {
        this.animations.values().forEach(consumer);
    }

    @JvmOverloads
    public final void stop() {
        MultiVarAnimation.stop$default(this, false, 1, null);
    }

    @JvmOverloads
    public final void play(boolean fromStart) {
        MultiVarAnimation.play$default(this, fromStart, false, 2, null);
    }

    @JvmOverloads
    public final void play() {
        MultiVarAnimation.play$default(this, false, false, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final HashMap<String, ?> blend(float blendWeight, float frameDelta, @NotNull MultiVarAnimation animation) {
        Intrinsics.checkNotNullParameter((Object)animation, (String)"animation");
        return MultiVarAnimation.blend$default(this, blendWeight, frameDelta, animation, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final HashMap<String, ?> get() {
        return MultiVarAnimation.get$default(this, 0.0f, 1, null);
    }

    public /* synthetic */ MultiVarAnimation(boolean loops, HashMap animations, int length, DefaultConstructorMarker $constructor_marker) {
        this(loops, animations, length);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006J/\u0010\u0013\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0018\u00a2\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0014\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder;", "", "<init>", "()V", "animations", "Ljava/util/HashMap;", "", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "Lkotlin/collections/HashMap;", "currentAnimation", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder$SubBuilder;", "currentKey", "currentLength", "", "build", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation;", "loops", "", "next", "key", "T", "time", "value", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "(ILjava/lang/Object;Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;)Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder;", "add", "animation", "addInternal", "", "SubBuilder", "Companion", "brokencore-common"})
    public static final class Builder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final HashMap<String, VarAnimation<?>> animations = new HashMap();
        @Nullable
        private SubBuilder<?> currentAnimation;
        @Nullable
        private String currentKey;
        private int currentLength;

        private Builder() {
        }

        @NotNull
        public final MultiVarAnimation build(boolean loops) {
            if (this.currentAnimation != null) {
                SubBuilder<?> subBuilder = this.currentAnimation;
                Intrinsics.checkNotNull(subBuilder);
                this.addInternal(subBuilder.getAnimation());
            }
            return new MultiVarAnimation(loops, this.animations, this.currentLength, null);
        }

        @NotNull
        public final Builder next(@NotNull String key) {
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            SubBuilder<?> subBuilder = this.currentAnimation;
            Intrinsics.checkNotNull(subBuilder);
            this.addInternal(subBuilder.getAnimation());
            this.currentKey = key;
            return this;
        }

        @NotNull
        public final <T> Builder key(int time2, T value, @NotNull Interpolator<T> interpolator) {
            Intrinsics.checkNotNullParameter(interpolator, (String)"interpolator");
            if (this.currentAnimation == null) {
                this.currentAnimation = new SubBuilder(new VarAnimation(false));
            }
            SubBuilder<?> subBuilder = this.currentAnimation;
            Intrinsics.checkNotNull(subBuilder, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.animation.value_animation.MultiVarAnimation.Builder.SubBuilder<T of net.thebrokenscript.brokencore.api.animation.value_animation.MultiVarAnimation.Builder.key>");
            subBuilder.key(value, time2, interpolator);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String key, @NotNull VarAnimation<?> animation) {
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Intrinsics.checkNotNullParameter(animation, (String)"animation");
            this.currentLength = Math.max(animation.getLength(), this.currentLength);
            ((Map)this.animations).put(key, animation);
            return this;
        }

        private final void addInternal(VarAnimation<?> animation) {
            Map map = this.animations;
            String string = this.currentKey;
            Intrinsics.checkNotNull((Object)string);
            map.put(string, animation);
            this.currentAnimation = null;
        }

        public /* synthetic */ Builder(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder$Companion;", "", "<init>", "()V", "create", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder;", "brokencore-common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Builder create() {
                return new Builder(null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a2\u0006\u0002\u0010\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/MultiVarAnimation$Builder$SubBuilder;", "T", "", "animation", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;)V", "getAnimation", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/VarAnimation;", "key", "", "value", "time", "", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;", "(Ljava/lang/Object;ILnet/thebrokenscript/brokencore/api/animation/value_animation/interpolator/Interpolator;)V", "brokencore-common"})
        private static final class SubBuilder<T> {
            @NotNull
            private final VarAnimation<T> animation;

            public SubBuilder(@NotNull VarAnimation<T> animation) {
                Intrinsics.checkNotNullParameter(animation, (String)"animation");
                this.animation = animation;
            }

            @NotNull
            public final VarAnimation<T> getAnimation() {
                return this.animation;
            }

            public final void key(T value, int time2, @NotNull Interpolator<T> interpolator) {
                Intrinsics.checkNotNullParameter(interpolator, (String)"interpolator");
                this.animation.key(time2, interpolator, value);
            }
        }
    }
}


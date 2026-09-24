/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.Mth
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.animation.value_animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\bf\u0018\u0000 \u00122\u00020\u0001:\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "", "ease", "", "t", "b", "c", "d", "prevB", "nextC", "Elastic", "ElasticIn", "ElasticOut", "ElasticInOut", "Back", "BackIn", "BackOut", "BackInOut", "Companion", "brokencore-common"})
public interface Easing {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.animation.value_animation.Easing$Companion.$$INSTANCE;

    public float ease(float var1, float var2, float var3, float var4);

    public float ease(float var1, float var2, float var3, float var4, float var5, float var6);

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "overshoot", "", "<init>", "(F)V", "getOvershoot", "()F", "setOvershoot", "Companion", "brokencore-common"})
    public static class Back
    implements Easing {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private float overshoot;
        public static final float DEFAULT_OVERSHOOT = 1.70158f;

        @JvmOverloads
        public Back(float overshoot) {
            this.overshoot = overshoot;
        }

        public /* synthetic */ Back(float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                f = 1.70158f;
            }
            this(f);
        }

        public final float getOvershoot() {
            return this.overshoot;
        }

        public final void setOvershoot(float f) {
            this.overshoot = f;
        }

        @JvmOverloads
        public Back() {
            this(0.0f, 1, null);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back$Companion;", "", "<init>", "()V", "DEFAULT_OVERSHOOT", "", "brokencore-common"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackIn;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "<init>", "()V", "overshoot", "", "(F)V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackIn\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class BackIn
    extends Back {
        public BackIn() {
            super(0.0f, 1, null);
        }

        public BackIn(float overshoot) {
            super(overshoot);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float ease(float t, float b, float c, float d) {
            void it;
            float t2 = 0.0f;
            t2 = t;
            float s = this.getOvershoot();
            float f = d;
            float f2 = c;
            boolean bl = false;
            float f3 = t2 /= it;
            return f2 * f3 * t2 * ((s + 1.0f) * t2 - s) + b;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackInOut;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "<init>", "()V", "overshoot", "", "(F)V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackInOut\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class BackInOut
    extends Back {
        public BackInOut() {
            super(0.0f, 1, null);
        }

        public BackInOut(float overshoot) {
            super(overshoot);
        }

        @Override
        public float ease(float t, float b, float c, float d) {
            int it2;
            float t2 = 0.0f;
            t2 = t;
            float s = 0.0f;
            s = this.getOvershoot();
            int n = 2;
            float f = d;
            boolean bl = false;
            float f2 = t2 /= (float)it2;
            if (f / f2 < 1.0f) {
                float it2 = 1.525f;
                f2 = t2 * t2;
                f = c / (float)2;
                boolean bl2 = false;
                float f3 = s *= it2;
                return f * (f2 * ((f3 + 1.0f) * t2 - s)) + b;
            }
            it2 = 2;
            f = c / (float)2;
            boolean bl3 = false;
            f2 = t2 -= (float)it2;
            float it2 = 1.525f;
            boolean bl4 = false;
            float f4 = s *= it2;
            return f * ((f2 *= t2) * ((f4 + 1.0f) * t2 + s) + (float)2) + b;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackOut;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "<init>", "()V", "overshoot", "", "(F)V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$BackOut\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class BackOut
    extends Back {
        public BackOut() {
            super(0.0f, 1, null);
        }

        public BackOut(float overshoot) {
            super(overshoot);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float ease(float t, float b, float c, float d) {
            void it;
            float f;
            float t2 = 0.0f;
            t2 = t;
            float s = this.getOvershoot();
            float f2 = f = t2 / d - 1.0f;
            float f3 = c;
            boolean bl = false;
            t2 = it;
            Unit unit = Unit.INSTANCE;
            return f3 * (f * t2 * ((s + 1.0f) * t2 + s) + 1.0f) + b;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010O\u001a\u00020PR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0011\u0010\u001b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0011\u0010!\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u0011\u0010#\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0011\u0010%\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\nR\u0011\u0010'\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\nR\u0011\u0010)\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u0011\u0010+\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\nR\u0011\u0010-\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\nR\u0011\u0010/\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\nR\u0011\u00101\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\nR\u0011\u00103\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\nR\u0011\u00105\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\nR\u0011\u00107\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\nR\u0011\u00109\u001a\u00020:\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020:\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010<R\u0011\u0010?\u001a\u00020:\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010<R\u0011\u0010A\u001a\u00020B\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020B\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010DR\u0011\u0010G\u001a\u00020B\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u0011\u0010I\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010\nR\u0011\u0010K\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010\nR\u0011\u0010M\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010\n\u00a8\u0006Q"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Companion;", "", "<init>", "()V", "easingFromString", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "string", "", "STEP", "getSTEP", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "CATMULROM", "getCATMULROM", "LINEAR", "getLINEAR", "QUAD_IN", "getQUAD_IN", "QUAD_OUT", "getQUAD_OUT", "QUAD_IN_OUT", "getQUAD_IN_OUT", "CUBIC_IN", "getCUBIC_IN", "CUBIC_OUT", "getCUBIC_OUT", "CUBIC_IN_OUT", "getCUBIC_IN_OUT", "QUARTIC_IN", "getQUARTIC_IN", "QUARTIC_OUT", "getQUARTIC_OUT", "QUARTIC_IN_OUT", "getQUARTIC_IN_OUT", "QUINTIC_IN", "getQUINTIC_IN", "QUINTIC_OUT", "getQUINTIC_OUT", "QUINTIC_IN_OUT", "getQUINTIC_IN_OUT", "SINE_IN", "getSINE_IN", "SINE_OUT", "getSINE_OUT", "SINE_IN_OUT", "getSINE_IN_OUT", "EXPO_IN", "getEXPO_IN", "EXPO_OUT", "getEXPO_OUT", "EXPO_IN_OUT", "getEXPO_IN_OUT", "CIRC_IN", "getCIRC_IN", "CIRC_OUT", "getCIRC_OUT", "CIRC_IN_OUT", "getCIRC_IN_OUT", "ELASTIC_IN", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "getELASTIC_IN", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "ELASTIC_OUT", "getELASTIC_OUT", "ELASTIC_IN_OUT", "getELASTIC_IN_OUT", "BACK_IN", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "getBACK_IN", "()Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Back;", "BACK_OUT", "getBACK_OUT", "BACK_IN_OUT", "getBACK_IN_OUT", "BOUNCE_IN", "getBOUNCE_IN", "BOUNCE_OUT", "getBOUNCE_OUT", "BOUNCE_IN_OUT", "getBOUNCE_IN_OUT", "byIndex", "", "brokencore-common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Easing STEP;
        @NotNull
        private static final Easing CATMULROM;
        @NotNull
        private static final Easing LINEAR;
        @NotNull
        private static final Easing QUAD_IN;
        @NotNull
        private static final Easing QUAD_OUT;
        @NotNull
        private static final Easing QUAD_IN_OUT;
        @NotNull
        private static final Easing CUBIC_IN;
        @NotNull
        private static final Easing CUBIC_OUT;
        @NotNull
        private static final Easing CUBIC_IN_OUT;
        @NotNull
        private static final Easing QUARTIC_IN;
        @NotNull
        private static final Easing QUARTIC_OUT;
        @NotNull
        private static final Easing QUARTIC_IN_OUT;
        @NotNull
        private static final Easing QUINTIC_IN;
        @NotNull
        private static final Easing QUINTIC_OUT;
        @NotNull
        private static final Easing QUINTIC_IN_OUT;
        @NotNull
        private static final Easing SINE_IN;
        @NotNull
        private static final Easing SINE_OUT;
        @NotNull
        private static final Easing SINE_IN_OUT;
        @NotNull
        private static final Easing EXPO_IN;
        @NotNull
        private static final Easing EXPO_OUT;
        @NotNull
        private static final Easing EXPO_IN_OUT;
        @NotNull
        private static final Easing CIRC_IN;
        @NotNull
        private static final Easing CIRC_OUT;
        @NotNull
        private static final Easing CIRC_IN_OUT;
        @NotNull
        private static final Elastic ELASTIC_IN;
        @NotNull
        private static final Elastic ELASTIC_OUT;
        @NotNull
        private static final Elastic ELASTIC_IN_OUT;
        @NotNull
        private static final Back BACK_IN;
        @NotNull
        private static final Back BACK_OUT;
        @NotNull
        private static final Back BACK_IN_OUT;
        @NotNull
        private static final Easing BOUNCE_IN;
        @NotNull
        private static final Easing BOUNCE_OUT;
        @NotNull
        private static final Easing BOUNCE_IN_OUT;

        private Companion() {
        }

        @NotNull
        public final Easing easingFromString(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"string");
            return switch (string) {
                case "catmulrom" -> CATMULROM;
                case "step" -> STEP;
                case "easeInOutBounce" -> BOUNCE_IN_OUT;
                case "easeInBounce" -> BOUNCE_IN;
                case "easeOutBounce" -> BOUNCE_OUT;
                case "easeInOutCirc" -> CIRC_IN_OUT;
                case "easeInCirc" -> CIRC_IN;
                case "easeOutCirc" -> CIRC_OUT;
                case "easeInOutQuint" -> QUINTIC_IN_OUT;
                case "easeInQuint" -> QUINTIC_IN;
                case "easeOutQuint" -> QUINTIC_OUT;
                case "easeInOutQuart" -> QUARTIC_IN_OUT;
                case "easeInQuart" -> QUARTIC_IN;
                case "easeOutQuart" -> QUARTIC_OUT;
                case "easeInOutCubic" -> CUBIC_IN_OUT;
                case "easeInCubic" -> CUBIC_IN;
                case "easeOutCubic" -> CUBIC_OUT;
                case "easeInOutExp" -> EXPO_IN_OUT;
                case "easeOutExp" -> EXPO_OUT;
                case "easeInExp" -> EXPO_IN;
                case "easeInOutBack" -> BACK_IN_OUT;
                case "easeOutBack" -> BACK_OUT;
                case "easeInBack" -> BACK_IN;
                case "easeInOutSine" -> SINE_IN_OUT;
                case "easeOutSine" -> SINE_OUT;
                case "easeInSine" -> SINE_IN;
                case "easeInOutElastic" -> ELASTIC_IN_OUT;
                case "easeOutElastic" -> ELASTIC_OUT;
                case "easeInElastic" -> ELASTIC_IN;
                default -> LINEAR;
            };
        }

        @NotNull
        public final Easing getSTEP() {
            return STEP;
        }

        @NotNull
        public final Easing getCATMULROM() {
            return CATMULROM;
        }

        @NotNull
        public final Easing getLINEAR() {
            return LINEAR;
        }

        @NotNull
        public final Easing getQUAD_IN() {
            return QUAD_IN;
        }

        @NotNull
        public final Easing getQUAD_OUT() {
            return QUAD_OUT;
        }

        @NotNull
        public final Easing getQUAD_IN_OUT() {
            return QUAD_IN_OUT;
        }

        @NotNull
        public final Easing getCUBIC_IN() {
            return CUBIC_IN;
        }

        @NotNull
        public final Easing getCUBIC_OUT() {
            return CUBIC_OUT;
        }

        @NotNull
        public final Easing getCUBIC_IN_OUT() {
            return CUBIC_IN_OUT;
        }

        @NotNull
        public final Easing getQUARTIC_IN() {
            return QUARTIC_IN;
        }

        @NotNull
        public final Easing getQUARTIC_OUT() {
            return QUARTIC_OUT;
        }

        @NotNull
        public final Easing getQUARTIC_IN_OUT() {
            return QUARTIC_IN_OUT;
        }

        @NotNull
        public final Easing getQUINTIC_IN() {
            return QUINTIC_IN;
        }

        @NotNull
        public final Easing getQUINTIC_OUT() {
            return QUINTIC_OUT;
        }

        @NotNull
        public final Easing getQUINTIC_IN_OUT() {
            return QUINTIC_IN_OUT;
        }

        @NotNull
        public final Easing getSINE_IN() {
            return SINE_IN;
        }

        @NotNull
        public final Easing getSINE_OUT() {
            return SINE_OUT;
        }

        @NotNull
        public final Easing getSINE_IN_OUT() {
            return SINE_IN_OUT;
        }

        @NotNull
        public final Easing getEXPO_IN() {
            return EXPO_IN;
        }

        @NotNull
        public final Easing getEXPO_OUT() {
            return EXPO_OUT;
        }

        @NotNull
        public final Easing getEXPO_IN_OUT() {
            return EXPO_IN_OUT;
        }

        @NotNull
        public final Easing getCIRC_IN() {
            return CIRC_IN;
        }

        @NotNull
        public final Easing getCIRC_OUT() {
            return CIRC_OUT;
        }

        @NotNull
        public final Easing getCIRC_IN_OUT() {
            return CIRC_IN_OUT;
        }

        @NotNull
        public final Elastic getELASTIC_IN() {
            return ELASTIC_IN;
        }

        @NotNull
        public final Elastic getELASTIC_OUT() {
            return ELASTIC_OUT;
        }

        @NotNull
        public final Elastic getELASTIC_IN_OUT() {
            return ELASTIC_IN_OUT;
        }

        @NotNull
        public final Back getBACK_IN() {
            return BACK_IN;
        }

        @NotNull
        public final Back getBACK_OUT() {
            return BACK_OUT;
        }

        @NotNull
        public final Back getBACK_IN_OUT() {
            return BACK_IN_OUT;
        }

        @NotNull
        public final Easing getBOUNCE_IN() {
            return BOUNCE_IN;
        }

        @NotNull
        public final Easing getBOUNCE_OUT() {
            return BOUNCE_OUT;
        }

        @NotNull
        public final Easing getBOUNCE_IN_OUT() {
            return BOUNCE_IN_OUT;
        }

        public final void byIndex() {
        }

        static {
            $$INSTANCE = new Companion();
            STEP = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return b;
                }
            };
            CATMULROM = new Easing(){

                public float ease(float t, float b, float c, float d, float prevB, float nextC) {
                    float delta = t / d;
                    return Mth.catmullrom((float)delta, (float)prevB, (float)b, (float)c, (float)nextC);
                }
            };
            LINEAR = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return b + t / d * (c - b);
                }
            };
            QUAD_IN = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = c;
                    boolean bl = false;
                    float f3 = t2 /= it;
                    return f2 * f3 * t2 + b;
                }
            };
            QUAD_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = -c;
                    boolean bl = false;
                    float f3 = t2 /= it;
                    return f2 * f3 * (t2 - (float)2) + b;
                }
            };
            QUAD_IN_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    int n = 2;
                    float f = d;
                    boolean bl = false;
                    float f2 = t2 /= (float)it;
                    if (f / f2 < 1.0f) {
                        return c / (float)2 * t2 * t2 + b;
                    }
                    return -c / (float)2 * ((t2 += -1.0f) * (t2 - (float)2) - 1.0f) + b;
                }
            };
            CUBIC_IN = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = c;
                    boolean bl = false;
                    float f3 = t2 /= it;
                    return f2 * f3 * t2 * t2 + b;
                }
            };
            CUBIC_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float f;
                    float t2 = 0.0f;
                    t2 = t;
                    float f2 = f = t2 / d - 1.0f;
                    float f3 = c;
                    boolean bl = false;
                    t2 = it;
                    Unit unit = Unit.INSTANCE;
                    return f3 * (f * t2 * t2 + 1.0f) + b;
                }
            };
            CUBIC_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    float delta = (double)t < 0.5 ? (float)4 * t * t * t : (float)((double)d - Math.pow((float)-2 * t + (float)2, 3.0) / (double)2);
                    return net.thebrokenscript.brokencore.api.animation.value_animation.Easing$Companion.$$INSTANCE.getLINEAR().ease(delta, b, c, d);
                }
            };
            QUARTIC_IN = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = c;
                    boolean bl = false;
                    float f3 = t2 /= it;
                    return f2 * f3 * t2 * t2 * t2 + b;
                }
            };
            QUARTIC_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float f;
                    float t2 = 0.0f;
                    t2 = t;
                    float f2 = f = t2 / d - 1.0f;
                    float f3 = -c;
                    boolean bl = false;
                    t2 = it;
                    Unit unit = Unit.INSTANCE;
                    return f3 * (f * t2 * t2 * t2 - 1.0f) + b;
                }
            };
            QUARTIC_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    int it;
                    float t2 = 0.0f;
                    t2 = t;
                    int n = 2;
                    float f = d;
                    boolean bl = false;
                    float f2 = t2 /= (float)it;
                    if (f / f2 < 1.0f) {
                        return c / (float)2 * t2 * t2 * t2 * t2 + b;
                    }
                    it = 2;
                    f = -c / (float)2;
                    boolean bl2 = false;
                    f2 = t2 -= (float)it;
                    return f * (f2 * t2 * t2 * t2 - (float)2) + b;
                }
            };
            QUINTIC_IN = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = c;
                    boolean bl = false;
                    float f3 = t2 /= it;
                    return f2 * f3 * t2 * t2 * t2 * t2 + b;
                }
            };
            QUINTIC_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float f;
                    float t2 = 0.0f;
                    t2 = t;
                    float f2 = f = t2 / d - 1.0f;
                    float f3 = c;
                    boolean bl = false;
                    t2 = it;
                    Unit unit = Unit.INSTANCE;
                    return f3 * (f * t2 * t2 * t2 * t2 + 1.0f) + b;
                }
            };
            QUINTIC_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    int it;
                    float t2 = 0.0f;
                    t2 = t;
                    int n = 2;
                    float f = d;
                    boolean bl = false;
                    float f2 = t2 /= (float)it;
                    if (f / f2 < 1.0f) {
                        return c / (float)2 * t2 * t2 * t2 * t2 * t2 + b;
                    }
                    it = 2;
                    f = c / (float)2;
                    boolean bl2 = false;
                    f2 = t2 -= (float)it;
                    return f * (f2 * t2 * t2 * t2 * t2 + (float)2) + b;
                }
            };
            SINE_IN = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return -c * (float)Math.cos((double)(t / d) * 1.5707963267948966) + c + b;
                }
            };
            SINE_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return c * (float)Math.sin((double)(t / d) * 1.5707963267948966) + b;
                }
            };
            SINE_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return -c / (float)2 * ((float)Math.cos(Math.PI * (double)t / (double)d) - 1.0f) + b;
                }
            };
            EXPO_IN = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return t == 0.0f ? b : c * (float)Math.pow(2.0, (float)10 * (t / d - 1.0f)) + b;
                }
            };
            EXPO_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return t == d ? b + c : c * (-((float)Math.pow(2.0, (float)-10 * t / d)) + 1.0f) + b;
                }
            };
            EXPO_IN_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    if (t2 == 0.0f) {
                        return b;
                    }
                    if (t2 == d) {
                        return b + c;
                    }
                    int n = 2;
                    float f = d;
                    boolean bl = false;
                    float f2 = t2 /= (float)it;
                    if (f / f2 < 1.0f) {
                        return c / (float)2 * (float)Math.pow(2.0, (float)10 * (t2 - 1.0f)) + b;
                    }
                    return c / (float)2 * (-((float)Math.pow(2.0, (float)-10 * (t2 += -1.0f))) + (float)2) + b;
                }
            };
            CIRC_IN = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float t2 = 0.0f;
                    t2 = t;
                    float f = d;
                    float f2 = 1.0f;
                    float f3 = -c;
                    boolean bl = false;
                    float f4 = t2 /= it;
                    return f3 * ((float)Math.sqrt(f2 - f4 * t2) - 1.0f) + b;
                }
            };
            CIRC_OUT = new Easing(){

                /*
                 * WARNING - void declaration
                 */
                public float ease(float t, float b, float c, float d) {
                    void it;
                    float f;
                    float t2 = 0.0f;
                    t2 = t;
                    float f2 = f = t2 / d - 1.0f;
                    float f3 = 1.0f;
                    float f4 = c;
                    boolean bl = false;
                    t2 = it;
                    Unit unit = Unit.INSTANCE;
                    return f4 * (float)Math.sqrt(f3 - f * t2) + b;
                }
            };
            CIRC_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    int it;
                    float t2 = 0.0f;
                    t2 = t;
                    int n = 2;
                    float f = d;
                    boolean bl = false;
                    float f2 = t2 /= (float)it;
                    if (f / f2 < 1.0f) {
                        return -c / (float)2 * ((float)Math.sqrt(1.0f - t2 * t2) - 1.0f) + b;
                    }
                    it = 2;
                    f2 = 1.0f;
                    f = c / (float)2;
                    boolean bl2 = false;
                    float f3 = t2 -= (float)it;
                    return f * ((float)Math.sqrt(f2 - f3 * t2) + 1.0f) + b;
                }
            };
            ELASTIC_IN = new ElasticIn();
            ELASTIC_OUT = new ElasticOut();
            ELASTIC_IN_OUT = new ElasticInOut();
            BACK_IN = new BackIn();
            BACK_OUT = new BackOut();
            BACK_IN_OUT = new BackInOut();
            BOUNCE_IN = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    return c - net.thebrokenscript.brokencore.api.animation.value_animation.Easing$Companion.$$INSTANCE.getBOUNCE_OUT().ease(d - t, 0.0f, c, d) + b;
                }
            };
            BOUNCE_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    float t2 = 0.0f;
                    t2 = t;
                    float it = d;
                    boolean bl = false;
                    t2 /= it;
                    if (t2 < 0.36363637f) {
                        return c * (7.5625f * t2 * t2) + b;
                    }
                    if (t2 < 0.72727275f) {
                        it = 2.75f;
                        float f = 1.5f;
                        float f2 = 7.5625f;
                        float f3 = c;
                        boolean bl2 = false;
                        float f4 = t2 -= it;
                        return f3 * (f2 * (f / f4) * t2 + 0.75f) + b;
                    }
                    if (t2 < 0.90909094f) {
                        it = 2.75f;
                        float f = 2.25f;
                        float f5 = 7.5625f;
                        float f6 = c;
                        boolean bl3 = false;
                        float f7 = t2 -= it;
                        return f6 * (f5 * (f / f7) * t2 + 0.9375f) + b;
                    }
                    it = 2.75f;
                    float f = 2.625f;
                    float f8 = 7.5625f;
                    float f9 = c;
                    boolean bl4 = false;
                    float f10 = t2 -= it;
                    return f9 * (f8 * (f / f10) * t2 + 0.984375f) + b;
                }
            };
            BOUNCE_IN_OUT = new Easing(){

                public float ease(float t, float b, float c, float d) {
                    if (t < d / (float)2) {
                        return net.thebrokenscript.brokencore.api.animation.value_animation.Easing$Companion.$$INSTANCE.getBOUNCE_IN().ease(t * (float)2, 0.0f, c, d) * 0.5f + b;
                    }
                    return net.thebrokenscript.brokencore.api.animation.value_animation.Easing$Companion.$$INSTANCE.getBOUNCE_OUT().ease(t * (float)2 - d, 0.0f, c, d) * 0.5f + c * 0.5f + b;
                }
            };
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static float ease(@NotNull Easing $this, float t, float b, float c, float d) {
            return Companion.getLINEAR().ease(t, b, c, d);
        }

        public static float ease(@NotNull Easing $this, float t, float b, float c, float d, float prevB, float nextC) {
            return $this.ease(t, b, c, d);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing;", "amplitude", "", "period", "<init>", "(FF)V", "getAmplitude", "()F", "setAmplitude", "(F)V", "getPeriod", "setPeriod", "brokencore-common"})
    public static class Elastic
    implements Easing {
        private float amplitude;
        private float period;

        @JvmOverloads
        public Elastic(float amplitude, float period) {
            this.amplitude = amplitude;
            this.period = period;
        }

        public /* synthetic */ Elastic(float f, float f2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                f = -1.0f;
            }
            if ((n & 2) != 0) {
                f2 = 0.0f;
            }
            this(f, f2);
        }

        public final float getAmplitude() {
            return this.amplitude;
        }

        public final void setAmplitude(float f) {
            this.amplitude = f;
        }

        public final float getPeriod() {
            return this.period;
        }

        public final void setPeriod(float f) {
            this.period = f;
        }

        @JvmOverloads
        public Elastic(float amplitude) {
            this(amplitude, 0.0f, 2, null);
        }

        @JvmOverloads
        public Elastic() {
            this(0.0f, 0.0f, 3, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticIn;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "amplitude", "", "period", "<init>", "(FF)V", "()V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticIn\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class ElasticIn
    extends Elastic {
        public ElasticIn(float amplitude, float period) {
            super(amplitude, period);
        }

        public ElasticIn() {
            super(0.0f, 0.0f, 3, null);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float ease(float t, float b, float c, float d) {
            void it;
            float t2 = 0.0f;
            t2 = t;
            float a = this.getAmplitude();
            float p = this.getPeriod();
            if (t2 == 0.0f) {
                return b;
            }
            float it2 = d;
            boolean bl = false;
            if ((t2 /= it2) == 1.0f) {
                return b + c;
            }
            if (p == 0.0f) {
                p = d * 0.3f;
            }
            float s = 0.0f;
            if (a < Math.abs(c)) {
                a = c;
                s = p / (float)4;
            } else {
                s = p / ((float)Math.PI * 2) * (float)Math.asin(c / a);
            }
            double d2 = 2.0;
            boolean bl2 = true;
            float f = 10;
            float f2 = a;
            boolean bl3 = false;
            float f3 = t2 -= (float)it;
            double d3 = f * f3;
            return -(f2 * (float)Math.pow(d2, d3) * (float)Math.sin((double)(t2 * d - s) * (Math.PI * 2) / (double)p)) + b;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticInOut;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "amplitude", "", "period", "<init>", "(FF)V", "()V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticInOut\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class ElasticInOut
    extends Elastic {
        public ElasticInOut(float amplitude, float period) {
            super(amplitude, period);
        }

        public ElasticInOut() {
            super(0.0f, 0.0f, 3, null);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float ease(float t, float b, float c, float d) {
            void it;
            float t2 = 0.0f;
            t2 = t;
            float a = this.getAmplitude();
            float p = this.getPeriod();
            if (t2 == 0.0f) {
                return b;
            }
            int n = 2;
            float f = d;
            boolean bl = false;
            float f2 = t2 /= (float)it;
            if (f / f2 == 2.0f) {
                return b + c;
            }
            if (p == 0.0f) {
                p = d * 0.45000002f;
            }
            float s = 0.0f;
            if (a < Math.abs(c)) {
                a = c;
                s = p / 4.0f;
            } else {
                s = p / ((float)Math.PI * 2) * (float)Math.asin(c / a);
            }
            if (t2 < 1.0f) {
                void it2;
                double d2 = 2.0;
                boolean bl2 = true;
                float f3 = 10;
                f2 = a;
                f = -0.5f;
                boolean bl3 = false;
                float f4 = t2 -= (float)it2;
                double d3 = f3 * f4;
                return f * (f2 * (float)Math.pow(d2, d3) * (float)Math.sin((double)(t2 * d - s) * (Math.PI * 2) / (double)p)) + b;
            }
            double d4 = 2.0;
            boolean it2 = true;
            f2 = -10;
            f = a;
            boolean bl4 = false;
            float f5 = t2 -= (float)it2;
            double d5 = f2 * f5;
            return f * (float)Math.pow(d4, d5) * (float)Math.sin((double)(t2 * d - s) * (Math.PI * 2) / (double)p) * 0.5f + c + b;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0007J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticOut;", "Lnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$Elastic;", "amplitude", "", "period", "<init>", "(FF)V", "()V", "ease", "t", "b", "c", "d", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nnet/thebrokenscript/brokencore/api/animation/value_animation/Easing$ElasticOut\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,395:1\n1#2:396\n*E\n"})
    public static final class ElasticOut
    extends Elastic {
        public ElasticOut(float amplitude, float period) {
            super(amplitude, period);
        }

        public ElasticOut() {
            super(0.0f, 0.0f, 3, null);
        }

        @Override
        public float ease(float t, float b, float c, float d) {
            float t2 = 0.0f;
            t2 = t;
            float a = this.getAmplitude();
            float p = this.getPeriod();
            if (t2 == 0.0f) {
                return b;
            }
            float it = d;
            boolean bl = false;
            if ((t2 /= it) == 1.0f) {
                return b + c;
            }
            if (p == 0.0f) {
                p = d * 0.3f;
            }
            float s = 0.0f;
            if (a < Math.abs(c)) {
                a = c;
                s = p / (float)4;
            } else {
                s = p / ((float)Math.PI * 2) * (float)Math.asin(c / a);
            }
            return a * (float)Math.pow(2.0, (float)-10 * t2) * (float)Math.sin((double)(t2 * d - s) * (Math.PI * 2) / (double)p) + c + b;
        }
    }
}


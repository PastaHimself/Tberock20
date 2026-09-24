/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@kotlin.annotation.Retention(value=AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.PROPERTY})
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={})
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/UI;", "", "mode", "Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;", "sliderStep", "", "()Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;", "()D", "Mode", "brokencore-common"})
public @interface UI {
    public Mode mode() default Mode.AUTO;

    public double sliderStep() default 1.0;

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "CHECKBOX", "SWITCH", "ON_OFF", "SLIDER", "TEXT", "EVENTS", "brokencore-common"})
    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode AUTO = new Mode();
        public static final /* enum */ Mode CHECKBOX = new Mode();
        public static final /* enum */ Mode SWITCH = new Mode();
        public static final /* enum */ Mode ON_OFF = new Mode();
        public static final /* enum */ Mode SLIDER = new Mode();
        public static final /* enum */ Mode TEXT = new Mode();
        public static final /* enum */ Mode EVENTS = new Mode();
        private static final /* synthetic */ Mode[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        public static Mode valueOf(String value) {
            return Enum.valueOf(Mode.class, value);
        }

        @NotNull
        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = modeArray = new Mode[]{Mode.AUTO, Mode.CHECKBOX, Mode.SWITCH, Mode.ON_OFF, Mode.SLIDER, Mode.TEXT, Mode.EVENTS};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}


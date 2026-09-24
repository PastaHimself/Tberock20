/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.component.TextBoxComponent
 *  io.wispforest.owo.ui.core.Sizing
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty0
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.components;

import io.wispforest.owo.ui.component.TextBoxComponent;
import io.wispforest.owo.ui.core.Sizing;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B3\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u001cH$\u00a2\u0006\u0002\u0010\u001dJ\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010 \u001a\u00020\nH\u0016R$\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00028\u0000X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u0010\u0010\u001e\u001a\u00028\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001f\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/NumberBox;", "T", "", "Lio/wispforest/owo/ui/component/TextBoxComponent;", "horizontalSizing", "Lio/wispforest/owo/ui/core/Sizing;", "field", "Lkotlin/reflect/KMutableProperty0;", "update", "Lkotlin/Function0;", "", "<init>", "(Lio/wispforest/owo/ui/core/Sizing;Lkotlin/reflect/KMutableProperty0;Lkotlin/jvm/functions/Function0;)V", "value", "numValue", "getNumValue", "()Ljava/lang/Number;", "setNumValue", "(Ljava/lang/Number;)V", "changeCallback", "Lkotlin/Function1;", "getChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "zero", "getZero", "parse", "", "(Ljava/lang/String;)Ljava/lang/Number;", "actualNumValue", "Ljava/lang/Number;", "onFocusLost", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nNumberBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NumberBox.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/NumberBox\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,73:1\n12879#2,2:74\n12767#2:76\n12768#2:80\n1104#3,3:77\n*S KotlinDebug\n*F\n+ 1 NumberBox.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/components/NumberBox\n*L\n44#1:74,2\n44#1:76\n44#1:80\n44#1:77,3\n*E\n"})
public abstract class NumberBox<T extends Number>
extends TextBoxComponent {
    @NotNull
    private Function1<? super T, Unit> changeCallback;
    @NotNull
    private T actualNumValue;

    @JvmOverloads
    public NumberBox(@NotNull Sizing horizontalSizing, @Nullable KMutableProperty0<T> field, @NotNull Function0<Unit> update) {
        Intrinsics.checkNotNullParameter((Object)horizontalSizing, (String)"horizontalSizing");
        Intrinsics.checkNotNullParameter(update, (String)"update");
        super(horizontalSizing);
        this.changeCallback = NumberBox::changeCallback$lambda$0;
        if (field != null) {
            this.setNumValue((Number)field.get());
            this.changeCallback = arg_0 -> NumberBox._init_$lambda$1(field, update, arg_0);
        }
        this.actualNumValue = this.getZero();
        this.setFilter(arg_0 -> NumberBox._init_$lambda$2(this, arg_0));
    }

    public /* synthetic */ NumberBox(Sizing sizing, KMutableProperty0 kMutableProperty0, Function0 function0, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            kMutableProperty0 = null;
        }
        if ((n & 4) != 0) {
            function0 = NumberBox::_init_$lambda$0;
        }
        this(sizing, kMutableProperty0, (Function0<Unit>)function0);
    }

    @NotNull
    public final T getNumValue() {
        return this.actualNumValue;
    }

    public final void setNumValue(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        this.actualNumValue = value;
        this.setNumValue();
    }

    @NotNull
    public final Function1<T, Unit> getChangeCallback() {
        return this.changeCallback;
    }

    public final void setChangeCallback(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"<set-?>");
        this.changeCallback = function1;
    }

    @NotNull
    protected abstract T getZero();

    @Nullable
    protected abstract T parse(@NotNull String var1);

    public final void setNumValue() {
        String string;
        String string2 = this.getValue();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getValue(...)");
        T parsed = this.parse(string2);
        if (parsed != null) {
            this.actualNumValue = parsed;
        }
        if (!(this.actualNumValue instanceof Double) && !(this.actualNumValue instanceof Float)) {
            string = this.actualNumValue.toString();
        } else if (Intrinsics.areEqual(this.actualNumValue, this.getZero())) {
            string = "0.000";
        } else {
            String string3 = "%.3f";
            Object[] objectArray = new Object[]{this.actualNumValue, Locale.US};
            String string4 = String.format(string3, Arrays.copyOf(objectArray, objectArray.length));
            string = string4;
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"format(...)");
        }
        String msg = string;
        this.text(msg);
        T t = this.parse(msg);
        if (t == null) {
            t = this.actualNumValue;
        }
        this.actualNumValue = t;
        this.changeCallback.invoke(this.actualNumValue);
    }

    public void onFocusLost() {
        super.onFocusLost();
        this.setNumValue();
    }

    @JvmOverloads
    public NumberBox(@NotNull Sizing horizontalSizing, @Nullable KMutableProperty0<T> field) {
        Intrinsics.checkNotNullParameter((Object)horizontalSizing, (String)"horizontalSizing");
        this(horizontalSizing, field, null, 4, null);
    }

    @JvmOverloads
    public NumberBox(@NotNull Sizing horizontalSizing) {
        Intrinsics.checkNotNullParameter((Object)horizontalSizing, (String)"horizontalSizing");
        this(horizontalSizing, null, null, 6, null);
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit changeCallback$lambda$0(Number it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(KMutableProperty0 $field, Function0 $update, Number it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $field.set((Object)it);
        $update.invoke();
        return Unit.INSTANCE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean _init_$lambda$2(NumberBox this$0, String it) {
        int n;
        Object[] objectArray;
        if (this$0.getZero() instanceof Float || this$0.getZero() instanceof Double) {
            Character[] characterArray = new Character[]{Character.valueOf('-'), Character.valueOf('.')};
            objectArray = characterArray;
        } else {
            Object[] objectArray2 = new Character[]{Character.valueOf('-')};
            objectArray = objectArray2;
        }
        Object[] extraAllowed = objectArray;
        Intrinsics.checkNotNull((Object)it);
        char[] cArray = it.toCharArray();
        Intrinsics.checkNotNullExpressionValue((Object)cArray, (String)"toCharArray(...)");
        char[] cArray2 = cArray;
        boolean $i$f$all = false;
        int n2 = cArray2.length;
        for (n = 0; n < n2; ++n) {
            char element$iv;
            char c = element$iv = cArray2[n];
            boolean bl = false;
            if (!Character.isDigit(c)) {
                if (!ArraysKt.contains((Object[])extraAllowed, (Object)Character.valueOf(c))) return false;
            }
            boolean bl2 = true;
            if (bl2) continue;
            return false;
        }
        boolean bl = true;
        if (!bl) return false;
        Object[] objectArray3 = extraAllowed;
        $i$f$all = false;
        n = 0;
        n2 = objectArray3.length;
        while (n < n2) {
            Object element$iv = objectArray3[n];
            char x = ((Character)element$iv).charValue();
            boolean bl3 = false;
            CharSequence $this$count$iv = it;
            boolean $i$f$count = false;
            int count$iv = 0;
            for (int i = 0; i < $this$count$iv.length(); ++i) {
                char element$iv2;
                char c = element$iv2 = $this$count$iv.charAt(i);
                boolean bl4 = false;
                if (!(c == x)) continue;
                ++count$iv;
            }
            if (count$iv >= 2) return false;
            boolean bl5 = true;
            if (!bl5) {
                return false;
            }
            ++n;
        }
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\n\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fJ\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\u0011\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u0012\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0013\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/TagExt;", "", "<init>", "()V", "incInt", "", "Lnet/minecraft/nbt/CompoundTag;", "key", "", "decInt", "addInt", "add", "", "subInt", "sub", "incDouble", "", "decDouble", "addDouble", "subDouble", "getOptionalInt", "(Lnet/minecraft/nbt/CompoundTag;Ljava/lang/String;)Ljava/lang/Integer;", "getOptionalLong", "", "(Lnet/minecraft/nbt/CompoundTag;Ljava/lang/String;)Ljava/lang/Long;", "getOptionalBool", "", "(Lnet/minecraft/nbt/CompoundTag;Ljava/lang/String;)Ljava/lang/Boolean;", "getOptional", "Lnet/minecraft/nbt/Tag;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTagExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagExt.kt\nnet/thebrokenscript/brokencore/api/ext/TagExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public final class TagExt {
    @NotNull
    public static final TagExt INSTANCE = new TagExt();

    private TagExt() {
    }

    public final int incInt(@NotNull CompoundTag $this$incInt, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$incInt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        $this$incInt.putInt(key, $this$incInt.getInt(key) + 1);
        Unit $this$incInt_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$incInt.getInt(key);
    }

    public final int decInt(@NotNull CompoundTag $this$decInt, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$decInt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        $this$decInt.putInt(key, $this$decInt.getInt(key) - 1);
        Unit $this$decInt_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$decInt.getInt(key);
    }

    public final int addInt(@NotNull CompoundTag $this$addInt, @NotNull String key, @NotNull Number add) {
        Intrinsics.checkNotNullParameter((Object)$this$addInt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)add, (String)"add");
        $this$addInt.putInt(key, $this$addInt.getInt(key) + add.intValue());
        Unit $this$addInt_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$addInt.getInt(key);
    }

    public final int subInt(@NotNull CompoundTag $this$subInt, @NotNull String key, @NotNull Number sub) {
        Intrinsics.checkNotNullParameter((Object)$this$subInt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)sub, (String)"sub");
        $this$subInt.putInt(key, $this$subInt.getInt(key) - sub.intValue());
        Unit $this$subInt_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$subInt.getInt(key);
    }

    public final double incDouble(@NotNull CompoundTag $this$incDouble, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$incDouble, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        $this$incDouble.putDouble(key, $this$incDouble.getDouble(key) + 1.0);
        Unit $this$incDouble_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$incDouble.getDouble(key);
    }

    public final double decDouble(@NotNull CompoundTag $this$decDouble, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$decDouble, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        $this$decDouble.putDouble(key, $this$decDouble.getDouble(key) - 1.0);
        Unit $this$decDouble_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$decDouble.getDouble(key);
    }

    public final double addDouble(@NotNull CompoundTag $this$addDouble, @NotNull String key, @NotNull Number add) {
        Intrinsics.checkNotNullParameter((Object)$this$addDouble, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)add, (String)"add");
        $this$addDouble.putDouble(key, $this$addDouble.getDouble(key) + add.doubleValue());
        Unit $this$addDouble_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$addDouble.getDouble(key);
    }

    public final double subDouble(@NotNull CompoundTag $this$subDouble, @NotNull String key, @NotNull Number sub) {
        Intrinsics.checkNotNullParameter((Object)$this$subDouble, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter((Object)sub, (String)"sub");
        $this$subDouble.putDouble(key, $this$subDouble.getDouble(key) - sub.doubleValue());
        Unit $this$subDouble_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return $this$subDouble.getDouble(key);
    }

    @Nullable
    public final Integer getOptionalInt(@NotNull CompoundTag $this$getOptionalInt, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getOptionalInt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return $this$getOptionalInt.contains(key) && $this$getOptionalInt.getTagType(key) == 3 ? Integer.valueOf($this$getOptionalInt.getInt(key)) : null;
    }

    @Nullable
    public final Long getOptionalLong(@NotNull CompoundTag $this$getOptionalLong, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getOptionalLong, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return $this$getOptionalLong.contains(key) && $this$getOptionalLong.getTagType(key) == 4 ? Long.valueOf($this$getOptionalLong.getLong(key)) : null;
    }

    @Nullable
    public final Boolean getOptionalBool(@NotNull CompoundTag $this$getOptionalBool, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getOptionalBool, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return $this$getOptionalBool.contains(key) && $this$getOptionalBool.getTagType(key) == 1 ? Boolean.valueOf($this$getOptionalBool.getBoolean(key)) : null;
    }

    @Nullable
    public final Tag getOptional(@NotNull CompoundTag $this$getOptional, @NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getOptional, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return $this$getOptional.contains(key) ? $this$getOptional.get(key) : null;
    }
}


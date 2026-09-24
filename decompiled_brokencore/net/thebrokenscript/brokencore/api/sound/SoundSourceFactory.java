/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fuzs.extensibleenums.api.v2.core.EnumAppender
 *  fuzs.extensibleenums.impl.BuiltInEnumFactoriesImpl
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundSource
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound;

import fuzs.extensibleenums.api.v2.core.EnumAppender;
import fuzs.extensibleenums.impl.BuiltInEnumFactoriesImpl;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/SoundSourceFactory;", "", "<init>", "()V", "createSoundSourceCategory", "Lnet/minecraft/sounds/SoundSource;", "identifier", "", "brokencore-common"})
@ApiStatus.Internal
public final class SoundSourceFactory {
    @NotNull
    public static final SoundSourceFactory INSTANCE = new SoundSourceFactory();

    private SoundSourceFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SoundSource createSoundSourceCategory(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter((Object)identifier, (String)"identifier");
        Object[] objectArray = new Class[]{String.class};
        EnumAppender enumAppender = EnumAppender.create(SoundSource.class, (Class[])objectArray);
        String string = identifier.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toUpperCase(...)");
        objectArray = new Object[]{identifier};
        EnumAppender enumAppender2 = enumAppender.addEnumConstant(string, objectArray);
        objectArray = new Class[]{Class.forName("net.minecraft.sounds.SoundSource")};
        enumAppender2.applyTo((Class[])objectArray);
        String string2 = identifier.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toUpperCase(...)");
        Enum enum_ = BuiltInEnumFactoriesImpl.testEnumValueAddition(SoundSource.class, (String)string2);
        Intrinsics.checkNotNullExpressionValue((Object)enum_, (String)"testEnumValueAddition(...)");
        return (SoundSource)enum_;
    }
}


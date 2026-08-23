/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.DimensionSpecialEffects$SkyType
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.level.SimpleDimensionFX
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.registry;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.client.level.SimpleDimensionFX;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.world.dimension.nothing.NothingEffects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0015R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\tR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/registry/TBSDimensionFX;", "", "<init>", "()V", "value", "Lnet/minecraft/client/renderer/DimensionSpecialEffects;", "shaderMoonFX", "getShaderMoonFX$annotations", "getShaderMoonFX", "()Lnet/minecraft/client/renderer/DimensionSpecialEffects;", "vanillaMoonFX", "getVanillaMoonFX$annotations", "getVanillaMoonFX", "levelEffectsField", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "getLevelEffectsField", "()Ljava/lang/reflect/Field;", "levelEffectsField$delegate", "Lkotlin/Lazy;", "register", "", "consumer", "Lkotlin/Function2;", "Lnet/minecraft/resources/ResourceLocation;", "spaceFX", "limboFX", "voidFX", "applyMoonSkyConfig", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSDimensionFX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSDimensionFX.kt\nnet/thebrokenscript/registry/TBSDimensionFX\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class TBSDimensionFX {
    @NotNull
    public static final TBSDimensionFX INSTANCE = new TBSDimensionFX();
    @Nullable
    private static DimensionSpecialEffects shaderMoonFX;
    @Nullable
    private static DimensionSpecialEffects vanillaMoonFX;
    @NotNull
    private static final Lazy levelEffectsField$delegate;

    private TBSDimensionFX() {
    }

    @Nullable
    public static final DimensionSpecialEffects getShaderMoonFX() {
        return shaderMoonFX;
    }

    @JvmStatic
    public static /* synthetic */ void getShaderMoonFX$annotations() {
    }

    @Nullable
    public static final DimensionSpecialEffects getVanillaMoonFX() {
        return vanillaMoonFX;
    }

    @JvmStatic
    public static /* synthetic */ void getVanillaMoonFX$annotations() {
    }

    private final Field getLevelEffectsField() {
        Lazy lazy = levelEffectsField$delegate;
        return (Field)lazy.getValue();
    }

    public final void register(@NotNull Function2<? super ResourceLocation, ? super DimensionSpecialEffects, Unit> consumer, @NotNull DimensionSpecialEffects spaceFX, @NotNull DimensionSpecialEffects limboFX, @NotNull DimensionSpecialEffects voidFX) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Intrinsics.checkNotNullParameter((Object)spaceFX, (String)"spaceFX");
        Intrinsics.checkNotNullParameter((Object)limboFX, (String)"limboFX");
        Intrinsics.checkNotNullParameter((Object)voidFX, (String)"voidFX");
        SimpleDimensionFX baseFX = new SimpleDimensionFX(300.0f, true, DimensionSpecialEffects.SkyType.NONE, false, false, Vec3.ZERO, false, 64, null);
        SimpleDimensionFX moonFX = new SimpleDimensionFX(Float.NaN, true, DimensionSpecialEffects.SkyType.NORMAL, false, false, new Vec3(0.3, 0.3, 0.3), false);
        SimpleDimensionFX nullFX = new SimpleDimensionFX(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false, new Vec3(0.0, 0.0, 0.0), false);
        SimpleDimensionFX nowhereFX = new SimpleDimensionFX(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false, new Vec3(0.15, 0.15, 0.15), true);
        SimpleDimensionFX libraryFX = new SimpleDimensionFX(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false, new Vec3(0.85, 0.85, 0.85), true);
        SimpleDimensionFX lucidFX = new SimpleDimensionFX(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false, new Vec3(0.03, 0.06, 0.18), true);
        shaderMoonFX = spaceFX;
        vanillaMoonFX = (DimensionSpecialEffects)moonFX;
        ResourceLocation resourceLocation = TBSDimensions.CLAN_VOID.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        consumer.invoke((Object)resourceLocation, (Object)baseFX);
        ResourceLocation resourceLocation2 = TBSDimensions.NULL_TORTURE.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"location(...)");
        consumer.invoke((Object)resourceLocation2, (Object)nullFX);
        ResourceLocation resourceLocation3 = TBSDimensions.CORRUPTED_MOON.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation3, (String)"location(...)");
        consumer.invoke((Object)resourceLocation3, (Object)spaceFX);
        ResourceLocation resourceLocation4 = TBSDimensions.NOWHERE.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation4, (String)"location(...)");
        consumer.invoke((Object)resourceLocation4, (Object)nowhereFX);
        ResourceLocation resourceLocation5 = TBSDimensions.LIMBO.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation5, (String)"location(...)");
        consumer.invoke((Object)resourceLocation5, (Object)limboFX);
        ResourceLocation resourceLocation6 = TBSDimensions.NOTHING.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation6, (String)"location(...)");
        consumer.invoke((Object)resourceLocation6, (Object)new NothingEffects());
        ResourceLocation resourceLocation7 = TBSDimensions.PROTECTED_VOID.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation7, (String)"location(...)");
        consumer.invoke((Object)resourceLocation7, (Object)nowhereFX);
        ResourceLocation resourceLocation8 = TBSDimensions.LIBRARY.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation8, (String)"location(...)");
        consumer.invoke((Object)resourceLocation8, (Object)libraryFX);
        ResourceLocation resourceLocation9 = TBSDimensions.LUCID.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation9, (String)"location(...)");
        consumer.invoke((Object)resourceLocation9, (Object)lucidFX);
        ResourceLocation resourceLocation10 = TBSDimensions.STAGE2.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation10, (String)"location(...)");
        consumer.invoke((Object)resourceLocation10, (Object)baseFX);
        ResourceLocation resourceLocation11 = TBSDimensions.STAGE3.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation11, (String)"location(...)");
        consumer.invoke((Object)resourceLocation11, (Object)voidFX);
    }

    public final void applyMoonSkyConfig() {
        DimensionSpecialEffects dimensionSpecialEffects;
        if (TBSConfigs.INSTANCE.getClient().getShaderBasedMoon()) {
            dimensionSpecialEffects = shaderMoonFX;
        } else {
            dimensionSpecialEffects = vanillaMoonFX;
            if (dimensionSpecialEffects == null) {
                return;
            }
        }
        DimensionSpecialEffects newFX = dimensionSpecialEffects;
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        if (!Intrinsics.areEqual((Object)level.dimension(), TBSDimensions.CORRUPTED_MOON)) {
            return;
        }
        this.getLevelEffectsField().set(level, newFX);
    }

    private static final Field levelEffectsField_delegate$lambda$0() {
        Field field;
        Field it = field = ClientLevel.class.getDeclaredField("effects");
        boolean bl = false;
        it.setAccessible(true);
        return field;
    }

    static {
        levelEffectsField$delegate = LazyKt.lazy(TBSDimensionFX::levelEffectsField_delegate$lambda$0);
    }
}


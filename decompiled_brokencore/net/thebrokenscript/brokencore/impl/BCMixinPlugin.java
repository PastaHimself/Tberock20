/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.objectweb.asm.tree.ClassNode
 *  org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
 *  org.spongepowered.asm.mixin.extensibility.IMixinInfo
 */
package net.thebrokenscript.brokencore.impl;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.SoundCategoryRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J$\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0016J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/impl/BCMixinPlugin;", "Lorg/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin;", "<init>", "()V", "onLoad", "", "mixinPackage", "", "getRefMapperConfig", "shouldApplyMixin", "", "targetClassName", "mixinClassName", "acceptTargets", "myTargets", "", "otherTargets", "getMixins", "", "preApply", "targetClass", "Lorg/objectweb/asm/tree/ClassNode;", "mixinInfo", "Lorg/spongepowered/asm/mixin/extensibility/IMixinInfo;", "postApply", "brokencore-common"})
public final class BCMixinPlugin
implements IMixinConfigPlugin {
    public void onLoad(@NotNull String mixinPackage) {
        Intrinsics.checkNotNullParameter((Object)mixinPackage, (String)"mixinPackage");
        SoundCategoryRegistry.Companion.initAll$default(SoundCategoryRegistry.Companion, null, 1, null);
    }

    @Nullable
    public String getRefMapperConfig() {
        return null;
    }

    public boolean shouldApplyMixin(@NotNull String targetClassName, @NotNull String mixinClassName) {
        Intrinsics.checkNotNullParameter((Object)targetClassName, (String)"targetClassName");
        Intrinsics.checkNotNullParameter((Object)mixinClassName, (String)"mixinClassName");
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.distanthorizons", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("distanthorizons");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.sodium", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("sodium");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.iris", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("iris");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.sable.sodium.sV6", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("sable") && PlatformUtil.Companion.isModLoadedEarly("sodium") && PlatformUtil.Companion.isModVersionAtMost("sable", "1.2.2") && PlatformUtil.Companion.isModVersionAtMost("sodium", "0.6.13");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.sable", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("sable");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.simulated", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("simulated");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.veil", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("veil");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"compat.vivecraft", (boolean)false, (int)2, null)) {
            return PlatformUtil.Companion.isModLoadedEarly("vivecraft");
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"devtool", (boolean)false, (int)2, null)) {
            return !PlatformUtil.Companion.isProduction();
        }
        if (StringsKt.contains$default((CharSequence)mixinClassName, (CharSequence)"RenderTypeMixin", (boolean)false, (int)2, null)) {
            return !PlatformUtil.Companion.isModLoadedEarly("veil");
        }
        return true;
    }

    public void acceptTargets(@NotNull Set<String> myTargets, @NotNull Set<String> otherTargets) {
        Intrinsics.checkNotNullParameter(myTargets, (String)"myTargets");
        Intrinsics.checkNotNullParameter(otherTargets, (String)"otherTargets");
    }

    @Nullable
    public List<String> getMixins() {
        return null;
    }

    public void preApply(@NotNull String targetClassName, @NotNull ClassNode targetClass, @NotNull String mixinClassName, @NotNull IMixinInfo mixinInfo) {
        Intrinsics.checkNotNullParameter((Object)targetClassName, (String)"targetClassName");
        Intrinsics.checkNotNullParameter((Object)targetClass, (String)"targetClass");
        Intrinsics.checkNotNullParameter((Object)mixinClassName, (String)"mixinClassName");
        Intrinsics.checkNotNullParameter((Object)mixinInfo, (String)"mixinInfo");
    }

    public void postApply(@NotNull String targetClassName, @NotNull ClassNode targetClass, @NotNull String mixinClassName, @NotNull IMixinInfo mixinInfo) {
        Intrinsics.checkNotNullParameter((Object)targetClassName, (String)"targetClassName");
        Intrinsics.checkNotNullParameter((Object)targetClass, (String)"targetClass");
        Intrinsics.checkNotNullParameter((Object)mixinClassName, (String)"mixinClassName");
        Intrinsics.checkNotNullParameter((Object)mixinInfo, (String)"mixinInfo");
    }
}


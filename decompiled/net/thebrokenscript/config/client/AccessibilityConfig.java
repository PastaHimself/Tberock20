/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.thebrokenscript.brokencore.api.config.Config
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigBool
 *  net.thebrokenscript.brokencore.api.config.Config$SubGroup
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config.client;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.config.Config;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/config/client/AccessibilityConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "showPhotosensitivityWarning", "getShowPhotosensitivityWarning", "()Z", "setShowPhotosensitivityWarning", "(Z)V", "showPhotosensitivityWarning$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "showMarkScreen", "getShowMarkScreen", "setShowMarkScreen", "showMarkScreen$delegate", "enableAberration", "getEnableAberration", "setEnableAberration", "enableAberration$delegate", "thebrokenscript-common"})
public final class AccessibilityConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool showPhotosensitivityWarning$delegate;
    @NotNull
    private final Config.ConfigBool showMarkScreen$delegate;
    @NotNull
    private final Config.ConfigBool enableAberration$delegate;

    public AccessibilityConfig() {
        String[] stringArray = new String[]{"Show the photosensitivity warning on startup."};
        this.showPhotosensitivityWarning$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Show the note about the Mark101 ARG on startup."};
        this.showMarkScreen$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"Enable the chromatic aberration effect."};
        this.enableAberration$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[2]);
    }

    public final boolean getShowPhotosensitivityWarning() {
        return (Boolean)this.showPhotosensitivityWarning$delegate.getValue((Config)this, $$delegatedProperties[0]);
    }

    public final void setShowPhotosensitivityWarning(boolean bl) {
        this.showPhotosensitivityWarning$delegate.setValue((Config)this, $$delegatedProperties[0], (Object)bl);
    }

    public final boolean getShowMarkScreen() {
        return (Boolean)this.showMarkScreen$delegate.getValue((Config)this, $$delegatedProperties[1]);
    }

    public final void setShowMarkScreen(boolean bl) {
        this.showMarkScreen$delegate.setValue((Config)this, $$delegatedProperties[1], (Object)bl);
    }

    public final boolean getEnableAberration() {
        return (Boolean)this.enableAberration$delegate.getValue((Config)this, $$delegatedProperties[2]);
    }

    public final void setEnableAberration(boolean bl) {
        this.enableAberration$delegate.setValue((Config)this, $$delegatedProperties[2], (Object)bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(AccessibilityConfig.class, "showPhotosensitivityWarning", "getShowPhotosensitivityWarning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(AccessibilityConfig.class, "showMarkScreen", "getShowMarkScreen()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(AccessibilityConfig.class, "enableAberration", "getEnableAberration()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


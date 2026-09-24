/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/DebugConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "registryDebugLogging", "getRegistryDebugLogging", "()Z", "setRegistryDebugLogging", "(Z)V", "registryDebugLogging$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "brokencore-common"})
public final class DebugConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool registryDebugLogging$delegate;

    public DebugConfig() {
        String[] stringArray = new String[]{"Enable BrokenReg's debug logging."};
        this.registryDebugLogging$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
    }

    public final boolean getRegistryDebugLogging() {
        return (Boolean)this.registryDebugLogging$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setRegistryDebugLogging(boolean bl) {
        this.registryDebugLogging$delegate.setValue(this, $$delegatedProperties[0], bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(DebugConfig.class, "registryDebugLogging", "getRegistryDebugLogging()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


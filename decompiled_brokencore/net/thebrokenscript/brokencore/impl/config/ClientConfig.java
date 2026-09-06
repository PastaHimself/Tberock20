/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.neoforged.fml.config.ModConfig$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.neoforged.fml.config.ModConfig;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/ClientConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "<init>", "()V", "<set-?>", "", "disableCrashes", "getDisableCrashes", "()Z", "setDisableCrashes", "(Z)V", "disableCrashes$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "runningSwitches", "getRunningSwitches", "setRunningSwitches", "runningSwitches$delegate", "brokencore-common"})
public final class ClientConfig
extends Config.Base {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool disableCrashes$delegate;
    @NotNull
    private final Config.ConfigBool runningSwitches$delegate;

    public ClientConfig() {
        super(ModConfig.Type.CLIENT);
        String[] stringArray = new String[]{"Disable the ability for mods to crash your game intentionally."};
        this.disableCrashes$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Make switches run. Don't ask."};
        this.runningSwitches$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
    }

    public final boolean getDisableCrashes() {
        return (Boolean)this.disableCrashes$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setDisableCrashes(boolean bl) {
        this.disableCrashes$delegate.setValue(this, $$delegatedProperties[0], bl);
    }

    public final boolean getRunningSwitches() {
        return (Boolean)this.runningSwitches$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setRunningSwitches(boolean bl) {
        this.runningSwitches$delegate.setValue(this, $$delegatedProperties[1], bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "disableCrashes", "getDisableCrashes()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "runningSwitches", "getRunningSwitches()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


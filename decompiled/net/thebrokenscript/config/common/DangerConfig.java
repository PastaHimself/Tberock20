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
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config.common;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR+\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/config/common/DangerConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "disableAttackCooldown", "getDisableAttackCooldown", "()Z", "setDisableAttackCooldown", "(Z)V", "disableAttackCooldown$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "disableSpawningEntities", "getDisableSpawningEntities", "setDisableSpawningEntities", "disableSpawningEntities$delegate", "funnySetting", "getFunnySetting", "setFunnySetting", "funnySetting$delegate", "showTriggerBlocks", "getShowTriggerBlocks", "setShowTriggerBlocks", "showTriggerBlocks$delegate", "thebrokenscript-common"})
public final class DangerConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool disableAttackCooldown$delegate;
    @NotNull
    private final Config.ConfigBool disableSpawningEntities$delegate;
    @NotNull
    private final Config.ConfigBool funnySetting$delegate;
    @NotNull
    private final Config.ConfigBool showTriggerBlocks$delegate;

    public DangerConfig() {
        String[] stringArray = new String[]{"Disable the attack cooldown, restoring pre-1.9 attack behavior."};
        this.disableAttackCooldown$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Disable TBS random entity spawning. Note that this does not apply to naturally spawned entities."};
        this.disableSpawningEntities$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"The funny setting."};
        this.funnySetting$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Show trigger blocks."};
        this.showTriggerBlocks$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
    }

    public final boolean getDisableAttackCooldown() {
        return (Boolean)this.disableAttackCooldown$delegate.getValue((Config)this, $$delegatedProperties[0]);
    }

    public final void setDisableAttackCooldown(boolean bl) {
        this.disableAttackCooldown$delegate.setValue((Config)this, $$delegatedProperties[0], (Object)bl);
    }

    public final boolean getDisableSpawningEntities() {
        return (Boolean)this.disableSpawningEntities$delegate.getValue((Config)this, $$delegatedProperties[1]);
    }

    public final void setDisableSpawningEntities(boolean bl) {
        this.disableSpawningEntities$delegate.setValue((Config)this, $$delegatedProperties[1], (Object)bl);
    }

    public final boolean getFunnySetting() {
        return (Boolean)this.funnySetting$delegate.getValue((Config)this, $$delegatedProperties[2]);
    }

    public final void setFunnySetting(boolean bl) {
        this.funnySetting$delegate.setValue((Config)this, $$delegatedProperties[2], (Object)bl);
    }

    public final boolean getShowTriggerBlocks() {
        return (Boolean)this.showTriggerBlocks$delegate.getValue((Config)this, $$delegatedProperties[3]);
    }

    public final void setShowTriggerBlocks(boolean bl) {
        this.showTriggerBlocks$delegate.setValue((Config)this, $$delegatedProperties[3], (Object)bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(DangerConfig.class, "disableAttackCooldown", "getDisableAttackCooldown()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(DangerConfig.class, "disableSpawningEntities", "getDisableSpawningEntities()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(DangerConfig.class, "funnySetting", "getFunnySetting()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(DangerConfig.class, "showTriggerBlocks", "getShowTriggerBlocks()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


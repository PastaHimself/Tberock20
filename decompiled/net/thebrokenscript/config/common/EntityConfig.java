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
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigDouble
 *  net.thebrokenscript.brokencore.api.config.Config$SubGroup
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config.common;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.config.Config;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/config/common/EntityConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "disguisedCircuitEntityChance", "getDisguisedCircuitEntityChance", "()D", "setDisguisedCircuitEntityChance", "(D)V", "disguisedCircuitEntityChance$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigDouble;", "disguisedCircuitOreChance", "getDisguisedCircuitOreChance", "setDisguisedCircuitOreChance", "disguisedCircuitOreChance$delegate", "thebrokenscript-common"})
public final class EntityConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigDouble disguisedCircuitEntityChance$delegate;
    @NotNull
    private final Config.ConfigDouble disguisedCircuitOreChance$delegate;

    public EntityConfig() {
        String[] stringArray = new String[]{"The chance for an entity to spawn Circuit on death."};
        this.disguisedCircuitEntityChance$delegate = (Config.ConfigDouble)this.d(0.001, 0.0, 100.0, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"The chance for an ore to become a disguised Circuit."};
        this.disguisedCircuitOreChance$delegate = (Config.ConfigDouble)this.d(0.01, 0.0, 100.0, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
    }

    public final double getDisguisedCircuitEntityChance() {
        return ((Number)this.disguisedCircuitEntityChance$delegate.getValue((Config)this, $$delegatedProperties[0])).doubleValue();
    }

    public final void setDisguisedCircuitEntityChance(double d) {
        this.disguisedCircuitEntityChance$delegate.setValue((Config)this, $$delegatedProperties[0], (Object)d);
    }

    public final double getDisguisedCircuitOreChance() {
        return ((Number)this.disguisedCircuitOreChance$delegate.getValue((Config)this, $$delegatedProperties[1])).doubleValue();
    }

    public final void setDisguisedCircuitOreChance(double d) {
        this.disguisedCircuitOreChance$delegate.setValue((Config)this, $$delegatedProperties[1], (Object)d);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EntityConfig.class, "disguisedCircuitEntityChance", "getDisguisedCircuitEntityChance()D", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EntityConfig.class, "disguisedCircuitOreChance", "getDisguisedCircuitOreChance()D", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.config.UI;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001f\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F@FX\u0087\u008e\u0002\u00a2\u0006\u0018\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/EventsConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "enableRandomEvents", "getEnableRandomEvents", "()Z", "setEnableRandomEvents", "(Z)V", "enableRandomEvents$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "rerollEvents", "getRerollEvents", "setRerollEvents", "rerollEvents$delegate", "", "", "disabledEvents", "getDisabledEvents$annotations", "getDisabledEvents", "()Ljava/util/List;", "setDisabledEvents", "(Ljava/util/List;)V", "disabledEvents$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigList;", "eventDebug", "getEventDebug", "setEventDebug", "eventDebug$delegate", "isEnabled", "event", "Lnet/minecraft/resources/ResourceKey;", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "brokencore-common"})
public final class EventsConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool enableRandomEvents$delegate;
    @NotNull
    private final Config.ConfigBool rerollEvents$delegate;
    @NotNull
    private final Config.ConfigList disabledEvents$delegate;
    @NotNull
    private final Config.ConfigBool eventDebug$delegate;

    public EventsConfig() {
        String[] stringArray = new String[]{"Enable random events."};
        this.enableRandomEvents$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Enable rerolling events until the engine finds one that can execute."};
        this.rerollEvents$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"Random event IDs to disable."};
        this.disabledEvents$delegate = (Config.ConfigList)this.list(EventsConfig::disabledEvents_delegate$lambda$0, stringArray, CollectionsKt.emptyList(), (Function1<Object, Boolean>)((Function1)EventsConfig::disabledEvents_delegate$lambda$1)).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Enable debugging of events. will tell player what event is attempted to run."};
        this.eventDebug$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
    }

    public final boolean getEnableRandomEvents() {
        return (Boolean)this.enableRandomEvents$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEnableRandomEvents(boolean bl) {
        this.enableRandomEvents$delegate.setValue(this, $$delegatedProperties[0], bl);
    }

    public final boolean getRerollEvents() {
        return (Boolean)this.rerollEvents$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setRerollEvents(boolean bl) {
        this.rerollEvents$delegate.setValue(this, $$delegatedProperties[1], bl);
    }

    @NotNull
    public final List<String> getDisabledEvents() {
        return (List)this.disabledEvents$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setDisabledEvents(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.disabledEvents$delegate.setValue(this, $$delegatedProperties[2], list);
    }

    @UI(mode=UI.Mode.EVENTS)
    public static /* synthetic */ void getDisabledEvents$annotations() {
    }

    public final boolean getEventDebug() {
        return (Boolean)this.eventDebug$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setEventDebug(boolean bl) {
        this.eventDebug$delegate.setValue(this, $$delegatedProperties[3], bl);
    }

    public final boolean isEnabled(@NotNull ResourceKey<RandomEvent> event) {
        Intrinsics.checkNotNullParameter(event, (String)"event");
        return !this.getDisabledEvents().contains(event.location().toString());
    }

    private static final String disabledEvents_delegate$lambda$0() {
        return "";
    }

    private static final boolean disabledEvents_delegate$lambda$1(Object it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it instanceof String && ResourceLocation.tryParse((String)((String)it)) != null;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EventsConfig.class, "enableRandomEvents", "getEnableRandomEvents()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EventsConfig.class, "rerollEvents", "getRerollEvents()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EventsConfig.class, "disabledEvents", "getDisabledEvents()Ljava/util/List;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(EventsConfig.class, "eventDebug", "getEventDebug()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


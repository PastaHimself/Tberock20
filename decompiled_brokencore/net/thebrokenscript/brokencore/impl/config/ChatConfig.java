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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/ChatConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "enableChatResponses", "getEnableChatResponses", "()Z", "setEnableChatResponses", "(Z)V", "enableChatResponses$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "forceFastResponses", "getForceFastResponses", "setForceFastResponses", "forceFastResponses$delegate", "brokencore-common"})
public final class ChatConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool enableChatResponses$delegate;
    @NotNull
    private final Config.ConfigBool forceFastResponses$delegate;

    public ChatConfig() {
        String[] stringArray = new String[]{"Enable the chat responses system."};
        this.enableChatResponses$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Force all chat responses to react instantly."};
        this.forceFastResponses$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
    }

    public final boolean getEnableChatResponses() {
        return (Boolean)this.enableChatResponses$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEnableChatResponses(boolean bl) {
        this.enableChatResponses$delegate.setValue(this, $$delegatedProperties[0], bl);
    }

    public final boolean getForceFastResponses() {
        return (Boolean)this.forceFastResponses$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setForceFastResponses(boolean bl) {
        this.forceFastResponses$delegate.setValue(this, $$delegatedProperties[1], bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChatConfig.class, "enableChatResponses", "getEnableChatResponses()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ChatConfig.class, "forceFastResponses", "getForceFastResponses()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


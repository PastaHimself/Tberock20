/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KProperty
 *  net.neoforged.fml.config.ModConfig$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import net.neoforged.fml.config.ModConfig;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.impl.config.ChatConfig;
import net.thebrokenscript.brokencore.impl.config.EventsConfig;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/ServerConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "<init>", "()V", "events", "Lnet/thebrokenscript/brokencore/impl/config/EventsConfig;", "getEvents", "()Lnet/thebrokenscript/brokencore/impl/config/EventsConfig;", "events$delegate", "Lkotlin/properties/ReadOnlyProperty;", "chat", "Lnet/thebrokenscript/brokencore/impl/config/ChatConfig;", "getChat", "()Lnet/thebrokenscript/brokencore/impl/config/ChatConfig;", "chat$delegate", "<set-?>", "", "enableCheats", "getEnableCheats", "()Z", "setEnableCheats", "(Z)V", "enableCheats$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "disableChunkRemoval", "getDisableChunkRemoval", "setDisableChunkRemoval", "disableChunkRemoval$delegate", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nServerConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerConfig.kt\nnet/thebrokenscript/brokencore/impl/config/ServerConfig\n+ 2 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n176#2:15\n177#2,2:18\n176#2:20\n177#2,2:23\n295#3,2:16\n295#3,2:21\n*S KotlinDebug\n*F\n+ 1 ServerConfig.kt\nnet/thebrokenscript/brokencore/impl/config/ServerConfig\n*L\n8#1:15\n8#1:18,2\n9#1:20\n9#1:23,2\n8#1:16,2\n9#1:21,2\n*E\n"})
public final class ServerConfig
extends Config.Base {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty events$delegate;
    @NotNull
    private final ReadOnlyProperty chat$delegate;
    @NotNull
    private final Config.ConfigBool enableCheats$delegate;
    @NotNull
    private final Config.ConfigBool disableChunkRemoval$delegate;

    public ServerConfig() {
        Object v2;
        String[] comment$iv;
        Config this_$iv;
        KFunction constructor$iv;
        String[] stringArray;
        block5: {
            Object v0;
            boolean bl;
            KFunction it$iv;
            boolean $i$f$firstOrNull;
            Iterable $this$firstOrNull$iv$iv;
            boolean $i$f$nested;
            ServerConfig serverConfig;
            block4: {
                super(ModConfig.Type.COMMON);
                stringArray = (String[])this;
                String[] stringArray2 = new String[]{"Events configuration."};
                serverConfig = this;
                $i$f$nested = false;
                $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(EventsConfig.class).getConstructors();
                $i$f$firstOrNull = false;
                for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                    it$iv = (KFunction)element$iv$iv;
                    bl = false;
                    if (!it$iv.getParameters().isEmpty()) continue;
                    v0 = element$iv$iv;
                    break block4;
                }
                v0 = null;
            }
            KFunction kFunction = v0;
            if (kFunction == null) {
                throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(EventsConfig.class) + " must have a single empty constructor");
            }
            constructor$iv = kFunction;
            serverConfig.events$delegate = (ReadOnlyProperty)Config.access$nested(this_$iv, (Function0)new Function0<EventsConfig>(constructor$iv){
                final /* synthetic */ KFunction $constructor;
                {
                    this.$constructor = $constructor;
                }

                public final EventsConfig invoke() {
                    return (Config.SubGroup)this.$constructor.call(new Object[0]);
                }
            }, (String[])Arrays.copyOf(comment$iv, comment$iv.length)).provideDelegate((Object)this, $$delegatedProperties[0]);
            this_$iv = this;
            comment$iv = new String[]{"Chat responses configuration."};
            serverConfig = this;
            $i$f$nested = false;
            $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(ChatConfig.class).getConstructors();
            $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                it$iv = (KFunction)element$iv$iv;
                bl = false;
                if (!it$iv.getParameters().isEmpty()) continue;
                v2 = element$iv$iv;
                break block5;
            }
            v2 = null;
        }
        KFunction kFunction = v2;
        if (kFunction == null) {
            throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(ChatConfig.class) + " must have a single empty constructor");
        }
        constructor$iv = kFunction;
        serverConfig.chat$delegate = (ReadOnlyProperty)Config.access$nested(this_$iv, (Function0)new Function0<ChatConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final ChatConfig invoke() {
                return (Config.SubGroup)this.$constructor.call(new Object[0]);
            }
        }, Arrays.copyOf(comment$iv, comment$iv.length)).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"Enable cheats."};
        this.enableCheats$delegate = (Config.ConfigBool)this.b(!PlatformUtil.Companion.isProduction(), stringArray).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Disable the ability for mods to delete entire chunks."};
        this.disableChunkRemoval$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
    }

    @NotNull
    public final EventsConfig getEvents() {
        return (EventsConfig)this.events$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public final ChatConfig getChat() {
        return (ChatConfig)this.chat$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    public final boolean getEnableCheats() {
        return (Boolean)this.enableCheats$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setEnableCheats(boolean bl) {
        this.enableCheats$delegate.setValue(this, $$delegatedProperties[2], bl);
    }

    public final boolean getDisableChunkRemoval() {
        return (Boolean)this.disableChunkRemoval$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setDisableChunkRemoval(boolean bl) {
        this.disableChunkRemoval$delegate.setValue(this, $$delegatedProperties[3], bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ServerConfig.class, "events", "getEvents()Lnet/thebrokenscript/brokencore/impl/config/EventsConfig;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ServerConfig.class, "chat", "getChat()Lnet/thebrokenscript/brokencore/impl/config/ChatConfig;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "enableCheats", "getEnableCheats()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "disableChunkRemoval", "getDisableChunkRemoval()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


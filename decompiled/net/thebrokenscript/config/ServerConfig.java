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
 *  net.thebrokenscript.brokencore.api.config.Config
 *  net.thebrokenscript.brokencore.api.config.Config$Base
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigBool
 *  net.thebrokenscript.brokencore.api.config.Config$SubGroup
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config;

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
import net.thebrokenscript.config.common.DangerConfig;
import net.thebrokenscript.config.common.EntityConfig;
import net.thebrokenscript.config.common.WorldConfig;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR+\u0010!\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR+\u0010%\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u001c\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR+\u0010)\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u001c\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001a\u00a8\u0006-"}, d2={"Lnet/thebrokenscript/config/ServerConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "<init>", "()V", "world", "Lnet/thebrokenscript/config/common/WorldConfig;", "getWorld", "()Lnet/thebrokenscript/config/common/WorldConfig;", "world$delegate", "Lkotlin/properties/ReadOnlyProperty;", "entities", "Lnet/thebrokenscript/config/common/EntityConfig;", "getEntities", "()Lnet/thebrokenscript/config/common/EntityConfig;", "entities$delegate", "danger", "Lnet/thebrokenscript/config/common/DangerConfig;", "getDanger", "()Lnet/thebrokenscript/config/common/DangerConfig;", "danger$delegate", "<set-?>", "", "disableBanning", "getDisableBanning", "()Z", "setDisableBanning", "(Z)V", "disableBanning$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "disableBlockBreaking", "getDisableBlockBreaking", "setDisableBlockBreaking", "disableBlockBreaking$delegate", "disableRandomJumpscares", "getDisableRandomJumpscares", "setDisableRandomJumpscares", "disableRandomJumpscares$delegate", "disableNewMobSpawning", "getDisableNewMobSpawning", "setDisableNewMobSpawning", "disableNewMobSpawning$delegate", "enableKeepInventory", "getEnableKeepInventory", "setEnableKeepInventory", "enableKeepInventory$delegate", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nServerConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerConfig.kt\nnet/thebrokenscript/config/ServerConfig\n+ 2 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,22:1\n176#2:23\n177#2,2:26\n176#2:28\n177#2,2:31\n176#2:33\n177#2,2:36\n295#3,2:24\n295#3,2:29\n295#3,2:34\n*S KotlinDebug\n*F\n+ 1 ServerConfig.kt\nnet/thebrokenscript/config/ServerConfig\n*L\n10#1:23\n10#1:26,2\n11#1:28\n11#1:31,2\n12#1:33\n12#1:36,2\n10#1:24,2\n11#1:29,2\n12#1:34,2\n*E\n"})
public final class ServerConfig
extends Config.Base {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty world$delegate;
    @NotNull
    private final ReadOnlyProperty entities$delegate;
    @NotNull
    private final ReadOnlyProperty danger$delegate;
    @NotNull
    private final Config.ConfigBool disableBanning$delegate;
    @NotNull
    private final Config.ConfigBool disableBlockBreaking$delegate;
    @NotNull
    private final Config.ConfigBool disableRandomJumpscares$delegate;
    @NotNull
    private final Config.ConfigBool disableNewMobSpawning$delegate;
    @NotNull
    private final Config.ConfigBool enableKeepInventory$delegate;

    public ServerConfig() {
        Object v4;
        String[] comment$iv;
        Config this_$iv;
        KFunction constructor$iv;
        String[] stringArray;
        block8: {
            Object v2;
            boolean bl;
            KFunction it$iv;
            boolean $i$f$firstOrNull;
            Iterable $this$firstOrNull$iv$iv;
            boolean $i$f$nested;
            ServerConfig serverConfig;
            block7: {
                Object v0;
                block6: {
                    super(ModConfig.Type.COMMON);
                    stringArray = (String[])this;
                    String[] stringArray2 = new String[]{"World configuration."};
                    serverConfig = this;
                    $i$f$nested = false;
                    $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(WorldConfig.class).getConstructors();
                    $i$f$firstOrNull = false;
                    for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                        it$iv = (KFunction)element$iv$iv;
                        bl = false;
                        if (!it$iv.getParameters().isEmpty()) continue;
                        v0 = element$iv$iv;
                        break block6;
                    }
                    v0 = null;
                }
                KFunction kFunction = v0;
                if (kFunction == null) {
                    throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(WorldConfig.class) + " must have a single empty constructor");
                }
                constructor$iv = kFunction;
                serverConfig.world$delegate = (ReadOnlyProperty)Config.access$nested((Config)this_$iv, (Function0)((Function0)new Function0<WorldConfig>(constructor$iv){
                    final /* synthetic */ KFunction $constructor;
                    {
                        this.$constructor = $constructor;
                    }

                    public final WorldConfig invoke() {
                        return (Config.SubGroup)this.$constructor.call(new Object[0]);
                    }
                }), (String[])((String[])Arrays.copyOf(comment$iv, comment$iv.length))).provideDelegate((Object)this, $$delegatedProperties[0]);
                this_$iv = (Config)this;
                comment$iv = new String[]{"Entity configuration."};
                serverConfig = this;
                $i$f$nested = false;
                $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(EntityConfig.class).getConstructors();
                $i$f$firstOrNull = false;
                for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                    it$iv = (KFunction)element$iv$iv;
                    bl = false;
                    if (!it$iv.getParameters().isEmpty()) continue;
                    v2 = element$iv$iv;
                    break block7;
                }
                v2 = null;
            }
            KFunction kFunction = v2;
            if (kFunction == null) {
                throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(EntityConfig.class) + " must have a single empty constructor");
            }
            constructor$iv = kFunction;
            serverConfig.entities$delegate = (ReadOnlyProperty)Config.access$nested((Config)this_$iv, (Function0)((Function0)new Function0<EntityConfig>(constructor$iv){
                final /* synthetic */ KFunction $constructor;
                {
                    this.$constructor = $constructor;
                }

                public final EntityConfig invoke() {
                    return (Config.SubGroup)this.$constructor.call(new Object[0]);
                }
            }), (String[])Arrays.copyOf(comment$iv, comment$iv.length)).provideDelegate((Object)this, $$delegatedProperties[1]);
            this_$iv = (Config)this;
            comment$iv = new String[]{"DANGER! THIS BREAKS THE INTENDED EXPERIENCE OF THE MOD!", "ONLY DO THIS IF YOU KNOW WHAT YOU ARE DOING."};
            serverConfig = this;
            $i$f$nested = false;
            $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(DangerConfig.class).getConstructors();
            $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                it$iv = (KFunction)element$iv$iv;
                bl = false;
                if (!it$iv.getParameters().isEmpty()) continue;
                v4 = element$iv$iv;
                break block8;
            }
            v4 = null;
        }
        KFunction kFunction = v4;
        if (kFunction == null) {
            throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(DangerConfig.class) + " must have a single empty constructor");
        }
        constructor$iv = kFunction;
        serverConfig.danger$delegate = (ReadOnlyProperty)Config.access$nested((Config)this_$iv, (Function0)((Function0)new Function0<DangerConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final DangerConfig invoke() {
                return (Config.SubGroup)this.$constructor.call(new Object[0]);
            }
        }), (String[])Arrays.copyOf(comment$iv, comment$iv.length)).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Disable getting banned from your world."};
        this.disableBanning$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
        stringArray = new String[]{"Disable TBS Entity's breaking blocks."};
        this.disableBlockBreaking$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[4]);
        stringArray = new String[]{"Disable random jumpscares."};
        this.disableRandomJumpscares$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[5]);
        stringArray = new String[]{"Disable spawning mobs from newer Minecraft versions."};
        this.disableNewMobSpawning$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[6]);
        stringArray = new String[]{"Enable keep inventory, only for TBS dimensions."};
        this.enableKeepInventory$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[7]);
    }

    @NotNull
    public final WorldConfig getWorld() {
        return (WorldConfig)((Object)this.world$delegate.getValue((Object)this, $$delegatedProperties[0]));
    }

    @NotNull
    public final EntityConfig getEntities() {
        return (EntityConfig)((Object)this.entities$delegate.getValue((Object)this, $$delegatedProperties[1]));
    }

    @NotNull
    public final DangerConfig getDanger() {
        return (DangerConfig)((Object)this.danger$delegate.getValue((Object)this, $$delegatedProperties[2]));
    }

    public final boolean getDisableBanning() {
        return (Boolean)this.disableBanning$delegate.getValue((Config)this, $$delegatedProperties[3]);
    }

    public final void setDisableBanning(boolean bl) {
        this.disableBanning$delegate.setValue((Config)this, $$delegatedProperties[3], (Object)bl);
    }

    public final boolean getDisableBlockBreaking() {
        return (Boolean)this.disableBlockBreaking$delegate.getValue((Config)this, $$delegatedProperties[4]);
    }

    public final void setDisableBlockBreaking(boolean bl) {
        this.disableBlockBreaking$delegate.setValue((Config)this, $$delegatedProperties[4], (Object)bl);
    }

    public final boolean getDisableRandomJumpscares() {
        return (Boolean)this.disableRandomJumpscares$delegate.getValue((Config)this, $$delegatedProperties[5]);
    }

    public final void setDisableRandomJumpscares(boolean bl) {
        this.disableRandomJumpscares$delegate.setValue((Config)this, $$delegatedProperties[5], (Object)bl);
    }

    public final boolean getDisableNewMobSpawning() {
        return (Boolean)this.disableNewMobSpawning$delegate.getValue((Config)this, $$delegatedProperties[6]);
    }

    public final void setDisableNewMobSpawning(boolean bl) {
        this.disableNewMobSpawning$delegate.setValue((Config)this, $$delegatedProperties[6], (Object)bl);
    }

    public final boolean getEnableKeepInventory() {
        return (Boolean)this.enableKeepInventory$delegate.getValue((Config)this, $$delegatedProperties[7]);
    }

    public final void setEnableKeepInventory(boolean bl) {
        this.enableKeepInventory$delegate.setValue((Config)this, $$delegatedProperties[7], (Object)bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ServerConfig.class, "world", "getWorld()Lnet/thebrokenscript/config/common/WorldConfig;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ServerConfig.class, "entities", "getEntities()Lnet/thebrokenscript/config/common/EntityConfig;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ServerConfig.class, "danger", "getDanger()Lnet/thebrokenscript/config/common/DangerConfig;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "disableBanning", "getDisableBanning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "disableBlockBreaking", "getDisableBlockBreaking()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "disableRandomJumpscares", "getDisableRandomJumpscares()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "disableNewMobSpawning", "getDisableNewMobSpawning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ServerConfig.class, "enableKeepInventory", "getEnableKeepInventory()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientPacketListener
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.neoforged.fml.config.IConfigSpec
 *  net.neoforged.fml.config.ModConfig
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.neoforge.common.ModConfigSpec
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.config;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.config.ConfigSerializer;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.impl.packets.ConfigUpdatePacket;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bJ\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0015J%\u0010\u0016\u001a\u0002H\u0017\"\b\b\u0000\u0010\u0017*\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0004\u00a2\u0006\u0002\u0010\u001aJ\u001a\u0010\u0016\u001a\u0002H\u0017\"\n\b\u0000\u0010\u0017\u0018\u0001*\u00020\tH\u0084\b\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u0006\u0010%\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "configs", "Ljava/util/EnumMap;", "Lnet/neoforged/fml/config/ModConfig$Type;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "id", "", "getId", "()Ljava/lang/String;", "value", "", "isLoaded", "()Z", "byType", "type", "all", "", "register", "T", "factory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "()Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "updatePacket", "", "cfg", "isConnectedToServer", "onLoad", "config", "Lnet/neoforged/fml/config/ModConfig;", "onReload", "onUnload", "init", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nConfigContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n295#2,2:166\n*S KotlinDebug\n*F\n+ 1 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer\n*L\n79#1:166,2\n*E\n"})
public class ConfigContainer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BrokenReg reg;
    @NotNull
    private final EnumMap<ModConfig.Type, Config.Base> configs;
    @NotNull
    private final String id;
    private boolean isLoaded;

    public ConfigContainer(@NotNull BrokenReg reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        this.reg = reg;
        this.configs = new EnumMap(ModConfig.Type.class);
        this.id = this.reg.getModId();
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    @NotNull
    public final Config.Base byType(@NotNull ModConfig.Type type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Config.Base base = this.configs.get(type);
        if (base == null) {
            throw new IllegalStateException(("No config registered for type " + type).toString());
        }
        return base;
    }

    @NotNull
    public final Map<ModConfig.Type, Config.Base> all() {
        return this.configs;
    }

    @NotNull
    protected final <T extends Config.Base> T register(@NotNull Function0<? extends T> factory2) {
        Intrinsics.checkNotNullParameter(factory2, (String)"factory");
        Config.Base config = (Config.Base)factory2.invoke();
        ModConfig.Type side = config.getType();
        if (this.configs.containsKey(side)) {
            throw new IllegalStateException(("Config for side " + side + " already registered!").toString());
        }
        ModConfigSpec.Builder it = new ModConfigSpec.Builder();
        boolean bl = false;
        ((Config)config).registerAll(it);
        ModConfigSpec spec = it.build();
        Intrinsics.checkNotNull((Object)spec);
        config.setSpecification$brokencore_common(spec);
        ((Map)this.configs).put(side, config);
        return (T)config;
    }

    protected final /* synthetic */ <T extends Config.Base> T register() {
        Object v0;
        block2: {
            boolean $i$f$register = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            Iterable $this$firstOrNull$iv = Reflection.getOrCreateKotlinClass(Config.Base.class).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                KFunction it = (KFunction)element$iv;
                boolean bl = false;
                if (!it.getParameters().isEmpty()) continue;
                v0 = element$iv;
                break block2;
            }
            v0 = null;
        }
        KFunction kFunction = v0;
        if (kFunction == null) {
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(Config.Base.class).getQualifiedName()).toString());
        }
        KFunction constructor = kFunction;
        Intrinsics.needClassReification();
        return (T)this.register(new Function0<T>(constructor){
            final /* synthetic */ KFunction<T> $constructor;
            {
                this.$constructor = $constructor;
            }

            public final T invoke() {
                return (T)((Config.Base)this.$constructor.call(new Object[0]));
            }
        });
    }

    private final void updatePacket(Config.Base cfg) {
        if (!PlatformUtil.Companion.isClientSide()) {
            return;
        }
        if (cfg.getType() == ModConfig.Type.CLIENT) {
            return;
        }
        if (!this.isConnectedToServer()) {
            return;
        }
        ConfigUpdatePacket packet = (ConfigUpdatePacket)BCPackets.CONFIG_UPDATE.of(ConfigSerializer.INSTANCE.serialize(this.id, cfg));
        PacketSender.INSTANCE.sendToServer(packet, new CustomPacketPayload[0]);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isConnectedToServer() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.isSingleplayer()) {
            return false;
        }
        if (minecraft.getConnection() == null) return false;
        ClientPacketListener clientPacketListener = minecraft.getConnection();
        Intrinsics.checkNotNull((Object)clientPacketListener);
        if (!clientPacketListener.getConnection().isConnected()) return false;
        return true;
    }

    public final void onLoad(@NotNull ModConfig config) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Config.Base base = this.configs.get(config.getType());
        if (base == null) {
            return;
        }
        Config.Base cfg = base;
        cfg.onLoad();
        this.updatePacket(cfg);
        this.isLoaded = true;
    }

    public final void onReload(@NotNull ModConfig config) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Config.Base base = this.configs.get(config.getType());
        if (base == null) {
            return;
        }
        Config.Base cfg = base;
        cfg.onReload();
        this.updatePacket(cfg);
    }

    public final void onUnload(@NotNull ModConfig config) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)config, (String)"config");
            this.isLoaded = false;
            Config.Base base = this.configs.get(config.getType());
            if (base == null) break block0;
            base.onUnload();
        }
    }

    public final void init() {
        for (Map.Entry entry : ((Map)this.configs).entrySet()) {
            ModConfig.Type type = (ModConfig.Type)entry.getKey();
            Config.Base cfg = (Config.Base)entry.getValue();
            Intrinsics.checkNotNull((Object)type);
            PlatformUtil.Companion.registerConfig(this.id, type, (IConfigSpec)cfg.getSpecification());
        }
        PlatformUtil.Companion.registerConfigListeners(this);
        for (Config.Base cfg : this.configs.values()) {
            cfg.genLang(this.reg);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/config/ConfigContainer$Companion;", "", "<init>", "()V", "onUpdate", "", "data", "Lnet/minecraft/network/FriendlyByteBuf;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nConfigContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1#2:166\n295#3,2:167\n*S KotlinDebug\n*F\n+ 1 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer$Companion\n*L\n152#1:167,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final void onUpdate(@NotNull FriendlyByteBuf data2) {
            void var11_23;
            Object t;
            boolean bl;
            Iterable configSet;
            Object $this$onUpdate_u24lambda_u241;
            Object $this$onUpdate_u24lambda_u240;
            Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
            String modId = data2.readUtf();
            ModConfig.Type type = (ModConfig.Type)data2.readEnum(ModConfig.Type.class);
            Object object = this;
            try {
                $this$onUpdate_u24lambda_u240 = object;
                boolean bl2 = false;
                $this$onUpdate_u24lambda_u240 = Result.constructor-impl(Class.forName("net.neoforged.fml.config.ModConfigs"));
            }
            catch (Throwable bl2) {
                $this$onUpdate_u24lambda_u240 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl2));
            }
            object = $this$onUpdate_u24lambda_u240;
            Class clazz = (Class)(Result.isFailure-impl((Object)object) ? null : object);
            if (clazz == null) {
                return;
            }
            Class modConfigsClass = clazz;
            Object bl2 = this;
            try {
                $this$onUpdate_u24lambda_u241 = bl2;
                boolean bl3 = false;
                Class[] classArray = new Class[]{ModConfig.Type.class};
                Object[] objectArray = new Object[]{type};
                $this$onUpdate_u24lambda_u241 = Result.constructor-impl((Object)modConfigsClass.getMethod("getConfigSet", classArray).invoke(null, objectArray));
            }
            catch (Throwable throwable) {
                $this$onUpdate_u24lambda_u241 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            bl2 = $this$onUpdate_u24lambda_u241;
            $this$onUpdate_u24lambda_u240 = Result.isFailure-impl((Object)bl2) ? null : bl2;
            if (!($this$onUpdate_u24lambda_u240 instanceof Iterable)) return;
            Iterable iterable = (Iterable)$this$onUpdate_u24lambda_u240;
            if (iterable == null) {
                return;
            }
            Iterable $this$firstOrNull$iv = configSet = iterable;
            boolean $i$f$firstOrNull = false;
            Object object2 = $this$firstOrNull$iv.iterator();
            do {
                if (!object2.hasNext()) return;
                Object it = t = object2.next();
                boolean bl4 = false;
                if (it != null) {
                    Object object3;
                    Object object4 = Companion;
                    try {
                        Companion $this$onUpdate_u24lambda_u242_u240 = object4;
                        boolean bl5 = false;
                        Object object5 = it.getClass().getMethod("getModId", new Class[0]).invoke(it, new Object[0]);
                        object3 = Result.constructor-impl((Object)(object5 instanceof String ? (String)object5 : null));
                    }
                    catch (Throwable throwable) {
                        object3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                    object4 = object3;
                    if (Intrinsics.areEqual((Object)(Result.isFailure-impl((Object)object4) ? null : object4), (Object)modId)) {
                        bl = true;
                        continue;
                    }
                }
                bl = false;
            } while (!bl);
            Object object6 = t;
            if (object6 == null) {
                return;
            }
            Object target = object6;
            object2 = this;
            try {
                Companion companion = (Companion)object2;
                boolean bl6 = false;
                Object object7 = Result.constructor-impl((Object)target.getClass().getMethod("getSpec", new Class[0]).invoke(target, new Object[0]));
            }
            catch (Throwable throwable) {
                Object object8 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object2 = var11_23;
            Object object9 = Result.isFailure-impl((Object)object2) ? null : object2;
            if (!(object9 instanceof ModConfigSpec)) return;
            ModConfigSpec modConfigSpec = (ModConfigSpec)object9;
            if (modConfigSpec == null) {
                return;
            }
            ModConfigSpec spec = modConfigSpec;
            ConfigSerializer.INSTANCE.deserialize(spec, data2);
            CompletableFuture.runAsync(() -> Companion.onUpdate$lambda$4(spec));
        }

        private static final void onUpdate$lambda$4(ModConfigSpec $spec) {
            $spec.save();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


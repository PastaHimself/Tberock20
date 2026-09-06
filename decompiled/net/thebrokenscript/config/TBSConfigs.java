/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 *  net.thebrokenscript.brokencore.api.config.Config$Base
 *  net.thebrokenscript.brokencore.api.config.ConfigContainer
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.config.ClientConfig;
import net.thebrokenscript.config.ServerConfig;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/config/TBSConfigs;", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "<init>", "()V", "client", "Lnet/thebrokenscript/config/ClientConfig;", "getClient", "()Lnet/thebrokenscript/config/ClientConfig;", "server", "Lnet/thebrokenscript/config/ServerConfig;", "getServer", "()Lnet/thebrokenscript/config/ServerConfig;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSConfigs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSConfigs.kt\nnet/thebrokenscript/config/TBSConfigs\n+ 2 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,10:1\n79#2:11\n80#2,2:14\n79#2:16\n80#2,2:19\n295#3,2:12\n295#3,2:17\n*S KotlinDebug\n*F\n+ 1 TBSConfigs.kt\nnet/thebrokenscript/config/TBSConfigs\n*L\n7#1:11\n7#1:14,2\n8#1:16\n8#1:19,2\n7#1:12,2\n8#1:17,2\n*E\n"})
public final class TBSConfigs
extends ConfigContainer {
    @NotNull
    public static final TBSConfigs INSTANCE;
    @NotNull
    private static final ClientConfig client;
    @NotNull
    private static final ServerConfig server;

    private TBSConfigs() {
        super((BrokenReg)TBSReg.INSTANCE);
    }

    @NotNull
    public final ClientConfig getClient() {
        return client;
    }

    @NotNull
    public final ServerConfig getServer() {
        return server;
    }

    static {
        Object v2;
        KFunction constructor$iv;
        ConfigContainer this_$iv;
        block5: {
            Object v0;
            boolean bl;
            KFunction it$iv;
            boolean $i$f$firstOrNull;
            Iterable $this$firstOrNull$iv$iv;
            boolean $i$f$register;
            block4: {
                INSTANCE = new TBSConfigs();
                this_$iv = INSTANCE;
                $i$f$register = false;
                $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(ClientConfig.class).getConstructors();
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
                throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(ClientConfig.class).getQualifiedName()).toString());
            }
            constructor$iv = kFunction;
            client = (ClientConfig)ConfigContainer.access$register((ConfigContainer)this_$iv, (Function0)((Function0)new Function0<ClientConfig>(constructor$iv){
                final /* synthetic */ KFunction $constructor;
                {
                    this.$constructor = $constructor;
                }

                public final ClientConfig invoke() {
                    return (Config.Base)this.$constructor.call(new Object[0]);
                }
            }));
            this_$iv = INSTANCE;
            $i$f$register = false;
            $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(ServerConfig.class).getConstructors();
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
            throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(ServerConfig.class).getQualifiedName()).toString());
        }
        constructor$iv = kFunction;
        server = (ServerConfig)ConfigContainer.access$register((ConfigContainer)this_$iv, (Function0)((Function0)new Function0<ServerConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final ServerConfig invoke() {
                return (Config.Base)this.$constructor.call(new Object[0]);
            }
        }));
    }
}


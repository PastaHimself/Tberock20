/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.impl.config.ClientConfig;
import net.thebrokenscript.brokencore.impl.config.ServerConfig;
import net.thebrokenscript.brokencore.impl.config.StartupConfig;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/impl/config/BCConfigs;", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "<init>", "()V", "client", "Lnet/thebrokenscript/brokencore/impl/config/ClientConfig;", "getClient", "()Lnet/thebrokenscript/brokencore/impl/config/ClientConfig;", "server", "Lnet/thebrokenscript/brokencore/impl/config/ServerConfig;", "getServer", "()Lnet/thebrokenscript/brokencore/impl/config/ServerConfig;", "startup", "Lnet/thebrokenscript/brokencore/impl/config/StartupConfig;", "getStartup", "()Lnet/thebrokenscript/brokencore/impl/config/StartupConfig;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCConfigs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCConfigs.kt\nnet/thebrokenscript/brokencore/impl/config/BCConfigs\n+ 2 ConfigContainer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigContainer\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,14:1\n79#2:15\n80#2,2:18\n79#2:20\n80#2,2:23\n79#2:25\n80#2,2:28\n295#3,2:16\n295#3,2:21\n295#3,2:26\n*S KotlinDebug\n*F\n+ 1 BCConfigs.kt\nnet/thebrokenscript/brokencore/impl/config/BCConfigs\n*L\n7#1:15\n7#1:18,2\n8#1:20\n8#1:23,2\n9#1:25\n9#1:28,2\n7#1:16,2\n8#1:21,2\n9#1:26,2\n*E\n"})
public final class BCConfigs
extends ConfigContainer {
    @NotNull
    public static final BCConfigs INSTANCE;
    @NotNull
    private static final ClientConfig client;
    @NotNull
    private static final ServerConfig server;
    @NotNull
    private static final StartupConfig startup;

    private BCConfigs() {
        super(BCReg.INSTANCE);
    }

    @NotNull
    public final ClientConfig getClient() {
        return client;
    }

    @NotNull
    public final ServerConfig getServer() {
        return server;
    }

    @NotNull
    public final StartupConfig getStartup() {
        return startup;
    }

    static {
        Object v4;
        KFunction constructor$iv;
        ConfigContainer this_$iv;
        block8: {
            Object v2;
            boolean bl;
            KFunction it$iv;
            boolean $i$f$firstOrNull;
            Iterable $this$firstOrNull$iv$iv;
            boolean $i$f$register;
            block7: {
                Object v0;
                block6: {
                    INSTANCE = new BCConfigs();
                    this_$iv = INSTANCE;
                    $i$f$register = false;
                    $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(ClientConfig.class).getConstructors();
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
                    throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(ClientConfig.class).getQualifiedName()).toString());
                }
                constructor$iv = kFunction;
                client = (ClientConfig)ConfigContainer.access$register(this_$iv, (Function0)new Function0<ClientConfig>(constructor$iv){
                    final /* synthetic */ KFunction $constructor;
                    {
                        this.$constructor = $constructor;
                    }

                    public final ClientConfig invoke() {
                        return (Config.Base)this.$constructor.call(new Object[0]);
                    }
                });
                this_$iv = INSTANCE;
                $i$f$register = false;
                $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(ServerConfig.class).getConstructors();
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
                throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(ServerConfig.class).getQualifiedName()).toString());
            }
            constructor$iv = kFunction;
            server = (ServerConfig)ConfigContainer.access$register(this_$iv, (Function0)new Function0<ServerConfig>(constructor$iv){
                final /* synthetic */ KFunction $constructor;
                {
                    this.$constructor = $constructor;
                }

                public final ServerConfig invoke() {
                    return (Config.Base)this.$constructor.call(new Object[0]);
                }
            });
            this_$iv = INSTANCE;
            $i$f$register = false;
            $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(StartupConfig.class).getConstructors();
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
            throw new IllegalStateException(("No empty constructor found for config class " + Reflection.getOrCreateKotlinClass(StartupConfig.class).getQualifiedName()).toString());
        }
        constructor$iv = kFunction;
        startup = (StartupConfig)ConfigContainer.access$register(this_$iv, (Function0)new Function0<StartupConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final StartupConfig invoke() {
                return (Config.Base)this.$constructor.call(new Object[0]);
            }
        });
    }
}


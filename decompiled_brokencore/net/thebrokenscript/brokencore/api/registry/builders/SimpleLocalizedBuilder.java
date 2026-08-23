/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.Localizer;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000*\u001a\b\u0000\u0010\u0001*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0000*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0003*\u0002H\u00022&\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004BA\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000J\r\u0010\u0017\u001a\u00028\u0002H\u0014\u00a2\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleLocalizedBuilder;", "S", "R", "T", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "name", "", "ctor", "Lkotlin/Function0;", "localizer", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/Localizer;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/Localizer;)V", "localized", "Lkotlin/Pair;", "lang", "noLang", "createObject", "()Ljava/lang/Object;", "createEntry", "key", "register", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSimpleLocalizedBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleLocalizedBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/SimpleLocalizedBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n1#2:44\n*E\n"})
public class SimpleLocalizedBuilder<S extends SimpleLocalizedBuilder<S, R, T>, R, T extends R>
extends AbstractBuilder<S, R, T, RegistryEntry<R, T>> {
    @NotNull
    private final Function0<T> ctor;
    @NotNull
    private final Pair<String, String> localized;
    @JvmField
    @Nullable
    public String lang;

    public SimpleLocalizedBuilder(@NotNull BrokenReg parent, @NotNull ResourceKey<Registry<R>> registry, @NotNull String name, @NotNull Function0<? extends T> ctor, @NotNull Localizer localizer) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter((Object)localizer, (String)"localizer");
        super(parent, registry, name);
        this.ctor = ctor;
        this.localized = localizer.localize(this.getId());
        this.lang = (String)this.localized.getSecond();
    }

    @NotNull
    public final SimpleLocalizedBuilder<S, R, T> noLang() {
        SimpleLocalizedBuilder simpleLocalizedBuilder;
        SimpleLocalizedBuilder $this$noLang_u24lambda_u240 = simpleLocalizedBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.lang = null;
        return simpleLocalizedBuilder;
    }

    @Override
    protected T createObject() {
        return (T)this.ctor.invoke();
    }

    @Override
    @NotNull
    public RegistryEntry<R, T> createEntry(@NotNull ResourceKey<R> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new RegistryEntry(key);
    }

    @Override
    @NotNull
    public RegistryEntry<R, T> register() {
        Object e;
        block0: {
            Object it = e = super.register();
            boolean bl = false;
            String string = this.lang;
            if (string == null) break block0;
            String it2 = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set((String)this.localized.getFirst(), it2);
        }
        return e;
    }
}


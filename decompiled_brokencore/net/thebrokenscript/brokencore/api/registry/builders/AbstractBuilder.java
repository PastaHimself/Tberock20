/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.BuiltObject;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000* \b\u0000\u0010\u0001*\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0000*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0003*\u0002H\u0002*\u0014\b\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006B+\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u001b\u001a\u00028\u0002H$\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0003H\u0014\u00a2\u0006\u0002\u0010)J\u001b\u0010/\u001a\u00028\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\nH&\u00a2\u0006\u0002\u00100J\r\u00101\u001a\u00028\u0003H\u0016\u00a2\u0006\u0002\u00102J&\u00103\u001a\u00028\u00032\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'05\u00a2\u0006\u0002\b6H\u0016\u00a2\u0006\u0002\u00107J\u0019\u00103\u001a\u00028\u00032\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000008\u00a2\u0006\u0002\u00109R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\u00020\rX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00028\u00008TX\u0094\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R!\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\n8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b$\u0010\u0013R-\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030+8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b,\u0010-\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "S", "R", "T", "E", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "getRegistry", "()Lnet/minecraft/resources/ResourceKey;", "getName", "()Ljava/lang/String;", "self", "getSelf$annotations", "()V", "getSelf", "()Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "createObject", "()Ljava/lang/Object;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "id$delegate", "Lkotlin/Lazy;", "key", "getKey", "key$delegate", "onRegistered", "", "entry", "(Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;)V", "builtObject", "Lnet/thebrokenscript/brokencore/api/registry/objects/BuiltObject;", "getBuiltObject", "()Lnet/thebrokenscript/brokencore/api/registry/objects/BuiltObject;", "builtObject$delegate", "createEntry", "(Lnet/minecraft/resources/ResourceKey;)Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "register", "()Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "configure", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "(Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;)Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAbstractBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n1#2:90\n*E\n"})
public abstract class AbstractBuilder<S extends AbstractBuilder<S, R, T, E>, R, T extends R, E extends RegistryEntry<R, T>> {
    @NotNull
    private final BrokenReg parent;
    @NotNull
    private final ResourceKey<Registry<R>> registry;
    @NotNull
    private final String name;
    @NotNull
    private final Lazy id$delegate;
    @NotNull
    private final Lazy key$delegate;
    @NotNull
    private final Lazy builtObject$delegate;

    public AbstractBuilder(@NotNull BrokenReg parent, @NotNull ResourceKey<Registry<R>> registry, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.parent = parent;
        this.registry = registry;
        this.name = name;
        this.id$delegate = LazyKt.lazy(() -> AbstractBuilder.id_delegate$lambda$0(this));
        this.key$delegate = LazyKt.lazy(() -> AbstractBuilder.key_delegate$lambda$0(this));
        this.builtObject$delegate = LazyKt.lazy(() -> AbstractBuilder.builtObject_delegate$lambda$0(this));
    }

    @NotNull
    public final BrokenReg getParent() {
        return this.parent;
    }

    @NotNull
    protected final ResourceKey<Registry<R>> getRegistry() {
        return this.registry;
    }

    @NotNull
    protected final String getName() {
        return this.name;
    }

    @NotNull
    protected S getSelf() {
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type S of net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder");
        return (S)this;
    }

    protected static /* synthetic */ void getSelf$annotations() {
    }

    protected abstract T createObject();

    @NotNull
    public ResourceLocation getId() {
        Lazy lazy = this.id$delegate;
        return (ResourceLocation)lazy.getValue();
    }

    @NotNull
    public ResourceKey<R> getKey() {
        Lazy lazy = this.key$delegate;
        Object object = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (ResourceKey)object;
    }

    protected void onRegistered(@NotNull E entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
    }

    @NotNull
    protected BuiltObject<R, T, E> getBuiltObject() {
        Lazy lazy = this.builtObject$delegate;
        return (BuiltObject)lazy.getValue();
    }

    @NotNull
    public abstract E createEntry(@NotNull ResourceKey<R> var1);

    @NotNull
    public E register() {
        return this.createEntry(this.parent.accept(this.getBuiltObject()));
    }

    @NotNull
    public E configure(@NotNull Function1<? super S, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        block2.invoke(this.getSelf());
        Unit $this$configure_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return this.register();
    }

    @NotNull
    public final E configure(@NotNull InstanceConsumer<S> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.configure(arg_0 -> AbstractBuilder.configure$lambda$1(block2, arg_0));
    }

    private static final ResourceLocation id_delegate$lambda$0(AbstractBuilder this$0) {
        return this$0.parent.id(this$0.name);
    }

    private static final ResourceKey key_delegate$lambda$0(AbstractBuilder this$0) {
        return ResourceKey.create(this$0.registry, (ResourceLocation)this$0.getId());
    }

    private static final BuiltObject builtObject_delegate$lambda$0(AbstractBuilder this$0) {
        return new BuiltObject(this$0.registry, this$0.getId(), (Function0)new Function0<T>(this$0){

            public final T invoke() {
                return ((AbstractBuilder)this.receiver).createObject();
            }
        }, (Function1)new Function1<E, Unit>(this$0){

            public final void invoke(E p0) {
                Intrinsics.checkNotNullParameter(p0, (String)"p0");
                ((AbstractBuilder)this.receiver).onRegistered(p0);
            }
        }, (Function1)new Function1<ResourceKey<R>, E>(this$0){

            public final E invoke(ResourceKey<R> p0) {
                Intrinsics.checkNotNullParameter(p0, (String)"p0");
                return ((AbstractBuilder)this.receiver).createEntry(p0);
            }
        });
    }

    private static final Unit configure$lambda$1(InstanceConsumer $block, AbstractBuilder $this$configure) {
        Intrinsics.checkNotNullParameter((Object)$this$configure, (String)"$this$configure");
        MiscExt.gluedApply($this$configure, $block);
        return Unit.INSTANCE;
    }
}


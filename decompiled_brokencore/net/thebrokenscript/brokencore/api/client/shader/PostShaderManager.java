/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.PostChain
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.PreparableReloadListener
 *  net.minecraft.server.packs.resources.PreparableReloadListener$PreparationBarrier
 *  net.minecraft.server.packs.resources.ResourceManager
 *  net.minecraft.server.packs.resources.ResourceProvider
 *  net.minecraft.util.profiling.ProfilerFiller
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.shader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.profiling.ProfilerFiller;
import net.thebrokenscript.brokencore.api.client.shader.ShaderStage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0096\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager;", "", "Lnet/minecraft/client/renderer/PostChain;", "<init>", "()V", "postShaders", "", "Lnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShader;", "register", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "enabled", "", "stage", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderStage;", "forStage", "iterator", "", "get", "setEnabled", "invalidateAll", "PostShader", "PostShaderReloadListener", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nPostShaderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostShaderManager.kt\nnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n295#2,2:92\n295#2,2:94\n*S KotlinDebug\n*F\n+ 1 PostShaderManager.kt\nnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager\n*L\n30#1:92,2\n33#1:94,2\n*E\n"})
public final class PostShaderManager
implements Iterable<PostChain>,
KMappedMarker {
    @NotNull
    public static final PostShaderManager INSTANCE = new PostShaderManager();
    @NotNull
    private static final Set<PostShader> postShaders = new LinkedHashSet();

    private PostShaderManager() {
    }

    public final void register(@NotNull ResourceLocation id, boolean enabled, @NotNull ShaderStage stage) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)stage), (String)"stage");
        postShaders.add(new PostShader(id, enabled, stage));
    }

    public static /* synthetic */ void register$default(PostShaderManager postShaderManager, ResourceLocation resourceLocation, boolean bl, ShaderStage shaderStage, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        if ((n & 4) != 0) {
            shaderStage = ShaderStage.WORLD;
        }
        postShaderManager.register(resourceLocation, bl, shaderStage);
    }

    @NotNull
    public final Iterable<PostChain> forStage(@NotNull ShaderStage stage) {
        Intrinsics.checkNotNullParameter((Object)((Object)stage), (String)"stage");
        return SequencesKt.asIterable((Sequence)SequencesKt.map((Sequence)SequencesKt.filter((Sequence)CollectionsKt.asSequence((Iterable)postShaders), arg_0 -> PostShaderManager.forStage$lambda$0(stage, arg_0)), PostShaderManager::forStage$lambda$1));
    }

    @Override
    @NotNull
    public Iterator<PostChain> iterator() {
        return this.forStage(ShaderStage.WORLD).iterator();
    }

    @Nullable
    public final PostChain get(@NotNull ResourceLocation id) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Iterable $this$firstOrNull$iv = postShaders;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                PostShader it = (PostShader)element$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getId(), (Object)id)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        PostShader postShader = v0;
        return postShader != null ? postShader.getChain() : null;
    }

    public final void setEnabled(@NotNull ResourceLocation id, boolean enabled) {
        Object v0;
        block2: {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Iterable $this$firstOrNull$iv = postShaders;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                PostShader it = (PostShader)element$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getId(), (Object)id)) continue;
                v0 = element$iv;
                break block2;
            }
            v0 = null;
        }
        PostShader postShader = v0;
        if (postShader == null) {
            throw new IllegalStateException(("Shader with ID " + id + " not found").toString());
        }
        PostShader shader = postShader;
        shader.setEnabled(enabled);
    }

    public final void invalidateAll() {
        for (PostShader shader : postShaders) {
            shader.invalidate();
        }
    }

    private static final boolean forStage$lambda$0(ShaderStage $stage, PostShader it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getEnabled() && it.getStage() == $stage;
    }

    private static final PostChain forStage$lambda$1(PostShader it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getChain();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShader;", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "enabled", "", "stage", "Lnet/thebrokenscript/brokencore/api/client/shader/ShaderStage;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;ZLnet/thebrokenscript/brokencore/api/client/shader/ShaderStage;)V", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "getEnabled", "()Z", "setEnabled", "(Z)V", "getStage", "()Lnet/thebrokenscript/brokencore/api/client/shader/ShaderStage;", "cached", "Lnet/minecraft/client/renderer/PostChain;", "chain", "getChain", "()Lnet/minecraft/client/renderer/PostChain;", "invalidate", "", "create", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nPostShaderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostShaderManager.kt\nnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
    private static final class PostShader {
        @NotNull
        private final ResourceLocation id;
        private boolean enabled;
        @NotNull
        private final ShaderStage stage;
        @Nullable
        private PostChain cached;

        public PostShader(@NotNull ResourceLocation id, boolean enabled, @NotNull ShaderStage stage) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)((Object)stage), (String)"stage");
            this.id = id;
            this.enabled = enabled;
            this.stage = stage;
        }

        @NotNull
        public final ResourceLocation getId() {
            return this.id;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final void setEnabled(boolean bl) {
            this.enabled = bl;
        }

        @NotNull
        public final ShaderStage getStage() {
            return this.stage;
        }

        @NotNull
        public final PostChain getChain() {
            PostChain postChain = this.cached;
            if (postChain == null) {
                PostChain postChain2;
                PostChain it = postChain2 = this.create();
                boolean bl = false;
                this.cached = it;
                postChain = postChain2;
            }
            return postChain;
        }

        public final void invalidate() {
            PostChain postChain = this.cached;
            if (postChain != null) {
                postChain.close();
            }
            this.cached = null;
        }

        private final PostChain create() {
            Minecraft mc = Minecraft.getInstance();
            PostChain chain = new PostChain(mc.getTextureManager(), (ResourceProvider)mc.getResourceManager(), mc.getMainRenderTarget(), this.id);
            chain.resize(mc.getWindow().getWidth(), mc.getWindow().getHeight());
            return chain;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J>\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShaderReloadListener;", "Lnet/minecraft/server/packs/resources/PreparableReloadListener;", "<init>", "()V", "subs", "", "Lkotlin/Function0;", "", "subscribe", "func", "reload", "Ljava/util/concurrent/CompletableFuture;", "Ljava/lang/Void;", "preparationBarrier", "Lnet/minecraft/server/packs/resources/PreparableReloadListener$PreparationBarrier;", "resourceManager", "Lnet/minecraft/server/packs/resources/ResourceManager;", "prepareProfiler", "Lnet/minecraft/util/profiling/ProfilerFiller;", "applyProfiler", "backgroundExecutor", "Ljava/util/concurrent/Executor;", "gameExecutor", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nPostShaderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostShaderManager.kt\nnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShaderReloadListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1869#2,2:92\n*S KotlinDebug\n*F\n+ 1 PostShaderManager.kt\nnet/thebrokenscript/brokencore/api/client/shader/PostShaderManager$PostShaderReloadListener\n*L\n85#1:92,2\n*E\n"})
    public static final class PostShaderReloadListener
    implements PreparableReloadListener {
        @NotNull
        public static final PostShaderReloadListener INSTANCE = new PostShaderReloadListener();
        @NotNull
        private static final List<Function0<Unit>> subs = new ArrayList();

        private PostShaderReloadListener() {
        }

        public final void subscribe(@NotNull Function0<Unit> func) {
            Intrinsics.checkNotNullParameter(func, (String)"func");
            subs.add(func);
        }

        @NotNull
        public CompletableFuture<Void> reload(@NotNull PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller prepareProfiler, @NotNull ProfilerFiller applyProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
            Intrinsics.checkNotNullParameter((Object)preparationBarrier, (String)"preparationBarrier");
            Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
            Intrinsics.checkNotNullParameter((Object)prepareProfiler, (String)"prepareProfiler");
            Intrinsics.checkNotNullParameter((Object)applyProfiler, (String)"applyProfiler");
            Intrinsics.checkNotNullParameter((Object)backgroundExecutor, (String)"backgroundExecutor");
            Intrinsics.checkNotNullParameter((Object)gameExecutor, (String)"gameExecutor");
            CompletionStage completionStage = ((CompletableFuture)CompletableFuture.supplyAsync(PostShaderReloadListener::reload$lambda$0, backgroundExecutor).thenCompose(arg_0 -> PostShaderReloadListener.reload$lambda$1((Function1)new Function1<Unit, CompletableFuture<Unit>>((Object)preparationBarrier){

                public final CompletableFuture<Unit> invoke(Unit p0) {
                    return ((PreparableReloadListener.PreparationBarrier)this.receiver).wait((Object)p0);
                }
            }, arg_0))).thenAcceptAsync(arg_0 -> PostShaderReloadListener.reload$lambda$3(PostShaderReloadListener::reload$lambda$2, arg_0), gameExecutor);
            Intrinsics.checkNotNullExpressionValue((Object)completionStage, (String)"thenAcceptAsync(...)");
            return completionStage;
        }

        private static final Unit reload$lambda$0() {
            return Unit.INSTANCE;
        }

        private static final CompletionStage reload$lambda$1(Function1 $tmp0, Object p0) {
            return (CompletionStage)$tmp0.invoke(p0);
        }

        private static final Unit reload$lambda$2(Unit it) {
            INSTANCE.invalidateAll();
            Iterable $this$forEach$iv = subs;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Function0 it2 = (Function0)element$iv;
                boolean bl = false;
                it2.invoke();
            }
            return Unit.INSTANCE;
        }

        private static final void reload$lambda$3(Function1 $tmp0, Object p0) {
            $tmp0.invoke(p0);
        }
    }
}


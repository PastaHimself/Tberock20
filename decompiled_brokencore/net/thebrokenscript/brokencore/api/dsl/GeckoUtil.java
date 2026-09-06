/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.thebrokenscript.brokencore.api.dsl.GeckoAnimType;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0007\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u000f\u001a7\u0010\u0011\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u000f\u001a3\u0010\u0007\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0012\u001a3\u0010\u0010\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0012\u001a3\u0010\u0011\u001a\u00020\b\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\r2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0012\u001a7\u0010\u0007\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u0015\u001a7\u0010\u0010\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u0015\u001a7\u0010\u0011\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\u000e\u001a\u00020\u0005R\u0002H\tj\u0006\u0010\f\u001a\u0002H\t\u00a2\u0006\u0002\u0010\u0015\u001a3\u0010\u0007\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0016\u001a3\u0010\u0010\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0016\u001a3\u0010\u0011\u001a\u00020\u0013\"\f\b\u0000\u0010\t*\u00020\n*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0016\"0\u0010\u0000\u001a$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"cachedAnimations", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Triple;", "Lnet/thebrokenscript/brokencore/api/dsl/GeckoAnimType;", "Lnet/minecraft/world/entity/EntityType;", "", "Lsoftware/bernie/geckolib/animation/RawAnimation;", "hold", "", "T", "Lnet/minecraft/world/entity/Entity;", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "entity", "Lsoftware/bernie/geckolib/animation/AnimationController;", "name", "(Lnet/minecraft/world/entity/Entity;Lsoftware/bernie/geckolib/animation/AnimationController;Ljava/lang/String;)V", "loop", "once", "(Lsoftware/bernie/geckolib/animation/AnimationController;Lnet/minecraft/world/entity/Entity;Ljava/lang/String;)V", "Lsoftware/bernie/geckolib/animation/PlayState;", "Lsoftware/bernie/geckolib/animation/AnimationState;", "(Lnet/minecraft/world/entity/Entity;Lsoftware/bernie/geckolib/animation/AnimationState;Ljava/lang/String;)Lsoftware/bernie/geckolib/animation/PlayState;", "(Lsoftware/bernie/geckolib/animation/AnimationState;Lnet/minecraft/world/entity/Entity;Ljava/lang/String;)Lsoftware/bernie/geckolib/animation/PlayState;", "brokencore-common"})
@JvmName(name="GeckoUtil")
@SourceDebugExtension(value={"SMAP\nGeckoDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GeckoDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/GeckoUtil\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n72#2,2:86\n72#2,2:89\n72#2,2:92\n72#2,2:95\n72#2,2:98\n72#2,2:101\n1#3:88\n1#3:91\n1#3:94\n1#3:97\n1#3:100\n1#3:103\n*S KotlinDebug\n*F\n+ 1 GeckoDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/GeckoUtil\n*L\n22#1:86,2\n28#1:89,2\n34#1:92,2\n39#1:95,2\n44#1:98,2\n49#1:101,2\n22#1:88\n28#1:91\n34#1:94\n39#1:97\n44#1:100\n49#1:103\n*E\n"})
public final class GeckoUtil {
    @NotNull
    private static final ConcurrentHashMap<Triple<GeckoAnimType, EntityType<?>, String>, RawAnimation> cachedAnimations = new ConcurrentHashMap();

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void hold(@NotNull T entity, @NotNull AnimationController<T> $this$hold, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$hold, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$hold;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.PLAY_HOLD, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenPlayAndHold(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void loop(@NotNull T entity, @NotNull AnimationController<T> $this$loop, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$loop, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$loop;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.LOOP, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenLoop(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void once(@NotNull T entity, @NotNull AnimationController<T> $this$once, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$once, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$once;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.PLAY_ONCE, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenPlay(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void hold(@NotNull AnimationController<T> $this$hold, @NotNull T entity, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter($this$hold, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$hold;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.PLAY_HOLD, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenPlayAndHold(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void loop(@NotNull AnimationController<T> $this$loop, @NotNull T entity, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter($this$loop, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$loop;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.LOOP, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenLoop(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    /*
     * WARNING - void declaration
     */
    public static final <T extends Entity> void once(@NotNull AnimationController<T> $this$once, @NotNull T entity, @NotNull String name) {
        void $this$getOrPut$iv;
        Intrinsics.checkNotNullParameter($this$once, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController<T> animationController = $this$once;
        ConcurrentMap concurrentMap = cachedAnimations;
        Triple key$iv = new Triple((Object)GeckoAnimType.PLAY_ONCE, (Object)entity.getType(), (Object)name);
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key$iv);
        if (object == null) {
            AnimationController<T> animationController2 = animationController;
            boolean bl = false;
            animationController = animationController2;
            RawAnimation default$iv = RawAnimation.begin().thenPlay(name);
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key$iv, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        animationController.setAnimation((RawAnimation)object);
    }

    @NotNull
    public static final <T extends Entity> PlayState hold(@NotNull T entity, @NotNull AnimationState<T> $this$hold, @NotNull String name) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$hold, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$hold.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.hold(entity, animationController, name);
        return PlayState.CONTINUE;
    }

    @NotNull
    public static final <T extends Entity> PlayState loop(@NotNull T entity, @NotNull AnimationState<T> $this$loop, @NotNull String name) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$loop, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$loop.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.loop(entity, animationController, name);
        return PlayState.CONTINUE;
    }

    @NotNull
    public static final <T extends Entity> PlayState once(@NotNull T entity, @NotNull AnimationState<T> $this$once, @NotNull String name) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter($this$once, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$once.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.once(entity, animationController, name);
        return PlayState.CONTINUE;
    }

    @NotNull
    public static final <T extends Entity> PlayState hold(@NotNull AnimationState<T> $this$hold, @NotNull T entity, @NotNull String name) {
        Intrinsics.checkNotNullParameter($this$hold, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$hold.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.hold(animationController, entity, name);
        return PlayState.CONTINUE;
    }

    @NotNull
    public static final <T extends Entity> PlayState loop(@NotNull AnimationState<T> $this$loop, @NotNull T entity, @NotNull String name) {
        Intrinsics.checkNotNullParameter($this$loop, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$loop.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.loop(animationController, entity, name);
        return PlayState.CONTINUE;
    }

    @NotNull
    public static final <T extends Entity> PlayState once(@NotNull AnimationState<T> $this$once, @NotNull T entity, @NotNull String name) {
        Intrinsics.checkNotNullParameter($this$once, (String)"<this>");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AnimationController animationController = $this$once.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.once(animationController, entity, name);
        return PlayState.CONTINUE;
    }
}


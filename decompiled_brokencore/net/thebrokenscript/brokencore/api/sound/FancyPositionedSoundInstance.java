/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.audio.Channel
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.SafeContinuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Intrinsics$Kotlin
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.sounds.ChannelAccess$ChannelHandle
 *  net.minecraft.client.sounds.SoundManager
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.AL11
 */
package net.thebrokenscript.brokencore.api.sound;

import com.mojang.blaze3d.audio.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancyAudioMarker;
import net.thebrokenscript.brokencore.api.sound.SoundAccessorsKt;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010)\u001a\u0004\u0018\u00010*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020*0,H\u0002\u00a2\u0006\u0002\u0010-J\u001c\u0010.\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020*0,H\u0002J\u001e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\b\u0010B\u001a\u00020\rH\u0016J\r\u0010C\u001a\u00020*H\u0000\u00a2\u0006\u0002\bDJ\u0006\u0010E\u001a\u00020*J\b\u0010F\u001a\u00020*H\u0016J\r\u0010O\u001a\u00020*H\u0000\u00a2\u0006\u0002\bPJ\u0012\u0010Q\u001a\u00020*2\n\u0010R\u001a\u0006\u0012\u0002\b\u00030SJ\u000e\u0010T\u001a\u00020*2\u0006\u0010R\u001a\u00020UR$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b8G@FX\u0086\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b8G@FX\u0086\u000e\u00a2\u0006\u0012\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010$\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u0011\u0010'\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001dR\u001a\u00103\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR,\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020*0,07X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010=\u001a\b\u0018\u00010>R\u00020?8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010G\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR&\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00130JX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00a8\u0006V"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;", "Lnet/minecraft/client/resources/sounds/AbstractTickableSoundInstance;", "Lnet/thebrokenscript/brokencore/api/sound/FancyAudioMarker;", "soundEvent", "Lnet/minecraft/sounds/SoundEvent;", "source", "Lnet/minecraft/sounds/SoundSource;", "volume", "", "pitch", "pos", "Lnet/minecraft/world/phys/Vec3;", "looping", "", "random", "Lnet/minecraft/util/RandomSource;", "<init>", "(Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFLnet/minecraft/world/phys/Vec3;ZLnet/minecraft/util/RandomSource;)V", "positionSupplier", "Lkotlin/Function0;", "getPositionSupplier", "()Lkotlin/jvm/functions/Function0;", "setPositionSupplier", "(Lkotlin/jvm/functions/Function0;)V", "value", "soundVolume", "getSoundVolume$annotations", "()V", "getSoundVolume", "()F", "setSoundVolume", "(F)V", "soundPitch", "getSoundPitch$annotations", "getSoundPitch", "setSoundPitch", "time", "getTime", "setTime", "duration", "getDuration", "getTimeAsync", "", "cb", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "getDurationAsync", "setAttenuation", "referenceDistance", "maxDistance", "rolloff", "gain", "getGain", "setGain", "onEnded", "", "getOnEnded", "()Ljava/util/List;", "setOnEnded", "(Ljava/util/List;)V", "didFinish", "channel", "Lnet/minecraft/client/sounds/ChannelAccess$ChannelHandle;", "Lnet/minecraft/client/sounds/ChannelAccess;", "getChannel", "()Lnet/minecraft/client/sounds/ChannelAccess$ChannelHandle;", "isStopped", "stopHandler", "stopHandler$brokencore_common", "stopSFX", "tick", "isActive", "()Z", "setupQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getSetupQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "setSetupQueue", "(Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "channelReady", "channelReady$brokencore_common", "addEffect", "effect", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "removeEffect", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nFancyPositionedSoundInstance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FancyPositionedSoundInstance.kt\nnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,209:1\n1869#2,2:210\n1869#2,2:212\n*S KotlinDebug\n*F\n+ 1 FancyPositionedSoundInstance.kt\nnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance\n*L\n131#1:210,2\n171#1:212,2\n*E\n"})
public class FancyPositionedSoundInstance
extends AbstractTickableSoundInstance
implements FancyAudioMarker {
    @Nullable
    private Function0<? extends Vec3> positionSupplier;
    private float gain;
    @NotNull
    private List<Function1<FancyPositionedSoundInstance, Unit>> onEnded;
    private boolean didFinish;
    @NotNull
    private ConcurrentLinkedQueue<Function0<Unit>> setupQueue;

    public FancyPositionedSoundInstance(@NotNull SoundEvent soundEvent, @NotNull SoundSource source, float volume, float pitch, @NotNull Vec3 pos, boolean looping, @NotNull RandomSource random) {
        Intrinsics.checkNotNullParameter((Object)soundEvent, (String)"soundEvent");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        super(soundEvent, source, random);
        this.looping = looping;
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        this.volume = volume;
        this.pitch = pitch;
        this.gain = 1.0f;
        this.onEnded = new ArrayList();
        this.setupQueue = new ConcurrentLinkedQueue();
    }

    @Nullable
    public final Function0<Vec3> getPositionSupplier() {
        return this.positionSupplier;
    }

    public final void setPositionSupplier(@Nullable Function0<? extends Vec3> function0) {
        this.positionSupplier = function0;
    }

    @JvmName(name="getSoundVolume")
    public final float getSoundVolume() {
        return this.volume;
    }

    public final void setSoundVolume(float value) {
        this.volume = value;
    }

    public static /* synthetic */ void getSoundVolume$annotations() {
    }

    @JvmName(name="getSoundPitch")
    public final float getSoundPitch() {
        return this.pitch;
    }

    public final void setSoundPitch(float value) {
        this.pitch = value;
    }

    public static /* synthetic */ void getSoundPitch$annotations() {
    }

    public final float getTime() {
        return ((Number)BuildersKt.runBlocking$default(null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Float>, Object>(this, null){
            Object L$0;
            int label;
            final /* synthetic */ FancyPositionedSoundInstance this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FancyPositionedSoundInstance fancyPositionedSoundInstance = this.this$0;
                        this.L$0 = fancyPositionedSoundInstance;
                        this.label = 1;
                        Continuation continuation = (Continuation)this;
                        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation)continuation));
                        Continuation it = (Continuation)safeContinuation;
                        boolean bl = false;
                        FancyPositionedSoundInstance.access$getTimeAsync(fancyPositionedSoundInstance, (Function1)new Function1<Float, Unit>((Object)it){

                            public final void invoke(float p0) {
                                ((Continuation)this.receiver).resumeWith(Result.constructor-impl((Object)Float.valueOf(p0)));
                            }
                        });
                        Object object3 = safeContinuation.getOrThrow();
                        if (object3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)this));
                        }
                        Object object4 = object3;
                        if (object3 != object2) return object4;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        FancyPositionedSoundInstance cfr_ignored_0 = (FancyPositionedSoundInstance)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object4 = $result;
                        return object4;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Float> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)1, null)).floatValue();
    }

    public final void setTime(float value) {
        Unit unit;
        ChannelAccess.ChannelHandle channelHandle = this.getChannel();
        if (channelHandle != null) {
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance._set_time_$lambda$0(value, arg_0));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        MiscExt.void(unit);
    }

    public final float getDuration() {
        return ((Number)BuildersKt.runBlocking$default(null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Float>, Object>(this, null){
            Object L$0;
            int label;
            final /* synthetic */ FancyPositionedSoundInstance this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FancyPositionedSoundInstance fancyPositionedSoundInstance = this.this$0;
                        this.L$0 = fancyPositionedSoundInstance;
                        this.label = 1;
                        Continuation continuation = (Continuation)this;
                        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted((Continuation)continuation));
                        Continuation it = (Continuation)safeContinuation;
                        boolean bl = false;
                        FancyPositionedSoundInstance.access$getDurationAsync(fancyPositionedSoundInstance, (Function1)new Function1<Float, Unit>((Object)it){

                            public final void invoke(float p0) {
                                ((Continuation)this.receiver).resumeWith(Result.constructor-impl((Object)Float.valueOf(p0)));
                            }
                        });
                        Object object3 = safeContinuation.getOrThrow();
                        if (object3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)this));
                        }
                        Object object4 = object3;
                        if (object3 != object2) return object4;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        FancyPositionedSoundInstance cfr_ignored_0 = (FancyPositionedSoundInstance)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object4 = $result;
                        return object4;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Float> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)1, null)).floatValue();
    }

    private final Unit getTimeAsync(Function1<? super Float, Unit> cb) {
        Unit unit;
        ChannelAccess.ChannelHandle channelHandle = this.getChannel();
        if (channelHandle != null) {
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.getTimeAsync$lambda$0(cb, arg_0));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    private final void getDurationAsync(Function1<? super Float, Unit> cb) {
        block0: {
            ChannelAccess.ChannelHandle channelHandle = this.getChannel();
            if (channelHandle == null) break block0;
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.getDurationAsync$lambda$0(cb, arg_0));
        }
    }

    public final void setAttenuation(float referenceDistance, float maxDistance, float rolloff) {
        if (this.getChannel() != null) {
            FancyPositionedSoundInstance.setAttenuation$apply(this, referenceDistance, maxDistance, rolloff);
        } else {
            this.setupQueue.add(new Function0<Unit>(this, referenceDistance, maxDistance, rolloff){
                final /* synthetic */ FancyPositionedSoundInstance this$0;
                final /* synthetic */ float $referenceDistance;
                final /* synthetic */ float $maxDistance;
                final /* synthetic */ float $rolloff;
                {
                    this.this$0 = $receiver;
                    this.$referenceDistance = $referenceDistance;
                    this.$maxDistance = $maxDistance;
                    this.$rolloff = $rolloff;
                    super(0, Intrinsics.Kotlin.class, "apply", "setAttenuation$apply(Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;FFF)V", 0);
                }

                public final void invoke() {
                    FancyPositionedSoundInstance.access$setAttenuation$apply(this.this$0, this.$referenceDistance, this.$maxDistance, this.$rolloff);
                }
            });
        }
    }

    public final float getGain() {
        return this.gain;
    }

    public final void setGain(float f) {
        this.gain = f;
    }

    @NotNull
    public final List<Function1<FancyPositionedSoundInstance, Unit>> getOnEnded() {
        return this.onEnded;
    }

    public final void setOnEnded(@NotNull List<Function1<FancyPositionedSoundInstance, Unit>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.onEnded = list;
    }

    @Nullable
    protected final ChannelAccess.ChannelHandle getChannel() {
        SoundManager soundManager = ClientDSLKt.getMC().getSoundManager();
        Intrinsics.checkNotNullExpressionValue((Object)soundManager, (String)"getSoundManager(...)");
        return SoundAccessorsKt.getInstanceToChannel(SoundAccessorsKt.getEngine(soundManager)).get(this);
    }

    public boolean isStopped() {
        ChannelAccess.ChannelHandle channelHandle = this.getChannel();
        if (channelHandle == null) {
            return false;
        }
        ChannelAccess.ChannelHandle ch = channelHandle;
        return ch.isStopped() && !this.looping;
    }

    public final void stopHandler$brokencore_common() {
        if (this.didFinish) {
            return;
        }
        this.didFinish = true;
        ChannelAccess.ChannelHandle channelHandle = this.getChannel();
        if (!(channelHandle != null ? channelHandle.isStopped() : false)) {
            ChannelAccess.ChannelHandle channelHandle2 = this.getChannel();
            if (channelHandle2 != null) {
                channelHandle2.execute(FancyPositionedSoundInstance::stopHandler$lambda$0);
            }
        }
        ClientDSLKt.getMC().getSoundManager().stop((SoundInstance)this);
        Iterable $this$forEach$iv = this.onEnded;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl = false;
            it.invoke((Object)this);
        }
    }

    public final void stopSFX() {
        FancyAudio.INSTANCE.stop(this);
    }

    public void tick() {
        block0: {
            ChannelAccess.ChannelHandle channelHandle = this.getChannel();
            if (channelHandle == null) break block0;
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.tick$lambda$0(this, arg_0));
        }
    }

    public final boolean isActive() {
        return this.getChannel() != null;
    }

    @NotNull
    protected final ConcurrentLinkedQueue<Function0<Unit>> getSetupQueue() {
        return this.setupQueue;
    }

    protected final void setSetupQueue(@NotNull ConcurrentLinkedQueue<Function0<Unit>> concurrentLinkedQueue) {
        Intrinsics.checkNotNullParameter(concurrentLinkedQueue, (String)"<set-?>");
        this.setupQueue = concurrentLinkedQueue;
    }

    public final void channelReady$brokencore_common() {
        Function0<Unit> el = this.setupQueue.poll();
        while (el != null) {
            el.invoke();
            el = this.setupQueue.poll();
        }
    }

    public final void addEffect(@NotNull AudioEffect<?> effect) {
        Intrinsics.checkNotNullParameter(effect, (String)"effect");
        ChannelAccess.ChannelHandle ch = this.getChannel();
        if (ch != null) {
            ch.execute(arg_0 -> FancyPositionedSoundInstance.addEffect$lambda$0(effect, arg_0));
        } else {
            this.setupQueue.add((Function0<Unit>)((Function0)() -> FancyPositionedSoundInstance.addEffect$lambda$1(this, effect)));
        }
    }

    public final void removeEffect(@NotNull ResourceLocation effect) {
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        ChannelAccess.ChannelHandle ch = this.getChannel();
        if (ch != null) {
            ch.execute(arg_0 -> FancyPositionedSoundInstance.removeEffect$lambda$0(effect, arg_0));
        } else {
            this.setupQueue.add((Function0<Unit>)((Function0)() -> FancyPositionedSoundInstance.removeEffect$lambda$1(this, effect)));
        }
    }

    private static final void _set_time_$lambda$0(float $value, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        AL11.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4132, (float)$value);
    }

    private static final void getTimeAsync$lambda$0(Function1 $cb, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        $cb.invoke((Object)Float.valueOf(AL11.alGetSourcef((int)SoundAccessorsKt.getSource(it), (int)4132)));
    }

    private static final void getDurationAsync$lambda$0(Function1 $cb, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        int buf = AL11.alGetSourcei((int)SoundAccessorsKt.getSource(it), (int)4105);
        float size = AL11.alGetBufferi((int)buf, (int)8196);
        float freq = AL11.alGetBufferi((int)buf, (int)8193);
        float chan = AL11.alGetBufferi((int)buf, (int)8195);
        float bits = AL11.alGetBufferi((int)buf, (int)8194);
        $cb.invoke((Object)Float.valueOf(size / (freq * chan * (bits / 8.0f))));
    }

    private static final void setAttenuation$apply(FancyPositionedSoundInstance this$0, float $referenceDistance, float $maxDistance, float $rolloff) {
        block0: {
            ChannelAccess.ChannelHandle channelHandle = this$0.getChannel();
            if (channelHandle == null) break block0;
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.setAttenuation$apply$lambda$0($referenceDistance, $maxDistance, $rolloff, arg_0));
        }
    }

    private static final void setAttenuation$apply$lambda$0(float $referenceDistance, float $maxDistance, float $rolloff, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        AL10.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4128, (float)$referenceDistance);
        AL10.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4131, (float)$maxDistance);
        AL10.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4129, (float)$rolloff);
    }

    private static final void stopHandler$lambda$0(Channel it) {
        it.stop();
    }

    private static final void tick$lambda$0(FancyPositionedSoundInstance this$0, Channel it) {
        Vec3 newPos;
        Function0<? extends Vec3> function0 = this$0.positionSupplier;
        Object object = newPos = function0 != null ? (Vec3)function0.invoke() : null;
        if (this$0.positionSupplier != null && newPos == null) {
            this$0.stopSFX();
            return;
        }
        if (newPos != null) {
            this$0.x = newPos.x;
            this$0.y = newPos.y;
            this$0.z = newPos.z;
        }
        it.setSelfPosition(new Vec3(this$0.x, this$0.y, this$0.z));
        Intrinsics.checkNotNull((Object)it);
        AL10.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4106, (float)this$0.gain);
        AL10.alSourcef((int)SoundAccessorsKt.getSource(it), (int)4110, (float)this$0.gain);
        float sourceVolume = this$0.source != SoundSource.MASTER ? ClientDSLKt.getMC().options.getSoundSourceVolume(this$0.source) : 1.0f;
        it.setVolume(this$0.getSoundVolume() * sourceVolume);
        it.setPitch(this$0.getSoundPitch());
        it.updateStream();
        if (it.stopped() && !this$0.didFinish) {
            this$0.stopHandler$brokencore_common();
            if (this$0.looping) {
                it.play();
            } else {
                Iterable $this$forEach$iv = this$0.onEnded;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Function1 cb = (Function1)element$iv;
                    boolean bl = false;
                    cb.invoke((Object)this$0);
                }
            }
        }
    }

    private static final void addEffect$lambda$0(AudioEffect $effect, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        SoundAccessorsKt.addEffect(it, $effect);
    }

    private static final Unit addEffect$lambda$1(FancyPositionedSoundInstance this$0, AudioEffect $effect) {
        block0: {
            ChannelAccess.ChannelHandle channelHandle = this$0.getChannel();
            if (channelHandle == null) break block0;
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.addEffect$lambda$1$0($effect, arg_0));
        }
        return Unit.INSTANCE;
    }

    private static final void addEffect$lambda$1$0(AudioEffect $effect, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        SoundAccessorsKt.addEffect(it, $effect);
    }

    private static final void removeEffect$lambda$0(ResourceLocation $effect, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        SoundAccessorsKt.removeEffect(it, $effect);
    }

    private static final Unit removeEffect$lambda$1(FancyPositionedSoundInstance this$0, ResourceLocation $effect) {
        block0: {
            ChannelAccess.ChannelHandle channelHandle = this$0.getChannel();
            if (channelHandle == null) break block0;
            channelHandle.execute(arg_0 -> FancyPositionedSoundInstance.removeEffect$lambda$1$0($effect, arg_0));
        }
        return Unit.INSTANCE;
    }

    private static final void removeEffect$lambda$1$0(ResourceLocation $effect, Channel it) {
        Intrinsics.checkNotNull((Object)it);
        SoundAccessorsKt.removeEffect(it, $effect);
    }

    public static final /* synthetic */ Unit access$getTimeAsync(FancyPositionedSoundInstance $this, Function1 cb) {
        return $this.getTimeAsync((Function1<? super Float, Unit>)cb);
    }

    public static final /* synthetic */ void access$getDurationAsync(FancyPositionedSoundInstance $this, Function1 cb) {
        $this.getDurationAsync((Function1<? super Float, Unit>)cb);
    }

    public static final /* synthetic */ void access$setAttenuation$apply(FancyPositionedSoundInstance this$0, float $referenceDistance, float $maxDistance, float $rolloff) {
        FancyPositionedSoundInstance.setAttenuation$apply(this$0, $referenceDistance, $maxDistance, $rolloff);
    }
}


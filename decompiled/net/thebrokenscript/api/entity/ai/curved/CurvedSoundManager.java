/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.entity.ai.curved;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.entity.players.CurvedEntity;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedSoundManager;", "", "<init>", "()V", "playingSounds", "", "", "Lnet/thebrokenscript/api/entity/ai/curved/CurvedSoundManager$TrackedSound;", "tick", "", "reverbFor", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "inCave", "", "TrackedSound", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCurvedSoundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurvedSoundManager.kt\nnet/thebrokenscript/api/entity/ai/curved/CurvedSoundManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n808#2,11:70\n1869#2:81\n1870#2:83\n774#2:84\n865#2:85\n2746#2,3:86\n866#2:89\n1869#2,2:90\n1#3:82\n*S KotlinDebug\n*F\n+ 1 CurvedSoundManager.kt\nnet/thebrokenscript/api/entity/ai/curved/CurvedSoundManager\n*L\n29#1:70,11\n30#1:81\n30#1:83\n62#1:84\n62#1:85\n62#1:86,3\n62#1:89\n63#1:90,2\n*E\n"})
public final class CurvedSoundManager {
    @NotNull
    public static final CurvedSoundManager INSTANCE = new CurvedSoundManager();
    @NotNull
    private static final Map<Integer, TrackedSound> playingSounds = new LinkedHashMap();

    private CurvedSoundManager() {
    }

    /*
     * WARNING - void declaration
     */
    public final void tick() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Iterable $this$forEach$iv;
        Iterator $this$filterIsInstanceTo$iv$iv;
        Iterable $this$filterIsInstance$iv;
        Minecraft mc = Minecraft.getInstance();
        ClientLevel clientLevel = mc.level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        Iterable renderingEntities = level.entitiesForRendering();
        Intrinsics.checkNotNull((Object)renderingEntities);
        Iterable iterable = renderingEntities;
        boolean $i$f$filterIsInstance = false;
        Iterator iterator = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        Iterator iterator2 = $this$filterIsInstanceTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv$iv = iterator2.next();
            if (!(element$iv$iv instanceof CurvedEntity)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CurvedEntity entity = (CurvedEntity)((Object)element$iv);
            boolean bl = false;
            if (entity.isDead() || entity.isDeadOrDying()) {
                TrackedSound trackedSound = playingSounds.remove(entity.getId());
                if (trackedSound != null && (trackedSound = trackedSound.getSound()) != null) {
                    trackedSound.stopSFX();
                }
                continue;
            }
            if (entity.getTransformed()) {
                TrackedSound tracked = playingSounds.get(entity.getId());
                boolean nowInCave = BaseMonsterExtKt.isInCave((LivingEntity)((LivingEntity)entity));
                if (tracked == null || !tracked.getSound().isActive()) {
                    FancyEntitySoundInstance fancyEntitySoundInstance;
                    TrackedSound trackedSound = tracked;
                    if (trackedSound != null && (trackedSound = trackedSound.getSound()) != null) {
                        trackedSound.stopSFX();
                    }
                    AudioEffect<?> effect = INSTANCE.reverbFor(nowInCave);
                    FancyEntitySoundInstance $this$tick_u24lambda_u240_u240 = fancyEntitySoundInstance = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.CURVED_IDLE.invoke()), (SoundSource)SoundSource.HOSTILE, (float)4.0f, (float)1.0f, (boolean)true, null, (Entity)((Entity)entity), (int)32, null);
                    boolean bl2 = false;
                    $this$tick_u24lambda_u240_u240.addEffect(effect);
                    FancyEntitySoundInstance sound = fancyEntitySoundInstance;
                    playingSounds.put(entity.getId(), new TrackedSound(sound, nowInCave, effect.getId()));
                    continue;
                }
                if (tracked.getInCave() == nowInCave) continue;
                AudioEffect<?> newEffect = INSTANCE.reverbFor(nowInCave);
                tracked.getSound().removeEffect(tracked.getEffectId());
                tracked.getSound().addEffect(newEffect);
                tracked.setInCave(nowInCave);
                tracked.setEffectId(newEffect.getId());
                continue;
            }
            TrackedSound trackedSound = playingSounds.remove(entity.getId());
            if (trackedSound == null || (trackedSound = trackedSound.getSound()) == null) continue;
            trackedSound.stopSFX();
        }
        $this$forEach$iv = playingSounds.keySet();
        boolean $i$f$filter = false;
        $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl;
            block13: {
                int id = ((Number)element$iv$iv).intValue();
                boolean bl3 = false;
                Iterable $this$none$iv = renderingEntities;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        Entity it = (Entity)element$iv;
                        boolean bl4 = false;
                        if (!(it.getId() == id)) continue;
                        bl = false;
                        break block13;
                    }
                    bl = true;
                }
            }
            if (!bl) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            int id = ((Number)element$iv).intValue();
            boolean bl = false;
            TrackedSound trackedSound = playingSounds.remove(id);
            if (trackedSound == null || (trackedSound = trackedSound.getSound()) == null) continue;
            trackedSound.stopSFX();
        }
    }

    private final AudioEffect<?> reverbFor(boolean inCave) {
        return inCave ? (AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CAVE, null, (int)1, null) : (AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CITY, null, (int)1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/api/entity/ai/curved/CurvedSoundManager$TrackedSound;", "", "sound", "Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "inCave", "", "effectId", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;ZLnet/minecraft/resources/ResourceLocation;)V", "getSound", "()Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "getInCave", "()Z", "setInCave", "(Z)V", "getEffectId", "()Lnet/minecraft/resources/ResourceLocation;", "setEffectId", "(Lnet/minecraft/resources/ResourceLocation;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "thebrokenscript-common"})
    private static final class TrackedSound {
        @NotNull
        private final FancyEntitySoundInstance sound;
        private boolean inCave;
        @NotNull
        private ResourceLocation effectId;

        public TrackedSound(@NotNull FancyEntitySoundInstance sound, boolean inCave, @NotNull ResourceLocation effectId) {
            Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
            Intrinsics.checkNotNullParameter((Object)effectId, (String)"effectId");
            this.sound = sound;
            this.inCave = inCave;
            this.effectId = effectId;
        }

        @NotNull
        public final FancyEntitySoundInstance getSound() {
            return this.sound;
        }

        public final boolean getInCave() {
            return this.inCave;
        }

        public final void setInCave(boolean bl) {
            this.inCave = bl;
        }

        @NotNull
        public final ResourceLocation getEffectId() {
            return this.effectId;
        }

        public final void setEffectId(@NotNull ResourceLocation resourceLocation) {
            Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"<set-?>");
            this.effectId = resourceLocation;
        }

        @NotNull
        public final FancyEntitySoundInstance component1() {
            return this.sound;
        }

        public final boolean component2() {
            return this.inCave;
        }

        @NotNull
        public final ResourceLocation component3() {
            return this.effectId;
        }

        @NotNull
        public final TrackedSound copy(@NotNull FancyEntitySoundInstance sound, boolean inCave, @NotNull ResourceLocation effectId) {
            Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
            Intrinsics.checkNotNullParameter((Object)effectId, (String)"effectId");
            return new TrackedSound(sound, inCave, effectId);
        }

        public static /* synthetic */ TrackedSound copy$default(TrackedSound trackedSound, FancyEntitySoundInstance fancyEntitySoundInstance, boolean bl, ResourceLocation resourceLocation, int n, Object object) {
            if ((n & 1) != 0) {
                fancyEntitySoundInstance = trackedSound.sound;
            }
            if ((n & 2) != 0) {
                bl = trackedSound.inCave;
            }
            if ((n & 4) != 0) {
                resourceLocation = trackedSound.effectId;
            }
            return trackedSound.copy(fancyEntitySoundInstance, bl, resourceLocation);
        }

        @NotNull
        public String toString() {
            return "TrackedSound(sound=" + this.sound + ", inCave=" + this.inCave + ", effectId=" + this.effectId + ")";
        }

        public int hashCode() {
            int result = this.sound.hashCode();
            result = result * 31 + Boolean.hashCode(this.inCave);
            result = result * 31 + this.effectId.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackedSound)) {
                return false;
            }
            TrackedSound trackedSound = (TrackedSound)other;
            if (!Intrinsics.areEqual((Object)this.sound, (Object)trackedSound.sound)) {
                return false;
            }
            if (this.inCave != trackedSound.inCave) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.effectId, (Object)trackedSound.effectId);
        }
    }
}


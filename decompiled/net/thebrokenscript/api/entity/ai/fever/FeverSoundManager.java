/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.fever;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.entity.fever.FeverEntity;
import net.thebrokenscript.entity.fever.FeverStalkEntity;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/api/entity/ai/fever/FeverSoundManager;", "", "<init>", "()V", "playingSounds", "", "", "Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "tick", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFeverSoundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeverSoundManager.kt\nnet/thebrokenscript/api/entity/ai/fever/FeverSoundManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n808#2,11:66\n1869#2,2:77\n808#2,11:79\n1869#2,2:90\n774#2:92\n865#2:93\n2746#2,3:94\n866#2:97\n1869#2,2:98\n*S KotlinDebug\n*F\n+ 1 FeverSoundManager.kt\nnet/thebrokenscript/api/entity/ai/fever/FeverSoundManager\n*L\n22#1:66,11\n23#1:77,2\n41#1:79,11\n42#1:90,2\n62#1:92\n62#1:93\n62#1:94,3\n62#1:97\n63#1:98,2\n*E\n"})
public final class FeverSoundManager {
    @NotNull
    public static final FeverSoundManager INSTANCE = new FeverSoundManager();
    @NotNull
    private static final Map<Integer, FancyEntitySoundInstance> playingSounds = new LinkedHashMap();

    private FeverSoundManager() {
    }

    /*
     * WARNING - void declaration
     */
    public final void tick() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        FancyEntitySoundInstance sound;
        FancyEntitySoundInstance existing;
        Iterable $this$forEach$iv;
        Object element$iv$iv2;
        Iterator $this$filterIsInstanceTo$iv$iv;
        Iterable $this$filterIsInstance$iv;
        Minecraft mc = Minecraft.getInstance();
        ClientLevel clientLevel = mc.level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        Iterable renderingEntities = level.entitiesForRendering();
        LocalPlayer localPlayer = mc.player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer localPlayer2 = localPlayer;
        Intrinsics.checkNotNull((Object)renderingEntities);
        Iterable iterable = renderingEntities;
        boolean $i$f$filterIsInstance = false;
        Iterator iterator = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        Iterator iterator2 = $this$filterIsInstanceTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            element$iv$iv2 = iterator2.next();
            if (!(element$iv$iv2 instanceof FeverEntity)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            FeverEntity entity = (FeverEntity)((Object)element$iv);
            boolean bl = false;
            existing = playingSounds.get(entity.getId());
            if (existing != null && existing.isActive()) continue;
            FancyEntitySoundInstance fancyEntitySoundInstance = existing;
            if (fancyEntitySoundInstance != null) {
                fancyEntitySoundInstance.stopSFX();
            }
            sound = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.FEVER_WIND.invoke()), (SoundSource)SoundSource.HOSTILE, (float)4.0f, (float)1.0f, (boolean)true, null, (Entity)((Entity)entity), (int)32, null);
            playingSounds.put(entity.getId(), sound);
        }
        $this$forEach$iv = renderingEntities;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        Iterator bl = $this$filterIsInstanceTo$iv$iv.iterator();
        while (bl.hasNext()) {
            element$iv$iv2 = bl.next();
            if (!(element$iv$iv2 instanceof FeverStalkEntity)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            FeverStalkEntity entity = (FeverStalkEntity)((Object)element$iv);
            boolean bl2 = false;
            existing = playingSounds.get(entity.getId());
            if (existing != null && existing.isActive()) continue;
            FancyEntitySoundInstance fancyEntitySoundInstance = existing;
            if (fancyEntitySoundInstance != null) {
                fancyEntitySoundInstance.stopSFX();
            }
            if (!Intrinsics.areEqual(((Optional)entity.getEntityData().get(FeverStalkEntity.Companion.getTARGET_UUID())).orElse(null), (Object)localPlayer2.getUUID())) continue;
            sound = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.FEVER_WIND.invoke()), (SoundSource)SoundSource.HOSTILE, (float)4.0f, (float)1.0f, (boolean)true, null, (Entity)((Entity)entity), (int)32, null);
            playingSounds.put(entity.getId(), sound);
        }
        $this$forEach$iv = playingSounds.keySet();
        boolean $i$f$filter = false;
        $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
            boolean bl3;
            block13: {
                int id = ((Number)element$iv$iv2).intValue();
                boolean bl4 = false;
                Iterable $this$none$iv = renderingEntities;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl3 = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        Entity it = (Entity)element$iv;
                        boolean bl5 = false;
                        if (!(it.getId() == id)) continue;
                        bl3 = false;
                        break block13;
                    }
                    bl3 = true;
                }
            }
            if (!bl3) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            int id = ((Number)element$iv).intValue();
            boolean bl6 = false;
            FancyEntitySoundInstance fancyEntitySoundInstance = playingSounds.remove(id);
            if (fancyEntitySoundInstance == null) continue;
            fancyEntitySoundInstance.stopSFX();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.oblit2;

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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.entity.oblit.Obliteration2Entity;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/api/entity/ai/oblit2/Oblit2SoundManager;", "", "<init>", "()V", "playingSounds", "", "", "Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "tick", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nOblit2SoundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Oblit2SoundManager.kt\nnet/thebrokenscript/api/entity/ai/oblit2/Oblit2SoundManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n808#2,11:42\n1869#2,2:53\n774#2:55\n865#2:56\n2746#2,3:57\n866#2:60\n1869#2,2:61\n*S KotlinDebug\n*F\n+ 1 Oblit2SoundManager.kt\nnet/thebrokenscript/api/entity/ai/oblit2/Oblit2SoundManager\n*L\n19#1:42,11\n20#1:53,2\n38#1:55\n38#1:56\n38#1:57,3\n38#1:60\n39#1:61,2\n*E\n"})
public final class Oblit2SoundManager {
    @NotNull
    public static final Oblit2SoundManager INSTANCE = new Oblit2SoundManager();
    @NotNull
    private static final Map<Integer, FancyEntitySoundInstance> playingSounds = new LinkedHashMap();

    private Oblit2SoundManager() {
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
            if (!(element$iv$iv instanceof Obliteration2Entity)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Obliteration2Entity entity = (Obliteration2Entity)((Object)element$iv);
            boolean bl = false;
            FancyEntitySoundInstance existing = playingSounds.get(entity.getId());
            if (existing != null && existing.isActive()) continue;
            FancyEntitySoundInstance fancyEntitySoundInstance = existing;
            if (fancyEntitySoundInstance != null) {
                fancyEntitySoundInstance.stopSFX();
            }
            FancyEntitySoundInstance sound = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.OBLITERATION_SPEECH.invoke()), (SoundSource)SoundSource.HOSTILE, (float)35.0f, (float)1.0f, (boolean)true, null, (Entity)((Entity)entity), (int)32, null);
            playingSounds.put(entity.getId(), sound);
        }
        $this$forEach$iv = playingSounds.keySet();
        boolean $i$f$filter = false;
        $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            boolean bl;
            block9: {
                int id = ((Number)element$iv$iv).intValue();
                boolean bl2 = false;
                Iterable $this$none$iv = renderingEntities;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        Entity it = (Entity)element$iv;
                        boolean bl3 = false;
                        if (!(it.getId() == id)) continue;
                        bl = false;
                        break block9;
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
            FancyEntitySoundInstance fancyEntitySoundInstance = playingSounds.remove(id);
            if (fancyEntitySoundInstance == null) continue;
            fancyEntitySoundInstance.stopSFX();
        }
    }
}


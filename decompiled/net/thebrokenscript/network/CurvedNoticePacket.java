/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.entity.players.CurvedEntity;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/network/CurvedNoticePacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "noticeSounds", "", "Lnet/minecraft/sounds/SoundEvent;", "getNoticeSounds", "()Ljava/util/List;", "noticeSounds$delegate", "Lkotlin/Lazy;", "noticeSoundsIfHasTarget", "getNoticeSoundsIfHasTarget", "noticeSoundsIfHasTarget$delegate", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class CurvedNoticePacket
extends EndecPacket<CurvedNoticePacket, Integer> {
    @NotNull
    private final ResourceLocation id;
    @NotNull
    private final Lazy noticeSounds$delegate;
    @NotNull
    private final Lazy noticeSoundsIfHasTarget$delegate;

    public CurvedNoticePacket() {
        Endec endec2 = Endec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"INT");
        super(endec2);
        this.id = TBSConstants.id("curved_notice");
        this.noticeSounds$delegate = LazyKt.lazy(CurvedNoticePacket::noticeSounds_delegate$lambda$0);
        this.noticeSoundsIfHasTarget$delegate = LazyKt.lazy(CurvedNoticePacket::noticeSoundsIfHasTarget_delegate$lambda$0);
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public final List<SoundEvent> getNoticeSounds() {
        Lazy lazy = this.noticeSounds$delegate;
        return (List)lazy.getValue();
    }

    @NotNull
    public final List<SoundEvent> getNoticeSoundsIfHasTarget() {
        Lazy lazy = this.noticeSoundsIfHasTarget$delegate;
        return (List)lazy.getValue();
    }

    public void handle(int data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> CurvedNoticePacket.handle$lambda$0(data, cx, this));
    }

    private static final List noticeSounds_delegate$lambda$0() {
        Object[] objectArray = new SoundEvent[]{TBSSounds.CURVED_NOTICE1.invoke(), TBSSounds.CURVED_NOTICE2.invoke(), TBSSounds.CURVED_NOTICE3.invoke(), TBSSounds.CURVED_NOTICE4.invoke(), TBSSounds.CURVED_NOTICE5.invoke(), TBSSounds.CURVED_NOTICE6.invoke()};
        return CollectionsKt.listOf((Object[])objectArray);
    }

    private static final List noticeSoundsIfHasTarget_delegate$lambda$0() {
        Object[] objectArray = new SoundEvent[]{TBSSounds.CURVED_NOTICE3.invoke(), TBSSounds.CURVED_NOTICE4.invoke(), TBSSounds.CURVED_NOTICE5.invoke(), TBSSounds.CURVED_NOTICE6.invoke()};
        return CollectionsKt.listOf((Object[])objectArray);
    }

    private static final void handle$lambda$0(int $data, PacketHandlerContext $cx, CurvedNoticePacket this$0) {
        boolean hasTarget;
        int id = $data;
        Player player = $cx.getPlayer();
        Intrinsics.checkNotNull((Object)player);
        Level level = player.level();
        Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.client.multiplayer.ClientLevel");
        ClientLevel level2 = (ClientLevel)level;
        Entity entity = level2.getEntity(id);
        CurvedEntity curvedEntity = entity instanceof CurvedEntity ? (CurvedEntity)entity : null;
        if (curvedEntity == null) {
            return;
        }
        CurvedEntity curved = curvedEntity;
        boolean bl = hasTarget = curved.getTarget() != null;
        if (hasTarget) {
            FancyEntitySoundInstance fancyEntitySoundInstance;
            SoundEvent soundEvent = (SoundEvent)CollectionsKt.random((Collection)this$0.getNoticeSoundsIfHasTarget(), (Random)((Random)Random.Default));
            Entity entity2 = (Entity)curved;
            RandomSource randomSource = level2.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancyEntitySoundInstance $this$handle_u24lambda_u240_u240 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 2.0f, 1.0f, entity2, false, randomSource);
            boolean bl2 = false;
            $this$handle_u24lambda_u240_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CAVE, null, (int)1, null));
            instance = fancyEntitySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        } else {
            FancyEntitySoundInstance fancyEntitySoundInstance;
            SoundEvent soundEvent = (SoundEvent)CollectionsKt.random((Collection)this$0.getNoticeSounds(), (Random)((Random)Random.Default));
            Entity entity3 = (Entity)curved;
            RandomSource randomSource = level2.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            FancyEntitySoundInstance $this$handle_u24lambda_u240_u241 = fancyEntitySoundInstance = new FancyEntitySoundInstance(soundEvent, SoundSource.HOSTILE, 2.0f, 1.0f, entity3, false, randomSource);
            boolean bl3 = false;
            $this$handle_u24lambda_u240_u241.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_CAVE, null, (int)1, null));
            instance = fancyEntitySoundInstance;
            ClientDSLKt.getMC().getSoundManager().play((SoundInstance)instance);
        }
    }
}


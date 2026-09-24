/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.Biomes
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.circuit;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSBiomes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\n\u0010\u000e\u001a\u00020\f*\u00020\rJ\u001a\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u000f*\u00020\r*\b\u0012\u0004\u0012\u0002H\u000f0\u0005J\u001a\u0010\u000e\u001a\u00020\f\"\b\b\u0000\u0010\u000f*\u00020\r*\b\u0012\u0004\u0012\u0002H\u000f0\u0005R;\u0010\u0004\u001a,\u0012(\u0012&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitUtil;", "", "<init>", "()V", "BIOME_BLACKLIST", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/biome/Biome;", "kotlin.jvm.PlatformType", "getBIOME_BLACKLIST", "()Ljava/util/List;", "incNoWayOutFrame", "", "Lnet/minecraft/world/entity/player/Player;", "resetNoWayOutFrame", "T", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCircuitUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitUtil.kt\nnet/thebrokenscript/entity/circuit/CircuitUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1869#2,2:31\n1869#2,2:33\n*S KotlinDebug\n*F\n+ 1 CircuitUtil.kt\nnet/thebrokenscript/entity/circuit/CircuitUtil\n*L\n27#1:31,2\n28#1:33,2\n*E\n"})
public final class CircuitUtil {
    @NotNull
    public static final CircuitUtil INSTANCE = new CircuitUtil();
    @NotNull
    private static final List<ResourceKey<Biome>> BIOME_BLACKLIST;

    private CircuitUtil() {
    }

    @NotNull
    public final List<ResourceKey<Biome>> getBIOME_BLACKLIST() {
        return BIOME_BLACKLIST;
    }

    public final void incNoWayOutFrame(@NotNull Player $this$incNoWayOutFrame) {
        Intrinsics.checkNotNullParameter((Object)$this$incNoWayOutFrame, (String)"<this>");
        PlayerVariables vars = PlayerExt.INSTANCE.getVars($this$incNoWayOutFrame);
        vars.setNoWayOutFrame(vars.getNoWayOutFrame() == 5 ? 0 : vars.getNoWayOutFrame() + 1);
        vars.syncTo($this$incNoWayOutFrame);
    }

    public final void resetNoWayOutFrame(@NotNull Player $this$resetNoWayOutFrame) {
        Intrinsics.checkNotNullParameter((Object)$this$resetNoWayOutFrame, (String)"<this>");
        PlayerVariables vars = PlayerExt.INSTANCE.getVars($this$resetNoWayOutFrame);
        vars.setNoWayOutFrame(0);
        vars.syncTo($this$resetNoWayOutFrame);
    }

    public final <T extends Player> void incNoWayOutFrame(@NotNull List<? extends T> $this$incNoWayOutFrame) {
        Intrinsics.checkNotNullParameter($this$incNoWayOutFrame, (String)"<this>");
        Iterable $this$forEach$iv = $this$incNoWayOutFrame;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            INSTANCE.incNoWayOutFrame(it);
        }
    }

    public final <T extends Player> void resetNoWayOutFrame(@NotNull List<? extends T> $this$resetNoWayOutFrame) {
        Intrinsics.checkNotNullParameter($this$resetNoWayOutFrame, (String)"<this>");
        Iterable $this$forEach$iv = $this$resetNoWayOutFrame;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            INSTANCE.resetNoWayOutFrame(it);
        }
    }

    static {
        Object[] objectArray = new ResourceKey[]{Biomes.THE_END, Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS, TBSBiomes.NULL_BIOME};
        BIOME_BLACKLIST = CollectionsKt.listOf((Object[])objectArray);
    }
}


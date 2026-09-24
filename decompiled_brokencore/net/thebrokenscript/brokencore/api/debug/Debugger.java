/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.AtomicDouble
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.NbtIo
 *  net.minecraft.nbt.Tag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.apache.commons.io.output.ByteArrayOutputStream
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.debug;

import com.google.common.util.concurrent.AtomicDouble;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.brigadier.context.CommandContext;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.LevelTickEvents;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase;
import net.thebrokenscript.brokencore.api.util.UniqueMutableList;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010<\u001a\u00020=J\u0016\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BJ\u0016\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u000208J\u000e\u0010G\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000eJ\u000e\u0010H\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000eJ\u0016\u0010I\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010J\u001a\u000208J\u0015\u0010K\u001a\u0004\u0018\u0001082\u0006\u0010E\u001a\u00020\u000e\u00a2\u0006\u0002\u0010LJ#\u0010M\u001a\u0017\u0012\u000b\u0012\t\u0018\u000108\u00a2\u0006\u0002\b.\u0012\u0006\u0012\u0004\u0018\u0001080N2\u0006\u0010E\u001a\u00020\u000eJ\"\u0010O\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020802j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000208`4R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\r\u0012\t\u0012\u00070\u000e\u00a2\u0006\u0002\b.0-8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000203`4X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R*\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020802j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000208`4X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u0010\u0010C\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010P\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0S\u0012\u0004\u0012\u00020=0R0Q\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010V\u00a8\u0006W"}, d2={"Lnet/thebrokenscript/brokencore/api/debug/Debugger;", "", "<init>", "()V", "debuggables", "Lnet/thebrokenscript/brokencore/api/util/UniqueMutableList;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "getDebuggables", "()Lnet/thebrokenscript/brokencore/api/util/UniqueMutableList;", "debuggersToAdd", "Ljava/util/concurrent/LinkedBlockingQueue;", "getDebuggersToAdd", "()Ljava/util/concurrent/LinkedBlockingQueue;", "debuggerCategories", "", "getDebuggerCategories", "categoriesToAdd", "getCategoriesToAdd", "enabledDebuggers", "", "getEnabledDebuggers", "()Ljava/util/List;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "ticks", "", "getTicks", "()I", "setTicks", "(I)V", "subticks", "getSubticks", "setSubticks", "testLevel", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "getTestLevel", "()Lnet/minecraft/resources/ResourceKey;", "setTestLevel", "(Lnet/minecraft/resources/ResourceKey;)V", "valueNames", "", "Lkotlin/jvm/internal/EnhancedNullability;", "getValueNames", "()Ljava/util/Set;", "values", "Ljava/util/HashMap;", "Lcom/google/common/util/concurrent/AtomicDouble;", "Lkotlin/collections/HashMap;", "getValues$brokencore_common", "()Ljava/util/HashMap;", "incrementors", "", "tickspeed", "getTickspeed", "setTickspeed", "tick", "", "render", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "testCommandDebuggable", "addIncrementor", "name", "increment", "removeValue", "removeIncrementor", "addValue", "value", "getValue", "(Ljava/lang/String;)Ljava/lang/Double;", "getIncrementor", "Lkotlin/Pair;", "getValues", "tests", "", "Lkotlin/Function1;", "Lcom/mojang/brigadier/context/CommandContext;", "Lnet/minecraft/commands/CommandSourceStack;", "getTests", "()Ljava/util/Map;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nDebugger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Debugger.kt\nnet/thebrokenscript/brokencore/api/debug/Debugger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,158:1\n1869#2,2:159\n1869#2,2:161\n1869#2,2:163\n216#3,2:165\n*S KotlinDebug\n*F\n+ 1 Debugger.kt\nnet/thebrokenscript/brokencore/api/debug/Debugger\n*L\n57#1:159,2\n69#1:161,2\n90#1:163,2\n127#1:165,2\n*E\n"})
public final class Debugger {
    @NotNull
    public static final Debugger INSTANCE = new Debugger();
    @NotNull
    private static final UniqueMutableList<Debuggable> debuggables = new UniqueMutableList();
    @NotNull
    private static final LinkedBlockingQueue<Debuggable> debuggersToAdd = new LinkedBlockingQueue();
    @NotNull
    private static final UniqueMutableList<String> debuggerCategories = new UniqueMutableList();
    @NotNull
    private static final LinkedBlockingQueue<String> categoriesToAdd = new LinkedBlockingQueue();
    @NotNull
    private static final List<String> enabledDebuggers = new ArrayList();
    private static boolean enabled;
    private static int ticks;
    private static int subticks;
    @NotNull
    private static ResourceKey<Level> testLevel;
    @NotNull
    private static final HashMap<String, AtomicDouble> values;
    @NotNull
    private static final HashMap<String, Double> incrementors;
    private static int tickspeed;
    @Nullable
    private static volatile Debuggable testCommandDebuggable;
    @NotNull
    private static final Map<String, Function1<CommandContext<CommandSourceStack>, Unit>> tests;

    private Debugger() {
    }

    @NotNull
    public final UniqueMutableList<Debuggable> getDebuggables() {
        return debuggables;
    }

    @NotNull
    public final LinkedBlockingQueue<Debuggable> getDebuggersToAdd() {
        return debuggersToAdd;
    }

    @NotNull
    public final UniqueMutableList<String> getDebuggerCategories() {
        return debuggerCategories;
    }

    @NotNull
    public final LinkedBlockingQueue<String> getCategoriesToAdd() {
        return categoriesToAdd;
    }

    @NotNull
    public final List<String> getEnabledDebuggers() {
        return enabledDebuggers;
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean bl) {
        enabled = bl;
    }

    public final int getTicks() {
        return ticks;
    }

    public final void setTicks(int n) {
        ticks = n;
    }

    public final int getSubticks() {
        return subticks;
    }

    public final void setSubticks(int n) {
        subticks = n;
    }

    @NotNull
    public final ResourceKey<Level> getTestLevel() {
        return testLevel;
    }

    public final void setTestLevel(@NotNull ResourceKey<Level> resourceKey) {
        Intrinsics.checkNotNullParameter(resourceKey, (String)"<set-?>");
        testLevel = resourceKey;
    }

    @NotNull
    public final Set<String> getValueNames() {
        Set<String> set = values.keySet();
        Intrinsics.checkNotNullExpressionValue(set, (String)"<get-keys>(...)");
        return set;
    }

    @NotNull
    public final HashMap<String, AtomicDouble> getValues$brokencore_common() {
        return values;
    }

    public final int getTickspeed() {
        return tickspeed;
    }

    public final void setTickspeed(int n) {
        tickspeed = n;
    }

    public final void tick() {
        for (Map.Entry entry : ((Map)incrementors).entrySet()) {
            String key = (String)entry.getKey();
            double value = ((Number)entry.getValue()).doubleValue();
            AtomicDouble atomicDouble = values.get(key);
            if (atomicDouble == null) continue;
            atomicDouble.getAndAdd(value);
        }
        if (!enabled || ticks <= 0) {
            return;
        }
        while (!((Collection)debuggersToAdd).isEmpty()) {
            Debuggable next = debuggersToAdd.poll();
            Intrinsics.checkNotNull((Object)next);
            debuggables.add(next);
        }
        if (tickspeed <= 0) {
            while (ticks > 0) {
                --ticks;
                $this$forEach$iv = debuggables;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Debuggable it = (Debuggable)element$iv;
                    boolean bl = false;
                    try {
                        it.tickDebug();
                    }
                    catch (Throwable throwable) {
                    }
                }
            }
        } else if (ticks > 0) {
            if (subticks <= 1) {
                try {
                    $this$forEach$iv = debuggables;
                    boolean $i$f$forEach = false;
                    for (Object element$iv : $this$forEach$iv) {
                        Debuggable it = (Debuggable)element$iv;
                        boolean bl = false;
                        try {
                            it.tickDebug();
                        }
                        catch (Throwable throwable) {
                        }
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                subticks = tickspeed;
            }
            --subticks;
        }
    }

    public final void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        if (!enabled) {
            return;
        }
        Vec3 ofs = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().multiply(-1.0, -1.0, -1.0);
        while (!((Collection)categoriesToAdd).isEmpty()) {
            String next = categoriesToAdd.poll();
            Intrinsics.checkNotNull((Object)next);
            debuggerCategories.add(next);
        }
        Iterable $this$forEach$iv = debuggables;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Debuggable it = (Debuggable)element$iv;
            boolean bl = false;
            if (!enabledDebuggers.contains(it.getCategory())) continue;
            poseStack.pushPose();
            poseStack.translate(ofs.x, ofs.y, ofs.z);
            it.renderDebug(poseStack, buffer);
            poseStack.popPose();
        }
    }

    public final void addIncrementor(@NotNull String name, double increment) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ((Map)incrementors).put(name, increment);
        ((Map)values).put(name, new AtomicDouble(0.0));
    }

    public final void removeValue(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        values.remove(name);
    }

    public final void removeIncrementor(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        if (incrementors.containsKey(name)) {
            incrementors.remove(name);
            values.remove(name);
        }
    }

    public final void addValue(@NotNull String name, double value) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ((Map)values).put(name, new AtomicDouble(value));
    }

    @Nullable
    public final Double getValue(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AtomicDouble atomicDouble = values.get(name);
        return atomicDouble != null ? Double.valueOf(atomicDouble.get()) : null;
    }

    @NotNull
    public final Pair<Double, Double> getIncrementor(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        AtomicDouble atomicDouble = values.get(name);
        return new Pair((Object)incrementors.get(name), (Object)(atomicDouble != null ? Double.valueOf(atomicDouble.get()) : null));
    }

    @NotNull
    public final HashMap<String, Double> getValues() {
        HashMap<String, Double> map = new HashMap<String, Double>();
        Map $this$forEach$iv = values;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            String string = (String)entry.getKey();
            AtomicDouble atomicDouble = (AtomicDouble)entry.getValue();
            ((Map)map).put(string, atomicDouble.get());
        }
        return map;
    }

    @NotNull
    public final Map<String, Function1<CommandContext<CommandSourceStack>, Unit>> getTests() {
        return tests;
    }

    private static final Unit _init_$lambda$0(LevelTickEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        if (Intrinsics.areEqual(testLevel, (Object)$this$on.getLevel().dimension())) {
            INSTANCE.tick();
        }
        return Unit.INSTANCE;
    }

    private static final Unit tests$lambda$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Iterator iterator = debuggables.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            Object e = iterator2.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            Debuggable debuggable = (Debuggable)e;
            debuggable.free();
        }
        ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayer();
        Intrinsics.checkNotNull((Object)serverPlayer);
        BlockPos blockPos = serverPlayer.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        ServerLevel serverLevel = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        UnfinalizedPlayerBase scanner = PlayerBase.Companion.scanAt(blockPos, (Level)serverLevel, (Function1<? super PlayerBase, Unit>)((Function1)Debugger::tests$lambda$0$0));
        testCommandDebuggable = scanner;
        enabled = true;
        ticks = 1;
        tickspeed = 1;
        enabledDebuggers.add("player_base");
        Debuggable debuggable = testCommandDebuggable;
        Intrinsics.checkNotNull((Object)debuggable);
        debuggable.debug();
        return Unit.INSTANCE;
    }

    private static final Unit tests$lambda$0$0(PlayerBase it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ListTag nbt = it.toNbt();
        ByteArrayOutputStream a = new ByteArrayOutputStream();
        CompoundTag compound = new CompoundTag();
        compound.put("a", (Tag)nbt);
        NbtIo.writeCompressed((CompoundTag)compound, (OutputStream)((OutputStream)a));
        String string = Arrays.toString(a.toByteArray());
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String string2 = string;
        System.out.println((Object)string2);
        int n = a.size();
        System.out.println(n);
        testCommandDebuggable = PlayerBase.Companion.fromNbt(nbt);
        debuggables.clear();
        Debuggable debuggable = testCommandDebuggable;
        Intrinsics.checkNotNull((Object)debuggable);
        debuggable.debug();
        return Unit.INSTANCE;
    }

    static {
        ResourceKey resourceKey = Level.OVERWORLD;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"OVERWORLD");
        testLevel = resourceKey;
        values = new HashMap();
        incrementors = new HashMap();
        GameEvent.Companion.on(LevelTickEvents.PRE, Debugger::_init_$lambda$0);
        Pair[] pairArray = new Pair[]{new Pair((Object)"room_scanner", Debugger::tests$lambda$0)};
        tests = MapsKt.mutableMapOf((Pair[])pairArray);
    }
}


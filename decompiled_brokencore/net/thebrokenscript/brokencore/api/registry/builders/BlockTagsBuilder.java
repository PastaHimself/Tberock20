/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.DslMarker
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Target
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashSet;
import kotlin.DslMarker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.VanillaBlockTagEnum;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u000e,-./0123456789B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ*\u0010\r\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u0014\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u0016\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u0018\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u001a\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u001c\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\u001e\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010 \u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010\"\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010$\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010&\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010(\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013J*\u0010*\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0002X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "getReg", "()Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "getBlock", "()Lnet/minecraft/world/level/block/Block;", "tool", "", "func", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$Marker;", "Lkotlin/ExtensionFunctionType;", "material", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder;", "ore", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder;", "spawnableOn", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder;", "sign", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder;", "plantableOn", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder;", "partialBlock", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder;", "worldgen", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder;", "entityBehavior", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder;", "functional", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder;", "sound", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder;", "interactable", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder;", "misc", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder;", "ToolTagsBuilder", "MaterialTagsBuilder", "OreTagBuilder", "SpawnableTagBuilder", "SignTagBuilder", "PlantableOnTagBuilder", "PartialBlockTagBuilder", "WorldGenTagBuilder", "BehaviorTagBuilder", "FunctionalTagBuilder", "SoundTagBuilder", "InteractableBlockTagBuilder", "MiscTagBuilder", "Marker", "brokencore-common"})
public class BlockTagsBuilder<T extends Block> {
    @NotNull
    private final BrokenReg reg;
    @NotNull
    private final Block block;

    public BlockTagsBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        this.reg = reg;
        this.block = block2;
    }

    @NotNull
    protected final BrokenReg getReg() {
        return this.reg;
    }

    @NotNull
    protected final Block getBlock() {
        return this.block;
    }

    public final void tool(@NotNull Function1<? super ToolTagsBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        ToolTagsBuilder obj = new ToolTagsBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void material(@NotNull Function1<? super MaterialTagsBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        MaterialTagsBuilder obj = new MaterialTagsBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void ore(@NotNull Function1<? super OreTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        OreTagBuilder obj = new OreTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void spawnableOn(@NotNull Function1<? super SpawnableTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        SpawnableTagBuilder obj = new SpawnableTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void sign(@NotNull Function1<? super SignTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        SignTagBuilder obj = new SignTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void plantableOn(@NotNull Function1<? super PlantableOnTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        PlantableOnTagBuilder obj = new PlantableOnTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void partialBlock(@NotNull Function1<? super PartialBlockTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        PartialBlockTagBuilder obj = new PartialBlockTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void worldgen(@NotNull Function1<? super WorldGenTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        WorldGenTagBuilder obj = new WorldGenTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void entityBehavior(@NotNull Function1<? super BehaviorTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        BehaviorTagBuilder obj = new BehaviorTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void functional(@NotNull Function1<? super FunctionalTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        FunctionalTagBuilder obj = new FunctionalTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void sound(@NotNull Function1<? super SoundTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        SoundTagBuilder obj = new SoundTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void interactable(@NotNull Function1<? super InteractableBlockTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        InteractableBlockTagBuilder obj = new InteractableBlockTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    public final void misc(@NotNull Function1<? super MiscTagBuilder<T>, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        MiscTagBuilder obj = new MiscTagBuilder(this.reg, this.block);
        func.invoke(obj);
        obj.add$brokencore_common();
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "bed", "beeGrowable", "beehive", "cauldron", "frogsPrefereJump", "piglinGuarded", "hoglinRepellent", "mobInteractableDoor", "piglinRepellent", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder\n*L\n407#1:619,2\n*E\n"})
    public static final class BehaviorTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public BehaviorTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void bed() {
            this.tags.add(Tags.BEDS_BLOCK_TAGS);
        }

        public final void beeGrowable() {
            this.tags.add(Tags.BEE_GROWABLE);
        }

        public final void beehive() {
            this.tags.add(Tags.BEEHIVE_TAG);
        }

        public final void cauldron() {
            this.tags.add(Tags.CAULDRON_TAG);
        }

        public final void frogsPrefereJump() {
            this.tags.add(Tags.FROGS_PREFER_JUMP_TO_TAG);
        }

        public final void piglinGuarded() {
            this.tags.add(Tags.GUARDED_BY_PIGLINS_TAG);
        }

        public final void hoglinRepellent() {
            this.tags.add(Tags.HOGLIN_REPELLENTS_TAG);
        }

        public final void mobInteractableDoor() {
            this.tags.add(Tags.MOB_INTERACTABLE_DOORS_TAG);
        }

        public final void piglinRepellent() {
            this.tags.add(Tags.PIGLIN_REPELLENTS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$BehaviorTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "BEDS_BLOCK_TAGS", "BEE_GROWABLE", "BEEHIVE_TAG", "CAULDRON_TAG", "FROGS_PREFER_JUMP_TO_TAG", "GUARDED_BY_PIGLINS_TAG", "HOGLIN_REPELLENTS_TAG", "MOB_INTERACTABLE_DOORS_TAG", "PIGLIN_REPELLENTS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags BEDS_BLOCK_TAGS = new Tags((TagKey<Block>)BlockTags.BEDS);
            public static final /* enum */ Tags BEE_GROWABLE = new Tags((TagKey<Block>)BlockTags.BEE_GROWABLES);
            public static final /* enum */ Tags BEEHIVE_TAG = new Tags((TagKey<Block>)BlockTags.BEEHIVES);
            public static final /* enum */ Tags CAULDRON_TAG = new Tags((TagKey<Block>)BlockTags.CAULDRONS);
            public static final /* enum */ Tags FROGS_PREFER_JUMP_TO_TAG = new Tags((TagKey<Block>)BlockTags.FROG_PREFER_JUMP_TO);
            public static final /* enum */ Tags GUARDED_BY_PIGLINS_TAG = new Tags((TagKey<Block>)BlockTags.GUARDED_BY_PIGLINS);
            public static final /* enum */ Tags HOGLIN_REPELLENTS_TAG = new Tags((TagKey<Block>)BlockTags.HOGLIN_REPELLENTS);
            public static final /* enum */ Tags MOB_INTERACTABLE_DOORS_TAG = new Tags((TagKey<Block>)BlockTags.MOB_INTERACTABLE_DOORS);
            public static final /* enum */ Tags PIGLIN_REPELLENTS_TAG = new Tags((TagKey<Block>)BlockTags.PIGLIN_REPELLENTS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.BEDS_BLOCK_TAGS, Tags.BEE_GROWABLE, Tags.BEEHIVE_TAG, Tags.CAULDRON_TAG, Tags.FROGS_PREFER_JUMP_TO_TAG, Tags.GUARDED_BY_PIGLINS_TAG, Tags.HOGLIN_REPELLENTS_TAG, Tags.MOB_INTERACTABLE_DOORS_TAG, Tags.PIGLIN_REPELLENTS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b*\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u00017B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020\u000eJ\u0006\u0010(\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u000eJ\u0006\u0010-\u001a\u00020\u000eJ\u0006\u0010.\u001a\u00020\u000eJ\u0006\u0010/\u001a\u00020\u000eJ\u0006\u00100\u001a\u00020\u000eJ\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ\u0006\u00103\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u000eJ\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "anvil", "climbable", "blocksWindCharge", "campfire", "convertableToMud", "crop", "dampensVibrations", "hopperNonBlocking", "dragonImmune", "dragonTransparent", "enchantmentPowerProvider", "enchantmentPowerTransmitter", "endermanHoldable", "negatesFallDamage", "disallowsFluidDripping", "infiniburnOverworld", "infiniburnNether", "infiniburnEnd", "infiniburn", "maintainsFarmland", "mangroveRootsCanGrowThrough", "mangroveLogsCanGrowThrough", "mossReplaceable", "occludesVibrationSignals", "replaceable", "treeReplaceable", "skulkReplaceable", "smeltsToGlass", "snapsGoatHorn", "snifferDiggable", "snifferEggHatchBooster", "alwaysPermitSnowLayer", "neverPermitSnowLayer", "createsSoulFire", "triggersSoulSpeed", "warmForStrider", "vibrationResonator", "witherImmune", "witherStructureBaseBlock", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder\n*L\n437#1:619,2\n*E\n"})
    public static final class FunctionalTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public FunctionalTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void anvil() {
            this.tags.add(Tags.ANVIL_TAG);
        }

        public final void climbable() {
            this.tags.add(Tags.CLIMBABLE_TAG);
        }

        public final void blocksWindCharge() {
            this.tags.add(Tags.BLOCKS_WIND_CHARGE_EXPLOSIONS_TAG);
        }

        public final void campfire() {
            this.tags.add(Tags.CAMPFIRES_TAG);
        }

        public final void convertableToMud() {
            this.tags.add(Tags.CONVERTABLE_TO_MUD_TAG);
        }

        public final void crop() {
            this.tags.add(Tags.CROPS_TAG);
        }

        public final void dampensVibrations() {
            this.tags.add(Tags.DAMPENS_VIBRATIONS_TAG);
        }

        public final void hopperNonBlocking() {
            this.tags.add(Tags.DOES_NOT_BLOCK_HOPPERS_TAG);
        }

        public final void dragonImmune() {
            this.tags.add(Tags.DRAGON_IMMUNE_TAG);
        }

        public final void dragonTransparent() {
            this.tags.add(Tags.DRAGON_TRANSPARENT_TAG);
        }

        public final void enchantmentPowerProvider() {
            this.tags.add(Tags.ENCHANTMENT_POWER_PROVIDER_TAG);
        }

        public final void enchantmentPowerTransmitter() {
            this.tags.add(Tags.ENCHANTMENT_POWER_TRANSMITTER_TAG);
        }

        public final void endermanHoldable() {
            this.tags.add(Tags.ENDERMAN_HOLDABLE_TAG);
        }

        public final void negatesFallDamage() {
            this.tags.add(Tags.FALL_DAMAGE_RESETTING_TAG);
        }

        public final void disallowsFluidDripping() {
            this.tags.add(Tags.IMPERMEABLE_TAG);
        }

        public final void infiniburnOverworld() {
            this.tags.add(Tags.INFINIBURN_OVERWORLD_TAG);
        }

        public final void infiniburnNether() {
            this.tags.add(Tags.INFINIBURN_NETHER_TAG);
        }

        public final void infiniburnEnd() {
            this.tags.add(Tags.INFINIBURN_END_TAG);
        }

        public final void infiniburn() {
            this.infiniburnOverworld();
            this.infiniburnOverworld();
            this.infiniburnEnd();
        }

        public final void maintainsFarmland() {
            this.tags.add(Tags.MAINTAINS_FARMLAND_TAG);
        }

        public final void mangroveRootsCanGrowThrough() {
            this.tags.add(Tags.MANGROVE_ROOTS_CAN_GROW_THROUGH_TAG);
        }

        public final void mangroveLogsCanGrowThrough() {
            this.tags.add(Tags.MANGROVE_LOGS_CAN_GROW_THROUGH_TAG);
        }

        public final void mossReplaceable() {
            this.tags.add(Tags.MOSS_REPLACEABLE_TAG);
        }

        public final void occludesVibrationSignals() {
            this.tags.add(Tags.OCCLUDES_VIBRATION_SIGNALS_TAG);
        }

        public final void replaceable() {
            this.tags.add(Tags.REPLACEABLE_TAG);
        }

        public final void treeReplaceable() {
            this.tags.add(Tags.REPLACEABLE_BY_TREES_TAG);
        }

        public final void skulkReplaceable() {
            this.tags.add(Tags.SKULK_REPLACEABLE_TAG);
        }

        public final void smeltsToGlass() {
            this.tags.add(Tags.SMELTS_TO_GLASS_TAG);
        }

        public final void snapsGoatHorn() {
            this.tags.add(Tags.SNAPS_GOAT_HORN_TAG);
        }

        public final void snifferDiggable() {
            this.tags.add(Tags.SNIFFER_DIGGABLE_TAG);
        }

        public final void snifferEggHatchBooster() {
            this.tags.add(Tags.SNIFFER_EGG_HATCH_BOOST_TAG);
        }

        public final void alwaysPermitSnowLayer() {
            this.tags.add(Tags.SNOW_LAYER_CAN_SURVIVE_ON_TAG);
        }

        public final void neverPermitSnowLayer() {
            this.tags.add(Tags.SNOW_LAYER_CANNOT_SURVIVE_ON_TAG);
        }

        public final void createsSoulFire() {
            this.tags.add(Tags.SOUL_FIRE_BASE_BLOCKS_TAG);
        }

        public final void triggersSoulSpeed() {
            this.tags.add(Tags.SOUL_SPEED_BLOCKS_TAG);
        }

        public final void warmForStrider() {
            this.tags.add(Tags.STRIDER_WARM_BLOCKS_TAG);
        }

        public final void vibrationResonator() {
            this.tags.add(Tags.VIBRATION_RESONATORS_TAG);
        }

        public final void witherImmune() {
            this.tags.add(Tags.WITHER_IMMUNE_TAG);
        }

        public final void witherStructureBaseBlock() {
            this.tags.add(Tags.WITHER_SUMMON_BASE_BLOCKS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/\u00a8\u00060"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$FunctionalTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "CLIMBABLE_TAG", "BLOCKS_WIND_CHARGE_EXPLOSIONS_TAG", "CAMPFIRES_TAG", "ANVIL_TAG", "CONVERTABLE_TO_MUD_TAG", "CROPS_TAG", "DAMPENS_VIBRATIONS_TAG", "DOES_NOT_BLOCK_HOPPERS_TAG", "DRAGON_IMMUNE_TAG", "DRAGON_TRANSPARENT_TAG", "ENCHANTMENT_POWER_PROVIDER_TAG", "ENCHANTMENT_POWER_TRANSMITTER_TAG", "ENDERMAN_HOLDABLE_TAG", "FALL_DAMAGE_RESETTING_TAG", "IMPERMEABLE_TAG", "INFINIBURN_OVERWORLD_TAG", "INFINIBURN_NETHER_TAG", "INFINIBURN_END_TAG", "MAINTAINS_FARMLAND_TAG", "MANGROVE_LOGS_CAN_GROW_THROUGH_TAG", "MANGROVE_ROOTS_CAN_GROW_THROUGH_TAG", "MOSS_REPLACEABLE_TAG", "OCCLUDES_VIBRATION_SIGNALS_TAG", "REPLACEABLE_TAG", "REPLACEABLE_BY_TREES_TAG", "SKULK_REPLACEABLE_TAG", "SMELTS_TO_GLASS_TAG", "SNAPS_GOAT_HORN_TAG", "SNIFFER_DIGGABLE_TAG", "SNIFFER_EGG_HATCH_BOOST_TAG", "SNOW_LAYER_CAN_SURVIVE_ON_TAG", "SNOW_LAYER_CANNOT_SURVIVE_ON_TAG", "SOUL_FIRE_BASE_BLOCKS_TAG", "SOUL_SPEED_BLOCKS_TAG", "STRIDER_WARM_BLOCKS_TAG", "VIBRATION_RESONATORS_TAG", "WITHER_IMMUNE_TAG", "WITHER_SUMMON_BASE_BLOCKS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags CLIMBABLE_TAG = new Tags((TagKey<Block>)BlockTags.CLIMBABLE);
            public static final /* enum */ Tags BLOCKS_WIND_CHARGE_EXPLOSIONS_TAG = new Tags((TagKey<Block>)BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS);
            public static final /* enum */ Tags CAMPFIRES_TAG = new Tags((TagKey<Block>)BlockTags.CAMPFIRES);
            public static final /* enum */ Tags ANVIL_TAG = new Tags((TagKey<Block>)BlockTags.ANVIL);
            public static final /* enum */ Tags CONVERTABLE_TO_MUD_TAG = new Tags((TagKey<Block>)BlockTags.CONVERTABLE_TO_MUD);
            public static final /* enum */ Tags CROPS_TAG = new Tags((TagKey<Block>)BlockTags.CROPS);
            public static final /* enum */ Tags DAMPENS_VIBRATIONS_TAG = new Tags((TagKey<Block>)BlockTags.DAMPENS_VIBRATIONS);
            public static final /* enum */ Tags DOES_NOT_BLOCK_HOPPERS_TAG = new Tags((TagKey<Block>)BlockTags.DOES_NOT_BLOCK_HOPPERS);
            public static final /* enum */ Tags DRAGON_IMMUNE_TAG = new Tags((TagKey<Block>)BlockTags.DRAGON_IMMUNE);
            public static final /* enum */ Tags DRAGON_TRANSPARENT_TAG = new Tags((TagKey<Block>)BlockTags.DRAGON_TRANSPARENT);
            public static final /* enum */ Tags ENCHANTMENT_POWER_PROVIDER_TAG = new Tags((TagKey<Block>)BlockTags.ENCHANTMENT_POWER_PROVIDER);
            public static final /* enum */ Tags ENCHANTMENT_POWER_TRANSMITTER_TAG = new Tags((TagKey<Block>)BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
            public static final /* enum */ Tags ENDERMAN_HOLDABLE_TAG = new Tags((TagKey<Block>)BlockTags.ENDERMAN_HOLDABLE);
            public static final /* enum */ Tags FALL_DAMAGE_RESETTING_TAG = new Tags((TagKey<Block>)BlockTags.FALL_DAMAGE_RESETTING);
            public static final /* enum */ Tags IMPERMEABLE_TAG = new Tags((TagKey<Block>)BlockTags.IMPERMEABLE);
            public static final /* enum */ Tags INFINIBURN_OVERWORLD_TAG = new Tags((TagKey<Block>)BlockTags.INFINIBURN_OVERWORLD);
            public static final /* enum */ Tags INFINIBURN_NETHER_TAG = new Tags((TagKey<Block>)BlockTags.INFINIBURN_NETHER);
            public static final /* enum */ Tags INFINIBURN_END_TAG = new Tags((TagKey<Block>)BlockTags.INFINIBURN_END);
            public static final /* enum */ Tags MAINTAINS_FARMLAND_TAG = new Tags((TagKey<Block>)BlockTags.MAINTAINS_FARMLAND);
            public static final /* enum */ Tags MANGROVE_LOGS_CAN_GROW_THROUGH_TAG = new Tags((TagKey<Block>)BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH);
            public static final /* enum */ Tags MANGROVE_ROOTS_CAN_GROW_THROUGH_TAG = new Tags((TagKey<Block>)BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH);
            public static final /* enum */ Tags MOSS_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.MOSS_REPLACEABLE);
            public static final /* enum */ Tags OCCLUDES_VIBRATION_SIGNALS_TAG = new Tags((TagKey<Block>)BlockTags.OCCLUDES_VIBRATION_SIGNALS);
            public static final /* enum */ Tags REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.REPLACEABLE);
            public static final /* enum */ Tags REPLACEABLE_BY_TREES_TAG = new Tags((TagKey<Block>)BlockTags.REPLACEABLE_BY_TREES);
            public static final /* enum */ Tags SKULK_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.SCULK_REPLACEABLE);
            public static final /* enum */ Tags SMELTS_TO_GLASS_TAG = new Tags((TagKey<Block>)BlockTags.SMELTS_TO_GLASS);
            public static final /* enum */ Tags SNAPS_GOAT_HORN_TAG = new Tags((TagKey<Block>)BlockTags.SNAPS_GOAT_HORN);
            public static final /* enum */ Tags SNIFFER_DIGGABLE_TAG = new Tags((TagKey<Block>)BlockTags.SNIFFER_DIGGABLE_BLOCK);
            public static final /* enum */ Tags SNIFFER_EGG_HATCH_BOOST_TAG = new Tags((TagKey<Block>)BlockTags.SNIFFER_EGG_HATCH_BOOST);
            public static final /* enum */ Tags SNOW_LAYER_CAN_SURVIVE_ON_TAG = new Tags((TagKey<Block>)BlockTags.SNOW_LAYER_CAN_SURVIVE_ON);
            public static final /* enum */ Tags SNOW_LAYER_CANNOT_SURVIVE_ON_TAG = new Tags((TagKey<Block>)BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON);
            public static final /* enum */ Tags SOUL_FIRE_BASE_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.SOUL_FIRE_BASE_BLOCKS);
            public static final /* enum */ Tags SOUL_SPEED_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.SOUL_SPEED_BLOCKS);
            public static final /* enum */ Tags STRIDER_WARM_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.STRIDER_WARM_BLOCKS);
            public static final /* enum */ Tags VIBRATION_RESONATORS_TAG = new Tags((TagKey<Block>)BlockTags.VIBRATION_RESONATORS);
            public static final /* enum */ Tags WITHER_IMMUNE_TAG = new Tags((TagKey<Block>)BlockTags.WITHER_IMMUNE);
            public static final /* enum */ Tags WITHER_SUMMON_BASE_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.WITHER_SUMMON_BASE_BLOCKS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.CLIMBABLE_TAG, Tags.BLOCKS_WIND_CHARGE_EXPLOSIONS_TAG, Tags.CAMPFIRES_TAG, Tags.ANVIL_TAG, Tags.CONVERTABLE_TO_MUD_TAG, Tags.CROPS_TAG, Tags.DAMPENS_VIBRATIONS_TAG, Tags.DOES_NOT_BLOCK_HOPPERS_TAG, Tags.DRAGON_IMMUNE_TAG, Tags.DRAGON_TRANSPARENT_TAG, Tags.ENCHANTMENT_POWER_PROVIDER_TAG, Tags.ENCHANTMENT_POWER_TRANSMITTER_TAG, Tags.ENDERMAN_HOLDABLE_TAG, Tags.FALL_DAMAGE_RESETTING_TAG, Tags.IMPERMEABLE_TAG, Tags.INFINIBURN_OVERWORLD_TAG, Tags.INFINIBURN_NETHER_TAG, Tags.INFINIBURN_END_TAG, Tags.MAINTAINS_FARMLAND_TAG, Tags.MANGROVE_LOGS_CAN_GROW_THROUGH_TAG, Tags.MANGROVE_ROOTS_CAN_GROW_THROUGH_TAG, Tags.MOSS_REPLACEABLE_TAG, Tags.OCCLUDES_VIBRATION_SIGNALS_TAG, Tags.REPLACEABLE_TAG, Tags.REPLACEABLE_BY_TREES_TAG, Tags.SKULK_REPLACEABLE_TAG, Tags.SMELTS_TO_GLASS_TAG, Tags.SNAPS_GOAT_HORN_TAG, Tags.SNIFFER_DIGGABLE_TAG, Tags.SNIFFER_EGG_HATCH_BOOST_TAG, Tags.SNOW_LAYER_CAN_SURVIVE_ON_TAG, Tags.SNOW_LAYER_CANNOT_SURVIVE_ON_TAG, Tags.SOUL_FIRE_BASE_BLOCKS_TAG, Tags.SOUL_SPEED_BLOCKS_TAG, Tags.STRIDER_WARM_BLOCKS_TAG, Tags.VIBRATION_RESONATORS_TAG, Tags.WITHER_IMMUNE_TAG, Tags.WITHER_SUMMON_BASE_BLOCKS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001fB\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "bed", "button", "candleCake", "candle", "cauldron", "door", "fenceGate", "flowerPot", "pressurePlate", "stoneButton", "trapdoor", "woodenButton", "woodenDoor", "woodenPressurePlate", "woodenTrapdoor", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder\n*L\n546#1:619,2\n*E\n"})
    public static final class InteractableBlockTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public InteractableBlockTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void bed() {
            this.tags.add(Tags.BEDS_BLOCK_TAGS);
        }

        public final void button() {
            this.tags.add(Tags.BUTTONS_TAG);
        }

        public final void candleCake() {
            this.tags.add(Tags.CANDLE_CAKES_TAG);
        }

        public final void candle() {
            this.tags.add(Tags.CANDLES_TAG);
        }

        public final void cauldron() {
            this.tags.add(Tags.CAULDRON_TAG);
        }

        public final void door() {
            this.tags.add(Tags.DOORS_TAG);
        }

        public final void fenceGate() {
            this.tags.add(Tags.FENCE_GATES_TAG);
        }

        public final void flowerPot() {
            this.tags.add(Tags.FLOWER_POTS_TAG);
        }

        public final void pressurePlate() {
            this.tags.add(Tags.PRESSURE_PLATES_TAG);
        }

        public final void stoneButton() {
            this.tags.add(Tags.STONE_BUTTONS_TAG);
        }

        public final void trapdoor() {
            this.tags.add(Tags.TRAPDOORS_TAG);
        }

        public final void woodenButton() {
            this.tags.add(Tags.WOODEN_BUTTONS_TAG);
        }

        public final void woodenDoor() {
            this.tags.add(Tags.WOODEN_DOORS_TAG);
        }

        public final void woodenPressurePlate() {
            this.tags.add(Tags.WOODEN_PRESSURE_PLATES_TAG);
        }

        public final void woodenTrapdoor() {
            this.tags.add(Tags.WOODEN_TRAPDOORS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$InteractableBlockTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "BEDS_BLOCK_TAGS", "BUTTONS_TAG", "CANDLE_CAKES_TAG", "CANDLES_TAG", "CAULDRON_TAG", "DOORS_TAG", "FENCE_GATES_TAG", "FLOWER_POTS_TAG", "PRESSURE_PLATES_TAG", "STONE_BUTTONS_TAG", "TRAPDOORS_TAG", "WOODEN_BUTTONS_TAG", "WOODEN_DOORS_TAG", "WOODEN_PRESSURE_PLATES_TAG", "WOODEN_TRAPDOORS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags BEDS_BLOCK_TAGS = new Tags((TagKey<Block>)BlockTags.BEDS);
            public static final /* enum */ Tags BUTTONS_TAG = new Tags((TagKey<Block>)BlockTags.BUTTONS);
            public static final /* enum */ Tags CANDLE_CAKES_TAG = new Tags((TagKey<Block>)BlockTags.CANDLE_CAKES);
            public static final /* enum */ Tags CANDLES_TAG = new Tags((TagKey<Block>)BlockTags.CANDLES);
            public static final /* enum */ Tags CAULDRON_TAG = new Tags((TagKey<Block>)BlockTags.CAULDRONS);
            public static final /* enum */ Tags DOORS_TAG = new Tags((TagKey<Block>)BlockTags.DOORS);
            public static final /* enum */ Tags FENCE_GATES_TAG = new Tags((TagKey<Block>)BlockTags.FENCE_GATES);
            public static final /* enum */ Tags FLOWER_POTS_TAG = new Tags((TagKey<Block>)BlockTags.FLOWER_POTS);
            public static final /* enum */ Tags PRESSURE_PLATES_TAG = new Tags((TagKey<Block>)BlockTags.PRESSURE_PLATES);
            public static final /* enum */ Tags STONE_BUTTONS_TAG = new Tags((TagKey<Block>)BlockTags.STONE_BUTTONS);
            public static final /* enum */ Tags TRAPDOORS_TAG = new Tags((TagKey<Block>)BlockTags.TRAPDOORS);
            public static final /* enum */ Tags WOODEN_BUTTONS_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_BUTTONS);
            public static final /* enum */ Tags WOODEN_DOORS_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_DOORS);
            public static final /* enum */ Tags WOODEN_PRESSURE_PLATES_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_PRESSURE_PLATES);
            public static final /* enum */ Tags WOODEN_TRAPDOORS_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_TRAPDOORS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.BEDS_BLOCK_TAGS, Tags.BUTTONS_TAG, Tags.CANDLE_CAKES_TAG, Tags.CANDLES_TAG, Tags.CAULDRON_TAG, Tags.DOORS_TAG, Tags.FENCE_GATES_TAG, Tags.FLOWER_POTS_TAG, Tags.PRESSURE_PLATES_TAG, Tags.STONE_BUTTONS_TAG, Tags.TRAPDOORS_TAG, Tags.WOODEN_BUTTONS_TAG, Tags.WOODEN_DOORS_TAG, Tags.WOODEN_PRESSURE_PLATES_TAG, Tags.WOODEN_TRAPDOORS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$Marker;", "", "brokencore-common"})
    @DslMarker
    private static @interface Marker {
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002+,B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u000e2\u001d\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020\u000eJ\u0006\u0010(\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$MaterialTags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "log", "func", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder;", "Lkotlin/ExtensionFunctionType;", "bamboo", "caveVines", "concretePowder", "coralBlock", "coralPlant", "dirt", "fire", "flower", "ice", "nylium", "planks", "sand", "sapling", "smallFlower", "snow", "stoneBricks", "tallFlower", "terracotta", "wallCoral", "wartBlock", "wool", "woolCarpet", "MaterialTags", "LogBuilder", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder\n*L\n124#1:619,2\n*E\n"})
    public static final class MaterialTagsBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<MaterialTags> tags;

        public MaterialTagsBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                MaterialTags it = (MaterialTags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void log(@NotNull Function1<? super LogBuilder<T>, Unit> func) {
            Intrinsics.checkNotNullParameter(func, (String)"func");
            LogBuilder obj = new LogBuilder(this.reg, this.block);
            func.invoke(obj);
            obj.add$brokencore_common();
        }

        public final void bamboo() {
            this.tags.add(MaterialTags.BAMBOO_BLOCKS_TAG);
        }

        public final void caveVines() {
            this.tags.add(MaterialTags.CAVE_VINES_TAG);
        }

        public final void concretePowder() {
            this.tags.add(MaterialTags.CONCRETE_POWDER_TAG);
        }

        public final void coralBlock() {
            this.tags.add(MaterialTags.CORAL_BLOCKS_TAG);
        }

        public final void coralPlant() {
            this.tags.add(MaterialTags.CORAL_PLANTS_TAG);
        }

        public final void dirt() {
            this.tags.add(MaterialTags.DIRT_TAG);
        }

        public final void fire() {
            this.tags.add(MaterialTags.FIRE_TAG);
        }

        public final void flower() {
            this.tags.add(MaterialTags.FLOWERS_TAG);
        }

        public final void ice() {
            this.tags.add(MaterialTags.ICE_TAG);
        }

        public final void nylium() {
            this.tags.add(MaterialTags.NYLIUM_TAG);
        }

        public final void planks() {
            this.tags.add(MaterialTags.PLANKS_TAG);
        }

        public final void sand() {
            this.tags.add(MaterialTags.SAND_TAG);
        }

        public final void sapling() {
            this.tags.add(MaterialTags.SAPLINGS_TAG);
        }

        public final void smallFlower() {
            this.tags.add(MaterialTags.SMALL_FLOWERS_TAG);
        }

        public final void snow() {
            this.tags.add(MaterialTags.SNOW_TAG);
        }

        public final void stoneBricks() {
            this.tags.add(MaterialTags.STONE_BRICKS_TAG);
        }

        public final void tallFlower() {
            this.tags.add(MaterialTags.TALL_FLOWERS_TAG);
        }

        public final void terracotta() {
            this.tags.add(MaterialTags.TERRACOTTA_TAG);
        }

        public final void wallCoral() {
            this.tags.add(MaterialTags.WALL_CORALS_TAG);
        }

        public final void wartBlock() {
            this.tags.add(MaterialTags.WART_BLOCKS_TAG);
        }

        public final void wool() {
            this.tags.add(MaterialTags.WOOL_TAG);
        }

        public final void woolCarpet() {
            this.tags.add(MaterialTags.WOOL_CARPETS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001cB\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "smeltable", "oak", "spruce", "birch", "jungle", "acacia", "darkOak", "cherry", "mangrove", "crimson", "warped", "overworldNatural", "Tags", "brokencore-common"})
        @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder\n*L\n189#1:619,2\n*E\n"})
        public static final class LogBuilder<T extends Block> {
            @NotNull
            private final BrokenReg reg;
            @NotNull
            private final Block block;
            @NotNull
            private final HashSet<Tags> tags;

            public LogBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
                Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
                Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
                this.reg = reg;
                this.block = block2;
                this.tags = new HashSet();
            }

            public final void add$brokencore_common() {
                MaterialTags.LOGS_TAG.add(this.reg, this.block);
                Iterable $this$forEach$iv = this.tags;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Tags it = (Tags)element$iv;
                    boolean bl = false;
                    it.add(this.reg, this.block);
                }
            }

            public final void smeltable() {
                this.tags.add(Tags.SMELTABLE);
            }

            public final void oak() {
                this.tags.add(Tags.OAK);
            }

            public final void spruce() {
                this.tags.add(Tags.SPRUCE);
            }

            public final void birch() {
                this.tags.add(Tags.BIRCH);
            }

            public final void jungle() {
                this.tags.add(Tags.JUNGLE);
            }

            public final void acacia() {
                this.tags.add(Tags.ACACIA);
            }

            public final void darkOak() {
                this.tags.add(Tags.DARK_OAK);
            }

            public final void cherry() {
                this.tags.add(Tags.CHERRY);
            }

            public final void mangrove() {
                this.tags.add(Tags.MANGROVE);
            }

            public final void crimson() {
                this.tags.add(Tags.CRIMSON);
            }

            public final void warped() {
                this.tags.add(Tags.WARPED);
            }

            public final void overworldNatural() {
                this.tags.add(Tags.OVERWORLD_NATURAL);
            }

            @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$LogBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "SMELTABLE", "OAK", "SPRUCE", "BIRCH", "JUNGLE", "ACACIA", "DARK_OAK", "MANGROVE", "CHERRY", "CRIMSON", "WARPED", "OVERWORLD_NATURAL", "brokencore-common"})
            private static final class Tags
            extends Enum<Tags>
            implements VanillaBlockTagEnum {
                @Nullable
                private final TagKey<Block> tag;
                public static final /* enum */ Tags SMELTABLE = new Tags((TagKey<Block>)BlockTags.LOGS_THAT_BURN);
                public static final /* enum */ Tags OAK = new Tags((TagKey<Block>)BlockTags.OAK_LOGS);
                public static final /* enum */ Tags SPRUCE = new Tags((TagKey<Block>)BlockTags.SPRUCE_LOGS);
                public static final /* enum */ Tags BIRCH = new Tags((TagKey<Block>)BlockTags.BIRCH_LOGS);
                public static final /* enum */ Tags JUNGLE = new Tags((TagKey<Block>)BlockTags.JUNGLE_LOGS);
                public static final /* enum */ Tags ACACIA = new Tags((TagKey<Block>)BlockTags.ACACIA_LOGS);
                public static final /* enum */ Tags DARK_OAK = new Tags((TagKey<Block>)BlockTags.DARK_OAK_LOGS);
                public static final /* enum */ Tags MANGROVE = new Tags((TagKey<Block>)BlockTags.MANGROVE_LOGS);
                public static final /* enum */ Tags CHERRY = new Tags((TagKey<Block>)BlockTags.CHERRY_LOGS);
                public static final /* enum */ Tags CRIMSON = new Tags((TagKey<Block>)BlockTags.CRIMSON_STEMS);
                public static final /* enum */ Tags WARPED = new Tags((TagKey<Block>)BlockTags.WARPED_STEMS);
                public static final /* enum */ Tags OVERWORLD_NATURAL = new Tags((TagKey<Block>)BlockTags.OVERWORLD_NATURAL_LOGS);
                private static final /* synthetic */ Tags[] $VALUES;
                private static final /* synthetic */ EnumEntries $ENTRIES;

                private Tags(TagKey<Block> tag) {
                    this.tag = tag;
                }

                @Override
                @Nullable
                public TagKey<Block> getTag() {
                    return this.tag;
                }

                public static Tags[] values() {
                    return (Tags[])$VALUES.clone();
                }

                public static Tags valueOf(String value) {
                    return Enum.valueOf(Tags.class, value);
                }

                @NotNull
                public static EnumEntries<Tags> getEntries() {
                    return $ENTRIES;
                }

                static {
                    $VALUES = tagsArray = new Tags[]{Tags.SMELTABLE, Tags.OAK, Tags.SPRUCE, Tags.BIRCH, Tags.JUNGLE, Tags.ACACIA, Tags.DARK_OAK, Tags.MANGROVE, Tags.CHERRY, Tags.CRIMSON, Tags.WARPED, Tags.OVERWORLD_NATURAL};
                    $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
                }
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b \u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MaterialTagsBuilder$MaterialTags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "LOGS_TAG", "BAMBOO_BLOCKS_TAG", "CAVE_VINES_TAG", "CONCRETE_POWDER_TAG", "CORAL_BLOCKS_TAG", "CORAL_PLANTS_TAG", "DIRT_TAG", "FIRE_TAG", "FLOWERS_TAG", "ICE_TAG", "NYLIUM_TAG", "PLANKS_TAG", "SAND_TAG", "SAPLINGS_TAG", "SMALL_FLOWERS_TAG", "SNOW_TAG", "STONE_BRICKS_TAG", "TALL_FLOWERS_TAG", "TERRACOTTA_TAG", "WALL_CORALS_TAG", "WART_BLOCKS_TAG", "WOOL_TAG", "WOOL_CARPETS_TAG", "brokencore-common"})
        private static final class MaterialTags
        extends Enum<MaterialTags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ MaterialTags LOGS_TAG = new MaterialTags((TagKey<Block>)BlockTags.LOGS);
            public static final /* enum */ MaterialTags BAMBOO_BLOCKS_TAG = new MaterialTags((TagKey<Block>)BlockTags.BAMBOO_BLOCKS);
            public static final /* enum */ MaterialTags CAVE_VINES_TAG = new MaterialTags((TagKey<Block>)BlockTags.CAVE_VINES);
            public static final /* enum */ MaterialTags CONCRETE_POWDER_TAG = new MaterialTags((TagKey<Block>)BlockTags.CONCRETE_POWDER);
            public static final /* enum */ MaterialTags CORAL_BLOCKS_TAG = new MaterialTags((TagKey<Block>)BlockTags.CORAL_BLOCKS);
            public static final /* enum */ MaterialTags CORAL_PLANTS_TAG = new MaterialTags((TagKey<Block>)BlockTags.CORAL_PLANTS);
            public static final /* enum */ MaterialTags DIRT_TAG = new MaterialTags((TagKey<Block>)BlockTags.DIRT);
            public static final /* enum */ MaterialTags FIRE_TAG = new MaterialTags((TagKey<Block>)BlockTags.FIRE);
            public static final /* enum */ MaterialTags FLOWERS_TAG = new MaterialTags((TagKey<Block>)BlockTags.FLOWERS);
            public static final /* enum */ MaterialTags ICE_TAG = new MaterialTags((TagKey<Block>)BlockTags.ICE);
            public static final /* enum */ MaterialTags NYLIUM_TAG = new MaterialTags((TagKey<Block>)BlockTags.NYLIUM);
            public static final /* enum */ MaterialTags PLANKS_TAG = new MaterialTags((TagKey<Block>)BlockTags.PLANKS);
            public static final /* enum */ MaterialTags SAND_TAG = new MaterialTags((TagKey<Block>)BlockTags.SAND);
            public static final /* enum */ MaterialTags SAPLINGS_TAG = new MaterialTags((TagKey<Block>)BlockTags.SAPLINGS);
            public static final /* enum */ MaterialTags SMALL_FLOWERS_TAG = new MaterialTags((TagKey<Block>)BlockTags.SMALL_FLOWERS);
            public static final /* enum */ MaterialTags SNOW_TAG = new MaterialTags((TagKey<Block>)BlockTags.SNOW);
            public static final /* enum */ MaterialTags STONE_BRICKS_TAG = new MaterialTags((TagKey<Block>)BlockTags.STONE_BRICKS);
            public static final /* enum */ MaterialTags TALL_FLOWERS_TAG = new MaterialTags((TagKey<Block>)BlockTags.TALL_FLOWERS);
            public static final /* enum */ MaterialTags TERRACOTTA_TAG = new MaterialTags((TagKey<Block>)BlockTags.TERRACOTTA);
            public static final /* enum */ MaterialTags WALL_CORALS_TAG = new MaterialTags((TagKey<Block>)BlockTags.WALL_CORALS);
            public static final /* enum */ MaterialTags WART_BLOCKS_TAG = new MaterialTags((TagKey<Block>)BlockTags.WART_BLOCKS);
            public static final /* enum */ MaterialTags WOOL_TAG = new MaterialTags((TagKey<Block>)BlockTags.WOOL);
            public static final /* enum */ MaterialTags WOOL_CARPETS_TAG = new MaterialTags((TagKey<Block>)BlockTags.WOOL_CARPETS);
            private static final /* synthetic */ MaterialTags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private MaterialTags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static MaterialTags[] values() {
                return (MaterialTags[])$VALUES.clone();
            }

            public static MaterialTags valueOf(String value) {
                return Enum.valueOf(MaterialTags.class, value);
            }

            @NotNull
            public static EnumEntries<MaterialTags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = materialTagsArray = new MaterialTags[]{MaterialTags.LOGS_TAG, MaterialTags.BAMBOO_BLOCKS_TAG, MaterialTags.CAVE_VINES_TAG, MaterialTags.CONCRETE_POWDER_TAG, MaterialTags.CORAL_BLOCKS_TAG, MaterialTags.CORAL_PLANTS_TAG, MaterialTags.DIRT_TAG, MaterialTags.FIRE_TAG, MaterialTags.FLOWERS_TAG, MaterialTags.ICE_TAG, MaterialTags.NYLIUM_TAG, MaterialTags.PLANKS_TAG, MaterialTags.SAND_TAG, MaterialTags.SAPLINGS_TAG, MaterialTags.SMALL_FLOWERS_TAG, MaterialTags.SNOW_TAG, MaterialTags.STONE_BRICKS_TAG, MaterialTags.TALL_FLOWERS_TAG, MaterialTags.TERRACOTTA_TAG, MaterialTags.WALL_CORALS_TAG, MaterialTags.WART_BLOCKS_TAG, MaterialTags.WOOL_TAG, MaterialTags.WOOL_CARPETS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0018B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "air", "banner", "beaconBase", "completesFindTreeTutorial", "portal", "rail", "underwaterBonemealable", "unstableBottomCenter", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder\n*L\n588#1:619,2\n*E\n"})
    public static final class MiscTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public MiscTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void air() {
            this.tags.add(Tags.AIR_TAG);
        }

        public final void banner() {
            this.tags.add(Tags.BANNERS_TAG);
        }

        public final void beaconBase() {
            this.tags.add(Tags.BEACON_BASE_BLOCKS_TAG);
        }

        public final void completesFindTreeTutorial() {
            this.tags.add(Tags.COMPLETES_FIND_TREE_TUTORIAL_TAG);
        }

        public final void portal() {
            this.tags.add(Tags.PORTALS_TAG);
        }

        public final void rail() {
            this.tags.add(Tags.RAILS_TAG);
        }

        public final void underwaterBonemealable() {
            this.tags.add(Tags.UNDERWATER_BONEMEALS_TAG);
        }

        public final void unstableBottomCenter() {
            this.tags.add(Tags.UNSTABLE_BOTTOM_CENTER_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$MiscTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "AIR_TAG", "BANNERS_TAG", "BEACON_BASE_BLOCKS_TAG", "COMPLETES_FIND_TREE_TUTORIAL_TAG", "PORTALS_TAG", "RAILS_TAG", "SHULKER_BOXES_TAG", "UNDERWATER_BONEMEALS_TAG", "UNSTABLE_BOTTOM_CENTER_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags AIR_TAG = new Tags((TagKey<Block>)BlockTags.AIR);
            public static final /* enum */ Tags BANNERS_TAG = new Tags((TagKey<Block>)BlockTags.BANNERS);
            public static final /* enum */ Tags BEACON_BASE_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.BEACON_BASE_BLOCKS);
            public static final /* enum */ Tags COMPLETES_FIND_TREE_TUTORIAL_TAG = new Tags((TagKey<Block>)BlockTags.COMPLETES_FIND_TREE_TUTORIAL);
            public static final /* enum */ Tags PORTALS_TAG = new Tags((TagKey<Block>)BlockTags.PORTALS);
            public static final /* enum */ Tags RAILS_TAG = new Tags((TagKey<Block>)BlockTags.RAILS);
            public static final /* enum */ Tags SHULKER_BOXES_TAG = new Tags((TagKey<Block>)BlockTags.SHULKER_BOXES);
            public static final /* enum */ Tags UNDERWATER_BONEMEALS_TAG = new Tags((TagKey<Block>)BlockTags.UNDERWATER_BONEMEALS);
            public static final /* enum */ Tags UNSTABLE_BOTTOM_CENTER_TAG = new Tags((TagKey<Block>)BlockTags.UNSTABLE_BOTTOM_CENTER);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.AIR_TAG, Tags.BANNERS_TAG, Tags.BEACON_BASE_BLOCKS_TAG, Tags.COMPLETES_FIND_TREE_TUTORIAL_TAG, Tags.PORTALS_TAG, Tags.RAILS_TAG, Tags.SHULKER_BOXES_TAG, Tags.UNDERWATER_BONEMEALS_TAG, Tags.UNSTABLE_BOTTOM_CENTER_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0018B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "coal", "copper", "diamond", "emerald", "gold", "iron", "lapis", "redstone", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder\n*L\n226#1:619,2\n*E\n"})
    public static final class OreTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public OreTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void coal() {
            this.tags.add(Tags.COAL_ORES_TAG);
        }

        public final void copper() {
            this.tags.add(Tags.COPPER_ORES_TAG);
        }

        public final void diamond() {
            this.tags.add(Tags.DIAMOND_ORES_TAG);
        }

        public final void emerald() {
            this.tags.add(Tags.EMERALD_ORES_TAG);
        }

        public final void gold() {
            this.tags.add(Tags.GOLD_ORES_TAG);
        }

        public final void iron() {
            this.tags.add(Tags.IRON_ORES_TAG);
        }

        public final void lapis() {
            this.tags.add(Tags.LAPIS_ORES_TAG);
        }

        public final void redstone() {
            this.tags.add(Tags.REDSTONE_ORES_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$OreTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "COAL_ORES_TAG", "COPPER_ORES_TAG", "DIAMOND_ORES_TAG", "EMERALD_ORES_TAG", "GOLD_ORES_TAG", "IRON_ORES_TAG", "LAPIS_ORES_TAG", "REDSTONE_ORES_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags COAL_ORES_TAG = new Tags((TagKey<Block>)BlockTags.COAL_ORES);
            public static final /* enum */ Tags COPPER_ORES_TAG = new Tags((TagKey<Block>)BlockTags.COPPER_ORES);
            public static final /* enum */ Tags DIAMOND_ORES_TAG = new Tags((TagKey<Block>)BlockTags.DIAMOND_ORES);
            public static final /* enum */ Tags EMERALD_ORES_TAG = new Tags((TagKey<Block>)BlockTags.EMERALD_ORES);
            public static final /* enum */ Tags GOLD_ORES_TAG = new Tags((TagKey<Block>)BlockTags.GOLD_ORES);
            public static final /* enum */ Tags IRON_ORES_TAG = new Tags((TagKey<Block>)BlockTags.IRON_ORES);
            public static final /* enum */ Tags LAPIS_ORES_TAG = new Tags((TagKey<Block>)BlockTags.LAPIS_ORES);
            public static final /* enum */ Tags REDSTONE_ORES_TAG = new Tags((TagKey<Block>)BlockTags.REDSTONE_ORES);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.COAL_ORES_TAG, Tags.COPPER_ORES_TAG, Tags.DIAMOND_ORES_TAG, Tags.EMERALD_ORES_TAG, Tags.GOLD_ORES_TAG, Tags.IRON_ORES_TAG, Tags.LAPIS_ORES_TAG, Tags.REDSTONE_ORES_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0017B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "fence", "slab", "stairs", "wall", "woodenFence", "woodenSlab", "woodenStairs", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder\n*L\n339#1:619,2\n*E\n"})
    public static final class PartialBlockTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public PartialBlockTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void fence() {
            this.tags.add(Tags.FENCES_TAG);
        }

        public final void slab() {
            this.tags.add(Tags.SLABS_TAG);
        }

        public final void stairs() {
            this.tags.add(Tags.STAIRS_TAG);
        }

        public final void wall() {
            this.tags.add(Tags.WALLS_TAG);
        }

        public final void woodenFence() {
            this.tags.add(Tags.WOODEN_FENCES_TAG);
        }

        public final void woodenSlab() {
            this.tags.add(Tags.WOODEN_SLABS_TAG);
        }

        public final void woodenStairs() {
            this.tags.add(Tags.WOODEN_STAIRS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PartialBlockTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "FENCES_TAG", "SLABS_TAG", "STAIRS_TAG", "WALLS_TAG", "WOODEN_FENCES_TAG", "WOODEN_SLABS_TAG", "WOODEN_STAIRS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags FENCES_TAG = new Tags((TagKey<Block>)BlockTags.FENCES);
            public static final /* enum */ Tags SLABS_TAG = new Tags((TagKey<Block>)BlockTags.SLABS);
            public static final /* enum */ Tags STAIRS_TAG = new Tags((TagKey<Block>)BlockTags.STAIRS);
            public static final /* enum */ Tags WALLS_TAG = new Tags((TagKey<Block>)BlockTags.WALLS);
            public static final /* enum */ Tags WOODEN_FENCES_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_FENCES);
            public static final /* enum */ Tags WOODEN_SLABS_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_SLABS);
            public static final /* enum */ Tags WOODEN_STAIRS_TAG = new Tags((TagKey<Block>)BlockTags.WOODEN_STAIRS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.FENCES_TAG, Tags.SLABS_TAG, Tags.STAIRS_TAG, Tags.WALLS_TAG, Tags.WOODEN_FENCES_TAG, Tags.WOODEN_SLABS_TAG, Tags.WOODEN_STAIRS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0016B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "azalea", "bamboo", "mushrooms", "bigDripleaf", "deadBush", "smallDripleaf", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder\n*L\n315#1:619,2\n*E\n"})
    public static final class PlantableOnTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public PlantableOnTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void azalea() {
            this.tags.add(Tags.AZALEA);
        }

        public final void bamboo() {
            this.tags.add(Tags.BAMBOO);
        }

        public final void mushrooms() {
            this.tags.add(Tags.MUSHROOM_GROW_BLOCK_TAG);
        }

        public final void bigDripleaf() {
            this.tags.add(Tags.BIG_DRIPLEAF);
        }

        public final void deadBush() {
            this.tags.add(Tags.DEAD_BUSH);
        }

        public final void smallDripleaf() {
            this.tags.add(Tags.SMALL_DRIPLEAF);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$PlantableOnTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "AZALEA", "BAMBOO", "BIG_DRIPLEAF", "DEAD_BUSH", "MUSHROOM_GROW_BLOCK_TAG", "SMALL_DRIPLEAF", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags AZALEA = new Tags((TagKey<Block>)BlockTags.AZALEA_GROWS_ON);
            public static final /* enum */ Tags BAMBOO = new Tags((TagKey<Block>)BlockTags.BAMBOO_PLANTABLE_ON);
            public static final /* enum */ Tags BIG_DRIPLEAF = new Tags((TagKey<Block>)BlockTags.BIG_DRIPLEAF_PLACEABLE);
            public static final /* enum */ Tags DEAD_BUSH = new Tags((TagKey<Block>)BlockTags.DEAD_BUSH_MAY_PLACE_ON);
            public static final /* enum */ Tags MUSHROOM_GROW_BLOCK_TAG = new Tags((TagKey<Block>)BlockTags.MUSHROOM_GROW_BLOCK);
            public static final /* enum */ Tags SMALL_DRIPLEAF = new Tags((TagKey<Block>)BlockTags.SMALL_DRIPLEAF_PLACEABLE);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.AZALEA, Tags.BAMBOO, Tags.BIG_DRIPLEAF, Tags.DEAD_BUSH, Tags.MUSHROOM_GROW_BLOCK_TAG, Tags.SMALL_DRIPLEAF};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0015B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "ceiling", "standing", "wallHanging", "wallPostOverride", "wall", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder\n*L\n293#1:619,2\n*E\n"})
    public static final class SignTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public SignTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void ceiling() {
            this.tags.add(Tags.CEILING_HANGING_SIGN_TAG);
        }

        public final void standing() {
            this.tags.add(Tags.STANDING_SIGNS_TAG);
        }

        public final void wallHanging() {
            this.tags.add(Tags.WALL_HANGING_SIGNS_TAG);
        }

        public final void wallPostOverride() {
            this.tags.add(Tags.WALL_POST_OVERRIDE_TAG);
        }

        public final void wall() {
            this.tags.add(Tags.WALL_SIGNS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SignTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "CEILING_HANGING_SIGN_TAG", "STANDING_SIGNS_TAG", "WALL_HANGING_SIGNS_TAG", "WALL_POST_OVERRIDE_TAG", "WALL_SIGNS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags CEILING_HANGING_SIGN_TAG = new Tags((TagKey<Block>)BlockTags.CEILING_HANGING_SIGNS);
            public static final /* enum */ Tags STANDING_SIGNS_TAG = new Tags((TagKey<Block>)BlockTags.STANDING_SIGNS);
            public static final /* enum */ Tags WALL_HANGING_SIGNS_TAG = new Tags((TagKey<Block>)BlockTags.WALL_HANGING_SIGNS);
            public static final /* enum */ Tags WALL_POST_OVERRIDE_TAG = new Tags((TagKey<Block>)BlockTags.WALL_POST_OVERRIDE);
            public static final /* enum */ Tags WALL_SIGNS_TAG = new Tags((TagKey<Block>)BlockTags.WALL_SIGNS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.CEILING_HANGING_SIGN_TAG, Tags.STANDING_SIGNS_TAG, Tags.WALL_HANGING_SIGNS_TAG, Tags.WALL_POST_OVERRIDE_TAG, Tags.WALL_SIGNS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "camelSandStepSounds", "belowAndThisStepSoundsPlay", "crystal", "stepSoundsInsideBlock", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder\n*L\n526#1:619,2\n*E\n"})
    public static final class SoundTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public SoundTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void camelSandStepSounds() {
            this.tags.add(Tags.CAMEL_SAND_STEP_SOUND_BLOCKS_TAG);
        }

        public final void belowAndThisStepSoundsPlay() {
            this.tags.add(Tags.COMBINATION_STEP_SOUND_BLOCKS_TAG);
        }

        public final void crystal() {
            this.tags.add(Tags.CRYSTAL_SOUND_BLOCKS_TAG);
        }

        public final void stepSoundsInsideBlock() {
            this.tags.add(Tags.INSIDE_STEP_SOUND_BLOCKS_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SoundTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "CAMEL_SAND_STEP_SOUND_BLOCKS_TAG", "COMBINATION_STEP_SOUND_BLOCKS_TAG", "CRYSTAL_SOUND_BLOCKS_TAG", "INSIDE_STEP_SOUND_BLOCKS_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags CAMEL_SAND_STEP_SOUND_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS);
            public static final /* enum */ Tags COMBINATION_STEP_SOUND_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.COMBINATION_STEP_SOUND_BLOCKS);
            public static final /* enum */ Tags CRYSTAL_SOUND_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.CRYSTAL_SOUND_BLOCKS);
            public static final /* enum */ Tags INSIDE_STEP_SOUND_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.INSIDE_STEP_SOUND_BLOCKS);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.CAMEL_SAND_STEP_SOUND_BLOCKS_TAG, Tags.COMBINATION_STEP_SOUND_BLOCKS_TAG, Tags.CRYSTAL_SOUND_BLOCKS_TAG, Tags.INSIDE_STEP_SOUND_BLOCKS_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001cB\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "animals", "armadillo", "axolotl", "fox", "frog", "goat", "invalidInside", "mobInvalidInside", "mooshroom", "parrot", "rabbit", "wolf", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder\n*L\n254#1:619,2\n*E\n"})
    public static final class SpawnableTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public SpawnableTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void animals() {
            this.tags.add(Tags.ANIMALS);
        }

        public final void armadillo() {
            this.tags.add(Tags.ARMADILLO);
        }

        public final void axolotl() {
            this.tags.add(Tags.AXOLOTL);
        }

        public final void fox() {
            this.tags.add(Tags.FOX);
        }

        public final void frog() {
            this.tags.add(Tags.FROG);
        }

        public final void goat() {
            this.tags.add(Tags.GOAT);
        }

        public final void invalidInside() {
            this.tags.add(Tags.INVALID_INSIDE);
        }

        public final void mobInvalidInside() {
            this.tags.add(Tags.MOB_INVALID_INSIDE);
        }

        public final void mooshroom() {
            this.tags.add(Tags.MOOSHROOM);
        }

        public final void parrot() {
            this.tags.add(Tags.PARROT);
        }

        public final void rabbit() {
            this.tags.add(Tags.RABBIT);
        }

        public final void wolf() {
            this.tags.add(Tags.WOLF);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$SpawnableTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "ANIMALS", "ARMADILLO", "AXOLOTL", "FOX", "FROG", "GOAT", "INVALID_INSIDE", "MOB_INVALID_INSIDE", "MOOSHROOM", "PARROT", "POLAR_BEAR", "RABBIT", "WOLF", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags ANIMALS = new Tags((TagKey<Block>)BlockTags.ANIMALS_SPAWNABLE_ON);
            public static final /* enum */ Tags ARMADILLO = new Tags((TagKey<Block>)BlockTags.ARMADILLO_SPAWNABLE_ON);
            public static final /* enum */ Tags AXOLOTL = new Tags((TagKey<Block>)BlockTags.AXOLOTLS_SPAWNABLE_ON);
            public static final /* enum */ Tags FOX = new Tags((TagKey<Block>)BlockTags.FOXES_SPAWNABLE_ON);
            public static final /* enum */ Tags FROG = new Tags((TagKey<Block>)BlockTags.FROGS_SPAWNABLE_ON);
            public static final /* enum */ Tags GOAT = new Tags((TagKey<Block>)BlockTags.GOATS_SPAWNABLE_ON);
            public static final /* enum */ Tags INVALID_INSIDE = new Tags((TagKey<Block>)BlockTags.INVALID_SPAWN_INSIDE);
            public static final /* enum */ Tags MOB_INVALID_INSIDE = new Tags((TagKey<Block>)BlockTags.PREVENT_MOB_SPAWNING_INSIDE);
            public static final /* enum */ Tags MOOSHROOM = new Tags((TagKey<Block>)BlockTags.MOOSHROOMS_SPAWNABLE_ON);
            public static final /* enum */ Tags PARROT = new Tags((TagKey<Block>)BlockTags.PARROTS_SPAWNABLE_ON);
            public static final /* enum */ Tags POLAR_BEAR = new Tags((TagKey<Block>)BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE);
            public static final /* enum */ Tags RABBIT = new Tags((TagKey<Block>)BlockTags.RABBITS_SPAWNABLE_ON);
            public static final /* enum */ Tags WOLF = new Tags((TagKey<Block>)BlockTags.WOLVES_SPAWNABLE_ON);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.ANIMALS, Tags.ARMADILLO, Tags.AXOLOTL, Tags.FOX, Tags.FROG, Tags.GOAT, Tags.INVALID_INSIDE, Tags.MOB_INVALID_INSIDE, Tags.MOOSHROOM, Tags.PARROT, Tags.POLAR_BEAR, Tags.RABBIT, Tags.WOLF};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u001a\u001bB\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u000f\u001a\u00020\u0010H\u0000\u00a2\u0006\u0002\b\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "miningLevel", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder$MiningLevel;", "tools", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder$ToolType;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "needsDiamond", "needsStone", "needsIron", "pickaxe", "axe", "shovel", "hoe", "sword", "MiningLevel", "ToolType", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder\n*L\n87#1:619,2\n*E\n"})
    public static final class ToolTagsBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private MiningLevel miningLevel;
        @NotNull
        private final HashSet<ToolType> tools;

        public ToolTagsBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.miningLevel = MiningLevel.NONE;
            this.tools = new HashSet();
        }

        public final void add$brokencore_common() {
            this.miningLevel.add(this.reg, this.block);
            Iterable $this$forEach$iv = this.tools;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ToolType it = (ToolType)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void needsDiamond() {
            this.miningLevel = MiningLevel.DIAMOND;
        }

        public final void needsStone() {
            this.miningLevel = MiningLevel.STONE;
        }

        public final void needsIron() {
            this.miningLevel = MiningLevel.IRON;
        }

        public final void pickaxe() {
            this.tools.add(ToolType.PICKAXE);
        }

        public final void axe() {
            this.tools.add(ToolType.AXE);
        }

        public final void shovel() {
            this.tools.add(ToolType.SHOVEL);
        }

        public final void hoe() {
            this.tools.add(ToolType.HOE);
        }

        public final void sword() {
            this.tools.add(ToolType.SWORD);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder$MiningLevel;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "NONE", "STONE", "IRON", "DIAMOND", "WOODEN_INVALID", "STONE_INVALID_INVALID", "IRON_INVALID", "GOLD_INVALID", "DIAMOND_INVALID", "NETHERITE_INVALID", "brokencore-common"})
        private static final class MiningLevel
        extends Enum<MiningLevel>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ MiningLevel NONE = new MiningLevel(null);
            public static final /* enum */ MiningLevel STONE = new MiningLevel((TagKey<Block>)BlockTags.NEEDS_STONE_TOOL);
            public static final /* enum */ MiningLevel IRON = new MiningLevel((TagKey<Block>)BlockTags.NEEDS_IRON_TOOL);
            public static final /* enum */ MiningLevel DIAMOND = new MiningLevel((TagKey<Block>)BlockTags.NEEDS_DIAMOND_TOOL);
            public static final /* enum */ MiningLevel WOODEN_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_WOODEN_TOOL);
            public static final /* enum */ MiningLevel STONE_INVALID_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_STONE_TOOL);
            public static final /* enum */ MiningLevel IRON_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_IRON_TOOL);
            public static final /* enum */ MiningLevel GOLD_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_GOLD_TOOL);
            public static final /* enum */ MiningLevel DIAMOND_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
            public static final /* enum */ MiningLevel NETHERITE_INVALID = new MiningLevel((TagKey<Block>)BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
            private static final /* synthetic */ MiningLevel[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private MiningLevel(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static MiningLevel[] values() {
                return (MiningLevel[])$VALUES.clone();
            }

            public static MiningLevel valueOf(String value) {
                return Enum.valueOf(MiningLevel.class, value);
            }

            @NotNull
            public static EnumEntries<MiningLevel> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = miningLevelArray = new MiningLevel[]{MiningLevel.NONE, MiningLevel.STONE, MiningLevel.IRON, MiningLevel.DIAMOND, MiningLevel.WOODEN_INVALID, MiningLevel.STONE_INVALID_INVALID, MiningLevel.IRON_INVALID, MiningLevel.GOLD_INVALID, MiningLevel.DIAMOND_INVALID, MiningLevel.NETHERITE_INVALID};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$ToolTagsBuilder$ToolType;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "PICKAXE", "AXE", "SHOVEL", "HOE", "SWORD", "brokencore-common"})
        private static final class ToolType
        extends Enum<ToolType>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ ToolType PICKAXE = new ToolType((TagKey<Block>)BlockTags.MINEABLE_WITH_PICKAXE);
            public static final /* enum */ ToolType AXE = new ToolType((TagKey<Block>)BlockTags.MINEABLE_WITH_AXE);
            public static final /* enum */ ToolType SHOVEL = new ToolType((TagKey<Block>)BlockTags.MINEABLE_WITH_SHOVEL);
            public static final /* enum */ ToolType HOE = new ToolType((TagKey<Block>)BlockTags.MINEABLE_WITH_HOE);
            public static final /* enum */ ToolType SWORD = new ToolType((TagKey<Block>)BlockTags.SWORD_EFFICIENT);
            private static final /* synthetic */ ToolType[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private ToolType(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static ToolType[] values() {
                return (ToolType[])$VALUES.clone();
            }

            public static ToolType valueOf(String value) {
                return Enum.valueOf(ToolType.class, value);
            }

            @NotNull
            public static EnumEntries<ToolType> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = toolTypeArray = new ToolType[]{ToolType.PICKAXE, ToolType.AXE, ToolType.SHOVEL, ToolType.HOE, ToolType.SWORD};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Marker
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001fB\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder;", "T", "Lnet/minecraft/world/level/block/Block;", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/world/level/block/Block;)V", "tags", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder$Tags;", "Lkotlin/collections/HashSet;", "add", "", "add$brokencore_common", "ancientCityReplaceable", "azaleaRootReplaceable", "badlandsTerracotta", "baseStoneOverworld", "baseStoneNether", "deepslateOreReplaceable", "dripstoneReplaceable", "featureIrreplaceable", "geodeInvalid", "lushGroundReplaceable", "netherCarverReplaceable", "overworldCarverReplaceable", "skulkReplaceable", "stoneOreReplaceable", "trailRuinsReplaceable", "Tags", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBlockTagsBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1869#2,2:619\n*S KotlinDebug\n*F\n+ 1 BlockTagsBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder\n*L\n365#1:619,2\n*E\n"})
    public static final class WorldGenTagBuilder<T extends Block> {
        @NotNull
        private final BrokenReg reg;
        @NotNull
        private final Block block;
        @NotNull
        private final HashSet<Tags> tags;

        public WorldGenTagBuilder(@NotNull BrokenReg reg, @NotNull Block block2) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
            Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
            this.reg = reg;
            this.block = block2;
            this.tags = new HashSet();
        }

        public final void add$brokencore_common() {
            Iterable $this$forEach$iv = this.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tags it = (Tags)element$iv;
                boolean bl = false;
                it.add(this.reg, this.block);
            }
        }

        public final void ancientCityReplaceable() {
            this.tags.add(Tags.ANCIENT_CITY_REPLACEABLE_TAG);
        }

        public final void azaleaRootReplaceable() {
            this.tags.add(Tags.AZALEA_ROOT_REPLACEABLE_TAG);
        }

        public final void badlandsTerracotta() {
            this.tags.add(Tags.BADLANDS_TERRACOTTA_TAG);
        }

        public final void baseStoneOverworld() {
            this.tags.add(Tags.BASE_STONE_OVERWORLD_TAG);
        }

        public final void baseStoneNether() {
            this.tags.add(Tags.BASE_STONE_NETHER_TAG);
        }

        public final void deepslateOreReplaceable() {
            this.tags.add(Tags.DEEPSLATE_ORE_REPLACEABLES_TAG);
        }

        public final void dripstoneReplaceable() {
            this.tags.add(Tags.DRIPSTONE_REPLACEABLE_TAG);
        }

        public final void featureIrreplaceable() {
            this.tags.add(Tags.FEATURES_CANNOT_REPLACE_TAG);
        }

        public final void geodeInvalid() {
            this.tags.add(Tags.GEODE_INVALID_BLOCKS_TAG);
        }

        public final void lushGroundReplaceable() {
            this.tags.add(Tags.LUSH_GROUND_REPLACEABLE_TAG);
        }

        public final void netherCarverReplaceable() {
            this.tags.add(Tags.NETHER_CARVER_REPLACEABLES_TAG);
        }

        public final void overworldCarverReplaceable() {
            this.tags.add(Tags.OVERWORLD_CARVER_REPLACEABLES_TAG);
        }

        public final void skulkReplaceable() {
            this.tags.add(Tags.SKULK_REPLACEABLE_WORLDGEN_TAG);
        }

        public final void stoneOreReplaceable() {
            this.tags.add(Tags.STONE_ORE_REPLACEABLE_TAG);
        }

        public final void trailRuinsReplaceable() {
            this.tags.add(Tags.TRAIL_RUINS_REPLACEABLE_TAG);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder$WorldGenTagBuilder$Tags;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "<init>", "(Ljava/lang/String;ILnet/minecraft/tags/TagKey;)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "ANCIENT_CITY_REPLACEABLE_TAG", "AZALEA_ROOT_REPLACEABLE_TAG", "BADLANDS_TERRACOTTA_TAG", "BASE_STONE_OVERWORLD_TAG", "BASE_STONE_NETHER_TAG", "DEEPSLATE_ORE_REPLACEABLES_TAG", "DRIPSTONE_REPLACEABLE_TAG", "FEATURES_CANNOT_REPLACE_TAG", "GEODE_INVALID_BLOCKS_TAG", "LUSH_GROUND_REPLACEABLE_TAG", "NETHER_CARVER_REPLACEABLES_TAG", "OVERWORLD_CARVER_REPLACEABLES_TAG", "SKULK_REPLACEABLE_WORLDGEN_TAG", "STONE_ORE_REPLACEABLE_TAG", "TRAIL_RUINS_REPLACEABLE_TAG", "brokencore-common"})
        private static final class Tags
        extends Enum<Tags>
        implements VanillaBlockTagEnum {
            @Nullable
            private final TagKey<Block> tag;
            public static final /* enum */ Tags ANCIENT_CITY_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.ANCIENT_CITY_REPLACEABLE);
            public static final /* enum */ Tags AZALEA_ROOT_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.AZALEA_ROOT_REPLACEABLE);
            public static final /* enum */ Tags BADLANDS_TERRACOTTA_TAG = new Tags((TagKey<Block>)BlockTags.BADLANDS_TERRACOTTA);
            public static final /* enum */ Tags BASE_STONE_OVERWORLD_TAG = new Tags((TagKey<Block>)BlockTags.BASE_STONE_OVERWORLD);
            public static final /* enum */ Tags BASE_STONE_NETHER_TAG = new Tags((TagKey<Block>)BlockTags.BASE_STONE_NETHER);
            public static final /* enum */ Tags DEEPSLATE_ORE_REPLACEABLES_TAG = new Tags((TagKey<Block>)BlockTags.DEEPSLATE_ORE_REPLACEABLES);
            public static final /* enum */ Tags DRIPSTONE_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.DRIPSTONE_REPLACEABLE);
            public static final /* enum */ Tags FEATURES_CANNOT_REPLACE_TAG = new Tags((TagKey<Block>)BlockTags.FEATURES_CANNOT_REPLACE);
            public static final /* enum */ Tags GEODE_INVALID_BLOCKS_TAG = new Tags((TagKey<Block>)BlockTags.GEODE_INVALID_BLOCKS);
            public static final /* enum */ Tags LUSH_GROUND_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.LUSH_GROUND_REPLACEABLE);
            public static final /* enum */ Tags NETHER_CARVER_REPLACEABLES_TAG = new Tags((TagKey<Block>)BlockTags.NETHER_CARVER_REPLACEABLES);
            public static final /* enum */ Tags OVERWORLD_CARVER_REPLACEABLES_TAG = new Tags((TagKey<Block>)BlockTags.OVERWORLD_CARVER_REPLACEABLES);
            public static final /* enum */ Tags SKULK_REPLACEABLE_WORLDGEN_TAG = new Tags((TagKey<Block>)BlockTags.SCULK_REPLACEABLE_WORLD_GEN);
            public static final /* enum */ Tags STONE_ORE_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.STONE_ORE_REPLACEABLES);
            public static final /* enum */ Tags TRAIL_RUINS_REPLACEABLE_TAG = new Tags((TagKey<Block>)BlockTags.TRAIL_RUINS_REPLACEABLE);
            private static final /* synthetic */ Tags[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Tags(TagKey<Block> tag) {
                this.tag = tag;
            }

            @Override
            @Nullable
            public TagKey<Block> getTag() {
                return this.tag;
            }

            public static Tags[] values() {
                return (Tags[])$VALUES.clone();
            }

            public static Tags valueOf(String value) {
                return Enum.valueOf(Tags.class, value);
            }

            @NotNull
            public static EnumEntries<Tags> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = tagsArray = new Tags[]{Tags.ANCIENT_CITY_REPLACEABLE_TAG, Tags.AZALEA_ROOT_REPLACEABLE_TAG, Tags.BADLANDS_TERRACOTTA_TAG, Tags.BASE_STONE_OVERWORLD_TAG, Tags.BASE_STONE_NETHER_TAG, Tags.DEEPSLATE_ORE_REPLACEABLES_TAG, Tags.DRIPSTONE_REPLACEABLE_TAG, Tags.FEATURES_CANNOT_REPLACE_TAG, Tags.GEODE_INVALID_BLOCKS_TAG, Tags.LUSH_GROUND_REPLACEABLE_TAG, Tags.NETHER_CARVER_REPLACEABLES_TAG, Tags.OVERWORLD_CARVER_REPLACEABLES_TAG, Tags.SKULK_REPLACEABLE_WORLDGEN_TAG, Tags.STONE_ORE_REPLACEABLE_TAG, Tags.TRAIL_RUINS_REPLACEABLE_TAG};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }
}


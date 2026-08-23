/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.biome.Biome
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.ext.KFuncExt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.biomeSpawns.IBiomeSpawns;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientEntityHandler;
import net.thebrokenscript.brokencore.api.registry.handlers.EntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.impl.registry.BCTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u000220\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0003:\u0001?B7\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001e\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00172\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0007J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0007J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190)J2\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/J$\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/J\u001e\u00102\u001a\u00020\u0014\"\b\b\u0001\u00103*\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H306J\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u00108\u001a\u00020\u00142\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0014J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J \u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040=H\u0016J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\\\u0010 \u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001f0\u0013\u0018\u00010\u00162\"\u0010\u001d\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001f0\u0013\u0018\u00010\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder;", "T", "Lnet/minecraft/world/entity/Entity;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/minecraft/world/entity/EntityType;", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function2;", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "biomeSpawnData", "", "Lnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder$SpawnData;", "clientRegisterCallback", "Lkotlin/Function1;", "", "attrs", "Lkotlin/Function0;", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "props", "Lnet/minecraft/world/entity/EntityType$Builder;", "category", "Lnet/minecraft/world/entity/MobCategory;", "lang", "value", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "Lnet/minecraft/client/renderer/entity/EntityRenderer;", "renderer", "getRenderer", "()Lkotlin/jvm/functions/Function0;", "setRenderer", "(Lkotlin/jvm/functions/Function0;)V", "spawns", "Lnet/minecraft/core/Holder;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "block", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "biomeSpawn", "biomeTag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/biome/Biome;", "weight", "", "minCount", "maxCount", "brain", "E", "Lnet/minecraft/world/entity/LivingEntity;", "builtBrain", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "noLang", "onRegistered", "entry", "createObject", "createEntry", "key", "Lnet/minecraft/resources/ResourceKey;", "register", "SpawnData", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEntityBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,176:1\n1#2:177\n1869#3,2:178\n*S KotlinDebug\n*F\n+ 1 EntityBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder\n*L\n159#1:178,2\n*E\n"})
public class EntityBuilder<T extends Entity>
extends AbstractBuilder<EntityBuilder<T>, EntityType<?>, EntityType<T>, EntityEntry<T>> {
    @NotNull
    private final Function2<EntityType<T>, Level, T> ctor;
    @NotNull
    private final List<SpawnData> biomeSpawnData;
    @NotNull
    private Function1<? super EntityEntry<T>, Unit> clientRegisterCallback;
    @NotNull
    private Function0<? extends AttributeSupplier.Builder> attrs;
    @NotNull
    private Function0<? extends EntityType.Builder<T>> props;
    @JvmField
    @NotNull
    public MobCategory category;
    @JvmField
    @Nullable
    public String lang;
    @JvmField
    @Nullable
    public Holder<SpawnConditions> spawns;

    public EntityBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function2<? super EntityType<T>, ? super Level, ? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        ResourceKey resourceKey = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"ENTITY_TYPE");
        super(parent, resourceKey, name);
        this.ctor = ctor;
        this.biomeSpawnData = new ArrayList();
        this.clientRegisterCallback = EntityBuilder::clientRegisterCallback$lambda$0;
        this.attrs = EntityBuilder::attrs$lambda$0;
        this.props = () -> EntityBuilder.props$lambda$0(this);
        this.category = MobCategory.MISC;
        this.lang = LangUtil.INSTANCE.getAutomaticName(this.getId());
    }

    @Nullable
    public final Function0<Function1<EntityRendererProvider.Context, EntityRenderer<? super T>>> getRenderer() {
        return null;
    }

    public final void setRenderer(@Nullable Function0<? extends Function1<? super EntityRendererProvider.Context, ? extends EntityRenderer<? super T>>> value) {
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> EntityBuilder._set_renderer_$lambda$0(this, value)));
    }

    @JvmOverloads
    @NotNull
    public final EntityBuilder<T> attrs(@NotNull AttributeSupplier.Builder attrs, @NotNull InstanceConsumer<AttributeSupplier.Builder> block2) {
        Intrinsics.checkNotNullParameter((Object)attrs, (String)"attrs");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return this.attrs((Function0<AttributeSupplier.Builder>)((Function0)() -> EntityBuilder.attrs$lambda$2(attrs)), block2);
    }

    public static /* synthetic */ EntityBuilder attrs$default(EntityBuilder entityBuilder, AttributeSupplier.Builder builder, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attrs");
        }
        if ((n & 2) != 0) {
            instanceConsumer = EntityBuilder::attrs$lambda$1;
        }
        return entityBuilder.attrs(builder, instanceConsumer);
    }

    @JvmOverloads
    @NotNull
    public final EntityBuilder<T> attrs(@NotNull Function0<? extends AttributeSupplier.Builder> attrs, @NotNull InstanceConsumer<AttributeSupplier.Builder> block2) {
        EntityBuilder entityBuilder;
        Intrinsics.checkNotNullParameter(attrs, (String)"attrs");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        EntityBuilder $this$attrs_u24lambda_u244 = entityBuilder = this;
        boolean bl = false;
        $this$attrs_u24lambda_u244.attrs = KFuncExt.INSTANCE.chainApplyConsumer(attrs, block2);
        return entityBuilder;
    }

    public static /* synthetic */ EntityBuilder attrs$default(EntityBuilder entityBuilder, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attrs");
        }
        if ((n & 2) != 0) {
            instanceConsumer = EntityBuilder::attrs$lambda$3;
        }
        return entityBuilder.attrs((Function0<AttributeSupplier.Builder>)function0, instanceConsumer);
    }

    @NotNull
    public final EntityBuilder<T> attrs(@NotNull InstanceConsumer<AttributeSupplier.Builder> block2) {
        EntityBuilder entityBuilder;
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        EntityBuilder $this$attrs_u24lambda_u245 = entityBuilder = this;
        boolean bl = false;
        $this$attrs_u24lambda_u245.attrs = KFuncExt.INSTANCE.chainApplyConsumer($this$attrs_u24lambda_u245.attrs, block2);
        return entityBuilder;
    }

    @NotNull
    public final EntityBuilder<T> props(@NotNull InstanceConsumer<EntityType.Builder<T>> block2) {
        EntityBuilder entityBuilder;
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        EntityBuilder $this$props_u24lambda_u241 = entityBuilder = this;
        boolean bl = false;
        $this$props_u24lambda_u241.props = KFuncExt.INSTANCE.chainApplyConsumer($this$props_u24lambda_u241.props, block2);
        return entityBuilder;
    }

    @NotNull
    public final EntityBuilder<T> biomeSpawn(@NotNull TagKey<Biome> biomeTag, int weight, int minCount, int maxCount) {
        EntityBuilder entityBuilder;
        Intrinsics.checkNotNullParameter(biomeTag, (String)"biomeTag");
        EntityBuilder $this$biomeSpawn_u24lambda_u240 = entityBuilder = this;
        boolean bl = false;
        $this$biomeSpawn_u24lambda_u240.biomeSpawnData.add(new SpawnData(biomeTag, weight, minCount, maxCount));
        return entityBuilder;
    }

    @NotNull
    public final EntityBuilder<T> biomeSpawn(int weight, int minCount, int maxCount) {
        EntityBuilder entityBuilder;
        EntityBuilder $this$biomeSpawn_u24lambda_u241 = entityBuilder = this;
        boolean bl = false;
        $this$biomeSpawn_u24lambda_u241.biomeSpawnData.add(new SpawnData(BCTags.ANY_BIOME, weight, minCount, maxCount));
        return entityBuilder;
    }

    public final <E extends LivingEntity> void brain(@NotNull BuiltBrain<E> builtBrain) {
        Intrinsics.checkNotNullParameter(builtBrain, (String)"builtBrain");
        if (!PlatformUtil.Companion.isDataGen()) {
            builtBrain.register();
        }
    }

    @NotNull
    public final EntityBuilder<T> noLang() {
        EntityBuilder entityBuilder;
        EntityBuilder $this$noLang_u24lambda_u240 = entityBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.lang = null;
        return entityBuilder;
    }

    @Override
    protected void onRegistered(@NotNull EntityEntry<T> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        PlatformUtil.Companion.runWhenOn(Side.CLIENT, (Function0<? extends Function0<Unit>>)((Function0)() -> EntityBuilder.onRegistered$lambda$0(this, entry)));
        Holder<SpawnConditions> holder = this.spawns;
        if (holder != null) {
            Holder<SpawnConditions> it = holder;
            boolean bl = false;
            EntityHandler.INSTANCE.getSpawns$brokencore_common().put(entry, new Function0<SpawnConditions>(it){

                public final SpawnConditions invoke() {
                    return (SpawnConditions)((Holder)this.receiver).value();
                }
            });
        }
        Function0<? extends AttributeSupplier.Builder> it = this.attrs;
        boolean bl = false;
        EntityHandler.INSTANCE.getAttrs$brokencore_common().put(entry, it);
        Iterable $this$forEach$iv = this.biomeSpawnData;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SpawnData data2 = (SpawnData)element$iv;
            boolean bl2 = false;
            this.getParent().getBiomeSpawns().add(new IBiomeSpawns(data2, entry){
                private final TagKey<Biome> spawnBiomeTag;
                private final int spawnWeight;
                private final int spawnMinCount;
                private final int spawnMaxCount;
                final /* synthetic */ EntityEntry<T> $entry;
                {
                    this.$entry = $entry;
                    this.spawnBiomeTag = $data.getTag();
                    this.spawnWeight = $data.getWeight();
                    this.spawnMinCount = $data.getMin();
                    this.spawnMaxCount = $data.getMax();
                }

                public TagKey<Biome> getSpawnBiomeTag() {
                    return this.spawnBiomeTag;
                }

                public int getSpawnWeight() {
                    return this.spawnWeight;
                }

                public int getSpawnMinCount() {
                    return this.spawnMinCount;
                }

                public int getSpawnMaxCount() {
                    return this.spawnMaxCount;
                }

                public EntityType<T> entityType() {
                    return (EntityType)this.$entry.get();
                }
            });
        }
    }

    @Override
    @NotNull
    protected EntityType<T> createObject() {
        EntityType entityType = ((EntityType.Builder)this.props.invoke()).build(this.getName());
        Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"build(...)");
        return entityType;
    }

    @Override
    @NotNull
    public EntityEntry<T> createEntry(@NotNull ResourceKey<EntityType<?>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new EntityEntry(key);
    }

    @Override
    @NotNull
    public EntityEntry<T> register() {
        Object e;
        block0: {
            e = super.register();
            EntityEntry it = (EntityEntry)e;
            boolean bl = false;
            String string = this.lang;
            if (string == null) break block0;
            String it2 = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set("entity." + this.getParent().getModId() + "." + this.getName(), it2);
        }
        return (EntityEntry)e;
    }

    @JvmOverloads
    @NotNull
    public final EntityBuilder<T> attrs(@NotNull AttributeSupplier.Builder attrs) {
        Intrinsics.checkNotNullParameter((Object)attrs, (String)"attrs");
        return EntityBuilder.attrs$default(this, attrs, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final EntityBuilder<T> attrs(@NotNull Function0<? extends AttributeSupplier.Builder> attrs) {
        Intrinsics.checkNotNullParameter(attrs, (String)"attrs");
        return EntityBuilder.attrs$default(this, attrs, null, 2, null);
    }

    private static final Unit clientRegisterCallback$lambda$0(EntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final AttributeSupplier.Builder attrs$lambda$0() {
        return new AttributeSupplier.Builder();
    }

    private static final EntityType.Builder props$lambda$0(EntityBuilder this$0) {
        return EntityType.Builder.of((arg_0, arg_1) -> EntityBuilder.props$lambda$0$0(this$0.ctor, arg_0, arg_1), (MobCategory)this$0.category);
    }

    private static final Entity props$lambda$0$0(Function2 $tmp0, EntityType p0, Level p1) {
        return (Entity)$tmp0.invoke((Object)p0, (Object)p1);
    }

    private static final Function0 _set_renderer_$lambda$0(EntityBuilder this$0, Function0 $value) {
        return () -> EntityBuilder._set_renderer_$lambda$0$0(this$0, $value);
    }

    private static final Unit _set_renderer_$lambda$0$0(EntityBuilder this$0, Function0 $value) {
        Function0 function0 = $value;
        this$0.clientRegisterCallback = function0 != null ? arg_0 -> EntityBuilder._set_renderer_$lambda$0$0$0(function0, arg_0) : EntityBuilder::_set_renderer_$lambda$0$0$1;
        return Unit.INSTANCE;
    }

    private static final Unit _set_renderer_$lambda$0$0$0(Function0 $value, EntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ClientEntityHandler.INSTANCE.getRenderers$brokencore_common().add(new ClientEntityHandler.EntityRendererInfo(it, () -> EntityBuilder._set_renderer_$lambda$0$0$0$0($value)));
        return Unit.INSTANCE;
    }

    private static final EntityRendererProvider _set_renderer_$lambda$0$0$0$0(Function0 $value) {
        return arg_0 -> EntityBuilder._set_renderer_$lambda$0$0$0$0$0($value, arg_0);
    }

    private static final EntityRenderer _set_renderer_$lambda$0$0$0$0$0(Function0 $value, EntityRendererProvider.Context cx) {
        Function1 function1 = (Function1)$value.invoke();
        Intrinsics.checkNotNull((Object)cx);
        Object object = function1.invoke((Object)cx);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type net.minecraft.client.renderer.entity.EntityRenderer<T of net.thebrokenscript.brokencore.api.registry.builders.EntityBuilder>");
        return (EntityRenderer)object;
    }

    private static final Unit _set_renderer_$lambda$0$0$1(EntityEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final void attrs$lambda$1(AttributeSupplier.Builder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final AttributeSupplier.Builder attrs$lambda$2(AttributeSupplier.Builder $attrs) {
        return $attrs;
    }

    private static final void attrs$lambda$3(AttributeSupplier.Builder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final Function0 onRegistered$lambda$0(EntityBuilder this$0, EntityEntry $entry) {
        return () -> EntityBuilder.onRegistered$lambda$0$0(this$0, $entry);
    }

    private static final Unit onRegistered$lambda$0$0(EntityBuilder this$0, EntityEntry $entry) {
        this$0.clientRegisterCallback.invoke((Object)$entry);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder$SpawnData;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/biome/Biome;", "weight", "", "min", "max", "<init>", "(Lnet/minecraft/tags/TagKey;III)V", "getTag", "()Lnet/minecraft/tags/TagKey;", "getWeight", "()I", "getMin", "getMax", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "brokencore-common"})
    private static final class SpawnData {
        @NotNull
        private final TagKey<Biome> tag;
        private final int weight;
        private final int min;
        private final int max;

        public SpawnData(@NotNull TagKey<Biome> tag, int weight, int min, int max) {
            Intrinsics.checkNotNullParameter(tag, (String)"tag");
            this.tag = tag;
            this.weight = weight;
            this.min = min;
            this.max = max;
        }

        @NotNull
        public final TagKey<Biome> getTag() {
            return this.tag;
        }

        public final int getWeight() {
            return this.weight;
        }

        public final int getMin() {
            return this.min;
        }

        public final int getMax() {
            return this.max;
        }

        @NotNull
        public final TagKey<Biome> component1() {
            return this.tag;
        }

        public final int component2() {
            return this.weight;
        }

        public final int component3() {
            return this.min;
        }

        public final int component4() {
            return this.max;
        }

        @NotNull
        public final SpawnData copy(@NotNull TagKey<Biome> tag, int weight, int min, int max) {
            Intrinsics.checkNotNullParameter(tag, (String)"tag");
            return new SpawnData(tag, weight, min, max);
        }

        public static /* synthetic */ SpawnData copy$default(SpawnData spawnData, TagKey tagKey, int n, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                tagKey = spawnData.tag;
            }
            if ((n4 & 2) != 0) {
                n = spawnData.weight;
            }
            if ((n4 & 4) != 0) {
                n2 = spawnData.min;
            }
            if ((n4 & 8) != 0) {
                n3 = spawnData.max;
            }
            return spawnData.copy(tagKey, n, n2, n3);
        }

        @NotNull
        public String toString() {
            return "SpawnData(tag=" + this.tag + ", weight=" + this.weight + ", min=" + this.min + ", max=" + this.max + ")";
        }

        public int hashCode() {
            int result = this.tag.hashCode();
            result = result * 31 + Integer.hashCode(this.weight);
            result = result * 31 + Integer.hashCode(this.min);
            result = result * 31 + Integer.hashCode(this.max);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpawnData)) {
                return false;
            }
            SpawnData spawnData = (SpawnData)other;
            if (!Intrinsics.areEqual(this.tag, spawnData.tag)) {
                return false;
            }
            if (this.weight != spawnData.weight) {
                return false;
            }
            if (this.min != spawnData.min) {
                return false;
            }
            return this.max == spawnData.max;
        }
    }
}


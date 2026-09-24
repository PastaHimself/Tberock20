/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.Encoder
 *  com.mojang.serialization.JsonOps
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.advancements.Advancement
 *  net.minecraft.advancements.Advancement$Builder
 *  net.minecraft.advancements.AdvancementType
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.advancements.Criterion
 *  net.minecraft.advancements.CriterionTriggerInstance
 *  net.minecraft.advancements.DisplayInfo
 *  net.minecraft.advancements.critereon.ImpossibleTrigger$TriggerInstance
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.thebrokenscript.brokencore.api.datagen.data.ConstructedAssetManager;
import net.thebrokenscript.brokencore.api.ext.CodecExt;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u0000J\b\u0010\u001f\u001a\u00020\u0002H\u0014J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020!H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/AdvancementBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "Lnet/minecraft/advancements/Advancement;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;)V", "title", "desc", "icon", "Lkotlin/Function0;", "Lnet/minecraft/world/item/ItemStack;", "background", "Lnet/minecraft/resources/ResourceLocation;", "type", "Lnet/minecraft/advancements/AdvancementType;", "showToast", "", "announceChat", "hidden", "criteria", "", "Lnet/minecraft/advancements/Criterion;", "titleLang", "getTitleLang", "()Ljava/lang/String;", "descLang", "getDescLang", "noLang", "createObject", "register", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAdvancementBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdvancementBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/AdvancementBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class AdvancementBuilder
extends SimpleBuilder<AdvancementBuilder, Advancement> {
    @JvmField
    @Nullable
    public String title;
    @JvmField
    @Nullable
    public String desc;
    @JvmField
    @NotNull
    public Function0<ItemStack> icon;
    @JvmField
    @Nullable
    public ResourceLocation background;
    @JvmField
    @NotNull
    public AdvancementType type;
    @JvmField
    public boolean showToast;
    @JvmField
    public boolean announceChat;
    @JvmField
    public boolean hidden;
    @JvmField
    @NotNull
    public Map<String, Criterion<?>> criteria;

    public AdvancementBuilder(@NotNull BrokenReg parent, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceKey resourceKey = Registries.ADVANCEMENT;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"ADVANCEMENT");
        super(parent, resourceKey, name);
        this.title = LangUtil.INSTANCE.getAutomaticName(this.getId());
        this.icon = AdvancementBuilder::icon$lambda$0;
        this.type = AdvancementType.TASK;
        this.showToast = true;
        this.announceChat = true;
        this.criteria = new LinkedHashMap();
    }

    private final String getTitleLang() {
        return "advancement." + this.getId().getNamespace() + "." + this.getId().getPath() + ".title";
    }

    private final String getDescLang() {
        return "advancement." + this.getId().getNamespace() + "." + this.getId().getPath() + ".desc";
    }

    @NotNull
    public final AdvancementBuilder noLang() {
        AdvancementBuilder advancementBuilder;
        AdvancementBuilder $this$noLang_u24lambda_u240 = advancementBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.title = null;
        $this$noLang_u24lambda_u240.desc = null;
        return advancementBuilder;
    }

    @Override
    @NotNull
    protected Advancement createObject() {
        Advancement.Builder builder;
        Advancement.Builder $this$createObject_u24lambda_u240 = builder = new Advancement.Builder().display(new DisplayInfo((ItemStack)this.icon.invoke(), (Component)Component.translatable((String)this.getTitleLang()), (Component)Component.translatable((String)this.getDescLang()), Optional.ofNullable(this.background), this.type, this.showToast, this.announceChat, this.hidden));
        boolean bl = false;
        if (this.criteria.isEmpty()) {
            this.criteria.put("_empty", CriteriaTriggers.IMPOSSIBLE.createCriterion((CriterionTriggerInstance)new ImpossibleTrigger.TriggerInstance()));
        }
        for (Map.Entry<String, Criterion<?>> entry : this.criteria.entrySet()) {
            String k = entry.getKey();
            Criterion<?> v = entry.getValue();
            $this$createObject_u24lambda_u240.addCriterion(k, v);
        }
        Advancement advancement = builder.build(this.getId()).value();
        Intrinsics.checkNotNullExpressionValue((Object)advancement, (String)"value(...)");
        return advancement;
    }

    @Override
    @NotNull
    public RegistryEntry<Advancement, Advancement> register() {
        String it;
        Object e;
        Object it2 = e = super.register();
        boolean bl = false;
        String string = this.title;
        if (string != null) {
            it = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set(this.getTitleLang(), it);
        }
        String string2 = this.desc;
        if (string2 != null) {
            it = string2;
            boolean bl3 = false;
            this.getParent().getData().getLang().set(this.getDescLang(), it);
        }
        this.getParent().getData().getAdvancements().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> AdvancementBuilder.register$lambda$0$2(this, arg_0)));
        return e;
    }

    private static final ItemStack icon$lambda$0() {
        return Items.STONE.getDefaultInstance();
    }

    private static final Unit register$lambda$0$2(AdvancementBuilder this$0, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ConstructedAssetManager constructedAssetManager = this$0.getParent().getData().getAdvancements();
        Pair[] pairArray = new Pair[1];
        String string = "data/" + this$0.getId().getNamespace() + "/advancement/" + this$0.getId().getPath() + ".json";
        Codec codec = Advancement.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"CODEC");
        Encoder encoder = (Encoder)codec;
        JsonOps jsonOps = JsonOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)jsonOps, (String)"INSTANCE");
        pairArray[0] = TuplesKt.to((Object)string, CodecExt.INSTANCE.encodeOrThrow(encoder, (DynamicOps)jsonOps, this$0.createObject()));
        constructedAssetManager.accept(pairArray);
        return Unit.INSTANCE;
    }
}


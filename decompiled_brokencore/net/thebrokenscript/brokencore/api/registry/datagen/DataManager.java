/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.datagen;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.datagen.DataConsumer;
import net.thebrokenscript.brokencore.api.datagen.data.ConstructedAssetManager;
import net.thebrokenscript.brokencore.api.datagen.data.LangManager;
import net.thebrokenscript.brokencore.api.datagen.data.SoundManager;
import net.thebrokenscript.brokencore.api.datagen.data.TagManager;
import net.thebrokenscript.brokencore.api.registry.datagen.AdvancementGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BlockModelGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BlockStateGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BuiltInTagGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.DamageTypeGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.DataManager;
import net.thebrokenscript.brokencore.api.registry.datagen.ItemModelGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.JukeboxSongGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.LangGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.LootTableGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.RecipeGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.SoundGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.TagGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.VanillaTagGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t\"\u000e\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\t0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010\fJ=\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u000e\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\t0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e\u00a2\u0006\u0002\u0010\u000fR&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0011\u0010\"\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u0011\u0010,\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010)R\u0011\u0010.\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00062"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/datagen/DataManager;", "", "<init>", "()V", "map", "", "Ljava/lang/Class;", "Lnet/thebrokenscript/brokencore/api/datagen/DataConsumer;", "get", "T", "C", "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "default", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "advancements", "Lnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager;", "getAdvancements", "()Lnet/thebrokenscript/brokencore/api/datagen/data/ConstructedAssetManager;", "blockModels", "getBlockModels", "blockStates", "getBlockStates", "itemModels", "getItemModels", "jukeboxSongs", "getJukeboxSongs", "damageTypes", "getDamageTypes", "lootTables", "getLootTables", "recipes", "getRecipes", "lang", "Lnet/thebrokenscript/brokencore/api/datagen/data/LangManager;", "getLang", "()Lnet/thebrokenscript/brokencore/api/datagen/data/LangManager;", "tags", "Lnet/thebrokenscript/brokencore/api/datagen/data/TagManager;", "getTags", "()Lnet/thebrokenscript/brokencore/api/datagen/data/TagManager;", "vanillaTags", "getVanillaTags", "builtInTags", "getBuiltInTags", "sounds", "Lnet/thebrokenscript/brokencore/api/datagen/data/SoundManager;", "getSounds", "()Lnet/thebrokenscript/brokencore/api/datagen/data/SoundManager;", "brokencore-common"})
public final class DataManager {
    @NotNull
    private final Map<Class<? extends DataConsumer<?>>, Object> map = new LinkedHashMap();

    @Nullable
    public final <T, C extends DataConsumer<T>> T get(@NotNull Class<C> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Object object = this.map.get(clazz);
        if (object == null) {
            object = null;
        }
        return (T)object;
    }

    public final <T, C extends DataConsumer<T>> T get(@NotNull Class<C> clazz, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNullParameter(function0, (String)"default");
        return (T)this.map.computeIfAbsent(clazz, arg_0 -> DataManager.get$lambda$1(arg_0 -> DataManager.get$lambda$0(function0, arg_0), arg_0));
    }

    @NotNull
    public final ConstructedAssetManager getAdvancements() {
        return (ConstructedAssetManager)this.get(AdvancementGenerator.class, advancements.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getBlockModels() {
        return (ConstructedAssetManager)this.get(BlockModelGenerator.class, blockModels.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getBlockStates() {
        return (ConstructedAssetManager)this.get(BlockStateGenerator.class, blockStates.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getItemModels() {
        return (ConstructedAssetManager)this.get(ItemModelGenerator.class, itemModels.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getJukeboxSongs() {
        return (ConstructedAssetManager)this.get(JukeboxSongGenerator.class, jukeboxSongs.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getDamageTypes() {
        return (ConstructedAssetManager)this.get(DamageTypeGenerator.class, damageTypes.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getLootTables() {
        return (ConstructedAssetManager)this.get(LootTableGenerator.class, lootTables.1.INSTANCE);
    }

    @NotNull
    public final ConstructedAssetManager getRecipes() {
        return (ConstructedAssetManager)this.get(RecipeGenerator.class, recipes.1.INSTANCE);
    }

    @NotNull
    public final LangManager getLang() {
        return (LangManager)this.get(LangGenerator.class, lang.1.INSTANCE);
    }

    @NotNull
    public final TagManager getTags() {
        return (TagManager)this.get(TagGenerator.class, tags.1.INSTANCE);
    }

    @NotNull
    public final TagManager getVanillaTags() {
        return (TagManager)this.get(VanillaTagGenerator.class, vanillaTags.1.INSTANCE);
    }

    @NotNull
    public final TagManager getBuiltInTags() {
        return (TagManager)this.get(BuiltInTagGenerator.class, builtInTags.1.INSTANCE);
    }

    @NotNull
    public final SoundManager getSounds() {
        return (SoundManager)this.get(SoundGenerator.class, sounds.1.INSTANCE);
    }

    private static final Object get$lambda$0(Function0 $default, Class it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Object object = $default.invoke();
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    private static final Object get$lambda$1(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }
}


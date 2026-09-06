/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.level.entity.EntityAccess
 *  net.minecraft.world.level.entity.EntityLookup
 *  net.minecraft.world.level.entity.EntitySection
 *  net.minecraft.world.level.entity.EntitySectionStorage
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext.miximpl;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityLookup;
import net.minecraft.world.level.entity.EntitySection;
import net.minecraft.world.level.entity.EntitySectionStorage;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.thebrokenscript.brokencore.api.mixinterfaces.EntityLookupExt;
import net.thebrokenscript.brokencore.impl.mixin.features.entitylookup.EntitySectionStorageAccessor;
import net.thebrokenscript.brokencore.impl.mixin.features.entitylookup.LevelEntityGetterAdapterAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u001a/\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u001c\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\b\u001a;\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0002\u001a8\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u001a/\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u001c\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001a;\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0002\u001a8\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u001a/\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u001c\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000eH\u0086\b\u001a;\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0002\u001a8\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u001a/\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u001c\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\b\u001a;\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u001c*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0002\"4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\t8@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\n\u001a\u0004\b\u0007\u0010\u000b\":\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t0\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e8@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"4\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00158@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2={"ext", "Lnet/thebrokenscript/brokencore/api/mixinterfaces/EntityLookupExt;", "T", "Lnet/minecraft/world/level/entity/EntityAccess;", "Lnet/minecraft/world/level/entity/EntityLookup;", "getExt$annotations", "(Lnet/minecraft/world/level/entity/EntityLookup;)V", "getExt", "(Lnet/minecraft/world/level/entity/EntityLookup;)Lnet/thebrokenscript/brokencore/api/mixinterfaces/EntityLookupExt;", "Lnet/minecraft/world/level/entity/EntitySection;", "(Lnet/minecraft/world/level/entity/EntitySection;)V", "(Lnet/minecraft/world/level/entity/EntitySection;)Lnet/thebrokenscript/brokencore/api/mixinterfaces/EntityLookupExt;", "sections", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "Lnet/minecraft/world/level/entity/EntitySectionStorage;", "getSections$annotations", "(Lnet/minecraft/world/level/entity/EntitySectionStorage;)V", "getSections", "(Lnet/minecraft/world/level/entity/EntitySectionStorage;)Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "acc", "Lnet/thebrokenscript/brokencore/impl/mixin/features/entitylookup/LevelEntityGetterAdapterAccessor;", "Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;", "getAcc$annotations", "(Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;)V", "getAcc", "(Lnet/minecraft/world/level/entity/LevelEntityGetterAdapter;)Lnet/thebrokenscript/brokencore/impl/mixin/features/entitylookup/LevelEntityGetterAdapterAccessor;", "byClass", "", "U", "clazz", "Ljava/lang/Class;", "get", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEntityLookupExtImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityLookupExtImpl.kt\nnet/thebrokenscript/brokencore/api/ext/miximpl/EntityLookupExtImplKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n77#2:43\n97#2,5:44\n1669#3,8:49\n*S KotlinDebug\n*F\n+ 1 EntityLookupExtImpl.kt\nnet/thebrokenscript/brokencore/api/ext/miximpl/EntityLookupExtImplKt\n*L\n30#1:43\n30#1:44,5\n36#1:49,8\n*E\n"})
public final class EntityLookupExtImplKt {
    @NotNull
    public static final <T extends EntityAccess> EntityLookupExt<T> getExt(@NotNull EntityLookup<T> $this$ext) {
        Intrinsics.checkNotNullParameter($this$ext, (String)"<this>");
        return (EntityLookupExt)$this$ext;
    }

    public static /* synthetic */ void getExt$annotations(EntityLookup entityLookup) {
    }

    @NotNull
    public static final <T extends EntityAccess> EntityLookupExt<T> getExt(@NotNull EntitySection<T> $this$ext) {
        Intrinsics.checkNotNullParameter($this$ext, (String)"<this>");
        return (EntityLookupExt)$this$ext;
    }

    public static /* synthetic */ void getExt$annotations(EntitySection entitySection) {
    }

    @NotNull
    public static final <T extends EntityAccess> Long2ObjectMap<EntitySection<T>> getSections(@NotNull EntitySectionStorage<T> $this$sections) {
        Intrinsics.checkNotNullParameter($this$sections, (String)"<this>");
        Long2ObjectMap long2ObjectMap = ((EntitySectionStorageAccessor)$this$sections).bc$getSections();
        Intrinsics.checkNotNullExpressionValue(long2ObjectMap, (String)"bc$getSections(...)");
        return long2ObjectMap;
    }

    public static /* synthetic */ void getSections$annotations(EntitySectionStorage entitySectionStorage) {
    }

    @NotNull
    public static final <T extends EntityAccess> LevelEntityGetterAdapterAccessor<T> getAcc(@NotNull LevelEntityGetterAdapter<T> $this$acc) {
        Intrinsics.checkNotNullParameter($this$acc, (String)"<this>");
        return (LevelEntityGetterAdapterAccessor)$this$acc;
    }

    public static /* synthetic */ void getAcc$annotations(LevelEntityGetterAdapter levelEntityGetterAdapter) {
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> byClass(@NotNull EntityLookup<T> $this$byClass, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.getExt($this$byClass).bc$getByClass(clazz);
    }

    public static final /* synthetic */ <T extends EntityAccess, U extends T> Collection<U> byClass(EntityLookup<T> $this$byClass) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        boolean $i$f$byClass = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"U");
        return EntityLookupExtImplKt.byClass($this$byClass, EntityAccess.class);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> get(@NotNull EntityLookup<T> $this$get, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.byClass($this$get, clazz);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> byClass(@NotNull EntitySection<T> $this$byClass, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.getExt($this$byClass).bc$getByClass(clazz);
    }

    public static final /* synthetic */ <T extends EntityAccess, U extends T> Collection<U> byClass(EntitySection<T> $this$byClass) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        boolean $i$f$byClass = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"U");
        return EntityLookupExtImplKt.byClass($this$byClass, EntityAccess.class);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> get(@NotNull EntitySection<T> $this$get, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.byClass($this$get, clazz);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> byClass(@NotNull EntitySectionStorage<T> $this$byClass, @NotNull Class<U> clazz) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Map $this$flatMap$iv = (Map)EntityLookupExtImplKt.getSections($this$byClass);
        boolean $i$f$flatMap = false;
        Map map = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        Iterator iterator = $this$flatMapTo$iv$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry it = element$iv$iv = iterator.next();
            boolean bl = false;
            Object v = it.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            Iterable list$iv$iv = EntityLookupExtImplKt.byClass((EntitySection)v, clazz);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    public static final /* synthetic */ <T extends EntityAccess, U extends T> Collection<U> byClass(EntitySectionStorage<T> $this$byClass) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        boolean $i$f$byClass = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"U");
        return EntityLookupExtImplKt.byClass($this$byClass, EntityAccess.class);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> get(@NotNull EntitySectionStorage<T> $this$get, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.byClass($this$get, clazz);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> byClass(@NotNull LevelEntityGetterAdapter<T> $this$byClass, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        EntityLookup<T> entityLookup = EntityLookupExtImplKt.getAcc($this$byClass).bc$getVisibleEntities();
        Intrinsics.checkNotNullExpressionValue(entityLookup, (String)"bc$getVisibleEntities(...)");
        Collection<U> collection = EntityLookupExtImplKt.byClass(entityLookup, clazz);
        EntitySectionStorage<T> entitySectionStorage = EntityLookupExtImplKt.getAcc($this$byClass).bc$getSectionStorage();
        Intrinsics.checkNotNullExpressionValue(entitySectionStorage, (String)"bc$getSectionStorage(...)");
        Iterable $this$distinctBy$iv = CollectionsKt.plus(collection, (Iterable)EntityLookupExtImplKt.byClass(entitySectionStorage, clazz));
        boolean $i$f$distinctBy = false;
        HashSet<UUID> set$iv = new HashSet<UUID>();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            EntityAccess it = (EntityAccess)e$iv;
            boolean bl = false;
            UUID key$iv = it.getUUID();
            if (!set$iv.add(key$iv)) continue;
            list$iv.add(e$iv);
        }
        return list$iv;
    }

    public static final /* synthetic */ <T extends EntityAccess, U extends T> Collection<U> byClass(LevelEntityGetterAdapter<T> $this$byClass) {
        Intrinsics.checkNotNullParameter($this$byClass, (String)"<this>");
        boolean $i$f$byClass = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"U");
        return EntityLookupExtImplKt.byClass($this$byClass, EntityAccess.class);
    }

    @NotNull
    public static final <T extends EntityAccess, U extends T> Collection<U> get(@NotNull LevelEntityGetterAdapter<T> $this$get, @NotNull Class<U> clazz) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        return EntityLookupExtImplKt.byClass($this$get, clazz);
    }
}


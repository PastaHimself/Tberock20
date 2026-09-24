/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.entity.EntityTypeTest
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\t0\b\"\n\u0012\u0006\b\u0001\u0012\u00020\u00060\t\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/MultiTypeTest;", "", "<init>", "()V", "forClasses", "Lnet/minecraft/world/level/entity/EntityTypeTest;", "Lnet/minecraft/world/entity/Entity;", "types", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Lnet/minecraft/world/level/entity/EntityTypeTest;", "brokencore-common"})
public final class MultiTypeTest {
    @NotNull
    public static final MultiTypeTest INSTANCE = new MultiTypeTest();

    private MultiTypeTest() {
    }

    @NotNull
    public final EntityTypeTest<Entity, Entity> forClasses(Class<? extends Entity> ... types) {
        Intrinsics.checkNotNullParameter(types, (String)"types");
        return (EntityTypeTest)new EntityTypeTest<Entity, Entity>(types){
            final /* synthetic */ Class<? extends Entity>[] $types;
            {
                this.$types = $types;
            }

            public Entity tryCast(Entity it) {
                boolean bl;
                block1: {
                    Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                    Class<? extends Entity>[] $this$any$iv = this.$types;
                    boolean $i$f$any = false;
                    int n = $this$any$iv.length;
                    for (int i = 0; i < n; ++i) {
                        Class<? extends Entity> element$iv;
                        Class<? extends Entity> type = element$iv = $this$any$iv[i];
                        boolean bl2 = false;
                        if (!type.isAssignableFrom(it.getClass())) continue;
                        bl = true;
                        break block1;
                    }
                    bl = false;
                }
                return bl ? it : null;
            }

            public Class<Entity> getBaseClass() {
                return Entity.class;
            }
        };
    }
}


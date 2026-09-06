/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.entity.ecs.components;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.entity.ecs.ComponentBasedEntity;
import net.thebrokenscript.brokencore.api.entity.ecs.EntityComponentBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/components/Persistent;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "entity", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "<init>", "(Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;)V", "onInit", "", "Companion", "brokencore-common"})
public final class Persistent
extends EntityComponentBase {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public Persistent(@NotNull ComponentBasedEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super(entity);
    }

    @Override
    public void onInit() {
        this.getEntity().setPersistenceRequired();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/components/Persistent$Companion;", "", "<init>", "()V", "of", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentProvider;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Function1<ComponentBasedEntity, EntityComponentBase> of() {
            return Companion::of$lambda$0;
        }

        private static final Persistent of$lambda$0(ComponentBasedEntity it) {
            Intrinsics.checkNotNullParameter((Object)((Object)it), (String)"it");
            return new Persistent(it);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


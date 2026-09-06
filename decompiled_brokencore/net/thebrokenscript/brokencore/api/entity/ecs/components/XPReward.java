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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/components/XPReward;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "entity", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "xp", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;I)V", "onInit", "", "Companion", "brokencore-common"})
public final class XPReward
extends EntityComponentBase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int xp;

    public XPReward(@NotNull ComponentBasedEntity entity, int xp) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super(entity);
        this.xp = xp;
    }

    @Override
    public void onInit() {
        this.getEntity().setXpReward(this.xp);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/ecs/components/XPReward$Companion;", "", "<init>", "()V", "of", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentBasedEntity;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/EntityComponentBase;", "Lnet/thebrokenscript/brokencore/api/entity/ecs/ComponentProvider;", "xp", "", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Function1<ComponentBasedEntity, EntityComponentBase> of(int xp) {
            return arg_0 -> Companion.of$lambda$0(xp, arg_0);
        }

        private static final XPReward of$lambda$0(int $xp, ComponentBasedEntity it) {
            Intrinsics.checkNotNullParameter((Object)((Object)it), (String)"it");
            return new XPReward(it, $xp);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


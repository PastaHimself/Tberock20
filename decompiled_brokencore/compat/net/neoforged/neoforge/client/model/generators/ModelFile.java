/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH$J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0011\u0010\u000b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "", "uncheckedLocation", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;)V", "getUncheckedLocation", "()Lnet/minecraft/resources/ResourceLocation;", "setUncheckedLocation", "exists", "", "location", "getLocation", "assertExistence", "", "UncheckedModelFile", "ExistingModelFile", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nModelFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelFile.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1#2:43\n*E\n"})
public abstract class ModelFile {
    @NotNull
    private ResourceLocation uncheckedLocation;

    protected ModelFile(@NotNull ResourceLocation uncheckedLocation) {
        Intrinsics.checkNotNullParameter((Object)uncheckedLocation, (String)"uncheckedLocation");
        this.uncheckedLocation = uncheckedLocation;
    }

    @NotNull
    public final ResourceLocation getUncheckedLocation() {
        return this.uncheckedLocation;
    }

    public final void setUncheckedLocation(@NotNull ResourceLocation resourceLocation) {
        Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"<set-?>");
        this.uncheckedLocation = resourceLocation;
    }

    protected abstract boolean exists();

    @NotNull
    public final ResourceLocation getLocation() {
        this.assertExistence();
        Unit $this$_get_location__u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return this.uncheckedLocation;
    }

    public final void assertExistence() {
        if (Intrinsics.areEqual((Object)this.uncheckedLocation.getNamespace(), (Object)"brokencore")) {
            return;
        }
        Preconditions.checkState((boolean)this.exists(), (String)"Model at %s does not exist", (Object)this.uncheckedLocation);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile$ExistingModelFile;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "location", "Lnet/minecraft/resources/ResourceLocation;", "existingHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "exists", "", "brokencore-common"})
    public static final class ExistingModelFile
    extends ModelFile {
        @NotNull
        private final ExistingFileHelper existingHelper;

        public ExistingModelFile(@NotNull ResourceLocation location, @NotNull ExistingFileHelper existingHelper) {
            Intrinsics.checkNotNullParameter((Object)location, (String)"location");
            Intrinsics.checkNotNullParameter((Object)existingHelper, (String)"existingHelper");
            super(location);
            this.existingHelper = existingHelper;
        }

        @Override
        protected boolean exists() {
            String string = this.getUncheckedLocation().getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
            return StringsKt.contains$default((CharSequence)string, (CharSequence)".", (boolean)false, (int)2, null) ? this.existingHelper.exists(this.getUncheckedLocation(), ModelProvider.MODEL_WITH_EXTENSION) : this.existingHelper.exists(this.getUncheckedLocation(), ModelProvider.MODEL);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0004\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014\u00a8\u0006\n"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile$UncheckedModelFile;", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "location", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;)V", "", "(Ljava/lang/String;)V", "exists", "", "brokencore-common"})
    public static final class UncheckedModelFile
    extends ModelFile {
        public UncheckedModelFile(@NotNull ResourceLocation location) {
            Intrinsics.checkNotNullParameter((Object)location, (String)"location");
            super(location);
        }

        public UncheckedModelFile(@NotNull String location) {
            Intrinsics.checkNotNullParameter((Object)location, (String)"location");
            ResourceLocation resourceLocation = ResourceLocation.parse((String)location);
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
            this(resourceLocation);
        }

        @Override
        protected boolean exists() {
            return true;
        }
    }
}


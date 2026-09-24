/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import compat.net.neoforged.neoforge.common.data.SoundDefinition;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\b\u00a2\u0006\u0004\b\u0006\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u001f\u0010\u0019\u001a\u00020\u00032\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/SoundFileBuilder;", "", "parent", "Lnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder;", "path", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder;Lnet/minecraft/resources/ResourceLocation;)V", "", "(Lnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder;Ljava/lang/String;)V", "type", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$SoundType;", "volume", "", "Ljava/lang/Float;", "pitch", "weight", "", "Ljava/lang/Integer;", "attenuationDistance", "stream", "", "preload", "create", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;", "configure", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "register", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSoundFileBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundFileBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/SoundFileBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n1#2:78\n*E\n"})
public final class SoundFileBuilder {
    @NotNull
    private final SoundBuilder parent;
    @NotNull
    private ResourceLocation path;
    @JvmField
    @NotNull
    public SoundDefinition.SoundType type;
    @JvmField
    @Nullable
    public Float volume;
    @JvmField
    @Nullable
    public Float pitch;
    @JvmField
    @Nullable
    public Integer weight;
    @JvmField
    @Nullable
    public Integer attenuationDistance;
    @JvmField
    public boolean stream;
    @JvmField
    public boolean preload;

    public SoundFileBuilder(@NotNull SoundBuilder parent, @NotNull ResourceLocation path) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        this.parent = parent;
        this.path = path;
        this.type = SoundDefinition.SoundType.SOUND;
    }

    public SoundFileBuilder(@NotNull SoundBuilder parent, @NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        this(parent, parent.getParent().id(path));
    }

    @NotNull
    public final SoundDefinition.Sound create() {
        float it;
        SoundDefinition.Sound sound;
        SoundDefinition.Sound $this$create_u24lambda_u240 = sound = SoundDefinition.Sound.Companion.sound(this.path, this.type);
        boolean bl = false;
        Float f = this.volume;
        if (f != null) {
            it = ((Number)f).floatValue();
            boolean bl2 = false;
            $this$create_u24lambda_u240.volume(it);
        }
        Float f2 = this.pitch;
        if (f2 != null) {
            it = ((Number)f2).floatValue();
            boolean bl3 = false;
            $this$create_u24lambda_u240.pitch(it);
        }
        Integer n = this.weight;
        if (n != null) {
            int it2 = ((Number)n).intValue();
            boolean bl4 = false;
            $this$create_u24lambda_u240.weight(it2);
        }
        Integer n2 = this.attenuationDistance;
        if (n2 != null) {
            int it3 = ((Number)n2).intValue();
            boolean bl5 = false;
            $this$create_u24lambda_u240.attenuationDistance(it3);
        }
        $this$create_u24lambda_u240.stream(this.stream);
        $this$create_u24lambda_u240.preload(this.preload);
        return sound;
    }

    @NotNull
    public final SoundBuilder configure(@NotNull Function1<? super SoundFileBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        block2.invoke((Object)this);
        Unit $this$configure_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        return this.register();
    }

    @NotNull
    public final SoundBuilder register() {
        SoundBuilder soundBuilder;
        SoundBuilder $this$register_u24lambda_u240 = soundBuilder = this.parent;
        boolean bl = false;
        ((Collection)$this$register_u24lambda_u240.files).add(this.create());
        return soundBuilder;
    }
}


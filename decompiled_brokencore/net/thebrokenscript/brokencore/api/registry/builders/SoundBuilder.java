/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import compat.net.neoforged.neoforge.common.data.SoundDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.datagen.data.SoundManager;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.SoundFileBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u00a2\u0006\u0002\b\u001fH\u0007J+\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000e2\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u00a2\u0006\u0002\b\u001fH\u0007J+\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00062\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u00a2\u0006\u0002\b\u001fH\u0007J\u0012\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u0013H\u0007J\u0006\u0010$\u001a\u00020\u0000J\b\u0010%\u001a\u00020\u0002H\u0014J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020'H\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "Lnet/minecraft/sounds/SoundEvent;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceLocation;)V", "actualId", "id", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "subtitleKey", "", "getSubtitleKey", "()Ljava/lang/String;", "subtitle", "replace", "", "range", "", "Ljava/lang/Float;", "files", "", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;", "defaultFile", "block", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SoundFileBuilder;", "", "Lkotlin/ExtensionFunctionType;", "file", "path", "simple", "shouldStream", "noSubtitle", "createObject", "register", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSoundBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n37#2,2:101\n1#3:103\n*S KotlinDebug\n*F\n+ 1 SoundBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder\n*L\n94#1:101,2\n*E\n"})
public class SoundBuilder
extends SimpleBuilder<SoundBuilder, SoundEvent> {
    @NotNull
    private final ResourceLocation actualId;
    @NotNull
    private final String subtitleKey;
    @JvmField
    @Nullable
    public String subtitle;
    @JvmField
    public boolean replace;
    @JvmField
    @Nullable
    public Float range;
    @JvmField
    @NotNull
    public final List<SoundDefinition.Sound> files;

    public SoundBuilder(@NotNull BrokenReg parent, @NotNull ResourceLocation name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceKey resourceKey = Registries.SOUND_EVENT;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"SOUND_EVENT");
        String string = name.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        super(parent, resourceKey, string);
        this.actualId = name;
        String string2 = this.getId().getNamespace();
        String string3 = this.getId().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
        this.subtitleKey = "subtitles." + string2 + "." + StringsKt.replace$default((String)string3, (char)'/', (char)'.', (boolean)false, (int)4, null);
        this.subtitle = LangUtil.INSTANCE.getAutomaticName(this.getId());
        this.files = new ArrayList();
    }

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.actualId;
    }

    @NotNull
    protected final String getSubtitleKey() {
        return this.subtitleKey;
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder defaultFile(@NotNull Function1<? super SoundFileBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        String string = this.getId().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        return new SoundFileBuilder(this, StringsKt.replace$default((String)string, (String)".", (String)"/", (boolean)false, (int)4, null)).configure(block2);
    }

    public static /* synthetic */ SoundBuilder defaultFile$default(SoundBuilder soundBuilder, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultFile");
        }
        if ((n & 1) != 0) {
            function1 = SoundBuilder::defaultFile$lambda$0;
        }
        return soundBuilder.defaultFile((Function1<? super SoundFileBuilder, Unit>)function1);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder file(@NotNull String path, @NotNull Function1<? super SoundFileBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return new SoundFileBuilder(this, path).configure(block2);
    }

    public static /* synthetic */ SoundBuilder file$default(SoundBuilder soundBuilder, String string, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: file");
        }
        if ((n & 2) != 0) {
            function1 = SoundBuilder::file$lambda$0;
        }
        return soundBuilder.file(string, (Function1<? super SoundFileBuilder, Unit>)function1);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder file(@NotNull ResourceLocation path, @NotNull Function1<? super SoundFileBuilder, Unit> block2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        return new SoundFileBuilder(this, path).configure(block2);
    }

    public static /* synthetic */ SoundBuilder file$default(SoundBuilder soundBuilder, ResourceLocation resourceLocation, Function1 function1, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: file");
        }
        if ((n & 2) != 0) {
            function1 = SoundBuilder::file$lambda$1;
        }
        return soundBuilder.file(resourceLocation, (Function1<? super SoundFileBuilder, Unit>)function1);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder simple(boolean shouldStream) {
        return this.defaultFile((Function1<? super SoundFileBuilder, Unit>)((Function1)arg_0 -> SoundBuilder.simple$lambda$0(shouldStream, arg_0)));
    }

    public static /* synthetic */ SoundBuilder simple$default(SoundBuilder soundBuilder, boolean bl, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: simple");
        }
        if ((n & 1) != 0) {
            bl = false;
        }
        return soundBuilder.simple(bl);
    }

    @NotNull
    public final SoundBuilder noSubtitle() {
        SoundBuilder soundBuilder;
        SoundBuilder $this$noSubtitle_u24lambda_u240 = soundBuilder = this;
        boolean bl = false;
        $this$noSubtitle_u24lambda_u240.subtitle = null;
        return soundBuilder;
    }

    @Override
    @NotNull
    protected SoundEvent createObject() {
        SoundEvent soundEvent;
        if (this.range != null) {
            ResourceLocation resourceLocation = this.getId();
            Float f = this.range;
            Intrinsics.checkNotNull((Object)f);
            SoundEvent soundEvent2 = SoundEvent.createFixedRangeEvent((ResourceLocation)resourceLocation, (float)f.floatValue());
            soundEvent = soundEvent2;
            Intrinsics.checkNotNullExpressionValue((Object)soundEvent2, (String)"createFixedRangeEvent(...)");
        } else {
            SoundEvent soundEvent3 = SoundEvent.createVariableRangeEvent((ResourceLocation)this.getId());
            soundEvent = soundEvent3;
            Intrinsics.checkNotNullExpressionValue((Object)soundEvent3, (String)"createVariableRangeEvent(...)");
        }
        return soundEvent;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public RegistryEntry<SoundEvent, SoundEvent> register() {
        Object e;
        block1: {
            Object it = e = super.register();
            boolean bl = false;
            Object $this$toTypedArray$iv = this.files;
            boolean $i$f$toTypedArray = false;
            Object thisCollection$iv = $this$toTypedArray$iv;
            Object object = thisCollection$iv.toArray(new SoundDefinition.Sound[0]);
            $this$toTypedArray$iv = object = SoundDefinition.Companion.definition().with(Arrays.copyOf(object, ((SoundDefinition.Sound[])object).length)).replace(this.replace);
            ResourceLocation resourceLocation = this.getId();
            SoundManager soundManager = this.getParent().getData().getSounds();
            boolean bl2 = false;
            if (this.subtitle != null) {
                void $this$register_u24lambda_u240_u240;
                $this$register_u24lambda_u240_u240.subtitle(this.subtitleKey);
            }
            Unit unit = Unit.INSTANCE;
            soundManager.set(resourceLocation, (SoundDefinition)object);
            String string = this.subtitle;
            if (string == null) break block1;
            String it2 = string;
            boolean bl3 = false;
            this.getParent().getData().getLang().set(this.subtitleKey, it2);
        }
        return e;
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder defaultFile() {
        return SoundBuilder.defaultFile$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder file(@NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return SoundBuilder.file$default(this, path, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder file(@NotNull ResourceLocation path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return SoundBuilder.file$default(this, path, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final SoundBuilder simple() {
        return SoundBuilder.simple$default(this, false, 1, null);
    }

    private static final Unit defaultFile$lambda$0(SoundFileBuilder soundFileBuilder) {
        Intrinsics.checkNotNullParameter((Object)soundFileBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit file$lambda$0(SoundFileBuilder soundFileBuilder) {
        Intrinsics.checkNotNullParameter((Object)soundFileBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit file$lambda$1(SoundFileBuilder soundFileBuilder) {
        Intrinsics.checkNotNullParameter((Object)soundFileBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit simple$lambda$0(boolean $shouldStream, SoundFileBuilder $this$defaultFile) {
        Intrinsics.checkNotNullParameter((Object)$this$defaultFile, (String)"$this$defaultFile");
        $this$defaultFile.stream = $shouldStream;
        return Unit.INSTANCE;
    }
}


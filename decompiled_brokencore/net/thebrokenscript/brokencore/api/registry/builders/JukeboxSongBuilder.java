/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.PackOutput
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.item.JukeboxSong
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0014\u001a\u00020\u0000J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019H\u0016R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/JukeboxSongBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "Lnet/minecraft/world/item/JukeboxSong;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "sound", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/sounds/SoundEvent;", "length", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lnet/minecraft/core/Holder;Ljava/lang/Number;)V", "descriptionKey", "getDescriptionKey", "()Ljava/lang/String;", "comparatorOutput", "", "description", "noLang", "createJson", "Lcom/google/gson/JsonObject;", "createObject", "register", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nJukeboxSongBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JukeboxSongBuilder.kt\nnet/thebrokenscript/brokencore/api/registry/builders/JukeboxSongBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public class JukeboxSongBuilder
extends SimpleBuilder<JukeboxSongBuilder, JukeboxSong> {
    @JvmField
    @NotNull
    public Holder<SoundEvent> sound;
    @JvmField
    @NotNull
    public Number length;
    @NotNull
    private final String descriptionKey;
    @JvmField
    public int comparatorOutput;
    @JvmField
    @Nullable
    public String description;

    public JukeboxSongBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Holder<SoundEvent> sound, @NotNull Number length) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)length, (String)"length");
        ResourceKey resourceKey = Registries.JUKEBOX_SONG;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"JUKEBOX_SONG");
        super(parent, resourceKey, name);
        this.sound = sound;
        this.length = length;
        this.descriptionKey = "jukebox_song." + this.getId().getNamespace() + "." + this.getId().getPath();
        this.comparatorOutput = 15;
    }

    @NotNull
    protected final String getDescriptionKey() {
        return this.descriptionKey;
    }

    @NotNull
    public final JukeboxSongBuilder noLang() {
        JukeboxSongBuilder jukeboxSongBuilder;
        JukeboxSongBuilder $this$noLang_u24lambda_u240 = jukeboxSongBuilder = this;
        boolean bl = false;
        $this$noLang_u24lambda_u240.description = null;
        return jukeboxSongBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final JsonObject createJson() {
        void $this$createJson_u24lambda_u240_u240;
        JsonObject jsonObject;
        JsonObject jsonObject2;
        JsonObject $this$createJson_u24lambda_u240 = jsonObject2 = new JsonObject();
        boolean bl = false;
        Optional optional = this.sound.unwrapKey();
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"unwrapKey(...)");
        Object object = OptionalsKt.getOrNull((Optional)optional);
        Intrinsics.checkNotNull((Object)object);
        $this$createJson_u24lambda_u240.addProperty("sound_event", ((ResourceKey)object).location().toString());
        $this$createJson_u24lambda_u240.addProperty("length_in_seconds", (Number)Float.valueOf(this.length.floatValue()));
        $this$createJson_u24lambda_u240.addProperty("comparator_output", (Number)this.comparatorOutput);
        JsonObject jsonObject3 = jsonObject = new JsonObject();
        String string = "description";
        JsonObject jsonObject4 = $this$createJson_u24lambda_u240;
        boolean bl2 = false;
        $this$createJson_u24lambda_u240_u240.addProperty("translate", this.descriptionKey);
        Unit unit = Unit.INSTANCE;
        jsonObject4.add(string, (JsonElement)jsonObject);
        return jsonObject2;
    }

    @Override
    @NotNull
    protected JukeboxSong createObject() {
        return new JukeboxSong(this.sound, (Component)Component.translatable((String)this.descriptionKey), this.length.floatValue(), this.comparatorOutput);
    }

    @Override
    @NotNull
    public RegistryEntry<JukeboxSong, JukeboxSong> register() {
        Object e;
        Object it = e = super.register();
        boolean bl = false;
        String string = this.description;
        if (string != null) {
            String it2 = string;
            boolean bl2 = false;
            this.getParent().getData().getLang().set(this.descriptionKey, it2);
        }
        this.getParent().getData().getJukeboxSongs().register((Function1<? super PackOutput, Unit>)((Function1)arg_0 -> JukeboxSongBuilder.register$lambda$0$1(this, arg_0)));
        return e;
    }

    private static final Unit register$lambda$0$1(JukeboxSongBuilder this$0, PackOutput it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)("data/" + this$0.getId().getNamespace() + "/jukebox_song/" + this$0.getId().getPath() + ".json"), (Object)this$0.createJson())};
        this$0.getParent().getData().getJukeboxSongs().accept(pairArray);
        return Unit.INSTANCE;
    }
}


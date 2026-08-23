/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package compat.net.neoforged.neoforge.common.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import compat.net.neoforged.neoforge.common.data.SoundDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0003\u0012\u0013\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\"\u00020\u0006\u00a2\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lcompat/net/neoforged/neoforge/common/data/SoundDefinition;", "", "<init>", "()V", "sounds", "", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;", "replace", "", "subtitle", "", "with", "sound", "", "([Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;)Lcompat/net/neoforged/neoforge/common/data/SoundDefinition;", "soundList", "serialize", "Lcom/google/gson/JsonObject;", "Sound", "SoundType", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSoundDefinition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundDefinition.kt\ncompat/net/neoforged/neoforge/common/data/SoundDefinition\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n1#2:365\n*E\n"})
public final class SoundDefinition {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Sound> sounds = new ArrayList();
    private boolean replace;
    @Nullable
    private String subtitle;

    private SoundDefinition() {
    }

    @NotNull
    public final SoundDefinition replace(boolean replace) {
        this.replace = replace;
        return this;
    }

    @NotNull
    public final SoundDefinition subtitle(@Nullable String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    @NotNull
    public final SoundDefinition with(@NotNull Sound sound) {
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        this.sounds.add(sound);
        return this;
    }

    @NotNull
    public final SoundDefinition with(Sound ... sounds2) {
        SoundDefinition soundDefinition;
        Intrinsics.checkNotNullParameter((Object)sounds2, (String)"sounds");
        SoundDefinition $this$with_u24lambda_u240 = soundDefinition = this;
        boolean bl = false;
        CollectionsKt.addAll((Collection)$this$with_u24lambda_u240.sounds, (Object[])sounds2);
        return soundDefinition;
    }

    @NotNull
    public final List<Sound> soundList() {
        return this.sounds;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final JsonObject serialize() {
        void $this$serialize_u24lambda_u241;
        JsonArray jsonArray;
        if (!(!this.sounds.isEmpty())) {
            boolean bl = false;
            String string = "Unable to serialize a sound definition that has no sounds!";
            throw new IllegalStateException(string.toString());
        }
        JsonObject json = new JsonObject();
        if (this.replace) {
            json.addProperty("replace", Boolean.valueOf(true));
        }
        if (this.subtitle != null) {
            json.addProperty("subtitle", this.subtitle);
        }
        JsonArray jsonArray2 = jsonArray = new JsonArray();
        String string = "sounds";
        JsonObject jsonObject = json;
        boolean bl = false;
        this.sounds.stream().map(arg_0 -> SoundDefinition.serialize$lambda$1$0(serialize.2.1.INSTANCE, arg_0)).forEach(arg_0 -> SoundDefinition.serialize$lambda$1$1((Function1)new Function1<JsonElement, Unit>((Object)$this$serialize_u24lambda_u241){

            public final void invoke(JsonElement p0) {
                ((JsonArray)this.receiver).add(p0);
            }
        }, arg_0));
        Unit unit = Unit.INSTANCE;
        jsonObject.add(string, (JsonElement)jsonArray);
        return json;
    }

    private static final JsonElement serialize$lambda$1$0(Function1 $tmp0, Object p0) {
        return (JsonElement)$tmp0.invoke(p0);
    }

    private static final void serialize$lambda$1$1(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }

    public /* synthetic */ SoundDefinition(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Companion;", "", "<init>", "()V", "definition", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SoundDefinition definition() {
            return new SoundDefinition(null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0011J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;", "", "name", "Lnet/minecraft/resources/ResourceLocation;", "type", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$SoundType;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$SoundType;)V", "volume", "", "pitch", "weight", "", "stream", "", "attenuationDistance", "preload", "", "serialize", "Lcom/google/gson/JsonElement;", "canBeInShortForm", "stripMcPrefix", "", "Companion", "brokencore-common"})
    public static final class Sound {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ResourceLocation name;
        @NotNull
        private final SoundType type;
        private float volume;
        private float pitch;
        private int weight;
        private boolean stream;
        private int attenuationDistance;
        private boolean preload;
        @NotNull
        private static final SoundType DEFAULT_TYPE = SoundType.SOUND;
        private static final float DEFAULT_VOLUME = 1.0f;
        private static final float DEFAULT_PITCH = 1.0f;
        private static final int DEFAULT_WEIGHT = 1;
        private static final boolean DEFAULT_STREAM = false;
        private static final int DEFAULT_ATTENUATION_DISTANCE = 16;
        private static final boolean DEFAULT_PRELOAD = false;

        private Sound(ResourceLocation name, SoundType type) {
            this.name = name;
            this.type = type;
            this.volume = 1.0f;
            this.pitch = 1.0f;
            this.weight = 1;
            this.attenuationDistance = 16;
        }

        @NotNull
        public final Sound volume(double volume) {
            return this.volume((float)volume);
        }

        @NotNull
        public final Sound volume(float volume) {
            if (!(!(volume <= 0.0f))) {
                boolean bl = false;
                String string = "Volume must be positive for sound " + this.name + ", but instead got " + volume;
                throw new IllegalArgumentException(string.toString());
            }
            this.volume = volume;
            return this;
        }

        @NotNull
        public final Sound pitch(double pitch) {
            return this.pitch((float)pitch);
        }

        @NotNull
        public final Sound pitch(float pitch) {
            if (!(!(pitch <= 0.0f))) {
                boolean bl = false;
                String string = "Pitch must be positive for sound " + this.name + ", but instead got " + pitch;
                throw new IllegalArgumentException(string.toString());
            }
            this.pitch = pitch;
            return this;
        }

        @NotNull
        public final Sound weight(int weight) {
            if (!(weight > 0)) {
                boolean bl = false;
                String string = "Weight has to be a positive number in sound " + this.name + ", but instead got " + weight;
                throw new IllegalArgumentException(string.toString());
            }
            this.weight = weight;
            return this;
        }

        @JvmOverloads
        @NotNull
        public final Sound stream(boolean stream) {
            this.stream = stream;
            return this;
        }

        public static /* synthetic */ Sound stream$default(Sound sound, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = true;
            }
            return sound.stream(bl);
        }

        @NotNull
        public final Sound attenuationDistance(int attenuationDistance) {
            this.attenuationDistance = attenuationDistance;
            return this;
        }

        @JvmOverloads
        @NotNull
        public final Sound preload(boolean preload) {
            this.preload = preload;
            return this;
        }

        public static /* synthetic */ Sound preload$default(Sound sound, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = true;
            }
            return sound.preload(bl);
        }

        @NotNull
        public final ResourceLocation name() {
            return this.name;
        }

        @NotNull
        public final SoundType type() {
            return this.type;
        }

        @NotNull
        public final JsonElement serialize() {
            if (this.canBeInShortForm()) {
                return (JsonElement)new JsonPrimitive(this.stripMcPrefix(this.name));
            }
            JsonObject json = new JsonObject();
            json.addProperty("name", this.stripMcPrefix(this.name));
            if (this.type != DEFAULT_TYPE) {
                json.addProperty("type", this.type.getJsonString());
            }
            if (!(this.volume == 1.0f)) {
                json.addProperty("volume", (Number)Float.valueOf(this.volume));
            }
            if (!(this.pitch == 1.0f)) {
                json.addProperty("pitch", (Number)Float.valueOf(this.pitch));
            }
            if (this.weight != 1) {
                json.addProperty("weight", (Number)this.weight);
            }
            if (this.stream) {
                json.addProperty("stream", Boolean.valueOf(this.stream));
            }
            if (this.preload) {
                json.addProperty("preload", Boolean.valueOf(this.preload));
            }
            if (this.attenuationDistance != 16) {
                json.addProperty("attenuation_distance", (Number)this.attenuationDistance);
            }
            return (JsonElement)json;
        }

        private final boolean canBeInShortForm() {
            return this.type == DEFAULT_TYPE && this.volume == 1.0f && this.pitch == 1.0f && this.weight == 1 && !this.stream && this.attenuationDistance == 16 && !this.preload;
        }

        private final String stripMcPrefix(ResourceLocation name) {
            String string;
            if (Intrinsics.areEqual((Object)"minecraft", (Object)name.getNamespace())) {
                String string2 = name.getPath();
                string = string2;
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            } else {
                String string3 = name.toString();
                string = string3;
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toString(...)");
            }
            return string;
        }

        @JvmOverloads
        @NotNull
        public final Sound stream() {
            return Sound.stream$default(this, false, 1, null);
        }

        @JvmOverloads
        @NotNull
        public final Sound preload() {
            return Sound.preload$default(this, false, 1, null);
        }

        public /* synthetic */ Sound(ResourceLocation name, SoundType type, DefaultConstructorMarker $constructor_marker) {
            this(name, type);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound$Companion;", "", "<init>", "()V", "DEFAULT_TYPE", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$SoundType;", "DEFAULT_VOLUME", "", "DEFAULT_PITCH", "DEFAULT_WEIGHT", "", "DEFAULT_STREAM", "", "DEFAULT_ATTENUATION_DISTANCE", "DEFAULT_PRELOAD", "sound", "Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$Sound;", "name", "Lnet/minecraft/resources/ResourceLocation;", "type", "brokencore-common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Sound sound(@NotNull ResourceLocation name, @NotNull SoundType type) {
                Intrinsics.checkNotNullParameter((Object)name, (String)"name");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return new Sound(name, type, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lcompat/net/neoforged/neoforge/common/data/SoundDefinition$SoundType;", "", "jsonString", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonString", "()Ljava/lang/String;", "SOUND", "EVENT", "brokencore-common"})
    public static final class SoundType
    extends Enum<SoundType> {
        @NotNull
        private final String jsonString;
        public static final /* enum */ SoundType SOUND = new SoundType("sound");
        public static final /* enum */ SoundType EVENT = new SoundType("event");
        private static final /* synthetic */ SoundType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private SoundType(String jsonString) {
            this.jsonString = jsonString;
        }

        @NotNull
        public final String getJsonString() {
            return this.jsonString;
        }

        public static SoundType[] values() {
            return (SoundType[])$VALUES.clone();
        }

        public static SoundType valueOf(String value) {
            return Enum.valueOf(SoundType.class, value);
        }

        @NotNull
        public static EnumEntries<SoundType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = soundTypeArray = new SoundType[]{SoundType.SOUND, SoundType.EVENT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}


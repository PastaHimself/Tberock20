/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.Util
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.Util;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u000eH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/misc/CapeLoader;", "", "<init>", "()V", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "CAPE_META_URL", "", "CAPES", "", "Ljava/util/UUID;", "loadCapes", "", "getCapes", "", "load", "thebrokenscript-common"})
public final class CapeLoader {
    @NotNull
    public static final CapeLoader INSTANCE = new CapeLoader();
    @JvmField
    @NotNull
    public static final Logger LOGGER;
    @NotNull
    public static final String CAPE_META_URL = "https://git.thebrokenscript.net/Writers-of-the-Script/Meta/raw/branch/main/capes.json";
    @NotNull
    private static final Map<UUID, String> CAPES;

    private CapeLoader() {
    }

    private final void loadCapes() {
        LOGGER.info("Loading capes...");
        String raw = null;
        try {
            String string = IOUtils.toString((URI)URI.create(CAPE_META_URL), (Charset)StandardCharsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            raw = string;
        }
        catch (IOException iOException) {
            return;
        }
        JsonArray capes = JsonParser.parseString((String)raw).getAsJsonArray();
        CAPES.clear();
        Iterator iterator = capes.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            JsonElement item = (JsonElement)iterator2.next();
            JsonObject obj = item.getAsJsonObject();
            UUID uuid = UUID.fromString(obj.get("uuid").getAsString());
            String cape = obj.get("cape").getAsString();
            CAPES.put(uuid, cape);
        }
        LOGGER.info("Loaded " + CAPES.size() + " capes!");
    }

    @JvmStatic
    @NotNull
    public static final Map<UUID, String> getCapes() {
        return MapsKt.toMap(CAPES);
    }

    @JvmStatic
    public static final void load() {
        Util.backgroundExecutor().execute(INSTANCE::loadCapes);
    }

    static {
        Logger logger = LogManager.getLogger(CapeLoader.class);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
        CAPES = new LinkedHashMap();
    }
}


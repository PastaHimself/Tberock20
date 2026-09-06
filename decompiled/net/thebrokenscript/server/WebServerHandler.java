/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents
 *  net.thebrokenscript.brokencore.api.event.game.ClientEvents$Data
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.apache.commons.compress.archivers.zip.ZipArchiveEntry
 *  org.apache.commons.compress.archivers.zip.ZipFile
 *  org.apache.commons.compress.utils.SeekableInMemoryByteChannel
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SeekableByteChannel;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.ClientEvents;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/server/WebServerHandler;", "", "<init>", "()V", "server", "Lcom/sun/net/httpserver/HttpServer;", "decrypt", "", "encryptedBites", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nWebServerHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebServerHandler.kt\nnet/thebrokenscript/server/WebServerHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1208#2,2:101\n1236#2,4:103\n1#3:107\n*S KotlinDebug\n*F\n+ 1 WebServerHandler.kt\nnet/thebrokenscript/server/WebServerHandler\n*L\n33#1:101,2\n33#1:103,4\n*E\n"})
public final class WebServerHandler {
    @NotNull
    public static final WebServerHandler INSTANCE = new WebServerHandler();
    @Nullable
    private static HttpServer server;

    private WebServerHandler() {
    }

    @NotNull
    public final byte[] decrypt(@NotNull byte[] encryptedBites) {
        Intrinsics.checkNotNullParameter((Object)encryptedBites, (String)"encryptedBites");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        String decryptKey = "LEAVEWHILEYOUSTILLCAN";
        Object object = decryptKey;
        byte[] byArray = ((String)object).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
        object = byArray;
        int n = 32;
        byte[] byArray2 = Arrays.copyOf((byte[])object, n);
        Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"copyOf(...)");
        cipher.init(2, (Key)new SecretKeySpec(byArray2, "AES"), new IvParameterSpec(new byte[16]));
        byte[] byArray3 = cipher.doFinal(encryptedBites);
        Intrinsics.checkNotNullExpressionValue((Object)byArray3, (String)"doFinal(...)");
        return byArray3;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$0(ClientEvents.Data $this$on) {
        block4: {
            void $this$associateByTo$iv$iv;
            void $this$associateBy$iv;
            Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
            InputStream inputStream = WebServerHandler.class.getResourceAsStream("/sites/rblog/file.bin");
            if (inputStream == null) {
                ClientEvents.Data $this$lambda_u240_u240 = $this$on;
                boolean bl = false;
                System.err.println("Webserver couldn't start due to missing file.bin");
                Thread.sleep(1000L);
                return Unit.INSTANCE;
            }
            InputStream file = inputStream;
            byte[] byArray = file.readAllBytes();
            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readAllBytes(...)");
            byte[] bytes = INSTANCE.decrypt(byArray);
            ZipFile zip = ZipFile.builder().setSeekableByteChannel((SeekableByteChannel)new SeekableInMemoryByteChannel(bytes)).get();
            Enumeration enumeration = zip.getEntries();
            Intrinsics.checkNotNullExpressionValue((Object)enumeration, (String)"getEntries(...)");
            ArrayList arrayList = Collections.list(enumeration);
            Intrinsics.checkNotNullExpressionValue(arrayList, (String)"list(...)");
            Iterable bl = arrayList;
            boolean $i$f$associateBy = false;
            int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
            void var8_10 = $this$associateBy$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateByTo = false;
            for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                void it;
                ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry)element$iv$iv;
                Map map = destination$iv$iv;
                boolean bl2 = false;
                map.put(it.getName(), element$iv$iv);
            }
            Map entries = destination$iv$iv;
            HttpServer httpServer = server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 2018), 0);
            if (httpServer != null) {
                httpServer.createContext("/", arg_0 -> WebServerHandler.lambda$0$2(entries, zip, arg_0));
            }
            HttpServer httpServer2 = server;
            if (httpServer2 != null) {
                httpServer2.setExecutor(null);
            }
            HttpServer httpServer3 = server;
            if (httpServer3 == null) break block4;
            httpServer3.start();
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final void lambda$0$2(Map $entries, ZipFile $zip, HttpExchange exchange) {
        String ty;
        Object object;
        String string = exchange.getRequestURI().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        Object object2 = new char[]{'/'};
        object2 = StringsKt.trimStart((String)string, (char[])object2);
        if (object2.length() == 0) {
            boolean bl = false;
            object = "index.html";
        } else {
            object = object2;
        }
        String path = (String)object;
        ZipArchiveEntry resource = (ZipArchiveEntry)$entries.get(path);
        int code = 200;
        String string2 = StringsKt.endsWith$default((String)path, (String)".png", (boolean)false, (int)2, null) ? "image/png" : (StringsKt.endsWith$default((String)path, (String)".jpg", (boolean)false, (int)2, null) ? "image/jpeg" : (StringsKt.endsWith$default((String)path, (String)".webp", (boolean)false, (int)2, null) ? "image/webp" : (StringsKt.endsWith$default((String)path, (String)".ico", (boolean)false, (int)2, null) ? "application/x-icon" : (StringsKt.endsWith$default((String)path, (String)".html", (boolean)false, (int)2, null) ? "text/html" : (StringsKt.endsWith$default((String)path, (String)".js", (boolean)false, (int)2, null) ? "text/javascript" : (StringsKt.endsWith$default((String)path, (String)".css", (boolean)false, (int)2, null) ? "text/css" : (StringsKt.endsWith$default((String)path, (String)".json", (boolean)false, (int)2, null) ? "application/json" : (ty = StringsKt.endsWith$default((String)path, (String)".txt", (boolean)false, (int)2, null) ? "text/plain" : "application/octet-stream"))))))));
        if (resource == null) {
            resource = (ZipArchiveEntry)$entries.get(path + ".html");
            if (resource == null && (resource = (ZipArchiveEntry)$entries.get(path + "/index.html")) == null) {
                resource = (ZipArchiveEntry)$entries.get("index.html");
                code = 404;
            }
            ty = "text/html";
        }
        InputStream inputStream = $zip.getInputStream(resource);
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"getInputStream(...)");
        byte[] bytes = ByteStreamsKt.readBytes((InputStream)inputStream);
        exchange.getResponseHeaders().add("Content-Type", ty);
        exchange.sendResponseHeaders(code, bytes.length);
        Closeable closeable = exchange.getResponseBody();
        Throwable throwable = null;
        try {
            OutputStream it = (OutputStream)closeable;
            boolean bl = false;
            it.write(bytes);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    private static final Unit _init_$lambda$1(ClientEvents.Data $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        HttpServer httpServer = server;
        if (httpServer != null) {
            httpServer.stop(0);
        }
        server = null;
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(ClientEvents.EARLY_STARTUP, WebServerHandler::_init_$lambda$0);
        GameEvent.Companion.on(ClientEvents.SHUTDOWN, WebServerHandler::_init_$lambda$1);
    }
}


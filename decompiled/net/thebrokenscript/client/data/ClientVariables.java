/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.data;

import java.io.File;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.data.BitFlagSet;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/client/data/ClientVariables;", "Lnet/thebrokenscript/client/data/BitFlagSet;", "<init>", "()V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file$delegate", "Lkotlin/Lazy;", "set", "flag", "", "unset", "load", "", "save", "thebrokenscript-common"})
public final class ClientVariables
extends BitFlagSet {
    @NotNull
    public static final ClientVariables INSTANCE = new ClientVariables();
    @NotNull
    private static final Lazy file$delegate = LazyKt.lazy(ClientVariables::file_delegate$lambda$0);

    private ClientVariables() {
        super(0L);
    }

    private final File getFile() {
        Lazy lazy = file$delegate;
        Object object = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (File)object;
    }

    @Override
    @NotNull
    public ClientVariables set(long flag) {
        ClientVariables clientVariables;
        ClientVariables $this$set_u24lambda_u240 = clientVariables = this;
        boolean bl = false;
        super.set(flag);
        $this$set_u24lambda_u240.save();
        return clientVariables;
    }

    @Override
    @NotNull
    public ClientVariables unset(long flag) {
        ClientVariables clientVariables;
        ClientVariables $this$unset_u24lambda_u240 = clientVariables = this;
        boolean bl = false;
        super.unset(flag);
        $this$unset_u24lambda_u240.save();
        return clientVariables;
    }

    public final void load() {
        ByteBuffer data;
        ByteBuffer byteBuffer = data = this.getFile().exists() ? ByteBuffer.wrap(FilesKt.readBytes((File)this.getFile())) : ByteBuffer.allocate(8);
        if (data.remaining() >= 8) {
            this.setValue(data.getLong());
        }
    }

    public final void save() {
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.putLong(this.getValue());
        File file = this.getFile();
        byte[] byArray = buf.array();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"array(...)");
        FilesKt.writeBytes((File)file, (byte[])byArray);
    }

    private static final File file_delegate$lambda$0() {
        return PlatformUtil.Companion.gameDir().resolve(".tbs").toFile();
    }
}


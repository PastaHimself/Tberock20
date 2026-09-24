/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtIo
 *  net.minecraft.nbt.Tag
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.data;

import io.wispforest.endec.Endec;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.Tag;
import net.thebrokenscript.api.data.BookInfo;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/data/BookLoader;", "", "<init>", "()V", "getBook", "Lnet/thebrokenscript/api/data/BookInfo;", "name", "", "thebrokenscript-common"})
public final class BookLoader {
    @NotNull
    public static final BookLoader INSTANCE = new BookLoader();

    private BookLoader() {
    }

    @Nullable
    public final BookInfo getBook(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        InputStream inputStream = BookLoader.class.getResourceAsStream("/books/" + name + ".book");
        if (inputStream == null) {
            return null;
        }
        InputStream res = inputStream;
        DataInputStream stream = new DataInputStream(res);
        CompoundTag nbt = NbtIo.read((DataInput)stream);
        Endec endec2 = (Endec)BookInfo.Companion.getENDEC();
        Intrinsics.checkNotNull((Object)nbt);
        return (BookInfo)EndecExt.INSTANCE.tryDecodeNbt(endec2, (Tag)nbt);
    }
}


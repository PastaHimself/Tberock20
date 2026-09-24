/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/UniqueMutableList;", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "add", "", "e", "(Ljava/lang/Object;)Z", "set", "index", "", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "brokencore-common"})
public final class UniqueMutableList<E>
extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        boolean valid;
        boolean bl = valid = !this.contains(e);
        if (valid) {
            super.add(e);
        }
        return valid;
    }

    @Override
    public E set(int index, E element) {
        if (index < this.size() && !this.contains(element)) {
            super.set(index, element);
        }
        return element;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.boss.integrity.IntroSubtitlesKt;
import net.thebrokenscript.boss.integrity.SubtitleEntry;
import net.thebrokenscript.config.client.MenuMode;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u008b\u0001\n\u0002\u0010 \n\u0003\b\u00da\u0001\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u00ea\u0002\u001a\u00020\u00052\b\u0010\u00eb\u0002\u001a\u00030\u00ec\u00022\b\u0010\u00ed\u0002\u001a\u00030\u00ec\u0002H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0011\u0010^\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0011\u0010`\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0007R\u0011\u0010l\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0007R\u0011\u0010n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0007R\u0011\u0010p\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0007R\u0011\u0010r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0007R\u0011\u0010x\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010\u0007R\u0011\u0010z\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0007R\u0011\u0010|\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0007R\u0011\u0010~\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0007R\u0013\u0010\u0080\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0007R\u0013\u0010\u0082\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007R\u0013\u0010\u0084\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0007R\u0013\u0010\u0086\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0007R\u0013\u0010\u0088\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0007R\u0013\u0010\u008a\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0007R\u0013\u0010\u008c\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0007R\u0013\u0010\u008e\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0007R\u001b\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001b\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0093\u0001R\u001b\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u0093\u0001R\u0013\u0010\u009a\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u0007R\u0013\u0010\u009c\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010\u0007R\u001b\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0093\u0001R\u0013\u0010\u00a0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a1\u0001\u0010\u0007R\u0013\u0010\u00a2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a3\u0001\u0010\u0007R\u0013\u0010\u00a4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a5\u0001\u0010\u0007R\u0013\u0010\u00a6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a7\u0001\u0010\u0007R\u0013\u0010\u00a8\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a9\u0001\u0010\u0007R\u0013\u0010\u00aa\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ab\u0001\u0010\u0007R\u0013\u0010\u00ac\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ad\u0001\u0010\u0007R\u0013\u0010\u00ae\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00af\u0001\u0010\u0007R\u0013\u0010\u00b0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b1\u0001\u0010\u0007R\u0013\u0010\u00b2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b3\u0001\u0010\u0007R\u0013\u0010\u00b4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b5\u0001\u0010\u0007R\u0013\u0010\u00b6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b7\u0001\u0010\u0007R\u0013\u0010\u00b8\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b9\u0001\u0010\u0007R\u0013\u0010\u00ba\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bb\u0001\u0010\u0007R\u0013\u0010\u00bc\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bd\u0001\u0010\u0007R\u0013\u0010\u00be\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bf\u0001\u0010\u0007R\u0013\u0010\u00c0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c1\u0001\u0010\u0007R\u0013\u0010\u00c2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c3\u0001\u0010\u0007R\u0013\u0010\u00c4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c5\u0001\u0010\u0007R\u0013\u0010\u00c6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c7\u0001\u0010\u0007R\u0013\u0010\u00c8\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c9\u0001\u0010\u0007R\u0013\u0010\u00ca\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cb\u0001\u0010\u0007R\u0013\u0010\u00cc\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cd\u0001\u0010\u0007R\u0013\u0010\u00ce\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cf\u0001\u0010\u0007R\u0013\u0010\u00d0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d1\u0001\u0010\u0007R\u0013\u0010\u00d2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d3\u0001\u0010\u0007R\u0013\u0010\u00d4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d5\u0001\u0010\u0007R\u0013\u0010\u00d6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d7\u0001\u0010\u0007R\u0013\u0010\u00d8\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d9\u0001\u0010\u0007R\u0013\u0010\u00da\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00db\u0001\u0010\u0007R\u0013\u0010\u00dc\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00dd\u0001\u0010\u0007R\u0013\u0010\u00de\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00df\u0001\u0010\u0007R\u0013\u0010\u00e0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e1\u0001\u0010\u0007R\u0013\u0010\u00e2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e3\u0001\u0010\u0007R\u0013\u0010\u00e4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e5\u0001\u0010\u0007R\u0013\u0010\u00e6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e7\u0001\u0010\u0007R\u001b\u0010\u00e8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00e9\u0001\u0010\u0093\u0001R\u001b\u0010\u00ea\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00eb\u0001\u0010\u0093\u0001R\u001b\u0010\u00ec\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0091\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00ed\u0001\u0010\u0093\u0001R\u0013\u0010\u00ee\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ef\u0001\u0010\u0007R\u0013\u0010\u00f0\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00f1\u0001\u0010\u0007R\u0013\u0010\u00f2\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00f3\u0001\u0010\u0007R\u0013\u0010\u00f4\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00f5\u0001\u0010\u0007R\u0013\u0010\u00f6\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00f7\u0001\u0010\u0007R\u0013\u0010\u00f8\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00f9\u0001\u0010\u0007R\u0013\u0010\u00fa\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00fb\u0001\u0010\u0007R\u0013\u0010\u00fc\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00fd\u0001\u0010\u0007R\u0013\u0010\u00fe\u0001\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ff\u0001\u0010\u0007R\u0013\u0010\u0080\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0081\u0002\u0010\u0007R\u0013\u0010\u0082\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0083\u0002\u0010\u0007R\u0013\u0010\u0084\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0085\u0002\u0010\u0007R\u0013\u0010\u0086\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0087\u0002\u0010\u0007R\u0013\u0010\u0088\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0089\u0002\u0010\u0007R\u0013\u0010\u008a\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008b\u0002\u0010\u0007R\u0013\u0010\u008c\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008d\u0002\u0010\u0007R\u0013\u0010\u008e\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008f\u0002\u0010\u0007R\u0013\u0010\u0090\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0091\u0002\u0010\u0007R\u0013\u0010\u0092\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0093\u0002\u0010\u0007R\u0013\u0010\u0094\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0095\u0002\u0010\u0007R\u0013\u0010\u0096\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0097\u0002\u0010\u0007R\u0013\u0010\u0098\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0099\u0002\u0010\u0007R\u0013\u0010\u009a\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009b\u0002\u0010\u0007R\u0013\u0010\u009c\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009d\u0002\u0010\u0007R\u0013\u0010\u009e\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009f\u0002\u0010\u0007R\u0013\u0010\u00a0\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a1\u0002\u0010\u0007R\u0013\u0010\u00a2\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a3\u0002\u0010\u0007R\u0013\u0010\u00a4\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a5\u0002\u0010\u0007R\u0013\u0010\u00a6\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a7\u0002\u0010\u0007R\u0013\u0010\u00a8\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a9\u0002\u0010\u0007R\u0013\u0010\u00aa\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ab\u0002\u0010\u0007R\u0013\u0010\u00ac\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00ad\u0002\u0010\u0007R\u0013\u0010\u00ae\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00af\u0002\u0010\u0007R\u0013\u0010\u00b0\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b1\u0002\u0010\u0007R\u0013\u0010\u00b2\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b3\u0002\u0010\u0007R\u0013\u0010\u00b4\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b5\u0002\u0010\u0007R\u0013\u0010\u00b6\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b7\u0002\u0010\u0007R\u0013\u0010\u00b8\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b9\u0002\u0010\u0007R\u0013\u0010\u00ba\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bb\u0002\u0010\u0007R\u0013\u0010\u00bc\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bd\u0002\u0010\u0007R\u0013\u0010\u00be\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00bf\u0002\u0010\u0007R\u0013\u0010\u00c0\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c1\u0002\u0010\u0007R\u0013\u0010\u00c2\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c3\u0002\u0010\u0007R\u0013\u0010\u00c4\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c5\u0002\u0010\u0007R\u0013\u0010\u00c6\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c7\u0002\u0010\u0007R\u0013\u0010\u00c8\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c9\u0002\u0010\u0007R\u0013\u0010\u00ca\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cb\u0002\u0010\u0007R\u0013\u0010\u00cc\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cd\u0002\u0010\u0007R\u0013\u0010\u00ce\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00cf\u0002\u0010\u0007R\u0013\u0010\u00d0\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d1\u0002\u0010\u0007R\u0013\u0010\u00d2\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d3\u0002\u0010\u0007R\u0013\u0010\u00d4\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d5\u0002\u0010\u0007R\u0013\u0010\u00d6\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d7\u0002\u0010\u0007R\u0013\u0010\u00d8\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00d9\u0002\u0010\u0007R\u0013\u0010\u00da\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00db\u0002\u0010\u0007R\u0013\u0010\u00dc\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00dd\u0002\u0010\u0007R\u0013\u0010\u00de\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00df\u0002\u0010\u0007R\u0013\u0010\u00e0\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e1\u0002\u0010\u0007R\u0013\u0010\u00e2\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e3\u0002\u0010\u0007R\u0013\u0010\u00e4\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e5\u0002\u0010\u0007R\u0013\u0010\u00e6\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e7\u0002\u0010\u0007R\u0013\u0010\u00e8\u0002\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00e9\u0002\u0010\u0007\u00a8\u0006\u00ee\u0002"}, d2={"Lnet/thebrokenscript/registry/TBSLang;", "", "<init>", "()V", "NOSTALGIA_HELPER", "Lnet/minecraft/network/chat/MutableComponent;", "getNOSTALGIA_HELPER", "()Lnet/minecraft/network/chat/MutableComponent;", "NOSTALGIA_HELPER_DATA", "getNOSTALGIA_HELPER_DATA", "TBS_VER", "getTBS_VER", "EYE", "getEYE", "CMD_ERROR_NOT_PLAYER", "getCMD_ERROR_NOT_PLAYER", "CMD_SET_SUCCESS", "getCMD_SET_SUCCESS", "FX_ON", "getFX_ON", "FX_OFF", "getFX_OFF", "FX_TOGGLE_ON", "getFX_TOGGLE_ON", "FX_TOGGLE_OFF", "getFX_TOGGLE_OFF", "FX_ABERRATION", "getFX_ABERRATION", "FX_VHS", "getFX_VHS", "FX_MOON_GLITCH", "getFX_MOON_GLITCH", "FX_TEXT_GLITCH", "getFX_TEXT_GLITCH", "FX_CUSTOM_SKY", "getFX_CUSTOM_SKY", "FX_SKY_BLUE", "getFX_SKY_BLUE", "FX_SCREEN_DUPE", "getFX_SCREEN_DUPE", "FX_LUCID_EFFECT", "getFX_LUCID_EFFECT", "FX_META_PARANOIA", "getFX_META_PARANOIA", "FX_GLITCHES", "getFX_GLITCHES", "FX_VOID_BOX", "getFX_VOID_BOX", "FX_DREAM", "getFX_DREAM", "FX_INVERT", "getFX_INVERT", "DEOP_COMMAND_FAIL", "getDEOP_COMMAND_FAIL", "KICK_COMMAND_FAIL", "getKICK_COMMAND_FAIL", "GIVE_COMMAND_FAIL", "getGIVE_COMMAND_FAIL", "TP_COMMAND_FAIL", "getTP_COMMAND_FAIL", "CMD_INHABIT_SUCCESS", "getCMD_INHABIT_SUCCESS", "CONSOLE_NAME", "getCONSOLE_NAME", "COMMAND_NAME", "getCOMMAND_NAME", "COMMAND_BLOCK_FRESH", "getCOMMAND_BLOCK_FRESH", "COMMAND_BLOCK_PLACED", "getCOMMAND_BLOCK_PLACED", "COMMAND_BLOCK_TOO_FAR", "getCOMMAND_BLOCK_TOO_FAR", "COMMAND_BLOCK_COLDER", "getCOMMAND_BLOCK_COLDER", "COMMAND_BLOCK_WARMER", "getCOMMAND_BLOCK_WARMER", "COMMAND_BLOCK_FOUND", "getCOMMAND_BLOCK_FOUND", "COMMAND_BLOCK_WRONG_DIM", "getCOMMAND_BLOCK_WRONG_DIM", "COMMAND_DESC", "getCOMMAND_DESC", "DESYNCER_RESYNC", "getDESYNCER_RESYNC", "DESYNCER_DESYNC", "getDESYNCER_DESYNC", "GLAGGLE_TOOLTIP", "getGLAGGLE_TOOLTIP", "LILLY_TOOLTIP", "getLILLY_TOOLTIP", "TBS_STRUCTURE_TOOLTIP", "getTBS_STRUCTURE_TOOLTIP", "PHANTOM_PLAYER_NAME", "getPHANTOM_PLAYER_NAME", "NIW_KICK", "getNIW_KICK", "CIRCUIT_KICK_1", "getCIRCUIT_KICK_1", "CIRCUIT_KICK_2", "getCIRCUIT_KICK_2", "NULL_CHASE_KICK", "getNULL_CHASE_KICK", "NULL_MAZE_KICK", "getNULL_MAZE_KICK", "NULL_ENDGAME_CHAT_1", "getNULL_ENDGAME_CHAT_1", "NULL_ENDGAME_CHAT_2", "getNULL_ENDGAME_CHAT_2", "NULL_FLYING_NAME", "getNULL_FLYING_NAME", "NULL_INVADE_BASE_CHAT_1", "getNULL_INVADE_BASE_CHAT_1", "NULL_INVADE_BASE_CHAT_2", "getNULL_INVADE_BASE_CHAT_2", "NULL_SCARE_NAME", "getNULL_SCARE_NAME", "RAM2DIE_NAME", "getRAM2DIE_NAME", "RAM2DIE_HOSTED", "getRAM2DIE_HOSTED", "RAM2DIE_JOIN", "getRAM2DIE_JOIN", "RAM2DIE_CHAT_MSG", "getRAM2DIE_CHAT_MSG", "RAM2DIE_LEAVE", "getRAM2DIE_LEAVE", "TBE_KICK", "getTBE_KICK", "CURVED_NAME", "getCURVED_NAME", "CURVED_DEATH", "getCURVED_DEATH", "CURVED_DEATH_UNKNOWN", "getCURVED_DEATH_UNKNOWN", "CURVED_LEAVE", "getCURVED_LEAVE", "LIBERTY", "getLIBERTY", "VILLAGER_NICK", "getVILLAGER_NICK", "RANDOM_NICK_1", "getRANDOM_NICK_1", "RANDOM_NICK_2", "getRANDOM_NICK_2", "NULL_TITLES", "", "getNULL_TITLES", "()Ljava/util/List;", "NULL_MESSAGES", "getNULL_MESSAGES", "CAVE_MESSAGES", "getCAVE_MESSAGES", "SCARED_MESSAGES", "getSCARED_MESSAGES", "OPENGL_INVALID_OPERATION", "getOPENGL_INVALID_OPERATION", "OPENGL_HERE_I_AM", "getOPENGL_HERE_I_AM", "TEXT_EVENT_MESSAGES", "getTEXT_EVENT_MESSAGES", "NULL_BOOK_CONTENT", "getNULL_BOOK_CONTENT", "NULL_TITLE", "getNULL_TITLE", "MADNESS_MESSAGE", "getMADNESS_MESSAGE", "DISCONNECTED_1", "getDISCONNECTED_1", "DISCONNECTED_2", "getDISCONNECTED_2", "DISCONNECTED_3", "getDISCONNECTED_3", "USER_COLLINLOCK", "getUSER_COLLINLOCK", "COLLINLOCK_MSG", "getCOLLINLOCK_MSG", "USER_NULL", "getUSER_NULL", "USER_CIRCUIT", "getUSER_CIRCUIT", "MSG_ADMIN", "getMSG_ADMIN", "MSG_ITS_ME", "getMSG_ITS_ME", "MSG_CYSM_YES", "getMSG_CYSM_YES", "MSG_CYSM_HELLO", "getMSG_CYSM_HELLO", "MSG_ALL_HIS_FAULT", "getMSG_ALL_HIS_FAULT", "MSG_HOME", "getMSG_HOME", "MSG_ENT303", "getMSG_ENT303", "MSG_FOLLOW", "getMSG_FOLLOW", "MSG_HELLO", "getMSG_HELLO", "MSG_HELP", "getMSG_HELP", "MSG_INTEG", "getMSG_INTEG", "MSG_NIW", "getMSG_NIW", "MSG_NULL_1", "getMSG_NULL_1", "MSG_NULL_2", "getMSG_NULL_2", "MSG_R2D", "getMSG_R2D", "MSG_REV", "getMSG_REV", "MSG_STEVE", "getMSG_STEVE", "MSG_WANT", "getMSG_WANT", "MSG_WHO", "getMSG_WHO", "MSG_WHYER4", "getMSG_WHYER4", "MSG_BLACKOUT", "getMSG_BLACKOUT", "MSG_CATFISH12", "getMSG_CATFISH12", "MSG_FRIEND", "getMSG_FRIEND", "MSG_OVERLORD", "getMSG_OVERLORD", "MSG_DYEXD", "getMSG_DYEXD", "MSG_CAL", "getMSG_CAL", "UNKNOWN_RESPONSE_MESSAGES", "getUNKNOWN_RESPONSE_MESSAGES", "FEVER_ENTRY_MESSAGES", "getFEVER_ENTRY_MESSAGES", "FEVER_RANDOM_MESSAGES", "getFEVER_RANDOM_MESSAGES", "FEVER_MSG_HELLO", "getFEVER_MSG_HELLO", "FEVER_MSG_WHERE", "getFEVER_MSG_WHERE", "FEVER_MSG_WHAT", "getFEVER_MSG_WHAT", "FEVER_MSG_WHO", "getFEVER_MSG_WHO", "FEVER_MSG_INSULT", "getFEVER_MSG_INSULT", "FEVER_MSG_WANT", "getFEVER_MSG_WANT", "FEVER_MSG_SKY", "getFEVER_MSG_SKY", "FEVER_MSG_HOMES", "getFEVER_MSG_HOMES", "ALT_MC_VER", "getALT_MC_VER", "NULL_INTERFACE_1_NAME", "getNULL_INTERFACE_1_NAME", "NULL_INTERFACE_2_NAME", "getNULL_INTERFACE_2_NAME", "NULL_INTERFACE_3_NAME", "getNULL_INTERFACE_3_NAME", "NULLED_GUI", "getNULLED_GUI", "WARNING_TITLE", "getWARNING_TITLE", "WARNING_TOP", "getWARNING_TOP", "WARNING_LINE_1", "getWARNING_LINE_1", "WARNING_LINE_2", "getWARNING_LINE_2", "WARNING_LINE_3", "getWARNING_LINE_3", "WARNING_EXTRA", "getWARNING_EXTRA", "WARNING_BOTTOM", "getWARNING_BOTTOM", "MARK_TITLE", "getMARK_TITLE", "MARK_LINE_1", "getMARK_LINE_1", "MARK_LINE_2", "getMARK_LINE_2", "MARK_LINE_3", "getMARK_LINE_3", "MARK_LINE_4", "getMARK_LINE_4", "BUTTON_CONTINUE", "getBUTTON_CONTINUE", "TOGGLE_SHOW_AGAIN", "getTOGGLE_SHOW_AGAIN", "BUTTON_QUIT_ALT", "getBUTTON_QUIT_ALT", "BUTTON_QUIT_ALT_2", "getBUTTON_QUIT_ALT_2", "BECOME_VOID", "getBECOME_VOID", "CHAT_ENGINE_1", "getCHAT_ENGINE_1", "CHAT_ENGINE_2", "getCHAT_ENGINE_2", "DEBUG_MEASURE", "getDEBUG_MEASURE", "HARDWARE_TITLE", "getHARDWARE_TITLE", "HARDWARE_LINE_1_FUNNY", "getHARDWARE_LINE_1_FUNNY", "HARDWARE_LINE_1", "getHARDWARE_LINE_1", "HARDWARE_LINE_2", "getHARDWARE_LINE_2", "HARDWARE_LINE_3", "getHARDWARE_LINE_3", "HARDWARE_LINE_4", "getHARDWARE_LINE_4", "HARDWARE_LINE_5", "getHARDWARE_LINE_5", "HARDWARE_LINE_6", "getHARDWARE_LINE_6", "HARDWARE_LINE_7", "getHARDWARE_LINE_7", "HARDWARE_CONFIRM", "getHARDWARE_CONFIRM", "HARDWARE_ENABLED", "getHARDWARE_ENABLED", "HARDWARE_DISABLED", "getHARDWARE_DISABLED", "HARDWARE_SHOW_ONCE", "getHARDWARE_SHOW_ONCE", "HARDWARE_CONTINUE", "getHARDWARE_CONTINUE", "TESTER_TITLE", "getTESTER_TITLE", "TESTER_LINE_1", "getTESTER_LINE_1", "TESTER_LINE_2", "getTESTER_LINE_2", "TESTER_LINE_3", "getTESTER_LINE_3", "TESTER_LINE_4", "getTESTER_LINE_4", "TESTER_LINE_5", "getTESTER_LINE_5", "TESTER_LINE_6", "getTESTER_LINE_6", "TESTER_LINE_7", "getTESTER_LINE_7", "DEFAULT_TITLE", "getDEFAULT_TITLE", "ALT_TITLE", "getALT_TITLE", "NO_ESCAPE_TITLE", "getNO_ESCAPE_TITLE", "ALERT_TITLE", "getALERT_TITLE", "ALERT_HERE_I_AM", "getALERT_HERE_I_AM", "ALERT_ERR_PLAYER", "getALERT_ERR_PLAYER", "ALERT_END_GAME", "getALERT_END_GAME", "lang", "key", "", "value", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSLang.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSLang.kt\nnet/thebrokenscript/registry/TBSLang\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,497:1\n1573#2:498\n1604#2,4:499\n1573#2:503\n1604#2,4:504\n1573#2:508\n1604#2,4:509\n1573#2:513\n1604#2,4:514\n1573#2:518\n1604#2,4:519\n1573#2:523\n1604#2,4:524\n1573#2:528\n1604#2,4:529\n1573#2:533\n1604#2,4:534\n*S KotlinDebug\n*F\n+ 1 TBSLang.kt\nnet/thebrokenscript/registry/TBSLang\n*L\n145#1:498\n145#1:499,4\n158#1:503\n158#1:504,4\n175#1:508\n175#1:509,4\n193#1:513\n193#1:514,4\n220#1:518\n220#1:519,4\n322#1:523\n322#1:524,4\n330#1:528\n330#1:529,4\n346#1:533\n346#1:534,4\n*E\n"})
public final class TBSLang {
    @NotNull
    public static final TBSLang INSTANCE;
    @NotNull
    private static final MutableComponent NOSTALGIA_HELPER;
    @NotNull
    private static final MutableComponent NOSTALGIA_HELPER_DATA;
    @NotNull
    private static final MutableComponent TBS_VER;
    @NotNull
    private static final MutableComponent EYE;
    @NotNull
    private static final MutableComponent CMD_ERROR_NOT_PLAYER;
    @NotNull
    private static final MutableComponent CMD_SET_SUCCESS;
    @NotNull
    private static final MutableComponent FX_ON;
    @NotNull
    private static final MutableComponent FX_OFF;
    @NotNull
    private static final MutableComponent FX_TOGGLE_ON;
    @NotNull
    private static final MutableComponent FX_TOGGLE_OFF;
    @NotNull
    private static final MutableComponent FX_ABERRATION;
    @NotNull
    private static final MutableComponent FX_VHS;
    @NotNull
    private static final MutableComponent FX_MOON_GLITCH;
    @NotNull
    private static final MutableComponent FX_TEXT_GLITCH;
    @NotNull
    private static final MutableComponent FX_CUSTOM_SKY;
    @NotNull
    private static final MutableComponent FX_SKY_BLUE;
    @NotNull
    private static final MutableComponent FX_SCREEN_DUPE;
    @NotNull
    private static final MutableComponent FX_LUCID_EFFECT;
    @NotNull
    private static final MutableComponent FX_META_PARANOIA;
    @NotNull
    private static final MutableComponent FX_GLITCHES;
    @NotNull
    private static final MutableComponent FX_VOID_BOX;
    @NotNull
    private static final MutableComponent FX_DREAM;
    @NotNull
    private static final MutableComponent FX_INVERT;
    @NotNull
    private static final MutableComponent DEOP_COMMAND_FAIL;
    @NotNull
    private static final MutableComponent KICK_COMMAND_FAIL;
    @NotNull
    private static final MutableComponent GIVE_COMMAND_FAIL;
    @NotNull
    private static final MutableComponent TP_COMMAND_FAIL;
    @NotNull
    private static final MutableComponent CMD_INHABIT_SUCCESS;
    @NotNull
    private static final MutableComponent CONSOLE_NAME;
    @NotNull
    private static final MutableComponent COMMAND_NAME;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_FRESH;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_PLACED;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_TOO_FAR;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_COLDER;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_WARMER;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_FOUND;
    @NotNull
    private static final MutableComponent COMMAND_BLOCK_WRONG_DIM;
    @NotNull
    private static final MutableComponent COMMAND_DESC;
    @NotNull
    private static final MutableComponent DESYNCER_RESYNC;
    @NotNull
    private static final MutableComponent DESYNCER_DESYNC;
    @NotNull
    private static final MutableComponent GLAGGLE_TOOLTIP;
    @NotNull
    private static final MutableComponent LILLY_TOOLTIP;
    @NotNull
    private static final MutableComponent TBS_STRUCTURE_TOOLTIP;
    @NotNull
    private static final MutableComponent PHANTOM_PLAYER_NAME;
    @NotNull
    private static final MutableComponent NIW_KICK;
    @NotNull
    private static final MutableComponent CIRCUIT_KICK_1;
    @NotNull
    private static final MutableComponent CIRCUIT_KICK_2;
    @NotNull
    private static final MutableComponent NULL_CHASE_KICK;
    @NotNull
    private static final MutableComponent NULL_MAZE_KICK;
    @NotNull
    private static final MutableComponent NULL_ENDGAME_CHAT_1;
    @NotNull
    private static final MutableComponent NULL_ENDGAME_CHAT_2;
    @NotNull
    private static final MutableComponent NULL_FLYING_NAME;
    @NotNull
    private static final MutableComponent NULL_INVADE_BASE_CHAT_1;
    @NotNull
    private static final MutableComponent NULL_INVADE_BASE_CHAT_2;
    @NotNull
    private static final MutableComponent NULL_SCARE_NAME;
    @NotNull
    private static final MutableComponent RAM2DIE_NAME;
    @NotNull
    private static final MutableComponent RAM2DIE_HOSTED;
    @NotNull
    private static final MutableComponent RAM2DIE_JOIN;
    @NotNull
    private static final MutableComponent RAM2DIE_CHAT_MSG;
    @NotNull
    private static final MutableComponent RAM2DIE_LEAVE;
    @NotNull
    private static final MutableComponent TBE_KICK;
    @NotNull
    private static final MutableComponent CURVED_NAME;
    @NotNull
    private static final MutableComponent CURVED_DEATH;
    @NotNull
    private static final MutableComponent CURVED_DEATH_UNKNOWN;
    @NotNull
    private static final MutableComponent CURVED_LEAVE;
    @NotNull
    private static final MutableComponent LIBERTY;
    @NotNull
    private static final MutableComponent VILLAGER_NICK;
    @NotNull
    private static final MutableComponent RANDOM_NICK_1;
    @NotNull
    private static final MutableComponent RANDOM_NICK_2;
    @NotNull
    private static final List<MutableComponent> NULL_TITLES;
    @NotNull
    private static final List<MutableComponent> NULL_MESSAGES;
    @NotNull
    private static final List<MutableComponent> CAVE_MESSAGES;
    @NotNull
    private static final List<MutableComponent> SCARED_MESSAGES;
    @NotNull
    private static final MutableComponent OPENGL_INVALID_OPERATION;
    @NotNull
    private static final MutableComponent OPENGL_HERE_I_AM;
    @NotNull
    private static final List<MutableComponent> TEXT_EVENT_MESSAGES;
    @NotNull
    private static final MutableComponent NULL_BOOK_CONTENT;
    @NotNull
    private static final MutableComponent NULL_TITLE;
    @NotNull
    private static final MutableComponent MADNESS_MESSAGE;
    @NotNull
    private static final MutableComponent DISCONNECTED_1;
    @NotNull
    private static final MutableComponent DISCONNECTED_2;
    @NotNull
    private static final MutableComponent DISCONNECTED_3;
    @NotNull
    private static final MutableComponent USER_COLLINLOCK;
    @NotNull
    private static final MutableComponent COLLINLOCK_MSG;
    @NotNull
    private static final MutableComponent USER_NULL;
    @NotNull
    private static final MutableComponent USER_CIRCUIT;
    @NotNull
    private static final MutableComponent MSG_ADMIN;
    @NotNull
    private static final MutableComponent MSG_ITS_ME;
    @NotNull
    private static final MutableComponent MSG_CYSM_YES;
    @NotNull
    private static final MutableComponent MSG_CYSM_HELLO;
    @NotNull
    private static final MutableComponent MSG_ALL_HIS_FAULT;
    @NotNull
    private static final MutableComponent MSG_HOME;
    @NotNull
    private static final MutableComponent MSG_ENT303;
    @NotNull
    private static final MutableComponent MSG_FOLLOW;
    @NotNull
    private static final MutableComponent MSG_HELLO;
    @NotNull
    private static final MutableComponent MSG_HELP;
    @NotNull
    private static final MutableComponent MSG_INTEG;
    @NotNull
    private static final MutableComponent MSG_NIW;
    @NotNull
    private static final MutableComponent MSG_NULL_1;
    @NotNull
    private static final MutableComponent MSG_NULL_2;
    @NotNull
    private static final MutableComponent MSG_R2D;
    @NotNull
    private static final MutableComponent MSG_REV;
    @NotNull
    private static final MutableComponent MSG_STEVE;
    @NotNull
    private static final MutableComponent MSG_WANT;
    @NotNull
    private static final MutableComponent MSG_WHO;
    @NotNull
    private static final MutableComponent MSG_WHYER4;
    @NotNull
    private static final MutableComponent MSG_BLACKOUT;
    @NotNull
    private static final MutableComponent MSG_CATFISH12;
    @NotNull
    private static final MutableComponent MSG_FRIEND;
    @NotNull
    private static final MutableComponent MSG_OVERLORD;
    @NotNull
    private static final MutableComponent MSG_DYEXD;
    @NotNull
    private static final MutableComponent MSG_CAL;
    @NotNull
    private static final List<MutableComponent> UNKNOWN_RESPONSE_MESSAGES;
    @NotNull
    private static final List<MutableComponent> FEVER_ENTRY_MESSAGES;
    @NotNull
    private static final List<MutableComponent> FEVER_RANDOM_MESSAGES;
    @NotNull
    private static final MutableComponent FEVER_MSG_HELLO;
    @NotNull
    private static final MutableComponent FEVER_MSG_WHERE;
    @NotNull
    private static final MutableComponent FEVER_MSG_WHAT;
    @NotNull
    private static final MutableComponent FEVER_MSG_WHO;
    @NotNull
    private static final MutableComponent FEVER_MSG_INSULT;
    @NotNull
    private static final MutableComponent FEVER_MSG_WANT;
    @NotNull
    private static final MutableComponent FEVER_MSG_SKY;
    @NotNull
    private static final MutableComponent FEVER_MSG_HOMES;
    @NotNull
    private static final MutableComponent ALT_MC_VER;
    @NotNull
    private static final MutableComponent NULL_INTERFACE_1_NAME;
    @NotNull
    private static final MutableComponent NULL_INTERFACE_2_NAME;
    @NotNull
    private static final MutableComponent NULL_INTERFACE_3_NAME;
    @NotNull
    private static final MutableComponent NULLED_GUI;
    @NotNull
    private static final MutableComponent WARNING_TITLE;
    @NotNull
    private static final MutableComponent WARNING_TOP;
    @NotNull
    private static final MutableComponent WARNING_LINE_1;
    @NotNull
    private static final MutableComponent WARNING_LINE_2;
    @NotNull
    private static final MutableComponent WARNING_LINE_3;
    @NotNull
    private static final MutableComponent WARNING_EXTRA;
    @NotNull
    private static final MutableComponent WARNING_BOTTOM;
    @NotNull
    private static final MutableComponent MARK_TITLE;
    @NotNull
    private static final MutableComponent MARK_LINE_1;
    @NotNull
    private static final MutableComponent MARK_LINE_2;
    @NotNull
    private static final MutableComponent MARK_LINE_3;
    @NotNull
    private static final MutableComponent MARK_LINE_4;
    @NotNull
    private static final MutableComponent BUTTON_CONTINUE;
    @NotNull
    private static final MutableComponent TOGGLE_SHOW_AGAIN;
    @NotNull
    private static final MutableComponent BUTTON_QUIT_ALT;
    @NotNull
    private static final MutableComponent BUTTON_QUIT_ALT_2;
    @NotNull
    private static final MutableComponent BECOME_VOID;
    @NotNull
    private static final MutableComponent CHAT_ENGINE_1;
    @NotNull
    private static final MutableComponent CHAT_ENGINE_2;
    @NotNull
    private static final MutableComponent DEBUG_MEASURE;
    @NotNull
    private static final MutableComponent HARDWARE_TITLE;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_1_FUNNY;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_1;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_2;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_3;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_4;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_5;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_6;
    @NotNull
    private static final MutableComponent HARDWARE_LINE_7;
    @NotNull
    private static final MutableComponent HARDWARE_CONFIRM;
    @NotNull
    private static final MutableComponent HARDWARE_ENABLED;
    @NotNull
    private static final MutableComponent HARDWARE_DISABLED;
    @NotNull
    private static final MutableComponent HARDWARE_SHOW_ONCE;
    @NotNull
    private static final MutableComponent HARDWARE_CONTINUE;
    @NotNull
    private static final MutableComponent TESTER_TITLE;
    @NotNull
    private static final MutableComponent TESTER_LINE_1;
    @NotNull
    private static final MutableComponent TESTER_LINE_2;
    @NotNull
    private static final MutableComponent TESTER_LINE_3;
    @NotNull
    private static final MutableComponent TESTER_LINE_4;
    @NotNull
    private static final MutableComponent TESTER_LINE_5;
    @NotNull
    private static final MutableComponent TESTER_LINE_6;
    @NotNull
    private static final MutableComponent TESTER_LINE_7;
    @NotNull
    private static final MutableComponent DEFAULT_TITLE;
    @NotNull
    private static final MutableComponent ALT_TITLE;
    @NotNull
    private static final MutableComponent NO_ESCAPE_TITLE;
    @NotNull
    private static final MutableComponent ALERT_TITLE;
    @NotNull
    private static final MutableComponent ALERT_HERE_I_AM;
    @NotNull
    private static final MutableComponent ALERT_ERR_PLAYER;
    @NotNull
    private static final MutableComponent ALERT_END_GAME;

    private TBSLang() {
    }

    @NotNull
    public final MutableComponent getNOSTALGIA_HELPER() {
        return NOSTALGIA_HELPER;
    }

    @NotNull
    public final MutableComponent getNOSTALGIA_HELPER_DATA() {
        return NOSTALGIA_HELPER_DATA;
    }

    @NotNull
    public final MutableComponent getTBS_VER() {
        return TBS_VER;
    }

    @NotNull
    public final MutableComponent getEYE() {
        return EYE;
    }

    @NotNull
    public final MutableComponent getCMD_ERROR_NOT_PLAYER() {
        return CMD_ERROR_NOT_PLAYER;
    }

    @NotNull
    public final MutableComponent getCMD_SET_SUCCESS() {
        return CMD_SET_SUCCESS;
    }

    @NotNull
    public final MutableComponent getFX_ON() {
        return FX_ON;
    }

    @NotNull
    public final MutableComponent getFX_OFF() {
        return FX_OFF;
    }

    @NotNull
    public final MutableComponent getFX_TOGGLE_ON() {
        return FX_TOGGLE_ON;
    }

    @NotNull
    public final MutableComponent getFX_TOGGLE_OFF() {
        return FX_TOGGLE_OFF;
    }

    @NotNull
    public final MutableComponent getFX_ABERRATION() {
        return FX_ABERRATION;
    }

    @NotNull
    public final MutableComponent getFX_VHS() {
        return FX_VHS;
    }

    @NotNull
    public final MutableComponent getFX_MOON_GLITCH() {
        return FX_MOON_GLITCH;
    }

    @NotNull
    public final MutableComponent getFX_TEXT_GLITCH() {
        return FX_TEXT_GLITCH;
    }

    @NotNull
    public final MutableComponent getFX_CUSTOM_SKY() {
        return FX_CUSTOM_SKY;
    }

    @NotNull
    public final MutableComponent getFX_SKY_BLUE() {
        return FX_SKY_BLUE;
    }

    @NotNull
    public final MutableComponent getFX_SCREEN_DUPE() {
        return FX_SCREEN_DUPE;
    }

    @NotNull
    public final MutableComponent getFX_LUCID_EFFECT() {
        return FX_LUCID_EFFECT;
    }

    @NotNull
    public final MutableComponent getFX_META_PARANOIA() {
        return FX_META_PARANOIA;
    }

    @NotNull
    public final MutableComponent getFX_GLITCHES() {
        return FX_GLITCHES;
    }

    @NotNull
    public final MutableComponent getFX_VOID_BOX() {
        return FX_VOID_BOX;
    }

    @NotNull
    public final MutableComponent getFX_DREAM() {
        return FX_DREAM;
    }

    @NotNull
    public final MutableComponent getFX_INVERT() {
        return FX_INVERT;
    }

    @NotNull
    public final MutableComponent getDEOP_COMMAND_FAIL() {
        return DEOP_COMMAND_FAIL;
    }

    @NotNull
    public final MutableComponent getKICK_COMMAND_FAIL() {
        return KICK_COMMAND_FAIL;
    }

    @NotNull
    public final MutableComponent getGIVE_COMMAND_FAIL() {
        return GIVE_COMMAND_FAIL;
    }

    @NotNull
    public final MutableComponent getTP_COMMAND_FAIL() {
        return TP_COMMAND_FAIL;
    }

    @NotNull
    public final MutableComponent getCMD_INHABIT_SUCCESS() {
        return CMD_INHABIT_SUCCESS;
    }

    @NotNull
    public final MutableComponent getCONSOLE_NAME() {
        return CONSOLE_NAME;
    }

    @NotNull
    public final MutableComponent getCOMMAND_NAME() {
        return COMMAND_NAME;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_FRESH() {
        return COMMAND_BLOCK_FRESH;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_PLACED() {
        return COMMAND_BLOCK_PLACED;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_TOO_FAR() {
        return COMMAND_BLOCK_TOO_FAR;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_COLDER() {
        return COMMAND_BLOCK_COLDER;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_WARMER() {
        return COMMAND_BLOCK_WARMER;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_FOUND() {
        return COMMAND_BLOCK_FOUND;
    }

    @NotNull
    public final MutableComponent getCOMMAND_BLOCK_WRONG_DIM() {
        return COMMAND_BLOCK_WRONG_DIM;
    }

    @NotNull
    public final MutableComponent getCOMMAND_DESC() {
        return COMMAND_DESC;
    }

    @NotNull
    public final MutableComponent getDESYNCER_RESYNC() {
        return DESYNCER_RESYNC;
    }

    @NotNull
    public final MutableComponent getDESYNCER_DESYNC() {
        return DESYNCER_DESYNC;
    }

    @NotNull
    public final MutableComponent getGLAGGLE_TOOLTIP() {
        return GLAGGLE_TOOLTIP;
    }

    @NotNull
    public final MutableComponent getLILLY_TOOLTIP() {
        return LILLY_TOOLTIP;
    }

    @NotNull
    public final MutableComponent getTBS_STRUCTURE_TOOLTIP() {
        return TBS_STRUCTURE_TOOLTIP;
    }

    @NotNull
    public final MutableComponent getPHANTOM_PLAYER_NAME() {
        return PHANTOM_PLAYER_NAME;
    }

    @NotNull
    public final MutableComponent getNIW_KICK() {
        return NIW_KICK;
    }

    @NotNull
    public final MutableComponent getCIRCUIT_KICK_1() {
        return CIRCUIT_KICK_1;
    }

    @NotNull
    public final MutableComponent getCIRCUIT_KICK_2() {
        return CIRCUIT_KICK_2;
    }

    @NotNull
    public final MutableComponent getNULL_CHASE_KICK() {
        return NULL_CHASE_KICK;
    }

    @NotNull
    public final MutableComponent getNULL_MAZE_KICK() {
        return NULL_MAZE_KICK;
    }

    @NotNull
    public final MutableComponent getNULL_ENDGAME_CHAT_1() {
        return NULL_ENDGAME_CHAT_1;
    }

    @NotNull
    public final MutableComponent getNULL_ENDGAME_CHAT_2() {
        return NULL_ENDGAME_CHAT_2;
    }

    @NotNull
    public final MutableComponent getNULL_FLYING_NAME() {
        return NULL_FLYING_NAME;
    }

    @NotNull
    public final MutableComponent getNULL_INVADE_BASE_CHAT_1() {
        return NULL_INVADE_BASE_CHAT_1;
    }

    @NotNull
    public final MutableComponent getNULL_INVADE_BASE_CHAT_2() {
        return NULL_INVADE_BASE_CHAT_2;
    }

    @NotNull
    public final MutableComponent getNULL_SCARE_NAME() {
        return NULL_SCARE_NAME;
    }

    @NotNull
    public final MutableComponent getRAM2DIE_NAME() {
        return RAM2DIE_NAME;
    }

    @NotNull
    public final MutableComponent getRAM2DIE_HOSTED() {
        return RAM2DIE_HOSTED;
    }

    @NotNull
    public final MutableComponent getRAM2DIE_JOIN() {
        return RAM2DIE_JOIN;
    }

    @NotNull
    public final MutableComponent getRAM2DIE_CHAT_MSG() {
        return RAM2DIE_CHAT_MSG;
    }

    @NotNull
    public final MutableComponent getRAM2DIE_LEAVE() {
        return RAM2DIE_LEAVE;
    }

    @NotNull
    public final MutableComponent getTBE_KICK() {
        return TBE_KICK;
    }

    @NotNull
    public final MutableComponent getCURVED_NAME() {
        return CURVED_NAME;
    }

    @NotNull
    public final MutableComponent getCURVED_DEATH() {
        return CURVED_DEATH;
    }

    @NotNull
    public final MutableComponent getCURVED_DEATH_UNKNOWN() {
        return CURVED_DEATH_UNKNOWN;
    }

    @NotNull
    public final MutableComponent getCURVED_LEAVE() {
        return CURVED_LEAVE;
    }

    @NotNull
    public final MutableComponent getLIBERTY() {
        return LIBERTY;
    }

    @NotNull
    public final MutableComponent getVILLAGER_NICK() {
        return VILLAGER_NICK;
    }

    @NotNull
    public final MutableComponent getRANDOM_NICK_1() {
        return RANDOM_NICK_1;
    }

    @NotNull
    public final MutableComponent getRANDOM_NICK_2() {
        return RANDOM_NICK_2;
    }

    @NotNull
    public final List<MutableComponent> getNULL_TITLES() {
        return NULL_TITLES;
    }

    @NotNull
    public final List<MutableComponent> getNULL_MESSAGES() {
        return NULL_MESSAGES;
    }

    @NotNull
    public final List<MutableComponent> getCAVE_MESSAGES() {
        return CAVE_MESSAGES;
    }

    @NotNull
    public final List<MutableComponent> getSCARED_MESSAGES() {
        return SCARED_MESSAGES;
    }

    @NotNull
    public final MutableComponent getOPENGL_INVALID_OPERATION() {
        return OPENGL_INVALID_OPERATION;
    }

    @NotNull
    public final MutableComponent getOPENGL_HERE_I_AM() {
        return OPENGL_HERE_I_AM;
    }

    @NotNull
    public final List<MutableComponent> getTEXT_EVENT_MESSAGES() {
        return TEXT_EVENT_MESSAGES;
    }

    @NotNull
    public final MutableComponent getNULL_BOOK_CONTENT() {
        return NULL_BOOK_CONTENT;
    }

    @NotNull
    public final MutableComponent getNULL_TITLE() {
        return NULL_TITLE;
    }

    @NotNull
    public final MutableComponent getMADNESS_MESSAGE() {
        return MADNESS_MESSAGE;
    }

    @NotNull
    public final MutableComponent getDISCONNECTED_1() {
        return DISCONNECTED_1;
    }

    @NotNull
    public final MutableComponent getDISCONNECTED_2() {
        return DISCONNECTED_2;
    }

    @NotNull
    public final MutableComponent getDISCONNECTED_3() {
        return DISCONNECTED_3;
    }

    @NotNull
    public final MutableComponent getUSER_COLLINLOCK() {
        return USER_COLLINLOCK;
    }

    @NotNull
    public final MutableComponent getCOLLINLOCK_MSG() {
        return COLLINLOCK_MSG;
    }

    @NotNull
    public final MutableComponent getUSER_NULL() {
        return USER_NULL;
    }

    @NotNull
    public final MutableComponent getUSER_CIRCUIT() {
        return USER_CIRCUIT;
    }

    @NotNull
    public final MutableComponent getMSG_ADMIN() {
        return MSG_ADMIN;
    }

    @NotNull
    public final MutableComponent getMSG_ITS_ME() {
        return MSG_ITS_ME;
    }

    @NotNull
    public final MutableComponent getMSG_CYSM_YES() {
        return MSG_CYSM_YES;
    }

    @NotNull
    public final MutableComponent getMSG_CYSM_HELLO() {
        return MSG_CYSM_HELLO;
    }

    @NotNull
    public final MutableComponent getMSG_ALL_HIS_FAULT() {
        return MSG_ALL_HIS_FAULT;
    }

    @NotNull
    public final MutableComponent getMSG_HOME() {
        return MSG_HOME;
    }

    @NotNull
    public final MutableComponent getMSG_ENT303() {
        return MSG_ENT303;
    }

    @NotNull
    public final MutableComponent getMSG_FOLLOW() {
        return MSG_FOLLOW;
    }

    @NotNull
    public final MutableComponent getMSG_HELLO() {
        return MSG_HELLO;
    }

    @NotNull
    public final MutableComponent getMSG_HELP() {
        return MSG_HELP;
    }

    @NotNull
    public final MutableComponent getMSG_INTEG() {
        return MSG_INTEG;
    }

    @NotNull
    public final MutableComponent getMSG_NIW() {
        return MSG_NIW;
    }

    @NotNull
    public final MutableComponent getMSG_NULL_1() {
        return MSG_NULL_1;
    }

    @NotNull
    public final MutableComponent getMSG_NULL_2() {
        return MSG_NULL_2;
    }

    @NotNull
    public final MutableComponent getMSG_R2D() {
        return MSG_R2D;
    }

    @NotNull
    public final MutableComponent getMSG_REV() {
        return MSG_REV;
    }

    @NotNull
    public final MutableComponent getMSG_STEVE() {
        return MSG_STEVE;
    }

    @NotNull
    public final MutableComponent getMSG_WANT() {
        return MSG_WANT;
    }

    @NotNull
    public final MutableComponent getMSG_WHO() {
        return MSG_WHO;
    }

    @NotNull
    public final MutableComponent getMSG_WHYER4() {
        return MSG_WHYER4;
    }

    @NotNull
    public final MutableComponent getMSG_BLACKOUT() {
        return MSG_BLACKOUT;
    }

    @NotNull
    public final MutableComponent getMSG_CATFISH12() {
        return MSG_CATFISH12;
    }

    @NotNull
    public final MutableComponent getMSG_FRIEND() {
        return MSG_FRIEND;
    }

    @NotNull
    public final MutableComponent getMSG_OVERLORD() {
        return MSG_OVERLORD;
    }

    @NotNull
    public final MutableComponent getMSG_DYEXD() {
        return MSG_DYEXD;
    }

    @NotNull
    public final MutableComponent getMSG_CAL() {
        return MSG_CAL;
    }

    @NotNull
    public final List<MutableComponent> getUNKNOWN_RESPONSE_MESSAGES() {
        return UNKNOWN_RESPONSE_MESSAGES;
    }

    @NotNull
    public final List<MutableComponent> getFEVER_ENTRY_MESSAGES() {
        return FEVER_ENTRY_MESSAGES;
    }

    @NotNull
    public final List<MutableComponent> getFEVER_RANDOM_MESSAGES() {
        return FEVER_RANDOM_MESSAGES;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_HELLO() {
        return FEVER_MSG_HELLO;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_WHERE() {
        return FEVER_MSG_WHERE;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_WHAT() {
        return FEVER_MSG_WHAT;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_WHO() {
        return FEVER_MSG_WHO;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_INSULT() {
        return FEVER_MSG_INSULT;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_WANT() {
        return FEVER_MSG_WANT;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_SKY() {
        return FEVER_MSG_SKY;
    }

    @NotNull
    public final MutableComponent getFEVER_MSG_HOMES() {
        return FEVER_MSG_HOMES;
    }

    @NotNull
    public final MutableComponent getALT_MC_VER() {
        return ALT_MC_VER;
    }

    @NotNull
    public final MutableComponent getNULL_INTERFACE_1_NAME() {
        return NULL_INTERFACE_1_NAME;
    }

    @NotNull
    public final MutableComponent getNULL_INTERFACE_2_NAME() {
        return NULL_INTERFACE_2_NAME;
    }

    @NotNull
    public final MutableComponent getNULL_INTERFACE_3_NAME() {
        return NULL_INTERFACE_3_NAME;
    }

    @NotNull
    public final MutableComponent getNULLED_GUI() {
        return NULLED_GUI;
    }

    @NotNull
    public final MutableComponent getWARNING_TITLE() {
        return WARNING_TITLE;
    }

    @NotNull
    public final MutableComponent getWARNING_TOP() {
        return WARNING_TOP;
    }

    @NotNull
    public final MutableComponent getWARNING_LINE_1() {
        return WARNING_LINE_1;
    }

    @NotNull
    public final MutableComponent getWARNING_LINE_2() {
        return WARNING_LINE_2;
    }

    @NotNull
    public final MutableComponent getWARNING_LINE_3() {
        return WARNING_LINE_3;
    }

    @NotNull
    public final MutableComponent getWARNING_EXTRA() {
        return WARNING_EXTRA;
    }

    @NotNull
    public final MutableComponent getWARNING_BOTTOM() {
        return WARNING_BOTTOM;
    }

    @NotNull
    public final MutableComponent getMARK_TITLE() {
        return MARK_TITLE;
    }

    @NotNull
    public final MutableComponent getMARK_LINE_1() {
        return MARK_LINE_1;
    }

    @NotNull
    public final MutableComponent getMARK_LINE_2() {
        return MARK_LINE_2;
    }

    @NotNull
    public final MutableComponent getMARK_LINE_3() {
        return MARK_LINE_3;
    }

    @NotNull
    public final MutableComponent getMARK_LINE_4() {
        return MARK_LINE_4;
    }

    @NotNull
    public final MutableComponent getBUTTON_CONTINUE() {
        return BUTTON_CONTINUE;
    }

    @NotNull
    public final MutableComponent getTOGGLE_SHOW_AGAIN() {
        return TOGGLE_SHOW_AGAIN;
    }

    @NotNull
    public final MutableComponent getBUTTON_QUIT_ALT() {
        return BUTTON_QUIT_ALT;
    }

    @NotNull
    public final MutableComponent getBUTTON_QUIT_ALT_2() {
        return BUTTON_QUIT_ALT_2;
    }

    @NotNull
    public final MutableComponent getBECOME_VOID() {
        return BECOME_VOID;
    }

    @NotNull
    public final MutableComponent getCHAT_ENGINE_1() {
        return CHAT_ENGINE_1;
    }

    @NotNull
    public final MutableComponent getCHAT_ENGINE_2() {
        return CHAT_ENGINE_2;
    }

    @NotNull
    public final MutableComponent getDEBUG_MEASURE() {
        return DEBUG_MEASURE;
    }

    @NotNull
    public final MutableComponent getHARDWARE_TITLE() {
        return HARDWARE_TITLE;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_1_FUNNY() {
        return HARDWARE_LINE_1_FUNNY;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_1() {
        return HARDWARE_LINE_1;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_2() {
        return HARDWARE_LINE_2;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_3() {
        return HARDWARE_LINE_3;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_4() {
        return HARDWARE_LINE_4;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_5() {
        return HARDWARE_LINE_5;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_6() {
        return HARDWARE_LINE_6;
    }

    @NotNull
    public final MutableComponent getHARDWARE_LINE_7() {
        return HARDWARE_LINE_7;
    }

    @NotNull
    public final MutableComponent getHARDWARE_CONFIRM() {
        return HARDWARE_CONFIRM;
    }

    @NotNull
    public final MutableComponent getHARDWARE_ENABLED() {
        return HARDWARE_ENABLED;
    }

    @NotNull
    public final MutableComponent getHARDWARE_DISABLED() {
        return HARDWARE_DISABLED;
    }

    @NotNull
    public final MutableComponent getHARDWARE_SHOW_ONCE() {
        return HARDWARE_SHOW_ONCE;
    }

    @NotNull
    public final MutableComponent getHARDWARE_CONTINUE() {
        return HARDWARE_CONTINUE;
    }

    @NotNull
    public final MutableComponent getTESTER_TITLE() {
        return TESTER_TITLE;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_1() {
        return TESTER_LINE_1;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_2() {
        return TESTER_LINE_2;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_3() {
        return TESTER_LINE_3;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_4() {
        return TESTER_LINE_4;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_5() {
        return TESTER_LINE_5;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_6() {
        return TESTER_LINE_6;
    }

    @NotNull
    public final MutableComponent getTESTER_LINE_7() {
        return TESTER_LINE_7;
    }

    @NotNull
    public final MutableComponent getDEFAULT_TITLE() {
        return DEFAULT_TITLE;
    }

    @NotNull
    public final MutableComponent getALT_TITLE() {
        return ALT_TITLE;
    }

    @NotNull
    public final MutableComponent getNO_ESCAPE_TITLE() {
        return NO_ESCAPE_TITLE;
    }

    @NotNull
    public final MutableComponent getALERT_TITLE() {
        return ALERT_TITLE;
    }

    @NotNull
    public final MutableComponent getALERT_HERE_I_AM() {
        return ALERT_HERE_I_AM;
    }

    @NotNull
    public final MutableComponent getALERT_ERR_PLAYER() {
        return ALERT_ERR_PLAYER;
    }

    @NotNull
    public final MutableComponent getALERT_END_GAME() {
        return ALERT_END_GAME;
    }

    private final MutableComponent lang(String key, String value) {
        return TBSReg.INSTANCE.getData().getLang().set(StringsKt.replace$default((String)key, (String)"$$", (String)"thebrokenscript", (boolean)false, (int)4, null), value);
    }

    static {
        String it;
        int i;
        Collection collection;
        int n;
        Object item$iv$iv;
        Object $this$mapIndexedTo$iv$iv;
        INSTANCE = new TBSLang();
        NOSTALGIA_HELPER = INSTANCE.lang("resource_pack.$$.nostalgia", "Nostalgia Helper");
        NOSTALGIA_HELPER_DATA = INSTANCE.lang("data_pack.$$.nostalgia", "Nostalgia Helper Worldgen");
        TBS_VER = INSTANCE.lang("mod.$$.ver", "The Broken Script %1$s");
        EYE = INSTANCE.lang("general.$$.eye", "<o>");
        CMD_ERROR_NOT_PLAYER = INSTANCE.lang("commands.$$.not_player", "\u00a7cThis command must be executed by a player!");
        CMD_SET_SUCCESS = INSTANCE.lang("commands.$$.set_success", "\u00a7aSet successfully!");
        FX_ON = INSTANCE.lang("commands.$$.fx.state.on", "\u00a7a'%1$s' enabled!");
        FX_OFF = INSTANCE.lang("commands.$$.fx.state.off", "\u00a7a'%1$s' disabled!");
        FX_TOGGLE_ON = INSTANCE.lang("commands.$$.fx.toggle.on", "\u00a7a'%1$s' toggled to: \u00a7dON");
        FX_TOGGLE_OFF = INSTANCE.lang("commands.$$.fx.toggle.off", "\u00a7a'%1$s' toggled to: \u00a7dOFF");
        FX_ABERRATION = INSTANCE.lang("commands.$$.fx.aberration", "Chromatic Aberration");
        FX_VHS = INSTANCE.lang("commands.$$.fx.vhs", "VHS Overlay");
        FX_MOON_GLITCH = INSTANCE.lang("commands.$$.fx.moon_glitch", "Moon Glitch");
        FX_TEXT_GLITCH = INSTANCE.lang("commands.$$.fx.text_glitch", "Text Glitch");
        FX_CUSTOM_SKY = INSTANCE.lang("commands.$$.fx.custom_sky", "Custom Sky Color");
        FX_SKY_BLUE = INSTANCE.lang("commands.$$.fx.sky_blue", "Force Sky Blue");
        FX_SCREEN_DUPE = INSTANCE.lang("commands.$$.fx.screen_dupe", "Screen Duplication");
        FX_LUCID_EFFECT = INSTANCE.lang("commands.$$.fx.lucid_blocks_effect", "Lucid Blocks Pixelization");
        FX_META_PARANOIA = INSTANCE.lang("commands.$$.fx.meta_paranoia", "Meta Paranoia");
        FX_GLITCHES = INSTANCE.lang("commands.$$.fx.glitches", "Glitches");
        FX_VOID_BOX = INSTANCE.lang("commands.$$.fx.glitches", "Stage 2 Arena Border");
        FX_DREAM = INSTANCE.lang("commands.$$.fx.dream", "Dream Effect");
        FX_INVERT = INSTANCE.lang("commands.$$.fx.invert", "Invert Effect");
        DEOP_COMMAND_FAIL = INSTANCE.lang("commands.$$.deop.fail", "\u00a7cNothing changed. Your efforts are worthless.");
        KICK_COMMAND_FAIL = INSTANCE.lang("commands.$$.kick.fail", "\u00a7cCannot kick someone trying to assist.");
        GIVE_COMMAND_FAIL = INSTANCE.lang("commands.$$.give.fail", "\u00a7cError: Invalid Item \u00a7r\u00a7kcheater");
        TP_COMMAND_FAIL = INSTANCE.lang("commands.$$.tp.fail", "\u00a7cInvalid target entity for teleport.");
        CMD_INHABIT_SUCCESS = INSTANCE.lang("commands.$$.inhabit.success", "\u00a7aSuccessfully put Circuit inside %1$s entities!");
        CONSOLE_NAME = INSTANCE.lang("block.$$.console.name", "Alternate Console Block");
        COMMAND_NAME = INSTANCE.lang("block.$$.command.name", "Corrupted Command Block");
        COMMAND_BLOCK_FRESH = INSTANCE.lang("block.$$.command.fresh", "It's cold to the touch");
        COMMAND_BLOCK_PLACED = INSTANCE.lang("block.$$.command.placed", "A pulsing can be heard from inside");
        COMMAND_BLOCK_TOO_FAR = INSTANCE.lang("block.$$.command.too_far", "The pulsing flatlines");
        COMMAND_BLOCK_COLDER = INSTANCE.lang("block.$$.command.colder", "The pulsing weakens and slows");
        COMMAND_BLOCK_WARMER = INSTANCE.lang("block.$$.command.warmer", "The pulsing grows a bit more rapid");
        COMMAND_BLOCK_FOUND = INSTANCE.lang("block.$$.command.found", "The pulsing becomes incessant");
        COMMAND_BLOCK_WRONG_DIM = INSTANCE.lang("block.$$.command.wrong_dim", "It wants to return home");
        COMMAND_DESC = INSTANCE.lang("block.$$.command.description", "It pulses in your hands");
        DESYNCER_RESYNC = INSTANCE.lang("item.$$.desyncer.resync", "Resynced!");
        DESYNCER_DESYNC = INSTANCE.lang("item.$$.desyncer.desync", "Desyncing...");
        GLAGGLE_TOOLTIP = INSTANCE.lang("item.$$.glaggle.tooltip", "Also play Lucid Blocks!");
        LILLY_TOOLTIP = INSTANCE.lang("item.$$.lilly.tooltip", "Also try The Broken Content!");
        TBS_STRUCTURE_TOOLTIP = INSTANCE.lang("item.$$.tbs_structure.tooltip", "Dev thingy dw about it :3");
        PHANTOM_PLAYER_NAME = INSTANCE.lang("entity.$$.phantom_player.name", "__blackout__");
        NIW_KICK = INSTANCE.lang("entity.$$.nothingiswatching.kick", "null");
        CIRCUIT_KICK_1 = INSTANCE.lang("entity.$$.circuit.kick.1", "No more running.");
        CIRCUIT_KICK_2 = INSTANCE.lang("entity.$$.circuit.kick.2", "No more hiding.");
        NULL_CHASE_KICK = INSTANCE.lang("entity.$$.null_chase.kick", "null");
        NULL_MAZE_KICK = INSTANCE.lang("entity.$$.null_maze.kick", "err.leave");
        NULL_ENDGAME_CHAT_1 = INSTANCE.lang("entity.$$.null_endgame.chat.1", "\u00a74HERE I AM");
        NULL_ENDGAME_CHAT_2 = INSTANCE.lang("entity.$$.null_endgame.chat.2", "\u00a74\u00a7kVOIDNULLSILUETTANOMALY");
        NULL_FLYING_NAME = INSTANCE.lang("entity.$$.null_flying.name", "MobIsmissingID");
        NULL_INVADE_BASE_CHAT_1 = INSTANCE.lang("entity.$$.null_invade_base.chat.1", "[{}]");
        NULL_INVADE_BASE_CHAT_2 = INSTANCE.lang("entity.$$.null_invade_base.chat.2", "{[> null]}");
        NULL_SCARE_NAME = INSTANCE.lang("entity.$$.null_scare.name", "[]");
        RAM2DIE_NAME = INSTANCE.lang("entity.$$.ram2die.name", "xXram2dieXx");
        RAM2DIE_HOSTED = INSTANCE.lang("entity.$$.ram2die.chat.hosted", "Local game hosted on port [\u00a7a2\u00a7k0\u00a7r\u00a7a1\u00a7k8\u00a7r]");
        RAM2DIE_JOIN = INSTANCE.lang("entity.$$.ram2die.chat.join", "\u00a7exXram2dieXx joined the game");
        RAM2DIE_CHAT_MSG = INSTANCE.lang("entity.$$.ram2die.chat.message", "<xXram2dieXx> %1$s");
        RAM2DIE_LEAVE = INSTANCE.lang("entity.$$.ram2die.chat.leave", "\u00a7exXram2dieXx left the game");
        TBE_KICK = INSTANCE.lang("entity.$$.thebrokenend.kick", "Here I am.");
        CURVED_NAME = INSTANCE.lang("entity.$$.curved.name", "DyeXD412");
        CURVED_DEATH = INSTANCE.lang("entity.$$.curved.death", "DyeXD412 was slain by %1$s");
        CURVED_DEATH_UNKNOWN = INSTANCE.lang("entity.$$.curved.death_unknown", "DyeXD412 died");
        CURVED_LEAVE = INSTANCE.lang("entity.$$.curved.leave", "\u00a7eDyeXD412 left the game");
        LIBERTY = INSTANCE.lang("entity.$$.liberty", "Liberty");
        VILLAGER_NICK = INSTANCE.lang("entity.$$.villager.nick", "TESTIFICATE");
        RANDOM_NICK_1 = INSTANCE.lang("entity.$$.random.nick.1", "01001000 01100101 00100000 01110111 01101001 01101100 01101100 00100000 01100110 01101001 01101110 01100100 00100000 01111001 01101111 01110101");
        RANDOM_NICK_2 = INSTANCE.lang("entity.$$.random.nick.2", "01001000 01100101 01101100 01101100 01101111");
        Object[] objectArray = new String[]{"You know nothing", "Worship me", "Follow me", "Join us", "Corrupted", "Go away", "Null", "We can hear you", "Can you see me?", "0", "Behind you", "Help me", "Nothing can be changed", "Nothing can be changed", "Close your eyes", "One of us"};
        Object $this$mapIndexed$iv = (Object[])CollectionsKt.listOf((Object[])objectArray);
        boolean $i$f$mapIndexed = false;
        Object[] objectArray2 = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        Iterator iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String string = (String)item$iv$iv;
            int n2 = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("entity.$$.null.title." + i, it));
        }
        NULL_TITLES = (List)destination$iv$iv;
        $this$mapIndexed$iv = new String[]{"I hear you", "I see you", "Why are you doing this", "There is nothing left", "They are coming", "Nothing can be done", "Help", "err.type=null.messageNotFound"};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("entity.$$.null.message." + i, it));
        }
        NULL_MESSAGES = (List)destination$iv$iv;
        $this$mapIndexed$iv = new String[]{"You are not alone here", "I'm scared", "Help me", "Somethings chasing us", "It got my eyes", "Save us", "I can't escape", "It hurts so much", "I can't get out", "It saw us", "Why did this happen", "I dont understand"};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("entity.$$.cave.message." + i, it));
        }
        CAVE_MESSAGES = (List)destination$iv$iv;
        $this$mapIndexed$iv = new String[]{"So was I", "Me too", "I couldn't do anything", "It's been an eternity in there", "Set them free", "Help us", "It looked like me", "There was nowhere to run", "There was no way out", "Locked forever", "It took all of us", "It took our lives and minds", "I'm losing parts of myself"};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("response.$$.scared.message." + i, it));
        }
        SCARED_MESSAGES = (List)destination$iv$iv;
        OPENGL_INVALID_OPERATION = INSTANCE.lang("event.$$.opengl.invalid_op", "\u00a7eOpenGL Error\u00a7f: 1282 (Invalid operation)");
        OPENGL_HERE_I_AM = INSTANCE.lang("event.$$.opengl.here_i_am", "\u00a7eOpenGL Error\u00a7f: 0 (Here I am.)");
        $this$mapIndexed$iv = new String[]{"I see you.", "Can you see me?", "It was your fault.", "Help us.", "I am right behind you.", "\u00a74I am right behind you.", "null", "null.err", "000", "\u00a7kAAAAAAAAA", "\u00a7eNull joined the game", "\u00a7eNull left the game", "\u00a7ejoined the game", "<?>", "\u00a7cInternal Error: IllegalStateException - '<>' is not a valid player name!", "\u00a7cInternal Error: IllegalStateException - '<?>' is not a valid player name!"};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("event.$$.text." + i, it));
        }
        TEXT_EVENT_MESSAGES = (List)destination$iv$iv;
        NULL_BOOK_CONTENT = INSTANCE.lang("event.$$.null_book.text", "\u00a70null.err.object.err.null.object.alone.3.not.behind.entitytype:player.receiveddata.invalid.reboot.failed.reset.playerdata:00F9219492D94210F812");
        NULL_TITLE = INSTANCE.lang("event.$$.null_title.text", "\u00a7fnull null null null null null null null");
        MADNESS_MESSAGE = INSTANCE.lang("event.$$.madness_1.message", "=)");
        DISCONNECTED_1 = INSTANCE.lang("event.$$.disconnect_1", "Connection Lost");
        DISCONNECTED_2 = INSTANCE.lang("event.$$.disconnect_2", "Timed out");
        DISCONNECTED_3 = INSTANCE.lang("event.$$.disconnect_3", "Back to title screen");
        USER_COLLINLOCK = INSTANCE.lang("chat.$$.user.collinlock16", "collinlock16");
        COLLINLOCK_MSG = INSTANCE.lang("event.$$.collinlock16", "oh shit wrong door");
        USER_NULL = INSTANCE.lang("chat.$$.user.null", "Null");
        USER_CIRCUIT = INSTANCE.lang("chat.$$.user.circuit", "Circuit");
        MSG_ADMIN = INSTANCE.lang("chat.$$.msg.admin", "Administration.");
        MSG_ITS_ME = INSTANCE.lang("chat.$$.msg.its_me", "It's me.");
        MSG_CYSM_YES = INSTANCE.lang("chat.$$.msg.can_you_see_me.yes", "Yes.");
        MSG_CYSM_HELLO = INSTANCE.lang("chat.$$.msg.can_you_see_me.hello", "Hello.");
        MSG_ALL_HIS_FAULT = INSTANCE.lang("chat.$$.msg.all_his_fault", "It was all his fault.");
        MSG_HOME = INSTANCE.lang("chat.$$.msg.home", "Home.");
        MSG_ENT303 = INSTANCE.lang("chat.$$.msg.ent_303", "Ended his own life.");
        MSG_FOLLOW = INSTANCE.lang("chat.$$.msg.follow", "Is behind you.");
        MSG_HELLO = INSTANCE.lang("chat.$$.msg.hello", "err.type=null.hello");
        MSG_HELP = INSTANCE.lang("chat.$$.msg.help", "[?][?][?]");
        MSG_INTEG = INSTANCE.lang("chat.$$.msg.integ", "Deep down under the bedrock.");
        MSG_NIW = INSTANCE.lang("chat.$$.msg.niw", "A broken promise.");
        MSG_NULL_1 = INSTANCE.lang("chat.$$.msg.null.1", "The end is nigh");
        MSG_NULL_2 = INSTANCE.lang("chat.$$.msg.null.2", "The end is null");
        MSG_R2D = INSTANCE.lang("chat.$$.msg.r2d", "Rot in hell.");
        MSG_REV = INSTANCE.lang("chat.$$.msg.rev", "Poor soul.");
        MSG_STEVE = INSTANCE.lang("chat.$$.msg.steve", "[0.1]");
        MSG_WANT = INSTANCE.lang("chat.$$.msg.want", "err.type=null.freedom");
        MSG_WHO = INSTANCE.lang("chat.$$.msg.who", "err.type=null.");
        MSG_WHYER4 = INSTANCE.lang("chat.$$.msg.whyer4", "...");
        MSG_BLACKOUT = INSTANCE.lang("chat.$$.msg.blackout", "Asshole.");
        MSG_CATFISH12 = INSTANCE.lang("chat.$$.msg.catfish12", "Should've left it alone.");
        MSG_FRIEND = INSTANCE.lang("chat.$$.msg.fried", "?");
        MSG_OVERLORD = INSTANCE.lang("chat.$$.msg.overlord", "He was wrong.");
        MSG_DYEXD = INSTANCE.lang("chat.$$.msg.dyexd", "Obsessed with answers.");
        MSG_CAL = INSTANCE.lang("chat.$$.msg.cal", "Innocent.");
        $this$mapIndexed$iv = new String[]{"LET ME GO", "PLEASE DON'T LEAVE", "IT HURTS SO MUCH", "WHY WON'T IT STOP", "HELP ME", "I WANT TO GO HOME", "I CAN'T LEAVE", "WHY AREN'T YOU HELPING", "IT WON'T STOP HURTING", "PLEASE HELP", "I WANT MY MOM", "I CAN'T TAKE THIS", "LET US DIE", "PLEASE HELP ME", "NO MORE NO MORE NO MORE", "WHY AREN'T YOU LISTENING", "GET US OUT", "THEIR SCREAMS ARE SO LOUD", "WE WILL BE TOGETHER FOREVER", "PLEASE MAKE IT STOP", "I CAN'T TELL IF I'M ME", "DON'T LISTEN TO THEM", "YOU", "WHERE IS MY FAMILY", "HAHAHHAHAHAHAHHAHA", "I FELT MYSELF DIE", "YOU AREN'T LEAVING US", "JOIN US", "PLEASE HELP THEM", "TAKE US WITH YOU", "DON'T LEAVE", "HELP HELP HELP HELP", "THEY LIED", "LOOK AT ME", "THERE IS NO HOPE", "SEND HELP", "YOU'RE MAKING A MISTAKE", "HEAR US", "WE CAN ALL BE HAPPY TOGETHER", "STOP, PLEASE JUST STOP", "I CAN'T TAKE IT ANYMORE", "YOU NEED TO LEAVE", "I FEEL SO ALONE", "THIS IS HELL", "LEAVE WHILE YOU STILL CAN"};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("chat.$$.soul_text." + i, it));
        }
        UNKNOWN_RESPONSE_MESSAGES = (List)destination$iv$iv;
        $this$mapIndexed$iv = new String[]{"<Fever> The night sky is beautiful, isn\u2019t it?", "<Fever> We meet once again.", "<Fever> ..."};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("chat.$$.fever.entry.message." + i, it));
        }
        FEVER_ENTRY_MESSAGES = (List)destination$iv$iv;
        $this$mapIndexed$iv = new String[]{"<Fever> Do you have any feelings?", "<Fever> Do you have a voice in your heart?", "<Fever> Close your eyes and look at me.", "<Fever> Be not afraid.", "<Fever> The less visible something is, the more beautiful it becomes.", "<Fever> Do you know who you are?", "<Fever> Does this world bring you solace?", "<Fever> What do you seek from here?", "<Fever> Let yourselves be saved.", "<Fever> Why do you look for the living among the dead?", "<Fever> Do not be afraid, For you have found favor with God."};
        $this$mapIndexed$iv = CollectionsKt.listOf((Object[])$this$mapIndexed$iv);
        $i$f$mapIndexed = false;
        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        $i$f$mapIndexedTo = false;
        index$iv$iv = 0;
        iterator = $this$mapIndexedTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            item$iv$iv = iterator.next();
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            it = (String)item$iv$iv;
            i = n;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(INSTANCE.lang("chat.$$.fever.random.message." + i, it));
        }
        FEVER_RANDOM_MESSAGES = (List)destination$iv$iv;
        FEVER_MSG_HELLO = INSTANCE.lang("chat.$$.fever.msg.hello", "<Fever> Greetings.");
        FEVER_MSG_WHERE = INSTANCE.lang("chat.$$.fever.msg.where", "<Fever> Isn't it much more intriguing to think about where you aren't?");
        FEVER_MSG_WHAT = INSTANCE.lang("chat.$$.fever.msg.what", "<Fever> This? This is a safe haven. You don't need to be afraid here.");
        FEVER_MSG_WHO = INSTANCE.lang("chat.$$.fever.msg.who", "<Fever> Don't fret, I am your Savior.");
        FEVER_MSG_INSULT = INSTANCE.lang("chat.$$.fever.msg.insult", "<Fever> That is no way to speak to your Savior. Do you wish for \u00a74Judgement\u00a7r?");
        FEVER_MSG_WANT = INSTANCE.lang("chat.$$.fever.msg.want", "<Fever> I want to see you, from the inside out.");
        FEVER_MSG_SKY = INSTANCE.lang("chat.$$.fever.msg.sky", "<Fever> Isn't it beautiful?");
        FEVER_MSG_HOMES = INSTANCE.lang("chat.$$.fever.msg.homes", "<Fever> Such flora, in the forest.");
        ALT_MC_VER = INSTANCE.lang("gui.$$.title.game_version", "Minecraft 0.0.null");
        NULL_INTERFACE_1_NAME = INSTANCE.lang("gui.$$.null_interface_1.name", "NullInterface");
        NULL_INTERFACE_2_NAME = INSTANCE.lang("gui.$$.null_interface_2.name", "NullInterface2");
        NULL_INTERFACE_3_NAME = INSTANCE.lang("gui.$$.null_interface_3.name", "NullInterface3");
        NULLED_GUI = INSTANCE.lang("gui.$$.nulled_gui.name", "NulledGui");
        WARNING_TITLE = INSTANCE.lang("gui.$$.warning.title", "\u00a7e\u00a7l[!] Photosensitivity Warning [!]");
        WARNING_TOP = INSTANCE.lang("gui.$$.warning.top", "\u00a7lThe Broken Script may contain flashing lights and screens.");
        WARNING_LINE_1 = INSTANCE.lang("gui.$$.warning.lines.1", "This mod can also \u00a7e\u00a7lban you from your world\u00a7r, \u00a7d\u00a7lcrash the game\u00a7r,");
        WARNING_LINE_2 = INSTANCE.lang("gui.$$.warning.lines.2", "\u00a7a\u00a7lcreate '.txt' files on your desktop\u00a7r, \u00a79\u00a7lshake your game window\u00a7r,");
        WARNING_LINE_3 = INSTANCE.lang("gui.$$.warning.lines.3", "and \u00a7b\u00a7lcreate custom error popups on your desktop\u00a7r.");
        WARNING_EXTRA = INSTANCE.lang("gui.$$.warning.extra", "\u00a76\u00a7lIt does not do any real harm to your computer in any way.");
        WARNING_BOTTOM = INSTANCE.lang("gui.$$.warning.bottom", "\u00a7c\u00a7lViewer discretion is advised.");
        MARK_TITLE = INSTANCE.lang("gui.$$.mark.title", "\u00a7lNote about Mark101");
        MARK_LINE_1 = INSTANCE.lang("gui.$$.mark.lines.1", "Some parts of this mod are inspired by");
        MARK_LINE_2 = INSTANCE.lang("gui.$$.mark.lines.2", "the incredible Mark101/TBOTV ARG. Go watch it!");
        MARK_LINE_3 = INSTANCE.lang("gui.$$.mark.lines.3", "Do note that the content of this mod is NOT");
        MARK_LINE_4 = INSTANCE.lang("gui.$$.mark.lines.4", "canon to the original ARG.");
        BUTTON_CONTINUE = INSTANCE.lang("gui.$$.common.continue", "Click anywhere to continue");
        TOGGLE_SHOW_AGAIN = INSTANCE.lang("gui.$$.common.dont_show_again", "Don't show again");
        BUTTON_QUIT_ALT = INSTANCE.lang("gui.$$.button.quit_alt", "Leave");
        BUTTON_QUIT_ALT_2 = INSTANCE.lang("gui.$$.button.quit_alt_2", "<o>");
        BECOME_VOID = INSTANCE.lang("gui.$$.msg.become_void", "ERR.INTEGRITY");
        CHAT_ENGINE_1 = INSTANCE.lang("gui.$$.msg.chat_engine.1", "IMPORT minecraft.chatengine");
        CHAT_ENGINE_2 = INSTANCE.lang("gui.$$.msg.chat_engine.2", "Unexpected_error.returnedvalue=-1");
        DEBUG_MEASURE = INSTANCE.lang("gui.$$.debug", "===== 1 ===== 2 ===== 3 ===== 4 ===== 5 ===== 6 ===== 7 ===== 8 ===== 9");
        HARDWARE_TITLE = INSTANCE.lang("gui.$$.hardware.title", "\u00a7e\u00a7l[!] Hardware Performance Notice [!]\u00a7r");
        HARDWARE_LINE_1_FUNNY = INSTANCE.lang("gui.$$.hardware.line_1_", "The Broken Script has graphical features");
        HARDWARE_LINE_1 = INSTANCE.lang("gui.$$.hardware.line_1", "\u00a7lThe Broken Script\u00a7r has \u00a7a\u00a7lgraphical features\u00a7r that can be");
        HARDWARE_LINE_2 = INSTANCE.lang("gui.$$.hardware.line_2", "demanding on older hardware. While we \u00a76recommend playing \u00a7lwith");
        HARDWARE_LINE_3 = INSTANCE.lang("gui.$$.hardware.line_3", "them enabled, because it \u00a7d\u00a7lenhances the experience\u00a7r of the mod,");
        HARDWARE_LINE_4 = INSTANCE.lang("gui.$$.hardware.line_4", "they \u00a7c\u00a7lare not\u00a7r required, and can be disabled to \u00a7e\u00a7limprove performance.");
        HARDWARE_LINE_5 = INSTANCE.lang("gui.$$.hardware.line_5", "If your machine uses \u00a79\u00a7llow power integrated graphics,\u00a7r or if your GPU is");
        HARDWARE_LINE_6 = INSTANCE.lang("gui.$$.hardware.line_6", "weaker than a \u00a79\u00a7lGTX 1050ti,\u00a7r we recommend disabling them.");
        HARDWARE_LINE_7 = INSTANCE.lang("gui.$$.hardware.line_7", "\u00a73You appear to be using: ");
        HARDWARE_CONFIRM = INSTANCE.lang("gui.$$.hardware.confirm", "Settings will be: ");
        HARDWARE_ENABLED = INSTANCE.lang("gui.$$.hardware.enabled", "Enabled");
        HARDWARE_DISABLED = INSTANCE.lang("gui.$$.hardware.disabled", "Disabled");
        HARDWARE_SHOW_ONCE = INSTANCE.lang("gui.$$.hardware.show_once", "This popup will only appear once per instance.");
        HARDWARE_CONTINUE = INSTANCE.lang("gui.$$.hardware.continue", "Click here to continue.");
        TESTER_TITLE = INSTANCE.lang("gui.$$.tester.title", "You Are Playing a \u00a7bTester\u00a7r Build.");
        TESTER_LINE_1 = INSTANCE.lang("gui.$$.tester.line_1", "If you are not a playtester who is authorized to use this build,");
        TESTER_LINE_2 = INSTANCE.lang("gui.$$.tester.line_2", "please report the leak to us privately in the official TBS Discord server as a ticket.");
        TESTER_LINE_3 = INSTANCE.lang("gui.$$.tester.line_3", "\u00a7l\u00a7ahttps://discord.gg/nullnullnullnull\u00a7r");
        TESTER_LINE_4 = INSTANCE.lang("gui.$$.tester.line_4", "If you are not a playtester, the leaker may have placed \u00a74\u00a7lmalware\u00a7r inside this build.");
        TESTER_LINE_5 = INSTANCE.lang("gui.$$.tester.line_5", "Please close the game, and scan your computer for viruses.");
        TESTER_LINE_6 = INSTANCE.lang("gui.$$.tester.line_6", "Development takes a long time, so please wait until the full");
        TESTER_LINE_7 = INSTANCE.lang("gui.$$.tester.line_7", "release of the mod to get the best possible experience.");
        DEFAULT_TITLE = INSTANCE.lang("window.$$.main.title", "Minecraft 1.12.2");
        ALT_TITLE = INSTANCE.lang("window.$$.main.title_alt", "err.<o>");
        NO_ESCAPE_TITLE = INSTANCE.lang("window.$$.main.title_no_escape", "YOU CAN'T ESCAPE YOU CAN'T ESCAPE YOU CAN'T ESCAPE");
        ALERT_TITLE = INSTANCE.lang("window.$$.alert.title", "LWJGL Alert");
        ALERT_HERE_I_AM = INSTANCE.lang("window.$$.alert.here_i_am", "Here I am.");
        ALERT_ERR_PLAYER = INSTANCE.lang("window.$$.alert.err_player", "err.player");
        ALERT_END_GAME = INSTANCE.lang("window.$$.alert.end_game", "UNHANDLED EXCEPTION -1");
        INSTANCE.lang("painting.$$.circuit_cave.title", "Circuit Cave");
        INSTANCE.lang("painting.$$.circuit_cave.author", "WendigoDrip");
        INSTANCE.lang("soundCategory.tbs_ambience", "Ambience");
        TBSReg.INSTANCE.getData().getLang().plusAssign(MenuMode.Companion.createTranslations());
        INSTANCE.lang("travelerstitles.$$.clan_void", "Clan Void");
        INSTANCE.lang("travelerstitles.$$.concrete", "Concrete");
        INSTANCE.lang("travelerstitles.$$.library", "Library");
        INSTANCE.lang("travelerstitles.$$.limbo", "Limbo");
        INSTANCE.lang("travelerstitles.$$.lucid", "Lucid Blocks");
        INSTANCE.lang("travelerstitles.$$.nothing", "...");
        INSTANCE.lang("travelerstitles.$$.nowhere", "Nowhere");
        INSTANCE.lang("travelerstitles.$$.null_torture", "Null Torture");
        INSTANCE.lang("travelerstitles.$$.protected_void", "Protected Void");
        INSTANCE.lang("travelerstitles.$$.stage2", "");
        INSTANCE.lang("travelerstitles.$$.the_moon", "Corrupted Moon");
        INSTANCE.lang("travelerstitles.$$.void_shadow", "Void Shadow");
        for (SubtitleEntry sub : IntroSubtitlesKt.getSUBTITLES()) {
            INSTANCE.lang(sub.getKey(), sub.getText());
        }
    }
}


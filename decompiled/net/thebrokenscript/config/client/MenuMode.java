/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.util.TranslatedEnum
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config.client;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.util.TranslatedEnum;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nj\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/config/client/MenuMode;", "Lnet/thebrokenscript/brokencore/api/util/TranslatedEnum;", "", "<init>", "(Ljava/lang/String;I)V", "FANART", "VANILLA", "nameKey", "", "getNameKey", "()Ljava/lang/String;", "descKey", "getDescKey", "Companion", "thebrokenscript-common"})
public final class MenuMode
extends Enum<MenuMode>
implements TranslatedEnum {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String nameKey;
    @NotNull
    private final String descKey;
    public static final /* enum */ MenuMode FANART;
    public static final /* enum */ MenuMode VANILLA;
    private static final /* synthetic */ MenuMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private MenuMode() {
        String string = this.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
        this.nameKey = "menu_mode.thebrokenscript." + string;
        String string2 = this.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        this.descKey = "menu_mode.thebrokenscript." + string2 + ".desc";
    }

    @NotNull
    public String getNameKey() {
        return this.nameKey;
    }

    @NotNull
    public String getDescKey() {
        return this.descKey;
    }

    public static MenuMode[] values() {
        return (MenuMode[])$VALUES.clone();
    }

    public static MenuMode valueOf(String value) {
        return Enum.valueOf(MenuMode.class, value);
    }

    @NotNull
    public static EnumEntries<MenuMode> getEntries() {
        return $ENTRIES;
    }

    static {
        FANART = new MenuMode();
        VANILLA = new MenuMode();
        $VALUES = menuModeArray = new MenuMode[]{MenuMode.FANART, MenuMode.VANILLA};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/config/client/MenuMode$Companion;", "", "<init>", "()V", "createTranslations", "", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Map<String, String> createTranslations() {
            Map items = new LinkedHashMap();
            for (MenuMode item : MenuMode.getEntries()) {
                String name = switch (WhenMappings.$EnumSwitchMapping$0[item.ordinal()]) {
                    case 1 -> "Fanart";
                    case 2 -> "Vanilla";
                    default -> throw new NoWhenBranchMatchedException();
                };
                String desc = switch (WhenMappings.$EnumSwitchMapping$0[item.ordinal()]) {
                    case 1 -> "A slightly modified Vanilla main menu with the background replaced with fanart.";
                    case 2 -> "The Vanilla main menu, no modifications.";
                    default -> throw new NoWhenBranchMatchedException();
                };
                items.put(item.getNameKey(), name);
                items.put(item.getDescKey(), desc);
            }
            return items;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[MenuMode.values().length];
                try {
                    nArray[MenuMode.FANART.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[MenuMode.VANILLA.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}


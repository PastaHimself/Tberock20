/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.mojang.blaze3d.systems.RenderSystem
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.random.RandomKt
 *  kotlin.text.Charsets
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.gui.screens.inventory.PageButton
 *  net.minecraft.client.resources.sounds.SimpleSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.Resource
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.gui;

import com.google.gson.Gson;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.client.NoisyScreenChar;
import net.thebrokenscript.client.TBSLibraryAnimations;
import net.thebrokenscript.client.util.LibraryTextUtils;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.world.inventory.LibraryBookMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@AB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\fH\u0002J\b\u0010-\u001a\u00020%H\u0014J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u00020\fH\u0002J(\u00100\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0013H\u0016J8\u00106\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\fH\u0002J(\u0010=\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u00105\u001a\u00020\u00132\u0006\u00104\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0014J \u0010?\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2={"Lnet/thebrokenscript/client/gui/LibraryBookScreen;", "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;", "Lnet/thebrokenscript/world/inventory/LibraryBookMenu;", "container", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "text", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/world/inventory/LibraryBookMenu;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/network/chat/Component;)V", "pageContent", "currentPage", "", "totalPages", "bookId", "openTime", "", "prevSec", "time", "", "getTime", "()F", "noisyChars", "", "Lnet/thebrokenscript/client/NoisyScreenChar;", "noisyRandom", "Lkotlin/random/Random;", "minX", "minY", "maxX", "maxY", "forwardButton", "Lnet/minecraft/client/gui/screens/inventory/PageButton;", "backButton", "bookData", "Lnet/thebrokenscript/client/gui/LibraryBookScreen$BookData;", "init", "", "countPage", "createButtons", "pageForward", "pageBack", "updateButtonVisibility", "loadBook", "book", "containerTick", "loadPage", "page", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "blitCenteredInBook", "texture", "Lnet/minecraft/resources/ResourceLocation;", "destWidth", "destHeight", "srcWidth", "srcHeight", "renderBg", "p3", "renderLabels", "Companion", "BookData", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nLibraryBookScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibraryBookScreen.kt\nnet/thebrokenscript/client/gui/LibraryBookScreen\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1425:1\n1#2:1426\n*E\n"})
public final class LibraryBookScreen
extends AbstractContainerScreen<LibraryBookMenu> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Component pageContent;
    private int currentPage;
    private int totalPages;
    private int bookId;
    private long openTime;
    private int prevSec;
    @NotNull
    private final List<NoisyScreenChar> noisyChars;
    @NotNull
    private final Random noisyRandom;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private PageButton forwardButton;
    private PageButton backButton;
    private BookData bookData;
    @NotNull
    private static final ResourceLocation BOOK_GUI_LOCATION = TBSConstants.id("textures/gui/library_screen.png");
    @NotNull
    private static final ResourceLocation BOOK_GUI_STENCIL = TBSConstants.id("textures/gui/library_shelf_gui_stencil.png");
    @NotNull
    private static final ResourceLocation BOOK_GUI_CLOCK = TBSConstants.id("textures/gui/library_clock_gui.png");
    @NotNull
    private static final ResourceLocation WILBURS_PEN = TBSConstants.id("textures/gui/wilbur_pen.png");
    @NotNull
    private static final ResourceLocation PEN_EXPOSED = TBSConstants.id("textures/gui/wilbur_pen_exposed.png");
    @NotNull
    private static final ResourceLocation OLIVER_HALLWAY_CORNER = TBSConstants.id("textures/gui/oliver_hallway_corner.png");
    @NotNull
    private static final ResourceLocation WILBURS_NOTE = TBSConstants.id("textures/gui/wilburs_note.png");
    @NotNull
    private static final ResourceLocation OLIVER_ENDLESS_HALLWAY = TBSConstants.id("textures/gui/oliver_endless_hallway.png");
    @NotNull
    private static final ResourceLocation OLIVERS_NOTE = TBSConstants.id("textures/gui/olivers_note.png");
    @NotNull
    private static final ResourceLocation BOOK_TREE = TBSConstants.id("textures/gui/vision_of_trees.png");
    @NotNull
    private static final ResourceLocation WILBURS_SHOTGUN = TBSConstants.id("textures/gui/the_kings_sword.png");
    @NotNull
    private static final ResourceLocation OLIVER_DRAGONS_BREATH = TBSConstants.id("textures/gui/dragons_breath.png");
    @NotNull
    private static final ResourceLocation TIME_T0_GO = TBSConstants.id("textures/gui/time_to_go.png");
    @NotNull
    private static final ResourceLocation A_WAY_OUT = TBSConstants.id("textures/gui/a_way_out.png");
    @NotNull
    private static final ResourceLocation BEAST_FINALE = TBSConstants.id("textures/gui/rest_well.png");
    @NotNull
    private static final ResourceLocation WILBURS_LAST_STAND = TBSConstants.id("textures/gui/last_stand.png");
    @NotNull
    private static final ResourceLocation A_KNIFE_APPEARS = TBSConstants.id("textures/gui/a_knife_appears.png");
    @NotNull
    private static final ResourceLocation ULTIMATUM = TBSConstants.id("textures/gui/ultimatum.png");
    @NotNull
    private static final ResourceLocation LEFT_BEHIND = TBSConstants.id("textures/gui/left_behind.png");
    @NotNull
    private static final ResourceLocation JUDGEMENT = TBSConstants.id("textures/gui/judgement.png");
    @NotNull
    private static final ResourceLocation ETERNITY_PIT = TBSConstants.id("textures/gui/eternity_pit.png");
    @NotNull
    private static final ResourceLocation LABYRINTH = TBSConstants.id("textures/gui/labyrinth.png");
    @NotNull
    private static final ResourceLocation COAT_MAZE = TBSConstants.id("textures/gui/coat_maze.png");
    @NotNull
    private static final ResourceLocation THERMAL_CAM = TBSConstants.id("textures/gui/the_third_eye.png");
    @NotNull
    private static final ResourceLocation WILBUR_WAKES_UP = TBSConstants.id("textures/gui/rude_awakening.png");
    @NotNull
    private static final ResourceLocation FORGING_HELLS_HORN = TBSConstants.id("textures/gui/forging_hells_horn.png");
    @NotNull
    private static final ResourceLocation A_MONSTER_IS_BORN = TBSConstants.id("textures/gui/a_monster_is_born.png");
    @NotNull
    private static final ResourceLocation GRAVESTONE = TBSConstants.id("textures/gui/gravestone.png");
    @NotNull
    private static final ResourceLocation FINAL_GOODBYE = TBSConstants.id("textures/gui/final_goodbye.png");
    @NotNull
    private static final ResourceLocation OLIVERS_TAG = TBSConstants.id("textures/gui/olivers_tag.png");

    public LibraryBookScreen(@NotNull LibraryBookMenu container, @NotNull Inventory inventory, @NotNull Component text) {
        Intrinsics.checkNotNullParameter((Object)((Object)container), (String)"container");
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        super((AbstractContainerMenu)container, inventory, text);
        MutableComponent mutableComponent = Component.empty();
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"empty(...)");
        this.pageContent = (Component)mutableComponent;
        this.prevSec = -1;
        this.noisyChars = new ArrayList();
        this.noisyRandom = RandomKt.Random((long)System.nanoTime());
    }

    private final float getTime() {
        return (float)(System.currentTimeMillis() - this.openTime) / 1000.0f;
    }

    protected void init() {
        BookData bookData;
        super.init();
        this.bookId = ((LibraryBookMenu)this.menu).getBookId();
        BookData bookData2 = this.loadBook(this.bookId);
        if (bookData2 == null) {
            bookData2 = new BookData(CollectionsKt.emptyList());
        }
        if ((bookData = (this.bookData = bookData2)) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"bookData");
            bookData = null;
        }
        this.totalPages = this.countPage(bookData);
        BookData bookData3 = this.bookData;
        if (bookData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"bookData");
            bookData3 = null;
        }
        this.pageContent = this.loadPage(bookData3, 1);
        this.openTime = System.currentTimeMillis();
        this.createButtons();
    }

    private final int countPage(BookData bookData) {
        return bookData.getPages().size();
    }

    private final void createButtons() {
        int i = (this.width - 192) / 2;
        GuiEventListener guiEventListener = this.addRenderableWidget((GuiEventListener)new PageButton(i + 116, 159, true, arg_0 -> LibraryBookScreen.createButtons$lambda$0(this, arg_0), true));
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener, (String)"addRenderableWidget(...)");
        this.forwardButton = (PageButton)guiEventListener;
        GuiEventListener guiEventListener2 = this.addRenderableWidget((GuiEventListener)new PageButton(i + 43, 159, false, arg_0 -> LibraryBookScreen.createButtons$lambda$1(this, arg_0), true));
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener2, (String)"addRenderableWidget(...)");
        this.backButton = (PageButton)guiEventListener2;
        this.updateButtonVisibility();
    }

    private final void pageForward() {
        if (this.currentPage < this.totalPages - 1) {
            int n = this.currentPage;
            this.currentPage = n + 1;
            BookData bookData = this.bookData;
            if (bookData == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"bookData");
                bookData = null;
            }
            this.pageContent = this.loadPage(bookData, this.currentPage + 1);
            this.updateButtonVisibility();
        }
    }

    private final void pageBack() {
        if (this.currentPage > 0) {
            int n = this.currentPage;
            this.currentPage = n + -1;
            BookData bookData = this.bookData;
            if (bookData == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"bookData");
                bookData = null;
            }
            this.pageContent = this.loadPage(bookData, this.currentPage + 1);
            this.updateButtonVisibility();
        }
    }

    private final void updateButtonVisibility() {
        PageButton pageButton = this.forwardButton;
        if (pageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"forwardButton");
            pageButton = null;
        }
        pageButton.visible = this.currentPage < this.totalPages - 1;
        PageButton pageButton2 = this.backButton;
        if (pageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"backButton");
            pageButton2 = null;
        }
        pageButton2.visible = this.currentPage > 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final BookData loadBook(int book) {
        Object object;
        ResourceLocation location = TBSConstants.id("library_books/" + book + ".json");
        try {
            Resource resource = Minecraft.getInstance().getResourceManager().getResourceOrThrow(location);
            InputStream inputStream = resource.open();
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"open(...)");
            Closeable closeable = inputStream;
            Object object2 = Charsets.UTF_8;
            Object object3 = new InputStreamReader((InputStream)closeable, (Charset)object2);
            int n = 8192;
            closeable = object3 instanceof BufferedReader ? (BufferedReader)object3 : new BufferedReader((Reader)object3, n);
            object2 = null;
            try {
                BufferedReader reader = (BufferedReader)closeable;
                boolean bl = false;
                object3 = (BookData)new Gson().fromJson((Reader)reader, BookData.class);
            }
            catch (Throwable throwable) {
                object2 = throwable;
                throw throwable;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)object2);
            }
            object = object3;
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    protected void containerTick() {
        if (this.maxX <= this.minX || this.maxY <= this.minY) {
            return;
        }
        int n = 23;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            this.noisyChars.add(TBSLibraryAnimations.INSTANCE.createNoisyChar(this.minX, this.minY, this.maxX, this.maxY, this.noisyRandom));
        }
        Iterator<NoisyScreenChar> iterate = this.noisyChars.iterator();
        while (iterate.hasNext()) {
            NoisyScreenChar noisyScreenChar = iterate.next();
            noisyScreenChar.update(this.noisyRandom);
            if (!noisyScreenChar.isExpired()) continue;
            iterate.remove();
        }
    }

    private final Component loadPage(BookData bookData, int page) {
        Component component;
        try {
            String string = (String)CollectionsKt.getOrNull(bookData.getPages(), (int)(page - 1));
            if (string == null) {
                MutableComponent mutableComponent = Component.empty();
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"empty(...)");
                return (Component)mutableComponent;
            }
            String raw = string;
            component = Component.literal((String)raw);
            Intrinsics.checkNotNull((Object)component);
        }
        catch (Exception exception) {
            MutableComponent mutableComponent = Component.literal((String)"");
            Intrinsics.checkNotNull((Object)mutableComponent);
            component = (Component)mutableComponent;
        }
        return component;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        block125: {
            Pair pair;
            int y;
            int x;
            block136: {
                block135: {
                    block134: {
                        block133: {
                            block132: {
                                block131: {
                                    block130: {
                                        block129: {
                                            block128: {
                                                ArrayList<String> arrayList;
                                                block127: {
                                                    block126: {
                                                        block124: {
                                                            Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                                                            super.render(guiGraphics, mouseX, mouseY, partialTick);
                                                            x = (this.width - 192) / 2 + 36;
                                                            y = 28;
                                                            this.minX = x;
                                                            this.minY = y - 5;
                                                            this.maxX = x + 110;
                                                            this.maxY = y + 137;
                                                            guiGraphics.drawWordWrap(this.font, (FormattedText)this.pageContent, x, y, 114, 0);
                                                            pair = new Pair((Object)this.bookId, (Object)this.currentPage);
                                                            if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)2, (Object)9))) break block124;
                                                            Font font = this.font;
                                                            Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                                            TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "silly", font, x, y + 99, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                                                            Font font2 = this.font;
                                                            Intrinsics.checkNotNullExpressionValue((Object)font2, (String)"font");
                                                            TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "little", font2, x, y + 109, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                                                            Font font3 = this.font;
                                                            Intrinsics.checkNotNullExpressionValue((Object)font3, (String)"font");
                                                            TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "object", font3, x, y + 119, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                                                            break block125;
                                                        }
                                                        if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)13))) break block126;
                                                        Font font = this.font;
                                                        Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "A", x + 42, y + 56, new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                                                        Font font4 = this.font;
                                                        Intrinsics.checkNotNullExpressionValue((Object)font4, (String)"font");
                                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font4, "labyrinth.", x + 30, y + 69, new LibraryTextUtils(43520, false, false, false, false, false, null, Float.valueOf(1.0f), null, null, null, 1918, null));
                                                        break block125;
                                                    }
                                                    if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)17))) break block127;
                                                    Font font = this.font;
                                                    Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                                    TBSLibraryAnimations.INSTANCE.lungText(guiGraphics, font, "lungs", x, y + 90, this.getTime());
                                                    Font font5 = this.font;
                                                    Intrinsics.checkNotNullExpressionValue((Object)font5, (String)"font");
                                                    TBSLibraryAnimations.INSTANCE.heartText(guiGraphics, font5, "heart", x + 3, y + 107, this.getTime());
                                                    break block125;
                                                }
                                                if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)21))) break block128;
                                                Font font = this.font;
                                                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                                int n = 75;
                                                Font font6 = font;
                                                GuiGraphics guiGraphics2 = guiGraphics;
                                                TBSLibraryAnimations tBSLibraryAnimations = TBSLibraryAnimations.INSTANCE;
                                                ArrayList<String> arrayList2 = new ArrayList<String>(n);
                                                int n2 = 0;
                                                while (n2 < n) {
                                                    int n3;
                                                    int n4 = n3 = n2++;
                                                    arrayList = arrayList2;
                                                    boolean bl = false;
                                                    arrayList.add("Fuck");
                                                }
                                                arrayList = arrayList2;
                                                tBSLibraryAnimations.simpleTextStack(guiGraphics2, font6, arrayList, x, y, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(11.0f), null, Float.valueOf(88.0f), Float.valueOf(118.0f), null, 1214, null));
                                                break block125;
                                            }
                                            if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)6, (Object)4))) break block129;
                                            Font font = this.font;
                                            Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                            TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "\u00a75Who\u00a7r am \u00a71I\u00a7r?", x, y + 25, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(2.45f), null, null, null, 1918, null));
                                            Font font7 = this.font;
                                            Intrinsics.checkNotNullExpressionValue((Object)font7, (String)"font");
                                            TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font7, "What's going", x, y + 55, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
                                            Font font8 = this.font;
                                            Intrinsics.checkNotNullExpressionValue((Object)font8, (String)"font");
                                            TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font8, "on here?", x + 15, y + 71, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
                                            break block125;
                                        }
                                        if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)6, (Object)7))) break block130;
                                        Font font = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "COULD", x + 11, y + 7, new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                                        Font font9 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font9, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font9, "UNDERSTAND", x + 50, y + 21, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(0.85f), null, null, null, 1914, null));
                                        Font font10 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font10, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font10, "WHAT", x + 30, y + 58, new LibraryTextUtils(0, false, true, false, false, false, Float.valueOf(277.0f), Float.valueOf(0.93f), null, null, null, 1850, null));
                                        Font font11 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font11, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font11, "THE", x + 55, y + 58, new LibraryTextUtils(0, false, true, false, false, false, Float.valueOf(277.0f), Float.valueOf(0.93f), null, null, null, 1850, null));
                                        Font font12 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font12, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font12, "HELL", x + 78, y + 38, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(0.85f), null, null, null, 1914, null));
                                        Font font13 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font13, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font13, "WE WERE", x + 7, y + 68, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.65f), null, null, null, 1914, null));
                                        Font font14 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font14, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font14, "LOOKING", x + 7, y + 96, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.1f), null, null, null, 1914, null));
                                        Font font15 = this.font;
                                        Intrinsics.checkNotNullExpressionValue((Object)font15, (String)"font");
                                        TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font15, "AT", x + 78, y + 96, new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                                        break block125;
                                    }
                                    if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)6, (Object)14))) break block131;
                                    Font font = this.font;
                                    Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                    TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "dead?", font, x + 25, y, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                                    break block125;
                                }
                                if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)6, (Object)16))) break block132;
                                Font font = this.font;
                                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "I'm asleep", x + 32, y + 99, new LibraryTextUtils(0xBBBBBB, false, false, false, true, false, null, null, null, null, null, 2030, null));
                                break block125;
                            }
                            if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)7, (Object)1))) break block133;
                            Font font = this.font;
                            Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                            TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Fuck it all.", font, x, y + 110, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                            break block125;
                        }
                        if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)7, (Object)21))) break block134;
                        Font font = this.font;
                        Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                        TBSLibraryAnimations.INSTANCE.clockText(guiGraphics, font, "TIME", "MEANS", "NOTHING", x + 55, y + 65);
                        int currentSec = (int)this.getTime();
                        if (currentSec == this.prevSec) break block125;
                        this.prevSec = currentSec;
                        RegistryEntry<SoundEvent, SoundEvent> sound = currentSec % 2 == 0 ? TBSSounds.TICK : TBSSounds.TOCK;
                        Minecraft.getInstance().getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)((Holder)sound), (float)1.0f));
                        break block125;
                    }
                    if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)8, (Object)5))) break block135;
                    Font font = this.font;
                    Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                    TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Fear", x, y + 33, new LibraryTextUtils(0xA23333, false, false, false, false, false, null, Float.valueOf(4.75f), null, null, null, 1918, null));
                    break block125;
                }
                if (!Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)8, (Object)8))) break block136;
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.clockText(guiGraphics, font, "TIME", "MEANS", "NOTHING", x + 55, y + 65);
                int currentSec = (int)this.getTime();
                if (currentSec == this.prevSec) break block125;
                this.prevSec = currentSec;
                RegistryEntry<SoundEvent, SoundEvent> sound = currentSec % 2 == 0 ? TBSSounds.TICK : TBSSounds.TOCK;
                Minecraft.getInstance().getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)((Holder)sound), (float)1.0f));
                break block125;
            }
            if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)8, (Object)10))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "I do.", x + 1, y + 15, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.7f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)10, (Object)27))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "By", x + 31, y + 27, new LibraryTextUtils(0xFFFFFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font16 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font16, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "any", font16, x + 53, y + 45, this.getTime(), new LibraryTextUtils(0xAA0000, false, false, false, false, false, Float.valueOf(252.0f), null, null, null, null, 1982, null));
                Font font17 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font17, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font17, "means", x + 31, y + 65, new LibraryTextUtils(0xFFFFFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font18 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font18, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font18, "necessary", x + 31, y + 75, new LibraryTextUtils(0xFFFFFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)11, (Object)1))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Closer", x, y + 25, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
                Font font19 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font19, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font19, "Closer", x, y + 55, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(2.75f), null, null, null, 1918, null));
                Font font20 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font20, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font20, "Closer", x, y + 95, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(3.6f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)14, (Object)2))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Pyrophobia", font, x, y, this.getTime(), new LibraryTextUtils(0xFF4000, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)15, (Object)3))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "I mean a ", x, y + 55, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
                Font font21 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font21, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font21, "much more", x, y + 68, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
                Font font22 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font22, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "vile", font22, x, y + 13, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1914, null));
                Font font23 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font23, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font23, "nothing", x + 45, y + 85, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)15, (Object)8))) {
                int i = 0;
                int j = 0;
                int n = 8;
                int n5 = 0;
                while (n5 < n) {
                    int it = n5++;
                    boolean bl = false;
                    Font font = this.font;
                    Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                    TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "NOTHING", x + 7, y + j - 8, new LibraryTextUtils(i, false, true, false, false, false, Float.valueOf(3.5f), Float.valueOf(1.95f), null, null, null, 1850, null));
                    j += 17;
                    i += 0x191919;
                }
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)16, (Object)2))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "There.", x, y, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.75f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)16, (Object)10))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "\u00a76Arches of Yarn\u00a7r", x, y, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1919, null));
                Font font24 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font24, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font24, "is waiting for \u00a71me\u00a7r", x, y + 12, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)16, (Object)14))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Something", font, x, y - 16, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
                Font font25 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font25, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font25, "is here", x, y + 12, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1918, null));
                Font font26 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font26, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font26, "\u00a71I\u00a7r can feel it.", x, y + 24, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)16, (Object)16))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Fight", font, x, y - 16, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
                Font font27 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font27, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "or", font27, x + 45, y - 8, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
                Font font28 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font28, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "flight", font28, x + 70, y - 5, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)16, (Object)18))) {
                int i = 0;
                int j = 0;
                int n = 13;
                int n6 = 0;
                while (n6 < n) {
                    int it = n6++;
                    boolean bl = false;
                    Font font = this.font;
                    Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                    TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "THUD", font, x + i, y + 30 - i, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
                    Font font29 = this.font;
                    Intrinsics.checkNotNullExpressionValue((Object)font29, (String)"font");
                    TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "THUD", font29, x + j + 51, y + 30 - i, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1914, null));
                    i += 3;
                    j += 2;
                }
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)18, (Object)12))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Fuck.", font, x, y, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                Font font30 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font30, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Not again.", font30, x, y + 10, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)20, (Object)8))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "just one", font, x, y - 10, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.1f), null, null, null, 1914, null));
                Font font31 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font31, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "more", font31, x, y - 5, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.3f), null, null, null, 1914, null));
                Font font32 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font32, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "step", font32, x, y, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.5f), null, null, null, 1914, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)1))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 83, y + 18, new LibraryTextUtils(0x6666EE, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)5))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 9, new LibraryTextUtils(0x8888DD, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)6))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 117, new LibraryTextUtils(0x8888DD, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)7))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 71, y + 54, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)8))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "fucking die?", font, x + 24, y + 72, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)9))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 9, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font33 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font33, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "pi      pa", font33, x + 5, y + 99, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
                Font font34 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font34, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "tter     tter", font34, x + 9, y + 111, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)10))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 22, y, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)11))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 22, y, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font35 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font35, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font35, "beast", x, y + 117, new LibraryTextUtils(0x8888AA, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)15))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 35, y + 54, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)19))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 83, y + 9, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)20))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 67, y + 90, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)21))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 99, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)23))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Judgement", x + 120, y + 30, new LibraryTextUtils(0x880000, false, true, false, false, false, null, null, null, null, null, 2042, null));
                Font font36 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font36, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font36, "is upon you,", x + 116, y + 40, new LibraryTextUtils(0x880000, false, true, false, false, false, null, null, null, null, null, 2042, null));
                Font font37 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font37, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "wretched thing", font37, x + 103, y + 50, this.getTime(), new LibraryTextUtils(0x880000, true, true, false, false, false, null, null, null, null, null, 2040, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)23, (Object)16))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "tremble", font, x + 28, y + 63, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)23, (Object)23))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "\u00a71I\u00a7r am far,", x + 60, y, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.25f), null, null, null, 1918, null));
                Font font38 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font38, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font38, "far", x, y + 25, new LibraryTextUtils(0, true, true, true, false, false, null, Float.valueOf(1.25f), null, null, null, 1904, null));
                Font font39 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font39, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font39, "above this monster", x + 1, y + 60, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.2f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)25, (Object)4))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "I", x, y, new LibraryTextUtils(0x110099, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font40 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font40, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font40, "myself", x + 44, y, new LibraryTextUtils(0x2200AA, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font41 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font41, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font41, "I", x + 58, y + 27, new LibraryTextUtils(0x3300AA, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font42 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font42, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font42, "me", x + 28, y + 45, new LibraryTextUtils(0x330099, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font43 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font43, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font43, "My", x + 90, y + 45, new LibraryTextUtils(0x440099, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font44 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font44, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font44, "my", x + 68, y + 90, new LibraryTextUtils(0x440088, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)25, (Object)5))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "my", x, y + 45, new LibraryTextUtils(0x440077, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font45 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font45, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font45, "I", x + 22, y + 54, new LibraryTextUtils(0x550044, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font46 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font46, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font46, "my", x + 42, y + 63, new LibraryTextUtils(0x660011, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font47 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font47, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font47, "I", x + 96, y + 81, new LibraryTextUtils(0x880000, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)33))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "It's been a ", x + 52, y + 60, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(75.0f), Float.valueOf(0.55f), null, null, null, 1855, null));
                Font font48 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font48, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font48, "pleasure, \u00a75Wilbur\u00a7r.", x + 46, y + 60, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(75.0f), Float.valueOf(0.43f), null, null, null, 1855, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)29, (Object)3))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "This is a trap.", x, y + 25, new LibraryTextUtils(0, true, true, true, false, false, null, Float.valueOf(1.25f), null, null, null, 1904, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)29, (Object)6))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "No no no", font, x + 20, y + 35, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, null, null, null, null, 2042, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)29, (Object)14))) {
                ArrayList<String> arrayList;
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                int n = 150;
                Font font49 = font;
                GuiGraphics guiGraphics3 = guiGraphics;
                TBSLibraryAnimations tBSLibraryAnimations = TBSLibraryAnimations.INSTANCE;
                ArrayList<String> j = new ArrayList<String>(n);
                int n7 = 0;
                while (n7 < n) {
                    int n8;
                    int it = n8 = n7++;
                    arrayList = j;
                    boolean bl = false;
                    arrayList.add("Useless");
                }
                arrayList = j;
                tBSLibraryAnimations.simpleTextStack(guiGraphics3, font49, arrayList, x, y, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(-1.0f), null, Float.valueOf(70.0f), Float.valueOf(120.0f), null, 1214, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)30, (Object)2))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Thrust.", x + 1, y + 60, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(2.75f), null, null, null, 1914, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)32, (Object)3))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Something is", font, x, y + 108, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font50 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font50, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "approaching", font50, x, y + 118, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)32, (Object)12))) {
                ArrayList<String> arrayList;
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                int n = 15;
                Font font51 = font;
                GuiGraphics guiGraphics4 = guiGraphics;
                TBSLibraryAnimations tBSLibraryAnimations = TBSLibraryAnimations.INSTANCE;
                ArrayList<String> j = new ArrayList<String>(n);
                int n9 = 0;
                while (n9 < n) {
                    int n10;
                    int it = n10 = n9++;
                    arrayList = j;
                    boolean bl = false;
                    arrayList.add("Right?");
                }
                arrayList = j;
                tBSLibraryAnimations.simpleTextStack(guiGraphics4, font51, arrayList, x, y + 89, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(-2.0f), null, Float.valueOf(65.0f), Float.valueOf(30.0f), null, 1214, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)34, (Object)4))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "are not", x + 1, y + 60, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(2.2f), null, null, null, 1918, null));
                Font font52 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font52, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font52, "as empty", x + 1, y + 80, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.8f), null, null, null, 1918, null));
                Font font53 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font53, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font53, "as they seem", x + 1, y + 100, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.4f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)34, (Object)7))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "\u00a76Arches of Yarn\u00a7r.", x + 1, y + 60, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.4f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)34, (Object)21))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Just make", x + 1, y + 60, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.4f), null, null, null, 1918, null));
                Font font54 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font54, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font54, "a fucking choice.", x + 1, y + 80, new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(1.0f), null, null, null, 1914, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)35, (Object)17))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "There's no", x + 1, y + 15, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.7f), null, null, null, 1918, null));
                Font font55 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font55, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font55, "such thing", x + 5, y + 35, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.7f), null, null, null, 1918, null));
                Font font56 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font56, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font56, "as \u00a7lmonsters\u00a7r", x - 2, y + 55, new LibraryTextUtils(0, false, false, false, false, false, null, Float.valueOf(1.7f), null, null, null, 1918, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)37, (Object)4))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "fuckingdie", font, x - 1, y + 9, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)37, (Object)6))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "miss.", font, x, y, this.getTime(), new LibraryTextUtils(0, false, true, false, false, false, null, Float.valueOf(3.3f), null, null, null, 1914, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)39, (Object)14))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "Who is", x + 43, y + 15, new LibraryTextUtils(0, false, false, false, false, false, Float.valueOf(48.0f), null, null, null, null, 1983, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)40, (Object)0))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Holy shit,", font, x - 1, y + 9, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font57 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font57, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "it's cold.", font57, x - 1, y + 25, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)40, (Object)1))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "Holy shit,", font, x - 1, y + 110, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font58 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font58, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "it is so cold.", font58, x - 1, y + 120, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)0))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x, y + 54, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
                Font font59 = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font59, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font59, "beast", x + 20, y + 117, new LibraryTextUtils(0x8888CC, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)3))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 69, y + 108, new LibraryTextUtils(0x9999DD, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)5))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 54, new LibraryTextUtils(0x9999FF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)6))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.jitteryText(guiGraphics, "No no no.", font, x + 40, y + 106, this.getTime(), new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)11))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 22, y + 18, new LibraryTextUtils(0xAAAAFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)12))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 69, y + 90, new LibraryTextUtils(0xAAAAFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)14))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 117, new LibraryTextUtils(0xAAAAFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)15))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 64, y + 9, new LibraryTextUtils(0xBBBBFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)17))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 60, y + 9, new LibraryTextUtils(0xCCCCFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)18))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 36, new LibraryTextUtils(0xCCCCFF, false, false, false, false, false, null, null, null, null, null, 2046, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)21))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x, y + 36, new LibraryTextUtils(0xCCCCFF, false, false, false, true, false, null, null, null, null, null, 2030, null));
            } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)22))) {
                Font font = this.font;
                Intrinsics.checkNotNullExpressionValue((Object)font, (String)"font");
                TBSLibraryAnimations.INSTANCE.simpleText(guiGraphics, font, "beast", x + 20, y + 45, new LibraryTextUtils(0xCCCCFF, false, false, false, true, false, null, null, null, null, null, 2030, null));
            } else if (this.bookId % 2 == 0) {
                int n = this.bookId;
                if (!(1 <= n ? n < 45 : false)) {
                    for (NoisyScreenChar noisyScreenChar : this.noisyChars) {
                        guiGraphics.drawString(this.font, String.valueOf(noisyScreenChar.getChar()), noisyScreenChar.getX(), noisyScreenChar.getY(), 0, false);
                    }
                }
            }
        }
    }

    private final void blitCenteredInBook(GuiGraphics guiGraphics, ResourceLocation texture, int destWidth, int destHeight, int srcWidth, int srcHeight) {
        int bookX = (this.width - 192) / 2;
        int bookY = 5;
        int x = bookX + (192 - destWidth) / 2;
        int y = bookY + (192 - destHeight) / 2;
        guiGraphics.blit(texture, x, y, destWidth, destHeight, 0.0f, 0.0f, srcWidth, srcHeight, srcWidth, srcHeight);
    }

    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseY, int p3) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        guiGraphics.blit(BOOK_GUI_LOCATION, (this.width - 192) / 2, 5, 0, 0, 192, 192);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Pair pair = new Pair((Object)this.bookId, (Object)this.currentPage);
        if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)2, (Object)10))) {
            this.blitCenteredInBook(guiGraphics, WILBURS_PEN, 120, 150, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)2, (Object)19))) {
            this.blitCenteredInBook(guiGraphics, PEN_EXPOSED, 130, 165, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)6))) {
            this.blitCenteredInBook(guiGraphics, OLIVER_HALLWAY_CORNER, 120, 130, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)13))) {
            guiGraphics.blit(LABYRINTH, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)4, (Object)25))) {
            this.blitCenteredInBook(guiGraphics, COAT_MAZE, 132, 76, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)6, (Object)7))) {
            guiGraphics.blit(BOOK_GUI_STENCIL, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)7, (Object)3))) {
            this.blitCenteredInBook(guiGraphics, OLIVER_ENDLESS_HALLWAY, 119, 70, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)7, (Object)21))) {
            guiGraphics.blit(BOOK_GUI_CLOCK, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)8, (Object)8))) {
            guiGraphics.blit(BOOK_GUI_CLOCK, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)10, (Object)3))) {
            this.blitCenteredInBook(guiGraphics, WILBURS_LAST_STAND, 126, 148, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)10, (Object)22))) {
            this.blitCenteredInBook(guiGraphics, A_KNIFE_APPEARS, 132, 147, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)10, (Object)27))) {
            this.blitCenteredInBook(guiGraphics, ULTIMATUM, 155, 200, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)12, (Object)10))) {
            this.blitCenteredInBook(guiGraphics, WILBURS_NOTE, 120, 75, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)14, (Object)13))) {
            this.blitCenteredInBook(guiGraphics, LEFT_BEHIND, 140, 170, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)17, (Object)8))) {
            guiGraphics.blit(ETERNITY_PIT, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)18, (Object)2))) {
            guiGraphics.blit(OLIVER_DRAGONS_BREATH, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)19, (Object)14))) {
            guiGraphics.blit(THERMAL_CAM, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)22, (Object)23))) {
            this.blitCenteredInBook(guiGraphics, JUDGEMENT, 385, 275, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)24, (Object)2))) {
            guiGraphics.blit(WILBUR_WAKES_UP, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)27, (Object)3))) {
            guiGraphics.blit(FORGING_HELLS_HORN, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)27, (Object)8))) {
            guiGraphics.blit(A_MONSTER_IS_BORN, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)11))) {
            guiGraphics.blit(A_WAY_OUT, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)19))) {
            guiGraphics.blit(GRAVESTONE, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)22))) {
            guiGraphics.blit(TIME_T0_GO, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)28))) {
            guiGraphics.blit(WILBURS_SHOTGUN, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)28, (Object)33))) {
            guiGraphics.blit(FINAL_GOODBYE, (this.width - 194) / 2, 5, 0, 0, 192, 192);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)38, (Object)11))) {
            guiGraphics.blit(BOOK_TREE, (this.width - 194) / 2, 5, 0, 0, 256, 256);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)38, (Object)22))) {
            guiGraphics.blit(WILBURS_SHOTGUN, (this.width - 194) / 2, 5, 0, 0, 256, 256);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)39, (Object)14))) {
            guiGraphics.blit(OLIVERS_TAG, (this.width - 194) / 2, 5, 0, 0, 256, 256);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)40, (Object)11))) {
            this.blitCenteredInBook(guiGraphics, WILBURS_NOTE, 132, 85, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)40, (Object)17))) {
            this.blitCenteredInBook(guiGraphics, OLIVERS_NOTE, 120, 110, 1000, 1250);
        } else if (Intrinsics.areEqual((Object)pair, (Object)new Pair((Object)44, (Object)8))) {
            this.blitCenteredInBook(guiGraphics, BEAST_FINALE, 360, 360, 1000, 1250);
        }
    }

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    private static final void createButtons$lambda$0(LibraryBookScreen this$0, Button it) {
        this$0.pageForward();
    }

    private static final void createButtons$lambda$1(LibraryBookScreen this$0, Button it) {
        this$0.pageBack();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/client/gui/LibraryBookScreen$BookData;", "", "pages", "", "", "<init>", "(Ljava/util/List;)V", "getPages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "thebrokenscript-common"})
    public static final class BookData {
        @NotNull
        private final List<String> pages;

        public BookData(@NotNull List<String> pages) {
            Intrinsics.checkNotNullParameter(pages, (String)"pages");
            this.pages = pages;
        }

        public /* synthetic */ BookData(List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                list = CollectionsKt.emptyList();
            }
            this(list);
        }

        @NotNull
        public final List<String> getPages() {
            return this.pages;
        }

        @NotNull
        public final List<String> component1() {
            return this.pages;
        }

        @NotNull
        public final BookData copy(@NotNull List<String> pages) {
            Intrinsics.checkNotNullParameter(pages, (String)"pages");
            return new BookData(pages);
        }

        public static /* synthetic */ BookData copy$default(BookData bookData, List list, int n, Object object) {
            if ((n & 1) != 0) {
                list = bookData.pages;
            }
            return bookData.copy(list);
        }

        @NotNull
        public String toString() {
            return "BookData(pages=" + this.pages + ")";
        }

        public int hashCode() {
            return ((Object)this.pages).hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookData)) {
                return false;
            }
            BookData bookData = (BookData)other;
            return Intrinsics.areEqual(this.pages, bookData.pages);
        }

        public BookData() {
            this(null, 1, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b=\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007\u00a8\u0006B"}, d2={"Lnet/thebrokenscript/client/gui/LibraryBookScreen$Companion;", "", "<init>", "()V", "BOOK_GUI_LOCATION", "Lnet/minecraft/resources/ResourceLocation;", "getBOOK_GUI_LOCATION", "()Lnet/minecraft/resources/ResourceLocation;", "BOOK_GUI_STENCIL", "getBOOK_GUI_STENCIL", "BOOK_GUI_CLOCK", "getBOOK_GUI_CLOCK", "WILBURS_PEN", "getWILBURS_PEN", "PEN_EXPOSED", "getPEN_EXPOSED", "OLIVER_HALLWAY_CORNER", "getOLIVER_HALLWAY_CORNER", "WILBURS_NOTE", "getWILBURS_NOTE", "OLIVER_ENDLESS_HALLWAY", "getOLIVER_ENDLESS_HALLWAY", "OLIVERS_NOTE", "getOLIVERS_NOTE", "BOOK_TREE", "getBOOK_TREE", "WILBURS_SHOTGUN", "getWILBURS_SHOTGUN", "OLIVER_DRAGONS_BREATH", "getOLIVER_DRAGONS_BREATH", "TIME_T0_GO", "getTIME_T0_GO", "A_WAY_OUT", "getA_WAY_OUT", "BEAST_FINALE", "getBEAST_FINALE", "WILBURS_LAST_STAND", "getWILBURS_LAST_STAND", "A_KNIFE_APPEARS", "getA_KNIFE_APPEARS", "ULTIMATUM", "getULTIMATUM", "LEFT_BEHIND", "getLEFT_BEHIND", "JUDGEMENT", "getJUDGEMENT", "ETERNITY_PIT", "getETERNITY_PIT", "LABYRINTH", "getLABYRINTH", "COAT_MAZE", "getCOAT_MAZE", "THERMAL_CAM", "getTHERMAL_CAM", "WILBUR_WAKES_UP", "getWILBUR_WAKES_UP", "FORGING_HELLS_HORN", "getFORGING_HELLS_HORN", "A_MONSTER_IS_BORN", "getA_MONSTER_IS_BORN", "GRAVESTONE", "getGRAVESTONE", "FINAL_GOODBYE", "getFINAL_GOODBYE", "OLIVERS_TAG", "getOLIVERS_TAG", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getBOOK_GUI_LOCATION() {
            return BOOK_GUI_LOCATION;
        }

        @NotNull
        public final ResourceLocation getBOOK_GUI_STENCIL() {
            return BOOK_GUI_STENCIL;
        }

        @NotNull
        public final ResourceLocation getBOOK_GUI_CLOCK() {
            return BOOK_GUI_CLOCK;
        }

        @NotNull
        public final ResourceLocation getWILBURS_PEN() {
            return WILBURS_PEN;
        }

        @NotNull
        public final ResourceLocation getPEN_EXPOSED() {
            return PEN_EXPOSED;
        }

        @NotNull
        public final ResourceLocation getOLIVER_HALLWAY_CORNER() {
            return OLIVER_HALLWAY_CORNER;
        }

        @NotNull
        public final ResourceLocation getWILBURS_NOTE() {
            return WILBURS_NOTE;
        }

        @NotNull
        public final ResourceLocation getOLIVER_ENDLESS_HALLWAY() {
            return OLIVER_ENDLESS_HALLWAY;
        }

        @NotNull
        public final ResourceLocation getOLIVERS_NOTE() {
            return OLIVERS_NOTE;
        }

        @NotNull
        public final ResourceLocation getBOOK_TREE() {
            return BOOK_TREE;
        }

        @NotNull
        public final ResourceLocation getWILBURS_SHOTGUN() {
            return WILBURS_SHOTGUN;
        }

        @NotNull
        public final ResourceLocation getOLIVER_DRAGONS_BREATH() {
            return OLIVER_DRAGONS_BREATH;
        }

        @NotNull
        public final ResourceLocation getTIME_T0_GO() {
            return TIME_T0_GO;
        }

        @NotNull
        public final ResourceLocation getA_WAY_OUT() {
            return A_WAY_OUT;
        }

        @NotNull
        public final ResourceLocation getBEAST_FINALE() {
            return BEAST_FINALE;
        }

        @NotNull
        public final ResourceLocation getWILBURS_LAST_STAND() {
            return WILBURS_LAST_STAND;
        }

        @NotNull
        public final ResourceLocation getA_KNIFE_APPEARS() {
            return A_KNIFE_APPEARS;
        }

        @NotNull
        public final ResourceLocation getULTIMATUM() {
            return ULTIMATUM;
        }

        @NotNull
        public final ResourceLocation getLEFT_BEHIND() {
            return LEFT_BEHIND;
        }

        @NotNull
        public final ResourceLocation getJUDGEMENT() {
            return JUDGEMENT;
        }

        @NotNull
        public final ResourceLocation getETERNITY_PIT() {
            return ETERNITY_PIT;
        }

        @NotNull
        public final ResourceLocation getLABYRINTH() {
            return LABYRINTH;
        }

        @NotNull
        public final ResourceLocation getCOAT_MAZE() {
            return COAT_MAZE;
        }

        @NotNull
        public final ResourceLocation getTHERMAL_CAM() {
            return THERMAL_CAM;
        }

        @NotNull
        public final ResourceLocation getWILBUR_WAKES_UP() {
            return WILBUR_WAKES_UP;
        }

        @NotNull
        public final ResourceLocation getFORGING_HELLS_HORN() {
            return FORGING_HELLS_HORN;
        }

        @NotNull
        public final ResourceLocation getA_MONSTER_IS_BORN() {
            return A_MONSTER_IS_BORN;
        }

        @NotNull
        public final ResourceLocation getGRAVESTONE() {
            return GRAVESTONE;
        }

        @NotNull
        public final ResourceLocation getFINAL_GOODBYE() {
            return FINAL_GOODBYE;
        }

        @NotNull
        public final ResourceLocation getOLIVERS_TAG() {
            return OLIVERS_TAG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


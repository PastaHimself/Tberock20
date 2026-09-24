/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.text.StringsKt
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.impl.client.JpgLoader
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.client.JpgLoader;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010%\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010&\u001a\u00020\u0018H\u0007R2\u0010\u0004\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0011\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0013\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R8\u0010\u0016\u001a,\u0012(\u0012&\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0006\u0012\u0004\u0012\u00020\b0\u00050\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u00188FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010$\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/api/TBSMenuBackgrounds;", "", "<init>", "()V", "CIRCUIT_BACKGROUND_IMAGES", "Lkotlin/Pair;", "", "", "", "CHORD_BACKGROUND_IMAGES", "CURVED_BACKGROUND_IMAGES", "FARAWAY_BACKGROUND_IMAGES", "FEVER_BACKGROUND_IMAGES", "FRACTURED_BACKGROUND_IMAGES", "INTEGRITY_BACKGROUND_IMAGES", "MOON_BACKGROUND_IMAGES", "NULL_BACKGROUND_IMAGES", "OBLITERATION_BACKGROUND_IMAGES", "REVUXOR_BACKGROUND_IMAGES", "SILUET_BACKGROUND_IMAGES", "TBE_BACKGROUND_IMAGES", "FUNNY_BACKGROUND_IMAGES", "BG_IMAGES_SET", "MENU_BACKGROUNDS", "Lnet/minecraft/resources/ResourceLocation;", "getMENU_BACKGROUNDS", "()Ljava/util/Set;", "FUNNY_MENU_BACKGROUNDS", "", "CURRENT_MENU_BACKGROUND", "FUNNY_CURRENT_MENU_BACKGROUND", "isFunnyActive", "", "menuBackground", "getMenuBackground$annotations", "getMenuBackground", "()Lnet/minecraft/resources/ResourceLocation;", "refreshMenuBackground", "refreshFunnyMenuBackground", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSMenuBackgrounds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSMenuBackgrounds.kt\nnet/thebrokenscript/api/TBSMenuBackgrounds\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n1869#2,2:300\n1563#2:302\n1634#2,3:303\n*S KotlinDebug\n*F\n+ 1 TBSMenuBackgrounds.kt\nnet/thebrokenscript/api/TBSMenuBackgrounds\n*L\n238#1:300,2\n252#1:302\n252#1:303,3\n*E\n"})
public final class TBSMenuBackgrounds {
    @NotNull
    public static final TBSMenuBackgrounds INSTANCE;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> CIRCUIT_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> CHORD_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> CURVED_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> FARAWAY_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> FEVER_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> FRACTURED_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> INTEGRITY_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> MOON_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> NULL_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> OBLITERATION_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> REVUXOR_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> SILUET_BACKGROUND_IMAGES;
    @NotNull
    private static final Pair<Set<Pair<String, Set<String>>>, Long> TBE_BACKGROUND_IMAGES;
    @NotNull
    private static final Set<String> FUNNY_BACKGROUND_IMAGES;
    @NotNull
    private static final Set<Pair<Set<Pair<String, Set<String>>>, Long>> BG_IMAGES_SET;
    @NotNull
    private static final List<ResourceLocation> FUNNY_MENU_BACKGROUNDS;
    @Nullable
    private static ResourceLocation CURRENT_MENU_BACKGROUND;
    @Nullable
    private static ResourceLocation FUNNY_CURRENT_MENU_BACKGROUND;
    private static boolean isFunnyActive;

    private TBSMenuBackgrounds() {
    }

    private final Set<ResourceLocation> getMENU_BACKGROUNDS() {
        Set result = new LinkedHashSet();
        Iterable $this$forEach$iv = BG_IMAGES_SET;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair)element$iv;
            boolean bl = false;
            if (!ClientVariables.INSTANCE.has(((Number)it.getSecond()).longValue())) continue;
            for (Pair authorPair : (Set)it.getFirst()) {
                for (String str : (Set)authorPair.getSecond()) {
                    result.add(TBSConstants.id("textures/gui/menu/backgrounds/" + str));
                }
            }
        }
        return result;
    }

    @Nullable
    public static final ResourceLocation getMenuBackground() {
        ResourceLocation resourceLocation;
        if (isFunnyActive) {
            resourceLocation = FUNNY_CURRENT_MENU_BACKGROUND;
            if (resourceLocation == null) {
                resourceLocation = TBSMenuBackgrounds.refreshFunnyMenuBackground();
            }
        } else {
            resourceLocation = CURRENT_MENU_BACKGROUND;
            if (resourceLocation == null) {
                resourceLocation = TBSMenuBackgrounds.refreshMenuBackground();
            }
        }
        return resourceLocation;
    }

    @JvmStatic
    public static /* synthetic */ void getMenuBackground$annotations() {
    }

    @JvmStatic
    @Nullable
    public static final ResourceLocation refreshMenuBackground() {
        ResourceLocation resourceLocation;
        boolean bl = isFunnyActive = TBSConfigs.INSTANCE.getServer().getDanger().getFunnySetting() && ClientDSLKt.getMC().font.random.nextFloat() <= 0.01f;
        if (isFunnyActive) {
            resourceLocation = TBSMenuBackgrounds.refreshFunnyMenuBackground();
        } else if (!((Collection)INSTANCE.getMENU_BACKGROUNDS()).isEmpty()) {
            Object object = CollectionsKt.random((Collection)INSTANCE.getMENU_BACKGROUNDS(), (Random)((Random)Random.Default));
            ResourceLocation it = (ResourceLocation)object;
            boolean bl2 = false;
            CURRENT_MENU_BACKGROUND = it;
            String string = it.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
            if (StringsKt.endsWith$default((String)string, (String)".jpg", (boolean)false, (int)2, null)) {
                JpgLoader.Companion.loadJpg(it);
            }
            resourceLocation = (ResourceLocation)object;
        } else {
            resourceLocation = null;
        }
        return resourceLocation;
    }

    @JvmStatic
    @NotNull
    public static final ResourceLocation refreshFunnyMenuBackground() {
        Object object = CollectionsKt.random((Collection)FUNNY_MENU_BACKGROUNDS, (Random)((Random)Random.Default));
        ResourceLocation it = (ResourceLocation)object;
        boolean bl = false;
        FUNNY_CURRENT_MENU_BACKGROUND = it;
        String string = it.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        if (StringsKt.endsWith$default((String)string, (String)".jpg", (boolean)false, (int)2, null)) {
            JpgLoader.Companion.loadJpg(it);
        }
        return (ResourceLocation)object;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_4;
        void $this$mapTo$iv$iv;
        INSTANCE = new TBSMenuBackgrounds();
        Object[] objectArray = new Pair[]{TuplesKt.to((Object)"rabeon", (Object)SetsKt.setOf((Object)"circuit/caveman.jpg")), TuplesKt.to((Object)"mafia_circuit", (Object)SetsKt.setOf((Object)"circuit/circuit_frolic.jpg")), TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"circuit/new_super_circuit_bros_3d.jpg"))};
        CIRCUIT_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)1L);
        objectArray = new String[]{"chord/baby_harmony.jpg", "chord/coordinates.jpg"};
        CHORD_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object)TuplesKt.to((Object)"mavender", (Object)SetsKt.setOf((Object[])objectArray))), (Object)8L);
        objectArray = new Pair[]{TuplesKt.to((Object)"ebridger", (Object)SetsKt.setOf((Object)"curved/caveboy.jpg")), TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"curved/bad_posture.jpg"))};
        CURVED_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)32L);
        FARAWAY_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object)TuplesKt.to((Object)"eyae", (Object)SetsKt.setOf((Object)"faraway/john_far.jpg"))), (Object)64L);
        objectArray = new Pair[6];
        objectArray[0] = TuplesKt.to((Object)"ebridger", (Object)SetsKt.setOf((Object)"fever/colorfever.jpg"));
        objectArray[1] = TuplesKt.to((Object)"echo", (Object)SetsKt.setOf((Object)"fever/la_fever.png"));
        Object[] objectArray2 = new String[]{"fever/cold.jpg", "fever/protofever.jpg"};
        objectArray[2] = TuplesKt.to((Object)"mochi", (Object)SetsKt.setOf((Object[])objectArray2));
        objectArray[3] = TuplesKt.to((Object)"magazine", (Object)SetsKt.setOf((Object)"fever/da_fever.png"));
        objectArray[4] = TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"fever/increase_in_heat.jpg"));
        objectArray[5] = TuplesKt.to((Object)"lavaimp", (Object)SetsKt.setOf((Object)"fever/red_fever.jpg"));
        FEVER_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)2L);
        objectArray = new Pair[]{TuplesKt.to((Object)"ancient", (Object)SetsKt.setOf((Object)"fractured/double_trouble_jimmy_fever.jpg")), TuplesKt.to((Object)"ebridger", (Object)SetsKt.setOf((Object)"fractured/pale_jimmy.jpg")), TuplesKt.to((Object)"lost", (Object)SetsKt.setOf((Object)"fractured/moonboy.jpg")), TuplesKt.to((Object)"novaShards", (Object)SetsKt.setOf((Object)"fractured/hey_jimmy_gimme_a_cheese_with_nothin.png")), TuplesKt.to((Object)"mafia_circuit", (Object)SetsKt.setOf((Object)"fractured/jimmy_copy.jpg")), TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"fractured/the_one_with_many_legs.jpg")), TuplesKt.to((Object)"teebee", (Object)SetsKt.setOf((Object)"fractured/nothin.jpg"))};
        FRACTURED_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)4L);
        objectArray = new Pair[]{TuplesKt.to((Object)"ancient", (Object)SetsKt.setOf((Object)"integrity/integrity2.jpg")), TuplesKt.to((Object)"mafia_circuit", (Object)SetsKt.setOf((Object)"integrity/integ_mafia.jpg")), TuplesKt.to((Object)"ebridger", (Object)SetsKt.setOf((Object)"integrity/heavenlytegrity.jpg")), TuplesKt.to((Object)"mochi", (Object)SetsKt.setOf((Object)"integrity/darktegrity.jpg")), TuplesKt.to((Object)"rabeon", (Object)SetsKt.setOf((Object)"integrity/splittegrity.jpg")), TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"integrity/smoketegrity.jpg")), TuplesKt.to((Object)"teebee", (Object)SetsKt.setOf((Object)"integrity/splitter.jpg")), TuplesKt.to((Object)"novaShards", (Object)SetsKt.setOf((Object)"integrity/scarlet_king.jpg")), TuplesKt.to((Object)"jacko", (Object)SetsKt.setOf((Object)"integrity/world_domination.jpg"))};
        INTEGRITY_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)256L);
        objectArray = new Pair[2];
        objectArray2 = new String[]{"moon/dark_moon_1.jpg", "moon/dark_moon_2.jpg"};
        objectArray[0] = TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object[])objectArray2));
        objectArray2 = new String[]{"moon/moon1.png", "moon/moon2.png"};
        objectArray[1] = TuplesKt.to((Object)"ancient", (Object)SetsKt.setOf((Object[])objectArray2));
        MOON_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)512L);
        objectArray = new Pair[]{TuplesKt.to((Object)"echo", (Object)SetsKt.setOf((Object)"null/null_field_day.jpg")), TuplesKt.to((Object)"psyychopomp", (Object)SetsKt.setOf((Object)"null/cool_glitchy_null_by_autumn.jpg")), TuplesKt.to((Object)"mavender", (Object)SetsKt.setOf((Object)"null/a_very_null_night.jpg")), TuplesKt.to((Object)"jacko", (Object)SetsKt.setOf((Object)"null/void_castle.jpg"))};
        NULL_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)16L);
        objectArray = new Pair[]{TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object)"obliteration/dark_save_point.jpg")), TuplesKt.to((Object)"mafia_circuit", (Object)SetsKt.setOf((Object)"obliteration/oblit2.jpg"))};
        OBLITERATION_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)1024L);
        REVUXOR_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object)TuplesKt.to((Object)"err.type.guilherme", (Object)SetsKt.setOf((Object)"revuxor/depressuxor.jpg"))), (Object)128L);
        objectArray = new Pair[2];
        objectArray2 = new String[]{"siluet/cool_he.jpg", "siluet/cool_r2.jpg"};
        objectArray[0] = TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object[])objectArray2));
        objectArray2 = new String[]{"siluet/r21.jpg", "siluet/r22.jpg", "siluet/r25.png"};
        objectArray[1] = TuplesKt.to((Object)"ancient", (Object)SetsKt.setOf((Object[])objectArray2));
        SILUET_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)2048L);
        objectArray = new Pair[7];
        objectArray[0] = TuplesKt.to((Object)"iris", (Object)SetsKt.setOf((Object)"tbe/red_end.jpg"));
        objectArray[1] = TuplesKt.to((Object)"mafia_circuit", (Object)SetsKt.setOf((Object)"tbe/static_end.jpg"));
        objectArray2 = new String[]{"tbe/stary_end.jpg", "tbe/slay_end.jpg"};
        objectArray[2] = TuplesKt.to((Object)"rabeon", (Object)SetsKt.setOf((Object[])objectArray2));
        objectArray2 = new String[]{"tbe/ambusher.jpg", "tbe/angy.jpg"};
        objectArray[3] = TuplesKt.to((Object)"rach", (Object)SetsKt.setOf((Object[])objectArray2));
        objectArray[4] = TuplesKt.to((Object)"skie", (Object)SetsKt.setOf((Object)"tbe/da_broken_end.jpg"));
        objectArray[5] = TuplesKt.to((Object)"err.type.guilherme", (Object)SetsKt.setOf((Object)"tbe/twinkling_end.jpg"));
        objectArray[6] = TuplesKt.to((Object)"jacko", (Object)SetsKt.setOf((Object)"tbe/tbread.jpg"));
        TBE_BACKGROUND_IMAGES = TuplesKt.to((Object)SetsKt.setOf((Object[])objectArray), (Object)4096L);
        objectArray = new String[]{"funny/catcuit.jpg", "funny/dawg.jpg", "funny/integrulus.jpg", "funny/pizzategrity.jpg", "funny/rocket2.jpg", "funny/perfecttegrity.png", "funny/jim.jpg"};
        FUNNY_BACKGROUND_IMAGES = SetsKt.setOf((Object[])objectArray);
        objectArray = new Pair[]{CIRCUIT_BACKGROUND_IMAGES, CHORD_BACKGROUND_IMAGES, CURVED_BACKGROUND_IMAGES, FARAWAY_BACKGROUND_IMAGES, FEVER_BACKGROUND_IMAGES, FRACTURED_BACKGROUND_IMAGES, INTEGRITY_BACKGROUND_IMAGES, MOON_BACKGROUND_IMAGES, NULL_BACKGROUND_IMAGES, OBLITERATION_BACKGROUND_IMAGES, REVUXOR_BACKGROUND_IMAGES, SILUET_BACKGROUND_IMAGES, TBE_BACKGROUND_IMAGES};
        BG_IMAGES_SET = SetsKt.setOf((Object[])objectArray);
        Iterable $this$map$iv = FUNNY_BACKGROUND_IMAGES;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(TBSConstants.id("textures/gui/menu/backgrounds/" + (String)it));
        }
        FUNNY_MENU_BACKGROUNDS = (List)var3_4;
    }
}


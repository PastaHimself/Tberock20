/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound.fx;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bq\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006v"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbPresets;", "", "<init>", "()V", "EFX_REVERB_PRESET_GENERIC", "Lnet/thebrokenscript/brokencore/api/sound/fx/ReverbPreset;", "EFX_REVERB_PRESET_PADDEDCELL", "EFX_REVERB_PRESET_ROOM", "EFX_REVERB_PRESET_BATHROOM", "EFX_REVERB_PRESET_LIVINGROOM", "EFX_REVERB_PRESET_STONEROOM", "EFX_REVERB_PRESET_AUDITORIUM", "EFX_REVERB_PRESET_CONCERTHALL", "EFX_REVERB_PRESET_CAVE", "EFX_REVERB_PRESET_ARENA", "EFX_REVERB_PRESET_HANGAR", "EFX_REVERB_PRESET_CARPETEDHALLWAY", "EFX_REVERB_PRESET_HALLWAY", "EFX_REVERB_PRESET_STONECORRIDOR", "EFX_REVERB_PRESET_ALLEY", "EFX_REVERB_PRESET_FOREST", "EFX_REVERB_PRESET_CITY", "EFX_REVERB_PRESET_MOUNTAINS", "EFX_REVERB_PRESET_QUARRY", "EFX_REVERB_PRESET_PLAIN", "EFX_REVERB_PRESET_PARKINGLOT", "EFX_REVERB_PRESET_SEWERPIPE", "EFX_REVERB_PRESET_UNDERWATER", "EFX_REVERB_PRESET_DRUGGED", "EFX_REVERB_PRESET_DIZZY", "EFX_REVERB_PRESET_PSYCHOTIC", "EFX_REVERB_PRESET_CASTLE_SMALLROOM", "EFX_REVERB_PRESET_CASTLE_SHORTPASSAGE", "EFX_REVERB_PRESET_CASTLE_MEDIUMROOM", "EFX_REVERB_PRESET_CASTLE_LARGEROOM", "EFX_REVERB_PRESET_CASTLE_LONGPASSAGE", "EFX_REVERB_PRESET_CASTLE_HALL", "EFX_REVERB_PRESET_CASTLE_CUPBOARD", "EFX_REVERB_PRESET_CASTLE_COURTYARD", "EFX_REVERB_PRESET_CASTLE_ALCOVE", "EFX_REVERB_PRESET_FACTORY_SMALLROOM", "EFX_REVERB_PRESET_FACTORY_SHORTPASSAGE", "EFX_REVERB_PRESET_FACTORY_MEDIUMROOM", "EFX_REVERB_PRESET_FACTORY_LARGEROOM", "EFX_REVERB_PRESET_FACTORY_LONGPASSAGE", "EFX_REVERB_PRESET_FACTORY_HALL", "EFX_REVERB_PRESET_FACTORY_CUPBOARD", "EFX_REVERB_PRESET_FACTORY_COURTYARD", "EFX_REVERB_PRESET_FACTORY_ALCOVE", "EFX_REVERB_PRESET_ICEPALACE_SMALLROOM", "EFX_REVERB_PRESET_ICEPALACE_SHORTPASSAGE", "EFX_REVERB_PRESET_ICEPALACE_MEDIUMROOM", "EFX_REVERB_PRESET_ICEPALACE_LARGEROOM", "EFX_REVERB_PRESET_ICEPALACE_LONGPASSAGE", "EFX_REVERB_PRESET_ICEPALACE_HALL", "EFX_REVERB_PRESET_ICEPALACE_CUPBOARD", "EFX_REVERB_PRESET_ICEPALACE_COURTYARD", "EFX_REVERB_PRESET_ICEPALACE_ALCOVE", "EFX_REVERB_PRESET_SPACESTATION_SMALLROOM", "EFX_REVERB_PRESET_SPACESTATION_SHORTPASSAGE", "EFX_REVERB_PRESET_SPACESTATION_MEDIUMROOM", "EFX_REVERB_PRESET_SPACESTATION_LARGEROOM", "EFX_REVERB_PRESET_SPACESTATION_LONGPASSAGE", "EFX_REVERB_PRESET_SPACESTATION_HALL", "EFX_REVERB_PRESET_SPACESTATION_CUPBOARD", "EFX_REVERB_PRESET_SPACESTATION_ALCOVE", "EFX_REVERB_PRESET_WOODEN_SMALLROOM", "EFX_REVERB_PRESET_WOODEN_SHORTPASSAGE", "EFX_REVERB_PRESET_WOODEN_MEDIUMROOM", "EFX_REVERB_PRESET_WOODEN_LARGEROOM", "EFX_REVERB_PRESET_WOODEN_LONGPASSAGE", "EFX_REVERB_PRESET_WOODEN_HALL", "EFX_REVERB_PRESET_WOODEN_CUPBOARD", "EFX_REVERB_PRESET_WOODEN_COURTYARD", "EFX_REVERB_PRESET_WOODEN_ALCOVE", "EFX_REVERB_PRESET_SPORT_EMPTYSTADIUM", "EFX_REVERB_PRESET_SPORT_SQUASHCOURT", "EFX_REVERB_PRESET_SPORT_SMALLSWIMMINGPOOL", "EFX_REVERB_PRESET_SPORT_LARGESWIMMINGPOOL", "EFX_REVERB_PRESET_SPORT_GYMNASIUM", "EFX_REVERB_PRESET_SPORT_FULLSTADIUM", "EFX_REVERB_PRESET_SPORT_STADIUMTANNOY", "EFX_REVERB_PRESET_PREFAB_WORKSHOP", "EFX_REVERB_PRESET_PREFAB_SCHOOLROOM", "EFX_REVERB_PRESET_PREFAB_PRACTISEROOM", "EFX_REVERB_PRESET_PREFAB_OUTHOUSE", "EFX_REVERB_PRESET_PREFAB_CARAVAN", "EFX_REVERB_PRESET_DOME_TOMB", "EFX_REVERB_PRESET_PIPE_SMALL", "EFX_REVERB_PRESET_DOME_SAINTPAULS", "EFX_REVERB_PRESET_PIPE_LONGTHIN", "EFX_REVERB_PRESET_PIPE_LARGE", "EFX_REVERB_PRESET_PIPE_RESONANT", "EFX_REVERB_PRESET_OUTDOORS_BACKYARD", "EFX_REVERB_PRESET_OUTDOORS_ROLLINGPLAINS", "EFX_REVERB_PRESET_OUTDOORS_DEEPCANYON", "EFX_REVERB_PRESET_OUTDOORS_CREEK", "EFX_REVERB_PRESET_OUTDOORS_VALLEY", "EFX_REVERB_PRESET_MOOD_HEAVEN", "EFX_REVERB_PRESET_MOOD_HELL", "EFX_REVERB_PRESET_MOOD_MEMORY", "EFX_REVERB_PRESET_DRIVING_COMMENTATOR", "EFX_REVERB_PRESET_DRIVING_PITGARAGE", "EFX_REVERB_PRESET_DRIVING_INCAR_RACER", "EFX_REVERB_PRESET_DRIVING_INCAR_SPORTS", "EFX_REVERB_PRESET_DRIVING_INCAR_LUXURY", "EFX_REVERB_PRESET_DRIVING_FULLGRANDSTAND", "EFX_REVERB_PRESET_DRIVING_EMPTYGRANDSTAND", "EFX_REVERB_PRESET_DRIVING_TUNNEL", "EFX_REVERB_PRESET_CITY_STREETS", "EFX_REVERB_PRESET_CITY_SUBWAY", "EFX_REVERB_PRESET_CITY_MUSEUM", "EFX_REVERB_PRESET_CITY_LIBRARY", "EFX_REVERB_PRESET_CITY_UNDERPASS", "EFX_REVERB_PRESET_CITY_ABANDONED", "EFX_REVERB_PRESET_DUSTYROOM", "EFX_REVERB_PRESET_CHAPEL", "EFX_REVERB_PRESET_SMALLWATERROOM", "brokencore-common"})
public final class ReverbPresets {
    @NotNull
    public static final ReverbPresets INSTANCE = new ReverbPresets();
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_GENERIC;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PADDEDCELL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_BATHROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_LIVINGROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_STONEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_AUDITORIUM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CONCERTHALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CAVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ARENA;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_HANGAR;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CARPETEDHALLWAY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_HALLWAY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_STONECORRIDOR;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ALLEY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FOREST;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_MOUNTAINS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_QUARRY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PLAIN;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PARKINGLOT;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SEWERPIPE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_UNDERWATER;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRUGGED;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DIZZY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PSYCHOTIC;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_SMALLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_SHORTPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_MEDIUMROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_LARGEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_LONGPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_HALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_CUPBOARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_COURTYARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CASTLE_ALCOVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_SMALLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_SHORTPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_MEDIUMROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_LARGEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_LONGPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_HALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_CUPBOARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_COURTYARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_FACTORY_ALCOVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_SMALLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_SHORTPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_MEDIUMROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_LARGEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_LONGPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_HALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_CUPBOARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_COURTYARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_ICEPALACE_ALCOVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_SMALLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_SHORTPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_MEDIUMROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_LARGEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_LONGPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_HALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_CUPBOARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPACESTATION_ALCOVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_SMALLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_SHORTPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_MEDIUMROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_LARGEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_LONGPASSAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_HALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_CUPBOARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_COURTYARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_WOODEN_ALCOVE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_EMPTYSTADIUM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_SQUASHCOURT;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_SMALLSWIMMINGPOOL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_LARGESWIMMINGPOOL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_GYMNASIUM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_FULLSTADIUM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SPORT_STADIUMTANNOY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PREFAB_WORKSHOP;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PREFAB_SCHOOLROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PREFAB_PRACTISEROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PREFAB_OUTHOUSE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PREFAB_CARAVAN;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DOME_TOMB;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PIPE_SMALL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DOME_SAINTPAULS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PIPE_LONGTHIN;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PIPE_LARGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_PIPE_RESONANT;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_OUTDOORS_BACKYARD;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_OUTDOORS_ROLLINGPLAINS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_OUTDOORS_DEEPCANYON;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_OUTDOORS_CREEK;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_OUTDOORS_VALLEY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_MOOD_HEAVEN;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_MOOD_HELL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_MOOD_MEMORY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_COMMENTATOR;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_PITGARAGE;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_INCAR_RACER;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_INCAR_SPORTS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_INCAR_LUXURY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_FULLGRANDSTAND;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_EMPTYGRANDSTAND;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DRIVING_TUNNEL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_STREETS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_SUBWAY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_MUSEUM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_LIBRARY;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_UNDERPASS;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CITY_ABANDONED;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_DUSTYROOM;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_CHAPEL;
    @JvmField
    @NotNull
    public static final ReverbPreset EFX_REVERB_PRESET_SMALLWATERROOM;

    private ReverbPresets() {
    }

    static {
        float[] fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray2 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_GENERIC = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.8913f, 1.0f, 1.49f, 0.83f, 1.0f, 0.05f, 0.007f, fArray2, 1.2589f, 0.011f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray3 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PADDEDCELL = new ReverbPreset(0.1715f, 1.0f, 0.3162f, 0.001f, 1.0f, 0.17f, 0.1f, 1.0f, 0.25f, 0.001f, fArray3, 1.2691f, 0.002f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray4 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ROOM = new ReverbPreset(0.4287f, 1.0f, 0.3162f, 0.5929f, 1.0f, 0.4f, 0.83f, 1.0f, 0.1503f, 0.002f, fArray4, 1.0629f, 0.003f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray5 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_BATHROOM = new ReverbPreset(0.1715f, 1.0f, 0.3162f, 0.2512f, 1.0f, 1.49f, 0.54f, 1.0f, 0.6531f, 0.007f, fArray5, 3.2734f, 0.011f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray6 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_LIVINGROOM = new ReverbPreset(0.9766f, 1.0f, 0.3162f, 0.001f, 1.0f, 0.5f, 0.1f, 1.0f, 0.2051f, 0.003f, fArray6, 0.2805f, 0.004f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray7 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_STONEROOM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.7079f, 1.0f, 2.31f, 0.64f, 1.0f, 0.4411f, 0.012f, fArray7, 1.1003f, 0.017f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray8 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_AUDITORIUM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.5781f, 1.0f, 4.32f, 0.59f, 1.0f, 0.4032f, 0.02f, fArray8, 0.717f, 0.03f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray9 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CONCERTHALL = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.5623f, 1.0f, 3.92f, 0.7f, 1.0f, 0.2427f, 0.02f, fArray9, 0.9977f, 0.029f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray10 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CAVE = new ReverbPreset(1.0f, 1.0f, 0.3162f, 1.0f, 1.0f, 2.91f, 1.3f, 1.0f, 0.5f, 0.015f, fArray10, 0.7063f, 0.022f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray11 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ARENA = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.4477f, 1.0f, 7.24f, 0.33f, 1.0f, 0.2612f, 0.02f, fArray11, 1.0186f, 0.03f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray12 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_HANGAR = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.3162f, 1.0f, 10.05f, 0.23f, 1.0f, 0.5f, 0.02f, fArray12, 1.256f, 0.03f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray13 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CARPETEDHALLWAY = new ReverbPreset(0.4287f, 1.0f, 0.3162f, 0.01f, 1.0f, 0.3f, 0.1f, 1.0f, 0.1215f, 0.002f, fArray13, 0.1531f, 0.03f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray14 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_HALLWAY = new ReverbPreset(0.3645f, 1.0f, 0.3162f, 0.7079f, 1.0f, 1.49f, 0.59f, 1.0f, 0.2458f, 0.007f, fArray14, 1.6615f, 0.011f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray15 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_STONECORRIDOR = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.7612f, 1.0f, 2.7f, 0.79f, 1.0f, 0.2472f, 0.013f, fArray15, 1.5758f, 0.02f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray16 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ALLEY = new ReverbPreset(1.0f, 0.3f, 0.3162f, 0.7328f, 1.0f, 1.49f, 0.86f, 1.0f, 0.25f, 0.007f, fArray16, 0.9954f, 0.011f, fArray, 0.125f, 0.95f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray17 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FOREST = new ReverbPreset(1.0f, 0.3f, 0.3162f, 0.0224f, 1.0f, 1.49f, 0.54f, 1.0f, 0.0525f, 0.162f, fArray17, 0.7682f, 0.088f, fArray, 0.125f, 1.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray18 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY = new ReverbPreset(1.0f, 0.5f, 0.3162f, 0.3981f, 1.0f, 1.49f, 0.67f, 1.0f, 0.073f, 0.007f, fArray18, 0.1427f, 0.011f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray19 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_MOUNTAINS = new ReverbPreset(1.0f, 0.27f, 0.3162f, 0.0562f, 1.0f, 1.49f, 0.21f, 1.0f, 0.0407f, 0.3f, fArray19, 0.1919f, 0.1f, fArray, 0.25f, 1.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray20 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_QUARRY = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.3162f, 1.0f, 1.49f, 0.83f, 1.0f, 0.0f, 0.061f, fArray20, 1.7783f, 0.025f, fArray, 0.125f, 0.7f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray21 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PLAIN = new ReverbPreset(1.0f, 0.21f, 0.3162f, 0.1f, 1.0f, 1.49f, 0.5f, 1.0f, 0.0585f, 0.179f, fArray21, 0.1089f, 0.1f, fArray, 0.25f, 1.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray22 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PARKINGLOT = new ReverbPreset(1.0f, 1.0f, 0.3162f, 1.0f, 1.0f, 1.65f, 1.5f, 1.0f, 0.2082f, 0.008f, fArray22, 0.2652f, 0.012f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray23 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SEWERPIPE = new ReverbPreset(0.3071f, 0.8f, 0.3162f, 0.3162f, 1.0f, 2.81f, 0.14f, 1.0f, 1.6387f, 0.014f, fArray23, 3.2471f, 0.021f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray24 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_UNDERWATER = new ReverbPreset(0.3645f, 1.0f, 0.3162f, 0.01f, 1.0f, 1.49f, 0.1f, 1.0f, 0.5963f, 0.007f, fArray24, 7.0795f, 0.011f, fArray, 0.25f, 0.0f, 1.18f, 0.348f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray25 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRUGGED = new ReverbPreset(0.4287f, 0.5f, 0.3162f, 1.0f, 1.0f, 8.39f, 1.39f, 1.0f, 0.876f, 0.002f, fArray25, 3.1081f, 0.03f, fArray, 0.25f, 0.0f, 0.25f, 1.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray26 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DIZZY = new ReverbPreset(0.3645f, 0.6f, 0.3162f, 0.631f, 1.0f, 17.23f, 0.56f, 1.0f, 0.1392f, 0.02f, fArray26, 0.4937f, 0.03f, fArray, 0.25f, 1.0f, 0.81f, 0.31f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray27 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PSYCHOTIC = new ReverbPreset(0.0625f, 0.5f, 0.3162f, 0.8404f, 1.0f, 7.56f, 0.91f, 1.0f, 0.4864f, 0.02f, fArray27, 2.4378f, 0.03f, fArray, 0.25f, 0.0f, 4.0f, 1.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray28 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_SMALLROOM = new ReverbPreset(1.0f, 0.89f, 0.3162f, 0.3981f, 0.1f, 1.22f, 0.83f, 0.31f, 0.8913f, 0.022f, fArray28, 1.9953f, 0.011f, fArray, 0.138f, 0.08f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray29 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_SHORTPASSAGE = new ReverbPreset(1.0f, 0.89f, 0.3162f, 0.3162f, 0.1f, 2.32f, 0.83f, 0.31f, 0.8913f, 0.007f, fArray29, 1.2589f, 0.023f, fArray, 0.138f, 0.08f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray30 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_MEDIUMROOM = new ReverbPreset(1.0f, 0.93f, 0.3162f, 0.2818f, 0.1f, 2.04f, 0.83f, 0.46f, 0.631f, 0.022f, fArray30, 1.5849f, 0.011f, fArray, 0.155f, 0.03f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray31 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_LARGEROOM = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.2818f, 0.1259f, 2.53f, 0.83f, 0.5f, 0.4467f, 0.034f, fArray31, 1.2589f, 0.016f, fArray, 0.185f, 0.07f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray32 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_LONGPASSAGE = new ReverbPreset(1.0f, 0.89f, 0.3162f, 0.3981f, 0.1f, 3.42f, 0.83f, 0.31f, 0.8913f, 0.007f, fArray32, 1.4125f, 0.023f, fArray, 0.138f, 0.08f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray33 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_HALL = new ReverbPreset(1.0f, 0.81f, 0.3162f, 0.2818f, 0.1778f, 3.14f, 0.79f, 0.62f, 0.1778f, 0.056f, fArray33, 1.122f, 0.024f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray34 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_CUPBOARD = new ReverbPreset(1.0f, 0.89f, 0.3162f, 0.2818f, 0.1f, 0.67f, 0.87f, 0.31f, 1.4125f, 0.01f, fArray34, 3.5481f, 0.007f, fArray, 0.138f, 0.08f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray35 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_COURTYARD = new ReverbPreset(1.0f, 0.42f, 0.3162f, 0.4467f, 0.1995f, 2.13f, 0.61f, 0.23f, 0.2239f, 0.16f, fArray35, 0.7079f, 0.036f, fArray, 0.25f, 0.37f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray36 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CASTLE_ALCOVE = new ReverbPreset(1.0f, 0.89f, 0.3162f, 0.5012f, 0.1f, 1.64f, 0.87f, 0.31f, 1.0f, 0.007f, fArray36, 1.4125f, 0.034f, fArray, 0.138f, 0.08f, 0.25f, 0.0f, 0.9943f, 5168.6f, 139.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray37 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_SMALLROOM = new ReverbPreset(0.3645f, 0.82f, 0.3162f, 0.7943f, 0.5012f, 1.72f, 0.65f, 1.31f, 0.7079f, 0.01f, fArray37, 1.7783f, 0.024f, fArray, 0.119f, 0.07f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray38 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_SHORTPASSAGE = new ReverbPreset(0.3645f, 0.64f, 0.2512f, 0.7943f, 0.5012f, 2.53f, 0.65f, 1.31f, 1.0f, 0.01f, fArray38, 1.2589f, 0.038f, fArray, 0.135f, 0.23f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray39 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_MEDIUMROOM = new ReverbPreset(0.4287f, 0.82f, 0.2512f, 0.7943f, 0.5012f, 2.76f, 0.65f, 1.31f, 0.2818f, 0.022f, fArray39, 1.4125f, 0.023f, fArray, 0.174f, 0.07f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray40 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_LARGEROOM = new ReverbPreset(0.4287f, 0.75f, 0.2512f, 0.7079f, 0.631f, 4.24f, 0.51f, 1.31f, 0.1778f, 0.039f, fArray40, 1.122f, 0.023f, fArray, 0.231f, 0.07f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray41 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_LONGPASSAGE = new ReverbPreset(0.3645f, 0.64f, 0.2512f, 0.7943f, 0.5012f, 4.06f, 0.65f, 1.31f, 1.0f, 0.02f, fArray41, 1.2589f, 0.037f, fArray, 0.135f, 0.23f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray42 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_HALL = new ReverbPreset(0.4287f, 0.75f, 0.3162f, 0.7079f, 0.631f, 7.43f, 0.51f, 1.31f, 0.0631f, 0.073f, fArray42, 0.8913f, 0.027f, fArray, 0.25f, 0.07f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray43 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_CUPBOARD = new ReverbPreset(0.3071f, 0.63f, 0.2512f, 0.7943f, 0.5012f, 0.49f, 0.65f, 1.31f, 1.2589f, 0.01f, fArray43, 1.9953f, 0.032f, fArray, 0.107f, 0.07f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray44 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_COURTYARD = new ReverbPreset(0.3071f, 0.57f, 0.3162f, 0.3162f, 0.631f, 2.32f, 0.29f, 0.56f, 0.2239f, 0.14f, fArray44, 0.3981f, 0.039f, fArray, 0.25f, 0.29f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray45 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_FACTORY_ALCOVE = new ReverbPreset(0.3645f, 0.59f, 0.2512f, 0.7943f, 0.5012f, 3.14f, 0.65f, 1.31f, 1.4125f, 0.01f, fArray45, 1.0f, 0.038f, fArray, 0.114f, 0.1f, 0.25f, 0.0f, 0.9943f, 3762.6f, 362.5f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray46 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_SMALLROOM = new ReverbPreset(1.0f, 0.84f, 0.3162f, 0.5623f, 0.2818f, 1.51f, 1.53f, 0.27f, 0.8913f, 0.01f, fArray46, 1.4125f, 0.011f, fArray, 0.164f, 0.14f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray47 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_SHORTPASSAGE = new ReverbPreset(1.0f, 0.75f, 0.3162f, 0.5623f, 0.2818f, 1.79f, 1.46f, 0.28f, 0.5012f, 0.01f, fArray47, 1.122f, 0.019f, fArray, 0.177f, 0.09f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray48 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_MEDIUMROOM = new ReverbPreset(1.0f, 0.87f, 0.3162f, 0.5623f, 0.4467f, 2.22f, 1.53f, 0.32f, 0.3981f, 0.039f, fArray48, 1.122f, 0.027f, fArray, 0.186f, 0.12f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray49 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_LARGEROOM = new ReverbPreset(1.0f, 0.81f, 0.3162f, 0.5623f, 0.4467f, 3.14f, 1.53f, 0.32f, 0.2512f, 0.039f, fArray49, 1.0f, 0.027f, fArray, 0.214f, 0.11f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray50 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_LONGPASSAGE = new ReverbPreset(1.0f, 0.77f, 0.3162f, 0.5623f, 0.3981f, 3.01f, 1.46f, 0.28f, 0.7943f, 0.012f, fArray50, 1.2589f, 0.025f, fArray, 0.186f, 0.04f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray51 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_HALL = new ReverbPreset(1.0f, 0.76f, 0.3162f, 0.4467f, 0.5623f, 5.49f, 1.53f, 0.38f, 0.1122f, 0.054f, fArray51, 0.631f, 0.052f, fArray, 0.226f, 0.11f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray52 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_CUPBOARD = new ReverbPreset(1.0f, 0.83f, 0.3162f, 0.5012f, 0.2239f, 0.76f, 1.53f, 0.26f, 1.122f, 0.012f, fArray52, 1.9953f, 0.016f, fArray, 0.143f, 0.08f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray53 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_COURTYARD = new ReverbPreset(1.0f, 0.59f, 0.3162f, 0.2818f, 0.3162f, 2.04f, 1.2f, 0.38f, 0.3162f, 0.173f, fArray53, 0.3162f, 0.043f, fArray, 0.235f, 0.48f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray54 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_ICEPALACE_ALCOVE = new ReverbPreset(1.0f, 0.84f, 0.3162f, 0.5623f, 0.2818f, 2.76f, 1.46f, 0.28f, 1.122f, 0.01f, fArray54, 0.8913f, 0.03f, fArray, 0.161f, 0.09f, 0.25f, 0.0f, 0.9943f, 12428.5f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray55 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_SMALLROOM = new ReverbPreset(0.2109f, 0.7f, 0.3162f, 0.7079f, 0.8913f, 1.72f, 0.82f, 0.55f, 0.7943f, 0.007f, fArray55, 1.4125f, 0.013f, fArray, 0.188f, 0.26f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray56 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_SHORTPASSAGE = new ReverbPreset(0.2109f, 0.87f, 0.3162f, 0.631f, 0.8913f, 3.57f, 0.5f, 0.55f, 1.0f, 0.012f, fArray56, 1.122f, 0.016f, fArray, 0.172f, 0.2f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray57 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_MEDIUMROOM = new ReverbPreset(0.2109f, 0.75f, 0.3162f, 0.631f, 0.8913f, 3.01f, 0.5f, 0.55f, 0.3981f, 0.034f, fArray57, 1.122f, 0.035f, fArray, 0.209f, 0.31f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray58 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_LARGEROOM = new ReverbPreset(0.3645f, 0.81f, 0.3162f, 0.631f, 0.8913f, 3.89f, 0.38f, 0.61f, 0.3162f, 0.056f, fArray58, 0.8913f, 0.035f, fArray, 0.233f, 0.28f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray59 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_LONGPASSAGE = new ReverbPreset(0.4287f, 0.82f, 0.3162f, 0.631f, 0.8913f, 4.62f, 0.62f, 0.55f, 1.0f, 0.012f, fArray59, 1.2589f, 0.031f, fArray, 0.25f, 0.23f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray60 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_HALL = new ReverbPreset(0.4287f, 0.87f, 0.3162f, 0.631f, 0.8913f, 7.11f, 0.38f, 0.61f, 0.1778f, 0.1f, fArray60, 0.631f, 0.047f, fArray, 0.25f, 0.25f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray61 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_CUPBOARD = new ReverbPreset(0.1715f, 0.56f, 0.3162f, 0.7079f, 0.8913f, 0.79f, 0.81f, 0.55f, 1.4125f, 0.007f, fArray61, 1.7783f, 0.018f, fArray, 0.181f, 0.31f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray62 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPACESTATION_ALCOVE = new ReverbPreset(0.2109f, 0.78f, 0.3162f, 0.7079f, 0.8913f, 1.16f, 0.81f, 0.55f, 1.4125f, 0.007f, fArray62, 1.0f, 0.018f, fArray, 0.192f, 0.21f, 0.25f, 0.0f, 0.9943f, 3316.1f, 458.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray63 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_SMALLROOM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1122f, 0.3162f, 0.79f, 0.32f, 0.87f, 1.0f, 0.032f, fArray63, 0.8913f, 0.029f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray64 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_SHORTPASSAGE = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1259f, 0.3162f, 1.75f, 0.5f, 0.87f, 0.8913f, 0.012f, fArray64, 0.631f, 0.024f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray65 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_MEDIUMROOM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1f, 0.2818f, 1.47f, 0.42f, 0.82f, 0.8913f, 0.049f, fArray65, 0.8913f, 0.029f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray66 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_LARGEROOM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.0891f, 0.2818f, 2.65f, 0.33f, 0.82f, 0.8913f, 0.066f, fArray66, 0.7943f, 0.049f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray67 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_LONGPASSAGE = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1f, 0.3162f, 1.99f, 0.4f, 0.79f, 1.0f, 0.02f, fArray67, 0.4467f, 0.036f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray68 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_HALL = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.0794f, 0.2818f, 3.45f, 0.3f, 0.82f, 0.8913f, 0.088f, fArray68, 0.7943f, 0.063f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray69 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_CUPBOARD = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1413f, 0.3162f, 0.56f, 0.46f, 0.91f, 1.122f, 0.012f, fArray69, 1.122f, 0.028f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray70 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_COURTYARD = new ReverbPreset(1.0f, 0.65f, 0.3162f, 0.0794f, 0.3162f, 1.79f, 0.35f, 0.79f, 0.5623f, 0.123f, fArray70, 0.1f, 0.032f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray71 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_WOODEN_ALCOVE = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.1259f, 0.3162f, 1.22f, 0.62f, 0.91f, 1.122f, 0.012f, fArray71, 0.7079f, 0.024f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 4705.0f, 99.6f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray72 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_EMPTYSTADIUM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.4467f, 0.7943f, 6.26f, 0.51f, 1.1f, 0.0631f, 0.183f, fArray72, 0.3981f, 0.038f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray73 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_SQUASHCOURT = new ReverbPreset(1.0f, 0.75f, 0.3162f, 0.3162f, 0.7943f, 2.22f, 0.91f, 1.16f, 0.4467f, 0.007f, fArray73, 0.7943f, 0.011f, fArray, 0.126f, 0.19f, 0.25f, 0.0f, 0.9943f, 7176.9f, 211.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray74 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_SMALLSWIMMINGPOOL = new ReverbPreset(1.0f, 0.7f, 0.3162f, 0.7943f, 0.8913f, 2.76f, 1.25f, 1.14f, 0.631f, 0.02f, fArray74, 0.7943f, 0.03f, fArray, 0.179f, 0.15f, 0.895f, 0.19f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray75 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_LARGESWIMMINGPOOL = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.7943f, 1.0f, 5.49f, 1.31f, 1.14f, 0.4467f, 0.039f, fArray75, 0.5012f, 0.049f, fArray, 0.222f, 0.55f, 1.159f, 0.21f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray76 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_GYMNASIUM = new ReverbPreset(1.0f, 0.81f, 0.3162f, 0.4467f, 0.8913f, 3.14f, 1.06f, 1.35f, 0.3981f, 0.029f, fArray76, 0.5623f, 0.045f, fArray, 0.146f, 0.14f, 0.25f, 0.0f, 0.9943f, 7176.9f, 211.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray77 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_FULLSTADIUM = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.0708f, 0.7943f, 5.25f, 0.17f, 0.8f, 0.1f, 0.188f, fArray77, 0.2818f, 0.038f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray78 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SPORT_STADIUMTANNOY = new ReverbPreset(1.0f, 0.78f, 0.3162f, 0.5623f, 0.5012f, 2.53f, 0.88f, 0.68f, 0.2818f, 0.23f, fArray78, 0.5012f, 0.063f, fArray, 0.25f, 0.2f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray79 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PREFAB_WORKSHOP = new ReverbPreset(0.4287f, 1.0f, 0.3162f, 0.1413f, 0.3981f, 0.76f, 1.0f, 1.0f, 1.0f, 0.012f, fArray79, 1.122f, 0.012f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray80 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PREFAB_SCHOOLROOM = new ReverbPreset(0.4022f, 0.69f, 0.3162f, 0.631f, 0.5012f, 0.98f, 0.45f, 0.18f, 1.4125f, 0.017f, fArray80, 1.4125f, 0.015f, fArray, 0.095f, 0.14f, 0.25f, 0.0f, 0.9943f, 7176.9f, 211.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray81 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PREFAB_PRACTISEROOM = new ReverbPreset(0.4022f, 0.87f, 0.3162f, 0.3981f, 0.5012f, 1.12f, 0.56f, 0.18f, 1.2589f, 0.01f, fArray81, 1.4125f, 0.011f, fArray, 0.095f, 0.14f, 0.25f, 0.0f, 0.9943f, 7176.9f, 211.2f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray82 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PREFAB_OUTHOUSE = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.1122f, 0.1585f, 1.38f, 0.38f, 0.35f, 0.8913f, 0.024f, fArray82, 0.631f, 0.044f, fArray, 0.121f, 0.17f, 0.25f, 0.0f, 0.9943f, 2854.4f, 107.5f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray83 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PREFAB_CARAVAN = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.0891f, 0.1259f, 0.43f, 1.5f, 1.0f, 1.0f, 0.012f, fArray83, 1.9953f, 0.012f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray84 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DOME_TOMB = new ReverbPreset(1.0f, 0.79f, 0.3162f, 0.3548f, 0.2239f, 4.18f, 0.21f, 0.1f, 0.3868f, 0.03f, fArray84, 1.6788f, 0.022f, fArray, 0.177f, 0.19f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray85 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PIPE_SMALL = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.3548f, 0.2239f, 5.04f, 0.1f, 0.1f, 0.5012f, 0.032f, fArray85, 2.5119f, 0.015f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray86 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DOME_SAINTPAULS = new ReverbPreset(1.0f, 0.87f, 0.3162f, 0.3548f, 0.2239f, 10.48f, 0.19f, 0.1f, 0.1778f, 0.09f, fArray86, 1.2589f, 0.042f, fArray, 0.25f, 0.12f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray87 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PIPE_LONGTHIN = new ReverbPreset(0.256f, 0.91f, 0.3162f, 0.4467f, 0.2818f, 9.21f, 0.18f, 0.1f, 0.7079f, 0.01f, fArray87, 0.7079f, 0.022f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray88 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PIPE_LARGE = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.3548f, 0.2239f, 8.45f, 0.1f, 0.1f, 0.3981f, 0.046f, fArray88, 1.5849f, 0.032f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray89 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_PIPE_RESONANT = new ReverbPreset(0.1373f, 0.91f, 0.3162f, 0.4467f, 0.2818f, 6.81f, 0.18f, 0.1f, 0.7079f, 0.01f, fArray89, 1.0f, 0.022f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 2854.4f, 20.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray90 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_OUTDOORS_BACKYARD = new ReverbPreset(1.0f, 0.45f, 0.3162f, 0.2512f, 0.5012f, 1.12f, 0.34f, 0.46f, 0.4467f, 0.069f, fArray90, 0.7079f, 0.023f, fArray, 0.218f, 0.34f, 0.25f, 0.0f, 0.9943f, 4399.1f, 242.9f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray91 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_OUTDOORS_ROLLINGPLAINS = new ReverbPreset(1.0f, 0.0f, 0.3162f, 0.0112f, 0.631f, 2.13f, 0.21f, 0.46f, 0.1778f, 0.3f, fArray91, 0.4467f, 0.019f, fArray, 0.25f, 1.0f, 0.25f, 0.0f, 0.9943f, 4399.1f, 242.9f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray92 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_OUTDOORS_DEEPCANYON = new ReverbPreset(1.0f, 0.74f, 0.3162f, 0.1778f, 0.631f, 3.89f, 0.21f, 0.46f, 0.3162f, 0.223f, fArray92, 0.3548f, 0.019f, fArray, 0.25f, 1.0f, 0.25f, 0.0f, 0.9943f, 4399.1f, 242.9f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray93 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_OUTDOORS_CREEK = new ReverbPreset(1.0f, 0.35f, 0.3162f, 0.1778f, 0.5012f, 2.13f, 0.21f, 0.46f, 0.3981f, 0.115f, fArray93, 0.1995f, 0.031f, fArray, 0.218f, 0.34f, 0.25f, 0.0f, 0.9943f, 4399.1f, 242.9f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray94 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_OUTDOORS_VALLEY = new ReverbPreset(1.0f, 0.28f, 0.3162f, 0.0282f, 0.1585f, 2.88f, 0.26f, 0.35f, 0.1413f, 0.263f, fArray94, 0.3981f, 0.1f, fArray, 0.25f, 0.34f, 0.25f, 0.0f, 0.9943f, 2854.4f, 107.5f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray95 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_MOOD_HEAVEN = new ReverbPreset(1.0f, 0.94f, 0.3162f, 0.7943f, 0.4467f, 5.04f, 1.12f, 0.56f, 0.2427f, 0.02f, fArray95, 1.2589f, 0.029f, fArray, 0.25f, 0.08f, 2.742f, 0.05f, 0.9977f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray96 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_MOOD_HELL = new ReverbPreset(1.0f, 0.57f, 0.3162f, 0.3548f, 0.4467f, 3.57f, 0.49f, 2.0f, 0.0f, 0.02f, fArray96, 1.4125f, 0.03f, fArray, 0.11f, 0.04f, 2.109f, 0.52f, 0.9943f, 5000.0f, 139.5f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray97 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_MOOD_MEMORY = new ReverbPreset(1.0f, 0.85f, 0.3162f, 0.631f, 0.3548f, 4.06f, 0.82f, 0.56f, 0.0398f, 0.0f, fArray97, 1.122f, 0.0f, fArray, 0.25f, 0.0f, 0.474f, 0.45f, 0.9886f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray98 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_COMMENTATOR = new ReverbPreset(1.0f, 0.0f, 0.3162f, 0.5623f, 0.5012f, 2.42f, 0.88f, 0.68f, 0.1995f, 0.093f, fArray98, 0.2512f, 0.017f, fArray, 0.25f, 1.0f, 0.25f, 0.0f, 0.9886f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray99 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_PITGARAGE = new ReverbPreset(0.4287f, 0.59f, 0.3162f, 0.7079f, 0.5623f, 1.72f, 0.93f, 0.87f, 0.5623f, 0.0f, fArray99, 1.2589f, 0.016f, fArray, 0.25f, 0.11f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray100 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_INCAR_RACER = new ReverbPreset(0.0832f, 0.8f, 0.3162f, 1.0f, 0.7943f, 0.17f, 2.0f, 0.41f, 1.7783f, 0.007f, fArray100, 0.7079f, 0.015f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 10268.2f, 251.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray101 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_INCAR_SPORTS = new ReverbPreset(0.0832f, 0.8f, 0.3162f, 0.631f, 1.0f, 0.17f, 0.75f, 0.41f, 1.0f, 0.01f, fArray101, 0.5623f, 0.0f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 10268.2f, 251.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray102 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_INCAR_LUXURY = new ReverbPreset(0.256f, 1.0f, 0.3162f, 0.1f, 0.5012f, 0.13f, 0.41f, 0.46f, 0.7943f, 0.01f, fArray102, 1.5849f, 0.01f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 10268.2f, 251.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray103 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_FULLGRANDSTAND = new ReverbPreset(1.0f, 1.0f, 0.3162f, 0.2818f, 0.631f, 3.01f, 1.37f, 1.28f, 0.3548f, 0.09f, fArray103, 0.1778f, 0.049f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 10420.2f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray104 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_EMPTYGRANDSTAND = new ReverbPreset(1.0f, 1.0f, 0.3162f, 1.0f, 0.7943f, 4.62f, 1.75f, 1.4f, 0.2082f, 0.09f, fArray104, 0.2512f, 0.049f, fArray, 0.25f, 0.0f, 0.25f, 0.0f, 0.9943f, 10420.2f, 250.0f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray105 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DRIVING_TUNNEL = new ReverbPreset(1.0f, 0.81f, 0.3162f, 0.3981f, 0.8913f, 3.42f, 0.94f, 1.31f, 0.7079f, 0.051f, fArray105, 0.7079f, 0.047f, fArray, 0.214f, 0.05f, 0.25f, 0.0f, 0.9943f, 5000.0f, 155.3f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray106 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_STREETS = new ReverbPreset(1.0f, 0.78f, 0.3162f, 0.7079f, 0.8913f, 1.79f, 1.12f, 0.91f, 0.2818f, 0.046f, fArray106, 0.1995f, 0.028f, fArray, 0.25f, 0.2f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray107 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_SUBWAY = new ReverbPreset(1.0f, 0.74f, 0.3162f, 0.7079f, 0.8913f, 3.01f, 1.23f, 0.91f, 0.7079f, 0.046f, fArray107, 1.2589f, 0.028f, fArray, 0.125f, 0.21f, 0.25f, 0.0f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray108 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_MUSEUM = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.1778f, 0.1778f, 3.28f, 1.4f, 0.57f, 0.2512f, 0.039f, fArray108, 0.8913f, 0.034f, fArray, 0.13f, 0.17f, 0.25f, 0.0f, 0.9943f, 2854.4f, 107.5f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, -0.0f};
        float[] fArray109 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_LIBRARY = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.2818f, 0.0891f, 2.76f, 0.89f, 0.41f, 0.3548f, 0.029f, fArray109, 0.8913f, 0.02f, fArray, 0.13f, 0.17f, 0.25f, 0.0f, 0.9943f, 2854.4f, 107.5f, 0.0f, 0);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray110 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_UNDERPASS = new ReverbPreset(1.0f, 0.82f, 0.3162f, 0.4467f, 0.8913f, 3.57f, 1.12f, 0.91f, 0.3981f, 0.059f, fArray110, 0.8913f, 0.037f, fArray, 0.25f, 0.14f, 0.25f, 0.0f, 0.992f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray111 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CITY_ABANDONED = new ReverbPreset(1.0f, 0.69f, 0.3162f, 0.7943f, 0.8913f, 3.28f, 1.17f, 0.91f, 0.4467f, 0.044f, fArray111, 0.2818f, 0.024f, fArray, 0.25f, 0.2f, 0.25f, 0.0f, 0.9966f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray112 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_DUSTYROOM = new ReverbPreset(0.3645f, 0.56f, 0.3162f, 0.7943f, 0.7079f, 1.79f, 0.38f, 0.21f, 0.5012f, 0.002f, fArray112, 1.2589f, 0.006f, fArray, 0.202f, 0.05f, 0.25f, 0.0f, 0.9886f, 13046.0f, 163.3f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray113 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_CHAPEL = new ReverbPreset(1.0f, 0.84f, 0.3162f, 0.5623f, 1.0f, 4.62f, 0.64f, 1.23f, 0.4467f, 0.032f, fArray113, 0.7943f, 0.049f, fArray, 0.25f, 0.0f, 0.25f, 0.11f, 0.9943f, 5000.0f, 250.0f, 0.0f, 1);
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArray114 = fArray;
        fArray = new float[]{0.0f, 0.0f, 0.0f};
        EFX_REVERB_PRESET_SMALLWATERROOM = new ReverbPreset(1.0f, 0.7f, 0.3162f, 0.4477f, 1.0f, 1.51f, 1.25f, 1.14f, 0.8913f, 0.02f, fArray114, 1.4125f, 0.03f, fArray, 0.179f, 0.15f, 0.895f, 0.19f, 0.992f, 5000.0f, 250.0f, 0.0f, 0);
    }
}


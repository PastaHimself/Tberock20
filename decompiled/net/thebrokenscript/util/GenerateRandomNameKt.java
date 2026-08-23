/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u00a8\u0006\u0002"}, d2={"generateRandomName", "", "thebrokenscript-common"})
public final class GenerateRandomNameKt {
    @NotNull
    public static final String generateRandomName() {
        Object[] objectArray = new String[]{"Super", "Ultra", "Dark", "Evil", "Shadow", "Crimson", "Frozen", "Ancient", "Cursed", "Blessed", "Mighty", "Chaos", "Storm", "Void", "Blazing", "Corrupt", "Divine", "Wicked", "Silent", "Nether", "Hollow", "Savage", "Mystic", "Eternal", "Armored", "BaneOf", "Sinister", "Scary", "Coal", "Emerald", "Diamond", "Copper", "Iron", "Gold", "Obsidian", "Netherite", "Lapis", "Doom", "Cool", "Lame", "Boring", "Fun"};
        List first = CollectionsKt.listOf((Object[])objectArray);
        Object[] objectArray2 = new String[]{"Unicorn", "Blade", "Crusher", "Walker", "Stalker", "Reaper", "Slayer", "Phantom", "Titan", "Wraith", "Seeker", "Bringer", "Warden", "Caller", "Breaker", "Strider", "Hunter", "Lord", "Rabbit", "Kitty", "Dawg", "Loser", "Winner", "Wizard", "Magician", "Muggle", "Zombie", "Skeleton", "Creeper", "Enderman", "Silverfish", "Endermite", "Witch", "Ravager", "Villager", "Pillager", "Ghost"};
        List second = CollectionsKt.listOf((Object[])objectArray2);
        String name = "" + CollectionsKt.random((Collection)first, (Random)((Random)Random.Default)) + CollectionsKt.random((Collection)second, (Random)((Random)Random.Default));
        int numbers = RangesKt.random((IntRange)new IntRange(0, 2100), (Random)((Random)Random.Default));
        return numbers == 0 ? name : name + numbers;
    }
}


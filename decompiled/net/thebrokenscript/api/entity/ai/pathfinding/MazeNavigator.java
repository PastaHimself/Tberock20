/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.PathFinder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.pathfinding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.thebrokenscript.api.entity.ai.pathfinding.MazeNodeEvaluator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/ai/pathfinding/MazeNavigator;", "Lnet/minecraft/world/entity/ai/navigation/GroundPathNavigation;", "mob", "Lnet/minecraft/world/entity/Mob;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/Mob;Lnet/minecraft/world/level/Level;)V", "createPathFinder", "Lnet/minecraft/world/level/pathfinder/PathFinder;", "maxVisitedNodes", "", "thebrokenscript-common"})
public final class MazeNavigator
extends GroundPathNavigation {
    public MazeNavigator(@NotNull Mob mob, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(mob, level);
        this.setCanOpenDoors(true);
        this.setCanPassDoors(true);
        this.setCanFloat(true);
        this.setCanWalkOverFences(true);
    }

    @NotNull
    protected PathFinder createPathFinder(int maxVisitedNodes) {
        this.nodeEvaluator = (NodeEvaluator)new MazeNodeEvaluator();
        return new PathFinder(this.nodeEvaluator, maxVisitedNodes);
    }
}


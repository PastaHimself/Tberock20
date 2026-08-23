/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.thebrokenscript.block.entity.AllDeadBlockEntity;
import net.thebrokenscript.block.entity.CommandBlockEntity;
import net.thebrokenscript.block.entity.ExitBlockEntity;
import net.thebrokenscript.block.entity.NullStructureBlockEntity;
import net.thebrokenscript.block.entity.ShadowBugBlockEntity;
import net.thebrokenscript.block.entity.TetherBloomBlockEntity;
import net.thebrokenscript.block.portal.PortalControllerBER;
import net.thebrokenscript.block.portal.PortalControllerBlockEntity;
import net.thebrokenscript.block.portal.PortalExtenderBER;
import net.thebrokenscript.block.portal.PortalExtenderBlockEntity;
import net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.client.renderer.block.AllDeadRenderer;
import net.thebrokenscript.client.renderer.block.ExitRenderer;
import net.thebrokenscript.client.renderer.block.TetherBloomRenderer;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/registry/TBSBlockEntities;", "", "<init>", "()V", "COMMAND_BLOCK", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lnet/thebrokenscript/block/entity/CommandBlockEntity;", "ALL_DEAD", "Lnet/thebrokenscript/block/entity/AllDeadBlockEntity;", "EXIT", "Lnet/thebrokenscript/block/entity/ExitBlockEntity;", "SHADOW_BUG", "Lnet/thebrokenscript/block/entity/ShadowBugBlockEntity;", "PORTAL_CONTROLLER", "Lnet/thebrokenscript/block/portal/PortalControllerBlockEntity;", "PORTAL_EXTENDER", "Lnet/thebrokenscript/block/portal/PortalExtenderBlockEntity;", "NULL_STRUCTURE", "Lnet/thebrokenscript/block/entity/NullStructureBlockEntity;", "A_FLOWER", "Lnet/thebrokenscript/block/entity/TetherBloomBlockEntity;", "thebrokenscript-common"})
public final class TBSBlockEntities {
    @NotNull
    public static final TBSBlockEntities INSTANCE = new TBSBlockEntities();
    @JvmField
    @NotNull
    public static final BlockEntityEntry<CommandBlockEntity> COMMAND_BLOCK = TBSReg.INSTANCE.blockEntity("command", COMMAND_BLOCK.1.INSTANCE, TBSBlockEntities::COMMAND_BLOCK$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<AllDeadBlockEntity> ALL_DEAD = TBSReg.INSTANCE.blockEntity("all", ALL_DEAD.1.INSTANCE, TBSBlockEntities::ALL_DEAD$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<ExitBlockEntity> EXIT = TBSReg.INSTANCE.blockEntity("exit", EXIT.1.INSTANCE, TBSBlockEntities::EXIT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<ShadowBugBlockEntity> SHADOW_BUG = TBSReg.INSTANCE.blockEntity("shadow_bug", SHADOW_BUG.1.INSTANCE, TBSBlockEntities::SHADOW_BUG$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<PortalControllerBlockEntity> PORTAL_CONTROLLER = TBSReg.INSTANCE.blockEntity("portal_controller", PORTAL_CONTROLLER.1.INSTANCE, TBSBlockEntities::PORTAL_CONTROLLER$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<PortalExtenderBlockEntity> PORTAL_EXTENDER = TBSReg.INSTANCE.blockEntity("portal_extender", PORTAL_EXTENDER.1.INSTANCE, TBSBlockEntities::PORTAL_EXTENDER$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<NullStructureBlockEntity> NULL_STRUCTURE = TBSReg.INSTANCE.blockEntity("null_structure", NULL_STRUCTURE.1.INSTANCE, TBSBlockEntities::NULL_STRUCTURE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntityEntry<TetherBloomBlockEntity> A_FLOWER = TBSReg.INSTANCE.blockEntity("a_flower", A_FLOWER.1.INSTANCE, TBSBlockEntities::A_FLOWER$lambda$0);

    private TBSBlockEntities() {
    }

    private static final void COMMAND_BLOCK$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.CORRUPTED_COMMAND_BLOCK);
    }

    private static final void ALL_DEAD$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.ALL_DEAD);
        $this$blockEntity.setRenderer(TBSBlockEntities::ALL_DEAD$lambda$0$0);
    }

    private static final Function1 ALL_DEAD$lambda$0$0() {
        return TBSBlockEntities::ALL_DEAD$lambda$0$0$0;
    }

    private static final AllDeadRenderer ALL_DEAD$lambda$0$0$0(BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return new AllDeadRenderer();
    }

    private static final void EXIT$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.EXIT);
        $this$blockEntity.setRenderer(TBSBlockEntities::EXIT$lambda$0$0);
    }

    private static final Function1 EXIT$lambda$0$0() {
        return TBSBlockEntities::EXIT$lambda$0$0$0;
    }

    private static final ExitRenderer EXIT$lambda$0$0$0(BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return new ExitRenderer();
    }

    private static final void SHADOW_BUG$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.SHADOW_BUG);
    }

    private static final void PORTAL_CONTROLLER$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.PORTAL_CONTROLLER);
        $this$blockEntity.setRenderer(TBSBlockEntities::PORTAL_CONTROLLER$lambda$0$0);
    }

    private static final Function1 PORTAL_CONTROLLER$lambda$0$0() {
        return TBSBlockEntities::PORTAL_CONTROLLER$lambda$0$0$0;
    }

    private static final PortalControllerBER PORTAL_CONTROLLER$lambda$0$0$0(BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return new PortalControllerBER();
    }

    private static final void PORTAL_EXTENDER$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.PORTAL_EXTENDER);
        $this$blockEntity.setRenderer(TBSBlockEntities::PORTAL_EXTENDER$lambda$0$0);
    }

    private static final Function1 PORTAL_EXTENDER$lambda$0$0() {
        return TBSBlockEntities::PORTAL_EXTENDER$lambda$0$0$0;
    }

    private static final PortalExtenderBER PORTAL_EXTENDER$lambda$0$0$0(BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return new PortalExtenderBER();
    }

    private static final void NULL_STRUCTURE$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.NULL_STRUCTURE);
    }

    private static final void A_FLOWER$lambda$0(BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add(TBSBlocks.A_FLOWER);
        $this$blockEntity.setRenderer(TBSBlockEntities::A_FLOWER$lambda$0$0);
    }

    private static final Function1 A_FLOWER$lambda$0$0() {
        return TBSBlockEntities::A_FLOWER$lambda$0$0$0;
    }

    private static final TetherBloomRenderer A_FLOWER$lambda$0$0$0(BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return new TetherBloomRenderer();
    }
}


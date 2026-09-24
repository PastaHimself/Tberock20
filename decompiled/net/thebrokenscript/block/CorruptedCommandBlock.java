/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block;

import com.mojang.serialization.MapCodec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.block.entity.CommandBlockEntity;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSBlockEntities;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0019H\u0014J\u001c\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0014J \u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J@\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0014J0\u0010/\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0014J\"\u00103\u001a\u0004\u0018\u0001042\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020(2\u0006\u0010#\u001a\u00020$H\u0014J\u0018\u00105\u001a\u0002062\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001eH\u0016J0\u00107\u001a\u0002022\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0014H\u0014J\u0010\u0010:\u001a\u00020;2\u0006\u0010 \u001a\u00020\u001eH\u0014J8\u0010<\u001a\n\u0012\u0004\u0012\u0002H>\u0018\u00010=\"\b\b\u0000\u0010>*\u00020?2\u0006\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001e2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H>0AH\u0016\u00a8\u0006C"}, d2={"Lnet/thebrokenscript/block/CorruptedCommandBlock;", "Lnet/minecraft/world/level/block/BaseEntityBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "appendHoverText", "", "stack", "Lnet/minecraft/world/item/ItemStack;", "context", "Lnet/minecraft/world/item/Item$TooltipContext;", "tooltipComponents", "", "Lnet/minecraft/network/chat/Component;", "tooltipFlag", "Lnet/minecraft/world/item/TooltipFlag;", "horizontalDistanceSqrd", "", "x", "", "z", "bossStructX", "bossStructZ", "codec", "Lcom/mojang/serialization/MapCodec;", "createBlockStateDefinition", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/state/BlockState;", "getLightBlock", "state", "worldIn", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "useItemOn", "Lnet/minecraft/world/ItemInteractionResult;", "level", "Lnet/minecraft/world/level/Level;", "player", "Lnet/minecraft/world/entity/player/Player;", "hand", "Lnet/minecraft/world/InteractionHand;", "hitResult", "Lnet/minecraft/world/phys/BlockHitResult;", "onPlace", "oldState", "movedByPiston", "", "getMenuProvider", "Lnet/minecraft/world/MenuProvider;", "newBlockEntity", "Lnet/thebrokenscript/block/entity/CommandBlockEntity;", "triggerEvent", "eventID", "eventParam", "getRenderShape", "Lnet/minecraft/world/level/block/RenderShape;", "getTicker", "Lnet/minecraft/world/level/block/entity/BlockEntityTicker;", "T", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "Companion", "thebrokenscript-common"})
public final class CorruptedCommandBlock
extends BaseEntityBlock {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static BooleanProperty CODE;
    @NotNull
    private static final MapCodec<CorruptedCommandBlock> CODEC;
    public static final long MIN_DIST_SQRD = 10000L;
    public static final long MAX_DIST_SQRD = 2250000L;

    public CorruptedCommandBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)CODE, (Comparable)Boolean.valueOf(false)));
    }

    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(tooltipComponents, (String)"tooltipComponents");
        Intrinsics.checkNotNullParameter((Object)tooltipFlag, (String)"tooltipFlag");
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) {
            return;
        }
        LocalPlayer player = localPlayer;
        int currentX = PlayerExt.INSTANCE.getVars((Player)player).getCurrentX();
        int currentZ = PlayerExt.INSTANCE.getVars((Player)player).getCurrentZ();
        int lastX = PlayerExt.INSTANCE.getVars((Player)player).getLastX();
        int lastZ = PlayerExt.INSTANCE.getVars((Player)player).getLastZ();
        int bossX = LevelExt.INSTANCE.getVars((LevelAccessor)level).getBossStructX();
        int bossZ = LevelExt.INSTANCE.getVars((LevelAccessor)level).getBossStructZ();
        long currentDist = this.horizontalDistanceSqrd(currentX, currentZ, bossX, bossZ);
        long lastDist = this.horizontalDistanceSqrd(lastX, lastZ, bossX, bossZ);
        boolean bl = !Intrinsics.areEqual((Object)player.level().dimension(), (Object)Level.OVERWORLD) && !Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.CORRUPTED_MOON) ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_WRONG_DIM()) : (!LevelExt.INSTANCE.getVars((LevelAccessor)level).getPlacedStructure() ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_FRESH()) : (currentDist > 2250000L ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_TOO_FAR()) : (currentDist < 10000L ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_FOUND()) : (currentDist > lastDist ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_COLDER()) : (currentDist < lastDist ? tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_WARMER()) : tooltipComponents.add((Component)TBSLang.INSTANCE.getCOMMAND_BLOCK_PLACED()))))));
    }

    private final long horizontalDistanceSqrd(int x, int z, int bossStructX, int bossStructZ) {
        long dx = x - bossStructX;
        long dz = z - bossStructZ;
        return dx * dx + dz * dz;
    }

    @NotNull
    protected MapCodec<? extends CorruptedCommandBlock> codec() {
        return CODEC;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        Property[] propertyArray = new Property[]{CODE};
        builder.add(propertyArray);
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 15;
    }

    @NotNull
    protected ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)hitResult, (String)"hitResult");
        ItemInteractionResult res = super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        if (player instanceof ServerPlayer && Arena.instance == null) {
            ((ServerPlayer)player).openMenu(state.getMenuProvider(level, pos));
        }
        Intrinsics.checkNotNull((Object)res);
        return res;
    }

    protected void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)oldState, (String)"oldState");
        super.onPlace(state, level, pos, oldState, movedByPiston);
        LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> CorruptedCommandBlock.onPlace$lambda$0(pos, arg_0)));
    }

    @Nullable
    protected MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)worldIn, (String)"worldIn");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (MenuProvider)blockEntity : null;
    }

    @NotNull
    public CommandBlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return (CommandBlockEntity)TBSBlockEntities.COMMAND_BLOCK.create(pos, state);
    }

    protected boolean triggerEvent(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, int eventID, int eventParam) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        super.triggerEvent(state, level, pos, eventID, eventParam);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity != null ? blockEntity.triggerEvent(eventID, eventParam) : false;
    }

    @NotNull
    protected RenderShape getRenderShape(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return RenderShape.MODEL;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        CommandBlockEntity.Companion companion = CommandBlockEntity.Companion;
        return BaseEntityBlock.createTickerHelper(type, (BlockEntityType)((BlockEntityType)TBSBlockEntities.COMMAND_BLOCK.get()), (BlockEntityTicker)new BlockEntityTicker(companion){
            final /* synthetic */ CommandBlockEntity.Companion $tmp0;
            {
                this.$tmp0 = $tmp0;
            }

            public final void tick(Level p0, BlockPos p1, BlockState p2, CommandBlockEntity p3) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                Intrinsics.checkNotNullParameter((Object)((Object)p3), (String)"p3");
                this.$tmp0.tick(p0, p1, p2, p3);
            }
        });
    }

    private static final Unit onPlace$lambda$0(BlockPos $pos, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCommandBlockLocation($pos);
        return Unit.INSTANCE;
    }

    static {
        BooleanProperty booleanProperty = BooleanProperty.create((String)"code");
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty, (String)"create(...)");
        CODE = booleanProperty;
        MapCodec mapCodec = BaseEntityBlock.simpleCodec(CorruptedCommandBlock::new);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/block/CorruptedCommandBlock$Companion;", "", "<init>", "()V", "CODE", "Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "getCODE", "()Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "setCODE", "(Lnet/minecraft/world/level/block/state/properties/BooleanProperty;)V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/block/CorruptedCommandBlock;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "MIN_DIST_SQRD", "", "MAX_DIST_SQRD", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BooleanProperty getCODE() {
            return CODE;
        }

        public final void setCODE(@NotNull BooleanProperty booleanProperty) {
            Intrinsics.checkNotNullParameter((Object)booleanProperty, (String)"<set-?>");
            CODE = booleanProperty;
        }

        @NotNull
        public final MapCodec<CorruptedCommandBlock> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


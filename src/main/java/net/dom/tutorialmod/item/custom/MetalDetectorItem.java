package net.dom.tutorialmod.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.dom.tutorialmod.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item{
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos PositionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean found_block = false;

            for(int i = 0; i <= PositionClicked.getY() + 64; ++i){
                BlockState state = pContext.getLevel().getBlockState(PositionClicked.below(i));
                if(isValuableBlock(state)){
                    outputValuableCordinates(PositionClicked.below(i), player, state.getBlock());
                    found_block = true;
                    break;
                }
            }

            if(!found_block){
                player.sendSystemMessage(Component.literal("No Valuables Found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), 
            player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
            "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}

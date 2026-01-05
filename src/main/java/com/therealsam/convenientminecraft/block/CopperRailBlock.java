package com.therealsam.convenientminecraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.RailBlock;
import net.minecraft.block.enums.RailShape;

import static net.minecraft.block.PoweredRailBlock.POWERED;

public class CopperRailBlock extends PoweredRailBlock {
    public CopperRailBlock(Settings settings) {

        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false).with(SHAPE, RailShape.NORTH_SOUTH));
    }


}

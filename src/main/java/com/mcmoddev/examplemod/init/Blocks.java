package com.mcmoddev.examplemod.init;

import com.mcmoddev.examplemod.block.ExampleBlock;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class Blocks {

    @GameRegistry.ObjectHolder("examplemod:example_block")
    public static ExampleBlock exampleBlock;
}

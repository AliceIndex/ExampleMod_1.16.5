package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TexturedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ExampleModBlockStateProvider extends BlockStateProvider {
    public ExampleModBlockStateProvider(DataGenerator gen, String modId, ExistingFileHelper exFileHelper) {
        super(gen, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ExampleMod.Blocks.TEST_BLOCK.get());
        slabBlockWithItem(ExampleMod.Blocks.TEST_TILE_BLOCK.get(), modLoc("block/test_tile_block"));
    }

    private void simpleBlockWithItem(Block block) {
        ModelFile model = cubeAll(block);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void slabBlockWithItem(SlabBlock block, ResourceLocation texture) {
        slabBlock(block, texture, texture);
        String baseName = Objects.requireNonNull(block.getRegistryName()).getPath();
        ModelFile bottomModel = new ModelFile.UncheckedModelFile(modLoc("block/" + baseName));
        simpleBlockItem(block, bottomModel);
    }
}

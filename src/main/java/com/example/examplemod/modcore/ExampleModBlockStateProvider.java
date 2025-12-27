package com.example.examplemod.modcore;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
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
        String baseName = Objects.requireNonNull(block.getRegistryName()).getPath();

        // 下付き (Bottom)
        ModelFile bottomModel = models().slab(baseName, texture, texture, texture);
        // 上付き (Top)
        ModelFile topModel = models().slabTop(baseName + "_top", texture, texture, texture);
        // 2段重ね (Double) - ここで cubeAll を使うので確実にフルブロックになります
        ModelFile doubleModel = models().cubeAll(baseName + "_double", texture);

        // 2. BlockStateの登録
        // さっき作った3つのモデルを、引数として「これを使え！」と渡します
        // 引数の順序: (block, bottom, top, double)
        slabBlock(block, bottomModel, topModel, doubleModel);
        simpleBlockItem(block, bottomModel);
    }
}

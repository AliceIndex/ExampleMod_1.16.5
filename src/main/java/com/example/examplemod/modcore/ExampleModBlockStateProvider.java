package com.example.examplemod.modcore;

import com.example.examplemod.modcore.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject; // 追加

import java.util.Objects;

public class ExampleModBlockStateProvider extends BlockStateProvider {
    public ExampleModBlockStateProvider(DataGenerator gen, String modId, ExistingFileHelper exFileHelper) {
        super(gen, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // ★ここが自動化ポイント！
        // BlockInitに登録されている全てのブロックをループ処理します
        for (RegistryObject<Block> blockReg : BlockInit.BLOCKS.getEntries()) {
            Block block = blockReg.get();
            generateBlockState(block);
        }
    }

    // ブロックの種類を判定して、適切なメソッドに振り分けるロジック
    private void generateBlockState(Block block) {
        // 基本的にテクスチャ名はブロックのIDと同じ場所にあると仮定
        // (例: assets/examplemod/textures/block/test_block.png)
        ResourceLocation texture = modLoc("block/" + Objects.requireNonNull(block.getRegistryName()).getPath());

        if (block instanceof SlabBlock) {
            // ハーフブロックなら、以前作った専用メソッドへ
            slabBlockWithItem((SlabBlock) block, texture);
        }
        // 将来的に階段(StairsBlock)などを追加したらここに else if を足すだけ！
        // else if (block instanceof StairsBlock) { ... }
        else {
            // それ以外は普通の四角いブロックとして処理
            simpleBlockWithItem(block, texture);
        }
    }

    // --- 以下、以前作ったメソッド群 ---

    // 少し改造: テクスチャを引数で受け取るように変更
    private void simpleBlockWithItem(Block block, ResourceLocation texture) {
        ModelFile model = models().cubeAll(Objects.requireNonNull(block.getRegistryName()).getPath(), texture);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void slabBlockWithItem(SlabBlock block, ResourceLocation texture) {
        String baseName = Objects.requireNonNull(block.getRegistryName()).getPath();

        ModelFile bottomModel = models().slab(baseName, texture, texture, texture);
        ModelFile topModel = models().slabTop(baseName + "_top", texture, texture, texture);
        ModelFile doubleModel = models().cubeAll(baseName + "_double", texture);

        slabBlock(block, bottomModel, topModel, doubleModel);
        simpleBlockItem(block, bottomModel);
    }
}
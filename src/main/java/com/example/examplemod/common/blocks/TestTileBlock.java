package com.example.examplemod.common.blocks;

import com.example.examplemod.modcore.init.TileEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

// 設定も挙動も全部このクラスの中に書く！
public class TestTileBlock extends SlabBlock {
    // コンストラクタで「設定(Properties)」を決めてしまう
    public TestTileBlock() {
        super(AbstractBlock.Properties
                .of(Material.METAL, MaterialColor.METAL) // 材質
                .noOcclusion()
                .strength(5.0f, 6.0f)     // 硬さ、爆破耐性
                .sound(SoundType.METAL)   // 音
                .harvestLevel(1)          // 採掘レベル
                .requiresCorrectToolForDrops()
        );
    }
    // --- ここから追加 ---

    // 1. TileEntityを持っていますか？ -> Yes
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    // 2. どのTileEntityを作りますか？
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        // Initクラスに登録したTypeから新しいインスタンスを作る
        return TileEntityInit.TEST_TILE_TYPE.get().create();
    }
}
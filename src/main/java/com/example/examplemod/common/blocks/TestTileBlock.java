package com.example.examplemod.common.blocks;

import com.example.examplemod.modcore.init.TileEntityInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapeArray;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

// 1. extends SlabBlock を extends Block に変更
public class TestTileBlock extends Block {

    public TestTileBlock() {
        super(AbstractBlock.Properties
                .of(Material.METAL, MaterialColor.METAL)
                .noOcclusion() // ← これがあると「透けるブロック」として扱われます（今回はそのままでOK）
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
        );
    }

    // 2. ★ここがポイント★
    // 「衝突判定（体がぶつかる判定）」を返すメソッドです。
    // ここで VoxelShapes.empty() を返すと、当たり判定がなくなって通り抜けられるようになります。
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        //return VoxelShapes.empty();
        return Block.box(0.0F,16.0F,0.0F,16.0F,32.0F,16.0F);
    }

    // ※補足：getShape（視線を合わせたときの黒い枠線）はデフォルト（フルブロック）のまま残ります。
    // これを消してしまうと、ブロックを壊したり右クリックしたりできなくなるので注意してください。

    // --- TileEntity関連（維持） ---
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityInit.TEST_TILE_TYPE.get().create();
    }
}
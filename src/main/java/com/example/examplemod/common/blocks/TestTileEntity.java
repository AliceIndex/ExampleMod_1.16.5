package com.example.examplemod.common.blocks;

import com.example.examplemod.modcore.init.TileEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TestTileEntity extends TileEntity implements ITickableTileEntity {
    private int counter = 0;

    // コンストラクタ：自分のタイプ（Initで作るやつ）をsuperに渡す
    public TestTileEntity() {
        super(TileEntityInit.TEST_TILE_TYPE.get());
    }

    public TestTileEntity(TileEntityType<?> type) {
        super(type);
    }

    // 毎tick実行される処理（例：1秒ごとにログを出す）
    @Override
    public void tick() {
        if (level != null && !level.isClientSide) {
            counter++;
            if (counter % 20 == 0) {
                // System.out.println("TileEntity is working! Count: " + counter);
            }
        }
    }

    // --- データの保存と読み込み (NBT) ---
    // これを書かないと、ゲームを再起動するとデータが消えます

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.counter = nbt.getInt("MyCounter");
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putInt("MyCounter", this.counter);
        return nbt;
    }
}

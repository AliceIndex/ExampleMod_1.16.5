package com.example.examplemod.modcore.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.common.blocks.TestBlock;
import com.example.examplemod.common.blocks.TestTileBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    // ブロックを登録するための「箱」を作る
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    // ★ここに新しいブロックを1行ずつ追加していくだけ！
    // "block_name", ブロックのクラス::new
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", TestBlock::new);
    public static final RegistryObject<SlabBlock> TEST_TILE_BLOCK = BLOCKS.register("test_tile_block", TestTileBlock::new);



    // --- ここから下は「自動化」のための魔法 ---

    // 登録処理をModのイベントバスに繋ぐためのメソッド
    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
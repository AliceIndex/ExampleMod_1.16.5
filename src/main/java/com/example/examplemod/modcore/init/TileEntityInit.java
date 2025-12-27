package com.example.examplemod.modcore.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.common.blocks.TestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ExampleMod.MOD_ID);

    // ★ ここで登録！
    // Builder.of(TileEntityのコンストラクタ, 紐付けるブロック).build(null)
    public static final RegistryObject<TileEntityType<TestTileEntity>> TEST_TILE_TYPE =
            TILE_ENTITIES.register("test_tile_entity", () ->
                    TileEntityType.Builder.of(TestTileEntity::new, BlockInit.TEST_TILE_BLOCK.get()).build(null)
            );

    public static void register() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
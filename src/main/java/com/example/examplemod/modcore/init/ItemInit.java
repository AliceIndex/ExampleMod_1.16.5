package com.example.examplemod.modcore.init;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    // ★ここが自動化の肝！
    // "Blockの登録が終わったタイミング" でこの処理が走り、
    // BlockInitに登録されている全てのブロックに対して、自動でItemBlockを生成して登録します。
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        // 登録されている全てのブロックをループ処理
        BlockInit.BLOCKS.getEntries().forEach(blockRegistryObject -> {

            // ブロック本体を取得
            Block block = blockRegistryObject.get();
            // ブロックのID名（例: examplemod:test_tile_block）を取得
            ResourceLocation registryName = block.getRegistryName();

            // アイテムの設定（タブなど）
            Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_MISC);

            // BlockItemを作成して登録！
            // 名前はブロックと同じものを自動で使うので被りなし
            event.getRegistry().register(
                    new BlockItem(block, properties).setRegistryName(Objects.requireNonNull(registryName))
            );
        });
    }
}
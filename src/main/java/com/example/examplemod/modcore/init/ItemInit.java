package com.example.examplemod.modcore.init;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    // ブロックを登録するための「箱」を作る
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,ExampleMod.MOD_ID);

    // 2. 普通のアイテム（ブロックじゃないやつ）はここで登録
    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties().tab(ExampleMod.TEST_TAB)));


    // 3. ★自動登録システム★
    // BlockInitに登録されたブロックをすべてチェックして、自動的にアイテム版(BlockItem)を登録します
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        // 登録されている全ブロックをループ
        BlockInit.BLOCKS.getEntries().forEach(blockRegistryObject -> {
            Block block = blockRegistryObject.get(); // ブロック本体
            ResourceLocation registryName = block.getRegistryName(); // ブロックの名前 (例: test_block)

            // アイテムの設定 (タブなどを指定)
            Item.Properties properties = new Item.Properties().tab(ExampleMod.TEST_TAB);

            // BlockItemを作成して、ブロックと同じ名前で登録！
            // setRegistryNameで名前をセットしないとエラーになるので注意
            BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(Objects.requireNonNull(registryName));

            event.getRegistry().register(blockItem);
        });
    }

    // 4. Mainクラスから呼び出すためのメソッド
    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
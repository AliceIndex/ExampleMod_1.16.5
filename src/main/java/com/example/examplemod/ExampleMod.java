package com.example.examplemod;

import com.example.examplemod.modcore.*;
import com.example.examplemod.modcore.init.BlockInit;
import com.example.examplemod.modcore.init.ItemInit;
import com.example.examplemod.modcore.init.TileEntityInit;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("examplemod")
public class ExampleMod
{
    public static final String MOD_ID="examplemod";
    public static final ItemGroup TEST_TAB = new ItemGroup("examplemod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.TEST_ITEM.get());
        }
    };



    public ExampleMod() {
        // メインのイベントバス取得
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ★ここで新しいクラスたちを呼び出す
        BlockInit.register();      // ブロック登録
        ItemInit.register();       // アイテム登録
        TileEntityInit.register(); // TileEntity登録

        // （DataGenなどのイベントリスナーはそのまま残してOK）
        modEventBus.addListener(this::registerProviders);
    }

    private void registerProviders(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            gen.addProvider(new ExampleModBlockStateProvider(gen, MOD_ID, event.getExistingFileHelper()));
            gen.addProvider(new ExampleModItemModelProvider(gen, MOD_ID, event.getExistingFileHelper()));
            gen.addProvider(new ExampleModEnUsLanguageProvider(gen, MOD_ID));
            gen.addProvider(new ExampleModJaJpLanguageProvider(gen, MOD_ID));
        }
        if (event.includeServer()) {
            gen.addProvider(new ExampleModRecipeProvider(gen));
            gen.addProvider(new ExampleModLootTableProvider(gen));
        }
    }
}

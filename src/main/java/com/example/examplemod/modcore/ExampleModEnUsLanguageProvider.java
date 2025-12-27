package com.example.examplemod.modcore;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.modcore.init.BlockInit;
import com.example.examplemod.modcore.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ExampleModEnUsLanguageProvider extends LanguageProvider {
    public ExampleModEnUsLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "en_us");
    }

    @Override
    protected void addTranslations() {// 参照先を変更
        add(BlockInit.TEST_BLOCK.get(), "test Block");
        add(BlockInit.TEST_TILE_BLOCK.get(), "Test Tile Block");
        add(ItemInit.TEST_ITEM.get(), "Test Item");

        add("itemGroup.examplemod", "Example Mod");
    }
}

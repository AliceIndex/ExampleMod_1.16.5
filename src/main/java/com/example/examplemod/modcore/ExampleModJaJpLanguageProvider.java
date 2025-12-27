package com.example.examplemod.modcore;

import com.example.examplemod.modcore.init.BlockInit;
import com.example.examplemod.modcore.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ExampleModJaJpLanguageProvider extends LanguageProvider {
    public ExampleModJaJpLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "ja_jp");
    }

    @Override
    protected void addTranslations() {// 参照先を変更
        add(BlockInit.TEST_BLOCK.get(), "テストブロック");
        add(BlockInit.TEST_TILE_BLOCK.get(), "テストタイルブロック");
        add(ItemInit.TEST_ITEM.get(), "テストアイテム");

        add("itemGroup.examplemod", "Example Mod");
    }
}

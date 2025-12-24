package com.example.examplemod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ExampleModJaJpLanguageProvider extends LanguageProvider {
    public ExampleModJaJpLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add(ExampleMod.Blocks.TEST_BLOCK.get(), "テストブロック");
        add(ExampleMod.Blocks.TEST_TILE_BLOCK.get(), "テストタイルブロック");
        add(ExampleMod.Items.TEST_ITEM.get(), "テストアイテム");
    }
}

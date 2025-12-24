package com.example.examplemod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ExampleModEnUsLanguageProvider extends LanguageProvider {
    public ExampleModEnUsLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.examplemod", "Example Mod");
        add(ExampleMod.Blocks.TEST_BLOCK.get(), "Test Block");
        add(ExampleMod.Items.TEST_TILE_BLOCK.get(), "Test Tile Block");
        add(ExampleMod.Items.TEST_ITEM.get(), "Test Item");
    }
}

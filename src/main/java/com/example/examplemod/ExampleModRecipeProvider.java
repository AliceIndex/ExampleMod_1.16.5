package com.example.examplemod;

import net.minecraft.data.*;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class ExampleModRecipeProvider extends RecipeProvider {
    public ExampleModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ExampleMod.Blocks.TEST_BLOCK.get())
                .define('#', ExampleMod.Items.TEST_ITEM.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_test_item", has(ExampleMod.Items.TEST_ITEM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ExampleMod.Items.TEST_ITEM.get(), 9)
                .requires(ExampleMod.Blocks.TEST_BLOCK.get())
                .group("test_item")
                .unlockedBy("has_test_block", has(ExampleMod.Blocks.TEST_BLOCK.get()))
                .save(consumer, "examplemod:test_item_from_test_block");
    }
}

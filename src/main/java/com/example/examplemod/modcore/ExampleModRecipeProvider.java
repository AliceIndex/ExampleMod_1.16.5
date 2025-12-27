package com.example.examplemod.modcore;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.modcore.init.BlockInit;
import com.example.examplemod.modcore.init.ItemInit;
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
        ShapedRecipeBuilder.shaped(BlockInit.TEST_BLOCK.get())
                .define('#', ItemInit.TEST_ITEM.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_test_item", has(ItemInit.TEST_ITEM.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ItemInit.TEST_ITEM.get(), 9)
                .requires(BlockInit.TEST_BLOCK.get())
                .group("test_item")
                .unlockedBy("has_test_block", has(BlockInit.TEST_BLOCK.get()))
                .save(consumer, "examplemod:test_item_from_test_block");
    }
}

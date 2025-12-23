package com.example.examplemod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collection;

@Mod("examplemod")
public class ExampleMod
{
    public static final String MOD_ID="examplemod";
    public static final ItemGroup TEST_TAB = new ItemGroup("examplemod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.TEST_ITEM.get());
        }
    };



    public ExampleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Blocks.register(modEventBus);
        Items.register(modEventBus);
        TileEntities.register(modEventBus);

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

    public static class Blocks {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
        public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new Block(AbstractBlock.Properties
                .of(Material.METAL, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
        ));

        public static final RegistryObject<Block> TEST_TILE_BLOCK = BLOCKS.register("test_tile_block", () -> new TestTileBlock(AbstractBlock.Properties
                .of(Material.METAL, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
        ));

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
        public static Collection<RegistryObject<Block>> getEntries() {
            return BLOCKS.getEntries();
        }
    }

    public static class Items {
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final RegistryObject<Item> TEST_BLOCK = ITEMS.register("test_block", () -> new BlockItem(Blocks.TEST_BLOCK.get(), new Item.Properties()
                .tab(TEST_TAB)));
        public static final RegistryObject<Item> TEST_TILE_BLOCK = ITEMS.register("test_tile_block", () -> new BlockItem(Blocks.TEST_TILE_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",() -> new Item(new Item.Properties()
                .tab(TEST_TAB)));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
    }

    public static class TileEntities {
        private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);

        public static final RegistryObject<TileEntityType<TestTileEntity>> TEST_TILE = TILE_ENTITIES.register("test_tile",
                () -> TileEntityType.Builder.of(TestTileEntity::new, Blocks.TEST_TILE_BLOCK.get()).build(null));

        public static void register(IEventBus eventBus) {
            TILE_ENTITIES.register(eventBus);
        }
    }

    public static class TestTileBlock extends Block {
        protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

        public TestTileBlock(Properties properties) {
            super(properties);
        }

        @Override
        public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return SHAPE;
        }

        // --- TileEntity紐付け部分（前回と同じ） ---
        @Override
        public boolean hasTileEntity(BlockState state) {
            return true;
        }

        @Nullable
        @Override
        public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            return TileEntities.TEST_TILE.get().create();
        }
    }

    public static class TestTileEntity extends TileEntity implements ITickableTileEntity {
        public TestTileEntity() {
            super(TileEntities.TEST_TILE.get());
        }

        @Override
        public void tick() {
            if (level != null && !level.isClientSide) {
                // サーバー側での毎ティック処理（例：周囲にパーティクルを出す、エネルギーを貯める等）
            }
        }
    }
}

package net.dom.tutorialmod.datagen;

import net.dom.tutorialmod.TutorialMod;
import net.dom.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.LOW_QUALITY_MINOR_VITALITY_PILL);
        simpleItem(ModItems.MID_QUALITY_MINOR_VITALITY_PILL);
        simpleItem(ModItems.HIGH_QUALITY_MINOR_VITALITY_PILL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    
}

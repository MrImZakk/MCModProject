package arcanemod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid="ArcaneMod", name="ArcaneMod", version="PreAlpha")       //Mod ID, Name, and Version
@NetworkMod(clientSideRequired=true, serverSideRequired=false)      // If the mod is compatible with Multiplayer or not
public class arcanemod 
{
  // Will provide screenshots

       
        @Instance("ArcaneMod")
        public static arcanemod instance;
        //IDs
        int RedArcaneOreID;          ////
        int RedArcaneFragmentsID;      //
        int RedArcaneBarID;            //
        int RedArcanePickaxeID;        //
        int RedArcaneSwordID;         // ----------- Item ID declarations
        int RedArcaneBlockID;         //
        int RedArcaneShovelID;        //
        int RedArcaneHoeID;          //
        int RedArcaneAxeID;      /////
        //Items/Blocks
        public static Block RedArcaneOre;     /////
        public static Item RedArcaneFragments;   //
        public static Item RedArcaneIngot;         //
        public static Item RedArcanePickaxe;      //
        public static Item RedArcaneSword;        // --------- Item and Block declarations
        public static Block RedArcaneBlock;       //
        public static Item RedArcaneShovel;       //
        public static Item RedArcaneHoe;        //
        public static Item RedArcaneAxe;    //////  
        //EnumMaterials
        public static EnumToolMaterial REDARCANE  = EnumHelper.addToolMaterial("REDARCANE", 2, 275, 7.0F, 2, 5);      ///////
        public static EnumToolMaterial REDARCANEWEAPON  = EnumHelper.addToolMaterial("REDARCANEWEAPON", 2, 145, 0, 3, 5);//// --- Creates a custom EnumMaterial with stats/attritbutes used by tools and weapons 
                                                                                                                      //////
       
        
        @SidedProxy(clientSide="arcanemod.client.ClientProxy", serverSide="arcanemod.common.CommonProxy") /// Unsure what this is for, but it has to be there
        public static CommonProxy proxy;
       
        @PreInit
        public void preInit(FMLPreInitializationEvent event)  /// PreInit is basically when the mod loads, it does all this code first
        {
          Configuration config = new Configuration(event.getSuggestedConfigurationFile());   /// Configuration file to change the Item/Block IDs or boolean statements by the user
          RedArcaneOreID = config.get("Block IDs", "Red Arcane Ore ID", 2500).getInt();
          RedArcaneFragmentsID = config.get("Item IDs", "Red Arcane Fragment ID", 2700).getInt();
          RedArcaneBarID = config.get("Item IDs", "Red Arcane Bar ID", 2511).getInt();
          RedArcanePickaxeID = config.get("Item IDs", "Red Arcane Pickaxe ID", 2600).getInt();
          RedArcaneSwordID = config.get("Item IDs", "Red Arcane Sword ID", 2601).getInt();
          RedArcaneBlockID = config.get("Block IDs", "Red Arcane Block ID", 2501).getInt();
          RedArcaneShovelID = config.get("Item IDs", "Red Arcane Shovel ID", 2602).getInt();
          RedArcaneHoeID = config.get("Item IDs", "Red Arcane Hoe ID", 2603).getInt();
          RedArcaneAxeID = config.get("Item IDs", "Red Arcane Axe ID", 2605).getInt();
          config.save();
        }
       
        @Init
        public void load(FMLInitializationEvent event)
        {
        	 //MinecraftForgeClient
        	 MinecraftForgeClient.preloadTexture("/arcanemodtextures/ArcaneMod_Blocks.png"); // Preloades a texture to be used later
             MinecraftForgeClient.preloadTexture("/arcanemodtextures/ArcaneMod_Items.png");
        	//ItemStacks
        	ItemStack stick = new ItemStack(Item.stick); //Creates a ItemStack used in crafting recipes when the object isn't in this class
        	//Items and Blocks
        	RedArcaneFragments = new Item_RedArcaneFragements(2502).setIconIndex(0);   // All the block/item declarations
        	RedArcaneIngot = new Item_RedArcaneBar(2501).setIconIndex(1);
        	RedArcanePickaxe = new Tool_RedArcanePickaxe(RedArcanePickaxeID, REDARCANE).setIconIndex(2);
        	RedArcaneOre = new Block_RedArcaneOre(RedArcaneOreID, 0, Material.iron);
        	RedArcaneSword = new Tool_RedArcaneSword(RedArcaneSwordID, REDARCANEWEAPON).setIconIndex(3);
        	RedArcaneBlock = new Block_RedArcaneBlock(RedArcaneBlockID, 1, Material.iron);
        	RedArcaneShovel = new Tool_RedArcaneShovel(RedArcaneShovelID, REDARCANE).setIconIndex(4);
        	RedArcaneHoe = new Tool_RedArcaneHoe(RedArcaneHoeID, REDARCANE).setIconIndex(5);
        	RedArcaneAxe = new Tool_RedArcaneAxe(RedArcaneAxeID, REDARCANE).setIconIndex(6);
        	//GameRegistry
        	GameRegistry.registerWorldGenerator(new WorldGeneratorMod()); // Everything under the GameRegistry comment basically registers block,item,recipe,world generation to minecraft
            GameRegistry.registerBlock(RedArcaneOre, "RedArcaneOre");
            GameRegistry.registerItem(RedArcaneFragments, "RedArcaneFragments");
            GameRegistry.registerItem(RedArcaneIngot, "RedArcaneBar");
            GameRegistry.addSmelting(arcanemod.RedArcaneFragments.itemID, new ItemStack(arcanemod.RedArcaneIngot), 0.1F);  
       	    GameRegistry.registerItem(RedArcanePickaxe, "RedArcanePickaxe");
       	    GameRegistry.registerItem(RedArcaneSword, "RedArcaneSword");
       	    GameRegistry.registerBlock(RedArcaneBlock, "RedArcaneBlock");
       	    GameRegistry.registerItem(RedArcaneShovel, "RedArcaneShovel");
       	    GameRegistry.registerItem(RedArcaneHoe, "RedArcaneHoe");
       	    GameRegistry.registerItem(RedArcaneAxe, "RedArcaneAxe");
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcanePickaxe), "MMM", " S ", " S ", 'S', stick, 'M', RedArcaneIngot);
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcaneSword), " A ", " A ", " S ", 'S', stick, 'A', RedArcaneIngot);
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcaneBlock), "RRR", "RRR", "RRR",'R', RedArcaneIngot);
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcaneShovel), " Y ", " S ", " S ", 'S', stick, 'Y', RedArcaneIngot);
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcaneHoe), "## ", " $ ", " $ ", '#', RedArcaneIngot, '$', stick);
       	    GameRegistry.addRecipe(new ItemStack(arcanemod.RedArcaneAxe), "AA ", "A% ", " % ", '%', stick, 'A', RedArcaneIngot);
       	    GameRegistry.addShapelessRecipe(new ItemStack(arcanemod.RedArcaneIngot, 9), new ItemStack (arcanemod.RedArcaneBlock));
       	    //LanguageRegistry
       	    LanguageRegistry.addName(RedArcaneOre, "Red Arcane Ore");     /// Everything under the LanguageRegistry comment, basically gives a block/item name in-game
            LanguageRegistry.addName(RedArcaneFragments, "Red Arcane Fragments");
            LanguageRegistry.addName(RedArcaneIngot, "Red Arcane Ingot");
   	        LanguageRegistry.addName(RedArcanePickaxe, "Red Arcane Pickaxe");
   	        LanguageRegistry.addName(RedArcaneSword, "Red Arcane Sword");
   	        LanguageRegistry.addName(RedArcaneBlock, "Red Arcane Block");
   	        LanguageRegistry.addName(RedArcaneShovel, "Red Arcane Shovel");
   	        LanguageRegistry.addName(RedArcaneHoe, "Red Arcane Hoe");
   	        LanguageRegistry.addName(RedArcaneAxe, "Red Arcane Axe");
   	        //MinecraftForge
   	        MinecraftForge.setBlockHarvestLevel(RedArcaneOre, "pickaxe", 2);  //Sets the harvest level for said blocks with a certain tool type
   	        MinecraftForge.setBlockHarvestLevel(RedArcaneBlock, "pickaxe", 2);
       	    
        }
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                
        }
}

package com.carystanley.camping.common;

import com.carystanley.camping.common.item.ItemMarshmallow;
import com.carystanley.camping.common.item.ItemMarshmallowStick;
import com.carystanley.camping.common.item.ItemChocolate;
import com.carystanley.camping.common.item.ItemGrahamcracker;
import com.carystanley.camping.common.item.ItemSleepingBag;
import com.carystanley.camping.common.item.ItemSmore;
import com.carystanley.camping.common.block.BlockSleepingBag;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "carystanley_camping", name = "Camping", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Camping {

	public static Item marshmallow = new ItemMarshmallow(5558).setUnlocalizedName("marshmallow");
	public static Item sleepingBagItem = new ItemSleepingBag(5559).setMaxStackSize(1).setUnlocalizedName("sleepingbagitem");
	public static Item chocolate = new ItemChocolate(5560, 3, 0.5f, false).setUnlocalizedName("chocolate");
	public static Item grahamcracker = new ItemGrahamcracker(5561, 3, 0.5f, false).setUnlocalizedName("grahamcracker");
	public static Item marshmallowStick = new ItemMarshmallow(5562).setUnlocalizedName("marshmallowstick");
	public static Item smore = new ItemSmore(5563, 8, 0.5f, false).setUnlocalizedName("smore");
	
	public static Block sleepingBagBlock = new BlockSleepingBag(4000).setHardness(0.2F).setUnlocalizedName("sleepingbagblock");
	
	@Init
	public void load(FMLInitializationEvent event) {
		loadRecipes();
		loadLang();
	}
	
	public void loadRecipes() {
		// Marshmallow Recipe
		GameRegistry.addRecipe(new ItemStack(Camping.marshmallow, 2), new Object[] {
			"XX",
			"XX",
			'X', Item.sugar
		});
		
		// Chocolate Recipe
		GameRegistry.addRecipe(new ItemStack(Camping.chocolate, 2), new Object[] {
			"SS",
			"CC",
			'S', Item.sugar,
			'C', new ItemStack(Item.dyePowder, 1, 3)
		});

		// Grahamcracker Recipe
		GameRegistry.addRecipe(new ItemStack(Camping.grahamcracker, 2), new Object[] {
			"SS",
			"WW",
			'S', Item.sugar,
			'W', Item.wheat
		});

	// Smore Recipe
	GameRegistry.addShapelessRecipe(new ItemStack(Camping.smore, 1), new Object[] {
		Camping.grahamcracker,
		Camping.grahamcracker,
		Camping.marshmallow,
		Camping.chocolate
	});

		// Sleeping Bag Recipe
		GameRegistry.addRecipe(new ItemStack(Camping.sleepingBagItem, 1), new Object[] {
			"XXX",
			'X', Block.cloth
		});

		// Marshmallow on a Stick Recipe
		GameRegistry.addRecipe(new ItemStack(Camping.marshmallowStick, 1), new Object[] {
			" M",
			"S ",
			'M', Camping.marshmallow,
			'S', Item.stick
		});
	}
	
	public void loadLang() {
		LanguageRegistry.addName(Camping.marshmallow, "Marshmallow");
		LanguageRegistry.addName(Camping.marshmallowStick, "Marshmallow on a Stick");
		LanguageRegistry.addName(Camping.chocolate, "Chocolate");
		LanguageRegistry.addName(Camping.grahamcracker, "Grahamcracker");
		LanguageRegistry.addName(Camping.sleepingBagItem, "Sleeping Bag");
		LanguageRegistry.addName(Camping.sleepingBagBlock, "Sleeping Bag");
	}

}

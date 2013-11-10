package com.carystanley.camping.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemGrahamcracker extends ItemFood {
    public ItemGrahamcracker(int id, int foodAmount, float sat, boolean isWolfMeat) {
    	super(id, foodAmount, sat, isWolfMeat);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("campout:grahamcracker");
    }
}

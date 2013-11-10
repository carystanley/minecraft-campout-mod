package com.carystanley.camping.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

import net.minecraft.potion.Potion;

public class ItemSmore extends ItemFood {
    public ItemSmore(int id, int foodAmount, float sat, boolean isWolfMeat) {
        super(id, foodAmount, sat, isWolfMeat);
        this.setPotionEffect(Potion.moveSpeed.getId(), 40, 4, 1.0f);
        this.setAlwaysEdible();
    }
        
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("campout:smore");
    }
}

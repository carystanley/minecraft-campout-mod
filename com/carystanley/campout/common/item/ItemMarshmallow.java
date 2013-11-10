package com.carystanley.camping.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemMarshmallow extends Item {
    public ItemMarshmallow(int id) {
    	super(id);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("campout:marshmallow");
    }
}

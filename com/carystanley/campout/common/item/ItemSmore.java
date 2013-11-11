package com.carystanley.camping.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;


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

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase)
    {
        par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 4000, 8));
        --par1ItemStack.stackSize;

        return true;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        this.itemInteractionForEntity(par1ItemStack, (EntityPlayer)null, par2EntityLivingBase);
        return true;
    }
}

package com.carystanley.camping.common.block;

import java.util.Random;

import com.carystanley.camping.common.Camping;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;

public class BlockSleepingBag extends BlockBed {

    @SideOnly(Side.CLIENT)
    private Icon[] sbagEndIcons;
    @SideOnly(Side.CLIENT)
    private Icon[] sbagSideIcons;
    @SideOnly(Side.CLIENT)
    private Icon[] sbagTopIcons;
   
	public BlockSleepingBag(int id) {
		super(id);
		disableStats();
	}
	
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return isBlockHeadOfBed(par1) ? 0 : Camping.sleepingBagItem.itemID;
    }
    
    @Override
    public boolean isBed(World world, int x, int y, int z, EntityLivingBase player)
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return Camping.sleepingBagItem.itemID;
    }
    
    
    
    @Override
    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }
    
    /**
     * Set the bounds of the bed block.
     */
    private void setBounds()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par1 == 0)
        {
            return Block.planks.getBlockTextureFromSide(par1);
        }
        else
        {
            int k = getDirection(par2);
            int l = Direction.bedDirection[k][par1];
            int i1 = isBlockHeadOfBed(par2) ? 1 : 0;
            return (i1 != 1 || l != 2) && (i1 != 0 || l != 3) ? (l != 5 && l != 4 ? this.sbagTopIcons[i1] : this.sbagSideIcons[i1]) : this.sbagEndIcons[i1];
        }
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.sbagTopIcons = new Icon[] {par1IconRegister.registerIcon("campout:sleepingbag_feet_top"), par1IconRegister.registerIcon("campout:sleepingbag_head_top")};
        this.sbagEndIcons = new Icon[] {par1IconRegister.registerIcon("campout:sleepingbag_feet_end"), par1IconRegister.registerIcon("campout:sleepingbag_head_end")};
        this.sbagSideIcons = new Icon[] {par1IconRegister.registerIcon("campout:sleepingbag_feet_side"), par1IconRegister.registerIcon("campout:sleepingbag_head_side")};
    }
}

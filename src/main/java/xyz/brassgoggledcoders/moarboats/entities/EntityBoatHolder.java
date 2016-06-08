package xyz.brassgoggledcoders.moarboats.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.moarlibs.api.IBlockContainer;
import xyz.brassgoggledcoders.moarlibs.api.IHolderEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityBoatHolder extends EntityBoatBase implements IHolderEntity<EntityBoatHolder>
{
	IBlockContainer blockContainer;

	public EntityBoatHolder(World world)
	{
		super(world);
	}

	@Override
	public EntityBoatHolder getEntity()
	{
		return this;
	}

	@Override
	public IBlockContainer getBlockContainer()
	{
		return this.blockContainer;
	}

	@Override
	public void setBlockContainer(IBlockContainer blockContainer)
	{
		this.blockContainer = blockContainer;
	}

	@Override
	public boolean processInitialInteract(@Nonnull EntityPlayer entityPlayer, @Nullable ItemStack stack, EnumHand hand)
	{
		if(this.getBlockContainer() != null)
		{
			//return this.getBlockContainer().onInteract(entityPlayer, this);
		}
		return false;
	}
}

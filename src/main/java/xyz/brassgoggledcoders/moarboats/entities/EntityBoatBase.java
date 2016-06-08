package xyz.brassgoggledcoders.moarboats.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityBoatBase extends EntityBoat
{
	public EntityBoatBase(World world)
	{
		super(world);
	}

	@Override
	@Nonnull
	public Item getItemBoat()
	{
		return new ItemBoat(Type.ACACIA);
	}

	@Override
	public boolean canPassengerSteer()
	{
		return false;
	}

	@Override
	public boolean isBeingRidden()
	{
		return false;
	}

	@Override
	public boolean processInitialInteract(@Nonnull EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
	{
		return true;
	}

	@Override
	protected boolean canFitPassenger(Entity passenger)
	{
		return false;
	}
}

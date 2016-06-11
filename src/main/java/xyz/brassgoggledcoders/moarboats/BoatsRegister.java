package xyz.brassgoggledcoders.moarboats;

import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarlibs.api.IBlockContainer;
import xyz.brassgoggledcoders.moarlibs.api.IMoarRegister;
import xyz.brassgoggledcoders.moarlibs.modules.VanillaModule;

import java.util.Iterator;
import java.util.Map;

public class BoatsRegister implements IMoarRegister
{
	@Override
	public void registerItems(Map<String, IBlockContainer> blockContainers)
	{
		blockContainers.put(VanillaModule.ENDER_CHEST.getUnlocalizedName(), VanillaModule.ENDER_CHEST);
		Iterator<Map.Entry<String, IBlockContainer>> containerIterable = blockContainers.entrySet().iterator();
		while(containerIterable.hasNext())
		{
			IBlockContainer firstContainer = containerIterable.next().getValue();
			IBlockContainer secondContainer = null;
			if(containerIterable.hasNext())
			{
				secondContainer = containerIterable.next().getValue();
			}
			ItemBoatHolder holder = new ItemBoatHolder(firstContainer, secondContainer);
			MoarBoats.INSTANCE.getRegistryHolder().getItemRegistry().registerItem(holder);
		}
	}

	@Override
	public void registerEntities()
	{
		MoarBoats.INSTANCE.getRegistryHolder().getEntityRegistry().registerEntity(EntityBoatHolder.class);
	}
}

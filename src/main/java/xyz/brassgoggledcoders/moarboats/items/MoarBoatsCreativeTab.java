package xyz.brassgoggledcoders.moarboats.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import xyz.brassgoggledcoders.boilerplate.BaseCreativeTab;

public class MoarBoatsCreativeTab extends BaseCreativeTab
{
	public MoarBoatsCreativeTab()
	{
		super("moarboats");
	}

	@Override
	public Item getTabIconItem()
	{
		return Items.BOAT;
	}
}

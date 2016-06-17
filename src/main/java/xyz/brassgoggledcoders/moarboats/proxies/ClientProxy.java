package xyz.brassgoggledcoders.moarboats.proxies;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xyz.brassgoggledcoders.moarboats.MoarBoats;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.renderers.RenderHolderBoat;
import xyz.brassgoggledcoders.moarboats.renderers.RenderRegistry;

public class ClientProxy extends CommonProxy
{
	RenderRegistry renderRegistry;

	@Override
	public void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBoatHolder.class, RenderHolderBoat.Factory.INSTANCE);
	}

	@Override
	public void registerItemRenders()
	{
		renderRegistry = new RenderRegistry();
		for(ItemBoatHolder itemBoatHolder: MoarBoats.ALL_BOATS) {
			renderRegistry.registerCustomItemRenderer(itemBoatHolder);
		}
	}
}

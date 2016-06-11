package xyz.brassgoggledcoders.moarboats.proxies;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.renderers.RenderHolderBoat;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBoatHolder.class, RenderHolderBoat.Factory.INSTANCE);
	}
}

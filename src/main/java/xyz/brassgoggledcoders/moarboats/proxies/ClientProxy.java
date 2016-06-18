package xyz.brassgoggledcoders.moarboats.proxies;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xyz.brassgoggledcoders.moarboats.MoarBoats;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.renderers.RenderHolderBoat;
import xyz.brassgoggledcoders.moarboats.renderers.RenderItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.renderers.RenderRegistry;

import java.util.ArrayList;
import java.util.List;

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
		for(ItemBoatHolder holder: MoarBoats.ALL_BOATS) {
			List<ItemStack> holderStacks = new ArrayList<>();
			holder.getSubItems(holder, holder.getCreativeTab(), holderStacks);
			for(ItemStack holderStack: holderStacks) {
				ClientRegistry.bindTileEntitySpecialRenderer(RenderItemBoatHolder.FakeTE.class, new RenderItemBoatHolder());
				ForgeHooksClient.registerTESRItemStack(holderStack.getItem(), holderStack.getMetadata(),
						RenderItemBoatHolder.FakeTE.class);
				ModelLoader.setCustomModelResourceLocation(holderStack.getItem(), holderStack.getMetadata(),
						new ModelResourceLocation("moarboats:boat_container", "inventory"));
			}
			renderRegistry.registerCustomItemRenderer(holder);
		}
	}
}

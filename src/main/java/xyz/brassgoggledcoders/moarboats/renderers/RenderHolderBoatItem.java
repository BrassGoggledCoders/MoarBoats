package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.model.ModelBoat;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;
import xyz.brassgoggledcoders.moarlibs.renderers.RenderBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RenderHolderBoatItem implements IItemRenderingHandler<ItemBoatHolder> {
	private ModelBoat modelBoat = new ModelBoatNoPaddles();
	private RenderBlock renderBlock = new RenderBlock();
	private static List<ResourceLocation> BOAT_TEXTURES;

	private ItemBoatHolder item;

	public RenderHolderBoatItem(ItemBoatHolder item) {
		this.item = item;
		if(BOAT_TEXTURES == null) {
			this.setBoatTextures();
		}
	}

	private void setBoatTextures() {
		BOAT_TEXTURES = new ArrayList<>();
	}

	public Class<FakeTE> getTileClass()
	{
		return FakeTE.class;
	}

	@Override
	public Collection<ResourceLocation> getAllTextures() {
		return BOAT_TEXTURES;
	}

	@Override
	public ItemBoatHolder getItem() {
		return this.item;
	}

	static class FakeTE extends TileEntity {

	}
}



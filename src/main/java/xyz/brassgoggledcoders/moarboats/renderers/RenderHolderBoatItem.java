package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import xyz.brassgoggledcoders.boilerplate.client.ClientHelper;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;
import xyz.brassgoggledcoders.moarboats.renderers.tesserellator.ITessellator;
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
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_oak"));
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_spruce"));
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_birch"));
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_jungle"));
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_acacia"));
		BOAT_TEXTURES.add(new ResourceLocation("entity/boat/boat_darkoak"));
	}

	@Override
	public void renderItem(ITessellator tessellator, World world, ItemBoatHolder item, ItemStack itemStack, EntityLivingBase entity,
			ItemCameraTransforms.TransformType transformType, VertexFormat format) {
		ItemBoatHolder boatHolder = (ItemBoatHolder) itemStack.getItem();

		GlStateManager.pushMatrix();
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		GlStateManager.pushMatrix();
		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(-0.5,-0.20, 0.5);
		this.renderBlock.renderEntity(ClientHelper.player(), boatHolder.getBlockContainer(itemStack), 0);
		GlStateManager.popMatrix();

		int itemDamage = itemStack.getItemDamage();
		int type = itemDamage > 7 ? itemDamage - 8 : itemDamage;
		Minecraft.getMinecraft().getTextureManager().bindTexture(BOAT_TEXTURES.get(type));
		format.clear();
		this.modelBoat.render(ClientHelper.player(), 0, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GlStateManager.popMatrix();
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



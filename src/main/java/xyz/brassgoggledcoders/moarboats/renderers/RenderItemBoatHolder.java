package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import xyz.brassgoggledcoders.boilerplate.client.ClientHelper;
import xyz.brassgoggledcoders.boilerplate.utils.ItemStackUtils;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;
import xyz.brassgoggledcoders.moarlibs.renderers.RenderBlock;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RenderItemBoatHolder extends TileEntitySpecialRenderer<RenderItemBoatHolder.FakeTE> {
	private RenderBlock renderBlock = new RenderBlock();
	private ModelBoat modelBoat = new ModelBoatNoPaddles();

	private static List<ResourceLocation> BOAT_TEXTURES;

	public RenderItemBoatHolder() {
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
	public void renderTileEntityAt(@Nonnull FakeTE te, double x, double y, double z, float partialTicks, int destroyStage) {
		ItemStack itemStack = RenderRegistry.currentlyRenderedStacks.get(Thread.currentThread().getId());
		if (ItemStackUtils.isItemInstanceOf(itemStack, ItemBoatHolder.class)) {
			RenderRegistry.currentlyRenderedStacks.remove(Thread.currentThread().getId());
			ItemBoatHolder boatHolder = (ItemBoatHolder) itemStack.getItem();

			GlStateManager.pushMatrix();
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

			GlStateManager.pushMatrix();
			GlStateManager.rotate(180, 1, 0, 0);
			GlStateManager.translate(-0.5, -0.20, 0.5);
			this.renderBlock.renderEntity(ClientHelper.player(), boatHolder.getBlockContainer(itemStack), 0);
			GlStateManager.popMatrix();

			int itemDamage = itemStack.getItemDamage();
			int type = itemDamage > 7 ? itemDamage - 8 : itemDamage;
			Minecraft.getMinecraft().getTextureManager().bindTexture(BOAT_TEXTURES.get(type));

			this.modelBoat.render(ClientHelper.player(), 0, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

			GlStateManager.popMatrix();
		}
	}

	public static class FakeTE extends TileEntity {

	}
}

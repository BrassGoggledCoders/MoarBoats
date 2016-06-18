package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import xyz.brassgoggledcoders.moarboats.MoarBoats;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;
import xyz.brassgoggledcoders.moarlibs.renderers.RenderBlock;

import javax.annotation.Nonnull;

public class RenderItemBoatHolder extends TileEntitySpecialRenderer<RenderItemBoatHolder.FakeTE> {
	private RenderBlock renderBlock = new RenderBlock();
	private ModelBoat modelBoat = new ModelBoatNoPaddles();

	@Override
	public void renderTileEntityAt(@Nonnull FakeTE te, double x, double y, double z, float partialTicks, int destroyStage) {
		MoarBoats.INSTANCE.getLogger().devInfo("SHIT");
		/*ItemBoatHolder boatHolder = (ItemBoatHolder) itemStack.getItem();

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

		this.modelBoat.render(ClientHelper.player(), 0, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GlStateManager.popMatrix();*/
	}

	public static class FakeTE extends TileEntity {

	}
}

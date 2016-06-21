package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.boilerplate.client.ClientHelper;
import xyz.brassgoggledcoders.boilerplate.utils.ItemStackUtils;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;
import xyz.brassgoggledcoders.moarlibs.api.IBlockContainer;
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
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_oak.png"));
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_spruce.png"));
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_birch.png"));
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_jungle.png"));
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_acacia.png"));
		BOAT_TEXTURES.add(new ResourceLocation("textures/entity/boat/boat_darkoak.png"));
	}

	@Override
	public void renderTileEntityAt(@Nonnull FakeTE te, double x, double y, double z, float partialTicks, int destroyStage) {
		ItemStack itemStack = RenderRegistry.currentlyRenderedStacks.get(Thread.currentThread().getId());
		if (ItemStackUtils.isItemInstanceOf(itemStack, ItemBoatHolder.class)) {
			RenderRegistry.currentlyRenderedStacks.remove(Thread.currentThread().getId());
			ItemBoatHolder boatHolder = (ItemBoatHolder) itemStack.getItem();

			GlStateManager.pushMatrix();

			GlStateManager.pushMatrix();

			GlStateManager.translate(-0.5, 0.20, 0.5);
			IBlockContainer blockContainer = boatHolder.getBlockContainer(itemStack);
			if(blockContainer.getTileEntity() == null) {
				EntityBoatHolder entityBoatHolder = new EntityBoatHolder(this.getWorld());
				entityBoatHolder.setBlockContainer(blockContainer);
				blockContainer.init(entityBoatHolder);
			}
			this.renderBlock.renderEntity(ClientHelper.player(), blockContainer, 0);
			GlStateManager.popMatrix();

			int itemDamage = itemStack.getItemDamage();
			int type = itemDamage > 7 ? itemDamage - 8 : itemDamage;
			this.bindTexture(BOAT_TEXTURES.get(type));

			this.modelBoat.render(ClientHelper.player(), 0, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

			GlStateManager.popMatrix();
		}
	}

	public static class FakeTE extends TileEntity {

	}
}

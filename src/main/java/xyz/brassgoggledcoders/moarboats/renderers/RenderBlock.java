package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import xyz.brassgoggledcoders.moarlibs.api.IBlockContainer;

public class RenderBlock
{
	public void render(Entity entity, IBlockContainer blockContainer, float partialTicks)
	{
		switch(blockContainer.getRenderType())
		{
			case VMC:
				this.renderVMC(entity, blockContainer, partialTicks);
				break;
			case TESR:
				break;
			case COMBO:
				break;
			case CUSTOM:
				break;
		}
	}

	public void renderVMC(Entity entity, IBlockContainer blockContainer, float partialTicks)
	{
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(blockContainer.getBlockState(),
				entity.getBrightness(partialTicks));
		GlStateManager.popMatrix();
	}
}

package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.models.ModelBoatNoPaddles;

public class RenderHolderBoat extends RenderBoat
{
	public enum Factory implements IRenderFactory<EntityBoatHolder>
	{
		INSTANCE;

		@Override
		public Render<? super EntityBoatHolder> createRenderFor(RenderManager manager) {
			return new RenderHolderBoat(manager);
		}
	}

	public RenderHolderBoat(RenderManager renderManager)
	{
		super(renderManager);
		modelBoat = new ModelBoatNoPaddles();
	}
}

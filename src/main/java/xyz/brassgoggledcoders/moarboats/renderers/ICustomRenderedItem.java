package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.brassgoggledcoders.boilerplate.client.models.IHasModel;

public interface ICustomRenderedItem<I extends Item> extends IHasModel {
	@SideOnly(Side.CLIENT)
	IItemRenderingHandler<I> getRenderer();
}

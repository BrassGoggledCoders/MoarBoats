package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;

@SideOnly(Side.CLIENT)
public interface IItemRenderingHandler<I extends Item> {
	Collection<ResourceLocation> getAllTextures();

	I getItem();
}

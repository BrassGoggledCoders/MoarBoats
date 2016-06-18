package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.brassgoggledcoders.moarboats.renderers.tesserellator.ITessellator;

import java.util.Collection;

@SideOnly(Side.CLIENT)
public interface IItemRenderingHandler<I extends Item> {
	Collection<ResourceLocation> getAllTextures();

	I getItem();

	void renderItem(ITessellator tessellator, World world, I item, ItemStack stack, EntityLivingBase entity,
			ItemCameraTransforms.TransformType transformType, VertexFormat format);
}

package xyz.brassgoggledcoders.moarboats.renderers;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenderRegistry implements ICustomModelLoader {
	private final Map<ResourceLocation, ItemRenderer<? extends Item>> renderers;
	private final List<ICustomRenderedItem<? extends Item>> items;

	public RenderRegistry() {
		this.renderers = new HashMap<>();
		this.items = new ArrayList<>();
		ModelLoaderRegistry.registerLoader(this);
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return renderers.containsKey(modelLocation);
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		return renderers.get(modelLocation);
	}

	@Override
	public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {

	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings("unchecked")
	public void registerCustomItemRenderer(ICustomRenderedItem<? extends Item> customRenderedItem) {
		if (customRenderedItem == null || !(customRenderedItem instanceof Item)) {
			return;
		}
		Item item = (Item) customRenderedItem;
		final ModelResourceLocation itemModel = new ModelResourceLocation(item.getRegistryName().toString());
		IItemRenderingHandler<? extends Item> renderer = customRenderedItem.getRenderer();
		if(item.getHasSubtypes()) {
			List<ItemStack> subItems = new ArrayList<>();
			item.getSubItems(item, item.getCreativeTab(), subItems);
			for(ItemStack stack : subItems) {
				ModelLoader.setCustomModelResourceLocation(item, stack.getItemDamage(), itemModel);
			}
		} else {
			ModelLoader.setCustomModelResourceLocation(item, 0, itemModel);
		}
		if (renderer != null) {
			ItemRenderer<? extends Item> instance = new ItemRenderer<>(renderer);
			ResourceLocation loc = new ResourceLocation(itemModel.getResourceDomain(), "models/item/" + itemModel.getResourcePath());
			renderers.put(loc, instance);
			ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
				@Override
				@Nonnull
				public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
					return itemModel;
				}
			});
		}
		items.add(customRenderedItem);
	}
}

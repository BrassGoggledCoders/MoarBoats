package xyz.brassgoggledcoders.moarboats.renderers;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModelCustomData;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemRenderer<I extends Item> implements IModelCustomData {
	private final IItemRenderingHandler<I> renderer;

	public ItemRenderer(IItemRenderingHandler<I> renderer) {
		this.renderer = renderer;
	}

	@Override
	public Collection<ResourceLocation> getDependencies() {
		return Collections.emptyList();
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return renderer.getAllTextures();
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		return new BakedSetItemStackModel();
	}

	@Override
	public IModelState getDefaultState() {
		return TRSRTransformation.identity();
	}

	@Override
	public ItemRenderer<I> process(ImmutableMap<String, String> customData) {
		return this;
	}

	public static class BakedSetItemStackModel implements IBakedModel {

		private BakedSetItemStackModel () {
		}


		@Override
		@Nonnull
		public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
			return ImmutableList.of();
		}

		@Override
		public boolean isAmbientOcclusion() {
			return false;
		}

		@Override
		public boolean isGui3d() {
			return true;
		}

		@Override
		public boolean isBuiltInRenderer() {
			return false;
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return null;
		}

		@Override
		@Nonnull
		public ItemCameraTransforms getItemCameraTransforms() {
			return ItemCameraTransforms.DEFAULT;
		}

		@Override
		@Nonnull
		public ItemOverrideList getOverrides() {
			return new SetItemStackOverride<>();
		}
	}

	public static class SetItemStackOverride<I extends Item> extends ItemOverrideList {
		private SetItemStackOverride() {
			super(new ArrayList<ItemOverride>());
		}

		@Override
		@Nonnull
		public IBakedModel handleItemState(@Nonnull IBakedModel originalModel, @Nonnull ItemStack stack,
				@Nonnull World world, @Nonnull EntityLivingBase entity) {
			RenderRegistry.currentlyRenderedStacks.put(Thread.currentThread().getId(), stack);
			return originalModel;
		}
	}
}

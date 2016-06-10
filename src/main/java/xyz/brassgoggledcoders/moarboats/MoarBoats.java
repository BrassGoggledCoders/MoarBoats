package xyz.brassgoggledcoders.moarboats;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.boilerplate.BoilerplateModBase;
import xyz.brassgoggledcoders.moarboats.entities.EntityBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.MoarBoatsCreativeTab;

@Mod(modid = MoarBoats.MODID, name = MoarBoats.MODNAME, version = MoarBoats.VERSION)
public class MoarBoats extends BoilerplateModBase
{
	public static final String MODID = "moarboats";
	public static final String MODNAME = "MoarBoats";
	public static final String VERSION = "@VERSION@";

	public static final CreativeTabs CREATIVE_TAB = new MoarBoatsCreativeTab();

	@Instance(MoarBoats.MODID)
	public static MoarBoats INSTANCE;

	public MoarBoats()
	{
		super(MODID, MODNAME, VERSION, CREATIVE_TAB);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}

	@Override
	public void modPreInit(FMLPreInitializationEvent event)
	{
		this.registryHolder.getItemRegistry().registerItem(new ItemBoatHolder());
		this.registryHolder.getEntityRegistry().registerEntity(EntityBoatHolder.class);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}

	@Override
	public Object getInstance()
	{
		return INSTANCE;
	}
}

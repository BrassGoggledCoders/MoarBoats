package xyz.brassgoggledcoders.moarboats;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.boilerplate.BoilerplateModBase;

@Mod(modid = MoarBoats.MODID, name = MoarBoats.MODNAME, version = MoarBoats.VERSION)
public class MoarBoats extends BoilerplateModBase
{
	public static final String MODID = "moarboats";
	public static final String MODNAME = "MoarBoats";
	public static final String VERSION = "@VERSION@";

	@Instance(MoarBoats.MODID)
	public static MoarBoats INSTANCE;

	public MoarBoats()
	{
		super(MODID, MODNAME, VERSION, CreativeTabs.MISC);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}

	@Mod.EventHandler
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

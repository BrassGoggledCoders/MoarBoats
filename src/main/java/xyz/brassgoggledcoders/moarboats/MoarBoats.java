package xyz.brassgoggledcoders.moarboats;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.moarboats.items.ItemBoatHolder;
import xyz.brassgoggledcoders.moarboats.items.MoarBoatsCreativeTab;
import xyz.brassgoggledcoders.moarboats.proxies.CommonProxy;
import xyz.brassgoggledcoders.moarlibs.MoarLibModBase;
import xyz.brassgoggledcoders.moarlibs.api.IMoarRegister;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = MoarBoats.MODID, name = MoarBoats.MODNAME, version = MoarBoats.VERSION, dependencies = MoarBoats.DEPENDENCIES)
public class MoarBoats extends MoarLibModBase
{
	public static final String MODID = "moarboats";
	public static final String MODNAME = "MoarBoats";
	public static final String VERSION = "@VERSION@";
	public static final String DEPENDENCIES = "required-after:moarlibs";

	public static final BoatsRegister BOATS_REGISTER = new BoatsRegister();
	public static final CreativeTabs CREATIVE_TAB = new MoarBoatsCreativeTab();
	public static final List<ItemBoatHolder> ALL_BOATS = new ArrayList<>();

	@Instance(MoarBoats.MODID)
	public static MoarBoats INSTANCE;

	@SidedProxy(clientSide = "xyz.brassgoggledcoders.moarboats.proxies.ClientProxy",
			serverSide = "xyz.brassgoggledcoders.moarboats.proxies.CommonProxy")
	public static CommonProxy PROXY;

	public MoarBoats()
	{
		super(MODID, MODNAME, VERSION, CREATIVE_TAB);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		PROXY.registerEntityRenders();
		PROXY.registerItemRenders();
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

	@Override
	public IMoarRegister getMoarRegister()
	{
		return BOATS_REGISTER;
	}
}

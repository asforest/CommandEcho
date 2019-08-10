package cn.innc11.commandecho;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.server.RemoteServerCommandEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class CommandEcho extends PluginBase implements Listener
{
	
	@Override
	public void onEnable() 
	{
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = false)
	public void onRemoteServerCommand(RemoteServerCommandEvent e)
	{
		getLogger().info("RCON Command: "+e.getCommand());
	}
	
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = false)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
	{
		getLogger().info(TextFormat.colorize((e.getPlayer().isOp() ? "&c" : "")+e.getPlayer().getName()+(e.getPlayer().isOp() ? "&r" : ""))+ ": "+e.getMessage());
	}
}

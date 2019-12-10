package cn.innc11.commandecho;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.RemoteConsoleCommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.server.RemoteServerCommandEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.LogLevel;
import cn.nukkit.utils.TextFormat;

public class CommandEcho extends PluginBase implements Listener
{
	@Override
	public void onEnable() 
	{
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRemoteServerCommand(RemoteServerCommandEvent e)
	{
		RemoteConsoleCommandSender sender = (RemoteConsoleCommandSender) e.getSender();
		rawLog("&3RCON Command: "+e.getCommand());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
	{
		Player player = e.getPlayer();
		String playName = player.getName();
		boolean isOp = player.isOp();

		rawLog( (isOp? "&c":"") + playName + (isOp? "&r: ":": ") + e.getMessage());
	}

	public void rawLog(String message)
	{
		Server.getInstance().getLogger().log(LogLevel.INFO, TextFormat.colorize(message));
	}
}

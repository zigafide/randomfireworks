package zigafide.simplefireworks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main_class extends JavaPlugin {
	 
    @Override
    public void onEnable() {
       
    }
   
    @Override
    public void onDisable() {
       
    }
    
    @Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {
        if (command.getName().equalsIgnoreCase("rfw")) {
        	Player p = (Player) sender;
        	Location loc = p.getLocation();
        	int size = args.length;
        	if (size==0) {
        		firework.random(loc);
        	}
        	else {
            	int amount = Integer.parseInt(args[0]);
            	int delay = Integer.parseInt(args[1]);
        	    	    	for(int x=0; x < amount; x++ ) 
        	    	    	{
        	        			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
        	        	    	public void run() {
        	    	    		firework.random(loc);
        	        			}
        	    	    	}, delay*x);
        	    	    }
        			}
            return true;
        }
        return false;
    }
   
}
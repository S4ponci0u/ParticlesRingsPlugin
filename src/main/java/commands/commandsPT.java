package commands;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandsPT implements CommandExecutor {
    private double angle = Math.PI;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§4§l[PT]: §6You must be a player for execute that!");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ring")){
            if (args.length >= 2) {
                try {
                    int radius = Integer.parseInt(args[0]);
                    int thickness = Integer.parseInt(args[1]);
                    player.sendMessage("Radius: " + radius);
                    player.sendMessage("Thickness: " + thickness);
                    if(angle < -Math.PI/8) angle = Math.PI;
                    double y = (radius * Math.sin(angle));
                    double z = (radius * Math.cos(angle));
                    angle -= 0.1;
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F);
                    Particle.DustTransition dustTransition = new Particle.DustTransition(Color.fromRGB(255, 0, 0), Color.fromRGB(255, 255, 255), 1.0F);
                    player.spawnParticle(Particle.DUST_COLOR_TRANSITION, player.getLocation(), 50, dustOptions);
                } catch (IllegalArgumentException e){
                    player.sendMessage("§4§l[PT]: §6Invalid arguments");
                }
            }else {
                player.sendMessage("§4§l[PT] Usage: §6/ring <radius> <thickness>");
            }
        }
        return true;


    }
}

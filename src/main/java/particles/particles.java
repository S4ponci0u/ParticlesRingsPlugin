package particles;
import commands.commandsPT;
import org.bukkit.plugin.java.JavaPlugin;

public final class particles extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        commandsPT commands = new commandsPT();
        getCommand("ring").setExecutor(commands);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

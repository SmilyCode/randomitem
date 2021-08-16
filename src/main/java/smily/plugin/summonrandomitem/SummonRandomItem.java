package smily.plugin.summonrandomitem;

import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.lang.NonNull;
import smily.plugin.summonrandomitem.command.SetPlayerCommand;

public final class SummonRandomItem extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting plugin");

        getCommand("randomitem").setExecutor(new SetPlayerCommand());
    }

}

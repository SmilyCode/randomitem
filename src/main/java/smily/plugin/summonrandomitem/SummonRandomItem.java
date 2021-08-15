package smily.plugin.summonrandomitem;

import org.bukkit.plugin.java.JavaPlugin;
import smily.plugin.summonrandomitem.command.SetPlayerCommand;

import java.util.Objects;

public final class SummonRandomItem extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting plugin");
        getCommand("randomitem").setExecutor(new SetPlayerCommand());
    }

}

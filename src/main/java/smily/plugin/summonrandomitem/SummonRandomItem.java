package smily.plugin.summonrandomitem;

import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smily.plugin.summonrandomitem.command.SetPlayerCommand;

import java.util.Objects;

public final class SummonRandomItem extends JavaPlugin {

    ApplicationContext context = new ClassPathXmlApplicationContext();


    @Override
    public void onEnable() {
        System.out.println("Starting plugin");
        getCommand("randomitem").setExecutor(new SetPlayerCommand());
    }

}

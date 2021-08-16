package smily.plugin.summonrandomitem.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.springframework.context.ApplicationContext;
import smily.plugin.summonrandomitem.data.RandomMaterial;
import smily.plugin.summonrandomitem.data.RandomizerData;

public class RandomItem extends ItemStack{

    private int cooldown;
    private final Plugin plugin = Bukkit.getPluginManager().getPlugin("SummonRandomItem");

    RandomizerData randomitem = new RandomMaterial();

    public void executeRandomize(Player player){
        assert (plugin != null);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> player.getWorld().dropItem(player.getLocation(), (ItemStack) randomitem.getData() )
        , 0, cooldown);
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}


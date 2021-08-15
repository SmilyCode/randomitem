package smily.plugin.summonrandomitem.summon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomItem {

    private final Plugin plugin = Bukkit.getPluginManager().getPlugin("SummonRandomItem");

    private final ItemStack bedrock;
    private final ItemStack dragonEgg;
    private final ItemStack lavaBucket;
    private final ItemStack endStone;
    private final ItemStack fish;
    private final ItemStack ironBlock;
    private final ItemStack poisonousPotato;
    private final ItemStack dirt;
    private final ItemStack diamond;
    private final ItemStack dark_oak;
    private final ItemStack endRod;

    private final RandomCollection<Object> randomMaterial = new RandomCollection<>()
            .add(50, bedrock = new ItemStack(Material.BEDROCK,1))
            .add(70, lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1))
            .add(10, dragonEgg = new ItemStack(Material.BEDROCK, 1))
            .add(90, endStone = new ItemStack(Material.END_STONE, setAmmountChance(64, 20)))
            .add(30, fish = new ItemStack(Material.TROPICAL_FISH_SPAWN_EGG, 1))
            .add(40, ironBlock = new ItemStack(Material.IRON_BLOCK, setAmmountChance(64, 1)))
            .add(70, endRod = new ItemStack(Material.END_ROD, 64))
            .add(70, dark_oak = new ItemStack(Material.DARK_OAK_LOG, setAmmountChance(6, 1)))
            .add(90, dirt = new ItemStack(Material.DIRT, setAmmountChance(64, 10)))
            .add(40, diamond = new ItemStack(Material.DIAMOND))
            .add(80, poisonousPotato = new ItemStack(Material.POISONOUS_POTATO ,64));

    public void spawnItem(Player player){
        assert (plugin != null);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> player.getWorld().dropItem(player.getLocation(), (ItemStack) randomMaterial.next())
        , 0, 600);
    }

    private int setAmmountChance(int max, int minimum){
        Random random = new Random();

        return random.nextInt(max + 1 - minimum) + minimum;
    }

}

class RandomCollection<E> {
    private final NavigableMap<Double, E> map = new TreeMap<>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}

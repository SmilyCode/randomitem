package smily.plugin.summonrandomitem.data;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomMaterial implements RandomizerData {

    private final List<Material> MAT = Collections.unmodifiableList(Arrays.asList(Material.values()));
    private final int SIZE = MAT.size();
    private final Random random = new Random();

    @Override
    public Object getData() {
        assert (getMaterial() != null);
        return new ItemStack(getMaterial(),getRandomAmount());
    }

    private Material getMaterial(){
        return MAT.get(random.nextInt(SIZE));
    }

    @Override
    public int getRandomAmount(){
        return random.nextInt(64);
    }

    @Override
    public int setAmount(int amount) {
        return amount;
    }
}

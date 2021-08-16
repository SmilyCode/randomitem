package smily.plugin.summonrandomitem.data;


import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomMaterial implements RandomizerData {

    private List<Material> MAT = Collections.unmodifiableList(Arrays.asList(Material.values()));
    private int SIZE = MAT.size();
    private Random random = new Random();

    Material mat;

    @Override
    public Object getData() {
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

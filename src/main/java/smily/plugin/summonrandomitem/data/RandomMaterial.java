package smily.plugin.summonrandomitem.data;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomMaterial implements RandomizerData {

    private final List<Material> MAT = Collections.unmodifiableList(Arrays.asList(Material.values()));
    private final int SIZE = MAT.size();
    private final Random random = new Random();
    private Material mat;

    @Override
    public Object getData() {
        return new ItemStack(mat,getRandomAmount());
    }

    private Material getMaterial(){
        mat = MAT.get(random.nextInt(SIZE));
        isMatAir(mat);
        return mat;
    }

    private void isMatAir(Material mat){
        if (mat.isAir()){
            getMaterial();
        }
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

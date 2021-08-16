package smily.plugin.summonrandomitem.event;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


class RandomItemTest {


    Plugin plugin;
    Player player;

    @BeforeEach
    void setUp(){
        player = mock(Player.class);
        plugin = mock(Plugin.class);
    }


    @Test
    public void isExecuting(){

    }


}


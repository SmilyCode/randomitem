package smily.plugin.summonrandomitem.time;

import org.springframework.beans.factory.annotation.Autowired;

public class Minute implements Time {

    @Autowired
    Second sec;

    @Override
    public int setTick(int time) {
        return sec.setTick(time)*60;
    }
}

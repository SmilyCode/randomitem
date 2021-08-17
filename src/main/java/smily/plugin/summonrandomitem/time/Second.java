package smily.plugin.summonrandomitem.time;

public class Second implements Time {
    @Override
    public int setTick(int time) {
        return time*20;
    }
}

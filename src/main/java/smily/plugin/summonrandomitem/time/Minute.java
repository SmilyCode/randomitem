package smily.plugin.summonrandomitem.time;

public class Minute extends TimeContext implements Time {

    Second sec = context.getBean(Second.class);

    @Override
    public int setTick(int time) {
        return sec.setTick(time)*60;
    };
}

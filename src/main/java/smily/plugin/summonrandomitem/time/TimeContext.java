package smily.plugin.summonrandomitem.time;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TimeContext {
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TimeConfig.class);
}

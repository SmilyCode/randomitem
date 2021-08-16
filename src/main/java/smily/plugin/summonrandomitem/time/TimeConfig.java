package smily.plugin.summonrandomitem.time;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeConfig {

    @Bean
    public Second getTime(){
        return new Second();
    }

    @Bean
    public Minute getMinute(){
        return new Minute();
    }
}

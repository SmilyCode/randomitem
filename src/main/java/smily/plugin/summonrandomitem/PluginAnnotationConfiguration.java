package smily.plugin.summonrandomitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smily.plugin.summonrandomitem.data.RandomMaterial;
import smily.plugin.summonrandomitem.data.RandomizerData;
import smily.plugin.summonrandomitem.event.RandomItem;
import smily.plugin.summonrandomitem.time.Minute;
import smily.plugin.summonrandomitem.time.Second;
import smily.plugin.summonrandomitem.time.Tick;

@Configuration
public class PluginAnnotationConfiguration {

    @Bean
    public RandomItem getRandomItemEvent(){
        return new RandomItem();
    }

    @Bean
    public RandomizerData getRandomMaterial(){
        return new RandomMaterial();
    }

    @Bean
    public Second getTime(){
        return new Second();
    }

    @Bean
    public Minute getMinute(){
        return new Minute();
    }

    @Bean
    public Tick getTick(){
        return new Tick();
    }
}

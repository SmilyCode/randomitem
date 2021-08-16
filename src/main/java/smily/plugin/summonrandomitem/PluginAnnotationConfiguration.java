package smily.plugin.summonrandomitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smily.plugin.summonrandomitem.data.RandomMaterial;
import smily.plugin.summonrandomitem.event.RandomItem;

@Configuration
public class PluginAnnotationConfiguration {

    @Bean
    public RandomItem getRandomItemEvent(){
        return new RandomItem();
    }

    @Bean
    public RandomMaterial getRandomMaterial(){
        return new RandomMaterial();
    }
}

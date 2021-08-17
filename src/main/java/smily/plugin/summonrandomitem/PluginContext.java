package smily.plugin.summonrandomitem;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginContext{
    public static ApplicationContext context = new AnnotationConfigApplicationContext(PluginAnnotationConfiguration.class);
}

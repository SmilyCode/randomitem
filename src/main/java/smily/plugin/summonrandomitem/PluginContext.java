package smily.plugin.summonrandomitem;


import jdk.tools.jlink.plugin.Plugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginContext{
    ApplicationContext context = new AnnotationConfigApplicationContext(PluginAnnotationConfiguration.class);
}

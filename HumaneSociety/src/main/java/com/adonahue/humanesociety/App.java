package com.adonahue.humanesociety;

import java.lang.ModuleLayer.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author allison
 */
public class App {
    
    public static void main(String[] args) {
        
         ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
         Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
}

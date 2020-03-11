package com.adonahue.humanesociety;

import com.adonahue.humanesociety.controller.HumaneSocietyController;
import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author allison
 */
public class App {

    public static void main(String[] args) throws HumaneSocietyDaoException{

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        HumaneSocietyController controller = ctx.getBean("controller", HumaneSocietyController.class);
        controller.run();
    }
}

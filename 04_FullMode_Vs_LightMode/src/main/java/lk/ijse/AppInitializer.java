package lk.ijse;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanTwo;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

      /*  SpringBeanOne beanOne = context.getBean(SpringBeanOne.class);
        System.out.println(beanOne);


        SpringBeanTwo beanTwo = context.getBean(SpringBeanTwo.class);
        System.out.println(beanTwo);


        SpringBeanOne bean3 = context.getBean(SpringBeanOne.class);
        System.out.println(bean3);

        SpringBeanTwo bean4 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean4);
*/

     /*   SpringBeanTwo bean1 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean1);
        SpringBeanTwo bean2 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean2);*/
        context.registerShutdownHook();

       /* SpringBeanOne bean1 = (SpringBeanOne) context.getBean("springBeanOne");
        System.out.println(bean1);*/
    }
}

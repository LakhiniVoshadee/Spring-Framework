package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitalizer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();



      /*  Object bean = context.getBean("springBean");
        SpringBean bean1 = (SpringBean) context.getBean("springBean");
        System.out.println(bean);
        System.out.println(bean1);


        MyConnection myConnection1= context.getBean(MyConnection.class);
        MyConnection myConnection2= context.getBean(MyConnection.class);
        System.out.println(myConnection1);
        System.out.println(myConnection2);*/
        MyConnection myConnection1 = context.getBean(MyConnection.class);
        System.out.println("--------------------------------------------");
        MyConnection myConnection2 = context.getBean(MyConnection.class);

        context.registerShutdownHook();


    }
}

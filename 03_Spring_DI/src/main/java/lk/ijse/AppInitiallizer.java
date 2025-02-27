package lk.ijse;

import lk.ijse.bean.Boy;
import lk.ijse.config.AppConfig;
import lk.ijse.di.Test1;
import lk.ijse.di.Test2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitiallizer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        /*Boy boy = context.getBean(Boy.class);
        System.out.println(boy);
        boy.chatWithGirl();*/

        Test2 test2 = context.getBean(Test2.class);
        test2.display();

        Test1 test1 = context.getBean(Test1.class);

        context.registerShutdownHook();
    }
}

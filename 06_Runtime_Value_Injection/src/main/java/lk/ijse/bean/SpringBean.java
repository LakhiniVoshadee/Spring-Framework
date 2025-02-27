package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

/* public SpringBean() {
    }*/


   /* @Autowired(required = false)
    public SpringBean(@Value("lakhini") String lakhini ,@Value("1") int id, @Value("true") boolean b) {

        System.out.println("Spring Bean Object Created");
        System.out.println(lakhini);
        System.out.println(id);
        System.out.println(b);
    }

    @Autowired(required = false)
    public SpringBean(@Value("lakhini") String lakhini ,@Value("1") int id,@Value("lakhini") String names,@Value("2") int id2) {

        System.out.println("Spring Bean Object Created");
        System.out.println(lakhini);
        System.out.println(id);
        System.out.println(names);
        System.out.println(id2);
    }*/

    @Value("lakhini")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }

}

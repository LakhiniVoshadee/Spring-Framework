package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.*;
/*
@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")*/


@Configuration
@Import({AppConfig1.class, AppConfig2.class})
//root
//@ImportResource("classpath:hibernate.xml")
//if not
//@ImportResource("file:absolute-path-of-hibernate.xml")
public class AppConfig {
    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }

}

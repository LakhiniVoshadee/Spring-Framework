package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {

    @Bean
  //  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MyConnection myConnection(){
        return new MyConnection();
    }
}

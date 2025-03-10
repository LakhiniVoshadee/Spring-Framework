package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    public SpringBean() {
        System.out.println("Spring Bean");
    }

    @Value("${USERDOMAIN}")
    private String logName;
    @Value("${os.name}")
    private String osName;
    @Value("${database.user}")
    private String user;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
        System.out.println(logName);
        System.out.println(user);
    }
}

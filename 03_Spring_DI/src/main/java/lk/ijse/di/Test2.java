package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DIInterface {
    // @Autowired
    DI test1;

    //=====================Constructor Through====================
   /* @Autowired
    public Test2(DI test1) {
        this.test1 = test1;
      //  System.out.println("Test2 constructor");
    }*/
//=======================Setter Method Through===============
   /* @Autowired
    public void setter(DI test1) {
        this.test1 = test1;
    }*/
    public void display() {
        test1.sayHello();
    }
//=======================Interface Through============================

    @Autowired
    @Override
    public void inject(DI test1) {
        this.test1 = test1;

    }
}


package lk.ijse.spring_boot_loggins_17.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    //Trace,Debug,info,warn,error
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @GetMapping("/log-demo")
    public String logdemo() {
        log.trace("This is a trace message");
        log.info("This is an info message");
        log.debug("This is a debug message");
        log.warn("This is a warn message");
        log.error("This is a error message");
        return "Hello World";
    }
}

package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("variable")
public class PathVariableController {
    @GetMapping(path = "{id:[I][0-9]{3}}")
    public String variable1(@PathVariable ("id")String id) {
        return id;
    }

    // --------> /variable/45
    @GetMapping(path = "{customerID}")
    public String variable2(@PathVariable("customerID") String id) {
        return id;
    }

    //--------> /variable/Lakhini/99
    @GetMapping(path = "{customerName}/{customerID}")
    public String variable3(@PathVariable("customerName") String id,@PathVariable("customerID") String name) {
        return id + " " + name;
    }
}

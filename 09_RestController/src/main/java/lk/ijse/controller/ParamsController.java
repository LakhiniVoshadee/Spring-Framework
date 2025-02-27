package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("params")
public class ParamsController {
    @GetMapping(params = {"id","name"})
    public String test1(@RequestParam (value = "id") String id,@RequestParam(value = "name") String name) {
        return id + "  " + name;

    }

}

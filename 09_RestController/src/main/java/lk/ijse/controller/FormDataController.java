package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {
    /*@PostMapping
    public String test1(@RequestParam("id") String id, @RequestParam("name") String name) {
        return " ID: " + id + " Name: " + name;
    }*/

    @PostMapping
    public String test1(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.getFirstName());
        return customerDTO.toString();
    }
}

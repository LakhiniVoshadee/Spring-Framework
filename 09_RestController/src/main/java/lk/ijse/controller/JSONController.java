package lk.ijse.controller;

import jdk.jfr.ContentType;
import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JSONController {
    @PostMapping
    public String test1(@RequestBody  CustomerDTO customerDTO) {
        return customerDTO.getFirstName();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO test2(){
      return new CustomerDTO("Lakhini","Voshadee",24);
    }

    @GetMapping (path = "data", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<CustomerDTO> test3(){
        ArrayList<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO("Lakhini","Voshadee",24));
        list.add(new CustomerDTO("Lakhini","Voshadee",24));
        list.add(new CustomerDTO("Lakhini","Voshadee",24));
        list.add(new CustomerDTO("Lakhini","Voshadee",24));
        return list;
    }

}

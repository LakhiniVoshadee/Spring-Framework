package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private List<CustomerDTO> customers = new ArrayList<>();

    @PostMapping(value = "save")
    public CustomerDTO savecustomer(@RequestBody CustomerDTO customerDTO) {
        customers.add(customerDTO);
        return customerDTO;

    }

    @PutMapping("update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO excitingCustomer = customers.get(i);
            if (excitingCustomer.getId().equals(customerDTO.getId())) {
                excitingCustomer.setName(customerDTO.getName());
                excitingCustomer.setAddress(customerDTO.getAddress());
                excitingCustomer.setAge(customerDTO.getAge());
                return excitingCustomer;
            }
        }
        return customerDTO;
    }

    @GetMapping("getAll")
    public List<CustomerDTO> getallcustomer() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        return customers;
    }

    @DeleteMapping(path = {"delete/{id}"})
    public boolean deletecustomer(@PathVariable(value = "id") String id) {
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO excitingcustomer = customers.get(i);
            if (excitingcustomer.getId().equals(id)) {
                customers.remove(i);
                return true;
            }

        }
        return false;
    }

}

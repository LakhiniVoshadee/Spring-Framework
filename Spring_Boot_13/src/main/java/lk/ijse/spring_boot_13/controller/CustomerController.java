package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
  /* @GetMapping
    public CustomerDTO getCustomer(@RequestBody CustomerDTO customerdto) {
       return customerdto;
   }*/

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(path = "save")
    public ResponseUtil getCustomer(@RequestBody CustomerDTO customerdto) {
      customerService.save(customerdto);
      return new ResponseUtil(201,"Customer is saved!",null);

      // return new ResponseUtil(409,"Already Exists!",null);
    }

    @GetMapping("/getall")
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(
                200,
                "success",
                customerService.getAllCustomers()
        );
       // return customerService.getAllCustomers();
    }
    @PutMapping("/update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
         customerService.updateCustomer(customerDTO);

            return new ResponseUtil(200,"Customer is updated!",null);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable int id) {
         customerService.deleteCustomer(id);
         return new ResponseUtil(200,"Customer is deleted!",null);
    }


}

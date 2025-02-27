package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.entity.Customer;
import lk.ijse.spring_boot_13.repo.CustomerRepo;
import lk.ijse.spring_boot_13.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CustomerDTO customerDTO){
        /*Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );*/
        //use model mapper to reduse the boilerplates codes
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));




    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
       /* return customerRepo.findAll().stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName(),customer.getAddress()))
                .collect(Collectors.toList());*/
       return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());

    }


    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            /*Customer customer = new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress()
            );*/
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
           // return true;
        }
        throw new RuntimeException("Customer not found");
    }
    @Override
    public void deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
           // return true;
        }
        throw new RuntimeException("Customer not found");
      //  return false;
    }




}

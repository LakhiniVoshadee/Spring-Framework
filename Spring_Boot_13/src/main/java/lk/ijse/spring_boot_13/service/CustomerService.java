package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    // Appliying the loose coupling
    void save(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(int id);
}

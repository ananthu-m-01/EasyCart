package com.ananthudev.EasyCart.controller;


import com.ananthudev.EasyCart.dto.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.CustomerResponseDTO;
import com.ananthudev.EasyCart.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ananthudev.EasyCart.service.CustomerService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    private CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO addCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        return customerService.addCustomer(createCustomerDTO);
    }
}

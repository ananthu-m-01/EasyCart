package com.ananthudev.EasyCart.controller;


import com.ananthudev.EasyCart.dto.customer.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ananthudev.EasyCart.service.customer.CustomerService;

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

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public CustomerResponseDTO addCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        return customerService.addCustomer(createCustomerDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(id,customerUpdateDTO);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}

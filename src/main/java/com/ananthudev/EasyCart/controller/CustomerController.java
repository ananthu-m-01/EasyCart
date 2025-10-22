package com.ananthudev.EasyCart.controller;


import com.ananthudev.EasyCart.dto.customer.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ananthudev.EasyCart.service.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    private CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerResponseDTO addCustomer(@RequestBody @Valid CreateCustomerDTO createCustomerDTO){
        return customerService.addCustomer(createCustomerDTO);
    }

    @PutMapping("{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(id,customerUpdateDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}

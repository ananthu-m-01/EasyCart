package com.ananthudev.EasyCart.service;

import com.ananthudev.EasyCart.dto.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.CustomerUpdateDTO;
import com.ananthudev.EasyCart.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO addCustomer(CreateCustomerDTO createCustomerDTO);
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO);
    ResponseEntity<String> deleteCustomer(Long id);
}

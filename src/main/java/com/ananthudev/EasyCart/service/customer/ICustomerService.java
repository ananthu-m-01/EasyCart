package com.ananthudev.EasyCart.service.customer;

import com.ananthudev.EasyCart.dto.customer.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO addCustomer(CreateCustomerDTO createCustomerDTO);
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO);
    ResponseEntity<String> deleteCustomer(Long id);
}

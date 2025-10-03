package com.ananthudev.EasyCart.service;

import com.ananthudev.EasyCart.dto.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.CustomerResponseDTO;
import com.ananthudev.EasyCart.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    CustomerResponseDTO addCustomer(CreateCustomerDTO createCustomerDTO);
}

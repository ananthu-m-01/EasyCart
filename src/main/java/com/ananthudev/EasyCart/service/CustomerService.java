package com.ananthudev.EasyCart.service;

import com.ananthudev.EasyCart.dto.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.CustomerResponseDTO;
import com.ananthudev.EasyCart.model.Customer;
import com.ananthudev.EasyCart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerResponseDTO addCustomer(CreateCustomerDTO createCustomerDTO){
        Customer customer = new Customer();
        customer.setName(createCustomerDTO.getName());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setPassword(createCustomerDTO.getPassword());
        customer.setPhoneNumber(createCustomerDTO.getPhoneNumber());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        Customer savedCustomer = customerRepository.save(customer);

        return new CustomerResponseDTO(
                savedCustomer.getName(),
                savedCustomer.getEmail(),
                savedCustomer.getPhoneNumber()
        );
    }
}

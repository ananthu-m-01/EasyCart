package com.ananthudev.EasyCart.service.customer;

import com.ananthudev.EasyCart.dto.customer.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerUpdateDTO;
import com.ananthudev.EasyCart.exceptions.customer.CustomerNotFoundException;
import com.ananthudev.EasyCart.model.Customer;
import com.ananthudev.EasyCart.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().
                stream().map(c -> CustomerResponseDTO.builder()
                .name(c.getName())
                .email(c.getEmail())
                .phoneNumber(c.getPhoneNumber())
                .build()).toList();
    }

    @Override
    public CustomerResponseDTO addCustomer(@Valid CreateCustomerDTO createCustomerDTO){

        Customer customer = Customer.builder()
                .name(createCustomerDTO.getName())
                .email(createCustomerDTO.getEmail())
                .password(createCustomerDTO.getPassword())
                .phoneNumber(createCustomerDTO.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerResponseDTO.builder()
                .name(savedCustomer.getName())
                .email(savedCustomer.getEmail())
                .phoneNumber(savedCustomer.getPhoneNumber())
                .build();
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id){

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));

        return CustomerResponseDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO){

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));

        Customer updatedCustomer = Customer.builder()
                .id(existingCustomer.getId())
                .name(customerUpdateDTO.getName())
                .email(existingCustomer.getEmail())
                .password(customerUpdateDTO.getPassword())
                .phoneNumber(customerUpdateDTO.getPhoneNumber())
                .createdAt(existingCustomer.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        Customer savedCustomer = customerRepository.save(updatedCustomer);

        return CustomerResponseDTO.builder()
                .name(savedCustomer.getName())
                .email(savedCustomer.getEmail())
                .phoneNumber(savedCustomer.getPhoneNumber())
                .build();
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found with id : "+id));
        customerRepository.delete(customer);
        return ResponseEntity.ok("customer deleted successfully");
    }
}

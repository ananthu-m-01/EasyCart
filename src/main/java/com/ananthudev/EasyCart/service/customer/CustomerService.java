package com.ananthudev.EasyCart.service.customer;

import com.ananthudev.EasyCart.dto.customer.CreateCustomerDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerResponseDTO;
import com.ananthudev.EasyCart.dto.customer.CustomerUpdateDTO;
import com.ananthudev.EasyCart.exceptions.customer.CustomerInvalidCredentialException;
import com.ananthudev.EasyCart.exceptions.customer.CustomerNotFoundException;
import com.ananthudev.EasyCart.exceptions.customer.DuplicateCustomerException;
import com.ananthudev.EasyCart.model.Customer;
import com.ananthudev.EasyCart.repository.CustomerRepository;
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
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(c -> new CustomerResponseDTO(
                        c.getName(),
                        c.getEmail(),
                        c.getPhoneNumber()
                )).toList();
    }

    @Override
    public CustomerResponseDTO addCustomer(CreateCustomerDTO createCustomerDTO){

        if(createCustomerDTO.getName() == null || createCustomerDTO.getEmail() == null || createCustomerDTO.getPassword() == null || createCustomerDTO.getPhoneNumber() == null){
            throw new CustomerInvalidCredentialException("invalid credential for customers");
        }

        boolean exists = customerRepository.findAll().stream().anyMatch(c-> c.getEmail().equalsIgnoreCase(createCustomerDTO.getEmail()));

        if(exists){
            throw new DuplicateCustomerException("customer with : "+createCustomerDTO.getEmail()+" is already exists!");
        }

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

    @Override
    public CustomerResponseDTO getCustomerById(Long id){
        boolean exists = customerRepository.findAll().stream().anyMatch(customer -> customer.getId().equals(id));
        if(!exists){
            throw new CustomerNotFoundException("customer not found");
        }

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO){
        if(customerUpdateDTO.getName() == null || customerUpdateDTO.getPassword() == null || customerUpdateDTO.getPhoneNumber() == null){
            throw new CustomerInvalidCredentialException("invalid credential for customer");
        }
        boolean exists = customerRepository.findAll().stream().anyMatch(customer -> customer.getId().equals(id));
        if(!exists){
            throw new CustomerNotFoundException("customer not found");
        }

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));
        customer.setName(customerUpdateDTO.getName());
        customer.setPassword(customerUpdateDTO.getPassword());
        customer.setPhoneNumber(customerUpdateDTO.getPhoneNumber());
        customer.setUpdatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);

        return new CustomerResponseDTO(
                savedCustomer.getName(),
                savedCustomer.getEmail(),
                savedCustomer.getPhoneNumber()
        );
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found with id : "+id));
        customerRepository.delete(customer);
        return ResponseEntity.ok("customer deleted successfully");
    }
}

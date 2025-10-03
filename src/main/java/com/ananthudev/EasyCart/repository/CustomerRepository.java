package com.ananthudev.EasyCart.repository;

import com.ananthudev.EasyCart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}

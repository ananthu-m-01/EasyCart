package com.ananthudev.EasyCart.validator;

import com.ananthudev.EasyCart.annotation.UniqueEmail;
import com.ananthudev.EasyCart.repository.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final CustomerRepository customerRepository;

    public UniqueEmailValidator(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext  context) {
        if (email == null || email.isEmpty()) return true;
        return !customerRepository.existsByEmailIgnoreCase(email);
    }
}

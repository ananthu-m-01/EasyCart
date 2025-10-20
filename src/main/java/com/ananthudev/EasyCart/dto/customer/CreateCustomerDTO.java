package com.ananthudev.EasyCart.dto.customer;

import com.ananthudev.EasyCart.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CreateCustomerDTO {
    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "invalid email format")
    @NotBlank(message = "email is required")
    @UniqueEmail
    private String email;


    @NotBlank(message = "password is required")
    @Size(min = 6,message = "password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",message = "phone number must contains exactly 10 digits")
    private String phoneNumber;
}

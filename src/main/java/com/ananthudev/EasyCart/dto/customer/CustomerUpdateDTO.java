package com.ananthudev.EasyCart.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "password is required")
    @Size(min = 6,message = "password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",message = "phone number must contains exactly 10 digits")
    private String phoneNumber;
}

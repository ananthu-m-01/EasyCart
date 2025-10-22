package com.ananthudev.EasyCart.dto.seller;

import jakarta.validation.constraints.Min;
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
public class SellerUpdateDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "password is required")
    @Size(min = 6, message = "password must contains at least 6 characters long")
    private String password;

    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",message = "phone number must contain exactly 10 digits")
    private String phoneNumber;

    @NotBlank(message = "business name is required")
    private String businessName;
}

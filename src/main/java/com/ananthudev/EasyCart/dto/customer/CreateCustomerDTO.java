package com.ananthudev.EasyCart.dto.customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}

package com.ananthudev.EasyCart.dto.customer;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private String name;
    private String password;
    private String phoneNumber;
}

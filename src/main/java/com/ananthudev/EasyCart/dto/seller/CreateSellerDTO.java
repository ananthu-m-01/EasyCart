package com.ananthudev.EasyCart.dto.seller;

import lombok.Data;


@Data
public class CreateSellerDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String businessName;
    private String GSTNumber;
}

package com.ananthudev.EasyCart.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSellerDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String businessName;
    private String GSTNumber;
}

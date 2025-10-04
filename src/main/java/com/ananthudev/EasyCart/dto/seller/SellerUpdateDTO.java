package com.ananthudev.EasyCart.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerUpdateDTO {
    private String name;
    private String password;
    private String phoneNumber;
    private String businessName;
}

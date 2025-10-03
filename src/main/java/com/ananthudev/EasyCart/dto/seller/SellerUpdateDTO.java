package com.ananthudev.EasyCart.dto.seller;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SellerUpdateDTO {
    private String name;
    private String password;
    private String phoneNumber;
    private String businessName;
}

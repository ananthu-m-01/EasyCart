package com.ananthudev.EasyCart.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseDTO {
    private String name;
    private String email;
    private String phoneNumber;
}

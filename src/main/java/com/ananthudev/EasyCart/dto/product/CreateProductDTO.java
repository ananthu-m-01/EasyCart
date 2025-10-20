package com.ananthudev.EasyCart.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductDTO {
    private Long sellerId;
    private Long categoryId;
    private Long discountId;

    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String stockUnit;
}

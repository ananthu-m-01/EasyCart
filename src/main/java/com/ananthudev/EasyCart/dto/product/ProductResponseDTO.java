package com.ananthudev.EasyCart.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String stockUnit;
    private String categoryName;
    private String sellerName;
    private String discountCode;  // nullable

}

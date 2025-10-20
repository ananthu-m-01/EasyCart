package com.ananthudev.EasyCart.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String stockUnit;
    private String categoryName;
    private String sellerName;
    private String discountCode;  // nullable
    private LocalDateTime createdAt;
}

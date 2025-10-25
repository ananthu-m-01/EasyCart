package com.ananthudev.EasyCart.dto.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductUpdateDTO {
    @NotBlank(message = "seller id is required")
    private Long sellerId;

    @NotBlank(message = "category id is required")
    private Long categoryId;

    @NotBlank(message = "discount id is required")
    private Long discountId;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "price is required")
    private BigDecimal price;

    @NotBlank(message = "quantity is required")
    private Long quantity;

    @NotBlank(message = "stock unit is required")
    private String stockUnit;
}

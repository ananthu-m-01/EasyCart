package com.ananthudev.EasyCart.model;

import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id",nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "discount_id",nullable = true)
    private Discount discount;

    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String stockUnit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDTO toProductResponseDTO() {
        return ProductResponseDTO.builder()
                .name(getName())
                .description(getDescription())
                .price(getPrice())
                .quantity(getQuantity())
                .stockUnit(getStockUnit())
                .categoryName(getCategory().getName())
                .discountCode(getDiscount().getCode())
                .sellerName(getSeller().getName())
                .discountCode(getDiscount().getCode())
                .build();
    }
}

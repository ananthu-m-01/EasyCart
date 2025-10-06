package com.ananthudev.EasyCart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "discount_id",nullable = true)
    private Discount discount;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @OneToOne(mappedBy = "order")
    private Delivery delivery;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.ananthudev.EasyCart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private Long zipCode;
    private String country;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private Long trackingNumber;
    private String courierService;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredAt;
}

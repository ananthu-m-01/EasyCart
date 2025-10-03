package com.ananthudev.EasyCart.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Seller {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String businessName;
    private String GSTNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.ananthudev.EasyCart.model;

import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String businessName;
    private String GSTNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public SellerResponseDTO toSellerResponseDTO(){
        return SellerResponseDTO.builder()
                .name(getName())
                .email(getEmail())
                .phoneNumber(getPhoneNumber())
                .build();
    }
}

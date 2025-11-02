package com.ananthudev.EasyCart.model;

import com.ananthudev.EasyCart.dto.category.CategoryResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    public CategoryResponseDTO toCategoryResponseDTO(){
        return CategoryResponseDTO
                .builder()
                .id(getId())
                .name(getName())
                .description(getDescription())
                .build();   
    }
}

package com.ananthudev.EasyCart.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryUpdateDTO {
    @NotBlank(message = "category name cannot be empty")
    private String name;

    @NotBlank(message = "category description can not be empty")
    private String description;
}

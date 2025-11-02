package com.ananthudev.EasyCart.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO {

    @NotBlank(message = "category name can not be empty")
    private String name;

    @NotBlank(message = "description can not be empty")
    private String description;
}

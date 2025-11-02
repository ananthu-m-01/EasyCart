package com.ananthudev.EasyCart.dto.category;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
}

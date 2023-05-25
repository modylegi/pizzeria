package ru.itis.semesterwork.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String pathToPhoto;
}

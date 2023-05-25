package ru.itis.semesterwork.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itis.semesterwork.dto.ProductDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDtoForCart extends ProductDto {
    private int quantity;
    private int totalSum;

}

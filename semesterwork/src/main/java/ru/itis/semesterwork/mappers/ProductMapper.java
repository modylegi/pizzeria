package ru.itis.semesterwork.mappers;

import org.mapstruct.Mapper;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Product;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    List<ProductDto> toDto(List<Product> product);
    Product fromDto(ProductDto productDto);
    List<Product> fromDto(List<ProductDto> productDto);


}

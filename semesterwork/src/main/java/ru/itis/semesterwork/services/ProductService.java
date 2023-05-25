package ru.itis.semesterwork.services;

import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto createProduct(Product product);

    void deleteProduct(Long productId);

    ProductDto updateProduct(Long productId, String name, String description, int price);

    ProductDto findById(Long id);
}

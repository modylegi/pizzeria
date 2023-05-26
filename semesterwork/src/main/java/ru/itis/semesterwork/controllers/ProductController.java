package ru.itis.semesterwork.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.mappers.ProductMapper;
import ru.itis.semesterwork.services.ProductService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(ModelMap modelMap) {
        List<ProductDto> allProducts = productService.getProducts();
        modelMap.put("products", allProducts);
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
        ProductDto createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        ProductDto updateProduct = productService.findById(id);
        productService.deleteProduct(id);
        updateProduct.setName(productDto.getName());
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setPathToPhoto(productDto.getPathToPhoto());
        updateProduct.setPrice(productDto.getPrice());
        productService.createProduct(productMapper.fromDto(updateProduct));
        return ResponseEntity.ok(updateProduct);
    }

}

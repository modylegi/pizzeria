package ru.itis.semesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.mappers.ProductMapper;
import ru.itis.semesterwork.repositories.ProductRepository;
import ru.itis.semesterwork.services.ProductService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    public ProductDto createProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product with this name already exists");
        }
        return productMapper.toDto(productRepository.save(product));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("product with id " + productId + " not exists");
        }
        productRepository.deleteById(productId);
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE)
//    @Override
//    public ProductDto updateProduct(Product product) {
//        Optional<Product> updatingProduct = productRepository.findById(product.getId());
//        if(updatingProduct.isPresent()){
//            productRepository.deleteById(productId);
//
//            throw new IllegalStateException("product with id " + productId + " not exists");
//        }
//        throw new IllegalStateException("product with id " + productId + " not exists");
//
//
//        return productMapper.toDto(productRepository.updateProduct(productRepository.findById(productId).orElseThrow()));
//
//    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));
        return productMapper.toDto(product);
    }
}

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

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ProductDto updateProduct(Long productId, String name, String description, int price) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "product with id " + productId + " does not exist"
        ));
        if(name != null && name.length() > 0 && !Objects.equals(product.getName(), name)){
            product.setName(name);
        }
        if(description != null && description.length() > 0 && !Objects.equals(product.getDescription(), description)){
            product.setDescription(description);
        }
        if(price != 0  && !Objects.equals(product.getPrice(), price)){
            product.setPrice(price);
        }
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toDto(product);
    }
}

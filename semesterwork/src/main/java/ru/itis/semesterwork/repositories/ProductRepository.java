package ru.itis.semesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.entities.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);


}


package ru.itis.semesterwork.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.services.OrderService;
import ru.itis.semesterwork.services.ProductService;
import ru.itis.semesterwork.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
    @PostMapping("/create-product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @DeleteMapping("delete-product/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping("update-product/{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int price) {
        return ResponseEntity.ok(productService.updateProduct(productId, name, description, price));
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @DeleteMapping("delete-user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}

package ru.itis.semesterwork.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.Order;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.mappers.ProductMapper;
import ru.itis.semesterwork.services.OrderService;
import ru.itis.semesterwork.services.ProductService;
import ru.itis.semesterwork.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;
    private final ProductMapper productMapper;
    @GetMapping("/api/v1/order")
    public ResponseEntity<List<OrderDto>> getOrdersApi() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("orders")

    public String getOrders() {
        return "admin-user/orders";
    }
    @PostMapping(value = "/api/create-product")
    public ResponseEntity<ProductDto> createProduct(@ModelAttribute Product product, @RequestParam("image")  MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setPathToPhoto(fileName);
        ProductDto createdProduct = productService.createProduct(product);
        String uploadDir = "src/main/webapp/storage";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }


        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/create-product")
    public String getCreateProductPage(
    ) {
        return "admin-user/create";
    }

    @DeleteMapping("delete-product/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

//    @PutMapping("update-product/{productId}")
//    public ResponseEntity<ProductDto> updateProduct(
//            @PathVariable("productId") Long productId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String description,
//            @RequestParam(required = false) int price) {
//        return ResponseEntity.ok(productService.updateProduct(productId, name, description, price));
//    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @DeleteMapping("delete-user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}

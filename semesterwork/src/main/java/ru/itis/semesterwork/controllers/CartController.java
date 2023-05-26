package ru.itis.semesterwork.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.services.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/cart")
@SessionAttributes("cart")
@RequiredArgsConstructor
public class CartController {
    private final ProductService productService;
//    private final


    @ModelAttribute("cart")
    public List<ProductDto> createCart() {
        return new ArrayList<>();

    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getCart(
            @ModelAttribute("cart") List<ProductDto> productCart) {
        return ResponseEntity.ok(productCart);
    }

    @PostMapping()
    public void addToCart(
            @ModelAttribute("cart") List<ProductDto> productCart,
            @RequestBody ProductDto productDto,
            Model model){
            ProductDto chosenProduct = productService.findById(productDto.getId());
            productCart.add(chosenProduct);
            model.addAttribute(productCart);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(
            @PathVariable Long id,
            @ModelAttribute("cart") List<ProductDto> productCart) {
        productCart.removeIf(productDto -> productDto.getId().equals(id));
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PutMapping("/{id}")
//    public void updateCartItem(@PathVariable Long id, @RequestBody ProductDto productDto) {
//        ProductDto existingProduct = productService.findById(id);
//        existingProduct.setName(productDto.getName());
//        existingProduct.setDescription(productDto.getDescription());
//        existingProduct.setPathToPhoto(productDto.getPathToPhoto());
//        existingProduct.setPrice(productDto.getPrice());
//
//
//        existingCartItem.setName(cartItem.getName());
//        existingCartItem.setPrice(cartItem.getPrice());
//        existingCartItem.setQuantity(cartItem.getQuantity());
//        cartItemRepository.save(existingCartItem);
//    }




}

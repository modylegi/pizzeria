package ru.itis.semesterwork.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.dto.UserDto;
//import ru.itis.semesterwork.security.services.JwtService;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.entities.ProductDtoForCart;
import ru.itis.semesterwork.services.OrderService;
import ru.itis.semesterwork.services.ProductService;
import ru.itis.semesterwork.services.UserService;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
@SessionAttributes("cart")
public class UserController {


    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("/create-order")
    public String createOrder(
            @ModelAttribute("cart") List<ProductDto> productCart,
            @ModelAttribute("address") String address,
            @CookieValue("dodo-pizza") String token
    ){

        if(productCart != null){
            orderService.createOrder(productCart, address, token);
            productCart.clear();
        }

        return "redirect:/products";



    }

    @GetMapping("/cart")
    public String getCart(@ModelAttribute("cart") List<ProductDto> productCart, ModelMap modelMap ) {
        modelMap.put("productCart", productCart);
        return "cart";

    }

    @ModelAttribute("cart")
    public List<ProductDto> createCart() {
        return new ArrayList<>();

    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(
            @PathVariable("id") Long id,
            @ModelAttribute("cart") List<ProductDto> productCart,
            ModelMap model){
        if(productCart != null){
            ProductDto chosenProduct = productService.findById(id);
            productCart.add(chosenProduct);
            model.addAttribute(productCart);
            log.info("Добавлен товар: {}", chosenProduct.getId());

            log.info("Корзина: {}", productCart.toString());
        } else {
            model.addAttribute("cart", new ArrayList<>());
        }
        return "redirect:/products";

    }
    @GetMapping("/remove-from-cart/{id}")
    public String removeFromCart(
            @PathVariable("id") Long id,
            @ModelAttribute("cart") List<ProductDto> productCart,
            Model model){
        ProductDto removedProduct = productService.findById(id);
        productCart.remove(removedProduct);
        model.addAttribute(productCart);
        log.info("Корзина: {}", productCart.toString());
        return "redirect:/cart";

    }

    @GetMapping("/products")
    public String getProducts(ModelMap modelMap){
        modelMap.put("products",productService.getProducts());
        return "products";



    }

    @PutMapping("update-profile/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String password) {
        return ResponseEntity.ok(userService.updateUser(userId,firstName,lastName,email,age,password));
    }

    @DeleteMapping("delete-profile/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}

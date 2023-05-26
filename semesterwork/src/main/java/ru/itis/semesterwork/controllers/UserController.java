package ru.itis.semesterwork.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itis.semesterwork.dto.CartProductDto;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.dto.UserDto;
//import ru.itis.semesterwork.security.services.JwtService;
import ru.itis.semesterwork.entities.AuthenticateRequest;
import ru.itis.semesterwork.entities.DeliveryAddress;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.entities.RegisterRequest;
import ru.itis.semesterwork.security.services.AuthService;
import ru.itis.semesterwork.services.OrderService;
import ru.itis.semesterwork.services.ProductService;
import ru.itis.semesterwork.services.UserService;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.net.URL;
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

    @PostMapping("/api/v1/order")
    public String createOrder(
            @ModelAttribute("cart") List<ProductDto> productCart,
            @ModelAttribute("address")  String address,
            @CookieValue("dodo-pizza") String token
    ){
        System.out.println(address);

        if(productCart != null){
            orderService.createOrder(productCart, address, token);
            productCart.clear();
        }

        return "redirect:/products";



    }

    @GetMapping("/cart")
    public String getCart( ModelMap modelMap, @ModelAttribute("cart") List<ProductDto> productCart, ModelMap model) {

        int totalSum = productCart.stream().mapToInt(ProductDto::getPrice).sum();
        int totalCount = productCart.size();
        log.info("elements: {}", productCart);
        modelMap.put("productCart", productCart);
        modelMap.put("totalSum", totalSum);
        modelMap.put("totalCount", totalCount);
        modelMap.addAttribute("address");
        return "cart";
    }


//    @GetMapping(value = "/cart")
//    public String getCart( ModelMap modelMap, HttpServletRequest request ) {
//        String fullURL = request.getRequestURL().toString().replace("/cart", "").concat("/api/v1/cart");
////        log.info("{}", productCart);
//        System.out.println(fullURL);
//
//        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
//
//        RestTemplate restTemplate = new RestTemplate();
////        String path = String.valueOf(UriComponentsBuilder.newInstance().);
//
//        CartProductDto response = restTemplate.getForObject(fullURL , CartProductDto.class);
//        System.out.println(response.getList());
////        System.out.println(response.getStatusCodeValue());
////        List<ProductDto> productCart = response.getBody();
////        log.info("{}", productCart);
//        modelMap.put("productCart", response);
//
//        return "cart";
//
//    }



    @GetMapping("/products")
    public String getProducts(ModelMap modelMap){
        modelMap.put("products",productService.getProducts());
        return "products";

    }
    private final AuthService authService;

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "security/signUp";
    }

    @GetMapping("/sign-in")
    public String getSignInPage(){
        return "security/signIn";
    }

    @PostMapping("/auth/sign-in")
    public String signIn(AuthenticateRequest authenticateRequest, HttpServletResponse servletResponse){
        servletResponse.addCookie(authService.authenticate(authenticateRequest));
        return "redirect:/products";

    }

    @PostMapping("/auth/sign-up")
    public String signUp(RegisterRequest registerRequest){
        authService.register(registerRequest);
        return "redirect:/sign-in";
    }


    @GetMapping("/auth/sign-out")
    public String signOut(){

        return "redirect:/products";
    }




}

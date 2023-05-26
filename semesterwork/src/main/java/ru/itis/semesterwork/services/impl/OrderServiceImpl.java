package ru.itis.semesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Order;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.entities.User;
import ru.itis.semesterwork.mappers.OrderMapper;
import ru.itis.semesterwork.mappers.ProductMapper;
import ru.itis.semesterwork.repositories.OrderRepository;
import ru.itis.semesterwork.repositories.ProductRepository;
import ru.itis.semesterwork.security.token.Token;
import ru.itis.semesterwork.security.token.TokenRepository;
import ru.itis.semesterwork.services.OrderService;
import ru.itis.semesterwork.services.ProductService;
import ru.itis.semesterwork.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final TokenRepository tokenRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;


    @Override
    public List<OrderDto> getOrders() {

        List<Order> orders =  orderRepository.findAll();

        return OrderDto.from(orders);

    }

    @Override
    public OrderDto createOrder(List<ProductDto> products, String address, String token) {
        User user = tokenRepository.findByToken(token).orElseThrow().getUser();

        Order order = Order.builder()
                .products(productMapper.fromDto(products))
                .time(LocalDateTime.now())
                .address(address)
                .user(user)
                .build();
        return orderMapper.toDto(orderRepository.save(order));
    }
}


//        return Order.builder()
//                .address(address)
//                .products(products)
//                .user(userService.findByEmail(email))
//                .time(new LocalDateTime)
//                .build();



//    @Transactional(isolation = Isolation.SERIALIZABLE)
//    @Override
//    public void deleteOrder(Long orderId) {
//        boolean exists = orderRepository.existsById(orderId);
//        if(!exists){
//            throw new IllegalStateException("product with id " + orderId + " not exists");
//        }
//        orderRepository.deleteById(orderId);
//
//    }
//}

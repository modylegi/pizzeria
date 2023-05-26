package ru.itis.semesterwork.services;

import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.dto.ProductDto;
import ru.itis.semesterwork.entities.Order;
import ru.itis.semesterwork.entities.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();

    OrderDto createOrder(List<ProductDto> products, String address, String token);

//    void deleteOrder(Long orderId);

//    OrderDto updateOrder(Long orderId, String name, String description, int price);
}

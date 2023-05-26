package ru.itis.semesterwork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.itis.semesterwork.entities.Order;
import ru.itis.semesterwork.entities.Product;
import ru.itis.semesterwork.entities.User;
import ru.itis.semesterwork.mappers.OrderMapper;
import ru.itis.semesterwork.mappers.ProductMapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class OrderDto {

    @JsonProperty("orderedProducts")
    private List<ProductDto> orderedProducts;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;

    public static OrderDto from(Order order){
        return OrderDto.builder()
                .orderedProducts(order.getProducts().stream()
                        .map(product -> {
                            ProductDto productDto = new ProductDto();
                            productDto.setName(product.getName());
                            productDto.setPrice(product.getPrice());
                            productDto.setId(product.getId());
                            productDto.setPathToPhoto(product.getPathToPhoto());
                            productDto.setDescription(productDto.getDescription());
                            return productDto;
                        }).collect(Collectors.toList()))
                .address(order.getAddress())
                .email(order.getUser().getEmail())
                .build();
    }
    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }

}

//    public List<ProductDto> getProducts(List<Product> products){
//
//    }
//}

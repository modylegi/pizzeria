package ru.itis.semesterwork.mappers;

import org.mapstruct.Mapper;
import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.entities.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    List<OrderDto> toDto(List<Order> product);
}

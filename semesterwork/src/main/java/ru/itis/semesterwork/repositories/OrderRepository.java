package ru.itis.semesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.dto.OrderDto;
import ru.itis.semesterwork.entities.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser_Id(long userId);
}

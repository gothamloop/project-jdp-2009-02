package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order mapToOrder(OrderDto orderDto) {
        return new Order();
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto();
    }
}

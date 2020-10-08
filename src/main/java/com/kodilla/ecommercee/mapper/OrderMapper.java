package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUserId(),
                orderDto.getCreationDate(),
                orderDto.isHasNotSent());
    }

   public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getCreationDate(),
                order.isHasNotSent(),
                order.getUser());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                //.map(t -> new OrderDto(t.getOrderId(), t.getUser(), t.getCreationDate(),t.isHasNotSent()))
                .map(t -> new OrderDto(t.getOrderId(), t.getCreationDate(),t.isHasNotSent(),t.getUser() ))
                .collect(Collectors.toList());
    }
}

package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getCreationDate().getDayOfYear(),
                orderDto.getCreationDate().getMonthValue(),
                orderDto.getCreationDate().getDayOfMonth(),
                orderDto.isHasNotSent());
    }

   public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUser(),
                order.getCreationDate().getDayOfYear(),
                order.getCreationDate().getDayOfMonth(),
                order.getCreationDate().getMonthValue(),
                order.isHasNotSent());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(t -> new OrderDto(t.getOrderId(),t.getUser(), t.getCreationDate().getDayOfYear(),t.getCreationDate().getDayOfMonth(),t.getCreationDate().getMonthValue(),t.isHasNotSent()))
                .collect(Collectors.toList());
    }

}

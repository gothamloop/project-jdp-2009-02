package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<Order> getOrders(@RequestParam Long userId) {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder() {
        System.out.println("The order has been created");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long OrderId) throws OrderNotFoundException {
        OrderDto testOrderDto = new OrderDto(1L, 1L, 2020, 9, 22);
        return testOrderDto;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        OrderDto testOrderDto = new OrderDto(2L, 2L, 2020, 9, 23);
        return testOrderDto;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long OrderId) {
        System.out.println("The order has been deleted");
    }
}
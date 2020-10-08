package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private DbService service;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
   // public List<Order> getOrders(@RequestParam Long userId) { return new ArrayList<>();}
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    //public void createOrder() { System.out.println("The order has been created"); }
    public void createOrder(@RequestBody OrderDto orderDto) {
        service.saveOrder(orderMapper.mapToOrder(orderDto));
    }

   @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(service.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
       // OrderDto testOrderDto = new OrderDto(1L, 1L, 2020, 9, 22);
       // return testOrderDto;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        //OrderDto testOrderDto = new OrderDto(2L, 2L, 2020, 9, 23);
        //return testOrderDto;
        return new OrderDto(2L,1, 20, 9,1,true);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        //System.out.println("The order has been deleted");
        service.deleteOrder(orderId);
    }
}
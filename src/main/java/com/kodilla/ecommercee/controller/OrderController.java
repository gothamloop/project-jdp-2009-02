package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
       public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
      public OrderDto createOrder(@RequestParam Long cartId, @RequestParam Long userId) throws CartNotFoundException, UserNotFoundException {
        Cart cart = service.findCartById(cartId).orElseThrow(CartNotFoundException::new);
        User user = service.findUserById(userId).orElseThrow(UserNotFoundException::new);

        Order order = new Order(LocalDate.now(), false, user);
        order.setProductsList(cart.getProductsList());
        return orderMapper.mapToOrderDto(service.saveOrder(order));
    }

   @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
       return orderMapper.mapToOrderDto(service.getOrder(orderId));
          }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(2L,new User(), 20, 10,8,true);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
         service.deleteOrder(orderId);
    }
}
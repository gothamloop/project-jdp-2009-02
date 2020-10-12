package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    DbService service;

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public CartDto createCart(@RequestBody CartDto cartDto) {
        return cartMapper.mapToCartDto(service.saveCart(cartMapper.mapToCart(cartDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId) throws ProductsListNotFoundException {
        List<Product> products = service.getProductsByCartId(cartId).orElseThrow(ProductsListNotFoundException::new);
        return productMapper.mapToProductsDtos(products);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProducts")
    public CartDto addProducts(@RequestParam Long cartId, @RequestBody List<ProductDto> productsDtos)
            throws CartNotFoundException {
        List<Product> products =  productMapper.mapToProducts(productsDtos);

        Cart cart = service.findCartById(cartId).orElseThrow(CartNotFoundException::new);
        cart.getProductsList().addAll(products);

        return cartMapper.mapToCartDto(service.saveCart(cart));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public CartDto deleteProduct(@RequestParam Long productId, @RequestParam Long cartId)
            throws CartNotFoundException {
        Cart cart = service.findCartById(cartId).orElseThrow(CartNotFoundException::new);
        cart.getProductsList().removeIf(product -> product.getId() == productId);

        return cartMapper.mapToCartDto(service.saveCart(cart));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public OrderDto createOrder(Long cartId, Long userId)
            throws UserNotFoundException, CartNotFoundException {
        Cart cart = service.findCartById(cartId).orElseThrow(CartNotFoundException::new);

        User user = service.findUserById(userId).orElseThrow(UserNotFoundException::new);

        Order order = new Order(LocalDate.now(), false, user);
        order.setProductsList(cart.getProductsList());

        return orderMapper.mapToOrderDto(service.saveOrder(order));
    }
}
package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.dao.ProductDao;
import com.kodilla.ecommercee.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    @Autowired
    ProductDao productDao;

    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                mapToProducts(cartDto.getProductsIds())
        );
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                mapToProductsIds(cart.getProductsList())
        );
    }

    public List<Product> mapToProducts(List<Long> productsIds) {
        return productsIds.stream()
                .map(productId -> productDao.findById(productId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Long> mapToProductsIds(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }
}
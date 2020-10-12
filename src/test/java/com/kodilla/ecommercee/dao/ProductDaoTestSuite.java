package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductDaoTestSuite {
    @Autowired
    ProductDao productDao;

    @Autowired
    CartDao cartDao;

    @Test
    public void testFindProductsList_ByCart_Id() {
        //Given
        Product product1 = new Product();
        Product product2 = new Product();

        List<Product> products = new ArrayList<>();
        Collections.addAll(products, product1, product2);

        Cart cart = new Cart();
        cart.getProductsList().addAll(products);

        product1.setCart(cart);
        product2.setCart(cart);

        cartDao.save(cart);
        long cartId = cart.getId();

        //When
        Optional<List<Product>> retrievedProducts = productDao.findByCart_Id(cartId);

        //Then
        Assert.assertEquals(2, retrievedProducts.get().size());
    }
}
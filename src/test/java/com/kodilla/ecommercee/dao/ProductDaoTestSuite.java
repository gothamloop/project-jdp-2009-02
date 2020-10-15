package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;
     
    @Autowired
    private CartDao cartDao;

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

    @Test
    public void testProductDaoSave(){
        //Given
        Product product1 = new Product("Shirt", "Spring/Summer 2020", new BigDecimal("49.99"));

        //When
        productDao.save(product1);

        //Than
        long id = product1.getId();
        Optional<Product> readProduct = productDao.findById(id);
        Assert.assertTrue(readProduct.isPresent());
        Assert.assertEquals("Shirt", readProduct.get().getName());
        Assert.assertEquals("Spring/Summer 2020", readProduct.get().getDescription());
        Assert.assertEquals(BigDecimal.valueOf(49.99), readProduct.get().getPrice());
    }

    @Test
    public void testProductSaveAllArgs() {
        //Given
        Cart cart = new Cart();
        Order order = new Order();
        Group group = new Group();
        Product product = new Product("Shirt", "Spring/Summer 2020", new BigDecimal("49.99"),
                12, cart, order, group);
        product.setCart(cart);
        product.setOrder(order);
        product.setGroup(group);

        //When
        productDao.save(product);
        long id = product.getId();

        Long cartId = cart.getId();
        Long orderId = order.getOrderId();
        Long groupId = group.getId();

        //Then
        Optional<Product> readProduct = productDao.findById(id);
        Assert.assertTrue(readProduct.isPresent());
        Assert.assertEquals(null, cartId);
        Assert.assertEquals(null, orderId);
        Assert.assertEquals(null, groupId);
    }
}

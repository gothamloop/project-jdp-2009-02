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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;

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

        //CleanUp
        productDao.deleteById(id);
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

        //CleanUp
        productDao.deleteById(id);

    }
}

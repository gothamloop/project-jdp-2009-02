package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartDaoTestSuite {

    @Autowired
    private CartDao cartDao;

    @Test
    public void testCartDaoSave() {
        //Given
        Cart cart = new Cart();

        //When
        cartDao.save(cart);

        //Then
        long id = cart.getId();
        Optional<Cart> cartDaoById = cartDao.findById(id);
        Assert.assertTrue(cartDaoById.isPresent());
        Assert.assertEquals(0, cartDaoById.get().getProductsList().size());

        //CleanUp
        cartDao.deleteById(id);
    }

    @Test
    public void testCartDaoSave_withProducts() {
        //Given
        Cart cart = new Cart();

        Product product1 = new Product("Pineapple", "Fruit LTD.", new BigDecimal("8.8"));
        Product product2 = new Product("Apple", "Fruit LTD.", new BigDecimal("1.45"));

        product1.setCart(cart);
        product2.setCart(cart);

        cart.getProductsList().add(product1);
        cart.getProductsList().add(product2);

        //When
        cartDao.save(cart);

        //Then
        long id = cart.getId();
        Optional<Cart> cartDaoById = cartDao.findById(id);
        Assert.assertTrue(cartDaoById.isPresent());
        Assert.assertEquals(2, cartDaoById.get().getProductsList().size());
        Assert.assertEquals("Pineapple", cartDaoById.get().getProductsList().get(0).getName());
        Assert.assertEquals("Fruit LTD.", cartDaoById.get().getProductsList().get(0).getDescription());
        Assert.assertEquals(BigDecimal.valueOf(1.45), cartDaoById.get().getProductsList().get(1).getPrice());

        //CleanUp
        cartDao.deleteById(id);
    }
}
package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDaoSave() {

        //Given
        User user = new User("Jan", "Nowak");

        //When
        userDao.save(user);

        //Then
        long id = user.getUserId();
        Optional<User> userDaoById = userDao.findById(id);

        Assert.assertTrue(userDaoById.isPresent());
        Assert.assertEquals("Jan", userDaoById.get().getName());
        Assert.assertEquals("Nowak", userDaoById.get().getSurname());
        Assert.assertEquals(0, userDaoById.get().getOrdersList().size());

    }

    @Test
    public void testUserDaoWithCart() {
        //Given
        User user = new User("Jan", "Nowak");
        Cart cart1 = new Cart();

        user.setCart(cart1);

        //When
        userDao.save(user);

        //Then
        long id = user.getUserId();
        Optional<User> userDaoById = userDao.findById(id);

        Assert.assertTrue(userDaoById.isPresent());
        Assert.assertEquals(cart1.getId(), userDaoById.get().getCart().getId());
        Assert.assertEquals(cart1.getProductsList().size(), userDaoById.get().getCart().getProductsList().size());

    }

    @Test
    public void testUserDaoWithOrders() {
        //Given
        User user = new User("Jan", "Nowak");
        Order order1 = new Order(2020, 5, 12);
        Order order2 = new Order(2020, 6, 11);
        Order order3 = new Order(2019, 9, 5);

        user.getOrdersList().add(order1);
        user.getOrdersList().add(order2);
        user.getOrdersList().add(order3);

        order1.setUser(user);
        order2.setUser(user);
        order3.setUser(user);

        //When
        userDao.save(user);

        //Then
        long id = user.getUserId();
        Optional<User> userDaoById = userDao.findById(id);

        Assert.assertTrue(userDaoById.isPresent());
        Assert.assertEquals(3, userDaoById.get().getOrdersList().size());
        Assert.assertEquals(2020, userDaoById.get().getOrdersList().get(0).getCreated().getYear());

    }
}

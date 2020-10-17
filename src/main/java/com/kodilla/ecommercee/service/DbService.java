package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.GenericEntityRepository;

import com.kodilla.ecommercee.dao.CartDao;
import com.kodilla.ecommercee.dao.OrderDao;
import com.kodilla.ecommercee.dao.ProductDao;
import com.kodilla.ecommercee.dao.UserDao;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    CartDao cartDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;
    private GenericEntityRepository repository;

    public List<GenericEntity> getAllOrders() {
        return repository.findAll();
    }

    // public Order getOrderById(final Long id) {
    //     return repository.findById(id).orElse(null);
    //  }

    //public Order saveOrder(final Order order)        return repository.save(order);
    //}

    public Optional<GenericEntity> getOrder(final Long id) {
        return repository.findById(id);
    }

    public void deleteOrder(final Long id) { repository.deleteById(id); }

  //  public Optional<GenericEntity> getAllOrders(final Long id) {return repository.findById(id);}



    public Cart saveCart(Cart cart) {
        return cartDao.save(cart);
    }

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public Optional<List<Product>> getProductsByCartId(long cartId) {
        return productDao.findByCart_Id(cartId);
    }

    public Optional<User> findUserById(long userid) {
        return userDao.findById(userid);
    }

    public Optional<Cart> findCartById(long cartId) {
        return cartDao.findById(cartId);
    }

}

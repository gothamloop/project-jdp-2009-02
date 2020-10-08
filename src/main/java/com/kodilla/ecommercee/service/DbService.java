package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private GenericEntityRepository repository;

    public List<GenericEntity> getAllOrders() {
        return repository.findAll();
    }

    // public Order getOrderById(final Long id) {
    //     return repository.findById(id).orElse(null);
    //  }

    public Order saveOrder(final Order order) {
        return repository.save(order);
    }

    public Optional<GenericEntity> getOrder(final Long id) {
        return repository.findById(id);
    }

    public void deleteOrder(final Long id) { repository.deleteById(id); }

    public Optional<GenericEntity> getAllOrders(final Long id) {
        return repository.findById(id);
    }
}

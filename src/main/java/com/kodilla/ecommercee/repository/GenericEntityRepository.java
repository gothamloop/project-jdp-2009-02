package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericEntityRepository<id> extends JpaRepository<Order, id> {

    @Override
    List<Order> findAll();

    @Override
    Order save(Order order);

    Optional<GenericEntity> findById(Long id);


    GenericEntity save(GenericEntity test);

    void deleteById(Long id);
}
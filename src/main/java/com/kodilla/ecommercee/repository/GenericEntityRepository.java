package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {

    @Override
    List<GenericEntity> findAll();

    //   @Override
    Order save(Order order);

    @Override
    Optional<GenericEntity> findById(Long id);


}
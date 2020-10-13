package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    public GenericEntity() {
    }

    public String getValue() {
        return value;
    }

    public Long getId() {

        return id;
    }

    public GenericEntity(String value) {

        this.value = value;
    }

    public Long getOrderId() {
        return null;
    }

    public User getUser() {
        return null;
    }

    public LocalDate getCreationDate() {
        return null;
    }

    public boolean isHasNotSent() {
        return false;
    }
}

package com.kodilla.ecommercee.domain;

import java.time.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private User userId;
    private LocalDate creationDate;
    private boolean hasNotSent;
    private Object productsList;

     public OrderDto(Long orderId, User userId, int yearOfOrder, int monthOfOrder, int dayOfOrder, boolean hasNotSent) {
        this.orderId = orderId;
        this.userId = userId;
        this.creationDate = LocalDate.of(yearOfOrder, monthOfOrder, dayOfOrder);
        this.hasNotSent = true;
     }


    public Long getOrderId() {
        return orderId;
    }

    public User getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isHasNotSent() {
        return hasNotSent;
    }

    public Object getProductsList() {
        return productsList;
    }
}

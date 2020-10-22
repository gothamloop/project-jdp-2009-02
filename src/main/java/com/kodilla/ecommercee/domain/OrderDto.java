package com.kodilla.ecommercee.domain;

import java.time.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private LocalDate creationDate;
    private boolean hasNotSent;
    private List<Long> productsList;

     public OrderDto(Long orderId, User userId, int yearOfOrder, int monthOfOrder, int dayOfOrder, boolean hasNotSent) {
        this.orderId = orderId;
        this.creationDate = LocalDate.of(yearOfOrder, monthOfOrder, dayOfOrder);
        this.hasNotSent = true;
     }


    public Long getOrderId() {
        return orderId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isHasNotSent() {
        return hasNotSent;
    }

    public List<Long> getProductsList() {
        return productsList;
    }
}

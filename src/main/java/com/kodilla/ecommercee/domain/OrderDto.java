package com.kodilla.ecommercee.domain;

import java.time.LocalDate;

public class OrderDto {
    private Long orderId;
    private Long userId;
    private LocalDate creationDate;
    private boolean hasNotSent;
    private Object productsList;


    public OrderDto(Long orderId, Long userId, int yearOfOrder, int monthOfOrder, int dayOfOrder, boolean hasNotSent) {
        this.orderId = orderId;
        this.userId = userId;
        this.creationDate = LocalDate.of(yearOfOrder, monthOfOrder, dayOfOrder);
        this.hasNotSent = true;


    }

    public OrderDto(Long orderId, User user, LocalDate creationDate, boolean hasNotSent) {
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
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

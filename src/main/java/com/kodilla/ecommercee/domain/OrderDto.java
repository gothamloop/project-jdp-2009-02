package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private Long userId;
    private LocalDate creationDate;
    private boolean hasNotSent;

    public OrderDto(Long orderId, Long userId, int yearOfOrder, int monthOfOrder, int dayOfOrder) {
        this.orderId = orderId;
        this.userId = userId;
        this.creationDate = LocalDate.of(yearOfOrder, monthOfOrder, dayOfOrder);
        this.hasNotSent = true;
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
}

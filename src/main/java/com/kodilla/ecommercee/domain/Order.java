package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private LocalDate creationDate;

    private boolean hasNotSent;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Long user;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productsList;

      public Order(Long orderId, Long user, LocalDate creationDate, boolean hasNotSent) {
        this.orderId = orderId;
        this.user = user;
        this.creationDate = creationDate;
        this.hasNotSent = hasNotSent;
    }

}


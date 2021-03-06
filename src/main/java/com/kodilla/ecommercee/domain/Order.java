package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true)
    private Long orderId;

    @Column(name = "CREATED")
    private LocalDate created;

    @Column(name = "SHIPPED")
    private boolean shipped;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
   private List<Product> productsList = new ArrayList<>();

    public Order(int yearOfCreationDate, int monthOfCreationDate, int dayOfCreationDate) {
        this.created = LocalDate.of(yearOfCreationDate, monthOfCreationDate, dayOfCreationDate);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(LocalDate creationDate, boolean hasNotSent, User user) {
        this.created = creationDate;
        this.shipped = hasNotSent;
        this.user = user;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

}

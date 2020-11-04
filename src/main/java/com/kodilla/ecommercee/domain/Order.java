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

    private int createdDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true)
    private Long orderId;

    private boolean hasNotSent;

    @Column(name = "CREATED")
    //private LocalDate created;
    private LocalDate creationDate;

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
    private List<Product> productsList;

    public Order(long l, int i, int dayOfMonth, int monthValue, boolean b) {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(Long orderId, LocalDate creationDate, boolean hasNotSent) {
        this.orderId = orderId;
        //this.user = user;
        this.creationDate = creationDate;
        this.hasNotSent = hasNotSent;
    }

    public Order(LocalDate creationDate, boolean hasNotSent, User user) {
              this.creationDate =creationDate;
              this.shipped = hasNotSent;
              this.user = user;
        }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;

    }
}


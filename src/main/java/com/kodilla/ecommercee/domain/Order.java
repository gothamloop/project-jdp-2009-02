package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
<<<<<<< HEAD
    private List<Product> products = new ArrayList<>();

    public Order(int yearOfCreationDate, int monthOfCreationDate, int dayOfCreationDate) {
        this.created = LocalDate.of(yearOfCreationDate, monthOfCreationDate, dayOfCreationDate);
=======
    private List<Product> productsList;

    public Order(int yearOfCreationDate,int monthOfCreationDate,int dayOfCreationDate) {
        this.creationDate = LocalDate.of(yearOfCreationDate, monthOfCreationDate, dayOfCreationDate);
>>>>>>> b78208d30b5f0044c09ad55f0f84a3debb4dc633
    }

    public void setUser(User user) {
        this.user = user;
    }
}

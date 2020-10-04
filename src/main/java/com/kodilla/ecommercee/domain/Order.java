package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Date created;

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
    private List<Product> products;
}

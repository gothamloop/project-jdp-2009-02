package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CART_ID")
    private Long id;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Product> productsList = new ArrayList<>();
}

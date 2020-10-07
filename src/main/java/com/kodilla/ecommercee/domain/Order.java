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
    private User user;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productsList;

    public Order(int yearOfCreationDate,int monthOfCreationDate,int dayOfCreationDate) {
        this.creationDate = LocalDate.of(yearOfCreationDate, monthOfCreationDate, dayOfCreationDate);
    }

    public void setUser(User user) {
        this.user = user;
    }
}

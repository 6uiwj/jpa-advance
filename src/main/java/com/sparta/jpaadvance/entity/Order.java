package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //food는 여러번 order 될 수있다. (1 : N)
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    //user는 여러번 order 할 수 있다. (1: N)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
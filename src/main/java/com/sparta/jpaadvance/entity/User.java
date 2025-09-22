package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "user")
    private Food food;

    public void addFood(Food food) { //외래키의 주인이 아닌데 외래키 넣는법
        this.food = food;
        food.setUser(this); //나자신 객체(User)
    }
}
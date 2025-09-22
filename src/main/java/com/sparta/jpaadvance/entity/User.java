package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REMOVE} /*  orphanRemoval = true*/)
    private List<Food> foodList = new ArrayList<>();

    //외래키의 주인이 아닌데 외래키를 설정하고 싶을 때
    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this); //외래키 설정
    }
}
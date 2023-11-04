package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
        @JoinTable(
        name = "cart_cars",
        joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    private List<Car> itemsinCart = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getItemsinCart() {
        return itemsinCart;
    }

    public void setItemsinCart(List<Car> itemsinCart) {
        this.itemsinCart = itemsinCart;
    }
}

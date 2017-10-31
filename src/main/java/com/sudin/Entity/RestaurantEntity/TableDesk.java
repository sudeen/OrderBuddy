package com.sudin.Entity.RestaurantEntity;

import javax.persistence.*;

@Entity
public class TableDesk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int capacity;

    @ManyToOne
    private Restaurant restaurant;

    public TableDesk() {
    }

    public TableDesk(int capacity, Restaurant restaurant) {
        this.capacity = capacity;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

package com.sudin.Service.restaurant;

import com.sudin.Entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);

    void remove(Long id);

}

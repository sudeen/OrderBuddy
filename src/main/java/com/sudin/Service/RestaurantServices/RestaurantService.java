package com.sudin.Service.RestaurantServices;

import com.sudin.Entity.RestaurantEntity.Restaurant;

import java.util.List;

public interface RestaurantService {

    void createRestaurant(Restaurant restaurant);

    List<Restaurant> findAll();

//    List<Restaurant> getAllRestaurant(Long id);

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);

    void remove(Long id);
}

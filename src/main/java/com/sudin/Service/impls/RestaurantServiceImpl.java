package com.sudin.Service.impls;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Repository.RestaurantRepository;
import com.sudin.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}

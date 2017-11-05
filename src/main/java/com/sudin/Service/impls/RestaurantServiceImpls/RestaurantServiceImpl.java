package com.sudin.Service.impls.RestaurantServiceImpls;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Pojo.RestaurantPojo;
import com.sudin.Repository.RestaurantRepository.RestaurantRepository;
import com.sudin.Service.RestaurantServices.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = (List<Restaurant>) restaurantRepository.findAll();
        return restaurantList;
    }

//    @Override
//    public List<Restaurant> getAllRestaurant(Long id) {
//
//        List<Restaurant> restaurantList = new ArrayList<>();
//        restaurantRepository.findAll()
//                .forEach(restaurantList::add);
//        return restaurantList;
//
//    }


    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void remove(Long id) {
        restaurantRepository.delete(id);
    }

//    @Override
//    public Restaurant update(RestaurantPojo restaurantPojo) {
//        return restaurantRepository.save(restaurantPojo);
//    }
}

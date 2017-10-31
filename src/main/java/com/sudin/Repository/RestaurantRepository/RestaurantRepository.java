package com.sudin.Repository.RestaurantRepository;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

//    public List<Restaurant> findByContactId(Long contactId);
}

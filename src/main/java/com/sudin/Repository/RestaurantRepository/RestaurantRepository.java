package com.sudin.Repository.RestaurantRepository;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import org.springframework.data.repository.CrudRepository;



public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

//    public List<Restaurant> findByContactId(Long contactId);


}

package com.sudin.Repository;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
}

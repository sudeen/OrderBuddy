package com.sudin.Service.RestaurantServices;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;

import java.util.Set;

public interface ContactService  {

    Contact findById(Long id);

    Contact save(Contact contact, Set<Restaurant> restaurants);

    void remove(Long id);
}

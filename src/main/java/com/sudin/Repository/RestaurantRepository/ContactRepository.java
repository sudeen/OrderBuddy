package com.sudin.Repository.RestaurantRepository;

import com.sudin.Entity.RestaurantEntity.Contact;
import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<Contact, Long> {
//    public Contact findByRestaurantId(Long id);
}

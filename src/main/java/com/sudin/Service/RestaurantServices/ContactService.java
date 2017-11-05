package com.sudin.Service.RestaurantServices;

import com.sudin.Entity.RestaurantEntity.Contact;


public interface ContactService  {


    Contact findById(Long id);

    Contact save(Contact contact);

    void remove(Long id);

}

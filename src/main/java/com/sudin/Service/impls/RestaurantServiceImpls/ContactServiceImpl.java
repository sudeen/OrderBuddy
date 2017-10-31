package com.sudin.Service.impls.RestaurantServiceImpls;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Repository.RestaurantRepository.ContactRepository;
import com.sudin.Repository.RestaurantRepository.RestaurantRepository;
import com.sudin.Service.RestaurantServices.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);


    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public Contact findById(Long id) {
        return null;
    }

    @Override
    public Contact save(Contact contact, Set<Restaurant> restaurants) {
        Contact contact1 = contactRepository.findOne(contact.getId());

        if (contact1 != null) {
            LOG.info("contact {} already exists. Nothing will be done", contact1.getId());
        } else {
            for (Restaurant restaurants1 : restaurants) {
                restaurantRepository.save(restaurants1);
            }
            Restaurant restaurant=new Restaurant();
            restaurant.setContactList(contact);
//            contact.getRestaurant();
            contact1=contactRepository.save(contact);
        }
//        contact.setRestaurant(restaurant);
//        contact1 = contactRepository.save(contact);
//        return contact1;
//        Restaurant restaurant=restaurantRepository.findOne(contact.getRestaurant().getId());
//        Contact contact1=contactRepository.findOne(contact.getRestaurant().getId());
        return contact1;
    }

    @Override
    public void remove(Long id) {
        contactRepository.delete(id);
    }
}

package com.sudin.Controllers.RestaurantControllers;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.RestaurantPojo;
import com.sudin.Repository.RestaurantRepository.ContactRepository;
import com.sudin.Repository.RestaurantRepository.RestaurantRepository;
import com.sudin.Service.RestaurantServices.RestaurantService;
import com.sudin.Service.impls.RestaurantServiceImpls.ContactServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantController.class);


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ContactRepository contactRepository;

    //TO MAKE DEFAULT RESPOND
    private GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(status, message, data);
    }

    @RequestMapping("/findAllRestaurant")
    @ResponseBody
    public List<Restaurant> findAllRestaurant() {
        try {
            return restaurantService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/findRestaurantById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse getRestaurantById(@PathVariable("id") Long id) {
        try {
            return respond("Success", "Successfully loaded", restaurantService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail", "Failed to load", null);
        }
    }

    @RequestMapping(value = "/saveRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse saveRestaurant(@RequestBody RestaurantPojo restaurantPojo) {
        Restaurant restaurant = new Restaurant();
        restaurant.setClosingTime(restaurantPojo.getClosingTime());
        restaurant.setName(restaurantPojo.getName());
        restaurant.setOpeningTime(restaurantPojo.getOpeningTime());
        Contact contact = contactRepository.findOne(restaurantPojo.getContactId());
        restaurant.setContactList(contact);
        if (contact != null) {
            try {
                return respond("Success", "Successfully loaded", restaurantService.save(restaurant));
            } catch (Exception e) {
                e.printStackTrace();
                return respond("Fail", "Failed to load", null);
            }
        } else {
            System.out.println("doesnt exist");
            return respond("Fail", "Failed to load", null);

        }

    }

    @RequestMapping(value = "/deleteRestaurantById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.remove(id);
    }


    @RequestMapping(value = "/updateRestaurant/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateRestaurant(@RequestBody RestaurantPojo restaurantPojo,
                                           @PathVariable("id") Long id) {

        if (restaurantPojo.getContactId() != null) {
            try {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(id);
                restaurant.setName(restaurantPojo.getName());
                restaurant.setOpeningTime(restaurantPojo.getOpeningTime());
                restaurant.setClosingTime(restaurantPojo.getClosingTime());
                Contact contact = contactRepository.findOne(restaurantPojo.getContactId());
                restaurant.setContactList(contact);
                return respond("Success", "Restaurant id " + id + " Updated", restaurantService.save(restaurant));

            } catch (Exception e) {
                e.printStackTrace();
                return respond("Fail", "Failed to Load", null);
            }

        } else {
            LOG.info("Contact Not available");
            return respond("Fail", "Failed to Load", null);
        }

    }

}

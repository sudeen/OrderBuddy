package com.sudin.Controllers;

import com.sudin.Entity.Contact;
import com.sudin.Entity.Restaurant;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.RestaurantPojo;
import com.sudin.Repository.ContactRepository;
import com.sudin.Repository.RestaurantRepository;
import com.sudin.Service.restaurant.RestaurantService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public GlobalResponse findAllRestaurant() {
        try {
            return respond(Constant.SUCCESS_MESSAGE, "Contact List", restaurantService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }
    }

    @RequestMapping(value = "/findRestaurantById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse getRestaurantById(@PathVariable("id") Long id) {
        try {
            return respond(Constant.SUCCESS_MESSAGE, "Successfully loaded", restaurantService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
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
                return respond(Constant.SUCCESS_MESSAGE, "Successfully loaded", restaurantService.save(restaurant));
            } catch (Exception e) {
                e.printStackTrace();
                return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
            }
        } else {
            System.out.println("Does not exist");
            return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }

    }

    @RequestMapping(value = "/deleteRestaurantById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.remove(id);
    }

    @RequestMapping(value = "/updateRestaurant/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateRestaurant(@RequestBody RestaurantPojo restaurantPojo, @PathVariable("id") Long id) {
        Restaurant currentRestaurant = restaurantService.findById(id);
        if (currentRestaurant != null) {
            try {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(id);
                restaurant.setName(BaseUtils.nullValueAlternative(restaurantPojo.getName(), currentRestaurant.getName()));
                restaurant.setOpeningTime(BaseUtils.nullValueAlternative(restaurantPojo.getOpeningTime(), currentRestaurant.getOpeningTime()));
                restaurant.setClosingTime(BaseUtils.nullValueAlternative(restaurantPojo.getClosingTime(), currentRestaurant.getClosingTime()));

                // TODO: 11/5/17 Update multiple contacts??
                Contact contact = contactRepository.findOne(restaurantPojo.getContactId());
                restaurant.setContactList(contact);

                return respond(Constant.SUCCESS_MESSAGE, "Restaurant id " + id + " Updated", restaurantService.save(restaurant));
            } catch (Exception e) {
                e.printStackTrace();
                return respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
            }

        } else {
            return respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

}

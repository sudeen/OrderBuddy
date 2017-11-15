package com.sudin.Controllers;

import com.sudin.Entity.Contact;
import com.sudin.Entity.Dish;
import com.sudin.Entity.Restaurant;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.RestaurantPojo;
import com.sudin.Service.contact.ContactService;
import com.sudin.Service.dish.DishService;
import com.sudin.Service.restaurant.RestaurantService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllRestaurant() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Restaurant List", restaurantService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }
    }

    @RequestMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getRestaurantById(@PathVariable("id") Long id) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Successfully loaded", restaurantService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }
    }

    @RequestMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse saveRestaurant(@RequestBody RestaurantPojo restaurantPojo) {
        if (!restaurantPojo.getName().isEmpty()) {
            Restaurant restaurant = new Restaurant();
            restaurant.setClosingTime(restaurantPojo.getClosingTime());
            restaurant.setName(restaurantPojo.getName());
            restaurant.setOpeningTime(restaurantPojo.getOpeningTime());
            Contact contact = contactService.findById(restaurantPojo.getContactId());
            List<Dish> dish= (List<Dish>) dishService.findByIdList(restaurantPojo.getDishId());
            restaurant.setContact(contact);
            restaurant.setDishList(dish);
            if (contact != null) {
                try {
                    return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Successfully added restaurant", restaurantService.save(restaurant));
                } catch (Exception e) {
                    e.printStackTrace();
                    return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to save restaurant information", null);
                }
            } else {
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to save restaurant information", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to save restaurant information", null);
        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.remove(id);
    }

    @RequestMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
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
                Contact contact = contactService.findById(restaurantPojo.getContactId());
                restaurant.setContact(contact);

                List<Dish> dish= (List<Dish>) dishService.findByIdList(restaurantPojo.getDishId());
//                for (Object d : dish){
//
//                }
                restaurant.setDishList(dish);

                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Restaurant id " + id + " Updated", restaurantService.save(restaurant));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
            }

        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

}

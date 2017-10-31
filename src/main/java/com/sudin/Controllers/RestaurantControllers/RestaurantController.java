package com.sudin.Controllers.RestaurantControllers;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.RestaurantServices.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

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

    @RequestMapping(value = "/saveRestaurant",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse saveRestaurant(@RequestBody Restaurant restaurant){
        try {
            return respond("Success","Successfully loaded",restaurantService.save(restaurant));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail","Failed to load",null);
        }
    }

    @RequestMapping(value = "/deleteRestaurantById/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRestaurant(@PathVariable Long id){
        restaurantService.remove(id);
    }

}

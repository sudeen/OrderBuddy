package com.sudin.Controllers;


import com.sudin.Entity.Dish;
import com.sudin.Pojo.DishPojo;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.category.CategoryService;
import com.sudin.Service.dish.DishService;
import com.sudin.Service.restaurant.RestaurantService;
import com.sudin.Service.variants.VariantService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;


    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllDish() {
        // Not right........
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Dish item List", dishService.findAll());
        } catch (Exception e) {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to load dish", null);
        }
    }

    @RequestMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse saveDish(@RequestBody Dish dish) {
        try {
            return respond(Constant.SUCCESS_MESSAGE, "Dish Saved", dishService.save(dish));
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to save dish", null);
        }
    }

    private GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(status, message, data);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteDish(@PathVariable("id") Long id) {
        dishService.remove(id);
    }


    @RequestMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateDish(@RequestBody DishPojo dishPojo, @PathVariable("id") Long id) {
        Dish currentDish = dishService.findById(id);
        if (currentDish != null) {
            try {
                Dish dish = new Dish();
                dish.setId(id);
                dish.setImageUrl(BaseUtils.nullValueAlternative(dishPojo.getImage(), currentDish.getImageUrl()));
                dish.setIngredients(BaseUtils.nullValueAlternative(dishPojo.getIngredients(), currentDish.getIngredients()));
                dish.setName(BaseUtils.nullValueAlternative(dishPojo.getName(),currentDish.getName()));
                dish.setPrice(BaseUtils.nullValueAlternative(dishPojo.getPrice(),currentDish.getPrice()));
                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Dish " + id + " Updated", dishService.save(dish));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to update Dish", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "No Dish with id " + id + " found", null);
        }
    }


}

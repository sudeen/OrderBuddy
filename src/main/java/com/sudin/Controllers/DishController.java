package com.sudin.Controllers;


import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.category.CategoryService;
import com.sudin.Service.dish.DishService;
import com.sudin.Service.restaurant.RestaurantService;
import com.sudin.Service.variants.VariantService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restaurant/{restaurantId}/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private VariantService variantService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllDish(@PathVariable("restaurantId") Long restaurantId) {
        // Not right........
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Dish item List", dishService.findAll());
        } catch (Exception e) {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to load dish", null);
        }
    }

}

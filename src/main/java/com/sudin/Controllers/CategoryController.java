package com.sudin.Controllers;

import com.sudin.Entity.Category;
import com.sudin.Pojo.CategoryPojo;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.category.CategoryService;
import com.sudin.Service.menu.MenuService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllCategory() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "All category", categoryService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getCategoryById(@PathVariable("id") Long categoryId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Category Id " + categoryId, categoryService.findById(categoryId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Category not found", null);
        }
    }

    @RequestMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addCategory(@RequestBody Category category) {
        return BaseUtils.respond(Constant.ERROR_MESSAGE, "Module not added", null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.remove(id);
    }

    @RequestMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateCategory(@RequestBody CategoryPojo categoryPojo, @PathVariable("id") Long id) {
        Category currentCategory = categoryService.findById(id);
        if (currentCategory != null) {
            try {
                Category category = new Category();
                category.setId(id);
                category.setName(BaseUtils.nullValueAlternative(categoryPojo.getName(), currentCategory.getName()));

                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Category " + id + " Updated", categoryService.save(category));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to update category", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "No category with id " + id + " found", null);
        }
    }
}

package com.sudin.Controllers;

import com.sudin.Entity.Variants;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.VariantPojo;
import com.sudin.Service.variants.VariantService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/variant")
public class VariantController {

    @Autowired
    VariantService variantService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllVariant() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "All variants", variantService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getVariantById(@PathVariable("id") Long variantId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Variants Id " + variantId, variantService.findById(variantId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Variants not found", null);
        }
    }

    @RequestMapping(value = "/add/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addVariant(@RequestBody Variants variant, @PathVariable("id") Long menuId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Successfully added Contact", variantService.save(variant));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to create variant.", null);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteVariant(@PathVariable("id") Long id) {
        variantService.remove(id);
    }

    @RequestMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateVariant(@RequestBody VariantPojo variantPojo, @PathVariable("id") Long id) {
        Variants currentVariants = variantService.findById(id);
        if (currentVariants != null) {
            try {
                Variants variants = new Variants();
                variants.setId(id);
                variants.setName(BaseUtils.nullValueAlternative(variantPojo.getName(), currentVariants.getName()));

                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Variants " + id + " Updated", variantService.save(variants));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to update variant", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "No variant with id " + id + " found", null);
        }
    }
}

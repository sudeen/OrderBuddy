package com.sudin.Controllers;

import com.sudin.Entity.Tables;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.TablePojo;
import com.sudin.Service.restaurant.RestaurantService;
import com.sudin.Service.table.TableService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    TableService tableService;

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public GlobalResponse findAllTable() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "All tables", tableService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getTableById(@PathVariable("id") Long tableId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Tables Id " + tableId, tableService.findById(tableId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Tables not found", null);
        }
    }

    @RequestMapping(value = "/add/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addTable(@RequestBody Tables table, @PathVariable("id") Long restaurantId) {
        return BaseUtils.respond(Constant.ERROR_MESSAGE, "Module not added", null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTable(@PathVariable("id") Long id) {
        tableService.remove(id);
    }

    @RequestMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateTable(@RequestBody TablePojo tablePojo, @PathVariable("id") Long id) {
        Tables currentTables = tableService.findById(id);
        if (currentTables != null) {
            try {
                Tables tables = new Tables();
                tables.setId(id);
                tables.setName(BaseUtils.nullValueAlternative(tablePojo.getName(), currentTables.getName()));
                tables.setCapacity(BaseUtils.nullValueAlternative(tablePojo.getCapacity(), currentTables.getCapacity()));

                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Tables " + id + " Updated", tableService.save(tables));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to update table", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "No table with id " + id + " found", null);
        }
    }
}

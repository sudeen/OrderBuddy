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

    @RequestMapping(value = "/findAllTable")
    @ResponseBody
    public GlobalResponse findAllTable() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "All tables", tableService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/addTable/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addTable(@RequestBody Tables Tables, @PathVariable("id") Long restaurantId) {
        return BaseUtils.respond(Constant.ERROR_MESSAGE, "Module not added", null);
    }

    @RequestMapping(value = "/deleteTable/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTable(@PathVariable Long id) {
        tableService.remove(id);
    }

    @RequestMapping(value = "/findTable/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getTableById(@PathVariable("id") Long TableId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Tables Id " + TableId, tableService.findById(TableId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Tables not found", null);
        }
    }

    @RequestMapping(value = "/updateTable/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateTable(@RequestBody TablePojo tablePojo, @PathVariable("id") Long id) {
        Tables currentTables = tableService.findById(id);
        if (currentTables != null) {
            try {
                Tables tables = new Tables();
                tables.setId(id);
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

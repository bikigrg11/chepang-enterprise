package com.example.sbu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Item {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/addNewItem", method = RequestMethod.POST)
    String registerUser(@RequestParam("product_id") int item_id_get,
                        @RequestParam("product_name") String item_name_get,
                        @RequestParam("product_categorie") String category_get ,
                        @RequestParam("available_quantity") int quantity_get,
                        @RequestParam("product_price") int price_get,
                        @RequestParam("product_description") String desc_get
//                        @RequestParam("filebutton") byte image_get
    ) {
        jdbcTemplate.batchUpdate("INSERT INTO chepangdb.Items (item_id , item_name, category, quantity, price, description) " +
                "VALUES('"+ item_id_get +"','"+ item_name_get +"', '"+ category_get+"','"+quantity_get+"', '"+ price_get +"', '"+ desc_get+"');");



        return "redirect:/getAddItemPage";
    }

    @RequestMapping(value="/deleteItem", method = RequestMethod.POST)
    String delItems(@RequestParam("product_id") int item_id_get,
                        @RequestParam("product_name") String item_name_get
    ) {
        String DELETE = " DELETE FROM chepangdb.Items WHERE item_id=?";
        jdbcTemplate.update(DELETE, item_id_get);
        return "redirect:/getDeleteItemPage";
    }

}

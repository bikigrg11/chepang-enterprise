package com.example.sbu.Controllers;

import com.example.sbu.model.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class cart {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/cartpost", method = RequestMethod.GET)
    String cartProcess(@RequestParam("user") String id) {
        String sql = "SELECT * FROM chepangdb.Cart WHERE userid='" + id+ "';";

        List<UserCart> userCarts = new ArrayList<UserCart>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            UserCart carts = new UserCart();
            carts.setItemId((Integer) row.get("ItemId"));
            carts.setItemQuantity((Integer) row.get("Quantity"));
            carts.setItemPrice((Integer) row.get("Price"));
            userCarts.add(carts);
        }

//        for(UserCart list:userCarts){
//            System.out.print("Item Id :"+list.getItemId());
//            System.out.print(" Price :"+list.getItemPrice());
//            System.out.print(" Quantity :"+list.getItemQuantity());
//            System.out.println();
//        }

        //ModelAndView model = new ModelAndView("cart");
       // model.addObject("userCart", userCarts);
        return "cart";
    }


}

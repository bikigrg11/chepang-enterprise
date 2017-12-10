package com.example.sbu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class admin {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/adminpage", method = RequestMethod.GET)
    String getAdminPage() {
        return  "admin";
    }

    @RequestMapping(value="/adminViewWeb", method = RequestMethod.GET)
    String getViewStore() {
        return  "chepang";
    }

    @RequestMapping(value="/getAddItemPage", method = RequestMethod.GET)
    String getAddItemPage() {
        return  "item";
    }

    @RequestMapping(value="/getDeleteItemPage", method = RequestMethod.GET)
    String getDeleteItemPage() {
        return  "itemDelete";
    }

    @RequestMapping(value="/adminLogin", method = RequestMethod.POST)
    String getAdminLogin() {
        return  "redirect:/viewnext?user=1";
    }


}

package com.example.sbu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class shipping {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/payinfo", method = RequestMethod.POST)
    String registerUser(@RequestParam("country") String country,
                        @RequestParam("first_name") String firstName,
                        @RequestParam("last_name") String lastName,
                        @RequestParam("user_given") String user_id_given,
                        @RequestParam("address") String address,
                        @RequestParam("city") String city,
                        @RequestParam("state") String state,
                        @RequestParam("zip_code") String zipCode,
                        @RequestParam("phone_number") String phone,
                        @RequestParam("email_address") String email,
                        @RequestParam("CreditCardType") String creditype,
                        @RequestParam("car_number") String cardnumber,
                        @RequestParam("car_code") String cardcode,
                        @RequestParam("exp_month") String expmonth,
                        @RequestParam("exp_year") String year)

    {
        jdbcTemplate.batchUpdate("INSERT INTO chepangdb.Shipping " +
                "(FirstName, LastName, Country, Address, City, State, ZipCode, PhoneNumber, Email, user_id) " +
                "VALUES('"+ firstName+"', '"+ lastName+"', '"+ country+"', '"+ address+"', '"+ city +"', '"+ state+"', '"+ zipCode+"', '"+ phone+"', '"+ email+"', '"+user_id_given+"');");

        jdbcTemplate.batchUpdate("INSERT INTO chepangdb.Payment " +
                "(CardType, CardNumber, CardCVV, Year, month, user_id) " +
                "VALUES('"+ creditype+"', '"+ cardnumber+"', '"+ cardcode+"', '"+ expmonth+"', '"+ year+"', '"+user_id_given+"');");

        return "redirect:/";
    }
}

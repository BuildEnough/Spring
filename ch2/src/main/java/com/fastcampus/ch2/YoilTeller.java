package com.fastcampus.ch2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class YoilTeller {
    @RequestMapping("/getYoil")
    public String main(HttpServletRequest request) {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        return "Monday";
    }
}

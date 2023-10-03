package com.buildenough.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {

        char yoil = getYoil(myDate);

        return "yoil";
    }

    @ModelAttribute("yoil")
    private char getYoil(MyDate mydate) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(mydate.getYear(), mydate.getMonth()-1, mydate.getDay());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
        return yoil;
    }
}

package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/yoil")
    public ModelAndView main(int year, int month, int day) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("yoilError");

        if (!isVaild(year, month, day)) {
            return mv;
        }

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);

        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        mv.setViewName("yoil");

        return mv;
    }

    private boolean isVaild(int year, int month, int day) {
        return true;
    }
}

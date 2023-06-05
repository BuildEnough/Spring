package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
@Controller
public class YoilTeller {
    @RequestMapping("/yoil")
//    public void main(String year, String month, String day, HttpServletResponse response) throws IOException {
//    public String main(int year, int month, int day, Model model) throws IOException {
    public ModelAndView main(int year, int month, int day) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("yoilError");

        if (!isValid(year, month, day)) {
            return mv; // 사용자가 요청한 날짜가 유효하지 않으면 yoilError를 보여준다
        }

        // 2. 작업 - 요일 계산
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
        cal.clear(); // cal의 모든 필드를 초기화
        cal.set(year, month - 1, day); // 월(mm)은 0부터 11이기 때문에 1을 빼줘야 함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7 반환, 1:일요일, 2: 월요일 ...
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); // 1~7 -> 0~6

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        mv.setViewName("yoil"); // yoil.html

        return mv;
//        return "yoil"; // yoil.html - 뷰의 이름을 반환

    }

    private boolean isValid(int year, int month, int day) {
        return true;
    }
}

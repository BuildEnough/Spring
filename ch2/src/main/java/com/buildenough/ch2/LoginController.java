package com.buildenough.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;

@RequestMapping("/login")
@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, String id, String pwd, RedirectAttributes model) throws IOException {
        if(loginCheck(id, pwd)) {
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);
            return "userInfo";
        } else {
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg", "일회용 메시지");
            req.setAttribute("msg", "request에 저장된 msg");

            return "redirect:/";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}

package edu.poly.asm_java6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    @RequestMapping("/security/login/form")
    public String loginForm(Model model) {
        model.addAttribute("message", "Vui lòng đăng nhập!");
        return "account/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "Đăng nhập thành công!");
        return "account/login";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "account/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoff(Model model) {
        model.addAttribute("message", "Đăng xuất thành công!");
        return "account/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", "Bạn không có quyền truy xuất!");
        return "account/login";
    }
}

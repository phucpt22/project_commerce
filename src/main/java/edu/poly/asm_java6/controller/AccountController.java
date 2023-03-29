package edu.poly.asm_java6.controller;

import edu.poly.asm_java6.entities.NguoiDung;
import edu.poly.asm_java6.reponsitory.NguoiDungRepository;
import edu.poly.asm_java6.service.CookieService;
import edu.poly.asm_java6.service.ParamService;
import edu.poly.asm_java6.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    NguoiDungRepository ndDAO;

    @RequestMapping("/login")
    public String getLogin() {
        return "";
    }
    @RequestMapping("/te")
    public String getLogin2() {
        return "";
    }
    @RequestMapping("/register")
    public String getRegister() {
        return "";
    }
    @RequestMapping("/user/id_kh={id}")
    public String findUserById(@PathVariable("id") Integer id_kh, Model model)
    {
        for (int i = 0; i < ndDAO.findAll().size(); i++) {
            if (ndDAO.findAll().get(i).getId_NguoiDung() == id_kh) {
                NguoiDung nd = ndDAO.findAll().get(i);
                model.addAttribute("nd", nd);
            }
        }
        return "";
    }

    @SuppressWarnings("unused")
    @PostMapping("/login")
    public String login(@RequestParam (required = false, name = "remember") boolean rem) {
        String message = "";

        // Đọc các tham số từ form login (username, password, remember)
        String username = paramService.getString("your_name", "");
        String password = paramService.getString("your_pass", "");

        // So khớp thông tin đăng nhập với dữ liệu hệ thống
        NguoiDung user = ndDAO.findUser(username);
        String userT = user.getTenTK();
        String passT = user.getMatKhau();

        // nếu tìm được người dùng có trong hệ thống thì đăng nhập thành công
        if (user != null) {
            if (userT.equals(username) && passT.equals(password)) {
                // Set tên người dùng vào cookie lưu giữ 1 ngày
                sessionService.set("user", user);

                // Ghi nhớ tài khoản vào cookie lưu giữ 1 ngày khi check remember
                if (rem) {
                    cookieService.add("taikhoan", user.getTenTK(), 1);
                    cookieService.add("matkhau", user.getMatKhau(), 1);
                }else {
                    cookieService.remove("taikhoan");
                    cookieService.remove("matkhau");
                }

                String uri = sessionService.get("security-uri");
                if (uri != null) {
                    return "redirect:" + uri;
                }else {
                    return "redirect:/ds-sanpham";
                }
            }else {
                message = "Tài khoản hoặc mật khẩu không đúng!";
                request.setAttribute("message", message);
                return "";
            }
        }else {
            message = "Tài khoản này không tồn tại. Vui lòng bạn kéo lên để đăng ký!";
            request.setAttribute("message", message);
            return "";
        }

    }

    @PostMapping("/register")
    public String register(@RequestParam(required = false, name = "agree") boolean chkAgree,
                           NguoiDung nd) {
        // Đọc các tham số từ form sign up (username, email, password, repeat pass, check agree)
        String re_pass = paramService.getString("repass", "");
        // Kiểm tra đồng ý các điều khoản
        if (chkAgree) {
            if (nd.getMatKhau().equals(re_pass)) {
                nd.setHoTen("NoName");
                ndDAO.save(nd);
                request.setAttribute("messageS", "Đăng ký thành công bạn có thể đăng nhập ngay bây giờ!");

            }else {
                request.setAttribute("messageS", "Mật khẩu và nhập lại mật khẩu không trùng khớp!");
            }
        }else {
            request.setAttribute("messageS", "Bạn chưa đồng ý với các điều khoản mà chúng tôi đưa ra!");
        }
        return "redirect:/ds-sanpham";
    }

    @RequestMapping("/logout")
    public String getLogout() {
        sessionService.remove("user");
        String taikhoanRmb = cookieService.getValue("taikhoan");
        String matkhauRmb = cookieService.getValue("matkhau");
        System.out.println(taikhoanRmb);
        System.out.println(matkhauRmb);
        request.setAttribute("taikhoanLuu", taikhoanRmb);
        request.setAttribute("matkhauLuu", matkhauRmb);

        return "redirect:/login";
    }
}

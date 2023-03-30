package edu.poly.asm_java6.controller;

import edu.poly.asm_java6.entities.ChatLieu;
import edu.poly.asm_java6.entities.ChungLoai;
import edu.poly.asm_java6.entities.ThuongHieu;
import edu.poly.asm_java6.reponsitory.*;
import edu.poly.asm_java6.service.CartService;
import edu.poly.asm_java6.service.SanPhamService;
import edu.poly.asm_java6.service.SessionService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    SanPhamRepository dao;

    @Autowired
    ChatLieuRepository cldao;
    @Autowired
    ChungLoaiRepository cloaidao;
    @Autowired
    ThuongHieuRepository thdao;

    @Autowired
    NguoiDungRepository adao;

    @Autowired
    NguoiDungRepository accountService;

    @Autowired
    SanPhamService productService;

    @Autowired
    SessionService session;

    @Autowired
    ServletContext app;

    @Autowired
    CartService cart;

    @RequestMapping("/contact")
    public String contact() {
        return "";
    }

//    @RequestMapping("/index")
//    public String home(Model model, @RequestParam(name = "name", defaultValue = "") String name,
//                       @RequestParam(name = "page") Optional<Integer> page) {
//        model.addAttribute("items", productService.findAll(page.orElse(0), 8));
//        model.addAttribute("product", dao.countAllProduct());
//        model.addAttribute("account", adao.countAllAccount());
//        model.addAttribute("countcart", cart.getCount());
//        return "user/index";
//    }

    @GetMapping("/shop")
    public String shop(Model model, @RequestParam(name = "page") Optional<Integer> page,
                       @RequestParam(name = "field", defaultValue = "") String field) {
        if (field.equals("")) {
            model.addAttribute("items", productService.findAll(page.orElse(0), 9));
        } else {
            model.addAttribute("items", productService.findByField(page.orElse(0), 9, field, ""));
        }
        List<ThuongHieu> list1 = thdao.findAll();
        List<ChatLieu> list2 = cldao.findAll();
        List<ChungLoai> list3 = cloaidao.findAll();
        model.addAttribute("thieu", list1);
        model.addAttribute("clieu", list2);
        model.addAttribute("cloai", list3);
        model.addAttribute("product", dao.countAllProduct());
        model.addAttribute("countcart", cart.getCount());
        return "";
    }

}

package edu.poly.asm_java6.controller;

import edu.poly.asm_java6.entities.SanPham;
import edu.poly.asm_java6.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    SanPhamService productService;

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        SanPham item = productService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<Integer> cid) {
        List<SanPham> list;
        if (cid.isPresent()) {
            list= productService.findByIDChungLoai(cid.get());
        }else {
            list = productService.findAll();
        }
        model.addAttribute("items1", list);
        return "product/list_product";
    }

}

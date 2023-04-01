package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.SanPham;
import edu.poly.asm_java6.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class SanPhamRestController {
    @Autowired
    SanPhamService productService;

    @GetMapping("")
    public List<SanPham> getAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public SanPham getOne(@PathVariable("id")Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    public SanPham create(@RequestBody SanPham product ) {
        return productService.create(product);
    }

    @PutMapping("{id}")
    public SanPham update(@PathVariable("id")Integer id,@RequestBody SanPham product ) {
        return productService.update(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id) {
        productService.delete(id);
    }
}

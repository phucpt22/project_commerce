package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.ChungLoai;
import edu.poly.asm_java6.service.ChungLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class ChungLoaiRestController {
    @Autowired
    ChungLoaiService categoryService;

    @GetMapping
    public List<ChungLoai> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public ChungLoai getOne(@PathVariable("id")Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ChungLoai creat(@RequestBody ChungLoai category ) {
        return categoryService.create(category);
    }

    @PutMapping("{id}")
    public ChungLoai update(@PathVariable("id")String id,@RequestBody ChungLoai category ) {
        return categoryService.update(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id) {
        categoryService.delete(id);
    }
}

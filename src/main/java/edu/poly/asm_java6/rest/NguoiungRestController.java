package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.NguoiDung;
import edu.poly.asm_java6.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/NguoiDungs")
public class NguoiungRestController {
    @Autowired
    NguoiDungService NguoiDungService;

    @GetMapping("/all")
    public List<NguoiDung> getAll() {
        return NguoiDungService.findAll();
    }

    @GetMapping("{id}")
    public NguoiDung getOne(@PathVariable("id")Integer id) {
        return NguoiDungService.findById(id);
    }

    @PostMapping
    public NguoiDung creat(@RequestBody NguoiDung NguoiDung ) {
        return NguoiDungService.create(NguoiDung);
    }

    @PutMapping("{id}")
    public NguoiDung update(@PathVariable("id")String id,@RequestBody NguoiDung NguoiDung ) {
        return NguoiDungService.update(NguoiDung);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id) {
        NguoiDungService.delete(id);
    }

}

package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.VaiTro;
import edu.poly.asm_java6.service.VaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class VaiTroRestController {
    @Autowired
    VaiTroService roleService;

    @GetMapping
    public List<VaiTro> getAll() {
        return roleService.findAll();
    }
}

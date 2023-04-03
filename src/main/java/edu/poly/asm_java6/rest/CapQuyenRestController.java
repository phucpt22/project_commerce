package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.CapQuyen;
import edu.poly.asm_java6.service.CapQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class CapQuyenRestController {
    @Autowired
    CapQuyenService authorityService;

    @GetMapping
    public List<CapQuyen> findAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return authorityService.findAuthoritiesOfAdministrators();
        }
        return authorityService.findAll();
    }

    @PostMapping
    public CapQuyen creat(@RequestBody CapQuyen authority ) {
        return authorityService.create(authority);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id) {
        authorityService.delete(id);
    }
}

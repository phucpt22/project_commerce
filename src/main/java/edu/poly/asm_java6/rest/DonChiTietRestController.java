package edu.poly.asm_java6.rest;

import com.fasterxml.jackson.databind.JsonNode;
import edu.poly.asm_java6.entities.DonDatChiTiet;
import edu.poly.asm_java6.entities.DonDatHang;
import edu.poly.asm_java6.service.DonHangChiTietService;
import edu.poly.asm_java6.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DonChiTietRestController {
    @Autowired
    DonHangChiTietService orderDetailService;

    @GetMapping("/rest/orderdetailall")
    public List<DonDatChiTiet> findAll() {
        return orderDetailService.findAll();
    }
}

package edu.poly.asm_java6.rest;

import com.fasterxml.jackson.databind.JsonNode;
import edu.poly.asm_java6.entities.DonDatHang;
import edu.poly.asm_java6.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DonHangRestController {
    @Autowired
    DonHangService orderService;

    @PostMapping("/rest/orders")
    public DonDatHang create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }

    @GetMapping("/rest/ordersall")
    public List<DonDatHang> findAll() {
        return orderService.findAll();
    }
}

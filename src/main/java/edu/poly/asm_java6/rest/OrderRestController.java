package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.Order;
import edu.poly.asm_java6.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderRestController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/rest/orders")
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
	
	@GetMapping("/rest/ordersall")
	public List<Order> findAll() {
		return orderService.findAll();
	}
}

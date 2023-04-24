package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.OrderDetail;
import edu.poly.asm_java6.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderDetailRestController {
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/rest/orderdetailall")
	public List<OrderDetail> findAll() {
		return orderDetailService.findAll();
	}

	@GetMapping("/rest/orderdetailall/{orderid}")
	public List<OrderDetail> findAllByOrderId(@PathVariable("orderid")Integer id) {
		return orderDetailService.getOrderDetailByOrdOrderById(id);
	}
}

package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
	List<OrderDetail> findAll();
	List<OrderDetail> getOrderDetailByOrdOrderById(Integer orderId);

}

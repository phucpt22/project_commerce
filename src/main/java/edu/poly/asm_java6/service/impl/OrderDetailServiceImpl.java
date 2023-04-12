package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.OrderDetailDAO;
import edu.poly.asm_java6.entities.OrderDetail;
import edu.poly.asm_java6.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrdOrderById(Integer orderId) {
		return orderDetailDAO.findOrderDetailByOrdOrderById(orderId);
	}


}

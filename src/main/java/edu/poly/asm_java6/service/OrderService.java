package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();

}

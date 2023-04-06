package edu.poly.asm_java6.dao;

import edu.poly.asm_java6.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}

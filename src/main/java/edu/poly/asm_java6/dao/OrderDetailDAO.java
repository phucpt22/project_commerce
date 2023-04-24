package edu.poly.asm_java6.dao;

import edu.poly.asm_java6.entities.OrderDetail;
import edu.poly.asm_java6.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
    @Query("SELECT p FROM OrderDetail p WHERE p.order.id = ?1")
    List<OrderDetail> findOrderDetailByOrdOrderById(Integer cid);
}

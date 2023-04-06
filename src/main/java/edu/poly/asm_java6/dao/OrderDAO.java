package edu.poly.asm_java6.dao;

import edu.poly.asm_java6.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
	@Query("SELECT o FROM Order o Where o.account.username=?1")
	List<Order> findByUsername(String username);

}

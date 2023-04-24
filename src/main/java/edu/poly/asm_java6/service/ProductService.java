package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);
	List<Product> findByPrice(double min, double max);
	List<Product> findByName(String name);

}

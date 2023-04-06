package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.ProductDAO;
import edu.poly.asm_java6.entities.Product;
import edu.poly.asm_java6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productDAO.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return productDAO.getByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		return productDAO.save(product);
	}

	@Override
	public Product update(Product product) {
		return productDAO.save(product);
	}

	@Override
	public void delete(Integer id) {
		productDAO.deleteById(id);
	}

	@Override
	public List<Product> findByPrice(double min, double max) {
		return productDAO.findByPrice(min,max);
	}

	@Override
	public List<Product> findByName(String name) {
		return productDAO.findSanPhamByName(name);
	}


}

package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.CategoryDAO;
import edu.poly.asm_java6.entities.Category;
import edu.poly.asm_java6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category findById(String id) {
		return categoryDAO.findById(id).get();
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.save(category);
	}

	@Override
	public void delete(String id) {
		categoryDAO.deleteById(id);
	}
}

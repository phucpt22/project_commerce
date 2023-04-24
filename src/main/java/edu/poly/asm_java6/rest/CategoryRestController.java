package edu.poly.asm_java6.rest;

import edu.poly.asm_java6.entities.Category;
import edu.poly.asm_java6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAll() {
// test
		return categoryService.findAll();
	}
	
	@GetMapping("{id}")
	public Category getOne(@PathVariable("id")String id) {
		return categoryService.findById(id);
	}
	
	@PostMapping
	public Category creat(@RequestBody Category category ) {
		return categoryService.create(category);
	}
	
	@PutMapping("{id}")
	public Category update(@PathVariable("id")String id,@RequestBody Category category ) {
		return categoryService.update(category); 
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")String id) {
		categoryService.delete(id);  
	}
}

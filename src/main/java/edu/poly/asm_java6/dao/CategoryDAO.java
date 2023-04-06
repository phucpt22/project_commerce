package edu.poly.asm_java6.dao;

import edu.poly.asm_java6.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, String> {

}

package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.Authority;

import java.util.List;

public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();
	
	public Authority create(Authority auth);
	
	public void delete(Integer id);
}

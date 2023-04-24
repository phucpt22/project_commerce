package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.RoleDAO;
import edu.poly.asm_java6.entities.Role;
import edu.poly.asm_java6.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDAO roleDAO;
	
	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

}

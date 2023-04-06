package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.AuthorityDAO;
import edu.poly.asm_java6.entities.Account;
import edu.poly.asm_java6.entities.Authority;
import edu.poly.asm_java6.service.AccountService;
import edu.poly.asm_java6.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityDAO authorityDAO;
	@Autowired
	AccountService accountService;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountService.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return authorityDAO.save(auth);
	}

	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}

}

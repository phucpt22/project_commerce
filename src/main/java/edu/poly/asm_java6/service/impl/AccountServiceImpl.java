package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dao.AccountDAO;
import edu.poly.asm_java6.entities.Account;
import edu.poly.asm_java6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return accountDAO.getAdministrators();
	}

	@Override
	public Account findById(String id) {
		return accountDAO.findById(id).get();
	}

	@Override
	public Account create(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public Account update(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public void delete(String id) {
		accountDAO.deleteById(id);
	}

}

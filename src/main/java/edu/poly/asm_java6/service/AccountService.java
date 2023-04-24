package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.Account;

import java.util.List;

public interface AccountService {

	List<Account> findAll();

	List<Account> getAdministrators();

	Account findById(String id);

	Account create(Account account);

	Account update(Account account);

	void delete(String id);

}

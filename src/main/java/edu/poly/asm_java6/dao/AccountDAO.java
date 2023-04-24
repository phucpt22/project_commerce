package edu.poly.asm_java6.dao;

import edu.poly.asm_java6.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
	
	@Query("SELECT a FROM Account a WHERE a.fullname = ?1")
	Account findByFullname(String username);

}

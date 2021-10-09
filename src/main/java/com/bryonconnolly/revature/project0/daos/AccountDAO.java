package com.bryonconnolly.revature.project0.daos;


import java.util.List;

import com.bryonconnolly.revature.project0.models.Account;


public interface AccountDAO {
	
	public List<Account> findAll();
	public Account findByUsername(String username);
	public boolean updateAccount(Account account);
	public boolean addAccount(Account account);
	

}

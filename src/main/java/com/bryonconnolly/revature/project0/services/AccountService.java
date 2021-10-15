package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.MDC;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bryonconnolly.revature.project0.daos.AccountDAO;
import com.bryonconnolly.revature.project0.daos.AccountDAOImplementation;
import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.utils.ANSI_Escape_Sequence;
import com.bryonconnolly.revature.project0.models.Account;

public class AccountService {
	
	// Setup and begin Logging
	private static final String CLASS_NAME 			= AccountService.class.getName();
	private static final String CLASS_SIMPLE_NAME 	= AccountService.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	

	private static AccountDAO accountDAO = new AccountDAOImplementation();
	

	public Account createNewAccount(String username, String encoded_password, String preferred_name/*,Element element*/) {

		if(accountDAO.findByUsername(username)!= null) {
			System.out.println("Sorry that username is already taken");
			return null;
		}else {
			System.out.println("Great choice! (i.e. the username "+username+" is available)");
			System.out.print(ANSI_Escape_Sequence.GREEN.code);
			System.out.println("Please hold on for a moment while your account is being created...");
			System.out.print(ANSI_Escape_Sequence.RESET.code);
		}
		
		Account account = new Account();
		account.setUsername(username);
		account.setEncodedPassword(encoded_password);
		if(preferred_name!=null)account.setPreferredName(preferred_name);
		account.setTickets(0);			//this could be left as default as well
		account.setAdmin(false);		//this could be left as default as well
		
		System.out.println("Almost done...");
		
		accountDAO.addAccount(account);
		
		System.out.print(ANSI_Escape_Sequence.GREEN_BRIGHT.code);
		System.out.println("It is done.");
		System.out.print(ANSI_Escape_Sequence.RESET.code);	
		
		return account;
	}

	//--for administration?---------------------------------------------
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> allAccounts = (ArrayList<Account>) accountDAO.findAll();
		return allAccounts;
	}
	
	//--for administration?---------------------------------------------
	public ArrayList<Account> getAccountsHavingTickets() {
		ArrayList<Account> accounts = (ArrayList<Account>) accountDAO.findAll();
		for(int i=0; i<accounts.size(); i++)
			if(accounts.get(i).getTickets()<=0)
				accounts.remove(i);
		return accounts;
	}
	
	public Account logIn(String username, String password) {
		Account account = accountDAO.findByUsername(username);
		if(checkPassword(account,password)) {
			log.info("Log in by "+account);
			System.out.println("Hello "+account.getPreferredName());
			return account;
		}else {
			System.out.println("incorrect username or password");
			return  null;
		}
	}

	boolean checkPassword(Account account, String password) {
		
		log.debug("account.getEncodedPassword() = "+account.getEncodedPassword());
		log.debug("parameter arg password is : "+password);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
				
		if(encoder.matches(password, account.getEncodedPassword()))
			return true;
		else {
			System.out.println("password does not match");
			return false;
		}
	}//end checkPassword
	
	public void save(Account account) {
		accountDAO.updateAccount(account);
	}

	public void addTickets(Account account, int number_to_add) {
		account.addTickets(number_to_add);
		accountDAO.updateAccount(account);
	}
	
	public void addTickets(String username, int number_to_add) {
		Account account = accountDAO.findByUsername(username);
		account.addTickets(number_to_add);
		save(account);
	}

	public void takeTickets(String username, int number_to_take) {
		Account account = accountDAO.findByUsername(username);
		account.takeTickets(number_to_take);
		save(account);
	}
	
	public void promote(String username) {
		Account account = accountDAO.findByUsername(username);
		account.setAdmin(true);
		save(account);
	}

	public void demote(String username) {
		Account account = accountDAO.findByUsername(username);
		account.setAdmin(false);
		save(account);
	}
	
	
	public void setPassword(Account account, String raw_password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		account.setEncodedPassword(encoder.encode(raw_password));
		save(account);
	}
	
	
	
}//end class AccountService

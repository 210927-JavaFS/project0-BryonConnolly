package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.MDC;
import org.slf4j.MDC;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.daos.AccountDAO;
import com.bryonconnolly.revature.project0.daos.AccountDAOImplementation;
import com.bryonconnolly.revature.project0.models.Element;
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
		}
		
		
		Account account = new Account();
		account.setUsername(username);
		account.setEncodedPassword(encoded_password);
		if(preferred_name!=null)account.setPreferredName(preferred_name);
		account.setTickets(0);			//this could be left as default as well
		account.setAdmin(false);		//this could be left as default as well
		
/****		
		switch(element) {
			case NORMAL:
//				weapon.setName("Longsword");
				break;
			case ARCANE:
//				weapon.setName("Arcane bolt");
				break;
			case HOLY:
//				weapon.setName("Holy Word");
				break;
			case FIRE:
//				weapon.setName("Flaming Dagger");
				break;
			case ICE:
//				weapon.setName("Icicle");
				break;
			case THUNDER:
//				weapon.setName("Lightning Rod");
				break;
			case LIGHT:
//				weapon.setName("Light Sabre");
				break;
			case DARK:
//				weapon.setName("Void Blade");
				break;
			case POISON:
//				weapon.setName("Poisoned Dart");
				break;
			case ACID:
//				weapon.setName("Acid Vial");
				break;
			case WATER:
//				weapon.setName("Bucket");
				break;
			default:
//				weapon.setName("Longsword");
				break;
			
		}
		******/
		
		return account;
	}

	/**********************
	//TODO change drinks to drink coupons
	public void buyDrinks(Account account, int purchase) {
		account.setTickets(account.getTickets()-(purchase*25));//TODO fix this to Constant for Drinks prices
	//	account.setDrinks(account.getDrinks()+purchase);
		log.debug(account.getUsername()+" bought "+purchase+" drinks.");
	}

	public void drinkPotions(Account account, int potions) {//TODO change to use drink coupon
		for(int i =0; i<potions; ++i) {
			System.out.println("You quaff a potion");
	//		player.setPotions(player.getPotions()-1);
	//		account.setCurrentHealth((int) (account.getCurrentHealth()+((Math.random()*account.getMaxHealth())/3)+1));
	//		System.out.println("Your current health is now "+player.getCurrentHealth()+" of a "
	//				+ "maximum of "+drinks      .getMaxHealth());
		}
	}
	**********************/

	public void save(Account account) {
		accountDAO.updateAccount(account);
		
	}

	public ArrayList<Account> getPreviousAccounts() {
		ArrayList<Account> allAccounts = (ArrayList<Account>) accountDAO.findAll();
	/*	for(int i =0; i<allPlayers.size(); ++i) {
			if(allPlayers.get(i).getCurrentTickets)<=0) {
				allPlayers.remove(i);
			}
		}
		*/
		return allAccounts;

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

	private boolean checkPassword(Account account, String password) {
		
		log.debug("account.getEncodedPassword() = "+account.getEncodedPassword());
		log.debug("parameter arg password is : "+password);
		
		
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		
		
		if(encoder.matches(password, account.getEncodedPassword()))
			return true;
		else {
			System.out.println("password does not match");
			return false;
		}
	}

}

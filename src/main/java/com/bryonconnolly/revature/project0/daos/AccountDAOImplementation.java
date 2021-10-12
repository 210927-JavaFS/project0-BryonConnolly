package com.bryonconnolly.revature.project0.daos;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.services.AccountService;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AccountDAOImplementation extends DAO implements AccountDAO {

	// Setup and begin Logging
	private static final String CLASS_NAME 			= AccountDAOImplementation.class.getName();
	private static final String CLASS_SIMPLE_NAME	= AccountDAOImplementation.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	@Override
	public List<Account> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM accounts;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			while(result.next()) {
				Account account = new Account();
				account.setUsername(result.getString("username"));
				account.setPassword(result.getString("password"));//TODO non plain text passwords
				account.setTickets(result.getInt("tickets"));
				account.setAdmin(result.getBoolean("is_admin"));
				account.setPreferedName("preferred_name");
				list.add(account);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findByUsername(String username) {
		
		//log.debug("In the findByUsername(String) method of an AccountDAOImplementation object.");
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			
			//log.debug("...and now in the try-with-resources block");
			
			String sql = "SELECT * FROM accounts WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			
			Account account = new Account();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			if(result.next()) {
				
				account.setUsername(result.getString("username"));
				account.setPassword(result.getString("password"));//TODO non plain text passwords
				account.setTickets(result.getInt("tickets"));
				account.setAdmin(result.getBoolean("is_admin"));
				account.setPreferedName(result.getString("preferred_name"));
			}
			//log.debug("..found and returning "+account.toString());
			//log.debug("... account.getPassword() = "+account.getPassword());
			return account;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		System.err.println("ERROR: updateAccount not implemented");
		return false;
	}

	@Override
	public boolean addAccount(Account account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO accounts (username, password, tickets, is_admin, preferred_name) "
					+ "VALUES (?,?,?,?,?);";
			
			int count = 0;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(++count, account.getUsername());
			statement.setString(++count, account.getPassword());
			statement.setInt(++count, account.getTickets());
			statement.setBoolean(++count, account.is_admin());
			statement.setString(++count, account.getPreferredName());
			
			statement.execute();
			
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}

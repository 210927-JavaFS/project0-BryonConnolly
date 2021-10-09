package com.bryonconnolly.revature.project0.daos;

import com.bryonconnolly.revature.project0.models.Account;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;
import com.revature.models.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class AccountDAOImplementation implements AccountDAO {

	@Override
	public List<Account> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM homes;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			while(result.next()) {
				Account account = new Account();
				account.setUsername(result.getString("username"));
				account.setPassword(result.getString("password"));//TODO non plain text passwords
				account.setTickets(result.getString("tickets"));
				account.setAdmin(result.getBoolean("is_admin"));
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
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
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
				account.setTickets(result.getString("tickets"));
				account.setAdmin(result.getBoolean("is_admin"));

			}
			
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
			
			String sql = "INSERT INTO accounts (username, password, tickets, is_admin, power_animal) "
					+ "VALUES (?,?,?,?,?,?,?,?);";
			
			int count = 0;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(++count, home.getName());
			statement.setString(++count, home.getStreetNumber());
			statement.setString(++count, home.getStreetName());
			statement.setString(++count, home.getCity());
			statement.setString(++count, home.getRegion());
			statement.setString(++count, home.getZip());
			statement.setString(++count, home.getCountry());
			statement.setInt(++count, home.getResidents());
			
			statement.execute();
			
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}

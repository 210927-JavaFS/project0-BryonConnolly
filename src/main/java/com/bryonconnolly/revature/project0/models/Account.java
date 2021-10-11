package com.bryonconnolly.revature.project0.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

	private String username;
	private String password;
	private int tickets;
	private boolean is_admin;
	private String preferred_name;
	
	private static Logger log = LoggerFactory.getLogger(Account.class);
	
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		//TODO think about if usernames should be changable
		// TODO and if so handle the changes properly
		this.username = username;
		//TODO transfer tickets, update db properly, etc.
		
	}

	public void setPreferedName(String preferred_name) {
		this.preferred_name = preferred_name;
	}
	
	
	public void setPassword(String string) {
		// TODO Auto-generated method stub
		this.password = password; //TODO implement non plain text password handling for DB
		
	}

	
	
	
	public void setTickets(int tickets) {
		// TODO Auto-generated method stub
		this.tickets = tickets;
		
	}


	public boolean is_admin() {
		return is_admin;
	}

	public void setAdmin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public String getUsername() {
		return username;
	}

	public String getPreferredName() {
		return preferred_name;
	}
	
	
	public String getPassword() {
		return password;
	}

	public int getTickets() {
		return tickets;
	}
	
	public void takeTickets(int number_of_tickets) {
		tickets -= number_of_tickets;
	}
	
	public void addTickets(int number_of_tickets) {
		tickets += number_of_tickets;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tickets;
	//	result = prime * result + drinks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (tickets != other.tickets)
			return false;
//		if (drinks != other.drinks)
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", preferred_name=" + preferred_name + ", tickets=" + tickets + ", toString()=" + super.toString() + "]";
	}
	
	
	

}

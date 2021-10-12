package com.bryonconnolly.revature.project0.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;

public class PrizeOption {

	private String name;
	private String description;
	private int quantity_available;
	private int price_in_tickets;
	
	// Setup and begin Logging
	private static final String CLASS_NAME 			= PrizeOption.class.getName();
	private static final String CLASS_SIMPLE_NAME	= PrizeOption.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	public boolean isAvailable(int quantity) {
		return quantity <= this.quantity_available;
	}
	
	public boolean isOutOfStock() {
		if(quantity_available > 0) return false;
		else return true;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantityAvailable() {
		return quantity_available;
	}
	public void setQuantityAvailable(int quantity_available) {
		this.quantity_available = quantity_available;
	}
	public int getPriceInTickets() {
		return price_in_tickets;
	}
	public void setPriceInTickets(int price_in_tickets) {
		this.price_in_tickets = price_in_tickets;
	}
	
	
	
	
}//end class PrizeOptions

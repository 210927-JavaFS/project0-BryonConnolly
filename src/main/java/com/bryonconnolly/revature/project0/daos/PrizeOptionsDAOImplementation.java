package com.bryonconnolly.revature.project0.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.models.PrizeOption;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;

public class PrizeOptionsDAOImplementation extends DAO implements PrizeOptionsDAO {

	// Setup and begin Logging
	private static final String CLASS_NAME 			= PrizeOptionsDAOImplementation.class.getName();
	private static final String CLASS_SIMPLE_NAME	= PrizeOptionsDAOImplementation.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	
	@Override
	public ArrayList<PrizeOption> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM prize_options;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<PrizeOption> list = new ArrayList<>();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			while(result.next()) {
				PrizeOption prizeOption = new PrizeOption();
				prizeOption.setName(result.getString("name"));
				prizeOption.setDescription(result.getString("description"));
				prizeOption.setPriceInTickets(result.getInt("price_in_tickets"));
				prizeOption.setQuantityAvailable(result.getInt("quantity_available"));
				list.add(prizeOption);
			}
			
			return (ArrayList<PrizeOption>) list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

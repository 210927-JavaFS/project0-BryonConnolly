package com.bryonconnolly.revature.project0.daos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.Driver;

public abstract class DAO {
	
	// Setup and begin Logging
	private static final String CLASS_NAME = Driver.class.getName();
	private static final String CLASS_SIMPLE_NAME = Driver.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block

	public List findAll;
	
	
}

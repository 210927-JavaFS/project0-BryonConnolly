package com.bryonconnolly.revature.project0.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.utils.ConnectionUtil;

public class RedemptionController {
	
	// Setup and begin Logging
	private static final String CLASS_NAME 			= RedemptionController.class.getName();
	private static final String CLASS_SIMPLE_NAME	= RedemptionController.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block

}

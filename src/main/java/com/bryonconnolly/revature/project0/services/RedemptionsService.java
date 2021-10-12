package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.Driver;
import com.bryonconnolly.revature.project0.daos.PrizeOptionsDAO;
import com.bryonconnolly.revature.project0.daos.PrizeOptionsDAOImplementation;
import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.PrizeOption;

public class RedemptionsService {

	// Setup and begin Logging
	private static final String CLASS_NAME = Driver.class.getName();
	private static final String CLASS_SIMPLE_NAME = Driver.class.getSimpleName();	
	private static Logger log = LoggerFactory.getLogger(CLASS_NAME);//NTS: Loggers have hierarchy and inherit from parents
	static {
		log.debug("Class "+CLASS_SIMPLE_NAME+" loaded into memory");
		//MDC.put("key","value");//just a reminder about MDC
	}//end static block
	
	private PrizeOptionsDAO prizeOptionsDao = new PrizeOptionsDAOImplementation();
	
	public PrizeOption findPrize() {
		ArrayList<PrizeOption> prize_options = prizeOptionsDao.findAll();
		//int monsterIndex = (int) (Math.random()*prizes.size());
		//log.debug(((Integer)prizeIndex).toString());
		//Prize prize = prizes.get(prizeIndex);
	//TODO IMPLEMENT THIS
		log.error("findPrize() NOT IMPLEMENTED");
		return null;
	}



}

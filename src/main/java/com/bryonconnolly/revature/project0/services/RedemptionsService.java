package com.bryonconnolly.revature.project0.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bryonconnolly.revature.project0.daos.PrizeDAO;
import com.bryonconnolly.revature.project0.daos.PrizeDAOImplementation;
import com.bryonconnolly.revature.project0.models.Element;
import com.bryonconnolly.revature.project0.models.Prize;

public class RedemptionsService {

	private static Logger log = LoggerFactory.getLogger(RedemptionsService.class);
	
	private PrizeDAO prizeDao = new PrizeDAOImplementation();
	
	public Prize findPrize() {
		ArrayList<Prize> prizes = prizeDao.findAllPrizes();
		//int monsterIndex = (int) (Math.random()*prizes.size());
		//log.debug(((Integer)prizeIndex).toString());
		//Prize prize = prizes.get(prizeIndex);
	//TODO IMPLEMENT THIS
		log.error("findPrize() NOT IMPLEMENTED");
		return null;
	}



}

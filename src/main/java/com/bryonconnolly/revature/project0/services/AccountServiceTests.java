package com.bryonconnolly.revature.project0.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.junit.jupiter.api.*;
import com.bryonconnolly.revature.project0.models.Account;

public class AccountServiceTests {
	
	public static AccountService accountService;
	public static Logger log = LoggerFactory.getLogger(AccountServiceTests.class);
	
	@BeforeAll
	public static void setAccountService() {
		log.info("In setAccountService");
		accountService = new AccountService();
	}
	

	
	@ParameterizedTest
	@ValueSource(strings = {""," ","A","Password","Number1","$ymbol","Extra Long........................"})
	public void testCheckPassword(String test_password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String encoded_password = encoder.encode(test_password);		
		Account test_account = new Account();
		test_account.setEncodedPassword(encoded_password);
		assertTrue(accountService.checkPassword(test_account,test_password));
	}
	
	@Test
	public void testCheckPassword() {
		testCheckPassword("Some Password");
	}
	
	
	//--EXAMPLE FROM THE WEB-----------------------------------------
	@DisplayName ("Testcase for Multiplication")
	@RepeatedTest (5)    
	 void multiply (TestInfo testInfo) 
	 {
	        int a, b;
	            a=10;
	         b=20;
	             assertEquals(200, (a*b), "Matched. Test status - Passed");
	}
	      

	
	
	/**************[EXAMPLES]****************
	 
	@BeforeAll
	public static void setAccountService() {
		log.info("In setAccountService");
		accountService = new AccountService();
	}

	@BeforeEach
	public void doSomething() {
		log.info("doing something (with an @BeforeEach annotation)");
	}
	
	@Test
	public void testAdd() {
		log.info("In testAdd");
		result = mathUtil.add(i, j);
		assertEquals(12, result);
	}
	
	@Test
	public void testSubtract() {
		log.info("In testSubtract.");
		result = mathUtil.subtract(i, j);
		assertTrue(result==2);
	}
	
	@Test
	public void testDivideByZero() {
		log.info("In testDivideByZero");
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(i,k));
	}
	
	//While so far we have been testing directly inputs and outputs it can often be more useful to test properties.
	//For example, addition has the commutative property. 
	@Test
	public void testCommutativeAdd() {
		log.info("in testCommutativeAdd");
		assertEquals(mathUtil.add(i, j), mathUtil.add(j, i));
	}
		
	@AfterEach
	public void clearResult() {
		result = 0;
		log.info("In clearResult");
	}
	
	@AfterAll 
	public static void clearMathUtil() {
		mathUtil = null;
		log.info("in clearMathUtil");
	}
	
	
	**************[END EXAMPLES]****************/
	

}

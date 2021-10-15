package com.bryonconnolly.revature.project0.daos;

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


public class AccountDAOTests {

	private static AccountDAO accountDAO;
	
	@BeforeAll
	public void beforeAll() {
		accountDAO = new AccountDAOImplementation();
	}

	// This should fail if the account named "admin" is removed, which is ok,
	// in addition to problems with the program, which is not ok.
	@Test
	public void testFindByUsernameSpecificallyTheOriginalAdminAccount() {
		accountDAO.findByUsername("admin");
	}

	@ParameterizedTest
	@ValueSource(strings = {"admin","bryon"})//a list of existing usernames
	public void testFindByUsername(String test_username) {
		assertNotNull(accountDAO.findByUsername(test_username));
	}

	
	@ParameterizedTest
	@ValueSource(strings = {"assert-null","bad-username","errorname","foobar_username"})//intentionally not extant accounts
	public void testPropertiesOfFindByUsername(String test_username) {
		//NOTE: these names are possible, so a failure could be that one was made and therefore should be non-null
		assertTrue(accountDAO.findByUsername(test_username) != null);
	}

}

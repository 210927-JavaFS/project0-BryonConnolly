package com.bryonconnolly.revature.project0.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static final String DRIVER			=	"org.postgresql.Driver";
	private static final String SUBPROTOCOL		=	"postgresql";
	private static final String ADDRESS			=	"database-1.cixcxydr3vka.us-east-1.rds.amazonaws.com";
	private static final int	PORT_NUMBER		=	5432;
	private static final String DATABASE_NAME	=	"project0";
	private static final String USERNAME		=	"postgres";// it is possible to use environment variables to hide this info
	private static final String PASSWORD		=	"password";// you would access them with System.getenv("variable-name");
	
	//combine into full url needed by JDBC
	private static final String URL = 	"jdbc:"
										+SUBPROTOCOL
										+"://"
										+ADDRESS
										+":"
										+PORT_NUMBER
										+"/"
										+DATABASE_NAME;

	
	public static Connection getConnection() throws SQLException {
		
		// for many frameworks using JDBC or operating with JDBC it is necessary to
		// register the driver you are using to make the framework aware
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}
}

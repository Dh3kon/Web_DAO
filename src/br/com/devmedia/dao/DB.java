package br.com.devmedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String server = "localhost";
	private static final String dataBaseName = "java";
	private static final String user = "root";
	private static final String pw = "";
	
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection("jdbc:mysql://" + server + "/" + dataBaseName, user, pw);
	}
}

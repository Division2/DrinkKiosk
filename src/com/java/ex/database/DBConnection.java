package com.java.ex.database;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/kiosk?useSSL=false";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_USER = "kiosk";
	private static final String DB_PASS = "kiosk";
	
	private static Connection dbConn;
	
	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				Class.forName(DB_DRIVER);
				dbConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				System.out.println("DB, 드라이버 로드 성공");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		return dbConn;
	}
}
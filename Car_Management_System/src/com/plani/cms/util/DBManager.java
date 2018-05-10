package com.plani.cms.util;

import java.sql.*;

public class DBManager {

	public static void main(String[] args) throws Exception {
		Connection con = null;

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "12345");
			System.out.println("success" + con);

		} catch (SQLException ex) {
			System.out.println("SQLException" + ex);
		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
		}
	}

}

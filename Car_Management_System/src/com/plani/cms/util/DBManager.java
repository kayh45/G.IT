package com.plani.cms.util;

import java.sql.*;

/**
 * JDBC 연결과 해제를 쉽게 진행하기 위하여 
 * getConnection(), close() 등의 메소드를 지원하는 클래스
 * 
 * @author 강현
 *
 */
public class DBManager {
	
	/**
	 * JDBC 연결을 진행
	 * DAO 클래스에서 사용
	 * 
	 * @return 연결된 Connection을 리턴
	 */
	public static Connection getConnection() {
		
		Connection conn = null;

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://planicmsdb.mysql.database.azure.com:3306/cms?useSSL=true&requireSSL=false", 
												"cmsadmin@planicmsdb", "1q2w3e4r*");
			System.out.println("DB 연결 성공 :  " + conn);			

		} catch (SQLException ex) {
			System.out.println("SQLException" + ex);
		}

		catch (Exception ex) {
			System.out.println("Exception" + ex);
		}
		
		return conn;
	
	}
	
	/**
	 * DQL(select)을 수행한 후 리소스 해제를 위한 메소드
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * DML(insert, update, delete)을 수행한 후 리소스 해제를 위한 메소드
	 * 
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn, Statement stmt){
		try{
			stmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

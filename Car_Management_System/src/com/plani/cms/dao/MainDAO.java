package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.plani.cms.dto.DeptVO;
import com.plani.cms.util.DBManager;

public class MainDAO {

	private static MainDAO instance = new MainDAO();

	public static MainDAO getInstance() {
		return instance;
	} // Singleton 패턴
	
	public int numberOfCars() {
		
		String sql = "select count(*) from car";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int noc = 0;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				 noc = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}		
		return noc;
	}
	
		public int numberOfUsingCars() {
		
		String sql = "SELECT DISTINCT count(*) FROM driv WHERE driv_s_date < now() AND driv_e_date > now()";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int nouc = 0;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				nouc = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}		
		return nouc;
	}
}

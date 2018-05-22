package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.util.DBManager;

public class ReserveDAO {

	private static ReserveDAO instance = new ReserveDAO();

	public static ReserveDAO getInstance() {
		return instance;
	} // Singleton 패턴
	
	public List<String> usingNow() {
		/**
		 * 현재 사용 중 상태인 차등록번호 가져오기
		 * @ReserveWriteFormAction 에서 사용
		 **/
		
		String sql = "SELECT DISTINCT car_reg_no FROM driv WHERE driv_s_date < now() AND driv_e_date > now()";
		
		List<String> usingList = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				usingList.add(rs.getString("car_reg_no"));	
				System.out.println("DAO: " + rs.getString("car_reg_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return usingList;		
	}
	

	public List<String> canUseNow() {
		/**
		 * 바로 사용 가능 상태가 아닌 차등록번호 가져오기
		 * @ReserveWriteFormAction 에서 사용
		 **/
		
		String sql = "SELECT car_reg_no FROM driv "
				+ "WHERE date(driv_s_date) = date(now()) AND driv_s_date > now() "
				+ "GROUP BY car_reg_no "
				+ "HAVING min(driv_s_date) < date_add(now(), interval 3 hour)";
		
		List<String> usingList = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				usingList.add(rs.getString("car_reg_no"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return usingList;		
	}
	
}

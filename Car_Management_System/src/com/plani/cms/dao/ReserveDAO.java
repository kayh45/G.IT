package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.plani.cms.dto.DrivVO;
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
	
	public Date getSysDate() {
		
		String sql = "select curdate()";
		
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			
			if(rs.next()){				
				try {
					date = today.parse(rs.getString(1));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e){
			e.printStackTrace();			
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return date;
	}
	
	public List<DrivVO> oneDaySchedule(String date, String car_reg_no) {
		/**
		 * 바로 사용 가능 상태가 아닌 차등록번호 가져오기
		 * @ReserveWriteFormAction 에서 사용
		 **/
		
		String sql = "SELECT *, hour(driv_s_date) as s_hour, hour(driv_e_date) as e_hour FROM driv WHERE date(driv_s_date) = ? AND car_reg_no = ?";
		
		List<DrivVO> scheduleList = new ArrayList<DrivVO>();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, date);
			pstmt.setString(2, car_reg_no);		
			
			rs = pstmt.executeQuery();

			while (rs.next()) {				
				DrivVO dVo = new DrivVO();
				
				dVo.setDriv_no(rs.getInt("driv_no"));
				dVo.setMem_id(rs.getString("mem_id"));
				dVo.setDriv_s_date(sdf.parse(rs.getString("driv_s_date")));
				dVo.setDriv_e_date(sdf.parse(rs.getString("driv_e_date")));
				dVo.setS_hour(rs.getInt("s_hour"));
				dVo.setE_hour(rs.getInt("e_hour"));		
								
				scheduleList.add(dVo);	
				
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println(scheduleList.get(0));
		return scheduleList;	
	}
	
	
	
}

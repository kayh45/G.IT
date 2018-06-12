package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarVO;
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
				+ "HAVING min(driv_s_date) < date_add(now(), interval 1 hour)";
		
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
	
	public String getSysDate() {
		
		String sql = "select curdate()";
		
		String date = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			
			if(rs.next()){				
				date = rs.getString(1);
				
				System.out.println(date);
			}
			
		} catch (SQLException e){
			e.printStackTrace();			
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return date;
	}
	
	public List<DrivVO> oneDaySchedule(String date, String mem_id) {
		/**
		 * 하루 스케쥴 가져오기
		 * @ReserveWriteFormAction 에서 사용
		 **/
		
		String sql = "SELECT *, hour(driv_s_date) as s_hour, hour(driv_e_date) as e_hour FROM driv WHERE date(driv_s_date) = ? "
				+ "AND mem_id = ? ORDER BY driv_s_date ASC";
		
		List<DrivVO> scheduleList = new ArrayList<DrivVO>();		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, date);
			pstmt.setString(2, mem_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {				
				DrivVO dVo = new DrivVO();
				
				dVo.setDriv_no(rs.getInt("driv_no"));
				dVo.setMem_id(rs.getString("mem_id"));
				dVo.setDriv_s_date(rs.getString("driv_s_date"));
				dVo.setDriv_e_date(rs.getString("driv_e_date"));
				dVo.setS_hour(rs.getInt("s_hour"));
				dVo.setE_hour(rs.getInt("e_hour"));		
								
				scheduleList.add(dVo);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return scheduleList;	
	}
	
	public void insertReserve(DrivVO dVo) {
		/**
		 * @ReserveWriteAction 에서 사용
		 **/
		
		String sql = "INSERT INTO driv(driv_s_date, driv_e_date, car_reg_no, mem_id) VALUES (?, ?, ?, ?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dVo.getDriv_s_date());
			pstmt.setString(2, dVo.getDriv_e_date());
			pstmt.setString(3, dVo.getCar_reg_no());		
			pstmt.setString(4, dVo.getMem_id());		
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteReserve(int driv_no) {
		
		String sql = "DELETE FROM driv WHERE driv_no = ?";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, driv_no);	
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public DrivVO selectOneDrive(int driv_no) {
		String sql = "SELECT *, date(driv_s_date) as date FROM driv WHERE driv_no = ?";
		
		DrivVO dVo = new DrivVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, driv_no);	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dVo.setCar_reg_no(rs.getString("car_reg_no"));
				dVo.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return dVo;
	}
	
	public List<CarVO> unuseList(String date, String s_date, String e_date) {
		
		/*
		 * 해당 날짜에 사용 가능한 차량 리스트를 받아오는 메소드
		 * date = 선택한 날짜
		 * s_date, e_date = 선택한 시간
		 */
		
		String sql = "select * from car where car_reg_no " + 
				"not in (select car_reg_no from driv " +
				"where date(driv_s_date) = date(?) and " + 
				"(hour(driv_s_date) > ? or hour(driv_e_date) < ?))";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CarVO cVo = null;
		List<CarVO> cVoList = new ArrayList<CarVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, date);	
			pstmt.setString(2, s_date);	
			pstmt.setString(3, e_date);	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cVo = new CarVO();
				
				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_model(rs.getString("car_model"));
				
				cVoList.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return cVoList;
	}
}
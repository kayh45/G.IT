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

/**
 * 배차 관리 화면의 기능들을 구현할 DAO 클래스 
 * 
 * @author 강현
 *
 */
public class ReserveDAO {

	private static ReserveDAO instance = new ReserveDAO();

	public static ReserveDAO getInstance() {
		return instance;
	} // Singleton 패턴
	
	/**
	 * 현재 사용 중 상태인 차량 등록번호 조회
	 * 
	 * @return 현재 사용 중 상태인 차량들의 목록을 List 타입으로 리턴
	 */
	public List<String> usingNow() {
		
		String sql = "SELECT DISTINCT car_reg_no "
				+ "     FROM driv "
				+ "    WHERE driv_s_date < now() "
				+ "      AND driv_e_date > now()";
		
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
	
	/**
     * 현재 사용 중 상태인 차등록번호 조회
	 * 
	 * @return 현재 사용 중 상태인 차량들의 목록을 List 타입으로 리턴
	 */
	public List<String> canUseNow() {
		
		String sql = "SELECT car_reg_no FROM driv "
				+ "    WHERE date(driv_s_date) = date(now()) "
				+ "      AND driv_s_date > now() "
				+ "    GROUP BY car_reg_no "
				+ "   HAVING min(driv_s_date) < date_add(now(), interval 1 hour)";
		
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
	
	/**
	 * 데이터 베이스 시스템 상의 시간 정보를 가져옴
	 * 
	 * @return DB 에서의 현재 시간
	 */
	public String getSysDate() {
		
		String sql = "SELECT curdate()";
		
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
	
	/**
	 * 조회하고자 하는 날짜의 스케쥴을 조회
	 * 
	 * @param date : 조회하고자 하는 날짜 (YYYY-MM-DD)
	 * @param mem_id : 조회하는 사원의 아이디
	 * 
	 * @return 하루의 스케쥴을 List 타입으로 리턴
	 */
	public List<DrivVO> oneDaySchedule(String date, String mem_id) {
		
		String sql = "SELECT *                                                        "
				+ "        , HOUR(driv_s_date) as s_hour                              "
				+ "        , HOUR(driv_e_date) as e_hour                              "
				+ "     FROM driv                                                     "
				+ "    WHERE date(driv_s_date) = ?                                    "  
				+ "      AND mem_id = ?                                               "
				+ "    ORDER BY driv_s_date ASC                                       ";
		
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
	
	/**
	 * 배차 정보를 추가
	 * 
	 * @param dVo : 등록하고자 하는 날짜와 시간(driv_s_date ~ driv_e_date)
	 *            , 등록하고자 하는 차량의 등록번호
	 *            , 등록하는 사원의 아이디 를 가지고 있는 객체 
	 */
	public void insertReserve(DrivVO dVo) {
		/**
		 * @ReserveWriteAction 에서 사용
		 **/
		
		String sql = "INSERT INTO driv(driv_s_date, driv_e_date, car_reg_no, mem_id) "
				+ "   VALUES (?, ?, ?, ?)";
		
		
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

	/**
	 * 배차 정보를 삭제
	 * 
	 * @param driv_no : 삭제하고자 하는 운행일지(배차)번호
	 */
	public void deleteReserve(int driv_no) {
		
		String sql = "DELETE driv        "
				+ "    WHERE driv_no = ? ";
		
		
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
	
	/**
	 * 배차 정보 하나를 조회
	 * 
	 * @param driv_no : 조회하고자 하는 운행일지(배차) 번호
	 * 
	 * @return 해당 운행일지 정보를 담고 있는 객체
	 */
	public DrivVO selectOneDrive(int driv_no) {
		String sql = "SELECT *                         "
				+ "        , DATE(driv_s_date) as date "
				+ "     FROM driv                      "
				+ "    WHERE driv_no = ?               ";
		
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
	
	/**
	 * 해당 날짜에 사용 가능한 차량 리스트를 받아오는 메소드
	 * 
	 * @param date : 선택한 날짜
	 * @param s_date : 선택한 시작 시간
	 * @param e_date : 선택한 종료 시간
	 * 
	 * @return 해당 날짜에 사용가능한 차량의 목록을 List 타입으로 리턴
	 */
	public List<CarVO> unuseList(String date, String s_date, String e_date) {
		
		String sql = "SELECT * "
				+ "     FROM car "
				+ "    WHERE car_reg_no NOT IN (SELECT car_reg_no "
				+ "                               FROM driv " 
				+ "                              WHERE date(driv_s_date) = date(?) "
				+ "                                AND (HOUR(driv_s_date) > ? OR HOUR(driv_e_date) < ?)"
				+ "                            )";
		
		
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
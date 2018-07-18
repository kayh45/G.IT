package com.plani.cms.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.plani.cms.util.DBManager;
import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.CarexVO;
/**
 * 
 * 법인 차량 등록, 수정, 삭제, 조회를 할 수 있는 클래스(싱글톤)
 * 
 * @author 조성철
 *
 */
public class CarDAO {
	private static CarDAO instance = new CarDAO();

	public static CarDAO getInstance() {
		return instance;
	}
	
	/**
	 * 법인 차량 전체 조회 메소드(PK 기준 내림 차순 정렬)
	 * 
	 * @return : 차량 리스트
	 */
	public List<CarVO> selectAllCar() {

		String sql = "SELECT c.* "
				   + "  FROM car c "
				   + " ORDER BY c.CAR_REG_NO DESC";

		List<CarVO> list = new ArrayList<CarVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarVO cVo = new CarVO();

				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_divi(rs.getString("car_divi"));
				cVo.setCar_model(rs.getString("car_model"));
				cVo.setCt_date(rs.getString("ct_date"));
				cVo.setEp_date(rs.getString("ep_date"));
				cVo.setCo_name(rs.getString("co_name"));
				cVo.setCo_tel(rs.getString("co_tel"));
				cVo.setCo_fax(rs.getString("co_fax"));
				cVo.setBo_name(rs.getString("bo_name"));
				cVo.setBo_divi(rs.getString("bo_divi"));
				cVo.setBo_age(rs.getInt("bo_age"));
				cVo.setBo_s_date(rs.getString("bo_s_date"));
				cVo.setBo_e_date(rs.getString("bo_e_date"));
				cVo.setTotal_dist(rs.getInt("total_dist"));
				

				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	public List<CarexVO> selectExpenCarOnlydate(String date_s, String date_e) {
		
		String sql = "select c.car_reg_no as 'car_reg_no', FORMAT(sum(r.repa_fee),0) as 'repa_fee', "
				+ "format(sum(d.oil_fee),0) as 'oil_fee', format(sum(d.trans_fee),0) as 'trans_fee', "
				+ "format(sum(d.etc_fee),0) as 'etc_fee' from car c, repa r, driv d "
				+ "where (c.car_reg_no = r.car_reg_no) and (r.car_reg_no = d.car_reg_no) and "
				+ "(between r.repa_s_date = '" + date_s + "' and r.repa_s_date = '" + date_e + "') and (between d.driv_s_date = '" + date_s + "' and "
						+ "d.driv_e_date = '" + date_e + "') group by c.car_reg_no";
		
		List<CarexVO> list = new ArrayList<CarexVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				CarexVO cVo = new CarexVO();
				
				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setRepa_fee(rs.getInt("repa_fee"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				
				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<CarexVO> selectExpenCarOnlydate(String date_s, String date_e, String car_reg_no) {
		
		String sql = "select c.car_reg_no as 'car_reg_no', FORMAT(sum(r.repa_fee),0) as 'repa_fee', "
				+ "format(sum(d.oil_fee),0) as 'oil_fee', format(sum(d.trans_fee),0) as 'trans_fee', "
				+ "format(sum(d.etc_fee),0) as 'etc_fee' from car c, repa r, driv d "
				+ "where (c.car_reg_no = r.car_reg_no) and (r.car_reg_no = d.car_reg_no) and "
				+ "(between r.repa_s_date = '" + date_s + "' and r.repa_s_date = '" + date_e + "') and (between d.driv_s_date = '" + date_s + "' and "
				+ "d.driv_e_date = '" + date_e + "') and c.car_reg_no = '" + car_reg_no +"' group by c.car_reg_no";
		
		List<CarexVO> list = new ArrayList<CarexVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				CarexVO cVo = new CarexVO();
				
				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setRepa_fee(rs.getInt("repa_fee"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				
				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	
	/**
	 * 법인 차량 번호 키워드로 검색할 수 있는 메소드
	 * 
	 * @param car_reg_no : 법인 차량 번호
	 * @return			 : 법인 차량 리스트
	 */
	
	public List<CarVO> carSearchByNameLike(String car_reg_no) {
		String sql = "SELECT c.*"
				   + "	FROM car c"
				   + " WHERE c.CAR_REG_NO LIKE '%" + car_reg_no + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CarVO> list = new ArrayList<CarVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarVO cVo = new CarVO();

				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_divi(rs.getString("car_divi"));
				cVo.setCar_model(rs.getString("car_model"));
				cVo.setCt_date(rs.getString("ct_date"));
				cVo.setEp_date(rs.getString("ep_date"));
				cVo.setCo_name(rs.getString("co_name"));
				cVo.setCo_tel(rs.getString("co_tel"));
				cVo.setCo_fax(rs.getString("co_fax"));
				cVo.setBo_name(rs.getString("bo_name"));
				cVo.setBo_divi(rs.getString("bo_divi"));
				cVo.setBo_age(rs.getInt("bo_age"));
				cVo.setBo_s_date(rs.getString("bo_s_date"));
				cVo.setBo_e_date(rs.getString("bo_e_date"));
				cVo.setTotal_dist(rs.getInt("total_dist"));


				list.add(cVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	/**
	 * 법인 차 중 구매차(자차) 데이터를 등록하는 메소드
	 * 
	 * @param cVo : 법인차 객체
	 * @return	  : 성공 여부에 따라 -1 또는 1 반환
	 */
	public int insertCar_payCar(CarVO cVo) {
		int result = -1;
		String sql = "INSERT INTO car (CAR_REG_NO, CAR_DIVI, CAC_MODEL, BO_NAME, BO_DIVI,"
				   + "                 BO_AGE, BO_S_DATE, BO_E_DATE, TOTAL_DIST) "
				   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_reg_no());
			pstmt.setString(2, cVo.getCar_divi());
			pstmt.setString(3, cVo.getCar_model());
			pstmt.setString(4, cVo.getBo_name());
			pstmt.setString(5, cVo.getBo_divi());
			pstmt.setInt(6, cVo.getBo_age());
			pstmt.setString(7, cVo.getBo_s_date());
			pstmt.setString(8, cVo.getBo_e_date());
			pstmt.setInt(9, cVo.getTotal_dist());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	/**
	 * 법인 차 중 렌트차 데이터를 등록하는 메소드
	 * @param cVo
	 */
	public void insertCar_rentalCar(CarVO cVo) {
		String sql = "INSERT INTO car (CAR_REG_NO, CAR_DIVI, CAR_MODEL, CT_DATE, EP_DATE"
				   + "               , CO_NAME, CO_TEL, CO_FAX, BO_NAME, BO_DIVI, BO_AGE"
				   + "				 , BO_S_DATE, BO_E_DATE, TOTAL_DIST)"
				   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_reg_no());
			pstmt.setString(2, cVo.getCar_divi());
			pstmt.setString(3, cVo.getCar_model());
			pstmt.setString(4, cVo.getCt_date());
			pstmt.setString(5, cVo.getEp_date());
			pstmt.setString(6, cVo.getCo_name());
			pstmt.setString(7, cVo.getCo_tel());
			pstmt.setString(8, cVo.getCo_fax());
			pstmt.setString(9, cVo.getBo_name());
			pstmt.setString(10, cVo.getBo_divi());
			pstmt.setInt(11, cVo.getBo_age());
			pstmt.setString(12, cVo.getBo_s_date());
			pstmt.setString(13, cVo.getBo_e_date());
			pstmt.setInt(14, cVo.getTotal_dist());

			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		} finally {
		
			DBManager.close(conn, pstmt);
		
		}
	}
	
	/**
	 * 법인 차 중 렌트카의 데이터를 수정하는 메소드
	 * @param cVo : cVo 객체
	 */
	public void updateCar_rentalCar(CarVO cVo) {
		String sql = "UPDATE car c"
				   + "   SET c.CAR_DIVI = ?"
				   + "	   , c.CAR_MODEL = ?"
				   + "	   , c.CT_DATE = ?"
				   + "	   , c.EP_DATE = ?"
				   + "     , c.CO_NAME = ?"
				   + " 	   , c.CO_TEL = ?"
				   + "	   , c.CO_FAX = ?"
				   + "     , c.BO_NAME = ?"
				   + "	   , c.BO_DIVI = ?"
				   + "	   , c.BO_AGE = ?"
				   + "	   , c.BO_S_DATE = ?"
				   + "     , c.BO_E_DATE = ?"
				   + "     , c.TOTAL_DIST = ?"
				   + "  WHERE c.CAR_REG_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCar_divi());
			pstmt.setString(2, cVo.getCar_model());
			pstmt.setString(3, cVo.getCt_date());
			pstmt.setString(4, cVo.getEp_date());
			pstmt.setString(5, cVo.getCo_name());
			pstmt.setString(6, cVo.getCo_tel());
			pstmt.setString(7, cVo.getCo_fax());
			pstmt.setString(8, cVo.getBo_name());
			pstmt.setString(9, cVo.getBo_divi());
			pstmt.setInt(10, cVo.getBo_age());
			pstmt.setString(11, cVo.getBo_s_date());
			pstmt.setString(12, cVo.getBo_e_date());
			pstmt.setInt(13, cVo.getTotal_dist());
			pstmt.setString(14, cVo.getCar_reg_no());

			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		} finally {
		
			DBManager.close(conn, pstmt);
		
		}
	}
	
	/**
	 * 법인 차 중 구매차의 데이터를 수정하는 메소드
	 * @param cVo : cVo 객체
	 */
	public void updateCar_payCar(CarVO cVo) {
		String sql = "UPDATE car c"
				   + "   SET c.CAR_DIVI = ?"
				   + "	   , c.CAR_MODEL = ?"
				   + "     , c.BO_NAME = ?"
				   + "	   , c.BO_DIVI = ?"
				   + "	   , c.BO_AGE = ?"
				   + "	   , c.BO_S_DATE = ?"
				   + "     , c.BO_E_DATE = ?"
				   + "     , c.TOTAL_DIST = ?"
				   + "  WHERE c.CAR_REG_NO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cVo.getCar_divi());
			pstmt.setString(2, cVo.getCar_model());
			pstmt.setString(3, cVo.getBo_name());
			pstmt.setString(4, cVo.getBo_divi());
			pstmt.setInt(5, cVo.getBo_age());
			pstmt.setString(6, cVo.getBo_s_date());
			pstmt.setString(7, cVo.getBo_e_date());
			pstmt.setInt(8, cVo.getTotal_dist());
			pstmt.setString(9, cVo.getCar_reg_no());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 법인 차 데이터를 삭제하는 메소드
	 * @param car_reg_no : 법인차량번호
	 */
	public void DeleteCar(String car_reg_no) {

		String sql = "DELETE FROM car c"
				   + " WHERE c.CAR_REG_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 법인 차 번호를 조회하여 법인 차 데이터가 있는지 없는지 조회하는 메소드
	 * 
	 * @param car_reg_no : 법인 차 번호
	 * @return			 : 데이터 null : 0 : 데이터 존재 : 1 : 데이터 없음 : -1
	 */
	public int confirmCarNo(String car_reg_no) {
		
		int result = -1;
		
		String sql = "SELECT c.CAR_REG_NO "
				   + "  FROM car c "
				   + " WHERE c.CAR_REG_NO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);

			rs = pstmt.executeQuery();

			if (car_reg_no.equals("")) {
				// 데이터 NULL
				result = 0; 
		
			} else if(rs.next()) {
				// 데이터 존재.
				result = 1;
				System.out.println(result +":통과");
			
			} else {
				// 데이터 없음
				result = -1;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		
		} finally {
		
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			
			} catch (Exception e) {
			
				e.printStackTrace();
			
			}
		}
		
		return result;
	}
}

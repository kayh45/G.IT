package com.plani.cms.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.CarlogVO;
import com.plani.cms.util.DBManager;

/**
 * 차량 운행일지를 등록, 수정, 삭제, 조회할 수 있는 클래스(싱글톤)
 * 
 * @author 조성철
 *
 */

public class CarlogDAO {

	private static CarlogDAO instance = new CarlogDAO();

	public static CarlogDAO getInstance() {
		return instance;
	}
	
	/**
	 * 운행일지로 증가 된 차량 누적거리 값을 
	 * 법인 차 테이블의 컬럼인 총 거리에 수정해주는 메소드
	 * 
	 * @param caVo : 법인 차 객체
	 * @param cVo  : 운행일지 객체
	 */
	public void updateCarDist(CarVO caVo, CarlogVO cVo) {
		String sql = "UPDATE driv d JOIN car c ON d.DRIV_NO = c.CAR_REG_NO "
				   + "                        AND c.CAR_REG_NO = ? "
				   + "                        AND d.DRIV_NO = ? " 
				   + "   SET c.TOTAL_DIST = c.TOTAL_DIST + d.DRIV_DIST";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, caVo.getCar_reg_no());
			pstmt.setInt(2, cVo.getDriv_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 운행일지를 등록하는 메소드
	 * 단, 전체 데이터 수정 (법인 카드 사용 할 때)
	 * 
	 * @param cVo : 운행일지 객체
	 */
	public void updateCarlog(CarlogVO cVo) {
		String sql = "UPDATE driv d "
				   + "	 SET d.COUR_NO = ? "
				   + "	   , d.DRIV_PURPR = ? "
				   + "     , d.DRIV_DIVI=? "
				   + "	   , d.CARD_DIVI = ? "
				   + "	   , d.OIL.FEE = ? "
				   + "	   , d.TRANS_FEE = ? "
				   + "     , d.ETC_TEXT = ? "
				   + "     , d.ETC_FEE = ? "
				   + "     , d.DRIV_DIST = ? "
				   + " WHERE d.DRIV_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setString(2, cVo.getDriv_purpo());
			pstmt.setString(3, cVo.getDriv_divi());
			pstmt.setString(4, cVo.getCard_divi());
			pstmt.setInt(5, cVo.getOil_fee());
			pstmt.setInt(6, cVo.getTrans_fee());
			pstmt.setString(7, cVo.getEtc_text());
			pstmt.setInt(8, cVo.getEtc_fee());
			pstmt.setInt(9, cVo.getDriv_dist());
			pstmt.setInt(10, cVo.getDriv_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/**
	 * 운행일지를 등록하는 메소드
	 * 단, 법인카드 사용 X
	 * 
	 * @param cVo : 운행일지 객체
	 */
	public void updateCarlogNofee(CarlogVO cVo) {
		String sql = "UPDATE driv d "
				   + "	 SET d.COUR_NO = ? "
				   + "	   , d.DRIV_PURPO = ? "
				   + "     , d.DRIV_DIVI=? "
				   + "	   , d.CARD_DIVI = ? "
				   + "     , d.DRIV_DIST = ? "
				   + " WHERE d.DRIV_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setString(2, cVo.getDriv_purpo());
			pstmt.setString(3, cVo.getDriv_divi());
			pstmt.setString(4, cVo.getCard_divi());
			pstmt.setInt(5, cVo.getDriv_dist());
			pstmt.setInt(6, cVo.getDriv_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 운행일지를 등록하는 메소드
	 * 단, 유류비 = 0  초기화
	 * 
	 * @param cVo
	 */
	public void updateCarlogOilfee(CarlogVO cVo) {

		String sql = "UPDATE driv d "
				   + "	 SET d.COUR_NO = ? "
				   + "	   , d.DRIV_PURPO = ? "
				   + "     , d.DRIV_DIVI=? "
				   + "	   , d.CARD_DIVI = ? "
				   + "	   , d.OIL.FEE = 0 "
				   + "	   , d.TRANS_FEE = ? "
				   + "     , d.ETC_TEXT = ? "
				   + "     , d.ETC_FEE = ? "
				   + "     , d.DRIV_DIST = ? "
				   + " WHERE d.DRIV_NO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setString(2, cVo.getDriv_purpo());
			pstmt.setString(3, cVo.getDriv_divi());
			pstmt.setString(4, cVo.getCard_divi());
			pstmt.setInt(5, cVo.getTrans_fee());
			pstmt.setString(6, cVo.getEtc_text());
			pstmt.setInt(7, cVo.getEtc_fee());
			pstmt.setInt(8, cVo.getDriv_dist());
			pstmt.setInt(9, cVo.getDriv_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 운행일지를 삭제하는 메소드
	 * 
	 * @param driv_no : 운행 번호
	 */
	public void DeleteCarlog(int driv_no) {

		String sql = "DELETE "
				   + "  FROM driv d"
				   + "WHERE d.DRIV_NO = ?";

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
	 * 운행일지 작성 완료한 데이터 조회하는 메소드
	 * 
	 * @param mem_id : 사원 아이디
	 * @return		 : 작성 완료 운행일지 리스트
	 */
	public List<CarlogVO> drivSearchByNameComplete(String mem_id) {
		
		String sql = "select d.driv_no, d.car_reg_no, cc.car_model, m.mem_id, m.mem_name, left(d.driv_s_date,16) as 'driv_s_date' , left(d.driv_e_date,16) as 'driv_e_date', d.cour_no, d.driv_purpo,"
				+ "d.driv_divi,(select place_name from place where place_no = s_place) as 's_place_name', (select place_divi from place where place_no = s_place) as 's_place_divi',"
				+ "(select place_name from place where place_no = e_place) as 'e_place_name', (select place_divi from place where place_no = e_place) as 'e_place_divi',"
				+ "c.distance, d.card_divi, d.oil_fee, d.trans_fee, d.etc_text, d.etc_fee, d .driv_dist from driv d, mem m, cour c, car cc "
				+ "where (d.mem_id=m.mem_id) AND (c.cour_no = d.cour_no) AND (d.car_reg_no = cc.car_reg_no) AND m.mem_id= '"
				+ mem_id + "'" + "order by d.driv_no";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CarlogVO> list = new ArrayList<CarlogVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarlogVO cVo = new CarlogVO();

				cVo.setDriv_no(rs.getInt("driv_no"));
				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_model(rs.getString("car_model"));
				cVo.setMem_id(rs.getString("mem_id"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_s_date(rs.getString("driv_s_date"));
				cVo.setDriv_e_date(rs.getString("driv_e_date"));
				cVo.setCour_no(rs.getInt("cour_no"));
				cVo.setDriv_purpo(rs.getString("driv_purpo"));
				cVo.setDriv_divi(rs.getString("driv_divi"));
				cVo.setS_place_name(rs.getString("s_place_name"));
				cVo.setS_place_divi(rs.getString("s_place_divi"));
				cVo.setE_place_name(rs.getString("e_place_name"));
				cVo.setE_place_divi(rs.getString("e_place_divi"));
				cVo.setDistance(rs.getInt("distance"));
				cVo.setCard_divi(rs.getString("card_divi"));
				cVo.setOil_fee(rs.getInt("oil_fee"));
				cVo.setTrans_fee(rs.getInt("trans_fee"));
				cVo.setEtc_text(rs.getString("etc_text"));
				cVo.setEtc_fee(rs.getInt("etc_fee"));
				cVo.setDriv_dist(rs.getInt("driv_dist"));
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
	 * 미작성 운행일지 데이터 조회하는 메소드
	 * 
	 * @param mem_id : 사원 아이디
	 * @return		 : 미작성 운행일지 리스트
	 */
	public List<CarlogVO> drivSearchByNameNoncomplete(String mem_id) {
		String sql = "select d.driv_no, d.car_reg_no, c.car_model, m.mem_name, left(d.driv_s_date,16) as 'driv_s_date' , left(d.driv_e_date,16) as 'driv_e_date',d.driv_dist from driv d, mem m, car c "
				+ "where d.mem_id=m.mem_id AND d.car_reg_no=c.car_reg_no AND d.cour_no is null AND m.mem_id= '" + mem_id
				+ "' " + "order by d.driv_no";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<CarlogVO> list = new ArrayList<CarlogVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CarlogVO cVo = new CarlogVO();

				cVo.setDriv_no(rs.getInt("driv_no"));
				cVo.setCar_reg_no(rs.getString("car_reg_no"));
				cVo.setCar_model(rs.getString("car_model"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_s_date(rs.getString("driv_s_date"));
				cVo.setDriv_e_date(rs.getString("driv_e_date"));
				cVo.setDriv_dist(rs.getInt("driv_dist"));
				list.add(cVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	public List<CarlogVO> preMonthNoneBefoDistCount(String car_reg_no, int year, int month) {
		String sql = "SELECT driv_no, m.mem_id, mem_name, driv_s_date, driv_e_date "
				+ "FROM driv AS d INNER JOIN mem AS m ON d.mem_id = m.mem_id "
				+ "WHERE car_reg_no = ? AND year(driv_e_date) = ? AND month(driv_e_date) = ? AND befo_dist is null";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CarlogVO cVo = null;
		List<CarlogVO> cVoList = new ArrayList<CarlogVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			String strYear = year + "";
			String strMonth = month + "";

			pstmt.setString(1, car_reg_no);
			pstmt.setString(2, strYear);
			pstmt.setString(3, strMonth);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				cVo = new CarlogVO();

				cVo.setDriv_no(rs.getInt("driv_no"));
				cVo.setMem_id(rs.getString("mem_Id"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_s_date(rs.getString("driv_s_date"));
				cVo.setDriv_e_date(rs.getString("driv_e_date"));

				cVoList.add(cVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return cVoList;
	}

	public List<CarlogVO> thisMonthDoneList(String car_reg_no, int year, int month) {
		String sql = "SELECT driv_no, m.mem_id, mem_name, driv_s_date, driv_e_date "
				+ "FROM driv AS d INNER JOIN mem AS m ON d.mem_id = m.mem_id "
				+ "WHERE car_reg_no = ? AND year(driv_e_date) = ? AND month(driv_e_date) = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CarlogVO cVo = null;
		List<CarlogVO> cVoList = new ArrayList<CarlogVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			String strYear = year + "";
			String strMonth = month + "";
			System.out.println(car_reg_no);
			pstmt.setString(1, car_reg_no);
			pstmt.setString(2, strYear);
			pstmt.setString(3, strMonth);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				cVo = new CarlogVO();

				cVo.setDriv_no(rs.getInt("driv_no"));
				cVo.setMem_id(rs.getString("mem_Id"));
				cVo.setMem_name(rs.getString("mem_name"));
				cVo.setDriv_s_date(rs.getString("driv_s_date"));
				cVo.setDriv_e_date(rs.getString("driv_e_date"));

				cVoList.add(cVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return cVoList;
	}

	public void deleteAllAutoOneMonth(String car_reg_no, String year, String month) {
		String sql = "DELETE FROM driv WHERE car_reg_no = ? AND year(driv_e_date) = ? " + "and month(driv_e_date) = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);
			pstmt.setString(2, year);
			pstmt.setString(3, month);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}

	public int getPreMonthBefoDist(String car_reg_no, int year, int month) {
		String sql = "select befo_dist from driv where car_reg_no = ? "
				+ "and befo_dist is not null and year(driv_e_date) = ? "
				+ "and month(driv_e_date) = ? order by befo_dist desc limit 1";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int befo_dist = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			String strYear = year + "";
			String strMonth = month + "";
			pstmt.setString(1, car_reg_no);
			pstmt.setString(2, strYear);
			pstmt.setString(3, strMonth);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				befo_dist = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return befo_dist;
	}

	public void writeOneAutoCarlog(CarlogVO cVo) {
		String sql = "INSERT INTO driv(driv_s_date, driv_e_date, car_reg_no, mem_id"
				+ ", cour_no, driv_purpo, driv_dist" + ", card_divi, driv_divi";

		if (cVo.getOil_fee() != 0 && cVo.getTrans_fee() != 0) {
			sql += ", trans_fee, oil_fee) values(?,?,?,?,?,?,?,?,?,?,?)";
		} else if (cVo.getOil_fee() != 0) {
			sql += ", oil_fee) values(?,?,?,?,?,?,?,?,?,?)";
		} else if (cVo.getTrans_fee() != 0) {
			sql += ", trans_fee) values(?,?,?,?,?,?,?,?,?,?)";
		} else {
			sql += ") values(?,?,?,?,?,?,?,?,?)";
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getDriv_s_date());
			pstmt.setString(2, cVo.getDriv_e_date());
			pstmt.setString(3, cVo.getCar_reg_no());
			pstmt.setString(4, cVo.getMem_id());
			pstmt.setInt(5, cVo.getCour_no());
			pstmt.setString(6, cVo.getDriv_purpo());
			pstmt.setLong(7, cVo.getDriv_dist());
			pstmt.setString(8, cVo.getCard_divi());
			pstmt.setString(9, cVo.getDriv_divi());

			if (cVo.getOil_fee() != 0 && cVo.getTrans_fee() != 0) {
				pstmt.setLong(10, cVo.getTrans_fee());
				pstmt.setLong(11, cVo.getOil_fee());
			} else if (cVo.getOil_fee() != 0) {
				pstmt.setLong(10, cVo.getOil_fee());
			} else if (cVo.getTrans_fee() != 0) {
				pstmt.setLong(10, cVo.getTrans_fee());
			} else {

			}

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void autoUpdateCarDist(String car_reg_no, int dist) {
		String sql = "update driv d join car c " + "on d.car_reg_no = d.car_reg_no and "
				+ "c.car_reg_no = ? and d.driv_no = ? " + "set c.total_dist = c.total_dist + d.driv_dist";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car_reg_no);
			pstmt.setInt(2, dist);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}

/*
 * public List<CarlogVO> drivSearchAllByName(String mem_id) { String sql
 * ="select d.driv_no, d.car_reg_no, d.driv_s_date, d.driv_e_date, d.cour_no from driv d, mem m "
 * + "where d.mem_id=m.mem_id AND and m.mem_id= '" + mem_id + "'";
 * 
 * 
 * 
 * Connection conn = null; Statement stmt = null; ResultSet rs = null;
 * 
 * List<CarlogVO> list = new ArrayList<CarlogVO>();
 * 
 * try { conn = DBManager.getConnection(); stmt = conn.createStatement(); rs =
 * stmt.executeQuery(sql);
 * 
 * while (rs.next()) {
 * 
 * CarlogVO cVo = new CarlogVO();
 * 
 * cVo.setDriv_no(rs.getInt("driv_no"));
 * cVo.setCar_reg_no(rs.getString("car_reg_no"));
 * cVo.setDriv_s_date(rs.getString("driv_s_date"));
 * cVo.setDriv_e_date(rs.getString("driv_e_date"));
 * cVo.setCour_no(rs.getInt("cour_no")); list.add(cVo);
 * 
 * } } catch (Exception e) { e.printStackTrace(); } finally {
 * DBManager.close(conn, stmt, rs); } return list; }
 */

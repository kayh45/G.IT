package com.plani.cms.dao;
/**
 * 정비내역을 등록, 수정, 삭제, 조회 하기 할 수 있는 클래스
 * 
 * @author 윤한수
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarVO;
import com.plani.cms.dto.RepaVO;
import com.plani.cms.util.DBManager;

public class RepaDAO {
	private static RepaDAO instance = new RepaDAO();

	public static RepaDAO getInstance() {
		return instance;
	}
	
	

	/**
	 * 시작날짜, 종료날짜의 검색조건에 해당하는 모든 정비내역 데이터의 갯수를 세는 메소드
	 * @param repa_s_date	: 시작 날짜
	 * @param repa_e_date	: 종료 날짜
	 * @return		: 조회된 데이터의 갯수
	 */
	public int selectOnlyDateCount(String repa_s_date, String repa_e_date){
	    //1번 페이지 1~10
        //2번 페이지 11~20
     
        int count =0;
        String sql = "SELECT count(r.repa_no) as 'count'"
        	   	   + "     , r.cent_no"
        	   	   + "     , c.cent_name"
        	   	   + "     , r.car_reg_no"
        	   	   + "     , r.mechanic_name"
        	   	   + "     , r.repa_s_date"
        	   	   + "     , r.repa_e_date"
				   + "     , r.repa_cont"
				   + "     , r.repa_fee"
				   + "     , r.repa_divi "
				   + "  FROM repa r, cent c "
				   + " WHERE r.cent_no = c.cent_no AND r.repa_s_date >='" + repa_s_date + "'and r.repa_e_date<='" + repa_e_date + "' "
				   + " ORDER BY repa_s_date asc ;";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, stmt, rs);
		}
		 return count;	
	}
	
	/**
	 * 시작날짜, 종료날짜의 검색조건에 해당하는 정비내역 데이터를 출력
	 * @param repa_s_date	: 시작 날짜
	 * @param repa_e_date	: 종료 날짜
	 * @param page	: 현재 선택된 페이지의 번호
	 * @return		: 정비내역 리스트
	 */
	public List<RepaVO> selectOnlyDate(String repa_s_date,String repa_e_date,int page){
		//1번 페이지 1~10
        //2번 페이지 11~20
        int startNum =(page-1)*10;
        int endNum = page*10;
        System.out.println(startNum+"//"+endNum);
		String sql = "SELECT r.repa_no"
				+    "     , r.cent_no"
				+    "     , c.cent_name"
				+    "     , r.car_reg_no"
				+    "     , r.mechanic_name"
				+    "     , r.repa_s_date"
				+    "     , r.repa_e_date"
				+    "     , r.repa_cont"
				+    "     , r.repa_fee"
				+    "     , r.repa_divi"
				+    "  FROM repa r, cent c "
				+    " WHERE r.cent_no = c.cent_no AND r.repa_s_date >='"
				+ repa_s_date + "'and r.repa_e_date<='" + repa_e_date + "' "
				+    " ORDER BY repa_s_date asc  LIMIT " + startNum + ", 10;";

		List<RepaVO> list = new ArrayList<RepaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCent_name(rs.getString("cent_name"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	/**
	 * 시작날짜, 종료날짜, 정비소 번호의 검색조건에 해당하는 정비내역 데이터를 출력
	 * @param repa_s_date	: 시작 날짜
	 * @param repa_e_date	: 종료 날짜
	 * @param cent_no	: 정비소 번호
	 * @return		: 정비내역 리스트
	 */
	public List<RepaVO> selectDateCent(String repa_s_date,String repa_e_date,String cent_no){
		String sql = "SELECT r.repa_no"
				   + "     , r.cent_no"
				   + "     , c.cent_name"
				   + "     , r.car_reg_no"
				   + "     , r.mechanic_name"
				   + "     , r.repa_s_date"
				   + "     , r.repa_e_date"
				   + "     , r.repa_cont"
				   + "     , r.repa_fee"
				   + "     , r.repa_divi"
				   + "  FROM repa r, cent c "
				   + " WHERE r.cent_no = c.cent_no AND r.repa_s_date >='" + repa_s_date + "'and r.repa_e_date<='" + repa_e_date + "'and r.cent_no='" + cent_no + "' ";

		List<RepaVO> list = new ArrayList<RepaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCent_name(rs.getString("cent_name"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	/**
	 * 시작날짜, 종료날짜, 정비소 번호,차량번호 검색조건에  해당하는 정비내역 데이터를 출력
	 * @param repa_s_date	: 시작 날짜
	 * @param repa_e_date	: 종료 날짜
	 * @param cent_no	: 정비소 번호
	 * @param car_reg_no	: 차량번호 
	 * @return		: 정비내역 리스트
	 */
	public List<RepaVO> selectDateCentReg(String repa_s_date,String repa_e_date,String cent_no,String car_reg_no){
		String sql = "SELECT r.repa_no"
				   + "     , r.cent_no"
				   + "     , c.cent_name"
				   + "     , r.car_reg_no"
				   + "     , r.mechanic_name"
				   + "     , r.repa_s_date"
				   + "     , r.repa_e_date"
				   + "     , r.repa_cont"
				   + "     , r.repa_fee"
				   + "     , r.repa_divi "
			   	   + "  FROM repa r, cent c "
			   	   + " WHERE r.cent_no = c.cent_no and "
			   	   + "r.repa_s_date >='" + repa_s_date + "'and r.repa_e_date<='" + repa_e_date + "'and r.cent_no='" + cent_no + "'and r.car_reg_no='" + car_reg_no + "' ";

		List<RepaVO> list = new ArrayList<RepaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCent_name(rs.getString("cent_name"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}
	
	
	/**
	 * 시작날짜, 종료날짜, 차량번호 검색조건에  해당하는 정비내역 데이터를 출력
	 * @param repa_s_date	: 시작 날짜
	 * @param repa_e_date	: 종료 날짜
	 * @param car_reg_no	: 차량번호 
	 * @return		: 정비내역 리스트
	 */
	public List<RepaVO> selectDateReg(String repa_s_date,String repa_e_date,String car_reg_no){
		String sql = "SELECT r.repa_no"
				   + "     , r.cent_no"
				   + "     , c.cent_name"
				   + "     , r.car_reg_no"
				   + "     , r.mechanic_name"
				   + "     , r.repa_s_date"
				   + "     , r.repa_e_date"
				   + "     ,r.repa_cont"
				   + "     , r.repa_fee"
				   + "     , r.repa_divi "
				   + "  FROM repa r, cent c "
				   + " WHERE r.cent_no = c.cent_no "
				   + "   AND r.repa_s_date >='" + repa_s_date + "'AND r.repa_e_date<='" + repa_e_date + "'AND r.car_reg_no='" + car_reg_no + "' ";

		List<RepaVO> list = new ArrayList<RepaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				RepaVO rVo = new RepaVO();

				rVo.setRepa_no(rs.getInt("repa_no"));
				rVo.setCent_no(rs.getInt("cent_no"));
				rVo.setCar_reg_no(rs.getString("car_reg_no"));
				rVo.setMechanic_name(rs.getString("mechanic_name"));
				rVo.setRepa_s_date(rs.getString("repa_s_date"));
				rVo.setRepa_e_date(rs.getString("repa_e_date"));
				rVo.setRepa_cont(rs.getString("repa_cont"));
				rVo.setRepa_fee(rs.getInt("repa_fee"));
				rVo.setRepa_divi(rs.getString("repa_divi"));
				list.add(rVo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;	
	}

	
	/**
	 * 정비내역 데이터를 등록하는 메소드
	 * @param rVo : rVo 객체
	 */
	public void insertRepa(RepaVO rVo) {
		String sql = "INSERT INTO repa (cent_no, car_reg_no, mechanic_name, repa_s_date"
                   + "                , repa_e_date, repa_cont, repa_fee, repa_divi)"
				   + "VALUES(?,?,?,?,?,?,?,?)";
		


		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rVo.getCent_no());
			pstmt.setString(2, rVo.getCar_reg_no());
			pstmt.setString(3, rVo.getMechanic_name());
			pstmt.setString(4, rVo.getRepa_s_date());
			pstmt.setString(5, rVo.getRepa_e_date());
			pstmt.setString(6, rVo.getRepa_cont());
			pstmt.setInt(7, rVo.getRepa_fee());
			pstmt.setString(8, rVo.getRepa_divi());
		

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 정비내역를 수정할 수 있는 메소드 
	 * @param rVo : Repa 객체
	 */
	
	public void updateRepa(RepaVO rVo) {
		String sql = "UPDATE repa "
	               + "   SET cent_no=?"
				   + "     , car_reg_no=?"
				+ "        , mechanic_name=?"
				+ "        , repa_s_date=?"
				+ "        , repa_e_date=?"
				+ "        , repa_cont=?"
				+ "        , repa_fee=?"
				+ "        , repa_divi=?"
				+ "    WHERE repa_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rVo.getCent_no());
			pstmt.setString(2, rVo.getCar_reg_no());
			pstmt.setString(3, rVo.getMechanic_name());
			pstmt.setString(4, rVo.getRepa_s_date());
			pstmt.setString(5, rVo.getRepa_e_date());
			pstmt.setString(6, rVo.getRepa_cont());
			pstmt.setInt(7, rVo.getRepa_fee());
			pstmt.setString(8, rVo.getRepa_divi());
			pstmt.setInt(9, rVo.getRepa_no());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/**
	 * 정비내역을 삭제할 수 있는 메소드
	 * @param repa_no
	 */
	public void DeleteRepa(int repa_no) {

		String sql = "DELETE FROM repa "
				+     "WHERE repa_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, repa_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	
}
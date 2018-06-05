package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CarlogVO;
import com.plani.cms.dto.PlaceCourVO;
import com.plani.cms.dto.PlaceVO;
import com.plani.cms.util.DBManager;

public class CarlogDAO {

	private static CarlogDAO instance = new CarlogDAO();

	public static CarlogDAO getInstance() {
		return instance;
	}
	
/*	private int driv_no;
	private String mem_id;
	private String car_reg_no;
	private int cour_no;
	private String driv_s_date;
	private String driv_e_date;
	private String driv_purpo;
	private String card_divi;
	private int oil_fee;
	private int trans_fee;
	private String etc_text;
	private int etc_fee;
	private int befo_dist;*/
	
	public void updateCarlog(CarlogVO cVo) {
		String sql = "update cour set cour_no=?, driv_purpo=?, card_divi=?, oil_fee=?, trans_fee=?, etc_text=?, etc_fee=?, "
				+ "befo_dist=? where driv_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setString(2, cVo.getDriv_purpo());
			pstmt.setString(3, cVo.getCard_divi());
			pstmt.setInt(4, cVo.getOil_fee());
			pstmt.setInt(5, cVo.getTrans_fee());
			pstmt.setString(6, cVo.getEtc_text());
			pstmt.setInt(7, cVo.getEtc_fee());
			pstmt.setInt(8, cVo.getBefo_dist());
			pstmt.setInt(9, cVo.getDriv_no());
	
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void DeleteCourse(int course_no) {

		String sql = "DELETE FROM cour WHERE cour_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, course_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	public List<PlaceCourVO> courSplaceSearchByNameLike(String name) {
		String sql ="select c.cour_no, c.s_place as 's_place', (select place_name from place where place_no = s_place) as 's_place_name', "
				+ "(select place_addr from place where place_no=s_place) as 's_place_addr', c.e_place, "
				+ "(select place_name from place where place_no = e_place) as 'e_place_name',"
				+ "(select place_addr from place where place_no=e_place) as 'e_place_addr', c.cour_purpo,c.distance from cour c, place p "
				+ "where p.place_no = c.s_place AND p.place_name like '%" + name + "%'";
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));

			
				

				list.add(pcVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public List<PlaceCourVO> courEplaceSearchByNameLike(String name) {
		String sql ="select c.cour_no, c.s_place as 's_place', (select place_name from place where place_no = s_place) as 's_place_name', "
				+ "(select place_addr from place where place_no=s_place) as 's_place_addr', c.e_place, "
				+ "(select place_name from place where place_no = e_place) as 'e_place_name',"
				+ "(select place_addr from place where place_no=e_place) as 'e_place_addr', c.cour_purpo,c.distance from cour c, place p "
				+ "where p.place_no = c.e_place AND p.place_name like '%" + name + "%'";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));

				
				
				
				list.add(pcVo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<PlaceCourVO> courAllplaceSearchByNameLike(String name) {
		String sql ="select c.cour_no, c.s_place as 's_place', (select place_name from place where place_no = s_place) as 's_place_name', "
				+ "(select place_addr from place where place_no=s_place) as 's_place_addr', c.e_place, "
				+ "(select place_name from place where place_no = e_place) as 'e_place_name',"
				+ "(select place_addr from place where place_no=e_place) as 'e_place_addr', c.cour_purpo, c.distance from cour c, place p "
				+ "where p.place_no = c.e_place";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PlaceCourVO> list = new ArrayList<PlaceCourVO>();
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				PlaceCourVO pcVo = new PlaceCourVO();
				
				pcVo.setCour_no(rs.getInt("cour_no"));
				pcVo.setS_place_no(rs.getInt("s_place"));
				pcVo.setS_place_name(rs.getString("s_place_name"));
				pcVo.setS_place_addr(rs.getString("s_place_addr"));
				pcVo.setE_place_no(rs.getInt("e_place"));
				pcVo.setE_place_name(rs.getString("e_place_name"));
				pcVo.setE_place_addr(rs.getString("e_place_addr"));
				pcVo.setCour_purpo(rs.getString("cour_purpo"));
				pcVo.setDistance(rs.getInt("distance"));

				
				
				
				list.add(pcVo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public List<PlaceVO> placeSearchByNameLike(String name) {
		/**
		 * 사원 이름에 대한 부분일치 검색
		 * @MemberSearchAction 에서 사용
		 ***/
		String sql = "select * from place where place_name like '%" + name + "%'";
			

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> list = new ArrayList<PlaceVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PlaceVO pVo = new PlaceVO();

				pVo.setPlace_no(rs.getInt("place_no"));
				pVo.setPlace_name(rs.getString("place_name"));
				pVo.setPlace_p_no(rs.getInt("place_p_no"));
				pVo.setPlace_addr(rs.getString("place_addr"));
				pVo.setPlace_addr_dtl(rs.getString("place_addr_dtl"));
				
				

				list.add(pVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}





}


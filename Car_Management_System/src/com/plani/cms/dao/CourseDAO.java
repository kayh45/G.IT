package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CourseVO;
import com.plani.cms.dto.PlaceVO;
import com.plani.cms.util.DBManager;

public class CourseDAO {
	private static CourseDAO instance = new CourseDAO();

	public static CourseDAO getInstance() {
		return instance;
	}
	


	public void insertCourse(CourseVO cVo) {
		String sql = "insert into cour(s_place, e_place,"
				+ "distance,cour_purpo) values(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, cVo.getS_place());
			pstmt.setInt(2, cVo.getE_place());
			pstmt.setInt(3, cVo.getDistance());
			pstmt.setString(4, cVo.getCour_purpo());
			

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateCourse(CourseVO cVo) {
		String sql = "update cour set s_place=?,"
				+ "e_place=?,distance=?,cour_purpo=? where cour_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getS_place());
			pstmt.setInt(2, cVo.getE_place());
			pstmt.setInt(3, cVo.getDistance());
			pstmt.setString(4, cVo.getCour_purpo());
			pstmt.setInt(5, cVo.getCour_no());
	
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


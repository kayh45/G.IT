package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plani.cms.dto.CourseVO;
import com.plani.cms.util.DBManager;

public class CourseDAO {
	private static CourseDAO instance = new CourseDAO();

	public static CourseDAO getInstance() {
		return instance;
	}
	
	public List<CourseVO> selectAllCus() {

		String sql = "select * from course order by cour_no desc";

		List<CourseVO> list = new ArrayList<CourseVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CourseVO cVo = new CourseVO();

				cVo.setCour_no(rs.getInt("cour_no"));
				cVo.setS_place(rs.getInt("s_place"));
				cVo.setE_place(rs.getInt("e_place"));
				cVo.setDistance(rs.getInt("distance"));
				cVo.setCour_purpo(rs.getString("cour_purpo"));

				list.add(cVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertCourse(CourseVO cVo) {
		String sql = "insert into course(s_place,e_place,"
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
		String sql = "update course set course_no=?, s_place=?,"
				+ "e_place=?,distance=?,cour_purpo=? where course_no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cVo.getCour_no());
			pstmt.setInt(2, cVo.getS_place());
			pstmt.setInt(3, cVo.getE_place());
			pstmt.setInt(4, cVo.getDistance());
			pstmt.setString(5, cVo.getCour_purpo());
	
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void DeleteCourse(int course_no) {

		String sql = "DELETE FROM course WHERE course_no = ?";

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

}
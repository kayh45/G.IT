package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.plani.cms.dto.DeptVO;
import com.plani.cms.util.DBManager;

/**
 * 부서의 등록, 수정, 삭제, 조회 등의 기능을 지원하는 
 * DAO 클래스
 * 
 * @author 강현
 *
 */
public class DeptDAO {

	private static DeptDAO instance = new DeptDAO();

	public static DeptDAO getInstance() {
		return instance;
	} // Singleton 패턴

	/**
	 * 부서 정보를 등록
	 * 
	 * @param dVo : 등록하고자 하는 부서 정보가 담긴 객체
	 */
	public void deptInsert(DeptVO dVo) {

		String sql = "insert into dept(dept_name) values(?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dVo.getDept_name());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 등록되어있는 부서 정보를 수정
	 * 
	 * @param dVo : 조회에 사용되는 부서 번호와 바꾸고자하는 부서 명을 가지고 있는 부서 객체
	 */
	public void deptUpdate(DeptVO dVo) {
		
		String sql = "UPDATE dept "
				+ "      SET dept_name = ? "
				+ "    WHERE dept_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dVo.getDept_name());
			pstmt.setInt(2, dVo.getDept_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}
	
	/**
	 * 등록되어있는 부서 정보 하나를 삭제
	 * 
	 * @param dept_no : 삭제하고자하는 부서의 부서번호
	 */
	public void deptDelete(int dept_no) {
		
		String sql = "DELETE FROM dept "
				+ "    WHERE dept_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dept_no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}
	}

	/**
	 * 부서명에 대한 완전일치 검색
	 * 부서 등록 및 수정 시 중복 체크용으로 사용
	 * 
	 * @param name : 검색하고자 하는 부서 이름
	 * 
	 * @return 부서명이 완전 일치하는 부서 객체
	 */
	public DeptVO deptSearchByName(String name) {
		
		String sql = "SELECT * "
				+ "     FROM dept "
				+ "    WHERE dept_name = '" + name + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DeptVO dVo = new DeptVO();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dVo.setDept_no(rs.getInt("dept_no"));
				dVo.setDept_name(rs.getString("dept_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dVo;
	}
	
	/**
	 * 부서명에 대한 부분일치 검색
	 * 부서 검색 등에 사용
	 * 
	 * @param name : 검색하고자 하는 부서 이름
	 * 
	 * @return 검색 결과로 나온 부서의 목록을 List 타입으로 리턴
	 */
	public List<DeptVO> deptSearchByNameLike(String name) {
		
		String sql = "SELECT *    "
				+ "     FROM dept "
				+ "    WHERE dept_name LIKE '%" + name + "%'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<DeptVO> list = new ArrayList<DeptVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				DeptVO tVo = new DeptVO();

				tVo.setDept_no(rs.getInt("dept_no"));
				tVo.setDept_name(rs.getString("dept_name"));

				list.add(tVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}

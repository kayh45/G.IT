package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.plani.cms.dto.DeptVO;
import com.plani.cms.util.DBManager;

public class DeptDAO {

	private static DeptDAO instance = new DeptDAO();

	public static DeptDAO getInstance() {
		return instance;
	} // Singleton 패턴

	public void deptInsert(DeptVO dVo) {
		/**
		 * 부서 등록
		 * 부서명만 받아와서 등록시킴
		 * @DeptWriteAction 에서 사용
		 **/
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
	
	public void deptUpdate(DeptVO dVo) {
		/**
		 * 부서 수정
		 * 부서 번호와 부서명을 받아와서 수정
		 * @DeptModifyAction 에서 사용
		 **/
		String sql = "UPDATE dept SET dept_name = ? where dept_no = ?";

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
	
	public void deptDelete(int dept_no) {
		/**
		 * 부서 삭제
		 * 부서 번호를 받아와서 삭제
		 * @DeptModifyAction 에서 사용
		 **/
		String sql = "DELETE FROM dept WHERE dept_no = ?";

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

	public DeptVO deptSearchByName(String name) {
		/**
		 * 부서명에 대한 완전일치 검색
		 * @DeptWriteCheckFormAction 에서 사용
		 **/
		String sql = "select * from dept where dept_name = '" + name + "'";

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
	
	public List<DeptVO> deptSearchByNameLike(String name) {
		/**
		 * 부서명에 대한 부분일치 검색
		 * @DeptWriteCheckFormAction 에서 사용
		 **/
		String sql = "select * from dept where dept_name like '%" + name + "%'";

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

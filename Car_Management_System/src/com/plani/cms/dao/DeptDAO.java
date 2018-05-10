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

	public List<DeptVO> DeptSearchByName(String name) {
		String sql = "select * from dept where dept_name = '" + name + "'";

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

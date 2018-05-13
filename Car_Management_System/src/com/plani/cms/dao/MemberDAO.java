package com.plani.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.plani.cms.dto.DeptVO;
import com.plani.cms.dto.MemberVO;
import com.plani.cms.util.DBManager;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	} // Singleton 패턴

	
	public void memberInsert(MemberVO mVo) {
		/**
		 * 부서 등록
		 * 부서명만 받아와서 등록시킴
		 * @DeptWriteAction 에서 사용
		 **/
		String sql = "insert into mem values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMem_id());
			pstmt.setString(2, mVo.getMem_pw());
			pstmt.setString(3, mVo.getMem_name());
			pstmt.setInt(4, mVo.getMem_jumin());
			pstmt.setString(5, mVo.getMem_p_no());
			pstmt.setString(6, mVo.getMem_addr());
			pstmt.setString(7, mVo.getMem_hp());
			pstmt.setString(8, mVo.getMem_posi());
			pstmt.setInt(9, mVo.getMem_auth());
			pstmt.setInt(10, mVo.getDept_no());

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
		 * 부서 수정
		 * 부서 번호와 부서명을 받아와서 수정
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
	
	
}
